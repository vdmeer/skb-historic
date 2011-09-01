<?php
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2002-2011, Sven van der Meer <sven@vandermeer.de>
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
 * Tool to convert data in an SQLite database to DAL
 *
 * @package    SKB sbin
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2002-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

$site_id="demo";
$site_path="/www/demo";
require_once "/dev/projects/skb/skb-git/htdocs/skb/classes/main.inc.php5";

$tinos_home="v:/dev/projects/skb/skb-git";

$skb_main->load_all_site_packages();

$data_tables=array(
//  "core.encoding" => array("db" => "core/encoding/encoding.db", "tables" => array("encoding_characters")),

  "dist.acronyms" => array("db" => "dist/acronyms/acronyms.db", "tables" => array("acronyms")),
  "dist.affiliations" => array("db" => "dist/affiliations/affiliations.db", "tables" => array("affiliations","affiliations_type")),
  "dist.currencies" => array("db" => "dist/currencies/currencies.db", "tables" => array("currencies")),
  "dist.date" => array("db" => "dist/date/date.db", "tables" => array("date_month","date_dow","date_dom")),
  "dist.geo" => array("db" => "dist/geo/geo.db", "tables" => array("geo_cities","geo_countries","geo_continents")),
  "dist.modelrailway" => array("db" => "dist/modelrailway/modelrailway.db", "tables" => array("mr_gauge","mr_categories")),
  "dist.people" => array("db" => "dist/people/people.db", "tables" => array("people")),
  "dist.publications" => array("db" => "dist/publications/publications.db", "tables" => array("conferences", "events", "journals", "publications")),
  "dist.publications.entrytypes" => array("db" => "dist/publications/entrytypes/entrytypes.db", "tables" => array("entrytypes")),
  "dist.units" => array("db" => "dist/units/units.db", "tables" => array("units_prefix_si")),

  "demo.gallery" => array("db" => "demo/gallery/gallery.db", "tables" => array("gallery_fotos","gallery_fotos_collections")),
  "demo.menu" => array("db" => "demo/menu/menu.db", "tables" => array("menu")),
);

$repo_dbs=array(
  "core" => array("db" => "core/core.db"),
  "core.default" => array("db" => "core/default/core.default.db"),
  "core.encoding" => array("db" => "core/encoding/core.encoding.db"),
  "core.http" => array("db" => "core/http/core.http.db"),
  "core.mime" => array("db" => "core/mime/core.mime.db"),
  "core.request" => array("db" => "core/request/core.request.db"),
  "core.skbinfo" => array("db" => "core/skbinfo/core.skbinfo.db"),

  "dist.acronyms" => array("db" => "dist/acronyms/dist.acronyms.db"),
  "dist.affiliations" => array("db" => "dist/affiliations/dist.affiliations.db"),
  "dist.collections" => array("db" => "dist/collections/dist.collections.db"),
  "dist.content" => array("db" => "dist/content/dist.content.db"),
  "dist.content.paper" => array("db" => "dist/content/paper/dist.content.paper.db"),
  "dist.currencies" => array("db" => "dist/currencies/dist.currencies.db"),
  "dist.date" => array("db" => "dist/date/dist.date.db"),
  "dist.formselect" => array("db" => "dist/formselect/dist.formselect.db"),
  "dist.gallery" => array("db" => "dist/gallery/dist.gallery.db"),
  "dist.geo" => array("db" => "dist/geo/dist.geo.db"),
  "dist.graph" => array("db" => "dist/graph/dist.graph.db"),
  "dist.htmlpage" => array("db" => "dist/htmlpage/dist.htmlpage.db"),
  "dist.menu" => array("db" => "dist/menu/dist.menu.db"),
  "dist.modelrailway" => array("db" => "dist/modelrailway/dist.modelrailway.db"),
  "dist.people" => array("db" => "dist/people/dist.people.db"),
  "dist.prevnext" => array("db" => "dist/prevnext/dist.prevnext.db", "tables" => array("pkg_fields", "pkg_rabit", "pkg_request")),
  "dist.publications" => array("db" => "dist/publications/dist.publications.db"),
  "dist.units" => array("db" => "dist/units/dist.units.db"),

  "demo.htmlpage" => array("db" => "demo/htmlpage/demo.htmlpage.db"),
);

echo "skb: building dal files for core, dist and demo from DB\n";
$output=array();
build_data();
build_tables();
build_repo();
output();

function build_data(){
  global $output, $data_tables, $skb_main;
  echo "skb: convert database to DAL\n";

  $_keys=array_keys($data_tables);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    echo "     -> for {$_keys[$i]}\n";
    $db_file=$skb_main->configuration->get_group("path", "database").$data_tables[$_keys[$i]]['db'];
    $o=new Util_PDOConnect($db_file);
    $pdo=$o->pdo;

    $collect="    data{\n";
  
    $ar=$data_tables[$_keys[$i]]['tables'];
    foreach ($ar as &$tab) {
      $sth=$pdo->prepare("SELECT * from {$tab}");
      if(!is_object($sth))
        continue;
      $sth->execute();
  
      while($row=$sth->fetch(PDO::FETCH_ASSOC)){
      	$_keysRow=array_keys($row);
        $_sizeRow=count($_keysRow);
        $collect.="        table {$tab}";
        for($r=0;$r<$_sizeRow;$r++)
          $collect.=' {'.$_keysRow[$r].' "'.str_replace('"','\\"',$row[$_keysRow[$r]]).'"}';
        $collect.="\n";
      }
    }
    $collect.="    }\n";
    if(!isset($output[$_keys[$i]]))
      $output[$_keys[$i]]=array();
    $output[$_keys[$i]]['data']=$collect;
  }
}

function build_tables(){
  global $output, $data_tables, $skb_main;
  echo "skb: get table information\n";

  $_keys=array_keys($data_tables);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    echo "     -> for {$_keys[$i]}\n";
    $db_file=$skb_main->configuration->get_group("path", "database").$data_tables[$_keys[$i]]['db'];
    $o=new Util_PDOConnect($db_file);
    $pdo=$o->pdo;

    $collect="";
  
    $ar=$data_tables[$_keys[$i]]['tables'];
    foreach ($ar as &$tab) {
      $sth=$pdo->prepare("SELECT * from {$tab}");
      if(!is_object($sth))
        continue;
      $sth->execute();

      $sequence=array();
      $collect.="    table {$tab}{\n";

      $colcount = $sth->columnCount();
      for($k=0;$k<$colcount;$k++){
        $cmd=$sth->getColumnMeta($k);
        $sequence[]=$cmd['name'];
        $collect.="        field {$cmd['name']}";

        $type=get_field_type($cmd['sqlite:decl_type']);
        $collect.=" ".$type;
        
        if($cmd['name']=="key")
          $collect.=" primkey(abort) notnull(abort) unique(abort)";
        $collect.=";\n";
      }

      $collect.="\n        sequence{".implode(",",$sequence)."}\n";
      $collect.="    }\n\n";
    }
    if(!isset($output[$_keys[$i]]))
      $output[$_keys[$i]]=array();
    $output[$_keys[$i]]['tables']=$collect;
  }
}

function get_field_type($tab){
  $ret="";
  switch($tab){
    case "TEXT":
        $ret="string";
        break;
    case "INTEGER":
        $ret="integer";
        break;
    case "BOOLEAN":
        $ret="boolean";
        break;
    default:
        $ret=get_field_type(substr($tab,0,strpos($tab, "(")));
        $pr=substr($tab,strpos($tab, "("));
        $pr=substr($pr,1,strlen($pr)-2);
        $pr=explode(",",$pr);
        if(isset($pr[0]))
          $ret.=" size({$pr[0]})";
        if(isset($pr[1]))
          $ret.=" precision({$pr[1]})";
  }
  return $ret;
}

function build_repo(){
  global $repo_dbs, $skb_main, $output;
  $repo_tables=array("pkg_fields", "pkg_rabit", "pkg_request", "pkg_http_headers_response", "pkg_mime_content_types");

  echo "skb: building repository information\n";

  $_keys=array_keys($repo_dbs);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    echo "     -> for {$_keys[$i]}\n";
  
    $db_file=$skb_main->configuration->get_group("path", "repository").$repo_dbs[$_keys[$i]]['db'];
    $o=new Util_PDOConnect($db_file);
    $pdo=$o->pdo;
  
    $collect="    repository skb.core{\n";
  
    foreach ($repo_tables as &$tab) {
      $sth=$pdo->prepare("SELECT * from {$tab}");
      if(!is_object($sth))
        continue;
      $sth->execute();
  
      $collect.="        table {$tab}{\n";
      while($row=$sth->fetch(PDO::FETCH_ASSOC)){
      	$_keysRow=array_keys($row);
        $_sizeRow=count($_keysRow);
  
        for($r=0;$r<$_sizeRow;$r++){
          if($_keysRow[$r]=="key")
            $collect.='            row '.$row[$_keysRow[$r]]."\n";
          $collect.='                '.$_keysRow[$r].' = "'.str_replace('"','\\"',$row[$_keysRow[$r]]).'"'."\n";
        }
        $collect.="                ;\n";
      }
      $collect.="        }\n\n";
    }
    $collect.="    }\n";
    if(!isset($output[$_keys[$i]]))
      $output[$_keys[$i]]=array();
    $output[$_keys[$i]]['repos']=$collect;
  }
}

function output(){
  global $output;

  echo "skb: crerating DAL files\n";

  $_keys=array_keys($output);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    echo "     -> for {$_keys[$i]}\n";
    $handle=fopen($_keys[$i].".dal", "wb");

    $name=explode(".", $_keys[$i]);
    for($k=0;$k<count($name);$k++)
      $name[$k]=ucfirst($name[$k]);
    $name=implode(".",$name);  

    fwrite($handle,
"/* Copyright (c) 2011-2011 Sven van der Meer
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
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS  IS\"
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

/*
 * Database and Repository specification for SKB Package {$name}.
 *
 * @package    Packages.{$name}
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.01 build 110309 (09-Mar-11) for DAL v0.01
 */

#include \"../../repository.dal\"

package {$_keys[$i]}{
");
    if(isset($output[$_keys[$i]]['repos']))
      fwrite($handle,$output[$_keys[$i]]['repos']);
    else
      fwrite($handle,"    repository dummy{}\n");
    if(isset($output[$_keys[$i]]['tables']))
      fwrite($handle,$output[$_keys[$i]]['tables']);
    if(isset($output[$_keys[$i]]['data']))
      fwrite($handle,$output[$_keys[$i]]['data']);
    fwrite($handle,"}\n");
    fclose($handle);
  }
}

?>