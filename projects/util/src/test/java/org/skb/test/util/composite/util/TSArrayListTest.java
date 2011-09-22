package org.skb.test.util.composite.util;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.util.TSLangRuleMap;

public class TSArrayListTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSArrayListTest.class);
    }

	//TODO - test for Constructors
	//TODO - test for tsClean

	@Test public void testInitialisation(){
		Object[] o;
		TSLangRuleMap _t=new TSLangRuleMap();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TABLE.toString(),o[2].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_LANG_RULEMAP.toString(),o[3].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TABLE,o[2]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_LANG_RULEMAP,o[3]);

		assertEquals(false,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_COMPOSITE_LANG_RULEMAP,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_COMPOSITE_LANG_RULEMAP,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TABLE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_LANG_RULEMAP));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TABLE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_LANG_RULEMAP));
	}
}
