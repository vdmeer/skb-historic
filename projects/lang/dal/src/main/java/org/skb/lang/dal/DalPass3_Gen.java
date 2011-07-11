/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.lang.dal;

import java.util.TreeMap;

import org.antlr.stringtemplate.StringTemplate;
import org.skb.lang.dal.internal.DalRepository;
import org.skb.util.languages.AtomList;
import org.skb.util.languages.ScopeString;

/**
 * Pass 3 of the DAL parser using templates to generate a target language specification.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass3_Gen {
	public AtomList atoms=AtomList.getInstance();
	public ScopeString sn;
	public DalRepository repo;

	//for simple_type, to get all options to all ColaAtoms
	private TreeMap<String,String> simple_type;

	public DalPass3_Gen(){
		this.atoms.scope.clear();

		this.simple_type=new TreeMap<String,String>();
		this._initSimple_type();

		this.sn=new ScopeString();

		this.repo=DalRepository.getInstance();
	}

	public void addElement(String ident, String type, StringTemplate prop){
		System.err.println(ident+" -- "+type+" -- "+prop);
	}

	public void addMetaElement(String ident, StringTemplate meta){
		System.err.println(ident+"  =>  "+meta);
	}

	public String trimQuotes(String s){
		if(s==null)
			return "";
		int st=0;
		int en=s.length();
		if(s.endsWith("\""))
			en-=1;
		if(s.startsWith("\""))
			st+=1;
		return(s.substring(st, en));
	}

	private void _initSimple_type(){
		this.simple_type.clear();
		this.simple_type.put(DalTokensConstants.parserScopedName, null);
		this.simple_type.put(DalTokensConstants.parserBaseType, null);
		this.simple_type.put(DalTokensConstants.dalVOID, null);
	}
	public void simple_typeClear(){this._initSimple_type();}
	public void simple_type(StringTemplate sc, String bt, String ar){
		if(sc!=null)
			this.simple_type.put(DalTokensConstants.parserScopedName, sc.toString());
		this.simple_type.put(DalTokensConstants.parserBaseType, bt);
	}
	public void simple_typeVoid(){
		this._initSimple_type();
		this.simple_type.put(DalTokensConstants.parserBaseType, DalTokensConstants.dalVOID);
		this.simple_type.put(DalTokensConstants.dalVOID, DalTokensConstants.dalVOID);
	}
	public TreeMap<String,String> simple_type(){return new TreeMap<String,String>(this.simple_type);}

	//add ST to AtomList, so that we can manipulate them as needed later and keep the definition order intact
	public void addST(StringTemplate st){
		this.atoms.addST(st); //atoms knows the scope already, grammar needs to push for that
		this.atoms.scope.pop();
	}
}
