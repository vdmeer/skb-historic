package org.skb.tribe;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.skb.util.io.files.FileTemplateList;

public interface TribeParserAPI {
	public String getConfigurationFile();
	public String getSourceLanguage();
	public String getOptionClassName();

	public Lexer pass1GetLexer(ANTLRInputStream input);
	public void pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException;
	public CommonTree pass1GetTree();

	public void pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException;
	public CommonTree pass2GetTree();

	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException;

	public FileTemplateList pass4Files();

	public void finish(boolean quietMode);
}
