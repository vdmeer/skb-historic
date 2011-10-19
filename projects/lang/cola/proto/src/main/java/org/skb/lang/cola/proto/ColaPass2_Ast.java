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
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.base.composite.TSTableRowAPI;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.config.Configuration;
import org.skb.base.utils.GrammarUtils;
import org.skb.base.utils.NameScopeUtils;
import org.skb.base.utils.StringUtils;
import org.skb.base.utils.TokenUtils;
import org.skb.lang.cola.proto.constants.ColaConstants;

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

	private TreeMap<String, ArrayList<String>> tempScopedNames;

	/** List for Property Declarations */
	private PropertyDeclarationList propertyDeclList;

	/** List for Contract Declarations */
	private ContractDeclarationList contractDeclList;

	/**
	 * Class constructor, initialises local fields.
	 */
	public ColaPass2_Ast(){
		this.rules=config.getParserRuleManager().getSTG();

		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.tempScopedNames=new TreeMap<String, ArrayList<String>>();

		this.reportManager=config.getReportManager();

		this.buildDeclarationLists();
	}

	/**
	 * Builds lists for property and contract declarations from the current atom list.
	 */
	private void buildDeclarationLists(){
		this.propertyDeclList=new PropertyDeclarationList();
		this.contractDeclList=new ContractDeclarationList();

		Vector<String> prop=new Vector<String>();

		Set<String> rows=this.atoms.getRows();
		String currentAtom;
		String currentAtomCat;
		Boolean property=true;
		String seperator=this.atoms.scope.getSeparator();
        for (Iterator<String> i = rows.iterator(); i.hasNext(); i.hasNext()){
        	currentAtom=i.next();
        	currentAtomCat=this.atoms.getAtomCategory(currentAtom);
        	String[] currentAtomIDArr=currentAtom.split(seperator);
        	String currentAtomID=currentAtomIDArr[currentAtomIDArr.length-1];
        	//if category is property or contract, we have a declaration
        	if(StringUtils.equalsAny(currentAtomCat, new String[]{ColaConstants.Tokens.colaPROPERTY, ColaConstants.Tokens.colaCONTRACT})){
        		prop.add(0, currentAtomID);
        		if(currentAtomCat.equals(ColaConstants.Tokens.colaPROPERTY))
        			property=true;
        		else
        			property=false;
        	}
        	if(StringUtils.equalsAny(currentAtomCat, new String[]{ColaConstants.Tokens.parserPropertyScopeAtom, ColaConstants.Tokens.parserContractScopeAtom})){
        		prop.add(1, currentAtomID);
        	}
        	if(StringUtils.equalsAny(currentAtomCat, new String[]{ColaConstants.Tokens.parserPropertyScopeRank, ColaConstants.Tokens.parserContractScopeRank})){
        		prop.add(2, currentAtomID);
        		if(property){
        			this.propertyDeclList.add(prop.get(2), prop.get(1), prop.get(0));
        		}
        		else{
        			this.contractDeclList.add(prop.get(2), prop.get(1), prop.get(0));
        		}
        	}
		}
	}

	/**
	 * Adds a declared property of a declared item of a declared contract (from current scope) with the given rank to local list.
	 * @param rank rank to be used for property
	 */
	public void addItemDeclaration(Token rank){
		if(rank==null)
			return;

		String separator=this.atoms.scope.getSeparator();

		String property=this.atoms.scope.toString();
		String item=NameScopeUtils.getParentID(property, separator);
		String contract=NameScopeUtils.getParentID(item, separator);

		if(property.contains(separator))
			property=property.substring(property.lastIndexOf(separator)+separator.length(), property.length());
		if(item.contains(separator))
			item=item.substring(item.lastIndexOf(separator)+separator.length(), item.length());

		this.contractDeclList.addItemDecl(contract, item, property, rank.getText());
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), logs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 * @param array null if no array, anything else otherwise
	 */
	public void putAtom(Token token, String category){
		this.atoms.scope.push(token);

		TSTableRowAPI otr=this.atoms.putAtom(token, category, null, false);
		if(otr!=null){
			StringTemplate found=RuleManager.found(this.rules, otr.get(TSAtomList.alValCategory), otr.get(TSAtomList.alValFile), otr.get(TSAtomList.alValLine), otr.get(TSAtomList.alValColumn));
			StringTemplate st;

			//general problem with not unique Identifier
			st=RuleManager.identifier01(this.rules, otr.get(TSAtomList.alValScopedID), category, found.toString());
			this.reportManager.error(st.toString(), token);
			return;
		}
	}

	/**
	 * Pop the current scope, after using putAtom.
	 */
	public void popAtom(){
		this.atoms.scope.pop();
	}

	/**
	 * Test the given base type against the type of the given constant value
	 * @param baseType base type to test with
	 * @param constValue constant value as type/value pair to test with
	 */
	public void testBaseTypeAndConstValue(Token baseType, CommonTree constValue){
		String bt=TokenUtils.getTokenString(baseType);
		String cvType=TokenUtils.getTreeString2Lower(constValue, 0);
		this.testTypesBTvsCV(bt, baseType.getLine(), baseType.getCharPositionInLine(), this.atoms.getAtomFile(), cvType, TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));
	}

	/**
	 * Does the final tests of a contract definition list (contractDefList).
	 */
	public void testContractDefList(){
		String currentAtom=this.atoms.scope.toString();
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);

		ArrayList<String> contractDefList=this.tempScopedNames.get(currentAtom+this.atoms.scope.getSeparator()+ColaConstants.Tokens.colaCONTRACT);

		//now we need to check if all mandatory and required contracts have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.get(ColaConstants.Tokens.colaMANDATORY, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!contractDefList.contains(al.get(i))){
				StringTemplate st=RuleManager.contract03(this.rules, al.get(i), currentAtomCategory, currentAtom);
				this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
			}
			else{
				contractDefList.remove(al.get(i));
			}
		}
		//now required contracts
		al=this.contractDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!contractDefList.contains(al.get(i))){
				StringTemplate st=RuleManager.contract04(this.rules, al.get(i), currentAtomCategory, currentAtom);
				this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
			}
			else
				contractDefList.remove(al.get(i));
		}
		//now remove all optional (thus legal) contract defs
		al=this.contractDeclList.get(ColaConstants.Tokens.colaOPTIONAL, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(contractDefList.contains(al.get(i)))
				contractDefList.remove(al.get(i));
		}
		if(contractDefList.size()>0){
			//there are too many contract defs in the list, mark them as error
			StringTemplate st=RuleManager.contract06(this.rules, currentAtom, contractDefList);
			this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
		}

//		//finally, see if all items that are part of a contract declarations are defined
//		LinkedHashMap<String, ArrayList<String>> cntDecl=this.contractDeclList.getDeclaredItems();
//		String key;
//		Set<String> contSet=cntDecl.keySet();
//		Iterator<String> contItr = contSet.iterator();
//		while(contItr.hasNext()){
//			key=contItr.next();
//			if(this.contDefList.containsKey(key)){
//				size=cntDecl.get(key).size();
//				for(int i=0; i<size; i++){
//					if(!this.contDefList.get(key).contains(cntDecl.get(key).get(i))){
//						this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem01, new String[]{cntDecl.get(key).get(i), key}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem01), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
//					}
//				}
//			}
//		}
	}

	/**
	 * Tests the constant value of a contract item property definition, here the number of values defined against base type array and required scope.
	 * @param property token with the name of associated declaration with the value (points to the contract item property declaration)
	 * @param values number of values defined for this contract item property
	 */
	public void testItemDefConstValue(Token property, int values){
		//TODO
	}

	/**
	 * Test the base type of the given contract item property against the type of the given constant value
	 * @param property token to be used to determine base type
	 * @param constValue constant value as type/value pair to test with
	 */
	public void testItemDefConstValue(Token property, Tree constValue){
		String separator=this.atoms.scope.getSeparator();
		String[] currentAtomAr=this.atoms.scope.toString().split(separator);
		String currentAtom=new String();
		for(int i=0;i<currentAtomAr.length-3;i++){
			if(currentAtom.length()>0)
				currentAtom+=separator;
			currentAtom+=currentAtomAr[i];
		}
		ArrayList<String> contracts=this.tempScopedNames.get(currentAtom+separator+ColaConstants.Tokens.colaCONTRACT);
		String contract=contracts.get(contracts.size()-1);
		String itemPropScoped=currentAtomAr[currentAtomAr.length-2]+separator+currentAtomAr[currentAtomAr.length-1];
		String itemID=currentAtomAr[currentAtomAr.length-2];
		String propertyID=currentAtomAr[currentAtomAr.length-1];

		String declarationSN=contract+separator+itemPropScoped;
		String bt=this.atoms.getAtomValueType(declarationSN);
		String btFile=this.atoms.get(declarationSN, TSAtomList.alValFile).toString();
		Integer btLine=this.atoms.getAtomLine(declarationSN);
		Integer btCol=this.atoms.getAtomColumn(declarationSN);

		String cvType=TokenUtils.getTreeString2Lower(constValue, 0);
		this.testTypesBTvsCV(bt, btLine, btCol, btFile, cvType, TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));

		if(this.contractDeclList.getItemDeclPropertyRank(contract, itemID, propertyID, ColaConstants.Tokens.colaREQUIRED)==true){
			//we have a required property, check the value (can only do Strings right now)
			String value=TokenUtils.getTreeString(constValue, 1).replace('"', ' ');
			if(value.equals(ColaConstants.Tokens.valueNULL)||value.trim().length()==0){
				StringTemplate st=RuleManager.property03(this.rules, declarationSN);
				this.reportManager.error(st.toString(), TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));
			}
		}

	}

	/**
	 * Tests the description of a property declaration, which needs to be non-empty.
	 * 
	 * If the value is NULL or an empty string (length=0), an error will be issued. Otherwise this method does nothing.
	 * @param value value of the description
	 */
	public void testPropDeclDescription(Tree value){
		String val=value.toStringTree().replace('"', ' ');
		if(val.equals(ColaConstants.Tokens.valueNULL)||val.trim().length()==0){
			StringTemplate err=RuleManager.property11(this.rules, this.atoms.scope.toString(), this.atoms.getAtomCategory());
			this.reportManager.error(err.toString(), TokenUtils.getLine(value), TokenUtils.getColumn(value));
		}
	}

	/**
	 * Tests the constant value of a property definition, here the number of values defined against base type array and required scope.
	 * @param sn scoped name of associated declaration with the value (points to the property declaration)
	 * @param values number of values defined for this property
	 */
	public void testPropertyDefConstValue(Tree sn, int values){
		String snStr=TokenUtils.getTreeString(sn, this.atoms.scope.getSeparator());
		Boolean btArray=this.atoms.atomTypeIsArray(snStr);

		String currentAtom=this.atoms.scope.toString();
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMember}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;
		if(this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory, snStr)==true&&values==0){
			//property is required, so needs to have a value, if values==0, then error
			StringTemplate st=RuleManager.property04(this.rules, snStr);
			this.reportManager.error(st.toString(), TokenUtils.getLine(sn), TokenUtils.getColumn(sn));
		}

		//error, type is not array but more than one value given
		if(btArray==false&&values>1){
			StringTemplate st=RuleManager.property06(this.rules, snStr, values);
			this.reportManager.error(st.toString(), TokenUtils.getLine(sn), TokenUtils.getColumn(sn));
		}
		//warning, type is array but only one value given
		if(btArray==true&&values<2){
			StringTemplate st=RuleManager.property05(this.rules, snStr, values);
			this.reportManager.warning(st.toString(), TokenUtils.getLine(sn), TokenUtils.getColumn(sn));
		}
	}

	/**
	 * Test the base type of the given scoped name against the type of the given constant value
	 * @param sn scoped name to be used to determine base type
	 * @param constValue constant value as type/value pair to test with
	 */
	public void testPropertyDefConstValue(Tree sn, Tree constValue){
		String snStr=TokenUtils.getTreeString(sn, this.atoms.scope.getSeparator());
		String bt=this.atoms.getAtomValueType(snStr);
		String btFile=this.atoms.get(snStr, TSAtomList.alValFile).toString();
		Integer btLine=this.atoms.getAtomLine(snStr);
		Integer btCol=this.atoms.getAtomColumn(snStr);
		String cvType=TokenUtils.getTreeString2Lower(constValue, 0);
		this.testTypesBTvsCV(bt, btLine, btCol, btFile, cvType, TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));

		String currentAtom=this.atoms.scope.toString();
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMember}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;
		if(this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory, snStr)==true){
			//we have a required property, check the value (can only do Strings right now)
			String value=TokenUtils.getTreeString(constValue, 1).replace('"', ' ');
			if(value.equals(ColaConstants.Tokens.valueNULL)||value.trim().length()==0){
				StringTemplate st=RuleManager.property03(this.rules, snStr);
				this.reportManager.error(st.toString(), TokenUtils.getLine(constValue, 1), TokenUtils.getColumn(constValue, 1));
			}
		}
	}

	/**
	 * Does the final tests of a property definition list (propertyDefList).
	 */
	public void testPropertyDefList(){
		String currentAtom=this.atoms.scope.toString();
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMember}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;

		ArrayList<String> propertyDefList=this.tempScopedNames.get(this.atoms.scope.toString()+this.atoms.scope.getSeparator()+ColaConstants.Tokens.colaPROPERTY);

		//now we need to check if all mandatory and required properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.propertyDeclList.get(ColaConstants.Tokens.colaMANDATORY, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!propertyDefList.contains(al.get(i))){
				StringTemplate st=RuleManager.property01(this.rules, al.get(i), currentAtomCategory, currentAtom);
				this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
			}
			else{
				propertyDefList.remove(al.get(i));
			}
		}
		//now required properties
		al=this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!propertyDefList.contains(al.get(i))){
				StringTemplate st=RuleManager.property02(this.rules, al.get(i), currentAtomCategory, currentAtom);
				this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
			}
			else
				propertyDefList.remove(al.get(i));
		}
		//now remove all optional (thus legal) property defs
		al=this.propertyDeclList.get(ColaConstants.Tokens.colaOPTIONAL, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(propertyDefList.contains(al.get(i)))
				propertyDefList.remove(al.get(i));
		}
		if(propertyDefList.size()>0){
			//there are too many property defs in the list, mark them as error
			StringTemplate st=RuleManager.property15(this.rules, currentAtom, propertyDefList);
			this.reportManager.error(st.toString(), this.atoms.getAtomLine(), this.atoms.getAtomColumn());
		}
	}

	/**
	 * Tests scoped names in current context.
	 * @param snTree scoped name as tree
	 * @param reasonTK reason as token
	 * @return true if no problems, false otherwise
	 */
	public void testScopedName(CommonTree snTree, String reason){
		if(snTree==null||reason==null||snTree.getChildCount()==0)
			return;

		String separator=this.atoms.scope.getSeparator();
		String currentAtom=this.atoms.scope.toString();
		String currentAtomCategory=this.atoms.getAtomCategory();
		StringTemplate st;
		Token tk;

		String scopedName="";
		Vector<Token> scopedTokens=new Vector<Token>();
		for(int i=0;i<snTree.getChildCount();i++){
			tk=((CommonTree)snTree.getChild(i)).getToken();
			if(scopedName.length()>0)
				scopedName+=separator;
			scopedName+=tk.getText();

			//first check if there is any Atom registered
			if(this.atoms.containsKey(scopedName)==false){
				st=RuleManager.scopename01(this.rules, scopedName);
				this.reportManager.error(st.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				return;
			}
			//test node category to be valid scoped_name node (package, element, facility)
			String nodeCategory=this.atoms.getAtomCategory(scopedName);
			//do not test the last part, that's for later!
			if(i<(snTree.getChildCount()-1)&&StringUtils.equalsNone(nodeCategory, new String[]{ColaConstants.Tokens.colaPACKAGE, ColaConstants.Tokens.colaELEMENT, ColaConstants.Tokens.colaFACILITY})){
				st=RuleManager.scopename02(this.rules, scopedName, nodeCategory);
				this.reportManager.error(st.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				return;
			}

			scopedTokens.add(tk);
		}

		//if the overall scoped name does not exist, return with an error
		scopedName=TokenUtils.getTreeString(snTree, separator);
		if(this.atoms.containsKey(scopedName)==false){
			st=RuleManager.scopename01(this.rules, scopedName);
			this.reportManager.error(st.toString(), TokenUtils.getLine(scopedTokens.get(scopedTokens.size()-1)), TokenUtils.getColumn(scopedTokens.get(scopedTokens.size()-1)));
			return;
		}

		tk=scopedTokens.get(scopedTokens.size()-1);
		String scopedNameCategory=this.atoms.getAtomCategory(scopedName);

		//parameters, actions and members cannot be accessed with scoped names
		if(StringUtils.equalsAny(scopedNameCategory, new String[]{ColaConstants.Tokens.colaPARAMETER, ColaConstants.Tokens.colaACTION, ColaConstants.Tokens.parserMember})){
			st=RuleManager.scopename02(this.rules, scopedName, scopedNameCategory);
			this.reportManager.error(st.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
			return;
		}

		//scoped name exists and is correct, see if it was already used (for all reasons it can only be used once!)
		String put=currentAtom+separator+reason;
		ArrayList<String> list=new ArrayList<String>();
		if(this.tempScopedNames.containsKey(put))
			list=this.tempScopedNames.get(put);
		if(list.contains(scopedName)){
			//already in it, so an error
			st=RuleManager.scopename03(this.rules, scopedName, currentAtom, reason.toLowerCase());
			this.reportManager.error(st.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
		}
		else{
			list.add(scopedName);
			this.tempScopedNames.put(put, list);
		}

		//now run all final tests, against the special reasons and general scoped name rules
		boolean errorOnLeaf=false;

		if(reason.equals(ColaConstants.Tokens.colaAT_APPLY)){

		}
		if(reason.equals(ColaConstants.Tokens.colaAT_CONTAINS)){
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaELEMENT)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaELEMENT))
				errorOnLeaf=true;
		}
		if(reason.equals(ColaConstants.Tokens.colaAT_EXTENDS)){
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaPROPERTY)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaPROPERTY))
				errorOnLeaf=true;
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaELEMENT)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaELEMENT))
				errorOnLeaf=true;
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaFACILITY)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaFACILITY))
				errorOnLeaf=true;
		}
		if(reason.equals(ColaConstants.Tokens.colaAT_PROVIDES)){
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaELEMENT)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaFACILITY))
				errorOnLeaf=true;
		}
		if(reason.equals(ColaConstants.Tokens.colaAT_REQUIRES)){
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaPROPERTY)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaPROPERTY))
				errorOnLeaf=true;
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaELEMENT)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaELEMENT))
				errorOnLeaf=true;
			if(currentAtomCategory.equals(ColaConstants.Tokens.colaFACILITY)&&!scopedNameCategory.equals(ColaConstants.Tokens.colaFACILITY))
				errorOnLeaf=true;
		}
		if(reason.equals(ColaConstants.Tokens.colaAT_TYPE)){
			//for types, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
			if(StringUtils.equalsAny(scopedNameCategory, new String[]{ColaConstants.Tokens.colaPROPERTY, ColaConstants.Tokens.colaITEM, ColaConstants.Tokens.colaCONTRACT, ColaConstants.Tokens.colaPACKAGE, ColaConstants.Tokens.colaELEMENT, ColaConstants.Tokens.colaFACILITY})){
				StringTemplate err=RuleManager.scopename06(this.rules, scopedName, currentAtomCategory, scopedNameCategory);
				this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				return;
			}
		}
		if(reason.equals(ColaConstants.Tokens.colaCONTRACT)){
			if(!scopedNameCategory.equals(ColaConstants.Tokens.colaCONTRACT)){
				StringTemplate err=RuleManager.scopename05(this.rules, scopedName, scopedNameCategory);
				this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
			}
			else{
				//scoped name is a contract so check scope/rank
				String testCat=currentAtomCategory.toString();
				//now, if contract is declared not_def for category, that's an error
				if(this.contractDeclList.get(ColaConstants.Tokens.colaNOT_DEF, testCat, scopedName)==true){
					StringTemplate err=RuleManager.contract02(this.rules, scopedName, currentAtomCategory);
					this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				}
			}
		}
		if(reason.equals(ColaConstants.Tokens.colaPROPERTY)){
			if(!scopedNameCategory.equals(ColaConstants.Tokens.colaPROPERTY)){
				StringTemplate err=RuleManager.scopename04(this.rules, scopedName, scopedNameCategory);
				this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
			}
			else{
				//scoped name is a property so check scope/rank
				//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
				String testCat=currentAtomCategory;
				if(StringUtils.equalsAny(currentAtomCategory.toString(), new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMember})){
					testCat=ColaConstants.Tokens.colaATTRIBUTE;
				}
				//now, if property is declared not_def for category, that's an error
				if(this.propertyDeclList.get(ColaConstants.Tokens.colaNOT_DEF, testCat, scopedName)==true){
					StringTemplate err=RuleManager.property09(this.rules, scopedName, currentAtomCategory);
					this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
				}
			}
		}

		if(errorOnLeaf==true){
			StringTemplate err=RuleManager.scopename06(this.rules, scopedName, currentAtomCategory, scopedNameCategory);
			this.reportManager.error(err.toString(), TokenUtils.getLine(tk), TokenUtils.getColumn(tk));
		}
	}

	/**
	 * Tests the base type with the type of a constant value.
	 * @param bt base type as string
	 * @param btLine line the base type was defined in
	 * @param btCol column the base type was defined in
	 * @param btFile file the base type was defined in
	 * @param cv type of the common value as string
	 * @param cvLine line the common value was defined in
	 * @param cvCol column the common value was defined in
	 */
	private void testTypesBTvsCV(String bt, int btLine, int btCol, String btFile, String cv, int cvLine, int cvCol){
		if(!bt.equals(cv)){
			if(GrammarUtils.testBasetypeAndConstvalueInteger(bt, cv, new String[]{ColaConstants.Tokens.typeINTEGER, ColaConstants.Tokens.typeSHORT, ColaConstants.Tokens.typeLONG})==false){
				//warning for integer types
				StringTemplate st=RuleManager.property13(this.rules, this.atoms.scope.toString(), bt, cv, btFile, btLine, btCol);
				this.reportManager.warning(st.toString(), cvLine, cvCol);
			}
			else{
				//error since types don't match
				StringTemplate st=RuleManager.property12(this.rules, this.atoms.scope.toString(), bt, cv, btFile, btLine, btCol);
				this.reportManager.error(st.toString(), cvLine, cvCol);
			}
		}
	}
}





//public void itemDef(Token itemProp){
//boolean add=true;
//String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
////itemDef not declared
//if(this.atoms.containsKey(scoped)==false){
//	this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem02), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem02, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
//	add=false;
//}
//}

//public void itemDefListFinish(){
//String category=ColaConstants.Tokens.colaITEM;
//String scoped_add=this.sn.toString()+"::"+this.currentItemDef.getText()+"::";
////now we need to check if all mandatory and required item-properties have been defined
////let's start with the mandatory properties
//ArrayList<String> al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaMANDATORY);
//int size=al.size();
//for(int i=0; i<size; i++){
//	if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
//		this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem09, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem09), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
//	}
//}
//
//		al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaREQUIRED);
//size=al.size();
//for(int i=0; i<size; i++){
//	if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
//		this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem10, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem10), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
//	}
//}
//}
