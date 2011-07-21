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

package org.skb.util.types.composite.util;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.INIConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.skb.util.misc.Json2Oat;
import org.skb.util.types.TSNull;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSAtomic;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.api.TSTableRowAPI;

/**
 * Provides a map of properties based on TSTable
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class TSPropertyMap extends TSTable{
	/**
	 * TS Type of the property
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

	public TSPropertyMap(){
		super();
		this._init();
	}

	public TSPropertyMap(HashSet<String>rows){
		super();
		this._init();
		this.addRows(rows);
	}

	public TSPropertyMap(String ref_class, String rowPrefix){
		super();
		this._init();
		this.addRows(ref_class, rowPrefix);
	}

	protected void _init(){
		super._init();
		this.tsvalue=new LinkedHashMap <String, TSTableRowAPI>();
		this.setColumns(TSPropertyMap.class.getName(), "pmVal");
		this.addRows(TSPropertyMap.class.getName(), "pmKey");

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_PROPERTY_MAP);
		this.typeEnum.add(TEnum.TS_COMPOSITE_PROPERTY_MAP);
	}

	public void addProperties(TSTable table){
		Collection<String> values = table.getRows();
		for (Iterator<String> i = values.iterator(); i.hasNext(); ){
			String s=i.next();
			this.put(s, table.get(s));
        }
	}

	public void addProperties(TSPropertyMap map){
		Collection<String> values = map.getRows();
		for (Iterator<String> i = values.iterator(); i.hasNext(); ){
			String s=i.next();
			this.put(s, map.get(s));
        }
	}

	public boolean hasProperty(String row){
		if(this.isInitialised())
			return this.tsvalue.containsKey(row);
		else
			return false;
	}

	public boolean hasPropertyValue(String row, String col){
		boolean ret=false;
		if(this.isInitialised()){
			if(this.tsvalue.containsKey(row)){
				if(this.tsvalue.get(row).containsKey(col)){
					TSBase val=this.tsvalue.get(row).get(col);
					if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
						ret=true;
				}
			}
		}
		return ret;
	}

	public void setValueDefault(String key, String val){
		this.put(key, TSPropertyMap.pmValValueDefault, val);
	}

	public void setValueDefault(String key, TSAtomic val){
		this.put(key, TSPropertyMap.pmValValueDefault, val);
	}

	public void setValueDefault(String key, boolean val){
		this.put(key, TSPropertyMap.pmValValueDefault, val);
	}

	public TSBase getValueDefault(String key){
		return this.get(key, TSPropertyMap.pmValValueDefault);
	}

	public void setValueCli(String key, TSAtomic val){
		this.put(key, TSPropertyMap.pmValValueCli, val);
	}

	public TSBase getValueCli(String key){
		return this.get(key, TSPropertyMap.pmValValueCli);
	}

	public TSBase getValue(String key){
		if(!this.containsKey(key))
			return new TSNull();
		if(!(this.get(key, TSPropertyMap.pmValValueCli)).tsIsType(TEnum.TS_NULL))
			return this.get(key, TSPropertyMap.pmValValueCli);
		if(!(this.get(key, TSPropertyMap.pmValValueFile)).tsIsType(TEnum.TS_NULL))
			return this.get(key, TSPropertyMap.pmValValueFile);
		if(!(this.get(key, TSPropertyMap.pmValValueDefault)).tsIsType(TEnum.TS_NULL))
			return this.get(key, TSPropertyMap.pmValValueDefault);
		return new TSNull();
	}

	public String loadFromFile(TSBase fn){
		if(fn!=null&&!fn.tsIsType(TEnum.TS_NULL))
			return this.loadFromFile(fn.toString());
		else
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
					String type=this.get(p, TSPropertyMap.pmValType).toString();
					if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_STRING))
	        			this.put(p, TSPropertyMap.pmValValueFile, cfg.getString(p));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN))
	        			this.put(p, TSPropertyMap.pmValValueFile, cfg.getBoolean(p, false));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_INTEGER))
	        			this.put(p, TSPropertyMap.pmValValueFile, cfg.getInteger(p, 0));
        			else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_DOUBLE))
	        			this.put(p, TSPropertyMap.pmValValueFile, cfg.getDouble(p));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_LONG))
	        			this.put(p, TSPropertyMap.pmValValueFile, cfg.getLong(p, 0));
//	        		else
//	        			System.err.println("TSPropMap, loadfromfile, unknown type <"+type+"> for <"+p+">");
				}

			}
		} catch (Exception e) {
//        	ReportManager repMgr=ReportManager.getInstance();
//        	repMgr.reportErrorNoFile(e.toString());
		}
		return null;
	}

	public String writeToFile(TSBase fn){
		if(fn!=null&&!fn.tsIsType(TEnum.TS_NULL))
			return this.writeToFile(fn.toString());
		else
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
	        	if(this.get(row, TSPropertyMap.pmValCliOptionShort)!=null||this.get(row, TSPropertyMap.pmValCliOptionLong)!=null)
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
		TSBase _t=new Json2Oat().read(file);
		if(_t.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			return this.loadFromJason((TSMapLH)_t);
		return new TreeSet<String>();
	}

	public Set<String> loadFromJason(TSBase map){
		if(map==null||!map.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			return null;
		else
			return this.loadFromJason((TSMapLH)map);
	}

	public Set<String> loadFromJason(TSMapLH map){
		if(map==null||!map.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			return null;
		map.tsClean();

		Set<String> keySet=this.keySet();
		Iterator<String> key_it=keySet.iterator();
		HashSet<String> cols=this.getColumns();
		while(key_it.hasNext()){
			String key=key_it.next();
			TSBase val;

		    for (String s:cols){
		    	val=map.get(key+"/"+s);
		    	if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
		    		this.put(key,s,val);
		    }

			if((val=map.get(key+"/"+TSPropertyMap.pmValType))!=null)
				this.put(key,TSPropertyMap.pmValType,TSRepository.type(val));
			if((val=map.get(key+"/"+TSPropertyMap.pmValCliOptionType))!=null)
				this.put(key,TSPropertyMap.pmValCliOptionType,TSRepository.type(val));

			//remove the key from cfg_ar to allow test for unknown options
			map.remove(key);
		}
		//if keys have not been processed they are unknown, return
		if(map.size()>0)
			return map.keySet();
		return null;
	}
}
