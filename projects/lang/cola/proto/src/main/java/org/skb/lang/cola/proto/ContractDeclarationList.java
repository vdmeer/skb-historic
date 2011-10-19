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

package org.skb.lang.cola.proto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.skb.lang.cola.proto.constants.ColaConstants;

/**
 * Internal class maintaining a list of contract declarations.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ContractDeclarationList {
	private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> contractScopesDeclMap;
	private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> contractItemsDeclMap;

	/**
	 * Class constructor.
	 */
	public ContractDeclarationList(){
		this.contractItemsDeclMap=new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>();

		this.contractScopesDeclMap=new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

		this.contractScopesDeclMap.put(ColaConstants.Tokens.colaREQUIRED, new LinkedHashMap<String, ArrayList<String>>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractScopesDeclMap.put(ColaConstants.Tokens.colaMANDATORY, new LinkedHashMap<String, ArrayList<String>>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractScopesDeclMap.put(ColaConstants.Tokens.colaOPTIONAL, new LinkedHashMap<String, ArrayList<String>>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractScopesDeclMap.put(ColaConstants.Tokens.colaNOT_DEF, new LinkedHashMap<String, ArrayList<String>>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractScopesDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
	}

	/**
	 * Add a contract scope declaration.
	 * @param scopeRank the scope rank of the declaration, for instance not_def, required, mandatory
	 * @param scopeAtom the atom the rank is declared for, for instance element, contract, package
	 * @param declID the identifier of the contract that declares the scope 
	 */
	public void add(String scopeRank, String scopeAtom, String declID){
		this.contractScopesDeclMap.get(scopeRank).get(scopeAtom).add(declID);
	}

	/**
	 * Determines if a particular scope is defined.
	 * @param scopeRank the scope rank to look for
	 * @param scopeAtom the scope atom to look for
	 * @param declID the contract that should declare it
	 * @return
	 */
	public boolean get(String scopeRank, String scopeAtom, String declID){
		return this.contractScopesDeclMap.get(scopeRank).get(scopeAtom).contains(declID);
	}

	/**
	 * Returns all contracts that declare the specified scope
	 * @param scopeRank scope rank to look for
	 * @param scopeAtom scope atom to look for
	 * @return list of contract identifiers that declare the scope
	 */
	public ArrayList<String> get(String scopeRank, String scopeAtom){
		return this.contractScopesDeclMap.get(scopeRank).get(scopeAtom);
	}

	/**
	 * Adds a declared property with associated rank to an item of a contract.
	 * @param contract identifier if the contract, ideally a scoped name
	 * @param item identifier of the item
	 * @param property identifier of the property
	 * @param rank rank of the property
	 */
	public void addItemDecl(String contract, String item, String property, String rank){
		if(!this.contractItemsDeclMap.containsKey(contract))
			this.contractItemsDeclMap.put(contract, new LinkedHashMap<String, LinkedHashMap<String, String>>());
		if(!this.contractItemsDeclMap.get(contract).containsKey(item))
			this.contractItemsDeclMap.get(contract).put(item, new LinkedHashMap<String, String>());
		this.contractItemsDeclMap.get(contract).get(item).put(property, rank);
	}

	/**
	 * Returns true if the contract item property is declared for the given rank, false otherwise
	 * @param contract contract to look for
	 * @param item item to look for 
	 * @param property property to look for
	 * @param rank rank to test for
	 * @return
	 */
	public boolean getItemDeclPropertyRank(String contract, String item, String property, String rank){
		if(this.contractItemsDeclMap.containsKey(contract)){
			if(this.contractItemsDeclMap.get(contract).containsKey(item)){
				if(this.contractItemsDeclMap.get(contract).get(item).containsKey(property)){
					if(this.contractItemsDeclMap.get(contract).get(item).get(property).toString().equals(rank)){
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}

	public ArrayList<String> getArrayForRank(String contract, String item, String rank){
		ArrayList<String> ret=new ArrayList<String>();
		if(this.contractItemsDeclMap.containsKey(contract)){
			if(this.contractItemsDeclMap.get(contract).containsKey(item)){
				Set<String> lSet= this.contractItemsDeclMap.get(contract).get(item).keySet();
				Iterator<String> itr2 = lSet.iterator();
				while(itr2.hasNext()){
					String key = itr2.next();
					if(this.contractItemsDeclMap.get(contract).get(item).get(key).toString().equals(rank))
						ret.add(key);
				}
			}
		}
		return ret;
	}

	public LinkedHashMap<String, ArrayList<String>> getDeclaredItems(){
		LinkedHashMap<String, ArrayList<String>> ret=new LinkedHashMap<String, ArrayList<String>>();

		String contract;
		Set<String> contSet= this.contractItemsDeclMap.keySet();
		Iterator<String> contItr = contSet.iterator();
		while(contItr.hasNext()){
			contract=contItr.next();
			ret.put(contract, new ArrayList<String>());
			Set<String> itemSet= this.contractItemsDeclMap.get(contract).keySet();
			Iterator<String> itemItr = itemSet.iterator();
			while(itemItr.hasNext())
				ret.get(contract).add(itemItr.next());
		}
		return ret;
	}

	public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> getContractItemsDeclMap(){
		return this.contractItemsDeclMap;
	}
}
