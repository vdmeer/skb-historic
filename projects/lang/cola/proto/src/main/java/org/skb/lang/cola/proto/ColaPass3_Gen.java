/* Copyright (c) 2000-2011 Sven van der Meer
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

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.base.FieldKeys;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.config.Configuration;
import org.skb.base.lang.NameScope;
import org.skb.base.utils.AtomListUtils;
import org.skb.base.utils.NameScopeUtils;
import org.skb.lang.cola.proto.constants.ColaConstants;

/**
 * Pass 3 of the Cola parser using templates to generate a target language specification.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ColaPass3_Gen {
	/** Logger instance */
	static Logger logger = Logger.getLogger(ColaPass3_Gen.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(ColaParser.class);

	public TSAtomList atoms;
	public NameScope sn;

	//for property Declarations, to get the whole scope as an array into the template
	private TreeMap<String,String> propertyScope;

	//for property def lists per declared atom
	private TreeSet<String> propDefList;

	//for simple_type, to get all options to all ColaAtoms
	private TreeMap<String,String> simple_type;

	public ColaPass3_Gen(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.propDefList=new TreeSet<String>();

		this.propertyScope=new TreeMap<String,String>();
		this._initPropertyScope();

		this.simple_type=new TreeMap<String,String>();
		this._initSimple_type();

		this.sn=new NameScope();
	}

	private void _initPropertyScope(){
		this.propertyScope.clear();
		this.propertyScope.put(ColaConstants.Tokens.colaCONTRACT,  ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaPACKAGE,   ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaELEMENT,   ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaFACILITY,  ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaACTION,    ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaATTRIBUTE, ColaConstants.Tokens.colaNOT_DEF);
		this.propertyScope.put(ColaConstants.Tokens.colaPARAMETER, ColaConstants.Tokens.colaNOT_DEF);
	}
	public void clearPropertyScope(){this._initPropertyScope();}
	public void addPropertyScope(StringTemplate atom, StringTemplate rank){this.propertyScope.put(atom.toString(), rank.toString());}
	public TreeMap<String,String> propertyScope(){return new TreeMap<String,String>(this.propertyScope);}

	public boolean propertyDefIsArray(List<Object> cv){
		boolean ret=false;
		if(cv==null)
			return ret;
		if(cv.size()>1)
			ret=true;
		return ret;
	}

	public void clearPropDefList(){this.propDefList.clear();}
	public void addPropDefList(String p){this.propDefList.add(p);}
	public TreeSet<String> getPropDefList(){return this.propDefList;}

	public String getPropDefBaseType(String p){
		return this.atoms.getToken(p,TSAtomList.alValType).getText();
	}

	private void _initSimple_type(){
		this.simple_type.clear();
		this.simple_type.put(ColaConstants.Tokens.parserScopedName, null);
		this.simple_type.put(ColaConstants.Tokens.parserBaseType, null);
		this.simple_type.put(ColaConstants.Tokens.parserARRAY, null);
		this.simple_type.put(ColaConstants.Tokens.typeVOID, null);
	}
	public void simple_typeClear(){this._initSimple_type();}
	public void simple_type(StringTemplate sc, String bt, String ar){
		if(sc!=null)
			this.simple_type.put(ColaConstants.Tokens.parserScopedName, sc.toString());
		this.simple_type.put(ColaConstants.Tokens.parserBaseType, bt);
		this.simple_type.put(ColaConstants.Tokens.parserARRAY, ar);
	}
	public void simple_typeVoid(){
		this._initSimple_type();
		this.simple_type.put(ColaConstants.Tokens.parserBaseType, ColaConstants.Tokens.typeVOID);
		this.simple_type.put(ColaConstants.Tokens.typeVOID, ColaConstants.Tokens.typeVOID);
	}
	public TreeMap<String,String> simple_type(){return new TreeMap<String,String>(this.simple_type);}

	public TreeMap<String,String> misc(){return this.genMiscAttribute();}

	//add ST to AtomList, so that we can manipulate them as needed later and keep the definition order intact
	public void addST(StringTemplate st){
		this.atoms.addST(st); //atoms knows the scope already, grammar needs to push for that
		this.atoms.scope.pop();
	}

	public String inline_code(String ic){
		String ret=ic.replace("<<?", "");
		return ret.replace("?>>", "");
	}


	public String inline_codeLanguage(String lang){
		TSBaseAPI ata=config.getProperties().getValue(FieldKeys.fieldCliOptionTgtLanguage);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)&&ata.toString().equals(ColaConstants.Properties.internalColaTgtCola)){
			return lang;
		}

		String ret=lang.replace("\"", "");
		ret.replace("\"", "");
		ata=config.getProperties().getValue(FieldKeys.fieldCliOptionTgtLanguage);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)&&ata.toString().equals(ret)){
			return ret;
		}
		return null;
	}

	public TreeMap<String,String> genMiscAttribute(){
		return this. genMiscAttribute(null, null);
	}
	
  	//keep key and cat null if you want to use current values or use overload function below
	public TreeMap<String,String> genMiscAttribute(String key, String cat){
		TreeMap<String,String>ret=new TreeMap<String,String>();
		ret.put(ColaConstants.Tokens.gcMiscParrentID, NameScopeUtils.getParentID(this.atoms.scope.toString(), this.atoms.scope.getSeparator()));
		ret.put(ColaConstants.Tokens.gcMiscParrentCat, AtomListUtils.getParentCategory(this.atoms.scope.toString(), this.atoms));
		ret.put(ColaConstants.Tokens.gcMiscSpecName, this.atoms.getSpecificationName());
		ret.put(ColaConstants.Tokens.gcMiscCurrentScope, this.atoms.scope.toString());
		ret.put(ColaConstants.Tokens.gcMiscCurrentCat, this.atoms.getAtomCategory());

		String cmpCat=AtomListUtils.getParentCategory(this.atoms.scope.toString(), this.atoms);
		if(cmpCat==null)
			cmpCat=AtomListUtils.getParentCategory(key, this.atoms);
		if(cmpCat.equals(ColaConstants.Tokens.colaCONTRACT))
			ret.put(ColaConstants.Tokens.gcMiscInContract, "true");
		if(cmpCat.equals(ColaConstants.Tokens.colaITEM))
			ret.put(ColaConstants.Tokens.gcMiscInItem, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaPACKAGE))
			ret.put(ColaConstants.Tokens.gcMiscInPackage, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaELEMENT))
			ret.put(ColaConstants.Tokens.gcMiscInElement, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaFACILITY))
			ret.put(ColaConstants.Tokens.gcMiscInFacility, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaACTION))
			ret.put(ColaConstants.Tokens.gcMiscInAction, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaSTRUCT))
			ret.put(ColaConstants.Tokens.gcMiscInStruct, "true");
		else
			ret.put(ColaConstants.Tokens.gcMiscInDefinition, "true");
		return ret;
	}

	public String scopeTgtLangAdd(){
		String ret=null;
		if(this.atoms.get(this.sn.toString(),TSAtomList.alValCategory).toString().equals(ColaConstants.Tokens.colaFUNCTION))
			return ret;
		if(config.getProperties().getValue(FieldKeys.fieldCliOptionTgtLanguage).toString().equals(ColaConstants.Properties.internalColaTgtJava)){
			TSBaseAPI javaPkg=config.getProperties().getValue(ColaConstants.Properties.keyXtJavaPackage);
			if(javaPkg!=null&&javaPkg.toString().length()>0)
				ret=config.getProperties().getValue(ColaConstants.Properties.keyXtJavaPackage).toString();
		}
		return ret;
	}
}
