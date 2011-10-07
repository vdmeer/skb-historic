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

package org.skb.util.classic.misc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Collection of methods the help to format ASCII output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class AsciiFormatter {
	/**
	 * Creates a top rule for a table.
	 * @param length length of the line
	 * @return top rule
	 */
	public static String topRule(int length){
		return AsciiFormatter.tsFill("+", '=', length-2)+"+"+"\n";
	}

	/**
	 * Creates a mid rule for a table.
	 * @param length length of the line
	 * @return mid rule
	 */
	public static String midRule(int length){
		return AsciiFormatter.tsFill("+", '-', length-2)+"+"+"\n";
	}

	/**
	 * Returns the given string centred.
	 * @param str string to be centred
	 * @param max maximum characters in the line
	 * @return string centred in the line
	 */
	public static String center(String str, int max){
		boolean even=(max-str.length())%2==0;
		if(even)
			return AsciiFormatter.tsFill("", ' ', (max-str.length())/2)+str+AsciiFormatter.tsFill("", ' ', (max-str.length())/2);
			return AsciiFormatter.tsFill("", ' ', (max-str.length()-1)/2)+str+AsciiFormatter.tsFill("", ' ', (max-str.length()+1)/2);
	}

	/**
	 * Returns a table consisting of two rows with an optional centred header row and an optional heading for each row.
	 * @param content map of strings where the keys are used for row 1 and values are used for row 2
	 * @param headCenter optional centred header, use null if not required
	 * @param headRow1 optional header for row 1, use null if not required
	 * @param headRow2 optional header for row 2, use null if not required
	 * @return string with formatted table
	 */
	public static String tableTwoRows(Map<String, String> content, String headCenter, String headRow1, String headRow2){
		if(content==null||content.size()==0)
			return "";

		String ret=new String();

		int row1=AsciiFormatter.maxLength(content.keySet().toArray());
		if(headRow1!=null&&row1<headRow1.length())
			row1=headRow1.length();
		int row2=AsciiFormatter.maxLength(content.values().toArray());
		if(headRow2!=null&&row1<headRow2.length())
			row2=headRow2.length();
		int line=row1+row2+8;
		row1=row1+4;

		String topRule=AsciiFormatter.topRule(line);
		String midRule=AsciiFormatter.midRule(line);

		ret+=topRule;
		if(headCenter!=null||(headRow1!=null&&headRow2!=null)){
			if(headCenter!=null)
				ret+="| "+AsciiFormatter.center(headCenter, line-5)+" |"+"\n";
			if(headCenter!=null&&headRow1!=null&&headRow2!=null)
				ret+=midRule;
			if(headRow1!=null&&headRow2!=null)
				ret+=AsciiFormatter.tsFill(AsciiFormatter.tsFill("| "+headRow1, ' ', row1)+headRow2, ' ', line-2)+"|"+"\n";
			ret+=topRule;
		}

		String doMid="";
		Set<String> o_set=(Set<String>)content.keySet();
		Iterator<String> key_it=o_set.iterator();
		while(key_it.hasNext()){
			String row1Str=key_it.next();
			String row2Str=content.get(row1Str);

			ret+=doMid;
			ret+=AsciiFormatter.tsFill(AsciiFormatter.tsFill("| "+row1Str, ' ', row1)+row2Str, ' ', line-2)+"|"+"\n";
			doMid=midRule;
		}
		ret+=topRule;
		ret+="\n";

		return ret;
	}

	/**
	 * Returns the length of the longest string in the given array.
	 * @param ar array to be processed
	 * @return length of the longest string (using toString on each object in the array)
	 */
	public static int maxLength(Object[] ar){
		int ret=0;
		for(int i=0;i<ar.length;i++){
			if(ret<ar[i].toString().length())
				ret=ar[i].toString().length();
		}
		return ret;
	}

	/**
	 * Fills a string with the given character up to the given length.
	 * @param str string to be filled
	 * @param fill character used for the fill
	 * @param length maximum length
	 * @return filled string
	 */
    public static String tsFill(String str, Character fill, int length){
    	for(int i=str.length();i<length;i++)
    		str+=fill;
    	return str;
    }
}
