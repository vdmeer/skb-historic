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

import java.util.ArrayList;
import java.util.Vector;

import org.antlr.runtime.Token;

/**
 * Provides functionality for a scoped name based on a vector of ANTLR runtime tokens.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class ScopeToken {
	/**
	 * The currently used scope separator, default is "::".
	 */
	private String separator;
	/**
	 * The ANTLR runtime token vector maintaining the scope.
	 */
	private Vector<Token> field;

	public ScopeToken(){
		this.separator="::";
		this.field=new Vector<Token>();
	}

	/**
	 * Set the scope separator to the given string.
	 * @param s new scope separator.
	 */
	public void separator(String s){
		this.separator=s;
	}

	/**
	 * Return the currently used scope separator.
	 * @return scope separator currently used.
	 */
	public String separator(){
		return this.separator;
	}

	/**
	 * Return the current scope as string.
	 */
	public String toString(){
		String ret="";
		for (int i = 0; i < this.field.size(); i++)
			ret+=this.field.get(i).getText()+this.separator;
	    if(ret!="")
	    	ret=ret.substring(0, ret.lastIndexOf(this.separator));
		return ret;
	}

	/**
	 * Remove the last entry of the vector, i.e. the last part of the scope
	 */
	public void pop(){
		if(this.field.size()>0)
			this.field.remove(this.field.size()-1);
	}

	/**
	 * Add a new scope, i.e. append the given token to the vector.
	 */
	public void push(Token token){
		this.field.add(token);
	}

	/**
	 * Clear the vector, empty the scope.
	 */
	public void clear(){
		this.field.clear();
	}

	/**
	 * Return the last entry of the vector.
	 * @return last entry of the vector
	 */
	public Token lastElement(){
		return this.field.lastElement();
	}

	/**
	 * Return the ANTLR token of the given index.
	 * @param index index of the vector
	 * @return ANTLR token at the given index
	 */
	public Token get(int index){
		return this.field.get(index);
	}

	/**
	 * Return the size of the vector.
	 * @return the size of the vector
	 */
	public int size(){
		return this.field.size();
	}

	/**
	 * Return the vector as an array list of tokens.
	 * @return the array list form of the vector
	 */
	public ArrayList<Token> getList(){
		return new ArrayList<Token>(this.field);
	}
}
