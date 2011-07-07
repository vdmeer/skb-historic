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

package org.skb.types.atomic.java;

import org.skb.types.atomic.java.OatObject;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;

/**
 * A wrapper for java.lang.String.Object.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatObject extends OatBaseAtomic {

	/**
	 * The local object
	 */
	protected Object oatValue=null;

	/**
	 * Creates a new OatObject with oatValue=null.
	 */
	public OatObject() {
		super();
		this.init();
	}

	/**
	 * Creates a new OatObject from the specified OatObject.
	 * 
	 * The default oatValue is null.
	 * @param o OatObject to be used in initialisation
	 */
	public OatObject(OatObject o) {
		super();
		this.init();
		try{
			this.oatValue=o.getValue();
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatObject from the specified Object.
	 * 
	 * The default oatValue is null.
	 * @param o Object to be used in initialisation
	 */
	public OatObject(Object o) {
		super();
		this.init();
		this.oatValue=o;
	}

	/**
	 * Creates a new OatObject from the specified OatBaseAtomic.
	 * 
	 * The default oatValue is null.
	 * @param oba OatBaseAtomic to be used in initialisation
	 */
	public OatObject(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=oba.getValue();
		} catch (Exception e) {}
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_OBJECT);
		this.typeEnum.add(ATType.OAT_ATOMIC_OBJECT);
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}