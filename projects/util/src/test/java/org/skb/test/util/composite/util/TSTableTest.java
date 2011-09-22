package org.skb.test.util.composite.util;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.util.TSTable;

public class TSTableTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSTableTest.class);
    }

	//TODO - test for Constructors
	//TODO - test for tsClean

	@Test public void testInitialisation(){
		Object[] o;
		TSTable _t=new TSTable();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLE.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TABLE,o[2]);

		assertEquals(false,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLE,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_COMPOSITE_TABLE,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TABLE));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TABLE));
	}


}
