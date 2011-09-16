package org.skb.util.config;

import java.util.LinkedHashMap;

public class ConfigManager {
	private LinkedHashMap<Class<?>, Configuration> configurations;


	/**
	 * Singleton instance holder
	 */
	private static class ConfigManagerHolder{
		private final static ConfigManager INSTANCE = new ConfigManager();
	}


	/**
	 * Singleton getInstance
	 * @return pointer to the TribeProperty instance
	 */
	public static ConfigManager getInstance(){
		return ConfigManagerHolder.INSTANCE;
	}


	private ConfigManager(){
		this.configurations=new LinkedHashMap<Class<?>, Configuration>();
	}


	public Configuration getConfiguration(Class<?> clazz){
		if(!this.configurations.containsKey(clazz)){
			this.configurations.put(clazz, new Configuration(clazz));
		}
		return this.configurations.get(clazz);
	}
}
