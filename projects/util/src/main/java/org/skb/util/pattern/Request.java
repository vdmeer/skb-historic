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

package org.skb.util.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.skb.util.types.TSRepository;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Generic implementation of a request object.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class Request {
	private TSMapLH request_ar;

	protected boolean is_initialised=false;

	protected TSMapLH init_map=new TSMapLH();
	protected TSMapLH core_ar_http=new TSMapLH();
	protected TSMapLH core_ar_plain=new TSMapLH();

	public Request(){}

	public void setRequestType(String type, TSMapLH registered_request, TSMapLH registered_fields){
		this.request_ar=new TSMapLH();

		if(type!=null){
			TSBase tmp;

			//this.init_map=mySkb.get_registered_requests_by_key(type);
			this.init_map=new TSMapLH(registered_request);
			if(this.init_map==null)
				;//trigger_error("SKB_Request: no request type of '{$type}' found", E_USER_ERROR);

			if(this.init_map.containsKey("core:requests:fields")){
				tmp=this.init_map.get("core:requests:fields");
				this.init_map.put("core:requests:fields", ((TSString)tmp).tsExplode());
			}
			else
				this.init_map.put("core:requests:fields", new TSMapLH());
			if(this.init_map.containsKey("core:requests:formselect_fields")){
				tmp=this.init_map.get("core:requests:formselect_fields");
				this.init_map.put("core:requests:formselect_fields", ((TSString)tmp).tsExplode());
			}
			else
				this.init_map.put("core:requests:formselect_fields", new TSMapLH());

			if(!this.init_map.containsKey("core:requests:table"))
				this.init_map.put("core:requests:formselect_fields", new TSString());
			if(!this.init_map.containsKey("core:requests:table_collections"))
				this.init_map.put("core:requests:table_collections", new TSString());

			ArrayList<String> rem_keys=new ArrayList<String>();
			TSBase _t=this.init_map.get("core:requests:fields");
			TSMapLH ar=new TSMapLH();
			if(_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH))
				ar=(TSMapLH)_t;
			String key;
			TSMapLH row;
			Set<String> o_set = ar.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				key=key_it.next();
				row=(TSMapLH)registered_fields.get(key);
				if(!((TSString)row.get("core:use")).tsvalue.contains("request"))
					rem_keys.add(key);
				else{
					tmp=(TSString)this.init_map.get("core:requests:fields"+"/"+key);
					this.init_map.put("core:requests:fields"+"/"+key, row);
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"request", tmp);
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"value", new String());
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar", new TSMapLH());

//				if(!((String)this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:val_unset")).equals("null"))
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar"+"/"+"core:val_unset", this._set((TSString)this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:val_unset")));
					if(this.init_map.containsKey("core:requests:fields"+"/"+key+"/"+"core:val_do_list")&&((TSString)this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:val_do_list")).equals("1"))
						this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar"+"/"+"list", new TSBoolean(true));
						if(this.init_map.containsKey("core:requests:fields"+"/"+key+"/"+"core:isval_if")&&this.init_map.containsKey("core:requests:fields"+"/"+key+"/"+"core:isval_else")){
						this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar"+"/"+"core:if_set"+"/"+"core:isval", this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:isval"));
						this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar"+"/"+"core:if_set"+"/"+"core:isval_if", this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:isval_if"));
						this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar"+"/"+"core:if_set"+"/"+"core:isval_else", this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:isval_else"));
					}

					if(((TSString)this.init_map.get("core:requests:fields"+"/"+key+"/"+"request")).equals("plain"))
						this.core_ar_plain.put(((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)row.get("core:http_req_name")).tsvalue, this.init_map.get("core:requests:fields"+"/"+key+"/"+"core-ar"));
					else if(((TSString)this.init_map.get("core:requests:fields"+"/"+key+"/"+"request")).equals("http"))
						this.core_ar_http.put(((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)row.get("core:http_req_name")).tsvalue, this.init_map.get("core:requests:fields"+"/"+key+"/"+"core-ar"));
				}
			}
			for(int i=0;i<rem_keys.size();i++)
				this.init_map.remove(rem_keys.get(i));
			this.is_initialised=true;
		}
		else
			;//trigger_error("SKB_Request: no request type given", E_USER_ERROR);
	}

	private TSBase _set(TSString type){
		/*if(type.equals("null"))
			return null;
		else if(type.equals("true"))
			return true;
		else if(type.equals("false"))
			return false;
		else*/
			return type;
	}

	public void initHttp(){this.init("http");}
	public void initPlain(){this.init("plain");}

	private void init(String type){
		if(this.is_initialised==false)
			;//trigger_error("SKB_Request: no type loaded", E_USER_ERROR);

		if(type.equals("http"))
			this.init_http(this.core_ar_http);
		else if(type.equals("plain"))
			this.init_plain(this.core_ar_http);
		else
			;//trigger_error("SKB_Request: no type given for initialisation of request", E_USER_ERROR);
		this.init_plain(this.core_ar_plain);

		String key;
		Set<String> o_set = this.request_ar.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			this.init_map.put("core:requests:fields"+"/"+key+"/"+"value", this.request_ar.get(((TSString)this.init_map.get("core:requests:prefix")).tsvalue+this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:http_req_name")));
		}
	}

	public void activate(){this.init_map.put("core:requests:fields"+"/"+"request:active"+"/"+"value", new TSBoolean(true));}
	public boolean isActivated(){
		return (boolean)((TSBoolean)this.init_map.get("core:requests:fields"+"/"+"request:active"+"/"+"value")).tsvalue;
	}

	public TSString getKey(){return (TSString)this.init_map.get("key");}

	public void addValue(String field_key, String[] value){this.addValue(field_key, new TSArrayListString(value));}
	public void addValue(String field_key, TSArrayListString value){
		for(int i=0;i<value.size();i++)
			this.addValue(field_key, value.get(i));
	}

	public void addValue(String field_key, TSBase value){
		if(!this.init_map.containsKey("core:requests:fields"+"/"+field_key)||field_key.equals("request:active"))
			return;

		TSBase cur_val=this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"value");
		if(cur_val.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
			((TSArrayListString)cur_val).add(((TSString)value));
			this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value", cur_val);
		}
		else if(cur_val.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value",new TSString(((TSString)cur_val).tsvalue+(TSString.tsAddCharComma((TSString)value))+value));
		}
	}

	public void setValue(String field_key, TSBase value){
		if(!this.init_map.containsKey("core:requests:fields"+"/"+field_key)||field_key.equals("request:active"))
			return;
		this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value",value);
	}

	public TSBase getValue(String field_key){
		return this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"value");
	}

	public String getFormName(String field_key){
		if(this.init_map.containsKey("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name"))
			return ((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name")).tsvalue;
		else
    	  return null;
	}

	public Object getFormSelectKeys(){return this.init_map.get("core:requests:formselect_fields");}

	public TSString getTable(){return (TSString)this.init_map.get("core:requests:table");}
	public TSString getTableCollections(){return (TSString)this.init_map.get("core:requests:table_collections");}

	//not yet implemented
	public String buildURL(String href){return null;}

	public String getHttpRequestName(String field_key){
		if(this.init_map.containsKey("core:requests:fields"+"/"+field_key)){
			String _t;
			_t = ((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name")).tsvalue;
			if(this.init_map.containsKey(_t))
				return _t+"[]";
		}
		return null;

	}
	
	public String toString(){
		if(this.is_initialised==true)
			return "init map: \n"+this.init_map.toString()+"http: \n"+this.core_ar_http.toString()+"plain: \n"+this.core_ar_plain.toString();
		else
			return "";
	}

	private void init_http(TSMapLH ar){
		if(ar.size()>0){
			String key;
			Set<String> o_set = ar.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				key=key_it.next();
				//if HTTP POST or GET exists, set this one, else default, now only default
				this.request_ar.put(key, ar.get(key+"/"+"core:val_unset"));

				if(ar.containsKey(key+"/"+"core:if_set")){
					if(((TSString)this.request_ar.get(key)).equals((TSString)ar.get("core:if_set"+"/"+"core:isval")))
						this.request_ar.put(key, ar.get("core:if_set"+"/"+"core:isval_if"));
					else
						this.request_ar.put(key, ar.get("core:if_set"+"/"+"core:isval_else"));
				}
//				if(ar.isset("core:list")&&(Boolean)ar.get("core:list")==true){
					//do REUQEST array search for list values
//				}
			}
		}

	}

	private void init_plain(TSMapLH ar){
		if(ar.size()>0){
			String key;
			Set<String> o_set = ar.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				key=key_it.next();
				this.request_ar.put(key,ar.get(key+"/"+"core:val_unset"));
				if(ar.containsKey(key+"/"+"core:if_set")){
					if(((TSString)this.request_ar.get(key)).equals((TSString)ar.get(key+"/"+"core:if_set"+"/"+"core:isval")))
						this.request_ar.put(key, ar.get(key+"/"+"core:if_set"+"/"+"core:isval_if"));
					else
						this.request_ar.put(key, ar.get(key+"/"+"core:if_set"+"/"+"core:isval_else"));
				}

			}
		}
	}

//	public Object get_request_by_key(TSString key){
//		if(this.request_ar.containsKey(key))
//			return this.request_ar.get(key);
//		return null;
//	}

}
