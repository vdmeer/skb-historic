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

package org.skb.util.types.composite.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.skb.util.types.TSNull;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.api.TSComposite;
import org.skb.util.types.api.TSMapAPI;
import org.skb.util.types.atomic.java.TSString;

/**
 * The composite class for linked hash map.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class TSMapLH implements TSComposite, TSMapAPI {
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));
	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	protected LinkedHashMap<String, TSBase> tsvalue=null;

	public TSMapLH(){
		this._init();
	}

	public TSMapLH(TSMapLH map){
		this._init();
//		if(map!=null)
//			this.tsvalue=new LinkedHashMap<String, TSBase>(map);
	}

	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_COMPOSITE);
		this.typeEnum.add(TEnum.TS_COMPOSITE);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_MAP);
		this.typeEnum.add(TEnum.TS_COMPOSITE_MAP);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_MAP_LH);
		this.typeEnum.add(TEnum.TS_COMPOSITE_MAP_LH);

		this.tsvalue=new LinkedHashMap<String, TSBase>();
	}

//	public OatMapLH(OatBaseArrayList a){
//		
//	}

	@Override
	public void clear() {
		if(this.isInitialised())
			this.tsvalue.clear();
	}

	@Override
	public boolean containsKey(List<String> list) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return false;
		else if(list.size()==1)
			return this.tsvalue.containsKey(list.get(0));
		else if(this.tsvalue.containsKey(list.get(0))){
			TSBase ct=this.tsvalue.get(list.get(0));
			if(ct.tsIsType(TSRepository.type(TEnum.TS_COMPOSITE_MAP))){
				list.remove(0);
				return ((TSMapAPI)ct).containsKey(list);
			}
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		if(this.isInitialised())
			return this.tsvalue.containsKey(key);
		else
			return false;
	}

	@Override
	public boolean containsKey(String key) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.containsKey(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.tsvalue.containsKey(key);
		}
		return false;
	}

	@Override
	public boolean containsKey(String[] list) {
		return this.containsKey(new ArrayList<String>(Arrays.asList(list)));
	}

	@Override
	public boolean containsKey(TSString key) {
		if(key!=null)
			return this.containsKey(key.toString());
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		if(this.isInitialised())
			return this.tsvalue.containsValue(value);
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, TSBase>> entrySet() {
		Set<java.util.Map.Entry<String, TSBase>> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.entrySet();
		if(ret==null)
			return new TreeSet<java.util.Map.Entry<String, TSBase>>();
		else
			return ret;
	}

	@Override
	public TSBase get(List<String> list) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.tsvalue.get(list.get(0).toString());
		else if(this.tsvalue.containsKey(list.get(0).toString())){
			TSBase ct=this.tsvalue.get(list.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				list.remove(0);
				return ((TSMapAPI)ct).get(list);
			}
		}
		return new TSNull();
	}

	@Override
	public TSBase get(Object key) {
		if(this.isInitialised())
			return this.tsvalue.get(key);
		return new TSNull();
	}

	@Override
	public TSBase get(String key) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.get(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.tsvalue.get(key);
		}
		return new TSNull();
	}

	@Override
	public TSBase get(String[] list) {
		return this.get(new ArrayList<String>(Arrays.asList(list)));
	}

	@Override
	public TSBase get(TSString key) {
		return this.get(key.toString());
	}

	@Override
	public void h2l() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		if(this.isInitialised())
			return this.tsvalue.isEmpty();
		return false;
	}

	@Override
	public boolean isInitialised() {
		if(this.tsvalue!=null)
			return true;
		else
			return false;
	}

	@Override
	public Set<String> keySet() {
		Set<String> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.keySet();
		if(ret==null)
			return new TreeSet<String>();
		else
			return ret;
	}

	@Override
	public void merge(TSMapAPI arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public TSBase put(ArrayList<String> list, String val) {
		return this.put(list, new TSString(val));
	}

	@Override
	public TSBase put(List<String> list, TSBase val) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.tsvalue.put(list.get(0).toString(), val);
		else{
			String key=list.get(0);
			if(!this.tsvalue.containsKey(key))
				this.tsvalue.put(key, new TSMapLH());
			list.remove(0);
			return ((TSMapLH)this.tsvalue.get(key)).put(list, val);
		}

		//return this.put(StringUtils.join(list, '/'), val);
	}

	@Override
	public TSBase put(String key, String val) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), val);
			else
				return this.tsvalue.put(key, new TSString(val));
		}
		return new TSNull();
	}

	@Override
	public TSBase put(String key, TSBase val) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), val);
			else
				return this.tsvalue.put(key, val);
		}
		return new TSNull();
	}

	@Override
	public TSBase put(String[] list, String val) {
		return this.put(new ArrayList<String>(Arrays.asList(list)), val);
	}

	@Override
	public TSBase put(String[] list, TSBase val) {
		return this.put(new ArrayList<String>(Arrays.asList(list)), val);
	}

	@Override
	public TSBase put(TSString key, TSBase val) {
		return this.put(key.toString(), val);
	}

	@Override
	public void putAll(Map<? extends String, ? extends TSBase> map) {
		String key;
		@SuppressWarnings("unchecked")
		Set<String> o_set = (Set<String>) map.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			this.put(key, map.get(key));
		}
	}

	@Override
	public void putAll(TSMapAPI map) {
		if(this.isInitialised()&&map!=null)
			this.putAll(map.tsGetMap());
	}

	@Override
	public TSBase remove(List<String> list) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.tsvalue.remove(list.get(0).toString());
		else if(this.tsvalue.containsKey(list.get(0).toString())){
			TSBase ct=this.tsvalue.get(list.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				list.remove(0);
				return ((TSMapAPI)ct).remove(list);
			}
		}
		return new TSNull();
	}

	@Override
	public TSBase remove(Object key) {
		if(this.isInitialised())
			return this.tsvalue.remove(key);
		return new TSNull();
	}

	@Override
	public TSBase remove(String key) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.remove(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.tsvalue.remove(key);
		}
		return new TSNull();
	}

	@Override
	public TSBase remove(String[] list) {
		return this.remove(new ArrayList<String>(Arrays.asList(list)));
	}

	@Override
	public TSBase remove(TSString key) {
		return this.remove(key.toString());
	}

	@Override
	public int size() {
		if(this.isInitialised())
			return this.tsvalue.size();
		return 0;
	}

	public String toString(){
		return this.tsToString(0);
	}

	@Override
	public void tsClean() {
		ArrayList<String> listRemove=new ArrayList<String>();
		String key;
		TSBase val;
		Set<String> o_set = this.tsvalue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			val=this.tsvalue.get(key);
			if(val==null||val.tsIsType(TEnum.TS_NULL)){
				listRemove.add(key);
				continue;
			}
			switch(val.tsGetTypeEnum()){
				case TS_COMPOSITE:
					val.tsClean();
					break;
				case TS_ATOMIC_JAVA_STRING:
					if(((TSString)val).tsvalue.length()==0)
						listRemove.add(key);
					break;
				default:
					break;
			}
		}
		for(int i=0;i<listRemove.size();i++)
			this.tsvalue.remove(listRemove.get(i));
	}

	@Override
	public TEnum tsGetTypeEnum() {
		return TSRepository.type(this.typeString.lastElement());
	}

	@Override
	public Set<TEnum> tsGetTypeEnumSet() {
		return this.typeEnum;
	}

	@Override
	public String tsGetTypeString() {
		return this.typeString.lastElement();
	}

	@Override
	public List<String> tsGetTypeStringList() {
		return this.typeString;
	}

	@Override
	public boolean tsIsAtomic() {
		return false;
	}

	@Override
	public boolean tsIsComposite() {
		return true;
	}

	@Override
	public boolean tsIsType(String t) {
		return this.typeString.contains(t);
	}

	@Override
	public boolean tsIsType(TEnum t) {
		return this.typeEnum.contains(t);
	}

	@Override
	public void tsPlus(TSBase tb) {
		// TODO Auto-generated method stub

	}

	@Override
	public String tsToString(int indent) {
		if(!this.isInitialised())
			return new String();

		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();
		String key;
		TSBase val;

		Set<String> o_set = this.tsvalue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			val=this.tsvalue.get(key);
			if(val!=null){
				if(val.tsIsType(TSRepository.TEnum.TS_COMPOSITE))
					ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => \n"+this.tsvalue.get(key).tsToString(indent)+"\n";
				else
					ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => "+this.tsvalue.get(key).toString()+"\n";
			}
		}
		return ret;
	}

	@Override
	public void tsTrim() {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<TSBase> values() {
		if(this.isInitialised())
			return this.tsvalue.values();
		return null;
	}

	@Override
	public Map<String, TSBase> tsGetMap() {
		if(this.isInitialised())
			return this.tsvalue;
		else
			return new LinkedHashMap<String, TSBase>();
	}

	@Override
	public TSMapLH tsGetValue(){
		return this;
	}
}
