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

package org.skb.util.patterns.structural.composite.atomic.util;

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
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSNull;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;

/**
 * An Array list of TSAtomic types, implementing the interfaces {@link List} and {@link Collection}.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSArrayListAtomic implements TSAtomicAPI, List<TSAtomicAPI>, Collection<TSAtomicAPI>{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSArrayListAtomic.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** Local value */
	protected List<TSAtomicAPI> tsvalue=null;


	public TSArrayListAtomic(){
		this._init();
		this.tsvalue=new ArrayList<TSAtomicAPI>();
	}

	public TSArrayListAtomic(int initialCapacity){
		this._init();
		this.tsvalue=new ArrayList<TSAtomicAPI>(initialCapacity);
	}

//	public TSArrayListStringAtomic(TSArrayListStringAtomic a){
//		this._init();
//		if(a!=null)
//			this.tsvalue=new ArrayList<TSAtomic>(a.getValue());
//		else
//			this.tsvalue=new ArrayList<TSAtomic>();
//	}

	public TSArrayListAtomic(List<TSAtomicAPI>a){
		this._init();
		this.tsvalue=new ArrayList<TSAtomicAPI>(a);
	}

	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_ARRAYLIST_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC_ARRAYLIST_ATOMIC);
	}

//	public TSArrayListStringAtomic(TSAtomic oba) {
//		this._init();
//		if(oba!=null){
//			switch(oba.getTypeEnum()){
//				case OAT_ARRAYLIST_ATOMIC:
//					this.tsvalue=new ArrayList<TSAtomic>(((TSArrayListStringAtomic)oba).getValue());
//					break;
//				default:
//					this.tsvalue=new ArrayList<TSAtomic>();
//			}
//		}
//		else
//			this.tsvalue=new ArrayList<TSAtomic>();
//	}

	@Override
	public void add(int index, TSAtomicAPI element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(index, element);
	}

	@Override
	public boolean add(TSAtomicAPI e) {
		if(this.tsvalue!=null)
			return this.tsvalue.add(e);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TSAtomicAPI> c) {
		if(this.tsvalue!=null)
			return this.tsvalue.addAll(c);
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TSAtomicAPI> c) {
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
		if(this.tsvalue!=null)
			return tsvalue.contains(o);
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(this.tsvalue!=null)
			return tsvalue.containsAll(c);
		return false;
	}

	@Override
	public TSAtomicAPI get(int index) {
		if(this.tsvalue!=null)
			return tsvalue.get(index);
		return null;

	}

	public void Html2LaTeX(){
/*
		for (OatBaseAtomic s : this.tsvalue) {
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
*/
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
	public Iterator<TSAtomicAPI> iterator() {
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
	public ListIterator<TSAtomicAPI> listIterator() {
		if(this.tsvalue!=null)
			return tsvalue.listIterator();
		return null;
	}

	@Override
	public ListIterator<TSAtomicAPI> listIterator(int index) {
		if(this.tsvalue!=null)
			return tsvalue.listIterator(index);
		return null;
	}

	@Override
	public TSAtomicAPI remove(int index) {
		if(this.tsvalue!=null)
			return tsvalue.remove(index);
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if(this.tsvalue!=null)
			return tsvalue.remove(o);
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
	public TSAtomicAPI set(int index, TSAtomicAPI element) {
		if(this.tsvalue!=null)
			return tsvalue.set(index, element);
		return new TSNull();

	}

	@Override
	public int size() {
		if(this.tsvalue!=null)
			return tsvalue.size();
		return 0;
	}

	@Override
	public List<TSAtomicAPI> subList(int fromIndex, int toIndex) {
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
		if(this.tsvalue!=null)
			return this.tsvalue.toString();
		return null;
	}

	public ArrayList<String> toStringArray(){
		ArrayList<String> ret=new ArrayList<String>();
		for (TSAtomicAPI s : this.tsvalue)
			ret.add(s.toString());
		return ret;
	}

	@Override
	public void tsClean() {
		// TODO
		logger.warn("tsClean not implemented");
/*
		ArrayList<String> listRemove=new ArrayList<String>();
		for (OatBaseAtomic s : this.tsvalue) {
			switch(s.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)s).clean();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)s).clean();
					break;
				case OAT_ATOMIC_STRING:
					try {
						if(((OatString)s).tsvalue.length()==0)
							listRemove.add(((OatString)s).getValue());
					} catch (tsvalueIsNullException e) {}
					break;
				default:
					break;
			}
		}
		for(int i=0;i<listRemove.size();i++)
			this.tsvalue.remove(listRemove.get(i));
*/
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
		// TODO
		logger.warn("tsPlusnot implemented");
		
	}

	@Override
	public String tsToString(int indent) {
		// TODO
		logger.warn("tsToString not implemented");
		return null;
	}

	@Override
	public void tsTrim() {
		for (TSAtomicAPI s : this.tsvalue)
			s.tsTrim();
	}


	@Override
	public TSArrayListAtomic tsCopyAtomic(){
		TSArrayListAtomic ret=new TSArrayListAtomic();
		ret.tsvalue=new ArrayList<TSAtomicAPI>(this.tsvalue.size());
		for(int i=0;i<this.tsvalue.size();i++){
			ret.tsvalue.add(this.tsvalue.get(i).tsCopyAtomic());
		}
		return ret;
	}
}
