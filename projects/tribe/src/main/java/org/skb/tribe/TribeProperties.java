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

import java.util.Properties;

import org.apache.log4j.Logger;
import org.skb.types.composite.util.OatMapLH;
import org.skb.types.composite.util.OatPropertyMap;
import org.skb.util.Json2Oat;
import org.skb.util.PropertyHandler;

/**
 * Singleton class maintaining all properties of the Tribe system.
 *
 * @author     Sven van der Meer
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class TribeProperties extends OatPropertyMap {
	static Logger logger = Logger.getLogger("org.skb.tribe.Tribe");

	/**
	 * TribeProperty external configurations
	 */
	public Properties config;

	/**
	 * TribeProperty Key for the programme name
	 */
	public final static String tpmKeyName				= "name";

	/**
	 * TribeProperty Key for the programme name, all characters lower case
	 */
	public final static String tpmKeyNameLC				= "name-lc";

	/**
	 * TribeProperty Key for copyright notices
	 */
	public final static String tpmKeyCopyright			= "copyright";

	/**
	 * TribeProperty Key for referencing software used to build the programme
	 */
	public final static String tpmKeyBuildWith			= "build-with";

	/**
	 * TribeProperty Key for additional comments in the help screen
	 */
	public final static String tpmKeyAdditional			= "additional";

	/**
	 * TribeProperty Key for the programme version number
	 */
	public final static String tpmKeyVersion			= "version";

	/**
	 * TribeProperty Key for the programme build number
	 */
	public final static String tpmKeyBuild				= "build";

	/**
	 * TribeProperty Key for the programme build date
	 */
	public final static String tpmKeyBuildDate			= "build-date";

	/**
	 * TribeProperty Key for the user directory
	 */
	public final static String tpmKeyUserDir			= "user-dir";

	/**
	 * TribeProperty Key to evaluate CLI command to show version information
	 */
	public final static String tpmKeyShowVersion		= "show-version";

	/**
	 * TribeProperty Key to evaluate CLI command to show help information
	 */
	public final static String tpmKeyShowHelp			= "show-help";

	/**
	 * TribeProperty Key to evaluate CLI command to show information about supported languages
	 */
	public final static String tpmKeyShowLanguages		= "show-languages";

	/**
	 * TribeProperty Key to evaluate CLI command to load a configuration
	 */
	public final static String tpmKeyCfgLoad			= "cfg-load";

	/**
	 * TribeProperty Key to evaluate CLI command to save a configuration
	 */
	public final static String tpmKeyCfgSave			= "cfg-save";

	/**
	 * TribeProperty Key to evaluate CLI command to show default options
	 */
	public final static String tpmKeyDefaultOptions		= "default-options";

	/**
	 * TribeProperty Key to evaluate CLI command to show language
	 */
	public final static String tpmKeyLanguages			= "languages";

	/**
	 * TribeProperty Key to evaluate CLI command to print the template used by ReportManager
	 */
	public final static String tpmKeyReportManagerStg	= "repmgr-stg";

	/**
	 * TribeProperty Key to evaluate CLI command to print the template used by Tribe
	 */
	public final static String tpmKeyPrStgFileTribe		= "pr-stg-tribe";

	/**
	 * TribeProperty Key to evaluate CLI command to print the template used for the selected target language
	 */
	public final static String tpmKeyPrStgFileTarget	= "pr-stg-target";

	/**
	 * TribeProperty Key to evaluate CLI command activating no warnings
	 */
	public final static String tpmKeyNoWarnings			= "no-warnings";

	/**
	 * TribeProperty Key to evaluate CLI command activating no errors
	 */
	public final static String tpmKeyNoErrors			= "no-errors";

	/**
	 * TribeProperty Key to evaluate CLI command de-activating preprocessor
	 */
	public final static String tpmKeyNoCPP				= "no-cpp";

	/**
	 * TribeProperty Key to evaluate CLI command de-activating all output (quiet)
	 */
	public final static String tpmKeyQuietMode			= "be-quiet";

	/**
	 * TribeProperty Key to evaluate CLI command activating code generation
	 */
	public final static String tpmKeyGC					= "gc";

	/**
	 * TribeProperty Key to evaluate CLI command changing the scope separator for code generation
	 */
	public final static String tpmKeyGCScopeSep			= "gc-scope-sep";

	/**
	 * TribeProperty Key to evaluate CLI command setting the source language
	 */
	public final static String tpmKeySrcLanguage		= "src-lang";

	/**
	 * TribeProperty Key to evaluate CLI command setting the source file
	 */
	public final static String tpmKeySrcFile			= "src-file";

	/**
	 * TribeProperty Key to evaluate CLI command setting the target language
	 */
	public final static String tpmKeyTgtLanguage		= "tgt-lang";

	/**
	 * TribeProperty Key to evaluate CLI command setting the target directory (for code generation)
	 */
	public final static String tpmKeyTgtDir				= "tgt-dir";

	/**
	 * TribeProperty Key to evaluate CLI command setting the target file extension (for code generation)
	 */
	public final static String tpmKeyTgtFileExt			= "tgt-fileext";

	/**
	 * TribeProperty Key to evaluate CLI command setting the target file (for code generation)
	 */
	public final static String tpmKeyTgtFile			= "tgt-file";

	/**
	 * TribeProperty Key to evaluate CLI command setting the template for the target language (for code generation)
	 */
	public final static String tpmKeyTgtStg				= "tgt-stg";

	/**
	 * TribeProperty Key to evaluate CLI command activating angle-brackets for target language template
	 */
	public final static String tpmKeyTgtStgAngleBr		= "tgt-stg-angle-br";

	/**
	 * TribeProperty Key to locate a generic STG file with header templates
	 */
	public final static String tpmKeyGenericSTG         = "tribe-generic-stg";

	//public final static String tpmKeyTgSplitCode		= "tgt-split-code";

	private static class TribePropertiesHolder{
		private final static TribeProperties INSTANCE = new TribeProperties();
	}

	/**
	 * Singleton getInstance
	 * @return pointer to the TribeProperty instance
	 */
	public static TribeProperties getInstance(){
		return TribePropertiesHolder.INSTANCE;
	}

	private TribeProperties(){
		super();
		logger.trace("init -- in");

		this.addRows(TribeProperties.class.getName(), "tpmKey");

		PropertyHandler ph=new PropertyHandler();
		this.config=ph.load("/org/skb/tribe/tribe.properties", "tribe");
		String cfgFile=this.config.getProperty("org.tribe.config.jsonfile");

		if(cfgFile==null){
			System.err.println("tribe: no configuration file given in properties");
			logger.trace("init -- out > no property for config file set");
			return;
		}

		Json2Oat j2o=new Json2Oat();
		OatMapLH config=j2o.read(this.config.getProperty("org.tribe.config.jsonfile")).getValOatMapLH();
		if(config==null){
			System.err.println("tribe: configuration not found");
			logger.trace("init -- out > no configuration file found");
			return;
		}
		else
			this.loadFromJason(config.get("configuration").getValOatMapLH());
		this.put(TribeProperties.tpmKeyUserDir, OatPropertyMap.pmValValueDefault, System.getProperty("user.dir")+System.getProperty("file.separator"));
		this.put(TribeProperties.tpmKeyTgtDir, OatPropertyMap.pmValValueDefault, System.getProperty("user.dir"));

		logger.trace("init -- out");
	}
}
