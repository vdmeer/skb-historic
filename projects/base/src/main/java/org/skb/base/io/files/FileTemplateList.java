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

package org.skb.base.io.files;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.java.TSString;

/**
 * A list of file templates that a parser/compiler can use/generate to produce output files.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class FileTemplateList {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(FileTemplateList.class);

	/** List of templates */
	private TreeMap<String, FileTemplateSingle> templates;

	/** The target directory */
	private TSString targetDirectory=null;

	/**
	 * Class constructor, initialises private members
	 */
	public FileTemplateList(){
		this.templates=new TreeMap<String, FileTemplateSingle>();
	}

	/**
	 * Class constructor, initialises private list with given list
	 * @param ftl file list to be used
	 */
	public FileTemplateList(TreeMap<String, FileTemplateSingle> ftl){
		this.templates=new TreeMap<String, FileTemplateSingle>(ftl);
	}

	/**
	 * Initialise the template with the target directory
	 * @param targetDir target directory
	 */
	public void init(TSBaseAPI targetDir){
		if(targetDir!=null)
			this.targetDirectory=new TSString(targetDir.toString());
	}

	/**
	 * Tests for existence of a key 
	 * @param k key to be tested
	 * @return true if key exists, false otherwise
	 */
	public boolean containsKey(String k){
		return this.templates.containsKey(k);
	}

	/**
	 * Return the current size of the template list
	 * @return size of the template list
	 */
	public int size(){
		return this.templates.size();
	}

	/**
	 * Return an entry set of the template list
	 * @return entry set
	 */
	public Set<Map.Entry<String, FileTemplateSingle>> entrySet(){
		return this.templates.entrySet();
	}

	/**
	 * Return the template for a given key
	 * @param key key of the template
	 * @return single template
	 */
	public FileTemplateSingle get(String key){
		return this.templates.get(key);
	}

	/**
	 * Return the complete template list
	 * @return template list
	 */
	public TreeMap<String, FileTemplateSingle> getList(){
		return this.templates;
	}

	/**
	 * Add a template
	 * @param fn file name (key)
	 * @param fts template
	 */
	public void add(String fn, FileTemplateSingle fts){
		this.templates.put(fn, fts);
	}

	/**
	 * Add a template
	 * @param fn file name (key), if exists, the template will be added, otherwise the key will be created and the given template added
	 * @param st template
	 */
	public void addTemplate(String fn, StringTemplate st){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addTemplate(st);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addTemplate(st);
			this.templates.put(fn, fts);
		}
	}

	/**
	 * Add imports to a key
	 * @param fn file name (key)
	 * @param im imports to be added to the template
	 */
	public void addImport(String fn, String im){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addImport(im);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addImport(im);
			this.templates.put(fn, fts);
		}
	}

	/**
	 * Add miscellaneous information to a template
	 * @param fn file name (key)
	 * @param key key of the misc information
	 * @param val value of the misc information
	 */
	public void addMisc(String fn, String key, String val){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addMisc(key,val);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addMisc(key,val);
			this.templates.put(fn, fts);
		}
	}

	/**
	 * Add all given templates to the list
	 * @param key key to add the templates to
	 * @param val collection of templates
	 * @return true if successful, false otherwise
	 */
	public boolean addAll(String key, Collection <StringTemplate> val){
		if(this.templates.containsKey(key)){
			return this.templates.get(key).addAllTemplates(val);
		}

		FileTemplateSingle fts=new FileTemplateSingle();
		fts.addAllTemplates(val);
		this.templates.put(key, fts);
		return true;
	}

	/**
	 * Get directory
	 * @param key key
	 * @return directory, either the target dir + local dir or the target dir only
	 */
	public String getDir(String key){
		String ret=null;
		if(this.targetDirectory==null)
			return ret;

		if(key.contains(System.getProperty("file.separator")))
			ret=this.targetDirectory+System.getProperty("file.separator")+key.substring(0,key.lastIndexOf(System.getProperty("file.separator")));
		else
			ret=this.targetDirectory.toString();
		return ret;
	}

	/**
	 * Get file
	 * @param key key
	 * @return file name
	 */
	public String getFile(String key){
		String ret;
		File f=new File(key);
		ret=f.getName();
		return ret;
	}
}
