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

package org.skb.util.types.atomic.java;

import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.java.OatLong;
import org.skb.util.types.base.OatBaseAtomic;

/**
 * A wrapper for java.lang.Long.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatLong extends OatBaseAtomic {

	/**
	 * The local Long
	 */
	protected Long oatValue=null;

	/**
	 * Creates a new OatLong with oatValue=null.
	 */
	public OatLong() {
		super();
		this.init();
	}

	/**
	 * Creates a new OatLong from the specified OatLong.
	 * 
	 * The default oatValue is null.
	 * @param l OatLong to be used in initialisation
	 */
	public OatLong(OatLong l) {
		super();
		this.init();
		try{
			this.oatValue=new Long(l.getValue());
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatLong from the specified Long.
	 * 
	 * The default oatValue is null.
	 * @param l Long to be used in initialisation
	 */
	public OatLong(Long l) {
		super();
		this.init();
		try{
			this.oatValue=new Long(l);
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatLong from the specified long.
	 * 
	 * The default oatValue is null.
	 * @param l long to be used in initialisation
	 */
	public OatLong(long l) {
		super();
		this.init();
		try{
			this.oatValue=new Long(l);
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatLong from the specified String.
	 * 
	 * The default oatValue is null.
	 * @param s String to be used in initialisation
	 */
	public OatLong(String s) {
		super();
		this.init();
		try{
			this.oatValue=new Long(s);
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatLong from the specified OatBaseAtomic.
	 * 
	 * The default oatValue is null.
	 * @param oba OatBaseAtomic to be used in initialisation
	 */
	public OatLong(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=new Long(((OatLong)oba).getValue());
		} catch (Exception e) {}
	}

	/**
	 * Returns the oatValue object.
	 * @return Long The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public Long getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return new Long(this.oatValue);
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	public void setValue(Long l) {
		this.oatValue=l;
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_LONG);
		this.typeEnum.add(ATType.OAT_ATOMIC_LONG);
	}

	public OatLong getValOatAtomicLong(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
