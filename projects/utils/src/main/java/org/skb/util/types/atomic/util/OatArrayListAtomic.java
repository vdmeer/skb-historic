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

package org.skb.util.types.atomic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.atomic.util.OatArrayListAtomic;
import org.skb.util.types.atomic.util.OatArrayListString;
import org.skb.util.types.base.OatBaseArrayList;
import org.skb.util.types.base.OatBaseAtomic;

/**
 * An Array list of OatAtomic types.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatArrayListAtomic extends OatBaseAtomic implements List<OatBaseAtomic>, Collection<OatBaseAtomic> {
	protected List<OatBaseAtomic> oatValue=null;

	public OatArrayListAtomic(){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBaseAtomic>();
	}

	public OatArrayListAtomic(OatArrayListAtomic a){
		super();
		this.init();
		if(a!=null)
			this.oatValue=new ArrayList<OatBaseAtomic>(a.getValue());
		else
			this.oatValue=new ArrayList<OatBaseAtomic>();
	}

	public OatArrayListAtomic(int initialCapacity){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBaseAtomic>(initialCapacity);
	}

	public OatArrayListAtomic(List<OatBaseAtomic>a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBaseAtomic>(a);
	}

	public OatArrayListAtomic(OatBaseAtomic oba) {
		super();
		this.init();
		if(oba!=null){
			switch(oba.getTypeEnum()){
				case OAT_ARRAYLIST_ATOMIC:
					this.oatValue=new ArrayList<OatBaseAtomic>(((OatArrayListAtomic)oba).getValue());
					break;
				default:
					this.oatValue=new ArrayList<OatBaseAtomic>();
			}
		}
		else
			this.oatValue=new ArrayList<OatBaseAtomic>();
	}

	public OatArrayListAtomic(OatBaseArrayList a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBaseAtomic>();
		if(a.isAtomicList()){
			for(int i=0;i<a.size();i++)
				this.oatValue.add((OatBaseAtomic)a.get(i));
		}
	}

	public List<OatBaseAtomic> getValue(){
		return this.oatValue;
	}

	protected void init(){
		this.typeString.add(TypeRepository.OAT_ARRAYLIST_ATOMIC);
		this.typeEnum.add(ATType.OAT_ARRAYLIST_ATOMIC);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, OatBaseAtomic element) {
		if(this.oatValue!=null)
			this.oatValue.add(index, element);
	}

	/**
	 * @param e
	 * @return boolean
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(OatBaseAtomic e) {
		if(this.oatValue!=null)
			return this.oatValue.add(e);
		return false;
	}

	/**
	 * @param c
	 * @return boolean
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends OatBaseAtomic> c) {
		if(this.oatValue!=null)
			return this.oatValue.addAll(c);
		return false;
	}

	/**
	 * @param index
	 * @param c
	 * @return boolean
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends OatBaseAtomic> c) {
		if(this.oatValue!=null)
			return oatValue.addAll(index, c);
		return false;
	}

	/**
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		if(this.oatValue!=null)
			this.oatValue.clear();
	}

	/**
	 * @param o
	 * @return boolean
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		if(this.oatValue!=null)
			return oatValue.contains(o);
		return false;
	}

	/**
	 * @param c
	 * @return boolean
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		if(this.oatValue!=null)
			return oatValue.containsAll(c);
		return false;
	}

	/**
	 * @param index
	 * @return OatBaseAtomic
	 * @see java.util.List#get(int)
	 */
	public OatBaseAtomic get(int index) {
		if(this.oatValue!=null)
			return oatValue.get(index);
		return null;
	}

	/**
	 * @param o
	 * @return int
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		if(this.oatValue!=null)
			return oatValue.indexOf(o);
		return -1;
	}

	/**
	 * @return boolean
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		if(this.oatValue!=null)
			return oatValue.isEmpty();
		return true;
	}

	/**
	 * @return Iterator
	 * @see java.util.List#iterator()
	 */
	public Iterator<OatBaseAtomic> iterator() {
		if(this.oatValue!=null)
			return oatValue.iterator();
		return null;
	}

	/**
	 * @param o
	 * @return int
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		if(this.oatValue!=null)
			return oatValue.lastIndexOf(o);
		return -1;
	}

	/**
	 * @return ListIterator
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<OatBaseAtomic> listIterator() {
		if(this.oatValue!=null)
			return oatValue.listIterator();
		return null;
	}

	/**
	 * @param index
	 * @return ListIterator
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<OatBaseAtomic> listIterator(int index) {
		if(this.oatValue!=null)
			return oatValue.listIterator(index);
		return null;
	}

	/**
	 * @param index
	 * @return OatBaseAtomic
	 * @see java.util.List#remove(int)
	 */
	public OatBaseAtomic remove(int index) {
		if(this.oatValue!=null)
			return oatValue.remove(index);
		return null;
	}

	/**
	 * @param o
	 * @return boolean
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		if(this.oatValue!=null)
			return oatValue.remove(o);
		return false;
	}

	/**
	 * @param c
	 * @return boolean
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		if(this.oatValue!=null)
			return oatValue.removeAll(c);
		return false;
	}

	/**
	 * @param c 
	 * @return boolean
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		if(this.oatValue!=null)
			return oatValue.retainAll(c);
		return false;
	}

	/**
	 * @param index
	 * @param element
	 * @return OatBaseAtomic
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public OatBaseAtomic set(int index, OatBaseAtomic element) {
		if(this.oatValue!=null)
			return oatValue.set(index, element);
		return null;
	}

	/**
	 * @return int
	 * @see java.util.List#size()
	 */
	public int size() {
		if(this.oatValue!=null)
			return oatValue.size();
		return 0;
	}

	/**
	 * @param fromIndex
	 * @param toIndex
	 * @return List
	 * @see java.util.List#subList(int, int)
	 */
	public List<OatBaseAtomic> subList(int fromIndex, int toIndex) {
		if(this.oatValue!=null)
			return oatValue.subList(fromIndex, toIndex);
		return null;
	}

	/**
	 * @return Object
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		if(this.oatValue!=null)
			return oatValue.toArray();
		return null;
	}

	public ArrayList<String> toStringArray(){
		ArrayList<String> ret=new ArrayList<String>();
		for (OatBaseAtomic s : this.oatValue)
			ret.add(s.toString());
		return ret;
	}

	/**
	 * @param <T>
	 * @param a
	 * @return T
	 * @see java.util.List#toArray()
	 */
	public <T> T[] toArray(T[] a) {
		if(this.oatValue!=null)
			return oatValue.toArray(a);
		return null;
	}

	public void trim(){
		for (OatBaseAtomic s : this.oatValue) {
			switch(s.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)s).trim();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)s).trim();
					break;
				case OAT_ATOMIC_STRING:
					try {
						((OatString)s).oatValue.trim();
					} catch (Exception e) {}
					break;
				default:
					break;
			}
		}
	}

	public void h2l(){
		for (OatBaseAtomic s : this.oatValue) {
			switch(s.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)s).h2l();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)s).h2l();
					break;
				case OAT_ATOMIC_STRING:
					try {
						((OatString)s).h2l();
					} catch (Exception e) {}
					break;
				default:
					break;
			}
		}
	}

	public void clean(){
		ArrayList<String> listRemove=new ArrayList<String>();
		for (OatBaseAtomic s : this.oatValue) {
			switch(s.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)s).clean();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)s).clean();
					break;
				case OAT_ATOMIC_STRING:
					try {
						if(((OatString)s).oatValue.length()==0)
							listRemove.add(((OatString)s).getValue());
					} catch (OatValueIsNullException e) {}
					break;
				default:
					break;
			}
		}
		for(int i=0;i<listRemove.size();i++)
			this.oatValue.remove(listRemove.get(i));
	}

	/**
	 * Return the stringified representation of the local object
	 * @return String stringified representation of the local object if instantiated, "" otherwise
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		if(this.oatValue!=null)
			return this.oatValue.toString();
		return null;
	}

	public OatArrayListAtomic getValOatArrayListAtomic(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}