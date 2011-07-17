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
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.skb.lang.cpp.CPP;
import org.skb.util.cli.Cli;
import org.skb.util.cli.CliApache;
import org.skb.util.misc.ReportManager;
import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.java.OatBoolean;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.base.OatBaseAtomic;
import org.skb.util.types.composite.util.OatPropertyMap;


/**
 * This is the main Tribe class, it does all the magic.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class Tribe {
	private TribeProperties prop;
	private ReportManager repMgr;
	private Cli cli;

	/** Log4 Logger Object */
	public final static Logger logger = Logger.getLogger(Tribe.class);

	/**
	 * Class Constructor initialising the Tribe system, loading <code>TribeProperties</code>, <code>ReportManager</code> and <code>Cli</code> objects.
	 */
	public Tribe(){
		logger.trace("init -- in");
		this.prop=TribeProperties.getInstance();
		this.repMgr=ReportManager.getInstance();
		this.cli=new CliApache();
		logger.trace("init -- out");
	}

	/**
	 * Start parsing with Tribe. Input parameters are the supported languages (string array) and the actual
	 * arguments. 
	 * @param supportedLanguages LanguageParser array containing all information on supported source and target languages.
	 * @param args Command line arguments.
	 */
	public void start (LanguageParser[] supportedLanguages, String[] args){
		logger.trace("start -- in");

		cli.setApplicationName(prop.getValue(TribeProperties.tpmKeyNameLC).getValOatAtomicString());

		/**
		 * Create an object for the supported language and set the property for languages
		 */
		logger.trace("set languages");
		//Languages languages=new Languages(supportedLanguages);
		LanguageList languages=new LanguageList();
		languages.addLanguages(supportedLanguages);
		prop.setValueDefault(TribeProperties.tpmKeyLanguages, languages);

		/**
		 * Get an instance of the report manager, to be able to write output, and give it the standard stg.
		 */
		logger.trace("set report manager");
		repMgr.setApplicationName(prop.getValue(TribeProperties.tpmKeyNameLC).getValOatAtomicString());
		repMgr.setSTGUrlName(prop.get(TribeProperties.tpmKeyReportManagerStg, OatPropertyMap.pmValValueDefault));
		repMgr.loadSTG("Report Manager String Template Group", "");

		/**
		 * Do the first pass of options. This is needed to detect:
		 * - a new TRIBE stg file if requested
		 * - input language if specified
		 * - target language if specified
		 */
		logger.trace("cli propOptions and setOptions pass 1");
		this.cli.setPropOptions(this.prop);
		this.setOptions(args, languages);

		/**
		 * If there is a new stg given, instruct the report manager to load it. Checks on the content of the
		 * new stg file will be handled by the report manager.
		 */
        if (prop.getValueCli(TribeProperties.tpmKeyReportManagerStg)!=null){
        	logger.trace("changed tribe stg");
        	repMgr.setSTGFileName(prop.getValueCli(TribeProperties.tpmKeyReportManagerStg));
        	repMgr.loadSTG("Tribe report stg", "");
        }

        /**
         * Check if the selected source and/or target language are valid. If they are not valid, check
         * if other CLI options still need to be addressed (such as -help or -version). If there are options
         * that result in exit (help, version), doExitOptions will not return! Otherwise we still need to go
         * through the CLI options again, cause that might include other exit options.
         */
        logger.trace("testing source and target languages pass1");
        Boolean gc=false;
        OatString srcLang=new OatString();
        OatString tgtLang=new OatString();
		try {
			gc=((OatBoolean)prop.getValue(TribeProperties.tpmKeyGC)).getValue();
			srcLang=prop.getValue(TribeProperties.tpmKeySrcLanguage).getValOatAtomicString();
			tgtLang=prop.getValue(TribeProperties.tpmKeyTgtLanguage).getValOatAtomicString();
		} catch (Exception e) {}

		if(prop.getValue(TribeProperties.tpmKeySrcLanguage)!=null)
			;
		Boolean ssl=languages.setSelectedLanguage(srcLang, tgtLang, gc);
		this.cli.setPropOptions(this.prop);
		cli.setApplicationName(prop.getValue(TribeProperties.tpmKeyNameLC).getValOatAtomicString());
        if(ssl==false)
			this.doExitOptions(1);

		/**
		 * Second pass of the CLI options, this time including the specific options of the selected source
		 * and/or target languages.
		 */
		logger.trace("cli pass 2");
		this.setOptions(args, languages);

		/**
		 * Now, if we have problems with the selected source and/or target language, exit with an error. 
		 */
		// if we got a language problem earlier, exit now
		logger.trace("testing source and target languages pass2");
		ssl=languages.checkSelectedLanguage();
		if(ssl==false)
			System.exit(3);

		/**
		 * Now do the language specific exit options (such as print an stg).
		 */
		logger.trace("exitOptions pass2");
		this.doExitOptions(2);

		/**
		 * If we do not have any input file, exit now. All other CLI options that do not need an input file need to be processed
		 * before this line!
		 */
		logger.trace("testing input file");
		if (prop.getValue(TribeProperties.tpmKeySrcFile)==null||prop.getValue(TribeProperties.tpmKeySrcFile).toString().equals("")){
        	repMgr.reportError("no input file specified");
        	System.exit(1);
        }

        /**
         * From here on we MUST have all options set via either default, files or CLI! 
         */
		logger.trace("end of option look up, starting processing");

		try {
			repMgr.doErrors(((OatBoolean)this.prop.getValue(TribeProperties.tpmKeyNoErrors)).getValue());
			repMgr.doWarnings(((OatBoolean)this.prop.getValue(TribeProperties.tpmKeyNoWarnings)).getValue());
			repMgr.setProgrammeName(((OatString)this.prop.getValue(TribeProperties.tpmKeyNameLC)).getValue());
		} catch (OatValueIsNullException e1) {}

		/**
         * Everything is set, so start loading the stg for the target file. If the stg should only be printed, print and exit.
         */
		logger.trace("load language stg");
		gc=false;
		Boolean prStgFileTgt=false;
		try {
			gc=((OatBoolean)prop.getValue(TribeProperties.tpmKeyGC)).getValue();
			prStgFileTgt=((OatBoolean)prop.getValue(TribeProperties.tpmKeyPrStgFileTarget)).getValue();
		} catch (Exception e) {}

		if(gc==true){
			languages.loadStg();
			if(prStgFileTgt==true){
				languages.printStg();
				System.exit(0);
			}
		}

        /**
         * Test the source and target files (including directories) by mean of:
         * - source file exists (check simple access and then classpath)
         * - target directory and target file can be written into
         */
        logger.trace("testing source and target files and target directory");
        try {
        	File fnTest;
        	fnTest=new File(prop.getValue(TribeProperties.tpmKeySrcFile).toString());
        	if(fnTest.canRead()==false){
        		URL url=ClassLoader.getSystemResource(prop.getValue(TribeProperties.tpmKeySrcFile).toString());
        		fnTest=new File(url.getFile());
        		if(fnTest.canRead()==false){
        			repMgr.reportError("can't open source file <" + prop.getValue(TribeProperties.tpmKeySrcFile) + "> for reading");
        			System.exit(1);
        		}
        		else
        			prop.put(TribeProperties.tpmKeySrcFile, OatPropertyMap.pmValValueCli, fnTest.getAbsolutePath());
        	}

        	OatBaseAtomic ata=prop.getValue(TribeProperties.tpmKeyGC);
        	if(ata!=null&&ata.isType(ATType.OAT_ATOMIC_BOOLEAN)&&(Boolean)ata.getValue()==true){
        		fnTest=new File(prop.getValue(TribeProperties.tpmKeyTgtDir).toString());
        		if (fnTest.canWrite()==false){
        			repMgr.reportError("can't write in target directory <" + prop.getValue(TribeProperties.tpmKeyTgtDir) + ">");
        			System.exit(1);
        		}
        		fnTest=new File(prop.getValue(TribeProperties.tpmKeyTgtDir)+"/"+prop.getValue(TribeProperties.tpmKeyTgtFile)+prop.getValue(TribeProperties.tpmKeyTgtFileExt));
        		fnTest.createNewFile();
        		if (fnTest.canWrite()==false){
        			repMgr.reportError("can't open target file <" + prop.getValue(TribeProperties.tpmKeyTgtDir)+"/"+prop.getValue(TribeProperties.tpmKeyTgtFile)+prop.getValue(TribeProperties.tpmKeyTgtFileExt) + "> for writing");
        			System.exit(1);
        		}
        		else
        			fnTest.delete();
        	}
        }catch(Exception e){
        	repMgr.reportError(e.toString());
		}

        /**
         * Save the current configuration.
         */
        logger.trace("save current configuration, if requested");
        if(prop.getValueCli(TribeProperties.tpmKeyCfgSave)!=null){
			OatString cl=(OatString)prop.getValueCli(TribeProperties.tpmKeyCfgSave);
//			String _cret="";
			try {
				prop.writeToFile(cl.getValue());
			} catch (Exception e) {}

//			if(_cret!=null)
//				repMgr.reportError(_cret+", trying to continue");


//        	if(sTest!=null)
//        		repMgr.reportError(sTest+", trying to continue");
		}

        /**
         * Rock'n roll. Create an input stream and (if requested) the preprocessor, finally hand over the stream to
         * the language parser.
         */
        logger.trace("rock'n roll, creating input stream");
        try{
        	InputStream tribeIS;
        	OatBaseAtomic ata=prop.getValue(TribeProperties.tpmKeyNoCPP);
        	if(ata!=null&&ata.isType(ATType.OAT_ATOMIC_BOOLEAN)&&(Boolean)ata.getValue()==false){
        		logger.trace("use build-in cpp");
        		File temp=File.createTempFile("_tribe", "cpp");
        	    temp.deleteOnExit();
				PrintWriter pw=new PrintWriter(new FileWriter(temp));
				CPP prep=new CPP();
				prep.parse(prop.getValue(TribeProperties.tpmKeySrcFile).toString(), pw);
				logger.trace("finished cpp, create input stream");
				tribeIS=new FileInputStream(temp);
			}
        	else{
				logger.trace("no cpp requested, create input stream");
				tribeIS=new FileInputStream(prop.getValue(TribeProperties.tpmKeySrcFile).toString());
			}
        	logger.trace("calling language.parse");
        	languages.parse(tribeIS);
        }
        catch(IOException io){
        	repMgr.reportError("catched exception while parsing", "IOException: " + io.toString());
        }
        catch(Exception e){
        	repMgr.reportError("catched exception while parsing", "Exception: " + e.toString());
        }

        /**
         * Cleanup, especially remove the temporary files created by the preprocessor.
         */
        logger.trace("finally, garbage collector");
        System.gc();

        logger.trace("start -- out");
	}

	/**
	 * Do all options that require Tribe to exit after processing them, such as help or version or
	 * print an stg file.
	 * @param pass Pass=1 means and we have to print an stg file, we cannot do that.
	 */
	private void doExitOptions(int pass){
		TribeProperties prop=TribeProperties.getInstance();

        if(pass==1&&prop.getValueCli(TribeProperties.tpmKeyTgtLanguage)!=null)
            return;

        if(pass==1&&prop.getValueCli(TribeProperties.tpmKeySrcLanguage)!=null)
            return;

		ReportManager repMgr=ReportManager.getInstance();

		Boolean defOpt=false;
		try {
			defOpt=((OatBoolean)prop.getValue(TribeProperties.tpmKeyDefaultOptions)).getValue();
		} catch (Exception e) {}
		if(defOpt==true){
			System.out.println("Default Configuration:");
			System.out.println("  [Option] = [Default Configuration]");
			System.out.println();

        	//repMgr.defaults();
			TreeSet<String> ts=new TreeSet<String>(this.prop.getRows());
	        for (Iterator<String> i = ts.iterator(); i.hasNext(); i.hasNext()){
	        	String current=i.next();
	        	if(prop.get(current, OatPropertyMap.pmValCliOptionType)!=null){
	        		if(prop.get(current, OatPropertyMap.pmValValueFile)!=null||prop.get(current, OatPropertyMap.pmValValueCli)!=null)
	        			System.out.println("    "+current+" = "+prop.getValue(current));
	        		else
	        			System.out.println("    "+current+" = "+prop.getValueDefault(current));
	        	}
	        }
        	this.footer();
        	System.exit(0);
        }

		Boolean showHelp=false;
		try {
			showHelp=((OatBoolean)prop.getValue(TribeProperties.tpmKeyShowHelp)).getValue();
		} catch (Exception e) {}

        if(showHelp==true){
        	this.header();
        	this.cli.usage();
        	this.footer();
            System.exit(0);
        }

		Boolean showVersion=false;
		try {
			showVersion=((OatBoolean)prop.getValue(TribeProperties.tpmKeyShowVersion)).getValue();
		} catch (Exception e) {}

        if(showVersion==true){
        	this.header();
        	System.exit(0);
        }

		Boolean showLang=false;
		try {
			showLang=((OatBoolean)prop.getValue(TribeProperties.tpmKeyShowLanguages)).getValue();
		} catch (Exception e) {}

        if(showLang==true){
        	repMgr.reportMessageNoFile("supported languages = " + prop.getValueDefault(TribeProperties.tpmKeyLanguages));
        	System.exit(0);
        }

        if(prop.getValueCli(TribeProperties.tpmKeyPrStgFileTribe)!=null){
        	System.out.println(repMgr.toString());
            System.exit(0);
        }		
	}

	/**
	 * SetOptions, instantiates the command line parser (CLI) and requests to parse the command line. 
	 * CLI parsing is done in two passes, the first one establishing all Tribe options and the second one
	 * looking for specific options of the selected source and target languages.
	 * @param args Command line arguments
	 * @param languages List of languages supported
	 * @param pass The current pass (1 or 2)
	 */
	private void setOptions(String[] args, LanguageList languages){
		try {
			this.cli.parse(args);
        }
        catch(ParseException e){
        	repMgr.reportError(e.getMessage());
        	System.exit(2);
        }

        cli.setOptions(this.prop);

		if(prop.getValueCli(TribeProperties.tpmKeyCfgLoad)!=null){
			OatString cl=(OatString)prop.getValueCli(TribeProperties.tpmKeyCfgLoad);
			String ret=null;
			try {
				ret=prop.loadFromFile(cl.getValue());
			} catch (Exception e) {
				repMgr.reportError("tribe: problems loading configuration file<"+cl+">, trying to continue");
			}
			if(ret!=null)
				repMgr.reportError("tribe: problems loading configuration file<"+cl+">, "+ret+", trying to continue");
		}
	}

	private void header(){
		System.out.println(prop.get(TribeProperties.tpmKeyName, OatPropertyMap.pmValValueDefault)+", version "+
		           prop.get(TribeProperties.tpmKeyVersion, OatPropertyMap.pmValValueDefault)+", build "+
		           prop.get(TribeProperties.tpmKeyBuild, OatPropertyMap.pmValValueDefault)+", "+
		           prop.get(TribeProperties.tpmKeyBuildDate, OatPropertyMap.pmValValueDefault));
		System.out.println(prop.get(TribeProperties.tpmKeyCopyright, OatPropertyMap.pmValValueDefault));
		System.out.println();
		System.out.println(prop.get(TribeProperties.tpmKeyBuildWith, OatPropertyMap.pmValValueDefault));
		System.out.println();
	}
	
	private void footer(){
		System.out.println();
		if(prop.get(TribeProperties.tpmKeyAdditional, OatPropertyMap.pmValValueDefault)!=null){
			System.out.println();
			System.out.println(prop.get(TribeProperties.tpmKeyAdditional, OatPropertyMap.pmValValueDefault).toString());
		}
	}
}