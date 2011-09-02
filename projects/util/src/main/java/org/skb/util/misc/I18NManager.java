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

package org.skb.util.misc;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * A class handling internationalisation using properties.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class I18NManager {
	/**
	 * Class logger
	 */
	public final static Logger logger = Logger.getLogger(I18NManager.class);

	/**
	 * List of keys (domains) with associated resource bundle
	 */
	LinkedHashMap <String, ResourceBundle> entries;

	/**
	 * Current domain for resources
	 */
	private String currentDomain;

	private static class XtI18NManager_MainHolder{
		private final static I18NManager INSTANCE = new I18NManager();
	}

	/**
	 * Return the instance of I18NManager (singleton)
	 * @return instance
	 */
	public static I18NManager getInstance(){
		return XtI18NManager_MainHolder.INSTANCE;
	}

	/**
	 * Class constructor, private since I18NManager implements singleton
	 */
	private I18NManager(){
		this.entries=new LinkedHashMap <String, ResourceBundle>();
		currentDomain=new String();
	}

	/**
	 * Add a domain described by a package name and locale information
	 * @param pkg name of the package (later used as key/domain ID)
	 * @param locale locale information to be used to load a resource bundle
	 */
	public void addDomain(String pkg, Locale locale){
		ResourceBundle rb;
		try{
			if(locale==null)
				rb=PropertyResourceBundle.getBundle(pkg);
			else
				rb=PropertyResourceBundle.getBundle(pkg, locale);
			this.entries.put(pkg, rb);

		} catch (Exception e) {
			logger.error("catched exception: "+e.toString());
			//e.printStackTrace();
		}
	}

	/**
	 * Set the domain to be used for getting translations
	 * @param pkg package name (domain ID)
	 */
	public void setTextDomain(String pkg){
		if(pkg!=null)
			this .currentDomain=pkg;
	}

	/**
	 * Translate the given string using the currently set domain
	 * @param translate
	 * @return translation or an empty string <"">
	 */
	public String _(String translate){
		if(this.currentDomain!=null)
			return this.entries.get(this.currentDomain).getString(translate);
		else
			return "";
	}

	/**
	 * Return translation for the given string from the given domain (pkg name)
	 * @param domain domain to use
	 * @param translate
	 * @return translation or an empty string <"">
	 */
	public String _(String domain, String translate){
		if(this.entries.containsKey(domain))
			return this.entries.get(domain).getString(translate);
		else
			return "";
	}
}
