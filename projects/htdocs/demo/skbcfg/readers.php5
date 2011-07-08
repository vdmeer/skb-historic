<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2010-2011, Sven van der Meer <sven@vandermeer.de>
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
 * Demo PHP file showing some capabilities of the PHP-SKB
 *
 * @package    Site.Demo.SkbConfig
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "../_sbin/site_id.php5";
require_once "../../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.htmlpage");
$skb_main->require_package("core.skbinfo");

$url="http://".$_SERVER["HTTP_HOST"].$skb_main->configuration->get_group("path","site")."/rest/info.php5?defh_rentry=readers&lang={$skb_main->configuration->get_group("system", "lang")}";
$ct=$http_request->request_test_accept_type();

$headers=array();
$headers[] = "Accept: {$ct}";
$headers[] = "Connection: Keep-Alive";
$headers[] = "Connection: close";
$headers[] = "Content-type: application/x-www-form-urlencoded;charset=UTF-8";
$user_agent = 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 1.0.3705; .NET CLR 1.1.4322; Media Center PC 4.0)'; 

$process=curl_init($url);
curl_setopt($process, CURLOPT_HTTPHEADER, $headers);
curl_setopt($process, CURLOPT_HEADER, 0);
curl_setopt($process, CURLOPT_USERAGENT, $user_agent);
curl_setopt($process, CURLOPT_TIMEOUT, 30);
curl_setopt($process, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($process, CURLOPT_FOLLOWLOCATION, 1);
$curl_return = curl_exec($process);
curl_close($process);

header('Content-type: '.$ct);

function info_html(){
  $mySKB=SKB_Main::get_instance();

  $mySKB->configuration->add_2_comma("header","std-css","core/skbinfo/div-skbinfo");

  $request=$mySKB->get_request("Dist.HtmlPage");
  $request->init_http();
  $request->activate();
  $page=$mySKB->get_reader("Dist.HtmlPage.DB2Entries");
  $page->set_builder($mySKB->get_builder("Demo.HtmlPage.Entries2XHTML-Page"));
  $page->prepare($request);

  $request->set_value("htmlpage:execute_todo", "head");
  $page->execute($request);
   
  $request->set_value("htmlpage:execute_todo", "bodystart");
  $page->execute($request);

  ?><h3>CORE Configuration => Readers</h3><?php

	global $curl_return;
  echo $curl_return;

  $request->set_value("htmlpage:execute_todo", "bodyend");
  $page->execute($request);
}
$http_request->register_callback(array("GET"), array("*/*","text/html","application/xhtml+xml"), "info_html");


function info_entries(){
	global $curl_return;
  echo $curl_return;
}
$http_request->register_callback(array("GET"), "x-skb/entries", "info_entries");

$http_request->response_do();
?>
