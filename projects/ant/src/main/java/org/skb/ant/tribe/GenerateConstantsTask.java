/* Copyright (c) 2011-2011 Sven van der Meer (sven@vandermeer.de)
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

package org.skb.ant.tribe;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

import org.skb.tribe.LanguageConfiguration;
import org.skb.tribe.LanguageConfigurationConstants;
import org.skb.types.atomic.java.OatString;
import org.skb.types.composite.util.OatMapLH;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Ant task for generating constant classes for parsers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class GenerateConstantsTask extends Task{
	private String pkgname=null;
	private String classname=null;
	private String jsonfile=null;
	private String destdir=null;
	private String destfile=null;

	private String stgurl=null; //="org/skb/ant/tribe/constants.stg";

    public void setPkgname(String s){
        this.pkgname=s;
    }

    public void setClassname(String s){
        this.classname=s;
    }

    public void setJsonfile(String s){
        this.jsonfile=s;
    }

    public void setDestdir(String s){
        this.destdir=s;
    }

    public void setDestfile(String s){
        this.destfile=s;
    }

    public void setStgurl(String s){
        this.stgurl=s;
    }

    public void execute() throws BuildException {
    	if(this.pkgname==null)
    		throw new BuildException("no package name given");
    	if(this.classname==null)
    		throw new BuildException("no class name given");
    	if(this.jsonfile==null)
    		throw new BuildException("no json file given");
    	if(this.destdir==null)
    		throw new BuildException("no destination dir given");
    	if(this.destfile==null)
    		throw new BuildException("no destination file given");

    	File jfh=new File(this.jsonfile);
    	if(!jfh.canRead())
    		throw new BuildException("cannot read the json file <"+this.jsonfile+">");

    	OatMapLH constProperties=new OatMapLH();
    	OatMapLH constRules=new OatMapLH();
    	OatMapLH constTokens=new OatMapLH();

    	LanguageConfiguration cfg=LanguageConfiguration.getInstance();
   		cfg.read(jfh);
    	OatMapLH map=null;
    	map=cfg.getLanguageTokens();
    	if(map!=null&&map.size()>0){
    		Set<String> cols=map.keySet();
    		for (String s:cols){
    			try{
    				OatString cid=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensConstID).getValOatAtomicString();
    			    OatString cval=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBLangTokensConstVal).getValOatAtomicString();
    		    	constTokens.put(cid, cval);
    		    } catch (Exception e){}
    		}
    	}

    	map=cfg.getLanguageRules();
    	if(map!=null&&map.size()>0){
				for(String k:map.keySet()){
					if(map.containsKey(k+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationConstID))
						constRules.put(map.get(k+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationConstID).toString(), new OatString(k));
				}
    	}

    	map=cfg.getConfiguration();
    	if(map!=null&&map.size()>0){
			if(map.containsKey(LanguageConfigurationConstants.Paths.SKBLangConfiguration)){
				for(String s:map.get(LanguageConfigurationConstants.Paths.SKBLangConfiguration).getValOatMapLH().keySet()){
					constProperties.put(map.get(LanguageConfigurationConstants.Paths.SKBLangConfiguration+"/"+s+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationConstID).toString(), s);
				}
			}

    	if(map.containsKey(LanguageConfigurationConstants.Paths.SKBLangTargets)){
    		for(String s:map.get(LanguageConfigurationConstants.Paths.SKBLangTargets).getValOatMapLH().keySet()){
    			OatMapLH newMap=map.get(LanguageConfigurationConstants.Paths.SKBLangTargets+"/"+s+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationCli).getValOatMapLH();
    			for(String k:newMap.keySet()){
    				if(newMap.containsKey(k+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationConstID))
    					constProperties.put(newMap.get(k+"/"+LanguageConfigurationConstants.Fields.SKBLangTargetConfigurationConstID).toString(), new OatString(k));
    			}
    		}
    	}
    }



		StringTemplateGroup stg=null;
		try{
			InputStream in=this.getClass().getResourceAsStream(this.stgurl);
			InputStreamReader isr=new InputStreamReader(in);
			stg=new StringTemplateGroup(isr, DefaultTemplateLexer.class);
		} catch (Exception e) {
			throw new BuildException("can't read string template group from URL <"+this.stgurl+">");
		}

		StringTemplate template;
		template=stg.getInstanceOf("doConstants");
		template.setAttribute("package", this.pkgname);
		template.setAttribute("classname", this.classname);
		template.setAttribute("properties", constProperties);
		template.setAttribute("rules", constRules);
		template.setAttribute("tokens", constTokens);
		template.setAttribute("origfile", this.jsonfile);
		File outputFile=new File(this.destdir+"/"+this.destfile);
		FileWriter aout;
		try{
			aout=new FileWriter(outputFile);
			aout.write(template.toString());
			aout.write("\r\n");
			aout.flush();
			aout.close();
		}catch(Exception e){
			throw new BuildException("cannot write to output file <"+this.destfile+"> in directory <"+this.destdir+">");
		}
    }
}
