package org.skb.test.util.composite.util;

import java.util.TreeMap;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.util.TSTableRow;

public class TSTableRowTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSTableRowTest.class);
    }

	//TODO - test for Constructors
	//TODO - test for tsClean

	@Test public void testInitialisation(){
		Object[] o;
		TSTableRow _t=new TSTableRow(new TreeMap<String, TSBaseAPI>());
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLEROW.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TABLEROW,o[2]);

		assertEquals(false,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLEROW,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_COMPOSITE_TABLEROW,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TABLEROW));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TABLEROW));
	}
}
