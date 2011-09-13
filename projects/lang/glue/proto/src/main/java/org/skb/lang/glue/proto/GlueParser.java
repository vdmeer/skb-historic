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
import org.skb.tribe.TribeProperties;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;

public class GlueParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(GlueParser.class);

	private glueEbnfParser.glueSpecification_return fromEbnf;
	private glueAst.glueSpecification_return fromAst;

	@Override
	public String getConfigurationFile() {
		return "/org/skb/lang/glue/proto/proto.json";
	}

	@Override
	public String getSourceLanguage() {
		return "glue";
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
	public void pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		glueEbnfParser parser = new glueEbnfParser(tokens);
		this.fromEbnf=parser.glueSpecification();
	}

	@Override
	public CommonTree pass1GetTree() {
		return (CommonTree)this.fromEbnf.getTree();
	}

	@Override
	public void pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException {
		glueAst ast=new glueAst(nodesForAst);
		this.fromAst=ast.glueSpecification();
	}

	@Override
	public CommonTree pass2GetTree() {
		return (CommonTree)this.fromAst.getTree();
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
		TribeProperties prop=TribeProperties.getInstance();
		GlueStatistics stats=new GlueStatistics();

		TSBaseAPI ata=prop.getValue(GlueConstants.Properties.keyPrStat);
		if(!quietMode){
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genSimpleStats();
			ata=prop.getValue(GlueConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genCompleteStats();
		}
		// print stats if wanted
		ata=prop.getValue(GlueConstants.Properties.keyPrStat);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printSimpleStatistic();
		ata=prop.getValue(GlueConstants.Properties.keyPrStatAll);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printCompleteStatistic();
	}
}
