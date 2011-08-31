package org.skb.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogManager {
	public static void init(){
		Logger logger=Logger.getLogger(LogManager.class);
		String fn=System.getenv("SKB_LOG4_CONFIG_XML");
		if(fn!=null&&fn.length()>0){
			DOMConfigurator.configure(fn);
			logger.info("initialised Logger from environment with <"+fn+">");
		}
		else{
			fn="/org/skb/util/log/log4j.xml";
			DOMConfigurator.configure(LogManager.class.getResource(fn));
			logger.info("initialised Logger from default with <"+fn+">");
		}
	}
}
