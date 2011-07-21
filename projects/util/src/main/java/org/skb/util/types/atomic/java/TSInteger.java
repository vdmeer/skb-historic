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

package org.skb.util.types.atomic.java;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSAtomic;
import org.skb.util.types.api.TSBase;

/**
 * A wrapper for java.lang.Integer.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class TSInteger implements TSAtomic {
	public static int bitCount(int i){
		return java.lang.Integer.bitCount(i);
	}
	public static Integer decode(java.lang.String nm){
		return java.lang.Integer.decode(nm);
	}

	public static java.lang.Integer getInteger(java.lang.String nm){
		return java.lang.Integer.getInteger(nm);
	}

	public static java.lang.Integer getInteger(java.lang.String nm, int val){
		return java.lang.Integer.getInteger(nm, val);
	}

	public static java.lang.Integer getInteger(java.lang.String nm, Integer val){
		return java.lang.Integer.getInteger(nm, val);
	}

	public static int highestOneBit(int i){
		return java.lang.Integer.highestOneBit(i);
	}

	public static int lowestOneBit(int i){
		return java.lang.Integer.lowestOneBit(i);
	}

	public static int numberOfLeadingZeros(int i){
		return java.lang.Integer.numberOfLeadingZeros(i);
	}

	public static int numberOfTrailingZeros(int i){
		return java.lang.Integer.numberOfTrailingZeros(i);
	}

	public static int parseInt(java.lang.String s){
		return java.lang.Integer.parseInt(s);
	}

	public static int parseInt(java.lang.String s, int radix){
		return java.lang.Integer.parseInt(s, radix);
	}

	public static int reverse(int i){
		return java.lang.Integer.reverse(i);
	}

	public static int reverseBytes(int i){
		return java.lang.Integer.reverseBytes(i);
	}

	public static int rotateLeft(int i, int distance){
		return java.lang.Integer.rotateLeft(i, distance);
	}

	public static int rotateRight(int i, int distance){
		return java.lang.Integer.rotateRight(i, distance);
	}

	public static int signum(int i){
		return java.lang.Integer.signum(i);
	}

	public static java.lang.String toBinaryString(int i){
		return java.lang.Integer.toBinaryString(i);
	}

	public static java.lang.String toHexString(int i){
		return java.lang.Integer.toHexString(i);
	}

	public static java.lang.String toOctalString(int i){
		return java.lang.Integer.toOctalString(i);
	}

	public static java.lang.String toString(int i){
		return java.lang.Integer.toString(i);
	}

	public static java.lang.String toString(int i, int radix){
		return java.lang.Integer.toString(i, radix);
	}

	public static java.lang.Integer valueOf(int i){
		return java.lang.Integer.valueOf(i);
	}

	public static java.lang.Integer valueOf(java.lang.String s){
		return java.lang.Integer.valueOf(s);
	}

	public static java.lang.Integer valueOf(java.lang.String s, int radix){
		return java.lang.Integer.valueOf(s, radix);
	}

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	public java.lang.Integer tsvalue=null;

	/**
	 * Creates a new empty TSInteger.
	 */
	public TSInteger(){
		this._init();
	}

	/**
	 * Creates a new TSInteger from the specified int
	 * 
	 * @param i int to be used in initialisation
	 */
	public TSInteger(int i){
		this._init();
		this.tsvalue=new java.lang.Integer(i);
	}

	/**
	 * Creates a new TSInteger from the specified Integer
	 * 
	 * @param i Integer to be used in initialisation
	 */
	public TSInteger(java.lang.Integer i){
		this._init();
		if(i!=null)
			this.tsvalue=new java.lang.Integer(i);
	}

	/**
	 * Creates a new TSInteger from the specified String
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSInteger(java.lang.String s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Integer(s);
	}

	/**
	 * Creates a new TSInteger from the specified TSAtomic
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSInteger(TSAtomic at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Integer(((TSInteger)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Integer(((TSString)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSInteger from the specified TSInteger
	 * 
	 * @param i TSInteger to be used in initialisation
	 */
	public TSInteger(TSInteger i){
		this._init();
		if(i!=null)
			this.tsvalue=i.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_BOOLEAN);
		this.tsvalue=new java.lang.Integer(0);
	}

	public byte byteValue(){
		return this.tsvalue.byteValue();
	}

	public int compareTo(Integer anotherInteger){
		return this.tsvalue.compareTo(anotherInteger);
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
	public void tsClean(){
		this.tsvalue=new java.lang.Integer(0);
	}

	@Override
	public final TEnum tsGetTypeEnum(){
		return TSRepository.type(this.typeString.lastElement());
	}

	@Override
	public final Set<TEnum> tsGetTypeEnumSet(){
		return this.typeEnum;
	}

	@Override
	public final java.lang.String tsGetTypeString(){
		return this.typeString.lastElement();
	}

	@Override
	public final List<String> tsGetTypeStringList(){
		return this.typeString;
	}

	@Override
	public boolean tsIsAtomic(){
		return true;
	}

	@Override
	public boolean tsIsComposite(){
		return false;
	}

	@Override
	public final boolean tsIsType(String t){
		return this.typeString.contains(t);
	}

	@Override
	public final boolean tsIsType(TEnum t){
		return this.typeEnum.contains(t);
	}

	@Override
	public void tsPlus(TSBase tb){
		if(tb.tsGetTypeEnum()==this.tsGetTypeEnum())
			this.tsvalue=this.tsvalue+((TSInteger)tb).tsvalue;
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
	public void tsTrim(){
		//TODO not yet implemented
	}
}
