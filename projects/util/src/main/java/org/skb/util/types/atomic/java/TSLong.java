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

public class TSLong implements TSAtomic {
	public static int bitCount(long i){
		return java.lang.Long.bitCount(i);
	}
	public static java.lang.Long decode(java.lang.String nm){
		return java.lang.Long.decode(nm);
	}

	public static java.lang.Long getLong(java.lang.String nm){
		return java.lang.Long.getLong(nm);
	}

	public static java.lang.Long getLong(java.lang.String nm, java.lang.Long val){
		return java.lang.Long.getLong(nm, val);
	}

	public static java.lang.Long getLong(java.lang.String nm, long val){
		return java.lang.Long.getLong(nm, val);
	}

	public static long highestOneBit(long i){
		return java.lang.Long.highestOneBit(i);
	}

	public static long lowestOneBit(long i){
		return java.lang.Long.lowestOneBit(i);
	}

	public static int numberOfLeadingZeros(long i){
		return java.lang.Long.numberOfLeadingZeros(i);
	}

	public static int numberOfTrailingZeros(long i){
		return java.lang.Long.numberOfTrailingZeros(i);
	}

	public static long parseLong(java.lang.String s){
		return java.lang.Long.parseLong(s);
	}

	public static long parseLong(java.lang.String s, int radix){
		return java.lang.Long.parseLong(s, radix);
	}

	public static long reverse(long i){
		return java.lang.Long.reverse(i);
	}

	public static long reverseBytes(long i){
		return java.lang.Long.reverseBytes(i);
	}

	public static long rotateLeft(long i, int distance){
		return java.lang.Long.rotateLeft(i, distance);
	}

	public static long rotateRight(long i, int distance){
		return java.lang.Long.rotateRight(i, distance);
	}

	public static int signum(long i){
		return java.lang.Long.signum(i);
	}

	public static java.lang.String toBinaryString(long i){
		return Long.toBinaryString(i);
	}

	public static java.lang.String toHexString(long i){
		return java.lang.Long.toHexString(i);
	}

	public static java.lang.String toOctalString(long i){
		return java.lang.Long.toOctalString(i);
	}

	public static java.lang.String toString(long i){
		return java.lang.Long.toString(i);
	}

	public static java.lang.String toString(long i, int radix){
		return java.lang.Long.toString(i, radix);
	}

	public static java.lang.Long valueOf(java.lang.String s){
		return java.lang.Long.valueOf(s);
	}

	public static java.lang.Long valueOf(java.lang.String s, int radix){
		return java.lang.Long.valueOf(s, radix);
	}

	public static java.lang.Long valueOf(long l){
		return java.lang.Long.valueOf(l);
	}

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	public java.lang.Long tsvalue=null;

	/**
	 * Creates a new empty TSLong.
	 */
	public TSLong(){
		super();
		this._init();
	}

	/**
	 * Creates a new TSLong from the specified Long.
	 * 
	 * @param l Long to be used in initialisation
	 */
	public TSLong(java.lang.Long l){
		super();
		this._init();
		if(l!=null)
			this.tsvalue=new java.lang.Long(l);
	}

	/**
	 * Creates a new TSLong from the specified String.
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSLong(java.lang.String s){
		super();
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Long(s);
	}

	/**
	 * Creates a new TSLong from the specified long.
	 * 
	 * @param l long to be used in initialisation
	 */
	public TSLong(long l){
		super();
		this._init();
		this.tsvalue=new java.lang.Long(l);
	}

	/**
	 * Creates a new TSLong from the specified TSAtomic.
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSLong(TSAtomic at){
		super();
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Long(((TSLong)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Long(((TSString)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSLong from the specified TSLong.
	 * 
	 * @param l TSLong to be used in initialisation
	 */
	public TSLong(TSLong l){
		super();
		this._init();
		if(l!=null)
			this.tsvalue=l.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_BOOLEAN);
		this.tsvalue=new java.lang.Long(0);
	}

	public byte byteValue(){
		return this.tsvalue.byteValue();
	}

	public int compareTo(java.lang.Long anotherLong){
		return this.tsvalue.compareTo(anotherLong);
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
	public void tsClean() {
		this.tsvalue=new java.lang.Long(0);
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
	public void tsPlus(TSBase tb) {
		if(tb.tsGetTypeEnum()==this.tsGetTypeEnum())
			this.tsvalue=this.tsvalue+((TSLong)tb).tsvalue;
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
	public void tsTrim() {
		//TODO not yet implemented
	}
}
