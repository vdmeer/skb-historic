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

import org.skb.tribe.LanguageRuleMap;
import org.skb.tribe.TribeProperties;
import org.skb.types.OatValueIsNullException;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;
import org.skb.util.languages.ScopeToken;
import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;

/**
 * Pass 2 of the Cola parser, mostly looking into semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class ColaPass2_Ast {
	static Logger logger = Logger.getLogger(ColaPass2_Ast.class);

	public AtomList atoms=AtomList.getInstance();
	//public ScopedName sn=ScopedName.getInstance();
	//public ScopedName sn=ScopedName.getInstance();
	public ScopeToken sn;
	private PropertyDeclarationList propertyDeclList=PropertyDeclarationList.getInstance();
	private ContractDeclarationList contractDeclList=ContractDeclarationList.getInstance();

	private LanguageRuleMap cr;
	
	//for Extends, Provides and Requires
	private String eprCategory;
	private String eprAtom;
	public LinkedHashMap<String, String> eprList;

	// temp Type and Value for testing
	private Token lastBaseType=null;
	private Token lastCommonValue=null;
	private Token lastCommonValueType=null;

	//for PropDef checks
	private Integer propDefListValues=0;
	private LinkedHashMap<String, ArrayList<Token>>propDefList=new LinkedHashMap<String, ArrayList<Token>>();
	private Token currentItemDef;

	//for ItemDef checks
	private Integer itemDefListValues=0;
	private LinkedHashMap<String, ArrayList<Token>>itemDefList=new LinkedHashMap<String, ArrayList<Token>>();

	//for ContDef checks
	private LinkedHashMap<String, ArrayList<String>>contDefList=new LinkedHashMap<String, ArrayList<String>>();

	public ColaPass2_Ast(){
		this.atoms.scope.clear();

		this.eprCategory="";
		this.eprAtom="";
		this.eprList=new LinkedHashMap<String, String>();

		this.cr=new LanguageRuleMap();
		this.cr.setClassName(ColaRuleConstants.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();

		this.sn=new ScopeToken();
	}

	//EPR methods, including testing the EPR declarations for Properties, Elements and Facilities
	public void eprStart(String atom){this.eprClear();this.eprAtom(atom);}
	public void eprAtom(String atom){this.eprAtom=atom;}
	public void eprCategory(String cat){this.eprCategory=cat;}
	public void eprClear(){
		this.eprCategory="";
		this.eprAtom="";
		this.eprList.clear();
	}
	public void eprAdd(String epr){
		if(this.eprList.containsKey(epr)==true){
			Token tk=this.sn.get(this.sn.size()-1);
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleIdentifier02),
					this.cr.getRuleAdd(ColaRuleConstants.ruleIdentifier02, new String[]{this.eprCategory,this.eprAtom,epr,this.eprList.get(epr)}),
					tk.getLine(),
					tk.getCharPositionInLine());
			return;
		}
		else if(this.testSN(this.eprAtom, this.eprCategory)==false){
			return;
		}
		else
			this.eprList.put(epr, this.eprCategory);
	}

	// temp Type and Value for testing
	public void setLastBaseType(Token tk){this.lastBaseType=tk;}
	public void setLastCommonValue(Token tk){this.lastCommonValue=tk;}
	public void setLastCommonValueType(Token tk){this.lastCommonValueType=tk;}
	public void setLastCommonValuePlusType(Token value, Token type){this.setLastCommonValueType(type); this.setLastCommonValue(value);}

	public void testBaseTypeWithConstValue(String t){
		String base_type=this.lastBaseType.getText().toLowerCase();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!base_type.equals(const_valueType)){
			if((base_type.equals(ColaTokensConstants.colaINTEGER)||base_type.equals(ColaTokensConstants.colaSHORT)||base_type.equals(ColaTokensConstants.colaLONG))&&
			   (const_valueType.equals(ColaTokensConstants.colaINTEGER)||const_valueType.equals(ColaTokensConstants.colaSHORT)||const_valueType.equals(ColaTokensConstants.colaLONG))
			)
				ReportManager.getInstance().reportWarning(
						this.cr.getRule(ColaRuleConstants.ruleProperty13, new String[]{t, this.atoms.scope.toString()}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty13, new String[]{base_type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleProperty12, new String[]{t, this.atoms.scope.toString()}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty12, new String[]{base_type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
		}
	}

	//test property declaration description, must be string and non-empty
	public void testPropDeclDescription(){
		String val=this.lastCommonValue.getText();
		val=val.replace('"', ' ');
		if(val.equals(ColaTokensConstants.colaNULL)||val.trim().length()==0)
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleProperty11, new String[]{this.atoms.get(this.atoms.scope.toString(), AtomList.alValCategory).toString(), this.atoms.scope.toString()}),
					this.cr.getRuleAdd(ColaRuleConstants.ruleProperty11),
					this.lastCommonValue.getLine(),
					this.lastCommonValue.getCharPositionInLine());
	}


	public void propDefListStart(){this.propDefList.clear();}
	public void propDef(){
		boolean add=true;
		String scoped=this.sn.toString();
		//propDef not declared
		if(this.atoms.containsKey(scoped)==false){
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleProperty10),
					this.cr.getRuleAdd(ColaRuleConstants.ruleProperty10, new String[]{scoped}),
					this.sn.get(this.sn.size()-1).getLine(),
					this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}
		//used once or more?
		if(this.propDefList.containsKey(scoped)){
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleIdentifier01),
					this.cr.getRuleAdd(ColaRuleConstants.ruleIdentifier01, new String[]{scoped}),
					this.sn.get(this.sn.size()-1).getLine(),
					this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}

		//property is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		if(add==true){
			//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
			String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
			if(category.equals(ColaTokensConstants.colaTYPEDEF)||category.equals(ColaTokensConstants.colaSTRUCT)||category.equals(ColaTokensConstants.parserMEMBER))
				category=ColaTokensConstants.colaATTRIBUTE;
			//now, if property is declared not_def for category, that's an error
			if(this.propertyDeclList.get(ColaTokensConstants.colaNOT_DEF, category, scoped)==true)
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleProperty09, new String[]{scoped, category}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty09),
						this.sn.get(this.sn.size()-1).getLine(),
						this.sn.get(this.sn.size()-1).getCharPositionInLine());
			else
				this.propDefList.put(new String(scoped), this.sn.getList());
		}
	}

	public void propDefValueStart(){this.propDefListValues=0;}
	public void propDefValueTest(){
		String scoped=this.sn.toString();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,AtomList.alValType).getText();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!type.equals(const_valueType)){
			if((type.equals(ColaTokensConstants.colaINTEGER)||type.equals(ColaTokensConstants.colaSHORT)||type.equals(ColaTokensConstants.colaLONG))&&
			   (const_valueType.equals(ColaTokensConstants.colaINTEGER)||const_valueType.equals(ColaTokensConstants.colaSHORT)||const_valueType.equals(ColaTokensConstants.colaLONG))
			)
				ReportManager.getInstance().reportWarning(
						this.cr.getRule(ColaRuleConstants.ruleProperty08, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty08, new String[]{type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleProperty07, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty07, new String[]{type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
		}
		this.propDefListValues++;
	}

	public void propDefFinish(){
		String scoped=this.sn.toString();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,AtomList.alValType).getText();

		//error, type is not array but more than one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(ColaTokensConstants.colaFALSE)&&this.propDefListValues>1)
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleProperty06, new String[]{scoped}),
					this.cr.getRuleAdd(ColaRuleConstants.ruleProperty06, new String[]{type, this.propDefListValues.toString()}),
					this.lastCommonValue.getLine(),
					this.lastCommonValue.getCharPositionInLine());
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(ColaTokensConstants.colaTRUE)&&(this.propDefListValues==0||this.propDefListValues==1))
			ReportManager.getInstance().reportWarning(
					this.cr.getRule(ColaRuleConstants.ruleProperty05, new String[]{scoped}),
					this.cr.getRuleAdd(ColaRuleConstants.ruleProperty05, new String[]{type, this.propDefListValues.toString()}),
					this.lastCommonValue.getLine(),
					this.lastCommonValue.getCharPositionInLine());

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		if(category.equals(ColaTokensConstants.colaTYPEDEF)||category.equals(ColaTokensConstants.colaSTRUCT)||category.equals(ColaTokensConstants.parserMEMBER))
			category=ColaTokensConstants.colaATTRIBUTE;
		//now, if property is declared not_def for category, that's an error
		if(this.propertyDeclList.get(ColaTokensConstants.colaREQUIRED, category, scoped)==true){
			//required property with no value, error
			if(this.propDefListValues==0)
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleProperty04, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleProperty04),
						this.sn.get(this.sn.size()-1).getLine(),
						this.sn.get(this.sn.size()-1).getCharPositionInLine());
			//required property with 1 value, can only test for Strings now
			if(this.propDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(ColaTokensConstants.colaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(ColaTokensConstants.colaNULL)||const_value.trim().length()==0)
						ReportManager.getInstance().reportError(
								this.cr.getRule(ColaRuleConstants.ruleProperty03, new String[]{scoped}),
								this.cr.getRuleAdd(ColaRuleConstants.ruleProperty03),
								this.lastCommonValue.getLine(),
								this.lastCommonValue.getCharPositionInLine());
				}
			}
		}
	}

	public void propDefListFinish(){
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		if(category.equals(ColaTokensConstants.colaTYPEDEF)||category.equals(ColaTokensConstants.colaSTRUCT)||category.equals(ColaTokensConstants.parserMEMBER))
			category=ColaTokensConstants.colaATTRIBUTE;

		//now we need to check if all mandatory and required properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.propertyDeclList.get(ColaTokensConstants.colaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleProperty01, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleProperty01),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		al=this.propertyDeclList.get(ColaTokensConstants.colaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleProperty02, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleProperty02),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void contDefListStart(){
		this.contDefList.clear();
	}

	public void contDef(){
		String scoped=this.sn.toString();
		Token tk=this.sn.get(this.sn.size()-1);

		//check if the scoped_name of contract is declared already (can use contract only once)
		if(this.contDefList.containsKey(scoped))
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleContract01, new String[]{scoped}),
					tk);

		//contract is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		//if contract is declared not_def for category, that's an error
		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		if(this.contractDeclList.get(ColaTokensConstants.colaNOT_DEF, category, this.sn.toString())==true)
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleContract02, new String[]{this.sn.toString(), category}),
					null,
					this.sn.get(this.sn.size()-1).getLine(),
					this.sn.get(this.sn.size()-1).getCharPositionInLine());

		//add contract, regardless of errors, to continue parsing (can help to catch multiple errors in one compile iteration and should not break anything)
		this.contDefList.put(scoped, new ArrayList<String>());
	}

	public void contDefListFinish(){
		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		//now we need to check if all mandatory and required contracts have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.get(ColaTokensConstants.colaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.contDefList.containsKey(al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleContract03, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleContract03),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		//now the required contracts
		al=this.contractDeclList.get(ColaTokensConstants.colaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.contDefList.containsKey(al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleContract04, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleContract04),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		//finally, see if all items that are part of a contract declarations are defined
		LinkedHashMap<String, ArrayList<String>> cntDecl=this.contractDeclList.getDeclaredItems();
		String key;
		Set<String> contSet=cntDecl.keySet();
		Iterator<String> contItr = contSet.iterator();
		while(contItr.hasNext()){
			key=contItr.next();
			if(this.contDefList.containsKey(key)){
				size=cntDecl.get(key).size();
				for(int i=0; i<size; i++)
					if(!this.contDefList.get(key).contains(cntDecl.get(key).get(i)))
						ReportManager.getInstance().reportError(
								this.cr.getRule(ColaRuleConstants.ruleItem01, new String[]{cntDecl.get(key).get(i), key}),
								this.cr.getRuleAdd(ColaRuleConstants.ruleItem01),
								this.sn.get(this.sn.size()-1).getLine(),
								this.sn.get(this.sn.size()-1).getCharPositionInLine());

			}
		}
	}

	public void itemDefListStart(Token item){
		this.currentItemDef=item;
		this.contDefList.get(this.sn.toString()).add(item.getText());
		this.itemDefList.clear();
	}

	public void itemDef(Token itemProp){
		boolean add=true;
		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
		//itemDef not declared
		if(this.atoms.containsKey(scoped)==false){
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleItem02),
					this.cr.getRuleAdd(ColaRuleConstants.ruleItem02, new String[]{scoped}),
					this.sn.get(this.sn.size()-1).getLine(),
					this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}
		//used once or more?
		if(this.itemDefList.containsKey(scoped)){
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleIdentifier03),
					this.cr.getRuleAdd(ColaRuleConstants.ruleIdentifier03, new String[]{scoped}),
					this.sn.get(this.sn.size()-1).getLine(),
					this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}

		//item-property is declared, and defined only once. we can add it, since scope is always valid (only rank differs
		if(add==true)
			this.itemDefList.put(new String(scoped), this.sn.getList());
	}

	public void itemDefValueStart(){
		this.itemDefListValues=0;
	}

	public void itemDefValueTest(Token itemProp){
		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
		//first check if we have a item-property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,AtomList.alValType).getText();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!type.equals(const_valueType)){
			if((type.equals(ColaTokensConstants.colaINTEGER)||type.equals(ColaTokensConstants.colaSHORT)||type.equals(ColaTokensConstants.colaLONG))&&
			   (const_valueType.equals(ColaTokensConstants.colaINTEGER)||const_valueType.equals(ColaTokensConstants.colaSHORT)||const_valueType.equals(ColaTokensConstants.colaLONG))
			)
				ReportManager.getInstance().reportWarning(
						this.cr.getRule(ColaRuleConstants.ruleItem03, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleItem03, new String[]{type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleItem04, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleItem04, new String[]{type, const_valueType}),
						this.lastCommonValue.getLine(),
						this.lastCommonValue.getCharPositionInLine());
		}
		this.itemDefListValues++;
	}

	public void itemDefFinish(Token itemProp){
		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,AtomList.alValType).getText();

		//error, type is not array but more than one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(ColaTokensConstants.colaFALSE)&&this.itemDefListValues>1)
			ReportManager.getInstance().reportError(
					this.cr.getRule(ColaRuleConstants.ruleItem05, new String[]{scoped}),
					this.cr.getRuleAdd(ColaRuleConstants.ruleItem05, new String[]{type, this.itemDefListValues.toString()}),
					this.lastCommonValue.getLine(),
					this.lastCommonValue.getCharPositionInLine());
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(ColaTokensConstants.colaTRUE)&&(this.itemDefListValues==0||this.itemDefListValues==1))
			ReportManager.getInstance().reportWarning(
					this.cr.getRule(ColaRuleConstants.ruleItem06, new String[]{scoped}),
					this.cr.getRuleAdd(ColaRuleConstants.ruleItem06, new String[]{type, this.itemDefListValues.toString()}),
					this.lastCommonValue.getLine(),
					this.lastCommonValue.getCharPositionInLine());

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		if(category.equals(ColaTokensConstants.colaTYPEDEF)||category.equals(ColaTokensConstants.colaSTRUCT)||category.equals(ColaTokensConstants.parserMEMBER))
			category=ColaTokensConstants.colaATTRIBUTE;

		if(this.contractDeclList.getItemDeclPropertyRank(this.sn.toString(), this.currentItemDef.getText(), itemProp.getText(), ColaTokensConstants.colaREQUIRED)==true){
			//required property with no value, error
			if(this.itemDefListValues==0)
				ReportManager.getInstance().reportError(
						this.cr.getRule(ColaRuleConstants.ruleItem07, new String[]{scoped}),
						this.cr.getRuleAdd(ColaRuleConstants.ruleItem07),
						this.sn.get(this.sn.size()-1).getLine(),
						this.sn.get(this.sn.size()-1).getCharPositionInLine());
			//required property with 1 value, can only test for Strings now
			if(this.itemDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(ColaTokensConstants.colaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(ColaTokensConstants.colaNULL)||const_value.trim().length()==0)
						ReportManager.getInstance().reportError(
								this.cr.getRule(ColaRuleConstants.ruleItem08, new String[]{scoped}),
								this.cr.getRuleAdd(ColaRuleConstants.ruleItem08),
								this.lastCommonValue.getLine(),
								this.lastCommonValue.getCharPositionInLine());
				}
			}
		}
	}

	public void itemDefListFinish(){
		String category=ColaTokensConstants.colaITEM;
		String scoped_add=this.sn.toString()+"::"+this.currentItemDef.getText()+"::";
		//now we need to check if all mandatory and required item-properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaTokensConstants.colaMANDATORY);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleItem09, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleItem09),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

				al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaTokensConstants.colaREQUIRED);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
				try {
					ReportManager.getInstance().reportError(
							this.cr.getRule(ColaRuleConstants.ruleItem10, new String[]{al.get(i), category, this.atoms.scope.toString()}),
							this.cr.getRuleAdd(ColaRuleConstants.ruleItem10),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValLine).getValue(),
							this.atoms.getInteger(this.atoms.scope.toString(),AtomList.alValColumn).getValue());
				} catch (OatValueIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.currentItemDef=null;
	}

	public boolean testSN(String category, String catElem){
		boolean ret=true;
		if(this.sn.size()==0)
			return ret;
		String scoped="";
		for (int i=0; i<this.sn.size()-1; i++){
			Token tk=this.sn.get(i);
			if(scoped.length()>0)
				scoped+=TribeProperties.getInstance().getValue(ColaPropertiesConstants.keyScopeSep).toString();
			scoped+=this.sn.get(i).getText();
			//first check if there is any Atom registered, if so the test node category to be valid scoped_name node
			if(this.atoms.containsKey(scoped)==false){
				ReportManager.getInstance().reportError(
						"invalid scoped name (" + scoped + ")",
						"no atom of that name declared",
						tk.getLine(),
						tk.getCharPositionInLine());
				ret=false;
			}
			else{
				String leafCat=this.atoms.get(scoped, AtomList.alValCategory).toString();
				if(!leafCat.equals(ColaTokensConstants.colaPACKAGE)&&
				   !leafCat.equals(ColaTokensConstants.colaELEMENT)&&
				   !leafCat.equals(ColaTokensConstants.colaFACILITY)
				  ){
					ReportManager.getInstance().reportError(
							"invalid scoped name (" + scoped + ")",
							scoped + " of type " + leafCat + " can't be used as part of scoped names",
							tk.getLine(),
							tk.getCharPositionInLine());
					ret=false;
				}
			}
		}
		//now test if the leaf is valid, if so, check also if it points to the correct Atom category
		if(scoped.length()>0)
			scoped+=TribeProperties.getInstance().getValue(ColaPropertiesConstants.keyScopeSep).toString();
		scoped+=this.sn.get(this.sn.size()-1).getText();
		Token tk=this.sn.get(this.sn.size()-1);
		if(this.atoms.containsKey(scoped)==false){
			ReportManager.getInstance().reportError(
					"invalid scoped name <" + scoped + ">",
					"no atom of that name declared",
					tk.getLine(),
					tk.getCharPositionInLine());
			ret=false;
		}
		else{
			String leafCat=this.atoms.get(scoped, AtomList.alValCategory).toString();
			if(leafCat.equals(ColaTokensConstants.colaPARAMETER)||leafCat.equals(ColaTokensConstants.colaACTION)){
				ReportManager.getInstance().reportError(
						"invalid scoped name <" + scoped + ">",
						"cannot scope "+leafCat+"s",
						tk.getLine(),
						tk.getCharPositionInLine());
				ret=false;
			}
			else if(leafCat.equals(ColaTokensConstants.parserMEMBER)){
				ReportManager.getInstance().reportError(
						"invalid scoped name <" + scoped + ">",
						"cannot scope members",
						tk.getLine(),
						tk.getCharPositionInLine());
				ret=false;
			}
			else{
				boolean errLeaf=false;
				//properties first
				if(category.equals(ColaTokensConstants.colaPROPERTY)&&!leafCat.equals(ColaTokensConstants.colaPROPERTY))
					errLeaf=true;
				//now contracts
				if(category.equals(ColaTokensConstants.colaCONTRACT)&&!leafCat.equals(ColaTokensConstants.colaCONTRACT))
					errLeaf=true;
				//property used in items
				if(category.equals(ColaTokensConstants.colaITEM)&&!leafCat.equals(ColaTokensConstants.colaITEM))
					errLeaf=true;
				//now facilities
				if(category.equals(ColaTokensConstants.colaFACILITY)&&!leafCat.equals(ColaTokensConstants.colaFACILITY))
					errLeaf=true;
				//now elements only
				if(catElem!=null&&category.equals(ColaTokensConstants.colaELEMENT)){
					//first check category extends, means elements only
					if(catElem.equals(ColaTokensConstants.colaAT_EXTENDS)&&!leafCat.equals(ColaTokensConstants.colaELEMENT))
						errLeaf=true;
					//now check provides, means facilities only
					if(catElem.equals(ColaTokensConstants.colaAT_PROVIDES)&&!leafCat.equals(ColaTokensConstants.colaFACILITY))
						errLeaf=true;
					//now go into requires, can be elements or facilities
					if(catElem.equals(ColaTokensConstants.colaAT_REQUIRES)){
						if(!leafCat.equals(ColaTokensConstants.colaFACILITY)&&!leafCat.equals(ColaTokensConstants.colaELEMENT))
							errLeaf=true;
					}
					//now go into contains, can be elements only
					if(catElem.equals(ColaTokensConstants.colaAT_CONTAINS)){
						if(!leafCat.equals(ColaTokensConstants.colaELEMENT))
							errLeaf=true;
					}
				}
				//last not least action, parameter, attribute, typedef, member
				//for them, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
				if(category.equals(ColaTokensConstants.colaACTION)||category.equals(ColaTokensConstants.colaPARAMETER)||category.equals(ColaTokensConstants.colaATTRIBUTE)||category.equals(ColaTokensConstants.colaTYPEDEF)||category.equals(ColaTokensConstants.parserMEMBER)){
					if(leafCat.equals(ColaTokensConstants.colaPROPERTY)||leafCat.equals(ColaTokensConstants.colaITEM)||leafCat.equals(ColaTokensConstants.colaCONTRACT)||leafCat.equals(ColaTokensConstants.colaPACKAGE)||leafCat.equals(ColaTokensConstants.colaELEMENT)||leafCat.equals(ColaTokensConstants.colaFACILITY))
						errLeaf=true;
				}
				if(errLeaf==true){
					String msg=scoped + " of type " + leafCat + " can't be used as leaf of scoped names for " + category;
					if(catElem!=null)
						msg+=" " + catElem;
					ReportManager.getInstance().reportError(
							"invalid scoped name (" + scoped + ")",
							msg,
							tk.getLine(),
							tk.getCharPositionInLine());
					ret=false;
				}
			}
		}
		return ret;
	}
}
