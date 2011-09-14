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

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;
import org.apache.log4j.Logger;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * Manager for String Template Groups, including chunk tests.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class STGroupManager {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(STGroupManager.class);

	/** Managed STG */
	protected StringTemplateGroup stg=null;

	/** File name for the STG (local file system */
	protected TSString stgFileName=null;

	/** URL name for the STG (resource) */
	protected TSString stgUrlName=null;

	/** Application name the STGManager is working for */
	protected TSString applicationName=null;

	/** Mandatory chunks, everything the STG must provide */
	protected TSMapLH chunksMandatory=null;

	/** Optionally chunks, everything the STG can provide */
	protected TSMapLH chunksOptional=null;

	/** Indicator for correct and complete initialisation */
	protected boolean loaded=false;

	/** Indicator for which lexer to be used, default is AngelB */
	protected boolean useLexerAngelB;


	//TODO sequence of load/testChunks is still important, should not be! needs to have two values: STG loaded and STG tested!


	/**
	 * Class constructor, empty
	 */
	public STGroupManager(){
	}


	/**
	 * Returns the managed STG
	 * @return null if not set or not initialised, STG otherwise
	 */
	public StringTemplateGroup getSTG(){
		if(this.loaded==true&&this.stg!=null)
			return this.stg;
		return null;
	}


	/**
	 * Returns the isLoaded indicator
	 * @return true if STG is loaded, false otherwise. If false, some functionality might not be available.
	 */
	public boolean isLoaded(){
		return this.loaded;
	}


	/**
	 * Sets the application name
	 * @param name new application name
	 * @return true if successful, false otherwise (given name was null or not of type TSSTring)
	 */
	public boolean setApplicationName(TSBaseAPI name){
		boolean ret=true;
		if(name!=null&&name.tsIsType(TEnum.TS_ATOMIC_JAVA_STRING))
			this.applicationName=(TSString)name;
		else
			ret=false;
		return ret;
	}


	/**
	 * Sets the application name
	 * @param name new application name
	 * @return true if successful, false otherwise (given name was null)
	 */
	public boolean setApplicationName(String name){
		boolean ret=true;
		if(name!=null)
			this.applicationName=new TSString(name);
		else
			ret=false;
		return ret;
	}


	/**
	 * Loads an STG
	 * 
	 * This method tests the parameters and then calls {@link STGroupManager#loadSTG(String, String)} 
	 * @param purpose message to be used for reporting/logging
	 * @param targetLang target language of the STG to be loaded
	 * @return true if load was successful, false otherwise (purpose and targetLang were NULL)
	 */
	public boolean loadSTG(TSBaseAPI purpose, TSBaseAPI targetLang){
		if(purpose==null&&targetLang==null)
			return this.loadSTG("", "");
		if(purpose!=null&&targetLang==null)
			return this.loadSTG(purpose.toString(), "");
		return false;
	}


	/**
	 * Loads an STG
	 * 
	 * This method tests the parameters and then calls {@link STGroupManager#loadSTG(String, String)}
	 * @param purpose message to be used for reporting/logging
	 * @param targetLang target language of the STG to be loaded
	 * @return true if load was successful, false otherwise (purpose and targetLang were NULL)
	 */
	public boolean loadSTG(String purpose, TSBaseAPI targetLang){
		if(targetLang==null)
			return this.loadSTG(purpose, "");
		else
			return this.loadSTG(purpose, targetLang.toString());
	}


	/**
	 * Loads an STG
	 * @param purpose message to be used for reporting/logging
	 * @param targetLang target language of the STG to be loaded
	 * @return true if loaded, false otherwise (file name and URL not set, not able to load from URL, not able to load from file name)
	 */
	public boolean loadSTG(String purpose, String targetLang){
		if(purpose!=null&&!purpose.equals("")){
			purpose=" (purpose: "+purpose;
			if(targetLang!=null&&!targetLang.equals(""))
				purpose+=", language: "+targetLang.toString();
			purpose+=")";
		}

		if(this.stgFileName==null&&this.stgUrlName==null){
			logger.error(this.applicationName+": can't read internal string template, no file and no URL set"+purpose);
			return false;
		}

		if(this.stgUrlName!=null){
			try{
				InputStream in=getClass().getResourceAsStream(this.stgUrlName.toString());
				InputStreamReader isr=new InputStreamReader(in);
				if(this.useLexerAngelB==true)
					this.stg=new StringTemplateGroup(isr, AngleBracketTemplateLexer.class);
				else
					this.stg=new StringTemplateGroup(isr, DefaultTemplateLexer.class);
				this.stgFileName=this.stgUrlName;
			} catch (Exception e) {
				logger.error(this.applicationName+": can't read internal string template <"+this.stgUrlName+">"+purpose);
				return false;
			}
		}
		else{
			try{
				if(this.useLexerAngelB==true)
					this.stg=new StringTemplateGroup(new FileReader(this.stgFileName.toString()), AngleBracketTemplateLexer.class);
				else
					this.stg=new StringTemplateGroup(new FileReader(this.stgFileName.toString()), DefaultTemplateLexer.class);
			} catch (Exception e1) {
				logger.error(this.applicationName+": can't find external string template <" + this.stgFileName + ">"+purpose);
				return false;
/*
				try{
					InputStream in = getClass().getResourceAsStream(url);
					InputStreamReader isr = new InputStreamReader(in); 
					this.myStg = new StringTemplateGroup(isr, AngleBracketTemplateLexer.class);
					this.stgFN=url;
					System.err.println(this.name+": using internal template file <" + file + ">");
				} catch (Exception e2) {
					System.err.println(this.name+": could not read template file <" + url + ">");
					System.err.println("exception: " + e2);
					System.exit(10);
				}
*/
			}
		}
		this.loaded=true;
		return this.testChunks();
	}


	/**
	 * Adds chunks to the mandatory chunk list
	 * @param key name of template
	 * @param value values of chunks to be added
	 */
	public void putMandatoryChunks(String key, TSArrayListString value){
		this.chunksMandatory.put(key, value);
	}


	/**
	 * Adds chunks to the optional chunk list
	 * @param key name of template
	 * @param value values of chunks to be added
	 */
	public void putOptionalChunks(String key, TSArrayListString value){
		this.chunksOptional.put(key, value);
	}


	/**
	 * Sets mandatory and optional chunks
	 * @param mandatory list with all mandatory chunks
	 * @param optional list with all optional chunks
	 */
	public void setChunks(TSMapLH mandatory, TSMapLH optional){
		this.chunksMandatory=mandatory;
		this.chunksOptional=optional;
	}


	/**
	 * Sets the mandatory chunks
	 * @param mandatory list with all mandatory chunks
	 */
	public void setMandatoryChunks(TSMapLH mandatory){
		this.chunksMandatory=mandatory;
	}


	/**
	 * Sets the optional chunks
	 * @param optional list with all optional chunks
	 */
	public void setOptionalChunks(TSMapLH optional){
		this.chunksOptional=optional;
	}


	/**
	 * Sets the file name for the STG
	 * @param fn file name
	 * @return true if set, false if fn was null or not of type TSString
	 */
	public boolean setSTGFileName(String fn){
		boolean ret=false;
		if(fn!=null){
			this.stgFileName=new TSString(fn);
			logger.trace("got FILE ("+fn.toString()+") of type (String)");
			ret=true;
		}
		return ret;
	}


	/**
	 * Sets the file name for the STG
	 * @param fn file name
	 * @return true if set, false if fn was null or not of type TSString
	 */
	public boolean setSTGFileName(TSString fn){
		boolean ret=false;
		if(fn!=null){
			this.stgFileName=fn;
			logger.trace("got FILE ("+fn.toString()+") of type ("+fn.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	/**
	 * Sets the file name for the STG
	 * @param fn file name
	 * @return true if set, false if fn was null or not of type TSString
	 */
	public boolean setSTGFileName(TSAtomicAPI fn){
		boolean ret=false;
		if(fn!=null&&fn.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.stgFileName=(TSString)fn;
			logger.trace("got FILE ("+fn.toString()+") of type ("+fn.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	/**
	 * Sets the file name for the STG
	 * @param fn file name
	 * @return true if set, false if fn was null or not of type TSString
	 */
	public boolean setSTGFileName(TSBaseAPI fn){
		boolean ret=false;
		if(fn!=null&&fn.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.stgFileName=(TSString)fn;
			logger.trace("got FILE ("+fn.toString()+") of type ("+fn.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	/** 
	 * Sets the URL name for the STG
	 * @param url URL name
	 * @return true if set, false if url was null or not of type TSString
	 */
	public boolean setSTGUrlName(String url){
		boolean ret=false;
		if(url!=null){
			this.stgUrlName=new TSString(url);
			logger.trace("got URL ("+url.toString()+") of type (String)");
			ret=true;
		}
		return ret;
	}


	/** 
	 * Sets the URL name for the STG
	 * @param url URL name
	 * @return true if set, false if url was null or not of type TSString
	 */
	public boolean setSTGUrlName(TSString url){
		boolean ret=false;
		if(url!=null){
			this.stgUrlName=url;
			logger.trace("got URL ("+url.toString()+") of type ("+url.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	public boolean setSTGUrlName(TSAtomicAPI url){
		boolean ret=false;
		if(url!=null&&url.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.stgUrlName=(TSString)url;
			logger.trace("got URL ("+url.toString()+") of type ("+url.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	public boolean setSTGUrlName(TSBaseAPI url){
		boolean ret=false;
		if(url!=null&&url.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.stgUrlName=(TSString)url;
			logger.trace("got URL ("+url.toString()+") of type ("+url.tsGetTypeString()+")");
			ret=true;
		}
		return ret;
	}


	/**
	 * Tests the currently set mandatory and optional chunks for the STG
	 * @return true if everything was ok, false otherwise (error messages in the log)
	 */
	public boolean testChunks(){
		return (this.testMandatoryChunks()&this.testOptionalChunks());
	}


	/**
	 * Tests the currently set mandatory chunks for the STG
	 * @return true if everything was ok, false otherwise (error messages in the log)
	 */
	public boolean testMandatoryChunks(){
		if(this.loaded==false)
			return false;
		else if(this.chunksMandatory==null)
			return true;
		else if(this.chunksMandatory.size()==0)
			return true;

		Set<?> stNames=this.stg.getTemplateNames();
		StringTemplate st;
		for (String s:this.chunksMandatory.keySet()){
			//check if our Templates exist
			if(stNames.contains(s)){
				TSBaseAPI _b=this.chunksMandatory.get(s);
				TSArrayListString val=null;
				if(_b.tsIsType(TEnum.TS_ATOMIC_ARRAYLIST_STRING))
					val=(TSArrayListString)_b;
				if(val==null)
					continue;
				//Template exists, check for Arguments existence
				st=this.stg.getInstanceOf(s);
				Map<?,?> stm=st.getFormalArguments();
				for (int i=0;i<val.size();i++){
					if(!stm.containsKey(val.get(i).toString())){
						logger.error(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> does not define argument <"+val.get(i)+">");
						this.loaded=false;
						return false;
					}
				}
			} else {
				logger.error(this.applicationName+": template group <"+this.stgFileName+"> does not specify mandatory template <"+s+">");
				this.loaded=false;
				return false;
			}
		}
		return true;
	}



	/**
	 * Tests the currently set optional chunks for the STG
	 * @return true if everything was ok, false otherwise (error messages in the log)
	 */
	public boolean testOptionalChunks(){
		if(this.loaded==false)
			return false;
		else if(this.chunksOptional==null)
			return true;
		else if(this.chunksOptional.size()==0)
			return true;

		TSArrayListString tempList = new TSArrayListString();
		Set<?> tName=this.stg.getTemplateNames();
		StringTemplate st;
		for (String s:this.chunksOptional.keySet()){
			//check if our Templates exist
			if(tName.contains(s)){
				TSBaseAPI _b=this.chunksMandatory.get(s);
				TSArrayListString val=null;
				if(_b.tsIsType(TEnum.TS_ATOMIC_ARRAYLIST_STRING))
					val=(TSArrayListString)_b;
				if(val==null)
					continue;
				//Template exists, check for optional Arguments existence
				st=this.stg.getInstanceOf(s);
				Map<?,?> stm=st.getFormalArguments();
				tempList.clear();
				for (int i = 0; i < val.size(); i++){
					if(stm.containsKey(val.get(i).toString()))
						tempList.add(val.get(i));
				}
				if(tempList.isEmpty()){
					logger.error(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> does not define any optional argument <"+val+">");
					this.loaded=false;
					return false;
				}
				else if(tempList.size()>1){
					logger.error(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> defines more than one optional argument <"+val+">");
					this.loaded=false;
					return false;
				}
			} else {
				logger.error(this.applicationName+": template group <"+this.stgFileName+"> does not specify optional template <"+s+">");
				this.loaded=false;
				return false;
			}
		}
		return true;
	}



	@Override
	public String toString(){
		if(this.loaded==true&&this.stg!=null)
			return this.stg.toString();
		return "";
	}


	/**
	 * Use the Angel Bracket lexer
	 */
	public void useLexerAngelB(){
		this.useLexerAngelB=true;
	}


	/**
	 * Use the StringTemplate default lexer
	 */
	public void useLexerDefault(){
		this.useLexerAngelB=false;
	}
}
