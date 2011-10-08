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

package org.skb.base.config;

import org.skb.base.FieldKeys;
import org.skb.base.PathKeys;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.antlr.TSSTGroupManager;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.composite.util.TSLangRuleMap;
import org.skb.base.composite.util.TSLinkedHashTree;

/**
 * Configuration class, maintains configuration information for a specific class.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Configuration {
	/** Class name for the Configuration */
	private String configClass=null;

	/** The configuration map, use {@link FieldKeys} and {@link PathKeys} to access information */
	public TSLinkedHashTree config=null;

	/**
	 * Class constructor, initialises local fields and sets class name
	 * @param clazz name of the class the Configuration serves
	 */
	public Configuration(Class<?> clazz){
		this.configClass=clazz.toString();
		this.init();
	}

	/**
	 * Initialises the configuration, resets all local fields (except configClass)
	 */
	public void init(){
		this.config=new TSLinkedHashTree();
		this.config.put(PathKeys.pathInstancesProperties, new ConfigurationProperties());
		this.config.put(PathKeys.pathInstancesReportmanager, new TSReportManager());
	}

	/**
	 * Initialises the configuration, resets all local fields (except configClass)
	 */
	public void init(String propFN){
		this.config=new TSLinkedHashTree();
		this.config.put(PathKeys.pathInstancesProperties, new ConfigurationProperties(propFN));
		this.config.put(PathKeys.pathInstancesReportmanager, new TSReportManager());
	}

	/**
	 * Returns a configuration object for a class name
	 * @param clazz class name identifying the configuration object
	 * @return configuration object
	 */
	public static Configuration getConfiguration(Class<?> clazz){
		return ConfigManager.getInstance().getConfiguration(clazz);
	}

	/**
	 * Return the class name that this Configuration serves
	 * @return class name
	 */
	public String getConfigName(){
		return this.configClass;
	}

	/**
	 * Returns the main property map of the configuration.
	 * @return property map
	 */
	public ConfigurationProperties getProperties(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesProperties);
		if(base.tsIsType(TEnum.TS_COMPOSITE_PROPERTY_MAP))
			return (ConfigurationProperties)base;
		return new ConfigurationProperties();
	}

	/**
	 * Returns the report manager of the configuration.
	 * @return report manager
	 */
	public TSReportManager getReportManager(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesReportmanager);
		if(base.tsIsType(TEnum.TS_ATOMIC_REPORTMANAGER))
			return (TSReportManager)base;
		return new TSReportManager();
	}

	/**
	 * Returns the atom list of the configuration.
	 * @return atom list
	 */
	public TSAtomList getAtomlist(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesAtomlist);
		if(base.tsIsType(TEnum.TS_COMPOSITE_LANG_ATOMLIST)){
			return (TSAtomList)base;
		}
		return new TSAtomList();
	}

	/**
	 * Adds an atom list to the configuration.
	 * @return always true
	 */
	public boolean addAtomList(){
		this.config.put(PathKeys.pathInstancesAtomlist, new TSAtomList());
		return true;
	}

	/**
	 * Returns the language rule map of the configuration.
	 * @return language rule map
	 */
	public TSLangRuleMap getLangRuleMap(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesLangrulemap);
		if(base.tsIsType(TEnum.TS_COMPOSITE_LANG_RULEMAP)){
			return (TSLangRuleMap)base;
		}
		return new TSLangRuleMap();
	}

	/**
	 * Adds a language rule map to the configuration.
	 * @return always true
	 */
	public boolean addLangRuleMap(){
		this.config.put(PathKeys.pathInstancesLangrulemap, new TSLangRuleMap());
		return true;
	}

	public boolean addParserRuleManager(TSSTGroupManager gm){
		if(gm!=null)
			this.config.put(PathKeys.pathInstancesParserrulemanager, gm.tsCopyAtomic());
		else
			this.config.put(PathKeys.pathInstancesParserrulemanager, new TSSTGroupManager());
		return true;
	}

	public TSSTGroupManager getParserRuleManager(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesParserrulemanager);
		if(base.tsIsType(TEnum.TS_ATOMIC_STGROUPMANAGER)){
			return (TSSTGroupManager)base;
		}
		return new TSSTGroupManager();
	}

	/**
	 * Returns the configuration information of a specific path.
	 * @param path path name for the configuration information
	 * @return the found configuration information if it is of type TSMapLH, or a new empty TSMapLH
	 */
	public TSLinkedHashTree get(String path){
		TSBaseAPI base=this.config.get(path);
		if(base.tsIsType(TEnum.TS_COMPOSITE_TREE_LH)){
			return (TSLinkedHashTree)base;
		}
		return new TSLinkedHashTree();
	}
}
