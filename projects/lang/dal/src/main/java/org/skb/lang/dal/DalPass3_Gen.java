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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.tribe.TribeProperties;
import org.skb.util.languages.AtomList;
import org.skb.util.languages.ScopeString;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.util.TSArrayListString;

/**
 * Pass 3 of the DAL parser using templates to generate a target language specification.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class DalPass3_Gen {
	static Logger logger = Logger.getLogger(DalPass3_Gen.class);

	public AtomList atoms=AtomList.getInstance();
	public ScopeString sn;

	//for simple_type, to get all options to all ColaAtoms
	private TreeMap<String,String> simple_type;

	//for temporary sequence lists
	TSArrayListString tempSeq;

	//collect constants, i.e. column name of repository fields
	TSArrayListString fieldNames;

	public DalPass3_Gen(){
		this.atoms.scope.clear();

		this.simple_type=new TreeMap<String,String>();
		this._initSimple_type();

		this.sn=new ScopeString();

		this.tempSeq=new TSArrayListString();

		this.fieldNames=new TSArrayListString();
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
		this.simple_type.put(DalConstants.Tokens.parserScopedName, null);
		this.simple_type.put(DalConstants.Tokens.parserBaseType, null);
		this.simple_type.put(DalConstants.Tokens.dalVOID, null);
	}
	public void simple_typeClear(){this._initSimple_type();}
	public void simple_type(StringTemplate sc, String bt, String ar){
		if(sc!=null)
			this.simple_type.put(DalConstants.Tokens.parserScopedName, sc.toString());
		this.simple_type.put(DalConstants.Tokens.parserBaseType, bt);
	}
	public void simple_typeVoid(){
		this._initSimple_type();
		this.simple_type.put(DalConstants.Tokens.parserBaseType, DalConstants.Tokens.dalVOID);
		this.simple_type.put(DalConstants.Tokens.dalVOID, DalConstants.Tokens.dalVOID);
	}
	public TreeMap<String,String> simple_type(){return new TreeMap<String,String>(this.simple_type);}

	//add ST to AtomList, so that we can manipulate them as needed later and keep the definition order intact
	public void addST(StringTemplate st){
		this.atoms.addST(st); //atoms knows the scope already, grammar needs to push for that
		this.atoms.scope.pop();
	}

	public ArrayList<StringTemplate> sequenceFields(String repo, String table, List<StringTemplate> fields) {
		ArrayList<StringTemplate> ret=new ArrayList<StringTemplate>();
		//extract keys from fields (grammar)
		LinkedHashMap<String, StringTemplate> ordered=new LinkedHashMap<String, StringTemplate>();
		for (Iterator<StringTemplate> it=fields.iterator(); it.hasNext();){
			StringTemplate st=it.next();
			ordered.put(st.getAttribute("ident").toString(), st);
		}
		//go through sequence and add st in correct order to return list
		for(int i=0;i<this.tempSeq.size();i++){
			String field=this.tempSeq.get(i).toString();
			if(ordered.containsKey(field))
				ret.add(ordered.get(field));

		}
		this.tempSeq.clear();
		return ret;
	}

	public void addToSequence(Token tk){
		this.tempSeq.add(tk.getText());
	}

	public LinkedHashMap<String, String> fixKV(LinkedHashMap<String, List<StringTemplate>> kv){
		LinkedHashMap<String, String> ret=new LinkedHashMap<String, String>();
		String key;
		Set<String> o_set = kv.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			String value="";
			List<StringTemplate> list=kv.get(key);
			for(int i=0;i<list.size();i++){
				if(value.length()>0)
					value+=", ";
				value+=StringUtils.removeEnd(StringUtils.removeStart(list.get(i).toString(), "\""), "\"");
			}
			ret.put(key, value);
		}
		return ret;
	}

	public void addFieldName(Token id){
		Boolean printRepoFields=false;
		try {
			printRepoFields=((TSBoolean)TribeProperties.getInstance().getValue(DalConstants.Properties.keyPrintRepoFields)).tsvalue;
		} catch (Exception e) {}
		if(printRepoFields==true)
			System.err.println(id.getText());
	}
}
