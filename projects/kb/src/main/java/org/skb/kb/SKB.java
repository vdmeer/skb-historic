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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.skb.util.io.dirwalker.FindPackageDirectories;
import org.skb.util.misc.I18NManager;
import org.skb.util.misc.Json2Oat;
import org.skb.util.pattern.Request;
import org.skb.util.sql.DBPDOs;
import org.skb.util.sql.PDOConnect;
import org.skb.util.types.TSRepository;
import org.skb.util.types.TSRepository.TEnum;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.db.TSPDO;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.atomic.util.TSScope;
import org.skb.util.types.composite.util.TSArrayList;
import org.skb.util.types.composite.util.TSMapLH;

public class SKB {
	private String lang;
	public static String site_id;

	public TSMapLH configuration;

	private DBPDOs dbpdos;

	private TSArrayListString registered_packages; 

	private TSMapLH registered_fields;
	private TSMapLH registered_requests;
	private TSMapLH registered_readers;
	private TSMapLH registered_builders;
	private TSMapLH registered_templates;
	private TSMapLH registered_interpreters;
	private TSMapLH registered_applications;

	private I18NManager i18n; 

	private static class XtSKB_MainHolder{
		private final static SKB INSTANCE = new SKB();
	}

	public static SKB getInstance(){
		return XtSKB_MainHolder.INSTANCE;
	}

	private SKB(){
		this.configuration=new TSMapLH();
		this.dbpdos=new DBPDOs();
		this.registered_packages=new TSArrayListString();

		this.registered_fields=new TSMapLH();
		this.registered_requests=new TSMapLH();
		this.registered_readers=new TSMapLH();
		this.registered_builders=new TSMapLH();
		this.registered_templates=new TSMapLH();
		this.registered_interpreters=new TSMapLH();
		this.registered_applications=new TSMapLH();

		this.i18n=new I18NManager(); 

		//try for the main variables we'll need set (similar to main.inc.php)
		//String site_id = System.getenv("site_id");           //id for the website
		String site_id = "default";           //id for the website
		String site_path = "www/demo";     //path to the website

		String root_classes = "/classes/";
		String root_skb = "/skb";
		String root_document = "V:/dev/projects/skb/skb-eclipse/kb/src/main/resources";

		TSMapLH __cfg_array=new TSMapLH();
		__cfg_array.put("root-document", root_document);
		__cfg_array.put("root-skb", root_skb);
		__cfg_array.put("root-classes", root_classes);
		__cfg_array.put("config-core", root_document+root_skb+"/config/core.db");
		__cfg_array.put("config-site", root_document+root_skb+"/config/"+site_id+".db");
		__cfg_array.put("site_path", site_path);
		__cfg_array.put("skb_site_id", site_id);
		__cfg_array.put("php_extension", ".php5");

		if(!__cfg_array.containsKey("skb_site_id")){
			System.err.println("SKB_Main: given configuration not valid");
			System.exit(-1);
		}
		else{
			Connection c;
			PDOConnect o;
			ResultSet rs;

			//load the skb configuration
			o=new PDOConnect(((TSString)__cfg_array.get("config-core")).tsvalue);
			c=o.connection;
			try{
				rs=c.createStatement().executeQuery("SELECT * FROM skb_cfg");
				String collection;
				String part;
				TSString value;
				Boolean explode;
				while (rs.next()) {
					collection=rs.getString("collection");
					part=rs.getString("part");
					value=new TSString(rs.getString("value"));
				explode=rs.getBoolean("field_explodes");

					if(!this.configuration.containsKey(collection)){
						this.configuration.put(collection, new TSMapLH());
					}

					if(explode)
						this.configuration.put(collection+"/"+part, value.tsExplode());
					else
						this.configuration.put(collection+"/"+part, value);
				}
				this.configuration.put("skb/site-id", __cfg_array.get("skb_site_id"));
				SKB.site_id=this.configuration.get("skb/site-id").toString();
				this.dbpdos.pdo_add("core:cfg", __cfg_array.get("config-core").toString(), new TSArrayListString("skb_cfg"), new TSPDO(c), "core:cfg");
			} catch (Exception e) {
				e.printStackTrace();
			}

			//load the site specific configuration
			o=new PDOConnect(((TSString)__cfg_array.get("config-site")).tsvalue);
			c=o.connection;
			try{
				rs=c.createStatement().executeQuery("SELECT * FROM configuration");
				String collection;
				String part;
				TSString value;
				Boolean explode;
				while (rs.next()) {
					collection=rs.getString("collection");
					part=rs.getString("part");
					value=new TSString(rs.getString("value"));
					explode=rs.getBoolean("field_explodes");

					if(!this.configuration.containsKey(collection)){
						this.configuration.put(collection, new TSMapLH());
					}

					if(explode)
						this.configuration.put(collection+"/"+part, value.tsExplode());
					else
						this.configuration.put(collection+"/"+part, value);
				}

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

				this.dbpdos.pdo_add("site:cfg", __cfg_array.get("config-site").toString(), new TSArrayListString("skb_cfg"), new TSPDO(c), "site:cfg");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//System.out.println("original now");
//System.err.println(this.configuration);
/*
        $this->db_scope=SKB_DBScope::get_instance();

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

		this.load_core_packages();
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
		this.requirePackage("core");
		this.requirePackage("core.request");
		this.requirePackage("core.default");
		this.requirePackage("core.mime");

		this.requirePackage("core.http");
//		myHttp=SKB_Http::get_instance();
//		myHttp->response_send_header("X-SKB", "v1.0");
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
		if(this.registered_packages.contains(pkg)){
			//if(SKB_LOAD_PACKAGE_NOTICE===true)
	        //  trigger_error("SKB_Main: package already loaded: $package", E_USER_NOTICE);
			return;
		}

		String pkg_dir=this.configuration.get("path/repository").toString()+pkg.replace(".", "/");
		String pkg_file_db=pkg_dir+"/"+pkg+".db";
		String pkg_file_json=pkg_dir+"/"+pkg+".json";

		File pkg_dir_fh=new File(pkg_dir);
		if(!pkg_dir_fh.canRead()){
			System.err.println("SKB_Main: package not found or not correctly installed: "+pkg+" in "+pkg_file_db+" and "+pkg_dir);
			System.exit(-10);
		}

		TSPDO pdo;
		ResultSet rs;
		ArrayList<String> cols=null;

		File pkg_file_db_fh=new File(pkg_file_db);
		if(pkg_file_db_fh.canRead()){
			pdo=new TSPDO(new PDOConnect(pkg_file_db).connection);
			ArrayList<String> tables=new ArrayList<String>();

			//package fields
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_fields")){
				tables.add(pkg+":pkg_fields");
				rs=pdo.query("*", "pkg_fields", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							this.registered_fields.put(rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						this.registered_fields.put(rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//package requests
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_requests")){
				tables.add(pkg+":pkg_requests");
				rs=pdo.query("*", "pkg_requests", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						//if(SKB_LOAD_PACKAGE_NOTICE===true){
						//  if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_requests))
						//    trigger_error("SKB_Main: redefinitions of registered request: {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
						//}
						for(int i=1;i<cols.size();i++)
							this.registered_requests.put(rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						this.registered_requests.put(rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//package rabit
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_rabit")){
				tables.add(pkg+":pkg_rabit");

				rs=pdo.query("*", "pkg_rabit", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						if(cols.contains("core:rabit:type")){
							TSMapLH tmap=null;
							String type=rs.getString("core:rabit:type");
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
								System.err.println("SKB_Main: Unknown RABIT type: "+type);

							if(tmap!=null){
								TSString t;
								for(int i=1;i<cols.size();i++){
									// TODO if(SKB_LOAD_PACKAGE_NOTICE===true){
									if(cols.get(i).equals("core:rabit:target:class")||cols.get(i).equals("core:rabit:target:template")){
										t=null;
										t=new TSString(rs.getString(cols.get(i)));
										if(t!=null&&t.tsvalue!=null)
											tmap.put(rs.getString("key")+"/"+cols.get(i), t.tsExplode());
									}
									else
										tmap.put(rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
								}
								tmap.put(rs.getString("key")+"/origin", "pkg:"+pkg);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			TSMapLH http_ar=new TSMapLH();

			//http_status_codes
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_http_status_codes")){
				tables.add(pkg+":pkg_http_status_codes");
				http_ar.put("http_status_codes", new TSMapLH());

				rs=pdo.query("*", "pkg_http_status_codes", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							http_ar.put("http_status_codes/"+rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						http_ar.put("http_status_codes/"+rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//http_headers_request
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_http_headers_request")){
				tables.add(pkg+":pkg_http_headers_request");
				http_ar.put("http_headers_request", new TSMapLH());

				rs=pdo.query("*", "pkg_http_headers_request", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							http_ar.put("http_headers_request/"+rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						http_ar.put("http_headers_request/"+rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//http_headers_response
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_http_headers_response")){
				tables.add(pkg+":pkg_http_headers_response");
				http_ar.put("http_headers_response", new TSMapLH());

				rs=pdo.query("*", "pkg_http_headers_response", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							http_ar.put("http_headers_response/"+rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						http_ar.put("http_headers_response/"+rs.getString("key")+ "/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//http_request_methods
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_http_request_methods")){
				tables.add(pkg+":pkg_http_request_methods");
				http_ar.put("http_request_methods", new TSMapLH());

				rs=pdo.query("*", "pkg_http_request_methods", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							http_ar.put("http_request_methods/"+rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						http_ar.put("http_request_methods/"+rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			//mime_content_types
			if(this.dbpdos.pdo_table_exists(pdo, "pkg_mime_content_types")){
				tables.add(pkg+":pkg_mime_content_types");
				http_ar.put("mime_content_types", new TSMapLH());

				rs=pdo.query("*", "pkg_mime_content_types", null, null);
				cols=pdo.get_columns();
				try{
					while(rs.next()){
						for(int i=1;i<cols.size();i++)
							http_ar.put("mime_content_types/"+rs.getString("key")+"/"+cols.get(i), rs.getString(cols.get(i)));
						http_ar.put("mime_content_types/"+rs.getString("key")+"/origin", "pkg:"+pkg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if(http_ar.size()>0){
//		          $myHttp=SKB_Http::get_instance();
//		          $myHttp->set_data($http_ar);				
			}

			//register pdo
			this.dbpdos.pdo_add("reg:"+pkg, pkg_file_db, new TSArrayListString(tables), pdo, "reg:"+pkg);
		}

		//if file_exists pkg.json load file
		File pkg_json_fn=new File(pkg_file_json);
		if(pkg_json_fn.canRead()){
			Json2Oat j2o=new Json2Oat();
			TSBase _t=j2o.read(pkg_json_fn);
			TSMapLH res=new TSMapLH();
			if(_t.tsIsType(TEnum.TS_COMPOSITE_MAP_LH))
				res=(TSMapLH)_t;

			if(res!=null){
				if(res.containsKey("require_package")){
					TSBase reqpkg=(res).get("require_package");
					if(reqpkg.tsIsType(TSRepository.TEnum.TS_ATOMIC_JAVA_STRING))
						reqpkg=((TSString)res.get("require_package")).tsExplode();
					if(reqpkg.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
						for(int i=0;i<((TSArrayListString)reqpkg).size();i++){
							this.requirePackage(((TSArrayListString)reqpkg).get(i).toString());
						}
					}
				}
				if(res.containsKey("load_database")){
					TSArrayList ar=(TSArrayList)res.get("load_database");
					if(ar!=null){
						for(int i=0;i<ar.size();i++){
							TSMapLH ld=(TSMapLH)ar.get(i);
							if(ld!=null){
								if(ld.containsKey("fn")&&ld.containsKey("tables")){
									TSBase tables=((TSString)ld.get("tables")).tsExplode();
									if(tables.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING))
										this.loadDatabase(ld.get("fn").toString(), (TSArrayListString)tables, pkg, null);
								}
							}
						}
					}
				}
			}
			if(res.containsKey("text_domain")){
				TSArrayList ar=(TSArrayList)res.get("text_domain");
				if(ar!=null){
					for(int i=0;i<ar.size();i++){
						TSMapLH ld=(TSMapLH)((TSArrayList)ar).get(i);
						if(ld!=null)
							if(ld.containsKey("domain"))
								this.i18n.addDomain(ld.get("domain").toString(), new Locale(this.configuration.get("system/lang").toString()));
					}
				}
			}
		}

		this.registered_packages.add(pkg);

		//clean the local maps, i.e. remove all zero/null entries
		this.registered_requests.tsClean();
		this.registered_readers.tsClean();
		this.registered_applications.tsClean();
		this.registered_builders.tsClean();
		this.registered_interpreters.tsClean();
		this.registered_templates.tsClean();
		//add SKB_LOAD_PACKAGE_NOTICE===true echo(pkg loaded)
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
		fpd.siteID(site_id);
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
	  * Register a Database (from database/) in the PDO repository.
	  * 
	  * This function creates a PDO object for the given database and registered the tables in the PDO
	  * repository. One can provide a package name or a simple name, the difference being that using a package name
	  * the registration will prefix it with "pkg:".
	  * 
	  * @param fn the filename of the database, assuming it is on the directory database/
	  * @param tables the tables to be registered, can be array or comma-separated list as string
	  * @param pkg name as package for the PDO repository or null if simple name is used
	  * @param name simple name for the PDO repository
	  */
	public void loadDatabase(String fn, TSArrayListString tables, String pkg, String name){
		String key;
		if(name!=null)
			key=name;
		else
			key="pkg:"+pkg;
		String dbFile=this.configuration.get("path/database")+fn+".db";
		TSPDO pdo=new TSPDO(new PDOConnect(dbFile).connection);
		for(int i=1;i<tables.size();i++){
			if(this.dbpdos.pdo_table_exists(pdo, tables.get(i).toString())==false){
				//TODO trigger_error('SKB_Main: Database Table not found: '.$tables[$_keys[$i]].' in '.$db_file, E_USER_ERROR);
				System.err.println("SKB_Main: table "+tables.get(i)+" not found in db "+fn);
			}
		}
		this.dbpdos.pdo_add(key, dbFile, tables, pdo, key);
	}


	/**
	 * Return the current configuration array.
	 * 
	 * @return the current configuration array
	 */
	public TSMapLH getConfiguration(){
		return this.configuration;
	}

	/**
	 * Return the specified registration field or a complete group of fields.
	 * 
	 * @param group group name of the requested group
	 * @param key name of the requested key; if null then the group is returned
	 * @return the configuration value if it exists
	 */
	public TSBase getConfiguration(String group, String key){
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
	public TSMapLH getRegisteredFields(){
		return this.registered_fields; 				
	}

	/**
	 * Return the specified field.
	 * 
	 * @param key name of the field
	 * @return field entry if it exists null otherwise
	 */
	public TSBase getRegisteredFields(String key){
		if(this.registered_fields.containsKey(key))
			return this.registered_fields.get(key);
		return null;
	}


	/**
	 * Return all currently registered requests.
	 * 
	 * @return list of all registered requests
	 */
	public TSMapLH getRegisteredRequests(){
		return this.registered_requests; 				
	}

	/**
	 * Return the specified requests.
	 * 
	 * @param key name of the requests
	 * @return requests entry if it exists null otherwise
	 */
	public TSBase getRegisteredRequests(String key){
		if(this.registered_requests.containsKey(key))
			return this.registered_requests.get(key);
		return null;
	}

	/**
	 * Return all currently registered readers.
	 * 
	 * @return list of all registered readers
	 */
	public TSMapLH getRegisteredReaders(){return this.registered_readers;}

	/**
	 * Return the specified reader.
	 * 
	 * @param key name of the reader
	 * @return reader entry if it exists null otherwise
	 */
	public TSMapLH getRegisteredReaders(String key){
		if(this.registered_readers.containsKey(key))
			return (TSMapLH)this.registered_readers.get(key);
		return null;
	}

	/**
	 * Return all currently registered builders.
	 * 
	 * @return list of all registered builders
	 */
	public TSMapLH getRegisteredBuilders(){return this.registered_builders;}

	/**
	 * Return the specified builder.
	 * 
	 * @param key name of the builder
	 * @return builder entry if it exists null otherwise
	 */
	public TSMapLH getRegisteredBuilders(String key){
		if(this.registered_builders.containsKey(key))
			return (TSMapLH)this.registered_builders.get(key);
		return null;
	}

	/**
	 * Return all currently registered templates.
	 * 
	 * @return list of all registered templates
	 */
	public TSMapLH getRegisteredTemplates(){return this.registered_templates;}

	/**
	 * Return the specified template.
	 * 
	 * @param key name of the template
	 * @return template entry if it exists null otherwise
	 */
	public TSMapLH getRegisteredTemplates(String key){
		if(this.registered_templates.containsKey(key))
			return (TSMapLH)this.registered_templates.get(key);
		return null;
	}

	/**
	 * Return all currently registered interpreters.
	 * 
	 * @return list of all registered interpreters
	 */
	public TSMapLH getRegisteredInterpreters(){return this.registered_interpreters;}

	/**
	 * Return the specified interpreter.
	 * 
	 * @param key name of the interpreter
	 * @return interpreter entry if it exists null otherwise
	 */
	public TSMapLH getRegisteredInterpreters(String key){
		if(this.registered_interpreters.containsKey(key))
			return (TSMapLH)this.registered_interpreters.get(key);
		return null;
	}

	/**
	 * Return all currently registered applications.
	 * 
	 * @return list of all registered applications
	 */
	public TSMapLH getRegisteredApplications(){return this.registered_applications;}

	/**
	 * Return the specified application.
	 * 
	 * @param key name of the application
	 * @return interpreter entry if it exists null otherwise
	 */
	public TSMapLH getRegisteredApplications(String key){
		if(this.registered_applications.containsKey(key))
			return (TSMapLH)this.registered_applications.get(key);
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
			ret.setRequestType(type, (TSMapLH)this.registered_requests.get(type), this.registered_fields);
			return ret;
		}
		System.err.println("SKB_Main: request not found: {"+type+"}\n--> USER ERROR");;
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
				e.printStackTrace();
			}
		}
		System.err.println("ERROR, Reader not found");
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
				ret.set_templates();
				return ret;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.err.println("ERROR, Builder not found");
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
				e.printStackTrace();
			}
		}
		System.err.println("ERROR, Interpreter not found");
		return null;
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
	public TSBase interpretData(String id, TSBase val, String table, Request request){
		try{
			Class<?> theClass=Class.forName((String)this.registered_interpreters.get(id+"/core:rabit:target:class/java").toString());
			SKBInterpreter inter=(SKBInterpreter)theClass.newInstance();
			String type=this.registered_interpreters.get("id/core:rabit:type").toString();
			if(type.equals("interpreter:core"))
				((SKBInterpreterCore)inter).interpret(val.toString(), request);
			else if(type.equals("interpreter:entity"))
				((SKBInterpreterEntity)inter).interpret(val.toString(), table);
			else if(type.equals("interpreter:value"))
				((SKBInterpreterValue)inter).interpret(val.toString());
			else if(type.equals("interpreter:entries"))
				((SKBInterpreterEntries)inter).interpret((TSMapLH)val, table);
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		//trigger_error("SKB_Main: interpreter not found: {$id} for target {$target}", E_USER_ERROR);
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
				e.printStackTrace();
			}
		}
		System.err.println("ERROR, Application not found");
		return null;
	}

/*
	  public function get_application($type){
	  	$target=$this->configuration->get_group("skb", "target");
	    if(array_key_exists($type, $this->registered_applications))
	      return new $this->registered_applications[$type]['core:rabit:target:class'][$target];
	    else
	      trigger_error("SKB_Main: application not found: {$type} for target {$target}", E_USER_ERROR);
	  }
*/

	public void interpretMap(TSMapLH map, String table){
		if(map==null||map.size()==0)
			return;
		map.tsClean();
		if(map.size()==0)
			return;

		this.interpret_map(map, new TSScope());
	}

	protected void interpret_map(TSMapLH map, TSScope scope){
		if(map==null||map.size()==0)
			return;

		ArrayList<String> listRemove=new ArrayList<String>();
		TSMapLH mergeMap=new TSMapLH();

		String key;
		Set<String> o_set = map.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			TSBase val=map.get(key);
			switch(val.tsGetTypeEnum()){
				case TS_COMPOSITE_MAP_LH:
					this.interpret_map((TSMapLH)val, scope);
					break;
				case TS_ATOMIC_JAVA_STRING:
					if(this.registered_fields.containsKey(key)){
						String name=this.registered_fields.get(key+"/core:entries_name").toString();
						String type=this.registered_fields.get(key+"/core:type").toString();
						if(type.equals("entity")){
							String table=null;
							if(this.registered_fields.get(key+"/core:default_db")!=null)
								table=this.registered_fields.get(key+"/core:default_db").toString();
							if(table==null)
								continue;

							if(this.registered_fields.get(key+"/core:interpreter")==null){
								String exp=this.registered_fields.get(key+"/core:explode").toString();
								if(exp.equals("1")){
									TSBase newVal=((TSString)val).tsExplode();
									if(newVal.tsIsType(TSRepository.TEnum.TS_ATOMIC_ARRAYLIST_STRING)){
										mergeMap.put(name, new TSMapLH());
										TSArrayListString m=(TSArrayListString)newVal;
										for(Integer i=0;i<m.size();i++){
											TSMapLH _t=new TSMapLH();
											_t.put(name+"_key", m.get(i));
											this.interpret_map(_t, scope);
											mergeMap.put(name+"/"+i.toString(), _t);
										}
									}
									listRemove.add(key);
								}
								else{
									if(scope.push(table,val.toString())==true){
										ResultSet rs=null;
										ArrayList<String> cols=null;
										TSPDO pdo=null;
	
										TSMapLH _t=new TSMapLH();
										pdo=this.dbpdos.pdo_select(table);
										rs=pdo.query("*", table, "key = '"+val+"'", null);
										cols=pdo.get_columns();
	
										try{
											while(rs.next()){
												for(int i=0;i<cols.size();i++){
													_t.put(name+"/"+cols.get(i), rs.getString(cols.get(i)));
												}
											}
										} catch (Exception e) {
											e.printStackTrace();
										}
										_t.tsClean();
										this.interpret_map(_t, scope);
										mergeMap.putAll(_t);
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
							String exp=this.registered_fields.get(key+"/core:explode").toString();
							if(key.endsWith("_locale")){
								if(((TSString)val).tsvalue.contains("%%")){
									String split[]=((TSString)val).tsvalue.split("%%");
									mergeMap.put(name,this.i18n._(split[0], split[1]));
									listRemove.add(key);
								}
								else if(((TSString)val).tsvalue.contains("%")){
									TSBase newVal=((TSString)val).tsExplode();
									if(newVal.tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)){
										TSMapLH m=(TSMapLH)newVal;
										String lang=this.lang;
										if(m.get(lang)!=null)
											mergeMap.put(name,m.get(lang));
										else if(m.get("")!=null)
											mergeMap.put(name,m.get(""));
										else
											mergeMap.put(name,"");
										listRemove.add(key);
									}
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
	 * Reset DB Scope, which is used in the interpreter loop to detect and avoid reference loops in the databases
	 */
	public void resetScope(){
		//$this->db_scope->reset();
	}

	public TSMapLH getFieldSettings(String field){
		if(this.registered_fields.containsKey(field))
			return (TSMapLH)this.registered_fields.get(field);
		return null;
	}

	/**
	 * Return registered PDOs.
	 * @return the currently registered PDOs
	 */
	public TSMapLH getRegisteredPDOs(){
		return this.dbpdos.get_registered_pdos();
	}

	/**
	 * Return specific PDO.
	 * 
	 * @param group of PDOs
	 * @param key specific id within a group
	 * @return map with all information
	 */
	public TSMapLH getRegisteredPDOs(String group, String key){
		return this.dbpdos.get_registered_pdos(group, key);
	}

	/**
	 * Generate an SQL query on a given PDO object.
	 * 
	 * @param pdo the PDO object to be used for the query
	 * @param select the SQL select string
	 * @param table an array of tables to be used for the query
	 * @param where the SQL where string
	 * @param order the SQL order string
	 * @return resulting ResultSet
	 */
	public ResultSet sql_query(TSPDO pdo, String select, String table, String where, String order){
		return this.dbpdos.sql_query(pdo, select, table, where, order);
	}

	public TSPDO pdoSelect(String table){
		return this.dbpdos.pdo_select(table);
	}
}