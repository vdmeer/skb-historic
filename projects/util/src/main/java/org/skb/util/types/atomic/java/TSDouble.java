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
 * A wrapper for java.lang.Double.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSDouble implements TSAtomic {
	public static int compare(double d1, double d2){
		return java.lang.Double.compare(d1, d2);
	}
	public static long doubleToLongBits(double value){
		return java.lang.Double.doubleToLongBits(value);
	}

	public static long doubleToRawLongBits(double value){
		return java.lang.Double.doubleToRawLongBits(value);
	}

	public static boolean isInfinite(double v){
		return java.lang.Double.isInfinite(v);
	}

	public static boolean isNaN(double v){
		return java.lang.Double.isNaN(v);
	}

	public static double longBitsToDouble(long bits){
		return java.lang.Double.longBitsToDouble(bits);
	}

	public static double parseDouble(java.lang.String s){
		return java.lang.Double.parseDouble(s);
	}

	public static java.lang.String toHexString(double d){
		return java.lang.Double.toHexString(d);
	}

	public static java.lang.String toString(double d){
		return java.lang.Double.toHexString(d);
	}

	public static java.lang.Double valueOf(double d){
		return java.lang.Double.valueOf(d);
	}

	public static java.lang.Double valueOf(java.lang.String s){
		return java.lang.Double.valueOf(s);
	}

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	public java.lang.Double tsvalue=null;

	/**
	 * Creates a new empty TSDouble.
	 */
	public TSDouble(){
		super();
		this._init();
	}

	/**
	 * Creates a new TSDouble from the specified double
	 * 
	 * @param d double to be used in initialisation
	 */
	public TSDouble(double d){
		super();
		this._init();
		this.tsvalue=new java.lang.Double(d);
	}

	/**
	 * Creates a new TSDouble from the specified Double
	 * 
	 * @param d Double to be used in initialisation
	 */
	public TSDouble(Double d){
		super();
		this._init();
		this.tsvalue=new java.lang.Double(d);
	}

	/**
	 * Creates a new TSDouble from the specified String
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSDouble(java.lang.String s){
		super();
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.Double(s);
	}

	/**
	 * Creates a new TSDouble from the specified TSAtomic
	 * 
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSDouble(TSAtomic at){
		super();
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.Double(((TSDouble)at).tsvalue);
			if(at.tsGetTypeEnum()==TEnum.TS_ATOMIC_JAVA_STRING)
				this.tsvalue=new java.lang.Double(((TSString)at).tsvalue);
		}
	}

	/**
	 * Creates a new TSDouble from the specified TSDouble
	 * 
	 * @param d TSDouble to be used in initialisation
	 */
	public TSDouble(TSDouble d){
		super();
		this._init();
		if(d!=null)
			this.tsvalue=d.tsvalue;
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_DOUBLE);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_DOUBLE);
		this.tsvalue=new java.lang.Double(0);
	}

	public byte byteValue(){
		return this.tsvalue.byteValue();
	}

	public int compareTo(java.lang.Double anotherDouble){
		return this.tsvalue.compareTo(anotherDouble);
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
		this.tsvalue=new java.lang.Double(0);
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
			this.tsvalue=this.tsvalue+((TSDouble)tb).tsvalue;
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
