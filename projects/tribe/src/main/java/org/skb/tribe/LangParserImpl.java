/* Copyright (c) 2005-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.tribe;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.PathKeys;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.config.ConfigurationProperties;
import org.skb.util.classic.io.files.FileManager;
import org.skb.util.classic.io.files.FileTemplateList;
import org.skb.util.classic.lang.LangParserAPI;
import org.skb.util.classic.misc.Json2Oat;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSDefault;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.misc.TSReportManager;
import org.skb.util.composite.stringtemplate.TSSTGroupManager;
import org.skb.util.composite.util.TSArrayListString;
import org.skb.util.composite.util.TSLinkedHashTree;
import org.skb.util.composite.util.TSPropertyMap;

/**
 * Tribe's implementation of a language parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class LangParserImpl implements LangParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(LangParserImpl.class);

	/** Target StringTemplateGroup */
	private STGroupTarget target;

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** the Parser object associated with this TribeParser */
	private TribeParserAPI langParser=null;

	/** supported source language of the parser */
	private String supportedSourceLang=null; 

	/** supported target languages of the parser */
	private TSArrayListString supportedTargetLang=null;

	/** StringTemplateGroup manager for the parser */
	protected TSSTGroupManager stgl=null;

	//TODO comments
	Configuration config=null;
	ConfigurationProperties cProp=null;

	/**
	 * Class constructor, initialises local fields
	 */
	public LangParserImpl(){
		logger.trace("constructor -- in");

		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_TRIBE_LP);
		this.typeEnum.add(TEnum.TS_TRIBE_LP);

		logger.trace("constructor -- out");
	}


	public void setLangParser(TribeParserAPI parser){
		this.langParser=parser;

		this.supportedSourceLang=this.langParser.getSourceLanguage();

		this.config=Configuration.getConfiguration(this.langParser.getConfigurationClassName());

		String url=this.langParser.getConfigurationFile();
		try{
			Json2Oat j2o=new Json2Oat();
			TSBaseAPI c=j2o.read(url);
			if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH)){
				this.config.config.put(PathKeys.pathConfigurationParserTribe, ((TSLinkedHashTree)c).get(PathKeys.pathConfigurationParserTribe));
				this.config.config.put(PathKeys.patConfigurationParserLang, ((TSLinkedHashTree)c).get(PathKeys.patConfigurationParserLang));
			}
		}
		catch (Exception e){
			System.err.println("LangParserImpl: "+e);
		}

		this.supportedTargetLang=new TSArrayListString();
		Set<String> lang=((TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTargets)).keySet();
		Iterator<String> it=lang.iterator();
		while(it.hasNext())
			this.supportedTargetLang.add(it.next().toString());

		this.config.getLangRuleMap().loadRules(this.langParser.getLangRuleClassName(), this.langParser.getLangRuleKeyword(), (TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangRules), (TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTokens));
	}


	@Override
	public void parse(InputStream is) {
		logger.trace("parse -- in");

		TSReportManager repMgr=this.config.getReportManager();

		Boolean quietMode=false;
		try {
			quietMode=((TSBoolean)this.cProp.getValue(FieldKeys.fieldCliOptionQuietMode)).tsvalue;
		}
		catch(Exception e){
			logger.trace("quiet mode not set in tribe, default false");
		}

		try {
			logger.trace("converting inputStream to ANTLR");
			ANTLRInputStream input=new ANTLRInputStream(is);

			logger.trace("creating lexer and token stream");
			Lexer lexer=this.langParser.pass1GetLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			logger.trace("creating parser and get return from parsing");
			CommonTree treeForAst=this.langParser.pass1ParseEBNF(tokens);

			logger.trace("check for errors");
			int ret=repMgr.noOfErrors();
			String msg=ret+" error";
			if(ret==0||ret>1)
				msg+="s";
			if(ret>0) {
				msg+=", exiting at pass 1";
				if(!quietMode)
					repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 1 (Syntax Check)";
			if(!quietMode)
				repMgr.reportMessageNoFile(msg);

			logger.trace("still here, reset errors and continue");
			repMgr.resetNoOfErrors();
			logger.trace("creating AST parser and tree node stream");
			CommonTreeNodeStream nodesForAst=new CommonTreeNodeStream(treeForAst);
			nodesForAst.setTokenStream(tokens);

			logger.trace("calling ast.specification");
			CommonTree treeForGen=this.langParser.pass2Ast(nodesForAst);
			ret=repMgr.noOfErrors();

			msg=ret+" error";
			if(ret==0||ret>1)
				msg+="s";
			if(ret>0) {
				msg+=", exiting at pass 2";
				if(!quietMode)
					repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 2 (Semantic Check)";
			if(!quietMode)
				repMgr.reportMessageNoFile(msg);

			TSBaseAPI ata=this.cProp.getValue(FieldKeys.fieldCliOptionGC);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true){
				//repMgr.resetNoOfErrors();
				CommonTreeNodeStream nodesForGen=new CommonTreeNodeStream(treeForGen);
				nodesForGen.setTokenStream(tokens);
				this.langParser.pass3CodeGen(nodesForGen, this.stgl.getSTG());

				msg="success  in pass 3 (Code Generation)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);

				FileTemplateList ftl=this.langParser.pass4Files();
				ftl.init(this.cProp.getValue(FieldKeys.fieldCliOptionTgtDir));

				FileManager fm=new FileManager(this.target.getStdHeaderST(), this.target.getFileStartST(), this.target.getFileEndST());
				fm.init(this.cProp.getValue(FieldKeys.fieldCliOptionSrcLanguage),
						this.cProp.getValue(FieldKeys.fieldCliOptionSrcFile),
						this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage),
						this.cProp.getValue(FieldKeys.fieldCliOptionTgtFileExt),
						this.cProp.getValue(FieldKeys.fieldCliOptionGC));
				fm.writeList(ftl);

				msg="success  in pass 4 (Write Files)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);
			}
			this.langParser.finish(quietMode);
		}
		catch(IOException io){
			repMgr.reportError("catched exception while parsing", "IOException: " + io.toString());
		}
		catch(Exception e){
			repMgr.reportError("catched exception while parsing", "Exception: " + e.toString());
		}

		logger.trace("parse -- out");
	}


	private TSDefault loadStg() {
		this.stgl=new TSSTGroupManager();

		TSBaseAPI obt=this.cProp.getValue(FieldKeys.fieldApplicationTgtStgAngleBr);
		Boolean _t=false;
		try {
			if(obt.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN))
				_t=((TSBoolean)obt).tsvalue;
		} catch (Exception e) {}

		if(Boolean.TRUE.equals(_t))
			this.stgl.useLexerAngelB();
		else
			this.stgl.useLexerDefault();

		this.stgl.setApplicationName(this.cProp.getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());
		this.stgl.setSTGFile(this.cProp.getValue(FieldKeys.fieldCliOptionTgtStg));

		if(this.target!=null){
			TSLinkedHashTree chMan=this.target.getMandatory();
			TSLinkedHashTree chOpt=this.target.getOptional();
			this.stgl.setChunks(chMan, chOpt);
		}

		TSDefault ret=this.stgl.loadSTG("code generation", this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage));
		return ret;
	}


	@Override
	public void printStg() {
		if(this.stgl!=null)
			System.out.println(this.stgl.getSTG().toString());
	}


	@Override
	public TSDefault setOptions(){
		logger.trace("setOptions -- in");

		//has to be a std property map to avoid loading fixed rows of ConfigurationProprties
		TSPropertyMap opm=new TSPropertyMap();
		opm.addRows(this.langParser.getOptionClassName(), this.langParser.getOptionKeyword());

		this.cProp=this.config.getProperties();

		if(config==null){
			//TODO
			System.err.println("tribe: property configuration not found");
		}
		else{
			opm.loadFromJason(this.config.config.get(PathKeys.patConfigurationParserLangConfiguration));
			cProp.loadFromJason(this.config.config.get(PathKeys.pathConfigurationParserTribe));
			if(this.config.config.containsKey(PathKeys.pathConfigurationParserLangTargets)){
				String lang=new String();
				if(!cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
					lang=cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).toString();
					opm.loadFromJason(((TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang+"/"+FieldKeys.fieldLangTargetConfigCli)));
					cProp.loadFromJason(((TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang)));
				}
			}
		}
		cProp.addProperties(opm);

		//load target
		if(!this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
			logger.trace("target set as <"+this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage)+">");
			this.target=new STGroupTarget(this.cProp.getValue(FieldKeys.fieldApplicationName), this.cProp.getValue(FieldKeys.fieldApplicationGenericSTG), this.config);
		}

		logger.trace("setOptions -- out");
		return this.loadStg();
	}


	@Override
	public String getSupportedSourceLang() {
		return this.supportedSourceLang;
	}


	@Override
	public TSArrayListString getSupportedTargetLang() {
		return this.supportedTargetLang;
	}


	@Override
	public Class<?> getConfigurationClassName(){
		return this.langParser.getConfigurationClassName();
	}
}
