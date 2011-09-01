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

package org.skb.tribe;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.skb.util.misc.ReportManager;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSAtomic;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.api.TSTableRowAPI;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSTable;

/**
 * Tribes interface to language parsers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
/**
 * @author vdmeer
 *
 */
public class LanguageList implements TSAtomic {
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));
	protected final EnumSet<TEnum> typeEnum=EnumSet.of(TEnum.TS_BASE);

	private TribeProperties prop=TribeProperties.getInstance();
	private ReportManager repMgr=ReportManager.getInstance();

	private TSTable llist=null;

	/**
	 * String constant to access a specific language 
	 */
	public final static String llValLang	= "ll:lang";

	/**
	 * String constant to access supported source languages 
	 */
	public final static String llValXS		= "ll:xs";

	/**
	 * String constant to access supported target languages 
	 */
	public final static String llValXT		= "ll:xt";

	private String srcLanguage=null;
	private String tgtLanguage=null;

	/**
	 * Class Constructor initialising local tables 
	 */
	public LanguageList(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_UNKNOWN); // TODO add proper type
		this.typeEnum.add(TEnum.TS_UNKNOWN);

		this.llist=new TSTable();
		this.llist.setColumns(LanguageList.class.getName(), "llVal");
	}

	/**
	 * Add languages to the local table
	 * @param lp array of language parsers
	 */
	public void addLanguages(LanguageParser[] lp){
		for(int i=0;i<lp.length;i++){
			this.llist.addRow(lp[i].xs());
			this.llist.put(lp[i].xs(), LanguageList.llValLang, lp[i]);
			this.llist.put(lp[i].xs(), LanguageList.llValXS, lp[i].xs());
			this.llist.put(lp[i].xs(), LanguageList.llValXT, lp[i].xt());
		}
	}

	/**
	 * Get mappings supported by registered language parsers
	 * @return TreeMap map of source languages with associated target languages
	 */
	public TreeMap<TSString, TSArrayListString> getMappings(){
		TreeMap<TSString, TSArrayListString> ret=new TreeMap<TSString, TSArrayListString>();
		Collection<String> keys = this.llist.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext(); ){
			TSTableRowAPI row=this.llist.get(i.next());
			ret.put((TSString)row.get(LanguageList.llValXS), (TSArrayListString)row.get(LanguageList.llValXT));
		}
		return ret;
	}

	public String toString(){
		String ret="";
		Collection<String> keys = this.llist.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext(); ){
			String key=i.next();
			ret+="\n          source:" + this.llist.get(key, LanguageList.llValXS).toString() + " -> targets:" + this.llist.get(key, LanguageList.llValXT).toString();
		}
    	return ret;
	}

	public Boolean setSelectedLanguage(TSBase srcLang, TSBase tgtLang, Boolean gc){
		if(srcLang!=null&&!srcLang.tsIsType(TEnum.TS_NULL))
			this.srcLanguage=srcLang.toString();
		if(tgtLang!=null&&!tgtLang.tsIsType(TEnum.TS_NULL))
			this.tgtLanguage=tgtLang.toString();
		if(gc==true&&this.tgtLanguage==null)
			return false;
		if(!this.llist.containsKey(this.srcLanguage))
			return false;

		if(this.tgtLanguage!=null){
			TSBase ols=this.llist.get(this.srcLanguage, LanguageList.llValXT);
			if(ols.tsIsType(TEnum.TS_ATOMIC_ARRAYLIST_STRING)&&!((TSArrayListString)ols).contains(this.tgtLanguage))
				return false;
		}

		((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).setOptions();
		this.prop.addProperties(((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).getMap());
		((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).loadTarget();
		return true;
	}

	public Boolean checkSelectedLanguage(){
		if(this.srcLanguage==null){
			this.repMgr.reportError("-  no source language specified");
			return false;
		}

        Boolean gc=false;
		try {
			gc=((TSBoolean)prop.getValue(TribeProperties.tpmKeyGC)).tsvalue;
		} catch (Exception e) {}

		if(gc==true&&this.tgtLanguage==null){
			this.repMgr.reportError("-  no target language specified");
			return false;
		}
		if(!this.llist.containsKey(this.srcLanguage)){
			this.repMgr.reportError("source language <" + this.srcLanguage + "> not supported");
			return false;
		}
		if(this.tgtLanguage!=null){
			TSArrayListString ols=(TSArrayListString)this.llist.get(this.srcLanguage, LanguageList.llValXT);
			if(!ols.contains(this.tgtLanguage)){
				this.repMgr.reportError("target language <" + this.tgtLanguage + "> not supported for source language <" + this.srcLanguage + ">");
				return false;
			}
		}
		return true;
	}

	public void loadStg(){
		((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).loadStg();
	}

	public void printStg(){
		((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).printStg();
	}

	public void parse(InputStream is){
		((LanguageParser)this.llist.get(this.srcLanguage, LanguageList.llValLang)).parse(is);
	}

	@Override
	public void tsClean(){
		//TODO implement
	}

	@Override
	public final TEnum tsGetTypeEnum(){
		return TSRepository.type(this.typeString.lastElement());
	}

	@Override
	public final Set<TEnum> tsGetTypeEnumSet(){
		return this.typeEnum;
	}

	@Override
	public final java.lang.String tsGetTypeString(){
		return this.typeString.lastElement();
	}

	@Override
	public final List<String> tsGetTypeStringList(){
		return this.typeString;
	}

	@Override
	public boolean tsIsAtomic(){
		return true;
	}

	@Override
	public boolean tsIsComposite(){
		return false;
	}

	@Override
	public final boolean tsIsType(String t){
		return this.typeString.contains(t);
	}

	@Override
	public final boolean tsIsType(TEnum t){
		return this.typeEnum.contains(t);
	}

	@Override
	public void tsPlus(TSBase tb){
	}

	@Override
	public java.lang.String tsToString(int indent){
		//TODO implements
		return "";
	}

	@Override
	public void tsTrim(){
		//TODO not yet implemented
	}
}
