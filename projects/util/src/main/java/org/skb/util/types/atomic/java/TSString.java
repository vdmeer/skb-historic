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

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;

import org.skb.util.dictionaries.Html2LaTeX;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSAtomic;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * A wrapper for java.lang.String.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class TSString implements TSAtomic{
	public static java.lang.String copyValueOf(char[] data){
		return java.lang.String.copyValueOf(data);
	}
	public static java.lang.String copyValueOf(char[] data, int offset, int count){
		return java.lang.String.copyValueOf(data, offset, count);
	}

	public static java.lang.String format(java.lang.String format, Object... args){
		return java.lang.String.format(format, args);
	}

	public static java.lang.String format(Locale l, java.lang.String format, Object... args){
		return java.lang.String.format(l, format, args);
	}

	/**
	 * Returns the specified character if the specified string is non-empty and does not end with the specified character nor a blank; "" otherwise
	 * @param str string to test
	 * @param chr character to test for
	 * @return String
	 */
	public static java.lang.String tsAddChar(TSString str, java.lang.String chr){
		if(str.tsvalue.length()>0&&!str.tsvalue.endsWith(chr)&&!str.tsvalue.endsWith(" "))
			return chr;
		else
			return "";
	}

	/**
	 * Returns a comma if the specified string is non-empty and does not end with a blank nor a comma; "" otherwise
	 * @param str string to test for
	 * @return 
	 * String
	 */
	public static java.lang.String tsAddCharComma(TSString str){
		return TSString.tsAddChar(str, ",");
	}

	public static java.lang.String tsAddCharWBlank(TSString str, java.lang.String chr){
		if (TSString.tsAddChar(str, chr).equals("")){
			java.lang.String ret=TSString.tsAddChar(str, chr);
			ret.concat(" ");
			return ret;
		}
		else
			return "";	
	}

	public static java.lang.String tsAddFirstChar(TSString str, TSString chr){
		if (str.tsvalue.length()==0)
			return chr.tsvalue;
		else
			return "";
	}

	public static java.lang.String valueOf(boolean b){
		return java.lang.String.valueOf(b);
	}

	public static java.lang.String valueOf(char c){
		return java.lang.String.valueOf(c);
	}

	public static java.lang.String valueOf(char[] data){
		return java.lang.String.valueOf(data);
	}

	public static java.lang.String valueOf(char[] data, int offset, int count){
		return java.lang.String.valueOf(data, offset, count);
	}

	public static java.lang.String valueOf(double d){
		return java.lang.String.valueOf(d);
	}

	public static java.lang.String valueOf(float f){
		return java.lang.String.valueOf(f);
	}

	public static java.lang.String valueOf(int i){
		return java.lang.String.valueOf(i);
	}

	public static java.lang.String valueOf(long l){
		return java.lang.String.valueOf(l);
	}

	public static java.lang.String valueOf(Object obj){
		return java.lang.String.valueOf(obj);
	}

	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	public java.lang.String tsvalue;

	/**
	 * Creates a new empty OatString.
	 */
	public TSString(){
		this._init();
	}

	/**
	 * Creates a new TSString from the specified String.
	 * 
	 * @param s String to be used in initialisation
	 */
	public TSString(java.lang.String s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.String(s);
	}

	/**
	 * Creates a new TSString from the specified Object
	 * 
	 * The initialisation is done using s.toString.
	 * @param o Object to be used in initialisation
	 */
	public TSString(Object o){
		this._init();
		if(o!=null)
			this.tsvalue=new java.lang.String(o.toString());
	}

	/**
	 * Creates a new TSString from the specified TSAtomic.
	 * 
	 * If the specified TSAtomic is not of type TSString then s.toString is called for the initialisation.
	 * @param at TSAtomic to be used in initialisation
	 */
	public TSString(TSAtomic at){
		this._init();
		if(at!=null){
			if(at.tsGetTypeEnum()==this.tsGetTypeEnum())
				this.tsvalue=new java.lang.String(((TSString)at).tsvalue);
			else
				this.tsvalue=at.toString();
		}
	}

	/**
	 * Creates a new TSString from the specified TSString.
	 * 
	 * @param s TSString to be used in initialisation
	 */
	public TSString(TSString s){
		this._init();
		if(s!=null)
			this.tsvalue=new java.lang.String(s.tsvalue);
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_JAVA_STRING);
		this.typeEnum.add(TEnum.TS_ATOMIC_JAVA_STRING);
		this.tsvalue=new java.lang.String();
	}

	public char charAt(int index){
		return this.tsvalue.charAt(index);
	}

	public int codePointAt(int index){
		return this.tsvalue.codePointAt(index);
	}

	public int codePointBefore(int index){
		return this.tsvalue.codePointBefore(index);
	}

	public int codePointCount(int beginIndex, int endIndex){
		return this.tsvalue.codePointCount(beginIndex, endIndex);
	}

	public int compareTo(java.lang.String anotherString){
		return this.tsvalue.compareTo(anotherString);
	}

	public int compareToIgnoreCase(java.lang.String str){
		return this.tsvalue.compareToIgnoreCase(str);
	}

	public java.lang.String concat(java.lang.String str){
		return this.tsvalue.concat(str);
	}

	public boolean contains(java.lang.CharSequence s){
		return this.tsvalue.contains(s);
	}

	public boolean contentEquals(java.lang.CharSequence cs){
		return this.tsvalue.contentEquals(cs);
	}

	public boolean contentEquals(java.lang.StringBuffer sb){
		return this.tsvalue.contentEquals(sb);
	}

	public boolean endsWith(java.lang.String suffix){
		return this.tsvalue.endsWith(suffix);
	}

	public boolean equalsIgnoreCase(java.lang.String anotherString){
		return this.tsvalue.equalsIgnoreCase(anotherString);
	}

	public byte[] getBytes(){
		return this.tsvalue.getBytes();
	}

	public byte[] getBytes(java.lang.String charsetName) throws UnsupportedEncodingException{
		try {
			return this.tsvalue.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw(e);
		}
	}

	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin){
		this.tsvalue.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	public int indexOf(int ch){
		return this.tsvalue.indexOf(ch);
	}

	public int indexOf(int ch, int fromIndex){
		return this.tsvalue.indexOf(ch, fromIndex);
	}

	public int indexOf(java.lang.String str){
		return this.tsvalue.indexOf(str);
	}

	public int indexOf(java.lang.String str, int fromIndex){
		return this.tsvalue.indexOf(str, fromIndex);
	}

	public java.lang.String intern(){
		return this.tsvalue.intern();
	}

	public int lastIndexOf(int ch){
		return this.tsvalue.lastIndexOf(ch);
	}

	public int lastIndexOf(int ch, int fromIndex){
		return this.tsvalue.lastIndexOf(ch, fromIndex);
	}

	public int lastIndexOf(java.lang.String str){
		return this.tsvalue.lastIndexOf(str);
	}

	public int lastIndexOf(java.lang.String str, int fromIndex){
		return this.tsvalue.lastIndexOf(str, fromIndex);
	}

	public int length(){
		return this.tsvalue.length();
	}

	public boolean matches(java.lang.String regex){
		return this.tsvalue.matches(regex);
	}

	public int offsetByCodePoints(int index, int codePointOffset){
		return this.tsvalue.offsetByCodePoints(index, codePointOffset);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, java.lang.String other, int ooffset, int len){
		return this.tsvalue.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	public boolean regionMatches(int toffset, java.lang.String other, int ooffset, int len){
		return this.tsvalue.regionMatches(toffset, other, ooffset, len);
	}

	public java.lang.String replace(char oldChar, char newChar){
		return this.tsvalue.replace(oldChar, newChar);
	}

	public java.lang.String replace(CharSequence target, CharSequence replacement){
		return this.tsvalue.replace(target, replacement);
	}

	public java.lang.String replaceAll(java.lang.String regex, java.lang.String replacement){
		return this.tsvalue.replaceAll(regex, replacement);
	}

	public java.lang.String replaceFirst(java.lang.String regex, java.lang.String replacement){
		return this.tsvalue.replaceFirst(regex, replacement);
	}

	public java.lang.String[] split(java.lang.String regex){
		return this.tsvalue.split(regex);
	}

	public java.lang.String[] split(java.lang.String regex, int limit){
		return this.tsvalue.split(regex, limit);
	}

	public boolean startsWith(java.lang.String prefix){
		return this.tsvalue.startsWith(prefix);
	}

	public boolean startsWith(java.lang.String prefix, int toffset){
		return this.tsvalue.startsWith(prefix, toffset);
	}

	public CharSequence subSequence(int beginIndex, int endIndex){
		return this.tsvalue.subSequence(beginIndex, endIndex);
	}

	public java.lang.String substring(int beginIndex){
		return this.tsvalue.substring(beginIndex);
	}

	public java.lang.String substring(int beginIndex, int endIndex){
		return this.tsvalue.substring(beginIndex, endIndex);
	}

	public char[] toCharArray(){
		return this.tsvalue.toCharArray();
	}

	public java.lang.String toLowerCase(){
		return this.tsvalue.toLowerCase();
	}

	public java.lang.String toLowerCase(Locale locale){
		return this.tsvalue.toLowerCase(locale);
	}

	public java.lang.String toString(){
		return this.tsvalue.toString();
	}

	public java.lang.String toUpperCase(){
		return this.tsvalue.toUpperCase();
	}

	public java.lang.String toUpperCase(Locale locale){
		return this.tsvalue.toUpperCase(locale);
	}

	public java.lang.String trim(){
		return this.tsvalue.trim();
	}

	@Override
	public void tsClean(){
		this.tsvalue=new java.lang.String();
	}

	/**
	 * Parses the local String and 'explodes' it into a map or list object, depending on the contents of the String.
	 * 
	 * The String explodes to a map (associative array) if it has the following notation: <code>key1%val1,key2%val2%key3,val3,...</code>
	 * The String explodes to an array list if it has the following notation: <code>string1,string2,string3,...</code>
	 * 
	 * @return TSBase either an TSMapLH (if String explodes to an associated array) or an TSArrayListString (if String explodes to a simple String[]); null otherwise  
	 */
	public TSBase tsExplode() {
		String ts[];
		if(this.tsvalue.length() == 0)
			return null;
		else if (this.tsvalue.contains("%")) {
			TSMapLH ret=new TSMapLH();
			String[] comma=this.tsvalue.split(",");
			for (int i = 0; i < comma.length; i++) {
				comma[i].trim();
				ts = comma[i].split("%");
				if (ts.length == 2)
					ret.put((String)ts[0].trim(), new TSString(ts[1].trim()));
			}
			return ret;
		} else {
			ts=this.tsvalue.split(",");
			TSArrayListString ret = new TSArrayListString();
			for (int i = 0; i < ts.length; i++)
				ret.add(new TSString(ts[i].trim()));
			return ret;
		}
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

	public java.lang.String tsHtml2LaTeX(){
		Html2LaTeX dict=Html2LaTeX.getInstance();
		return dict.translate(this.tsvalue);
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
		//TODO not yet implemented
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
		this.tsvalue=this.tsvalue.trim();
	}
}
