/* Copyright (c) 2010-2011 Sven van der Meer
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

package org.skb.types.atomic.java;

import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.base.OatBase;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.composite.util.OatMapLH;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.util.dictionaries.Html2LaTeX;

/**
 * A wrapper for java.lang.String.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatString extends OatBaseAtomic {
	public String oatValue=null;

	/**
	 * Creates a new OatString with oatValue=null.
	 */
	public OatString() {
		super();
		this.init();
	}

	/**
	 * Creates a new OatString from the specified OatString.
	 * 
	 * The default oatValue is null.
	 * @param s OatString to be used in initialisation
	 */
	public OatString(OatString s) {
		super();
		this.init();
		try{
			this.oatValue=new String(s.getValue());
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatString from the specified String.
	 * 
	 * The default oatValue is null.
	 * @param s String to be used in initialisation
	 */
	public OatString(String s) {
		super();
		this.init();
		try{
			this.oatValue=new String(s);
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatString from the specified Object
	 * 
	 * The initialisation is done using s.toString. The default oatValue is null.
	 * @param o Object to be used in initialisation
	 */
	public OatString(Object o) {
		super();
		this.init();
		try{
			this.oatValue=new String(o.toString());
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatString from the specified OatBaseAtomic.
	 * 
	 * If the specified OatBaseAtomic is not of type OatString then s.toString is called for the initialisation. The default oatValue is null.
	 * @param oba OatBaseAtomic to be used in initialisation
	 */
	public OatString(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=new String(((OatString)oba).getValue());
			else
				this.oatValue=new String(oba.toString());
		} catch (Exception e) {}
	}

	/**
	 * Returns the oatValue object.
	 * @return String The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public String getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	public void setValue(String s){
		this.oatValue=s;
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_STRING);
		this.typeEnum.add(ATType.OAT_ATOMIC_STRING);
	}

	/**
	 * Parses the local String and 'explodes' it into a map or list object, depending on the contents of the String.
	 * 
	 * The String explodes to a map (associative array) if it has the following notation: <code>key1%val1,key2%val2%key3,val3,...</code>
	 * The String explodes to an array list if it has the following notation: <code>string1,string2,string3,...</code>
	 * 
	 * @return OatBase either an OatMapLH (if String explodes to an associated array) or an OatArrayListString (if String explodes to a simple String[]); null otherwise  
	 */
	public OatBase explode() {
		String ts[];
		if(this.oatValue.length() == 0)
			return null;
		else if (this.oatValue.contains("%")) {
			OatMapLH ret=new OatMapLH();
			String[] comma=this.oatValue.split(",");
			for (int i = 0; i < comma.length; i++) {
				comma[i].trim();
				ts = comma[i].split("%");
				if (ts.length == 2)
					ret.put((String)ts[0].trim(), new OatString(ts[1].trim()));
			}
			return ret;
		} else {
			ts=this.oatValue.split(",");
			OatArrayListString ret = new OatArrayListString();
			for (int i = 0; i < ts.length; i++)
				ret.add(new OatString(ts[i].trim()));
			return ret;
		}
	}

	/**
	 * Returns a comma if the specified string is non-empty and does not end with a blank nor a comma; "" otherwise
	 * @param str string to test for
	 * @return OatString
	 * @throws OatValueIsNullException
	 */
	public static String add_char_comma(OatString str) throws OatValueIsNullException{
		try {
			return OatString.add_char(str, ",");
		} catch (OatValueIsNullException e) {
			throw new OatValueIsNullException(ATType.OAT_ATOMIC_STRING);
		}
	}

	/**
	 * Returns the specified character if the specified string is non-empty and does not end with the specified character nor a blank; "" otherwise
	 * @param str string to test
	 * @param chr character to test for
	 * @return OatString
	 * @throws OatValueIsNullException
	 */
	public static String add_char(OatString str, String chr) throws OatValueIsNullException{
		try{
			if(str.oatValue.length()>0&&!str.oatValue.endsWith(chr)&&!str.oatValue.endsWith(" "))
				return chr;
			else
				return "";
		} catch (Exception e){
			throw new OatValueIsNullException(ATType.OAT_ATOMIC_STRING);
		}
	}

	public static String add_char_with_blank(OatString str, String chr) throws OatValueIsNullException{
		try{
			if (OatString.add_char(str, chr).equals("")){
				String ret=OatString.add_char(str, chr);
				ret.concat(" ");
				return ret;
			}
			else
				return "";	
		} catch (Exception e){
			throw new OatValueIsNullException(ATType.OAT_ATOMIC_STRING);
		}
	}

	public static String add_first_char(OatString str, OatString chr) throws OatValueIsNullException{
		try{
			if (str.oatValue.length()==0)
				return chr.getValue();
			else
				return "";
		} catch (Exception e){
			throw new OatValueIsNullException(ATType.OAT_ATOMIC_STRING);
		}
	}

	public String h2l(){
		Html2LaTeX dict=Html2LaTeX.getInstance();
		return dict.translate(this.oatValue);
	}

	public void trim(){
		this.oatValue.trim();
	}

	public OatString getValOatAtomicString(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
