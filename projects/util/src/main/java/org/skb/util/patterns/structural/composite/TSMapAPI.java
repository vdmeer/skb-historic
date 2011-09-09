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

package org.skb.util.types.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.skb.util.types.atomic.java.TSString;

/**
 * Base interface for map implementations in the SKB type system
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface TSMapAPI extends TSCompositeAPI, Map<String, TSBaseAPI>{
	public boolean containsKey(List<String> list);
	public boolean containsKey(String key) ;
	public boolean containsKey(String[] list);
	public boolean containsKey(TSString key);
	public TSBaseAPI get(List<String> list);
	public TSBaseAPI get(String key);
	public TSBaseAPI get(String[] list);
	public TSBaseAPI get(TSString key);
	public void h2l();
	public boolean isEmpty() ;
	public boolean isInitialised();
	public Set<String> keySet() ;
	public void merge(TSMapAPI arg0);
	public TSBaseAPI put(ArrayList<String> list, String val);
	public TSBaseAPI put(List<String> list, TSBaseAPI val);
	public TSBaseAPI put(String key, String val);
	public TSBaseAPI put(String key, TSBaseAPI val) ;
	public TSBaseAPI put(String[] list, String val);
	public TSBaseAPI put(String[] list, TSBaseAPI val);
	public TSBaseAPI put(TSString key, TSBaseAPI val);
	public void putAll(Map<? extends String, ? extends TSBaseAPI> map) ;
	public void putAll(TSMapAPI m) ;
	public TSBaseAPI remove(List<String> list);
	public TSBaseAPI remove(String key);
	public TSBaseAPI remove(String[] list);
	public TSBaseAPI remove(TSString key);
	public Map<String, TSBaseAPI> tsGetMap();
	public Object tsGetValue();

	public Collection<TSBaseAPI> values() ;
}
