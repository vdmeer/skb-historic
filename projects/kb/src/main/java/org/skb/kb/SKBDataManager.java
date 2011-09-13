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

package org.skb.kb;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.util.misc.I18NManager;
import org.skb.util.patterns.creational.builder.Request;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.atomic.db.TSPDO;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.atomic.util.TSScope;
import org.skb.util.patterns.structural.composite.composite.util.TSArrayList;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * The SKB Data Manager, handling access to all registered data
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class SKBDataManager {
	static Logger logger;

	/**
	 * Registered data objects
	 */
	private TSMapLH registered_dos;


	/**
	 * Private class holding the instance of the SKBDataManager (singleton)
	 * @author     Sven van der Meer <sven@vandermeer.de>
	 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
	 */
	private static class XtSKBDataMangerHolder{
		private final static SKBDataManager INSTANCE = new SKBDataManager();
	}


	/**
	 * Returns the instance to the Data Manager (singleton)
	 * @return instance
	 */
	public static SKBDataManager getInstance(){
		return XtSKBDataMangerHolder.INSTANCE;
	}


	/**
	 * Class constructor, private (singleton), initialises local fields
	 */
	private SKBDataManager(){
		logger=Logger.getLogger(SKBDataManager.class);
		this.registered_dos=new TSMapLH();
	}


	/**
	 * Return current set of data objects.
	 */
	public TSMapLH getDataObjects(){
		return this.registered_dos;
	}


	/**
	 * Load and register a new data object (i.e. database tables, data file)
	 * 
	 * This method loads a data object (i.e. SQLite database with tables) and registers it in the local
	 * DO registry.
	 *
	 * @param semaTag the semantic tag to be used to access the data object
	 * @param type the type of the data object, i.e. sqlite
	 * @param handle a handle to access the data object, i.e. a file name for sqlite
	 * @param tables tables the data object maintains (currently for databases only), will be exploded
	 * @param filterID a specific filter attached to the data object, can be used in queueing methods
	 * @param pkg the package that registers the data object
	 */
	public void loadDataObject(String semaTag, String type, String handle, String tables, String filterID, String pkg){
		boolean doReg=true;
		TSMapLH dos=new TSMapLH();

		if(type.equals("sqlite")){
			TSString _t=new TSString(tables);
			TSArrayListString tab=(TSArrayListString)_t.tsExplode();

			String sqliteFile="";
			if(handle.startsWith("config://"))
				sqliteFile=handle.replace("config://", "");
			else if(handle.startsWith("repo://"))
				sqliteFile=SKB.getInstance().configuration.get("path/repository").toString()+handle.replace("repo://", "")+".db";
			else if(handle.startsWith("data://"))
				sqliteFile=SKB.getInstance().configuration.get("path/database").toString()+handle.replace("data://", "")+".db";

			File f=new File(sqliteFile);
			if(!f.canRead()){
				logger.warn("SKB_DataManager: SQLite database <"+sqliteFile+">  not found for sema tag <"+semaTag+"> in package <"+pkg+">");
				doReg=false;
			}
			else{
				Connection connection=null;
				try {
					Class.forName("org.sqlite.JDBC");
					connection=DriverManager.getConnection("jdbc:sqlite:"+sqliteFile);
				} catch (Exception e) {
					logger.error("SKB_DataManager: Unable to load PDO!\n--> "+sqliteFile+"\n--> "+e);
				}
				if(connection==null){
					logger.warn("SKB_DataManager: Could not load database <"+"jdbc:sqlite:"+sqliteFile+">");
				}
				else{
					for(int i=0;i<tab.size();i++){
						try{
							ResultSet rs=connection.createStatement().executeQuery("SELECT * FROM "+tab.get(i));
							rs.next();
						} catch (Exception e) {
							logger.error("SKB_DataManager: table <"+tab.get(i)+"> does not exist in SQLite database <"+sqliteFile+"> for sema tag <"+semaTag+"> in package <"+pkg+">");
							doReg=false;
						}
						if(doReg==true){
							dos.put("sqlite_pdo", new TSPDO(connection));
						}
					}
				}
			}
		}
		else{
			logger.error("SKB_DataManager: unknown type <"+type+"> for sema tag <"+semaTag+"> in package <"+pkg+">");
			doReg=false;
		}

		if(doReg==true){
			dos.put("type", type);
			dos.put("handle", handle);
			dos.put("tables", tables);
			dos.put("filter_id", filterID);
			dos.put("package", pkg);

			if(!this.registered_dos.containsKey(semaTag)){
				TSArrayList al=new TSArrayList();
				this.registered_dos.put(semaTag, al);
			}

			if(this.registered_dos.get(semaTag).tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)){
				TSArrayList _a=(TSArrayList)this.registered_dos.get(semaTag);
				_a.add(dos);
				this.registered_dos.put(semaTag, _a);				
			}
		}
	}


	//TODO JSDOC
	/**
	 * Prepares a query object that query_data_object can process
	 */
	public TSMapLH prepareQuery(String semaTag, String find, TSMapLH equals, String sort, String filterID, String pkg, boolean interpret, boolean clean){
		TSMapLH ret=new TSMapLH();
		ret.put("sema_tag",  new TSString(semaTag));
		ret.put("find",      new TSString(find));
		ret.put("equals",    new TSMapLH(equals));
		ret.put("sort",      new TSString(sort));
		ret.put("filter_id", new TSString(filterID));
		ret.put("package",   new TSString(pkg));
		ret.put("interpret", new TSBoolean(interpret));
		ret.put("clean",     new TSBoolean(clean));
		return ret;
	}


	//TODO JSDOC
	public TSMapLH testQuery(TSMapLH query){
		if(!query.containsKey("sema_tag"))
			logger.warn("SKB_DataManager: no sema tag set in query request");
		if(!this.registered_dos.containsKey(query.get("sema_tag").toString()))
			logger.error("SKB_DataManager: unknown sema tag <"+query.get("sema_tag")+"> in query request");

		if(!query.containsKey("find"))
			query.put("find", new TSString("*"));
		else if(query.get("find").tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)&&((TSArrayList)query.get("find")).size()==0)
			query.put("find", new TSString("*"));
		else if(query.get("find").tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING)&&((TSString)query.get("find")).length()==0)
			query.put("find", new TSString("*"));
		else if(query.get("find").tsIsType(TSRepository.TEnum.TS_NULL))
			query.put("find", new TSString("*"));

		if(!query.containsKey("equals")||!query.get("equals").tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH))
			query.put("equals", new TSMapLH());

		if(!query.containsKey("sort")||query.get("sort").tsIsType(TSRepository.TEnum.TS_NULL))
			query.put("sort", new TSString(""));

		if(!query.containsKey("filter_id")||query.get("filter_id").tsIsType(TSRepository.TEnum.TS_NULL))
			query.put("filter_id", new TSString(""));

		if(!query.containsKey("package")||query.get("package").tsIsType(TSRepository.TEnum.TS_NULL))
			query.put("package", new TSString(""));

		if(!query.containsKey("interpret"))
			query.put("interpret", new TSBoolean(false));

		if(!query.containsKey("clean"))
			query.put("clean", new TSBoolean(false));

		return query;
	}


	//TODO JSDOC
	public TSMapLH queryDataObject(TSMapLH query){
		TSMapLH ret=new TSMapLH();
		query=this.testQuery(query);
		
		if(!this.registered_dos.containsKey(query.get("sema_tag").toString())){
			logger.error("SKB_DataManager: unknown sema tag <"+query.get("sema_tag")+"> in query request");
			return ret;
		}

		TSBaseAPI entries=this.registered_dos.get(query.get("sema_tag").toString());
		if(entries.tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)){
			for(TSBaseAPI entry : (TSArrayList)entries){
				if(entry.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)){
					TSMapLH todo=(TSMapLH)entry;
					if(query.get("filter_id").toString().length()!=0&&todo.containsKey("filet_id")&&!query.get("filter_id").toString().equals(todo.get("filter_id").toString()))
						continue;
					if(query.get("package").toString().length()!=0&&todo.containsKey("package")&&!query.get("package").toString().equals(todo.get("package").toString()))
						continue;
					String type=todo.get("type").toString();
					if(type.equals("sqlite")){
						TSBaseAPI tables=todo.get("tables");
						String from=null;
						if(tables.tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST))
							from=StringUtils.join(((TSArrayList)tables).toArray(),",");
						else
							from=tables.toString();

						TSPDO pdo=(TSPDO)todo.get("sqlite_pdo");
						ret=pdo.semanticQuery(query, from);

						boolean interpret=((TSBoolean)query.get("interpret")).tsvalue;
						if(interpret==true)
							this.interpretDo(ret, query.get("sema_tag").toString());
					}
				}
			}
		}

		//check for cleaning
		boolean interpret=((TSBoolean)query.get("interpret")).tsvalue;
		if(interpret==true)
			ret.tsClean();

//		if(count($ret)==1&&isset($ret[0]))
//			$ret=$ret[0];
		return ret;
	}


	/**
	 * Interpret data, i.e. resolve all internal links, do i18n translations
	 *
	 * @param map the data map to be interpreted
	 * @param semaTag semantic tag to be used as starting point for interpretation
	 */
	public void interpretDo(TSMapLH map, String semaTag){
		if(map==null||map.size()==0)
			return;
		map.tsClean();
		if(map.size()==0)
			return;

		this.interpretLoop(map, new TSScope());
	}


	/**
	 * Loop for interpreting data
	 * @param map entries the data array to be interpreted
	 * @param scope stack that is used to avoid loops
	 */
	protected void interpretLoop(TSMapLH map, TSScope scope){
		if(map==null||map.size()==0)
			return;

		SKB mySKB=SKB.getInstance();
		TSMapLH registered_fields=mySKB.getRegisteredFields();

		ArrayList<String> listRemove=new ArrayList<String>();
		TSMapLH mergeMap=new TSMapLH();

		String key;
		Set<String> o_set = map.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			TSBaseAPI val=map.get(key);
			switch(val.tsGetTypeEnum()){
				case TS_COMPOSITE_MAP_LH:
					this.interpretLoop((TSMapLH)val, scope);
					break;
				case TS_ATOMIC_JAVA_STRING:
					if(registered_fields.containsKey(key)){
						String name=registered_fields.get(key+"/core:entries_name").toString();
						String type=registered_fields.get(key+"/core:type").toString();
						if(type.equals("entity")){
							String table=null;
							if(registered_fields.get(key+"/core:default_db").toString().length()!=0)
								table=registered_fields.get(key+"/core:default_db").toString();
							if(table==null)
								continue;

							if(registered_fields.get(key+"/core:interpreter").toString().length()==0){
								String exp=registered_fields.get(key+"/core:explode").toString();
								if(exp.equals("1")){
									TSBaseAPI newVal=((TSString)val).tsExplode();
									if(newVal.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
										mergeMap.put(name, new TSMapLH());
										TSArrayListString m=(TSArrayListString)newVal;
										for(Integer i=0;i<m.size();i++){
											TSMapLH _t=new TSMapLH();
											_t.put(name+"_key", m.get(i));
											this.interpretLoop(_t, scope);
											mergeMap.put(name+"/"+i.toString(), _t);
										}
									}
									listRemove.add(key);
								}
								else{
									if(scope.push(table,val.toString())==true){
										TSMapLH equals=new TSMapLH();
										equals.put("key", val);
										mergeMap.put(name, this.queryDataObject(this.prepareQuery(table,"*",equals,null,null,null,true,true)));
										listRemove.add(key);
										scope.pop();
									}
									else{
										listRemove.add(key);
									}
								}
							}
							else{
					            //$entries->ar[$testAr['core:entries_name']]=
								//$this->interpret_data($testAr['core:interpreter'], $val)->ar;
								//listRemove.add(key);
							}
						}
						else if (type.equals("value")){
							String exp=registered_fields.get(key+"/core:explode").toString();
							if(key.endsWith("_locale")){
								if(((TSString)val).tsvalue.contains("%%")){
									String split[]=((TSString)val).tsvalue.split("%%");
									I18NManager i18n=I18NManager.getInstance();
									mergeMap.put(name,i18n._(split[0], split[1]));
									listRemove.add(key);
								}
								else if(((TSString)val).tsvalue.contains("%")){
									TSBaseAPI newVal=((TSString)val).tsExplode();
									if(newVal.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)){
										TSMapLH m=(TSMapLH)newVal;
										String lang=SKB.getInstance().getLang();
										if(m.get(lang)!=null)
											mergeMap.put(name,m.get(lang));
										else if(m.get("")!=null)
											mergeMap.put(name,m.get(""));
										else
											mergeMap.put(name,"");
										listRemove.add(key);
									}
								}
								else{
									mergeMap.put(name,"");
								}
							}
							else if(exp.equals("1")){
								mergeMap.put(name,((TSString)val).tsExplode());
								listRemove.add(key);
							}
						}
					}
					break;
				default:
					break;
			}
		}
		for(int i=0;i<listRemove.size();i++)
			map.remove(listRemove.get(i));
		map.putAll(mergeMap);
	}


	/**
	 * Interpret data using registered interpreters.
	 * 
	 * This function supports all types of registered interpreters (core, entity, value and entries).
	 * Each of them requires a slightly different set of parameters.
	 * 
	 * @param id identifier for the interpreter
	 * @param val value to be interpreted
	 * @param table database table to be used during interpretation
	 * @param request request object for parametrisation
	 * @return interpreted value
	 */
	public TSBaseAPI interpretData(String id, TSBaseAPI val, String table, Request request){
		try{
			TSMapLH registered_interpreter=SKB.getInstance().getRegisteredInterpreters(id+"/core:rabit:target:class/java");

			Class<?> theClass=Class.forName((String)registered_interpreter.get("core:rabit:target:class/java").toString());
			SKBInterpreter inter=(SKBInterpreter)theClass.newInstance();
			String type=registered_interpreter.get("/core:rabit:type").toString();
			if(type.equals("interpreter:core"))
				return ((SKBInterpreterCore)inter).interpret(val.toString(), request);
			else if(type.equals("interpreter:entity"))
				return ((SKBInterpreterEntity)inter).interpret(val.toString(), table);
			else if(type.equals("interpreter:value"))
				return ((SKBInterpreterValue)inter).interpret(val.toString());
			else if(type.equals("interpreter:entries"))
				return ((SKBInterpreterEntries)inter).interpret((TSMapLH)val, table);
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.error("SKBDataManager: interpreter not found: <"+id+">");
		return null;
	}
}
