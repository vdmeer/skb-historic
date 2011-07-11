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
 * @package    Site.Demo.Rest
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "../_sbin/site_id.php5";
require_once "../../../skb/classes/main.inc.php5";

$skb_main->load_all_site_packages();

$mySKB=SKB_Main::get_instance();

$request=$mySKB->get_request("default:http");
$request->init_http();
$request->activate();
$reader=$mySKB->get_reader("Core.SkbInfo.DB2Entries");

function info_html(){
	global $request, $reader;
  $mySKB=SKB_Main::get_instance();

  $reader->set_builder($mySKB->get_builder("Core.SkbInfo.Entries2XHTML-Table"));
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), array("*/*","text/html","application/xhtml+xml"), "info_html");


function info_entries(){
	global $request, $reader;
  $reader->prepare($request);
  print_r($reader->get_entries()->ar);
}
$http_request->register_callback(array("GET"), "x-skb/entries", "info_entries");

$http_request->response_do();
?>
