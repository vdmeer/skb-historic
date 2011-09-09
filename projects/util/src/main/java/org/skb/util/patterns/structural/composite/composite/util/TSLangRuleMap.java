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

package org.skb.util.types.composite.util;

import java.util.HashSet;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSTableRowAPI;

/**
 * Implementation of a rule map for parsers/compilers.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSLangRuleMap extends TSTable{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSLangRuleMap.class);


	public final static String rmValRuleMessage		= "rule:message";
	public final static String rmValRuleAddMessage	= "rule:message:add";

	public TSLangRuleMap(){
		super();
		this._initRM();
	}

	public TSLangRuleMap(HashSet<String>rows){
		super();
		this._initRM();
		this.addRows(rows);
	}

	public TSLangRuleMap(String ref_class, String rowPrefix){
		super();
		this._initRM();
		this.addRows(ref_class, rowPrefix);
	}

	protected void _initRM(){
		this.tsvalue=new LinkedHashMap <String, TSTableRowAPI>();
		this.setColumns(TSLangRuleMap.class.getName(), "rmVal");
		this.addRows(TSLangRuleMap.class.getName(), "rmKey");

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_LANG_RULEMAP);
		this.typeEnum.add(TEnum.TS_COMPOSITE_LANG_RULEMAP);
	}

	public String getRule(String name){
		return this.getRule(name, null);
	}

	public String getRule(String name, String[] args){
		if(!this.isInitialised())
			return new String();

		if(!this.tsvalue.containsKey(name))
			return new String();

		String ret=this.getString(name, TSLangRuleMap.rmValRuleMessage).toString();

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
		if(!this.isInitialised())
			return new String();

		if(!this.tsvalue.containsKey(name))
			return new String();

		String ret=this.getString(name, TSLangRuleMap.rmValRuleAddMessage).toString();

		if(args==null)
			return ret;

		int argNo=ret.split("\\Q"+"%"+"\\E", -1).length-1;

		if(args.length!=argNo)
			return ret;

		return String.format(ret,(Object[])args);
	}
}
