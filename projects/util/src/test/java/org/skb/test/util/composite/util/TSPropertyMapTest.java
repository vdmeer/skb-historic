package org.skb.test.util.composite.util;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.util.TSPropertyMap;

public class TSPropertyMapTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSPropertyMapTest.class);
    }

	//TODO - test for Constructors
	//TODO - test for lots of stuff

	@Test public void testInitialisation(){
		Object[] o;
		TSPropertyMap _t=new TSPropertyMap();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLE.toString(),o[2].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_PROPERTY_MAP.toString(),o[3].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TABLE,o[2]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_PROPERTY_MAP,o[3]);

		assertEquals(false,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_COMPOSITE_PROPERTY_MAP,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_COMPOSITE_PROPERTY_MAP,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TABLE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_PROPERTY_MAP));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TABLE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_PROPERTY_MAP));
	}

}
