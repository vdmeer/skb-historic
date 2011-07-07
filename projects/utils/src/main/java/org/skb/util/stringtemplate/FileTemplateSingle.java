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

package org.skb.util.stringtemplate;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.antlr.stringtemplate.StringTemplate;

/**
 * A single file template maintaining everything necessary to write a file.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class FileTemplateSingle {
	LinkedHashSet<StringTemplate> templates;
	LinkedHashSet<String> imports;
	LinkedHashMap<String, String> misc;

	public FileTemplateSingle(){
		this.templates=new LinkedHashSet<StringTemplate>();
		this.imports=new LinkedHashSet<String>();
		this.misc=new LinkedHashMap<String, String>();
	}

	public FileTemplateSingle(LinkedHashSet<StringTemplate> lhsST, LinkedHashSet<String> lhsIM, LinkedHashMap<String, String> lhsMisc){
		this.templates=new LinkedHashSet<StringTemplate>(lhsST);
		this.imports=new LinkedHashSet<String>(lhsIM);
		this.misc=new LinkedHashMap<String, String>(lhsMisc);
	}

	public void addTemplate(StringTemplate st){this.templates.add(st);}
	public void addImport(String im){this.imports.add(im);}
	public void addMisc(String k, String v){this.misc.put(k,v);}

	public boolean addAllTemplates(Collection <StringTemplate> ts){return this.templates.addAll(ts);};
	public boolean addAllImports(Collection <String> ts){return this.imports.addAll(ts);};
	public void putAllMisc(Map <String, String> ms){this.misc.putAll(ms);};

	public LinkedHashSet<StringTemplate> getTemplates(){return this.templates;}
	public LinkedHashSet<String> getImports(){return this.imports;}
	public LinkedHashMap<String, String> getMisc(){return this.misc;}

	public int sizeTemplates(){return this.templates.size();}
	public int sizeImports(){return this.imports.size();}
	public int sizeMisc(){return this.misc.size();}
}
