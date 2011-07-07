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
 * Implements a simple stack used to identify loops when interpeting SKB data structures
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class SKB_DBScope{
  /**
   * Local instance holder for singleton implementation.
   * @var string
   */
  private static $instance=null;

  /**
   * Local static string to test for initialisation.
   * @var Util_ArType
   */
  private static $cKey="beef";

  /**
   * The local array maintaining all scopes.
   * @var array
   */
  private $scope=array();


  /**
   * The (empty) class constructor, which cannot be called directly since SKB_DBScope is a singleton.
   */
  public function __construct($_c){
    if($_c!=self::$cKey)
      trigger_error("SKB_DBScope: Direct creation of object is not allowed, please use get_instance().", E_USER_ERROR);
    else{
    }
  }


  /**
   * Return the instance of SKB_DBScope (Singleton).
   */
  public static function get_instance(){
    if(null===self::$instance)
      self::$instance=new SKB_DBScope("beef");
    return self::$instance;
  }


  /**
   * Cloning is not allowed, since SKB_Main is a Singleton.
   */
  public function __clone(){
  	trigger_error("SKB_DBScope: Clone is not allowed.", E_USER_ERROR);
  }


  /**
   * Push a scope using key and value.
   * 
   * Internally, the scopes are handled as entries in the local scope array in the form of "$k.'@'.$v".
   * If the given scope does not exist, this functions adds it and returns true. In all other cases it returns false.
   *
   * @param string k key of the scope
   * @param string v value of the scope
   */
  public function push($k,$v){
    if(in_array($k."@".$v,$this->scope))
      return false;
    $this->scope[]=$k."@".$v;
    return true;
  }


  /**
   * Pop a scope from the top of the array.
   * 
   * This function uses array_pop to pop the top scope off the local scope array.
   */
  public function pop(){
  	array_pop($this->scope);
  }


  /**
   * Empty the local scope array.
   */
  public function reset(){
    $this->scope=array();
  }


  /**
   * Return the local scope array as PHP array.
   */
  public function as_array(){
  	return $this->scope;
  }


  /**
   * Return the local scope array as string using implode("->",...).
   */
  public function as_string(){
  	return implode("->",$this->scope);
  }


  /**
   * Return the local scope array as string using implode("->",...).
   */
  public function to_string(){
  	$this->as_string();
  }


  /**
   * Calls as_string and echos the return plus two HTML line breaks.
   */
  public function print_r(){
  	echo $this->as_string()."<br />\n"."<br />\n";
  }
}
?>