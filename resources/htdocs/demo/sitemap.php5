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
 * @package    Site.Demo.Sitemap
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.htmlpage");

$my_menu_builder=$skb_main->get_builder("Dist.Menu.Entries2XHTML-Menu-Sitemap");
$my_menu_builder->set_header();

$request=$skb_main->get_request("Dist.HtmlPage");
$request->init_http();
$request->activate();
$page=$skb_main->get_reader("Dist.HtmlPage.DB2Entries");
$page->set_builder($skb_main->get_builder("Demo.HtmlPage.Entries2XHTML-Page"));
$page->prepare($request);

$request->set_value("htmlpage:execute_todo", "head");
$page->execute($request);

$request->set_value("htmlpage:execute_todo", "bodystart");
$page->execute($request);

echo "<h3>Sitemap</h3>\n";

?>
  <hr />
  <p>This page shows the autmatically generated sitemap, using the package Dist.Menu. All information for the sitemap should be 
     provided by the menu database (and gettext translations, if used).
  </p>
  <hr /><br />
<?php

$skb_menu_request->set_value("menu:levels", "1-6");
$skb_menu_reader->set_builder($my_menu_builder);
$skb_menu_reader->execute($skb_menu_request);

$request->set_value("htmlpage:execute_todo", "bodyend");
$page->execute($request);
?>