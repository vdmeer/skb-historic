package org.skb.test.util.composite.db;

import junit.framework.TestCase;

import org.junit.Test;

public class PDOTest extends TestCase {
	public void setUp(){
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PDOTest.class);
    }


	//TODO - test for Constructors
	//TODO - test for tsClean


	@Test public void testPDO(){
		assertTrue("PDO has no specific test assigned", true);
	}
}
