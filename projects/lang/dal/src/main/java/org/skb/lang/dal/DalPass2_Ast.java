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

import java.util.ArrayList;

import org.antlr.runtime.Token;
import org.skb.lang.dal.internal.DalRepository;
import org.skb.tribe.LanguageRuleMap;
import org.skb.util.languages.AtomList;

/**
 * Pass 2 of the DAL parser, mostly looking into semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass2_Ast {
	public AtomList atoms;
	public DalRepository repo;
	private LanguageRuleMap cr;

	//token list for dalElemSequence
	private ArrayList<Token> elemSeq;

	// temp Type and Value for testing
	private Token lastBaseType=null;
	private Token lastCommonValue=null;
	private Token lastCommonValueType=null;

	public DalPass2_Ast(){
		this.atoms=AtomList.getInstance();
		this.atoms.scope.clear();
//System.err.println(this.atoms.getValue());

		this.cr=new LanguageRuleMap();
		this.cr.setClassName(DalRuleConstants.class.getName());
		this.cr.setKey("rule");
		this.cr.loadRules();

		this.elemSeq=new ArrayList<Token>();

		this.repo=DalRepository.getInstance();
	}

	public void addElemSequence(Token tk){
		this.elemSeq.add(tk);
	}

	public void testElemSequence(){
		String tScope=this.atoms.scope.toString()+this.atoms.scope.separator();

		int size=this.elemSeq.size();
		for(int i=0; i<size; i++){
			if(!this.atoms.containsKey(tScope+this.elemSeq.get(i).getText())){
			  System.err.println(this.elemSeq.get(i).getText()+" not part of this declaration");
			  //Rule IDENT or Sequence
			}
		}
		this.elemSeq.clear();
	}

	public void testList(Token tk){
		String list=this.atoms.scope.toString();
		if(!this.atoms.containsKey(list)){
			  System.err.println(list+" not part of this declaration");
			  //Rule List in Atoms
			}
	}

	public void testKey(Token tk){
		String tKey=this.atoms.scope.toString()+this.atoms.scope.separator()+tk.getText();

		String scl=this.atoms.scope.lastElement();
		if(this.repo.get(this.repo.getCurrentRepo()+"/"+scl)!=null){
			if(this.repo.checkElement(scl, tk.getText())==false)
				System.err.println(tKey+" not part of this repo");
		}
		else{
			if(!this.atoms.containsKey(tKey)){
				  System.err.println(tKey+" not part of this declaration");
				  //Rule Keys in List
				}
		}
	}

	// temp Type and Value for testing
	public void setLastBaseType(Token tk){this.lastBaseType=tk;}
	public void setLastCommonValue(Token tk){this.lastCommonValue=tk;}
	public void setLastCommonValueType(Token tk){this.lastCommonValueType=tk;}
	public void setLastCommonValuePlusType(Token value, Token type){this.setLastCommonValueType(type); this.setLastCommonValue(value);}

	public boolean testSN(String category, String catElem){
		boolean ret=true;
		return ret;
	}
}
