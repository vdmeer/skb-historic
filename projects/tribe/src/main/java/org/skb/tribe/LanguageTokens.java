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

package org.skb.tribe;

import java.util.TreeMap;

import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.composite.util.OatMapLH;

/**
 * Class that reads language tokens from the configuration and processes them for parser/lexer.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class LanguageTokens {
    public TreeMap<String, String> tokens;
    private String[] tokenNames;

    public LanguageTokens(){}

	private static class LanguageTokensHolder{
		private final static LanguageTokens INSTANCE = new LanguageTokens();
	}

	public static LanguageTokens getInstance(){
		return LanguageTokensHolder.INSTANCE;
	}

    public void addTokens(String[] tokens){
    	this.tokens = new TreeMap<String, String>();

		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		OatMapLH map=cfg.getLanguageTokens();

    	if(map!=null){
    		OatMapLH tokenStrings=new OatMapLH();
    		if(map!=null&&map.size()>0){
    			for(String s:map.keySet()){
    				try{
    					OatString tid=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensTokenID).getValOatAtomicString();
    				    OatString tval=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensTokenVal).getValOatAtomicString();
    				    tokenStrings.put(tid, tval);
    				} catch (Exception e){}
    			}
    		}
    		if(tokenStrings.size()>0){
    			for(String s:tokenStrings.keySet()){
    				this.tokens.put(s,tokenStrings.get(s).toString());
    			}
    		}
    	}
        this.tokenNames=new String[tokens.length];
        for(int i=0;i<tokens.length;i++){
        	if(this.tokens.get(tokens[i])!=null)
            	this.tokenNames[i]=this.tokens.get(tokens[i]);
        	else
            	this.tokenNames[i]=tokens[i];
        }
    }

    public String[] getTokenNames() {
        return this.tokenNames;
    }
}
