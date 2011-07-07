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
 * @package    Site.Demo.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2010 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

require_once "_sbin/site_id.php5";
require_once "../../skb/classes/main.inc.php5";

$skb_main->require_package("demo.site");
$skb_main->require_package("demo.htmlpage");
$skb_main->require_package("dist.publications");
$skb_main->require_package("dist.graph");

function publ_html(){
	$mySKB=SKB_Main::get_instance();
  $ref_request=$mySKB->get_request("Dist.Publications");
  $ref_request->init_http();
  $ref_request->activate();
  $ref_reader=$mySKB->get_reader("Dist.Publications.DB2Entries");
  $ref_reader->set_builder($mySKB->get_builder("Dist.Publications.Entries2XHTML-OL"));
  
  $paper=$ref_request->get_value("publications:publications_key");
  if(count($paper)>0)
    $ref_reader->set_builder($mySKB->get_builder("Dist.Publications.Entries2XHTML-Entry-LNCS"));
  
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
  
  if(count($paper)==0){
    $h3=Html4_Element::factory("h3", "",_("SKB - Publications"));
    $h3->print_html();
    $hr=Html4_Element::factory("hr");
    
    ?>
      <hr />
      <p>This page shows some examples for the Publication package of the SKB distribution. It uses the publication reader to read entries 
         for articles, books, inproceedings, manuals, online, posters, standards, technical reports, tutorials and unpublished work. The publications 
         for each item are automatically sorted by date.
      </p>
      <hr /><br />
    <?php
    
    $h3=Html4_Element::factory("h3", "","article");
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "article");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","book");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "book");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","inproceedings");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "inproceedings");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","manual");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "manual");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","online");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "online");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","poster");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "poster");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","standard");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "standard");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","techreport");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "techreport");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","tutorial");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "tutorial");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
    
    $h3=Html4_Element::factory("h3", "","unpublished");
    $hr->print_html();
    $h3->print_html();
    $ref_request->set_value("publications:entry_type_key", "unpublished");
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
  }
  else{
  	$ref_request->set_value("publications:show_abstract", true);
    $ref_reader->set_builder($mySKB->get_builder("Dist.Publications.Entries2XHTML-Entry-LNCS"));
    $ref_reader->prepare($ref_request);
    $ref_reader->execute($ref_request);
  }
  
  $request->set_value("htmlpage:execute_todo", "bodyend");
  $page->execute($request);
}
$http_request->register_callback(array("GET"), array("*/*","text/html","application/xhtml+xml"), "publ_html");

function publ_graphml(){
	$mySKB=SKB_Main::get_instance();
	$ar=array();

  $ref_request=$mySKB->get_request("Dist.Publications");
  $ref_request->init_http();
  $ref_request->activate();
  $ref_reader=$mySKB->get_reader("Dist.Publications.DB2Entries");

  $ref_request->set_value("publications:entry_type_key", "article");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "book");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "inproceedings");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "manual");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "online");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "poster");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "standard");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "techreport");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "tutorial");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $ref_request->set_value("publications:entry_type_key", "unpublished");
  $ref_reader->prepare($ref_request);
  $ar=$ar+$ref_reader->get_entries()->ar;

  $request=$mySKB->get_request();
  $request->activate();
  $builder=$mySKB->get_builder("Dist.Graph.Entries2GraphML");
  $builder->execute($request, new Util_ArBase($ar));
}
$http_request->register_callback(array("GET"), "text/x-graphml", "publ_graphml");


$http_request->response_do();

?>