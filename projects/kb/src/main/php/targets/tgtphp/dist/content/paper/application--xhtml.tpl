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
 * Template for the HTML builder in SKB Package Dist.Content.Paper.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Content.Paper
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
$mySKB=SKB_Main::get_instance();

$req_type=$request->get_value("request:request");
$req_type=$req_type[0];
$gallery_request=$mySKB->get_request($req_type);
$gallery_request->init_http();

$title=$request->get_value('title');
if(Util_Interpreter::interpret("value:is_empty", $title)!=true)
  $title=$title[0];
else
  $title=null;
$subtitle=$request->get_value('subtitle');
if(Util_Interpreter::interpret("value:is_empty", $subtitle)!=true)
  $subtitle=$subtitle[0];
else
  $subtitle=null;


$elem=$gallery_request->get_value("request:entry");
if(count($elem)==0){
?>
  <div class="center">
    <div class="diary-outer">
      <br />
      <div id="paper">
      <p class="title"><?php echo $title ?><br /><?php echo $subtitle ?></p>
<?php
          $ar=$entries->ar;
          $_keys=array_keys($ar);
          $_size=count($_keys);
          for($i=0;$i<$_size;$i++){
          	if(isset($ar[$_keys[$i]]['request:url_frag']))
          	  echo '<a id="'.$ar[$_keys[$i]]['request:url_frag'].'"></a>';
          	echo '<p class="h1">'.$ar[$_keys[$i]]['default:name'].'</p>';
            echo $ar[$_keys[$i]]['default:description'];

            if(isset($ar[$_keys[$i]]['content:foto_keys'])){
            	$gallery_request=$mySKB->get_request("gallery:fotos");
            	$gallery_request->init_plain();
            	$gallery_request->set_value("request:file_ext",array("jpg"));
            	$gallery_request->set_value("request:part",$request->get_value("request:part"));
            	$gallery_request->set_value("request:element_keys",$ar[$_keys[$i]]['content:foto_keys']);
            	$gallery_request->activate();
            	$gallery_reader=$mySKB->get_reader($gallery_request);
            	$gallery_reader->set_builder($mySKB->get_builder($gallery_request));
            	$gallery_reader->prepare($gallery_request);
            	$gallery_reader->execute($gallery_request);
            }
            elseif(isset($ar[$_keys[$i]]['content:graphic_keys'])){
            	$gallery_request=$mySKB->get_request("Dist.Gallery.Graphics");
            	$gallery_request->init_plain();
            	$gallery_request->set_value("request:file_ext",array("png"));
            	$gallery_request->set_value("request:part",$request->get_value("request:part"));
            	$gallery_request->set_value("request:element_keys",$ar[$_keys[$i]]['content:graphic_keys']);
            	$gallery_request->activate();
            	$gallery_reader=$mySKB->get_reader("Dist.Gallery.DB2Entries");
            	$gallery_reader->set_builder($mySKB->get_builder("Dist.Gallery.Entries2XHTML"));
            	$gallery_reader->prepare($gallery_request);
            	$gallery_reader->execute($gallery_request);
            }
            echo "\n\n";
          }

    $collection=$request->get_value("request:collection");
    $collection=$collection[0];
    $part=$request->get_value("request:part");
    $part=$part[0];

    $cp_reader=$mySKB->get_reader("Dist.Collections.DB2Entries");
    $cp_reader->set_builder($mySKB->get_builder("Core.Default.Entries2Entries"));
    $cp_reader->prepare($request);
    $cp_entries=$cp_reader->get_entries()->ar;

    if(isset($cp_entries[$collection][$part]['content:wherepublished_key'])){
    	$ref_request=$mySKB->get_request("Dist.Publications");
    	$ref_request->init_plain();
    	$ref_request->set_value("publications:key",$cp_entries[$collection][$part]['content:wherepublished_key']);
    	$ref_request->activate();
    	$ref_reader=$mySKB->get_reader("Dist.Publications.DB2Entries");
    	$ref_reader->set_builder($mySKB->get_builder("Dist.Publications.Entries2XHTML-OL"));
    	$ref_reader->prepare($ref_request);

      echo '<hr />';
    	$ref_reader->execute($ref_request);

    	$ref_reader->set_builder($mySKB->get_builder("Dist.Publications.Entries2BibTeX"));
    	echo '<div class="publications"><ol><li><pre>';
    	$ref_reader->execute($ref_request);
    	echo '</pre></li></ol></div>';
    }
    if(isset($cp_entries['used_reference_keys'])){
    }

?>
      </div>
    </div>
  </div>
<?php
}
else{
	$gallery_request->set_value("request:file_ext",array("jpg","png"));
  $gallery_request->activate();
  $gallery_reader=$mySKB->get_reader("Dist.Gallery.DB2Entries");
  $gallery_reader->set_builder($mySKB->get_builder("Dist.Gallery.Entries2XHTML"));
  $gallery_reader->prepare($gallery_request);
  $gallery_reader->execute($gallery_request);
}
?>