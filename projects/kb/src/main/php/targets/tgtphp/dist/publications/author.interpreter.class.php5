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
 * SKB Entity Interpreter for Dist.Publications, collecting people information for a single author/editor.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__publications___author___interpreter implements SKB_InterpreterEntity{
	public function __construct(){
	}
	
	static public function interpret($key, $table=null){
		$ret=array();
		if($table==null)
			$table="skb:people";

		$ar=Util_Interpreter::interpret("array:explode", $key);
		$name=Util_Interpreter::interpret("array:clean", array_keys($ar));
		$aff=Util_Interpreter::interpret("array:clean", array_values($ar));
	
		$myDM=SKB_DataManager::get_instance();
		if(count($aff)>0&&count($name)>0){
			$ret=$myDM->query_data_object($myDM->prepare_query($table, array('"people:first"','"people:last"','"people:affiliation_keys"'), array("key"=>$name[0]), null, null, null, false, true))->ar;
			$aff_array=Util_Interpreter::interpret("array:explode", $ret['people:affiliation_keys']);
			if(isset($aff_array[$aff[0]])){
				unset($ret['people:affiliation_keys']);
				$ret['affiliation']=$myDM->interpret_loop(new Util_ArBase(array('people:affiliation_key'=>$aff_array[$aff[0]])))->ar['people:affiliation'];
			}
		}
		else{
			$ret=$myDM->query_data_object($myDM->prepare_query($table, array('"people:first"','"people:last"'), array("key"=>$name[0]), null, null, null, false, true))->ar;
		}
		$ret['key']=$name[0];
		return new Util_ArBase($ret);
	}
}
?>