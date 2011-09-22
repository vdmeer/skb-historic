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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSComposite;
import org.skb.util.composite.TSCompositeAPI;
import org.skb.util.composite.TSNull;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.TSTreeAPI;
import org.skb.util.composite.java.TSString;

/**
 * The composite class for a linked hash tree.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSLinkedHashTree extends TSComposite implements TSTreeAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSLinkedHashTree.class);

	/** The local value. */
	protected LinkedHashMap<String, TSBaseAPI> tsvalue=null;

	/**
	 * Class constructor, initialises local members.
	 */
	public TSLinkedHashTree(){
		this._init();
	}

	/**
	 * Class constructor, initialises local members.
	 * @param map copy everything from map to the local map
	 */
	public TSLinkedHashTree(TSLinkedHashTree map){
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
	public boolean containsKey(List<String> fqpn) {
		if(!this.isInitialised()||fqpn==null||fqpn.size()==0)
			return false;
		else if(fqpn.size()==1)
			return this.tsvalue.containsKey(fqpn.get(0));
		else if(this.tsvalue.containsKey(fqpn.get(0))){
			TSBaseAPI ct=this.tsvalue.get(fqpn.get(0));
			if(ct.tsIsType(TSRepository.type(TEnum.TS_COMPOSITE_MAP))){
				fqpn.remove(0);
				return ((TSTreeAPI)ct).containsKey(fqpn);
			}
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		if(this.isInitialised())
			return this.tsvalue.containsKey(key);
		return false;
	}

	@Override
	public boolean containsKey(String fqpn) {
		if(this.isInitialised()){
			if(StringUtils.contains(fqpn, '/'))
				return this.containsKey(new ArrayList<String>(Arrays.asList(StringUtils.split(fqpn, '/'))));
			return this.tsvalue.containsKey(fqpn);
		}
		return false;
	}

	@Override
	public boolean containsKey(String[] fqpn) {
		if(this.isInitialised()&&fqpn!=null&&fqpn.length>0)
			return this.containsKey(new ArrayList<String>(Arrays.asList(fqpn)));
		return false;
	}

	@Override
	public boolean containsKey(TSString fqpn) {
		if(this.isInitialised()&&fqpn!=null)
			return this.containsKey(fqpn.toString());
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
		return ret;
	}

	@Override
	public TSBaseAPI get(List<String> fqpn) {
		if(!this.isInitialised()||fqpn==null||fqpn.size()==0){
			return new TSNull();
		}
		else if(fqpn.size()==1){
			if(this.tsvalue.containsKey(fqpn.get(0).toString()))
				return this.tsvalue.get(fqpn.get(0).toString());
			return new TSNull();
		}
		else if(this.tsvalue.containsKey(fqpn.get(0).toString())){
			TSBaseAPI ct=this.tsvalue.get(fqpn.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				fqpn.remove(0);
				return ((TSTreeAPI)ct).get(fqpn);
			}
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(Object key) {
		if(this.isInitialised()&&key!=null){
			if(this.tsvalue.containsKey(key))
				return this.tsvalue.get(key);
			return new TSNull();				
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(String fqpn) {
		if(this.isInitialised()&&fqpn!=null){
			if(StringUtils.contains(fqpn, '/')){
				return this.get(new ArrayList<String>(Arrays.asList(StringUtils.split(fqpn, '/'))));
			}
			if(this.tsvalue.containsKey(fqpn)){
				return this.tsvalue.get(fqpn);
			}
			return new TSNull();
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(String[] fqpn) {
		if(this.isInitialised()&&fqpn!=null&&fqpn.length>0)
			return this.get(new ArrayList<String>(Arrays.asList(fqpn)));
		return new TSNull();
	}

	@Override
	public TSBaseAPI get(TSString fqpn) {
		if(this.isInitialised()&&fqpn!=null)
			return this.get(fqpn.toString());
		return new TSNull();
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
		return false;
	}

	@Override
	public Set<String> keySet() {
		Set<String> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.keySet();
		if(ret==null)
			return new TreeSet<String>();
		return ret;
	}

	@Override
	public TSBaseAPI put(ArrayList<String> fqpn, String val) {
		return this.put(fqpn, new TSString(val));
	}

	@Override
	public TSBaseAPI put(List<String> fqpn, TSBaseAPI val) {
		if(!this.isInitialised()||fqpn==null||fqpn.size()==0)
			return null;
		else if(fqpn.size()==1)
			return this.tsvalue.put(fqpn.get(0).toString(), val);
		else{
			String key=fqpn.get(0);
			if(!this.tsvalue.containsKey(key))
				this.tsvalue.put(key, new TSLinkedHashTree());
			if(!(this.tsvalue.get(key).tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)))
				this.tsvalue.put(key, new TSLinkedHashTree());
			fqpn.remove(0);
			return ((TSLinkedHashTree)this.tsvalue.get(key)).put(fqpn, val);
		}
	}

	@Override
	public TSBaseAPI put(String fqpn, String val) {
		if(this.isInitialised()){
			if(StringUtils.contains(fqpn, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(fqpn, '/'))), new TSString(val));
			return this.tsvalue.put(fqpn, new TSString(val));
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI put(String fqpn, TSBaseAPI val) {
		if(this.isInitialised()){
			if(StringUtils.contains(fqpn, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(fqpn, '/'))), val);
			return this.tsvalue.put(fqpn, val);
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI put(String[] fqpn, String val) {
		return this.put(new ArrayList<String>(Arrays.asList(fqpn)), val);
	}

	@Override
	public TSBaseAPI put(String[] fqpn, TSBaseAPI val) {
		return this.put(new ArrayList<String>(Arrays.asList(fqpn)), val);
	}

	@Override
	public TSBaseAPI put(TSString fqpn, TSBaseAPI val) {
		return this.put(fqpn.toString(), val);
	}

	@Override
	public void putAll(Map<? extends String, ? extends TSBaseAPI> map) {
		String fqpn;
		@SuppressWarnings("unchecked")
		Set<String> o_set = (Set<String>) map.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			fqpn=key_it.next();
			this.put(fqpn, map.get(fqpn));
		}
	}

	@Override
	public void putAll(TSTreeAPI map) {
		if(this.isInitialised()&&map!=null)
			this.putAll(map.tsGetTree());
	}

	@Override
	public TSBaseAPI remove(List<String> fqpn) {
		if(!this.isInitialised()||fqpn==null||fqpn.size()==0)
			return null;
		else if(fqpn.size()==1)
			return this.tsvalue.remove(fqpn.get(0).toString());
		else if(this.tsvalue.containsKey(fqpn.get(0).toString())){
			TSBaseAPI ct=this.tsvalue.get(fqpn.get(0).toString());
			if(ct.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP)){
				fqpn.remove(0);
				return ((TSTreeAPI)ct).remove(fqpn);
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
	public TSBaseAPI remove(String fqpn) {
		if(this.isInitialised()){
			if(StringUtils.contains(fqpn, '/'))
				return this.remove(new ArrayList<String>(Arrays.asList(StringUtils.split(fqpn, '/'))));
			return this.tsvalue.remove(fqpn);
		}
		return new TSNull();
	}

	@Override
	public TSBaseAPI remove(String[] fqpn) {
		return this.remove(new ArrayList<String>(Arrays.asList(fqpn)));
	}

	@Override
	public TSBaseAPI remove(TSString fqpn) {
		return this.remove(fqpn.toString());
	}

	@Override
	public int size() {
		if(this.isInitialised())
			return this.tsvalue.size();
		return 0;
	}

	@Override
	public String toString(){
		return this.tsToString(0);
	}

	//TODO
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
	public Collection<TSBaseAPI> values() {
		if(this.isInitialised())
			return this.tsvalue.values();
		return null;
	}

	@Override
	public Map<String, TSBaseAPI> tsGetTree() {
		if(this.isInitialised())
			return this.tsvalue;
		return new LinkedHashMap<String, TSBaseAPI>();
	}

	@Override
	public TSLinkedHashTree tsCopyComposite(){
		TSLinkedHashTree ret=new TSLinkedHashTree();

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
