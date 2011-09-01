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
 * A simple class that maintains templates for a builder object, and registers css
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class SKB_BuilderTemplates{
  /**
   * The local collection of templates.
   * @var array
   */
  protected $templates=array();


  /**
   * Class constructor (empty).
   */
  public function __construct(){}


  /**
   * Add a template using a name/key pair.
   * 
   * This will create an entry 'name' in the local template array and set the 
   * name/value pair 'key'/key.
   *
   * @param string name name for the template
   * @param key key key for the template
   */
  public function add_template($name, $key){
  	$this->templates[$name]=array("key"=>$key);
  }


  /**
   * Add CSS and Mime Content type information of registered templates to the global SKB configuration.
   * 
   * This function will add the CSS and Mime Content Type information of each of the registered templates to
   * the global SKB configuration, which in turn will help to automatically load CSS in HTML page headers and 
   * to process Mime Content Types when using REST access.
   */
  public function set_header(){
    $mySKB=SKB_Main::get_instance();

    $_keys=array_keys($this->templates);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
    	$tpl=$mySKB->get_registered_templates_by_key($this->templates[$_keys[$i]]['key']);
    	if(isset($tpl['core:rabit:css'])&&Util_Interpreter::interpret("value:is_empty", $tpl['core:rabit:css'])==false)
    	  $mySKB->configuration->add_2_comma("header","std-css",$tpl['core:rabit:css']);
    	if(isset($tpl['core:rabit:mime_out'])&&Util_Interpreter::interpret("value:is_empty", $tpl['core:rabit:mime_out'])==false){
    	  $mySKB->configuration->add_2_comma("header","content-type",$tpl['core:rabit:mime_out']);
    	}
    }
  }


  /**
   * Return a template object for the given template key.
   * 
   * This function will create and return an object Util_Template for the given tempalte 'key', or -1 if the key
   * does not exist.
   *
   * @param key key key of the template
   */
  public function get_template_object($key){
  	if(isset($this->templates[$key])){
  		$mySKB=SKB_Main::get_instance();
  		$target=$mySKB->configuration->get_group("skb","target");
  		$targetpref=$mySKB->configuration->get_group("skb","targetpref");
  		$tpl=$mySKB->get_registered_templates_by_key($this->templates[$key]['key']);
  	  return new Util_Template($mySKB->configuration->get_group("path","targets") . $targetpref . $target . "/" . $tpl['core:rabit:target:template'][$target] . ".tpl");
  	}
  	else
  	  return -1;
  }


  /**
   * Return a path of the template for the given template key.
   * 
   * This function will return the path to the actual template for the given tempalte 'key', or -1 if the key
   * does not exist.
   *
   * @param key key key of the template
   */
  public function get_template_path($key){
  	if(isset($this->templates[$key])){
  		$mySKB=SKB_Main::get_instance();
  		$target=$mySKB->configuration->get_group("skb","target");
  		$targetpref=$mySKB->configuration->get_group("skb","targetpref");
  		$tpl=$mySKB->get_registered_templates_by_key($this->templates[$key]['key']);
  	  return $mySKB->configuration->get_group("path","targets") . $targetpref . $target .  "/" . $tpl['core:rabit:target:template'][$target] . ".tpl";
  	}
  	else
  	  return -1;
  }
}
?>