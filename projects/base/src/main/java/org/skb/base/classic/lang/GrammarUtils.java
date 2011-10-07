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

package org.skb.base.classic.lang;

import org.antlr.runtime.Token;

/**
 * Utilities that help processing ANTLR grammars.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class GrammarUtils {

	/**
	 * Tests if the given type of a value is the same as a given base type.
	 * 
	 * A typical situation is that the type of a declaration (String s) needs to be tested with the type of the
	 * definition (s="string"). 
	 * @param baseType base type to test against
	 * @param constValue constant value with type information to test for, first child in the tree should be the type
	 * @return true if equal, false otherwise or if any of the two parameters is null
	 */
	public static boolean testBasetypeAndConstvalue(Token baseType, org.antlr.runtime.tree.Tree constValue){
		if(baseType==null||constValue==null)
			return false;
		return baseType.getText().toLowerCase().equals(constValue.getChild(0).toString().toLowerCase());
	}

	/**
	 * Tests if the given type of a value is the same as a given base type.
	 * 
	 * A typical situation is that the type of a declaration (String s) needs to be tested with the type of the
	 * definition (s="string"). 
	 * @param baseType base type to test against
	 * @param constValue constant value with type information to test for
	 * @return true if equal, false otherwise or if any of the two parameters is null
	 */
	public static boolean testBasetypeAndConstvalue(Token baseType, Token constValue){
		if(baseType==null||constValue==null)
			return false;
		return baseType.getText().toLowerCase().equals(constValue.getText().toLowerCase());
	}
}
