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

package org.skb.base.composite.java;

import org.apache.log4j.Logger;
import org.skb.base.composite.TSAtomic;
import org.skb.base.composite.TSAtomicAPI;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSRepository.TEnum;

/**
 * A wrapper for the class {@link Boolean}.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSBoolean extends TSAtomic {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSBoolean.class);

	static boolean getBoolean(java.lang.String name){
		return java.lang.Boolean.getBoolean(name);
	}

	static boolean parseBoolean(java.lang.String s){
		return java.lang.Boolean.parseBoolean(s);
	}

	static java.lang.String toString(boolean b){
		return java.lang.Boolean.toString(b);
	}

	static java.lang.Boolean valueOf(boolean b){
		return java.lang.Boolean.valueOf(b);
	}

	static java.lang.Boolean valueOf(java.lang.String s){ 
		return java.lang.Boolean.valueOf(s);
	}

	/** Local value */
	public java.lang.Boolean tsvalue=null;

	/**
	 * Creates a new OatBoolean with oatValue=null.
	 */
	public TSBoolean(){
		this._init();
	}

	/**
	 * Creates a new TSBoolean from the specified boolean
	 * 
	 * @param b boolean to be used in initialisation
	 */
	public TSBoolean(boolean b){
		this._init();
		this.tsvalue=new java.lang.Boolean(b);
	}

	/**
	 * Creates a new TSBoolean from the specified Boolean
	 * 
	 * The default oatValue is null.
	 * @param b Boolean to be used in initialisation
	 */
	public TSBoolean(java.lang.Boolean b){
		this._init();
		if(b!=null)
			this.tsvalue=new java.lang.Boolean(b);
	}

	public TSBoolean(java.lang.String s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Boolean(s);
	}

	/**
	 * Creates a new TSBoolean from the specified TSAtomic
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSBoolean(TSAtomicAPI at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Boolean(((TSBoolean)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Boolean(((TSString)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSBoolean from the specified TSBoolean
	 * 
	 * @param b TSBoolean to be used in initialisation
	 */
	public TSBoolean(TSBoolean b){
		this._init();
		if(b!=null)
			this.tsvalue=b.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_BOOLEAN);
		this.tsvalue=new java.lang.Boolean(null);
	}

	boolean booleanValue(){
		return this.tsvalue.booleanValue();
	}

	public int compareTo(java.lang.Boolean b){
		return this.tsvalue.compareTo(b);
	}

	@Override
	public void tsClean(){
		this.tsvalue=new java.lang.Boolean(null);
	}

	@Override
	public java.lang.String tsToString(int indent){
		String ret=new String();
		for(int i=indent;i>0;i--)
			ret+=" ";
		ret+=this.tsvalue.toString();
		return ret;
	}

	@Override
	public TSBoolean tsCopyAtomic(){
		return new TSBoolean(new Boolean(this.tsvalue));
	}

	@Override
	public String toString(){
		return this.tsToString(0);
	}
}
