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
import org.skb.util.languages.AtomList;
import org.skb.util.languages.ScopeString;

/**
 * Pass 3 of the Pola parser using templates to generate target language specifications.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class PolaPass3_Gen {
	static Logger logger = Logger.getLogger(PolaPass3_Gen.class);

	private AtomList atoms=AtomList.getInstance();
	public ScopeString sn;

	//for simple_type, to get all options to all DPOLAtoms
	private TreeMap<String,String> simple_type;

	public PolaPass3_Gen(){
		this.atoms.scope.clear();

		this.simple_type=new TreeMap<String,String>();
		this._initSimple_type();

		this.sn=new ScopeString();
	}

	private void _initSimple_type(){
		this.simple_type.clear();
		this.simple_type.put(PolaTokensConstants.parserScopedName, null);
		this.simple_type.put(PolaTokensConstants.parserBaseType, null);
		this.simple_type.put(PolaTokensConstants.parserARRAY, null);
		this.simple_type.put(PolaTokensConstants.polaVOID, null);
	}
	public void simple_typeClear(){this._initSimple_type();}
	public void simple_type(StringTemplate sc, String bt, String ar){
		if(sc!=null)
			this.simple_type.put(PolaTokensConstants.parserScopedName, sc.toString());
		this.simple_type.put(PolaTokensConstants.parserBaseType, bt);
		this.simple_type.put(PolaTokensConstants.parserARRAY, ar);
	}
	public void simple_typeVoid(){
		this._initSimple_type();
		this.simple_type.put(PolaTokensConstants.parserBaseType, PolaTokensConstants.polaVOID);
		this.simple_type.put(PolaTokensConstants.polaVOID, PolaTokensConstants.polaVOID);
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
		ret.put(PolaTokensConstants.gcMiscParrentID, this.atoms.getParrentId(key));
		ret.put(PolaTokensConstants.gcMiscParrentCat, this.atoms.getParrentCategory(key));
		ret.put(PolaTokensConstants.gcMiscSpecName, this.atoms.specificationName());
		ret.put(PolaTokensConstants.gcMiscCurrentScope, this.atoms.scope.toString());
		ret.put(PolaTokensConstants.gcMiscCurrentCat, this.atoms.get(this.atoms.scope.toString(), AtomList.alValCategory).toString());

		String cmpCat=cat;
		if(cmpCat==null)
			cmpCat=this.atoms.getParrentCategory(key);
		if(cmpCat.equals(PolaTokensConstants.polaCONTRACT))
			ret.put(PolaTokensConstants.gcMiscInContract, "true");
		if(cmpCat.equals(PolaTokensConstants.polaITEM))
			ret.put(PolaTokensConstants.gcMiscInItem, "true");
		else if(cmpCat.equals(PolaTokensConstants.polaPACKAGE))
			ret.put(PolaTokensConstants.gcMiscInPackage, "true");
		else if(cmpCat.equals(PolaTokensConstants.polaELEMENT))
			ret.put(PolaTokensConstants.gcMiscInElement, "true");
		else if(cmpCat.equals(PolaTokensConstants.polaFACILITY))
			ret.put(PolaTokensConstants.gcMiscInFacility, "true");
		else if(cmpCat.equals(PolaTokensConstants.polaACTION))
			ret.put(PolaTokensConstants.gcMiscInAction, "true");
		else if(cmpCat.equals(PolaTokensConstants.polaSTRUCT))
			ret.put(PolaTokensConstants.gcMiscInStruct, "true");
		else
			ret.put(PolaTokensConstants.gcMiscInDefinition, "true");
		return ret;
	}

	public String scopeTgtLangAdd(){
		String ret=null;
		//if function then no add...
		if(this.atoms.get(this.toString(),AtomList.alValCategory).equals(PolaTokensConstants.polaFUNCTION))
			return ret;
		return ret;
	}

}
