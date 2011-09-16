package org.skb.util.config;

import org.skb.util.PathKeys;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.misc.TSReportManager;
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
		this.config.put(PathKeys.pathConfigurationProperties, new ConfigurationProperties());
		this.config.put(PathKeys.pathConfigurationReportmanager, new TSReportManager());
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
		TSBaseAPI base=this.config.get(PathKeys.pathConfigurationProperties);
		if(base.tsIsType(TEnum.TS_COMPOSITE_PROPERTY_MAP))
			return (ConfigurationProperties)base;
		else
			return new ConfigurationProperties();
	}


	public TSReportManager getReportManager(){
		TSBaseAPI base=this.config.get(PathKeys.pathConfigurationReportmanager);
		if(base.tsIsType(TEnum.TS_ATOMIC_REPORTMANAGER))
			return (TSReportManager)base;
		else
			return new TSReportManager();
	}
}
