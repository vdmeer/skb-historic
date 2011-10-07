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

package org.skb.test.util.composite.util;

import java.util.ArrayList;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.skb.util.classic.json.Json2TS;
import org.skb.util.classic.misc.LogManager;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSNull;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSFloat;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSArrayListString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Test cases for {@link org.skb.util.composite.util.TSLinkedHashTree}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSLinkedHashTreeTest extends TestCase{
	TSLinkedHashTree simple;
	TSLinkedHashTree complex;

	static Logger logger;


	public TSLinkedHashTreeTest(String name) {
		super(name);
	}


	public void setUp(){
		LogManager.init();
		this.simple=new TSLinkedHashTree();
		this.complex=new TSLinkedHashTree();
		logger=Logger.getLogger(TSLinkedHashTreeTest.class);
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
		return new TestSuite(TSLinkedHashTreeTest.class);
    }

	@Test public void testTSInit(){
		Object[] o;
		TSLinkedHashTree _t=new TSLinkedHashTree();
		o=_t.tsGetTypeEnumSet().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TEnum.TS_BASE.toString(),o[0].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE.toString(),o[1].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TREE.toString(),o[2].toString());
			assertEquals(TSRepository.TEnum.TS_COMPOSITE_TREE_LH.toString(),o[3].toString());
		o=_t.tsGetTypeStringList().toArray();
			assertEquals(4,o.length);
			assertEquals(TSRepository.TString.TS_BASE,o[0]);
			assertEquals(TSRepository.TString.TS_COMPOSITE,o[1]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TREE,o[2]);
			assertEquals(TSRepository.TString.TS_COMPOSITE_TREE_LH,o[3]);

		assertEquals(false,_t.tsIsAtomic());
		assertEquals(true,_t.tsIsComposite());

		assertEquals(TSRepository.TEnum.TS_COMPOSITE_TREE_LH,_t.tsGetTypeEnum());
		assertEquals(TSRepository.TString.TS_COMPOSITE_TREE_LH,_t.tsGetTypeString());

		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TREE));
		assertEquals(true,_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_TREE_LH));

		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_BASE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TREE));
		assertEquals(true,_t.tsIsType(TSRepository.TString.TS_COMPOSITE_TREE_LH));
	}


	@Ignore public void initSimple(){
		this.simple=(TSLinkedHashTree)new TSString("key1%val1,key2%val2,key3%val3").tsExplode();
	}

	@Ignore public void initComplex(){
		this.complex.clear();
		Json2TS j2o=new Json2TS();
		TSBaseAPI c=j2o.read("/org/skb/test/util/types/composite/util/cola-proto.json");
		//TSBaseAPI c=j2o.read("/org/skb/test/util/types/composite/util/flare.json");
		if(c.tsIsType(TEnum.TS_COMPOSITE_TREE_LH))
			this.complex=(TSLinkedHashTree)c;
	}

	@Test public void testSize(){
		this.initSimple();
		assertEquals(3, this.simple.size());
	}


	@Test public void testClear(){
		this.initSimple();
		this.simple.clear();
		assertEquals(0, this.simple.size());
	}


	@Test public void testContainsKeySimple(){
		this.initSimple();

		//null
		String t=null;
		assertEquals(false, this.simple.containsKey(t));
		TSString ts=null;
		assertEquals(false, this.simple.containsKey(ts));
		Object to=null;
		assertEquals(false, this.simple.containsKey(to));
		String[] ta=null;
		assertEquals(false, this.simple.containsKey(ta));
		ArrayList<String>tl=null;
		assertEquals(false, this.simple.containsKey(tl));

		//String
		assertEquals(true, this.simple.containsKey("key1"));
		assertEquals(true, this.simple.containsKey("key2"));
		assertEquals(true, this.simple.containsKey("key3"));

		//TSString
		assertEquals(true, this.simple.containsKey(new TSString("key1")));
		assertEquals(true, this.simple.containsKey(new TSString("key2")));
		assertEquals(true, this.simple.containsKey(new TSString("key3")));

		//Object
		assertEquals(true, this.simple.containsKey((Object)"key1"));
		assertEquals(true, this.simple.containsKey((Object)"key2"));
		assertEquals(true, this.simple.containsKey((Object)"key3"));

		//List
		ArrayList<String> l=new ArrayList<String>();
		assertEquals(false, this.simple.containsKey(l));
		l.add("key1");
		assertEquals(true, this.simple.containsKey(l));

		//String[]
		assertEquals(false, this.simple.containsKey(new String[]{}));
		assertEquals(true, this.simple.containsKey(new String[]{"key1"}));
		assertEquals(true, this.simple.containsKey(new String[]{"key2"}));
		assertEquals(true, this.simple.containsKey(new String[]{"key3"}));
	}

	@Test public void testGetSimple(){
		this.initSimple();

		//null
		String t=null;
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(t).tsGetTypeEnum());
		TSString ts=null;
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(ts).tsGetTypeEnum());
		Object to=null;
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(to).tsGetTypeEnum());
		String[] ta=null;
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(ta).tsGetTypeEnum());
		ArrayList<String>tl=null;
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(tl).tsGetTypeEnum());

		//String
		assertEquals("val1", this.simple.get("key1").toString());
		assertEquals("val2", this.simple.get("key2").toString());
		assertEquals("val3", this.simple.get("key3").toString());

		//TSString
		assertEquals("val1", this.simple.get(new TSString("key1")).toString());
		assertEquals("val2", this.simple.get(new TSString("key2")).toString());
		assertEquals("val3", this.simple.get(new TSString("key3")).toString());

		//Object
		assertEquals("val1", this.simple.get((Object)"key1").toString());
		assertEquals("val2", this.simple.get((Object)"key2").toString());
		assertEquals("val3", this.simple.get((Object)"key3").toString());

		//List
		ArrayList<String> l=new ArrayList<String>();
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(l).tsGetTypeEnum());
		l.add("key1");
		assertEquals("val1", this.simple.get(l).toString());

		//String[]
		assertEquals(new TSNull().tsGetTypeEnum(), this.simple.get(new String[]{}).tsGetTypeEnum());
		assertEquals("val1", this.simple.get(new String[]{"key1"}).toString());
		assertEquals("val2", this.simple.get(new String[]{"key2"}).toString());
		assertEquals("val3", this.simple.get(new String[]{"key3"}).toString());
	}

	@Test public void testContainsKeyComplex(){
		this.initComplex();

		//null
		String t=null;
		assertEquals(false, this.complex.containsKey(t));
		TSString ts=null;
		assertEquals(false, this.complex.containsKey(ts));
		Object to=null;
		assertEquals(false, this.complex.containsKey(to));
		String[] ta=null;
		assertEquals(false, this.complex.containsKey(ta));
		ArrayList<String>tl=null;
		assertEquals(false, this.complex.containsKey(tl));

		//String
		assertEquals(true, this.complex.containsKey("skb/tribe/configuration"));
		assertEquals(true, this.complex.containsKey("skb/lang/configuration"));
		assertEquals(true, this.complex.containsKey("skb/lang/tokens"));
		assertEquals(true, this.complex.containsKey("skb/lang/targets"));
		assertEquals(true, this.complex.containsKey("skb/lang/stgchunks"));
		assertEquals(true, this.complex.containsKey("skb/lang/rules"));

		//TSString
		assertEquals(true, this.complex.containsKey(new TSString("skb/tribe/configuration")));
		assertEquals(true, this.complex.containsKey(new TSString("skb/lang/configuration")));
		assertEquals(true, this.complex.containsKey(new TSString("skb/lang/tokens")));
		assertEquals(true, this.complex.containsKey(new TSString("skb/lang/targets")));
		assertEquals(true, this.complex.containsKey(new TSString("skb/lang/stgchunks")));
		assertEquals(true, this.complex.containsKey(new TSString("skb/lang/rules")));

		//List
		ArrayList<String> l=new ArrayList<String>();
		assertEquals(false, this.complex.containsKey(l));
		l.add("skb");
		l.add("tribe");
		l.add("configuration");
		assertEquals(true, this.complex.containsKey(l));
		l.clear();
		l.add("skb");
		l.add("lang");
		l.add("configuration");
		assertEquals(true, this.complex.containsKey(l));

		//String[]
		assertEquals(false, this.complex.containsKey(new String[]{}));
		assertEquals(true, this.complex.containsKey(new String[]{"skb","tribe","configuration"}));
		assertEquals(true, this.complex.containsKey(new String[]{"skb","lang","configuration"}));
		assertEquals(true, this.complex.containsKey(new String[]{"skb","lang","targets"}));
//System.err.println(this.complex);
	}

	@Test public void testPut(){
		TSLinkedHashTree p=new TSLinkedHashTree();

		/*
		 * test with KEY=String and VAL=String
		 */
		//empty list, add a key/val pair
		p.put("key1", "val1");
		assertEquals(true, p.containsKey("key1"));
		assertEquals("val1", p.get("key1").toString());

		p.put("key8", "val8");
		assertEquals(true, p.containsKey("key8"));
		assertEquals("val8", p.get("key8").toString());

		p.put("key9", "val9");
		assertEquals(true, p.containsKey("key9"));
		assertEquals("val9", p.get("key9").toString());

		//change the value of key1 to list with key2/val2
		p.put("key1/key2", "val2");
		assertEquals(true, p.containsKey("key1/key2"));
		assertEquals("val2", p.get("key1/key2").toString());

		//change value of key2 to val3
		p.put("key1/key2", "val3");
		assertEquals(true, p.containsKey("key1/key2"));
		assertEquals("val3", p.get("key1/key2").toString());

		//add a key4 on level of key1
		p.put("key1/key4", "val4");
		assertEquals(true, p.containsKey("key1/key4"));
		assertEquals("val4", p.get("key1/key4").toString());

		/*
		 * test with KEY=STRING, VAL=TBase
		 */
		//empty list, add a key/val pair
		p.put("key1", new TSString("val1"));
		assertEquals(true, p.containsKey("key1"));
		assertEquals("val1", p.get("key1").toString());

		p.put("key8", new TSInteger(8));
		assertEquals(true, p.containsKey("key8"));
		assertEquals((Integer)8, ((TSInteger)p.get("key8")).tsvalue);

		p.put("key9", new TSBoolean(false));
		assertEquals(true, p.containsKey("key9"));
		assertEquals((Boolean)false, ((TSBoolean)p.get("key9")).tsvalue);

		//change the value of key1 to list with key2/val2
		p.put("key1/key2", new TSFloat(2.1));
		assertEquals(true, p.containsKey("key1/key2"));
		assertEquals(new Float(2.1), ((TSFloat)p.get("key1/key2")).tsvalue);

		//change value of key2 to val3
		TSArrayListString l=new TSArrayListString(new String[]{"part1","part2","part3","part4"});
		p.put("key1/key2", l);
		assertEquals(true, p.containsKey("key1/key2"));

		Object[] expected=new Object[]{"part1","part2","part3","part4"};
		Object[] actual=((TSArrayListString)p.get("key1/key2")).toArray();
		for(int i=0;i<expected.length;i++)
			assertEquals(expected[i].toString(), actual[i].toString());

		//add a key4 on level of key1
		p.put("key1/key4", "val4");
		assertEquals(true, p.containsKey("key1/key4"));
		assertEquals("val4", p.get("key1/key4").toString());

		/*
		 * test with KEY=TSString, VAL=TBase
		 */
		//empty list, add a key/val pair
		p.put(new TSString("key1"), new TSString("val1"));
		assertEquals(true, p.containsKey(new TSString("key1")));
		assertEquals("val1", p.get("key1").toString());

		p.put(new TSString("key8"), new TSInteger(8));
		assertEquals(true, p.containsKey("key8"));
		assertEquals((Integer)8, ((TSInteger)p.get("key8")).tsvalue);

		p.put(new TSString("key9"), new TSBoolean(false));
		assertEquals(true, p.containsKey("key9"));
		assertEquals((Boolean)false, ((TSBoolean)p.get("key9")).tsvalue);

		//change the value of key1 to list with key2/val2
		p.put(new TSString("key1/key2"), new TSFloat(2.1));
		assertEquals(true, p.containsKey("key1/key2"));
		assertEquals(new Float(2.1), ((TSFloat)p.get("key1/key2")).tsvalue);

		//change value of key2 to val3
		l=new TSArrayListString(new String[]{"part1","part2","part3","part4"});
		p.put(new TSString("key1/key2"), l);
		assertEquals(true, p.containsKey("key1/key2"));

		expected=new Object[]{"part1","part2","part3","part4"};
		actual=((TSArrayListString)p.get(new TSString("key1/key2"))).toArray();
		for(int i=0;i<expected.length;i++)
			assertEquals(expected[i].toString(), actual[i].toString());

		//add a key4 on level of key1
		p.put(new TSString("key1/key4"), new TSString("val4"));
		assertEquals(true, p.containsKey(new TSString("key1/key4")));
		assertEquals("val4", p.get("key1/key4").toString());


//		public TSBase put(ArrayList<String> list, String val)
//		public TSBase put(List<String> list, TSBase val)

//		public TSBase put(String[] list, String val)
//		public TSBase put(String[] list, TSBase val)
	}

//	@Test public void testT(){
//		this.initComplex();
//
//		try{
//			StringWriter sw=new StringWriter();
//			ObjectMapper mapper=TS2Json.getMapperD3();
//			JsonGenerator jsonGenerator=TS2Json.getJsonGeneratorSW(sw);
//			mapper.writeValue(jsonGenerator, this.complex);
//			sw.close();
//			String res=sw.getBuffer().toString();
//			System.out.println(res);
//		} catch(Exception e){
//			System.err.println(e);
//		}
//	}
}