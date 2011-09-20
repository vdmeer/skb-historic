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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.skb.util.classic.io.dirwalker.FindPackageDirectories;
import org.skb.util.classic.misc.I18NManager;
import org.skb.util.classic.misc.Json2Oat;
import org.skb.util.classic.patterns.creational.builder.Request;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSArrayList;
import org.skb.util.composite.util.TSArrayListString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Main SKB class
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class SKB {
	/** Logger instance */
	static Logger logger=Logger.getLogger(SKB.class);

	/** Set language */
	private String lang;

	/** Site ID, used to find local configurations */
	public static String site_id;

	/** Central configuration, everything that can be configured is stored here */ 
	public TSLinkedHashTree configuration;

	/** List of registered (loaded) packages, a list of identifiers */
	private TSArrayListString registered_packages; 

	/** Key/TSBase map of registered fields, everything the SKB can process is stored here */
	private TSLinkedHashTree registered_fields;

	/** Key/TBase map of registered requests, used to create new instances and parameterise them */
	private TSLinkedHashTree registered_requests;

	/** Key/TBase map of registered readers, used to instantiate new readers */
	private TSLinkedHashTree registered_readers;

	/** Key/TBase map of registered builders, used to instantiate new builders */
	private TSLinkedHashTree registered_builders;

	/** Key/TBase map of registered templates, used by builders to retrieve all information to access templates */
	private TSLinkedHashTree registered_templates;

	/** Key/TBase map of registered interpreters, used by the SKB for any interpretation request */
	private TSLinkedHashTree registered_interpreters;

	/** Key/TBase map of registered applications, used to instantiate new applications */
	private TSLinkedHashTree registered_applications;

	/** Local Internationalisation Manager */
	private I18NManager i18n; 


	/**
	 * Class that 'holds' the single valid instance of the SKB (singleton) 
	 * @author     Sven van der Meer <sven@vandermeer.de>
	 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
	 */
	private static class XtSKB_MainHolder{
		private final static SKB INSTANCE = new SKB();
	}


	/**
	 * Returns a pointer to the SKB instance (singleton)
	 * @return SKB pointer
	 */
	public static SKB getInstance(){
		return XtSKB_MainHolder.INSTANCE;
	}


	/**
	 * Class constructor (private, since SKB is singleton)
	 * 
	 * <p>
	 * The constructor initialises all local fields (registered_* and others) and reads the core configuration and 
	 * the configuration for the site. Once the constructor is finished, the SKB is operational. That means all required
	 * configuration is loaded and processed (some path information will be created based on given paths).
	 * </p>
	 * <p>
	 * Note: the first call to {@link SKB#getInstance()} will call this constructor. To complete the load, one will also need to call
	 * {@link SKB#load_core_packages()}, which will load the required core packages. Best is to use {@link SKBInit#init()} before any other
	 * call to the SKB.
	 * </p>
	 */
	private SKB(){
		//TODO externalise the initial __config array
		logger.trace("initialising SKB");

		logger.trace("-> configuration, registered packages");
		this.configuration=new TSLinkedHashTree();
		this.registered_packages=new TSArrayListString();

		logger.trace("-> registered fields, requests,  readers, builders, templates, interpreters, applications");
		this.registered_fields=new TSLinkedHashTree();
		this.registered_requests=new TSLinkedHashTree();
		this.registered_readers=new TSLinkedHashTree();
		this.registered_builders=new TSLinkedHashTree();
		this.registered_templates=new TSLinkedHashTree();
		this.registered_interpreters=new TSLinkedHashTree();
		this.registered_applications=new TSLinkedHashTree();

		logger.trace("-> I18NManager");
		this.i18n=I18NManager.getInstance();

		logger.trace("-> start values (not in property files yet)");
		//try for the main variables we'll need set (similar to main.inc.php)
		//String site_id = System.getenv("site_id");     //id for the website
		String site_id = "default";                      //id for the website
		String site_path = "www/demo";                   //path to the website

		String root_classes = "/classes/";
		String root_skb = "/skb";
		//String root_document = "V:/dev/projects/skb/skb-eclipse/kb/src/main/resources";
		String root_document = "V:/dev/projects/skb/skb-git/htdocs";

		logger.trace("-> __cfg_array");
		TSLinkedHashTree __cfg_array=new TSLinkedHashTree();
		__cfg_array.put("root-document", root_document);
		__cfg_array.put("root-skb", root_skb);
		__cfg_array.put("root-classes", root_classes);
		__cfg_array.put("config-core", root_document+root_skb+"/config/core.db");
		__cfg_array.put("config-site", root_document+root_skb+"/config/"+site_id+".db");
		__cfg_array.put("site_path", site_path);
		__cfg_array.put("skb_site_id", site_id);
		__cfg_array.put("php_extension", ".php5");

		if(!__cfg_array.containsKey("skb_site_id")){
			logger.error("SKB: given configuration not valid - missing Site ID");
			logger.trace("SKB: given configuration not valid - missing Site ID, trying to continue");
			//System.exit(-1);
		}
		else{
			logger.trace("starting to load configuration data");

			logger.trace("get DataManager Instance");
			SKBDataManager myDM=SKBDataManager.getInstance();

			logger.trace("load skb core config from "+__cfg_array.get("config-core"));
			myDM.loadDataObject("skb:core:config", "sqlite", "config://"+__cfg_array.get("config-core").toString(), "skb_cfg", "skb:core:config", "core");
			TSLinkedHashTree __cfg=myDM.queryDataObject(myDM.prepareQuery("skb:core:config",null,null,null,null,null,false,false));
			Set<String> o_set = __cfg.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				TSLinkedHashTree val=(TSLinkedHashTree)__cfg.get(key);

				String collection=val.get("collection").toString();
				String part=val.get("part").toString();
				TSString value=new TSString(val.get("value"));
				String explode=val.get("field_explodes").toString();

				if(!this.configuration.containsKey(collection))
					this.configuration.put(collection, new TSLinkedHashTree());

				if(explode.equals("1"))
					this.configuration.put(collection+"/"+part, value.tsExplode());
				else
					this.configuration.put(collection+"/"+part, value);
				logger.trace("added core config key <"+key+"> with value <"+value+">");
			}
			this.configuration.put("skb/site-id", __cfg_array.get("skb_site_id"));
			SKB.site_id=this.configuration.get("skb/site-id").toString();

			logger.trace("load skb site config from "+__cfg_array.get("config-site"));
			myDM.loadDataObject("skb:core:config:site", "sqlite", "config://"+__cfg_array.get("config-site").toString(), "configuration", "skb:core:config:site", "site");
			__cfg=myDM.queryDataObject(myDM.prepareQuery("skb:core:config:site",null,null,null,null,null,false,false));
			o_set = __cfg.keySet();
			key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				TSLinkedHashTree val=(TSLinkedHashTree)__cfg.get(key);

				String collection=val.get("collection").toString();
				String part=val.get("part").toString();
				TSString value=new TSString(val.get("value"));
				String explode=val.get("field_explodes").toString();

				if(!this.configuration.containsKey(collection))
					this.configuration.put(collection, new TSLinkedHashTree());

				if(explode.equals("1"))
					this.configuration.put(collection+"/"+part, value.tsExplode());
				else
					this.configuration.put(collection+"/"+part, value);
				logger.trace("added site config key <"+key+"> with value <"+value+">");
			}

			logger.trace("calculating skb and path values");
			this.configuration.put("skb/root-document",     __cfg_array.get("root-document"));

			this.configuration.put("skb/root-skb",          __cfg_array.get("root-skb"));
			this.configuration.put("skb/root-classes",      __cfg_array.get("root-classes"));
			this.configuration.put("path/skb",              __cfg_array.get("root-document").toString()+__cfg_array.get("root-skb").toString());

			this.configuration.put("skb/target",            "java");

			this.configuration.put("server/root-fs",        __cfg_array.get("root-document"));
			this.configuration.put("server/access-remote",  new TSBoolean(true));

			this.configuration.put("server/root-http",      this.configuration.get("skb/root-skb").toString());

			this.configuration.put("path/classes",          this.configuration.get("path/skb").toString()+__cfg_array.get("root-classes"));
			this.configuration.put("path/site",             __cfg_array.get("site_path"));
			this.configuration.put("path/database",         this.configuration.get("path/skb").toString()+this.configuration.get("path/database").toString());

			this.configuration.put("path/config",           this.configuration.get("path/skb").toString()+this.configuration.get("path/config").toString());
			this.configuration.put("path/repository",       this.configuration.get("path/skb").toString()+this.configuration.get("path/repository").toString());
			this.configuration.put("path/locale",           this.configuration.get("path/skb").toString()+this.configuration.get("path/locale").toString());

			this.configuration.put("path/targets",          this.configuration.get("path/skb").toString()+this.configuration.get("path/targets").toString());

			this.configuration.put("path/images",           this.configuration.get("server/root-http").toString()+this.configuration.get("path/images").toString());
			this.configuration.put("path/css",              this.configuration.get("server/root-http").toString()+this.configuration.get("path/css").toString());
			this.configuration.put("path/javascript",       this.configuration.get("server/root-http").toString()+this.configuration.get("path/javascript").toString());

			this.configuration.put("path/library-abs",      this.configuration.get("path/skb").toString()+this.configuration.get("path/library").toString());
			this.configuration.put("path/library-rel",      this.configuration.get("server/root-http").toString()+this.configuration.get("path/library").toString());
			this.configuration.remove("path/library");

			this.configuration.put("path/gallery-abs",      this.configuration.get("path/skb").toString()+this.configuration.get("path/gallery").toString());
			this.configuration.put("path/gallery-rel",      this.configuration.get("server/root-http").toString()+this.configuration.get("path/gallery").toString());
			this.configuration.remove("path/gallery");

			this.configuration.put("path/figures-abs",      this.configuration.get("path/skb").toString()+this.configuration.get("path/figures").toString());
			this.configuration.put("path/figures-rel",      this.configuration.get("server/root-http").toString()+this.configuration.get("path/figures").toString());
			this.configuration.remove("path/figures");

			this.configuration.put("php/file",     "[unset]");
			this.configuration.put("php/filename", "[unset]");

			if(this.configuration.containsKey("path/figures-local")){
				this.configuration.put("path/figures-local-abs",      this.configuration.get("server/root-fs").toString()+this.configuration.get("path/figures-local").toString());
				this.configuration.put("path/figures-local-rel",      __cfg_array.get("root-http").toString()+this.configuration.get("path/figures-local").toString());
				this.configuration.remove("path/figures-local");
			}
		}

		this.lang=this.configuration.get("system/lang").toString();

/*
        if(isset($_REQUEST['lang'])){
          $dir=$this->configuration->get_group("path", "locale");
          $supported=array();
          $handle=opendir($dir);
          while(false!==($file=readdir($handle))){
            if($file!="."&&$file!="..")
              $supported[]=$file;
          }
          closedir($handle);
          if(in_array($_REQUEST['lang'],$supported))
            $this->configuration->set_2_array("system", "lang", $_REQUEST['lang']);
        }
        $lang=$this->configuration->get_group("system", "lang");
        $this->lang=$this->configuration->get_group("system", "lang");
        putenv("LANG=$lang");
        putenv("LC_ALL=$lang");
        setlocale(LC_ALL, $lang);
      }
*/
		logger.trace("return, initialisation successful");
	}


	/**
	 * Loads the core packages.
	 * 
	 * This function loads the core packages. We cannot do this in the constructor, since the packages
	 * might need access to the SKB_Main instance. This function is called from main.inc.php5 right after
	 * creating the SKB_Main singleton. It should not be called by anyone else later. However, packages
	 * already loaded will not be processed again by require_package, so calling this function here more than
	 * once should not have any unwanted side effects.
	 */
	public void load_core_packages(){
		logger.trace("loading core packages: core, request, default, mime, http");
		this.requirePackage("core");
		this.requirePackage("core.request");
		this.requirePackage("core.default");
		this.requirePackage("core.mime");
		this.requirePackage("core.http");

//		myHttp=SKB_Http::get_instance();
//		myHttp->response_send_header("X-SKB", "v1.0");
		logger.trace("return, loaded core packages");
	}


	/**
	 * Loads a Package (.db and .php file in packages).
	 * 
	 * This function loads a package. It will check for the existence of packages/[package_name]/[package_name].db
	 * and packages/[package_name], with '.' replaced by directory separators. If either the database or
	 * the folder does not exist, it throws a USER ERROR. If the package is already loaded, nothing
	 * will be done here. Otherwise the database is analysed and all known tables will be read and the
	 * respective values being registered. Currently supported tables are: pkg_fields, pkg_requests,
	 * pkg_rabit, pkg_http_status_codes, pkg_http_headers_request, pkg_http_headers_response and pkg_http_request_methods.
	 * The package database will be registered in the PDO repository.
	 * @param pkg the packages name, i.e. core.skbinfo or mysite.mypackage
	 */
	public void requirePackage(String pkg){
		logger.trace("["+pkg+"] "+"loading");

		if(this.registered_packages.contains(pkg)){
			logger.trace("NOTICE: package <"+pkg+"> already loaded");
			logger.trace("return, doing nothing");
			return;
		}

		String pkg_dir=this.configuration.get("path/repository").toString()+pkg.replace(".", "/");
		String pkg_file_json=pkg_dir+"/"+pkg+".json";
		logger.trace("["+pkg+"] "+"directory: <"+pkg_dir+">");
		logger.trace("["+pkg+"] "+"JSON file: <"+pkg_file_json+">");

		//if file_exists pkg.json load file
		File pkgJsonFN=new File(pkg_file_json);
		if(pkgJsonFN.canRead()){
			this.load_from_json(pkg_file_json, pkg);
			logger.trace("["+pkg+"] "+"loaded from JSON");
		}
		else{
			logger.trace("["+pkg+"] "+"package JSON file does not exist, nothing loaded");
		}

		this.registered_packages.add(pkg);

		logger.trace("cleaning private maps");
		this.registered_fields.tsClean();
		this.registered_requests.tsClean();
		this.registered_readers.tsClean();
		this.registered_applications.tsClean();
		this.registered_builders.tsClean();
		this.registered_interpreters.tsClean();
		this.registered_templates.tsClean();
		logger.trace("["+pkg+"] "+"loaded");
	}

	/**
	 * Read a JSON file and execute the required functions (i.e. load_database, bind text domain).
	 *
	 * @param jsonFN the complete path and file name for the JSON file
	 * @param pkg the name of the package the JSON file belongs to
	 */
	public void load_from_json(String jsonFN, String pkg){
		File pkgJson=new File(jsonFN);
		if(pkgJson.canRead()){
			logger.trace("["+pkg+"] "+"loading from JSON file <"+pkgJson+">");
			SKBDataManager myDM=SKBDataManager.getInstance();

			Json2Oat j2o=new Json2Oat();
			TSBaseAPI _t=j2o.read(pkgJson);
			TSLinkedHashTree res=new TSLinkedHashTree();
			if(_t.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
				res=(TSLinkedHashTree)_t;

			logger.trace("["+pkg+"] "+"read file, testing for contents");
			if(res!=null){
				if(res.containsKey("load_repository_object")){
					logger.trace("["+pkg+"] "+"found <load_repository_object>");
					TSBaseAPI loadrepo=(res).get("load_repository_object");
					if(loadrepo.tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)){
						for(TSBaseAPI dos : (TSArrayList)loadrepo){
							if(dos.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)){
								TSLinkedHashTree repo=(TSLinkedHashTree)dos;
								if(repo.containsKey("sema_tag")&&repo.containsKey("type")&&repo.containsKey("handle")&&repo.containsKey("tables")&&repo.containsKey("filter_id")){
									myDM.loadDataObject(repo.get("sema_tag").toString(), repo.get("type").toString(), repo.get("handle").toString(), repo.get("tables").toString(), repo.get("filter_id").toString(), pkg);
									TSLinkedHashTree data=myDM.queryDataObject(myDM.prepareQuery(repo.get("sema_tag").toString(), null, null, null, repo.get("filter_id").toString(), pkg, false, true));
									this.load_repository_info(repo.get("sema_tag").toString(), data, repo.get("filter_id").toString(), pkg);
								}
							}
						}
					}
				}
				if(res.containsKey("require_package")){
					logger.trace("["+pkg+"] "+"found <require_package>");
					TSBaseAPI reqpkg=(res).get("require_package");
					if(reqpkg.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING))
						reqpkg=((TSString)res.get("require_package")).tsExplode();
					if(reqpkg.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
						for(int i=0;i<((TSArrayListString)reqpkg).size();i++){
							this.requirePackage(((TSArrayListString)reqpkg).get(i).toString());
						}
					}
				}
				if(res.containsKey("text_domain")){
					logger.trace("["+pkg+"] "+"found <text_domain>");
					TSArrayList ar=(TSArrayList)res.get("text_domain");
					if(ar!=null){
						for(int i=0;i<ar.size();i++){
							TSLinkedHashTree ld=(TSLinkedHashTree)((TSArrayList)ar).get(i);
							if(ld!=null)
								if(ld.containsKey("domain"))
									this.i18n.addDomain(ld.get("domain").toString(), new Locale(this.configuration.get("system/lang").toString()));
						}
					}
				}
				if(res.containsKey("load_data_object")){
					logger.trace("["+pkg+"] "+"found <load_data_object>");
					TSBaseAPI loaddata=(res).get("load_data_object");
					if(loaddata.tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)){
						for(TSBaseAPI dos : (TSArrayList)loaddata){
							if(dos.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)){
								TSLinkedHashTree data=(TSLinkedHashTree)dos;
								if(data.containsKey("sema_tag")&&data.containsKey("type")&&data.containsKey("handle")&&data.containsKey("tables")&&data.containsKey("filter_id"))
									myDM.loadDataObject(data.get("sema_tag").toString(), data.get("type").toString(), data.get("handle").toString(), data.get("tables").toString(), data.get("filter_id").toString(), pkg);
							}
						}
					}
				}
			}
		}
		else{
			logger.error("["+pkg+"] "+"cant' read JSON file <"+pkgJson+">");
		}
	}


	/**
	 * Loads all repository information of a required package.
	 * @param semaTag semantic tag for the fields
	 * @param data actual data to load information from
	 * @param filter filter to be used (with the semantic tag)
	 * @param pkg package
	 */
	private void load_repository_info(String semaTag, TSLinkedHashTree data, String filter, String pkg){
//		TSMapLH http_ar=new TSMapLH();

		if(semaTag==""){

		}
		else if(semaTag.equals("skb:repository:fields")){
			Set<String> o_set = data.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				TSLinkedHashTree val=(TSLinkedHashTree)data.get(key);
				val.put("package", pkg);
				this.registered_fields.put(key, val);
			}
		}
		else if(semaTag.equals("skb:repository:requests")){
			Set<String> o_set = data.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				TSLinkedHashTree val=(TSLinkedHashTree)data.get(key);
				val.put("package", pkg);
				this.registered_requests.put(key, val);
			}
		}
		else if(semaTag.equals("skb:repository:rabit")){
			Set<String> o_set = data.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				TSLinkedHashTree val=(TSLinkedHashTree)data.get(key);
				val.put("package", pkg);
				if(val.containsKey("core:rabit:type")){
					TSLinkedHashTree tmap=null;
					String type=val.get("core:rabit:type").toString();
					if(type.equals("reader"))
						tmap=this.registered_readers;
					else if(type.equals("builder"))
						tmap=this.registered_builders;
					else if(type.equals("interpreter:core")||type.equals("interpreter:value")||type.equals("interpreter:entries")||type.equals("interpreter:entity"))
						tmap=this.registered_interpreters;
					else if(type.equals("template"))
						tmap=this.registered_templates;
					else if(type.equals("application"))
						tmap=this.registered_applications;
					else
						logger.error("SKB_Main: Unknown RABIT type: <"+type+">");

					if(tmap!=null){
						tmap.put(key, val);
						if(val.containsKey("core:rabit:target:class")){
							TSString _ts=(TSString)val.get("core:rabit:target:class");
							if(_ts!=null&&_ts.tsvalue!=null)
								tmap.put(key+"/core:rabit:target:class", _ts.tsExplode());
						}
						if(val.containsKey("core:rabit:target:template")){
							TSString _ts=(TSString)val.get("core:rabit:target:template");
							if(_ts!=null&&_ts.tsvalue!=null)
								tmap.put(key+"/core:rabit:target:template", _ts.tsExplode());
						}
					}
				}
			}
		}
		else if(semaTag.equals("skb:repository:http_headers_response")){
			
		}
		else if(semaTag.equals("skb:repository:http_request_methods")){
			
		}
		else if(semaTag.equals("skb:repository:http_headers_request")){
			
		}
		else if(semaTag.equals("skb:repository:http_status_codes")){
			
		}
		else if(semaTag.equals("skb:repository:mime_ct")){
			
		}
		else{

		}
	}


	/**
	 * Loads all available packages for the current site.
	 * 
	 * This function loads all available (installed) packages for the current site ($site_id).
	 * This can be practical when loading individual packages is inconvenient. It is used for
	 * viewing configuration by the Core.SkbConfig package.
	 * @param additional
	 */
	public void loadAllSitePackages(ArrayList<String> additional){
		String pkg_dir=this.configuration.get("path/repository").toString();
		String site_id=this.configuration.get("skb/site-id").toString();

		FindPackageDirectories fpd=new FindPackageDirectories();
		fpd.setSiteID(site_id);
		List<String> files = fpd.getTxtFiles(pkg_dir);
		pkg_dir=pkg_dir.replace(FilenameUtils.getPrefix(pkg_dir), "");
		for(int i=0;i<files.size();i++){
			String fn=files.get(i);
			fn=fn.replace(FilenameUtils.getPrefix(fn), "");
			fn=fn.replace(FilenameUtils.separatorsToUnix(pkg_dir), "");
			fn=fn.replace("/", ".");
			this.requirePackage(fn);
		}
//	      in_array(str_replace($pkg_dir,"",$pkg),$additional)
	}


	/**
	 * Return the current configuration array.
	 * 
	 * @return the current configuration array
	 */
	public TSLinkedHashTree getConfiguration(){
		return this.configuration;
	}


	/**
	 * Return the specified registration field or a complete group of fields.
	 * 
	 * @param group group name of the requested group
	 * @param key name of the requested key; if null then the group is returned
	 * @return the configuration value if it exists
	 */
	public TSBaseAPI getConfiguration(String group, String key){
		if(key==null)
			return this.configuration.get(group);
		else
			return this.configuration.get(group+"/"+key);
	}


	/**
	 * Return all currently registered fields.
	 * 
	 * @return list of all registered fields
	 */
	public TSLinkedHashTree getRegisteredFields(){
		return this.registered_fields; 				
	}

	/**
	 * Return the specified field.
	 * 
	 * @param key name of the field
	 * @return field entry if it exists null otherwise
	 */
	public TSBaseAPI getRegisteredFields(String key){
		if(this.registered_fields.containsKey(key))
			return this.registered_fields.get(key);
		return null;
	}


	/**
	 * Return all currently registered requests.
	 * 
	 * @return list of all registered requests
	 */
	public TSLinkedHashTree getRegisteredRequests(){
		return this.registered_requests; 				
	}


	/**
	 * Return the specified requests.
	 * 
	 * @param key name of the requests
	 * @return requests entry if it exists null otherwise
	 */
	public TSBaseAPI getRegisteredRequests(String key){
		if(this.registered_requests.containsKey(key))
			return this.registered_requests.get(key);
		return null;
	}


	/**
	 * Return all currently registered readers.
	 * 
	 * @return list of all registered readers
	 */
	public TSLinkedHashTree getRegisteredReaders(){
		return this.registered_readers;
	}


	/**
	 * Return the specified reader.
	 * 
	 * @param key name of the reader
	 * @return reader entry if it exists null otherwise
	 */
	public TSLinkedHashTree getRegisteredReaders(String key){
		if(this.registered_readers.containsKey(key))
			return (TSLinkedHashTree)this.registered_readers.get(key);
		return null;
	}


	/**
	 * Return all currently registered builders.
	 * 
	 * @return list of all registered builders
	 */
	public TSLinkedHashTree getRegisteredBuilders(){return this.registered_builders;}


	/**
	 * Return the specified builder.
	 * 
	 * @param key name of the builder
	 * @return builder entry if it exists null otherwise
	 */
	public TSLinkedHashTree getRegisteredBuilders(String key){
		if(this.registered_builders.containsKey(key))
			return (TSLinkedHashTree)this.registered_builders.get(key);
		return null;
	}


	/**
	 * Return all currently registered templates.
	 * 
	 * @return list of all registered templates
	 */
	public TSLinkedHashTree getRegisteredTemplates(){return this.registered_templates;}


	/**
	 * Return the specified template.
	 * 
	 * @param key name of the template
	 * @return template entry if it exists null otherwise
	 */
	public TSLinkedHashTree getRegisteredTemplates(String key){
		if(this.registered_templates.containsKey(key))
			return (TSLinkedHashTree)this.registered_templates.get(key);
		return null;
	}


	/**
	 * Return all currently registered interpreters.
	 * 
	 * @return list of all registered interpreters
	 */
	public TSLinkedHashTree getRegisteredInterpreters(){return this.registered_interpreters;}


	/**
	 * Return the specified interpreter.
	 * 
	 * @param key name of the interpreter
	 * @return interpreter entry if it exists null otherwise
	 */
	public TSLinkedHashTree getRegisteredInterpreters(String key){
		if(this.registered_interpreters.containsKey(key))
			return (TSLinkedHashTree)this.registered_interpreters.get(key);
		return null;
	}


	/**
	 * Return all currently registered applications.
	 * 
	 * @return list of all registered applications
	 */
	public TSLinkedHashTree getRegisteredApplications(){return this.registered_applications;}


	/**
	 * Return the specified application.
	 * 
	 * @param key name of the application
	 * @return interpreter entry if it exists null otherwise
	 */
	public TSLinkedHashTree getRegisteredApplications(String key){
		if(this.registered_applications.containsKey(key))
			return (TSLinkedHashTree)this.registered_applications.get(key);
		return null;
	}


	/**
	 * Return a Request object for the given key.
	 * 
	 * @param type name of the requested request
	 * @return request object
	 */
	public Request getRequest(String type){
		if(type.equals(null)||type.equals(""))
			type="Core.Default";
		if(this.registered_requests.containsKey(type)){
			Request ret=new Request();
			ret.setRequestType(type, (TSLinkedHashTree)this.registered_requests.get(type), this.registered_fields);
			return ret;
		}
		logger.error("SKB_Main: request not found: {"+type+"}\n--> USER ERROR");
		return null;
	}


	/**
	 * Return a Reader object for the given key.
	 * 
	 * @param key name of the requested reader
	 * @return new reader object
	 */
	public SKBReader getReader(String key){
		if(this.registered_readers.containsKey(key)){
			try{
				Class<?> theClass=Class.forName((String)this.registered_readers.get(key+"/core:rabit:target:class/java").toString());
				SKBReader ret=(SKBReader)theClass.newInstance();
				return ret;
			} catch (Exception e) {
				logger.error("SKB_Main: caught exception instantiation reader: <"+key+">\n-->"+e);
			}
		}
		logger.error("SKB_Main: reader not found: <"+key+">");
		return null;
	}


	/**
	 * Return a Builder object for the given key.
	 * 
	 * @param key name of the requested builder
	 * @return new builder object
	 */
	public SKBBuilder getBuilder(String key){
		if(this.registered_builders.containsKey(key)){
			try{
				Class<?> theClass=Class.forName((String)this.registered_builders.get(key+"/core:rabit:target:class/java").toString());
				SKBBuilder ret=(SKBBuilder)theClass.newInstance();
				ret.setTemplates();
				return ret;
			} catch (Exception e) {
				logger.error("SKB_Main: caught exception instantiation builder: <"+key+">\n-->"+e);
			}
		}
		logger.error("SKB_Main: builder not found: <"+key+">");
		return null;
	}


	/**
	 * Return a Builder object for the given key.
	 * 
	 * @param key name of the requested builder
	 * @return new interpreter object
	 */
	public SKBInterpreter getInterpreter(String key){
		if(this.registered_interpreters.containsKey(key)){
			try{
				Class<?> theClass=Class.forName((String)this.registered_interpreters.get(key+"/core:rabit:target:class/java").toString());
				SKBInterpreter ret=(SKBInterpreter)theClass.newInstance();
				return ret;
			} catch (Exception e) {
				logger.error("SKB_Main: caught exception instantiation interpreter: <"+key+">\n-->"+e);
			}
		}
		logger.error("SKB_Main: interpreter not found: <"+key+">");
		return null;
	}


	/**
	 * Return a Application object for the given key.
	 * 
	 * @param key name of the requested application
	 * @return an SKBApplications if found, null otherwise
	 */
	public SKBApplication getApplication(String key){
		if(this.registered_applications.containsKey(key)){
			try{
				Class<?> theClass=Class.forName((String)this.registered_applications.get(key+"/core:rabit:target:class/java").toString());
				SKBApplication ret=(SKBApplication)theClass.newInstance();
				return ret;
			} catch (Exception e) {
				logger.error("SKB_Main: caught exception instantiation application: <"+key+">\n-->"+e);
			}
		}
		logger.error("SKB_Main: application not found: <"+key+">");
		return null;
	}


	public TSLinkedHashTree getFieldSettings(String field){
		if(this.registered_fields.containsKey(field))
			return (TSLinkedHashTree)this.registered_fields.get(field);
		return null;
	}


	/**
	 * Return the current language set for the SKB
	 * @return current language
	 */
	public String getLang(){
		return this.lang;
	}
}