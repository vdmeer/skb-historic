/* Copyright (c) 2000-2011 Sven van der Meer (sven@vandermeer.de)
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
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

package org.skb.lang.cola.proto;

import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageParser;
import org.skb.tribe.Tribe;
import org.skb.tribe.TribeProperties;
import org.apache.log4j.Logger;

/**
 * General entry point for Cola parsing.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class Cola{
	static Logger logger = Logger.getLogger("org.skb.lang.cola.base");

	public static void main (String[] args) {
		logger.trace("main -- in");
		logger.trace("initialise tribe and properties");

		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		cfg.read("/org/skb/lang/cola/proto/proto.json");

		Tribe tribe=new Tribe();

		//overwrite standard TRIBE values for LADS
		TribeProperties prop=TribeProperties.getInstance();

		prop.setValueDefault(TribeProperties.tpmKeyTgtDir, "V:/dev/projects/a3ds-java/experiements/src");

		// overwrite this permanently, we are in LADS
		prop.setValueDefault(TribeProperties.tpmKeySrcLanguage,   "cola");

		//some overwrites, for testing purpose only
		prop.setValueDefault(TribeProperties.tpmKeyTgtLanguage,   "java");
		//prop.setValueDefault(TribePM.tpmKeyPrStgFileTarget, true);

		prop.setValueDefault(TribeProperties.tpmKeyNoWarnings,   true);

		prop.setValueDefault(TribeProperties.tpmKeyGC, true);
		//prop.setValueDefault(TribeProperties.tpmKeyQuietMode, true);

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/ease/values.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/ease/car.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/ease/entitymgmt.cola");

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/appendix-conventions.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/cont-decl-car.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/cont-def-car.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/item-decl-car.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/name-scope.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/prop-decl-contact.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/prop-decl-counter.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/prop-def-struct-date.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples-doc/prop-def-values.cola");

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/tests/property.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/tests/test.cola");

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/contract.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/mama-j.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/test.cola");
		prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/mama.cola");

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/rina/cdap.cola");

		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/spec.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/cnt.cola");
		//prop.setValueDefault(TribeProperties.tpmKeySrcFile, "org/skb/lang/cola/proto/specs/examples/contract_text.cola");

		logger.trace("create Language[]");
		LanguageParser[] supportedLanguages={new ColaParser()};

		logger.trace("calling tribe to parse");
		tribe.start(supportedLanguages, args);

		logger.trace("main -- out");
	}
}