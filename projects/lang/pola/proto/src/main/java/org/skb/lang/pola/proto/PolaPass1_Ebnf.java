/* Copyright (c) 2009-2011 Sven van der Meer
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

package org.skb.lang.pola.proto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;

/**
 * Pass 1 of the Pola parser, syntax checks and building a symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class PolaPass1_Ebnf {
	static Logger logger = Logger.getLogger(PolaPass1_Ebnf.class);

	public AtomList atoms=AtomList.getInstance();
//	private ScopedName sn=ScopedName.getInstance();

//	private PropertyDeclarationList propertyDeclList=PropertyDeclarationList.getInstance();
//	private ContractDeclarationList contractDeclList=ContractDeclarationList.getInstance();

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

	public PolaPass1_Ebnf(){
		this.lastPropertyDeclScopeAtom="";
		this.propertyDeclScope=new LinkedHashMap<String,String>();

		this.lastContractDeclScopeAtom="";
		this.contractDeclScope=new LinkedHashMap<String,String>();
	}

	//add propertyDeclarationScope atoms and rank, check that atom is not redefined
	public void addPropertyDeclScopeAtom(Token atom){
		if(this.propertyDeclScope.containsKey(atom.getText()))
			ReportManager.getInstance().reportError(PolaTokensConstants.polaPROPERTY + " scope <" + atom.getText() + "> redefined for " + PolaTokensConstants.polaPROPERTY + " <" + this.atoms.scope.toString() + ">",atom);
		else
			lastPropertyDeclScopeAtom=atom.getText();
	}
	public void addPropertyDeclScopeRank(Token rank){this.propertyDeclScope.put(this.lastPropertyDeclScopeAtom,rank.getText());}
	public void propertyDeclScopeFinish(){
/*
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaCONTRACT),  DPOLTokens.polaCONTRACT,  this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaPACKAGE),   DPOLTokens.polaPACKAGE,   this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaELEMENT),   DPOLTokens.polaELEMENT,   this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaFACILITY),  DPOLTokens.polaFACILITY,  this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaACTION),    DPOLTokens.polaACTION,    this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaATTRIBUTE), DPOLTokens.polaATTRIBUTE, this.atoms.scope());
		this.propertyDeclList.add(this._getPropertyRankForScope(DPOLTokens.polaPARAMETER), DPOLTokens.polaPARAMETER, this.atoms.scope());
		this.propertyDeclScope.clear();
*/
	}
//	private String _getPropertyRankForScope(String scope){
//		String ret;
//		if(this.propertyDeclScope.containsKey(scope))
//			ret=this.propertyDeclScope.get(scope);
//		else
//			ret=LanguageTokens.polaNOT_DEF;
//		return ret;
//	}

	//and now the contract scopes
	public void addContractDeclScopeAtom(Token atom){
		if(this.contractDeclScope.containsKey(atom.getText()))
			ReportManager.getInstance().reportError(PolaTokensConstants.polaCONTRACT + " scope <" + atom.getText() + "> redefined for " + PolaTokensConstants.polaCONTRACT + " <" + this.atoms.scope.toString() +">",atom);
		else
			lastContractDeclScopeAtom=atom.getText();
	}
	public void addContractDeclScopeRank(Token rank){
		this.contractDeclScope.put(this.lastContractDeclScopeAtom,rank.getText());
	}
	public void contractDeclScopeFinish(){
//		this.contractDeclList.add(this._getContractRankForScope(DPOLTokens.polaELEMENT),   DPOLTokens.polaELEMENT,   this.atoms.scope());
//		this.contractDeclList.add(this._getContractRankForScope(DPOLTokens.polaFACILITY),  DPOLTokens.polaFACILITY,  this.atoms.scope());
		this.contractDeclScope.clear();
	}
//	private String _getContractRankForScope(String scope){
//		String ret;
//		if(this.contractDeclScope.containsKey(scope))
//			ret=this.contractDeclScope.get(scope);
//		else
//			ret=LanguageTokens.polaNOT_DEF;
//		return ret;
//	}

	public void identsStart(){this.tempIdents.clear();}
	private void _identsAdd(Token tk){this.tempIdents.add(tk.getText());}

	public void identsAddItemDef(Token tk){
		if(this.tempIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once","in " + PolaTokensConstants.parserItemProp + " definition: " + tk.getText(),tk.getLine(),tk.getCharPositionInLine());
		else
			this._identsAdd(tk);
	}
	public void identsAddPropDef(Token tk){
		if(this.tempIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once","in " + PolaTokensConstants.polaPROPERTY + " definition: " + tk.getText(),tk.getLine(),tk.getCharPositionInLine());
		else
			this._identsAdd(tk);
	}

	public void contIdentsStart(){this.tempContIdents.clear();}
	public void contIdentsAdd(Token tk){
		if(this.tempContIdents.contains(tk.getText()))
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once","in " + PolaTokensConstants.polaCONTRACT + " definition: " + tk.getText(),tk.getLine(),tk.getCharPositionInLine());
		else
			this.tempContIdents.add(tk.getText());
	}

	public void contractItemDeclAdd(String property){
//		this.contractDeclList.addItemDecl(this.lastContract, this.lastItem, property, this.lastItemPropRank);
	}
}
