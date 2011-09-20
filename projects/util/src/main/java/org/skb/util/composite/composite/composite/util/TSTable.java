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

package org.skb.util.patterns.structural.composite.composite.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSCompositeAPI;
import org.skb.util.patterns.structural.composite.TSNull;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSTableAPI;
import org.skb.util.patterns.structural.composite.TSTableRowAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.java.TSByte;
import org.skb.util.patterns.structural.composite.atomic.java.TSDouble;
import org.skb.util.patterns.structural.composite.atomic.java.TSFloat;
import org.skb.util.patterns.structural.composite.atomic.java.TSInteger;
import org.skb.util.patterns.structural.composite.atomic.java.TSLong;
import org.skb.util.patterns.structural.composite.atomic.java.TSObject;
import org.skb.util.patterns.structural.composite.atomic.java.TSShort;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;

/**
 * A composite class for tables.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSTable implements TSCompositeAPI, TSTableAPI{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSTable.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));


	protected LinkedHashMap<String, TSTableRowAPI> tsvalue=null;


	protected HashSet<String> columns=null;


	protected boolean columnsInitialised=false;


	public TSTable(){
		this._init();
	}


	public TSTable(HashSet<String>rows, HashSet<String>cols){
		this._init();
		this.setColumns(cols);
		this.addRows(rows);
	}


	public TSTable(String ref_class, String rowPrefix, String colPrefix){
		this._init();
		this.setColumns(ref_class, colPrefix);
		this.addRows(ref_class, rowPrefix);
	}


	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_COMPOSITE);
		this.typeEnum.add(TEnum.TS_COMPOSITE);

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_TABLE);
		this.typeEnum.add(TEnum.TS_COMPOSITE_TABLE);

		this.tsvalue=new LinkedHashMap<String, TSTableRowAPI>();
		this.columns=new HashSet<String>();
	}


	@Override
	public void addRow(String row) {
		if(this.columnsInitialised&&row!=null){
			LinkedHashMap<String, TSBaseAPI> rowMap=new LinkedHashMap<String, TSBaseAPI>();
			Iterator<String> cIT = this.columns.iterator();
			while(cIT.hasNext()){
				String key=cIT.next();
				rowMap.put(key, null);
			}
			this.put(row, new TSTableRow(rowMap));
		}
	}


	@Override
	public void addRows(HashSet<String> rows) {
		if(this.columnsInitialised&&rows!=null){
			Iterator<String> rIT = rows.iterator();
			while(rIT.hasNext()){
				String row=rIT.next();
				this.addRow(row);
			}
		}
	}


	@Override
	public void addRows(String ref_class, String prefix) {
		if(this.columnsInitialised&&ref_class!=null&&prefix!=null){
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


	protected boolean checkField(int mod, String type, String name, String prefix){
		if((mod==(Modifier.FINAL+Modifier.PUBLIC+Modifier.STATIC))&&("java.lang.String".equals(type))){
			if(prefix!=null&&name.startsWith(prefix))
				return true;
			if(prefix==null)
				return true;
			return false;
		}
		return false;
	}


	@Override
	public void clear() {
		if(this.isInitialised())
			this.tsvalue.clear();
	}


	@Override
	public boolean containsKey(Object key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.containsKey(key);
		else
			return false;
	}


	@Override
	public boolean containsKey(String key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.containsKey(key);
		else
			return false;
	}


	@Override
	public boolean containsKey(TSString key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.containsKey(key.toString());
		else
			return false;
	}


	@Override
	public boolean containsValue(Object value) {
		if(this.isInitialised()&&value!=null)
			return this.tsvalue.containsValue(value);
		else
			return false;
	}


	@Override
	public boolean containsValue(TSTableRowAPI value) {
		if(this.isInitialised()&&value!=null)
			return this.tsvalue.containsValue(value);
		else
			return false;
	}


	@Override
	public Set<java.util.Map.Entry<String, TSTableRowAPI>> entrySet() {
		Set<java.util.Map.Entry<String, TSTableRowAPI>> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.entrySet();
		if(ret==null)
			return new TreeSet<java.util.Map.Entry<String, TSTableRowAPI>>();
		else
			return ret;
	}


	@Override
	public TSTableRowAPI get(Object key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.get(key);
		else
			return null;
	}


	@Override
	public TSTableRowAPI get(String key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.get(key);
		else
			return null;
	}


	@Override
	public TSBaseAPI get(String row, String col) {
		TSBaseAPI ret=new TSNull();
		if(this.isInitialised()){
			if(this.containsKey(row)&&this.get(row).containsKey(col))
				ret=this.tsvalue.get(row).get(col);
		}
		return ret;
	}


	@Override
	public TSTableRowAPI get(TSString key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.get(key);
		else
			return null;
	}


	@Override
	public TSBoolean getBoolean(String row, String col) {
		TSBoolean ret=new TSBoolean();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_BOOLEAN))
				ret=(TSBoolean)tsb;
		}
		return ret;
	}


	@Override
	public TSByte getByte(String row, String col) {
		TSByte ret=new TSByte();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_BYTE))
				ret=(TSByte)tsb;
		}
		return ret;
	}


	@Override
	public HashSet<String> getColumns() {
		if(this.isInitialised())
			return this.columns;
		else
			return new HashSet<String>();
	}


	@Override
	public TSDouble getDouble(String row, String col) {
		TSDouble ret=new TSDouble();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_DOUBLE))
				ret=(TSDouble)tsb;
		}
		return ret;
	}


	@Override
	public TSFloat getFloat(String row, String col) {
		TSFloat ret=new TSFloat();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_FLOAT))
				ret=(TSFloat)tsb;
		}
		return ret;
	}


	@Override
	public TSInteger getInteger(String row, String col) {
		TSInteger ret=new TSInteger();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_INTEGER))
				ret=(TSInteger)tsb;
		}
		return ret;
	}


	@Override
	public TSLong getLong(String row, String col) {
		TSLong ret=new TSLong();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_LONG))
				ret=(TSLong)tsb;
		}
		return ret;
	}


	@Override
	public TSObject getObject(String row, String col) {
		TSObject ret=new TSObject();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_OBJECT))
				ret=(TSObject)tsb;
		}
		return ret;
	}


	@Override
	public Set<String> getRows() {
		return this.keySet();
	}


	@Override
	public TSShort getShort(String row, String col) {
		TSShort ret=new TSShort();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_SHORT))
				ret=(TSShort)tsb;
		}
		return ret;
	}


	@Override
	public TSString getString(String row, String col) {
		TSString ret=new TSString();
		if(this.isInitialised()){
			TSBaseAPI tsb=this.get(row, col);
			if(tsb.tsIsType(TEnum.TS_ATOMIC_JAVA_STRING))
				ret=(TSString)tsb;
		}
		return ret;
	}


	@Override
	public boolean isEmpty() {
		if(this.isInitialised())
			return this.tsvalue.isEmpty();
		return true;
	}


	@Override
	public boolean isInitialised() {
		return this.columnsInitialised;
	}


	@Override
	public Set<String> keySet() {
		Set<String> ret=null;
		if(this.isInitialised())
			ret=this.tsvalue.keySet();
		if(ret==null)
			return new TreeSet<String>();
		else
			return ret;
	}


	@Override
	public void put(String row, String col, boolean val) {
		if(this.isInitialised()&&row!=null&&col!=null)
			this.tsvalue.get(row).put(col, new TSBoolean(val));
	}


	@Override
	public void put(String row, String col, Boolean val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, new TSBoolean(val));
	}


	@Override
	public void put(String row, String col, double val) {
		if(this.isInitialised()&&row!=null&&col!=null)
			this.tsvalue.get(row).put(col, new TSDouble(val));
	}


	@Override
	public void put(String row, String col, Double val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, new TSDouble(val));
	}


	@Override
	public void put(String row, String col, int val) {
		if(this.isInitialised()&&row!=null&&col!=null)
			this.tsvalue.get(row).put(col, new TSInteger(val));
	}


	@Override
	public void put(String row, String col, Integer val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, new TSInteger(val));
	}


	@Override
	public void put(String row, String col, long val) {
		if(this.isInitialised()&&row!=null&&col!=null)
			this.tsvalue.get(row).put(col, new TSLong(val));
	}


	@Override
	public void put(String row, String col, Long val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, new TSLong(val));
	}


	@Override
	public void put(String row, String col, String val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, new TSString(val));
	}


	public void put(String row, String col, TSBaseAPI val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, val);
	}


	@Override
	public void put(String row, String col, TSAtomicAPI val) {
		if(this.isInitialised()&&row!=null&&col!=null&&val!=null)
			this.tsvalue.get(row).put(col, val);
	}


	@Override
	public TSTableRowAPI put(String key, TSTableRowAPI val) {
		if(this.isInitialised()&&key!=null&&val!=null)
			return this.tsvalue.put(key, val);
		else
			return null;
	}


	@Override
	public TSTableRowAPI put(TSString key, TSTableRowAPI val) {
		if(this.isInitialised()&&key!=null&&val!=null)
			return this.tsvalue.put(key.toString(), val);
		else
			return null;
	}


	@Override
	public void putAll(Map<? extends String, ? extends TSTableRowAPI> map) {
		String key;
		@SuppressWarnings("unchecked")
		Set<String> o_set = (Set<String>) map.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			this.put(key, map.get(key));
		}
	}


	@Override
	public TSTableRowAPI remove(Object key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.remove(key);
		else
			return null;
	}


	@Override
	public TSTableRowAPI remove(String key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.remove(key);
		else
			return null;
	}


	@Override
	public TSTableRowAPI remove(TSString key) {
		if(this.isInitialised()&&key!=null)
			return this.tsvalue.remove(key);
		else
			return null;
	}


	@Override
	public void setColumns(HashSet<String> cols) {
		if(this.columnsInitialised==false){
			this.columns=cols;
			this.columnsInitialised=true;
		}
	}


	@Override
	public void setColumns(String ref_class, String prefix) {
		if(this.columnsInitialised==false){
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


	@Override
	public void setColumns(HashSet<String> cols, String ref_class, String prefix) {
		//add the string set
		this.setColumns(cols);
		//re-set init to false, to that the next set still sets
		this.columnsInitialised=false;
		//add the prefixed class fields
		this.setColumns(ref_class, prefix);
	}


	@Override
	public int size() {
		if(this.isInitialised())
			return this.tsvalue.size();
		else
			return 0;
	}


	public String toString(){
		return this.tsToString(0);
	}


	@Override
	public void tsClean() {
		//TODO
		logger.warn("tsClean not implemented");
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
		if(this.isInitialised()==false)
			return new String();

		indent+=4;
		String indentation=new String();
		for(int i=1;i<=indent;i++)
			indentation+=" ";

		String ret = new String();
		String key;
		TSBaseAPI val;

		Set<String> o_set = this.tsvalue.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			val=this.tsvalue.get(key);
			if(val.tsIsType(TSRepository.TEnum.TS_COMPOSITE))
				ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => \n"+this.tsvalue.get(key).tsToString(indent)+"\n";
			else
				ret+=indentation+"["+key+"] <"+this.tsvalue.get(key).tsGetTypeString()+"> => "+this.tsvalue.get(key).toString()+"\n";
		}
		return ret;
	}


	@Override
	public void tsTrim() {
		//TODO
		logger.warn("tsTrim not implemented");
	}


	@Override
	public Collection<TSTableRowAPI> values() {
		if(this.tsvalue!=null)
			return this.tsvalue.values();
		else
			return new TreeSet<TSTableRowAPI>();		
	}


	@Override
	public Map<String, TSTableRowAPI> tsGetMap() {
		if(this.isInitialised())
			return this.tsvalue;
		else
			return new LinkedHashMap<String, TSTableRowAPI>();
	}


	@Override
	public TSTable tsCopyComposite(){
		TSTable ret=new TSTable();

		String key;
		Set<String> o_set=(Set<String>)this.tsvalue.keySet();
		Iterator<String> key_it=o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			ret.tsvalue.put(key, (TSTableRowAPI)this.tsvalue.get(key).tsCopyComposite());
		}
		ret.columns=new HashSet<String>(this.columns);
		ret.columnsInitialised=this.columnsInitialised;
		return ret;
	}
}
