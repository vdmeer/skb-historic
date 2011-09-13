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

import org.apache.commons.lang.StringUtils;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.composite.util.TSLangRuleMap;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * Class that reads parser rules and provides them for pass1/2 of parsers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class LanguageRuleMap extends TSLangRuleMap {
	private String className;
	private String key;

	public LanguageRuleMap(){
		super();
	}

	public void setClassName(String s){
		this.className=s;
	}

	public void setKey(String s){
		this.key=s;
	}

	public void loadRules(){
		if(this.className==null&&this.key==null)
			return;

		this.addRows(this.className, this.key);

		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		TSMapLH map=cfg.getLanguageRules();

		if(map!=null){
			TSMapLH tokens=cfg.getLanguageTokens();

			for (String s:map.keySet()){
				TSBaseAPI rm=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangRulesMessage);
				TSBaseAPI rmIns=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangRulesMessageInsertPath);
				if(rm!=null){
					if(rmIns!=null){
						TSBaseAPI replace=tokens.get(rmIns.toString()+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensConstVal);
						if(replace!=null)
							this.put(s, TSLangRuleMap.rmValRuleMessage, StringUtils.replace(rm.toString(), "####", replace.toString()));
						else
							this.put(s, TSLangRuleMap.rmValRuleMessage, rm.toString());
					}
					else
						this.put(s, TSLangRuleMap.rmValRuleMessage, rm.toString());
				}

				TSBaseAPI rmAdd=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangRulesMessageAdd);
				TSBaseAPI rmAddIns=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangRulesMessageAddInsertPath);
				if(rmAdd!=null){
					if(rmAddIns!=null){
						TSBaseAPI replace=tokens.get(rmAddIns.toString()+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensConstVal);
						if(replace!=null)
							this.put(s, TSLangRuleMap.rmValRuleAddMessage, StringUtils.replace(rmAdd.toString(), "####", replace.toString()));
						else
							this.put(s, TSLangRuleMap.rmValRuleAddMessage, rmAdd.toString());
					}
					else
						this.put(s, TSLangRuleMap.rmValRuleAddMessage, rmAdd.toString());
				}

			}
		}
	}
}
