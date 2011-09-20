package org.skb.lang.glue.proto;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.glue.proto.constants.GlueConstants;
import org.skb.lang.glue.proto.grammars.glueAst;
import org.skb.lang.glue.proto.grammars.glueEbnfLexer;
import org.skb.lang.glue.proto.grammars.glueEbnfParser;
import org.skb.lang.glue.proto.grammars.glueGen;
import org.skb.tribe.TribeParserAPI;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.io.files.FileTemplateList;

public class GlueParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(GlueParser.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(GlueParser.class);

	public GlueParser(){
		config.addAtomList();
		config.addLangRuleMap();
	}

	@Override
	public String getConfigurationFile() {
		return "/org/skb/lang/glue/proto/proto.json";
	}

	@Override
	public String getSourceLanguage() {
		return "glue";
	}

	@Override
	public Configuration getConfiguration(){
		return config;
	}

	@Override
	public String getLangRuleClassName(){
		return GlueConstants.Rules.class.getName();
	}


	@Override
	public String getLangRuleKeyword(){
		return "rule";
	}

	@Override
	public String getOptionClassName() {
		return GlueConstants.Properties.class.getName();
	}

	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new glueEbnfLexer(input);
	}

	@Override
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		glueEbnfParser parser = new glueEbnfParser(tokens);
		return (CommonTree)parser.glueSpecification().getTree();
	}


	@Override
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException {
		glueAst ast=new glueAst(nodesForAst);
		return (CommonTree)ast.glueSpecification().getTree();
	}

	@Override
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException {
		glueGen gen = new glueGen(nodesForGen);
		gen.setTemplateLib(stg);
		gen.glueSpecification();
	}

	@Override
	public FileTemplateList pass4Files() {
		GluePass4_Files cfm=new GluePass4_Files();
		return cfm.getFileTemplateList();
	}

	@Override
	public void finish(boolean quietMode) {
	}

	@Override
	public String getOptionKeyword() {
		return "key";
	}
}
