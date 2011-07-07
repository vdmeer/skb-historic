/* Copyright (c) 2009-2011 Sven van der Meer
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

package org.skb.lang.pola.proto;

import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageParser;
import org.skb.tribe.Tribe;
import org.skb.tribe.TribeProperties;

/**
 * General entry point for Pola parsing.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class Pola {
	public static void main (String[] args) {
		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		cfg.read("/resources/org/skb/lang/pola/proto/proto.json");

		Tribe tribe=new Tribe();

		//overwrite standard TRIBE values for LADS
		TribeProperties prop=TribeProperties.getInstance();

		prop.setValueDefault(TribeProperties.tpmKeyTgtDir, "V:/dev/projects/a3ds-java/experiements/src");

		// overwrite this permanently, we are in LADS
		prop.setValueDefault(TribeProperties.tpmKeySrcLanguage,   "pola");

		//some overwrites, for testing purpose only
		prop.setValueDefault(TribeProperties.tpmKeyTgtLanguage,   "pola");
		//prop.setValueDefault(TribePM.tpmKeyPrStgFileTarget, true);

		prop.setValueDefault(TribeProperties.tpmKeyNoWarnings,   true);

		prop.setValueDefault(TribeProperties.tpmKeyGC, true);

		prop.setValueDefault(TribeProperties.tpmKeySrcFile,   "org/skb/lang/pola/proto/specs/t1.pola");

		LanguageParser[] supportedLanguages={new PolaParser()};

		tribe.start(supportedLanguages, args);
	}
}