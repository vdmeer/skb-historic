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

package org.skb.types.composite.util;

import java.util.HashSet;
import java.util.TreeMap;

import org.skb.types.composite.util.OatLanguageRuleMap;
import org.skb.types.composite.util.OatTableRow;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.base.OatBaseComposite;
import org.skb.types.base.OatBaseTable;

/**
 * Implementation of a rule map for parsers/compilers.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatLanguageRuleMap extends OatBaseTable{

	public final static String rmValRuleMessage		= "rule:message";
	public final static String rmValRuleAddMessage	= "rule:message:add";

	public OatLanguageRuleMap(){
		super();
		this.init();
	}

	public OatLanguageRuleMap(HashSet<String>rows){
		super();
		this.init();
		this.addRows(rows);
	}

	public OatLanguageRuleMap(String ref_class, String rowPrefix){
		super();
		this.init();
		this.addRows(ref_class, rowPrefix);
	}

	protected void init(){
		super.init();
		this.oatValue=new TreeMap <String, OatTableRow>();
		this.setColumns(OatLanguageRuleMap.class.getName(), "rmVal");
		this.addRows(OatLanguageRuleMap.class.getName(), "rmKey");
		this.typeString.add(TypeRepository.OAT_COMPOSITE_LANGUAGE_RULE_MAP);
		this.typeEnum.add(ATType.OAT_COMPOSITE_LANGUAGE_RULE_MAP);
	}

	public String getRule(String name){
		return this.getRule(name, null);
	}

	public String getRule(String name, String[] args){
		if(!this.oatValue.containsKey(name))
			return null;

		String ret;
		try {
			ret=this.getString(name, OatLanguageRuleMap.rmValRuleMessage).getValue();
		} catch (OatValueIsNullException e) {
			return null;
		}

		if(args==null)
			return ret;

		int argNo=ret.split("\\Q"+"%"+"\\E", -1).length-1;

		if(args.length!=argNo)
			return ret;

		return String.format(ret,(Object[])args);
	}

	public String getRuleAdd(String name){
		return this.getRuleAdd(name, null);
	}

	public String getRuleAdd(String name, String[] args){
		if(!this.oatValue.containsKey(name))
			return null;

		String ret;
		try {
			ret=this.getString(name, OatLanguageRuleMap.rmValRuleAddMessage).getValue();
		} catch (OatValueIsNullException e) {
			return null;
		}

		if(args==null)
			return ret;

		int argNo=ret.split("\\Q"+"%"+"\\E", -1).length-1;

		if(args.length!=argNo)
			return ret;

		return String.format(ret,(Object[])args);
	}

	public OatLanguageRuleMap getValOatLanguageRuleMap(){
		return this;
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}