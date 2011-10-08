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

package org.skb.lang.mess.proto;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.skb.base.composite.lang.TSAtomList;
import org.skb.base.composite.misc.TSReportManager;
import org.skb.base.config.Configuration;
import org.skb.lang.mess.proto.constants.MessConstants;

/**
 * Pass 2 of the MESS parser, mostly looking into semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class MessPass2_Ast {
	/** Logger instance */
	static Logger logger = Logger.getLogger(MessPass2_Ast.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(MessParser.class);

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

	/** Local Report Manager */
	public TSReportManager repMgr;

	/** Remembering the last used extend on a message */
	private Token lastExtends=null;

	public MessPass2_Ast(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();
		this.repMgr=config.getReportManager();
	}

	public void pushSep(Token token, Token sep){
		if(sep!=null)
			this.atoms.scope.push(sep);
		this.atoms.scope.push(token);
	}

	public void popAtom(int count){
		for(int i=0;i<count;i++)
			this.atoms.scope.pop();
	}

	public void setExtends(Token ident){
		this.lastExtends=ident;
	}

	public void testIdent(Token ident, Token type, Token category){
		if(type!=null){
			String id=ident.getText();
			String idType=type.getText();
			String scSep=this.atoms.scope.getSeparator();

			if(idType.equals(MessConstants.Tokens.messFIELD)){
				//test MIME idents in fields against content types
				if(!this.atoms.containsKey(MessConstants.Tokens.messCONTENT_TYPE+scSep+id))
					this.repMgr.error("undefined content type ID <"+id+">", ident);
			}
			else if(idType.equals(MessConstants.Tokens.messMESSAGE)){
				if(!this.atoms.containsKey(MessConstants.Tokens.messMESSAGE+scSep+id))
					this.repMgr.error("extends uses an undefiend message ID <"+id+">", ident);
			}
			else if(idType.equals(MessConstants.Tokens.messCHANGE)){
				if(this.lastExtends==null){
					this.repMgr.error("change entry used without message extending a message", ident);
				}
				else{
					if(this.atoms.containsKey(MessConstants.Tokens.messMESSAGE+scSep+this.lastExtends.getText()+scSep+MessConstants.Tokens.messOPTIONAL+scSep+id))
						this.repMgr.error("change entry for field <"+id+"> defined as optional in parent message <"+this.lastExtends.getText()+">", ident, "cannot change optional fields, they are not inherited");
					else if(!this.atoms.containsKey(MessConstants.Tokens.messMESSAGE+scSep+this.lastExtends.getText()+scSep+MessConstants.Tokens.messREQUIRES+scSep+id))
						this.repMgr.error("change entry for field <"+id+"> not defined in parent message <"+this.lastExtends.getText()+">", ident);
				}
			}
			else if(idType.equals(MessConstants.Tokens.messREQUIRES)){
				if(!this.atoms.containsKey(MessConstants.Tokens.messFIELD+scSep+id))
					this.repMgr.error("requires entry uses an undefined field ID <"+id+">", ident);
			}
			else if(idType.equals(MessConstants.Tokens.messOPTIONAL)){
				if(!this.atoms.containsKey(MessConstants.Tokens.messFIELD+scSep+id))
					this.repMgr.error("optional entry uses an undefined field ID <"+id+">", ident);
			}
		}
		else
			System.err.println("empty token type");
	}
}
