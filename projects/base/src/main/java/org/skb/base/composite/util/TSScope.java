/* Copyright (c) 2011-2011 Sven van der Meer
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

package org.skb.base.composite.util;

import java.util.Stack;

import org.apache.log4j.Logger;
import org.skb.base.composite.TSAtomic;
import org.skb.base.composite.TSRepository;
import org.skb.base.composite.TSRepository.TEnum;

/**
 * Implementation of a scope, using {@link Stack}.
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSScope extends TSAtomic {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSScope.class);

	/** Local value */
	protected Stack<String> scope;

	public TSScope(){
		this._init();
	}

	protected void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_SCOPE);
		this.typeEnum.add(TEnum.TS_ATOMIC_SCOPE);
		this.scope=new Stack<String>();
	}

	public boolean push(String key, String value){
		if(this.scope.contains(key+"@"+value))
			return false;
		this.scope.push(key+"@"+value);
		return true;
	}

	public void pop(){
		this.scope.pop();
	}

	public void reset(){
		this.scope.clear();
	}

	public Stack<String> as_array(){
		return this.scope;
	}

	public String as_string(){
		return this.scope.toString();
	}

	@Override
	public TSScope tsCopyAtomic(){
		TSScope ret=new TSScope();
		ret.scope=this.scope;
		return ret;
	}
}
