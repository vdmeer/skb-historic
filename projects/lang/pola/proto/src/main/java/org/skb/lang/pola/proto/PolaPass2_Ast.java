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
import org.skb.tribe.TribeProperties;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;
import org.skb.util.languages.ScopeToken;

/**
 * Pass 2 of the Pola parser mostly doing semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class PolaPass2_Ast {
	static Logger logger = Logger.getLogger(PolaPass2_Ast.class);

	private AtomList atoms=AtomList.getInstance();
	public ScopeToken sn;
//	private PropertyDeclarationList propertyDeclList=PropertyDeclarationList.getInstance();
//	private ContractDeclarationList contractDeclList=ContractDeclarationList.getInstance();

	
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

	public PolaPass2_Ast(){
		this.atoms.scope.clear();

		this.eprCategory="";
		this.eprAtom="";
		this.eprList=new LinkedHashMap<String, String>();

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
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once","in " + this.eprCategory + " declaration for " + this.eprAtom + ": " + epr + " (previously used in " + this.eprList.get(epr) + ")",tk.getLine(),tk.getCharPositionInLine());
			return;
		}
		else if(this.testSN(this.eprAtom, this.eprCategory)==false)
			return;
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
			if((base_type.equals(PolaTokensConstants.polaINTEGER)||base_type.equals(PolaTokensConstants.polaSHORT)||base_type.equals(PolaTokensConstants.polaLONG))&&
			   (const_valueType.equals(PolaTokensConstants.polaINTEGER)||const_valueType.equals(PolaTokensConstants.polaSHORT)||const_valueType.equals(PolaTokensConstants.polaLONG))
			)
				ReportManager.getInstance().reportWarning("potential type mismatch for " + t + " declaration " + this.atoms.scope.toString(),"type declared is " + base_type + ", value associated is of type " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError("type mismatch for " + t + " declaration " + this.atoms.scope.toString(),"type declared is " + base_type + ", value associated is of type " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		}
	}

	//test property declaration description, must be string and non-empty
	public void testPropDeclDescription(){
		String val=this.lastCommonValue.getText();
		val=val.replace('"', ' ');
		if(val.equals(PolaTokensConstants.polaNULL)||val.trim().length()==0)
			ReportManager.getInstance().reportError("empty description in " + this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory) + " " + this.atoms.scope.toString(),"description needs to be a non-empty " + PolaTokensConstants.polaSTRING, this.lastCommonValue.getLine(),this.lastCommonValue.getCharPositionInLine());
	}


	public void propDefListStart(){this.propDefList.clear();}
	public void propDef(){
		boolean add=true;
		String scoped=this.sn.toString();
		//propDef not declared
		if(this.atoms.containsKey(scoped)==false){
			ReportManager.getInstance().reportError("declaration of unknown " + PolaTokensConstants.polaPROPERTY,PolaTokensConstants.polaPROPERTY + " " + scoped + " is not specified",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}
		//used once or more?
		if(this.propDefList.containsKey(scoped)){
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once",PolaTokensConstants.parserIDENTIFIER + " " + scoped + " in property definitions",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}

		//property is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		if(add==true){
			//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
//			String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
//			if(category.equals(DPOLTokens.polaTYPEDEF)||category.equals(DPOLTokens.polaSTRUCT)||category.equals(DPOLTokens.parserMEMBER))
//				category=DPOLTokens.polaATTRIBUTE;
			//now, if property is declared not_def for category, that's an error
//			if(this.propertyDeclList.get(DPOLTokens.polaNOT_DEF, category, scoped)==true)
//				ReportManager.getInstance().reportError("used " + DPOLTokens.polaPROPERTY + " " + scoped + " is not specified for " + category,"note: typedef, struct and member are handled as attributes",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
//			else
//				this.propDefList.put(new String(scoped), this.sn.getList());
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
			if((type.equals(PolaTokensConstants.polaINTEGER)||type.equals(PolaTokensConstants.polaSHORT)||type.equals(PolaTokensConstants.polaLONG))&&
			   (const_valueType.equals(PolaTokensConstants.polaINTEGER)||const_valueType.equals(PolaTokensConstants.polaSHORT)||const_valueType.equals(PolaTokensConstants.polaLONG))
			)
				ReportManager.getInstance().reportWarning("potential type mismatch for " + PolaTokensConstants.polaPROPERTY + " definition " + scoped, "expected " + type + ", found " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError("type mismatch for " + PolaTokensConstants.polaPROPERTY + " definition " + scoped, "expected " + type + ", found " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
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
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(PolaTokensConstants.polaFALSE)&&this.propDefListValues>1)
			ReportManager.getInstance().reportError  ("type mismatch for " + PolaTokensConstants.polaPROPERTY + " definition " + scoped,"type expected is " + type + ", but " + this.propDefListValues + " values given", this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(PolaTokensConstants.polaTRUE)&&(this.propDefListValues==0||this.propDefListValues==1))
			ReportManager.getInstance().reportWarning("potential type mismatch for " + PolaTokensConstants.polaPROPERTY + " definition " + scoped,"type expected is " + type + "[], but only " + this.propDefListValues + " value given", this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
//		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
//		if(category.equals(DPOLTokens.polaTYPEDEF)||category.equals(DPOLTokens.polaSTRUCT)||category.equals(DPOLTokens.parserMEMBER))
//			category=DPOLTokens.polaATTRIBUTE;
		//now, if property is declared not_def for category, that's an error
/*
		if(this.propertyDeclList.get(DPOLTokens.polaREQUIRED, category, scoped)==true){
			//required property with no value, error
			if(this.propDefListValues==0)
				ReportManager.getInstance().reportError("missing value for required " + DPOLTokens.polaPROPERTY + " " + scoped + ", no value given","required properties must be declared non-empty",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			//required property with 1 value, can only test for Strings now
			if(this.propDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(DPOLTokens.polaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(DPOLTokens.polaNULL)||const_value.trim().length()==0)
						ReportManager.getInstance().reportError("missing value for required " + DPOLTokens.polaPROPERTY + " " + scoped + ", one empty value given","required properties must be declared non-empty", this.lastCommonValue.getLine(),this.lastCommonValue.getCharPositionInLine());
				}
			}
		}
*/
	}

	public void propDefListFinish(){
		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
//		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
//		if(category.equals(DPOLTokens.polaTYPEDEF)||category.equals(DPOLTokens.polaSTRUCT)||category.equals(DPOLTokens.parserMEMBER))
//			category=DPOLTokens.polaATTRIBUTE;

		//now we need to check if all mandatory and required properties have been defined
		//let's start with the mandatory properties
/*
		ArrayList<String> al=this.propertyDeclList.get(DPOLTokens.polaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i)))
				ReportManager.getInstance().reportError("missing mandatory " + DPOLTokens.polaPROPERTY + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all mandatory properties need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));
		}
		al=this.propertyDeclList.get(DPOLTokens.polaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.propDefList.containsKey(al.get(i)))
				ReportManager.getInstance().reportError("missing required " + DPOLTokens.polaPROPERTY + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all required properties need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));
		}
*/
	}


	public void contDefListStart(){this.contDefList.clear();}

	public void contDef(){
		String scoped=this.sn.toString();
		Token tk=this.sn.get(this.sn.size()-1);

		//check if the scoped_name of contract is declared already (can use contract only once)
		if(this.contDefList.containsKey(scoped))
			ReportManager.getInstance().reportError(PolaTokensConstants.polaCONTRACT + " defined more than once: " + scoped,tk);

		//contract is declared, and defined only once. let's see if we can add it (scope is set to our current element category)
		//if contract is declared not_def for category, that's an error
//		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
//		if(this.contractDeclList.get(DPOLTokens.polaNOT_DEF, category, this.sn.getAsString())==true)
//			ReportManager.getInstance().reportError("used " + DPOLTokens.polaCONTRACT + " " + this.sn.getAsString() + " is not specified for " + category,null,this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());

		//add contract, regardless of errors, to continue parsing (can help to catch multiple errors in one compile iteration and should not break anything)
		this.contDefList.put(scoped, new ArrayList<String>());
	}

	public void contDefListFinish(){
//		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
		//now we need to check if all mandatory and required contracts have been defined
		//let's start with the mandatory properties
/*
		ArrayList<String> al=this.contractDeclList.get(DPOLTokens.polaMANDATORY,category);
		int size=al.size();
		for(int i=0; i<size; i++)
			if(!this.contDefList.containsKey(al.get(i)))
				ReportManager.getInstance().reportError("missing mandatory " + DPOLTokens.polaCONTRACT + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all mandatory contracts need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));
		//now the required contracts
		al=this.contractDeclList.get(DPOLTokens.polaREQUIRED,category);
		size=al.size();
		for(int i=0; i<size; i++)
			if(!this.contDefList.containsKey(al.get(i)))
				ReportManager.getInstance().reportError("missing required " + DPOLTokens.polaCONTRACT + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all required contracts need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));

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
						ReportManager.getInstance().reportError("missing declared item <" + cntDecl.get(key).get(i) + "> for declared contract <" + key + ">","all declared items must be defined",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());

			}
		}
*/
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
			ReportManager.getInstance().reportError("declaration of unknown " + PolaTokensConstants.parserItemProp,PolaTokensConstants.parserItemProp + " " + scoped + " is not specified",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}
		//used once or more?
		if(this.itemDefList.containsKey(scoped)){
			ReportManager.getInstance().reportError(PolaTokensConstants.parserIDENTIFIER + " used more than once",PolaTokensConstants.parserIDENTIFIER + " " + scoped + " in item-property definitions",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			add=false;
		}

		//item-property is declared, and defined only once. we can add it, since scope is always valid (only rank differs
		if(add==true)
			this.itemDefList.put(new String(scoped), this.sn.getList());
	}

	public void itemDefValueStart(){this.itemDefListValues=0;}
	public void itemDefValueTest(Token itemProp){
		String scoped=this.sn.toString()+"::"+this.currentItemDef.getText()+"::"+itemProp.getText();
		//first check if we have a item-property of that type
		if(!this.atoms.containsKey(scoped))
			return;

		String type=this.atoms.getToken(scoped,AtomList.alValType).getText();
		String const_valueType=this.lastCommonValueType.getText().toLowerCase();
		if(!type.equals(const_valueType)){
			if((type.equals(PolaTokensConstants.polaINTEGER)||type.equals(PolaTokensConstants.polaSHORT)||type.equals(PolaTokensConstants.polaLONG))&&
			   (const_valueType.equals(PolaTokensConstants.polaINTEGER)||const_valueType.equals(PolaTokensConstants.polaSHORT)||const_valueType.equals(PolaTokensConstants.polaLONG))
			)
				ReportManager.getInstance().reportWarning("potential type mismatch for " + PolaTokensConstants.parserItemProp + " definition " + scoped, "expected " + type + ", found " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
			else
				ReportManager.getInstance().reportError("type mismatch for " + PolaTokensConstants.parserItemProp + " definition " + scoped, "expected " + type + ", found " + const_valueType, this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
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
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(PolaTokensConstants.polaFALSE)&&this.itemDefListValues>1)
			ReportManager.getInstance().reportError  ("type mismatch for " + PolaTokensConstants.parserItemProp + " definition " + scoped,"type expected is " + type + ", but " + this.itemDefListValues + " values given", this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());
		//warning, type is array but only one value given
		if(this.atoms.get(scoped,AtomList.alValTypeArray).equals(PolaTokensConstants.polaTRUE)&&(this.itemDefListValues==0||this.itemDefListValues==1))
			ReportManager.getInstance().reportWarning("potential type mismatch for " + PolaTokensConstants.parserItemProp + " definition " + scoped,"type expected is " + type + "[], but only " + this.itemDefListValues + " value given", this.lastCommonValue.getLine(), this.lastCommonValue.getCharPositionInLine());

		//categories TYPEDEF, STRUCT and MEMBER are handled like ATTRIBUTE
//		String category=this.atoms.get(this.atoms.scope.toString(),AtomList.alValCategory).toString();
//		if(category.equals(DPOLTokens.polaTYPEDEF)||category.equals(DPOLTokens.polaSTRUCT)||category.equals(DPOLTokens.parserMEMBER))
//			category=DPOLTokens.polaATTRIBUTE;
/*
		if(this.contractDeclList.getItemDeclPropertyRank(this.sn.getAsString(), this.currentItemDef.getText(), itemProp.getText(), DPOLTokens.polaREQUIRED)==true){
			//required property with no value, error
			if(this.itemDefListValues==0)
				ReportManager.getInstance().reportError("missing value for required " + DPOLTokens.parserItemProp + " " + scoped + ", no value given","required item-properties must be declared non-empty",this.sn.get(this.sn.size()-1).getLine(),this.sn.get(this.sn.size()-1).getCharPositionInLine());
			//required property with 1 value, can only test for Strings now
			if(this.itemDefListValues==1){
				String const_valueType=this.lastCommonValueType.getText().toLowerCase();
				if(const_valueType.equals(DPOLTokens.polaSTRING)){
					String const_value=this.lastCommonValue.getText();
					const_value=const_value.replace('"', ' ');
					if(const_value.equals(DPOLTokens.polaNULL)||const_value.trim().length()==0)
						ReportManager.getInstance().reportError("missing value for required " + DPOLTokens.parserItemProp + " " + scoped + ", one empty value given","required item-properties must be declared non-empty", this.lastCommonValue.getLine(),this.lastCommonValue.getCharPositionInLine());
				}
			}
		}
*/
	}

	public void itemDefListFinish(){
//		String category=PolaTokensConstants.polaITEM;
//		String scoped_add=this.sn.toString()+"::"+this.currentItemDef.getText()+"::";
		//now we need to check if all mandatory and required item-properties have been defined
		//let's start with the mandatory properties
/*
		ArrayList<String> al=this.contractDeclList.getArrayForRank(this.sn.getAsString(), this.currentItemDef.getText(), DPOLTokens.polaMANDATORY);
		int size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i)))
				ReportManager.getInstance().reportError("missing mandatory " + DPOLTokens.polaPROPERTY + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all mandatory item-properties need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));
		}
		al=this.contractDeclList.getArrayForRank(this.sn.getAsString(), this.currentItemDef.getText(), DPOLTokens.polaREQUIRED);
		size=al.size();
		for(int i=0; i<size; i++){
			if(!this.itemDefList.containsKey(scoped_add+al.get(i)))
				ReportManager.getInstance().reportError("missing required " + DPOLTokens.polaPROPERTY + " <" + al.get(i) + "> for " + category + " <" + this.atoms.scope.toString() +">","all required item-properties need to be declared",this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valLine),this.atoms.getInteger(this.atoms.scope.toString(),AtomList.valColumn));
		}
		this.currentItemDef=null;
*/
	}

	public boolean testSN(String category, String catElem){
		boolean ret=true;
		if(this.sn.size()==0)
			return ret;
		String scoped="";
		for (int i=0; i<this.sn.size()-1; i++){
			Token tk=this.sn.get(i);
			if(scoped.length()>0)
				scoped+=TribeProperties.getInstance().getValue(PolaPropertiesConstants.keyScopeSep).toString();
			scoped+=this.sn.get(i).getText();
			//first check if there is any Atom registered, if so the test node category to be valid scoped_name node
			if(this.atoms.containsKey(scoped)==false){
				ReportManager.getInstance().reportError("invalid scoped name (" + scoped + ")","no atom of that name declared",tk.getLine(),tk.getCharPositionInLine());
				ret=false;
			}
			else{
				String leafCat=this.atoms.get(scoped, AtomList.alValCategory).toString();
				if(!leafCat.equals(PolaTokensConstants.polaPACKAGE)&&
				   !leafCat.equals(PolaTokensConstants.polaELEMENT)&&
				   !leafCat.equals(PolaTokensConstants.polaFACILITY)
				  ){
					ReportManager.getInstance().reportError("invalid scoped name (" + scoped + ")",scoped + " of type " + leafCat + " can't be used as part of scoped names",tk.getLine(),tk.getCharPositionInLine());
					ret=false;
				}
			}
		}
		//now test if the leaf is valid, if so, check also if it points to the correct Atom category
		if(scoped.length()>0)
			scoped+=TribeProperties.getInstance().getValue(PolaPropertiesConstants.keyScopeSep).toString();
		scoped+=this.sn.get(this.sn.size()-1).getText();
		Token tk=this.sn.get(this.sn.size()-1);
		if(this.atoms.containsKey(scoped)==false){
			ReportManager.getInstance().reportError("invalid scoped name <" + scoped + ">","no atom of that name declared",tk.getLine(),tk.getCharPositionInLine());
			ret=false;
		}
		else{
			String leafCat=this.atoms.get(scoped, AtomList.alValCategory).toString();
			if(leafCat.equals(PolaTokensConstants.polaPARAMETER)||leafCat.equals(PolaTokensConstants.polaACTION)){
				ReportManager.getInstance().reportError("invalid scoped name <" + scoped + ">","cannot scope "+leafCat+"s",tk.getLine(),tk.getCharPositionInLine());
				ret=false;
			}
			else if(leafCat.equals(PolaTokensConstants.parserMEMBER)){
				ReportManager.getInstance().reportError("invalid scoped name <" + scoped + ">","cannot scope members",tk.getLine(),tk.getCharPositionInLine());
				ret=false;
			}
			else{
				boolean errLeaf=false;
				//properties first
				if(category.equals(PolaTokensConstants.polaPROPERTY)&&!leafCat.equals(PolaTokensConstants.polaPROPERTY))
					errLeaf=true;
				//now contracts
				if(category.equals(PolaTokensConstants.polaCONTRACT)&&!leafCat.equals(PolaTokensConstants.polaCONTRACT))
					errLeaf=true;
				//property used in items
				if(category.equals(PolaTokensConstants.polaITEM)&&!leafCat.equals(PolaTokensConstants.polaITEM))
					errLeaf=true;
				//now facilities
				if(category.equals(PolaTokensConstants.polaFACILITY)&&!leafCat.equals(PolaTokensConstants.polaFACILITY))
					errLeaf=true;
				//now elements only
				if(catElem!=null&&category.equals(PolaTokensConstants.polaELEMENT)){
					//first check category extends, means elements only
					if(catElem.equals(PolaTokensConstants.polaAT_EXTENDS)&&!leafCat.equals(PolaTokensConstants.polaELEMENT))
						errLeaf=true;
					//now check provides, means facilities only
					if(catElem.equals(PolaTokensConstants.polaAT_PROVIDES)&&!leafCat.equals(PolaTokensConstants.polaFACILITY))
						errLeaf=true;
					//now go into requires, can be elements or facilities
					if(catElem.equals(PolaTokensConstants.polaAT_REQUIRES)){
						if(!leafCat.equals(PolaTokensConstants.polaFACILITY)&&!leafCat.equals(PolaTokensConstants.polaELEMENT))
							errLeaf=true;
					}
					//now go into contains, can be elements only
					if(catElem.equals(PolaTokensConstants.polaAT_CONTAINS)){
						if(!leafCat.equals(PolaTokensConstants.polaELEMENT))
							errLeaf=true;
					}
				}
				//last not least action, parameter, attribute, typedef, member
				//for them, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
				if(category.equals(PolaTokensConstants.polaACTION)||category.equals(PolaTokensConstants.polaPARAMETER)||category.equals(PolaTokensConstants.polaATTRIBUTE)||category.equals(PolaTokensConstants.polaTYPEDEF)||category.equals(PolaTokensConstants.parserMEMBER)){
					if(leafCat.equals(PolaTokensConstants.polaPROPERTY)||leafCat.equals(PolaTokensConstants.polaITEM)||leafCat.equals(PolaTokensConstants.polaCONTRACT)||leafCat.equals(PolaTokensConstants.polaPACKAGE)||leafCat.equals(PolaTokensConstants.polaELEMENT)||leafCat.equals(PolaTokensConstants.polaFACILITY))
						errLeaf=true;
				}
				if(errLeaf==true){
					String msg=scoped + " of type " + leafCat + " can't be used as leaf of scoped names for " + category;
					if(catElem!=null)
						msg+=" " + catElem;
					ReportManager.getInstance().reportError("invalid scoped name (" + scoped + ")",msg,tk.getLine(),tk.getCharPositionInLine());
					ret=false;
				}
			}
		}
		return ret;
	}

}
