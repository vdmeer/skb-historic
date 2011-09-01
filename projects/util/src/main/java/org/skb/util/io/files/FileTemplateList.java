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

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.antlr.stringtemplate.StringTemplate;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSString;

/**
 * A list of file templates that a parser/compiler can use/generate to produce output files.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class FileTemplateList {
	private TreeMap<String, FileTemplateSingle> templates;
	private TSString targetDirectory=null;

	public FileTemplateList(){
		this.templates=new TreeMap<String, FileTemplateSingle>();
	}

	public FileTemplateList(TreeMap<String, FileTemplateSingle> ftl){
		this.templates=new TreeMap<String, FileTemplateSingle>(ftl);
	}

	public void init(TSBase targetDir){
		if(targetDir!=null)
			this.targetDirectory=new TSString(targetDir.toString());
	}

	public boolean containsKey(String k){return this.templates.containsKey(k);}
	public int size(){return this.templates.size();}
	public Set<Map.Entry<String, FileTemplateSingle>> entrySet(){return this.templates.entrySet();}
	public FileTemplateSingle get(String k){return this.templates.get(k);}
	public TreeMap<String, FileTemplateSingle> getList(){return this.templates;}

	public void add(String fn, FileTemplateSingle fts){
		this.templates.put(fn, fts);
	}

	public void addTemplate(String fn, StringTemplate st){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addTemplate(st);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addTemplate(st);
			this.templates.put(fn, fts);
		}
	}

	public void addImport(String fn, String im){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addImport(im);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addImport(im);
			this.templates.put(fn, fts);
		}
	}

	public void addMisc(String fn, String k, String v){
		if(this.templates.containsKey(fn))
			this.templates.get(fn).addMisc(k,v);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addMisc(k,v);
			this.templates.put(fn, fts);
		}
	}

	//LinkedHashSet Functions
	public boolean addAll(String k, Collection <StringTemplate> v){
		if(this.templates.containsKey(k))
			return this.templates.get(k).addAllTemplates(v);
		else{
			FileTemplateSingle fts=new FileTemplateSingle();
			fts.addAllTemplates(v);
			this.templates.put(k, fts);
			return true;
		}
	}

	//Specific Functions
	public String getDir(String k){
		//return either the TGT Dir + local dir
		//or just the TGT Dir
		String ret=null;
		if(this.targetDirectory==null)
			return ret;

		if(k.contains(System.getProperty("file.separator")))
			ret=this.targetDirectory+System.getProperty("file.separator")+k.substring(0,k.lastIndexOf(System.getProperty("file.separator")));
		else
			ret=this.targetDirectory.toString();
		return ret;
	}

	public String getFile(String k){
		String ret;
		File f=new File(k);
		ret=f.getName();
		return ret;
	}
}
