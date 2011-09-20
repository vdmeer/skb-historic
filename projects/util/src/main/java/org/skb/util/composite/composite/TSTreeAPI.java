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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.skb.util.patterns.structural.composite.atomic.java.TSString;


/**
 * Base interface for a tree classes.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface TSTreeAPI extends TSCompositeAPI, Map<String, TSBaseAPI>{

	/**
	 * Returns true if this tree contains a mapping for the specified path. 
	 * More specifically, returns true if the map contains a mapping for the given path.
	 * @param fqpn path and key to be tested
	 * @return true if this map contains a mapping for the specified path.
	 */
	public boolean containsKey(List<String> fqpn);


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * More specifically, returns true if the map contains a mapping for the given key (string without any "/" character) or the 
	 * given path (string with "/" separators for each path element). 
	 * @param fqpn either the key (simple string) or a path to the key (string with "/" separators).
	 * @return true if this map contains a mapping for the specified key or path.
	 */
	public boolean containsKey(String fqpn);


	/**
	 * Returns true if this map contains a mapping for the specified path.
	 * More specifically, returns true if the map contains a mapping for the given path.
	 * @param fqpn path and key to be tested
	 * @return true if this map contains a mapping for the specified path.
	 */
	public boolean containsKey(String[] fqpn);


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * More specifically, returns true if the map contains a mapping for the given key (string without any "/" character) or the 
	 * given fqpn (string with "/" separators for each path element). 
	 * @param key either the key (simple string) or a path to the key (string with "/" separators).
	 * @return true if this map contains a mapping for the specified key or path.
	 */
	public boolean containsKey(TSString fqpn);


	/**
	 * Returns the value to which this map maps the specified path.
	 * @param fqpn path and key whose associated value is to be returned. 
	 * @return the value to which this map maps the specified path, or {@link TSNull} if the map contains no mapping for this path. 
	 */
	public TSBaseAPI get(List<String> fqpn);


	/**
	 * Returns the value to which this map maps the specified key or path.
	 * More specifically, returns a value if the map contains a mapping for the given key (string without any "/" character) or the 
	 * given path (string with "/" separators for each path element) and a value exists, or {@link TSNull} if the map contains no mapping for this path.
	 * @param fqpn key or path whose value should be returned
	 * @return the value to which this map maps the specified key or path, or {@link TSNull} if the map contains no mapping for this key/path.
	 */
	public TSBaseAPI get(String fqpn);


	/**
	 * Returns the value to which this map maps the specified path.
	 * @param fqpn path path and key whose associated value is to be returned.
	 * @return the value to which this map maps the specified path, or {@link TSNull} if the map contains no mapping for this path.
	 */
	public TSBaseAPI get(String[] fqpn);


	/**
	 * Returns the value to which this map maps the specified key or path.
	 * More specifically, returns a value if the map contains a mapping for the given key (string without any "/" character) or the 
	 * given path (string with "/" separators for each path element) and a value exists, or {@link TSNull} if the map contains no mapping for this path.
	 * @param fqpn key or path whose value should be returned
	 * @return the value to which this map maps the specified key or path, or {@link TSNull} if the map contains no mapping for this key/path.
	 */
	public TSBaseAPI get(TSString fqpn);


	@Override
	public boolean isEmpty() ;


	/**
	 * Returns the current status of initialisation of the tree.
	 * @return true if the tree is fully initialised, false otherwise
	 */
	public boolean isInitialised();


	@Override
	public Set<String> keySet() ;


	public TSBaseAPI put(ArrayList<String> fqpn, String val);


	public TSBaseAPI put(List<String> fqpn, TSBaseAPI val);


	public TSBaseAPI put(String fqpn, String val);


	public TSBaseAPI put(String fqpn, TSBaseAPI val) ;


	public TSBaseAPI put(String[] fqpn, String val);


	public TSBaseAPI put(String[] fqpn, TSBaseAPI val);


	public TSBaseAPI put(TSString fqpn, TSBaseAPI val);


	@Override
	public void putAll(Map<? extends String, ? extends TSBaseAPI> map);


	public void putAll(TSTreeAPI m);


	public TSBaseAPI remove(List<String> fqpn);


	public TSBaseAPI remove(String fqpn);


	public TSBaseAPI remove(String[] fqpn);


	public TSBaseAPI remove(TSString fqpn);


	public Map<String, TSBaseAPI> tsGetMap();


	@Override
	public Collection<TSBaseAPI> values() ;
}
