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

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.base.composite.TSTableRowAPI;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.config.Configuration;
import org.skb.base.lang.AtomListUtils;
import org.skb.base.lang.NameScopeUtils;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;

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

	/** Parser Rule Manager for error/warning reporting */
	private StringTemplateGroup rules;

	/** List for Property Declarations */
	private PropertyDeclarationList propertyDeclList=(PropertyDeclarationList)config.config.get(ColaParser.pathInstancePropertyDeclarationList);

	/** List for Contract Declarations */
	private ContractDeclarationList contractDeclList=(ContractDeclarationList)config.config.get(ColaParser.pathInstanceContractDeclarationList);


	/**
	 * Class constructor, initialises the atom list (symbol table) and other local fields
	 */
	public ColaPass1_Ebnf(){
		this.rules=config.getParserRuleManager().getSTG();

		//initialise the AtomList with spec
		this.atoms=config.getAtomlist();
		this.atoms.addRow(ColaConstants.Tokens.colaSPECIFICATION);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValCategory, ColaConstants.Tokens.colaVOID);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValType, ColaConstants.Tokens.colaVOID);

		//this.atoms.setDefaultCategory(ColaConstants.Tokens.colaDEFINITION);
		
		this.reportManager=config.getReportManager();
		this.atoms.setReportMgr(this.reportManager);
	}

	/**
	 * Checks and adds a token to the list of temporary stored property identifiers.
	 * 
	 * The property identifier should have been defined in an Item declaration. The method will test if it is unique for
	 * this item declaration, and add if unique or log an error if not.
	 * @param token to be added and checked
	 */
//	public void identsAddItemDef(Token token){
//		if(this.tempPropIdents.contains(token.getText()))
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier04), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier04, new String[]{token.getText()}), token.getLine(), token.getCharPositionInLine());
//		else
//			this._identsAdd(token);
//	}

	/**
	 * Checks and adds a token to the list of temporary stored property identifiers.
	 * 
	 * The property identifier should have been defined in a Contract declaration. The method will test if it is unique for
	 * this contract declaration, and add if unique or log an error if not.
	 * @param token to be added and checked
	 */
//	public void identsAddPropDef(Token token){
//		if(this.tempPropIdents.contains(token.getText()))
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier05), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier05, new String[]{token.getText()}), token.getLine(), token.getCharPositionInLine());
//		else
//			this._identsAdd(token);
//	}

	/**
	 * Checks and adds a token to the list of temporary stored contract identifiers.
	 * 
	 * If the token is already in the list, an error will be logged, otherwise the token will be added to the list.
	 * @param token to be added
	 */
//	public void contIdentsAdd(Token token){
//		if(this.tempContIdents.contains(token.getText()))
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier06), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier06, new String[]{token.getText()}), token.getLine(), token.getCharPositionInLine());
//		else
//			this.tempContIdents.add(token.getText());
//	}




	/**
	 * Puts a new atom into the Atom List (Symbol Table), logs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 * @param array null if no array, anything else otherwise
	 */
	public void putAtom(Token token, String category, Token type, Object array){
		boolean ar=false;
		if(array!=null)
			ar=true;
		TSTableRowAPI otr=this.atoms.putAtom(token, category, type, ar);
		if(otr!=null){
			StringTemplate err;
			if(category.equals(ColaConstants.Tokens.colaAT_SCOPE)){
				//we have an error for either Property Scope or Contract Scope declarations
				String scopeAtom=AtomListUtils.getParentID(this.atoms);
				String declId=NameScopeUtils.getParentID(scopeAtom, this.atoms.scope.getSeparator());
				String parCat=AtomListUtils.getParentCategory(scopeAtom, this.atoms);
				scopeAtom=scopeAtom.substring(scopeAtom.indexOf(this.atoms.scope.getSeparator())+this.atoms.scope.getSeparator().length(), scopeAtom.length());
				if(parCat.equals(ColaConstants.Tokens.colaPROPERTY)){
					err=this.rules.getInstanceOf("property14");
				}
				else{
					err=this.rules.getInstanceOf("contract05");
				}
				err.setAttribute("do_error", true);
				err.setAttribute("scope", scopeAtom);
				err.setAttribute("ident", declId);
				this.reportManager.error(err.toString(), token);
			}
			else{
				//general problem with not unique Identifier
				err=this.rules.getInstanceOf("identifier01");
				err.setAttribute("do_error", true);
				err.setAttribute("ident", otr.get(TSAtomList.alValScopedID));
				err.setAttribute("category", category);
				err.setAttribute("categoryOrig", otr.get(TSAtomList.alValCategory));
				err.setAttribute("fileOrig", otr.get(TSAtomList.alValFile));
				err.setAttribute("lineOrig", otr.get(TSAtomList.alValLine));
				err.setAttribute("colOrig", otr.get(TSAtomList.alValColumn));
				this.reportManager.error(err.toString(), token);
			}
			return;
		}
		if(category.equals(ColaConstants.Tokens.colaAT_SCOPE)){
			//current scope holds all information: declId::scopeAtom::scopeRank - now we tokenise it and use the last three entries in the array (everything else is scoped name)
			String[] tok=this.atoms.scope.toString().split(this.atoms.scope.getSeparator());
			int tokLen=tok.length-1;

			String scopeRank=tok[tokLen];
			String scopeAtom=tok[tokLen-1];
			String declID=tok[tokLen-2];
			String parCat=AtomListUtils.getParentCategory(AtomListUtils.getParentID(this.atoms), this.atoms);
			if(parCat.equals(ColaConstants.Tokens.colaPROPERTY))
				this.propertyDeclList.add(scopeRank, scopeAtom, declID);
			if(parCat.equals(ColaConstants.Tokens.colaCONTRACT))
				this.contractDeclList.add(scopeRank, scopeAtom, declID);
		}
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), logs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 */
	public void putAtom(Token token, String category){
		this.putAtom(token, category, null, null);
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), logs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 */
	public void putAtom(Token token, String category, Token type){
		this.putAtom(token, category, type, null);
	}
}
