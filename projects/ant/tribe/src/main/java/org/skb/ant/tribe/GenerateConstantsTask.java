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

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.skb.util.FieldKeys;
import org.skb.util.PathKeys;
import org.skb.util.classic.config.Configuration;
import org.skb.util.classic.misc.Json2Oat;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Ant task for generating constant classes for parsers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class GenerateConstantsTask extends Task{
	/** package name the constants are generated for */
	private String pkgname=null;

	/** Class name the constants are maintained by */
	private String classname=null;

	/** source JSON file */
	private String jsonfile=null;

	/** destination directory, a JAVA package */
	private String destdir=null;

	/** destination file name, a JAVA file */
	private String destfile=null;

	/** URL for the StringTemplate used to generate JAVA output */
	private String stgurl=null; //="/org/skb/ant/tribe/constants.stg";

	/**
	 * Sets the package name field.
	 * @param s name of the package the constants are generated for
	 */
    public void setPkgname(String s){
        this.pkgname=s;
    }


    /**
     * Sets the class name field.
     * @param s class name the contants are maintained by
     */
    public void setClassname(String s){
        this.classname=s;
    }


    /**
     * Sets the JSON source file field.
     * @param s JSON source file to read constant specifications from
     */
    public void setJsonfile(String s){
        this.jsonfile=s;
    }


    /**
     * Sets the destination directory field.
     * @param s destination directory, a JAVA package
     */
    public void setDestdir(String s){
        this.destdir=s;
    }


    /**
     * Sets the destination file name field.
     * @param s destination file name, needs to be consistent with JAVA naming conventions (same as the package name)
     */
    public void setDestfile(String s){
        this.destfile=s;
    }


    /**
     * Sets the StringTemplate field.
     * @param s template to be used to generate JAVA output
     */
    public void setStgurl(String s){
        this.stgurl=s;
    }


    /**
     * Executes the task.
     * 
     * <p>
     * 		This method is called by ANT when calling the ant task. It first checks that all fields are set (not null, not empty).
     * 		Throws a BuildException if fields are not set, proceeds to read the JSON file and generates output otherwise.
     * </p>
	 * <p>
	 * 		{@link Configuration} is used to parse the JSON source file and to retrieve properties, rules and tokens. For tokens, the following three
	 * 		JSON fields are processed:
	 * 		<ul>
	 * 			<li>{@link org.skb.util.FieldKeys#fieldLangTargetConstantIdent} - as key for the resulting map</li>
	 * 			<li>{@link org.skb.util.FieldKeys#fieldLangTargetConstantValue} - as "value"</li>
	 * 			<li>{@link org.skb.util.FieldKeys#fieldLangTargetConstantJavadoc} - as "javadoc"</li>
	 * 		</ul>
	 * 		For rules, the JSON source can have an map with rule specifications each of which is a key/map pair (the map holding the details). This map
	 * 		is then used in the following way:
	 * 		<ul>
	 * 			<li>{@link org.skb.util.FieldKeys#fieldLangTargetConstantIdent} - as key for the resulting map</li>
	 * 			<li>the key providing {@link org.skb.util.FieldKeys#fieldLangTargetConstantIdent} - as "value"</li>
	 * 			<li>the key providing {@link org.skb.util.FieldKeys#fieldLangTargetConstantJavadoc} - as "javadoc"</li>
	 * 		</ul>
	 * 		For properties (usually access to some configuration information in a property map), the JSON source file should to provide the path
	 * 		{@link org.skb.util.PathKeys#pathConfigurationParserTribe} for general properties and the path
	 * 		{@link org.skb.util.PathKeys#patConfigurationParserLang} for target specific configurations. The general configuration and each of the target
	 * 		configurations will be processed and JSON fields used in the following way:
	 * 		<ul>
	 * 			<li>path plus specific key plus {@link org.skb.util.FieldKeys#fieldLangTargetConstantIdent} - as key for the resulting map</li>
	 * 			<li>path plus specific key - as "value"</li> 
	 * 			<li>path plus specific key plus {@link org.skb.util.FieldKeys#fieldLangTargetConstantJavadoc} - as "javadoc"</li>
	 * 		</ul>
 	 * </p>
     */
    @Override
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

    	TSLinkedHashTree constProperties=new TSLinkedHashTree();
    	TSLinkedHashTree constRules=new TSLinkedHashTree();
    	TSLinkedHashTree constTokens=new TSLinkedHashTree();

    	Configuration config=Configuration.getConfiguration(GenerateConstantsTask.class);

		try{
			Json2Oat j2o=new Json2Oat();
			TSBaseAPI c=j2o.read(jfh);
			if(c.tsIsType(TEnum.TS_COMPOSITE_MAP_LH)){
				config.config.put(PathKeys.pathConfigurationParserTribe, ((TSLinkedHashTree)c).get(PathKeys.pathConfigurationParserTribe));
				config.config.put(PathKeys.patConfigurationParserLang, ((TSLinkedHashTree)c).get(PathKeys.patConfigurationParserLang));
			}
		}
		catch (Exception e){
			throw new BuildException("problems parsing json file <"+this.jsonfile+">\n"+e);
		}

    	TSLinkedHashTree map=null;

    	map=(TSLinkedHashTree)config.config.get(PathKeys.pathConfigurationParserLangTokens);
    	if(map!=null&&map.size()>0){
    		Set<String> cols=map.keySet();
    		for (String s:cols){
    			try{
    				TSString cid=(TSString)map.get(s+"/"+FieldKeys.fieldLangTargetConstantIdent);
    			    TSString cval=(TSString)map.get(s+"/"+FieldKeys.fieldLangTargetConstantValue);
    			    TSString jdoc=(TSString)map.get(s+"/"+FieldKeys.fieldLangTargetConstantJavadoc);

    			    TSLinkedHashTree _put=new TSLinkedHashTree();
					_put.put("value", cval);
					_put.put("javadoc", jdoc);
    			    constTokens.put(cid, _put);
    		    } catch (Exception e){}
    		}
    	}

    	map=(TSLinkedHashTree)config.config.get(PathKeys.pathConfigurationParserLangRules);
    	if(map!=null&&map.size()>0){
				for(String k:map.keySet()){
					if(map.containsKey(k+"/"+FieldKeys.fieldLangTargetConstantIdent)){
						TSLinkedHashTree _put=new TSLinkedHashTree();
						_put.put("value", new TSString(k));
						if(map.containsKey(k+"/"+FieldKeys.fieldLangTargetConstantJavadoc))
							_put.put("javadoc", map.get(k+"/"+FieldKeys.fieldLangTargetConstantJavadoc).toString());
						constRules.put(map.get(k+"/"+FieldKeys.fieldLangTargetConstantIdent).toString(), _put);
					}
				}
    	}

    	map=config.config;
    	if(map!=null&&map.size()>0){
			if(map.containsKey(PathKeys.patConfigurationParserLangConfiguration)){
				TSLinkedHashTree _m=(TSLinkedHashTree)map.get(PathKeys.patConfigurationParserLangConfiguration);
				for(String s:_m.keySet()){
					if(map.containsKey(PathKeys.patConfigurationParserLangConfiguration+"/"+s+"/"+FieldKeys.fieldLangTargetConstantIdent)){
						TSLinkedHashTree _put=new TSLinkedHashTree();
						_put.put("value", s);
						if(map.containsKey(PathKeys.patConfigurationParserLangConfiguration+"/"+s+"/"+FieldKeys.fieldLangTargetConstantJavadoc))
							_put.put("javadoc", map.get(PathKeys.patConfigurationParserLangConfiguration+"/"+s+"/"+FieldKeys.fieldLangTargetConstantJavadoc).toString());
						constProperties.put(map.get(PathKeys.patConfigurationParserLangConfiguration+"/"+s+"/"+FieldKeys.fieldLangTargetConstantIdent).toString(), _put);
					}
				}
			}
			if(map.containsKey(PathKeys.pathConfigurationParserLangTargets)){
				TSLinkedHashTree _m=(TSLinkedHashTree)map.get(PathKeys.pathConfigurationParserLangTargets);
				for(String s:_m.keySet()){
					TSLinkedHashTree newMap=(TSLinkedHashTree)map.get(PathKeys.pathConfigurationParserLangTargets+"/"+s+"/"+FieldKeys.fieldLangTargetConfigCli);
					for(String k:newMap.keySet()){
						if(newMap.containsKey(k+"/"+FieldKeys.fieldLangTargetConstantIdent)){
							TSLinkedHashTree _put=new TSLinkedHashTree();
							_put.put("value", new TSString(k));
							if(newMap.containsKey(k+"/"+FieldKeys.fieldLangTargetConstantJavadoc))
								_put.put("javadoc", newMap.get(k+"/"+FieldKeys.fieldLangTargetConstantJavadoc));
							constProperties.put(newMap.get(k+"/"+FieldKeys.fieldLangTargetConstantIdent).toString(), _put);
						}
					}
				}
			}
    	}

		StringTemplateGroup stg=null;
		try{
			InputStream in=this.getClass().getResourceAsStream(this.stgurl);
			InputStreamReader isr=new InputStreamReader(in);
			//stg=new StringTemplateGroup(isr, AngleBracketTemplateLexer.class);
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
			throw new BuildException("cannot write to output file <"+this.destfile+"> in directory <"+this.destdir+">\n"+e);
		}

		template=stg.getInstanceOf("doPackageHTML");
		outputFile=new File(this.destdir+"/package.html");
		try{
			aout=new FileWriter(outputFile);
			aout.write(template.toString());
			aout.write("\r\n");
			aout.flush();
			aout.close();
		}catch(Exception e){
			throw new BuildException("cannot write to output file <package.html> in directory <"+this.destdir+">\n"+e);
		}
    }
}
