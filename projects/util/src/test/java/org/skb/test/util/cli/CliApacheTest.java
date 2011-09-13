package org.skb.test.util.cli;

import junit.framework.TestCase;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;
import org.skb.util.FieldKeys;
import org.skb.util.cli.CliApache;
import org.skb.util.log.LogManager;
import org.skb.util.misc.Json2Oat;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSInteger;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;
import org.skb.util.patterns.structural.composite.composite.util.TSPropertyMap;

public class CliApacheTest extends TestCase {
	public void setUp(){
		LogManager.init();
	}


	public void tearDown(){
	}


	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CliApacheTest.class);
    }


	//TODO - test for lots of stuff


	@Test public void testApplicationName(){
		CliApache _t=new CliApache();

		//AppName not set, must be ""
		assertEquals("", _t.getApplicationName());

		assertEquals(true, _t.setApplicationName("testString"));
		assertEquals("testString", _t.getApplicationName());

		assertEquals(true, _t.setApplicationName(new TSString("testTSString")));
		assertEquals("testTSString", _t.getApplicationName());

		//set with null should not change the AppName
		assertEquals(false, _t.setApplicationName((String)null));
		assertEquals("testTSString", _t.getApplicationName());

		//set with TBase other than TSString should not change the AppName
		assertEquals(false, _t.setApplicationName(new TSInteger(1)));
		assertEquals("testTSString", _t.getApplicationName());
	}


	@Test public void testSetProperties(){
		CliTestProperties prop=new CliTestProperties();
		CliApache _t=new CliApache();
		Options opt;

		//zero test, no properties set
		_t.setPropOptions(prop);
		opt=_t.getPropOptions();
		assertEquals(0, opt.getOptions().size());

		prop.fill();
		_t.setPropOptions(prop);
		Object[] cOpt=_t.getPropOptions().getOptions().toArray();
		for(int i=0;i<cOpt.length;i++){
			Option o=(Option)cOpt[i];
			
			String optShort=o.getOpt();
			String optLong=o.getLongOpt();
			String arg=o.getArgName();
			String descr=o.getDescription();

			assertEquals(true, prop.containsKey(optLong));
			//if arg=="arg" we have a boolean CLI value
			if(o.hasArg())
				assertEquals(arg.toString(), prop.get(optLong).get(FieldKeys.fieldCliOptionDescriptionArguments).toString());

			//if optShort==null, then not set, so put on "" for testing
			if(optShort==null)
				optShort="";
			assertEquals(optShort, prop.get(optLong).get(FieldKeys.fieldCliOptionShort).toString());
			assertEquals(descr, prop.get(optLong).get(FieldKeys.fieldCliOptionDescriptionShort).toString());
		}
		assertEquals(18, opt.getOptions().size());
	}


	@Test public void testUsage(){
		CliTestProperties prop=new CliTestProperties();
		CliApache _t=new CliApache();

		prop.fill();
		_t.setPropOptions(prop);
		_t.setApplicationName("cli-test");
		String usage=_t.usage(null, null, 100, true);

		//can only test for lenght, so check of !=0
		assertFalse(0==usage.length());
		//System.err.println(usage);
	}


	@Test public void testParse(){
		CliTestProperties prop=new CliTestProperties();
		CliApache _t=new CliApache();

		prop.fill();
		_t.setPropOptions(prop);
		_t.setApplicationName("cli-test");

		//empty command line
		try {
			_t.parse(new String[] {""}, false);
		} catch (ParseException e) {
			fail("parse exception with empty cmd\n"+e);
		}

		//correct short options w/o arguments
		try {
			_t.parse(new String[] {"-f", "-g", "-h", "-i", "-j"}, false);
		} catch (ParseException e) {
			fail("parse exception for correct short options w/o arguments\n"+e);
		}

		//correct short options with arguments
		try {
			_t.parse(new String[] {"-a", "FOR_A", "-b", "FOR_B", "-c", "FOR_C", "-d", "FOR_D"}, false);
		} catch (ParseException e) {
			fail("parse exception for correct short options with arguments\n"+e);
		}

		//correct long options w/o arguments
		try {
			_t.parse(new String[] {"--boolean-boolean__long", "--boolean-double__long", "--boolean-integer__long", "--boolean-long__long", "--boolean-string__long",}, false);
		} catch (ParseException e) {
			fail("parse exception for correct long options w/o arguments\n"+e);
		}
 
		//correct long options with arguments
		try {
			_t.parse(new String[] {"--boolean-double__long__arg", "AAA", "--boolean-integer__long__arg", "BBB", "--boolean-long__long__arg", "CCC", "--boolean-string__long__arg", "DDD"}, false);
		} catch (ParseException e) {
			fail("parse exception for correct long options with arguments\n"+e);
		}

	}


	@Test public void testSetOptions(){
		CliTestProperties prop=new CliTestProperties();
		CliApache _t=new CliApache();

		prop.fill();
		_t.setPropOptions(prop);
		_t.setApplicationName("cli-test");

		//command line with all defined options
		try {
			_t.parse(new String[] {"-f", "-g", "-h", "-i", "-j", "-a", "FOR_A", "-b", "FOR_B", "-c", "FOR_C", "-d", "FOR_D", "--boolean-boolean__long", "--boolean-double__long", "--boolean-integer__long", "--boolean-long__long", "--boolean-string__long", "--boolean-double__long__arg", "AAA", "--boolean-integer__long__arg", "BBB", "--boolean-long__long__arg", "CCC", "--boolean-string__long__arg", "DDD"}, false);
		} catch (ParseException e) {
			fail("oops, parse error while testing setOptions\n"+e);
		}

		_t.setOptions(prop);
		//TODO test the resulting prop for set CLI values
	}


	public class CliTestProperties extends TSPropertyMap {
		public final static String propKeyBoolStringLongARG			= "boolean-string__long__arg";
		public final static String propKeyBoolStringShortLongARG	= "boolean-string__short-long__arg";
		public final static String propKeyBoolIntegerShortLongARG	= "boolean-integer__short-long__arg";
		public final static String propKeyBoolIntegerLongARG		= "boolean-integer__long__arg";
		public final static String propKeyBoolDoubleShortLongARG	= "boolean-double__short-long__arg";
		public final static String propKeyBoolDoubleLongARG			= "boolean-double__long__arg";
		public final static String propKeyBoolLongShortLongARG		= "boolean-long__short-long__arg";
		public final static String propKeyBoolLongLongARG			= "boolean-long__long__arg";

		public final static String propKeyBoolStringLong			= "boolean-string__long";
		public final static String propKeyBoolStringShortLong		= "boolean-string__short-long";
		public final static String propKeyBoolIntegerShortLong		= "boolean-integer__short-long";
		public final static String propKeyBoolIntegerLong			= "boolean-integer__long";
		public final static String propKeyBoolDoubleShortLong		= "boolean-double__short-long";
		public final static String propKeyBoolDoubleLong			= "boolean-double__long";
		public final static String propKeyBoolLongShortLong			= "boolean-long__short-long";
		public final static String propKeyBoolLongLong				= "boolean-long__long";
		public final static String propKeyBoolBooleanShortLong		= "boolean-boolean__short-long";
		public final static String propKeyBoolBooleanLong			= "boolean-boolean__long";

		public CliTestProperties(){
			super();
			this.addRows(CliTestProperties.class.getName(), "propKey");
		}

		public void fill(){
			Json2Oat j2o=new Json2Oat();
			TSBaseAPI c=j2o.read("/org/skb/test/util/cli/properties.json");
			if(c!=null&&c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
				this.loadFromJason(((TSMapLH)c));
		}
	}
}
