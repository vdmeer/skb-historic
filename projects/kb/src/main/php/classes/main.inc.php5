<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2002-2011, Sven van der Meer <sven@vandermeer.de>
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
 * The main SKB include file, initialising the core SKB components.
 *
 * @package    SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2002-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
error_reporting(E_ALL | E_STRICT);
define('SKB_LOAD_PACKAGE_NOTICE', false);

//error_reporting(0);
ini_set('display_errors', TRUE);
date_default_timezone_set('UTC');

//we determine the document root the following way:
//1. set $root_classes '/classes/'
//2. set $root_skb to 'skb'
//3. get the array of included files
//4. get the last entry in the resulting array, which is the absolute path to main.inc
//5. change all '\' to '/' and then set $root_document to everything upto the first occurance of 'skb'
//in other words: we expect the SKB being in a folder SKB and the classes being in that very folder (not a sub-folder)
//steps 3-5 are below the 'dont change line'

//class root, relative from skb root
$root_classes="/classes/";
//skb root, relative from the document root
$root_skb="/skb";


//===
//=== change nothing beyond that line, unless you know exactly what you are doing ;) ===
//===

//root of SKB and ALL related folders
$gif=get_included_files();
$root_document=str_replace("\\","/",array_pop($gif));
$root_document=substr($root_document,0,strpos($root_document,$root_skb.$root_classes."main.inc.php5"));

if(!isset($site_id)){
  trigger_error("No site_id set", E_USER_ERROR);
}
if(!isset($site_path)){
  trigger_error("No site_path set", E_USER_ERROR);
}

$skb_loaded=false;

$__cfg_array=array(
  "root-document" => $root_document,
  "root-skb"      => $root_skb,
  "root-classes"  => $root_classes,
  "config-core"   => $root_document.$root_skb."/config/core.db",
  "config-site"   => $root_document.$root_skb."/config/".$site_id.".db",
  "site_path"     => $site_path,
  "skb_site_id"   => $site_id,
  "php_extension" => ".php5",
);


if(!file_exists($__cfg_array['config-site'])){
  trigger_error("Unknown site configuration\n --> did not find ".$__cfg_array['config-site'], E_USER_ERROR);
}

require_once($__cfg_array["root-document"].$__cfg_array["root-skb"].$__cfg_array["root-classes"]."SKB/Autoloader.class".$__cfg_array["php_extension"]);
function __autoload($class){SKB_Autoloader::autoload($class);}

//$__cfg_request->init_http(array("lang" => array("core:val_unset" => $skb_lang)));

$skb_main=SKB_Main::get_instance();
$skb_main->load_core_packages();
$skb_loaded=true;
$url_add=$skb_main->configuration->get_group("html","url-add");
$skb_main->configuration->add("request", array());
if(count($url_add)>0){
  //$url_req=$__cfg_request->get_requests();
  $url_req=(array("lang" => $skb_main->configuration->get_group("system", "lang")));
	$_keys=array_keys($url_req);
	$_size=count($_keys);
	for($i=0;$i<$_size;$i++){
		if(in_array($_keys[$i],$url_add))
		  $skb_main->configuration->set_2_array("request", $_keys[$i], $url_req[$_keys[$i]]);
	}
}

//if $_SERVER["REQUEST_URI"] is not set, we are in CMD mode
if($skb_main->configuration->get_group("menu","load")=="true"&&isset($_SERVER["REQUEST_URI"])){
  //we no longer load the menu automatically, but provide for global access via these ids
  $skb_menu_request=null;
  $skb_menu_reader=null;
}

$__htmlStd="";
if($skb_main->configuration->get_group("html4","load")=="true"){
  if($skb_main->configuration->get_group("html4","server-active")=="true"){
    $__htmlStd=$skb_main->configuration->get_group("html4","server-active");
    $$__htmlStd=new Html4_Standard($skb_main->configuration->get_group("html4","dtd"));
  }
}
$http_request=SKB_Http::get_instance();
?>