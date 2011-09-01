package org.skb.kb.tests;

import org.skb.kb.SKB;
import org.skb.kb.SKBBuilder;
import org.skb.kb.SKBInit;
import org.skb.kb.SKBReader;
import org.skb.util.pattern.Request;

public class SKB_Acronyms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SKBInit.init();
		SKB mySKB=SKB.getInstance();

		mySKB.requirePackage("dist.acronyms");

		Request def=mySKB.getRequest("Core.Default");
		def.initPlain();
		def.activate();

		SKBReader r=mySKB.getReader("Dist.Acronyms.DB2Entries");
		SKBBuilder b=mySKB.getBuilder("Dist.Acronyms.Entries2LaTeX-Table"); 
			//Dist.Acronyms.Entries2LaTeX-Acronym
			//Dist.Acronyms.Entries2LaTeX-Table
			//Dist.Acronyms.Entries2Text-Plain

		r.set_builder(b);
		r.prepare(def);
		r.execute(def);

//System.err.println(r.get_entries());
	}
}
