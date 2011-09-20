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

package org.skb.util.composite;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSByte;
import org.skb.util.composite.java.TSDouble;
import org.skb.util.composite.java.TSFloat;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSLong;
import org.skb.util.composite.java.TSObject;
import org.skb.util.composite.java.TSShort;
import org.skb.util.composite.java.TSString;

/**
 * Base interface for all table implementations of the SKB type system
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface TSTableAPI extends TSCompositeAPI, Map<String, TSTableRowAPI>{
	/**
	 * Add am empty row to the table
	 * 
	 * This method should add a new empty row using the given string as key.
	 * @param row key of the row to be added
	 */
	public void addRow(String row);


	/**
	 * Add a set of empty rows to the table
	 * 
	 * This method should add a new empty row using the given strings as keys.
	 * @param rows set of rows to be added
	 */
	public void addRows(HashSet<String>rows);


	/**
	 * Add a set of rows using reflection
	 * 
	 * This method should use reflection to collect all declared fields of the given class <ref_class> whose name starts with the string <prefix> and then
	 * create an empty row using the string defined by the declared fields as keys. Have a look at the following example:
	 * <code>
	 * 		public final static String tpmKeySrcLanguage		= "src-lang";
	 * 		public final static String tpmKeySrcFile			= "src-file";
	 * 		public final static String tpmKeyTgtLanguage		= "tgt-lang";
	 * 		public final static String tpmKeyTgtDir				= "tgt-dir";
	 * 		void init(){
	 * 			...
	 * 			this.table.addRows(MyClass.class.getName(), "tpmKey");
	 * 			...
	 * 		}
	 * </code>
	 * The class declares four fields that all use the same prefix in their name: "tpmKey". In a method <code>init</code>, the class then calls
	 * <code>addRows</code> with its own class name and the required prefix "tpmKey" to create four empty rows in the table with the keys "src-lang",
	 *  "src-file", "tgt-lang" and "tgt-dir".
	 * @param ref_class class name to be used for reflection
	 * @param prefix string to be used as prefix filter when selecting declared fields 
	 */
	public void addRows(String ref_class, String prefix);


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map
	 * contains a mapping for a key k such that (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
	 * @param key - key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key. 
	 */
	public boolean containsKey(String key);


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map
	 * contains a mapping for a key k such that (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
	 * @param key - key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key. 
	 */
	public boolean containsKey(TSString key);


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 *  
	 * Returns true if this map maps one or more keys to the specified value. More formally, returns true if and only if this map
	 * contains at least one mapping to a value v such that (value==null ? v==null : value.equals(v)). This operation will probably
	 * require time linear in the map size for most implementations of the Map interface.  
	 * @param value - value whose presence in this map is to be tested.
	 * @return true if this map maps one or more keys to the specified value.
	 */
	public boolean containsValue(TSTableRowAPI value);


	@Override
	public Set<java.util.Map.Entry<String, TSTableRowAPI>> entrySet();


	/**
	 * Returns the value to which this map maps the specified key.
	 * 
	 * Returns the value to which this map maps the specified key. Returns TSNull if the map contains no mapping for this key. A return
	 * value of TSNull does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly
	 * maps the key to TSNull. The containsKey operation may be used to distinguish these two cases.
	 * 
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this
	 * method returns v; otherwise it returns TSNull. (There can be at most one such mapping.) 
	 * @param key - key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or TSNull if the map contains no mapping for this key.
	 */
	public TSTableRowAPI get(String key);


	public TSBaseAPI get(String row, String col);


	/**
	 * Returns the value to which this map maps the specified key.
	 * 
	 * Returns the value to which this map maps the specified key. Returns TSNull if the map contains no mapping for this key. A return
	 * value of TSNull does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly
	 * maps the key to TSNull. The containsKey operation may be used to distinguish these two cases.
	 * 
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this
	 * method returns v; otherwise it returns TSNull. (There can be at most one such mapping.) 
	 * @param key - key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or TSNull if the map contains no mapping for this key.
	 */
	public TSTableRowAPI get(TSString key);

	public TSBoolean getBoolean(String row, String col);

	public TSByte getByte(String row, String col);

	public HashSet<String> getColumns();

	public TSDouble getDouble(String row, String col);

	public TSFloat getFloat(String row, String col);

	public TSInteger getInteger(String row, String col);

	public TSLong getLong(String row, String col);

	public TSObject getObject(String row, String col);

	public Set<String> getRows();

	public TSShort getShort(String row, String col);

	public TSString getString(String row, String col);

	public boolean isInitialised();

	public void put(String row, String col, boolean val);

	public void put(String row, String col, Boolean val);

	public void put(String row, String col, double val);

	public void put(String row, String col, Double val);

	public void put(String row, String col, int val);

	public void put(String row, String col, Integer val);

	public void put(String row, String col, long val);

	public void put(String row, String col, Long val);

	public void put(String row, String col, String val);

	public void put(String row, String col, TSAtomicAPI val);


	/**
	 * Associates the specified value with the specified key in this map (optional operation).
	 * 
	 * Associates the specified value with the specified key in this map (optional operation). If the map previously contained a mapping
	 * for this key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only if
	 * m.containsKey(k) would return true.))  
	 * @param key key with which the specified value is to be associated.
	 * @param val value to be associated with the specified key.
	 * @return previous value associated with specified key, or TSNull if there was no mapping for key. A TSNull return can also indicate that
	 * the map previously associated null with the specified key, if the implementation supports null values. 
	 */
	public TSTableRowAPI put(String key, TSTableRowAPI val);


	/**
	 * Associates the specified value with the specified key in this map (optional operation).
	 * 
	 * Associates the specified value with the specified key in this map (optional operation). If the map previously contained a mapping
	 * for this key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only if
	 * m.containsKey(k) would return true.))  
	 * @param key key with which the specified value is to be associated.
	 * @param val value to be associated with the specified key.
	 * @return previous value associated with specified key, or TSNull if there was no mapping for key. A TSNull return can also indicate that
	 * the map previously associated null with the specified key, if the implementation supports null values. 
	 */
	public TSTableRowAPI put(TSString key, TSTableRowAPI val);


	@Override
	public void putAll(Map<? extends String, ? extends TSTableRowAPI> map);


	public TSTableRowAPI remove(String key);


	public TSTableRowAPI remove(TSString key);


	public void setColumns(HashSet<String>cols);


	public void setColumns(String ref_class, String prefix);


	public void setColumns(HashSet<String>cols, String ref_class, String prefix);


	public Map<String, TSTableRowAPI> tsGetMap();


	@Override
	public Collection<TSTableRowAPI> values();
}
