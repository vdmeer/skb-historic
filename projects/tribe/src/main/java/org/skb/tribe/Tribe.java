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
 *       documentation and/or other materials provided with the distribution.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Properties;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.skb.base.ConfigKeys;
import org.skb.base.FieldKeys;
import org.skb.base.PathKeys;
import org.skb.base.cli.Cli;
import org.skb.base.cli.CliApache;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSDefault;
import org.skb.base.composite.TSError;
import org.skb.base.composite.TSNull;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSWarning;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.java.TSBoolean;
import org.skb.base.composite.java.TSString;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.composite.util.TSLinkedHashTree;
import org.skb.base.config.Configuration;
import org.skb.base.config.ConfigurationProperties;
import org.skb.base.json.Json2TS;
import org.skb.base.lang.LangParserAPI;
import org.skb.base.misc.PropertyHandler;
import org.skb.lang.cpp.CPP;

/**
 * This is the main Tribe class, it does all the magic.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Tribe {
	/** Logger Instance */
	public final static Logger logger = Logger.getLogger(Tribe.class);

	/** Configuration Instance */
	public final static Configuration config=Configuration.getConfiguration(Tribe.class);

	/** Property file defining a property that points to the tribe JSON configuration file */
	private final String propertyFile="/org/skb/tribe/tribe.properties";

	/** Tribe configuration */
	private ConfigurationProperties prop;

	/** Report Manager instance */
	private TSReportManager repMgr;

	/** Command Line Parser instance */
	private Cli cli;

	/** Local list of parsers for processing */
	private LangParserAPI[] parsers=null;

	/** Parser selected for parsing */
	private LangParserAPI parser=null;

	/** Enum set used as bit field for exitOptions */
	public EnumSet<EnumExitOptions> eo=EnumSet.noneOf(EnumExitOptions.class);

	/**
	 * Class Constructor, empty.
	 */
	public Tribe(){}

	/**
	 * Execute the parsing process Tribe. Input parameters are the supported languages and arguments for parameterising 
	 * Tribe, usually taken from the command line. 
	 * @param langParsers LanguageParser array containing all information on supported source and target languages.
	 * @param args Command line arguments.
	 * @return TSNull if everything was ok, TSError or TSWarning otherwise
	 */
	public TSDefault execute(LangParserAPI[] langParsers, String[] args){
		this.cli=new CliApache();
		config.init(this.propertyFile);
		this.prop=config.getProperties();
		this.repMgr=config.getReportManager();
		this.parsers=langParsers;

		//get the chunks for the standard STG file
		Properties cfgFile=new PropertyHandler().load(this.propertyFile, Tribe.class.getName());
		Json2TS j2o=new Json2TS();
		TSBaseAPI c=j2o.read(cfgFile.getProperty("org.skb.base.config.jsonfile"));
		if(c.tsIsType(TEnum.TS_COMPOSITE_TREE_LH)){
			TSLinkedHashTree cfg=(TSLinkedHashTree)c;
			config.config.put(PathKeys.pathConfigurationParserTribeStgChunks, cfg.get(PathKeys.pathConfigurationParserTribeStgChunks));
		}

		TSDefault result;
		//phase 1 is doing TRIBE parameter checking, no parser involved
		//if the phase returns 0 we can continue, otherwise we exit (phase responsible for printing errors/warnings/messages)
		result=this.phase1_Tribe(args);
		if(!result.tsIsType(TEnum.TS_NULL)){
			return result;
		}

		//parser is selected, so shift our internal prop and report manager to the new parser configuration
		Configuration parserConfig=this.parser.getConfiguration();
		this.prop=parserConfig.getProperties();
		this.repMgr=parserConfig.getReportManager();
		this.setOptions(args);

		//call phase 2, the actual parser related evaluation of parameters and the parsing
		result=this.phase2_Parser();
		if(!result.tsIsType(TEnum.TS_NULL)){
			return result;
		}

		return new TSNull();
	}

	/**
	 * Realises the parser-generic option processing.
	 * @param args command line arguments
	 * @return TSNull if everything was ok, TSError or TSWarning otherwise
	 */
	private TSDefault phase1_Tribe(String[] args){
		logger.trace("starting phase 1 -- tribe");

		/** Field to check return values */
		TSDefault checkRet=new TSDefault();

		/**
		 * Get the set application name (default is "") and set CLI and ReportManager accordingly
		 */
		String appName="";
		try{
			appName=prop.getValue(FieldKeys.fieldApplicationName).toString().toLowerCase();
		} catch(Exception e){}
		logger.trace("set app name on CLI and ReportManager to <"+appName+">");
		this.cli.setApplicationName(appName);
		this.repMgr.setApplicationName(appName);

		/**
		 * Initialise the report manager
		 */
		logger.trace("set report manager");
		this.repMgr.setSTGFileName(prop.get(FieldKeys.fieldCliOptionReportManagerStg, FieldKeys.fieldValueDefault));
		checkRet=this.repMgr.loadSTG("Report Manager default String Template Group", "");
		if(checkRet.tsIsType(TEnum.TS_ERROR)){
			this.repMgr.error(checkRet.toString());
			return checkRet;
		}

		/**
		 * Do the first pass of options. This is needed to detect:
		 * - a new StringTemplate for the ReportManager
		 * - source language
		 * - target language
		 */
		logger.trace("cli propOptions and setOptions pass 1");
		this.cli.setPropOptions(this.prop);
		this.setOptions(args);

		/**
		 * Check for quiet mode, no error or no warning mode and set the logger for reports accordingly
		 */
		Boolean noError=((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionNoErrors)).tsvalue;
		Boolean noWarning=((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionNoWarnings)).tsvalue;
		Boolean quietMode=((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionQuietMode)).tsvalue;
		if(quietMode==true){
			Logger.getLogger(ConfigKeys.configLoggerReportmanagerInfo).setLevel(Level.OFF);
			Logger.getLogger(ConfigKeys.configLoggerReportmanagerErrors).setLevel(Level.OFF);
			Logger.getLogger(ConfigKeys.configLoggerReportmanagerWarnings).setLevel(Level.OFF);
		}
		else{
			if(noError==true)
				Logger.getLogger(ConfigKeys.configLoggerReportmanagerErrors).setLevel(Level.OFF);
			if(noWarning==true)
				Logger.getLogger(ConfigKeys.configLoggerReportmanagerWarnings).setLevel(Level.OFF);
		}

		//check if exit options are set, put them into the enum set
		this.eo=TribeHelpers.checkExitOptions(this.prop);

		/**
		 * reload the report manager stg (can be changed in CLI as well as in file)
		 */
		this.repMgr.setSTGFileName(prop.getValue(FieldKeys.fieldCliOptionReportManagerStg));
       	checkRet=this.repMgr.loadSTG("Report Manager after command line parsing", "");
		if(checkRet.tsIsType(TEnum.TS_ERROR)){
			this.repMgr.error(checkRet.toString());
			return checkRet;
		}

        /**
         * CLI Option case 1: no source language specified then
         * - if a target language is specified, print error and exit
         * - if no target language is specified then
         *   - if exitOptions apply, print exitOptions and exit
         *   - else print error on not set source language end exit
         */
        if(prop.getValue(FieldKeys.fieldCliOptionSrcLanguage).tsIsType(TEnum.TS_NULL)){
        	if(!prop.getValue(FieldKeys.fieldCliOptionTgtLanguage).tsIsType(TEnum.TS_NULL)){
        		String msg="target language specified without a source language";
        		this.repMgr.error(msg);
        		TSError ret=new TSError();
        		ret.tsSetMessage(msg);
        		return ret;
        	}
			if(this.eo.size()>0){
				System.out.println(this.doExitOptions());
				TSWarning ret=new TSWarning();
				ret.tsSetMessage("exit options selected, printed");
				return ret;
			}
			String msg="no source language specified";
			this.repMgr.error(msg);
			TSError ret=new TSError();
			ret.tsSetMessage(msg);
			return ret;
        }

        //we have a source language
        TSBaseAPI sourceLang=prop.getValue(FieldKeys.fieldCliOptionSrcLanguage);

        /**
         * CLI Option case 2: source language specified but no parser supporting it
         * - print error and exit
         */
        ArrayList<LangParserAPI> sourceParsers=TribeHelpers.getSrcParsers(this.parsers, sourceLang);
        if(sourceParsers.size()==0){
        	String msg="source language <"+sourceLang+"> not supported";
        	this.repMgr.error(msg);
        	TSError ret=new TSError();
			ret.tsSetMessage(msg);
			return ret;
        }

        //we now know that there is a source language and at least 1 parser supports it
        TSBaseAPI targetLang=prop.getValue(FieldKeys.fieldCliOptionTgtLanguage);
        ArrayList<LangParserAPI> targetParsers=TribeHelpers.getTgtParsers(sourceParsers, targetLang);

        /**
         * CLI Option case 3: test src with target and exit options
         * a) if no target language
         *    a.1) more than 1 source parser => error and exit
         *    a.2) exactly 1 source parser => load parser options, do exit options, exit
         *    => a.3 doesn't exist, at least 1 parser is supporting the source language!
         * b) if target language
         *    b.1) if supported by exactly 1 possible mapping (source parser), then load options and do exit options, exit
         *    b.2) if supported by more than 1 source parser => error and exit
         */
        if(targetLang.tsIsType(TEnum.TS_NULL)){
        	//a.1 - not target and multiple source parsers = decision problem
        	if(sourceParsers.size()>1){
        		String msg="source language <"+sourceLang+"> supported by <"+sourceParsers.size()+"> parsers and no target language set";
        		this.repMgr.error(msg);
        		TSError ret=new TSError();
    			ret.tsSetMessage(msg);
    			return ret;
        	}
        	//a.2 - no target and 1 source parser, if exit Options then do, otherwise nothing
        	else if(this.eo.size()>0){
        		checkRet=TribeHelpers.loadParserOptions(sourceParsers.get(0), this.cli);
    			if(checkRet.tsIsType(TEnum.TS_ERROR)){
    				this.repMgr.error(checkRet.toString());
    				return checkRet;
    			}
        		this.setOptions(args);
        		this.prop=sourceParsers.get(0).getConfiguration().getProperties().tsCopyComposite();
       			System.out.println(this.doExitOptions());
       			TSWarning ret=new TSWarning();
				ret.tsSetMessage("exit options selected, printed");
				return ret;   			
        	}
        }
        //b
        else{
        	//b.1 - target lang set, 1 target parser selected = if exit Options do, otherwise nothing
        	if(targetParsers.size()==1){
        		if(this.eo.size()>0){
        			checkRet=TribeHelpers.loadParserOptions(targetParsers.get(0), this.cli);
        			if(checkRet.tsIsType(TEnum.TS_ERROR)){
        				this.repMgr.error(checkRet.toString());
        				return checkRet;
        			}
        			this.setOptions(args);
        			//this.parser=targetParsers.get(0);
        			this.prop=targetParsers.get(0).getConfiguration().getProperties().tsCopyComposite();
        			System.out.println(this.doExitOptions());
        			TSWarning ret=new TSWarning();
    				ret.tsSetMessage("exit options selected, printed");
    				return ret;
        		}
        	}
        	//b.2 - target lang set, multiple target parsers available, print error
        	else{
        		String msg="target language <"+targetLang+"> supported by <"+targetParsers.size()+"> parsers for source language <"+sourceLang+">";
        		this.repMgr.error(msg);
        		TSError ret=new TSError();
				ret.tsSetMessage(msg);
				return ret;
        	}
        }

        /**
         * CLI Option case 4: code generation is selected but no target language given
         * - print error
         */
        Boolean gc=((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionGC)).tsvalue;
        if(gc==true&&targetParsers.size()==0){
        	String msg="code generation activated but no target language given";
        	this.repMgr.error(msg);
        	TSError ret=new TSError();
			ret.tsSetMessage(msg);
			return ret;
        }

        /**
         * CLI Option case 5: test src with target and exit options
         * - we have a parser selected, and all exit options are processed, now we need an source file or we can't proceed
         */
        if (this.prop.getValue(FieldKeys.fieldCliOptionSrcFile).tsIsType(TEnum.TS_NULL)||this.prop.getValue(FieldKeys.fieldCliOptionSrcFile).toString().equals("")){
        	String msg="no source file specified";
        	this.repMgr.error(msg);
        	TSError ret=new TSError();
			ret.tsSetMessage(msg);
			return ret;
        }

        /**
         * we now have either src and !tgt and 1 parser or src&tgt and 1 parser and no further exit options. finished then.
         */
        if(targetParsers.size()==1){
        	this.parser=targetParsers.get(0);
        }
        else if(sourceParsers.size()==1){
        	this.parser=sourceParsers.get(0);
        }
        else{
        	//oops, we should not have this case, that sourceParser and targetParser have more/less than 1 member
        	String msg="PANIC, Problem with parser selection";
        	this.repMgr.error(msg);
        	TSError ret=new TSError();
			ret.tsSetMessage(msg);
			return ret;
        }

        /**
         * the final action - transfer all options to the selected parser's configuration and re-check command line parameters for it as well
         */
        checkRet=TribeHelpers.loadParserOptions(this.parser, this.cli);
		if(checkRet.tsIsType(TEnum.TS_ERROR)){
			this.parser.getConfiguration().getReportManager().error(checkRet.toString());
			return checkRet;
		}

        logger.trace("finshed phase 1 -- tribe");
		return new TSNull();
	}

	/**
	 * Realises the parser specific option processing and finally calls the parser
	 * @return TSNull if everything was ok, TSError or TSWarning otherwise
	 */
	private TSDefault phase2_Parser(){
		logger.trace("starting phase 2 -- parser");

		/**
		 * first, set everything for the report manager
		 */
		this.repMgr.doErrors(((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionNoErrors)).tsvalue);
		this.repMgr.doWarnings(((TSBoolean)this.prop.getValue(FieldKeys.fieldCliOptionNoWarnings)).tsvalue);

		/**
         * Test the source and target files (including directories) by mean of:
         * - source file exists (check simple access and then classpath)
         * - target directory and target file can be written into
         */
        try {
			String sourceFile=this.prop.getValue(FieldKeys.fieldCliOptionSrcFile).toString();
        	File fnTest;
        	fnTest=new File(sourceFile);
        	if(fnTest.canRead()==false){
        		URL url=ClassLoader.getSystemResource(sourceFile);
        		if(url==null){
        			String msg="can't open source file <" + sourceFile + "> for reading (tried URL from getSystemResource)";
        			this.repMgr.error(msg);
        			TSError ret=new TSError();
        			ret.tsSetMessage(msg);
        			return ret;
        		}
        		fnTest=new File(url.getFile());
        		if(fnTest.canRead()==false){
        			String msg="can't open source file <" + sourceFile + "> for reading (tried to read from URL)";
        			this.repMgr.error(msg);
        			TSError ret=new TSError();
        			ret.tsSetMessage(msg);
        			return ret;
        		}
				this.prop.put(FieldKeys.fieldCliOptionSrcFile, FieldKeys.fieldValueCli, fnTest.getAbsolutePath());
        	}

        	TSBaseAPI ata=this.prop.getValue(FieldKeys.fieldCliOptionGC);
        	if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==true){
        		fnTest=new File(this.prop.getValue(FieldKeys.fieldCliOptionTgtDir).toString());
        		if(fnTest.canWrite()==false){
        			String msg="can't write in target directory <" + this.prop.getValue(FieldKeys.fieldCliOptionTgtDir) + ">";
        			this.repMgr.error(msg);
        			TSError ret=new TSError();
        			ret.tsSetMessage(msg);
        			return ret;
        		}
        		fnTest=new File(this.prop.getValue(FieldKeys.fieldCliOptionTgtDir)+"/"+this.prop.getValue(FieldKeys.fieldCliOptionTgtFile)+this.prop.getValue(FieldKeys.fieldCliOptionTgtFileExt));
        		fnTest.createNewFile();
        		if(fnTest.canWrite()==false){
        			String msg="can't open target file <" + this.prop.getValue(FieldKeys.fieldCliOptionTgtDir)+"/"+this.prop.getValue(FieldKeys.fieldCliOptionTgtFile)+prop.getValue(FieldKeys.fieldCliOptionTgtFileExt) + "> for writing";
        			this.repMgr.error(msg);
        			TSError ret=new TSError();
        			ret.tsSetMessage(msg);
        			return ret;
        		}
				fnTest.delete();
        	}
        }catch(Exception e){
        	this.repMgr.error(e.toString());
		}

        /**
         * Rock'n roll. Create an input stream and (if requested) the preprocessor, finally hand over the stream to
         * the language parser.
         */
        logger.trace("rock'n roll, creating input stream");
        try{
        	InputStream tribeIS;
        	TSBaseAPI ata=this.prop.getValue(FieldKeys.fieldCliOptionNoCPP);
        	if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BOOLEAN)&&((TSBoolean)ata).tsvalue==false){
        		logger.trace("use build-in cpp");
        		File temp=File.createTempFile("_tribe", "cpp");
        		temp.deleteOnExit();
				PrintWriter pw=new PrintWriter(new FileWriter(temp));
				CPP prep=new CPP();
				prep.parse_initial(this.prop.getValue(FieldKeys.fieldCliOptionSrcFile).toString(), pw);
				logger.trace("finished cpp, create input stream");
				tribeIS=new FileInputStream(temp);
			}
        	else{
				logger.trace("no cpp requested, create input stream");
				tribeIS=new FileInputStream(this.prop.getValue(FieldKeys.fieldCliOptionSrcFile).toString());
			}
        	logger.trace("calling language.parse");
        	this.parser.parse(tribeIS);
        }
        catch(IOException io){
        	this.repMgr.error("catched exception while parsing", "IOException: " + io.toString());
        }
        catch(Exception e){
        	this.repMgr.error("catched exception while parsing", "Exception: " + e.toString());
        }


        /**
         * Save the current configuration.
         */
        logger.trace("save current configuration, if requested");
        if(!(this.prop.getValueCli(FieldKeys.fieldCliOptionConfigSave)).tsIsType(TEnum.TS_NULL)){
			TSBaseAPI cl=this.prop.getValueCli(FieldKeys.fieldCliOptionConfigSave);
			TSDefault checkRet=this.prop.writeToFile(cl);
			if(checkRet.tsIsType(TEnum.TS_ERROR)){
				this.repMgr.error("tribe: problems writing configuration file<"+cl+">\n  => error message: "+checkRet.tsGetMessage()+"\n  => error explanation: "+checkRet.tsGetExplanation()+"\n  => ...trying to continue");
				return checkRet;
			}
		}

        /**
         * Cleanup, especially remove the temporary files created by the preprocessor.
         */
        logger.trace("finally, garbage collector");
        System.gc();

		logger.trace("finshed phase 2 -- parser");
		return new TSNull();
	}

	/**
	 * Do all options that require Tribe to exit after processing them, such as help or version or
	 * print an stg file.
	 * @return null if no exit option found, a message to be printed otherwise
	 */
	private String doExitOptions(){
		String ret=new String();
		boolean didHead=false;

		if(this.eo.contains(EnumExitOptions.HELP)){
        	ret=TribeHelpers.getHelpPrint(cli, this.prop);
        	didHead=true;
        }

		if(this.eo.contains(EnumExitOptions.VERSION)&&!this.eo.contains(EnumExitOptions.HELP)){
        	ret=TribeHelpers.getVersionPrint(this.prop);
        	didHead=true;
        }

        if(this.eo.contains(EnumExitOptions.LANGUAGES)){
        	if(didHead==false){
        		ret+="\n"+TribeHelpers.getHeaderShortPrint(this.prop);
        		didHead=true;
        	}
        	ret+="\n";
        	ret+=TribeHelpers.getSupportedLangPrint(this.parsers);
        }

        if(this.eo.contains(EnumExitOptions.DEF_OPTIONS)){
        	if(didHead==false){
        		ret+="\n"+TribeHelpers.getHeaderShortPrint(this.prop);
        		didHead=true;
        	}
        	ret+="\n";
			ret+=TribeHelpers.getDefaultOptionsPrint(this.prop);
		}

		if(this.eo.contains(EnumExitOptions.PRINT_STG_REPORTMGR)){
			if(didHead==false){
        		ret+="\n"+TribeHelpers.getVersionPrint(this.prop);
        		didHead=true;
        	}
			ret+="\n";
        	ret+=this.repMgr.stgmToString();
		}		

		if(this.eo.contains(EnumExitOptions.PRINT_STG_TARGET)){
			if(this.parser!=null){
				String stg=this.parser.getTargetStgAsString();
				if(stg.length()>0){
					if(ret!=null)
		        		ret+="\n\n";
		        	else
		        		ret="\n";
					ret+=stg;
				}
			}
		}

		return ret;
	}

	/**
	 * SetOptions, instantiates the command line parser (CLI) and requests to parse the command line. 
	 * CLI parsing is done in two passes, the first one establishing all Tribe options and the second one
	 * looking for specific options of the selected source and target languages.
	 * @param args Command line arguments
	 */
	private void setOptions(String[] args){
		try {
			this.cli.parse(args, true);
        }
        catch(ParseException e){
        	this.repMgr.error(e.getMessage());
       		System.exit(2);
        }

        cli.setOptions(this.prop);
		if(!(this.prop.getValueCli(FieldKeys.fieldCliOptionConfigLoad)).tsIsType(TEnum.TS_NULL)){
			TSBaseAPI cl=(TSString)prop.getValueCli(FieldKeys.fieldCliOptionConfigLoad);
			TSDefault ret=this.prop.loadFromFile(cl);
			if(ret.tsIsType(TEnum.TS_ERROR)){
				this.repMgr.error("tribe: problems loading configuration file<"+cl+">\n  => error message: "+ret.tsGetMessage()+"\n  => error explanation: "+ret.tsGetExplanation()+"\n  => ...trying to continue");
			}
		}
	}
}
