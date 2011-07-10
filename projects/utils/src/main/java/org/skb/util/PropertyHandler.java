package org.skb.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

	public PropertyHandler(){
		
	}

	public Properties load(String file, String callee){
		Properties l=new Properties();
		try{
			l.load(getClass().getResourceAsStream(file));
		}
		catch (IOException e){
			System.err.println(callee+" cant' load property file <"+file+">, IOException");
			e.printStackTrace();
		}
		catch (Exception e){
			System.err.println(callee+" cant' load property file <"+file+">, general Exception");
			e.printStackTrace();
		}
		return l;
	}
}
