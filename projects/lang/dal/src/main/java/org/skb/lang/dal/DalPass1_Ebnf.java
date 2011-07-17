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

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.lang.dal.internal.DalTables;
import org.skb.tribe.LanguageRuleMap;
import org.skb.tribe.TribeProperties;
import org.skb.util.languages.AtomList;
import org.skb.util.misc.ReportManager;
import org.skb.util.types.composite.util.OatTableRow;

/**
 * Pass 1 of the Cola parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass1_Ebnf {
	static Logger logger = Logger.getLogger(DalPass1_Ebnf.class);

	public AtomList atoms;
	public DalTables tables;
	private LanguageRuleMap cr;

	public DalPass1_Ebnf(){
		this.cr=new LanguageRuleMap();
		this.cr.setClassName(DalConstants.Rules.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();		

		this.atoms=AtomList.getInstance();
		this.atoms.setScopeSeparator(TribeProperties.getInstance().getValueDefault("internal-scope-sep").toString());

		this.tables=DalTables.getInstance();
	}

	public void putAtom(Token tk, String category, Token type){
		OatTableRow otr=this.atoms.putAtom(tk, category, type);
		if(otr!=null){
			ReportManager.getInstance().reportError(
					DalConstants.Tokens.parserIDENTIFIER+" used more than once",
					tk,
					DalConstants.Tokens.parserIDENTIFIER+": " + otr.get(AtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(AtomList.alValCategory) + " at " + otr.get(AtomList.alValFile) + ":" + otr.get(AtomList.alValLine) + ":" + otr.get(AtomList.alValColumn));
		}
	}

	public void putAtom(Token tk, String category){
		this.putAtom(tk, category, null);
	}

}
