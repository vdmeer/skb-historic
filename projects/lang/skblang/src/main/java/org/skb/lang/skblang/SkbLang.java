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

package org.skb.lang.skblang;

import org.apache.log4j.Logger;
import org.skb.base.lang.LangParserAPI;
import org.skb.base.misc.LogManager;
import org.skb.lang.cola.proto.ColaParser;
import org.skb.lang.dal.DalParser;
import org.skb.lang.glue.proto.GlueParser;
import org.skb.lang.pola.proto.PolaParser;
import org.skb.tribe.LangParserImpl;
import org.skb.tribe.Tribe;

/**
 * Class combining all SKB Language Parsers into a single tool.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class SkbLang {
	/** Logger instance */
	static Logger logger;

	/**
	 * Main method to execute the parser with arguments.
	 * @param args arguments for execution, usually command line arguments
	 */
	public static void main (String[] args) {
		LogManager.init();
		logger=Logger.getLogger(SkbLang.class);

		logger.trace("main -- in");
		logger.trace("initialise tribe and properties");
		Tribe tribe=new Tribe();

		logger.trace("create Language[]");
		
		LangParserImpl colaProto=new LangParserImpl();
		colaProto.setLangParser(new ColaParser());

		LangParserImpl polaProto=new LangParserImpl();
		polaProto.setLangParser(new PolaParser());

		LangParserImpl glueProto=new LangParserImpl();
		glueProto.setLangParser(new GlueParser());

		LangParserImpl dal=new LangParserImpl();
		dal.setLangParser(new DalParser());

		LangParserAPI[] supportedLanguages={colaProto, polaProto, glueProto, dal};

		logger.trace("calling tribe to parse");
		tribe.execute(supportedLanguages, args);

		logger.trace("main -- out");
	}
}
