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

package org.skb.base.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utilities for processing java strings.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class StringUtils {

	/**
	 * Returns true if the given string equals any of the strings in the given list.
	 * @param s string to test
	 * @param list list of strings to test
	 * @return true if the given string equals any of the strings in the given list, false otherwise
	 */
	public static Boolean equalsAny(String s, List<String> list){
		if(list.contains(s))
			return true;
//		for(int i=0;i<list.size();i++){
//			if(s.equals(list.get(i)))
//				return true;
//		}
		return false;
	}

	/**
	 * Returns true if the given string equals any of the strings in the given array.
	 * @param s string to test
	 * @param array array of strings to test
	 * @return true if the given string equals any of the strings in the given array, false otherwise
	 */
	public static Boolean equalsAny(String s, String[] array){
		return StringUtils.equalsAny(s, Arrays.asList(array));
//		for(int i=0;i<array.length;i++){
//			if(s.equals(array[i]))
//				return true;
//		}
//		return false;
	}

	/**
	 * Returns true if the given string does not equal any of the strings in the given list.
	 * @param s string to test
	 * @param list list of strings to test
	 * @return true if the given string equals none of the strings in the given list, false otherwise
	 */
	public static Boolean equalsNone(String s, ArrayList<String> list){
		return !StringUtils.equalsAny(s, list);
	}

	/**
	 * Returns true if the given string does not equal any of the strings in the given array.
	 * @param s string to test
	 * @param array array of strings to test
	 * @return true if the given string equals none of the strings in the given array, false otherwise
	 */
	public static Boolean equalsNone(String s, String[] array){
		return !StringUtils.equalsAny(s, array);
	}
}
