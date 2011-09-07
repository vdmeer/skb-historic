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

package org.skb.util.types.atomic.util;

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
import org.skb.util.types.TSNull;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSAtomic;
import org.skb.util.types.api.TSBase;

/**
 * An Array list of TSAtomic types.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSArrayListAtomic implements TSAtomic, List<TSAtomic>, Collection<TSAtomic>{
	/** Logger instance */
	static Logger logger;

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	protected List<TSAtomic> tsvalue=null;

	public TSArrayListAtomic(){
		this._init();
		this.tsvalue=new ArrayList<TSAtomic>();
	}

	public TSArrayListAtomic(int initialCapacity){
		this._init();
		this.tsvalue=new ArrayList<TSAtomic>(initialCapacity);
	}

//	public TSArrayListStringAtomic(TSArrayListStringAtomic a){
//		this._init();
//		if(a!=null)
//			this.tsvalue=new ArrayList<TSAtomic>(a.getValue());
//		else
//			this.tsvalue=new ArrayList<TSAtomic>();
//	}

	public TSArrayListAtomic(List<TSAtomic>a){
		this._init();
		this.tsvalue=new ArrayList<TSAtomic>(a);
	}

	protected void _init(){
		logger=Logger.getLogger(TSArrayListAtomic.class);

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
	public void add(int index, TSAtomic element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(index, element);
	}

	@Override
	public boolean add(TSAtomic e) {
		if(this.tsvalue!=null)
			return this.tsvalue.add(e);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TSAtomic> c) {
		if(this.tsvalue!=null)
			return this.tsvalue.addAll(c);
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TSAtomic> c) {
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
	public TSAtomic get(int index) {
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
	public Iterator<TSAtomic> iterator() {
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
	public ListIterator<TSAtomic> listIterator() {
		if(this.tsvalue!=null)
			return tsvalue.listIterator();
		return null;
	}

	@Override
	public ListIterator<TSAtomic> listIterator(int index) {
		if(this.tsvalue!=null)
			return tsvalue.listIterator(index);
		return null;
	}

	@Override
	public TSAtomic remove(int index) {
		if(this.tsvalue!=null)
			return tsvalue.remove(index);
		return new TSNull();
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
	public TSAtomic set(int index, TSAtomic element) {
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
	public List<TSAtomic> subList(int fromIndex, int toIndex) {
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
		for (TSAtomic s : this.tsvalue)
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
	public void tsPlus(TSBase tb) {
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
		for (TSAtomic s : this.tsvalue)
			s.tsTrim();
	}
}
