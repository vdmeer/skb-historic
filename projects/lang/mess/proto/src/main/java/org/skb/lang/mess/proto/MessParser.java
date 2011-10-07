/* Copyright (c) 2007-2011 Sven van der Meer
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

package org.skb.lang.mess.proto;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.base.classic.config.Configuration;
import org.skb.base.classic.io.files.FileTemplateList;
import org.skb.lang.mess.proto.constants.MessConstants;
import org.skb.lang.mess.proto.grammars.messAst;
import org.skb.lang.mess.proto.grammars.messEbnfLexer;
import org.skb.lang.mess.proto.grammars.messEbnfParser;
import org.skb.lang.mess.proto.grammars.messGen;
import org.skb.tribe.TribeParserAPI;

/**
 * Parser class for MESS.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class MessParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(MessParser.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(MessParser.class);

	public MessParser(){
		config.addAtomList();
		config.addLangRuleMap();
	}

	@Override
	public String getConfigurationFile() {
		return "/org/skb/lang/mess/proto/mess.json";
	}

	@Override
	public String getSourceLanguage() {
		return "mess";
	}

	@Override
	public Configuration getConfiguration(){
		return config;
	}

	@Override
	public String getOptionClassName() {
		return MessConstants.Properties.class.getName();
	}

	@Override
	public String getLangRuleClassName(){
		return MessConstants.Rules.class.getName();
	}


	@Override
	public String getLangRuleKeyword(){
		return "rule";
	}

	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new messEbnfLexer(input);
	}

	@Override
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		messEbnfParser parser = new messEbnfParser(tokens);
		return (CommonTree)parser.messSpecification().getTree();
	}

	@Override
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst)	throws RecognitionException {
		messAst ast=new messAst(nodesForAst);
		return (CommonTree)ast.messSpecification().getTree();
	}

	@Override
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException {
		messGen gen = new messGen(nodesForGen);
		gen.setTemplateLib(stg);
		gen.messSpecification();
	}

	@Override
	public FileTemplateList pass4Files() {
		MessPass4_Files cfm=new MessPass4_Files();
		return cfm.getFileTemplateList();
	}

	@Override
	public void finish() {
	}

	@Override
	public String getOptionKeyword() {
		return "key";
	}

	@Override
	public String getParserRuleSTGFileName() {
		// TODO Auto-generated method stub
		return null;
	}
}
