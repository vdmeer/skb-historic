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

import java.io.File;

import org.skb.types.composite.util.OatMapLH;
import org.skb.util.Json2Oat;

/**
 * Read the json configuration of a parser and provide filtered access to it.
 *
 * @author     Sven van der Meer
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class LanguageConfiguration {
	private OatMapLH configuration;

	private static class LanguageConfigurationHolder{
		private final static LanguageConfiguration INSTANCE = new LanguageConfiguration();
	}

	/**
	 * Singleton getInstance
	 * @return pointer to the LanguageConfiguration instance
	 */
	public static LanguageConfiguration getInstance(){
		return LanguageConfigurationHolder.INSTANCE;
	}

	private LanguageConfiguration(){
		this.configuration=null;
	}

	public void read(String url){
		try{
			Json2Oat j2o=new Json2Oat();
			this.configuration=j2o.read(url).getValOatMapLH();
		}
		catch (Exception e){
			System.err.println("LanguageConfiguration: "+e);
		}

	}
	
	public void read(File file){
		try{
			Json2Oat j2o=new Json2Oat();
			this.configuration=j2o.read(file).getValOatMapLH();
		}
		catch (Exception e){
			System.err.println("LanguageConfiguration: "+e);
		}

	}

	public void validate(){
		
	}

	public OatMapLH getConfiguration(){
		return this.configuration;
	}

	public OatMapLH getTribeConfiguration(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBTribeConfiguration).getValOatMapLH();
	}

	public OatMapLH getLanguageConfiguration(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangConfiguration).getValOatMapLH();
	}

	public OatMapLH getLanguageTokens(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangTokens).getValOatMapLH();
	}

	public OatMapLH getLanguageTargets(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangTargets).getValOatMapLH();
	}

	public OatMapLH getLanguageStgChunks(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangStgChunks).getValOatMapLH();
	}

	public OatMapLH getLanguageRules(){
		return this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangRules).getValOatMapLH();
	}
}
