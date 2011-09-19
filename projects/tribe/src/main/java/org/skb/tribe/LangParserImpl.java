package org.skb.tribe;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.PathKeys;
import org.skb.util.config.Configuration;
import org.skb.util.config.ConfigurationProperties;
import org.skb.util.io.files.FileManager;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.languages.LangParserAPI;
import org.skb.util.misc.Json2Oat;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.misc.TSReportManager;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;
import org.skb.util.patterns.structural.composite.composite.util.TSPropertyMap;
import org.skb.util.stringtemplate.STGroupManager;

public class LangParserImpl implements LangParserAPI {
	/** Logger instance */
	static Logger logger = Logger.getLogger(LangParserImpl.class);

	/** Target StringTemplateGroup */
	private STGroupTarget target;

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** the Parser object associated with this TribeParser */
	private TribeParserAPI langParser=null;

	/** supported source language of the parser */
	private String supportedSourceLang=null; 

	/** supported target languages of the parser */
	private TSArrayListString supportedTargetLang=null;

	/** StringTemplateGroup manager for the parser */
	protected STGroupManager stgl=null;

	//TODO comments
	Configuration config=null;
	ConfigurationProperties cProp=null;

	/**
	 * Class constructor, initialises local fields
	 */
	public LangParserImpl(){
		logger.trace("constructor -- in");

		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_TRIBE_LP);
		this.typeEnum.add(TEnum.TS_TRIBE_LP);

		logger.trace("constructor -- out");
	}


	public void setLangParser(TribeParserAPI parser){
		this.langParser=parser;

		this.supportedSourceLang=this.langParser.getSourceLanguage();

		this.config=Configuration.getConfiguration(this.langParser.getConfigurationClassName());

		String url=this.langParser.getConfigurationFile();
		try{
			Json2Oat j2o=new Json2Oat();
			TSBaseAPI c=j2o.read(url);
			if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH)){
				this.config.config.put(PathKeys.pathConfigurationParserTribe, ((TSMapLH)c).get(PathKeys.pathConfigurationParserTribe));
				this.config.config.put(PathKeys.patConfigurationParserLang, ((TSMapLH)c).get(PathKeys.patConfigurationParserLang));
			}
		}
		catch (Exception e){
			System.err.println("LangParserImpl: "+e);
		}

		this.supportedTargetLang=new TSArrayListString();
		Set<String> lang=((TSMapLH)this.config.config.get(PathKeys.pathConfigurationParserLangTargets)).keySet();
		Iterator<String> it=lang.iterator();
		while(it.hasNext())
			this.supportedTargetLang.add(it.next().toString());

		this.config.getLangRuleMap().loadRules(this.langParser.getLangRuleClassName(), this.langParser.getLangRuleKeyword(), (TSMapLH)this.config.config.get(PathKeys.pathConfigurationParserLangRules), (TSMapLH)this.config.config.get(PathKeys.pathConfigurationParserLangTokens));
	}


	@Override
	public void parse(InputStream is) {
		logger.trace("parse -- in");

		TSReportManager repMgr=this.config.getReportManager();

		Boolean quietMode=false;
		try {
			quietMode=((TSBoolean)this.cProp.getValue(FieldKeys.fieldCliOptionQuietMode)).tsvalue;
		}
		catch(Exception e){
			logger.trace("quiet mode not set in tribe, default false");
		}

		try {
			logger.trace("converting inputStream to ANTLR");
			ANTLRInputStream input = new ANTLRInputStream(is);

			logger.trace("creating lexer and token stream");
			Lexer lexer=this.langParser.pass1GetLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			logger.trace("creating parser and get return from parsing");
			//Object fromEbnf=this.langParser.pass1Ebnf(tokens);
			this.langParser.pass1ParseEBNF(tokens);

			logger.trace("check for errors");
			int ret=repMgr.noOfErrors();
			String msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
				msg+=", exiting at pass 1";
				if(!quietMode)
					repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 1 (Syntax Check)";
			if(!quietMode)
				repMgr.reportMessageNoFile(msg);

			logger.trace("still here, reset errors and continue");
			repMgr.resetNoOfErrors();
			logger.trace("creating AST parser and tree node stream");
			CommonTree treeForAst=this.langParser.pass1GetTree();
			CommonTreeNodeStream nodesForAst=new CommonTreeNodeStream(treeForAst);
			nodesForAst.setTokenStream(tokens);

			logger.trace("calling ast.specification");
			//Object fromAst=this.langParser.pass2Ast(nodesForAst);
			this.langParser.pass2Ast(nodesForAst);
			ret=repMgr.noOfErrors();

			msg=ret+" error";
			if (ret == 0 || ret > 1)
				msg+="s";
			if (ret > 0) {
				msg+=", exiting at pass 2";
				if(!quietMode)
					repMgr.reportError(msg);
				System.exit(1);
			}
			else
				msg+=" in pass 2 (Semantic Check)";
			if(!quietMode)
				repMgr.reportMessageNoFile(msg);

			TSBaseAPI ata=this.cProp.getValue(FieldKeys.fieldCliOptionGC);
			if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true){
				//repMgr.resetNoOfErrors();
				CommonTree treeForGen=this.langParser.pass2GetTree();
				CommonTreeNodeStream nodesForGen=new CommonTreeNodeStream(treeForGen);
				nodesForGen.setTokenStream(tokens);
				this.langParser.pass3CodeGen(nodesForGen, this.stgl.getSTG());

				msg="success  in pass 3 (Code Generation)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);

				FileTemplateList ftl=this.langParser.pass4Files();
				ftl.init(this.cProp.getValue(FieldKeys.fieldCliOptionTgtDir));

				FileManager fm=new FileManager(this.target.getStdHeaderST(), this.target.getFileStartST(), this.target.getFileEndST());
				fm.init(this.cProp.getValue(FieldKeys.fieldCliOptionSrcLanguage),
						this.cProp.getValue(FieldKeys.fieldCliOptionSrcFile),
						this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage),
						this.cProp.getValue(FieldKeys.fieldCliOptionTgtFileExt),
						this.cProp.getValue(FieldKeys.fieldCliOptionGC));
				fm.writeList(ftl);

				msg="success  in pass 4 (Write Files)";
				if(!quietMode)
					repMgr.reportMessageNoFile(msg);
			}
			this.langParser.finish(quietMode);
		}
		catch(IOException io){
			repMgr.reportError("catched exception while parsing", "IOException: " + io.toString());
		}
		catch(Exception e){
			repMgr.reportError("catched exception while parsing", "Exception: " + e.toString());
		}

		logger.trace("parse -- out");
	}


	private void loadStg() {
		this.stgl=new STGroupManager();

		TSBaseAPI obt=this.cProp.getValue(FieldKeys.fieldApplicationTgtStgAngleBr);
		Boolean _t=false;
		try {
			if(obt.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN))
				_t=((TSBoolean)obt).tsvalue;
		} catch (Exception e) {}

		if(Boolean.TRUE.equals(_t))
			this.stgl.useLexerAngelB();
		else
			this.stgl.useLexerDefault();

		this.stgl.setApplicationName(this.cProp.getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());
		this.stgl.setSTGFile(this.cProp.getValue(FieldKeys.fieldCliOptionTgtStg));
		this.stgl.loadSTG("code generation", this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage));

		TSMapLH chMan=this.target.getMandatory();
		TSMapLH chOpt=this.target.getOptional();

		this.stgl.setChunks(chMan, chOpt);
		if(this.stgl.testChunks()==false){
			System.err.println("Oops, problem loading STG"); //TODO
			System.exit(-10);
		}
	}


	@Override
	public void printStg() {
		if(this.stgl!=null)
			System.out.println(this.stgl.getSTG().toString());
	}


	@Override
	public void setOptions(ConfigurationProperties TTT){
		logger.trace("setOptions -- in");

		//has to be a std property map to avoid loading fixed rows of ConfigurationProprties
		TSPropertyMap opm=new TSPropertyMap();
		opm.addRows(this.langParser.getOptionClassName(), this.langParser.getOptionKeyword());

		this.cProp=this.config.getProperties();

		if(config==null){
			//TODO
			System.err.println("tribe: property configuration not found");
		}
		else{
			opm.loadFromJason(this.config.config.get(PathKeys.patConfigurationParserLangConfiguration));
			cProp.loadFromJason(this.config.config.get(PathKeys.pathConfigurationParserTribe));
			if(this.config.config.containsKey(PathKeys.pathConfigurationParserLangTargets)){
				String lang=new String();
				if(!cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
					lang=cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).toString();
					opm.loadFromJason(((TSMapLH)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang+"/"+FieldKeys.fieldLangTargetConfigCli)).tsGetValue());
					cProp.loadFromJason(((TSMapLH)this.config.config.get(PathKeys.pathConfigurationParserLangTargets+"/"+lang)).tsGetValue());
				}
			}
		}
		cProp.addProperties(opm);

		//load target
		if(!this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
			logger.trace("target set as <"+this.cProp.getValue(FieldKeys.fieldCliOptionTgtLanguage)+">");
			this.target=new STGroupTarget(this.cProp.getValue(FieldKeys.fieldApplicationName), this.cProp.getValue(FieldKeys.fieldApplicationGenericSTG), this.config);
		}

		//load stg for target
		this.loadStg();

		logger.trace("setOptions -- out");
	}


	@Override
	public String getSupportedSourceLang() {
		return this.supportedSourceLang;
	}


	@Override
	public TSArrayListString getSupportedTargetLang() {
		return this.supportedTargetLang;
	}


	@Override
	public Class<?> getConfigurationClassName(){
		return this.langParser.getConfigurationClassName();
	}
}
