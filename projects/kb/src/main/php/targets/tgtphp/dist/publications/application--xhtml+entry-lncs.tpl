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
 * Template for the SKB Package Dist.Publications, displays LNCS style information for a paper.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

    $publ=$request->get_value("publications:publications_key");
    $entry=$entries->ar[$publ[0]];
    $mySKB=SKB_Main::get_instance();
    $hBR="<br />";

    if(isset($entry["publications:conference"]["publications:published_in"])){
      $entry["publications:published_in"]=$entry["publications:conference"]["publications:published_in"];
      unset($entry["publications:conference"]["publications:published_in"]);
    }
    if(isset($entry["publications:event"]["publications:published_in"])){
      $entry["publications:published_in"]=$entry["publications:event"]["publications:published_in"];
      unset($entry["publications:event"]["publications:published_in"]);
    }

?>

  <div class="indent-white">
    <div id="paper">
      <p class="title"><?php echo $entry['publications:title'] ?></p>
<?php

$pAuthor=Html4_Element::factory("p", array("class"=>"author"));
$pAuthorInfo=Html4_Element::factory("p", array("class"=>"authorinfo"));

if(isset($entry['publications:author'])||isset($entry['publications:editor'])){
  if(isset($entry['publications:author']))
    $authors=$entry['publications:author'];
  elseif(isset($entry['publications:editor']))
    $authors=$entry['publications:editor'];

  $affiliations=array();

  $_keys=array_keys($authors);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    if(isset($authors[$_keys[$i]]['affiliation'])){
      if(isset($authors[$_keys[$i]]['affiliation']['default:name']))
        $aff=$authors[$_keys[$i]]['affiliation']['default:name'];
      else
        $aff=$authors[$_keys[$i]]['affiliation']['default:acronym']['acronyms:long'];
      if(!in_array($aff . ", " . $authors[$_keys[$i]]['affiliation']['default:country']['default:name'],$affiliations))
        $affiliations[]=$aff . ", " . $authors[$_keys[$i]]['affiliation']['default:country']['default:name'];
    
      $idx=array_search($aff . ", " . $authors[$_keys[$i]]['affiliation']['default:country']['default:name'],$affiliations)+1;
      if($i>0)
        $pAuthor->add_child(", ");
      $pAuthor->add_child($authors[$_keys[$i]]['people:first'] . " " . $authors[$_keys[$i]]['people:last'] . "<sup>" . $idx . "</sup>");
    }
    else{
      if($i>0)
        $pAuthor->add_child(", ");
      $pAuthor->add_child($authors[$_keys[$i]]['people:first'] . " " . $authors[$_keys[$i]]['people:last']);
    }
  }
  
  $_keys=array_keys($affiliations);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++)
    $pAuthorInfo->add_child("<sup>" . ($i+1) . "</sup> " . $affiliations[$_keys[$i]] . "<br />");
}
elseif(isset($entry['default:organization'])){
  if(isset($entry['default:organization'][0]['default:name']))
    $pAuthor->add_child($entry['default:organization'][0]['default:name']);
  else
    $pAuthor->add_child($entry['default:organization'][0]['default:acronym']['acronyms:long']);
}
elseif(isset($entry['default:institution'])){
  if(isset($entry['default:institution'][0]['default:name']))
    $pAuthor->add_child($entry['default:institution'][0]['default:name']);
  else
    $pAuthor->add_child($entry['default:institution'][0]['default:acronym']['acronyms:long']);
}

echo "<div class=\"center\">" . $pAuthor->to_string() . "</div>\n";
echo "<div class=\"center\">" . $pAuthorInfo->to_string() . "</div>\n";

if(isset($entry['publications:abstract']))
  echo "<p class=\"abstract\"><b>Abstract: </b>" . $entry['publications:abstract'] . "</p>";

if(isset($entry['publications:keywords']))
  echo "<p class=\"keywords\"><b>Keywords: </b>" . implode(", ", $entry['publications:keywords']) . "</p>";

//    if($this->myPublications->getTOC($_key)!="")
//      $divPaper->addChild(new Html4_P(array("class"=>"toc"),"Table of Contents\n\n" . $this->myPublications->getTOC($_key) . "\n"));

echo "<p class=\"event\"><b>Published: </b>\n";

$date=$mySKB->interpret_data("Dist.Publication.Interpreter.EntryDateString", $entry);
switch($entry['publications:entry_type']['key']){
  case "thesis":
  case "phdthesis":
  case "mastersthesis":
    $s="";
    if(isset($entry['publications:type']))
      $s.=$entry['publications:type'] . ": ";
    if(isset($entry['default:institution'][0]['default:acronym']['acronyms:long']))
      $s.=$entry['default:institution'][0]['default:acronym']['acronyms:long'];
    elseif(isset($entry['default:institution'][0]['default:name']))
      $s.=$entry['default:institution'][0]['default:name'];
    $s.=", " . $entry['default:institution'][0]['default:city']['default:name'];
    $s.=", " . $entry['default:institution'][0]['default:city']['default:country']['default:name'];
    $s.=", " . $date;
    echo $s;
    break; 

  case "report":
  case "techreport":
    $s="";
    if(isset($entry['default:organization'])){
      $_keys=array_keys($entry['default:organization']);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
      	if($i>0)
      	  $s.="/";
    	  $s.=$entry['default:organization'][$i]['default:acronym']['acronyms:long'];
      }
      $s.=", " . $entry['default:organization'][0]['default:city']['default:name'];
      $s.=", " . $entry['default:organization'][0]['default:city']['default:country']['default:name'];
    }
    $s.=", " . $date;
    echo $s;
    break;

  case "pr_poster":
  case "standard":
    $s="";
    if(isset($entry['publications:series']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
    if(isset($entry['publications:number']))
      $s.=Util_Interpreter::interpret("add:char:blank", $s) . $entry['publications:number'];
    if(isset($entry['publications:edition']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:edition'];
    if(isset($entry['publications:type']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:type'];
    if(isset($entry['publications:howpublished']))
      $s.=" " . $entry['publications:howpublished'];
      //$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['howpublished'];

  	if(isset($entry['default:organization'][0]['default:name']))
  	  $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:name'];
  	else
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:acronym']['acronyms:long'];

    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:city']['default:name'];
    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:organization'][0]['default:country']['default:name'];

    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
    echo $s;
    if(isset($entry['publications:note']))
      echo "<br />note: <i>" . $entry['publications:note'] . "</i>";
    break;

  case "inbook":
  case "incollection":
    echo "<i>";

    echo $mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:published_in"]["publications:editor"]);
    if(count($entry["publications:published_in"]["publications:editor"])==1)
      echo " (Ed.)";
    else
      echo " (Eds.)";
    echo ": <b>". $entry["publications:published_in"]['publications:title'] . "</b></i>";
    if(isset($entry['publications:subtitle']))
      echo " - <b><i>{$entry['publications:subtitle']}</i></b>";

    $s=", ";
    if(isset($entry["publications:published_in"]['publications:series']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:series'];
    if(isset($entry["publications:published_in"]['publications:edition']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:edition'] . "<sup>" . Util_Interpreter::interpret("integer:ordinal_text", $entry["publications:published_in"]['publications:edition']) . "</sup>" . " Edition";
    if(isset($entry["publications:published_in"]['publications:version']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]['publications:version'];
    if(isset($entry["publications:published_in"]['publications:isbn']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry["publications:published_in"]['publications:isbn'];
    if(isset($entry["publications:published_in"]['publications:isbn_10']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-10: " . $entry["publications:published_in"]['publications:isbn_10'];
    if(isset($entry["publications:published_in"]['publications:isbn_13']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-13: " . $entry["publications:published_in"]['publications:isbn_13'];
    if(isset($entry["publications:published_in"]["pagetotal"]))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "pages: " . $entry["publications:published_in"]["pagetotal"];

    if(isset($entry["publications:published_in"]["default:publisher"])){
      if(isset($entry["publications:published_in"]["default:publisher"]['default:name']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:name'];
      else
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:acronym']['acronyms:short'];
      if(isset($entry["publications:published_in"]["default:publisher"]['affiliations:address']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['affiliations:address'];
      elseif(isset($entry["publications:published_in"]["default:publisher"]['default:city']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:city']['default:name'] . Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:city']['default:country']['default:name'];
      elseif(isset($entry["publications:published_in"]["default:publisher"]['default:country']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["publications:published_in"]["default:publisher"]['default:country']['default:name'];
    }
    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
    echo $s;
    break;

  case "proceedings":
    $s="";
    if(isset($entry['publications:conference'])){
    	$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "Proceedings of the ";
      if(isset($entry['publications:conference']['publications:iteration']))
        $s.=$entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
      if(isset($entry['publications:conference']['default:sponsor'])){
        $_keys=array_keys($entry['publications:conference']['default:sponsor']);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
        	if($i>0)
        	  $s.="/";
      	  $s.=$entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
        }
        $s.=" ";
      }
      $s.=$entry['publications:conference']['default:acronym']['acronyms:long'];
      $s.=" (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
    }

    if(isset($entry['publications:series']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
    if(isset($entry['publications:volume']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "vol. " . $entry['publications:volume'];
    if(isset($entry['publications:number']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "no. " . $entry['publications:number'];
    if(isset($entry['default:publisher'])){
    	$s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:publisher']['default:name'];
    	if(isset($entry['default:publisher']['affiliations:address']))
    	  $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['default:publisher']['affiliations:address'];;
    }
    if(isset($entry['publications:isbn']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry['publications:isbn'];
    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
    echo $s;
    break;

  case "conference":
  case "inproceedings":
    echo "in Proc. of the ";
    if(isset($entry['publications:conference']['publications:iteration']))
      echo $entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
    if(isset($entry['publications:conference']['default:sponsor'])){
      $_keys=array_keys($entry['publications:conference']['default:sponsor']);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
      	if($i>0)
      	  echo "/";
      	echo $entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
      }
      echo " ";
    }
    echo $entry['publications:conference']['default:acronym']['acronyms:long'];
    echo " (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
    echo ", " . $entry['publications:conference']['default:city']['default:name'];
    echo ", " . $entry['publications:conference']['default:city']['default:country']['default:name'];
    echo ", " . $date;

    if(isset($entry["publications:published_in"])){
    	echo "<i>";
      echo $mySKB->interpret_data("Dist.People.Interpreter.String", $entry["publications:published_in"]["publications:editor"]);
      if(count($entry["publications:published_in"]["publications:editor"])==1)
        echo " (Ed.)";
      else
        echo " (Eds.)";
      echo ": <b>". $entry["publications:published_in"]['publications:title'] . "</b></i>";
      if(isset($entry["publications:published_in"]['publications:subtitle']))
        echo " - <b><i>{$entry["publications:published_in"]['publications:subtitle']}</i></b>";
      if(isset($entry["publications:published_in"]['publications:series']))
        echo ", " . $entry["publications:published_in"]['publications:series'];
      if(isset($entry["publications:published_in"]['publications:volume']))
        echo ", vol. " . $entry["publications:published_in"]['publications:volume'];
      if(isset($entry["publications:published_in"]['publications:number']))
        echo ", no. " . $entry["publications:published_in"]['publications:number'];
      if(isset($entry["publications:published_in"]['default:publisher'])){
      	echo ", " . $entry["publications:published_in"]['default:publisher']['default:name'];
      	if(isset($entry["publications:published_in"]['default:publisher']['affiliations:address']))
      	  echo ", " . $entry["publications:published_in"]['default:publisher']['affiliations:address'];
      }
      if(isset($entry["publications:published_in"]['publications:isbn']))
        echo ", ISBN: " . $entry["publications:published_in"]['publications:isbn'];
      if(isset($entry['publications:pages']))
        echo ", pp. " . $entry['publications:pages'];
      echo ", " . $date;
    }
    break;

  case "pr_tutorial":
  case "pr_presentation":
    $s="";
    if(isset($entry['publications:note']))
      $s.=$entry['publications:note'] . ": ";

    if(isset($entry['publications:conference'])){
      if(isset($entry['publications:conference']['publications:iteration']))
        $s.=$entry['publications:conference']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:conference']['publications:iteration']).' ';
      if(isset($entry['publications:conference']['default:sponsor'])){
        $_keys=array_keys($entry['publications:conference']['default:sponsor']);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
        	if($i>0)
        	  $s.="/";
      	  $s.=$entry['publications:conference']['default:sponsor'][$i]['default:acronym']['acronyms:short'];
        }
        $s.=" ";
      }
      $s.=$entry['publications:conference']['default:acronym']['acronyms:long'];
      $s.=" (" . $entry['publications:conference']['default:acronym']['acronyms:short'] . " " . $entry['publications:conference']['default:year'] . ")";
      $s.=", " . $entry['publications:conference']['default:city']['default:name'];
      $s.=", " . $entry['publications:conference']['default:city']['default:country']['default:name'];
      $s.=", " . $date;
    }
    elseif(isset($entry['event'])){
      if(isset($entry['event']['publications:iteration']))
        $s.=$entry['event']['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $entry['event']['publications:iteration']).' ';
      if(isset($entry['event']['default:organization'])){
        $_keys=array_keys($entry['event']['default:organization']);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
        	if($i>0)
        	  $s.="/";
      	  $s.=$entry['event']['default:organization'][$i]['default:acronym']['acronyms:short'];
        }
        $s.=" ";
      }
      $s.=$entry['event']['default:name'];
      $s.=", " . $entry['event']['default:city']['default:name'];
      $s.=", " . $entry['event']['default:city']['default:country']['default:name'];
      $s.=", " . $date;
    }
    echo $s;
    break;

  case "article":
    echo $hBR;
    echo $entry["publications:journal"]['default:acronym']["acronyms:long"];
    echo " (" . $entry["publications:journal"]['default:acronym']["acronyms:short"] . ")";
    if(isset($entry["publications:journal"]["default:publisher"]['default:name']))
      echo ", " . $entry["publications:journal"]["default:publisher"]['default:name'];
    else
      echo ", " . $entry["publications:journal"]["default:publisher"]['default:acronym']['acronyms:short'];
    if(isset($entry["publications:journal"]["default:publisher"]['affiliations:address']))
      echo ", " . $entry["publications:journal"]["default:publisher"]['affiliations:address'];
    else
      echo ", " . $entry["publications:journal"]["default:publisher"]['default:city']['default:name'];
    if(isset($entry["publications:journal"]["default:publisher"]['default:country']))
      echo ", " . $entry["publications:journal"]["default:publisher"]['default:country']['default:name'];
    if(isset($entry["publications:journal"]["publications:issn_print"]))
      echo ", ISSN: " . $entry["publications:journal"]["publications:issn_print"];
    if(isset($entry["publications:journal"]["publications:issn_online"]))
      echo ", ISSN (online): " . $entry["publications:journal"]["publications:issn_online"];
    if(isset($entry["publications:number"]))
      echo ", no. " . $entry["publications:number"];
    if(isset($entry["publications:volume"]))
      echo ", vol. " . $entry["publications:volume"];
    if(isset($entry["publications:issue"]))
      echo ", issue " . $entry["publications:issue"];
    echo ", " . $date;
    break;

  case "collection":
  case "book":
    $s="";
    if(isset($entry['publications:series']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:series'];
    if(isset($entry['publications:edition']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:edition'] . "<sup>" . Util_Interpreter::interpret("integer:ordinal:text", $entry['publications:edition']) . "</sup>" . " Edition";
    if(isset($entry['publications:version']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry['publications:version'];
    if(isset($entry['publications:isbn']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN: " . $entry['publications:isbn'];
    if(isset($entry['publications:isbn_10']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-10: " . $entry['publications:isbn_10'];
    if(isset($entry['publications:isbn_13']))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "ISBN-13: " . $entry['publications:isbn_13'];
    if(isset($entry["publications:pagetotal"]))
      $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . "pages: " . $entry["publications:pagetotal"];

    if(isset($entry["default:publisher"])){
      if(isset($entry["default:publisher"]['default:name']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:name'];
      else
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:acronym']['acronyms:short'];
      if(isset($entry["default:publisher"]['affiliationsaddress']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['affiliations:address'];
      elseif(isset($entry["default:publisher"]['default:city']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:city']['default:name'];
      if(isset($entry["default:publisher"]['default:country']))
        $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $entry["default:publisher"]['default:country']['default:name'];
    }
    $s.=Util_Interpreter::interpret("add:char:comma-blank", $s) . $date;
    echo $s;
    break;
}

echo "</p>\n";

?>
      <div class="center">
        <br /><br />
        <input type="button" value=" &lsaquo;&lsaquo; Back &lsaquo;&lsaquo; " onclick="history.go(-1)" />
        <br /><br />
      </div>
    </div>
  </div>