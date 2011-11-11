package org.skb.lang.cola.proto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.skb.lang.cola.proto.constants.ColaConstants;

public class DeclarationLists {
	private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> propertyDeclMap;
	private LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> contractDeclMap;

	public DeclarationLists(){
		this.initPropertyDeclMap();
		initContractDeclMap();
	}

	private void initPropertyDeclMap(){
		this.propertyDeclMap=new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

		this.propertyDeclMap.put(ColaConstants.Tokens.colaREQUIRED, new LinkedHashMap<String, ArrayList<String>>());
	    this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaMANDATORY, new LinkedHashMap<String, ArrayList<String>>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaOPTIONAL, new LinkedHashMap<String, ArrayList<String>>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());

		this.propertyDeclMap.put(ColaConstants.Tokens.colaNOT_DEF, new LinkedHashMap<String, ArrayList<String>>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaPACKAGE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaACTION, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaATTRIBUTE, new ArrayList<String>());
		this.propertyDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaPARAMETER, new ArrayList<String>());
	}

	private void initContractDeclMap(){
		this.contractDeclMap=new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

		this.contractDeclMap.put(ColaConstants.Tokens.colaREQUIRED, new LinkedHashMap<String, ArrayList<String>>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaREQUIRED).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractDeclMap.put(ColaConstants.Tokens.colaMANDATORY, new LinkedHashMap<String, ArrayList<String>>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaMANDATORY).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractDeclMap.put(ColaConstants.Tokens.colaOPTIONAL, new LinkedHashMap<String, ArrayList<String>>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaOPTIONAL).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());

		this.contractDeclMap.put(ColaConstants.Tokens.colaNOT_DEF, new LinkedHashMap<String, ArrayList<String>>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaELEMENT, new ArrayList<String>());
		this.contractDeclMap.get(ColaConstants.Tokens.colaNOT_DEF).put(ColaConstants.Tokens.colaFACILITY, new ArrayList<String>());
	}

	/**
	 * Add a property scope declaration.
	 * @param scopeRank the scope rank of the declaration, for instance not_def, required, mandatory
	 * @param scopeAtom the atom the rank is declared for, for instance element, contract, package
	 * @param declID the identifier of the property that declares the scope 
	 */
	public void addPropertyDecl(String scopeRank, String scopeAtom, String declID){
		this.propertyDeclMap.get(scopeRank).get(scopeAtom).add(declID);
	}

	/**
	 * Determines if a particular scope is defined.
	 * @param scopeRank the scope rank to look for
	 * @param scopeAtom the scope atom to look for
	 * @param declID the property that should declare it
	 * @return true if scope is defined for the property, false otherwise
	 */
	public boolean getPropertyScope(String scopeRank, String scopeAtom, String declID){
		return this.propertyDeclMap.get(scopeRank).get(scopeAtom).contains(declID);
	}

	/**
	 * Returns all properties that declare the specified scope
	 * @param scopeRank scope rank to look for
	 * @param scopeAtom scope atom to look for
	 * @return list of property identifiers that declare the scope
	 */
	public ArrayList<String> getPropertyScope(String scopeRank, String scopeAtom){
		return this.propertyDeclMap.get(scopeRank).get(scopeAtom);
	}

	/**
	 * Returns the complete property declaration list.
	 * @return property declaration list
	 */
	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> getPropertyDeclMap(){
		return new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>(this.propertyDeclMap);
	}

	/**
	 * Add a contract scope declaration.
	 * @param scopeRank the scope rank of the declaration, for instance not_def, required, mandatory
	 * @param scopeAtom the atom the rank is declared for, for instance element, contract, package
	 * @param declID the identifier of the contract that declares the scope 
	 */
	public void addContractScope(String scopeRank, String scopeAtom, String declID){
		this.contractDeclMap.get(scopeRank).get(scopeAtom).add(declID);
	}

	/**
	 * Determines if a particular scope is defined.
	 * @param scopeRank the scope rank to look for
	 * @param scopeAtom the scope atom to look for
	 * @param declID the contract that should declare it
	 * @return true if the declaration ID is in the map, false otherwise
	 */
	public boolean getContractScope(String scopeRank, String scopeAtom, String declID){
		return this.contractDeclMap.get(scopeRank).get(scopeAtom).contains(declID);
	}

	/**
	 * Returns all contracts that declare the specified scope
	 * @param scopeRank scope rank to look for
	 * @param scopeAtom scope atom to look for
	 * @return list of contract identifiers that declare the scope
	 */
	public ArrayList<String> getContractScope(String scopeRank, String scopeAtom){
		return this.contractDeclMap.get(scopeRank).get(scopeAtom);
	}

}
