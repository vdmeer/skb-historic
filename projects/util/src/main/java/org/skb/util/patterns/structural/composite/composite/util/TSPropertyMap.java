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

package org.skb.util.patterns.structural.composite.composite.util;

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
import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.misc.Json2Oat;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSNull;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.TSTableRowAPI;

/**
 * Provides a map of properties based on TSTable
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSPropertyMap extends TSTable{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSPropertyMap.class);


	public TSPropertyMap(){
		super();
		this._initPM();
	}


	public TSPropertyMap(HashSet<String>rows){
		super();
		this._initPM();
		this.addRows(rows);
	}


	public TSPropertyMap(String ref_class, String rowPrefix){
		super();
		this._initPM();
		this.addRows(ref_class, rowPrefix);
	}


	protected void _initPM(){
		this.tsvalue=new LinkedHashMap <String, TSTableRowAPI>();

		HashSet<String>columns=new HashSet<String>();
		columns.add(FieldKeys.fieldValueType);
		columns.add(FieldKeys.fieldValueDefault);
		columns.add(FieldKeys.fieldValueFile);
		columns.add(FieldKeys.fieldValueCli);
		columns.add(FieldKeys.fieldCliOptionType);
		columns.add(FieldKeys.fieldCliOptionShort);
		columns.add(FieldKeys.fieldCliOptionLong);
		columns.add(FieldKeys.fieldCliOptionDescriptionShort);
		columns.add(FieldKeys.fieldCliOptionDescriptionLong);
		columns.add(FieldKeys.fieldCliOptionArguments);
		columns.add(FieldKeys.fieldCliOptionDescriptionArguments);

		this.setColumns(columns, TSPropertyMap.class.getName(), "pmVal");
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
					TSBaseAPI val=this.tsvalue.get(row).get(col);
					if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
						ret=true;
				}
			}
		}
		return ret;
	}


	public void setValueDefault(String key, String val){
		this.put(key, FieldKeys.fieldValueDefault, val);
	}


	public void setValueDefault(String key, TSBaseAPI val){
		this.put(key, FieldKeys.fieldValueDefault, val);
	}


	public void setValueDefault(String key, boolean val){
		this.put(key, FieldKeys.fieldValueDefault, val);
	}


	public TSBaseAPI getValueDefault(String key){
		return this.get(key, FieldKeys.fieldValueDefault);
	}


	public void setValueCli(String key, TSBaseAPI val){
		this.put(key, FieldKeys.fieldValueCli, val);
	}


	public TSBaseAPI getValueCli(String key){
		return this.get(key, FieldKeys.fieldValueCli);
	}


	public TSBaseAPI getValue(String key){
		if(!this.containsKey(key))
			return new TSNull();
		if(!(this.get(key, FieldKeys.fieldValueCli)).tsIsType(TEnum.TS_NULL))
			return this.get(key, FieldKeys.fieldValueCli);
		if(!(this.get(key, FieldKeys.fieldValueFile)).tsIsType(TEnum.TS_NULL))
			return this.get(key, FieldKeys.fieldValueFile);
		if(!(this.get(key, FieldKeys.fieldValueDefault)).tsIsType(TEnum.TS_NULL))
			return this.get(key, FieldKeys.fieldValueDefault);
		return new TSNull();
	}


	public String loadFromFile(TSBaseAPI fn){
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
					String type=this.get(p, FieldKeys.fieldValueType).toString();
					if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_STRING))
	        			this.put(p, FieldKeys.fieldValueFile, cfg.getString(p));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN))
	        			this.put(p, FieldKeys.fieldValueFile, cfg.getBoolean(p, false));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_INTEGER))
	        			this.put(p, FieldKeys.fieldValueFile, cfg.getInteger(p, 0));
        			else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_DOUBLE))
	        			this.put(p, FieldKeys.fieldValueFile, cfg.getDouble(p));
	        		else if(type.equals(TSRepository.TString.TS_ATOMIC_JAVA_LONG))
	        			this.put(p, FieldKeys.fieldValueFile, cfg.getLong(p, 0));
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


	public String writeToFile(TSBaseAPI fn){
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
	        	if(this.get(row, FieldKeys.fieldCliOptionShort)!=null||this.get(row, FieldKeys.fieldCliOptionLong)!=null)
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
		TSBaseAPI _t=new Json2Oat().read(file);
		if(_t.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
			return this.loadFromJason((TSMapLH)_t);
		return new TreeSet<String>();
	}


	public Set<String> loadFromJason(TSBaseAPI map){
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
			TSBaseAPI val;

		    for (String s:cols){
		    	val=map.get(key+"/"+s);
		    	if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
		    		this.put(key,s,val);
		    }

		    val=map.get(key+"/"+FieldKeys.fieldValueType);
			if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
				this.put(key,FieldKeys.fieldValueType,TSRepository.type(val));

			val=map.get(key+"/"+FieldKeys.fieldCliOptionType);
			if(val!=null&&!val.tsIsType(TEnum.TS_NULL))
				this.put(key,FieldKeys.fieldCliOptionType,TSRepository.type(val));

			//remove the key from cfg_ar to allow test for unknown options
			map.remove(key);
		}
		//if keys have not been processed they are unknown, return
		if(map.size()>0)
			return map.keySet();
		return null;
	}
}
