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
 * The SKB Request object, used to paramerise readers and builders.
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class SKB_Request{
	/**
	 * Boolean to determine if the request is initialised or not.
	 * @var isInitialised
	 */
	protected $isInitialised=false;


	/**
	 * Map for initialisation.
	 * @var init_map
	 */
	protected $init_map=array();

	/**
	 * Array for core initialisation using HTTP request values.
	 * @var core_ar_http
	 */

	protected $core_ar_http=array();
	/**
	 * Array for core initialisation using common request values.
	 * @var core_ar_plain
	 */
	protected $core_ar_plain=array();


	/**
	 * The class constructor.
	 *
	 * It will take the type, if given, to use SKB data for the initialisation. If type is not provided, a
	 * user error will be thrown.
	 *
	 * @param string type the SKB identifier for request data used in the initialisation.
	 */
	function __construct($type=null){
		if($type!=null){
			$mySKB=SKB_Main::get_instance();
			$row=$mySKB->get_registered_requests_by_key($type);
			if($row==-1)
				trigger_error("SKB_Request: no reqyest type of '{$type}' found", E_USER_ERROR);

			$this->init_map=$row;
			if(isset($this->init_map['core:requests:fields']))
				$this->init_map['core:requests:fields']=$this->_explodeFields($this->init_map['core:requests:fields']);
			else
				$this->init_map['core:requests:fields']=array();
			if(isset($this->init_map['core:requests:formselect_fields']))
				$this->init_map['core:requests:formselect_fields']=$this->_explodeFields($this->init_map['core:requests:formselect_fields']);
			else
				$this->init_map['core:requests:formselect_fields']=array();

			if(!isset($this->init_map['core:requests:table']))
				$this->init_map['core:requests:table']=null;
			if(!isset($this->init_map['core:requests:table_collections']))
				$this->init_map['core:requests:table_collections']=null;
			if(!isset($this->init_map['core:requests:filter']))
				$this->init_map['core:requests:filter']=null;
			if(!isset($this->init_map['core:requests:package']))
				$this->init_map['core:requests:package']=null;

			$_keys=array_keys($this->init_map['core:requests:fields']);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++){
				$eRow=$mySKB->get_registered__fields_by_key($_keys[$i]);

				if(strpos($eRow['core:use'],'request')===false){
					unset($this->init_map['core:requests:fields'][$eRow['key']]);
				}
				else{
					$tmp=$this->init_map['core:requests:fields'][$eRow['key']];
					$this->init_map['core:requests:fields'][$eRow['key']]=$eRow;
					$this->init_map['core:requests:fields'][$eRow['key']]['request']=$tmp;

					$this->init_map['core:requests:fields'][$eRow['key']]['value']=null;

					$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']=array();

					if($this->init_map['core:requests:fields'][$eRow['key']]['core:val_unset']!=null)
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['core:val_unset']=$this->_set($this->init_map['core:requests:fields'][$eRow['key']]['core:val_unset']);

					if(isset($this->init_map['core:requests:fields'][$eRow['key']]['core:val_do_list'])&&$this->init_map['core:requests:fields'][$eRow['key']]['core:val_do_list']==1)
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['list']=true;
					if(isset($this->init_map['core:requests:fields'][$eRow['key']]['core:isval_if'])&&isset($this->init_map['core:requests:fields'][$eRow['key']]['core:isval_else'])){
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['core:if_set']=array();
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['core:if_set']['core:isval']=$this->_set($this->init_map['core:requests:fields'][$eRow['key']]['core:isval']);
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['core:if_set']['core:isval_if']=$this->_set($this->init_map['core:requests:fields'][$eRow['key']]['core:isval_if']);
						$this->init_map['core:requests:fields'][$eRow['key']]['core-ar']['core:if_set']['core:isval_else']=$this->_set($this->init_map['core:requests:fields'][$eRow['key']]['core:isval_else']);
					}

					if($this->init_map['core:requests:fields'][$eRow['key']]['request']=="plain")
						$this->core_ar_plain[$this->init_map['core:requests:prefix'].$eRow['core:http_req_name']]=$this->init_map['core:requests:fields'][$eRow['key']]['core-ar'];
					elseif($this->init_map['core:requests:fields'][$eRow['key']]['request']=="http")
						$this->core_ar_http[$this->init_map['core:requests:prefix'].$eRow['core:http_req_name']]=$this->init_map['core:requests:fields'][$eRow['key']]['core-ar'];
				}
			}
			$this->isInitialised=true;
		}
		else
			trigger_error("SKB_Request: no request type given", E_USER_ERROR);
	}


	/**
	 * Private function to translate the strings for null, false and true into PHP constants.
	 *
	 * @ignore
	 */
	private function _set($type){
		switch($type){
			case "null":  return null; break;
			case "true":  return true; break;
			case "false": return false; break;
			default:      return $type; break;
		}
	}


	/**
	 * Initialise the data for that request reading HTTP request values.
	 */
	public function init_http(){
		$this->_init("http");
	}


	/**
	 * Initialise the data for that request using default values.
	 */
	public function init_plain(){
		$this->_init("plain");
	}


	/**
	 * Private function for initialising the request.
	 *
	 * @ignore
	 */
	private function _init($type){
		if($this->isInitialised==false)
			trigger_error("SKB_Request: no type loaded", E_USER_ERROR);
	
		$request=new Util_Requests();
		if($type=="http")
			$request->init_http($this->core_ar_http);
		elseif($type=="plain")
			$request->init_plain($this->core_ar_http);
		else
			trigger_error("SKB_Request: no type given for initialisation of request", E_USER_ERROR);
		$request->init_plain($this->core_ar_plain);
	
		$request=$request->get_requests();
		$_keys=array_keys($this->init_map['core:requests:fields']);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++)
			$this->init_map['core:requests:fields'][$_keys[$i]]['value']=$request[$this->init_map['core:requests:prefix'].$this->init_map['core:requests:fields'][$_keys[$i]]['core:http_req_name']];
	}


	/**
	 * Activate the request object.
	 *
	 * This function must be called before the request object can be used by Readers or Builders.
	 * A non-activated request object will be ignored, and some Reader/Builder functionality might be 
	 * disabled.
	 */
	public function activate(){
		$this->init_map['core:requests:fields']['request:active']['value']=true;
	}


	/**
	 * Test if the request object is activated or not.
	 *
	 * Returns boolean true if activated, boolean false otherwise.
	 */
	public function is_activated(){
		return $this->init_map['core:requests:fields']['request:active']['value'];
	}


	/**
	 * Return the key of the request object.
	 *
	 * The key is the type used for the creation in the constructor. It corresponds to a registered request in the SKB.
	 */
	public function get_key(){
		return $this->init_map['key'];
	}


	/**
	 * Add a value to a registered key/value pair of the request object.
	 *
	 * This function allows to add values to registered key/value pair of the request object. $fieldKey must be a known
	 * key in the request, otherwise this function will return -1. The value can be a mixed value, which means that this 
	 * function will operate as follows:
	 * <ul>
	 *   <li> If $value is an array and the current value of $fieldKey is an array both arrays will be merged using array_merge. </li>
	 *   <li> If $value is not an array and the current value of $fieldKey is an array then $value will be added to the existing array. </li>
	 *   <li> If $fieldKey is not an array and $value is not an array then current value of $fieldKey will be treated as a string and $value will be added with a leading comma. </li>
	 *   <li> If $fieldKey is not an array and $value is an array then current value of $fieldKey will be treated as a string and $value will be transformed and added to it as a comma separated string representation using implode. </li>
	 * </ul>
	 *
	 * @param string fieldKey the key for which values should be added.
	 * @param mixed value the value to be added.
	 */
	public function add_value($fieldKey, $value){
		if(!isset($this->init_map['core:requests:fields'][$fieldKey])||$fieldKey=='request:active')
			return -1;
		if(is_array($this->init_map['core:requests:fields'][$fieldKey]['value'])&&is_array($value))
			$this->init_map['core:requests:fields'][$fieldKey]['value']=array_merge($this->init_map['core:requests:fields'][$fieldKey]['value'], $value);
		elseif(is_array($this->init_map['core:requests:fields'][$fieldKey]['value'])&&!is_array($value))
			$this->init_map['core:requests:fields'][$fieldKey]['value'][]=$value;
		elseif(!is_array($this->init_map['core:requests:fields'][$fieldKey]['value'])&&!is_array($value))
			$this->init_map['core:requests:fields'][$fieldKey]['value'].=Core_Interpreter::interpret("add:char:comma", $this->init_map['core:requests:fields'][$fieldKey]['value']).$value;
		elseif(!is_array($this->init_map['core:requests:fields'][$fieldKey]['value'])&&is_array($value))
			$this->init_map['core:requests:fields'][$fieldKey]['value'].=Core_Interpreter::interpret("add:char:comma", $this->init_map['core:requests:fields'][$fieldKey]['value']).implode(",",$value);
	}


	/**
	 * Set a value of a registered key/value pair of the request object.
	 *
	 * This function allows to set the value of a registered key/value pair of the request object. $fieldKey must be a known
	 * key in the request, otherwise this function will return -1. The value can be a mixed value and it will simply overwrite any 
	 * current value of $fieldKey.
	 *
	 * @param string fieldKey the key for which values should be set.
	 * @param mixed value the value to be set.
	 */
	public function set_value($fieldKey, $value){
		if(!isset($this->init_map['core:requests:fields'][$fieldKey])||$fieldKey=='request:active')
			return -1;
		unset($this->init_map['core:requests:fields'][$fieldKey]['value']);
		$this->init_map['core:requests:fields'][$fieldKey]['value']=$value;
		//$this->addValue($fieldKey, $value);
	}


	/**
	 * Return the current value of $fieldKey.
	 *
	 * This function will return the current value of $fieldKey in the following way:
	 * <ul>
	 *   <li> If the value of $fieldKey is 'null', the return value is an empty array.</li>
	 *   <li> If the value of $fieldKey is an array, then this array will be returned.</li>
	 *   <li> If the value of $fieldKey is no 'null' and not an array, then a new array with the current value as member will be returned.</li>
	 * </ul>
	 *
	 * @param string fieldKey the key for which values should be returned.
	 */
	public function get_value($fieldKey){
		if(!isset($this->init_map['core:requests:fields'][$fieldKey]))
			return -1;
		if($this->init_map['core:requests:fields'][$fieldKey]['value']==null)
			return array();
		if(is_array($this->init_map['core:requests:fields'][$fieldKey]['value']))
			return $this->init_map['core:requests:fields'][$fieldKey]['value'];
		else
			return array($this->init_map['core:requests:fields'][$fieldKey]['value']);
	}


	/**
	 * Return the HTTP request name (or HTML Form name) of the given key.
	 *
	 * This function returns the HTTP request name (or HTML Form name) of $field_key, or -1 if that name does not exist.
	 * This name is usually different from the variable name used internally in the SKB.
	 *
	 * @param string field_key the key to be looked for.
	 */
	public function get_form_name($field_key){
		if(isset($this->init_map['core:requests:fields'][$field_key]['core:http_req_name']))
			return $this->init_map['core:requests:prefix'].$this->init_map['core:requests:fields'][$field_key]['core:http_req_name'];
		else
			return -1;
	}


	/**
	 * Returns the keys for form select fields
	 */
	public function get_form_select_keys(){
		return $this->init_map['core:requests:formselect_fields'];
	}


	/**
	 * Returns the default semantic tag set for the request object.
	 */
	public function get_sematag(){
		return $this->init_map['core:requests:table'];
	}


	/**
	 * Returns the default semantic tag for collections set for the request object.
	 */
	public function get_sematag_collections(){
		return $this->init_map['core:requests:table_collections'];
	}


	/**
	 * Returns the default filter set for the request object.
	 */
	public function get_filter(){
		return $this->init_map['core:requests:filter'];
	}


	/**
	 * Sets the default filter set for the request object.
	 */
	public function set_filter($filter){
		if($filter!=null&&!is_array($filter)&&strlen($filter)>0)
			$this->init_map['core:requests:filter']=$filter;
	}


	/**
	 * Returns the default package for the request object.
	 */
	public function get_package(){
		return $this->init_map['core:requests:package'];
	}


	/**
	 * Sets the default package for the request object.
	 */
	public function set_package($pkg){
		if($pkg!=null&&!is_array($pkg)&&strlen($pkg)>0)
			$this->init_map['core:requests:package']=$pkg;
	}


	/**
	 * Build a URL adding request specific information.
	 *
	 * This function will return a new URL adding some request specific information to it. That information is basically
	 * the HTTP Request name and the current value of all key/value pairs that are visible to HTTP requests.
	 *
	 * @param string href the original URL (aka HTML HREF).
	 */
	public function build_url($href){
		$ar=array();
		$_keys=array_keys($this->init_map['core:requests:fields']);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if($this->init_map['core:requests:fields'][$_keys[$i]]['request']=="http")
				$ar[$this->init_map['core:requests:prefix'].$this->init_map['core:requests:fields'][$_keys[$i]]['core:http_req_name']]=$this->init_map['core:requests:fields'][$_keys[$i]]['value'];
		}
		return Util_Interpreter::interpret("url:build", $href, $ar);
	}


	/**
	 * A private function that explodes fields.
	 *
	 * @ignore
	 */
	private function _explodeFields($str){
		$ret=array();
		if(strstr($str, "%")!==false){
			$tmp=explode(",", $str);
			$_Akeys=array_keys($tmp);
	    	$_Asize=count($_Akeys);
			for($k=0;$k<$_Asize;$k++){
				$ts=trim($tmp[$_Akeys[$k]]);
				$tmp2=explode("%", $ts);
				if(isset($tmp2[0])&&isset($tmp2[1]))
					$ret[$tmp2[0]]=$tmp2[1];
			}
		}
		elseif(strlen($str)==0)
			return array();
		else
			$ret=explode(",", $str);
		return $ret;
	}


	/**
	 * Return the HTTP Request name for a given key (field).
	 *
	 * This function returns the HTTP Request name for a given field (existing key/value pair), or 'null' if it does not exist 
	 * or if the given field is not visible for HTTP requests.
	 *
	 * @param string field the field to be looked for.
	 */
	public function get_http_request_name($field){
		if(isset($this->init_map['core:requests:fields'][$field])){
			if(isset($this->core_ar_http[$this->init_map['core:requests:prefix'].$this->init_map['core:requests:fields'][$field]['core:http_req_name']]))
				return $this->init_map['core:requests:prefix'].$this->init_map['core:requests:fields'][$field]['core:http_req_name']."[]";
		}
		else
			return null;
	}
}
?>