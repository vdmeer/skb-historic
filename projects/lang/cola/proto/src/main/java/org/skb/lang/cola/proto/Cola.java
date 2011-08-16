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

import org.apache.log4j.Logger;
import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageParser;
import org.skb.tribe.Tribe;

/**
 * General entry point for Cola parsing.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class Cola{
	static Logger logger;

	public static void main (String[] args) {
		System.setProperty("log4j.configuration", "org/skb/lang/cola/proto/log4/log4j.xml");
		logger=Logger.getLogger(Cola.class);

		logger.trace("main -- in");
		logger.trace("initialise tribe and properties");

		LanguageConfiguration cfg=LanguageConfiguration.getInstanceInit();
		cfg.read("/org/skb/lang/cola/proto/proto.json");
//		cfg.read(new String[] {"/org/skb/lang/cola/proto/proto.json",
//   	                           "/org/skb/lang/cola/proto/lang-rules.json",
//	                           "/org/skb/lang/cola/proto/lang-tokens.json"
//                               }
//		);


		Tribe tribe=new Tribe();

		logger.trace("create Language[]");
		LanguageParser[] supportedLanguages={new ColaParser()};

		logger.trace("calling tribe to parse");
		tribe.start(supportedLanguages, args);

		logger.trace("main -- out");
	}
}