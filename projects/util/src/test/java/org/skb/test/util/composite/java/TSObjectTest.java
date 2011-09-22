package org.skb.test.util.composite.java;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.java.TSObject;

public class TSObjectTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSObjectTest.class);
    }

	//TODO - test for Constructors
	//TODO - test for tsClean

	@Test public void testInitialisation(){
		Object[] o;
		TSObject _t=new TSObject();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_OBJECT.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_ATOMIC,o[1]);
			assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_OBJECT,o[2]);
		
		assertEquals(true,_t.tsIsAtomic());
		assertEquals(false,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_OBJECT,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_OBJECT,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_OBJECT));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC_JAVA_OBJECT));
	}

	@Test public void testTSObject(){
		assertTrue("TSObject has no specific test assigned", true);
	}
}
