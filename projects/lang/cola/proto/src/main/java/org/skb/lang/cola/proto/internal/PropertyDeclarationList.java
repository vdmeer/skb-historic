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

import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.util.composite.TSAtomic;

/**
 * Helper class maintaining the list of property declarations.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PropertyDeclarationList extends TSAtomic {
	private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> propertyDeclMap;
	
	/**
	 * Class constructor.
	 */
	public PropertyDeclarationList(){
		this.propertyDeclMap=new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

		this.propertyDeclMap.put(ColaConstants.Tokens.colaREQUIRED, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaCONTRACT, new ArrayList<String>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaMANDATORY, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaOPTIONAL, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaNOT_DEF, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaCONTRACT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());
	}

	/**
	 * Add a property scope declaration.
	 * @param scopeRank the scope rank of the declaration, for instance not_def, required, mandatory
	 * @param scopeAtom the atom the rank is declared for, for instance element, contract, package
	 * @param declID the identifier of the property that declares the scope 
	 */
	public void add(String scopeRank, String scopeAtom, String declID){
		this.propertyDeclMap.get(scopeRank).get(scopeAtom).add(declID);
	}

	/**
	 * Determines if a particular scope is defined.
	 * @param scopeRank the scope rank to look for
	 * @param scopeAtom the scope atom to look for
	 * @param declID the property that should declare it
	 * @return
	 */
	public boolean get(String scopeRank, String scopeAtom, String declID){
		return this.propertyDeclMap.get(scopeRank).get(scopeAtom).contains(declID);
	}

	/**
	 * Returns all properties that declare the specified scope
	 * @param scopeRank scope rank to look for
	 * @param scopeAtom scope atom to look for
	 * @return list of property identifiers that declare the scope
	 */
	public ArrayList<String> get(String scopeRank, String scopeAtom){
		return this.propertyDeclMap.get(scopeRank).get(scopeAtom);
	}

	/**
	 * Returns the complete property declaration list.
	 * @return property declaration list
	 */
	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> getList(){
		return new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>(this.propertyDeclMap);
	}
}
