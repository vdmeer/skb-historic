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
import java.util.TreeMap;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.config.Configuration;
import org.skb.base.utils.GrammarUtils;
import org.skb.base.utils.StringUtils;
import org.skb.base.utils.TokenUtils;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.lang.cola.proto.internal.ContractDeclarationList;
import org.skb.lang.cola.proto.internal.PropertyDeclarationList;

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

	private TreeMap<String, ArrayList<String>> tempAtoms;

	/** List for Property Declarations */
	private PropertyDeclarationList propertyDeclList=(PropertyDeclarationList)config.config.get(ColaParser.pathInstancePropertyDeclarationList);

	/** List for Contract Declarations */
	private ContractDeclarationList contractDeclList=(ContractDeclarationList)config.config.get(ColaParser.pathInstanceContractDeclarationList);

	/**
	 * Class constructor, initialises local fields.
	 */
	public ColaPass2_Ast(){
		this.rules=config.getParserRuleManager().getSTG();

		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.tempAtoms=new TreeMap<String, ArrayList<String>>();

		this.reportManager=config.getReportManager();
	}

	//test property declaration description, must be string and non-empty
	public void testPropDeclDescription(Tree value){
		String val=value.toStringTree().replace('"', ' ');
		if(val.equals(ColaConstants.Tokens.valueNULL)||val.trim().length()==0){
			//TODO
			System.err.println("problem with description, no text given");
			//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty11, new String[]{this.atoms.get(this.atoms.scope.toString(), TSAtomList.alValCategory).toString(), this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty11), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
	}

	public void itemDefListStart(Token item){
//		this.currentItemDef=item;
//		this.contDefList.get(this.sn.toString()).add(item.getText());
//		this.itemDefList.clear();
	}

	public void itemDef(Token itemProp){
//		boolean add=true;
//		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
//		//itemDef not declared
//		if(this.atoms.containsKey(scoped)==false){
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem02), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem02, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
//			add=false;
//		}
//		//used once or more?
//		if(this.itemDefList.containsKey(scoped)){
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleIdentifier03), this.cr.getRuleAdd(ColaConstants.Rules.ruleIdentifier03, new String[]{scoped}), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
//			add=false;
//		}
//
//		//item-property is declared, and defined only once. we can add it, since scope is always valid (only rank differs
//		if(add==true)
//			this.itemDefList.put(new String(scoped), this.sn.getList());
	}

	public void itemDefValueStart(){
//		this.itemDefListValues=0;
	}

	public void itemDefValueTest(Token itemProp){
//		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
//		//first check if we have a item-property of that type
//		if(!this.atoms.containsKey(scoped))
//			return;
//
//		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();
//		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
//		if(!type.equals(const_valueType)){
//			if((type.equals(ColaConstants.Tokens.colaINTEGER)||type.equals(ColaConstants.Tokens.colaSHORT)||type.equals(ColaConstants.Tokens.colaLONG))&&
//			   (const_valueType.equals(ColaConstants.Tokens.colaINTEGER)||const_valueType.equals(ColaConstants.Tokens.colaSHORT)||const_valueType.equals(ColaConstants.Tokens.colaLONG))
//			){
//				this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleItem03, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem03, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
//			}
//			else{
//				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem04, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem04, new String[]{type, const_valueType}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
//			}
//		}
//		this.itemDefListValues++;
	}

	public void itemDefFinish(Token itemProp){
//		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
//		//first check if we have a property of that type
//		if(!this.atoms.containsKey(scoped))
//			return;
//
//		String type=this.atoms.getToken(scoped,TSAtomList.alValType).getText();
//
//		//error, type is not array but more than one value given
//		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaFALSE)&&this.itemDefListValues>1){
//			this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem05, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem05, new String[]{type, this.itemDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
//		}
//		//warning, type is array but only one value given
//		if(this.atoms.get(scoped,TSAtomList.alValTypeArray).equals(ColaConstants.Tokens.colaTRUE)&&(this.itemDefListValues==0||this.itemDefListValues==1)){
//			this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleItem06, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem06, new String[]{type, this.itemDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
//		}
//
//		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
//		String category=this.atoms.get(this.atoms.scope.toString(),TSAtomList.alValCategory).toString();
//		if(category.equals(ColaConstants.Tokens.colaTYPEDEF)||category.equals(ColaConstants.Tokens.colaSTRUCT)||category.equals(ColaConstants.Tokens.parserMEMBER))
//			category=ColaConstants.Tokens.colaATTRIBUTE;
//
//		if(this.contractDeclList.getItemDeclPropertyRank(this.sn.toString(), this.currentItemDef.getText(), itemProp.getText(), ColaConstants.Tokens.colaREQUIRED)==true){
//			//required property with no value, error
//			if(this.itemDefListValues==0){
//				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem07, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem07), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
//			}
//			//required property with 1 value, can only test for Strings now
//			if(this.itemDefListValues==1){
//				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
//				if(const_valueType.equals(ColaConstants.Tokens.colaSTRING)){
//					String const_value=this.lastCommonValue.getText();
//					const_value=const_value.replace('"', ' ');
//					if(const_value.equals(ColaConstants.Tokens.colaNULL)||const_value.trim().length()==0){
//						this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem08, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem08), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
//					}
//				}
//			}
//		}
	}

	public void itemDefListFinish(){
//		String category=ColaConstants.Tokens.colaITEM;
//		String scoped_add=this.sn.toString()+"::"+this.currentItemDef.getText()+"::";
//		//now we need to check if all mandatory and required item-properties have been defined
//		//let's start with the mandatory properties
//		ArrayList<String> al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaMANDATORY);
//		int size=al.size();
//		for(int i=0; i<size; i++){
//			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
//				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem09, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem09), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
//			}
//		}
//
//				al=this.contractDeclList.getArrayForRank(this.sn.toString(), this.currentItemDef.getText(), ColaConstants.Tokens.colaREQUIRED);
//		size=al.size();
//		for(int i=0; i<size; i++){
//			if(!this.itemDefList.containsKey(scoped_add+al.get(i))){
//				this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleItem10, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleItem10), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
//			}
//		}
//		this.currentItemDef=null;
	}



////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////


	/**
	 * Tests the simple type of a Cola atom if it is a scoped name
	 * @param stType simple type tree
	 * @return true if no problems, false otherwise
	 */
	public boolean testSimpleType(Tree stType){
		if(stType==null){
			return false;
		}
		else if(stType.getChildCount()==0){
			return false; //no children means no scoped name (sn starts with @scope)
		}
		else if(TokenUtils.getTreeString(stType,0).equals("AT_SCOPE")){
			return this.testScopedName(stType.getChild(0), null); // if at_scope is set, we use that scope
		}
		else if(StringUtils.equalsNone(TokenUtils.getTreeString(stType, 0), new String[]{"ARRAY", ColaConstants.Tokens.typeSTRING, ColaConstants.Tokens.typeINTEGER, ColaConstants.Tokens.typeOCTET, ColaConstants.Tokens.typeHEX, ColaConstants.Tokens.typeBINARY, ColaConstants.Tokens.typeFLOAT, ColaConstants.Tokens.typeCHAR, ColaConstants.Tokens.typeBOOLEAN, ColaConstants.Tokens.typeSTRING})){
			return this.testScopedName(stType, null); // if no at_scope and not an array or base_type, use that scope
		}
		else{
			return false;
		}
	}

	/**
	 * Tests scoped names in current context.
	 * @param snTree scoped name as tree
	 * @param reasonTK reason as token
	 * @return true if no problems, false otherwise
	 */
	public boolean testScopedName(Tree snTree, Token reasonTK){
		if(snTree==null)
			return false;
		String reason=new String();
		if(reasonTK!=null)
			reason=TokenUtils.getTokenString(reasonTK);
		String separator=this.atoms.scope.getSeparator();

		String currentAtom=this.atoms.scope.toString();
		String currentAtomCat=this.atoms.getAtomCategory(currentAtom);

		//System.err.println(parent+" == "+parentCat+" -- "+this.atoms.scope+" ==> "+sn);

		boolean ret=true;
		if(snTree.getChildCount()==0)
			return ret;
		String scoped="";
		//we test for the elements of the scoped name until -1 (not the last one!)
		for(int i=0;i<snTree.getChildCount()-1;i++){
			if(scoped.length()>0)
				scoped+=separator;
			scoped+=snTree.getChild(i).toString();
			//first check if there is any Atom registered, if so the test node category to be valid scoped_name node
			if(this.atoms.containsKey(scoped)==false){
				this.reportManager.error("invalid scoped name (" + scoped + ")", "no atom of that name declared", TokenUtils.getLine(snTree, i), TokenUtils.getColumn(snTree, i));
				ret=false;
			}
			else{
				String leafCat=this.atoms.getAtomCategory(scoped);
				if(StringUtils.equalsNone(leafCat, new String[]{ColaConstants.Tokens.colaPACKAGE, ColaConstants.Tokens.colaELEMENT, ColaConstants.Tokens.colaFACILITY})){
					this.reportManager.error("invalid scoped name (" + scoped + ")", scoped + " of type " + leafCat + " can't be used as part of scoped names", TokenUtils.getLine(snTree, i), TokenUtils.getColumn(snTree, i));
					ret=false;
				}
			}
		}

		//now test if the leaf is valid, if so, check also if it points to the correct Atom category
		if(scoped.length()>0)
			scoped+=separator;
		scoped+=snTree.getChild(snTree.getChildCount()-1).toString();
		Tree lastScoped=snTree.getChild(snTree.getChildCount()-1);
		if(this.atoms.containsKey(scoped)==false){
			this.reportManager.error("invalid scoped name <" + scoped + ">", "no atom of that name declared", TokenUtils.getLine(lastScoped), TokenUtils.getColumn(lastScoped));
			ret=false;
		}
		else{
			String leafCat=this.atoms.getAtomCategory(scoped);
			boolean errLeaf=false;
			//parameters, actions and members cannot be accessed with scoped names
			if(StringUtils.equalsAny(leafCat, new String[]{ColaConstants.Tokens.colaPARAMETER, ColaConstants.Tokens.colaACTION, ColaConstants.Tokens.parserMEMBER})){
				this.reportManager.error("invalid scoped name <" + scoped + ">", "cannot scope "+leafCat+"s", TokenUtils.getLine(lastScoped), TokenUtils.getColumn(lastScoped));
				ret=false;
			}
			//if specific reason, test against
			else if(!reason.equals("")){
				//put the scoped name into our tempAtom list to check for reuse
				if(this.putTempAtom(currentAtom, scoped, reason)==false)
					System.err.println(scoped+" already used for "+currentAtom);//TODO error message about already used

				//we have a specific reason, test against
				if(reason.equals(ColaConstants.Tokens.colaAT_EXTENDS)){
					if(currentAtomCat.equals(ColaConstants.Tokens.colaPROPERTY)&&!leafCat.equals(ColaConstants.Tokens.colaPROPERTY))
						errLeaf=true;
					if(currentAtomCat.equals(ColaConstants.Tokens.colaELEMENT)&&!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
						errLeaf=true;
					if(currentAtomCat.equals(ColaConstants.Tokens.colaFACILITY)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
						errLeaf=true;
				}
				else if(reason.equals(ColaConstants.Tokens.colaAT_PROVIDES)){
					if(currentAtomCat.equals(ColaConstants.Tokens.colaELEMENT)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
						errLeaf=true;
				}
				else if(reason.equals(ColaConstants.Tokens.colaAT_REQUIRES)){
					if(currentAtomCat.equals(ColaConstants.Tokens.colaPROPERTY)&&!leafCat.equals(ColaConstants.Tokens.colaPROPERTY))
						errLeaf=true;
					if(currentAtomCat.equals(ColaConstants.Tokens.colaELEMENT)&&!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
						errLeaf=true;
					if(currentAtomCat.equals(ColaConstants.Tokens.colaFACILITY)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
						errLeaf=true;
				}
				else if(reason.equals(ColaConstants.Tokens.colaAT_CONTAINS)){
					if(currentAtomCat.equals(ColaConstants.Tokens.colaELEMENT)&&!leafCat.equals(ColaConstants.Tokens.colaELEMENT))
						errLeaf=true;
				}
				else if(reason.toLowerCase().equals(ColaConstants.Tokens.colaPROPERTY)){
					if(!leafCat.equals(ColaConstants.Tokens.colaPROPERTY)){
						System.err.println("scoped name for PropDef is not a property"); //TODO
					}
					else{
						//scoped name is a property so check scope/rank
						//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
						String testCat=currentAtomCat.toString();
						if(StringUtils.equalsAny(currentAtomCat.toString(), new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMEMBER})){
							testCat=ColaConstants.Tokens.colaATTRIBUTE;
						}
						//now, if property is declared not_def for category, that's an error
						if(this.propertyDeclList.get(ColaConstants.Tokens.colaNOT_DEF, testCat, scoped)==true){
							System.err.println("property not specified for atom cat <"+currentAtom+">"); //TODO
							//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty09, new String[]{scoped, category}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty09), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
						}
					}
				}
				else if(reason.toLowerCase().equals(ColaConstants.Tokens.colaCONTRACT)){
					if(!leafCat.equals(ColaConstants.Tokens.colaCONTRACT)){
						System.err.println("scoped name for ContDef is not a contract"); //TODO
					}
					else{
						//scoped name is a contract so check scope/rank
						String testCat=currentAtomCat.toString();
						//now, if contract is declared not_def for category, that's an error
						if(this.contractDeclList.get(ColaConstants.Tokens.colaNOT_DEF, testCat, scoped)==true){
							System.err.println("contract not specified for atom cat <"+currentAtom+">"); //TODO
							//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract02, new String[]{this.sn.toString(), category}), null, TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
						}
					}
				}
				else
					;//System.err.println(reason);
			}
			//normal test, should be simple type
			else{
				//properties: must scope a property
				if(currentAtomCat.equals(ColaConstants.Tokens.colaPROPERTY)&&!leafCat.equals(ColaConstants.Tokens.colaPROPERTY))
					errLeaf=true;
				//contracts: must scope a contract
				if(currentAtomCat.equals(ColaConstants.Tokens.colaCONTRACT)&&!leafCat.equals(ColaConstants.Tokens.colaCONTRACT))
					errLeaf=true;
				//property used in items: must scope an item //TODO
				if(currentAtomCat.equals(ColaConstants.Tokens.colaITEM)&&!leafCat.equals(ColaConstants.Tokens.colaITEM))
					errLeaf=true;
				//facilities can only scope facilities
				if(currentAtomCat.equals(ColaConstants.Tokens.colaFACILITY)&&!leafCat.equals(ColaConstants.Tokens.colaFACILITY))
					errLeaf=true;
				//last not least action, parameter, attribute, typedef, member
				//for them, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
				if(StringUtils.equalsAny(currentAtomCat.toString(), new String[]{ColaConstants.Tokens.colaACTION, ColaConstants.Tokens.colaPARAMETER, ColaConstants.Tokens.colaATTRIBUTE, ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.parserMEMBER})){
					if(StringUtils.equalsAny(leafCat, new String[]{ColaConstants.Tokens.colaPROPERTY, ColaConstants.Tokens.colaITEM, ColaConstants.Tokens.colaCONTRACT, ColaConstants.Tokens.colaPACKAGE, ColaConstants.Tokens.colaELEMENT, ColaConstants.Tokens.colaFACILITY})){
						System.err.println(currentAtomCat+" == "+leafCat);
						errLeaf=true;
					}
				}
			}

			if(errLeaf==true){
				String msg=scoped + " of type " + leafCat + " can't be used as leaf of scoped names for " + currentAtomCat;
				this.reportManager.error("invalid scoped name (" + scoped + ")", msg, TokenUtils.getLine(lastScoped), TokenUtils.getColumn(lastScoped));
				ret=false;
			}
		}

		return ret;
	}

	/**
	 * Adds a new atom to the temporary (local) atom list.
	 * @param parent parent atom (one that is in the global atom list)
	 * @param atom atom to be added to the temporary list
	 * @param reason string giving a reason, used as separator and identifier for later access
	 * @return
	 */
	private boolean putTempAtom(String parent, String atom, String reason){
		String separator=this.atoms.scope.getSeparator();
		String put=parent+separator+reason;

		ArrayList<String> list=new ArrayList<String>();
		if(this.tempAtoms.containsKey(put))
			list=this.tempAtoms.get(put);
		if(list.contains(atom))
			return false;
		list.add(atom);
		this.tempAtoms.put(put, list);
		return true;
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
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMEMBER}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;
		if(this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory, snStr)==true){
			//we have a required property, check the value (can only do Strings right now)
			String value=TokenUtils.getTreeString(constValue, 1).replace('"', ' ');
			if(value.equals(ColaConstants.Tokens.valueNULL)||value.trim().length()==0){
				//TODO
				System.err.println("required property defined w/o value");
				//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty03, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty03), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			}

		}
	}

	/**
	 * Tests the constant value of a property definition, here the number of values defined against base type array and required scope.
	 * @param sn scoped name of associated with the value (points to the property declaration)
	 * @param values number of values defined for this property
	 */
	public void testPropertyDefConstValue(Tree sn, int values){
		String snStr=TokenUtils.getTreeString(sn, this.atoms.scope.getSeparator());
		Boolean btArray=this.atoms.atomTypeIsArray(snStr);

		String currentAtom=this.atoms.scope.toString();
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMEMBER}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;
		if(this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory, snStr)==true&&values==0){
			//property is required, so needs to have a value, if values==0, then error
			//TODO
			System.err.println("required property w/o any value: "+currentAtom+"("+snStr+")");
			//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty04, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty04), TokenUtils.getLine(NameScopeUtils.lastName(this.sn)), TokenUtils.getColumn(NameScopeUtils.lastName(this.sn)));
		}

		//error, type is not array but more than one value given
		if(btArray==false&&values>1){
			//TODO
			//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty06, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty06, new String[]{type, this.propDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
		//warning, type is array but only one value given
		if(btArray==true&&values==1){
			//TODO
			//this.reportManager.warning(this.cr.getRule(ColaConstants.Rules.ruleProperty05, new String[]{scoped}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty05, new String[]{type, this.propDefListValues.toString()}), this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
	}

	/**
	 * Adds the given identifier to the list of identifier for the current property definition and issues an error if already exists.
	 * @param ident identifier of property definition
	 */
	public void testPropDefIdent(Token ident){
		if(ident!=null)
			if(this.putTempAtom(this.atoms.scope.toString(), ident.getText(), ColaConstants.Tokens.colaAT_PROVIDES)==false)
				System.err.println("ident already used in context PropertyDefList");//TODO Error message about identifier already used
	}

	/**
	 * Does the final tests of a property definition list (propertyDefList).
	 */
	public void testPropertyDefList(){
		String currentAtom=this.atoms.scope.toString();
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);
		if(StringUtils.equalsAny(currentAtomCategory, new String[]{ColaConstants.Tokens.colaTYPEDEF, ColaConstants.Tokens.colaSTRUCT, ColaConstants.Tokens.parserMEMBER}))
			currentAtomCategory=ColaConstants.Tokens.colaATTRIBUTE;

		ArrayList<String> propertyDefList=this.tempAtoms.get(this.atoms.scope.toString()+this.atoms.scope.getSeparator()+"PROPERTY");

		//now we need to check if all mandatory and required properties have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.propertyDeclList.get(ColaConstants.Tokens.colaMANDATORY, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!propertyDefList.contains(al.get(i))){
				//TODO
				System.err.println("missing mandatory property in propertydeflist: <"+al.get(i));
				//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty01, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty01), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
			else
				propertyDefList.remove(al.get(i));
				
		}
		//now required properties
		al=this.propertyDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!propertyDefList.contains(al.get(i))){
				//TODO
				System.err.println("missing required property in propertydeflist: <"+al.get(i));
				//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleProperty02, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleProperty02), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
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
			//TODO
			System.err.println("properties illegally defined: "+propertyDefList);
		}
	}

	/**
	 * Adds the given identifier to the list of identifier for the current contract definition and issues an error if already exists.
	 * @param ident identifier of contract definition
	 */
	public void testContDefIdent(Token ident){
		if(ident!=null)
			if(this.putTempAtom(this.atoms.scope.toString(), ident.getText(), ColaConstants.Tokens.colaAT_CONTAINS)==false)
				System.err.println("ident already used in context ContractDefList");//TODO Error message about identifier already used
	}


	/**
	 * Does the final tests of a contract definition list (contractDefList).
	 */
	public void testContractDefList(){
		String currentAtom=this.atoms.scope.toString();
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
		String currentAtomCategory=this.atoms.getAtomCategory(currentAtom);

		ArrayList<String> contractDefList=this.tempAtoms.get(currentAtom+this.atoms.scope.getSeparator()+"CONTRACT");

		//now we need to check if all mandatory and required contracts have been defined
		//let's start with the mandatory properties
		ArrayList<String> al=this.contractDeclList.get(ColaConstants.Tokens.colaMANDATORY, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!contractDefList.contains(al.get(i))){
				//TODO
				System.err.println("missing mandatory contract in propertydeflist: <"+al.get(i));
				//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract03, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleContract03), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
			}
			else
				contractDefList.remove(al.get(i));
				
		}
		//now required contracts
		al=this.contractDeclList.get(ColaConstants.Tokens.colaREQUIRED, currentAtomCategory);
		for(int i=0; i<al.size(); i++){
			if(!contractDefList.contains(al.get(i))){
				//TODO
				System.err.println("missing required contract in propertydeflist: <"+al.get(i));
				//this.reportManager.error(this.cr.getRule(ColaConstants.Rules.ruleContract04, new String[]{al.get(i), category, this.atoms.scope.toString()}), this.cr.getRuleAdd(ColaConstants.Rules.ruleContract04), this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValLine).tsvalue, this.atoms.getInteger(this.atoms.scope.toString(),TSAtomList.alValColumn).tsvalue);
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
			//there are too many property defs in the list, mark them as error
			//TODO
			System.err.println("contracts illegally defined: "+contractDefList);
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
	//}


	}












}
