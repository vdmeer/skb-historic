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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.skb.types.base.OatBaseAtomic;
import org.skb.types.base.OatBaseComposite;
import org.skb.types.base.OatBaseTable;
import org.skb.types.composite.util.OatTableRow;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatBoolean;
import org.skb.types.atomic.java.OatByte;
import org.skb.types.atomic.java.OatDouble;
import org.skb.types.atomic.java.OatFloat;
import org.skb.types.atomic.java.OatInteger;
import org.skb.types.atomic.java.OatLong;
import org.skb.types.atomic.java.OatObject;
import org.skb.types.atomic.java.OatShort;
import org.skb.types.atomic.java.OatString;

/**
 * A composite class for tables.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatBaseTable extends OatBaseComposite implements Map<String, OatTableRow> {
	protected Map<String, OatTableRow> oatValue=null;

	protected HashSet<String> columns=null;

	protected boolean columnsInitialised=false;

	protected void init(){
		//super();
		this.typeString.add(TypeRepository.OAT_BASE_COMPOSITE_TABLE);
		this.typeEnum.add(ATType.OAT_BASE_COMPOSITE_TABLE);
	}

	public Object getValue(){
		return this.oatValue;
	}

	/**
	 * 
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		if(this.isInitialised())
			this.oatValue.clear();
	}

	/**
	 * @param key
	 * @return boolean True if table contains key, false otherwise
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		if(this.isInitialised())
			return this.oatValue.containsKey(key);
		return false;
	}

	public boolean containsKey(OatString key){
		if(key!=null)
			return this.containsKey(key.toString());
		return false;
	}

	public boolean containsKey(String key){
		if(this.isInitialised())
			return this.oatValue.containsKey(key);
		return false;
	}

	/**
	 * @param value
	 * @return boolean True if table contains value, false otherwise
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		if(this.isInitialised())
			return this.oatValue.containsValue(value);
		return false;
	}

	/**
	 * @return Set
	 * @see java.util.Map#entrySet()
	 */
	public Set<java.util.Map.Entry<String, OatTableRow>> entrySet() {
		if(this.isInitialised())
			return this.oatValue.entrySet();
		return null;
	}

	/**
	 * @param key
	 * @return OatTableRow
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public OatTableRow get(Object key) {
		if(this.isInitialised())
			return this.oatValue.get(key);
		return null;
	}

	public OatTableRow get(OatString key){
		if(key!=null)
			return this.get(key.toString());
		return null;
	}

	public OatTableRow get(String key){
		if(this.isInitialised())
			return this.oatValue.get(key);
		return null;
	}

	/**
	 * @return boolean True if table is emtpy, false otherwise 
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		if(this.isInitialised())
			return this.oatValue.isEmpty();
		return true;
	}

	/**
	 * @return Set
	 * @see java.util.Map#keySet()
	 */
	public Set<String> keySet() {
		if(this.isInitialised())
			return this.oatValue.keySet();
		return null;
	}

	/**
	 * @param key
	 * @param value
	 * @return null if successful, row containing existing atom otherwise
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public OatTableRow put(String key, OatTableRow value) {
		if(this.isInitialised())
			return this.oatValue.put(key, value);
		return null;
	}

	/**
	 * @param m
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map<? extends String, ? extends OatTableRow> m) {
		;//this.field.putAll(m);
	}

	/**
	 * @param key
	 * @return OatTableRow
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public OatTableRow remove(Object key) {
		if(this.isInitialised())
			return this.oatValue.remove(key);
		return null;
	}

	public OatTableRow remove(OatString key){
		if(key!=null)
			return this.remove(key.toString());
		return null;
	}

	public OatTableRow remove(String key){
		if(this.isInitialised())
			return this.oatValue.remove(key);
		return null;
	}

	/**
	 * @return int
	 * @see java.util.Map#size()
	 */
	public int size() {
		if(this.isInitialised())
			return this.oatValue.size();
		return 0;
	}

	public String toString(){
		return this.toString(0);
	}

	public String toString(int indent){
		if(this.isInitialised()==false)
			return "";

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
			switch(this.oatValue.get(key).getTypeEnum()){
//this is not too good...
			case OAT_ARRAYLIST_ATOMIC:
			case OAT_ARRAYLIST_STRING:
					ret+=indentation+"["+key+"] => List "+this.oatValue.get(key).toString()+"\n";
					break;
				default:
					ret+=indentation+"["+key+"] => "+this.oatValue.get(key).toString()+"\n";
					break;
			}
		}
		return ret;
	}

	/**
	 * @return Collection
	 * @see java.util.Map#values()
	 */
	public Collection<OatTableRow> values() {
		if(this.isInitialised())
			return this.oatValue.values();
		return null;
	}


	public boolean isInitialised(){
		return this.columnsInitialised;
	}

	private boolean checkField(int mod, String type, String name, String prefix){
		if((mod==(Modifier.FINAL+Modifier.PUBLIC+Modifier.STATIC))&&("java.lang.String".equals(type))){
			if(prefix!=null&&name.startsWith(prefix))
				return true;
			if(prefix==null)
				return true;
			return false;
		}
		return false;
	}

	public HashSet<String> getColumns(){
		return this.columns;
	}

	public Set<String> getRows(){
		return this.oatValue.keySet();
	}

	public OatBaseAtomic get(String row, String col){
		if(this.oatValue.containsKey(row)&&this.oatValue.get(row).containsKey(col))
			return this.oatValue.get(row).get(col);
		return null;
	}

	public OatBoolean getBoolean(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_BOOLEAN))
			return (OatBoolean)oba;
		return null;
	}

	public OatByte getByte(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_BYTE))
			return (OatByte)oba;
		return null;
	}

	public OatDouble getDouble(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_DOUBLE))
			return (OatDouble)oba;
		return null;
	}

	public OatFloat getFloat(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_FLOAT))
			return (OatFloat)oba;
		return null;
	}

	public OatInteger getInteger(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_INTEGER))
			return (OatInteger)oba;
		return null;
	}

	public OatLong getLong(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_LONG))
			return (OatLong)oba;
		return null;
	}

	public OatObject getObject(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_OBJECT))
			return (OatObject)oba;
		return null;
	}

	public OatShort getShort(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_SHORT))
			return (OatShort)oba;
		return null;
	}

	public OatString getString(String row, String col){
		OatBaseAtomic oba=this.get(row, col);
		if(oba!=null&&oba.isType(TypeRepository.OAT_ATOMIC_STRING))
			return (OatString)oba;
		return null;
	}

	public OatTableRow put(OatString key, OatTableRow val){
		return this.put(key.toString(), val);
	}

	public void put(String row, String col, OatBaseAtomic val){
		if(this.isInitialised()&&this.oatValue.containsKey(row)){
			this.oatValue.get(row).put(col, val);
		}
	}

	public void put(String row, String col, boolean val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatBoolean(val));
	}

	public void put(String row, String col, Boolean val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatBoolean(val));
	}

	public void put(String row, String col, double val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatDouble(val));
	}

	public void put(String row, String col, Double val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatDouble(val));
	}

	public void put(String row, String col, int val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatInteger(val));
	}

	public void put(String row, String col, Integer val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatInteger(val));
	}

	public void put(String row, String col, long val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatLong(val));
	}

	public void put(String row, String col, Long val){
		if(this.isInitialised()&&this.oatValue.containsKey(row))
			this.oatValue.get(row).put(col, new OatLong(val));
	}

	public void put(String row, String col, String val){
		if(this.isInitialised()&&this.oatValue.containsKey(row)){
			this.put(row,col, new OatString(val));
		}
	}

	final public void setColumns(HashSet<String>cols){
		if(this.columnsInitialised==false){
			this.columns=cols;
			this.columnsInitialised=true;
		}
	}

	final public void setColumns(String ref_class, String prefix){
		if(this.columnsInitialised==false){
			this.columns=new HashSet<String>();
			try {
				Class<?> c=Class.forName(ref_class);
				for (Field f : c.getDeclaredFields()){
					if(this.checkField(f.getModifiers(), f.getType().getName(), f.getName(), prefix)==true)
						this.columns.add((String)f.get(c));
				}
				this.columnsInitialised=true;
			} catch (ClassNotFoundException ex) {
				System.out.println(ex);
			} catch (SecurityException e) {
				System.out.println(e);
			} catch (IllegalAccessException e) {
				System.out.println(e);
			}
		}
	}

	final public void addRow(String row){
		if(this.columnsInitialised!=false&&row!=null){
			LinkedHashMap<String, OatBaseAtomic> rowMap=new LinkedHashMap<String, OatBaseAtomic>();
			Iterator<String> cIT = columns.iterator();
			while(cIT.hasNext())
				rowMap.put(cIT.next(), null);
			this.put(row, new OatTableRow(rowMap));
		}
	}

	final public void addRows(HashSet<String>rows){
		if(this.columnsInitialised!=false&&rows!=null){
			Iterator<String> rIT = rows.iterator();
			while(rIT.hasNext())
				this.addRow(rIT.next());
		}
	}

	public void addRows(String ref_class, String prefix){
		if(this.columnsInitialised!=false&&ref_class!=null&&prefix!=null){
			try {
				HashSet<String>rows=new HashSet<String>();
				Class<?> c=Class.forName(ref_class);
				for (Field f : c.getDeclaredFields()){
					if(this.checkField(f.getModifiers(), f.getType().getName(), f.getName(), prefix)==true){
						rows.add((String)f.get(c));
					}
				}
				this.addRows(rows);
			} catch (ClassNotFoundException ex) {
				System.out.println(ex);
			} catch (SecurityException e) {
		        System.out.println(e);
		    } catch (IllegalAccessException e) {
		        System.out.println(e);
		    }
		}
	}

	public OatBaseTable getValOatBaseCompositeTable(){
		return this;
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}
