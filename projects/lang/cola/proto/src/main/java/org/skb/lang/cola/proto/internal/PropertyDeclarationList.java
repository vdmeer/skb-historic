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

package org.skb.lang.cola.proto.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.skb.lang.cola.proto.ColaTokensConstants;

/**
 * Internal class maintaining a list of property declarations.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class PropertyDeclarationList {
	private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> propertyDeclMap;
	
	public PropertyDeclarationList(){
		this.propertyDeclMap=new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

		this.propertyDeclMap.put(ColaTokensConstants.colaREQUIRED, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaCONTRACT, new ArrayList<String>());
	    this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaREQUIRED).put(ColaTokensConstants.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaTokensConstants.colaMANDATORY, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaMANDATORY).put(ColaTokensConstants.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaTokensConstants.colaOPTIONAL, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaOPTIONAL).put(ColaTokensConstants.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaTokensConstants.colaNOT_DEF, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaTokensConstants.colaNOT_DEF).put(ColaTokensConstants.colaPARAMETER, new ArrayList<String>());
	}

	private static class PropertyDeclarationListHolder{
		private final static PropertyDeclarationList INSTANCE = new PropertyDeclarationList();
	}

	public static PropertyDeclarationList getInstance(){
		return PropertyDeclarationListHolder.INSTANCE;
	}

	public void add(String key, String column, String val){
		this.propertyDeclMap.get(key).get(column).add(val);
	}

	public boolean get(String key, String column, String property){
		return this.propertyDeclMap.get(key).get(column).contains(property);
	}

	public ArrayList<String> get(String key, String column){
		return this.propertyDeclMap.get(key).get(column);
	}

	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> getList(){
		return new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>(this.propertyDeclMap);
	}
}
