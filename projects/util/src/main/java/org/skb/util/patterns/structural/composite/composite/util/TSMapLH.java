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

package org.skb.util.patterns.structural.composite.composite.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSCompositeAPI;
import org.skb.util.patterns.structural.composite.TSMapAPI;
import org.skb.util.patterns.structural.composite.TSNull;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;

/**
 * The composite class for linked hash map.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSMapLH implements TSCompositeAPI, TSMapAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSMapLH.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** The local value. */
	protected LinkedHashMap<String, TSBaseAPI> tsvalue=null;


	/**
	 * Class constructor, initialises local members.
	 */
	public TSMapLH(){
		this._init();
	}


	/**
	 * Class constructor, initialises local members.
	 * @param map copy everything from map to the local map
	 */
	public TSMapLH(TSMapLH map){
		this._init();
		if(map!=null)
			this.tsvalue=new LinkedHashMap<String, TSBaseAPI>(map);
	}


	/**
	 * Local initialisation method.
	 * 
	 * This method adds TS_COMPOSITE, TS_COMPOSITE_MAP and TS_COMPOSITE_MAP_LH to the type lists (string and enum) and
	 * initialises the local map.
	 */
	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_COMPOSITE);
		this.typeEnum.add(TEnum.TS_COMPOSITE);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_MAP);
		this.typeEnum.add(TEnum.TS_COMPOSITE_MAP);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_MAP_LH);
		this.typeEnum.add(TEnum.TS_COMPOSITE_MAP_LH);

		this.tsvalue=new LinkedHashMap<String, TSBaseAPI>();
	}

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
			TSBaseAPI ct=this.tsvalue.get(list.get(0));
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
		if(this.isInitialised()&&list!=null&&list.length>0)
			return this.containsKey(new ArrayList<String>(Arrays.asList(list)));
		return false;
	}

	@Override
	public boolean containsKey(TSString key) {
		if(this.isInitialised()&&key!=null)
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
	public Set<java.util.Map.Entry<String, TSBaseAPI>> entrySet() {
		Set<java.util.Map.Entry<String, TSBaseAPI>> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.entrySet();
		if(ret==null)
			return new TreeSet<java.util.Map.Entry<String, TSBaseAPI>>();
		else
			return ret;
	}

	@Override
	public TSBaseAPI get(List<String> list) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return new TSNull();
		else if(list.size()==1)
			return this.tsvalue.get(list.get(0).toString());
		else if(this.tsvalue.containsKey(list.get(0).toString())){
			TSBaseAPI ct=this.tsvalue.get(list.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				list.remove(0);
				return ((TSMapAPI)ct).get(list);
			}
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(Object key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.get(key);
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(String key) {
		if(this.isInitialised()&&key!=null){
			if(StringUtils.contains(key, '/'))
				return this.get(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.tsvalue.get(key);
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(String[] list) {
		if(this.isInitialised()&&list!=null&&list.length>0)
			return this.get(new ArrayList<String>(Arrays.asList(list)));
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(TSString key) {
		if(this.isInitialised()&&key!=null)
			return this.get(key.toString());
		return new TSNull();
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
	public TSBaseAPI put(ArrayList<String> list, String val) {
		return this.put(list, new TSString(val));
	}

	@Override
	public TSBaseAPI put(List<String> list, TSBaseAPI val) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.tsvalue.put(list.get(0).toString(), val);
		else{
			String key=list.get(0);
			if(!this.tsvalue.containsKey(key))
				this.tsvalue.put(key, new TSMapLH());
			if(!(this.tsvalue.get(key).tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)))
				this.tsvalue.put(key, new TSMapLH());
			list.remove(0);
			return ((TSMapLH)this.tsvalue.get(key)).put(list, val);
		}
	}

	@Override
	public TSBaseAPI put(String key, String val) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), new TSString(val));
			else
				return this.tsvalue.put(key, new TSString(val));
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI put(String key, TSBaseAPI val) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), val);
			else
				return this.tsvalue.put(key, val);
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI put(String[] list, String val) {
		return this.put(new ArrayList<String>(Arrays.asList(list)), val);
	}

	@Override
	public TSBaseAPI put(String[] list, TSBaseAPI val) {
		return this.put(new ArrayList<String>(Arrays.asList(list)), val);
	}

	@Override
	public TSBaseAPI put(TSString key, TSBaseAPI val) {
		return this.put(key.toString(), val);
	}

	@Override
	public void putAll(Map<? extends String, ? extends TSBaseAPI> map) {
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
	public TSBaseAPI remove(List<String> list) {
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.tsvalue.remove(list.get(0).toString());
		else if(this.tsvalue.containsKey(list.get(0).toString())){
			TSBaseAPI ct=this.tsvalue.get(list.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				list.remove(0);
				return ((TSMapAPI)ct).remove(list);
			}
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI remove(Object key) {
		if(this.isInitialised())
			return this.tsvalue.remove(key);
		return new TSNull();
	}

	@Override
	public TSBaseAPI remove(String key) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.remove(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.tsvalue.remove(key);
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI remove(String[] list) {
		return this.remove(new ArrayList<String>(Arrays.asList(list)));
	}

	@Override
	public TSBaseAPI remove(TSString key) {
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
		TSBaseAPI val;
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
	public void tsPlus(TSBaseAPI tb) {
		// TODO
		logger.warn("tsPlus not implemented");
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
		TSBaseAPI val;

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
		// TODO
		logger.warn("tsTrim not implemented");
	}

	@Override
	public Collection<TSBaseAPI> values() {
		if(this.isInitialised())
			return this.tsvalue.values();
		return null;
	}

	@Override
	public Map<String, TSBaseAPI> tsGetMap() {
		if(this.isInitialised())
			return this.tsvalue;
		else
			return new LinkedHashMap<String, TSBaseAPI>();
	}

	@Override
	public TSMapLH tsGetValue(){
		return this;
	}


	@Override
	public TSMapLH tsCopyComposite(){
		TSMapLH ret=new TSMapLH();

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
