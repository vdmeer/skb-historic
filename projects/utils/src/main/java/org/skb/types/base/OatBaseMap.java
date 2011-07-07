/* Copyright (c) 2010-2011 Sven van der Meer
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

package org.skb.types.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.skb.types.base.OatBase;
import org.skb.types.base.OatBaseComposite;
import org.skb.types.base.OatBaseMap;
import org.apache.commons.lang.StringUtils;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListAtomic;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.atomic.util.OatScope;

/**
 * The composite class for maps.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatBaseMap extends OatBaseComposite implements Map<String, OatBase>{
	protected Map<String, OatBase> oatValue=null;
	protected OatScope scope;

	protected void init(){
		//super();
		this.typeString.add(TypeRepository.OAT_BASE_COMPOSITE_MAP);
		this.typeEnum.add(ATType.OAT_BASE_COMPOSITE_MAP);
	}

	@Override
	public void clear() {
		if(this.oatValue!=null)
			this.oatValue.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		if(this.isInitialised())
			return this.oatValue.containsKey(key);
		return false;
	}

	public boolean containsKey(String key) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.containsKey(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.oatValue.containsKey(key);
		}
		return false;
	}

	public boolean containsKey(OatString key){
		if(key!=null)
			return this.containsKey(key.toString());
		return false;
	}

	public boolean containsKey(List<String> list){
		if(!this.isInitialised()||list==null||list.size()==0)
			return false;
		else if(list.size()==1)
			return this.oatValue.containsKey(list.get(0));
		else if(this.oatValue.containsKey(list.get(0))){
			OatBase ct=this.oatValue.get(list.get(0));
			if(ct.isType(TypeRepository.OAT_BASE_COMPOSITE_MAP)){
				list.remove(0);
				return ((OatBaseMap)ct).containsKey(list);
			}
		}
		return false;
	}

	public boolean containsKey(String[] list){
		return this.containsKey(new ArrayList<String>(Arrays.asList(list)));
	}

//	public boolean containsKey(OatBaseCompositeList list){
//		return this.containsKey(list.getMemberAsObject());
//	}

	@Override
	public boolean containsValue(Object value) {
		if(this.isInitialised())
			return this.oatValue.containsValue(value);
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, OatBase>> entrySet() {
		if(this.isInitialised())
			return this.oatValue.entrySet();
		return null;
	}

	@Override
	public OatBase get(Object key) {
		if(this.isInitialised())
			return this.oatValue.get(key);
		return null;
	}

	public OatBase get(OatString key){
		return this.get(key.toString());
	}

//	public OatBase get(OatBaseCompositeList list){
//		return this.get(list.getMemberAsObject());
//	}

	public OatBase get(List<String> list){
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.oatValue.get(list.get(0).toString());
		else if(this.oatValue.containsKey(list.get(0).toString())){
			OatBase ct=this.oatValue.get(list.get(0).toString());
			if(ct.isType(TypeRepository.OAT_COMPOSITE_MAP_LH)){
				list.remove(0);
				return ((OatBaseMap)ct).get(list);
			}
		}
		return null;
	}

	public OatBase get(String key){
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.get(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.oatValue.get(key);
		}
		return null;
	}

	public OatBase get(String[] list){
		return this.get(new ArrayList<String>(Arrays.asList(list)));
	}


	@Override
	public boolean isEmpty() {
		if(this.isInitialised())
			return this.oatValue.isEmpty();
		return false;
	}

	@Override
	public Set<String> keySet() {
		if(this.isInitialised())
			return this.oatValue.keySet();
		return null;
	}

	public void merge(OatBaseMap arg0){
		this.putAll(arg0);
	}

	@Override
	public OatBase put(String key, OatBase val) {
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), val);
			else
				return this.oatValue.put(key, val);
		}
		return null;
	}

	public OatBase put(List<String> list, OatBase val){
		return null;
	}
//	public OatBase put(List<String> list, OatBase val){
//		if(!this.isInitialised()||list==null||list.size()==0)
//			return null;
//		else if(list.size()==1)
//			return this.oatValue.put(list.get(0).toString(), val);
//		else{
//			String key=list.get(0);
//			if(!this.oatValue.containsKey(key))
//				this.oatValue.put(key, new OatBaseMap());
//			list.remove(0);
//			return ((OatBaseMap)this.oatValue.get(key)).put(list, val);
//		}
//	}

	public OatBase put(ArrayList<String> list, String val){
		return this.put(list, new OatString(val));
	}

	public OatBase put(OatString key, OatBase val){
		return this.put(key.toString(), val);
	}

	public OatBase put(String key, String val){
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.put(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))), val);
			else
				return this.oatValue.put(key, new OatString(val));
		}
		return null;
	}

	public OatBase put(String[] list, OatBase val){
		return this.put(new ArrayList<String>(Arrays.asList(list)), val);
	}

	public OatBase put(String[] list, String val){
		return this.put(new ArrayList<String>(Arrays.asList(list)), new OatString(val));
	}

	@Override
	public void putAll(Map<? extends String, ? extends OatBase> m) {
		if(this.isInitialised())
			this.oatValue.putAll(m);
	}

	public void putAll(OatBaseMap m) {
		if(this.isInitialised()&&m!=null)
			this.oatValue.putAll(m.oatValue);
	}


	@Override
	public OatBase remove(Object key) {
		if(this.isInitialised())
			return this.oatValue.remove(key);
		return null;
	}

	public OatBase remove(String key){
		if(this.isInitialised()){
			if(StringUtils.contains(key, '/'))
				return this.remove(new ArrayList<String>(Arrays.asList(StringUtils.split(key, '/'))));
			else
				return this.oatValue.remove(key);
		}
		return null;
	}

	public OatBase remove(String[] list){
		return this.remove(new ArrayList<String>(Arrays.asList(list)));
	}

	public OatBase remove(List<String> list){
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.oatValue.remove(list.get(0).toString());
		else if(this.oatValue.containsKey(list.get(0).toString())){
			OatBase ct=this.oatValue.get(list.get(0).toString());
			if(ct.isType(ATType.OAT_BASE_COMPOSITE_MAP)){
				list.remove(0);
				return ((OatBaseMap)ct).remove(list);
			}
		}
		return null;
	}

	public OatBase remove(OatString key){
		return this.remove(key.toString());
	}

	@Override
	public int size() {
		if(this.isInitialised())
			return this.oatValue.size();
		return 0;
	}

	@Override
	public Collection<OatBase> values() {
		if(this.isInitialised())
			return this.oatValue.values();
		return null;
	}

	public boolean isInitialised(){
		if(this.oatValue!=null)
			return true;
		return false;
	}

	public String toString(){
		return this.toString(0);
	}

	public String toString(int indent){
		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();
		String key;

		Set<String> o_set = this.oatValue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			if(this.oatValue.get(key)==null)
				continue;
			switch(this.oatValue.get(key).getTypeEnum()){
				case OAT_BASE_COMPOSITE_MAP:
				case OAT_COMPOSITE_MAP_LH:
					ret+=indentation+"["+key+"::Map] => \n"+indentation+"    (\n"+((OatBaseMap)this.oatValue.get(key)).toString(indent+4)+indentation+indentation+")\n";
					break;
//				case OAT_LIST_COMPOSITE:
//					ret+=indentation+"["+key+"::List] => "+this.field.get(key)+"\n";
//					break;
				case OAT_ARRAYLIST_ATOMIC:
					ret+=indentation+"["+key+"::List<Atomic>] => "+this.oatValue.get(key)+"\n";
					break;
				case OAT_ARRAYLIST_STRING:
					ret+=indentation+"["+key+"::List<String>] => "+this.oatValue.get(key)+"\n";
					break;
				default:
					ret+=indentation+"["+key+"] => "+this.oatValue.get(key)+"\n";
					break;
			}
		}
		return ret;
	}

	public void clean(){
		ArrayList<String> listRemove=new ArrayList<String>();
		String key;
		Set<String> o_set = this.oatValue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			if(this.oatValue.get(key)==null){
				listRemove.add(key);
				continue;
			}
			switch(this.oatValue.get(key).getTypeEnum()){
				case OAT_BASE_COMPOSITE_MAP:
				case OAT_COMPOSITE_MAP_LH:
					((OatBaseMap)this.oatValue.get(key)).clean();
					break;
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)this.oatValue.get(key)).clean();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)this.oatValue.get(key)).clean();
					break;
				case OAT_ATOMIC_STRING:
					try{
						if(this.oatValue.get(key).toString().length()==0)
							listRemove.add(key);
					} catch (Exception e){
						listRemove.add(key);
					}
					break;
				default:
					break;
			}
		}
		for(int i=0;i<listRemove.size();i++)
			this.oatValue.remove(listRemove.get(i));
	}

	public void trim(){
		String key;
		Set<String> o_set = this.oatValue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			if(this.oatValue.get(key)==null)
				continue;
			switch(this.oatValue.get(key).getTypeEnum()){
   			  case OAT_BASE_COMPOSITE_MAP:
			  case OAT_COMPOSITE_MAP_LH:
					((OatBaseMap)this.oatValue.get(key)).trim();
					break;
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)this.oatValue.get(key)).trim();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)this.oatValue.get(key)).trim();
					break;
				case OAT_ATOMIC_STRING:
					try{
						String _t=((OatString)this.oatValue.get(key)).oatValue.trim();
						this.oatValue.put(key, new OatString(_t));
					} catch (Exception e){}
					break;
				default:
					break;
			}
		}
	}


	public void h2l(){
		String key;
		Set<String> o_set = this.oatValue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			if(this.oatValue.get(key)==null)
				continue;
			switch(this.oatValue.get(key).getTypeEnum()){
   			  case OAT_BASE_COMPOSITE_MAP:
			  case OAT_COMPOSITE_MAP_LH:
					((OatBaseMap)this.oatValue.get(key)).h2l();
					break;
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)this.oatValue.get(key)).h2l();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)this.oatValue.get(key)).h2l();
					break;
				case OAT_ATOMIC_STRING:
					try{
						String _t=((OatString)this.oatValue.get(key)).h2l();
						this.oatValue.put(key, new OatString(_t));
					} catch (Exception e){}
					break;
				default:
					break;
			}
		}
	}

	public OatBaseMap getValOatBaseCompositeMap(){
		return this;
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}
