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
 * @package    Site.Demo.People
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.site");
$skb_main->require_package("demo.htmlpage");
$skb_main->require_package("dist.people");
$skb_main->require_package("dist.graph");

function people_html(){
	$mySKB=SKB_Main::get_instance();
  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.People.DB2Entries");

  $builder=$mySKB->get_builder("Dist.People.Entries2XHTML-Table");
  $reader->set_builder($builder);
  $reader->prepare($request);

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

  $h3=Html4_Element::factory("h3", "",_("SKB - People"));
  $h3->print_html();
  ?>
    <hr />
    <p>This page shows the People package of the SKB distribution. The people included here are authors of the publications shown on the publication page.
       Each person can have one or more affiliations (which might be current or past).
    </p>
    <hr /><br />
  <?php

  ?>
    <table style="border:0;" cellpadding="10" cellspacing="50">
      <tr style="vertical-align:top;text-align:left;border:0;">
        <td>
          <b>Change language</b>
          <ul>
            <li><b><a href="?lang=en">English</a></b></li>
            <li><b><a href="?lang=fr">French</a></b></li>
            <li><b><a href="?lang=de">German</a></b></li>
          </ul>
        </td>
  
        <td>
  <?php
          $reader->execute($request);
  ?>
        </td>
      </tr>
    </table>
  
  <?php
  $request->set_value("htmlpage:execute_todo", "bodyend");
  $page->execute($request);
}
$http_request->register_callback(array("GET"), array("*/*","text/html","application/xhtml+xml"), "people_html");

function people_graphml(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.People.DB2Entries");
  
  $builder=$mySKB->get_builder("Dist.Graph.Entries2GraphML");
  $reader->set_builder($builder);
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), "text/x-graphml", "people_graphml");


$http_request->response_do();

?>
