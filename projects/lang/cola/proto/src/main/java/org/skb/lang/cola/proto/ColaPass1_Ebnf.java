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
import java.util.LinkedHashMap;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;
import org.skb.util.classic.config.Configuration;
import org.skb.util.composite.TSTableRowAPI;
import org.skb.util.composite.lang.TSAtomList;
import org.skb.util.composite.misc.TSReportManager;
import org.skb.util.composite.util.TSLangRuleMap;

/**
 * Pass 1 of the Cola parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ColaPass1_Ebnf {
	/** Logger instance */
	static Logger logger = Logger.getLogger(ColaPass1_Ebnf.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(ColaParser.class);

	/** Report Manager instance */
	private TSReportManager reportManager;

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

	/** Language Rule map for error/warning reporting */
	private TSLangRuleMap cr;

	/** List for Property Declarations */
	private PropertyDeclarationList propertyDeclList=PropertyDeclarationList.getInstance();
	/** List for Contract Declarations */
	private ContractDeclarationList contractDeclList=ContractDeclarationList.getInstance();

	/** Holds the last parsed scope atom in a property declarations */
	private String lastPropertyDeclScopeAtom;
	/** Holds the scopes of the current property declaration, for scope checks */
	private LinkedHashMap<String,String> propertyDeclScope;

	/** Holds the last parsed scope atom in a contract declarations */
	private String lastContractDeclScopeAtom;
	/** Holds the scopes of the current contract declaration, for scope checks */
	private LinkedHashMap<String,String> contractDeclScope;

	/** Temporary storage of Identifiers bound to properties or items as type */
	private ArrayList<String> tempPropIdents=new ArrayList<String>();
	/** Temporary storage of Identifiers bound to contracts or items as type */
	private ArrayList<String> tempContIdents=new ArrayList<String>();

	/** ID of last parsed contract */
	private String lastContract=null;
	/** ID of last parsed item */
	private String lastItem=null;
	/** ID of last parsed item property rank */
	private String lastItemPropRank=null;


	/**
	 * Class constructor, initialises the atom list (symbol table) and other local fields
	 */
	public ColaPass1_Ebnf(){
		this.lastPropertyDeclScopeAtom="";
		this.propertyDeclScope=new LinkedHashMap<String,String>();

		this.lastContractDeclScopeAtom="";
		this.contractDeclScope=new LinkedHashMap<String,String>();

		this.cr=config.getLangRuleMap();

		//initialise the AtomList with spec
		this.atoms=config.getAtomlist();
		this.atoms.addRow(ColaConstants.Tokens.colaSPECIFICATION);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValCategory, ColaConstants.Tokens.colaVOID);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValType, ColaConstants.Tokens.colaVOID);

		this.atoms.setDefaultCategory(ColaConstants.Tokens.colaDEFINITION);

		this.reportManager=config.getReportManager();
	}


	/**
	 * Stores the last parsed property scope in a property declaration if it not exists, logs error if is already defined
	 * @param atom to be checked and stored
	 */
	public void addPropertyDeclScopeAtom(Token atom){
		if(this.propertyDeclScope.containsKey(atom.getText()))
			this.reportManager.reportError(
					this.cr.getRule(ColaConstants.Rules.ruleProperty14, new String[]{atom.getText(), this.atoms.scope.toString()}),
					atom);
		else
			lastPropertyDeclScopeAtom=atom.getText();
	}


	/**
	 * Adds the parsed rank to the last parsed atom for a property scope declaration.
	 * @param rank to be stored
	 */
	public void addPropertyDeclScopeRank(Token rank){
		this.propertyDeclScope.put(this.lastPropertyDeclScopeAtom,rank.getText());
	}


	/**
	 * Finishes the property scope declaration and empties the temporary property scope list.
	 */
	public void propertyDeclScopeFinish(){
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaCONTRACT),  ColaConstants.Tokens.colaCONTRACT,  this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaPACKAGE),   ColaConstants.Tokens.colaPACKAGE,   this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaELEMENT),   ColaConstants.Tokens.colaELEMENT,   this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaFACILITY),  ColaConstants.Tokens.colaFACILITY,  this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaACTION),    ColaConstants.Tokens.colaACTION,    this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaATTRIBUTE), ColaConstants.Tokens.colaATTRIBUTE, this.atoms.scope.toString());
		this.propertyDeclList.add(this._getPropertyRankForScope(ColaConstants.Tokens.colaPARAMETER), ColaConstants.Tokens.colaPARAMETER, this.atoms.scope.toString());
		this.propertyDeclScope.clear();
	}


	/**
	 * Returns the rank for a given property scope
	 * @param scope property scope atom
	 * @return the parsed/stored rank of the scope exists, colaNOT_DEF otherwise
	 */
	private String _getPropertyRankForScope(String scope){
		String ret;
		if(this.propertyDeclScope.containsKey(scope))
			ret=this.propertyDeclScope.get(scope);
		else
			ret=ColaConstants.Tokens.colaNOT_DEF;
		return ret;
	}

	//and now the contract scopes
	/**
	 * Stores the last parsed contract scope in a contract declaration if it not exists, logs error if is already defined
	 * @param atom to be checked and stored
	 */
	public void addContractDeclScopeAtom(Token atom){
		if(this.contractDeclScope.containsKey(atom.getText()))
			this.reportManager.reportError(
					this.cr.getRule(ColaConstants.Rules.ruleContract05, new String[]{atom.getText(), this.atoms.scope.toString()}),
					atom);
		else
			lastContractDeclScopeAtom=atom.getText();
	}


	/**
	 * Adds the parsed rank to the last parsed atom for a contract scope declaration.
	 * @param rank to be stored
	 */
	public void addContractDeclScopeRank(Token rank){
		this.contractDeclScope.put(this.lastContractDeclScopeAtom,rank.getText());
	}


	/**
	 * Finishes the contract scope declaration and empties the temporary contract scope list.
	 */
	public void contractDeclScopeFinish(){
		this.contractDeclList.add(this._getContractRankForScope(ColaConstants.Tokens.colaELEMENT),   ColaConstants.Tokens.colaELEMENT,   this.atoms.scope.toString());
		this.contractDeclList.add(this._getContractRankForScope(ColaConstants.Tokens.colaFACILITY),  ColaConstants.Tokens.colaFACILITY,  this.atoms.scope.toString());
		this.contractDeclScope.clear();
	}


	/**
	 * Returns the rank for a given contract scope
	 * @param scope contract scope atom
	 * @return the parsed/stored rank of the scope exists, colaNOT_DEF otherwise
	 */
	private String _getContractRankForScope(String scope){
		String ret;
		if(this.contractDeclScope.containsKey(scope))
			ret=this.contractDeclScope.get(scope);
		else
			ret=ColaConstants.Tokens.colaNOT_DEF;
		return ret;
	}


	/**
	 * Clears the list of temporary stored property identifiers.
	 */
	public void identsStart(){
		this.tempPropIdents.clear();
	}


	/**
	 * Adds a token to the list of temporary stored property identifiers.
	 * @param token to be added
	 */
	private void _identsAdd(Token token){
		this.tempPropIdents.add(token.getText());
	}


	/**
	 * Checks and adds a token to the list of temporary stored property identifiers.
	 * 
	 * The property identifier should have been defined in an Item declaration. The method will test if it is unique for
	 * this item declaration, and add if unique or log an error if not.
	 * @param token to be added and checked
	 */
	public void identsAddItemDef(Token token){
		if(this.tempPropIdents.contains(token.getText()))
			this.reportManager.reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier04),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier04, new String[]{token.getText()}),
					token.getLine(),
					token.getCharPositionInLine());
		else
			this._identsAdd(token);
	}


	/**
	 * Checks and adds a token to the list of temporary stored property identifiers.
	 * 
	 * The property identifier should have been defined in a Contract declaration. The method will test if it is unique for
	 * this contract declaration, and add if unique or log an error if not.
	 * @param token to be added and checked
	 */
	public void identsAddPropDef(Token token){
		if(this.tempPropIdents.contains(token.getText()))
			this.reportManager.reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier05),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier05, new String[]{token.getText()}),
					token.getLine(),
					token.getCharPositionInLine());
		else
			this._identsAdd(token);
	}


	/**
	 * Clears the list of temporary stored contract identifiers.
	 */
	public void contIdentsStart(){
		this.tempContIdents.clear();
	}


	/**
	 * Checks and adds a token to the list of temporary stored contract identifiers.
	 * 
	 * If the token is already in the list, an error will be logged, otherwise the token will be added to the list.
	 * @param token to be added
	 */
	public void contIdentsAdd(Token token){
		if(this.tempContIdents.contains(token.getText()))
			this.reportManager.reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier06),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier06, new String[]{token.getText()}),
					token.getLine(),
					token.getCharPositionInLine());
		else
			this.tempContIdents.add(token.getText());
	}


	/**
	 * Adds a property declaration parsed within an Item of a Contract to the contract declaration list.
	 * @param property to be added
	 */
	public void contractItemDeclAdd(String property){
		this.contractDeclList.addItemDecl(this.lastContract, this.lastItem, property, this.lastItemPropRank);
	}


	/**
	 * Stores the last parsed Identifier as a contract identifier.
	 */
	public void lastContract(){
		this.lastContract=this.atoms.getLastID();
	}


	/**
	 * Stores the last parsed Identifier as an item identifier.
	 */
	public void lastItem(){
		this.lastItem=this.atoms.getLastID();
	}


	/**
	 * Stores the last parsed item property rank.
	 * @param rank to be stored
	 */
	public void lastItemPropRank(Token rank){
		this.lastItemPropRank=rank.getText();
	}


	/**
	 * Puts a new atom into the Atom List (Symbol Table), loggs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 * @param array true if it is an array, false otherwise
	 */
	public void putAtom(Token token, String category, Token type, Boolean array){
		TSTableRowAPI otr=this.atoms.putAtom(token, category, type, array);
		if(otr!=null){
			this.reportManager.reportError(
					ColaConstants.Tokens.parserIDENTIFIER+" used more than once",
					token,
					ColaConstants.Tokens.parserIDENTIFIER+": " + otr.get(TSAtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(TSAtomList.alValCategory) + " at " + otr.get(TSAtomList.alValFile) + ":" + otr.get(TSAtomList.alValLine) + ":" + otr.get(TSAtomList.alValColumn));
		}
	}


	/**
	 * Puts a new atom into the Atom List (Symbol Table), loggs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 */
	public void putAtom(Token token, String category){
		this.putAtom(token, category, null);
	}


	/**
	 * Puts a new atom into the Atom List (Symbol Table), loggs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 */
	public void putAtom(Token token, String category, Token type){
		this.putAtom(token, category, type, false);
	}

}
