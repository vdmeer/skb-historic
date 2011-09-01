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

import org.skb.util.misc.Json2Oat;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Read the json configuration of a parser and provide filtered access to it.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class LanguageConfiguration {
	private TSMapLH configuration;

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

	/**
	 * Singleton getInstance with default initialisation
	 * @return pointer to the LanguageConfiguration instance
	 */
	public static LanguageConfiguration getInstanceInit(){
		LanguageConfigurationHolder.INSTANCE._init();
		return LanguageConfigurationHolder.INSTANCE;
	}

	private LanguageConfiguration(){
		this._init();
	}

	private void _init(){
		this.configuration=new TSMapLH();
	}

	public void read(String[] url){
		//TODO not implemented yet
//		try{
//			Json2Oat j2o=new Json2Oat();
//			for(int i=0;i<url.length;i++)
//				this.configuration.merge(j2o.read(url[i]).getValOatMapLH());
//		}
//		catch (Exception e){
//			System.err.println("LanguageConfiguration: "+e);
//		}
	}

	public void read(String url){
		try{
			Json2Oat j2o=new Json2Oat();
			TSBase c=j2o.read(url);
			if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
				this.configuration=(TSMapLH)c;
		}
		catch (Exception e){
			System.err.println("LanguageConfiguration: "+e);
		}
	}
	
	public void read(File file){
		try{
			Json2Oat j2o=new Json2Oat();
			TSBase c=j2o.read(file);
			if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
				this.configuration=(TSMapLH)c;
		}
		catch (Exception e){
			System.err.println("LanguageConfiguration: "+e);
		}
	}

	public void validate(){
		//TODO nyi
	}

	public TSMapLH getConfiguration(){
		return this.configuration;
	}

	public TSMapLH getTribeConfiguration(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBTribeConfiguration)).tsGetValue();
	}

	public TSMapLH getLanguageConfiguration(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangConfiguration)).tsGetValue();
	}

	public TSMapLH getLanguageTokens(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangTokens)).tsGetValue();
	}

	public TSMapLH getLanguageTargets(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangTargets)).tsGetValue();
	}

	public TSMapLH getLanguageStgChunks(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangStgChunks)).tsGetValue();
	}

	public TSMapLH getLanguageRules(){
		return ((TSMapLH)this.configuration.get(LanguageConfigurationConstants.Paths.SKBLangRules)).tsGetValue();
	}
}
