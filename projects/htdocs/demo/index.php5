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
 * @package    Site.Demo.Index
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.htmlpage");

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

$h3=Html4_Element::factory("h3", "","SKB - Demo Server");
$h3->print_html();
?>
  <hr />
  <p>This is a small webiste, demonstrating some of the features of the SKB and a link to the API documentation.
     Next to the home button in the menu of this page you find the links to these packages. The first link (CORE SKBCONFIG) demonstrates how 
     the package Core.CkbInfo can be used to monitor the configuration information and information about all loadable packages. It also shows how 
     to combine the CURL API with the SKB REST support. The next link (DIST) demonstrate some of the features of the SKB distribution packages, namely 
     acronyms, Date, Geo, Affiliations, People and Publications. The third link is dedicated to the package Dist.Gallery. It provides access to a small
     example of a foto gallery, with some automatic features and a searh form. The fourth link (API DOC) opens the generated documentation for the 
     SKB classes and packages (it actually leaves this server and shows the documentation only). The last and final link shows the automatically
     generated sitemap of this server.
  </p>
  <p>Please note that linknames can change depending on the language you have selected. Some of the pages provide links to do that, but you can also
     manually add a paramter to the links: ?lang=de for German or ?lang=en for English or ?lang=fr for French. Not all pages are translated,
     and not all parts of the SKB are translated either.
  </p>
  <hr /><br />
<?php

$request->set_value("htmlpage:execute_todo", "bodyend");
$page->execute($request);
?>
