<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2009-2011, Sven van der Meer <sven@vandermeer.de>
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
 */

/**
 * This is the main object for the SKB. Handles all initialisation and provides DB access.
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class SKB_Main{
  /**
   * The SKB configuration.
   * @var Util_ArType
   */
  public $configuration=null;


  /**
   * Pointer to the singleton instance of the SKB
   * @var object
   */
  private static $instance=null;

  /**
   * String internally being used  for initial construction.
   * @var string
   */
  private static $cKey="beef";


  /**
   * Currently set language
   * @var string
   */
  private $lang;

  /**
   * The ID of the current site
   * @var string
   */
  private  static $site_id;



  /**
   * Registered fields
   * @var array
   */
  private $registered_fields=array();
  /**
   * Registered requests
   * @var array
   */
  private $registered_requests=array();
  /**
   * Registered readers
   * @var array
   */
  private $registered_readers=array();
  /**
   * Registered builders
   * @var array
   */
  private $registered_builders=array();
  /**
   * Registered templates
   * @var array
   */
  private $registered_templates=array();
  /**
   * Registered interpreters
   * @var array
   */
  private $registered_interpreters=array();
  /**
   * Registered applications
   * @var array
   */
  private $registered_applications=array();
  /**
   * Registered packages
   * @var array
   */
  private $registered_packages=array();


  /**
   * Object maintaining list of all connected PDOs and handling SQL requests
   * @var SKB_DBPDOs
   */
  private $dbpdos;

  /**
   * Object implementing a stack for detecing loops while interpreting data
   * @var SKB_DBScope
   */
  private $db_scope;


  /**
   * Return the instance of SKB_Main (Singleton).
   */
  public static function get_instance(){
    if(self::$instance===null)
      self::$instance=new SKB_Main(self::$cKey);
    return self::$instance;
  }


  /**
   * Cloning is not allowed, since SKB_Main is a Singleton.
   */
  public function __clone(){
    trigger_error('SKB_Main: Clone is not allowed.', E_USER_ERROR);
  }


  /**
   * The class constructor, which cannot be called directly since SKB_Main is a singleton.
   */
  private function __construct($_c){
    if($_c!=self::$cKey)
      trigger_error('SKB_Main: Direct creation of object is not allowed, please use get_instance().', E_USER_ERROR);
    else{
      global $__cfg_array;
      mb_internal_encoding("UTF-8");

      if(!isset($__cfg_array["skb_site_id"]))
        trigger_error("SKB_Main: invalid configuration", E_USER_ERROR);
      else{
        $this->dbpdos=new SKB_DBPDOs();
        $this->db_scope=SKB_DBScope::get_instance();

        //load the skb configuration
        $o=new Util_PDOConnect($__cfg_array["config-core"]);
        $sth=$o->pdo->prepare("SELECT * FROM skb_cfg");
        if($sth->execute()){
          while($row=$sth->fetch(PDO::FETCH_ASSOC)){
            if(!isset($this->configuration[$row['collection']]))
              $this->configuration[$row['collection']]=array();
            if($row['field_explodes']==true)
              $this->configuration[$row['collection']][$row['part']]=Util_Interpreter::interpret("array:explode", $row['value']);
            else
              $this->configuration[$row['collection']][$row['part']]=$row['value'];
          }
          $this->configuration['skb']['site-id']=$__cfg_array["skb_site_id"];
          self::$site_id=$this->configuration['skb']['site-id'];
          $this->dbpdos->pdo_add("core:cfg",$__cfg_array["config-core"],array("skb_cfg"),$o->pdo,"core:cfg");
        }

        //load the site specific configuration
        $o=new Util_PDOConnect($__cfg_array["config-site"]);
        $sth=$o->pdo->prepare("SELECT * FROM configuration");
        if($sth->execute()){
          while($row=$sth->fetch(PDO::FETCH_ASSOC)){
            if(!isset($this->configuration[$row['collection']]))
              $this->configuration[$row['collection']]=array();
            if($row['field_explodes']==true)
              $this->configuration[$row['collection']][$row['part']]=Util_Interpreter::interpret("array:explode", $row['value']);
            else
              $this->configuration[$row['collection']][$row['part']]=$row['value'];
          }

          $this->configuration["skb"]["root-document"] = $__cfg_array["root-document"];
          $this->configuration["skb"]["root-skb"]      = $__cfg_array["root-skb"];
          $this->configuration["skb"]["root-classes"]  = $__cfg_array["root-classes"];
          $this->configuration["path"]["skb"]          = $__cfg_array["root-document"].$__cfg_array["root-skb"];

					$this->configuration["skb"]["target"]        = "php";

          $this->configuration["server"]["root-fs"]=$__cfg_array["root-document"];

          if(isset($_SERVER["REMOTE_ADDR"])&&strcmp($_SERVER["REMOTE_ADDR"], "127.0.0.1")!=0){
            $this->configuration["server"]["access-remote"]=true;
          }
          else
            $this->configuration["server"]["access-remote"]=false;

          $this->configuration["server"]["root-http"]   = $this->configuration["skb"]["root-skb"];

          $this->configuration["path"]["classes"]       = $this->configuration["path"]["skb"].$__cfg_array["root-classes"];
          $this->configuration["path"]["site"]          = $__cfg_array["site_path"];
          $this->configuration["path"]["database"]      = $this->configuration["path"]["skb"] . $this->configuration["path"]["database"];
          $this->configuration["path"]["config"]        = $this->configuration["path"]["skb"] . $this->configuration["path"]["config"];
          $this->configuration["path"]["repository"]    = $this->configuration["path"]["skb"] . $this->configuration["path"]["repository"];
          $this->configuration["path"]["locale"]        = $this->configuration["path"]["skb"] . $this->configuration["path"]["locale"];

          $this->configuration["path"]["targets"]       = $this->configuration["path"]["skb"] . $this->configuration["path"]["targets"];

          $this->configuration["path"]["images"]        = $this->configuration["server"]["root-http"] . $this->configuration["path"]["images"];
          $this->configuration["path"]["css"]           = $this->configuration["server"]["root-http"] . $this->configuration["path"]["css"];
          $this->configuration["path"]["javascript"]    = $this->configuration["server"]["root-http"] . $this->configuration["path"]["javascript"];

          $this->configuration["path"]["library-abs"]   = $this->configuration["path"]["skb"] . $this->configuration["path"]["library"];
          $this->configuration["path"]["library-rel"]   = $this->configuration["server"]["root-http"] . $this->configuration["path"]["library"];
          unset($this->configuration["path"]["library"]);

          $this->configuration["path"]["gallery-abs"]   = $this->configuration["path"]["skb"] . $this->configuration["path"]["gallery"];
          $this->configuration["path"]["gallery-rel"]   = $this->configuration["server"]["root-http"] . $this->configuration["path"]["gallery"];
          unset($this->configuration["path"]["gallery"]);

          $this->configuration["path"]["figures-abs"]   = $this->configuration["path"]["skb"] . $this->configuration["path"]["figures"];
          $this->configuration["path"]["figures-rel"]   = $this->configuration["server"]["root-http"] . $this->configuration["path"]["figures"];
          unset($this->configuration["path"]["figures"]);

          $this->configuration["php"]["file"]           = $_SERVER["PHP_SELF"];
          $this->configuration["php"]["filename"]       = strtok(basename($_SERVER["PHP_SELF"]),".");

          if(isset($this->configuration["path"]["figures-local"])){
            $this->configuration["path"]["figures-local-abs"]   = $_SERVER["DOCUMENT_ROOT"] . $this->configuration["path"]["site"] . $this->configuration["path"]["figures-local"] . "/";
            $this->configuration["path"]["figures-local-rel"]   = $this->configuration["path"]["site"]. $this->configuration["path"]["figures-local"] . "/";
            unset($this->configuration["path"]["figures-local"]);
          }
          $this->dbpdos->pdo_add("site:cfg",$__cfg_array["config-site"],array("skb_cfg"),$o->pdo,"site:cfg");
        }

        $this->configuration=new Util_ArType($this->configuration);

        // set locale
        if(isset($_REQUEST['lang'])){
          $dir=$this->configuration->get_group("path", "locale")."mo";
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
    }
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
  public function load_core_packages(){
    $this->require_package("core");
    $this->require_package("core.encoding");
    $this->require_package("core.request");
    $this->require_package("core.default");
    $this->require_package("core.mime");
    $this->require_package("core.http");

    $myHttp=SKB_Http::get_instance();
    $myHttp->response_send_header("X-SKB", "v1.0");
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
   *
   * @param string package the packages name, i.e. core.skbinfo or mysite.mypackage
   */
  public function require_package($package){
    if(in_array($package,$this->registered_packages)){
      if(SKB_LOAD_PACKAGE_NOTICE===true)
        trigger_error("SKB_Main: package already loaded: $package", E_USER_NOTICE);
      return;
    }

    $pkg_dir=$this->configuration->get_group("path", "repository");
    $pkg_dir=$pkg_dir.str_replace(".","/",$package);

    $pkg_file_db=$pkg_dir."/".$package.".db";
    $pkg_file_php=$pkg_dir."/".$package.".".$this->configuration->get_group("php", "extension");
    $pkg_file_json=$pkg_dir."/".$package.".json";

    if(!file_exists($pkg_dir))
      trigger_error('SKB_Main: package not found or not correctly installed: '.$package.' in '.$pkg_dir, E_USER_ERROR);

    if(file_exists($pkg_file_db)){
      $o=new Util_PDOConnect($pkg_file_db);
      $tables=array();

      //package fields
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_fields")){
        $tables[]=$package.":pkg_fields";

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_fields');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          if(SKB_LOAD_PACKAGE_NOTICE===true){
            if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_fields))
              trigger_error("SKB_Main: redefinitions of field: {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
          }
          $this->registered_fields[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $this->registered_fields[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //package requests
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_requests")){
        $tables[]=$package.":pkg_requests";

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_requests');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          if(SKB_LOAD_PACKAGE_NOTICE===true){
            if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_requests))
              trigger_error("SKB_Main: redefinitions of registered request: {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
          }
          $this->registered_requests[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $this->registered_requests[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //package rabit
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_rabit")){
        $tables[]=$package.":pkg_rabit";

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_rabit');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          if(isset($ar[$_keys[$i]]['core:rabit:type'])){
            switch($ar[$_keys[$i]]['core:rabit:type']){
              case "reader":
                                         if(SKB_LOAD_PACKAGE_NOTICE===true){
                                           if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_readers))
                                             trigger_error("SKB_Main: redefinitions of registered rabit (reader): {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
                                         }
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:class']))
                                           $ar[$_keys[$i]]['core:rabit:target:class']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:class']);
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:template']))
                                           $ar[$_keys[$i]]['core:rabit:target:template']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:template']);
                                         $this->registered_readers[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
                                         $this->registered_readers[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
                                         break;
              case "builder":
                                         if(SKB_LOAD_PACKAGE_NOTICE===true){
                                           if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_builders))
                                             trigger_error("SKB_Main: redefinitions of registered rabit (builder): {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
                                         }
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:class']))
                                           $ar[$_keys[$i]]['core:rabit:target:class']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:class']);
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:template']))
                                           $ar[$_keys[$i]]['core:rabit:target:template']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:template']);
                                         $this->registered_builders[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
                                         $this->registered_builders[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
                                         break;
              case "interpreter:core":
              case "interpreter:value":
              case "interpreter:entries":
              case "interpreter:entity":
                                         if(SKB_LOAD_PACKAGE_NOTICE===true){
                                           if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_interpreters))
                                             trigger_error("SKB_Main: redefinitions of registered rabit (interpreter): {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
                                         }
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:class']))
                                           $ar[$_keys[$i]]['core:rabit:target:class']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:class']);
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:template']))
                                           $ar[$_keys[$i]]['core:rabit:target:template']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:template']);
                                         $this->registered_interpreters[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
                                         $this->registered_interpreters[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
                                         break;
              case "template":
                                         if(SKB_LOAD_PACKAGE_NOTICE===true){
                                           if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_templates))
                                             trigger_error("SKB_Main: redefinitions of registered rabit (template): {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
                                         }
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:class']))
                                           $ar[$_keys[$i]]['core:rabit:target:class']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:class']);
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:template']))
                                           $ar[$_keys[$i]]['core:rabit:target:template']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:template']);
                                         $this->registered_templates[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
                                         $this->registered_templates[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
                                         break;
              case "application":
                                         if(SKB_LOAD_PACKAGE_NOTICE===true){
                                           if(array_key_exists($ar[$_keys[$i]]['key'], $this->registered_applications))
                                             trigger_error("SKB_Main: redefinitions of registered rabit (application): {$ar[$_keys[$i]]['key']} by $package", E_USER_NOTICE);
                                         }
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:class']))
                                           $ar[$_keys[$i]]['core:rabit:target:class']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:class']);
                                         if(isset($ar[$_keys[$i]]['core:rabit:target:template']))
                                           $ar[$_keys[$i]]['core:rabit:target:template']=Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['core:rabit:target:template']);
                                         $this->registered_applications[$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
                                         $this->registered_applications[$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
                                         break;
              default: break;
            }
          }
        }
      }

      $http_ar=array();

      //http_status_codes
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_http_status_codes")){
        $tables[]=$package.":pkg_http_status_codes";
        $http_ar['http_status_codes']=array();

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_http_status_codes');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          $http_ar['http_status_codes'][$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $http_ar['http_status_codes'][$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //http_headers_request
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_http_headers_request")){
        $tables[]=$package.":pkg_http_headers_request";
        $http_ar['http_headers_request']=array();

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_http_headers_request');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          $http_ar['http_headers_request'][$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $http_ar['http_headers_request'][$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //http_headers_response
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_http_headers_response")){
        $tables[]=$package.":pkg_http_headers_response";
        $http_ar['http_headers_response']=array();

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_http_headers_response');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          $http_ar['http_headers_response'][$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $http_ar['http_headers_response'][$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //http_request_methods
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_http_request_methods")){
        $tables[]=$package.":pkg_http_request_methods";
        $http_ar['http_request_methods']=array();

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_http_request_methods');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          $http_ar['http_request_methods'][$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $http_ar['http_request_methods'][$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      //mime_content_types
      if($this->dbpdos->pdo_table_exists($o->pdo,"pkg_mime_content_types")){
        $tables[]=$package.":pkg_mime_content_types";
        $http_ar['mime_content_types']=array();

        $pdos=$this->dbpdos->sql_query($o->pdo,"*",'pkg_mime_content_types');
        $ar=Util_Interpreter::interpret("array:clean", $pdos->fetchAll(PDO::FETCH_ASSOC));
        $_keys=array_keys($ar);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          $http_ar['mime_content_types'][$ar[$_keys[$i]]['key']]=$ar[$_keys[$i]];
          $http_ar['mime_content_types'][$ar[$_keys[$i]]['key']]['origin']="pkg:".$package;
        }
      }

      if(count($http_ar)>0){
        $myHttp=SKB_Http::get_instance();
        $myHttp->set_data($http_ar);
      }

      //register pdo
      $this->dbpdos->pdo_add("reg:".$package,$pkg_file_db,$tables,$o->pdo,"reg:".$package);
    }

    if(file_exists($pkg_file_json)){
      $this->load_from_json($pkg_file_json, $package);
      if(SKB_LOAD_PACKAGE_NOTICE===true)
        trigger_error("SKB_Main: package PHP loaded: $package", E_USER_NOTICE);
    }
    if(file_exists($pkg_file_php)){
      require_once($pkg_file_php);
      if(SKB_LOAD_PACKAGE_NOTICE===true)
        trigger_error("SKB_Main: package PHP loaded: $package", E_USER_NOTICE);
    }

    $this->registered_packages[]=$package;

    if(SKB_LOAD_PACKAGE_NOTICE===true)
      trigger_error("SKB_Main: package loaded and registered: $package", E_USER_NOTICE);
  }

  /**
   * Read a JSON file and execute the required functions (i.e. load_database, bind text domain).
   *
   * @param sting json_fn the complete path and file name for the JSON file
   */
  public function load_from_json($json_fn, $package){
  	if(file_exists($json_fn)){
  		$js=file($json_fn);

  		foreach($js as $ln=>$line){
  			if(strlen($line)==0)
  			  unset($js[$ln]);
  			elseif(strlen($line)>0&&$line[0]=='#')
  			  unset($js[$ln]);
  		}
  		$ar=json_decode(implode($js), true);

      if(isset($ar['require_package'])){
      	foreach($ar['require_package'] as $pkg){
      		if(strlen($pkg)>0)
      		  $this->require_package($pkg);
      	}
      }
      if(isset($ar['load_database'])){
      	foreach($ar['load_database'] as $ln=>$db){
      		if(isset($db['fn'])&&isset($db['tables']))
      		  $this->load_database($db['fn'], $db['tables'], $package);
      	}
      }
      if(isset($ar['text_domain'])){
      	foreach($ar['text_domain'] as $ln=>$td){
      		if(isset($td['domain'])&&isset($td['path']))
      		  bindtextdomain($td['domain'], $this->configuration->get_group("path", "locale").$td['path']);
      	  if(isset($td['codeset']))
      	    bind_textdomain_codeset($td['domain'],$td['codeset']);
      	}
      }
  	}
  }

  /**
   * Loads all available packages for the current site.
   * 
   * This function loads all available (installed) packages for the current site ($site_id).
   * This can be practical when loading individual packages is inconvenient. It is used for 
   * viewing configuration by the Core.SkbConfig package.
   *
   * @param array additional array of additional packages, using '/' as separator (not the usual '.')
   */
  public function load_all_site_packages($additional=array()){
    $pkg_dir=$this->configuration->get_group("path", "repository");
    $site_id=$this->configuration->get_group("skb", "site-id");
    $pkg_ar=$this->walk_package_dir($this->configuration->get_group("path", "repository"));
    foreach($pkg_ar as $pkg){
      if(strpos($pkg,"/core")!==false||strpos($pkg,"/dist")!==false||strpos($pkg,"/".$site_id)!==false||in_array(str_replace($pkg_dir,"",$pkg),$additional)){
        $pkg_name=str_replace("/",".",str_replace($pkg_dir,"",$pkg));
        $this->require_package($pkg_name);
      }
    }
  }

  /** @ignore */
  private function walk_package_dir($pwd){
    $ret=array();
    if(false!=($ar=@scandir($pwd))){
      foreach($ar as &$file){
        if($file!="."&&$file!=".."&&@scandir($pwd.$file)!=false){
          $ret[]=$pwd.$file;
          $ret=array_merge($ret, $this->walk_package_dir($pwd.$file."/"));
        }
      }
    }
    return $ret;
  }

  /**
   * Register a Database (from database/) in the PDO repository.
   * 
   * This function creates a PDO object for the given database and registered the tables in the PDO
   * repository. One can provide a package name or a simple name, the difference being that using a package name 
   * the registration will prefix it with "pkg:".
   *
   * @param string fn the filename of the database, assuming it is on the directory database/
   * @param array tables the tables to be registered, can be array or comma-separated list as string 
   * @param string package name as package for the PDO repository or null if simple name is used
   * @param string name simple name for the PDO repository
   */
  public function load_database($fn, $tables, $package, $name=null){
    $key="";
    if($name!=null)
      $key=$name;
    else
      $key="pkg:".$package;

    if(!is_array($tables))
      $tables=Util_Interpreter::interpret("array:explode", $tables);

    $db_file=$this->configuration->get_group("path", "database").$fn.".db";
    $o=new Util_PDOConnect($db_file);

    $_keys=array_keys($tables);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      if($this->dbpdos->pdo_table_exists($o->pdo,$tables[$_keys[$i]])==false)
      trigger_error('SKB_Main: Database Table not found: '.$tables[$_keys[$i]].' in '.$db_file, E_USER_ERROR);
    }
    $this->dbpdos->pdo_add($key,$db_file,$tables,$o->pdo,$key);
  }

  /**
   * Return the current configuration array.
   */
  public function get_configuration(){
    return $this->configuration->get();
  }

  /**
   * Return the specified registration field or a complete group of fields.
   * 
   * @param string group name of the requested group
   * @param string key name of the requested key; if null then the group is returned
   */
  public function get_configuration_by_key($group, $key=null){
    return $this->configuration->get_group($group, $key);
  }

  /**
   * Return all currently registered fields.
   */
  public function get_registered__fields(){
    return $this->registered_fields;
  }

  /**
   * Return the specified field.
   * 
   * @param string key name of the field
   */
  public function get_registered__fields_by_key($key){
    if(array_key_exists($key, $this->registered_fields))
      return $this->registered_fields[$key];
    return -1;
  }

  /**
   * Return all currently registered requests.
   */
  public function get_registered_requests(){
    return $this->registered_requests;
  }

  /**
   * Return the specified request.
   * 
   * @param string key name of the request
   */
  public function get_registered_requests_by_key($key){
    if(array_key_exists($key, $this->registered_requests))
      return $this->registered_requests[$key];
    return -1;
  }

  /**
   * Return all currently registered readers.
   */
  public function get_registered_readers(){
    return $this->registered_readers;
  }

  /**
   * Return the specified reader.
   * 
   * @param string key name of the reader
   */
  public function get_registered_readers_by_key($key){
    if(array_key_exists($key, $this->registered_readers))
      return $this->registered_readers[$key];
    return -1;
  }

  /**
   * Return all currently registered builders.
   */
  public function get_registered_builders(){
    return $this->registered_builders;
  }

  /**
   * Return the specified builder.
   * 
   * @param string key name of the builder
   */
  public function get_registered_builders_by_key($key){
    if(array_key_exists($key, $this->registered_builders))
      return $this->registered_builders[$key];
    return -1;
  }

  /**
   * Return all currently registered templates.
   */
  public function get_registered_templates(){
    return $this->registered_templates;
  }

  /**
   * Return the specified template.
   * 
   * @param string key name of the template
   */
  public function get_registered_templates_by_key($key){
    if(array_key_exists($key, $this->registered_templates))
      return $this->registered_templates[$key];
    return -1;
  }

  /**
   * Return all currently registered interpreters.
   */
  public function get_registered_interpreters(){
    return $this->registered_interpreters;
  }

  /**
   * Return the specified interpreter.
   * 
   * @param string key name of the interpreter
   */
  public function get_registered_interpreters_by_key($key){
    if(array_key_exists($key, $this->registered_interpreters))
      return $this->registered_interpreters[$key];
    return -1;
  }

  /**
   * Return all currently registered applications.
   */
  public function get_registered_applications(){return $this->registered_applications;}

  /**
   * Return the specified application.
   * 
   * @param string key name of the application
   */
  public function get_registered_applications_by_key($key){
    if(array_key_exists($key, $this->registered_applications))
      return $this->registered_applications[$key];
    return -1;
  }


  /**
   * Return a Request object for the given key.
   * 
   * @param string key name of the requested request
   */
  public function get_request($type=null){
    if($type==null)
      $type="Core.Default";
    if(array_key_exists($type, $this->registered_requests))
      return new SKB_Request($this->registered_requests[$type]['key']);
    else
      trigger_error("SKB_Main: request not found: {$type}", E_USER_ERROR);
  }

  /**
   * Return a Reader object for the given key.
   * 
   * @param string key name of the requested reader
   */
  public function get_reader($type){
  	$target=$this->configuration->get_group("skb", "target");
    if(array_key_exists($type, $this->registered_readers))
      return new $this->registered_readers[$type]['core:rabit:target:class'][$target];
    else
      trigger_error("SKB_Main: reader not found: {$type} for target {$target}", E_USER_ERROR);
  }

  /**
   * Return a Builder object for the given key.
   * 
   * @param string key name of the requested builder
   */
  public function get_builder($type){
  	$target=$this->configuration->get_group("skb", "target");
    if(array_key_exists($type, $this->registered_builders))
      return new $this->registered_builders[$type]['core:rabit:target:class'][$target];
    else
      trigger_error("SKB_Main: builder not found: {$type} for target {$target}", E_USER_ERROR);
  }

  /**
   * Return a Interpreter object for the given key.
   * 
   * @param string key name of the requested interpreter
   */
  public function get_interpreter($type){
  	$target=$this->configuration->get_group("skb", "target");
    if(array_key_exists($type, $this->registered_interpreter))
      return new $this->registered_interpreter[$type]['core:rabit:target:class'][$target];
    else
      trigger_error("SKB_Main: interpreter not found: {$type} for target {$target}", E_USER_ERROR);
  }

  /**
   * Interpret data using registered interpreters.
   * 
   * This function supports all types of registered interpreters (core, entity, value and entries).
   * Each of them requires a slightly different set of parameters.
   *
   * @param string id identifier for the interpreter
   * @param val value to be interpreted
   * @param table database table to be used during interpretation
   * @param SKB_Request request object for parametrisation
   */
  public function interpret_data($id, $val=null, $table=null, SKB_Request $request=null){
  	$target=$this->configuration->get_group("skb", "target");
    if(array_key_exists($id, $this->registered_interpreters)){
      $class=$this->registered_interpreters[$id]['core:rabit:target:class'][$target];
      switch($this->registered_interpreters[$id]['core:rabit:type']){
        case "interpreter:core":    $c=new $class; return $c->interpret($val, $request);
        case "interpreter:entity":  $c=new $class; return $c->interpret($val, $table);
        case "interpreter:value":   $c=new $class; return $c->interpret($val);
        case "interpreter:entries": $c=new $class; return $c->interpret($val, $table);
      }
      return;
    }
    trigger_error("SKB_Main: interpreter not found: {$id} for target {$target}", E_USER_ERROR);
  }

  /**
   * Return a Application object for the given key.
   * 
   * @param string key name of the requested application
   */
  public function get_application($type){
  	$target=$this->configuration->get_group("skb", "target");
    if(array_key_exists($type, $this->registered_applications))
      return new $this->registered_applications[$type]['core:rabit:target:class'][$target];
    else
      trigger_error("SKB_Main: application not found: {$type} for target {$target}", E_USER_ERROR);
  }

  /**
   * Start interpreting a data array created by a Reader.
   * 
   * @param Util_ArBase entries the data array to be interpreted
   * @param string table database table to be used as starting point for interpretation  
   */
  public function interpret(Util_ArBase $entries, $table){
    $this->db_scope->reset();
    if(isset($entries->ar['key']))
      $this->db_scope->push($table,$entries->ar['key']);
    return $this->interpret_next($entries);
  }

  /**
   * Loop for interpreting a data array created by a Reader.
   * 
   * @param Util_ArBase entries the data array to be interpreted
   */
  public function interpret_next(Util_ArBase $entries){
    $table=null;
    $test_ar=Util_Interpreter::interpret("array:clean", $entries->ar);
    if(count($test_ar)==0) // empty array, nothing to be done
      return $entries;
    elseif(!is_array($test_ar)) // no array, nothing to be done
      return $entries;
    elseif(count($test_ar)==1){ // array with 1 member, main process initiated
      $key=array_keys($test_ar);
      $key=$key[0];
      $val=array_values($test_ar);
      $val=$val[0];

      // we only process if the key is known and meta data (an entry in the fields table) for it exist
      if(array_key_exists($key, $this->registered_fields)){
        $testAr=$this->registered_fields[$key];

        // check for entity or value, if neither of them do not process entry
        if($testAr['core:type']=="entity"){
          // we have an entity, so test for links to other tables or interpreters to be called
          if($table==null&&isset($testAr['core:default_db']))
            $table=$testAr['core:default_db'];
          if($table!=null&&!isset($testAr['core:interpreter'])){
            if($testAr['core:explode']==true){
              $ar=Util_Interpreter::interpret("array:explode", $val);
              $_Lkeys=array_keys($ar);
              $_Lsize=count($_Lkeys);
              for($l=0;$l<$_Lsize;$l++){
                $entries->ar[$testAr['core:entries_name']][]=$this->interpret_next(new Util_ArBase(array($testAr['core:entries_name']."_key"=>$ar[$_Lkeys[$l]])))->ar[$testAr['core:entries_name']];
              }
              unset($entries->ar[$key]);
            }
            else{
              $entries->ar=array();
              if($this->db_scope->push($table,$val)==true){
                $pdos=$this->sql_query(null, array('*'), array($table), "key = '{$val}'");
                $ret=Util_Interpreter::interpret("array:clean", $pdos->fetch(PDO::FETCH_ASSOC));
                $entries->ar[$testAr['core:entries_name']]=$this->interpret_next(new Util_ArBase($ret))->ar;
                //echo "+++ ";$this->db_scope->print_r();
                $this->db_scope->pop();
              }
              else{
                $entries->ar[$testAr['core:entries_name']]=array();
                //echo "### ";$this->db_scope->print_r();
              }
            }
          }
          else{
            $entries->ar[$testAr['core:entries_name']]=$this->interpret_data($testAr['core:interpreter'], $val)->ar;
            unset($entries->ar[$key]);
          }
        }
        elseif($testAr['core:type']=="value"){
          // we have a value, which can be localised or exploded (create an array from a list)
          // first the locale, identified by ending on "_locale"
          if(substr_compare($key, "_locale", -strlen("_locale"), strlen("_locale"))===0){
            //old test was on test field localised: if($testAr['core:localised']==true){
            $lang=$this->lang;

            //new i18n method, using gettext: domain%%text
            if(strpos($val,"%%")!==false){
              $domain=strtok($val,"%%");
              $text=strtok("%%");
              $entries->ar[$testAr['core:entries_name']]=dgettext($domain, $text);
            }
            //old i18n method: de%Deutsch,en%English
            elseif(strpos($val,"%")!==false){
              $ar=Util_Interpreter::interpret("array:explode", $val);
              $entries->ar=array();
              if(isset($ar[$lang]))
                $entries->ar[$testAr['core:entries_name']]=$ar[$lang];
              elseif(isset($ar[""]))
                $entries->ar[$testAr['core:entries_name']]=$ar[""];
              else
                $entries->ar[$testAr['core:entries_name']]=-1;
            }
            else
              $entries->ar[$testAr['core:entries_name']]=-1;
          }
          elseif($testAr['core:explode']==true){
            $entries->ar=array();
            $entries->ar[$testAr['core:entries_name']]=Util_Interpreter::interpret("array:explode", $val);
          }
        }
      }
    }
    else{ // array with more than one member, loop through the array
      $newAr=array();
      $_keys=array_keys($entries->ar);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
        $reAr=new Util_ArBase(array($_keys[$i]=>$entries->ar[$_keys[$i]]));
        $newAr=array_merge($newAr, $this->interpret_next($reAr)->ar);
      }
      unset($entries->ar);
      $entries->ar=$newAr;
    }
    return $entries;
  }

  /**
   * Reset DB Scope, which is used in the interpreter loop to detect and avoid reference loops in the databases
   */
  public function reset_scope(){$this->db_scope->reset();}

  public function get_field_settings($field){
    if(isset($this->registered_fields[$field]))
      return $this->registered_fields[$field];
    else
      return array();
  }

  /**
   * Return registered PDOs.
   */
  public function get_registered_pdos(){
    return $this->dbpdos->get_registered_pdos();
  }

  /**
   * Return specific PDO.
   * 
   * @param string group of PDOs
   * @param string key specific id within a group
   */
  public function get_registered_pdos_by_key($group, $key=null){
    return $this->dbpdos->get_registered_pdos_by_key($group, $key);
  }

  /**
   * Generate an SQL query on a given PDO object.
   * 
   * @param Util_PDOConnect pdo the PDO object to be used for the query
   * @param string select the SQL select string
   * @param array tables an array of tables to be used for the query
   * @param string where the SQL where string
   * @param string order the SQL order string
   */
  public function sql_query($pdo, $select, $tables, $where=null, $order=null){
    return $this->dbpdos->sql_query($pdo, $select, $tables, $where, $order);
  }
}
?>