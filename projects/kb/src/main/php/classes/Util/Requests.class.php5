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
 * A simple class that initialises a request array either from HTML POST/GET or plain (default values)
 *
 * @package    Classes.Util
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Util_Requests{
  private $_requestAr;

  function __construct() {
    $this->_requestAr = array();
  }

  /*
   * $ar[$request]["core:val_unset"]
   * $ar[$request]["core:if_set"]=["core:isval"]["core:isval_if"]["core:isval_else"]
   */
  public function init_http($ar=array()){
  	if(count($ar)>0){
      while(list($key, $val) = each($ar)){
      	if(isset($_REQUEST[$key])){
      	  $this->_requestAr[$key]=$_REQUEST[$key];
      	}
      	else{
      	  $this->_requestAr[$key]=$val["core:val_unset"];
      	}
      	if(isset($val["core:if_set"])&&is_array($val["core:if_set"])&&count($val["core:if_set"])>0){
          if($this->_requestAr[$key]==$val["core:if_set"]["core:isval"])
            $this->_requestAr[$key]=$val["core:if_set"]["core:isval_if"];
          else
            $this->_requestAr[$key]=$val["core:if_set"]["core:isval_else"];
        }
        if(isset($val["core:list"])&&$val["core:list"]==true){
          $_keys=array_keys($_REQUEST);
          $_size=count($_keys);
          for($i=0;$i<$_size;$i++)
            if(strpos($_keys[$i],$key)!==false)
              $this->_requestAr[$key][]=str_replace($key, "", $_keys[$i]);
        }
  	  }
    }
  }

  public function init_plain($ar=array()){
  	if(count($ar)>0){
      while(list($key, $val) = each($ar)){
     	  $this->_requestAr[$key]=$val["core:val_unset"];
      	if(isset($val["core:if_set"])&&is_array($val["core:if_set"])&&count($val["core:if_set"])>0){
          if($this->_requestAr[$key]==$val["core:if_set"]["core:isval"])
            $this->_requestAr[$key]=$val["core:if_set"]["core:isval_if"];
          else
            $this->_requestAr[$key]=$val["core:if_set"]["core:isval_else"];
        }
  	  }
    }
  }

  public function get_request_by_key($request){(isset($this->_requestAr[$request]))?$ret=$this->_requestAr[$request]:$ret=-1;return $ret;}
  public function get_requests(){return $this->_requestAr;}
}

?>