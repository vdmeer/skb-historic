/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.tribe;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.skb.base.FieldKeys;
import org.skb.base.PathKeys;
import org.skb.base.classic.cli.Cli;
import org.skb.base.classic.config.Configuration;
import org.skb.base.classic.config.ConfigurationProperties;
import org.skb.base.classic.lang.LangParserAPI;
import org.skb.base.classic.misc.AsciiFormatter;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSDefault;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.antlr.TSSTGroupManager;
import org.skb.base.composite.java.TSBoolean;
import org.skb.base.composite.util.TSArrayList;
import org.skb.base.composite.util.TSArrayListString;
import org.skb.base.composite.util.TSLinkedHashTree;

/**
 * Helper methods for Tribe processing.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TribeHelpers {

	/**
	 * Loads a StringTemplateGroup Manager ({@link TSSTGroupManager}).
	 * @param config configuration object
	 * @param path path to StringTemplate chunk information within the configuration
	 * @param applicationName name of the application that loads the manager
	 * @param stgFile StringTemplate file name
	 * @return new STG Manager
	 */
	public static TSSTGroupManager loadSTGM(Configuration config, String path, String applicationName, String stgFile){
		TSSTGroupManager ret=new TSSTGroupManager();
		TSBaseAPI tsb=config.config.get(path);
		if(tsb.tsIsType(TEnum.TS_COMPOSITE_TREE_LH)){
			TSLinkedHashTree map=(TSLinkedHashTree)tsb;
			TSBaseAPI ala;
			for (String s:map.keySet()){
				ala=map.get(s+"/"+FieldKeys.fieldStringtemplateChunksMandatory);
				if(!ala.tsIsType(TEnum.TS_NULL))
					ret.putMandatoryChunks(s, (TSArrayList)ala);
				ala=map.get(s+"/"+FieldKeys.fieldStringtemplateChunksOptional);
				if(!ala.tsIsType(TEnum.TS_NULL))
					ret.putOptionalChunks(s, (TSArrayList)ala);
			}
		}

		ret.useLexerDefault();
		ret.setApplicationName(applicationName);

		ret.setSTGFile(stgFile);

		return ret;
	}

	/**
	 * Returns all parsers from the given array of parsers that support the specified source language.
	 * @param parsers parser array
	 * @param srcLang required source language
	 * @return set of parsers that support the source language
	 */
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

	/**
	 * Returns all parsers from the given array of parsers that support the specified target language.
	 * @param parsers parser array
	 * @param tgtLang required target language
	 * @return set of parsers that support the target language
	 */
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

	/**
	 * Loads all options of a parser and copies current tribe-processed options to it.
	 * @param parser selected parser
	 * @param cli command line parser with additional settings
	 * @return the return of the parser specific load method
	 */
	public static TSDefault loadParserOptions(LangParserAPI parser, Cli cli){
		Configuration dest=parser.getConfiguration();
		Configuration orig=Configuration.getConfiguration(Tribe.class);

		dest.config.put(PathKeys.pathConfigurationParserTribeStgChunks, orig.config.get(PathKeys.pathConfigurationParserTribeStgChunks));
		dest.config.put(PathKeys.pathInstancesProperties, orig.getProperties().tsCopyComposite());
		dest.config.put(PathKeys.pathInstancesReportmanager, orig.getReportManager().tsCopyAtomic());

		TSDefault ret=parser.loadParserOptions();

		cli.setPropOptions(dest.getProperties());
		cli.setApplicationName(dest.getProperties().getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());
		dest.getReportManager().setApplicationName(dest.getProperties().getValue(FieldKeys.fieldApplicationName).toString().toLowerCase());

		return ret;
	}

	/**
	 * Returns a string with a footer, to be used after other exit options prints
	 * @param prop property map
	 * @return string
	 */
	public static String getFooterPrint(ConfigurationProperties prop){
		String ret=new String();
		ret+="\n";
		if(!prop.get(FieldKeys.fieldApplicationAdditional, FieldKeys.fieldValueDefault).tsIsType(TEnum.TS_NULL)){
			ret+="\n";
			ret+=prop.get(FieldKeys.fieldApplicationAdditional, FieldKeys.fieldValueDefault).toString()+"\n";
		}
		return ret;
	}

	/**
	 * Returns a string with a header, to be used before other exit options prints
	 * @param prop property map
	 * @return string
	 */
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

	/**
	 * Returns a string with a header, to be used before other exit options prints
	 * @param prop property map
	 * @return string
	 */
	public static String getHeaderShortPrint(ConfigurationProperties prop){
		return prop.get(FieldKeys.fieldApplicationName, FieldKeys.fieldValueDefault)+", version "+
		       prop.get(FieldKeys.fieldApplicationVersion, FieldKeys.fieldValueDefault)+", build "+
		       prop.get(FieldKeys.fieldApplicationBuild, FieldKeys.fieldValueDefault)+", "+
		       prop.get(FieldKeys.fieldApplicationBuilddate, FieldKeys.fieldValueDefault)+
		       "\n";
	}

	/**
	 * Returns a string with all options (properties) and their default value
	 * @param prop property map
	 * @return string
	 */
	public static String getDefaultOptionsPrint(ConfigurationProperties prop){
		LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
		TreeSet<String> ts=new TreeSet<String>(prop.getRows());
        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
        	String current=i.next();
        	if(!(prop.get(current, FieldKeys.fieldCliOptionType)).tsIsType(TEnum.TS_NULL)){
        		if(!(prop.get(current, FieldKeys.fieldValueFile)).tsIsType(TEnum.TS_NULL)||!(prop.get(current, FieldKeys.fieldValueCli)).tsIsType(TEnum.TS_NULL))
        			map.put(current, prop.getValue(current).toString());
        		else
        			map.put(current, prop.getValueDefault(current).toString());
        	}
        }
        return AsciiFormatter.tableTwoRows(map, "Default Options", "Option", "Default Value");
	}

	/**
	 * Returns a string with usage and extended help information.
	 * @param cli command line parser that prints usage information
	 * @param prop properties that hold all information on arguments
	 * @return string
	 */
	public static String getHelpPrint(Cli cli, ConfigurationProperties prop){
		return cli.usage(TribeHelpers.getHeaderPrint(prop), TribeHelpers.getFooterPrint(prop), 80, true);
	}

	/**
	 * Returns a string with version information.
	 * @param prop properties that hold information about the version
	 * @return string
	 */
	public static String getVersionPrint(ConfigurationProperties prop){
		return TribeHelpers.getHeaderPrint(prop);
	}

	/**
	 * Returns a string with the supported languages.
	 * @param parsers array with all registered parsers
	 * @return simple string containing source language to target language(s) mappings per parser supported
	 */
	public static String getSupportedLangPrint(LangParserAPI[] parsers){
		LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
		for(int i=0;i<parsers.length;i++){
			map.put(parsers[i].getSupportedSourceLang(), parsers[i].getSupportedTargetLang().toString());
		}
		return AsciiFormatter.tableTwoRows(map, "Supported Languages", "Source", "Target");
	}

	/**
	 * Checks the settings for exit options and puts them into an enum set.
	 * 
	 * An exit option is any option that is intended to stop the processing of the parser intentionally.
	 * Examples of exit options are: show help information, show version information, show supported languages
	 * and print StrngTemplate source files.
	 * @param prop properties that might contain exit options
	 * @return set of activated exit options
	 */
	public static EnumSet<EnumExitOptions> checkExitOptions(ConfigurationProperties prop){
		EnumSet<EnumExitOptions> ret=EnumSet.noneOf(EnumExitOptions.class);

		Boolean showHelp=false;
		Boolean showVersion=false;
		Boolean showLang=false;
		Boolean defOpt=false;
		Boolean printTribeSTG=false;
		Boolean printTargetSTG=false;

		try {
			showHelp=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowhelp)).tsvalue;
			showVersion=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowversion)).tsvalue;
			showLang=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionShowlang)).tsvalue;
			defOpt=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionDefaultOptions)).tsvalue;
			printTribeSTG=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionPrStgFileReportMgr)).tsvalue;
			printTargetSTG=((TSBoolean)prop.getValue(FieldKeys.fieldCliOptionPrStgFileTarget)).tsvalue;

		} catch (Exception e) {}

		if(showHelp==true)
			ret.add(EnumExitOptions.HELP);
		if(showVersion==true)
			ret.add(EnumExitOptions.VERSION);
		if(showLang==true)
			ret.add(EnumExitOptions.LANGUAGES);
		if(defOpt==true)
			ret.add(EnumExitOptions.DEF_OPTIONS);
		if(printTribeSTG==true)
			ret.add(EnumExitOptions.PRINT_STG_REPORTMGR);
		if(printTargetSTG==true)
			ret.add(EnumExitOptions.PRINT_STG_TARGET);
		return ret;
	}

	/**
	 * Translates tokens.
	 * @param tokens tokens to be translated
	 * @param config configuration holding translation information
	 * @return translated tokens
	 */
    public static String[] translateTokens(String[] tokens, Configuration config){
    	TreeMap<String, String> tokenMap=new TreeMap<String, String>();

    	TSLinkedHashTree map=(TSLinkedHashTree)config.config.get(PathKeys.pathConfigurationParserLangTokens);
    	if(map!=null&&map.size()>0){
    		TSLinkedHashTree tokenStrings=new TSLinkedHashTree();
   			for(String s:map.keySet()){
   				try{
   					TSBaseAPI tid=map.get(s+"/"+FieldKeys.fieldLangTargetTokenIdent);
   					TSBaseAPI tval=map.get(s+"/"+FieldKeys.fieldLangTargetTokenTranslate);
   				    tokenStrings.put(tid.toString(), tval.toString());
   				} catch (Exception e){}
   			}
    		if(tokenStrings.size()>0){
    			for(String s:tokenStrings.keySet()){
    				tokenMap.put(s,tokenStrings.get(s).toString());
    			}
    		}
    	}

    	String[] tokenNames=new String[tokens.length];
        for(int i=0;i<tokens.length;i++){
        	if(tokenMap.get(tokens[i])!=null)
            	tokenNames[i]=tokenMap.get(tokens[i]);
        	else
            	tokenNames[i]=tokens[i];
        }
        return tokenNames;
    }
}
