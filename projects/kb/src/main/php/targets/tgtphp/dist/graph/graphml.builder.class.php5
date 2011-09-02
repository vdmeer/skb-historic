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
 * Builder for the SKB Package Dist.Graph, creating a GraphML representation of the given entries.
 *
 * For examples how to use this builder, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Graph
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__graph___graphml___builder extends SKB_Builder{
	/**
	 * The template id for the builder.
	 *
	 * @var $tpl
	 */
	protected $tpl="Dist.Graph.Entries2GraphML:Template";


	/**
	 * The flattened array.
	 *
	 * @var $entries_flat
	 */
	protected $entries_flat;


	/**
	 * Class Constructor.
	 *
	 * It calls the parent class to instantiate the template repository and then 
	 * adds the local template to it.
	 */
	function __construct(){
		parent::__construct();
		$this->templates->add_template("tpl", $this->tpl);
		$this->entries_flat=array();
		$this->entries_flat['cloud']=array();
	}


	/**
	 * The builder specific execute function.
	 *
	 * Automatically called by {@link SKB_Builder#execute() SKB_Builder->execute}
	 */
	public function execute_loop(SKB_Request $request, Util_ArBase $entries){
		$this->flatten($entries->ar, 'cloud');
		$this->entries_flat['graphml:data']=array_unique($this->entries_flat['graphml:data']);
	
		$tpl=$this->templates->get_template_object("tpl");
		$tpl->set("entries", new Util_ArBase($this->entries_flat));
//		print_r($entries);
//		print_r($this->entries_flat);
		$tpl->printT();
	}


	/**
	 * Flatten the entries array for the builder
	 */
	private function flatten($ar, $entry_point){
		$this->entries_flat['graphml:edges']=array();
		$this->entries_flat['graphml:data']=array();
	
		$_keys=array_keys($ar);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if(isset($ar[$_keys[$i]]['key'])){
				$this->entries_flat[$entry_point][str_replace(":", "_", $ar[$_keys[$i]]['key'])]=array();
				$this->flatten_rec($ar[$_keys[$i]], $entry_point);
			}
		}
	}


	/**
	 * Recursive flattening function.
	 */
	private function flatten_rec(array $ar, $entry_point){
		if(!isset($ar['key']))
			return;
		$parKey=str_replace(":", "_", $ar['key']);

		$_keys=array_keys($ar);
		$_size=count($_keys);
		$key;
		$val;
		for($i=0;$i<$_size;$i++){
			$key=$_keys[$i];
			$val=$ar[$_keys[$i]];
			
			//exclusion of keys
			if($key=="default:name_locale")
				continue;

			$key=str_replace(":", "_", $key);
			if(is_array($val)&&isset($val['key'])){
				if(!isset($this->entries_flat[$key])){
					$this->entries_flat[$key]=array();
					$this->entries_flat[$key]['default_name']=$key;
				}
				$this->flatten_rec($val, $key);

				$val=str_replace(":", "_", $val);
				if(!isset($this->entries_flat['graphml:edges'][$entry_point."::".$parKey]))
					$this->entries_flat['graphml:edges'][$entry_point."::".$parKey]=array();
				$this->entries_flat['graphml:edges'][$entry_point."::".$parKey][]=$key."::".$val['key'];
			}
			elseif(is_array($val)&&!isset($val['key'])){
				foreach($val as $subVal){
					if(is_array($subVal)&&isset($subVal['key'])){
						if(!isset($this->entries_flat[$key])){
							$this->entries_flat[$key]=array();
//							$this->entries_flat[$key]['default_name']=$key;
						}
						$this->flatten_rec($subVal, $key);

						$subVal=str_replace(":", "_", $subVal);
						if(!isset($this->entries_flat['graphml:edges'][$entry_point."::".$parKey]))
							$this->entries_flat['graphml:edges'][$entry_point."::".$parKey]=array();
						$this->entries_flat['graphml:edges'][$entry_point."::".$parKey][]=$key."::".$subVal['key'];
					}
				}
			}
			elseif(!is_array($val)){
				$this->entries_flat[$entry_point][$parKey][$key]=Util_Interpreter::interpret("convert_text:h2t", $val);
				$this->entries_flat['graphml:data'][]=$key;
			}
		}
	} 
}
?>