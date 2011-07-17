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

package org.skb.util.types.composite.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.base.OatBaseAtomic;
import org.skb.util.types.base.OatBaseComposite;
import org.skb.util.types.composite.util.OatTableRow;

/**
 * Implementation of a Table row with predefined columns.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatTableRow extends OatBaseComposite implements Map<String, OatBaseAtomic> {
	protected Map<String, OatBaseAtomic> oatValue=null;

	public OatTableRow(Map<String, OatBaseAtomic> map){
		super();
		this.init();
		this.oatValue=map;
	}

	protected void init(){
		this.typeString.add(TypeRepository.OAT_COMPOSITE_TABLE_ROW);
		this.typeEnum.add(ATType.OAT_COMPOSITE_TABLE_ROW);
	}

	/**
	 * 
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		if(this.oatValue!=null)
			this.oatValue.clear();
	}

	/**
	 * @param arg0
	 * @return boolean
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object arg0) {
		if(this.oatValue!=null)
			return this.oatValue.containsKey(arg0);
		return false;
	}

	final public boolean containsKey(String key){
		if(this.oatValue!=null)
			return this.oatValue.containsKey(key);
		return false;
	}

	final public boolean containsKey(OatString key){
		if(key!=null)
			return this.containsKey(key.toString());
		return false;
	}

	/**
	 * @param arg0
	 * @return boolean
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object arg0) {
		if(this.oatValue!=null)
			return this.oatValue.containsValue(arg0);
		return false;
	}

	/**
	 * @return Set
	 * @see java.util.Map#entrySet()
	 */
	public Set<java.util.Map.Entry<String, OatBaseAtomic>> entrySet() {
		if(this.oatValue!=null)
			return this.oatValue.entrySet();
		return null;
	}

	/**
	 * @param arg0
	 * @return OatBaseAtomic
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public OatBaseAtomic get(Object arg0) {
		if(this.oatValue!=null)
			return this.oatValue.get(arg0);
		return null;
	}

	final public OatBaseAtomic get(OatString key){
		if(key!=null)
			return this.get(key.toString());
		return null;
	}

	final public OatBaseAtomic get(String key){
		if(this.oatValue!=null)
			return this.oatValue.get(key);
		return null;
	}

	/**
	 * @return boolean
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		if(this.oatValue!=null)
			return this.oatValue.isEmpty();
		return true;
	}

	/**
	 * @return Set
	 * @see java.util.Map#keySet()
	 */
	public Set<String> keySet() {
		if(this.oatValue!=null)
			return this.oatValue.keySet();
		return null;
	}

	/**
	 * @param key
	 * @param val
	 * @return OatBaseAtomic
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public OatBaseAtomic put(String key, OatBaseAtomic val) {
		if(this.oatValue!=null&&this.oatValue.containsKey(key))
			return this.oatValue.put(key, val);
		return null;
	}

	final public OatBaseAtomic put(OatString key, OatBaseAtomic val){
		if(this.oatValue==null||key==null||val==null)
			return null;

		String iKey;
		try {
			iKey=key.getValue();
		} catch (OatValueIsNullException e) {
			return null;
		}

		if(this.oatValue.containsKey(iKey))
			return this.oatValue.put(iKey, val);
		return null;
	}

	/**
	 * @param arg0
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map<? extends String, ? extends OatBaseAtomic> arg0) {
		;//this.field.putAll(arg0);
	}

	/**
	 * @param arg0
	 * @return OatBaseAtomic
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public OatBaseAtomic remove(Object arg0) {
		//return field.remove(arg0);
		return null;
	}

	/**
	 * @return int
	 * @see java.util.Map#size()
	 */
	public int size() {
		if(this.oatValue!=null)
			return oatValue.size();
		return 0;
	}

	/**
	 * @return Collection
	 * @see java.util.Map#values()
	 */
	public Collection<OatBaseAtomic> values() {
		if(this.oatValue!=null)
			return this.oatValue.values();
		return null;
	}

	final public String toString(){return this.toString(0);}

	final public String toString(int indent){
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
			OatBaseAtomic ata=this.oatValue.get(key);
			if(ata==null)
				ret+=indentation+"["+key+"] => "+ata+"\n";
			else{
				switch(this.oatValue.get(key).getTypeEnum()){
//					case OAT_BASE_COMPOSITE:
//						ret+=indentation+"["+key+"] => List "+this.field.get(key).toString()+"\n";
//						break;
					default:
						ret+=indentation+"["+key+"] => "+this.oatValue.get(key).toString()+"\n";
						break;
				}
			}
		}
		return ret;
	}

	public OatTableRow getValOatTableRow(){
		return this;
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}
