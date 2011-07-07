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

import org.antlr.runtime.Token;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.base.OatBaseAtomic;

/**
 * This class provides am OatBaseAtomic wrapper for the ANTLR runtime class Token.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatAntlrToken extends OatBaseAtomic {
	/**
	 * The local value of an ANTLR runtime Token.
	 */
	public Token oatValue=null;

	public OatAntlrToken(OatAntlrToken k) {
		super();
		this.init();
		try{
			this.oatValue=k.getValue();
		} catch (Exception e){}
	}

	public OatAntlrToken(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=((OatAntlrToken)oba).getValue();
		} catch (Exception e) {}
	}

	public OatAntlrToken(Token k) {
		super();
		this.init();
		try{
			this.oatValue=k;
		} catch (Exception e){}
	}

	/**
	 * Returns the oatValue object.
	 * @return token The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public Token getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	/** @ignore */
	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_ANTLR_TOKEN);
		this.typeEnum.add(ATType.OAT_ATOMIC_ANTLR_TOKEN);
	}

	public OatAntlrToken getValOatAtomicAntlrToken(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
