package org.skb.lang.pola.proto;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.pola.proto.constants.PolaConstants;
import org.skb.lang.pola.proto.grammars.polaAst;
import org.skb.lang.pola.proto.grammars.polaEbnfLexer;
import org.skb.lang.pola.proto.grammars.polaEbnfParser;
import org.skb.lang.pola.proto.grammars.polaGen;
import org.skb.tribe.TribeParserAPI;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.config.ConfigurationProperties;
import org.skb.util.classic.io.files.FileTemplateList;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.java.TSBoolean;

public class PolaParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(TribeParserAPI.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(PolaParser.class);

	public PolaParser(){
		config.addAtomList();
		config.addLangRuleMap();
	}


	@Override
	public String getConfigurationFile() {
		return "/org/skb/lang/pola/proto/proto.json";
	}


	@Override
	public String getSourceLanguage() {
		return "pola";
	}


	@Override
	public Class<?> getConfigurationClassName(){
		return PolaParser.class;
	}


	@Override
	public String getLangRuleClassName(){
		return PolaConstants.Rules.class.getName();
	}


	@Override
	public String getLangRuleKeyword(){
		return "rule";
	}


	@Override
	public String getOptionClassName() {
		return PolaConstants.Properties.class.getName();
	}


	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new polaEbnfLexer(input);
	}


	@Override
	public CommonTree pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		polaEbnfParser parser = new polaEbnfParser(tokens);
		return (CommonTree)parser.polaSpecification().getTree();
	}


	@Override
	public CommonTree pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException {
		polaAst ast=new polaAst(nodesForAst);
		return (CommonTree)ast.polaSpecification().getTree();
	}


	@Override
	public void pass3CodeGen(CommonTreeNodeStream nodesForGen, StringTemplateGroup stg) throws RecognitionException {
		polaGen gen = new polaGen(nodesForGen);
		gen.setTemplateLib(stg);
		gen.polaSpecification();
	}


	@Override
	public FileTemplateList pass4Files() {
		PolaPass4_Files cfm=new PolaPass4_Files();
		return cfm.getFileTemplateList();
	}


	@Override
	public void finish(boolean quietMode) {
		ConfigurationProperties prop=config.getProperties();
		PolaStatistics stats=new PolaStatistics();

		TSBaseAPI ata=prop.getValue(PolaConstants.Properties.keyPrStat);
		if(!quietMode){
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genSimpleStats();
			ata=prop.getValue(PolaConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genCompleteStats();
		}
		// print stats if wanted
		ata=prop.getValue(PolaConstants.Properties.keyPrStat);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printSimpleStatistic();
		ata=prop.getValue(PolaConstants.Properties.keyPrStatAll);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printCompleteStatistic();
	}


	@Override
	public String getOptionKeyword() {
		return "key";
	}
}
