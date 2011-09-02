<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2007-2011, Sven van der Meer <sven@vandermeer.de>
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
 * Read .ini files from a directory and check for duplicate entries
 *
 * @package    Classes.Util
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Util_IniFile{
	public function read_file($fn){
		$ret=new Util_ArBase();
		$ret->ar=parse_ini_file($fn, true);
		return $ret;
	}


	public function read_dir($dir){
		$mySKB=SKB_Main::get_instance();

		$ret=new Util_ArBase();

		$dir=$dir;
		if(!is_dir($dir))
		  $dir=$mySKB->configuration->getGroup("path","database") . $directory;

		if(is_dir($dir)){
			if($dh=opendir($dir)){
				while(($file=readdir($dh))!==false)
					if($file!=".."&&$file!="."&&$file[0]!="#")
						$ret->ar=array_merge($ret->ar, self::read_File($dir."/".$file)->ar);
				closedir($dh);
			}
		}
		return $ret;
	}


	public function find_duplicates($file){
		$mySKB=SKB_Main::get_instance();
		$file=$mySKB->configuration->getGroup("path","database") . $file;
		$testAr=array();
		$ar=explode("\n", file_get_contents($file));
		$_keys=array_keys($ar);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if(isset($ar[$_keys[$i]][0])&&$ar[$_keys[$i]][0]=="["){
				if(!isset($testAr[$ar[$_keys[$i]]]))
					$testAr[$ar[$_keys[$i]]]=0;
				else
					echo "Found duplicate: {$file}, line $i = {$ar[$_keys[$i]]}\n";
			}
		}
	}
}
?>