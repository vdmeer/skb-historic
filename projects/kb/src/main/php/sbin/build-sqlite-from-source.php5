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
 * Tool that executes SQL statements on an SQLite 3 database
 *
 * @package    SKB sbin
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2002-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

$site_id="demo";
$site_path="/www/demo";
require_once "/dev/projects/skb/skb-git/htdocs/skb/classes/main.inc.php5";

$tinos_home="v:/dev/projects/skb/skb-git";

//$skb_main->load_all_site_packages();

echo "skb: building SQLite databases from SQL files\n";
$output=array();

$dir="v:/dev/projects/skb/skb-git/projects/kb/target/base/";
build_packages($dir);
create_structure($dir);

function build_packages($dir){
  global $skb_main;
  echo "skb: building packages\n";

  if(!is_dir($dir))
    return;

  $files=array();
  $sql_files=array();
  if(is_dir($dir."/sql")){
    if($dh=opendir($dir."sql")){
      while(($file=readdir($dh))!==false){
        if($file!=".."&&$file!="."&&$file[0]!="#"){
          $files[]=$file;
          $sql_files[]=$dir."/sql/".$file;
        }
      }
      closedir($dh);
    }
  }

  if(!is_dir($dir."/db-sqlite"))
    mkdir($dir."/db-sqlite");

  $db_file;
  $_keys=array_keys($files);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    $file=$files[$_keys[$i]];
    $file=str_replace(".sql","",$file);
    echo "--> ".$file."\n";

    $db_file=$dir."/db-sqlite/".$file.".db";
    $o=new Util_PDOConnect($db_file);
    $pdo=$o->pdo;
    $sql_statements=file($sql_files[$_keys[$i]]);
    foreach ($sql_statements as &$st){
      if(strpos($st,"/* ")===false&&strpos($st," * ")===false&&strpos($st," * ")===false&&strpos($st," */")===false){
        $sth=$pdo->prepare($st);
        if(!is_object($sth))
          echo " SQL statement error: {$st}\n";
        else
          $sth->execute();
      }
    }
  }
}

function create_structure($dir){
  //$dir=$mySKB->configuration->getGroup("path","database") . $directory;

  $dir_repo=$dir."/skb/skb/repository";
  $dir_cfg=$dir."/skb/skb/config";
  $dir_data=$dir."/skb/database";
  $dir_target="";
  $file_target="";
  $dir_add="";

  $files=array();
  if(is_dir($dir."/db-sqlite")){
    echo "\ncreating SKB structure\n";
    if($dh=opendir($dir."/db-sqlite")){
      while(($file=readdir($dh))!==false){
        if($file!=".."&&$file!="."&&$file[0]!="#"){
          $files[]=$file;
        }
      }
      closedir($dh);
    }

    foreach ($files as &$file){
      if(strpos($file,"-repo.db")!==false){
        $file_target=str_replace("-repo.db", ".db", $file);
        $dir_target=$dir_repo."/".str_replace(".", "/", str_replace(".db", "", $file_target))."/";
      }
      elseif(strpos($file,"config-")!==false){
        $file_target=str_replace("config-", "", $file);
        $dir_target=$dir_cfg."/";
      }
      else{
        $dir_target=$dir_data."/".str_replace(".", "/", str_replace(".db", "", $file))."/";
        $file_target=str_replace(".db", "", $file);
        $file_target=substr($file_target, strrpos($file_target,".")+1, strlen($file_target));
        $file_target=$file_target.".db";
      }

      if(!is_dir($dir_target))
        mkdir($dir_target, 0755, true);
      copy($dir."db-sqlite/".$file, $dir_target.$file_target);
    }
  }
}
?>