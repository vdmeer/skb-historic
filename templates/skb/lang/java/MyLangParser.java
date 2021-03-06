/* Copyright (c) 2000-2011 Sven van der Meer (sven@vandermeer.de)
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
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

package org.skb.lang.##mylang##;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageParser;
import org.skb.tribe.LanguageProperties;
import org.skb.tribe.TargetSTG;
import org.skb.tribe.TribeProperties;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatBoolean;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.composite.util.OatMapLH;
import org.skb.types.composite.util.OatPropertyMap;
import org.skb.util.ReportManager;
import org.skb.util.stringtemplate.FileManager;
import org.skb.util.stringtemplate.FileTemplateList;
import org.skb.util.stringtemplate.STGManager;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.log4j.Logger;
import org.skb.lang.##mylang##.grammars.##mylang##Ast;
import org.skb.lang.##mylang##.grammars.##mylang##EbnfLexer;
import org.skb.lang.##mylang##.grammars.##mylang##EbnfParser;
import org.skb.lang.##mylang##.grammars.##mylang##Gen;

/**
 * The core of the ##MyLang## parser implementing the whole parsing process.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class ##MyLang##Parser extends LanguageParser{
	private TargetSTG target;

	static Logger logger = Logger.getLogger("org.skb.languages.##mylang##");

	public OatPropertyMap getMap(){
		return LanguageProperties.getInstance().getMap();
	}

	public ##MyLang##Parser(){
		logger.trace("constructor -- in");
		this.xs="##mylang##";
		this.xt=new OatArrayListString();

		Set<String> lang=LanguageConfiguration.getInstance().getLanguageTargets().keySet();
		Iterator<String> it=lang.iterator();
		while(it.hasNext())
			this.xt.add(it.next().toString());

		logger.trace("constructor -- out");
	}

	public void setOptions(){
		logger.trace("setOptions -- in");
		LanguageProperties lp=LanguageProperties.getInstance();
		lp.setClassName(##MyLang##PropertiesConstants.class.getName());
		lp.setKey("key");
		lp.setOptions();
		super.setOptions();
		logger.trace("setOptions -- out");
	}

	public void parse(InputStream is){
		logger.trace("parse -- in");

		ReportManager repMgr=ReportManager.getInstance();

		Boolean quietMode=false;
		try {
			quietMode=((OatBoolean)prop.getValue(TribeProperties.tpmKeyQuietMode)).getValue();
		}
		catch(Exception e){
			logger.trace("quiet mode not set in tribe, default false");
		}

		try {
			logger.trace("converting inputStream to ANTLR");
			ANTLRInputStream input = new ANTLRInputStream(is);

			logger.trace("creating lexer and token stream");
			##mylang##EbnfLexer lexer=new ##mylang##EbnfLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			logger.trace("creating parser");
			##mylang##EbnfParser parser = new ##mylang##EbnfParser(tokens);
			logger.trace("calling parser.specification");
			##mylang##EbnfParser.##mylang##Specification_return fromEbnf=parser.##mylang##Specification();

			logger.trace("check for errors");
			int ret=repMgr.noOfErrors();
			String msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
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
			CommonTree treeForAst=(CommonTree)fromEbnf.getTree();
			CommonTreeNodeStream nodesForAst=new CommonTreeNodeStream(treeForAst);
			nodesForAst.setTokenStream(tokens);
			##mylang##Ast ast=new ##mylang##Ast(nodesForAst);

			logger.trace("calling ast.specification");
			##mylang##Ast.##mylang##Specification_return fromAst = ast.##mylang##Specification();
			ret=repMgr.noOfErrors();

			msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
				msg+=", exiting at pass 2";
				if(!quietMode)
					repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 2 (Semantic Check)";
			if(!quietMode)
				repMgr.reportMessageNoFile(msg);

			ata=this.prop.getValue(TribeProperties.tpmKeyGC);
			if(ata!=null&&ata.isType(TypeRepository.OAT_ATOMIC_BOOLEAN)&&((OatBoolean)ata).getValue()==true){
				//repMgr.resetNoOfErrors();
				CommonTree treeForGen=(CommonTree)fromAst.getTree();
				CommonTreeNodeStream nodesForGen = new CommonTreeNodeStream(treeForGen);
				nodesForGen.setTokenStream(tokens);
				##mylang##Gen gen = new ##mylang##Gen(nodesForGen);

				gen.setTemplateLib(this.stgl.getSTG());
				gen.##mylang##Specification();

				msg="success  in pass 3 (Code Generation)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);

				##MyLang##Pass4_Files cfm=new ##MyLang##Pass4_Files();

				FileTemplateList ftl=cfm.getFileTemplateList();
				ftl.init(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtDir).getValOatAtomicString());

				FileManager fm=new FileManager(this.target.getStdHeaderST(), this.target.getFileStartST(), this.target.getFileEndST());
				fm.init(TribeProperties.getInstance().getValue(TribeProperties.tpmKeySrcLanguage).getValOatAtomicString(),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeySrcFile).getValOatAtomicString(),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtLanguage).getValOatAtomicString(),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtFileExt).getValOatAtomicString(),
						TribeProperties.getInstance().getValue(TribeProperties.tpmKeyGC).getValOatAtomicBoolean());
				fm.writeList(ftl);

				msg="success  in pass 4 (Write Files)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);
			}
		}
		catch(IOException io){
			repMgr.reportError("catched exception while parsing", "IOException: " + io.toString());
		}
		catch(Exception e){
			repMgr.reportError("catched exception while parsing", "Exception: " + e.toString());
		}

		logger.trace("parse -- out");
	}

	public void loadTarget(){
		if(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtLanguage)!=null){
			logger.trace("target set as ##MyLang##TargetSTG");
			this.target=new TargetSTG();
		}
	}

	public void loadStg(){
		this.stgl=new STGManager();

		OatBaseAtomic obt=TribeProperties.getInstance().getValue(TribeProperties.tpmKeyTgtStgAngleBr);
		Boolean _t=false;
		try {
			if(obt.getTypeEnum().equals(ATType.OAT_ATOMIC_BOOLEAN))
				_t=((OatBoolean)obt).getValue();
		} catch (Exception e) {}

		if(Boolean.TRUE.equals(_t))
			this.stgl.useLexerAngelB();
		else
			this.stgl.useLexerDefault();

		this.stgl.setApplicationName(prop.getValue(TribeProperties.tpmKeyNameLC).getValOatAtomicString());
		this.stgl.setSTGFileName(prop.getValueCli(TribeProperties.tpmKeyTgtStg));
		this.stgl.setSTGUrlName(prop.getValueDefault(TribeProperties.tpmKeyTgtStg));
		this.stgl.loadSTG("code generation", prop.getValue(TribeProperties.tpmKeyTgtLanguage));

		OatMapLH chMan=this.target.getMandatory();
		OatMapLH chOpt=this.target.getOptional();
		this.stgl.setChunks(chMan, chOpt);
		if(this.stgl.testChunks()==false)
			System.exit(-10);
	}

	public void printStg(){
		if(this.stgl!=null)
			System.out.println(this.stgl.getSTG().toString());
	}
}
