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
 *       documentation and/or other materials provided with the distribution.
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

package org.skb.kb.targets.tgtjava.core.skbinfo;

import java.util.Iterator;
import java.util.Set;

import org.skb.kb.SKB;
import org.skb.kb.SKBReader;
import org.skb.types.TypeRepository.ATType;
import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.base.OatBase;
import org.skb.types.composite.util.OatMapLH;
import org.skb.util.pattern.Request;

public class SkbInfoReader extends SKBReader {

	@Override
	protected void prepare_loop(Request request, OatString table, OatString tableCollections) {
		OatBase todo=request.getValue("request:entry");
		String doto=null;
		String select=null;
		switch(todo.getTypeEnum()){
			case OAT_ATOMIC_STRING:
				doto=todo.toString();
				if(doto.length()<1)
					doto=null;

				break;
			case OAT_ARRAYLIST_STRING:
				doto=((OatArrayListString)todo).get(0).toString();
				if(doto.contains(":")){
					String[] ar=doto.split(":");
					if(ar[0].length()>0)
						doto=ar[0];
					else
						doto=null;
					select=ar[1];
				}
				break;
			default:
				break;
		}

		SKB mySKB=SKB.getInstance();
		if(doto==null||doto.equals("configuration"))
			this.entries.put("configuration", mySKB.getConfiguration());
//		if(doto==null||doto.equals("dbpdos"))
//			this.entries.put("dbpdos", mySKB.getRegisteredPdos());
		if(doto==null||doto.equals("requests"))
			this.entries.put("registered_requests", mySKB.getRegisteredRequests());
		if(doto==null||doto.equals("readers"))
			this.entries.put("registered_readers", mySKB.getRegisteredReaders());
		if(doto==null||doto.equals("builders"))
			this.entries.put("registered_builders", mySKB.getRegisteredBuilders());
		if(doto==null||doto.equals("templates"))
			this.entries.put("registered_templates", mySKB.getRegisteredTemplates());
		if(doto==null||doto.equals("applications"))
			this.entries.put("registered_applications", mySKB.getRegisteredApplications());
		if(doto==null||doto.equals("interpreters"))
			this.entries.put("registered_interpreters", mySKB.getRegisteredInterpreters());
		if(doto==null||doto.equals("fields"))
			this.entries.put("registered_fields", mySKB.getRegisteredFields());
/*
	    $myHTTP=SKB_Http::get_instance();
	    if($todo==null||$todo=="mime_content_types"){
	      $this->entries['mime_content_types']=$myHTTP->get_skb_mime_content_types();
	      ksort($this->entries['mime_content_types']);
	    }
	    if($todo==null||$todo=="http_headers_response"){
	      $this->entries['http_headers_response']=$myHTTP->get_skb_http_headers_response();
	      ksort($this->entries['http_headers_response']);
	    }
*/

		this.entries.put("todo", doto);
		this.entries.put("select", select);

		//remove all non selected
		if(select!=null){
			Set<String> o_set = this.entries.keySet();
			Iterator<String> key_it = o_set.iterator();
			String key;
			while(key_it.hasNext()){
				key=key_it.next();
				OatBase val=this.entries.get(key);
				if(val.getTypeEnum().equals(ATType.OAT_COMPOSITE_MAP_LH)){
					Set<String> t_set = ((OatMapLH)val).keySet();
					Iterator<String> t_it = t_set.iterator();
					String t_key;
					while(t_it.hasNext()){
						t_key=t_it.next();
						if(((OatMapLH)val).containsKey("origin")&&!((OatMapLH)val).get("origin").toString().equals(select)){
							((OatMapLH)val).remove(t_key);
						}
					}
				}
			}
		}
		this.entries.clean();
	}

	@Override
	protected void execute_loop(Request request) {
		// TODO Auto-generated method stub
	}
}
