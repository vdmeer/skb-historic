/* Copyright (c) 2010-2011 Sven van der Meer
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

package org.skb.util.types.composite.util;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.INIConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.skb.util.misc.Json2Oat;
import org.skb.util.types.TypeRepository;
import org.skb.util.types.TypeRepository.ATType;
import org.skb.util.types.base.OatBase;
import org.skb.util.types.base.OatBaseAtomic;
import org.skb.util.types.base.OatBaseComposite;
import org.skb.util.types.base.OatBaseTable;

/**
 * Provides a map of properties based on OatBaseTable
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class OatPropertyMap extends OatBaseTable{

	/**
	 * OAT Type of the property
	 */
	public final static String pmValType				= "at:type";

	/**
	 * Default value of the property
	 */
	public final static String pmValValueDefault		= "value:default";

	/**
	 * Value read from file
	 */
	public final static String pmValValueFile			= "value:file";

	/**
	 * Value read from command line
	 */
	public final static String pmValValueCli			= "value:cli";


	/**
	 * Type of the CLI option
	 */
	public final static String pmValCliOptionType		= "cli:option:type";

	/**
	 * Short option for CLI (first character is used)
	 */
	public final static String pmValCliOptionShort		= "cli:option:short";

	/**
	 * Long option for CLI (all characters are used, some restrictions apply)
	 */
	public final static String pmValCliOptionLong		= "cli:option:long";

	/**
	 * Additional description, i.e. extra arguments
	 */
	public final static String pmValCliUsageDescrAdd	= "cli:option:arg-name";

	/**
	 * Description of the property for CLI
	 */
	public final static String pmValCliUsageDescr		= "cli:usage:descr";

	/**
	 * Long description of the property for CLI 
	 */
	public final static String pmValCliUsageDescrLong	= "cli:usage:descr-long";

	public OatPropertyMap(){
		super();
		this.init();
	}

	public OatPropertyMap(HashSet<String>rows){
		super();
		this.init();
		this.addRows(rows);
	}

	public OatPropertyMap(String ref_class, String rowPrefix){
		super();
		this.init();
		this.addRows(ref_class, rowPrefix);
	}

	protected void init(){
		super.init();
		this.oatValue=new TreeMap <String, OatTableRow>();
		this.setColumns(OatPropertyMap.class.getName(), "pmVal");
		this.addRows(OatPropertyMap.class.getName(), "pmKey");
		this.typeString.add(TypeRepository.OAT_COMPOSITE_PROPERTY_MAP);
		this.typeEnum.add(ATType.OAT_COMPOSITE_PROPERTY_MAP);
	}

	public void addProperties(OatBaseTable table){
		Collection<String> values = table.getRows();
		for (Iterator<String> i = values.iterator(); i.hasNext(); ){
			String s=i.next();
			this.put(s, table.get(s));
        }
	}

	public void addProperties(OatPropertyMap map){
		Collection<String> values = map.getRows();
		for (Iterator<String> i = values.iterator(); i.hasNext(); ){
			String s=i.next();
			this.put(s, map.get(s));
        }
	}

	public boolean hasProperty(String row){
		return this.oatValue.containsKey(row);
	}

	public boolean hasPropertyValue(String row, String col){
		boolean ret=false;
		if(this.oatValue.containsKey(row)){
			if(this.oatValue.get(row).containsKey(col)){
				if(this.oatValue.get(row).get(col)!=null)
					ret=true;
			}
		}
		return ret;
	}

	public void setValueDefault(String key, String val){
		this.put(key, OatPropertyMap.pmValValueDefault, val);
	}

	public void setValueDefault(String key, OatBaseAtomic val){
		this.put(key, OatPropertyMap.pmValValueDefault, val);
	}

	public void setValueDefault(String key, boolean val){
		this.put(key, OatPropertyMap.pmValValueDefault, val);
	}

	public OatBaseAtomic getValueDefault(String key){
		return this.get(key, OatPropertyMap.pmValValueDefault);
	}

	public void setValueCli(String key, OatBaseAtomic val){
		this.put(key, OatPropertyMap.pmValValueCli, val);
	}

	public OatBaseAtomic getValueCli(String key){
		return this.get(key, OatPropertyMap.pmValValueCli);
	}

	public OatBaseAtomic getValue(String key){
		if(this.containsKey(key)==false)
			return null;
		if(this.get(key, OatPropertyMap.pmValValueCli)!=null)
			return this.get(key, OatPropertyMap.pmValValueCli);
		if(this.get(key, OatPropertyMap.pmValValueFile)!=null)
			return this.get(key, OatPropertyMap.pmValValueFile);
		if(this.get(key, OatPropertyMap.pmValValueDefault)!=null)
			return this.get(key, OatPropertyMap.pmValValueDefault);
		return null;
	}

	public String loadFromFile(String fn){
		try {
			AbstractConfiguration cfg;
			String prefix="";
			if(fn.endsWith(".ini")){
				cfg=new INIConfiguration(fn);
				prefix="tribe.";
			}
			else if(fn.endsWith(".xml"))
				cfg=new XMLConfiguration(fn);
			else if(fn.endsWith(".properties"))
				cfg=new PropertiesConfiguration(fn);
			else
				return "unknown configuration file format, use '.ini' or '.xml' or '.properties'";

			File file=new File(fn);
			if(!file.canRead())
				return "can't read configuration file <" + fn +">";

			Iterator<?> it;
			if(prefix!="")
				it=cfg.getKeys(prefix);
			else
				it=cfg.getKeys();
			while(it.hasNext()){
				String p=it.next().toString();
				if(this.containsKey(p)){
	        		if(this.get(p, OatPropertyMap.pmValType).getValue().equals(TypeRepository.OAT_ATOMIC_STRING))
	        			this.put(p, OatPropertyMap.pmValValueFile, cfg.getString(p));
	        		else if(this.get(p, OatPropertyMap.pmValType).getValue().equals(TypeRepository.OAT_ATOMIC_BOOLEAN))
	        			this.put(p, OatPropertyMap.pmValValueFile, cfg.getBoolean(p, false));
	        		else if(this.get(p, OatPropertyMap.pmValType).getValue().equals(TypeRepository.OAT_ATOMIC_INTEGER))
	        			this.put(p, OatPropertyMap.pmValValueFile, cfg.getInteger(p, 0));
        			else if(this.get(p, OatPropertyMap.pmValType).getValue().equals(TypeRepository.OAT_ATOMIC_DOUBLE))
	        			this.put(p, OatPropertyMap.pmValValueFile, cfg.getDouble(p));
	        		else if(this.get(p, OatPropertyMap.pmValType).getValue().equals(TypeRepository.OAT_ATOMIC_LONG))
	        			this.put(p, OatPropertyMap.pmValValueFile, cfg.getLong(p, 0));
				}

			}
		} catch (Exception e) {
//        	ReportManager repMgr=ReportManager.getInstance();
//        	repMgr.reportErrorNoFile(e.toString());
		} 
		return null;
	}

	public String writeToFile(String fn){
		try {
			AbstractConfiguration cfg;
			String prefix="";
			if(fn.endsWith(".ini")){
				cfg=new INIConfiguration();
				prefix="tribe.";
			}
			else if(fn.endsWith(".xml"))
				cfg=new XMLConfiguration();
			else if(fn.endsWith(".properties"))
				cfg=new PropertiesConfiguration();
			else
				return "unknown configuration file format, use '.ini' or '.xml' or '.properties'";

			File file=new File(fn);
			file.createNewFile();
			if(!file.canWrite())
				return "can't write configuration file <" + fn +">";

			HashSet<String> rows=new HashSet<String>(this.getRows());
	        for (Iterator<String> i = rows.iterator(); i.hasNext(); i.hasNext()){
	        	String row=i.next();
	        	if((OatBaseAtomic)this.get(row, OatPropertyMap.pmValCliOptionShort)!=null||(OatBaseAtomic)this.get(row, OatPropertyMap.pmValCliOptionLong)!=null)
	        		cfg.setProperty(prefix+row, this.getValue(row));
	        }
			if(fn.endsWith(".ini"))
				((INIConfiguration)cfg).save(file);
			if(fn.endsWith(".xml"))
				((XMLConfiguration)cfg).save(file);
			if(fn.endsWith(".properties"))
				((PropertiesConfiguration)cfg).save(file);
		} catch (Exception e) {
//        	ReportManager repMgr=ReportManager.getInstance();
//        	repMgr.reportErrorNoFile(e.toString());
		}
		return null;
	}

	public Set<String> loadFromJson(File file){
		return this.loadFromJason(new Json2Oat().read(file).getValOatMapLH());
	}

	public Set<String> loadFromJason(OatMapLH map){
		if(map==null)
			return null;
		map.clean();
		Set<String> keySet=this.keySet();
		Iterator<String> key_it=keySet.iterator();
		HashSet<String> cols=this.getColumns();
		while(key_it.hasNext()){
			String key=key_it.next();
			OatBase val;

		    for (String s:cols)
		    	if((val=map.get(key+"/"+s))!=null)
		    		this.put(key,s,val.getValOatAtomic());

			if((val=map.get(key+"/"+OatPropertyMap.pmValType))!=null)
				this.put(key,OatPropertyMap.pmValType,TypeRepository.type(val));
			if((val=map.get(key+"/"+OatPropertyMap.pmValCliOptionType))!=null)
				this.put(key,OatPropertyMap.pmValCliOptionType,TypeRepository.type(val));

			//remove the key from cfg_ar to allow test for unknown options
			map.remove(key);
		}
		//if keys have not been processed they are unknown, return
		if(map.size()>0){
			return map.keySet();
		}
		return null;
	}

	public OatPropertyMap getValOatPropertyMap(){
		return this;
	}

	public OatBaseComposite getValOatComposite(){
		return this;
	}
}
