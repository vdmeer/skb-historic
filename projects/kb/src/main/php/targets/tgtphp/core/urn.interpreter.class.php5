<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2010-2011, Sven van der Meer <sven@vandermeer.de>
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
 * SKB Core Interpreter for converting URNs into filenames, SKB Package Core.
 *
 * This interpreter reads the semantic tag provided in the request and reads information for $key.
 * Then it creates information about absolute and relative paths to the filename from the SKB URN.
 *
 * @package    Packages.Core
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_core___urn___interpreter implements SKB_InterpreterCore{
  public function __construct(){}

  /**
   * Interpret the given key using the given request.
   *
   * The paramter key will be used to query the semantic tag named in the parameter request. This semantic tag 
   * should hold information about the URN for interpretation, currently the actual URN only. Furthermore,
   * the entry "request:file_ext" in the parameter request must indicate what file extensions the interpreter 
   * should look for (i.e.: "jpg", "gif"). Path names will then be created using the SKB configuraton information for 
   * absolute and relative path names.
   * 
   * @param string key the key to collect further information for
   * @param SKBRequest request object for furhter paramters
   * @return Util_ArBase with the interpreted information for the key.
   */
  static public function interpret($key, SKB_Request $request){
    $mySKB=SKB_Main::get_instance();
    $myDM=SKB_DataManager::get_instance();
    $ret=array();

    $sematag=$request->get_sematag();
    $key=$myDM->query_data_object($myDM->prepare_query($sematag,"*",array("key"=>$key),null,null,false,true))->ar;

    $start=strtok($key['core:urn'], ":");
    $urn=str_replace($start.":","",$key['core:urn']);
    $urn=str_replace(":","/",$urn);

    $lib_abs=$mySKB->configuration->get_group("path",$start."-abs");
    $lib_rel=$mySKB->configuration->get_group("path",$start."-rel");

    $file_ext=$request->get_value("request:file_ext");
    if(Util_Interpreter::interpret("value:is_empty", $file_ext)==true||$file_ext==-1)
      trigger_error(_("Core.Interpreter.URN: no file extensions given"), E_USER_ERROR);

    $_keys=array_keys($file_ext);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      if(($_size>1&&file_exists($lib_abs.$urn.'.'.$file_ext[$_keys[$i]]))||$_size==1){
      	$ret[$file_ext[$_keys[$i]]]=array();
        $ret[$file_ext[$_keys[$i]]]['full']=array();
        $ret[$file_ext[$_keys[$i]]]['full']['abs']=$lib_abs.$urn.'.'.$file_ext[$_keys[$i]];
        $ret[$file_ext[$_keys[$i]]]['full']['rel']=$lib_rel.$urn.'.'.$file_ext[$_keys[$i]];
        if(isset($key['gallery:w_600']))
          $ret[$file_ext[$_keys[$i]]]['full']['width']=$key['gallery:w_600'];
        if(isset($key['gallery:h_600']))
          $ret[$file_ext[$_keys[$i]]]['full']['height']=$key['gallery:h_600'];

        if(($_size>1&&file_exists($lib_abs.$urn.'_s.'.$file_ext[$_keys[$i]]))||$_size==1){
          $ret[$file_ext[$_keys[$i]]]['small']=array();
          $ret[$file_ext[$_keys[$i]]]['small']['abs']=$lib_abs.$urn.'_s.'.$file_ext[$_keys[$i]];
          $ret[$file_ext[$_keys[$i]]]['small']['rel']=$lib_rel.$urn.'_s.'.$file_ext[$_keys[$i]];
          if(isset($key['gallery:w_200']))
            $ret[$file_ext[$_keys[$i]]]['small']['width']=$key['gallery:w_200'];
          if(isset($key['gallery:h_200']))
            $ret[$file_ext[$_keys[$i]]]['small']['height']=$key['gallery:h_200'];
        }
      }
    }
    if(count($ret)==0)
      trigger_error(_("Core.Interpreter.URN: file not found for")." ".$key['core:urn'], E_USER_ERROR);

    return new Util_ArBase($ret);
  }

}
?>