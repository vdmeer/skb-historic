package org.skb.kb;

public final class SKBInit {

	public static boolean init(){
		boolean ret=false;

		try{
			@SuppressWarnings("unused")
			SKB mySKB=SKB.getInstance();
			ret=true;
		}
		catch(Exception e){
			System.err.println("SKBInit exception initialising SKB and SKBDataManager\n"+e);
		}
		try{
			SKB mySKB=SKB.getInstance();
			mySKB.load_core_packages();
		}
		catch(Exception e){
			System.err.println("SKBInit exception loading core packages\n"+e);
		}
		return ret;
	}
}
