package org.skb.kb.tests;

import org.skb.kb.SKB;
import org.skb.kb.SKBBuilder;
import org.skb.kb.SKBInit;
import org.skb.kb.SKBReader;
import org.skb.util.pattern.Request;

public class SKB_SKBInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SKBInit.init();
		SKB mySKB=SKB.getInstance();

		mySKB.requirePackage("core.skbinfo");
		mySKB.requirePackage("dist.acronyms");
		mySKB.requirePackage("dist.geo");
		mySKB.requirePackage("dist.affiliations");

		mySKB.loadAllSitePackages(null);

		Request def=mySKB.getRequest("Core.Default");
		def.initPlain();
		def.activate();

		SKBReader r=mySKB.getReader("Core.SkbInfo.DB2Entries");
		SKBBuilder b=mySKB.getBuilder("Core.SkbInfo.Entries2Text-Plain");

		r.setBuilder(b);
		r.prepare(def);
		r.execute(def);

		//System.err.println(r.get_entries());
	}
}
