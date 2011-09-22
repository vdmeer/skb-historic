package org.skb.test.util.composite.java;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.java.TSByte;

import junit.framework.TestCase;

public class TSByteTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSByteTest.class);
    }

	//TODO - test for Constructors
	//Todo - test for tsClean

	@Test public void testInitialisation(){
		Object[] o;
		TSByte _t=new TSByte();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_BYTE.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_ATOMIC,o[1]);
			assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_BYTE,o[2]);

		assertEquals(true,_t.tsIsAtomic());
		assertEquals(false,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_BYTE,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_BYTE,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_BYTE));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC_JAVA_BYTE));
	}

	@Test public void testTSByteTest(){
		assertTrue("TSByteTest has no specific test assigned", true);
	}
}
