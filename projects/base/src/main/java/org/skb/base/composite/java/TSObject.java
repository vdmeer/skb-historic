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

package org.skb.util.composite.java;

import org.skb.util.composite.TSAtomic;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;

/**
 * A wrapper for the class {@link Object}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSObject extends TSAtomic {
	/** Local value */
	public java.lang.Object tsvalue=null;

	/**
	 * Creates a new empty TSObject.
	 */
	public TSObject(){
		this._init();
	}

	/**
	 * Creates a new TSObject from the specified Object.
	 * 
	 * @param o Object to be used in initialisation
	 */
	public TSObject(java.lang.Object o){
		this._init();
		if(o!=null)
			this.tsvalue=o;
	}

	/**
	 * Creates a new TSObject from the specified TSAtomic.
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSObject(TSAtomicAPI at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=((TSObject)at).tsvalue;
		}
	}

	/**
	 * Creates a new TSObject from the specified TSObject.
	 * 
	 * @param o TSObject to be used in initialisation
	 */
	public TSObject(TSObject o){
		this._init();
		if(o!=null)
			this.tsvalue=o.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_OBJECT);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_OBJECT);
		this.tsvalue=new java.lang.Object();
	}

	public boolean equals(Object obj){
		return this.tsvalue.equals(obj);
	}

	public java.lang.String toString(){
		return this.tsvalue.toString();
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
	public TSObject tsCopyAtomic(){
		return new TSObject(this.tsvalue);
	}
}
