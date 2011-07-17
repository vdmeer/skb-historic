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

package org.skb.tribe;

import org.skb.util.types.composite.util.OatMapLH;
import org.skb.util.types.composite.util.OatPropertyMap;

/**
 * Class that reads properties (any configuration information) of a parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class LanguageProperties {
	private OatPropertyMap opm;
	private String className;
	private String key;

//	static Logger logger = Logger.getLogger("org.skb.tribe");

	private static class LanguagePropertiesHolder{
		private final static LanguageProperties INSTANCE = new LanguageProperties();
	}

	public static LanguageProperties getInstance(){
//		logger.trace("returning instance");
		return LanguagePropertiesHolder.INSTANCE;
	}

	public LanguageProperties(){
//		logger.trace("creating properties");
		this.opm=new OatPropertyMap();
	}

	public void setClassName(String s){
		this.className=s;
	}

	public void setKey(String s){
		this.key=s;
	}

	public void setOptions(){
//		logger.trace("setOptions -- in");

		if(this.className==null&&this.key==null)
			return;

		this.opm.addRows(this.className, this.key);

		TribeProperties prop=TribeProperties.getInstance();

		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		OatMapLH config=cfg.getConfiguration();

		if(config==null)
			System.err.println("tribe: property configuration not found");
		else{
			this.opm.loadFromJason(config.get(LanguageConfigurationConstants.Paths.SKBLangConfiguration).getValOatMapLH());
			prop.loadFromJason(config.get(LanguageConfigurationConstants.Paths.SKBTribeConfiguration).getValOatMapLH());

			if(config.containsKey(LanguageConfigurationConstants.Paths.SKBLangTargets)){
				String lang=new String();
				try {
					lang=prop.getValue(TribeProperties.tpmKeyTgtLanguage).toString();
				} catch (Exception e) {}
				this.opm.loadFromJason(config.get(LanguageConfigurationConstants.Paths.SKBLangTargets+"/"+lang+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationCli).getValOatMapLH());
				prop.loadFromJason(config.get(LanguageConfigurationConstants.Paths.SKBLangTargets+"/"+lang).getValOatMapLH());
			}
		}
//		logger.trace("setOptions -- out");
	}

	public OatPropertyMap getMap(){
		return this.opm;
	}
}
