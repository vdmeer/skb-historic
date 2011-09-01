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
 * Reader for the SKB Package Dist.Gallery.
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__gallery___gallery___reader extends SKB_Reader{
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
		$myDM=SKB_DataManager::get_instance();

		//get values
		$skb_collection=$this->_get_values($request,'request:collection');
		$skb_part=$this->_get_values($request,'request:part');
		$skb_key=$this->_get_values($request,'request:entry');
		$skb_key_list=$this->_get_values($request,'request:entry_list');
		$skb_element_key_list=$this->_get_values($request,'request:element_keys');
		$skb_year=$this->_get_values($request,"default:year");
		$skb_city=$this->_get_values($request,"default:city_key");
		$skb_country=$this->_get_values($request,"default:country_key");
		$skb_museum=$this->_get_values($request,"gallery:museum_key");
		$skb_items=$this->_get_values($request,"gallery:item_keys");
		$skb_fotographer=$this->_get_values($request,"gallery:fotographer_key");

		//do counts
		$skb_collection_count=count($skb_collection);
		$skb_part_count=count($skb_part);
		$skb_key_count=count($skb_key);
		$skb_key_list_count=count($skb_key_list);
		$skb_element_key_list_count=count($skb_element_key_list);
		$skb_year_count=count($skb_year);
		$skb_city_count=count($skb_city);
		$skb_country_count=count($skb_country);
		$skb_museum_count=count($skb_museum);
		$skb_items_count=count($skb_items);
		$skb_fotographer_count=count($skb_fotographer);

		$count_extra=$skb_year_count+$skb_city_count+$skb_country_count+$skb_museum_count+$skb_items_count+$skb_fotographer_count;

		//build cases
		$case="";
		if($skb_collection_count==1&&$skb_part_count==1&&$skb_key_count==0&&$count_extra==0)
			$case="coll_n_part";
		elseif($skb_key_count==1)
			$case="single_key";
		elseif($skb_key_list_count>00)
			$case="key_list";
		elseif($skb_element_key_list_count==1)
			$case="element_key_list";
		elseif($count_extra>0)
			$case="form_select";
		else
			return;

		switch($case){
			case "coll_n_part":
					$skb_collection=$skb_collection[0];
					$skb_part=$skb_part[0];
					$row=$this->entries=$myDM->query_data_object($myDM->prepare_query($sematag_collections, array('key','"request:collection"','"request:part"','"request:element_keys"'), array("request:collection"=>$skb_collection,"request:part"=>$skb_part), null, null, null, false, false))->ar;
					$fotos=Util_Interpreter::interpret("array:explode", $row['request:element_keys']);
					$_keys=array_keys($fotos);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						$ar=$myDM->query_data_object($myDM->prepare_query($sematag,"*",array("key"=>$_keys[$i]),null,null,null,true,true))->ar;
						$ar['file']=$myDM->interpret_data('Core.Interpreter.URN', $_keys[$i], null, $request)->ar;
						$ar['request:seq_no']=$i;
						if($fotos[$_keys[$i]]==1)
							$ar['request:hbr']=$fotos[$_keys[$i]];
						$this->entries[]=$ar;
					}
					break;

			case "single_key":
					$skb_key=$skb_key[0];
					$ar=$myDM->query_data_object($myDM->prepare_query($sematag,"*",array("key"=>$skb_key),null,null,null,true,true))->ar;
					$ar['file']=$myDM->interpret_data('Core.Interpreter.URN', $skb_key, null, $request)->ar;
					$this->entries[]=$ar;
					break;

			case "key_list":
					$_keys=array_keys($skb_key_list);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						$ar=$myDM->query_data_object($myDM->prepare_query($sematag,"*",array("key"=>$skb_key_list[$_keys[$i]]),null,null,null,true,true))->ar;
						$ar['file']=$myDM->interpret_data('Core.Interpreter.URN', $skb_key_list[$_keys[$i]], null, $request)->ar;
						$this->entries[]=$ar;
					}
					break;

			case "element_key_list":
					$fotos=Util_Interpreter::interpret("array:explode", $skb_element_key_list[0]);
					$_keys=array_keys($fotos);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						$ar=$myDM->query_data_object($myDM->prepare_query($sematag,"*",array("key"=>$_keys[$i]),null,null,null,true,true))->ar;
						$ar['file']=$myDM->interpret_data('Core.Interpreter.URN', $_keys[$i], null, $request)->ar;
						$ar['request:seq_no']=$i;
						if($fotos[$_keys[$i]]==1)
							$ar['request:hbr']=$fotos[$_keys[$i]];
						$this->entries[]=$ar;
					}
					break;

			case "form_select":
					$fotos=array();
					$fotos_count=0;
					if($skb_collection_count==1&&$skb_part_count==1){
						$coll=$skb_collection[0];
						$part=$skb_part[0];
						$row=$myDM->query_data_object($myDM->prepare_query($sematag_collections,array('key','"request:collection"','"request:part"','"request:element_keys"'),array("request:collection"=>$coll,"request:part"=>$part),null,null,null,false,false))->ar;
						$fotos=array_keys(Util_Interpreter::interpret("array:explode", $row['request:element_keys']));
						$fotos_count=count($fotos);
					}

					$rows=$myDM->query_data_object($myDM->prepare_query($sematag,"*",null,null,null,null,false,false))->ar;
					foreach($rows as $row){
						//we've had a collection/part, but key is not in it
						if($fotos_count>0&&!in_array($row['key'],$fotos))
							continue;
						//we are looking at fotos and figures, so all keys are already there
						if($request->get_key()=="Dist.Gallery.Fotos"||$request->get_key()=="Dist.Gallery.Figures"){
							if(isset($row['default:year'])&&$skb_year_count>0&&!in_array($row['default:year'],$skb_year))
								continue;
							if(isset($row['default:city_key'])&&$skb_city_count>0&&!in_array($row['default:city_key'],$skb_city))
							  continue;
							if(isset($row['default:country_key'])&&$skb_country_count>0&&!in_array($row['default:country_key'],$skb_country))
								continue;
							if(isset($row['gallery:fotographer_key'])&&$skb_fotographer_count>0&&!in_array($row['gallery:fotographer_key'],$skb_fotographer))
								continue;

							//now for the guys who don't have city/country/year set but we are looking for it
							if($skb_year_count>0&&!isset($row['default:year']))
								continue;
							if($skb_city_count>0&&!isset($row['default:city_key']))
								continue;
							if($skb_country_count>0&&!isset($row['default:country_key']))
								continue;
						}

						//we are looking at paintings, so we need to interpret the museum_key to get city/country, if needed
						elseif($request->get_key()=="VDM.Gallery.Paintings"){
							if(isset($row['gallery:museum_key'])){
								if($skb_museum_count>0&&!in_array($row['gallery:museum_key'],$skb_museum))
									continue;

								if($skb_items_count>0){
									$items=Util_Interpreter::interpret("array:explode", $row['gallery:item_keys']);
									if(!in_array($skb_items[0], $items))
										continue;
								}

								$ar=$myDM->interpret_do(new Util_ArBase(array("gallery:museum_key"=>$row['gallery:museum_key'])), null, $sematag)->ar['gallery:museum'];
								if(isset($ar['default:city']['key'])&&$skb_city_count>0&&!in_array($ar['default:city']['key'],$skb_city))
									continue;
								if(isset($ar['default:country']['key'])&&$skb_country_count>0&&!in_array($ar['default:country']['key'],$skb_country))
									continue;
							}
							else
								continue;
						}

						$ar=Util_Interpreter::interpret("array:clean", $row);
						$ar=$myDM->interpret_do(new Util_ArBase($ar), null, $sematag)->ar;
						$ar['file']=$myDM->interpret_data('Core.Interpreter.URN', $row['key'], null, $request)->ar;
						$this->entries[]=$ar;
					}
					break;
			default: break;
		}
	}

	/**
	 * The reader specific execute function.
	 *
	 * Automatically called by {@link SKB_Reader#execute() SKB_Reader->execute}.
	 */
	public function execute_loop(SKB_Request $request){
	}

	/** @ignore */
	private function _get_values($request, $field){
		$ret=$request->get_value($field);
		($ret==-1)?$ret=array():"";
		return $ret;
	}
}
?>