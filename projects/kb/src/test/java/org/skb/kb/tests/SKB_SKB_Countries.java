package org.skb.kb.tests;

import org.skb.base.classic.patterns.creational.builder.Request;
import org.skb.kb.SKB;
import org.skb.kb.SKBInit;
import org.skb.kb.SKBReader;

public class SKB_SKB_Countries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SKBInit.init();
		SKB mySKB=SKB.getInstance();

		mySKB.requirePackage("dist.geo");

		Request def=mySKB.getRequest("Core.Default");
		def.initPlain();
		def.activate();

		SKBReader r=mySKB.getReader("Dist.Geo.Countries.DB2Entries");
//		SKBBuilder b=mySKB.getBuilder("Dist.Acronyms.Entries2LaTeX-Table"); 

//		r.set_builder(b);
		r.prepare(def);
//		r.execute(def);

		System.err.println(r.getEntries());
	}
}
