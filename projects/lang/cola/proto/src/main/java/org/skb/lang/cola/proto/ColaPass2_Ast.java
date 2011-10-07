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

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.lang.GrammarUtils;
import org.skb.util.classic.lang.NameScope;
import org.skb.util.classic.lang.NameScopeUtils;
import org.skb.util.classic.lang.TokenUtils;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.antlr.TSToken;
import org.skb.util.composite.lang.TSAtomList;
import org.skb.util.composite.misc.TSReportManager;
import org.skb.util.composite.util.TSLangRuleMap;

/**
 * Pass 2 of the Cola parser, mostly looking into semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ColaPass2_Ast {
	/** Logger instance */
	static Logger logger = Logger.getLogger(ColaPass2_Ast.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(ColaParser.class);

	/** Report Manager instance */
	private TSReportManager reportManager;

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

	/** Parser Rule Manager for error/warning reporting */
	private StringTemplateGroup rules;

	/** Language Rule map for error/warning reporting */
	private TSLangRuleMap cr;

	/** Scope processing using ANTLR Tokens */
	public NameScope sn;

	/** List for Property Declarations */
	private PropertyDeclarationList propertyDeclList=(PropertyDeclarationList)config.config.get(ColaParser.pathInstancePropertyDeclarationList);

	/** List for Contract Declarations */
	private ContractDeclarationList contractDeclList=(ContractDeclarationList)config.config.get(ColaParser.pathInstanceContractDeclarationList);

	// temp Type and Value for testing
	private Token lastCommonValue=null;
	private Token lastCommonValueType=null;

	//for PropDef checks
	private Integer propDefListValues=0;
	private LinkedHashMap<String, ArrayList<TSBaseAPI>>propDefList=new LinkedHashMap<String, ArrayList<TSBaseAPI>>();
	private Token currentItemDef;

	//for ItemDef checks
	private Integer itemDefListValues=0;
	private LinkedHashMap<String, ArrayList<TSBaseAPI>>itemDefList=new LinkedHashMap<String, ArrayList<TSBaseAPI>>();

	//for ContDef checks
	private LinkedHashMap<String, ArrayList<String>>contDefList=new LinkedHashMap<String, ArrayList<String>>();

	/**
	 * Class constructor, initialises local fields.
	 */
	public ColaPass2_Ast(){
		this.rules=config.getParserRuleManager().getSTG();

		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.cr=config.getLangRuleMap();

		this.sn=new NameScope();

		this.reportManager=config.getReportManager();
	}

	/**
	 * Sets last value of parsed common value.
	 * @param tk new value
	 */
	public void setLastCommonValue(Token tk){
		this.lastCommonValue=tk;
	}

	/**
	 * Sets last type of parsed common value.
	 * @param tk new type
	 */
	public void setLastCommonValueType(Token tk){
		this.lastCommonValueType=tk;
	}

	/**
	 * Sets last parsed common value and type.
	 * @param value
	 * @param type
	 */
	public void setLastCommonValuePlusType(Token value, Token type){
		this.setLastCommonValueType(type);
		this.setLastCommonValue(value);
	}

	//test property declaration description, must be string and non-empty
	public void testPropDeclDescription(){
		String val=this.lastCommonValue.getText();
		val=val.replace('"', ' ');
		if(val.equals(ColaConstants.Tokens.colaNULL)||val.trim().length()==0){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty11, new String[]{this.atoms.get(this.atoms.scope.toString(), TSAtomList.alValCategory).toString(), this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty11), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
	}

	public void propDefListStart(){
		this.propDefList.clear();
	}

	public void propDef(){
		boolean add=true;
		String scoped=this.sn.toString();
		//propDef not declared
		if(this.atoms.containsKey(scoped)==false){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty10), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty10, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			add=false;
		}
		//used once or more?
		if(this.propDefList.containsKey(scoped)){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier01), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier01, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			add=false;
		}

		//property is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		if(add==true){
			//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
			String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
			if(category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.colaSTRUCT)||category.equals(ColaConstants.Tokens.parserMEMBER))
				category=ColaConstants.Tokens.colaATTRIBUTE;
			//now, if property is declared not_def for category, that's an error
			if(this.propertyDeclList.get(ColaConstants.Tokens.colaNOT_DEF, category, scoped)==true){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty09, new String[]{scoped, category}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty09), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			}
			else{
				this.propDefList.put(new String(scoped), this.sn.getList());
			}
		}
	}

	public void propDefValueStart(){
		this.propDefListValues=0;
	}

	public void propDefValueTest(){
		String scoped=this.sn.toString();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!type.equals(const_valueType)){
			if((type.equals(ColaConstants.Tokens.colaINTEGER)||type.equals(ColaConstants.Tokens.colaSHORT)||type.equals(ColaConstants.Tokens.colaLONG))&&
			   (const_valueType.equals(ColaConstants.Tokens.colaINTEGER)||const_valueType.equals(ColaConstants.Tokens.colaSHORT)||const_valueType.equals(ColaConstants.Tokens.colaLONG))
			){
				this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleProperty08, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty08, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			}
			else{
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty07, new String[]{scoped}),this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty07, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			}
		}
		this.propDefListValues++;
	}

	public void propDefFinish(){
		String scoped=this.sn.toString();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();

		//error, type is not array but more than one value given
		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaFALSE)&&this.propDefListValues>1){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty06, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty06, new String[]{type, this.propDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaTRUE)&&(this.propDefListValues==0||this.propDefListValues==1)){
			this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleProperty05, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty05, new String[]{type, this.propDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
		if(category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.colaSTRUCT)||category.equals(ColaConstants.Tokens.parserMEMBER))
			category=ColaConstants.Tokens.colaATTRIBUTE;
		//now, if property is declared not_def for category, that's an error
		if(this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, category, scoped)==true){
			//required property with no value, error
			if(this.propDefListValues==0){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty04, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty04), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			}
			//required property with 1 value, can only test for Strings now
			if(this.propDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(ColaConstants.Tokens.colaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(ColaConstants.Tokens.colaNULL)||const_value.trim().length()==0){
						this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty03, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty03), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
					}
				}
			}
		}
	}

	public void propDefListFinish(){
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
		if(category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.colaSTRUCT)||category.equals(ColaConstants.Tokens.parserMEMBER))
			category=ColaConstants.Tokens.colaATTRIBUTE;

		//now we need to check if all mandatory and required properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.propertyDeclList.get(ColaConstants.Tokens.colaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty01, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty01), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
		}
		al=this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty02, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty02), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
		}
	}

	public void contDefListStart(){
		this.contDefList.clear();
	}

	public void contDef(){
		String scoped=this.sn.toString();
		TSBaseAPI tk=NameScopeUtils.lastName(this.sn);

		//check if the scoped_name of contract is declared already (can use contract only once)
		if(this.contDefList.containsKey(scoped)){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract01, new String[]{scoped}), (TSToken)tk);
		}

		//contract is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		//if contract is declared not_def for category, that's an error
		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
		if(this.contractDeclList.get(ColaConstants.Tokens.colaNOT_DEF, category, this.sn.toString())==true){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract02, new String[]{this.sn.toString(), category}), null, TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
		}

		//add contract, regardless of errors, to continue parsing (can help to catch multiple errors in one compile iteration and should not break anything)
		this.contDefList.put(scoped, new ArrayList<String>());
	}

	public void contDefListFinish(){
		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
		//now we need to check if all mandatory and required contracts have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.get(ColaConstants.Tokens.colaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.contDefList.containsKey(al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract03, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleContract03), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
		}

		//now the required contracts
		al=this.contractDeclList.get(ColaConstants.Tokens.colaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.contDefList.containsKey(al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract04, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleContract04), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
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
				for(int i=0; i<size; i++){
					if(!this.contDefList.get(key).contains(cntDecl.get(key).get(i))){
						this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem01, new String[]{cntDecl.get(key).get(i), key}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem01), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
					}
				}
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
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem02), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem02, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			add=false;
		}
		//used once or more?
		if(this.itemDefList.containsKey(scoped)){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier03), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier03, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
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

		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!type.equals(const_valueType)){
			if((type.equals(ColaConstants.Tokens.colaINTEGER)||type.equals(ColaConstants.Tokens.colaSHORT)||type.equals(ColaConstants.Tokens.colaLONG))&&
			   (const_valueType.equals(ColaConstants.Tokens.colaINTEGER)||const_valueType.equals(ColaConstants.Tokens.colaSHORT)||const_valueType.equals(ColaConstants.Tokens.colaLONG))
			){
				this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleItem03, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem03, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			}
			else{
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem04, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem04, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			}
		}
		this.itemDefListValues++;
	}

	public void itemDefFinish(Token itemProp){
		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
		//first check if we have a property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();

		//error, type is not array but more than one value given
		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaFALSE)&&this.itemDefListValues>1){
			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem05, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem05, new String[]{type, this.itemDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaTRUE)&&(this.itemDefListValues==0||this.itemDefListValues==1)){
			this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleItem06, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem06, new String[]{type, this.itemDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
		if(category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.colaSTRUCT)||category.equals(ColaConstants.Tokens.parserMEMBER))
			category=ColaConstants.Tokens.colaATTRIBUTE;

		if(this.contractDeclList.getItemDeclPropertyRank(this.sn.toString(), this.currentItemDef.getText(), itemProp.getText(), ColaConstants.Tokens.colaREQUIRED)==true){
			//required property with no value, error
			if(this.itemDefListValues==0){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem07, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem07), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
			}
			//required property with 1 value, can only test for Strings now
			if(this.itemDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(ColaConstants.Tokens.colaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(ColaConstants.Tokens.colaNULL)||const_value.trim().length()==0){
						this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem08, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem08), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
					}
				}
			}
		}
	}

	public void itemDefListFinish(){
		String category=ColaConstants.Tokens.colaITEM;
		String scoped_add=this.sn.toString()+"::"+this.currentItemDef.getText()+"::";
		//now we need to check if all mandatory and required item-properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaMANDATORY);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem09, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem09), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
		}

				al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaREQUIRED);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem10, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem10), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
		}
		this.currentItemDef=null;
	}

	/**
	 * Tests a scoped name 
	 * @param category category for the scoped name
	 * @param catElem category element
	 * @return true if no errors
	 */
	public boolean testSN(String category, String catElem){
		boolean ret=true;
		if(this.sn.size()==0)
			return ret;
		String scoped="";
		for (int i=0; i<this.sn.size()-1; i++){
			TSBaseAPI tk=this.sn.get(i);
			if(scoped.length()>0)
				scoped+=config.getProperties().getValue(ColaConstants.Properties.keyScopeSep).toString();
			scoped+=this.sn.get(i).toString();
			//first check if there is any Atom registered, if so the test node category to be valid scoped_name node
			if(this.atoms.containsKey(scoped)==false){
				this.reportManager.error("invalid scoped name (" + scoped + ")", "no atom of that name declared", TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				ret=false;
			}
			else{
				String leafCat=this.atoms.get(scoped, TSAtomList.alValCategory).toString();
				if(!leafCat.equals(ColaConstants.Tokens.colaPACKAGE)&&
				   !leafCat.equals(ColaConstants.Tokens.colaELEMENT)&&
				   !leafCat.equals(ColaConstants.Tokens.colaFACILITY)
				  ){
					this.reportManager.error("invalid scoped name (" + scoped + ")", scoped + " of type " + leafCat + " can't be used as part of scoped names", TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
					ret=false;
				}
			}
		}
		//now test if the leaf is valid, if so, check also if it points to the correct Atom category
		if(scoped.length()>0)
			scoped+=config.getProperties().getValue(ColaConstants.Properties.keyScopeSep).toString();
		scoped+=NameScopeUtils.lastName(this.sn).toString();
		TSBaseAPI tk=NameScopeUtils.lastName(this.sn);
		if(this.atoms.containsKey(scoped)==false){
			this.reportManager.error("invalid scoped name <" + scoped + ">", "no atom of that name declared", TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
			ret=false;
		}
		else{
			String leafCat=this.atoms.get(scoped, TSAtomList.alValCategory).toString();
			if(leafCat.equals(ColaConstants.Tokens.colaPARAMETER)||leafCat.equals(ColaConstants.Tokens.colaACTION)){
				this.reportManager.error("invalid scoped name <" + scoped + ">", "cannot scope "+leafCat+"s", TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				ret=false;
			}
			else if(leafCat.equals(ColaConstants.Tokens.parserMEMBER)){
				this.reportManager.error("invalid scoped name <" + scoped + ">", "cannot scope members", TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				ret=false;
			}
			else{
				boolean errLeaf=false;
				//properties first
				if(category.equals(ColaConstants.Tokens.colaPROPERTY)&&!leafCat.equals(ColaConstants.Tokens.colaPROPERTY))
					errLeaf=true;
				//now contracts
				if(category.equals(ColaConstants.Tokens.colaCONTRACT)&&!leafCat.equals(ColaConstants.Tokens.colaCONTRACT))
					errLeaf=true;
				//property used in items
				if(category.equals(ColaConstants.Tokens.colaITEM)&&!leafCat.equals(ColaConstants.Tokens.colaITEM))
					errLeaf=true;
				//now facilities
				if(category.equals(ColaConstants.Tokens.colaFACILITY)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
					errLeaf=true;
				//now elements only
				if(catElem!=null&&category.equals(ColaConstants.Tokens.colaELEMENT)){
					//first check category extends, means elements only
					if(catElem.equals(ColaConstants.Tokens.colaAT_EXTENDS)&&!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
						errLeaf=true;
					//now check provides, means facilities only
					if(catElem.equals(ColaConstants.Tokens.colaAT_PROVIDES)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
						errLeaf=true;
					//now go into requires, can be elements or facilities
					if(catElem.equals(ColaConstants.Tokens.colaAT_REQUIRES)){
						if(!leafCat.equals(ColaConstants.Tokens.colaFACILITY)&&!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
							errLeaf=true;
					}
					//now go into contains, can be elements only
					if(catElem.equals(ColaConstants.Tokens.colaAT_CONTAINS)){
						if(!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
							errLeaf=true;
					}
				}
				//last not least action, parameter, attribute, typedef, member
				//for them, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
				if(category.equals(ColaConstants.Tokens.colaACTION)||category.equals(ColaConstants.Tokens.colaPARAMETER)||category.equals(ColaConstants.Tokens.colaATTRIBUTE)||category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.parserMEMBER)){
					if(leafCat.equals(ColaConstants.Tokens.colaPROPERTY)||leafCat.equals(ColaConstants.Tokens.colaITEM)||leafCat.equals(ColaConstants.Tokens.colaCONTRACT)||leafCat.equals(ColaConstants.Tokens.colaPACKAGE)||leafCat.equals(ColaConstants.Tokens.colaELEMENT)||leafCat.equals(ColaConstants.Tokens.colaFACILITY))
						errLeaf=true;
				}
				if(errLeaf==true){
					String msg=scoped + " of type " + leafCat + " can't be used as leaf of scoped names for " + category;
					if(catElem!=null){
						msg+=" " + catElem;
					}
					this.reportManager.error("invalid scoped name (" + scoped + ")", msg, TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
					ret=false;
				}
			}
		}
		return ret;
	}



////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////



	/**
	 * Test the given base type against the type of the given constant value
	 * @param baseType base type to test with
	 * @param constValue constant value as type/value pair to test with
	 */
	public void testBaseTypeAndConstValue(Token baseType, CommonTree constValue){
		String bt=TokenUtils.getTokenString(baseType);
		String cvType=TokenUtils.getTreeString2Lower(constValue, 0);

		if(GrammarUtils.testBasetypeAndConstvalue(baseType, constValue)==false){
			StringTemplate err=null;
			boolean warn=false;
			//bt=int, cvt=short||long ==> warning
			if(bt.equals(ColaConstants.Tokens.colaINTEGER)&&(cvType.equals(ColaConstants.Tokens.colaSHORT)||cvType.equals(ColaConstants.Tokens.colaLONG))){
				err=this.rules.getInstanceOf("property13");
				warn=true;
			}
			//bt=short, cvt=int||long ==> warning
			else if(bt.equals(ColaConstants.Tokens.colaSHORT)&&(cvType.equals(ColaConstants.Tokens.colaINTEGER)||cvType.equals(ColaConstants.Tokens.colaLONG))){
				err=this.rules.getInstanceOf("property13");
				warn=true;
			}
			//bt=long, cvt=int||short ==> warning
			else if(bt.equals(ColaConstants.Tokens.colaLONG)&&(cvType.equals(ColaConstants.Tokens.colaINTEGER)||cvType.equals(ColaConstants.Tokens.colaSHORT))){
				err=this.rules.getInstanceOf("property13");
				warn=true;
			}
			else{
				err=this.rules.getInstanceOf("property12");
			}
			err.setAttribute("do_error", true);
			err.setAttribute("ident", this.atoms.scope.toString());
			err.setAttribute("base_type", bt);
			err.setAttribute("const_type", cvType);
			if(warn==true)
				this.reportManager.warning(err.toString(), TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));
			else
				this.reportManager.error(err.toString(), TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));
		}
	}



	public void testExtends(String scopeName){
		this.testEPR(ColaConstants.Tokens.colaAT_EXTENDS, scopeName);
	}

	public void testRequires(String scopeName){
		this.testEPR(ColaConstants.Tokens.colaAT_REQUIRES, scopeName);
	}

	public void testProvides(String scopeName){
		this.testEPR(ColaConstants.Tokens.colaAT_PROVIDES, scopeName);
	}

	public void testEPR(String category, String scopeName){
		//TSTableRowAPI otr=this.atoms.putAtom(null, category, null, null);
		//System.err.println(this.atoms.scope+" --"+category+"--"+scopeName);
	}


	/**
	 * Adds to the EPR list and tests the EPR declarations for Properties, Elements and Facilities
	 * @param epr string to be used
	 */
//	public void eprAdd(String epr){
//		if(this.eprList.containsKey(epr)==true){
//			Token tk=NameScopeUtils.lastName(this.sn);
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier02), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier02, new String[]{this.eprCategory,this.eprAtom,epr,this.eprList.get(epr)}), tk.getLine(), tk.getCharPositionInLine());
//			return;
//		}
//		else if(this.testSN(this.eprAtom, this.eprCategory)==false){
//			return;
//		}
//		else
//			this.eprList.put(epr, this.eprCategory);
//	}


}
