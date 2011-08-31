package org.skb.kb;

import org.apache.log4j.Logger;
import org.skb.util.log.LogManager;

public final class SKBInit {
	static Logger logger;

	public static boolean init(){
		LogManager.init();
		logger=Logger.getLogger(SKBInit.class);

		boolean ret=false;
		try{
			logger.trace("creating first SKB instance");
			@SuppressWarnings("unused")
			SKB mySKB=SKB.getInstance();
			ret=true;
		}
		catch(Exception e){
			System.err.println("SKBInit exception initialising SKB and SKBDataManager\n"+e);
		}
		try{
			logger.trace("loading SKB core packages");
			SKB mySKB=SKB.getInstance();
			mySKB.load_core_packages();
		}
		catch(Exception e){
			System.err.println("SKBInit exception loading core packages\n"+e);
		}

		logger.trace("return ("+ret+")");
		return ret;
	}
}
