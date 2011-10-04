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
import org.skb.util.classic.config.Configuration;
import org.skb.util.composite.TSTableRowAPI;
import org.skb.util.composite.lang.TSAtomList;

/**
 * Pass 1 of the Cola parser, mostly looking into syntax analysis and creation of symbol table.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class DalPass1_Ebnf {
	/** Logger instance */
	static Logger logger = Logger.getLogger(DalPass1_Ebnf.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(DalParser.class);

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

	/**
	 * Class constructor, initialises the atom list (symbol table) and other local fields
	 */
	public DalPass1_Ebnf(){
		this.atoms=config.getAtomlist();
		this.atoms.setReportMgt(config.getReportManager());
		this.atoms.setScopeSeparator(config.getProperties().getValueDefault("internal-scope-sep").toString());
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), loggs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 * @param type of the atom
	 */
	public void putAtom(Token token, String category, Token type){
		TSTableRowAPI otr=this.atoms.putAtom(token, category, type);
		if(otr!=null){
			config.getReportManager().error(DalConstants.Tokens.parserIDENTIFIER+" used more than once", token, DalConstants.Tokens.parserIDENTIFIER+": " + otr.get(TSAtomList.alValScopedID) + " as " + category + ", previously declared as " + otr.get(TSAtomList.alValCategory) + " at " + otr.get(TSAtomList.alValFile) + ":" + otr.get(TSAtomList.alValLine) + ":" + otr.get(TSAtomList.alValColumn));
		}
	}

	/**
	 * Puts a new atom into the Atom List (Symbol Table), loggs an error if Atom already exists.
	 * @param token of the atom
	 * @param category the atom belongs to
	 */
	public void putAtom(Token token, String category){
		this.putAtom(token, category, null);
	}
}
