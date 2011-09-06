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

package org.skb.util.languages;

import java.util.Vector;

import org.antlr.runtime.Token;

/**
 * Provides functionality for a scoped name based on a vector of strings.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ScopeString {
	/**
	 * The currently used scope separator, default is "::".
	 */
	private String separator;

	/**
	 * The string vector maintaining the scope.
	 */
	private Vector<String> field;

	/**
	 * Class constructor, initialises private members
	 */
	public ScopeString(){
		this.separator="::";
		this.field=new Vector<String>();
	}

	/**
	 * Sets the scope separator to the given string.
	 * @param s new scope separator.
	 */
	public void separator(String s){
		this.separator=s;
	}

	/**
	 * Returns the currently used scope separator.
	 * @return scope separator currently used.
	 */
	public String separator(){
		return this.separator;
	}

	/**
	 * Returns the current scope as string.
	 */
	public String toString(){
		String ret="";
		for (int i = 0; i < this.field.size(); i++)
			ret+=this.field.get(i)+this.separator;
	    if(ret!="")
	    	ret=ret.substring(0, ret.lastIndexOf(this.separator));
		return ret;
	}

	/**
	 * Removes the last entry of the vector, i.e. the last part of the scope
	 */
	public void pop(){
		if(this.field.size()>0)
			this.field.remove(this.field.size()-1);
	}

	/**
	 * Adds a new scope, i.e. append the given token to the vector.
	 */
	public void push(Token token){
		this.field.add(token.getText());
	}

	/**
	 * Clears the vector, empty the scope.
	 */
	public void clear(){
		this.field.clear();
	}

	/**
	 * Returns the last entry of the vector.
	 * @return last entry of the vector
	 */
	public String lastElement(){
		return this.field.lastElement();
	}
}
