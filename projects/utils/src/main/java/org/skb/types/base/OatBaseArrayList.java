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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.skb.types.base.OatBase;
import org.skb.types.base.OatBaseArrayList;
import org.skb.types.base.OatBaseMap;
import org.skb.types.composite.util.OatMapLH;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListAtomic;
import org.skb.types.atomic.util.OatArrayListString;

/**
 * An Array list of OatBase types.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatBaseArrayList extends OatBase implements List<OatBase>, Collection<OatBase>{
	protected List<OatBase> oatValue=null;

	private Boolean isStringList;
	private Boolean isAtomicList;
	private Boolean isMapLH;

	public OatBaseArrayList(){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBase>();
	}

	public OatBaseArrayList(OatBaseArrayList a){
		super();
		this.init();
		if(a!=null)
			this.oatValue=new ArrayList<OatBase>(a.getValue());
		else
			this.oatValue=new ArrayList<OatBase>();
	}

	public OatBaseArrayList(int initialCapacity){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBase>(initialCapacity);
	}

	public OatBaseArrayList(List<OatBase>a){
		super();
		this.init();
		this.oatValue=new ArrayList<OatBase>(a);
	}

	public OatBaseArrayList(OatBase oba) {
		super();
		this.init();
		if(oba!=null){
			switch(oba.getTypeEnum()){
				case OAT_ARRAYLIST:
					this.oatValue=new ArrayList<OatBase>(((OatBaseArrayList)oba).getValue());
					break;
				default:
					this.oatValue=new ArrayList<OatBase>();
			}
		}
		else
			this.oatValue=new ArrayList<OatBase>();
	}

	public List<OatBase> getValue(){
		return this.oatValue;
	}

	protected void init(){
		this.typeString.add(TypeRepository.OAT_ARRAYLIST);
		this.typeEnum.add(ATType.OAT_ARRAYLIST);

		this.isStringList=true;
		this.isAtomicList=true;
		this.isMapLH=true;
	}

	/**
	 * @param index
	 * @param element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, OatBase element) {
		if(this.oatValue!=null)
			this.oatValue.add(index, element);
		if(element.isAtomic()!=true)
			this.isAtomicList=false;
		if(element.getTypeEnum()!=ATType.OAT_ATOMIC_STRING)
			this.isStringList=false;
		if(element.getTypeEnum()!=ATType.OAT_COMPOSITE_MAP_LH)
			this.isMapLH=false;
	}

	/**
	 * @param e
	 * @return boolean
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(OatBase e) {
		if(this.oatValue!=null){
			if(e.isAtomic()!=true)
				this.isAtomicList=false;
			if(e.getTypeEnum()!=ATType.OAT_ATOMIC_STRING)
				this.isStringList=false;
			if(e.getTypeEnum()!=ATType.OAT_COMPOSITE_MAP_LH)
				this.isMapLH=false;
			return this.oatValue.add(e);
		}
		return false;
	}

	/**
	 * @param c
	 * @return boolean
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends OatBase> c) {
		boolean ret=false;
		if(this.oatValue!=null){
			ret=this.oatValue.addAll(c);
			if(ret==true){
				for(int i=0;i<this.oatValue.size();i++){
					if(this.oatValue.get(i).isAtomic()!=true)
						this.isAtomicList=false;
					if(this.oatValue.get(i).getTypeEnum()!=ATType.OAT_ATOMIC_STRING)
						this.isStringList=false;
					if(this.oatValue.get(i).getTypeEnum()!=ATType.OAT_COMPOSITE_MAP_LH)
						this.isMapLH=false;
				}
			}
		}
		return ret;
	}

	/**
	 * @param index
	 * @param c
	 * @return boolean
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends OatBase> c) {
		boolean ret=false;
		if(this.oatValue!=null){
			ret=oatValue.addAll(index, c);
			if(ret==true){
				for(int i=0;i<this.oatValue.size();i++){
					if(this.oatValue.get(i).isAtomic()!=true)
						this.isAtomicList=false;
					if(this.oatValue.get(i).getTypeEnum()!=ATType.OAT_ATOMIC_STRING)
						this.isStringList=false;
					if(this.oatValue.get(i).getTypeEnum()!=ATType.OAT_COMPOSITE_MAP_LH)
						this.isMapLH=false;
				}
			}
		}
		return ret;
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
	 * @return OatBase
	 * @see java.util.List#get(int)
	 */
	public OatBase get(int index) {
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
	public Iterator<OatBase> iterator() {
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
	public ListIterator<OatBase> listIterator() {
		if(this.oatValue!=null)
			return oatValue.listIterator();
		return null;
	}

	/**
	 * @param index
	 * @return ListIterator
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<OatBase> listIterator(int index) {
		if(this.oatValue!=null)
			return oatValue.listIterator(index);
		return null;
	}

	/**
	 * @param index
	 * @return OatBase
	 * @see java.util.List#remove(int)
	 */
	public OatBase remove(int index) {
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
	 * @return OatBase
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public OatBase set(int index, OatBase element) {
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
	public List<OatBase> subList(int fromIndex, int toIndex) {
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
		for (OatBase s : this.oatValue)
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
		for (OatBase s : this.oatValue) {
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
		for (OatBase s : this.oatValue) {
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
		for (OatBase s : this.oatValue) {
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
		return this.toString(0);
	}

	public String toString(int indent){
		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();

		for(int i=0;i<this.oatValue.size();i++){
			switch(this.oatValue.get(i).getTypeEnum()){
				case OAT_BASE_COMPOSITE_MAP:
				case OAT_COMPOSITE_MAP_LH:
					ret+=indentation+"["+i+"::Map] => \n"+indentation+"    (\n"+((OatBaseMap)this.oatValue.get(i)).toString(indent+4)+indentation+indentation+")\n";
					break;
				case OAT_ARRAYLIST:
					ret+=indentation+"["+i+"::Map] => \n"+indentation+"    (\n"+((OatBaseArrayList)this.oatValue.get(i)).toString(indent+4)+indentation+indentation+")\n";
					break;
//				case OAT_LIST_COMPOSITE:
//					ret+=indentation+"["+i+"::List] => "+this.field.get(key)+"\n";
//					break;
				case OAT_ARRAYLIST_ATOMIC:
					ret+=indentation+"["+i+"::List<Atomic>] => "+this.oatValue.get(i)+"\n";
					break;
				case OAT_ARRAYLIST_STRING:
					ret+=indentation+"["+i+"::List<String>] => "+this.oatValue.get(i)+"\n";
					break;
				default:
					ret+=indentation+"["+i+"] => "+this.oatValue.get(i)+"\n";
					break;
			}
		}
		return ret;
	}


	@Override
	public boolean isAtomic() {
		return false;
	}

	@Override
	public boolean isComposite() {
		return true;
	}

	public boolean isAtomicList(){
		return this.isAtomicList;
	}

	public boolean isStringList(){
		return this.isStringList;
	}

	public boolean isMapLH(){
		return this.isMapLH;
	}

	public OatArrayListString toStringList(){
		OatArrayListString ret=null;
		if(this.isStringList==true)
			ret=new OatArrayListString(this);
		return ret;
	}

	public OatArrayListAtomic toAtomicList(){
		OatArrayListAtomic ret=null;
		if(this.isStringList==true)
			ret=new OatArrayListAtomic(this);
		return ret;
	}

	public OatMapLH toMapLH(){
		OatMapLH ret=null;
		if(this.isStringList==true)
			ret=new OatMapLH(this);
		return ret;
	}

	public OatBaseArrayList getValOatArrayList(){
		return this;
	}
}
