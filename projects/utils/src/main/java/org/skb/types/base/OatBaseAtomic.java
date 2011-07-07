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

package org.skb.types.base;

import org.skb.types.base.OatBase;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.base.OatBaseComposite;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;

/**
 * The base class for all SKB Atomic types.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatBaseAtomic extends OatBase {

	protected OatBaseAtomic(){
		this.typeString.add(TypeRepository.OAT_BASE_ATOMIC);
		this.typeEnum.add(ATType.OAT_BASE_ATOMIC);
	}

	@Override
	public boolean isAtomic() {
		return true;
	}

	@Override
	public boolean isComposite() {
		return false;
	}

	@Override
	public void clean() {
	}

	@Override
	public void trim() {
	}

	/**
	 * Alter oatValue.
	 */
	public void setValue(OatBaseAtomic obj) {
		this.oatValue=obj;
	}

	/**
	 * Returns oatValue.
	 * @return Object The local object.
	 * @throws OatValueIsNullException 
	 */
	public Object getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	public OatBaseAtomic getValAtomic(){
		return (OatBaseAtomic)this.oatValue;
	}

	public OatBaseComposite getValComposite(){
		return null;
	}
}
