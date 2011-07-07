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

import org.skb.types.atomic.java.OatDouble;
import org.skb.types.atomic.java.OatString;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.OatValueIsNullException;
import org.skb.types.TypeRepository;
import org.skb.types.TypeRepository.ATType;

/**
 * A wrapper for java.lang.Double.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatDouble extends OatBaseAtomic {
	protected Double oatValue=null;

	/**
	 * Creates a new OatDouble with oatValue=null.
	 */
	public OatDouble() {
		super();
		this.init();
	}

	/**
	 * Creates a new OatDouble from the specified OatDouble
	 * 
	 * The default oatValue is null.
	 * @param d OatDouble to be used in initialisation
	 */
	public OatDouble(OatDouble d) {
		super();
		this.init();
		try{
			this.oatValue=new Double(d.getValue());
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatDouble from the specified Double
	 * 
	 * The default oatValue is null.
	 * @param d Double to be used in initialisation
	 */
	public OatDouble(Double d) {
		super();
		this.init();
		try{
			this.oatValue=new Double(d);
		} catch (Exception e){}
	}

	/**
	 * Creates a new OatDouble from the specified double
	 * 
	 * The default oatValue is null.
	 * @param d double to be used in initialisation
	 */
	public OatDouble(double d) {
		super();
		this.init();
		try{
			this.oatValue=new Double(d);
		} catch (Exception e){}

	}

	/**
	 * Creates a new OatDouble from the specified String
	 * 
	 * The default oatValue is null.
	 * @param s String to be used in initialisation
	 */
	public OatDouble(String s) {
		super();
		this.init();
		try{
			this.oatValue=new Double(s);
		} catch (Exception e){}

	}

	/**
	 * Creates a new OatDouble from the specified OatBaseAtomic
	 * 
	 * The default oatValue is null.
	 * @param oba OatBaseAtomic to be used in initialisation
	 */
	public OatDouble(OatBaseAtomic oba) {
		super();
		this.init();
		try{
			if(oba.getTypeEnum()==this.getTypeEnum())
				this.oatValue=new Double(((OatString)oba).getValue());
		} catch (Exception e) {}
	}

	/**
	 * Returns the oatValue object.
	 * @return Double The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public Double getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return new Double(this.oatValue);
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	public void setValue(Double d) {
		this.oatValue=d;
	}

	private void init(){
		this.typeString.add(TypeRepository.OAT_ATOMIC_DOUBLE);
		this.typeEnum.add(ATType.OAT_ATOMIC_DOUBLE);
	}

	public OatDouble getValOatAtomicDouble(){
		return this;
	}

	public OatBaseAtomic getValOatAtomic(){
		return this;
	}
}
