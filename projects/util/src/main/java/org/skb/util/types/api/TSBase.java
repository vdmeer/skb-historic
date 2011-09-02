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

import java.util.List;
import java.util.Set;

import org.skb.util.types.TSRepository.TEnum;

/**
 * Base interface for all SKB types
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface TSBase {
	/**
	 * Empty the TSBase object
	 */
	public void tsClean();

	/**
	 * Return the last entry of the type list as an enumerate
	 * @return type
	 */
	public TEnum tsGetTypeEnum();

	/**
	 * Return the full set of enumerate types
	 * @return type list
	 */
	public Set<TEnum> tsGetTypeEnumSet();

	/**
	 * Return the last entry of the type list as an string
	 * @return type
	 */
	public java.lang.String tsGetTypeString();

	/**
	 * Return the full set of string types
	 * @return type list
	 */
	public List<String> tsGetTypeStringList();

	/**
	 * Is the object a TSAtomic?
	 * @return true if the object is a TSAtomic type, false otherwise
	 */
	public boolean tsIsAtomic();

	/**
	 * Is the object a TSComposite?
	 * @return true if the object is a TSComposite type, false otherwise
	 */
	public boolean tsIsComposite();

	/**
	 * Test if the object is of a given type (string)
	 * @param type to be tested
	 * @return true if the object is of the given type, false otherwise
	 */
	public boolean tsIsType(String type);

	/**
	 * Test if the object is of a given type (enumerate)
	 * @param type to be tested
	 * @return true if the object is of the given type, false otherwise
	 */
	public boolean tsIsType(TEnum type);

	/**
	 * Add a value to the object
	 * @param tb value to be added
	 */
	public void tsPlus(TSBase tb);

	/**
	 * toString() with indentation for formatted output
	 * @param indent indentation to be used
	 * @return stringified version of the object
	 */
	public String tsToString(int indent);

	/**
	 * Trim the object
	 */
	public void tsTrim();
}
