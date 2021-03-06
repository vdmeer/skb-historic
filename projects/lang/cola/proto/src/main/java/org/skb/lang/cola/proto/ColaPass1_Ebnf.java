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
import org.skb.tribe.LanguageRuleMap;
import org.skb.util.languages.AtomList;
import org.skb.util.misc.ReportManager;
import org.skb.util.types.api.TSTableRowAPI;

/**
 * Pass 1 of the Cola parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ColaPass1_Ebnf {
	static Logger logger = Logger.getLogger(ColaPass1_Ebnf.class);

	public AtomList atoms;

	private LanguageRuleMap cr;

	private PropertyDeclarationList propertyDeclList=PropertyDeclarationList.getInstance();
	private ContractDeclarationList contractDeclList=ContractDeclarationList.getInstance();

	//for property declarations, scope check and list build
	private String lastPropertyDeclScopeAtom;
	private LinkedHashMap<String,String> propertyDeclScope;

	//for property declarations, scope check and list build only
	private String lastContractDeclScopeAtom;
	private LinkedHashMap<String,String> contractDeclScope;

	//Idents (names bound to properties/items as type)
	private ArrayList<String> tempIdents=new ArrayList<String>();
	//Idents (names bound to contracts as type)
	private ArrayList<String> tempContIdents=new ArrayList<String>();

	private String lastContract=null;
	private String lastItem=null;
	private String lastItemPropRank=null;

	public ColaPass1_Ebnf(){
		this.lastPropertyDeclScopeAtom="";
		this.propertyDeclScope=new LinkedHashMap<String,String>();

		this.lastContractDeclScopeAtom="";
		this.contractDeclScope=new LinkedHashMap<String,String>();

		this.cr=new LanguageRuleMap();
		this.cr.setClassName(ColaConstants.Rules.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();		

		//initialise the AtomList with spec
		this.atoms=AtomList.getInstanceInit();
		this.atoms.addRow(ColaConstants.Tokens.colaSPECIFICATION);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, AtomList.alValCategory, ColaConstants.Tokens.colaVOID);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, AtomList.alValType, ColaConstants.Tokens.colaVOID);

		this.atoms.setDefaultCategory(ColaConstants.Tokens.colaDEFINITION);
	}

	//add propertyDeclarationScope atoms and rank, check that atom is not redefined
	public void addPropertyDeclScopeAtom(Token atom){
		if(this.propertyDeclScope.containsKey(atom.getText()))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaConstants.Rules.ruleProperty14, new String[]{atom.getText(), this.atoms.scope.toString()}),
					atom);
		else
			lastPropertyDeclScopeAtom=atom.getText();
	}
	public void addPropertyDeclScopeRank(Token rank){this.propertyDeclScope.put(this.lastPropertyDeclScopeAtom,rank.getText());}
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
	private String _getPropertyRankForScope(String scope){
		String ret;
		if(this.propertyDeclScope.containsKey(scope))
			ret=this.propertyDeclScope.get(scope);
		else
			ret=ColaConstants.Tokens.colaNOT_DEF;
		return ret;
	}

	//and now the contract scopes
	public void addContractDeclScopeAtom(Token atom){
		if(this.contractDeclScope.containsKey(atom.getText()))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaConstants.Rules.ruleContract05, new String[]{atom.getText(), this.atoms.scope.toString()}),
					atom);
		else
			lastContractDeclScopeAtom=atom.getText();
	}
	public void addContractDeclScopeRank(Token rank){
		this.contractDeclScope.put(this.lastContractDeclScopeAtom,rank.getText());
	}
	public void contractDeclScopeFinish(){
		this.contractDeclList.add(this._getContractRankForScope(ColaConstants.Tokens.colaELEMENT),   ColaConstants.Tokens.colaELEMENT,   this.atoms.scope.toString());
		this.contractDeclList.add(this._getContractRankForScope(ColaConstants.Tokens.colaFACILITY),  ColaConstants.Tokens.colaFACILITY,  this.atoms.scope.toString());
		this.contractDeclScope.clear();
	}
	private String _getContractRankForScope(String scope){
		String ret;
		if(this.contractDeclScope.containsKey(scope))
			ret=this.contractDeclScope.get(scope);
		else
			ret=ColaConstants.Tokens.colaNOT_DEF;
		return ret;
	}

	public void identsStart(){this.tempIdents.clear();}
	private void _identsAdd(Token tk){this.tempIdents.add(tk.getText());}

	public void identsAddItemDef(Token tk){
		if(this.tempIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier04),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier04, new String[]{tk.getText()}),
					tk.getLine(),
					tk.getCharPositionInLine());
		else
			this._identsAdd(tk);
	}
	public void identsAddPropDef(Token tk){
		if(this.tempIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier05),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier05, new String[]{tk.getText()}),
					tk.getLine(),
					tk.getCharPositionInLine());
		else
			this._identsAdd(tk);
	}

	public void contIdentsStart(){this.tempContIdents.clear();}
	public void contIdentsAdd(Token tk){
		if(this.tempContIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaConstants.Rules.ruleIdentifier06),
					this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier06, new String[]{tk.getText()}),
					tk.getLine(),
					tk.getCharPositionInLine());
		else
			this.tempContIdents.add(tk.getText());
	}

	public void contractItemDeclAdd(String property){
		this.contractDeclList.addItemDecl(this.lastContract, this.lastItem, property, this.lastItemPropRank);
	}

	public void lastContract(){this.lastContract=this.atoms.getLastID();}
	public void lastItem(){this.lastItem=this.atoms.getLastID();}
	public void lastItemPropRank(Token rank){this.lastItemPropRank=rank.getText();}

	//from atoms, only here for error handling
	public void putAtom(Token tk, String category, Token type, Boolean array){
		TSTableRowAPI otr=this.atoms.putAtom(tk, category, type, array);
		if(otr!=null){
			ReportManager.getInstance().reportError(
					ColaConstants.Tokens.parserIDENTIFIER+" used more than once",
					tk,
					ColaConstants.Tokens.parserIDENTIFIER+": " + otr.get(AtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(AtomList.alValCategory) + " at " + otr.get(AtomList.alValFile) + ":" + otr.get(AtomList.alValLine) + ":" + otr.get(AtomList.alValColumn));
		}
	}

	public void putAtom(Token tk, String category){
		this.putAtom(tk, category, null);
	}

	public void putAtom(Token tk, String category, Token type){
		this.putAtom(tk, category, type, false);
	}

}
