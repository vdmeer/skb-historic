/* Copyright (c) 2000-2011 Sven van der Meer (sven@vandermeer.de)
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
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

package org.skb.lang.##mylang##;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.skb.tribe.LanguageRuleMap;
import org.skb.types.composite.util.OatTableRow;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;
import org.antlr.runtime.Token;

/**
 * Pass 1 of the ##MyLang## parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class ##MyLang##Pass1_Ebnf {
	public AtomList atoms=AtomList.getInstance();

	private LanguageRuleMap cr;

	public ##MyLang##Pass1_Ebnf(){
		this.cr=new LanguageRuleMap();
		this.cr.setClassName(##MyLang##RuleConstants.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();		

		//initialise the AtomList with spec
		this.atoms.addRow(##MyLang##TokensConstants.##mylang##SPECIFICATION);
		this.atoms.put(##MyLang##TokensConstants.##mylang##SPECIFICATION, AtomList.alValCategory, ##MyLang##TokensConstants.##mylang##VOID);
		this.atoms.put(##MyLang##TokensConstants.##mylang##SPECIFICATION, AtomList.alValType, ##MyLang##TokensConstants.##mylang##VOID);

		this.atoms.setDefaultCategory(##MyLang##TokensConstants.##mylang##DEFINITION);
	}

	//from atoms, only here for error handling
	public void putAtom(Token tk, String category, Token type, Boolean array){
		OatTableRow otr=this.atoms.putAtom(tk, category, type, array);
		if(otr!=null){
			ReportManager.getInstance().reportError(
					##MyLang##TokensConstants.parserIDENTIFIER+" used more than once",
					tk,
					##MyLang##TokensConstants.parserIDENTIFIER+": " + otr.get(AtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(AtomList.alValCategory) + " at " + otr.get(AtomList.alValFile) + ":" + otr.get(AtomList.alValLine) + ":" + otr.get(AtomList.alValColumn));
		}
	}

	public void putAtom(Token tk, String category){
		this.putAtom(tk, category, null);
	}

	public void putAtom(Token tk, String category, Token type){
		this.putAtom(tk, category, type, false);
	}

}
