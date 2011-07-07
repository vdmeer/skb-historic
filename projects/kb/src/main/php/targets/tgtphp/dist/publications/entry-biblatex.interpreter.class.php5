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
 * SKB Value Interpreter for Dist.Publications, creates the actual BibTeX entry for a single reference.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.31 build 110208 (08-Feb-11) with PHP 5.3.0
 */
class pkg_dist__publications___entry_biblatex___interpreter implements SKB_InterpreterValue{
  public function __construct(){}

  static public function interpret($entry){
    $mySKB=SKB_Main::get_instance();
    $ret=array();

    /*
    UNUSED BIBLATEX Fields
    -- eprint, eprinttype, indextitle
    -- addendum, annotation, bookpagination, library, nameaddon, pagination, language
    -- isan, ismn, iswc
    -- origlanguage, origlocation, origpublisher, origtitle, origyear
    -- shortauthor, shorteditor, shorthand, shorthandintro, shortjournal, shortseries, shorttitle
    */

    $ret['key']=$entry['key'];
    $ret['publications:entry_type']=$entry['publications:entry_type'];

//    $date=$mySKB->interpret_data("Dist.Date.Interpreter.String", $entry);
    $date=$mySKB->interpret_data("Dist.Publication.Interpreter.EntryDateString", $entry);

    if(isset($entry["publications:conference"]["publications:published_in"])){
      $entry["publications:published_in"]=$entry["publications:conference"]["publications:published_in"];
      unset($entry["publications:conference"]["publications:published_in"]);
    }
    if(isset($entry["publications:event"]["publications:published_in"])){
      $entry["publications:published_in"]=$entry["publications:event"]["publications:published_in"];
      unset($entry["publications:event"]["publications:published_in"]);
    }


    if(isset($entry["publications:conference"])||isset($entry["publications:event"])){
    	if(isset($entry["publications:conference"]))
    	  $inAr=$entry["publications:conference"];
    	else
    	  $inAr=$entry["publications:event"];
    	$event="";
      if(isset($inAr['publications:iteration']))
        $event.=$inAr['publications:iteration'].Util_Interpreter::interpret("integer:ordinal:text", $inAr['publications:iteration']).' ';
      if(isset($inAr['default:sponsor'])){
        $_keysCo=array_keys($inAr['default:sponsor']);
        $_sizeCo=count($_keysCo);
        for($k=0;$k<$_sizeCo;$k++){
          if($k>0)
            $event.="/";
    	    $event.=$inAr['default:sponsor'][$k]['default:acronym']['acronyms:short'];
        }
        $event.=" ";
      }
      if(isset($inAr['default:acronym']['acronyms:long']))
        $event.=$inAr['default:acronym']['acronyms:long'];
      else
        $event.=$inAr['default:name'];

      $event_short="";
      if(isset($inAr['default:acronym']['acronyms:short']))
        $event_short=$inAr['default:acronym']['acronyms:short'];

      $event_year=$inAr['default:year'];

      if(isset($inAr["default:city"])&&isset($inAr["default:country"]))
        $venue=$inAr["default:city"]['default:name'].', '.$inAr["default:country"]['default:name'];     
      elseif(isset($inAr["default:city"]))
        $venue=$inAr["default:city"]['default:name'].', '.$inAr["default:city"]["default:country"]['default:name'];
      elseif(isset($inAr["default:country"]))
        $venue=$inAr["default:country"]['default:name'];
    }

    /*
    people-related: author, bookauthor, editor
                    -- authortype, editortype
                    -- afterword, annotator, commentator, redactor, translator, introduction
                    -- holder, foreword
    */
    //author is either first organisation (standards), or author-list or editor-list
    if($entry['publications:entry_type']['key']=='standard'){
    	if(isset($entry['default:organization'][0]['default:name']))
    	  $ret["author"]=$entry['default:organization'][0]['default:name'];
    	else
        $ret["author"]=$entry['default:organization'][0]['default:acronym']['acronyms:long'];
    }
    elseif($entry['publications:entry_type']['key']=='book'){
    	if(isset($entry['publications:author'])){
    	  //$ret["bookauthor"]=$mySKB->interpret_data("Dist.People.Interpreter.StringBibTeX", $entry["publications:author"]);
    	  $ret["author"]=$mySKB->interpret_data("Dist.People.Interpreter.StringBibTeX", $entry["publications:author"]);
    	}
    }
    elseif(isset($entry['publications:author']))
      $ret["author"]=$mySKB->interpret_data("Dist.People.Interpreter.StringBibTeX", $entry["publications:author"]);

    if(isset($entry['publications:editor']))
      $ret["editor"]=$mySKB->interpret_data("Dist.People.Interpreter.StringBibTeX", $entry["publications:editor"]);
    elseif(isset($entry["publications:published_in"]))
      $ret["editor"]=$mySKB->interpret_data("Dist.People.Interpreter.StringBibTeX", $entry["publications:published_in"]["publications:editor"]);


    /*
    title-related: booksubtitle, booktitle, booktitleaddon
                   issuesubtitle, issuetitle
                   journalsubtitle, journaltitle
                   mainsubtitle, maintitle, maintitleaddon
                   //reprinttitle
                   subtitle, title, titleaddon
    */
    $ret["title"]=$entry['publications:title'];
    switch($entry['publications:entry_type']['key']){
      case "conference":
      case "inproceedings":
          if(isset($entry['publications:subtitle']))
            $ret["subtitle"]=$entry['publications:subtitle'];
          if(isset($entry['publications:titleaddon']))
            $ret["titleaddon"]=$entry['publications:titleaddon'];

          $conf="Proc. of the " . $event . " (" . $event_short . " " . $event_year . ")";
          if(isset($entry['publications:published_in'])){
            //$ret['booktitle']=$entry['publications:published_in']['publications:title'];
            //$ret['booksubtitle']=$conf;
            $ret['booktitle']=$conf;
            if(isset($entry['publications:published_in']['publications:titleaddon']))
              $ret['booktitleaddon']=$entry['publications:published_in']['publications:titleaddon'];
          }
          else{
            $ret['booktitle']=$conf;
          }
          $ret['venue']=$venue . ", " . $date;

          if(isset($entry['publications:published_in']['default:day']))
            $ret['eventday']=$entry['publications:published_in']['default:day'];
          elseif(isset($entry['publications:published_in']['default:day_start'])){
            $ret['eventday']=$entry['publications:published_in']['default:day_start'];
            $ret['eventendday']=$entry['publications:published_in']['default:day_end'];
          }
          if(isset($entry['publications:published_in']['default:month']))
            $ret['eventmonth']=$entry['publications:published_in']['default:month'];
          elseif(isset($entry['publications:published_in']['default:month_start'])){
            $ret['eventmonth']=$entry['publications:published_in']['default:month_start'];
            $ret['eventendmonth']=$entry['publications:published_in']['default:month_end'];
          }
//          if(isset($entry['publications:published_in']['default:year']))
//            $ret['eventyear']=$entry['publications:published_in']['default:year'];
          break;

      case "inbook":
      case "incollection":
          if(isset($entry['publications:subtitle']))
            $ret["subtitle"]=$entry['publications:subtitle'];
          if(isset($entry['publications:titleaddon']))
            $ret["titleaddon"]=$entry['publications:titleaddon'];

          $ret['booktitle']=$entry['publications:published_in']['publications:title'];
          if(isset($entry['publications:published_in']['publications:subtitle']))
            $ret['booksubtitle']=$entry['publications:published_in']['publications:subtitle'];
          if(isset($entry['publications:published_in']['publications:titleaddon']))
            $ret['booktitleaddon']=$entry['publications:published_in']['publications:titleaddon'];
          break;

      case "book":
      case "collection":
          if(isset($entry['publications:subtitle']))
            $ret["subtitle"]=$entry['publications:subtitle'];
          if(isset($entry['publications:titleaddon']))
            $ret["titleaddon"]=$entry['publications:titleaddon'];
          break;

      case "proceedings":
          if(isset($entry['publications:subtitle']))
            $ret["subtitle"]=$entry['publications:subtitle'];
          if(isset($entry['publications:titleaddon']))
            $ret["titleaddon"]=$entry['publications:titleaddon'];

          $conf="Proc. of the " . $event . " (" . $event_short . " " . $event_year . ")";

          if(isset($entry['publications:published_in'])){
          	if(isset($entry['publications:published_in']['publications:title'])){
              $ret['booktitle']=$entry['publications:published_in']['publications:title'];
              $ret['booksubtitle']=$conf;
            }
            else
              $ret['booktitle']=$conf;

            if(isset($entry['publications:published_in']['publications:titleaddon']))
              $ret['booktitleaddon']=$entry['publications:published_in']['publications:titleaddon'];
          }
          elseif(isset($entry['publications:conference'])){
            $ret['booktitle']=$conf;
          }
          //$ret['venue']=$venue;
          $ret['eventtitle']=$event . " (" . $event_short . " " . $event_year . ")";
          break;

      case "presentation":
      case "tutorial":
          if(isset($entry['publications:subtitle']))
            $ret["subtitle"]=$entry['publications:subtitle'];
          if(isset($entry['publications:titleaddon']))
            $ret["titleaddon"]=$entry['publications:titleaddon'];
          $ret['location']=$venue;
          $ret['howpublished']=$event;
          if($event_short!="")
            $ret['howpublished'].=" (" . $event_short . " " . $event_year . ")";
          $ret['howpublished'].=", " . $date;
          break;
      default:
          break;
    }


    /* Standard Fields from publication
       abstract, chapter, edition, issue, label, number, pages, pagetotal, part, series, version, volume, type, volumes, note, howpublished, journaltitle
    */
    if(isset($entry["publications:abstract"]))
      $ret['abstract']=$entry["publications:abstract"];
    if(isset($entry["publications:chapter"]))
      $ret['chapter']=$entry["publications:chapter"];
    if(isset($entry["publications:edition"]))
      $ret['edition']=$entry["publications:edition"];
    if(isset($entry["publications:issue"]))
      $ret['issue']=$entry["publications:issue"];
    if(isset($entry["publications:label"]))
      $ret['label']=$entry["publications:label"].'-';
    if(isset($entry["publications:number"]))
      $ret['number']=$entry["publications:number"];
    if(isset($entry["publications:pages"]))
      $ret['pages']=$entry["publications:pages"];
    if(isset($entry["publications:pagetotal"]))
      $ret['pagetotal']=$entry["publications:pagetotal"];
    if(isset($entry["publications:part"]))
      $ret['part']=$entry["publications:part"];
    if(isset($entry["publications:series"]))
      $ret['series']=$entry["publications:series"];
    if(isset($entry["publications:version"]))
      $ret['version']=$entry["publications:version"];
    if(isset($entry["publications:volume"]))
      $ret['volume']=$entry["publications:volume"];
    if(isset($entry["publications:volumes"]))
      $ret['volumes']=$entry["publications:volumes"];
    if(isset($entry["publications:type"]))
      $ret['type']=$entry["publications:type"];
    if(isset($entry["publications:note"]))
      $ret['note']=$entry["publications:note"];
    if(isset($entry["publications:howpublished"]))
      $ret['howpublished']=$entry["publications:howpublished"];
    if(isset($entry["publications:journal"]))
      $ret['journaltitle']=$entry["publications:journal"]['default:acronym']['acronyms:long'];


    /* catalogue-numbers:
         ++ isbn, issn, doi
         -- eid, isrn
    */
    if(isset($entry["publications:doi"]))
      $ret['doi']=$entry["publications:doi"];
    if(isset($entry['publications:published_in'])){
      if(isset($entry['publications:published_in']["publications:isbn_13"]))
        $ret['isbn']=$entry['publications:published_in']["publications:isbn_13"];
      elseif(isset($entry['publications:published_in']["publications:isbn_10"]))
        $ret['isbn']=$entry['publications:published_in']["publications:isbn_10"];
      elseif(isset($entry['publications:published_in']["publications:isbn"]))
        $ret['isbn']=$entry['publications:published_in']["publications:isbn"];
    }
    else{
      if(isset($entry["publications:isbn_13"]))
        $ret['isbn']=$entry["publications:isbn_13"];
      elseif(isset($entry["publications:isbn_10"]))
        $ret['isbn']=$entry["publications:isbn_10"];
      elseif(isset($entry["publications:isbn"]))
        $ret['isbn']=$entry["publications:isbn"];
    }
    if(isset($entry["publications:journal"]['publications:issn_print']))
      $ret['issn']=$entry["publications:journal"]['publications:issn_print'];
    elseif(isset($entry["publications:journal"]['publications:issn_online']))
      $ret['issn']=$entry["publications:journal"]['publications:issn_online'];


    /* date-related
         ++ date, day, month, year
    */
    if(isset($entry["default:year"]))
      $ret['year']=$entry["default:year"];
      //echo $mySKB->interpret_data("Dist.Date.Interpreter.String", $entry);


    /* external-links
         ++ url, urldate, urlday, urlmonth, urlyear
         -- file
    */
    if(isset($entry['default:url'])){
    	$ret['url']=$entry['default:url'];
    	(isset($entry['default:url_day']))?$ret['url_day']=$entry['default:url_day']:"";
     	(isset($entry['default:url_month']['date:number']))?$ret['url_month']=$entry['default:url_month']['date:number']:"";
     	(isset($entry['default:url_year']))?$ret['url_year']=$entry['default:url_year']:"";
    }
    else{
      if(isset($entry["publications:conference"]['default:url'])){
      	$ret['url']=$entry["publications:conference"]['default:url'];
      	(isset($entry["publications:conference"]['default:url_day']))?$ret['url_day']=$entry["publications:conference"]['default:url_day']:"";
      	(isset($entry["publications:conference"]['default:url_month']['date:number']))?$ret['url_month']=$entry["publications:conference"]['default:url_month']['date:number']:"";
      	(isset($entry["publications:conference"]['default:url_year']))?$ret['url_year']=$entry["publications:conference"]['default:url_year']:"";
      }
      elseif(isset($entry["publications:journal"]['default:url'])){
      	$ret['url']=$entry["publications:journal"]['default:url'];
      	(isset($entry["publications:journal"]['default:url_day']))?$ret['url_day']=$entry["publications:journal"]['default:url_day']:"";
      	(isset($entry["publications:journal"]['default:url_month']['date:number']))?$ret['url_month']=$entry["publications:journal"]['default:url_month']['date:number']:"";
      	(isset($entry["publications:journal"]['default:url_year']))?$ret['url_year']=$entry["publications:journal"]['default:url_year']:"";
      }
      elseif(isset($entry["publications:published_in"]['default:url'])){
      	$ret['url']=$entry["publications:published_in"]['default:url'];
      	(isset($entry["publications:published_in"]['default:url_day']))?$ret['url_day']=$entry["publications:published_in"]['default:url_day']:"";
      	(isset($entry["publications:published_in"]['default:url_month']['date:number']))?$ret['url_month']=$entry["publications:published_in"]['default:url_month']['date:number']:"";
      	(isset($entry["publications:published_in"]['default:url_year']))?$ret['url_year']=$entry["publications:published_in"]['default:url_year']:"";
      }
      elseif(isset($entry["event"]['default:url'])){
      	$ret['url']=$entry["event"]['default:url'];
      	(isset($entry["event"]['default:url_day']))?$ret['url_day']=$entry["event"]['default:url_day']:"";
      	(isset($entry["event"]['default:url_month']['date:number']))?$ret['url_month']=$entry["event"]['default:url_month']['date:number']:"";
      	(isset($entry["event"]['default:url_year']))?$ret['url_year']=$entry["event"]['default:url_year']:"";
      }
    }


    /* publisher and location
    */
    if(isset($entry['default:publisher']))
      $pAr=$entry['default:publisher'];
    elseif(isset($entry['publications:published_in']['default:publisher']))
    	$pAr=$entry['publications:published_in']['default:publisher'];
    elseif(isset($entry['publications:journal']['default:publisher']))
    	$pAr=$entry['publications:journal']['default:publisher'];

    if(isset($pAr['default:name']))
  	  $ret['publisher']=$pAr['default:name'];
  	elseif(isset($pAr['default:acronym']['acronyms:short']))
  	  $ret['publisher']=$pAr['default:acronym']['acronyms:short'];

    if(isset($pAr["default:city"])&&isset($pAr["default:country"]))
      $ret['location']=$pAr["default:city"]['default:name'].', '.$pAr["default:country"]['default:name'];     
    elseif(isset($pAr["default:city"]))
      $ret['location']=$pAr["default:city"]['default:name'].', '.$pAr["default:city"]["default:country"]['default:name'];
    elseif(isset($pAr["default:country"]))
      $ret['location']=$pAr["default:country"]['default:name'];
    elseif(isset($pAr['affiliations:address']))
      $ret['location']=$pAr['affiliations:address'];


    /* institution and organisation
    */
    switch($entry['publications:entry_type']['key']){
      case "mastersthesis":
      case "phdthesis":
      case "thesis":
          if(isset($entry['default:institution'])){
          	if(isset($entry['default:institution'][0]['default:name']))
      	      $ret['institution']=$entry['default:institution'][0]['default:name'];
          	else
              $ret['institution']=$entry['default:institution'][0]['default:acronym']['acronyms:long'];
          }
          break;
      case "manual":
      case "online":
          if(isset($entry['default:organization'])){
          	if(isset($entry['default:organization'][0]['default:name']))
          	  $ret['organization']=$entry['default:organization'][0]['default:name'];
          	else
              $ret['organization']=$entry['default:organization'][0]['default:acronym']['acronyms:short'];
          }
          break;
      default:
          break;
    }

    ksort($ret);

    //last, change the entry_type array to the biblatex entry type
    $ret['publications:entry_type']=$entry['publications:entry_type']['publications:biblatex'];
    return $ret;
  }
}
?>