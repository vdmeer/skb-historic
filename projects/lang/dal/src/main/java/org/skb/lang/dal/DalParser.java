package org.skb.lang.dal;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.lang.dal.grammars.dalAst;
import org.skb.lang.dal.grammars.dalEbnfLexer;
import org.skb.lang.dal.grammars.dalEbnfParser;
import org.skb.lang.dal.grammars.dalGen;
import org.skb.tribe.TribeParserAPI;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.io.files.FileTemplateList;

public class DalParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(DalParser.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(DalParser.class);

	public DalParser(){
		config.addAtomList();
		config.addLangRuleMap();
	}

	@Override
	public String getConfigurationFile() {
		return "/org/skb/lang/dal/dal.json";
	}

	@Override
	public String getSourceLanguage() {
		return "dal";
	}

	@Override
	public Configuration getConfiguration(){
		return config;
	}

	@Override
	public String getOptionClassName() {
		return DalConstants.Properties.class.getName();
	}

	@Override
	public String getLangRuleClassName(){
		return DalConstants.Rules.class.getName();
	}


	@Override
	public String getLangRuleKeyword(){
		return "rule";
	}

	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new dalEbnfLexer(input);
	}

	@Override
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		dalEbnfParser parser = new dalEbnfParser(tokens);
		return (CommonTree)parser.dalSpecification().getTree();
	}

	@Override
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst)	throws RecognitionException {
		dalAst ast=new dalAst(nodesForAst);
		return (CommonTree)ast.dalSpecification().getTree();
	}

	@Override
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException {
		dalGen gen = new dalGen(nodesForGen);
		gen.setTemplateLib(stg);
		gen.dalSpecification();
	}

	@Override
	public FileTemplateList pass4Files() {
		DalPass4_Files cfm=new DalPass4_Files();
		return cfm.getFileTemplateList();
	}

	@Override
	public void finish() {
	}

	@Override
	public String getOptionKeyword() {
		return "key";
	}
}
