/* Copyright (c) 2008-2011 Sven van der Meer
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

package org.skb.util.types.atomic.util;

import org.skb.util.stringtemplate.STGManager;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.util.OatSTGManager;
import org.skb.util.types.base.OatBaseAtomic;

/**
 * A wrapper for an STG Manager.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatSTGManager extends OatBaseAtomic {
	public STGManager oatValue=null;
	
	public OatSTGManager(){
		super();
		this.init();
		this.oatValue=new STGManager();
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_STG_MANAGER);
		this.typeEnum.add(ATType.OAT_ATOMIC_STG_MANAGER);
	}

	public OatSTGManager getValOatAtomicSTGManager(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
