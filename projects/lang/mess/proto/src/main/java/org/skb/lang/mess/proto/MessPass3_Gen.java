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

import java.util.ArrayList;

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.mess.proto.constants.MessConstants;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.config.ConfigurationProperties;
import org.skb.util.classic.lang.NameScope;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.antlr.TSStringTemplate;
import org.skb.util.composite.lang.TSAtomList;

/**
 * Pass 3 of the MESS parser using templates to generate a target language specification.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class MessPass3_Gen {
	/** Logger instance */
	static Logger logger = Logger.getLogger(MessPass3_Gen.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(MessParser.class);

	public TSAtomList atoms;

	private ConfigurationProperties prop;

	public NameScope sn;

	private Token fieldValue=null;
	private Token fieldImmut=null;

	ArrayList<StringTemplate> defs;

	public MessPass3_Gen(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();

		this.prop=config.getProperties();

		this.sn=new NameScope();
		this.defs=new ArrayList<StringTemplate>();
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

	//add ST to AtomList, so that we can manipulate them as needed later and keep the definition order intact
	public void addST(StringTemplate st){
		this.atoms.addST(st); //atoms knows the scope already, grammar needs to push for that
		this.atoms.scope.pop();
	}

	public void clearDefTemplates(){
		this.defs.clear();
	}

	public Object getDefTemplates(){
		return this.defs.clone();
	}

	public void resetFieldList(){
		this.fieldValue=null;
		this.fieldImmut=null;
	}

	public void setFieldValue(Token value){
		this.fieldValue=value;
	}

	public void setFieldImmut(Token immut){
		this.fieldImmut=immut;
	}

	public void addFieldListDef(Token list, Token ident, StringTemplateGroup stg){
		String fieldList=list.getText();
		String stName=null;
		if(fieldList.equals(MessConstants.Tokens.messCHANGE)){
			stName="messMessageChangeDef";
		}
		else if(fieldList.equals(MessConstants.Tokens.messREQUIRES)){
			stName="messMessageRequiresDef";
		}
		else if(fieldList.equals(MessConstants.Tokens.messOPTIONAL)){
			stName="messMessageOptionalDef";
		}
		else{
			System.err.println("Panic: problem with field list for DEF"); //TODO
			return;
		}

		StringTemplate st=stg.getInstanceOf(stName);
		st.setAttribute("ident", ident.getText());
		if(this.fieldValue!=null)
			st.setAttribute("value", this.fieldValue.getText());
		if(this.fieldImmut!=null)
			st.setAttribute("immutable", this.fieldImmut.getText());
		this.defs.add(st);
	}

	public void addRuntimeST(StringTemplateGroup stg){
		if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).tsIsType(TEnum.TS_DEFAULT)){
			TSStringTemplate api=new TSStringTemplate(stg.getInstanceOf("messMessageRuntimeAPI"));
			config.config.put(prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).toString(), api);
		}

		if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).tsIsType(TEnum.TS_DEFAULT)){
			TSStringTemplate impl=new TSStringTemplate(stg.getInstanceOf("messMessageRuntimeImplementation"));
			config.config.put(prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).toString(), impl);
		}
	}
}
