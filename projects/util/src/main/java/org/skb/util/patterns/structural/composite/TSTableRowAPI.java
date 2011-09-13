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

package org.skb.util.patterns.structural.composite;

import java.util.Map;

import org.skb.util.patterns.structural.composite.atomic.java.TSString;

public interface TSTableRowAPI extends TSCompositeAPI, Map<String, TSBaseAPI>{

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map
	 * contains a mapping for a key k such that (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
	 * @param key key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key.  
	 */
	public boolean containsKey(String key);

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map
	 * contains a mapping for a key k such that (key==null ? k==null : key.equals(k)). (There can be at most one such mapping.)
	 * @param key key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key. 
	 */
	public boolean containsKey(TSString key);

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 *  
	 * Returns true if this map maps one or more keys to the specified value. More formally, returns true if and only if this map
	 * contains at least one mapping to a value v such that (value==null ? v==null : value.equals(v)). This operation will probably
	 * require time linear in the map size for most implementations of the Map interface.  
	 * @param val value whose presence in this map is to be tested.
	 * @return true if this map maps one or more keys to the specified value.
	 */
	public boolean containsValue(TSBaseAPI val);

	/**
	 * Returns the value to which this map maps the specified key.
	 * 
	 * Returns the value to which this map maps the specified key. Returns TSNull if the map contains no mapping for this key. A return
	 * value of TSNull does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly
	 * maps the key to TSNull. The containsKey operation may be used to distinguish these two cases.
	 * 
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this
	 * method returns v; otherwise it returns TSNull. (There can be at most one such mapping.) 
	 * @param key key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or TSNull if the map contains no mapping for this key.
	 */
	public TSBaseAPI get(String key);

	/**
	 * Returns the value to which this map maps the specified key.
	 * 
	 * Returns the value to which this map maps the specified key. Returns TSNull if the map contains no mapping for this key. A return
	 * value of TSNull does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly
	 * maps the key to TSNull. The containsKey operation may be used to distinguish these two cases.
	 * 
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this
	 * method returns v; otherwise it returns TSNull. (There can be at most one such mapping.) 
	 * @param key key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or TSNull if the map contains no mapping for this key.
	 */
	public TSBaseAPI get(TSString key);

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
	public TSBaseAPI put(TSString key, TSBaseAPI val);

	public Map<String, TSBaseAPI> tsGetMap();
	public Object tsGetValue();

	public String tsToString(int indent);
	//public T2TableRow getValOatTableRow();
}
