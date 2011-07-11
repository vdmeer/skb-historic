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
 * @package    Site.Demo.Skbconfig
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.htmlpage");

  $mySKB=SKB_Main::get_instance();

  $templates=new SKB_BuilderTemplates();
  $templates->add_template("entry", "Dist.Menu.Entries2XHTML-Menu:Template:DD-Entry");
  $templates->set_header();

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
?>
  <h3>Check CORE SKB Configuration</h3>

  <hr />
  <p>This page shows the package Core.SkbInfo, which can be used to monitor the configueration of the SKB and all loadable packages. The list below
     contains all maintained information, and each entry links to a page providing a table with that information. All sub-pages use the CURL API
     to do a subsequent HTTP request to the PHP file rest/info.php5 to collect the information. Have a look into the source code for details.
  </p>
  <hr /><br />

  <ul>
    <li><?php echo get_item("/02/01") ?></li>
    <li><?php echo get_item("/02/02") ?></li>
    <li><?php echo get_item("/02/03") ?></li>
    <li><?php echo get_item("/02/04") ?></li>
    <li><?php echo get_item("/02/05") ?></li>
    <li><?php echo get_item("/02/06") ?></li>
    <li><?php echo get_item("/02/07") ?></li>
    <li><?php echo get_item("/02/08") ?></li>
    <li><?php echo get_item("/02/09") ?></li>
    <li><?php echo get_item("/02/10") ?></li>
    <li><?php echo get_item("/02/11") ?></li>
    <li><?php echo get_item("/02/12") ?></li>
  </ul>
<?php
  $request->set_value("htmlpage:execute_todo", "bodyend");
  $page->execute($request);

function get_item($key){
	global $skb_menu_reader, $templates;
	$ar=explode("/",$key);
	array_shift($ar);
	$ret=$skb_menu_reader->get_item($ar);
  $tpl=$templates->get_template_object("entry");
  $tpl->set("entries", $ret);
  return $tpl->to_string()." = ".$ret['menu:text_sitemap'];
}
?>
