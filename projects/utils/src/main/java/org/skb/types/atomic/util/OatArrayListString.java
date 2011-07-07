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

package org.skb.types.atomic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatString;
import org.skb.types.base.OatBaseArrayList;
import org.skb.types.base.OatBaseAtomic;

/**
 * An Array list of Oat Strings.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatArrayListString extends OatBaseAtomic implements List<OatString>, Collection<OatString> {
	protected ArrayList<OatString> oatValue=null;

	public OatArrayListString(){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
	}

	public OatArrayListString(ArrayList<String> a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
		for(int i=0;i<a.size();i++)
			this.oatValue.add(new OatString(a.get(i)));
	}

	public OatArrayListString(OatArrayListString a){
		super();
		this.init();
		if(a!=null)
			this.oatValue=new ArrayList<OatString>(a.getValue());
		else
			this.oatValue=new ArrayList<OatString>();
	}

	public OatArrayListString(int initialCapacity){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>(initialCapacity);
	}

	public OatArrayListString(List<OatString>a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>(a);
	}

	public OatArrayListString(String[] a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
		for(int i=0;i<a.length;i++)
			this.oatValue.add(new OatString(a[i]));
	}

	public OatArrayListString(OatBaseAtomic oba) {
		super();
		this.init();
		if(oba!=null){
			switch(oba.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					this.oatValue=new ArrayList<OatString>(((OatArrayListString)oba).getValue());
					break;
				default:
					this.oatValue=new ArrayList<OatString>();
			}
		}
		else
			this.oatValue=new ArrayList<OatString>();
	}

	public OatArrayListString(OatBaseArrayList a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
		for(int i=0;i<a.size();i++)
			this.oatValue.add(new OatString(a.get(i).toString()));
	}

	public OatArrayListString(String s){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
		this.oatValue.add(new OatString(s));
	}

	public OatArrayListString(OatString s){
		super();
		this.init();
		this.oatValue=new ArrayList<OatString>();
		this.oatValue.add(s);
	}

	public List<OatString> getValue(){
		return this.oatValue;
	}

	protected void init(){
		this.typeString.add(TypeRepository.OAT_ARRAYLIST_STRING);
		this.typeEnum.add(ATType.OAT_ARRAYLIST_STRING);
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, OatString element) {
		if(this.oatValue!=null)
			this.oatValue.add(index, element);
	}

	public void add(int index, String element) {
		if(this.oatValue!=null)
			this.oatValue.add(index, new OatString(element));
	}

	/**
	 * @param e
	 * @return boolean
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(OatString e) {
		if(this.oatValue!=null)
			return this.oatValue.add(e);
		return false;
	}

	public void add(String element) {
		if(this.oatValue!=null)
			this.oatValue.add(new OatString(element));
	}

	/**
	 * @param c
	 * @return boolean
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends OatString> c) {
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
	public boolean addAll(int index, Collection<? extends OatString> c) {
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
		return this.contains(o.toString());
	}

	public boolean contains(String s) {
		if(this.oatValue!=null){
			for(int i=0;i<this.oatValue.size();i++)
				try {
					if(s.equals(this.oatValue.get(i).getValue()))
						return true;
				} catch (OatValueIsNullException e) {}
		}
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
	 * @return OatString
	 * @see java.util.List#get(int)
	 */
	public OatString get(int index) {
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
	public Iterator<OatString> iterator() {
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
	public ListIterator<OatString> listIterator() {
		if(this.oatValue!=null)
			return oatValue.listIterator();
		return null;
	}

	/**
	 * @param index
	 * @return ListIterator
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<OatString> listIterator(int index) {
		if(this.oatValue!=null)
			return oatValue.listIterator(index);
		return null;
	}

	/**
	 * @param index
	 * @return OatString
	 * @see java.util.List#remove(int)
	 */
	public OatString remove(int index) {
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
			return this.remove(o.toString());
		return false;
	}


	public boolean remove(OatString s) {
		if(this.oatValue!=null)
			return this.remove(s.toString());
		return false;
	}

	public boolean remove(String s) {
		if(this.oatValue!=null){
			for(int i=0;i<this.oatValue.size();i++)
				try {
					if(s.equals(this.oatValue.get(i).getValue())){
						this.oatValue.remove(i);
						break;
					}
				} catch (OatValueIsNullException e) {}
		}
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
	 * @return OatString
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public OatString set(int index, OatString element) {
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
	public List<OatString> subList(int fromIndex, int toIndex) {
		if(this.oatValue!=null)
			return oatValue.subList(fromIndex, toIndex);
		return null;
	}

	/**
	 * @return Object[]
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		if(this.oatValue!=null)
			return oatValue.toArray();
		return null;
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
		for (OatString s : this.oatValue){
			try {
				s.oatValue.trim();
			} catch (Exception e) {}
		}
	}

	public void h2l(){
		for (OatString s : this.oatValue){
			try {
				s.h2l();
			} catch (Exception e) {}
		}
	}

	public void clean(){
		ArrayList<String> listRemove=new ArrayList<String>();
		for (OatString s : this.oatValue){
			try {
				if(s.oatValue.length()==0)
					listRemove.add(s.getValue());
			} catch (OatValueIsNullException e) {
				//listRemove.add(s.getValue());
			}
		}
		for(int i=0;i<listRemove.size();i++)
			this.oatValue.remove(listRemove.get(i));
	}

	public String toString(){
		String ret=new String();
		for (OatString s : this.oatValue){
			if(ret.length()!=0)
				ret+=", ";
			ret+=s.toString();
		}
		return ret;
	}

	public OatArrayListString getValOatArrayListString(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
