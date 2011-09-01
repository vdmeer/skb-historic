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
 * Reader for the SKB Package Dist.Menu.
 *
 * @package    Packages.Dist.Menu
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__menu___menu___reader extends SKB_Reader{
	/**
	 * An empty constructor.
	 */
	public function __construct(){
	}

	/**
	 * The reader specific prepare function.
	 *
	 * Automatically called by {@link SKB_Reader#prepare() SKB_Reader->prepare}.
	 */
	public function prepare_loop(SKB_Request $request, $sematag, $sematag_collections){
		$mySKB=SKB_Main::get_instance();
		$myDM=SKB_DataManager::get_instance();

		$this->entry_list=$myDM->query_data_object($myDM->prepare_query("skb:menu",null,null,"key",null,null,true,true))->ar;
		$site_root=$mySKB->configuration->get_group("path","site");

		$this->entries['/']=array();
		$this->entries['/']['_children']=array();
		$this->entries['/']["current-title"]=array();

		$_keys=array_keys($this->entry_list);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			$exp=explode("/",$this->entry_list[$_keys[$i]]['key']);
			array_shift($exp);

			$this->entry_list[$_keys[$i]]['level']=count($exp);
			if(isset($this->entry_list[$_keys[$i]]["menu:url"])){
				if(isset($this->entry_list[$_keys[$i]]["menu:url"])){
					if(strpos($this->entry_list[$_keys[$i]]["menu:url"], "http://")!==false)
						;
					elseif(strpos($this->entry_list[$_keys[$i]]["menu:url"], "https://")!==false)
						;
					elseif(strpos($this->entry_list[$_keys[$i]]["menu:url"], "ftp://")!==false)
						;
					elseif(strpos($this->entry_list[$_keys[$i]]["menu:url"], "mailto:")!==false)
						;
					else
						$this->entry_list[$_keys[$i]]["menu:url"]=$site_root . $this->entry_list[$_keys[$i]]["menu:url"];
				}
			}
			$this->build($exp, $this->entries['/']['_children'], $this->entry_list[$_keys[$i]]);

			if(isset($this->entry_list[$_keys[$i]]["menu:url"])){
					if($this->entry_list[$_keys[$i]]["menu:url"]==Util_Interpreter::interpret("url:remove:add", $_SERVER["REQUEST_URI"]) || $this->entry_list[$_keys[$i]]["menu:url"]==$_SERVER["PHP_SELF"]){
						$this->entries['/']["current-position"]=$exp;
						$this->entries['/']["current-parameters"]=$this->entry_list[$_keys[$i]];
					}
			}
		}
		ksort($this->entries['/']['_children']);
		$this->remove($this->entries['/']);
		if(isset($this->entries['/']["current-position"]))
			$this->set_active($this->entries['/'], $this->entries['/']["current-position"]);
	}

	/** @ignore */
	private function build($exp, &$ar_ret, $ar_ins){
		if(count($exp)==1){
			if(!isset($ar_ret[$exp[0]]))
				$ar_ret[$exp[0]]=$ar_ins;
			else
				$ar_ret[$exp[0]]=array_merge($ar_ret[$exp[0]],$ar_ins);
		}
		else{
			$_first=array_shift($exp);
			if(!isset($ar_ret[$_first]['_children']))
				$ar_ret[$_first]['_children']=array();
			$this->build($exp, $ar_ret[$_first]['_children'], $ar_ins);
			ksort($ar_ret[$_first]['_children']);
		}
	}

	/** @ignore */
	private function remove(&$ar_ret){
		$mySKB=SKB_Main::get_instance();

		$_keys=array_keys($ar_ret['_children']);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if(isset($ar_ret['_children'][$_keys[$i]]["menu:options"])){
				if(strstr($ar_ret['_children'][$_keys[$i]]["menu:options"], "notvisible")!==false){
					unset($ar_ret['_children'][$_keys[$i]]);
					continue;
				}
				$rl=$mySKB->configuration->get_group("server","access-remote");
				if(strstr($ar_ret['_children'][$_keys[$i]]["menu:options"], "local_only")!==false&&$rl==true){
					unset($ar_ret['_children'][$_keys[$i]]);
					continue;
				}
			}
			if(isset($ar_ret['_children'][$_keys[$i]]['_children']))
				$this->remove($ar_ret['_children'][$_keys[$i]]);
		}
	}

	/** @ignore */
	private function set_active(&$ar_ret, $exp){
		if(count($exp)>0){
			$next=array_shift($exp);
			$ar_ret['_children'][$next]['active']=true;
			$this->entries['/']["current-title"][]=$ar_ret['_children'][$next]['menu:title'];
			if(isset($ar_ret['_children'][$next]['_children']))
				$this->set_active($ar_ret['_children'][$next], $exp);
		}
	}

	/**
	 * The reader specific execute function.
	 *
	 * Automatically called by {@link SKB_Reader#execute() SKB_Reader->execute}.
	 */
	public function execute_loop(SKB_Request $request){
	}

	public function get_current_key(){
		if(isset($this->entries['/']["current-parameters"]['key']))
		  return $this->entries['/']["current-parameters"]['key'];
		else
		  return -1;
	}

	public function get_item($position, $ar=array()){
		if(count($ar)==0)
		  $ar=$this->entries['/'];
		if(count($position)==1){
			if(isset($ar['_children'][$position[0]])){
				$ret=$ar['_children'][$position[0]];
				if(isset($ret['_children']))
				  unset($ret['_children']);
			  return $ret;
			}
			else
			  return -1;
		}
		else{
			if(isset($ar['_children'][$position[0]]));
				$ar=$ar['_children'][$position[0]];
			array_shift($position);
			return $this->get_item($position,$ar);
		}
	}

	public function get_title_array(){
		return $this->entries['/']["current-title"];
	}

	public function get_title_string($delim){
		if(count($this->entries['/']["current-title"])==0)
			return "";
		elseif(count($this->entries['/']["current-title"])==1)
			return $this->entries['/']["current-title"][0];
		else
			return implode($delim,$this->entries['/']["current-title"]);
	}
}
?>