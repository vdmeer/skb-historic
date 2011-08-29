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
 * A simple singleton that manages HTTP requests and response for individual pages
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class SKB_Http{
	private static $instance=null;
	private static $cKey="beef";

	//HTTP Headers not prefixed HTTP_ in $_SERVER
	private static $additional_headers=array('CONTENT_TYPE', 'CONTENT_LENGTH');

	private $request_headers=array();
	private $request_method=false;
	private $request_protocol=false;

	private $request_time;
	private $request_date;
	private $reuqest_datetime;

	private $status_codes=array();
	private $headers_request=array();
	private $headers_response=array();
	private $headers_response_skb=array();
	private $mime_content_types=array();
	private $request_methods=array();

	private $registered_callbacks=array();


	/**
	 * The class constructor, which cannot be called directly since SKB_Http is a singleton.
	 */
	public function __construct($_c){
		if($_c!=self::$cKey)
			trigger_error("SKB_Http: Direct creation of object is not allowed, please use get_instance().", E_USER_ERROR);
		else
			$this->_init_http_request();
	}


	/**
	 * Return the instance of SKB_Http (Singleton)
	 */
	public static function get_instance(){
		if(null===self::$instance)
			self::$instance=new SKB_Http("beef");
		return self::$instance;
	}
  
  
	/**
	 * Cloning is not allowed, since SKB_Http is a Singleton
	 */
	public function __clone(){
		trigger_error("SKB_Http: Clone is not allowed.", E_USER_ERROR);
	}


	public function set_data($ar){
		if(isset($ar['http_status_codes']))
			$this->status_codes=$this->status_codes+$ar['http_status_codes'];
		if(isset($ar['http_headers_request']))
			$this->headers_request=$this->headers_request+$ar['http_headers_request'];
		if(isset($ar['http_headers_response']))
			$this->headers_response=$this->headers_response+$ar['http_headers_response'];
		if(isset($ar['mime_content_types']))
			$this->mime_content_types=$this->mime_content_types+$ar['mime_content_types'];
		if(isset($ar['http_request_methods']))
			$this->request_methods=$this->request_methods+$ar['http_request_methods'];
		$_keys=array_keys($this->request_methods);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++)
			$this->registered_callbacks[$this->request_methods[$_keys[$i]]['http:method']]=array();
	}


	/**
	 * Initialise local data structure with the original HTTP request.
	 * 
	 * This private function is called by the class constructor to fill local data structures with the current HTTP request.
	 */
	private function _init_http_request(){
		if(isset($_SERVER['HTTP_METHOD'])){
			$this->request_method=$_SERVER['HTTP_METHOD'];
			unset($_SERVER['HTTP_METHOD']);
		}
		else
			$this->request_method=isset($_SERVER['REQUEST_METHOD'])?$_SERVER['REQUEST_METHOD']:false;
	
		$this->request_protocol=isset($_SERVER['SERVER_PROTOCOL'])?$_SERVER['SERVER_PROTOCOL']:false;
	
		foreach($_SERVER as $i=>$val){
			if(strpos($i,'HTTP_')===0||in_array($i,self::$additional_headers)){
				$name=str_replace(array('HTTP_','_'),array('','-'),$i);
				$this->request_headers[$name]=$val;
			}
		}
	
		if(isset($this->request_headers['ACCEPT'])){
			$exp=explode(",",$this->request_headers['ACCEPT']);
			$this->request_headers['ACCEPT']=array();
			foreach($exp as $exp){
				preg_match("!([^;]+)(?:;q=(\d\.\d\d?))?!", $exp, $matches);
				if(!isset($matches[2])||''==$matches[2])
					$matches[2]='1.0';
				$matches[1]=trim($matches[1]);
				$priority=(string)(int)((float)$matches[2]*100);
				$this->request_headers['ACCEPT'][$matches[1]]=(string)(int)((float)$matches[2]*100);
			}
			arsort($this->request_headers['ACCEPT']);
		}
	
		if(isset($this->request_headers['ACCEPT-LANGUAGE'])){
			$exp=explode(",",$this->request_headers['ACCEPT-LANGUAGE']);
			$this->request_headers['ACCEPT-LANGUAGE']=array();
			foreach($exp as $exp){
				preg_match("!([a-z]{2}(?:-[a-zA-Z]{2})?)(?:;q=(\d\.\d\d?))?!", $exp, $matches);
				if(!isset($matches[2])||''==$matches[2])
					$matches[2]='1.0';
				$matches[1]=preg_replace('!([a-z]{2}-)([a-z]{2})!e', "'$1' . strtoupper('$2')", $matches[1]); // capitalized Alpha-2 code
				$this->request_headers['ACCEPT-LANGUAGE'][$matches[1]]=(string)(int)((float)$matches[2]*100);
			}
			arsort($this->request_headers['ACCEPT-LANGUAGE']);
		}
	
		if(isset($this->request_headers['ACCEPT-CHARSET'])){
			$exp=explode(",",$this->request_headers['ACCEPT-CHARSET']);
			$this->request_headers['ACCEPT-CHARSET']=array();
			foreach($exp as $exp){
				preg_match("!([^;]+)(?:;q=(\d\.\d\d?))?!", $exp, $matches);
				if(!isset($matches[2])||''==$matches[2])
					$matches[2]='1.0';
				$this->request_headers['ACCEPT-CHARSET'][$matches[1]]=(string)(int)((float)$matches[2]*100);
			}
			arsort($this->request_headers['ACCEPT-CHARSET']);
		}
	
		$time=time();
		$this->reuqest_datetime=date("Y-m-d H:i:s",$time);
		$this->reuqest_date=date("Y-m-d",$time);
		$this->reuqest_time=date("H:i:s",$time);
	}


	public function request_get_header($key){
		if(array_key_exists($key, $this->request_headers))
			return $this->request_headers[$key];
		else
		return -1;
	}

	public function request_test_accept_type(){
		if(array_key_exists("ACCEPT", $this->request_headers)){
			if(count($this->request_headers['ACCEPT'])==1){
				$keys=array_keys($this->request_headers['ACCEPT']);
				return $keys[0];
			}
			elseif(array_key_exists("application/xhtml+xml", $this->request_headers['ACCEPT']))
				return "application/xhtml+xml";
			elseif(array_key_exists("*/*", $this->request_headers['ACCEPT']))
				return "application/xhtml+xml";
			elseif(array_key_exists("text/html", $this->request_headers['ACCEPT']))
				return "text/html";
			else{
				$keys=array_keys($this->request_headers['ACCEPT']);
				return $keys[0];
			}
		}
		else
			return -1;
	}

	public function request_get_method(){
		return $this->request_method;
	}

	public function response_send_status_code($status){
		if(array_key_exists($status,$this->status_codes))
			header("HTTP/1.1 " . $this->status_codes[$status]['http:status:code'] . " " . $this->status_codes[$status]['http:status:code:text']);
		else
			trigger_error("SKB_Http: unknown status code: {$status}.", E_USER_ERROR);
	}

	public function response_send_header($header, $value, $status=null, $replace=true){
		if(array_key_exists($header,$this->headers_response)&&$status!=null&&array_key_exists($status,$this->status_codes))
			header($header.": ".$value, $replace, $status);
		elseif(array_key_exists($header,$this->headers_response))
			header($header.": ".$value, $replace);
		elseif(array_key_exists($header,$this->headers_response_skb)&&$status!=null&&array_key_exists($status,$this->status_codes))
				header($header.": ".$value, $replace, $status);
		elseif(array_key_exists($header,$this->headers_response_skb))
			header($header.": ".$value, $replace);
		else
			trigger_error("SKB_Http: unknown header <{$header}> or status code: <{$status}> with value <{$value}>.", E_USER_ERROR);
	}

	public function register_callback($http_methods, $header_accept, $f_name){
		if($f_name==null&&$f_name=="")
			trigger_error("SKB_Http: no function name given for register_callback.", E_USER_ERROR);
		if(!is_array($header_accept)&&!array_key_exists($header_accept,$this->mime_content_types))
			trigger_error("SKB_Http: cannot register unknown content type {$header_accept}.", E_USER_ERROR);
	
		if(is_array($header_accept)){
			$keys=array_values($header_accept);
			foreach($keys as $key){
				if(!array_key_exists($key,$this->mime_content_types))
					trigger_error("SKB_Http: cannot register unknown content type {$key}.", E_USER_ERROR);
			}
		}
	
		if(!is_array($http_methods)){
			if(array_key_exists($http_methods,$this->request_methods)){
				if(!is_array($header_accept))
					$this->registered_callbacks[$http_methods][$header_accept]=$f_name;
				else{
					foreach($header_accept as $ct)
						$this->registered_callbacks[$http_methods][$ct]=$f_name;
				}
			}
		}
		else{
			foreach($http_methods as $method){
				if(array_key_exists($method,$this->request_methods)){
					if(!is_array($header_accept))
						$this->registered_callbacks[$method][$header_accept]=$f_name;
					else{
						foreach($header_accept as $ct)
							$this->registered_callbacks[$method][$ct]=$f_name;
					}
				}
			}
		}
	}

	public function response_do(){
		$this->registered_callbacks=Util_Interpreter::interpret("array:clean", $this->registered_callbacks);
	
		$keys=array_keys($this->registered_callbacks);
		(count($keys)==0)?$allow="OPTIONS":$allow=implode(", ",$keys).", OPTIONS";
	
		if($this->request_method=="OPTIONS")
			$this->response_send_header("Allow", $allow);
		elseif(array_key_exists($this->request_method,$this->registered_callbacks)){
			$ct=$this->request_test_accept_type();
			if(array_key_exists($ct,$this->registered_callbacks[$this->request_method])){
				$this->response_send_header("Content-Type", $ct);
				call_user_func($this->registered_callbacks[$this->request_method][$ct]);
			}
			else{
				$this->response_send_status_code(415);
				$this->response_send_header("X-SKB-Accept", implode(", ",array_keys($this->registered_callbacks[$this->request_method])));
			}
		}
		else
			$this->response_send_header("Allow", $allow, 405);
	}

	public function response_set_html_content_type(){
		//get the accept header, and change the array to allow priorities
		if(!array_key_exists("ACCEPT", $this->request_headers))
			return null;
	
		$accept=$this->request_headers['ACCEPT'];
		$priority=array();
		foreach($accept as $key=>$val){
			if(!isset($priority[$val]))
				$priority[$val]=array();
			$priority[$val][]=$key;
		}
	
		//now sort the priorities, that'll bring and */* (IE) and app/xhtml to the front
		foreach($priority as $key=>$val){
			sort($priority[$key]);
			$ret=$this->_test_response_set_html_content_type($priority[$key]);
			if($ret!=null)
				break;
		}
		return $ret;
	}

	private function _test_response_set_html_content_type($ar){
		$mySKB=SKB_Main::get_instance();
		$ct=$mySKB->configuration->get_group("header","content-type");
		$ct=explode(",",$ct);
		$ct=array_unique($ct);
		$ret=null;
	
		foreach($ar as $key=>$val){
			if($val=="application/xhtml+xml"){
				if(in_array("text/html",$ct))
					$ret="text/html";
				elseif(in_array("application/xhtml+xml",$ct))
					$ret="application/xhtml+xml";
				break;
			}
			elseif($val=="text/html"){
				$ret="text/html";
			break;
			}
			elseif($val=="*/*"){
				$ret="text/html";
				break;
			}
		}
		$this->response_send_header("Content-Type", $ret."; charset=iso-8859-1");
		return $ret;
	}

	public function get_skb_http_headers_response(){
		return $this->headers_response;
	}

	public function get_skb_mime_content_types(){
		$ret=array();
		foreach($this->mime_content_types as $key=>$val)
			if(isset($this->mime_content_types[$key]['origin'])&&$this->mime_content_types[$key]['origin']!="std")
				$ret[$key]=$val;
		return $ret;
	}
}
?>