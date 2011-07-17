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
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.atomic.util.OatArrayListString;
import org.skb.util.types.base.OatBaseAtomic;
import org.skb.util.types.composite.util.OatMapLH;

/**
 * A manager for String Template Groups, including chunk tests.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class STGManager {
	protected StringTemplateGroup stg=null;
	protected OatString stgFileName=null;
	protected OatString stgUrlName=null;

	protected OatString applicationName=null;

	//protected OatString stgLanguage=null;

	protected OatMapLH chunksMandatory=null;
	protected OatMapLH chunksOptional=null;

	protected boolean loaded=false;
	protected boolean useLexerAngelB;

	public STGManager(){}

	public StringTemplateGroup getSTG(){
		if(this.loaded==true&&this.stg!=null)
			return this.stg;
		return null;
	}

	public boolean isLoaded(){
		return this.loaded;
	}

	public void setApplicationName(OatString name){
		if(name!=null)
			this.applicationName=name;		
	}

	public void setApplicationName(String name){
		if(name!=null)
			this.applicationName=new OatString(name);		
	}

	public boolean loadSTG(OatBaseAtomic purpose, OatBaseAtomic targetLang){
		if(purpose==null&&targetLang==null)
			return this.loadSTG("", "");
		if(purpose!=null&&targetLang==null)
			return this.loadSTG(purpose.toString(), "");
		return false;
	}

	public boolean loadSTG(String purpose, OatBaseAtomic targetLang){
		if(targetLang==null)
			return this.loadSTG(purpose, "");
		else
			return this.loadSTG(purpose, targetLang.toString());
	}

	public boolean loadSTG(String purpose, String targetLang){
		if(purpose!=null&&!purpose.equals("")){
			purpose=" (purpose: "+purpose;
			if(targetLang!=null&&!targetLang.equals(""))
				purpose+=", language: "+targetLang.toString();
			purpose+=")";
		}

		if(this.stgFileName==null&&this.stgUrlName==null){
			System.err.println(this.applicationName+": can't read internal string template, no file and no URL set"+purpose);
			return false;
		}

		if(this.stgFileName==null){
			try{
				InputStream in=getClass().getResourceAsStream(this.stgUrlName.toString());
				InputStreamReader isr=new InputStreamReader(in);
				if(this.useLexerAngelB==true)
					this.stg=new StringTemplateGroup(isr, AngleBracketTemplateLexer.class);
				else
					this.stg=new StringTemplateGroup(isr, DefaultTemplateLexer.class);
				this.stgFileName=this.stgUrlName;
			} catch (Exception e) {
				System.err.println(this.applicationName+": can't read internal string template <"+this.stgUrlName+">"+purpose);
				//System.exit(10);
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
				System.err.println(this.applicationName+": can't find external string template <" + this.stgFileName + ">"+purpose);
				//System.exit(10);
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

	public void putMandatoryChunks(String key, OatArrayListString value){
		this.chunksMandatory.put(key, value);
	}

	public void putOptionalChunks(String key, OatArrayListString value){
		this.chunksOptional.put(key, value);
	}

	public void setChunks(OatMapLH mandatory, OatMapLH optional){
		this.chunksMandatory=mandatory;
		this.chunksOptional=optional;
	}

	public void setMandatoryChunks(OatMapLH mandatory){
		this.chunksMandatory=mandatory;
	}

	public void setOptionalChunks(OatMapLH optional){
		this.chunksOptional=optional;
	}

	public void setSTGFileName(String fn){
		this.stgFileName=new OatString(fn);
	}

	public void setSTGFileName(OatString fn){
		this.stgFileName=fn;
	}

	public void setSTGFileName(OatBaseAtomic fn){
		if(fn!=null&&fn.isType(ATType.OAT_ATOMIC_STRING))
			this.stgFileName=(OatString)fn;
	}

	public void setSTGUrlName(String fn){
		this.stgUrlName=new OatString(fn);
	}

	public void setSTGUrlName(OatString fn){
		this.stgUrlName=fn;
	}

	public void setSTGUrlName(OatBaseAtomic fn){
		if(fn!=null&&fn.isType(ATType.OAT_ATOMIC_STRING))
			this.stgUrlName=(OatString)fn;
	}

	public boolean testChunks(){
		return (this.testMandatoryChunks()&this.testOptionalChunks());
	}

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
				OatArrayListString val=this.chunksMandatory.get(s).getValOatArrayListString();
				if(val==null)
					continue;
				//Template exists, check for Arguments existence
				st=this.stg.getInstanceOf(s);
				Map<?,?> stm=st.getFormalArguments();
				for (int i=0;i<val.size();i++){
					if(!stm.containsKey(val.get(i))){
						//Template Argument doesn't exist, notify and exit
						System.err.println(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> does not define argument <"+val.get(i)+">");
//						System.err.println("exception: " + e);
						//System.exit(1);
						this.loaded=false;
						return false;
					}
				}
			} else {
				System.err.println(this.applicationName+": template group <"+this.stgFileName+"> does not specify mandatory template <"+s+">");
//				System.err.println("exception: " + e);
				//System.exit(1);
				this.loaded=false;
				return false;
			}
		}
		return true;
	}

	public boolean testOptionalChunks(){
		if(this.loaded==false)
			return false;
		else if(this.chunksOptional==null)
			return true;
		else if(this.chunksOptional.size()==0)
			return true;

		OatArrayListString tempList = new OatArrayListString();
		Set<?> tName=this.stg.getTemplateNames();
		StringTemplate st;
		for (String s:this.chunksOptional.keySet()){
			//check if our Templates exist
			if(tName.contains(s)){
				OatArrayListString val=this.chunksMandatory.get(s).getValOatArrayListString();
				if(val==null)
					continue;
				//Template exists, check for optional Arguments existence
				st=this.stg.getInstanceOf(s);
				Map<?,?> stm=st.getFormalArguments();
				tempList.clear();
				for (int i = 0; i < val.size(); i++){
					if(stm.containsKey(val.get(i)))
						tempList.add(val.get(i));
				}
				if(tempList.isEmpty()){
					System.err.println(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> does not define any optional argument <"+val+">");
//					System.err.println("exception: " + e);
					//System.exit(1);
					this.loaded=false;
					return false;
				}
				else if(tempList.size()>1){
					System.err.println(this.applicationName+": template group <"+this.stgFileName+"> with template <"+s+"> defines more than one optional argument <"+val+">");
//					System.err.println("exception: " + e);
					//System.exit(1);
					this.loaded=false;
					return false;
				}
			} else {
				System.err.println(this.applicationName+": template group <"+this.stgFileName+"> does not specify optional template <"+s+">");
//				System.err.println("exception: " + e);
				//System.exit(1);
				this.loaded=false;
				return false;
			}
		}
		return true;
	}

	public String toString(){
		if(this.loaded==true&&this.stg!=null)
			return this.stg.toString();
		return "";
	}

	public void useLexerAngelB(){
		this.useLexerAngelB=true;
	}

	public void useLexerDefault(){
		this.useLexerAngelB=false;
	}
}
