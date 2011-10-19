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
import org.skb.base.utils.AtomListUtils;
import org.skb.base.utils.NameScopeUtils;
import org.skb.base.utils.StringUtils;
import org.skb.lang.cola.proto.constants.ColaConstants;

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


	/**
	 * Class constructor, initialises the atom list (symbol table) and other local fields
	 */
	public ColaPass1_Ebnf(){
		this.rules=config.getParserRuleManager().getSTG();

		//initialise the AtomList with spec
		this.atoms=config.getAtomlist();
		this.atoms.addRow(ColaConstants.Tokens.colaSPECIFICATION);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValCategory, ColaConstants.Tokens.typeVOID);
		this.atoms.put(ColaConstants.Tokens.colaSPECIFICATION, TSAtomList.alValType, ColaConstants.Tokens.typeVOID);

		//this.atoms.setDefaultCategory(ColaConstants.Tokens.colaDEFINITION);
		
		this.reportManager=config.getReportManager();
		this.atoms.setReportMgr(this.reportManager);
	}

	public void setSpecificationName(Token name){
		this.atoms.setSpecificationName(name.getText());		
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), logs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 * @param array null if no array, anything else otherwise
	 */
	public void putAtom(Token token, String category, Token type, Object array){
		this.atoms.scope.push(token);

		//change array into boolean
		boolean ar=false;
		if(array!=null)
			ar=true;

		TSTableRowAPI otr=this.atoms.putAtom(token, category, type, ar);
		if(otr!=null){
			StringTemplate found=RuleManager.found(this.rules, otr.get(TSAtomList.alValCategory), otr.get(TSAtomList.alValFile), otr.get(TSAtomList.alValLine), otr.get(TSAtomList.alValColumn));
			StringTemplate st;

			if(StringUtils.equalsAny(category, new String[]{ColaConstants.Tokens.parserPropertyScopeRank, ColaConstants.Tokens.parserContractScopeRank})){
				//we have an error for either Property Scope or Contract Scope declarations
				String scopeAtom=AtomListUtils.getParentID(this.atoms);
				String declId=NameScopeUtils.getParentID(scopeAtom, this.atoms.scope.getSeparator());
				scopeAtom=scopeAtom.substring(scopeAtom.indexOf(this.atoms.scope.getSeparator())+this.atoms.scope.getSeparator().length(), scopeAtom.length());
				if(category.equals(ColaConstants.Tokens.parserPropertyScopeRank)){
					st=RuleManager.property14(this.rules, scopeAtom, declId);
				}
				else{
					st=RuleManager.contract05(this.rules, scopeAtom, declId);
				}
				this.reportManager.error(st.toString(), token);
			}
			else{
				//general problem with not unique Identifier
				st=RuleManager.identifier01(this.rules, otr.get(TSAtomList.alValScopedID), category, found.toString());
				this.reportManager.error(st.toString(), token);
			}
			return;
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
}
