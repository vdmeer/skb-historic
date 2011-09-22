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

package org.skb.util.classic.config;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.classic.misc.Json2Oat;
import org.skb.util.classic.misc.PropertyHandler;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.TSTableRowAPI;
import org.skb.util.composite.util.TSLinkedHashTree;
import org.skb.util.composite.util.TSPropertyMap;

/**
 * Special property map with pre-loaded rows for configurations.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ConfigurationProperties extends TSPropertyMap {
	/** Logger Instance */
	static Logger logger = Logger.getLogger(ConfigurationProperties.class);

	/** To read property pointing to default configuration file */
	public Properties config;

	/**
	 * Class constructor, initialises local fields
	 */
	public ConfigurationProperties(){
		super();
		this._trInit("/org/skb/util/config/load.properties");
	}

	/**
	 * Class constructor, initialises local fields
	 */
	public ConfigurationProperties(String propFN){
		super();
		this._trInit(propFN);
	}

	//TODO: make this a public method, so that we can return errors (remove all println...)
	/**
	 * Initialisation method.
	 */
	private void _trInit(String propFN){
		logger.trace("init -- in");

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
			rows.add(FieldKeys.fieldCliOptionPrStgFileReportMgr);
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
		this.config=ph.load(propFN, ConfigurationProperties.class.getName());
		String cfgFile=this.config.getProperty("org.skb.util.config.jsonfile");

		if(cfgFile==null){
			System.err.println("skb: no configuration file given in properties");
			logger.trace("init -- out > no property for config file set");
			return;
		}

		//TODO check if cfgFile exists as URL or FILE

		Json2Oat j2o=new Json2Oat();
		TSBaseAPI c=j2o.read(this.config.getProperty("org.skb.util.config.jsonfile"));
		TSLinkedHashTree cfg=null;
		if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			cfg=(TSLinkedHashTree)c;
		if(cfg==null){
			System.err.println("skb: configuration not found");
			logger.trace("init -- out > no configuration file found");
			return;
		}
		this.loadFromJason(((TSLinkedHashTree)cfg.get("configuration")));
		this.put(FieldKeys.fieldApplicationDirectory, FieldKeys.fieldValueDefault, System.getProperty("user.dir")+System.getProperty("file.separator"));
		this.put(FieldKeys.fieldCliOptionTgtDir, FieldKeys.fieldValueDefault, System.getProperty("user.dir"));

		logger.trace("init -- out");
	}

	@Override
	public ConfigurationProperties tsCopyComposite(){
		ConfigurationProperties ret=new ConfigurationProperties();
		String key;
		Set<String> o_set=(Set<String>)this.tsvalue.keySet();
		Iterator<String> key_it=o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			ret.tsvalue.put(key, (TSTableRowAPI)this.tsvalue.get(key).tsCopyComposite());
		}
		ret.columns=new HashSet<String>(this.columns);
		ret.columnsInitialised=this.columnsInitialised;
		return ret;
	}
}
