/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.util.classic.lang;

import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSDefault;

/**
 * Utilities for processing named scopes.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class NameScopeUtils {

	/**
	 * Returns the parent ID of the given ID using the given separator.
	 * @param id
	 * @param separator
	 * @return parent ID of the given current scope  or "" of not existent
	 */
	public static String getParentID(String id, String separator){
		if(id==null)
			return "";
		if(separator==null)
			return "";
		if(id.lastIndexOf(separator)==-1)
			return "";
		return id.substring(0,id.lastIndexOf(separator));
	}

	/**
	 * Returns the parent ID of the current scope using the scope's separator
	 * @param scope
	 * @return parent ID of the given current scope  or "" of not existent
	 */
	public static String getParentID(NameScope scope){
		return NameScopeUtils.getParentID(scope.toString(), scope.getSeparator());
	}

	/**
	 * Return the last name in the scope.
	 * @return last entry of the vector or TSDefault if no name is in the scope
	 */
	public static TSBaseAPI lastName(NameScope scope){
		if(scope.size()>0)
			return scope.get(scope.size()-1);
		return new TSDefault();
	}
}
