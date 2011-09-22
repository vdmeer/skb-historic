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

package org.skb.test.util.classic.cli;

import junit.framework.TestCase;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.Test;
import org.skb.util.FieldKeys;
import org.skb.util.classic.cli.CliApache;
import org.skb.util.classic.misc.Json2Oat;
import org.skb.util.classic.misc.LogManager;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSLinkedHashTree;
import org.skb.util.composite.util.TSPropertyMap;

/**
 * Test cases for {@link org.skb.util.classic.cli.CliApache}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class CliApacheTest extends TestCase {
	public void setUp(){
		LogManager.init();
	}

	public void tearDown(){}

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
				this.loadFromJason(((TSLinkedHashTree)c));
		}
	}
}
