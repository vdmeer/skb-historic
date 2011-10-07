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
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSRepository.TEnum;

/**
 * A wrapper for the class {@link Short}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSShort extends TSAtomic {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSShort.class);

	public static java.lang.Short decode(java.lang.String nm){
		return java.lang.Short.decode(nm);
	}
	public static short parseShort(java.lang.String s){
		return java.lang.Short.parseShort(s);
	}

	public static short parseShort(java.lang.String s, int radix){
		return java.lang.Short.parseShort(s, radix);
	}

	public static short reverseBytes(short i){
		return java.lang.Short.reverseBytes(i);
	}

	public static java.lang.String toString(short s){
		return java.lang.Short.toString(s);
	}

	public static java.lang.Short valueOf(java.lang.String s){
		return java.lang.Short.valueOf(s);
	}

	public static java.lang.Short valueOf(java.lang.String s, int radix){
		return java.lang.Short.valueOf(s, radix);
	}

	public static java.lang.Short valueOf(short s){
		return java.lang.Short.valueOf(s);
	}

	/** Local value */
	public java.lang.Short tsvalue;

	/**
	 * Creates a new empty TSShort.
	 */
	public TSShort(){
		this._init();
	}

	/**
	 * Creates a new TSShort from the specified Short
	 * 
	 * @param s Short to be used in initialisation
	 */
	public TSShort(java.lang.Short s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Short(s);
	}

	/**
	 * Creates a new TSShort from the specified String
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSShort(java.lang.String s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Short(s);
	}

	/**
	 * Creates a new TSShort from the specified short
	 * 
	 * @param s short to be used in initialisation
	 */
	public TSShort(short s){
		this._init();
		this.tsvalue=new java.lang.Short(s);
	}

	/**
	 * Creates a new TSShort from the specified TSAtomic
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSShort(TSAtomicAPI at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Short(((TSShort)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Short(((TSString)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSShort from the specified TSShort.
	 * 
	 * @param s TSShort to be used in initialisation
	 */
	public TSShort(TSShort s){
		this._init();
		if(s!=null)
			this.tsvalue=s.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_SHORT);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_SHORT);
		this.tsvalue=new java.lang.Short((short) 0);
	}

	public byte byteValue(){
		return this.tsvalue.byteValue();
	}

	public int compareTo(java.lang.Short anotherShort){
		return this.tsvalue.compareTo(anotherShort);
	}

	public double doubleValue(){
		return this.tsvalue.doubleValue();
	}

	public float floatValue(){
		return this.tsvalue.floatValue();
	}

	public int intValue(){
		return this.tsvalue.intValue();
	}

	public long longValue(){
		return this.tsvalue.longValue();
	}

	public short shortValue(){
		return this.tsvalue.shortValue();
	}

	public java.lang.String toString(){
		return this.tsvalue.toString();
	}

	@Override
	public void tsPlus(TSBaseAPI tb){
		if(tb.tsGetTypeEnum()==this.tsGetTypeEnum())
			this.tsvalue=(short) (this.tsvalue+((TSShort)tb).tsvalue);
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
	public TSShort tsCopyAtomic(){
		return new TSShort(new Short(this.tsvalue));
	}
}
