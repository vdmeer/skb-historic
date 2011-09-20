package org.skb.test.util.types.atomic.java;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSLinkedHashTree;

public class TSStringTest extends TestCase{
	public void setUp(){
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSStringTest.class);
    }


	//TODO - test for tsAddCharWBlank
	//TODO - test for tsAddFirstChar
	//TODO - test for Constructors
	//TODO - test for tsClean
	//TODO - test for tsTrim


	@Test public void testTsAddChar(){
		java.lang.String result;
		//Returns the specified character if the specified string is non-empty and does not end with the specified character nor a blank; "" otherwise

		result=TSString.tsAddChar(new TSString("test/"), "/");
		assertEquals("", result);

		result=TSString.tsAddChar(new TSString("test "), "/");
		assertEquals("", result);

		result=TSString.tsAddChar(new TSString("test/ "), "/");
		assertEquals("", result);

		result=TSString.tsAddChar(new TSString("test"), "/");
		assertEquals("/", result);

		result=TSString.tsAddChar(new TSString(" "), "/");
		assertEquals("", result);

		result=TSString.tsAddChar(null, "/");
		assertEquals("", result);
	}


	@Test public void testTsAddCharComma(){
		java.lang.String result;
		//Returns a comma if the specified string is non-empty and does not end with a blank nor a comma; "" otherwise

		result=TSString.tsAddCharComma(new TSString("test,"));
		assertEquals("", result);

		result=TSString.tsAddCharComma(new TSString("test "));
		assertEquals("", result);

		result=TSString.tsAddCharComma(new TSString("test, "));
		assertEquals("", result);

		result=TSString.tsAddCharComma(new TSString("test"));
		assertEquals(",", result);

		result=TSString.tsAddCharComma(new TSString(" "));
		assertEquals("", result);

		result=TSString.tsAddCharComma(null);
		assertEquals("", result);
	}


	@Test
	public void testTsExplodeSimple(){
		TSString t=new TSString("string1,string2,string3");
		TSBaseAPI result=t.tsExplode();

		//check for type
		assertEquals(TEnum.TS_ATOMIC_ARRAYLIST_STRING, result.tsGetTypeEnum());

		//check if list is as expected
		Object[] _o=((TSArrayListString)result).toArray();
		String[] actual=new String[]{_o[0].toString(),_o[1].toString(),_o[2].toString()};
		String[] expected=new String[]{"string1","string2","string3"};
		assertArrayEquals(expected, actual);
	}


	@Test
	public void testTsExplodeDouble(){
		TSString t=new TSString("key1%val1,key2%val2,key3%val3");
		TSBaseAPI result=t.tsExplode();

		//check for type
		assertEquals(TEnum.TS_COMPOSITE_MAP_LH, result.tsGetTypeEnum());

		//check if keys are all ok
		LinkedHashSet<String> keysExpected=new LinkedHashSet<String>();
		keysExpected.add("key1");
		keysExpected.add("key2");
		keysExpected.add("key3");
		Set<String> keysActual=((TSLinkedHashTree)result).keySet();
		assertArrayEquals(keysExpected.toArray(), keysActual.toArray());

		//check if values are all ok
		LinkedHashSet<String> valExpected=new LinkedHashSet<String>();
		valExpected.add("val1");
		valExpected.add("val2");
		valExpected.add("val3");
		Object[] _va=((TSLinkedHashTree)result).values().toArray();
		LinkedHashSet<String> valActual=new LinkedHashSet<String>();
		valActual.add(_va[0].toString());
		valActual.add(_va[1].toString());
		valActual.add(_va[2].toString());
		assertArrayEquals(valExpected.toArray(), valActual.toArray());
	}
}
