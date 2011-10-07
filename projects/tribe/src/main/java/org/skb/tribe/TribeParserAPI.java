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

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.skb.base.classic.config.Configuration;
import org.skb.base.classic.io.files.FileTemplateList;

/**
 * Interface for tribe's implementation of a language parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface TribeParserAPI {
	/**
	 * Returns the fully qualified path name of the parser's JSON configuration file
	 * @return FQPN of parser's configuration file (JSON)
	 */
	public String getConfigurationFile();

	/**
	 * Returns the supported source language of the parser.
	 * @return supported source language
	 */
	public String getSourceLanguage();

	/**
	 * Returns the class name of the class that provides string constants for properties.
	 * @return class name
	 */
	public String getOptionClassName();

	/**
	 * Returns the key (prefix) to be used to auto-load properties for the parser from the options class.
	 * @return key
	 */
	public String getOptionKeyword();

	/**
	 * Returns the class name of the class that provides string constants for language rules.
	 * @return class name for the language rule constants
	 */
	public String getLangRuleClassName();

	/**
	 * Returns the file name of the STG file with parser language rules.
	 * @return STG file name as fully qualified file name (directory+file)
	 */
	public String getParserRuleSTGFileName();

	/**
	 * Returns the key (prefix) to be used to auto-load language rules for the parser from the options class.
	 * @return key
	 */
	public String getLangRuleKeyword();

	/**
	 * Returns the parser's configuration object.
	 * @return class for the parser's configuration
	 */
	public Configuration getConfiguration();

	/**
	 * Returns the parser's lexer object
	 * @param input stream with the input to be parsed
	 * @return lexer object
	 */
	public Lexer pass1GetLexer(ANTLRInputStream input);

	/**
	 * Returns the tree resulting of the parsing of pass 1 (EBNF).
	 * @param tokens lexer tokens for the parser
	 * @return common tree (usually an AST) as result of the parse
	 * @throws RecognitionException
	 */
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException;

	/**
	 * Returns the tree resulting of the parsing of pass 2 (AST).
	 * @param nodesForAst the common tree (AST) generated by pass 1
	 * @return a common tree (AST) for code generation
	 * @throws RecognitionException
	 */
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException;

	/**
	 * Invokes the pass 3 (code generation).
	 * @param nodesForGen common tree (AST) generated by pass 2
	 * @param stg group for string templates for the code generation
	 * @throws RecognitionException
	 */
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException;

	/**
	 * Invokes pass 4, file generation.
	 * @return list of files and associated string templates to be written to the file system
	 */
	public FileTemplateList pass4Files();

	/**
	 * Final call to the parser, to do for instance statistics.
	 */
	public void finish();
}
