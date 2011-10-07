/* Copyright (c) 2011-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.test.base.composite.java;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.java.TSString;
import org.skb.base.composite.util.TSArrayListString;
import org.skb.base.composite.util.TSLinkedHashTree;

/**
 * Test cases for {@link org.skb.base.composite.java.TSString}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSStringTest extends TestCase{
	public void setUp(){}

	public void tearDown(){}

	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TSStringTest.class);
    }

	//TODO - test for tsAddCharWBlank
	//TODO - test for tsAddFirstChar
	//TODO - test for Constructors
	//TODO - test for tsClean
	//TODO - test for tsTrim

	@Test public void testTSInit(){
		Object[] o;
		TSString _t=new TSString();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(3,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING.toString(),o[2].toString());
		o=_t.tsGetTypeStringList().toArray();
		assertEquals(3,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_ATOMIC,o[1]);
			assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_STRING,o[2]);

		assertEquals(true,_t.tsIsAtomic());
		assertEquals(false,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_ATOMIC_JAVA_STRING,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_ATOMIC_JAVA_STRING));
	}

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
		assertEquals(TEnum.TS_COMPOSITE_TREE_LH, result.tsGetTypeEnum());

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
