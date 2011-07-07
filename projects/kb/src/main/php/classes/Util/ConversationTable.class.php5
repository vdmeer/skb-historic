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
 * Class for maintaining and providing access to text conversion tables.
 *
 * @package    Classes.Util
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class Util_ConversationTable{

  private static $instance=null;
  private static $cKey="beef";

  public $configuration=null;

  public $ar_natsort=array();
  public $ar_h2l=array();
  public $ar_h2t=array();

  /**
   * The class constructor -> this implementation is a singleton, please use get_instance().
   */
  public function __construct($_c){
    if($_c!=self::$cKey)
      trigger_error('Util_ConversationTable: Direct creation of object is not allowed, please use get_instance().', E_USER_ERROR);
  }

  /**
   * Singleton implementation for retrieving an instance of the class.
   *
   * This class is implemented as a singleton, thus this function will return a pointer to the single 
   * available instance. This avoids unecessary re-loading of convertion tables at runtime.
   */
  public static function get_instance(){
    if(null===self::$instance)
      self::$instance=new Util_ConversationTable("beef");
    return self::$instance;
  }

  /**
   * Overwrite the standard clone function to allow true singleton implementation.
   *
   * Cloning of this class is not allowed, clone will trigger an E_USER_ERROR.
   */
  public function __clone(){trigger_error('Util_ConversationTable: Clone is not allowed.', E_USER_ERROR);}

  /**
   * Return an array that can be used for character replacements.
   *
   * This function returns an array that has two sub-arrays: one holding patterns for replacements ("pattern")
   * and the other one holding replacements ("replace"). In short, this function uses the package Core.Encoding 
   * to create these two arrays using the information in the field 'core:encoding:natsort'. If this field is set,
   * then its content will be used as replacement ("replace") and the entries in the fields 'core:encoding:text',
   * 'core:encoding:html' and 'core:encoding:ascii7' as patterns ("pattern").
   *
   * <br /><br /><b>Note: This function is not optimised and re-initialises the arrays for every call</b>
   */
  public function get_i18n_arrays($lang){
  	if(count($this->ar_natsort)<1){
  		$mySKB=SKB_Main::get_instance();
    	$req=$mySKB->get_request("Core.Encoding");
    	$req->init_plain();
    	$req->activate();
    	$red=$mySKB->get_reader("Core.Encoding.DB2Entries");
    	$red->set_builder($mySKB->get_builder("Core.Encoding.Entries2Entries"));
    	$red->prepare($req);
    	$ctab=$red->get_entries()->ar;

      $ar_tmp=array();
    	$_keys=array_keys($ctab);
    	$_size=count($_keys);
  	  for($i=0;$i<$_size;$i++){
  	  	if(isset($ctab[$_keys[$i]]['core:encoding:natsort'])){
  	  		if(!isset($ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']]))
  	  		  $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']]=array();

          if(isset($ctab[$_keys[$i]]['core:encoding:text']))
            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$this->escape_preg($ctab[$_keys[$i]]['core:encoding:text']);
          if(isset($ctab[$_keys[$i]]['core:encoding:html']))
            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$this->escape_preg($ctab[$_keys[$i]]['core:encoding:html']);
          if(isset($ctab[$_keys[$i]]['core:encoding:ascii7']))
            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$this->escape_preg($ctab[$_keys[$i]]['core:encoding:ascii7']);
//          if(isset($ctab[$_keys[$i]]['core:encoding:utf8']))
//            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$ctab[$_keys[$i]]['core:encoding:utf8'];
//          if(isset($ctab[$_keys[$i]]['core:encoding:latex']))
//            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$ctab[$_keys[$i]]['core:encoding:latex'];
//          if(isset($ctab[$_keys[$i]]['core:encoding:latex:skb']))
//            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$ctab[$_keys[$i]]['core:encoding:latex:skb'];
//          if(isset($ctab[$_keys[$i]]['core:encoding:asciidoc']))
//            $ar_tmp[$ctab[$_keys[$i]]['core:encoding:natsort']][]=$ctab[$_keys[$i]]['core:encoding:asciidoc'];

  	  	}
  	  }
    	$_keys=array_keys($ar_tmp);
    	$_size=count($_keys);
	    for($i=0;$i<$_size;$i++){
	    	$this->ar_natsort['pattern'][]="/" . mb_convert_encoding(implode("|", array_unique($ar_tmp[$_keys[$i]])), "UTF-8", "auto") . "/";
	    	$this->ar_natsort['replace'][]=$_keys[$i];

        //cho mb_convert_encoding(implode("|", array_unique($ar_tmp[$_keys[$i]])), "UTF-8", "auto");
        //echo mb_internal_encoding() . " --   ";
        //echo mb_detect_encoding("/" . implode("|", array_unique($ar_tmp[$_keys[$i]])) . "/")."\n";
      }
  	}

    return new Util_ArBase(array("pattern"=>$this->ar_natsort['pattern'],"replace"=>$this->ar_natsort['replace']));
  }

  private function escape_preg($c){
  	switch($c){
  		case "\\": $c="\\" ;break;
  		case "^":  $c="\^" ;break;
  		case "$":  $c="\$" ;break;
  		case ".":  $c="\." ;break;
  		case "[":  $c="\[" ;break;
  		case "]":  $c="\]" ;break;
  		case "|":  $c="\|" ;break;
  		case "(":  $c="\(" ;break;
  		case ")":  $c="\)" ;break;
  		case "?":  $c="\?" ;break;
  		case "*":  $c="\*" ;break;
  		case "+":  $c="\+" ;break;
  		case "{":  $c="\{" ;break;
  		case "}":  $c="\}" ;break;
  		case "/":  $c="\/" ;break;
  	}
    return $c;
  }

  public function get_h2l_arrays(){
  	if(count($this->ar_h2l)==0){
  		$mySKB=SKB_Main::get_instance();
    	$req=$mySKB->get_request("Core.Encoding");
    	$req->init_plain();
    	$req->activate();
    	$req->set_value("default:source","h");
    	$req->set_value("default:target","l");
    	$red=$mySKB->get_reader("Core.Encoding.DB2Entries");
    	$bui=$mySKB->get_builder("Core.Encoding.Entries2Entries");
    	$red->set_builder($bui);
    	$red->prepare($req);
    	$this->ar_h2l=$red->get_entries()->ar;
      ksort($this->ar_h2l);
    }
  	return $this->ar_h2l;
  }

  public function get_h2t_arrays(){
  	if(count($this->ar_h2t)==0){
  		$mySKB=SKB_Main::get_instance();
    	$req=$mySKB->get_request("Core.Encoding");
    	$req->init_plain();
    	$req->activate();
    	$req->set_value("default:source","h");
    	$req->set_value("default:target","t");
    	$red=$mySKB->get_reader("Core.Encoding.DB2Entries");
    	$bui=$mySKB->get_builder("Core.Encoding.Entries2Entries");
    	$red->set_builder($bui);
    	$red->prepare($req);
    	$this->ar_h2t=$red->get_entries()->ar;
      ksort($this->ar_h2t);
    }
  	return $this->ar_h2t;
  }


}
?>