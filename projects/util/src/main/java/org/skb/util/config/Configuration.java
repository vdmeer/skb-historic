package org.skb.util.config;

import org.skb.util.PathKeys;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.lang.TSAtomList;
import org.skb.util.patterns.structural.composite.atomic.misc.TSReportManager;
import org.skb.util.patterns.structural.composite.composite.util.TSLangRuleMap;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

public class Configuration {
	/** Class name for the Configuration */
	private String configClass=null;

	/** The configuration map, use FieldKeys and PathKeys to access information */
	public TSMapLH config=null;


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
		this.config=new TSMapLH();
		this.config.put(PathKeys.pathInstancesProperties, new ConfigurationProperties());
		this.config.put(PathKeys.pathInstancesReportmanager, new TSReportManager());
	}


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


	public ConfigurationProperties getProperties(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesProperties);
		if(base.tsIsType(TEnum.TS_COMPOSITE_PROPERTY_MAP))
			return (ConfigurationProperties)base;
		else
			return new ConfigurationProperties();
	}


	public TSReportManager getReportManager(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesReportmanager);
		if(base.tsIsType(TEnum.TS_ATOMIC_REPORTMANAGER))
			return (TSReportManager)base;
		else
			return new TSReportManager();
	}


	public TSAtomList getAtomlist(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesAtomlist);
		if(base.tsIsType(TEnum.TS_ATOMIC_LANG_ATOMLIST)){
			return (TSAtomList)base;
		}
		else{
			return new TSAtomList();
		}
	}


	public boolean addAtomList(){
		this.config.put(PathKeys.pathInstancesAtomlist, new TSAtomList());
		return true;
	}


	public TSLangRuleMap getLangRuleMap(){
		TSBaseAPI base=this.config.get(PathKeys.pathInstancesLangrulemap);
		if(base.tsIsType(TEnum.TS_COMPOSITE_LANG_RULEMAP)){
			return (TSLangRuleMap)base;
		}
		else{
			return new TSLangRuleMap();
		}
	}

	public boolean addLangRuleMap(){
		this.config.put(PathKeys.pathInstancesLangrulemap, new TSLangRuleMap());
		return true;
	}


	public TSMapLH get(String path){
		TSBaseAPI base=this.config.get(path);
		if(base.tsIsType(TEnum.TS_COMPOSITE_MAP_LH)){
			return (TSMapLH)base;
		}
		else{
			return new TSMapLH();
		}
	}
}
