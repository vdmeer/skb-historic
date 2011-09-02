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
 * Extended HTML4 TR,  offering some added functionality
 *
 * @package    Classes.HTML4.Extension
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Html4_Ext_TR extends Html4_Base{
	/**
	 * Constructor for the extended table row element.
	 *
	 * The constructor works similar to the base class ({@link Html4_Base Html4_Base}), except that the paramter htype is automatically 
	 * set to tr (so it's not part of this constructor. Furthermore, three attributes are set in the constructor:
	 * <ul>
	 *  <li>sort_value - for using sort function</li>
	 *  <li>normaliseValue - for normalising values in the table row</li>
	 *  <li>optimise - is set to false since optimisation of the HTML4 package doesn't work well with the extra functionality</li>
	 * </ul>
	 *
	 * @param array attributes HTML attributes as array("attribute" => "value")
	 * @param mixed content content for the instance (mixed, object, array of mixed or array of objects)
	 * @param array parameters configuration parameters array("parameter" => "value")
	 * @param string obj_id identifier the instance
	 */
	public function __construct($attributes="", $content=false, $objID=false){
		parent::__construct("tr", $attributes, $content, array("sort_value"=>array("value"=>false),"normaliseValue"=>array("value"=>false),"optimise"=>false), $objID);
	}


	/**
	 *  Set the cell's alignement
	 *
	 *  @param string $va the requested alignement as one of: top-left, top-center, top-right, middle-left, middle-center, middle-right, bottom-left, bottom-center, bottom-right
	 */
	public function set_align($va="top-left"){
		$valueMap=array("top-left","top-center","top-right","middle-left","middle-center","middle-right","bottom-left","bottom-center","bottom-right");
		if(isset($valueMap[$va])){
			$this->set("valign",strtok($va,"-"));
			$this->set("align",strtok("-"));
		}
	}


	/**
	 *  Compare two rows using a sort value
	 *
	 *  @param Html4_Base $a left part of the comparision
	 *  @param Html4_Base $b right part of the comparision
	 */
	public function compare($a, $b){
		return strcmp($a->get("sortValue"), $b->get("sort_value"));
	}


	/**
	 *  Sort the cells in a table row.
	 */
	public function u_sort(){
		usort($this->content, array("Html4_Ext_TD", "compare"));
	}


	/**
	 *  Sort the cells using the keys.
	 */
	public function ksort(){
		if(is_array($this->content))
			ksort($this->content, SORT_STRING);
	}


	/**
	 *  Normalise the rows of the table body.
	 *
	 *  @param ar $ar array to normalise
	 */
	public function normalise($ar){
		$cmpAr=array_diff_key($ar->ar,$this->_get_normalise_ar()->ar);
		$_keys=array_keys($cmpAr);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			$val=$cmpAr[$_keys[$i]];
			$td=new Html4_Ext_TD(array("sort_value"=>$val["sort"]));
			$td->emptyContent();
			$this->add_child($td);
		}
		$this->USort();
	}


	/** @ignore */
	private function _get_normalise_ar(){
		$ret=new Util_ArBase();

		$_keys=array_keys($this->content);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			$_norm=$this->content[$_keys[$i]]->get("normalise_value");
			if($_norm!=-1&&$_norm!="")
				$ret->ar[$_norm]=true;
		}
		return $ret;
	}
}

?>