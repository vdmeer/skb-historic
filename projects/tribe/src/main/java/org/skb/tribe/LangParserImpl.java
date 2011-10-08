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
import org.skb.base.FieldKeys;
import org.skb.base.PathKeys;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSDefault;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.antlr.TSSTGroupManager;
import org.skb.base.composite.java.TSBoolean;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.composite.util.TSArrayListString;
import org.skb.base.composite.util.TSLinkedHashTree;
import org.skb.base.composite.util.TSPropertyMap;
import org.skb.base.config.Configuration;
import org.skb.base.config.ConfigurationProperties;
import org.skb.base.io.files.FileManager;
import org.skb.base.io.files.FileTemplateList;
import org.skb.base.json.Json2TS;
import org.skb.base.lang.LangParserAPI;

/**
 * Tribe's implementation of a language parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class LangParserImpl implements LangParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(LangParserImpl.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE, TSRepository.TString.TS_ATOMIC, TSRepository.TString.TS_TRIBE_LP));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE, TEnum.TS_ATOMIC, TEnum.TS_TRIBE_LP));

	/** the Parser object associated with this TribeParser */
	private TribeParserAPI langParser=null;

	/** supported source language of the parser */
	private String supportedSourceLang=null; 

	/** supported target languages of the parser */
	private TSArrayListString supportedTargetLang=null;

	/** StringTemplateGroup manager for the parser */
	protected TSSTGroupManager targetStgm=null;

	/** StringTemplateGroup manager for the standard tribe stg */
	protected TSSTGroupManager tribeStgm=null;

	/** Tribe configuration */
	Configuration config=null;

	/** Tribe properties */
	ConfigurationProperties prop=null;

	/**
	 * Class constructor, initialises local fields
	 */
	public LangParserImpl(){}

	public void setLangParser(TribeParserAPI parser){
		this.langParser=parser;

		this.supportedSourceLang=this.langParser.getSourceLanguage();

		this.config=this.langParser.getConfiguration();

		String url=this.langParser.getConfigurationFile();
		try{
			Json2TS j2o=new Json2TS();
			TSBaseAPI c=j2o.read(url);
			if(c.tsIsType(TEnum.TS_COMPOSITE_TREE_LH)){
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
				repMgr.error(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 1 (Syntax Check)";
			repMgr.messageNoFile(msg);

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
				repMgr.error(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 2 (Semantic Check)";
			repMgr.messageNoFile(msg);

			TSBaseAPI ata=this.prop.getValue(FieldKeys.fieldCliOptionGC);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true){
				//repMgr.resetNoOfErrors();
				CommonTreeNodeStream nodesForGen=new CommonTreeNodeStream(treeForGen);
				nodesForGen.setTokenStream(tokens);
				this.langParser.pass3CodeGen(nodesForGen, this.targetStgm.getSTG());

				msg="success  in pass 3 (Code Generation)";
				repMgr.messageNoFile(msg);

				FileTemplateList ftl=this.langParser.pass4Files();
				ftl.init(this.prop.getValue(FieldKeys.fieldCliOptionTgtDir));

				FileManager fm=new FileManager(this.tribeStgm.getSTG().getInstanceOf("std"), this.tribeStgm.getSTG().getInstanceOf("fileStart"), this.tribeStgm.getSTG().getInstanceOf("fileEnd"), this.tribeStgm.getSTG().getInstanceOf("fImport"));
				fm.init(this.prop.getValue(FieldKeys.fieldCliOptionSrcLanguage),
						this.prop.getValue(FieldKeys.fieldCliOptionSrcFile),
						this.prop.getValue(FieldKeys.fieldCliOptionTgtLanguage),
						this.prop.getValue(FieldKeys.fieldCliOptionTgtFileExt),
						this.prop.getValue(FieldKeys.fieldCliOptionGC));
				fm.writeList(ftl);

				msg="success  in pass 4 (Write Files)";
				repMgr.messageNoFile(msg);
			}
			this.langParser.finish();
		}
		catch(IOException io){
			repMgr.error("catched exception while parsing", "IOException: " + io.toString());
		}
		catch(Exception e){
			repMgr.error("catched exception while parsing", "Exception: " + e.toString());
		}

		logger.trace("parse -- out");
	}

	@Override
	public String getTargetStgAsString() {
		if(this.targetStgm!=null&&this.targetStgm.getSTG()!=null)
			return this.targetStgm.getSTG().toString();
		return "";
	}

	@Override
	public TSDefault loadParserOptions(){
		logger.trace("setOptions -- in");

		//has to be a std property map to avoid loading fixed rows of ConfigurationProprties
		TSPropertyMap opm=new TSPropertyMap();
		opm.addRows(this.langParser.getOptionClassName(), this.langParser.getOptionKeyword());

		this.prop=this.config.getProperties();

		if(config==null){
			//TODO
			System.err.println("tribe: property configuration not found");
		}
		else{
			opm.loadFromJason(this.config.config.get(PathKeys.patConfigurationParserLangConfiguration));
			prop.loadFromJason(this.config.config.get(PathKeys.pathConfigurationParserTribe));
			if(this.config.config.containsKey(PathKeys.pathConfigurationParserLangTargets)){
				String lang=new String();
				if(!prop.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
					lang=prop.getValue(FieldKeys.fieldCliOptionTgtLanguage).toString();
					opm.loadFromJason(((TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang+"/"+FieldKeys.fieldLangTargetConfigCli)));
					prop.loadFromJason(((TSLinkedHashTree)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang)));
				}
			}
		}
		prop.addProperties(opm);

		TSSTGroupManager prm=TribeHelpers.loadSTGM(this.config, PathKeys.pathConfigurationParserRulesStgChunks, this.prop.getValue(FieldKeys.fieldApplicationGenericSTG).toString(), this.langParser.getParserRuleSTGFileName());
		prm.useLexerAngelB();
		TSDefault prmRet=prm.loadSTG("loading parser rule templates", "");
		if(prmRet.tsIsType(TEnum.TS_ERROR))
			return prmRet;
		this.config.addParserRuleManager(prm);

		logger.trace("setOptions -- out");
		return this.loadTargetLanguage();
	}

	@Override
	public TSDefault loadTargetLanguage(){
		TSDefault ret=new TSDefault();

		if(this.prop.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
			ret.tsSetMessage("load target: no target language set");
			return ret;
		}

		logger.trace("target set as <"+this.prop.getValue(FieldKeys.fieldCliOptionTgtLanguage)+">");
		this.tribeStgm=TribeHelpers.loadSTGM(this.config, PathKeys.pathConfigurationParserTribeStgChunks, this.prop.getValue(FieldKeys.fieldApplicationName).toString().toLowerCase(), this.prop.getValue(FieldKeys.fieldApplicationGenericSTG).toString());
		ret=this.tribeStgm.loadSTG("string template for generic header", "");
		if(ret.tsIsType(TEnum.TS_ERROR))
			return ret;

		this.targetStgm=TribeHelpers.loadSTGM(this.config, PathKeys.pathConfigurationParserLangStgChunks, this.prop.getValue(FieldKeys.fieldApplicationName).toString().toLowerCase(), this.prop.getValue(FieldKeys.fieldCliOptionTgtStg).toString());

		TSBaseAPI obt=this.prop.getValue(FieldKeys.fieldApplicationTgtStgAngleBr);
		Boolean _t=false;
		try {
			if(obt.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN))
				_t=((TSBoolean)obt).tsvalue;
		} catch (Exception e) {}

		if(Boolean.TRUE.equals(_t))
			this.targetStgm.useLexerAngelB();
		else
			this.targetStgm.useLexerDefault();

		ret=this.targetStgm.loadSTG("code generation", "");
		return ret;
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
	public Configuration getConfiguration(){
		return this.langParser.getConfiguration();
	}

}
