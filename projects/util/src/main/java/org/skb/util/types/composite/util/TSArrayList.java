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

package org.skb.util.types.composite.util;

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
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBaseAPI;
import org.skb.util.types.api.TSCompositeAPI;

/**
 * An Array list of TSBase types.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSArrayList implements TSCompositeAPI, List<TSBaseAPI>, Collection<TSBaseAPI> {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSArrayList.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));

	/** Local value */
	protected List<TSBaseAPI> tsvalue=null;

	public TSArrayList(){
		this._init();
		this.tsvalue=new ArrayList<TSBaseAPI>();
	}

	public TSArrayList(int initialCapacity){
		this._init();
		this.tsvalue=new ArrayList<TSBaseAPI>(initialCapacity);
	}

	public TSArrayList(List<TSBaseAPI>a){
		this._init();
		this.tsvalue=new ArrayList<TSBaseAPI>(a);
	}

	public TSArrayList(TSArrayList a){
		this._init();
		if(a!=null)
			this.tsvalue=new ArrayList<TSBaseAPI>(a.tsGetList());
		else
			this.tsvalue=new ArrayList<TSBaseAPI>();
	}

	public TSArrayList(TSBaseAPI oba) {
		//TODO
		logger.warn("constructor (TSBase) not implemented");
//		this._init();
//		if(oba!=null){
//			switch(oba.getTypeEnum()){
//				case OAT_ARRAYLIST:
//					this.oatValue=new ArrayList<OatBase>(((OatBaseArrayList)oba).getValue());
//					break;
//				default:
//					this.oatValue=new ArrayList<OatBase>();
//			}
//		}
//		else
//			this.oatValue=new ArrayList<OatBase>();
	}

	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_COMPOSITE);
		this.typeEnum.add(TEnum.TS_COMPOSITE);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_ARRAYLIST);
		this.typeEnum.add(TEnum.TS_COMPOSITE_ARRAYLIST);

		this.tsvalue=new ArrayList<TSBaseAPI>();
	}

	@Override
	public void add(int index, TSBaseAPI element) {
		if(this.tsvalue!=null)
			this.tsvalue.add(index, element);
	}

	@Override
	public boolean add(TSBaseAPI element) {
		if(this.tsvalue!=null)
			return this.tsvalue.add(element);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TSBaseAPI> c) {
		boolean ret=false;
		if(this.tsvalue!=null)
			ret=this.tsvalue.addAll(c);
		return ret;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TSBaseAPI> c) {
		boolean ret=false;
		if(this.tsvalue!=null)
			ret=tsvalue.addAll(index, c);
		return ret;
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
	public TSBaseAPI get(int index) {
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
	public Iterator<TSBaseAPI> iterator() {
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
	public ListIterator<TSBaseAPI> listIterator() {
		if(this.tsvalue!=null)
			return tsvalue.listIterator();
		return null;
	}

	@Override
	public ListIterator<TSBaseAPI> listIterator(int index) {
		if(this.tsvalue!=null)
			return tsvalue.listIterator(index);
		return null;
	}

	@Override
	public TSBaseAPI remove(int index) {
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
	public TSBaseAPI set(int index, TSBaseAPI element) {
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
	public List<TSBaseAPI> subList(int fromIndex, int toIndex) {
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

	public ArrayList<String> toStringArray(){
		ArrayList<String> ret=new ArrayList<String>();
		for (TSBaseAPI s : this.tsvalue)
			ret.add(s.toString());
		return ret;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(this.tsvalue!=null)
			return tsvalue.toArray(a);
		return null;
	}

	@Override
	public void tsClean() {
		//TODO
		logger.warn("tsClean not implemented");
/*
		ArrayList<String> listRemove=new ArrayList<String>();
		for (TSBase s : this.tsvalue) {
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

	public List<TSBaseAPI> tsGetList(){
		if(this.tsvalue!=null)
			return this.tsvalue;
		else
			return new ArrayList<TSBaseAPI>();
	}

	public TSArrayList tsGetValue(){
		return this;
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
		//TODO
		logger.warn("tsPlus not implemented");
	}

	@Override
	public String tsToString(int indent) {
		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();

		for(TSBaseAPI val : this.tsvalue){
			if(val.tsIsType(TSRepository.TEnum.TS_COMPOSITE))
				ret+=indentation+" <"+val.tsGetTypeString()+"> => \n"+val.tsToString(indent)+"\n";
			else
				ret+=indentation+" <"+val.tsGetTypeString()+"> => "+val.toString()+"\n";
		}
		return ret;
	}

	@Override
	public void tsTrim() {
		//TODO
		logger.warn("tsTrim not implemented");
/*
		for (TSBase s : this.tsvalue) {
			switch(s.getTypeEnum()){
				case OAT_ARRAYLIST_STRING:
					((OatArrayListString)s).trim();
					break;
				case OAT_ARRAYLIST_ATOMIC:
					((OatArrayListAtomic)s).trim();
					break;
				case OAT_ATOMIC_STRING:
					try {
						((OatString)s).tsvalue.trim();
					} catch (Exception e) {}
					break;
				default:
					break;
			}
		}
*/
	}

	public String toString(){
		return this.tsToString(0);
	}
/*
	public void h2l(){
		for (TSBase s : this.tsvalue) {
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
*/
}
