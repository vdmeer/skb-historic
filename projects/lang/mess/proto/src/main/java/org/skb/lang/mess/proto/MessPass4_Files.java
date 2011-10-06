/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.lang.mess.proto;

import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.lang.mess.proto.constants.MessConstants;
import org.skb.util.FieldKeys;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.config.ConfigurationProperties;
import org.skb.util.classic.io.files.FileTemplateList;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.antlr.TSStringTemplate;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.lang.TSAtomList;

/**
 * Pass 4 of the MESS Parser, generating files for output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class MessPass4_Files {
	/** Logger instance */
	static Logger logger = Logger.getLogger(MessPass4_Files.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(MessParser.class);

	private FileTemplateList ftl;
	private TSAtomList atoms;
	private ConfigurationProperties prop;

	public MessPass4_Files(){
		this.ftl=new FileTemplateList();
		this.atoms=config.getAtomlist();
		this.prop=config.getProperties();
	}

	public FileTemplateList getFileTemplateList(){
		String fn;
		String pkg;
		String fileSep=System.getProperty("file.separator");
		String scopeSep=this.prop.getValue(FieldKeys.fieldCliOptionGCScopeSep).toString();

		//remove all field lists (change, requires, optional)
		String currentElem;
		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		if(size>0){
			for(int i=0;i<size;i++){
				currentElem=rows.get(i);
				String parrentId=this.atoms.getParrentId(currentElem);
				if(parrentId!=null){
					if(parrentId.endsWith(MessConstants.Tokens.messCHANGE)||parrentId.endsWith(MessConstants.Tokens.messREQUIRES)||parrentId.endsWith(MessConstants.Tokens.messOPTIONAL)){
						this.atoms.remove(currentElem);
					}
				}
			}
		}

//config.config.get(prop.getValue(MessConstants.Properties.keyTgtRuntimePkg)+"api");
//config.config.get(prop.getValue(MessConstants.Properties.keyTgtRuntimePkg)+"impl");

		//now different behaviour for SplitCode
		Boolean tgtSplitCode=false;
		try {
			tgtSplitCode=((TSBoolean)this.prop.getValue(MessConstants.Properties.keyTgtSplitCode)).tsvalue;
		} catch (Exception e) {}
		if(tgtSplitCode==false){
			//no split, so go through the atoms, put all children into the body of their parent
			//add the final template to the ftl and give back
			fn=this.prop.getValue(FieldKeys.fieldCliOptionTgtFile).toString();

			StringTemplate spec=this.atoms.getST(MessConstants.Tokens.messAT_SPEC);
			rows=new ArrayList<String>(this.atoms.getRows());
			size=rows.size();
			for(int i=1;i<size;i++){ //i=1 means we avoid the spec template itself
				if(this.atoms.getST(rows.get(i)).toString().length()!=0)
						spec.setAttribute("body", this.atoms.getST(rows.get(i)));
			}
			this.ftl.addTemplate(fn,spec);
		}
		else{
			//keep content-type, fields and messages separated, and add the extra STs for runtime plus add package names and imports
			rows=new ArrayList<String>(this.atoms.getRows());

			String domain=rows.get(1); //domain is second in list
			String domainPkg=this.prop.getValue(MessConstants.Properties.keyTgtDomainPkg).toString();
			String runtimePkg=this.prop.getValue(MessConstants.Properties.keyTgtRuntimePkg).toString();

			size=rows.size();
			for(int i=2;i<size;i++){ //i=2 means we avoid the spec and the domain templates
				//no like empty templates
				if(this.atoms.getST(rows.get(i)).toString().length()==0)
					continue;

				String current=rows.get(i);
				String currentId=current.replace(this.atoms.scope.separator(), fileSep);

				pkg=domainPkg+scopeSep+domain.toLowerCase()+scopeSep+currentId;
				fn=pkg.replace(scopeSep, fileSep);
				pkg=pkg.substring(0, pkg.lastIndexOf(fileSep));
				
				this.ftl.addTemplate(fn, this.atoms.getST(current));
				this.ftl.addMisc(fn,"package",pkg);
				if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).tsIsType(TEnum.TS_DEFAULT)){
					this.ftl.addImport(fn, runtimePkg+scopeSep+this.prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).toString());
				}
				if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).tsIsType(TEnum.TS_DEFAULT)){
					this.ftl.addImport(fn, runtimePkg+scopeSep+this.prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).toString());
				}
			}
			if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).tsIsType(TEnum.TS_DEFAULT)){
				fn=runtimePkg.replace(scopeSep, fileSep)+fileSep+this.prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).toString();
				this.ftl.addTemplate(fn, (TSStringTemplate)config.config.get(prop.getValue(MessConstants.Properties.keyTgtRuntimeAPI).toString()));
				this.ftl.addMisc(fn,"package",runtimePkg);
			}
			if(!this.prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).tsIsType(TEnum.TS_DEFAULT)){
				fn=runtimePkg.replace(scopeSep, fileSep)+fileSep+this.prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).toString();
				this.ftl.addTemplate(fn, (TSStringTemplate)config.config.get(prop.getValue(MessConstants.Properties.keyTgtRuntimeImpl).toString()));
				this.ftl.addMisc(fn,"package",runtimePkg);
			}

		}
		return this.ftl;
	}
}