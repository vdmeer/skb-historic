/* Copyright (c) 2000-2011 Sven van der Meer
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

package org.skb.lang.cola.proto;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.base.config.Configuration;
import org.skb.base.io.files.FileTemplateList;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.grammars.colaAst;
import org.skb.lang.cola.proto.grammars.colaEbnfLexer;
import org.skb.lang.cola.proto.grammars.colaEbnfParser;
import org.skb.lang.cola.proto.grammars.colaGen;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;
import org.skb.tribe.TribeParserAPI;

/**
 * Parser for COLA-Proto.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ColaParser implements TribeParserAPI {
	/** Logger instance */
	public static Logger logger = Logger.getLogger(ColaParser.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(ColaParser.class);

	/** Path to the Contract Declaration List in the configuration */
	public final static String pathInstanceContractDeclarationList	= "skb/instances/cola/proto/contractdecllist";

	/** Path to the Property Declaration List in the configuration */
	public final static String pathInstancePropertyDeclarationList	= "skb/instances/cola/proto/propertydecllist";

	/**
	 * Class constructor.
	 */
	public ColaParser(){
		config.addAtomList();
		config.addLangRuleMap();
		config.config.put(ColaParser.pathInstanceContractDeclarationList, new ContractDeclarationList());
		config.config.put(ColaParser.pathInstancePropertyDeclarationList, new PropertyDeclarationList());
	}

	@Override
	public String getConfigurationFile(){
		return "/org/skb/lang/cola/proto/proto.json";
	}

	@Override
	public String getSourceLanguage(){
		return "cola";
	}

	@Override
	public Configuration getConfiguration(){
		return config;
	}

	@Override
	public String getLangRuleClassName(){
		return ColaConstants.Rules.class.getName();
	}

	@Override
	public String getLangRuleKeyword(){
		return "rule";
	}

	@Override
	public String getOptionClassName(){
		return ColaConstants.Properties.class.getName();
	}

	@Override
	public String getOptionKeyword(){
		return "key";
	}

	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new colaEbnfLexer(input);
	}

	@Override
	public String getParserRuleSTGFileName(){
		return config.getProperties().getValue(ColaConstants.Properties.keyParserRuleStg).toString();
	}

	@Override
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		colaEbnfParser parser=new colaEbnfParser(tokens);
		return (CommonTree)parser.colaSpecification().getTree();
	}

	@Override
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException {
		colaAst ast=new colaAst(nodesForAst);
		return (CommonTree)ast.colaSpecification().getTree();
	}

	@Override
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException {
		colaGen gen = new colaGen(nodesForGen);
		gen.setTemplateLib(stg);
		gen.colaSpecification();
	}

	@Override
	public FileTemplateList pass4Files() {
		ColaPass4_Files cfm=new ColaPass4_Files();
		return cfm.getFileTemplateList();
	}

	@Override
	public void finish() {
//		ConfigurationProperties prop=config.getProperties();
//		ColaStatistics stats=new ColaStatistics();
//
//		TSBaseAPI ata=prop.getValue(ColaConstants.Properties.keyPrStat);
//		if(!quietMode){
//			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
//				stats.genSimpleStats();
//			ata=prop.getValue(ColaConstants.Properties.keyPrStatAll);
//			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
//				stats.genCompleteStats();
//		}
//		// print stats if wanted
//		ata=prop.getValue(ColaConstants.Properties.keyPrStat);
//		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
//			stats.printSimpleStatistic();
//		ata=prop.getValue(ColaConstants.Properties.keyPrStatAll);
//		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
//			stats.printCompleteStatistic();
	}
}
