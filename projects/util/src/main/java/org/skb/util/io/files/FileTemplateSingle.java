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

package org.skb.util.io.files;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;

/**
 * A single file template maintaining everything necessary to write a file.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class FileTemplateSingle {
	/**
	 * StringTemplates maintained by this template
	 */
	LinkedHashSet<StringTemplate> templates;

	/**
	 * List of imports for this template
	 */
	LinkedHashSet<String> imports;

	/**
	 * List of miscellaneous items for the template
	 */
	LinkedHashMap<String, String> misc;

	/**
	 * Class constructor, initialised private members
	 */
	public FileTemplateSingle(){
		this.templates=new LinkedHashSet<StringTemplate>();
		this.imports=new LinkedHashSet<String>();
		this.misc=new LinkedHashMap<String, String>();
	}

	/**
	 * Class constructor, initialises private members with given parameters
	 * @param lhsST list of StringTemplates
	 * @param lhsIM list of imports
	 * @param lhsMisc list of misc items
	 */
	public FileTemplateSingle(LinkedHashSet<StringTemplate> lhsST, LinkedHashSet<String> lhsIM, LinkedHashMap<String, String> lhsMisc){
		this.templates=new LinkedHashSet<StringTemplate>(lhsST);
		this.imports=new LinkedHashSet<String>(lhsIM);
		this.misc=new LinkedHashMap<String, String>(lhsMisc);
	}

	/**
	 * Add a StringTemplate to the template
	 * @param st the StringTemplate to be added
	 */
	public void addTemplate(StringTemplate st){
		this.templates.add(st);
	}

	/**
	 * Add an import to the template
	 * @param im the import to be added
	 */
	public void addImport(String im){
		this.imports.add(im);
	}

	/**
	 * Add a misc item to the template
	 * @param key the key of the misc item
	 * @param val the value of the misc item
	 */
	public void addMisc(String key, String val){
		this.misc.put(key,val);
	}

	/**
	 * Add a collection of StringTemplates to the template
	 * @param ts collection of StringTemplates to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addAllTemplates(Collection <StringTemplate> ts){
		return this.templates.addAll(ts);
	}

	/**
	 * Add a collection of imports to the template
	 * @param ts collection of imports to be added
	 * @return true if successful, false otherwise
	 */
	public boolean addAllImports(Collection <String> ts){
		return this.imports.addAll(ts);
	}

	/**
	 * Add a collection of misc items to the template
	 * @param ms collection of misc items to be added
	 */
	public void putAllMisc(Map <String, String> ms){
		this.misc.putAll(ms);
	}

	/**
	 * Return all currently added StringTemplates
	 * @return list of StringTemplates
	 */
	public LinkedHashSet<StringTemplate> getTemplates(){
		return this.templates;
	}

	/**
	 * Return all currently added imports
	 * @return list of imports
	 */
	public LinkedHashSet<String> getImports(){
		return this.imports;
	}

	/**
	 * Return all currently added misc items
	 * @return list of misc items
	 */
	public LinkedHashMap<String, String> getMisc(){
		return this.misc;
	}

	/**
	 * Return the size of the template list
	 * @return size
	 */
	public int sizeTemplates(){
		return this.templates.size();
	}

	/**
	 * Return the size of the import list
	 * @return size
	 */
	public int sizeImports(){
		return this.imports.size();
	}

	/**
	 * Return the size of the misc item list
	 * @return size
	 */
	public int sizeMisc(){
		return this.misc.size();
	}
}
