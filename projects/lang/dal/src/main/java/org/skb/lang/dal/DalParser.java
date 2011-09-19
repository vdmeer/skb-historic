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
import org.skb.util.config.Configuration;
import org.skb.util.config.ConfigurationProperties;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;

public class DalParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(DalParser.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(DalParser.class);

	private dalEbnfParser.dalSpecification_return fromEbnf;
	private dalAst.dalSpecification_return fromAst;

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
	public Class<?> getConfigurationClassName(){
		return DalParser.class;
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
	public void pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		dalEbnfParser parser = new dalEbnfParser(tokens);
		this.fromEbnf=parser.dalSpecification();
	}

	@Override
	public CommonTree pass1GetTree() {
		return (CommonTree)this.fromEbnf.getTree();
	}

	@Override
	public void pass2Ast(CommonTreeNodeStream nodesForAst)	throws RecognitionException {
		dalAst ast=new dalAst(nodesForAst);
		this.fromAst=ast.dalSpecification();
	}

	@Override
	public CommonTree pass2GetTree() {
		return (CommonTree)this.fromAst.getTree();
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
	public void finish(boolean quietMode) {
		ConfigurationProperties prop=config.getProperties();
		DalStatistics stats=new DalStatistics();

		TSBaseAPI ata=prop.getValue(DalConstants.Properties.keyPrStat);
		if(!quietMode){
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genSimpleStats();
			ata=prop.getValue(DalConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genCompleteStats();
		}
		// print stats if wanted
		ata=prop.getValue(DalConstants.Properties.keyPrStat);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printSimpleStatistic();
		ata=prop.getValue(DalConstants.Properties.keyPrStatAll);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printCompleteStatistic();
	}

	@Override
	public String getOptionKeyword() {
		return "key";
	}
}
