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

package org.skb.kb;

import org.apache.log4j.Logger;
import org.skb.util.patterns.creational.builder.TemplateManager;
import org.skb.util.patterns.structural.composite.atomic.stringtemplate.TSSTGManager;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * SKB specific Template Manager, supporting builders in managing templates.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class SKBTemplateManager implements TemplateManager {
	/** Logger instance */
	static Logger logger=Logger.getLogger(TemplateManager.class);

	/** local map of templates */
	protected TSMapLH templates=new TSMapLH();


	/**
	 * Class constructor, empty
	 */
	public SKBTemplateManager(){
	}


	/**
	 * Shows if the manager is initialised completely or not
	 * @return true if everything is initialised, false otherwise (either templates are NULL or no templates registered)
	 */
	public final boolean isInitialised(){
		if(this.templates!=null&&this.templates.size()>0)
			return true;
		return false;
	}


	//TODO JSDOC
	public void add_template(String name, String key){
		this.templates.put(new String [] {name, "key"}, key);

		SKB mySKB=SKB.getInstance();
		String file=mySKB.configuration.get(new String[] {"path", "targets"}).toString()+mySKB.configuration.get(new String[] {"skb", "targetpref"}).toString()+mySKB.configuration.get(new String[] {"skb", "target"}).toString()+"/"+mySKB.getRegisteredTemplates(key).get(new String[] {"core:rabit:target:template", "java"}).toString()+".stg";

		TSSTGManager stgm=new TSSTGManager();
		stgm.setApplicationName("skb");
		stgm.setSTGFileName(file);
		stgm.useLexerAngelB();
		stgm.loadSTG("builder template", "skb");

		//TreeMap<String, ArrayList<String>> chunks=new TreeMap<String, ArrayList<String>>();
		//stgm.field.setChunks(chunks, chunks);

		this.templates.put(new String [] {name, "stgm"}, stgm);
	}


	//TODO JSDOC
	public void set_header(){
		//TODO implement once HTTP/REST functionality is available
		logger.warn("not yet implemented");
	}


	//TODO JSDOC
	public TSSTGManager get_template_object(String key){
		if(!this.isInitialised())
			return null;

		if(this.templates.containsKey(key))
			return (TSSTGManager)this.templates.get(new String[] {key, "stgm"});

		return null;
	}


	//TODO JSDOC
	public String get_template_path(String key){
		if(!this.isInitialised())
			return null;

//		if(this.templates.isset(key)){
//			SKB_Main mySKB=SKB_Main.getInstance();
//	  		$tpl=$mySKB->get_registered_templates_by_key($this->templates[$key]['key']);
//		  	return $mySKB->configuration->get_group("path","rabit") . $tpl['core:rabit:file:stg'].".stg";
//		}
		return null;
	}
}
