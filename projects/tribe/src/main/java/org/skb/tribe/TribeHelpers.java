package org.skb.tribe;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.TreeSet;

import org.skb.util.FieldKeys;
import org.skb.util.PathKeys;
import org.skb.util.cli.Cli;
import org.skb.util.config.Configuration;
import org.skb.util.config.ConfigurationProperties;
import org.skb.util.languages.LangParserAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;


public class TribeHelpers {


	public static ArrayList<LangParserAPI> getSrcParsers(LangParserAPI[] parsers, TSBaseAPI srcLang){
		ArrayList<LangParserAPI> ret=new ArrayList<LangParserAPI>();
		for(int i=0;i<parsers.length;i++){
			LangParserAPI p=parsers[i];
			if(srcLang.toString().equals(p.getSupportedSourceLang())){
				ret.add(p);
			}
		}
		return ret;
	}


	public static ArrayList<LangParserAPI> getTgtParsers(ArrayList<LangParserAPI> parsers, TSBaseAPI tgtLang){
		ArrayList<LangParserAPI> ret=new ArrayList<LangParserAPI>();
		if(tgtLang.tsIsType(TEnum.TS_NULL))
			return ret;
		if(parsers.size()==0)
			return ret;
		for(int i=0;i<parsers.size();i++){
			LangParserAPI p=parsers.get(i);
			TSArrayListString target=p.getSupportedTargetLang();
			if(target.contains(tgtLang)){
				ret.add(p);
			}
		}
		return ret;
	}


	public static void loadParserOptions(LangParserAPI parser, Cli cli){
		Configuration dest=Configuration.getConfiguration(parser.getConfigurationClassName());
		Configuration orig=Configuration.getConfiguration(Tribe.class);

		dest.config.put(PathKeys.pathConfigurationProperties, orig.getProperties().tsCopyComposite());
		dest.config.put(PathKeys.pathConfigurationReportmanager, orig.getReportManager().tsCopyAtomic());

		parser.setOptions(dest.getProperties());

		cli.setPropOptions(dest.getProperties());
		cli.setApplicationName(dest.getProperties().getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());
		dest.getReportManager().setApplicationName(dest.getProperties().getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());
	}


	public static String getFooterPrint(ConfigurationProperties prop){
		String ret=new String();
		ret+="\n";
		if(!prop.get(FieldKeys.fieldApplicationAdditional, FieldKeys.fieldValueDefault).tsIsType(TEnum.TS_NULL)){
			ret+="\n";
			ret+=prop.get(FieldKeys.fieldApplicationAdditional, FieldKeys.fieldValueDefault).toString()+"\n";
		}
		return ret;
	}


	public static String getHeaderPrint(ConfigurationProperties prop){
		String ret=new String();
		ret+=prop.get(FieldKeys.fieldApplicationName, FieldKeys.fieldValueDefault)+", version "+
		     prop.get(FieldKeys.fieldApplicationVersion, FieldKeys.fieldValueDefault)+", build "+
		     prop.get(FieldKeys.fieldApplicationBuild, FieldKeys.fieldValueDefault)+", "+
		     prop.get(FieldKeys.fieldApplicationBuilddate, FieldKeys.fieldValueDefault)+
		     "\n";
		ret+=prop.get(FieldKeys.fieldApplicationCopyright, FieldKeys.fieldValueDefault)+"\n";
		ret+="\n";
		ret+=prop.get(FieldKeys.fieldApplicationBuildwith, FieldKeys.fieldValueDefault)+"\n";
		ret+="\n";
		return ret;
	}


	public static String getDefaultOptionsPrint(ConfigurationProperties prop){
		String ret=new String();

   		ret+="\n";
		ret+="Default Configuration:\n";
		ret+="  [Option] = [Default Configuration]\n";
		ret+="\n";

		TreeSet<String> ts=new TreeSet<String>(prop.getRows());
        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
        	String current=i.next();
        	if(!(prop.get(current, FieldKeys.fieldCliOptionType)).tsIsType(TEnum.TS_NULL)){
        		if(!(prop.get(current, FieldKeys.fieldValueFile)).tsIsType(TEnum.TS_NULL)||!(prop.get(current, FieldKeys.fieldValueCli)).tsIsType(TEnum.TS_NULL)){
        			ret+="    "+current+" = "+prop.getValue(current)+"\n";
        		}
        		else{
        			ret+="    "+current+" = "+prop.getValueDefault(current)+"\n";
        		}
        	}
        }
        ret+=TribeHelpers.getFooterPrint(prop);

		return ret;
	}


	public static String getHelpPrint(Cli cli, ConfigurationProperties prop){
		return cli.usage(TribeHelpers.getHeaderPrint(prop), TribeHelpers.getFooterPrint(prop), 80, true);
	}


	public static String getVersionPrint(ConfigurationProperties prop){
		return TribeHelpers.getHeaderPrint(prop);
	}


	public static String getSupportedLangPrint(LangParserAPI[] parsers){
		String ret=new String();

		ret+="supported languages = ";
		for(int i=0;i<parsers.length;i++){
			LangParserAPI p=parsers[i];
			ret+="\n          source:"+p.getSupportedSourceLang();
			ret+=" -> targets:"+p.getSupportedTargetLang();
		}
    	ret+="\n";
    	return ret;
	}


	public static boolean exitOptionsSet(ConfigurationProperties prop){
		Boolean defOpt=false;
		Boolean showHelp=false;
		Boolean showVersion=false;
		Boolean showLang=false;

		try {
			defOpt=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionDefaultOptions)).tsvalue;
			showHelp=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowhelp)).tsvalue;
			showVersion=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowversion)).tsvalue;
			showLang=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowlang)).tsvalue;
		} catch (Exception e) {}

		return defOpt&showHelp&showVersion&showLang;
	}


	public enum exitOptions{
		HELP, VERSION, LANGUAGES, DEF_OPTIONS, PRINT_STG_REPORTMGR
	}


	public static EnumSet<TribeHelpers.exitOptions> checkExitOptions(ConfigurationProperties prop){
		EnumSet<TribeHelpers.exitOptions> ret=EnumSet.noneOf(TribeHelpers.exitOptions.class);

		Boolean showHelp=false;
		Boolean showVersion=false;
		Boolean showLang=false;
		Boolean defOpt=false;
		Boolean printTribeSTG=false;

		try {
			showHelp=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowhelp)).tsvalue;
			showVersion=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowversion)).tsvalue;
			showLang=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowlang)).tsvalue;
			defOpt=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionDefaultOptions)).tsvalue;
			printTribeSTG=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionPrStgFileReportMgr)).tsvalue;
		} catch (Exception e) {}

		if(showHelp==true)
			ret.add(TribeHelpers.exitOptions.HELP);
		if(showVersion==true)
			ret.add(TribeHelpers.exitOptions.VERSION);
		if(showLang==true)
			ret.add(TribeHelpers.exitOptions.LANGUAGES);
		if(defOpt==true)
			ret.add(TribeHelpers.exitOptions.DEF_OPTIONS);
		if(printTribeSTG==true)
			ret.add(TribeHelpers.exitOptions.PRINT_STG_REPORTMGR);
		return ret;
	}
}
