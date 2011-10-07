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

package org.skb.test;

import junit.framework.TestSuite;

import org.junit.Ignore;
import org.skb.test.base.classic.cli.CliApacheTest;
import org.skb.test.base.classic.io.dirwalker.FindPackageDirectoriesTest;
import org.skb.test.base.classic.io.files.FileManagerTest;
import org.skb.test.base.classic.io.files.FileTemplateListTest;
import org.skb.test.base.classic.io.files.FileTemplateSingleTest;
import org.skb.test.base.classic.json.Json2TSTest;
import org.skb.test.base.classic.lang.ScopeStringTest;
import org.skb.test.base.classic.lang.ScopeTokenTest;
import org.skb.test.base.classic.misc.PropertyHandlerTest;
import org.skb.test.base.classic.patterns.creational.builder.RequestTest;
import org.skb.test.base.classic.stringtemplate.STGWriterXtoYTest;
import org.skb.test.base.composite.TSDefaultTest;
import org.skb.test.base.composite.TSErrorTest;
import org.skb.test.base.composite.TSNullTest;
import org.skb.test.base.composite.TSRepositoryTest;
import org.skb.test.base.composite.TSWarningTest;
import org.skb.test.base.composite.antlr.TSTokenTest;
import org.skb.test.base.composite.db.TSPDOTest;
import org.skb.test.base.composite.java.TSBooleanTest;
import org.skb.test.base.composite.java.TSByteTest;
import org.skb.test.base.composite.java.TSDoubleTest;
import org.skb.test.base.composite.java.TSFloatTest;
import org.skb.test.base.composite.java.TSIntegerTest;
import org.skb.test.base.composite.java.TSLongTest;
import org.skb.test.base.composite.java.TSObjectTest;
import org.skb.test.base.composite.java.TSShortTest;
import org.skb.test.base.composite.java.TSStringTest;
import org.skb.test.base.composite.stringtemplate.TSSTGroupManagerTest;
import org.skb.test.base.composite.stringtemplate.TSStringTemplateTest;
import org.skb.test.base.composite.util.TSArrayListAtomicTest;
import org.skb.test.base.composite.util.TSArrayListStringTest;
import org.skb.test.base.composite.util.TSArrayListTest;
import org.skb.test.base.composite.util.TSLangRuleMapTest;
import org.skb.test.base.composite.util.TSLinkedHashTreeTest;
import org.skb.test.base.composite.util.TSPropertyMapTest;
import org.skb.test.base.composite.util.TSScopeTest;
import org.skb.test.base.composite.util.TSTableRowTest;
import org.skb.test.base.composite.util.TSTableTest;

/**
 * Test class that will run all SKB Util tests
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class RunTests {
	/**
	 * Main method for running tests from command line or inside Eclipse
	 * @param args command line arguments
	 */
	@Ignore	public static void main(String[] args){
		org.junit.runner.JUnitCore.main("org.skb.test.RunTests");
	}

	/**
	 * TestSuits that collects all SKB Util tests
	 * @return the test suite of test suites
	 */
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		/*
		 * org.skb.util.config
		 */
		//TODO add Configuration
		//TODO add Configuration Manager
		//TODO add Configuration Properties

		/*
		 * org.skb.util.cli
		 */
		suite.addTestSuite(CliApacheTest.class);

		/*
		 * org.skb.util.io.dirwalker
		 */
		suite.addTestSuite(FindPackageDirectoriesTest.class);

		/*
		 * org.skb.util.io.files
		 */
		suite.addTestSuite(FileManagerTest.class);
		suite.addTestSuite(FileTemplateListTest.class);
		suite.addTestSuite(FileTemplateSingleTest.class);


		/*
		 * org.skb.util.json
		 */
		suite.addTestSuite(Json2TSTest.class);

		/*
		 * org.skb.util.languages
		 */
		suite.addTestSuite(ScopeStringTest.class);
		suite.addTestSuite(ScopeTokenTest.class);

		/*
		 * org.skb.util.misc
		 */
		suite.addTestSuite(PropertyHandlerTest.class);
		//TODO ADD LOG MANAGER

		/*
		 * org.skb.util.pattern
		 */
		suite.addTestSuite(RequestTest.class);

		/*
		 * org.skb.util.stringtemplate
		 */
		suite.addTestSuite(STGWriterXtoYTest.class);

		/*
		 * org.skb.types
		 */
		suite.addTestSuite(TSRepositoryTest.class);
		suite.addTestSuite(TSDefaultTest.class);
		suite.addTestSuite(TSErrorTest.class);
		suite.addTestSuite(TSWarningTest.class);
		suite.addTestSuite(TSNullTest.class);

		/*
		 * org.skb.composite.antlr
		 */
		suite.addTestSuite(TSTokenTest.class);

		/*
		 * org.skb.composite.db
		 */
		suite.addTestSuite(TSPDOTest.class);

		/*
		 * org.skb.composite.java
		 */
		suite.addTestSuite(TSBooleanTest.class);
		suite.addTestSuite(TSByteTest.class);
		suite.addTestSuite(TSDoubleTest.class);
		suite.addTestSuite(TSFloatTest.class);
		suite.addTestSuite(TSIntegerTest.class);
		suite.addTestSuite(TSLongTest.class);
		suite.addTestSuite(TSObjectTest.class);
		suite.addTestSuite(TSShortTest.class);
		suite.addTestSuite(TSStringTest.class);

		/*
		 * org.skb.composite.misc
		 */
		//TODO add TSI18N
		//TODO Add Report Manager


		/*
		 * org.skb.composite.stringtemplate
		 */
		suite.addTestSuite(TSStringTemplateTest.class);
		suite.addTestSuite(TSSTGroupManagerTest.class);

		/*
		 * org.skb.composite.util
		 */
		suite.addTestSuite(TSArrayListAtomicTest.class);
		suite.addTestSuite(TSArrayListStringTest.class);
		suite.addTestSuite(TSScopeTest.class);
		suite.addTestSuite(TSArrayListTest.class);
		suite.addTestSuite(TSLangRuleMapTest.class);
		suite.addTestSuite(TSLinkedHashTreeTest.class);
		suite.addTestSuite(TSPropertyMapTest.class);
		suite.addTestSuite(TSTableTest.class);
		suite.addTestSuite(TSTableRowTest.class);

		return suite;
	}
}
