package org.skb.test.util.types.composite.util;

import java.util.ArrayList;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.skb.util.log.LogManager;
import org.skb.util.misc.Json2Oat;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSNull;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.java.TSFloat;
import org.skb.util.patterns.structural.composite.atomic.java.TSInteger;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

public class TSMapLHTest extends TestCase{
	TSMapLH simple;
	TSMapLH complex;

	static Logger logger;


	public TSMapLHTest(String name) {
		super(name);
	}


	public void setUp(){
		LogManager.init();
		this.simple=new TSMapLH();
		this.complex=new TSMapLH();
		logger=Logger.getLogger(TSMapLHTest.class);
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
		return new TestSuite(TSMapLHTest.class);
    }


	@Ignore public void initSimple(){
		this.simple=(TSMapLH)new TSString("key1%val1,key2%val2,key3%val3").tsExplode();
	}

	@Ignore public void initComplex(){
		this.complex=new TSMapLH();
		Json2Oat j2o=new Json2Oat();
		TSBaseAPI c=j2o.read("/org/skb/test/util/types/composite/util/cola-proto.json");
		if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			this.complex=(TSMapLH)c;
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
		TSMapLH p=new TSMapLH();

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
}