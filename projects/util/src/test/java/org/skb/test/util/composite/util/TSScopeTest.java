package org.skb.test.util.composite.util;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.util.TSScope;

public class TSScopeTest extends TestCase {
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSScopeTest.class);
    }


	//TODO - test for Constructors
	//TODO - test for lots of stuff

	@Test public void testInitialisation(){
		Object[] o;
		TSScope _t=new TSScope();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC_SCOPE.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_ATOMIC,o[1]);
			assertEquals(TSRepository.TString.TS_ATOMIC_SCOPE,o[2]);

		assertEquals(true,_t.tsIsAtomic());
		assertEquals(false,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_ATOMIC_SCOPE,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_ATOMIC_SCOPE,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC_SCOPE));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC_SCOPE));
	}

}
