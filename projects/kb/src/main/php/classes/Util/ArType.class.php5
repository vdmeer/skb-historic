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
 * Provides access to an associative array using key/value pairs, originally written to parse .ini files.
 *
 * @package    Classes.Util
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Util_ArType{
  protected $ar;

  /**
   * Constructor.
   *
   * Sets the internal array to $ar or initialises it as a new empty array.
   * @param array $ar initial array.
   */
  public function __construct($ar=false){
  	if($ar&&is_array($ar))
  	  $this->ar=$ar;
  	else
  	  $this->ar=array();
  }

  /**
   * Overwrite the internal array.
   *
   * Replaces the internal array with $ar, if $ar is an array, otherwise empties the local array.
   * @param array $ar array.
   */

  protected function set_array($ar){
    if(!is_array($ar))
      $this->ar=array();
    else
      $this->ar=$ar;
  }

  /**
   * Merge the internal array with the given parameter.
   *
   * If both, the local array and the $ar are arrays it calls array_merge. Otherwise it does nothing.
   * @param array $ar array to be merged.
   */
  public function merge_array($ar){
    if(is_array($ar)&&is_array($this->ar))
      $this->ar=array_merge($this->ar,$ar);
  }

  /**
   * Set the value for a key.
   *
   * This function firsts tests $key and then calls a private function _set for setting
   * the given values. The four options for $key are:
   * <ul>
   *   <li>$key is an array - then we call _set for each member of the array, $val is ignored in that case</li>
   *   <li>$key is a non-empty string - then we simply call _set with $key and $val</li>
   *   <li>$key is an integer - then we simply call _set with $key and $val</li>
   *   <li>all other cases - return -1</li>
   * <ul>
   * The private function _set then takes $key and $val as parameters and tests first of $key exists in the local 
   * array; if not, it does nothing. If $key exists, then it tests if a value map (vmap exists). Does vmap exist and $key 
   * is part of it, the value $val is set. Does vmap exist and $key is not part of it nothing happens. Does vmap not exist, then 
   * it simply sets the new value $val.
   * @param mixed $key the key, can be an array of keys or a string
   * @param mixed $val the value
   */
  public function set($key, $val=""){
    if(is_array($key)){
      while(list($k, $v) = each($key))
        $this->_set($k,$v);
    }
    else if(is_string($key)&&$key!=""){
      $this->_set($key, $val);
    }
    else if(is_int($key))
      $this->_set($key, $val);
    else
      return -1;
  }

  /** @ignore */
  private function _set($key, $val){
    if(array_key_exists($key,$this->ar)){
      if(isset($this->ar[$key]["vmap"],$this->ar)){
        if(in_array($val,$this->ar[$key]["vmap"]))
          $this->ar[$key]["value"]=$val;
      }
      else
        $this->ar[$key]["value"]=$val;
    }
  }

  /**
   * Add a new key/value pair.
   *
   * This function will add $key with $val to the array. If $key already exists, nothing will be done.
   * If $key is an array, every single member of $key will be added as a key/value and $val is ignored.
   *
   * @param mixed $key the key, can be an array of keys or a string
   * @param mixed $val the value
   */
  public function add($key, $val=""){
    if(is_array($key))
      while(list($k, $v) = each($key))
        $this->_add($k,$v);
    else
  	  $this->_add($key, $val);

  }

  /** @ignore */
  private function _add($key, $val){
  	if(!array_key_exists($key,$this->ar))
  	  $this->ar[$key]=$val;
  }

  /**
   * Add a string to an existing value identified by two keys.
   *
   * This function will, if $key[$key2] exists, add ",".$val to the existing value.
   *
   * @param string $key1 first key to look for
   * @param string $key2 second key to look for
   * @param string $val value to be added to the existing value
   */
  public function add_2_comma($key1, $key2, $val){
  	if(array_key_exists($key1,$this->ar)){
  		if(array_key_exists($key2,$this->ar[$key1])){
				$this->ar[$key1][$key2].=Util_Interpreter::interpret("add:char:comma", $this->ar[$key1][$key2]);
				$this->ar[$key1][$key2].=$val;
  		}
  	}
  }

  /**
   * Change the value identified by two keys to the given value.
   *
   * This function will, if $key[$key2] exists, overwrite the current value with the given value.
   *
   * @param string $key1 first key to look for
   * @param string $key2 second key to look for
   * @param mixed $val new value
   */
  public function set_2_array($key1, $key2, $val){
  	if(array_key_exists($key1,$this->ar)&&is_array($this->ar[$key1]))
			$this->ar[$key1][$key2]=$val;
  }

  /**
   * Retrieve information from the local array.
   *
   * @param string $key the optional key
   * @return mixed returns complete local array ($key==""), the value for $key (if $key exists) or -1
   */
  public function get($key=""){
  	if($key=="")
  	  return $this->ar;
  	else if(array_key_exists($key,$this->ar)){
      if(is_array($this->ar[$key])&&isset($this->ar[$key]["value"]))
        return $this->ar[$key]["value"];
      else
        return $this->ar[$key];
    }
    return -1;
  }

  /**
   * Returns an array with the keys of the local array using array_keys.
   *
   * @return array array of key
   */
  public function keys(){
  	return array_keys($this->ar);
  }

  public function get_group($group, $key=""){
    if($key==""&&array_key_exists($group,$this->ar))
      return $this->ar[$group];
    else if(array_key_exists($group,$this->ar)){
      if(array_key_exists($key,$this->ar[$group])){
        if(is_array($this->ar[$group][$key])&&isset($this->ar[$group][$key]["value"]))
          return $this->ar[$group][$key]["value"];
        else
          return $this->ar[$group][$key];
      }
    }
    return -1;
  }

  public function trim(){
  	array_walk_recursive($this->ar, create_function('&$v','$v=trim($v," ".chr(0xA0));'));
  }
}

?>