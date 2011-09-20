/* Copyright (c) 2011-2011 Sven van der Meer
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

package org.skb.util.composite.stringtemplate;

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
import org.skb.util.composite.TSAtomic;
import org.skb.util.composite.TSAtomicAPI;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSNull;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSArrayList;
import org.skb.util.composite.util.TSArrayListString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Wrapper for the class {@link STGroupManager}
 * 
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSSTGroupManager extends TSAtomic {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSSTGroupManager.class);

	/** Managed STG */
	protected StringTemplateGroup stg=null;

	/** File name for the STG */
	protected TSAtomicAPI stgFile=null;

	/** Enum type identifying the type of the stgFile */
	public enum stgLoadType{URL, FILESYSTEM}

	/** Application name the STGManager is working for */
	protected TSString applicationName=null;

	/** Mandatory chunks, everything the STG must provide */
	protected TSLinkedHashTree chunksMandatory=null;

	/** Optionally chunks, everything the STG can provide */
	protected TSLinkedHashTree chunksOptional=null;

	/** Indicator for correct and complete initialisation */
	protected boolean loaded=false;

	/** Indicator for which lexer to be used, default is AngelB */
	protected boolean useLexerAngelB=true;


	//TODO sequence of load/testChunks is still important, should not be! needs to have two values: STG loaded and STG tested!


	/**
	 * Class constructor, initialises local fields.
	 */
	public TSSTGroupManager(){
		this.chunksMandatory=new TSLinkedHashTree();
		this.chunksOptional=new TSLinkedHashTree();

		this.stgFile=new TSNull();
		this._init();
	}

	public TSSTGroupManager(TSSTGroupManager stgm){
		this.stg=stgm.stg;
		this.stgFile=stgm.stgFile.tsCopyAtomic();
		this.applicationName=stgm.applicationName.tsCopyAtomic();
		this.chunksMandatory=stgm.chunksMandatory.tsCopyComposite();
		this.chunksOptional=stgm.chunksOptional.tsCopyComposite();
		this.loaded=stgm.loaded;
		this.useLexerAngelB=stgm.useLexerAngelB;

		this._init();
	}

	/**
	 * Initialisation.
	 */
	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_STGROUPMANAGER);
		this.typeEnum.add(TEnum.TS_ATOMIC_STGROUPMANAGER);
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

		if(this.stgFile.tsIsType(TEnum.TS_NULL)){
			logger.error(this.applicationName+": can't read internal string template, no file set"+purpose);
			return false;
		}

		//test if we can access the file via URL
		InputStream in=getClass().getResourceAsStream(this.stgFile.toString());
		if(in!=null){
			try{
				InputStreamReader isr=new InputStreamReader(in);
				if(this.useLexerAngelB==true)
					this.stg=new StringTemplateGroup(isr, AngleBracketTemplateLexer.class);
				else
					this.stg=new StringTemplateGroup(isr, DefaultTemplateLexer.class);
			} catch (Exception e) {
				logger.warn(this.applicationName+": can't read internal string template <"+this.stgFile+">"+purpose);
				return false;
			}
			logger.trace("loaded URL <"+this.stgFile+">");
		}
		else{
			try{
				if(this.useLexerAngelB==true)
					this.stg=new StringTemplateGroup(new FileReader(this.stgFile.toString()), AngleBracketTemplateLexer.class);
				else
					this.stg=new StringTemplateGroup(new FileReader(this.stgFile.toString()), DefaultTemplateLexer.class);
			} catch (Exception e1) {
				logger.error(this.applicationName+": can't find external string template <" + this.stgFile + ">"+purpose);
				return false;
			}
			logger.trace("loaded Filesystem <"+this.stgFile+">");
		}
		this.loaded=true;
		return this.testChunks();
	}


	/**
	 * Adds chunks to the mandatory chunk list
	 * @param key name of template
	 * @param value values of chunks to be added
	 */
	public void putMandatoryChunks(String key, TSArrayList value){
		this.chunksMandatory.put(key, value);
	}


	/**
	 * Adds chunks to the optional chunk list
	 * @param key name of template
	 * @param value values of chunks to be added
	 */
	public void putOptionalChunks(String key, TSArrayList value){
		this.chunksOptional.put(key, value);
	}


	/**
	 * Sets mandatory and optional chunks
	 * @param mandatory list with all mandatory chunks
	 * @param optional list with all optional chunks
	 */
	public void setChunks(TSLinkedHashTree mandatory, TSLinkedHashTree optional){
		this.chunksMandatory=mandatory;
		this.chunksOptional=optional;
	}


	/**
	 * Sets the mandatory chunks
	 * @param mandatory list with all mandatory chunks
	 */
	public void setMandatoryChunks(TSLinkedHashTree mandatory){
		this.chunksMandatory=mandatory;
	}


	/**
	 * Sets the optional chunks
	 * @param optional list with all optional chunks
	 */
	public void setOptionalChunks(TSLinkedHashTree optional){
		this.chunksOptional=optional;
	}


	/**
	 * Sets the file name for the STG
	 * @param fn file name
	 * @return true if set, false if fn was null or not of type TSString
	 */
	public boolean setSTGFile(String fn){
		boolean ret=false;
		if(fn!=null){
			this.stgFile=new TSString(fn);
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
	public boolean setSTGFile(TSBaseAPI fn){
		boolean ret=false;
		if(fn!=null&&fn.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)){
			this.stgFile=new TSString(fn.toString());
			logger.trace("got file ("+fn.toString()+") of type ("+fn.tsGetTypeString()+")");
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
				TSArrayList val=null;
				if(_b.tsIsType(TEnum.TS_COMPOSITE_ARRAYLIST))
					val=(TSArrayList)_b;
				if(val==null)
					continue;
				//Template exists, check for Arguments existence
				st=this.stg.getInstanceOf(s);
				Map<?,?> stm=st.getFormalArguments();
				for (int i=0;i<val.size();i++){
					if(!stm.containsKey(val.get(i).toString())){
						logger.error(this.applicationName+": template group <"+this.stgFile+"> with template <"+s+"> does not define argument <"+val.get(i)+">");
						System.err.println(this.applicationName+": template group <"+this.stgFile+"> with template <"+s+"> does not define argument <"+val.get(i)+">");;
						this.loaded=false;
						return false;
					}
				}
			} else {
				logger.error(this.applicationName+": template group <"+this.stgFile+"> does not specify mandatory template <"+s+">");
				System.err.println(this.applicationName+": template group <"+this.stgFile+"> does not specify mandatory template <"+s+">");
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
				TSBaseAPI _b=this.chunksOptional.get(s);
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
					logger.error(this.applicationName+": template group <"+this.stgFile+"> with template <"+s+"> does not define any optional argument <"+val+">");
					this.loaded=false;
					return false;
				}
				else if(tempList.size()>1){
					logger.error(this.applicationName+": template group <"+this.stgFile+"> with template <"+s+"> defines more than one optional argument <"+val+">");
					this.loaded=false;
					return false;
				}
			} else {
				logger.error(this.applicationName+": template group <"+this.stgFile+"> does not specify optional template <"+s+">");
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

//	@Override
//	public java.lang.String tsToString(int indent){
//		String ret=new String();
//		for(int i=indent;i>0;i--)
//			ret+=" ";
//		ret+=super.toString();
//		return ret;
//	}

	@Override
	public TSSTGroupManager tsCopyAtomic(){
		return new TSSTGroupManager(this);
	}
}
