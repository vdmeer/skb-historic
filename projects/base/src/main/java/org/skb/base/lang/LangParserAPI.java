/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.base.lang;

import java.io.InputStream;

import org.skb.base.composite.TSDefault;
import org.skb.base.composite.util.TSArrayListString;
import org.skb.base.config.Configuration;

/**
 * Interface for a Language Parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface LangParserAPI {
	/**
	 * Returns the supported source language of the parser.
	 * @return source language
	 */
	public String getSupportedSourceLang();

	/**
	 * Returns the parser's configuration object.
	 * @return class name
	 */
	public Configuration getConfiguration();

	/**
	 * Returns the supported target languages of the parser.
	 * @return string array with the supported target languages
	 */
	public TSArrayListString getSupportedTargetLang();

	/**
	 * Sets the parser's configuration.
	 */
	public TSDefault loadParserOptions();

	/**
	 * Sets the parser's configuration.
	 */
	public TSDefault loadTargetLanguage();

	/**
	 * Starts the parsing process
	 * @param is stream with the content to be parsed
	 */
	public void parse(InputStream is);

	/**
	 * Returns the target StringTemplate as string, for instance for printing.
	 */
	public String getTargetStgAsString();
}
