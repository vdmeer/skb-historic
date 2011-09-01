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
 * A wrapper for java.lang.Float.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSFloat implements TSAtomic {
	public static int compare(float f1, float f2){
		return java.lang.Float.compare(f1, f2);
	}
	public static int floatToIntBits(float value){
		return java.lang.Float.floatToIntBits(value);
	}

	public static int floatToRawIntBits(float value){
		return java.lang.Float.floatToRawIntBits(value);
	}

	public static float intBitsToFloat(int bits){
		return java.lang.Float.intBitsToFloat(bits);
	}

	public static boolean isInfinite(float v){
		return java.lang.Float.isInfinite(v);
	}

	public static boolean isNaN(float v){
		return java.lang.Float.isNaN(v);
	}

	public static float parseFloat(java.lang.String s){
		return java.lang.Float.parseFloat(s);
	}

	public static java.lang.String toHexString(float f){
		return java.lang.Float.toHexString(f);
	}

	public static java.lang.String toString(float f){
		return java.lang.Float.toHexString(f);
	}

	public static java.lang.Float valueOf(float f){
		return java.lang.Float.valueOf(f);
	}

	public static java.lang.Float valueOf(java.lang.String s){
		return java.lang.Float.valueOf(s);
	}

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	public Float tsvalue=null;

	/**
	 * Creates a new empty TSFloat.
	 */
	public TSFloat(){
		this._init();
	}

	/**
	 * Creates a new TSFloat from the specified float
	 * 
	 * @param f float to be used in initialisation
	 */
	public TSFloat(float f){
		this._init();
		this.tsvalue=new java.lang.Float(f);
	}

	/**
	 * Creates a new TSFloat from the specified Float
	 * 
	 * @param f Float to be used in initialisation
	 */
	public TSFloat(java.lang.Float f){
		this._init();
		if(f!=null)
			this.tsvalue=new java.lang.Float(f);
	}

	/**
	 * Creates a new TSFloat from the specified double
	 * 
	 * @param d double to be used in initialisation
	 */
	public TSFloat(double d){
		this._init();
		this.tsvalue=new java.lang.Float(d);
	}

	/**
	 * Creates a new TSFloat from the specified Double
	 * 
	 * @param d Double to be used in initialisation
	 */
	public TSFloat(java.lang.Double d){
		this._init();
		if(d!=null)
			this.tsvalue=new java.lang.Float(d);
	}

	/**
	 * Creates a new TSFloat from the specified String
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSFloat(java.lang.String s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Float(s);
	}

	/**
	 * Creates a new TSFloat from the specified TSAtomic
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSFloat(TSAtomic at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Float(((TSFloat)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Float(((TSString)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_DOUBLE)
				this.tsvalue=new java.lang.Float(((TSDouble)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSFloat from the specified TSDouble
	 * 
	 * @param d TSDouble to be used in initialisation
	 */
	public TSFloat(TSDouble d) {
		this._init();
		if(d!=null)
			this.tsvalue=new Float(d.tsvalue);
	}

	/**
	 * Creates a new TSFloat from the specified TSFloat
	 * 
	 * @param f TSFloat to be used in initialisation
	 */
	public TSFloat(TSFloat f){
		this._init();
		if(f!=null)
			this.tsvalue=f.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_FLOAT);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_FLOAT);
		this.tsvalue=new java.lang.Float(0);
	}

	public byte byteValue(){
		return this.tsvalue.byteValue();
	}

	public int compareTo(java.lang.Float anotherFloat){
		return this.tsvalue.compareTo(anotherFloat);
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

	public boolean isInfinite(){
		return this.tsvalue.isInfinite();
	}

	public boolean isNaN(){
		return this.tsvalue.isNaN();
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
		this.tsvalue=new java.lang.Float(0);
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
			this.tsvalue=this.tsvalue+((TSFloat)tb).tsvalue;

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
