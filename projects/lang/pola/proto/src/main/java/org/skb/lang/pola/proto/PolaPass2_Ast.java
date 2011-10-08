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

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.config.Configuration;
import org.skb.base.lang.NameScope;
import org.skb.base.lang.TokenUtils;
import org.skb.lang.pola.proto.constants.PolaConstants;

/**
 * Pass 2 of the Pola parser mostly doing semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PolaPass2_Ast {
	/** Logger instance */
	static Logger logger = Logger.getLogger(PolaPass2_Ast.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(PolaParser.class);

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

//	/** Language Rule map for error/warning reporting */
//	private LanguageRuleMap cr;

	/** Scope processing using ANTLR Tokens */
	public NameScope sn;

	// temp Type and Value for testing
	private Token lastBaseType=null;
	private Token lastCommonValue=null;
	private Token lastCommonValueType=null;

	public PolaPass2_Ast(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();
		this.sn=new NameScope();
	}


	// temp Type and Value for testing
	public void setLastBaseType(Token tk){
		this.lastBaseType=tk;
	}
	public void setLastCommonValue(Token tk){
		this.lastCommonValue=tk;
	}
	public void setLastCommonValueType(Token tk){
		this.lastCommonValueType=tk;
	}
	public void setLastCommonValuePlusType(Token value, Token type){
		this.setLastCommonValueType(type);
		this.setLastCommonValue(value);
	}

	public boolean testSN(String category, String catElem){
		boolean ret=true;
		if(this.sn.size()==0)
			return ret;
		String scoped="";
		for (int i=0; i<this.sn.size()-1; i++){
			TSBaseAPI tk=this.sn.get(i);
			if(scoped.length()>0)
				scoped+=config.getProperties().getValue(PolaConstants.Properties.keyScopeSep).toString();
			scoped+=this.sn.get(i).toString();
			//first check if there is any Atom registered, if so the test node category to be valid scoped_name node
			if(this.atoms.containsKey(scoped)==false){
				config.getReportManager().error("invalid scoped name (" + scoped + ")","no atom of that name declared",TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
				ret=false;
			}
			else{
				String leafCat=this.atoms.get(scoped, TSAtomList.alValCategory).toString();
				if(!leafCat.equals(PolaConstants.Tokens.polaPACKAGE)&&
				   !leafCat.equals(PolaConstants.Tokens.polaELEMENT)&&
				   !leafCat.equals(PolaConstants.Tokens.polaFACILITY)
				  ){
					config.getReportManager().error("invalid scoped name (" + scoped + ")",scoped + " of type " + leafCat + " can't be used as part of scoped names",TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
					ret=false;
				}
			}
		}
		//now test if the leaf is valid, if so, check also if it points to the correct Atom category
		if(scoped.length()>0)
			scoped+=config.getProperties().getValue(PolaConstants.Properties.keyScopeSep).toString();
		scoped+=this.sn.get(this.sn.size()-1).toString();
		TSBaseAPI tk=this.sn.get(this.sn.size()-1);
		if(this.atoms.containsKey(scoped)==false){
			config.getReportManager().error("invalid scoped name <" + scoped + ">","no atom of that name declared",TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
			ret=false;
		}
		else{
			String leafCat=this.atoms.get(scoped, TSAtomList.alValCategory).toString();
			if(leafCat.equals(PolaConstants.Tokens.polaPARAMETER)||leafCat.equals(PolaConstants.Tokens.polaACTION)){
				config.getReportManager().error("invalid scoped name <" + scoped + ">","cannot scope "+leafCat+"s",TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
				ret=false;
			}
			else if(leafCat.equals(PolaConstants.Tokens.parserMEMBER)){
				config.getReportManager().error("invalid scoped name <" + scoped + ">","cannot scope members",TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
				ret=false;
			}
			else{
				boolean errLeaf=false;
				//properties first
				if(category.equals(PolaConstants.Tokens.polaPROPERTY)&&!leafCat.equals(PolaConstants.Tokens.polaPROPERTY))
					errLeaf=true;
				//now contracts
				if(category.equals(PolaConstants.Tokens.polaCONTRACT)&&!leafCat.equals(PolaConstants.Tokens.polaCONTRACT))
					errLeaf=true;
				//property used in items
				if(category.equals(PolaConstants.Tokens.polaITEM)&&!leafCat.equals(PolaConstants.Tokens.polaITEM))
					errLeaf=true;
				//now facilities
				if(category.equals(PolaConstants.Tokens.polaFACILITY)&&!leafCat.equals(PolaConstants.Tokens.polaFACILITY))
					errLeaf=true;
				//now elements only
				if(catElem!=null&&category.equals(PolaConstants.Tokens.polaELEMENT)){
					//first check category extends, means elements only
					if(catElem.equals(PolaConstants.Tokens.polaAT_EXTENDS)&&!leafCat.equals(PolaConstants.Tokens.polaELEMENT))
						errLeaf=true;
					//now check provides, means facilities only
					if(catElem.equals(PolaConstants.Tokens.polaAT_PROVIDES)&&!leafCat.equals(PolaConstants.Tokens.polaFACILITY))
						errLeaf=true;
					//now go into requires, can be elements or facilities
					if(catElem.equals(PolaConstants.Tokens.polaAT_REQUIRES)){
						if(!leafCat.equals(PolaConstants.Tokens.polaFACILITY)&&!leafCat.equals(PolaConstants.Tokens.polaELEMENT))
							errLeaf=true;
					}
					//now go into contains, can be elements only
					if(catElem.equals(PolaConstants.Tokens.polaAT_CONTAINS)){
						if(!leafCat.equals(PolaConstants.Tokens.polaELEMENT))
							errLeaf=true;
					}
				}
				//last not least action, parameter, attribute, typedef, member
				//for them, the scoped name cannot be Property, Item, Contract, Package, Element, Facility
				if(category.equals(PolaConstants.Tokens.polaACTION)||category.equals(PolaConstants.Tokens.polaPARAMETER)||category.equals(PolaConstants.Tokens.polaATTRIBUTE)||category.equals(PolaConstants.Tokens.polaTYPEDEF)||category.equals(PolaConstants.Tokens.parserMEMBER)){
					if(leafCat.equals(PolaConstants.Tokens.polaPROPERTY)||leafCat.equals(PolaConstants.Tokens.polaITEM)||leafCat.equals(PolaConstants.Tokens.polaCONTRACT)||leafCat.equals(PolaConstants.Tokens.polaPACKAGE)||leafCat.equals(PolaConstants.Tokens.polaELEMENT)||leafCat.equals(PolaConstants.Tokens.polaFACILITY))
						errLeaf=true;
				}
				if(errLeaf==true){
					String msg=scoped + " of type " + leafCat + " can't be used as leaf of scoped names for " + category;
					if(catElem!=null)
						msg+=" " + catElem;
					config.getReportManager().error("invalid scoped name (" + scoped + ")",msg,TokenUtils.getLine(tk),TokenUtils.getColumn(tk));
					ret=false;
				}
			}
		}
		return ret;
	}

}
