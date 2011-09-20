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
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSString;

/**
 * An Array list of TSString types implementing the interfaces {@link List} and {@link Collection}.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSArrayListString implements TSAtomicAPI, List<TSString>, Collection<TSString>{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSArrayListString.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** Local value */
	protected List<TSString> tsvalue=null;


	public TSArrayListString(){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
	}

	public TSArrayListString(ArrayList<String> a){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
		for(int i=0;i<a.size();i++)
			this.tsvalue.add(new TSString(a.get(i)));
	}

	public TSArrayListString(int initialCapacity){
		this._init();
		this.tsvalue=new ArrayList<TSString>(initialCapacity);
	}

//	public TSArrayListString(TSArrayListString a){
//		this._init();
//		if(a!=null)
//			this.tsvalue=new ArrayList<TSString>(a.getValue());
//		else
//			this.tsvalue=new ArrayList<TSString>();
//	}

	public TSArrayListString(List<TSString>a){
		this._init();
		this.tsvalue=new ArrayList<TSString>(a);
	}

	public TSArrayListString(String s){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
		this.tsvalue.add(new TSString(s));
	}

	public TSArrayListString(String[] a){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
		for(int i=0;i<a.length;i++)
			this.tsvalue.add(new TSString(a[i]));
	}

//	public TSArrayListString(OatBaseAtomic oba) {
//		this._init();
//		if(oba!=null){
//			switch(oba.getTypeEnum()){
//				case OAT_ARRAYLIST_STRING:
//					this.tsvalue=new ArrayList<TSString>(((TSArrayListString)oba).getValue());
//					break;
//				default:
//					this.tsvalue=new ArrayList<TSString>();
//			}
//		}
//		else
//			this.tsvalue=new ArrayList<TSString>();
//	}

	public TSArrayListString(TSArrayListString a){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
		for(int i=0;i<a.size();i++)
			this.tsvalue.add(new TSString(a.get(i).toString()));
	}

	public TSArrayListString(TSString s){
		this._init();
		this.tsvalue=new ArrayList<TSString>();
		this.tsvalue.add(s);
	}

	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_ARRAYLIST_STRING);
		this.typeEnum.add(TEnum.TS_ATOMIC_ARRAYLIST_STRING);
	}

	public void add(int index, String element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(index, new TSString(element));
	}

	@Override
	public void add(int index, TSString element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(index, element);
	}

	public void add(String element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(new TSString(element));
	}

	@Override
	public boolean add(TSString e) {
		if(this.tsvalue!=null)
			return this.tsvalue.add(e);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TSString> c) {
		if(this.tsvalue!=null)
			return this.tsvalue.addAll(c);
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TSString> c) {
		if(this.tsvalue!=null)
			return tsvalue.addAll(index, c);
		return false;
	}

	@Override
	public void clear() {
		if(this.tsvalue!=null)
			this.tsvalue.clear();
	}

	@Override
	public boolean contains(Object o) {
		if(o!=null)
			return this.contains(o.toString());
		else
			return false;
	}

	public boolean contains(String s) {
		if(this.tsvalue!=null){
			for(int i=0;i<this.tsvalue.size();i++)
				if(s.equals(this.tsvalue.get(i).tsvalue))
					return true;
		}
		return false;
	}

	public boolean contains(TSString s){
		if(s!=null)
			return this.contains(s.toString());
		else
			return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(this.tsvalue!=null)
			return tsvalue.containsAll(c);
		return false;
	}

	@Override
	public TSString get(int index) {
		if(this.tsvalue!=null)
			return tsvalue.get(index);
		return null;
	}

	@Override
	public int indexOf(Object o) {
		if(this.tsvalue!=null)
			return tsvalue.indexOf(o);
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if(this.tsvalue!=null)
			return tsvalue.isEmpty();
		return true;
	}

	@Override
	public Iterator<TSString> iterator() {
		if(this.tsvalue!=null)
			return tsvalue.iterator();
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		if(this.tsvalue!=null)
			return tsvalue.lastIndexOf(o);
		return -1;
	}

	@Override
	public ListIterator<TSString> listIterator() {
		if(this.tsvalue!=null)
			return tsvalue.listIterator();
		return null;
	}

	@Override
	public ListIterator<TSString> listIterator(int index) {
		if(this.tsvalue!=null)
			return tsvalue.listIterator(index);
		return null;
	}

	@Override
	public TSString remove(int index) {
		if(this.tsvalue!=null)
			return tsvalue.remove(index);
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if(this.tsvalue!=null)
			return this.remove(o.toString());
		return false;
	}

	public boolean remove(String s) {
		if(this.tsvalue!=null){
			for(int i=0;i<this.tsvalue.size();i++)
				if(s.equals(this.tsvalue.get(i).tsvalue))
					return this.tsvalue.remove(this.tsvalue.get(i));
		}
		return false;
	}

	public boolean remove(TSString s) {
		if(this.tsvalue!=null)
			return this.remove(s.toString());
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(this.tsvalue!=null)
			return tsvalue.removeAll(c);
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if(this.tsvalue!=null)
			return tsvalue.retainAll(c);
		return false;
	}

	@Override
	public TSString set(int index, TSString element) {
		if(this.tsvalue!=null)
			return tsvalue.set(index, element);
		return null;
	}

	@Override
	public int size() {
		if(this.tsvalue!=null)
			return tsvalue.size();
		return 0;
	}

	@Override
	public List<TSString> subList(int fromIndex, int toIndex) {
		if(this.tsvalue!=null)
			return tsvalue.subList(fromIndex, toIndex);
		return null;
	}

	@Override
	public Object[] toArray() {
		if(this.tsvalue!=null)
			return tsvalue.toArray();
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(this.tsvalue!=null)
			return tsvalue.toArray(a);
		return null;
	}

	public String toString(){
		String ret=new String();
		for (TSString s : this.tsvalue){
			if(ret.length()!=0)
				ret+=", ";
			ret+=s.toString();
		}
		return ret;
	}

	@Override
	public void tsClean() {
		ArrayList<String> listRemove=new ArrayList<String>();
		for (TSString s : this.tsvalue){
			if(s.tsvalue.length()==0)
				listRemove.add(s.tsvalue);
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
		return true;
	}

	@Override
	public boolean tsIsComposite() {
		return false;
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
		//TODO
		logger.warn("tsPlus not implemented");
	}

	@Override
	public String tsToString(int indent) {
		//TODO
		logger.warn("tsToString not implemented");
		return null;
	}

	@Override
	public void tsTrim() {
		for (TSString s : this.tsvalue)
			s.tsvalue.trim();
	}

//	public void h2l(){
//		for (TSString s : this.tsvalue){
//			try {
//				s.h2l();
//			} catch (Exception e) {}
//		}
//	}


	@Override
	public TSArrayListString tsCopyAtomic(){
		TSArrayListString ret=new TSArrayListString();
		ret.tsvalue=new ArrayList<TSString>(this.tsvalue.size());
		for(int i=0;i<this.tsvalue.size();i++){
			ret.tsvalue.add(this.tsvalue.get(i).tsCopyAtomic());
		}
		return ret;
	}
}
