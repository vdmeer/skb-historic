package org.skb.lang.cola.proto;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.grammars.colaAst;
import org.skb.lang.cola.proto.grammars.colaEbnfLexer;
import org.skb.lang.cola.proto.grammars.colaEbnfParser;
import org.skb.lang.cola.proto.grammars.colaGen;
import org.skb.tribe.TribeParserAPI;
import org.skb.tribe.TribeProperties;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;

public class ColaParser implements TribeParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(ColaParser.class);


	private colaEbnfParser.colaSpecification_return fromEbnf;
	private colaAst.colaSpecification_return fromAst;


	@Override
	public String getConfigurationFile(){
		return "/org/skb/lang/cola/proto/proto.json";
	}


	@Override
	public String getSourceLanguage(){
		return "cola";
	}


	@Override
	public String getOptionClassName(){
		return ColaConstants.Properties.class.getName();
	}


	@Override
	public Lexer pass1GetLexer(ANTLRInputStream input) {
		return new colaEbnfLexer(input);
	}


	@Override
	public void pass1ParseEBNF(CommonTokenStream tokens) throws RecognitionException {
		colaEbnfParser parser = new colaEbnfParser(tokens);
		this.fromEbnf=parser.colaSpecification();
	}


	@Override
	public CommonTree pass1GetTree() {
		return (CommonTree)this.fromEbnf.getTree();
	}


	@Override
	public void pass2Ast(CommonTreeNodeStream nodesForAst) throws RecognitionException {
		colaAst ast=new colaAst(nodesForAst);
		this.fromAst=ast.colaSpecification();
	}


	@Override
	public CommonTree pass2GetTree() {
		return (CommonTree)this.fromAst.getTree();
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
	public void finish(boolean quietMode) {
		TribeProperties prop=TribeProperties.getInstance();
		ColaStatistics stats=new ColaStatistics();

		TSBaseAPI ata=prop.getValue(ColaConstants.Properties.keyPrStat);
		if(!quietMode){
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genSimpleStats();
			ata=prop.getValue(ColaConstants.Properties.keyPrStatAll);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
				stats.genCompleteStats();
		}
		// print stats if wanted
		ata=prop.getValue(ColaConstants.Properties.keyPrStat);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printSimpleStatistic();
		ata=prop.getValue(ColaConstants.Properties.keyPrStatAll);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true)
			stats.printCompleteStatistic();
	}
}
