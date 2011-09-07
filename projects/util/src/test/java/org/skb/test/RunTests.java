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
import org.skb.test.util.cli.CliApacheTest;
import org.skb.test.util.io.dirwalker.FindPackageDirectoriesTest;
import org.skb.test.util.io.files.FileManagerTest;
import org.skb.test.util.io.files.FileTemplateListTest;
import org.skb.test.util.io.files.FileTemplateSingleTest;
import org.skb.test.util.languages.AtomListTest;
import org.skb.test.util.languages.ScopeStringTest;
import org.skb.test.util.languages.ScopeTokenTest;
import org.skb.test.util.misc.I18NManagerTest;
import org.skb.test.util.misc.Json2OatTest;
import org.skb.test.util.misc.PropertyHandlerTest;
import org.skb.test.util.misc.ReportManagerTest;
import org.skb.test.util.pattern.RequestTest;
import org.skb.test.util.sql.PDOTest;
import org.skb.test.util.stringtemplate.STGManagerTest;
import org.skb.test.util.stringtemplate.STGWriterXtoYTest;
import org.skb.test.util.types.InitTests;
import org.skb.test.util.types.TSrepositoryTest;
import org.skb.test.util.types.atomic.antlr.TSTokenTest;
import org.skb.test.util.types.atomic.db.TSPDOTest;
import org.skb.test.util.types.atomic.java.TSBooleanTest;
import org.skb.test.util.types.atomic.java.TSByteTest;
import org.skb.test.util.types.atomic.java.TSDoubleTest;
import org.skb.test.util.types.atomic.java.TSFloatTest;
import org.skb.test.util.types.atomic.java.TSIntegerTest;
import org.skb.test.util.types.atomic.java.TSLongTest;
import org.skb.test.util.types.atomic.java.TSObjectTest;
import org.skb.test.util.types.atomic.java.TSShortTest;
import org.skb.test.util.types.atomic.java.TSStringTest;
import org.skb.test.util.types.atomic.stringtemplate.TSSTGManagerTest;
import org.skb.test.util.types.atomic.stringtemplate.TSSTGTest;
import org.skb.test.util.types.atomic.stringtemplate.TSSTTest;
import org.skb.test.util.types.atomic.util.TSArrayListAtomicTest;
import org.skb.test.util.types.atomic.util.TSArrayListStringTest;
import org.skb.test.util.types.atomic.util.TSScopeTest;
import org.skb.test.util.types.composite.util.TSArrayListTest;
import org.skb.test.util.types.composite.util.TSLangRuleMapTest;
import org.skb.test.util.types.composite.util.TSMapLHTest;
import org.skb.test.util.types.composite.util.TSPropertyMapTest;
import org.skb.test.util.types.composite.util.TSTableRowTest;
import org.skb.test.util.types.composite.util.TSTableTest;

/**
 * Test class that will run all SKB Util tests
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class RunTests {

	/**
	 * Main function for running tests from command line
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
		 * org.skb.util.languages
		 */
		suite.addTestSuite(AtomListTest.class);
		suite.addTestSuite(ScopeStringTest.class);
		suite.addTestSuite(ScopeTokenTest.class);

		/*
		 * org.skb.util.misc
		 */
		suite.addTestSuite(I18NManagerTest.class);
		suite.addTestSuite(Json2OatTest.class);
		suite.addTestSuite(PropertyHandlerTest.class);
		suite.addTestSuite(ReportManagerTest.class);

		/*
		 * org.skb.util.pattern
		 */
		suite.addTestSuite(RequestTest.class);

		/*
		 * org.skb.util.sql
		 */
		suite.addTestSuite(PDOTest.class);

		/*
		 * org.skb.util.stringtemplate
		 */
		suite.addTestSuite(STGManagerTest.class);
		suite.addTestSuite(STGWriterXtoYTest.class);

		/*
		 * org.skb.types
		 */
		suite.addTestSuite(InitTests.class);
		suite.addTestSuite(TSrepositoryTest.class);

		/*
		 * org.skb.types.atomic.antlr
		 */
		suite.addTestSuite(TSTokenTest.class);

		/*
		 * org.skb.types.atomic.db
		 */
		suite.addTestSuite(TSPDOTest.class);

		/*
		 * org.skb.types.atomic.java
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
		 * org.skb.types.atomic.stringtemplate
		 */
		suite.addTestSuite(TSSTTest.class);
		suite.addTestSuite(TSSTGTest.class);
		suite.addTestSuite(TSSTGManagerTest.class);

		/*
		 * org.skb.types.atomic.util
		 */
		suite.addTestSuite(TSArrayListAtomicTest.class);
		suite.addTestSuite(TSArrayListStringTest.class);
		suite.addTestSuite(TSScopeTest.class);

		/*
		 * org.skb.types.composite.util
		 */
		suite.addTestSuite(TSArrayListTest.class);
		suite.addTestSuite(TSLangRuleMapTest.class);
		suite.addTestSuite(TSMapLHTest.class);
		suite.addTestSuite(TSPropertyMapTest.class);
		suite.addTestSuite(TSTableTest.class);
		suite.addTestSuite(TSTableRowTest.class);

		return suite;
	}
}
