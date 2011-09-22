package org.skb.test.util.composite;

import org.junit.Test;
import org.skb.util.composite.TSNull;
import org.skb.util.composite.TSRepository;

import junit.framework.TestCase;

public class TSNullTest extends TestCase{
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSNullTest.class);
    }

	@Test public void testInitialisation(){
		Object[] o;
		TSNull _t=new TSNull();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(5,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[2].toString());
			assertEquals(TSRepository.TEnum.TS_DEFAULT.toString(),o[3].toString());
			assertEquals(TSRepository.TEnum.TS_NULL.toString(),o[4].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(5,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_ATOMIC,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[2]);
			assertEquals(TSRepository.TString.TS_DEFAULT,o[3]);
			assertEquals(TSRepository.TString.TS_NULL,o[4]);

		assertEquals(true,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_NULL,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_NULL,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_DEFAULT));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_NULL));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_DEFAULT));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_NULL));
	}
}
