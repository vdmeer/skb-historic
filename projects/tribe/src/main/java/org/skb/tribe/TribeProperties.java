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

import java.util.HashSet;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.misc.Json2Oat;
import org.skb.util.misc.PropertyHandler;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;
import org.skb.util.patterns.structural.composite.composite.util.TSPropertyMap;

/**
 * Singleton class maintaining all properties of the Tribe system.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TribeProperties extends TSPropertyMap {
	static Logger logger = Logger.getLogger(TSPropertyMap.class);

	/**
	 * TribeProperty external configurations
	 */
	public Properties config;


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

	/**
	 * Singleton getInstance with default initialisation
	 * @return pointer to the TribeProperty instance
	 */
	public static TribeProperties getInstanceInit(){
		TribePropertiesHolder.INSTANCE._trInit();
		return TribePropertiesHolder.INSTANCE;
	}

	private TribeProperties(){
		super();
		this._trInit();
	}

	private void _trInit(){
		logger.trace("init -- in");

		//this.addRows(TribeProperties.class.getName(), "tpmKey");
		HashSet<String> rows=new HashSet<String>();
			rows.add(FieldKeys.fieldApplicationName);
			rows.add(FieldKeys.fieldApplicationCopyright);
			rows.add(FieldKeys.fieldApplicationBuildwith);
			rows.add(FieldKeys.fieldApplicationAdditional);
			rows.add(FieldKeys.fieldApplicationVersion);
			rows.add(FieldKeys.fieldApplicationBuild);
			rows.add(FieldKeys.fieldApplicationBuilddate);
			rows.add(FieldKeys.fieldApplicationDirectory);
			rows.add(FieldKeys.fieldCliOptionShowversion);
			rows.add(FieldKeys.fieldCliOptionShowhelp);
			rows.add(FieldKeys.fieldCliOptionShowlang);
			rows.add(FieldKeys.fieldCliOptionConfigLoad);
			rows.add(FieldKeys.fieldCliOptionConfigSave);
			rows.add(FieldKeys.fieldCliOptionDefaultOptions);
			rows.add(FieldKeys.fieldCliOptionLanguages);
			rows.add(FieldKeys.fieldCliOptionReportManagerStg);
			rows.add(FieldKeys.fieldCliOptionPrStgFileTribe);
			rows.add(FieldKeys.fieldCliOptionPrStgFileTarget);
			rows.add(FieldKeys.fieldCliOptionNoWarnings);
			rows.add(FieldKeys.fieldCliOptionNoErrors);
			rows.add(FieldKeys.fieldCliOptionNoCPP);
			rows.add(FieldKeys.fieldCliOptionQuietMode);
			rows.add(FieldKeys.fieldCliOptionGC);
			rows.add(FieldKeys.fieldCliOptionGCScopeSep);
			rows.add(FieldKeys.fieldCliOptionSrcLanguage);
			rows.add(FieldKeys.fieldCliOptionSrcFile);
			rows.add(FieldKeys.fieldCliOptionTgtLanguage);
			rows.add(FieldKeys.fieldCliOptionTgtDir);
			rows.add(FieldKeys.fieldCliOptionTgtFileExt);
			rows.add(FieldKeys.fieldCliOptionTgtFile);
			rows.add(FieldKeys.fieldCliOptionTgtStg);
			rows.add(FieldKeys.fieldApplicationTgtStgAngleBr);
			rows.add(FieldKeys.fieldApplicationGenericSTG);
			rows.add(FieldKeys.fieldCliOptionTgSplitCode);
		this.addRows(rows);

		PropertyHandler ph=new PropertyHandler();
		this.config=ph.load("/org/skb/tribe/tribe.properties", "tribe");
		String cfgFile=this.config.getProperty("org.tribe.config.jsonfile");

		if(cfgFile==null){
			System.err.println("tribe: no configuration file given in properties");
			logger.trace("init -- out > no property for config file set");
			return;
		}

		Json2Oat j2o=new Json2Oat();
		TSBaseAPI c=j2o.read(this.config.getProperty("org.tribe.config.jsonfile"));
		TSMapLH config=null;
		if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			config=(TSMapLH)c;
		if(config==null){
			System.err.println("tribe: configuration not found");
			logger.trace("init -- out > no configuration file found");
			return;
		}
		else
			this.loadFromJason(((TSMapLH)config.get("configuration")));
		this.put(FieldKeys.fieldApplicationDirectory, FieldKeys.fieldValueDefault, System.getProperty("user.dir")+System.getProperty("file.separator"));
		this.put(FieldKeys.fieldCliOptionTgtDir, FieldKeys.fieldValueDefault, System.getProperty("user.dir"));

		logger.trace("init -- out");
	}
}
