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

package org.skb.types.atomic.antlr;

import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.base.OatBaseAtomic;

/**
 * This class provides am OatBaseAtomic wrapper for the string template class StringTemplateGroup.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatStringTemplateGroup extends OatBaseAtomic {
	/**
	 * The local value of a string template StringTemplageGroup.
	 */
	public StringTemplateGroup oatValue=null;

	public OatStringTemplateGroup(OatStringTemplateGroup stg) {
		super();
		this.init();
		try{
			this.oatValue=stg.getValue();
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(StringTemplateGroup stg) {
		super();
		this.init();
		try{
			this.oatValue=stg;
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.io.Reader r){
		try{
			this.oatValue=new StringTemplateGroup(r);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		try{
			this.oatValue=new StringTemplateGroup(r, lexer);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer, StringTemplateErrorListener errors){
		try{
			this.oatValue=new StringTemplateGroup(r, lexer, errors);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.io.Reader r, @SuppressWarnings("rawtypes") java.lang.Class lexer, StringTemplateErrorListener errors, StringTemplateGroup superGroup){
		try{
			this.oatValue=new StringTemplateGroup(r, lexer, errors, superGroup);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.io.Reader r, StringTemplateErrorListener errors){
		try{
			this.oatValue=new StringTemplateGroup(r, errors);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.lang.String name){
		try{
			this.oatValue=new StringTemplateGroup(name);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.lang.String name, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		try{
			this.oatValue=new StringTemplateGroup(name, lexer);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.lang.String name, java.lang.String rootDir){
		try{
			this.oatValue=new StringTemplateGroup(name, rootDir);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(java.lang.String name, java.lang.String rootDir, @SuppressWarnings("rawtypes") java.lang.Class lexer){
		try{
			this.oatValue=new StringTemplateGroup(name, rootDir, lexer);
		} catch (Exception e){}
	}

	public OatStringTemplateGroup(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=((OatStringTemplateGroup)oba).getValue();
		} catch (Exception e) {}
	}

	/**
	 * Returns the oatValue object.
	 * @return StringTemplateGroup The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public StringTemplateGroup getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_ANTLR_STGROUP);
		this.typeEnum.add(ATType.OAT_ATOMIC_ANTLR_STGROUP);
	}

	public OatStringTemplateGroup getValOatAtomicStringTemplateGroup(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
