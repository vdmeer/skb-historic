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

import java.util.TreeMap;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.lang.pola.proto.constants.PolaConstants;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.lang.ScopeString;
import org.skb.util.composite.lang.TSAtomList;

/**
 * Pass 3 of the Pola parser using templates to generate target language specifications.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PolaPass3_Gen {
	/** Logger instance */
	static Logger logger = Logger.getLogger(PolaPass3_Gen.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(PolaParser.class);

	public TSAtomList atoms;
	public ScopeString sn;

	//for simple_type, to get all options to all DPOLAtoms
	private TreeMap<String,String> simple_type;

	public PolaPass3_Gen(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.simple_type=new TreeMap<String,String>();
		this._initSimple_type();

		this.sn=new ScopeString();
	}

	private void _initSimple_type(){
		this.simple_type.clear();
		this.simple_type.put(PolaConstants.Tokens.parserScopedName, null);
		this.simple_type.put(PolaConstants.Tokens.parserBaseType, null);
		this.simple_type.put(PolaConstants.Tokens.parserARRAY, null);
		this.simple_type.put(PolaConstants.Tokens.polaVOID, null);
	}
	public void simple_typeClear(){this._initSimple_type();}
	public void simple_type(StringTemplate sc, String bt, String ar){
		if(sc!=null)
			this.simple_type.put(PolaConstants.Tokens.parserScopedName, sc.toString());
		this.simple_type.put(PolaConstants.Tokens.parserBaseType, bt);
		this.simple_type.put(PolaConstants.Tokens.parserARRAY, ar);
	}
	public void simple_typeVoid(){
		this._initSimple_type();
		this.simple_type.put(PolaConstants.Tokens.parserBaseType, PolaConstants.Tokens.polaVOID);
		this.simple_type.put(PolaConstants.Tokens.polaVOID, PolaConstants.Tokens.polaVOID);
	}
	public TreeMap<String,String> simple_type(){return new TreeMap<String,String>(this.simple_type);}

	public TreeMap<String,String> misc(){return this.genMiscAttribute();}

	//add ST to AtomList, so that we can manipulate them as needed later and keep the definition order intact
	public void addST(StringTemplate st){
		this.atoms.addST(st); //atoms knows the scope already, grammar needs to push for that
		this.atoms.scope.pop();
	}

	public TreeMap<String,String> genMiscAttribute(){return this. genMiscAttribute(null, null);}

	//keep key and cat null if you want to use current values or use overload function below
	public TreeMap<String,String> genMiscAttribute(String key, String cat){
		TreeMap<String,String>ret=new TreeMap<String,String>();
		ret.put(PolaConstants.Tokens.gcMiscParrentID, this.atoms.getParrentId(key));
		ret.put(PolaConstants.Tokens.gcMiscParrentCat, this.atoms.getParrentCategory(key));
		ret.put(PolaConstants.Tokens.gcMiscSpecName, this.atoms.specificationName());
		ret.put(PolaConstants.Tokens.gcMiscCurrentScope, this.atoms.scope.toString());
		ret.put(PolaConstants.Tokens.gcMiscCurrentCat, this.atoms.get(this.atoms.scope.toString(), TSAtomList.alValCategory).toString());

		String cmpCat=cat;
		if(cmpCat==null)
			cmpCat=this.atoms.getParrentCategory(key);
		if(cmpCat.equals(PolaConstants.Tokens.polaCONTRACT))
			ret.put(PolaConstants.Tokens.gcMiscInContract, "true");
		if(cmpCat.equals(PolaConstants.Tokens.polaITEM))
			ret.put(PolaConstants.Tokens.gcMiscInItem, "true");
		else if(cmpCat.equals(PolaConstants.Tokens.polaPACKAGE))
			ret.put(PolaConstants.Tokens.gcMiscInPackage, "true");
		else if(cmpCat.equals(PolaConstants.Tokens.polaELEMENT))
			ret.put(PolaConstants.Tokens.gcMiscInElement, "true");
		else if(cmpCat.equals(PolaConstants.Tokens.polaFACILITY))
			ret.put(PolaConstants.Tokens.gcMiscInFacility, "true");
		else if(cmpCat.equals(PolaConstants.Tokens.polaACTION))
			ret.put(PolaConstants.Tokens.gcMiscInAction, "true");
		else if(cmpCat.equals(PolaConstants.Tokens.polaSTRUCT))
			ret.put(PolaConstants.Tokens.gcMiscInStruct, "true");
		else
			ret.put(PolaConstants.Tokens.gcMiscInDefinition, "true");
		return ret;
	}

	public String scopeTgtLangAdd(){
		String ret=null;
		//if function then no add...
		if(this.atoms.get(this.toString(),TSAtomList.alValCategory).toString().equals(PolaConstants.Tokens.polaFUNCTION))
			return ret;
		return ret;
	}

}
