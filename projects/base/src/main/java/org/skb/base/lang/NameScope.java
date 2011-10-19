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

package org.skb.base.lang;

import java.util.ArrayList;
import java.util.Vector;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.base.composite.TSAtomic;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSComposite;
import org.skb.base.composite.TSDefault;
import org.skb.base.composite.antlr.TSToken;
import org.skb.base.composite.java.TSString;

/**
 * Implementation of a named scope using Strings and ANTLR Tokens.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class NameScope {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(NameScope.class);

	/** The currently used scope separator, default is "::". */
	private String separator;

	/** The ANTLR runtime token vector maintaining the scope. */
	private Vector<TSBaseAPI> vector;

	/**
	 * Class constructor, initialises members.
	 */
	public NameScope(){
		this.separator="::";
		this.vector=new Vector<TSBaseAPI>();
	}

	public NameScope(NameScope ns){
		this.separator=ns.getSeparator();
		this.vector=ns.getVector();
	}

	/**
	 * Clear the vector, empty the scope.
	 */
	public void clear(){
		this.vector.clear();
	}

	/**
	 * Returns the currently used scope separator.
	 * @return scope separator currently used.
	 */
	public String getSeparator(){
		return this.separator;
	}

	/**
	 * Sets the scope separator to the given string.
	 * @param sep new scope separator.
	 */
	public void setSeparator(String sep){
		if(sep!=null)
			this.separator=sep;
	}

	/**
	 * Returns the current scope as string.
	 */
	public String toString(){
		String ret="";
		for (int i = 0; i < this.vector.size(); i++)
			ret+=this.vector.get(i).toString()+this.separator;
	    if(ret!="")
	    	ret=ret.substring(0, ret.lastIndexOf(this.separator));
		return ret;
	}

	/**
	 * Adds a new name to the scope.
	 * @param name
	 */
	public void push(Token name){
		if(name!=null)
			this.vector.add(new TSToken(name));
	}

	/**
	 * Adds a new name to the scope.
	 * @param name
	 */
	public void push(TSToken name){
		if(name!=null)
			this.vector.add(name);
	}

	/**
	 * Adds a new name to the scope.
	 * @param name
	 */
	public void push(String name){
		if(name!=null)
			this.vector.add(new TSString(name));
	}

	/**
	 * Adds a new name to the scope.
	 * @param name
	 */
	public void push(TSString name){
		if(name!=null)
			this.vector.add(name);
	}

	/**
	 * Returns the number of names currently in the scope
	 * @return number of names
	 */
	public int size(){
		return this.vector.size();
	}

	/**
	 * Removes the last entry in the scope.
	 */
	public void pop(){
		if(this.vector.size()>0)
			this.vector.remove(this.vector.size()-1);
	}

	/**
	 * Return the scope as an array list
	 * @return the array list form of the scope
	 */
	public ArrayList<TSBaseAPI> getList(){
		return new ArrayList<TSBaseAPI>(this.vector);
	}

	/**
	 * Return the scope as a vector
	 * @return the array list form of the scope
	 */
	public Vector<TSBaseAPI> getVector(){
		Vector<TSBaseAPI> ret=new Vector<TSBaseAPI>();
		for(int i=0;i<this.vector.size();i++){
			TSBaseAPI b=this.vector.get(i);
			if(b.tsIsAtomic())
				ret.add(((TSAtomic)this.vector.get(i)).tsCopyAtomic());
			else
				ret.add(((TSComposite)this.vector.get(i)).tsCopyComposite());
		}
		return ret;
	}

	/**
	 * Return the name of the given index.
	 * @param index index of the vector
	 * @return name at the given index or TSDefault if index out of bounds
	 */
	public TSBaseAPI get(int index){
		if(index<=this.vector.size())
			return this.vector.get(index);
		return new TSDefault();
	}
}
