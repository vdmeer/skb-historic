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
 * @package    Site.Demo.Acronyms
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.site");
$skb_main->require_package("dist.acronyms");
$skb_main->require_package("dist.graph");

function acro_html(){
  $mySKB=SKB_Main::get_instance();
  $mySKB->require_package("demo.htmlpage");

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");

  $builder=$mySKB->get_builder("Dist.Acronyms.Entries2XHTML-Table");
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

  $h3=Html4_Element::factory("h3", "",_("SKB - Acronyms"));
  $h3->print_html();
?>
  <hr />
  <p>This page shows the acronyms included in the sample database of the SKB distribution. Each attribute has a short form and a long form.
  </p>
  <p>The page also uses the REST support of the SKB to enable download of the acronym database in different formats. Implemented are plain
     text, LaTeX acronym environment and LaTeX longtable environment. Have a look into the source code (dist-acronyms.php5) for details.
  </p>
  <hr /><br />
<?php
  echo "dowload other Formats: ";

  $coll=$_SERVER['HTTP_HOST'];
  $part=$_SERVER['REQUEST_URI'];
  $ct="application/x-latex";
  $url="http://".$coll."/www/demo/dist-http.php5?_hgmedia_type=".urlencode($ct)."&amp;_hgurl=".urlencode($coll.$part)."&amp;_hgfile_name=".urlencode("acronyms.tex");
  echo '<a href="'.$url.'">latex (acronym environment)</a>';

  $ct="text/plain";
  $url="http://".$coll."/www/demo/dist-http.php5?_hgmedia_type=".urlencode($ct)."&amp;_hgurl=".urlencode($coll.$part)."&amp;_hgfile_name=".urlencode("acronyms.txt");
  echo ', <a href="'.$url.'">plain text</a>';

  $ct="text/x-latex+table";
  $url="http://".$coll."/www/demo/dist-http.php5?_hgmedia_type=".urlencode($ct)."&amp;_hgurl=".urlencode($coll.$part)."&amp;_hgfile_name=".urlencode("acronyms-table.tex");
  echo ', <a href="'.$url.'">latex (longtable environment)</a>';

  $reader->execute($request);

  $request->set_value("htmlpage:execute_todo", "bodyend");
  $page->execute($request);
}
$http_request->register_callback(array("GET"), array("*/*","text/html","application/xhtml+xml"), "acro_html");


function acro_latex(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");
  $builder=$mySKB->get_builder("Dist.Acronyms.Entries2LaTeX-Acronym");
  $reader->set_builder($builder);
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), array("application/x-latex","text/x-latex"), "acro_latex");

function acro_latex_table(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");
  $builder=$mySKB->get_builder("Dist.Acronyms.Entries2LaTeX-Table");
  $reader->set_builder($builder);
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), array("application/x-latex+table","text/x-latex+table"), "acro_latex_table");


function acro_text(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");
  $builder=$mySKB->get_builder("Dist.Acronyms.Entries2Text-Plain");
  $reader->set_builder($builder);
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), array("text/plain"), "acro_text");

function acro_entries(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");
  $reader->prepare($request);
  print_r($reader->get_entries()->ar);
}
$http_request->register_callback(array("GET"), "x-skb/entries", "acro_entries");

function acro_graphml(){
	$mySKB=SKB_Main::get_instance();

  $request=$mySKB->get_request();
  $request->activate();
  $reader=$mySKB->get_reader("Dist.Acronyms.DB2Entries");
  $builder=$mySKB->get_builder("Dist.Graph.Entries2GraphML");
  $reader->set_builder($builder);
  $reader->prepare($request);
  $reader->execute($request);
}
$http_request->register_callback(array("GET"), "text/x-graphml", "acro_graphml");


$http_request->response_do();
?>
