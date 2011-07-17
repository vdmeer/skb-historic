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

package org.skb.util.types.composite.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.base.OatBase;
import org.skb.util.types.base.OatBaseArrayList;
import org.skb.util.types.base.OatBaseComposite;
import org.skb.util.types.base.OatBaseMap;
import org.skb.util.types.composite.util.OatMapLH;

/**
 * Implementation of a LinkedHashMap for Oat Types.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatMapLH extends OatBaseMap {
	public OatMapLH(){
		super();
		this.init();
		this.oatValue=new LinkedHashMap<String, OatBase>();
	}
	public OatMapLH(OatMapLH n){
		super();
		this.init();
		try{
			this.oatValue=new LinkedHashMap<String, OatBase>(n.getValue());
		} catch (Exception e){}
	}

	public OatMapLH(OatBaseArrayList a){
		super();
		this.init();
		this.oatValue=new LinkedHashMap<String, OatBase>();
		if(a.isMapLH()){
			Map<String,OatBase> at;
			for(int i=0;i<a.size();i++){
				at=(OatMapLH)a.get(i);
				String key;
				Set<String> o_set = at.keySet();
				Iterator<String> key_it = o_set.iterator();
				while(key_it.hasNext()){
					key=key_it.next();
					if(at.get(key)==null)
						continue;
					else
						this.oatValue.put(key, at.get(key));
				}
			}
		}
	}

	protected void init(){
		super.init();
		this.typeString.add(TypeRepository.OAT_COMPOSITE_MAP_LH);
		this.typeEnum.add(ATType.OAT_COMPOSITE_MAP_LH);
	}

	/**
	 * Returns the oatValue object.
	 * @return Long The local oatValue object.
	 * @throws OatValueIsNullException 
	 */
	public Map<String, OatBase> getValue() throws OatValueIsNullException{
		if(this.oatValue!=null)
			return this.oatValue;
		throw new OatValueIsNullException(this.getTypeEnum());
	}

	public OatMapLH getValOatMapLH(){
		return this;
	}

	public OatBase put(List<String> list, OatBase val){
		if(!this.isInitialised()||list==null||list.size()==0)
			return null;
		else if(list.size()==1)
			return this.oatValue.put(list.get(0).toString(), val);
		else{
			String key=list.get(0);
			if(!this.oatValue.containsKey(key))
				this.oatValue.put(key, new OatMapLH());
			list.remove(0);
			return ((OatBaseMap)this.oatValue.get(key)).put(list, val);
		}
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}
