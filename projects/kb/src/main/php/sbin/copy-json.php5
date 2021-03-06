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
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

$site_id="demo";
$site_path="/www/demo";
require_once "/dev/projects/skb/skb-git/htdocs/skb/classes/main.inc.php5";

$tinos_home="v:/dev/projects/skb/skb-git";

//$skb_main->load_all_site_packages();

$output=array();

$dir="v:/dev/projects/skb/skb-git/projects/kb/target/base/";
copy_json($dir);

function copy_json($dir){
  $dir_repo=$dir."/skb/skb/repository";
  $dir_target="";
  $file_target="";

  $files=array();
  if(is_dir($dir."/json")){
    if($dh=opendir($dir."/json")){
      while(($file=readdir($dh))!==false){
        if($file!=".."&&$file!="."&&$file[0]!="#"){
          $files[]=$file;
        }
      }
      closedir($dh);
    }

    foreach ($files as &$file){
      $file_target=$file;
      $dir_target=$dir_repo."/".str_replace(".", "/", str_replace(".json", "", $file))."/";

      if(!is_dir($dir_target))
        mkdir($dir_target, 0755, true);
      copy($dir."json/".$file, $dir_target.$file_target);
    }
  }
}
?>