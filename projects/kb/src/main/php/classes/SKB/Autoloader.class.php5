<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2009-2011, Sven van der Meer <sven@vandermeer.de>
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
 * A simple autoloader class that loads either from class directory or rabit directory (using two different naming schemes)
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class SKB_Autoloader{
	/**
	 * The (empty) class constructor.
	 */
	public function __construct(){}


	/**
	 * The autoload call back function.
	 *
	 * This is the main function of the auoloader. The SKB main.inc file will tell PHP to use this function for loading 
	 * classes by calling:
	 * <br />&#160;&#160;&#160;&#160;<code>function __autoload($class){SKB_Autoloader::autoload($class);}</code><br />
	 *
	 * This function checks first of a class file with the given name exists, and loads it on success using require_once. If it 
	 * does not exist, then it checks for an interface file and loads it on success using require_once. If neither class nor 
	 * interface file exist it will throw a user error.
	 *
	 * Since the SKB has to load its own classes and interfaces plus the classes/interfaces registered by SKB packages and of 
	 * course user defined classes/interfaces, the class name provided by $class must adhere to the SKB class naming conventions.
	 * First, package classe names must start with the string "pkg_". All other class names must not start with this string.
	 *
	 * General file naming conventions:
	 * <ul>
	 *   <li>All files must end on ".php5." or the configured PHP file extension</li>
	 *   <li>All class files must have the character sequence ".class" between their name and the file extension</li>
	 *   <li>All interface files must have the character sequence ".interface" between their name and the file extension</li>
	 * </ul>
	 *
	 * For package class names, the following additional naming rules apply:
	 * <ul>
	 *   <li>The name contains directory and file name information separated by three underscores: "___"</li>
	 *   <li>In the directory part, the sub-directories are separated using two underscores: "__". They will be translated in the file separator character "/"</li>
	 *   <li>In the directory part, single underscore characters "_" will be translated into the dash charachter "-"</li>
	 *   <li>In the file name part, all triple underscores "___" will be translated into the dot character "."</li>
	 *   <li>In the file name part, the first occurance of a double underscore "__" will be translated into two dash characters "--"</li>
	 *   <li>In the file name part, the second occurance of a double underscore "__" will be translated into a single plus character "+"</li>
	 *   <li>In the file name part, finally, all remaining underscore charactes "_" will be translated into a single dash character for each of them "-"</li>
	 * </ul>
	 * For example, the core interpreter class for URN transformation of the SKB has the name: pkg_core___urn___interpreter. This name will be translated into
	 * the following search for a filename containing the class: [package_dir]/core/urn.interpreter.class.php5. A more complex example is the 
	 * builder for XHTML tables in the package SKBInfo. The class name: "pkg_core__skbinfo___application__xhtml__table___builder" will be translated into the 
	 * file name: [package_dir]/core/skbinfo/application--xhtml+table.builder.class.php5.
	 * As you can see, the naming convention leads to rather long and cryptic class names yet allows to code the MIME Content Type into the file name, which makes
	 * programming (hopefully) a little bit easier. Please note: an end-user (programmer using the SKB) will never see the actual class name, but use the functions 
	 * provided in SKB main to initialise package objects.
	 *
	 * For all other class names, which should be found in the class path, the following addtional rules apply:
	 * <ul>
	 *  <li>Any allowed PHP character can be part of the class name.</li>
	 *  <li>The class name may contain underscore characters, which will be automatically translated into the file separator character "/".</li>
	 * </ul>
	 * For instance, the name of this auto loader class is "SKB_Autoloader", which will be translated into the file name: [class_path]/SKB/Autoloader.class.php5.
	 *
	 * @param string class class or interface name to be loaded.
	 */
	public static function autoload($class){
		$ar=self::_get_path($class);
		if(file_exists($ar['path'].$ar['class']))
			require_once($ar['path'].$ar['class']);
		elseif(file_exists($ar['path'].$ar['interface']))
			require_once($ar['path'].$ar['interface']);
		if(!class_exists($class, false)&&!interface_exists($class, false)){
			$cr=isset($_SERVER["REQUEST_URI"])?"<br />\n":"\n";
			trigger_error("SKB Autoloader: unable to load class/interface{$cr} #  $class{$cr} # from {$ar['class']}{$cr} == ", E_USER_ERROR);
		}
	}


	/**
	 * Parse the class/interface name and return the generated path.
	 *
	 * This function will parse the given class/interface name of $class according to the SKB naming rules and return the resulting
	 * file name (including directories) if the corrersponding file exists, -1 otherwise.
	 *
	 * @param string class name of the class/interface.
	 */
	public static function get_path($class){
		$ar=self::_get_path($class);
		if(file_exists($ar['path'].$ar['class']))
			return $ar['path'].$ar['class'];
		elseif(file_exists($ar['path'].$ar['interface']))
			return $ar['path'].$ar['interface'];
		return -1;
	}


	/**
	 * Parse the class/interface name and return the generated path in an abbreviated form.
	 *
	 * This function will parse the given class/interface name of $class according to the SKB naming rules and return the resulting
	 * file name (including directories) in an abbreviated form if the corrersponding file exists, -1 otherwise. Abbreviation means that 
	 * the actual class path or package path will be shortend to the string "[class_path]" and "[package_path]", respectively.
	 *
	 * @param string class name of the class/interface.
	 */
	public static function get_path_abbreviated($class){
		$ar=self::_get_path($class);
		if(file_exists($ar['path'].$ar['class']))
			return $ar['path_text'].$ar['class'];
		elseif(file_exists($ar['path'].$ar['interface']))
			return $ar['path_text'].$ar['interface'];
		return -1;
	}


	/**
	 * Private function implementing the naming convention and class/interface name parsing.
	 *
	 * @ignore
	 */
	private static function _get_path($class){
		$packages_dir="";
		$class_path="";
		$php_extension=".php5";
	
		global $skb_loaded;
		if($skb_loaded==false){
			global $__cfg_array;
			$class_path=$__cfg_array["root-document"].$__cfg_array["root-skb"].$__cfg_array["root-classes"];
			$php_extension=$__cfg_array["php_extension"];
		}
		else{
			$mySKB=SKB_Main::get_instance();
			$packages_dir=$mySKB->configuration->get_group("path","targets").$mySKB->configuration->get_group("skb","targetpref").$mySKB->configuration->get_group("skb","target")."/";
			$class_path=$mySKB->configuration->get_group("path","classes");
			$php_extension=".".$mySKB->configuration->get_group("php","extension");
		}
	
		$class_file=$class.$php_extension;
		$interface_file=$class.$php_extension;
	
		if(strpos($class,"pkg_")!==false){
			$exp=explode("pkg_",$class);
			//directory up to first '___', rest is filename
			$dir=substr($exp[1],0,strpos($exp[1],"___"));
			$dir=str_replace("__", "/", $dir);
			$dir=str_replace("_", "-", $dir);
			$dir.="/";
			
			//file starts after first "___"
			$file=substr($class,strpos($class,"___")+3);
			$file=str_replace("___", ".", $file);
			//first '__' is '--'
			if(strpos($file,"__")!==false)
				$file=substr_replace($file,"--",strpos($file,"__"), 2);
			//second '__' is '+'
			if(strpos($file,"__")!==false)
				$file=substr_replace($file,"+",strpos($file,"__"), 2);
			$file=str_replace("_", "-", $file);
			
			$path=$packages_dir;
			$path_text="[targets_path]/";
			$class_file=$dir . $file . ".class" . $php_extension;
			$interface_file=$dir . $file . ".interface" . $php_extension;
		}
		elseif(strpos($class,"_")!==false){
			$fn=str_replace("_", "/", $class);
			$dir=substr($fn,0,strrpos($fn,"/")+1);
			$file=substr($fn,strrpos($fn,"/")+1);
			
			$path=$class_path;
			$path_text="[class_path]";
			
			$class_file=$dir . $file . ".class" . $php_extension;
			$interface_file=$dir . $file . ".interface" . $php_extension;
		}
		return array("path"=>$path,"path_text"=>$path_text,"class"=>$class_file,"interface"=>$interface_file);
	}
}
?>