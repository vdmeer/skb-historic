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

package org.skb.lang.dal;

import org.skb.lang.dal.internal.DalRepository;
import org.skb.tribe.LanguageRuleMap;
import org.skb.tribe.TribeProperties;
import org.skb.types.composite.util.OatTableRow;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;
import org.antlr.runtime.Token;

/**
 * Pass 1 of the Cola parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass1_Ebnf {
	public AtomList atoms;
	public DalRepository repo;
	private LanguageRuleMap cr;

	public DalPass1_Ebnf(){
		this.cr=new LanguageRuleMap();
		this.cr.setClassName(DalRuleConstants.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();		

		this.atoms=AtomList.getInstance();
		this.atoms.setScopeSeparator(TribeProperties.getInstance().getValueDefault("internal-scope-sep").toString());

		//initialise the AtomList with spec
//		this.atoms.addRow(DalTokensConstants.colaSPECIFICATION);
//		this.atoms.put(DalTokensConstants.colaSPECIFICATION, AtomList.alValCategory, DalTokensConstants.colaVOID);
//		this.atoms.put(DalTokensConstants.colaSPECIFICATION, AtomList.alValType, DalTokensConstants.colaVOID);

//		this.atoms.setDefaultCategory(DalTokensConstants.colaDEFINITION);

		this.repo=DalRepository.getInstance();
	}

	//from atoms, only here for error handling
	public void putAtom(Token tk, String category, Token type, Boolean array){

		//need to check for List name against Repo table names!!!
		
		OatTableRow otr=this.atoms.putAtom(tk, category, type, array);
		if(otr!=null){
			ReportManager.getInstance().reportError(
					DalTokensConstants.parserIDENTIFIER+" used more than once",
					tk,
					DalTokensConstants.parserIDENTIFIER+": " + otr.get(AtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(AtomList.alValCategory) + " at " + otr.get(AtomList.alValFile) + ":" + otr.get(AtomList.alValLine) + ":" + otr.get(AtomList.alValColumn));
		}
	}

	public void putAtom(Token tk, String category){
		this.putAtom(tk, category, null);
	}

	public void putAtom(Token tk, String category, Token type){
		this.putAtom(tk, category, type, false);
	}
}