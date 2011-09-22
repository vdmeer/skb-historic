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

package org.skb.test.util.composite;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.skb.util.classic.misc.LogManager;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.TSRepository.TString;

/**
 * Test class for the TSRepository, checks for consistent definitions of TString and TEnum fields
 * 
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSrepositoryTest extends TestCase{
	static Logger logger;


	public void setUp(){
		LogManager.init();
		logger=Logger.getLogger(InitTests.class);
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
		return new TestSuite(TSrepositoryTest.class);
    }


	/**
	 * Tests for consistency between TString and TEnum fields in TSRepository
	 * 
	 * First it reads all fields of type string from TString into <code>strings</code> and all
	 * enumerates from TEnum into <code>enums</code>, then it tests the strings against 
	 * <code>TSRepository.type(String s)</code> and the enumerates against <code>TSRepository.type(TEnum e))</code>.
	 * If the tests fail, then either a string has no enumerate or an enumerate has no string. If both methods
	 * <code>TSRepository.type</code> are implemented correctly, any fail should occur testing for strings.
	 */
	@Test public void testTypes(){
		TreeMap<String, String> strings=new TreeMap<String, String>();
		Class<?> c=TString.class;
		for (Field f : c.getDeclaredFields()){
			try {
				if(f.getType().toString().equals("class java.lang.String"))
					strings.put(f.getName(), (String)f.get(c));
			} catch (IllegalAccessException e) {}
		}

		TreeMap<String, TEnum> enums=new TreeMap<String, TEnum>();
		TreeMap<String, String> enumsName=new TreeMap<String, String>();
		TreeMap<TEnum, String> enumsType=new TreeMap<TEnum, String>();
		TEnum[] e=TSRepository.TEnum.values();
		for(int k=0;k<e.length;k++){
			enums.put(e[k].type(), e[k]);
			enumsName.put(e[k].type(), e[k].name());
			enumsType.put(e[k], e[k].type());
		}

		//if size of strings and enums is different, we have more definitions on one of them
		//assertEquals("TSring and TEnum names have different size: "+strings.size()+"!="+enums.size()+"\n", strings.size(), enums.size());
		assertEquals("TSring and TEnum types have different size: "+strings.size()+"!="+enumsType.size()+"\n", strings.size(), enumsType.size());

		Set<String> sSet=strings.keySet();
		Iterator<String> sIt=sSet.iterator();
		while(sIt.hasNext()){
			String key=sIt.next();
			String val=strings.get(key);
			//each string field must have an enumerate defined using it
			assertEquals("string field <"+val+"> not used in enums\n", true, enums.containsKey(val));
			//each string field must have an enumerate defined
			assertEquals("string field name <"+key+"> used in wrong enum <"+enumsName.get(val)+">\n", key, enumsName.get(val));
			//name of TEnum and value assigned needs to be identical
			assertEquals("enum field <"+enums.get(val).toString()+"> and enum name not identical <"+enumsName.get(val).toString()+">\n", enums.get(val).toString(), enumsName.get(val).toString());
		}

		//check if TSRepository.type(String) returns a valid TEnum
		sSet=strings.keySet();
		sIt=sSet.iterator();
		while(sIt.hasNext()){
			String key=sIt.next();
			assertEquals("TSRepository.type(String) returns wrong TEnum <"+TSRepository.type(key)+"> for TString <"+key+">\n", true, enumsType.containsKey(TSRepository.type(key)));
		}

		//check if TSRepository.type(TEnum) returns a valid String
		Set<TEnum> eSet=enumsType.keySet();
		Iterator<TEnum> eIt=eSet.iterator();
		while(eIt.hasNext()){
			TEnum key=eIt.next();
			assertEquals("TSRepository.type(TEnum) returns wrong TString <"+TSRepository.type(key)+"> for TEnum <"+key+">\n", true, strings.containsValue(TSRepository.type(key)));
		}
	}
}
