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

package org.skb.util.classic.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSArrayListString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Generic implementation of a request object.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Request {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(Request.class);

	/** Local request array */
	private TSLinkedHashTree request_ar;

	/** Boolean indicating if initialisation is ok */
	protected boolean is_initialised=false;

	/** Initialisation map */
	protected TSLinkedHashTree init_map=new TSLinkedHashTree();

	/** Array for HTTP initialisation */
	protected TSLinkedHashTree core_ar_http=new TSLinkedHashTree();

	/** Array for initialisation */
	protected TSLinkedHashTree core_ar_plain=new TSLinkedHashTree();


	/** Class constructor, empty */
	public Request(){
	}


	/**
	 * Initialises the request instance
	 * @param type the type ID for the request
	 * @param registered_request the parameters for the request
	 * @param registered_fields the registered fields
	 */
	public void setRequestType(String type, TSLinkedHashTree registered_request, TSLinkedHashTree registered_fields){
		this.request_ar=new TSLinkedHashTree();

		if(type!=null){
			TSBaseAPI tmp;

			//this.init_map=mySkb.get_registered_requests_by_key(type);
			this.init_map=new TSLinkedHashTree(registered_request);
			if(this.init_map==null)
				logger.error("no request type found for <"+type+">");

			if(this.init_map.containsKey("core:requests:fields")){
				tmp=this.init_map.get("core:requests:fields");
				this.init_map.put("core:requests:fields", ((TSString)tmp).tsExplode());
			}
			else
				this.init_map.put("core:requests:fields", new TSLinkedHashTree());
			if(this.init_map.containsKey("core:requests:formselect_fields")){
				tmp=this.init_map.get("core:requests:formselect_fields");
				this.init_map.put("core:requests:formselect_fields", ((TSString)tmp).tsExplode());
			}
			else
				this.init_map.put("core:requests:formselect_fields", new TSLinkedHashTree());

			if(!this.init_map.containsKey("core:requests:table"))
				this.init_map.put("core:requests:formselect_fields", new TSString());
			if(!this.init_map.containsKey("core:requests:table_collections"))
				this.init_map.put("core:requests:table_collections", new TSString());

			ArrayList<String> rem_keys=new ArrayList<String>();
			TSBaseAPI _t=this.init_map.get("core:requests:fields");
			TSLinkedHashTree ar=new TSLinkedHashTree();
			if(_t.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH))
				ar=(TSLinkedHashTree)_t;
			String key;
			TSLinkedHashTree row;
			Set<String> o_set = ar.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				key=key_it.next();
				row=(TSLinkedHashTree)registered_fields.get(key);
				if(!((TSString)row.get("core:use")).tsvalue.contains("request"))
					rem_keys.add(key);
				else{
					tmp=(TSString)this.init_map.get("core:requests:fields"+"/"+key);
					this.init_map.put("core:requests:fields"+"/"+key, row);
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"request", tmp);
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"value", new String());
					this.init_map.put("core:requests:fields"+"/"+key+"/"+"core-ar", new TSLinkedHashTree());

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
			logger.error("no request type given");
	}


	private TSBaseAPI _set(TSString type){
		/*if(type.equals("null"))
			return null;
		else if(type.equals("true"))
			return true;
		else if(type.equals("false"))
			return false;
		else*/
			return type;
	}


	/**
	 * Initialise the data for that request reading HTTP request values.
	 */
	public void initHttp(){this.init("http");}


	/**
	 * Initialise the data for that request using default values.
	 */
	public void initPlain(){this.init("plain");}


	/**
	 * Private method for initialising the request.
	 * @param type either "http" or "core"
	 */
	private void init(String type){
		if(this.is_initialised==false)
			logger.error("request not initialised");

		if(type.equals("http"))
			this.init_http(this.core_ar_http);
		else if(type.equals("plain"))
			this.init_plain(this.core_ar_http);
		else
			logger.error("no type given for initialisation of request (should be http or plain)");
		this.init_plain(this.core_ar_plain);

		String key;
		Set<String> o_set = this.request_ar.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			this.init_map.put("core:requests:fields"+"/"+key+"/"+"value", this.request_ar.get(((TSString)this.init_map.get("core:requests:prefix")).tsvalue+this.init_map.get("core:requests:fields"+"/"+key+"/"+"core:http_req_name")));
		}
	}


	/**
	 * Activate the request object.
	 *
	 * This method must be called before the request object can be used by Readers or Builders.
	 * A non-activated request object will be ignored, and some Reader/Builder functionality might be 
	 * disabled.
	 */
	public void activate(){
		this.init_map.put("core:requests:fields"+"/"+"request:active"+"/"+"value", new TSBoolean(true));
	}


	/**
	 * Test if the request object is activated or not.
	 * @return true if activated, boolean false otherwise
	 */
	public boolean isActivated(){
		return (boolean)((TSBoolean)this.init_map.get("core:requests:fields"+"/"+"request:active"+"/"+"value")).tsvalue;
	}


	/**
	 * Return the key of the request object.
	 *
	 * The key is the type used for the creation in the constructor. In the SKB, it corresponds to a registered request.
	 * @return string 
	 */
	public TSString getKey(){
		return (TSString)this.init_map.get("key");
	}


	/**
	 * Add a value to a registered key/value pair of the request object.
	 * 
	 * This function allows to add values to registered key/value pair of the request object. <code>key</code> must be a known
	 * key in the request, otherwise this method will do nothing. All fields of <code>value</code> will be merged with the list that <code>key</code> points to.
	 * @param field_key the key for which values should be added.
	 * @param value the value to be added.
	 */
	public void addValue(String field_key, String[] value){
		this.addValue(field_key, new TSArrayListString(value));
	}


	/**
	 * Add a value to a registered key/value pair of the request object.
	 * 
	 * This function allows to add values to registered key/value pair of the request object. <code>key</code> must be a known
	 * key in the request, otherwise this method will do nothing. All fields of <code>value</code> will be merged with the list that <code>key</code> points to.

	 * @param field_key the key for which values should be added.
	 * @param value the value to be added.
	 */
	public void addValue(String field_key, TSArrayListString value){
		for(int i=0;i<value.size();i++)
			this.addValue(field_key, value.get(i));
	}


	/**
	 * Add a value to a registered key/value pair of the request object.
	 * @param field_key the key for which values should be added.
	 * @param value the value to be added.
	 */
	public void addValue(String field_key, TSBaseAPI value){
		if(!this.init_map.containsKey("core:requests:fields"+"/"+field_key)||field_key.equals("request:active"))
			return;

		TSBaseAPI cur_val=this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"value");
		if(cur_val.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
			((TSArrayListString)cur_val).add(((TSString)value));
			this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value", cur_val);
		}
		else if(cur_val.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value",new TSString(((TSString)cur_val).tsvalue+(TSString.tsAddCharComma((TSString)value))+value));
		}
	}


	/**
	 * Set a value of a registered key/value pair of the request object.
	 * 
	 * This methods allows to set the value of a registered key/value pair of the request object. <code>field_key</code> must be a known
	 * key in the request, otherwise this function will do nothing. The value will simply overwrite any 
	 * current value of <code>field_key</code>.
	 * @param field_key the key for which values should be set.
	 * @param value the value to be set.
	 */
	public void setValue(String field_key, TSBaseAPI value){
		if(!this.init_map.containsKey("core:requests:fields"+"/"+field_key)||field_key.equals("request:active"))
			return;
		this.init_map.put("core:requests:fields"+"/"+field_key+"/"+"value",value);
	}


	/**
	 * Return the current value of <code>field_key</code>.
	 * 
	 * This method will return the current value of <code>field_key</code> in the following way:
	 * <ul>
	 *   <li> If the value of <code>field_key</code> is 'null', the return value is TSNull.</li>
	 *   <li> If the value of <code>field_key</code> is an array, then this array will be returned.</li>
	 *   <li> If the value of <code>field_key</code> is no 'null' and not an array, then a new array with the current value as member will be returned.</li>
	 * </ul>
	 * @param field_key the key for which values should be returned.
	 * @return current value of the key
	 */
	public TSBaseAPI getValue(String field_key){
		return this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"value");
	}


	/**
	 * Return the HTTP request name (or HTML Form name) of the given key.
	 * 
	 * This method returns the HTTP request name (or HTML Form name) of key, or null if that name does not exist.
	 * This name is usually different from the variable name used internally in the SKB.
	 * @param field_key the key to be looked for.
	 * @return null or the form name of the key
	 */
	public String getFormName(String field_key){
		if(this.init_map.containsKey("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name"))
			return ((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name")).tsvalue;
		else
    	  return null;
	}


	/**
	 * Return the keys for form select fields
	 * @return set with the keys
	 */
	public Object getFormSelectKeys(){
		return this.init_map.get("core:requests:formselect_fields");
	}


	/**
	 * Return the default semantic tag set for the request object.
	 * @return default semantic tag
	 */
	public TSString getTable(){
		return (TSString)this.init_map.get("core:requests:table");
	}


	/**
	 * Return the default semantic tag for collections set for the request object.
	 * @return default semantic tag for collections
	 */
	public TSString getTableCollections(){
		return (TSString)this.init_map.get("core:requests:table_collections");
	}


	/**
	 * Build a URL adding request specific information.
	 * 
	 * This method will return a new URL adding some request specific information to it. That information is basically
	 * the HTTP Request name and the current value of all key/value pairs that are visible to HTTP requests.
	 * @param href the original URL (aka HTML HREF).
	 * @return new url
	 */
	public String buildURL(String href){
		//TODO implement if HTTP/REST supported
		logger.warn("not yet implemented");
		return null;
	}


	/**
	 * Return the HTTP Request name for a given key (field).
	 * 
	 * This method returns the HTTP Request name for a given field (existing key/value pair), or 'null' if it does not exist 
	 * or if the given field is not visible for HTTP requests.
	 * @param field_key the field to be looked for.
	 * @return HTTP request name for the field or null if key does not exist
	 */
	public String getHttpRequestName(String field_key){
		if(this.init_map.containsKey("core:requests:fields"+"/"+field_key)){
			String _t;
			_t = ((TSString)this.init_map.get("core:requests:prefix")).tsvalue+((TSString)this.init_map.get("core:requests:fields"+"/"+field_key+"/"+"core:http_req_name")).tsvalue;
			if(this.init_map.containsKey(_t))
				return _t+"[]";
		}
		return null;
	}


	@Override
	public String toString(){
		if(this.is_initialised==true)
			return "init map: \n"+this.init_map.toString()+"http: \n"+this.core_ar_http.toString()+"plain: \n"+this.core_ar_plain.toString();
		else
			return "";
	}


	private void init_http(TSLinkedHashTree ar){
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


	private void init_plain(TSLinkedHashTree ar){
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
