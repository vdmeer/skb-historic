package org.skb.kb.tests;

import org.skb.kb.SKB;
import org.skb.kb.SKBBuilder;
import org.skb.kb.SKBReader;
import org.skb.util.pattern.Request;
import org.skb.util.types.atomic.java.TSString;

public class Tool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
System.out.println("...initial:  ");
		SKB mySKB=SKB.getInstance();
System.out.println("...start:    ");
//Date d=new Date();
//System.out.println(d.getTime());

//		mySKB.requirePackage("core.skbinfo");
		mySKB.requirePackage("dist.acronyms");
//		mySKB.requirePackage("dist.geo");
//		mySKB.requirePackage("dist.affiliations");
//mySKB.loadAllSitePackages(null);

		Request def=mySKB.getRequest("Core.Default");
		def.initPlain();
		def.activate();

		def.setValue("request:entry", new TSString("readers"));

		SKBReader r=mySKB.getReader("Dist.Acronyms.DB2Entries");
		SKBBuilder b=mySKB.getBuilder("Dist.Acronyms.Entries2Text-Plain"); 
			//Dist.Acronyms.Entries2LaTeX-Acronym
			//Dist.Acronyms.Entries2LaTeX-Table
			//Dist.Acronyms.Entries2Text-Plain

//		SKBReader r=mySKB.getReader("Core.SkbInfo.DB2Entries");
//		SKBBuilder b=mySKB.getBuilder("Core.SkbInfo.Entries2Text-Plain");

		r.set_builder(b);
		r.prepare(def);
		r.execute(def);

//System.err.println(r.get_entries());

//d=new Date();
//System.out.println(d.getTime());

System.out.println("...finished: ");
	}
}
