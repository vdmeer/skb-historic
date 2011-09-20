/* Copyright (c) 2011-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
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

package org.skb.util.composite.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSComposite;
import org.skb.util.composite.TSCompositeAPI;
import org.skb.util.composite.TSNull;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.TSTableRowAPI;
import org.skb.util.composite.java.TSString;

/**
 * Implementation of a Table row with predefined columns.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSTableRow extends TSComposite implements TSTableRowAPI{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSTableRow.class);

	/** The actual table row */
	protected Map<String, TSBaseAPI> tsvalue=null;

	public TSTableRow(Map<String, TSBaseAPI> map){
		this._init();
		this.tsvalue=map;
	}


	private TSTableRow(){
		this._init();
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_COMPOSITE_TABLEROW);
		this.typeEnum.add(TEnum.TS_COMPOSITE_TABLEROW);
	}

	@Override
	public void clear() {
		if(this.tsvalue!=null)
			this.tsvalue.clear();
	}

	@Override
	public boolean containsKey(Object arg0) {
		if(this.tsvalue!=null&&arg0!=null)
			return this.tsvalue.containsKey(arg0);
		else
			return false;
	}

	@Override
	public boolean containsKey(String key) {
		if(this.tsvalue!=null&&key!=null)
			return this.tsvalue.containsKey(key);
		else
			return false;
	}

	@Override
	public boolean containsKey(TSString key) {
		if(this.tsvalue!=null&&key!=null)
			return this.tsvalue.containsKey(key.toString());
		else
			return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		if(this.tsvalue!=null&&arg0!=null)
			return this.tsvalue.containsValue(arg0);
		else
			return false;
	}

	@Override
	public boolean containsValue(TSBaseAPI value) {
		if(this.tsvalue!=null&&value!=null)
			return this.tsvalue.containsValue(value);
		else
			return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, TSBaseAPI>> entrySet() {
		Set<java.util.Map.Entry<String, TSBaseAPI>> ret=null;
		if(this.tsvalue!=null)
			ret=this.tsvalue.entrySet();
		if(ret==null)
			return new TreeSet<java.util.Map.Entry<String, TSBaseAPI>>();
		else
			return ret;
	}

	@Override
	public TSBaseAPI get(Object arg0) {
		TSBaseAPI ret=null;
		if(this.tsvalue!=null&&arg0!=null)
			ret=this.tsvalue.get(arg0);
		if(ret==null)
			return new TSNull();
		else
			return ret;
	}

	@Override
	public TSBaseAPI get(String key) {
		TSBaseAPI ret=null;
		if(this.tsvalue!=null&&key!=null)
			ret=this.tsvalue.get(key);
		if(ret==null)
			return new TSNull();
		else
			return ret;
	}

	@Override
	public TSBaseAPI get(TSString key) {
		TSBaseAPI ret=null;
		if(this.tsvalue!=null&&key!=null)
			ret=this.tsvalue.get(key.toString());
		if(ret==null)
			return new TSNull();
		else
			return ret;
	}

	@Override
	public boolean isEmpty() {
		if(this.tsvalue!=null)
			return this.tsvalue.isEmpty();
		else
			return true;
	}

	@Override
	public Set<String> keySet() {
		Set<String> ret=null;
		if(this.tsvalue!=null)
			ret=this.tsvalue.keySet();
		if(ret==null)
			return new TreeSet<String>();
		else
			return ret;
	}

	@Override
	public TSBaseAPI put(String arg0, TSBaseAPI arg1) {
		if(this.tsvalue!=null&&arg0!=null&&arg1!=null)
			return this.tsvalue.put(arg0, arg1);
		else
			return new TSNull();
	}

	@Override
	public TSBaseAPI put(TSString key, TSBaseAPI val) {
		if(this.tsvalue==null||key==null||val==null)
			return new TSNull();

		if(this.tsvalue.containsKey(key.toString()))
			return this.tsvalue.put(key.toString(), val);
		else
			return new TSNull();
	}

	@Override
	public void putAll(Map<? extends String, ? extends TSBaseAPI> arg0) {
		String key;
		@SuppressWarnings("unchecked")
		Set<String> o_set = (Set<String>) arg0.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			this.put(key, arg0.get(key));
		}
	}

	@Override
	public TSBaseAPI remove(Object arg0) {
		// we do not remove any keys from a row in a table, so return null
		return new TSNull();
	}

	@Override
	public int size() {
		if(this.tsvalue!=null)
			return this.tsvalue.size();
		else
			return -1;
	}

	@Override
	public String tsToString(int indent) {
		if(this.tsvalue==null)
			return "";

		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();
		String key;
		TSBaseAPI val;

		Set<String> o_set = this.tsvalue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			val=this.tsvalue.get(key);
			if(val==null||val.tsIsType(TEnum.TS_NULL))
				ret+=indentation+"["+key+"] => "+val+"\n";
			else{
				if(val.tsIsType(TSRepository.TEnum.TS_COMPOSITE))
					ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => \n"+this.tsvalue.get(key).tsToString(indent)+"\n";
				else
					ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => "+this.tsvalue.get(key).toString()+"\n";
			}
		}
		return ret;
	}

	@Override
	public String toString(){
		return this.tsToString(0);
	}

	@Override
	public void tsTrim() {
		Set<String> o_set = this.tsvalue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			this.tsvalue.get(key_it.next()).tsTrim();
		}
	}

	@Override
	public Collection<TSBaseAPI> values() {
		if(this.tsvalue!=null)
			return this.tsvalue.values();
		else
			return new TreeSet<TSBaseAPI>();
	}

	@Override
	public Map<String, TSBaseAPI> tsGetMap() {
		if(this.tsvalue!=null)
			return this.tsvalue;
		else
			return new TreeMap<String, TSBaseAPI>();
	}

	@Override
	public TSTableRow tsGetValue(){
		return this;
	}


	@Override
	public TSTableRow tsCopyComposite(){
		TSTableRow ret=new TSTableRow();
		ret.tsvalue=new LinkedHashMap<String, TSBaseAPI>();

		String key;
		Set<String> o_set=(Set<String>)this.tsvalue.keySet();
		Iterator<String> key_it=o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			if(this.tsvalue.get(key)==null)
				ret.tsvalue.put(key, null);
			else if(this.tsvalue.get(key).tsIsAtomic())
				ret.tsvalue.put(key, ((TSAtomicAPI)this.tsvalue.get(key)).tsCopyAtomic());
			else
				ret.tsvalue.put(key, ((TSCompositeAPI)this.tsvalue.get(key)).tsCopyComposite());
		}
		return ret;
	}
}
