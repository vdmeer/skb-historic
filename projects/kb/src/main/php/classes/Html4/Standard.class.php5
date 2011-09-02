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
 * Stand-alone server that implements and checks HTML conformity when using an HTML_Element
 *
 * @package    Classes.HTML4
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Html4_Standard{
	private $doctype;
	private $docTypeLong;


	/**
	 *  @param string $doctype document type which can be Strict/S/s or Transitional/T/t or Frameset/F/f
	 */
	public function __construct($doctype){
		$this->doctype="";
		switch($doctype){
			case "Strict":
			case "S":
			case "s":
				$this->doctype="s";
				break;
			case "Transitional":
			case "T":
			case "t":
				$this->doctype="t";
				break;
			case "Frameset":
			case "F":
			case "f":
				$this->doctype="f";
				break;
		}

		switch($this->doctype){
			case "s":
				$this->docTypeLong="Strict";
				break;
			case "t":
				$this->docTypeLong="Transitional";
				break;
			case "f":
				$this->docTypeLong="Frameset";
				break;
		}
	}


	/**
	 *  Check if the HTML element exists.
	 *
	 *  @param string $element HTML element to be checked
	 */
	public function element_exists($element){
		$ret=array_key_exists($element,$this->Html_Elements);
		if($ret!=true)
			trigger_error("[HTML4] - not valid HTML element: >$element<", E_USER_WARNING);
		return $ret;
	}


	/**
	 *  Check if the attrtibute exists for element, and optional if the value is permitted.
	 *
	 *  @param string $element HTML element to be checked
	 *  @param string $attribute HTML attribute to be checked
	 *  @param string $value optional value to be tested
	 */
	public function check_attribute($element, $attribute, $value=""){
		$ret=" problem ";

		if(isset($this->universalAttrGeneral[$attribute])&&!isset($this->universalAttrGeneral[$attribute]["exception"][$element]))
			$ret=$this->_checkVmap($this->universalAttrGeneral[$attribute], $value);
		else if(isset($this->universalAttrEvent[$attribute])&&!isset($this->universalAttrEvent[$attribute]["exception"][$element]))
			$ret=$this->_checkVmap($this->universalAttrEvent[$attribute], $value);
		else if(isset($this->universalAttrInt[$attribute])&&!isset($this->universalAttrInt[$attribute]["exception"][$element]))
			$ret=$this->_checkVmap($this->universalAttrInt[$attribute], $value);
		else if(array_key_exists($element,$this->Html_Elements)
				&& array_key_exists($attribute,$this->Html_Elements[$element]["attributes"])
				&& in_array($this->doctype,$this->Html_Elements[$element]["attributes"][$attribute]["dtype"]))
			$ret=$this->_checkVmap($this->Html_Elements[$element]["attributes"][$attribute],$value);
		else
			$ret="attribute not allowed in doctype " . $this->docTypeLong;

		if($ret!==true)
			trigger_error("[HTML4] - " . $ret . ": elem=$element, attr=$attribute, val=$value<br>", E_USER_NOTICE);
		return $ret;
	}


	/** @ignore */
	private function _checkVmap($ar, $value){
		$vmap="";
		if(isset($ar["vmap"])){
			$vmap=$ar["vmap"];
			if(in_array($value,$vmap)&&is_string($value))
				return true;
			if(in_array("#CDATA",$vmap)&&(is_string($value)||is_int($value)))
				return true;
			if(in_array("#ID",$vmap)&&is_string($value))
				return true;
			if(in_array("#NAME",$vmap)&&is_string($value))
				return true;
			if(in_array("#INT",$vmap)&&is_int($value))
				return true;
		}
		else
			trigger_error("[HTML4] - vmap missing for " . $attr, E_USER_ERROR);
		return "incorrect value, should be one of (" . implode(",", $vmap) . ")";
	}


	/**
	 *  Check settings for a specific HTML element.
	 *
	 *  @param string $htype HTML element to be checked
	 *  @param string $attributes HTML attribute to be checked
	 *  @param string $childs if element has childs, check them as well
	 */
	public function check_element($htype, $attributes, $childs){
		//first, check if all required attributes are present
		$_keys=array_keys($this->Html_Elements[$htype]["attributes"]);
		$_size=count($_keys);
		$userKeys=$attributes->keys();
		for($i=0;$i<$_size;$i++){
			$err=false;
			if($htype=="a"&&($_keys[$i]=="href"||$_keys[$i]=="name")){
				//exception for <a>, where either href or name must be present (and name is dropped in favour of id in xhtml 1.1)
				if((!in_array("href",$userKeys))&&(!in_array("name",$userKeys))&&(!in_array("id",$userKeys)))
					$err=true;
			}
			else if($this->Html_Elements[$htype]["attributes"][$_keys[$i]]["required"]==true){
				if(!in_array($_keys[$i],$userKeys))
					$err=true;
			}
			if($err==true)
				trigger_error("[HTML4] - missing required attribute " . $_keys[$i] . " for element " . $htype, E_USER_WARNING);
		}

		//now check attribute values
		$_keys=$attributes->keys();
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			$this->check_attribute($htype,$_keys[$i],$attributes->get($_keys[$i]));
		}

		//now check the child objects, first test if they are defined HTML4 objects then if they are allowed child elements of $htype
		$_keys=$childs->keys();
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if($this->element_exists($_keys[$i])!=true)
				trigger_error("Attempt to instantiate Html4_BaseElement for non-standard element: $element", E_USER_WARNING);
			$this->check_child_element($htype,$_keys[$i]);
		}
	}


	/**
	 *  Check child elements.
	 *
	 *  @param string $element HTML element to be checked
	 *  @param string $childs if element has childs, check them as well
	 */
	public function check_child_element($element, $child){
		$ret=false;
		if(array_key_exists($element,$this->Html_Elements)){
			if(array_key_exists("childElems",$this->Html_Elements[$element])&&
						is_array($this->Html_Elements[$element]["childElems"])&&
						array_key_exists($child,$this->Html_Elements[$element]["childElems"])&&
						in_array($this->doctype,$this->Html_Elements[$element]["childElems"][$child]))
				$ret=true;
			else if(array_key_exists("acceptBlock",$this->Html_Elements[$element])&&
						array_key_exists($child, $this->blockElements)&&
						in_array($this->doctype,$this->blockElements[$child]))
				$ret=true;
			else if(array_key_exists("acceptInline",$this->Html_Elements[$element])&&
						array_key_exists($child, $this->inlineElements)&&
						in_array($this->doctype,$this->inlineElements[$child]))
				$ret=true;
		}
		if($ret==false)
			trigger_error("[HTML4] - not valid child element: >$child< for >$element<", E_USER_WARNING);
		return $ret;
	}


	private $Html_Elements=array(
		"a" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"attributes"   => array("accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charset"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"coords"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"href"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"hreflang"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"rel"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"rev"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"shape"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("rect","circle","poly","default")),  
									"tabindex"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"target"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("_blank","_parent","_self","_top")),
									"type"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"abbr" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"acronym" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"address" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array("p" => array(    "t")),
			"attributes"   => array()),

		"applet" => array(
			"dtype" => array(    "t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"childElems"   => array("param" => array(    "t","f")),
			"attributes"   => array("align"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("top","middle","bottom","left","right")),
									"alt"      => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"archive"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"code"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"codebase" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"height"   => array("dtype" => array(    "t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"hspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"object"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"vspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"    => array("dtype" => array(    "t","f"), "required" => true,  "vmap" => array("#CDATA")))),

		"area" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("alt"       => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"coords"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"href"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"nohref"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("nohref", "")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"shape"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("rect","circle","poly","default")),  
									"tabindex"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"target"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("_blank","_parent","_self","_top")))),

		"b" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"base" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("href"   => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"target" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"basefont" => array(
			"dtype" => array(    "t","f"),
			"childElems"   => array(),
			"attributes"   => array("color" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"face"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"size"  => array("dtype" => array(    "t","f"), "required" => true,  "vmap" => array("#CDATA")))),

		"bdo" => array("dtype" => array("s","t","f"), "acceptInline" => false, "childElems" => array(), "attributes" => array()),

		"big" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"blockquote" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array("script" => array("s")),
			"attributes"   => array("cite" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"body" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("alink"      => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"background" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"bgcolor"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"link"       => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onload"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onunload"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"text"       => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"vlink"      => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"br" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("clear" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","all","right","none")))),

		"button" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"childElems"   => array("abbr"       => array("s","t","f"),
									"acronym"    => array("s","t","f"),
									"address"    => array("s","t","f"),
									"applet"     => array("s","t","f"),
									"b"          => array("s","t","f"),
									"basefont"   => array("s","t","f"),
									"bdo"        => array("s","t","f"),
									"big"        => array("s","t","f"),
									"blockquote" => array("s","t","f"),
									"br"         => array("s","t","f"),
									"center"     => array("s","t","f"),
									"cite"       => array("s","t","f"),
									"code"       => array("s","t","f"),
									"dfn"        => array("s","t","f"),
									"dl"         => array("s","t","f"),
									"dir"        => array("s","t","f"),
									"div"        => array("s","t","f"),
									"em"         => array("s","t","f"),
									"font"       => array("s","t","f"),
									"h1-6"       => array("s","t","f"),
									"hr"         => array("s","t","f"),
									"i"          => array("s","t","f"),
									"img"        => array("s","t","f"),
									"kbd"        => array("s","t","f"),
									"map"        => array("s","t","f"),
									"menu"       => array("s","t","f"),
									"noframes"   => array("s","t","f"),
									"noscript"   => array("s","t","f"),
									"object"     => array("s","t","f"),
									"ol"         => array("s","t","f"),
									"p"          => array("s","t","f"),
									"pre"        => array("s","t","f"),
									"q"          => array("s","t","f"),
									"samp"       => array("s","t","f"),
									"script"     => array("s","t","f"),
									"small"      => array("s","t","f"),
									"span"       => array("s","t","f"),
									"strong"     => array("s","t","f"),
									"sub"        => array("s","t","f"),
									"sup"        => array("s","t","f"),
									"table"      => array("s","t","f"),
									"tt"         => array("s","t","f"),
									"ul"         => array("s","t","f"),
									"var"        => array("s","t","f")),
			"attributes"   => array("accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"disabled"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"name"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"tabindex"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"type"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("button","submit","reset")),
									"value"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"caption" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","bottom","left","right")))),

		"center" => array("dtype" => array(    "t","f"), "acceptBlock" => true, "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"cite" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"code" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"col" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"childElems"   => array(),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"span"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")),
									"width"   => array("dtype" => array("s", "t","f", "required" => false, "vmap" => array("#CDATA")),))),

		"colgroup" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"childElems"   => array("col" => array("s","t","f")),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"span"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")),
									"width"   => array("dtype" => array("s", "t","f", "required" => false, "vmap" => array("#CDATA")),))),

		"dd" => array("dtype" => array("s","t","f"), "acceptBlock" => true, "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"del" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("cite"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"datetime" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"dfn" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"dir" => array(
			"dtype" => array(    "t","f"),
			"childElems"   => array("li" => array(    "t","f")),
			"attributes"   => array("compact" => array("dtype" => array("s","t","f")))),

		"div" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")))),

		"dl" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("dd" => array("s","t","f"),
									"dt" => array("s","t","f")),
			"attributes"   => array("compact" => array("dtype" => array("s","t","f")))),

		"dt" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"em" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"fieldset" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array("legend" => array("s","t","f")),
			"attributes"   => array()),

		"font" => array(
			"dtype" => array(    "t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("color"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"face"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"size"    => array("dtype" => array(    "t","f"), "required" => true,  "vmap" => array("#CDATA")),)),

		"form" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("action"         => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"accept"         => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"accept-charset" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"enctype"        => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"method"         => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("get","post")),
									"name"           => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onreset"        => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onsubmit"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"target"         => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("_blank","_parent","_self","_top")))),

		"frame" => array(
			"dtype" => array(    "t","f"),
			"childElems"   => array(),
			"attributes"   => array("frameborder"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("1","0")),
									"longdesc"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"marginwidth"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"marginheight" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"         => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"noresize"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("noresize", "")),
									"scrolling"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("yes","no ","auto")),
									"src"          => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"frameset" => array(
			"dtype" => array(        "f"),
			"childElems"   => array("frame"    => array(    "t","f"),
									"frameset" => array(    "t","f"),
									"noframes" => array(    "t","f")),
			"attributes"   => array("cols"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onload "  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onunload" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"rows"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"h1" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"h2" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"h3" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"h4" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"h5" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"h6" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify")))),

		"head" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("base"    => array("s","t","f"),
									"isindex" => array(    "t"),
									"link"    => array("s","t","f"),
									"meta"    => array("s","t","f"),
									"object"  => array("s","t","f"),
									"script"  => array("s","t","f"),
									"style"   => array("s","t","f"),
									"title"   => array("s","t","f")),
			"attributes"   => array("profile" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"hr" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("align"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right")),
									"noshade" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("noshade", "")),
									"size"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"html" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("head"     => array("s","t","f"),
									"body"     => array("s","t","f"),
									"frameset" => array(        "f")),
			"attributes"   => array("version" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("")))),

		"i" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"iframe" => array(
			"dtype" => array(    "t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("align"        => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("top","middle","bottom","left","right")),
									"frameborder"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("1","0")),
									"height"       => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"longdesc"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"marginwidth"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"marginheight" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"         => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"scrolling"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("yes","no","auto")),
									"src"          => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"        => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"img" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("align"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("top","middle","bottom","left","right")),
									"alt"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"border"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"height"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"hspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"ismap"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("ismap", "")),
									"longdesc" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"src"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"usemap"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"vspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),)),

		"input" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("accept"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"align"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("top","middle","bottom","left","center","right")),
									"alt"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"checked"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("checked", "")),
									"disabled"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"ismap"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("ismap", "")),
									"maxlength" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"name"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onchange"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onselect"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"readonly"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("readonly", "")),
									"size"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"src"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"tabindex"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"type"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("text","password","checkbox","radio","submit","reset","file","hidden","image","button")),
									"usemap"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"value"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"ins" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("cite"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"datetime" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"isindex" => array(
			"dtype" => array(    "t","f"),
			"childElems"   => array(),
			"attributes"   => array("prompt" => array("dtype" => array(    "t","f")))),

		"kbd" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"label" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"for"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#IDREF")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),)),

		"legend" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"align"     => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","top","right","bottom")))),

		"li" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"attributes"   => array("type"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("disc","square","circle","1","a","A","i","I")),
									"value" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#INT")))),

		"link" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("charset"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"href"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"hreflang" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"media"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"rel"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"rev"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"target"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("_blank","_parent","_self","_top")),
									"type"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"map" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"childElems"   => array("area" => array("s","t","f")),
			"attributes"   => array("name" => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")))),

		"menu" => array(
			"dtype" => array(    "t","f"),
			"childElems"   => array("li" => array(    "t","f")),
			"attributes"   => array("compact" => array("dtype" => array(    "t","f")))),

		"meta" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("name"       => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"content"    => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"http-equiv" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#NAME")),
									"scheme"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#NAME")))),

		"noframes" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array("tbody" => array(        "f")),
			"attributes"   => array()),

		"noscript" => array("dtype" => array("s","t","f"), "acceptBlock" => true, "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"object" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"childElems"   => array("param" => array("s","t","f")),
			"attributes"   => array("align"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("top","middle","bottom","left","right")),
									"archive"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"border"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"classid"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"codebase" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"codetype" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"data"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"declare"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("declare", "")),
									"height"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"hspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"name"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"standby"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"tabindex" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"type"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"usemap"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"vspace"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"ol" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"childElems"   => array("li" => array("s","t","f")),
			"attributes"   => array("compact" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("compact", "")),
									"start"   => array("dtype" => array(    "t","f"),   "required" => false, "vmap" => array("start", "")),
									"type"    => array("dtype" => array(    "t","f"),    "required" => false, "vmap" => array("1","a","A","i","I")))),

		"optgroup" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("option" => array("s","t","f")),
			"attributes"   => array("disabled" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"label"    => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")))),

		"option" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("disabled" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"label"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"selected" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("selected", "")),
									"value"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"p" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"attributes"   => array("align" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")))),

		"param" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("id"        => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#ID")),
									"name"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")),
									"value"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"valuetype" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("data","ref","object")),
									"type"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"pre" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("a"        => array("s","t","f"),
									"abbr"     => array("s","t","f"),
									"acronym"  => array("s","t","f"),
									"applet"   => array("s","t","f"),
									"b"        => array("s","t","f"),
									"bdo"      => array("s","t","f"),
									"br"       => array("s","t","f"),
									"button"   => array("s","t","f"),
									"cite"     => array("s","t","f"),
									"code"     => array("s","t","f"),
									"dfn"      => array("s","t","f"),
									"em"       => array("s","t","f"),
									"i"        => array("s","t","f"),
									"input"    => array("s","t","f"),
									"iframe"   => array("s","t","f"),
									"kbd"      => array("s","t","f"),
									"label"    => array("s","t","f"),
									"map"      => array("s","t","f"),
									"q"        => array("s","t","f"),
									"samp"     => array("s","t","f"),
									"script"   => array("s","t","f"),
									"select"   => array("s","t","f"),
									"span"     => array("s","t","f"),
									"strong"   => array("s","t","f"),
									"textarea" => array("s","t","f"),
									"tt"       => array("s","t","f"),
									"var"      => array("s","t","f")),
			"attributes"   => array("width" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#INT")))),

		"q" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array("cite" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"s" => array("dtype" => array(    "t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"samp" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"script" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("charset"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"defer"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("defer", "")),
									"event"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"language" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"for"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#IDREF")),
									"src"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"type"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")))),

		"select" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("optgroup" => array("s","t","f"),
									"option"   => array("s","t","f")),
			"attributes"   => array("disabled" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"multiple" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("multiple", "")),
									"name"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onblur"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onchange" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"size"     => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"tabindex" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")))),

		"small" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"span" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"strike" => array("dtype" => array(    "t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"strong" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"style" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array("media" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"title" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")), //### should be universal
									"type" => array("dtype"  => array("s","t","f"), "required" => true,  "vmap" => array("#CDATA")))),

		"sub" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array()),

		"sup" => array(
			"dtype" => array("s","t","f"),
			"acceptInline" => true,
			"childElems"   => array(),
			"attributes"   => array()),

		"table" => array(
			"childElems"   => array("tr"       => array("s","t","f"),
									"thead"    => array("s","t","f"),
									"tfoot"    => array("s","t","f"),
									"tbody"    => array("s","t","f"),
									"caption"  => array("s","t","f"),
									"col"      => array("s","t","f"),
									"colgroup" => array("s","t","f")),
			"attributes"   => array("align"       => array("dtype" => array(     "t","f"), "required" => false, "vmap" => array("left","center","right","justify")),
									"border"      => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"bgcolor"     => array("dtype" => array(     "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"cellpadding" => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"cellspacing" => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"frame"       => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("void","above","below","hsides","lhs","rhs","vsides","box","border")),
									"rules"       => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("none","groups","rows","cols","all")),
									"summary"     => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"width"       => array("dtype" => array("s", "t","f"), "required" => false, "vmap" => array("#CDATA")),)),

		"tbody" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("tr" => array("s","t","f")),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center2","right","justify","char")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")))),

		"td" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"attributes"   => array("abbr"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")),
									"axis"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"bgcolor" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"colspan" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"headers" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#IDREFS")),
									"height"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"nowrap"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("nowrap", "")),
									"rowspan" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"scope"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("row","col","rowgroup","colgroup")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")),
									"width"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),)),

		"textarea" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => false,
			"acceptInline" => false,
			"attributes"   => array("accesskey" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"cols"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#INT")),
									"disabled"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("disabled", "")),
									"name"      => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onblur"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onchange"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onfocus"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"onselect"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"readonly"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("readonly", "")),
									"rows"      => array("dtype" => array("s","t","f"), "required" => true,  "vmap" => array("#INT")),
									"tabindex"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")))),

		"tfoot" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("tr" => array("s","t","f")),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center2","right","justify","char")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")))),

		"th" => array(
			"dtype" => array("s","t","f"),
			"acceptBlock"  => true,
			"acceptInline" => true,
			"attributes"   => array("abbr"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")),
									"axis"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"bgcolor" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"colspan" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"headers" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#IDREFS")),
									"height"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"nowrap"  => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("nowrap", "")),
									"rowspan" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#INT")),
									"scope"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("row","col","rowgroup","colgroup")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")),
									"width"   => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),)),

		"thead" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("tr" => array("s","t","f")),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center2","right","justify","char")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")))),

		"title" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array(),
			"attributes"   => array()),

		"tr" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("td" => array("s","t","f"),
									"th" => array("s","t","f")),
			"attributes"   => array("align"   => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("left","center","right","justify","char")),
									"bgcolor" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("#CDATA")),
									"char"    => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"charoff" => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("#CDATA")),
									"valign"  => array("dtype" => array("s","t","f"), "required" => false, "vmap" => array("top","middle","bottom","baseline")))),

		"tt" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"u"  => array("dtype" => array(    "t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

		"ul" => array(
			"dtype" => array("s","t","f"),
			"childElems"   => array("li" => array("s","t","f")),
			"attributes"   => array("compact" => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("compact", "")),
									"type"    => array("dtype" => array(    "t","f"), "required" => false, "vmap" => array("disc","square","circle")))),

		"var" => array("dtype" => array("s","t","f"), "acceptInline" => true, "childElems" => array(), "attributes" => array()),

	);


	private $universalAttrGeneral=array(
		"class" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("base", "basefont", "head", "html", "meta", "param", "script", "style", "title")),
		"id"    => array("vmap" => array("#ID"),    "required" => false, "exception" => array("base",             "head", "html", "meta",          "script", "style", "title")),
		"style" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("base", "basefont", "head", "html", "meta", "param", "script", "style", "title")),
		"title" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("base", "basefont", "head", "html", "meta", "param", "script", "style", "title")),
	);


	private $universalAttrInt=array(
		"dir"  => array("vmap" => array("ltr","rtr"), "required" => false, "exception" => array("applet", "base", "basefont", "br", "frame", "frameset", "hr", "iframe",         "param", "script")),
		"lang" => array("vmap" => array("#CDATA"),    "required" => false, "exception" => array("applet", "base", "basefont", "br", "frame", "frameset", "hr", "iframe", "meta", "param", "script")),
	);


	private $universalAttrEvent=array(
		"onclick"     => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"ondblclick"  => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onmousedown" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onmouseup"   => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onmouseover" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onmousemove" => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onmouseout"  => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onkeypress"  => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onkeydown"   => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
		"onkeyup"     => array("vmap" => array("#CDATA"), "required" => false, "exception" => array("applet", "base", "basefont", "bdo", "br", "font", "frame", "frameset", "head", "html", "iframe", "isindex", "param", "script", "style", "title")),
	);


	private $blockElements=array(
		"address"    => array("s","t","f"),
		"blockquote" => array("s","t","f"),
		"center"     => array(    "t"),
		"del"        => array("s","t","f"),
		"dir"        => array(    "t"),
		"div"        => array("s","t","f"),
		"dl"         => array("s","t","f"),
		"fieldset"   => array("s","t","f"),
		"form"       => array("s","t","f"),
		"h1"         => array("s","t","f"),
		"h2"         => array("s","t","f"),
		"h3"         => array("s","t","f"),
		"h4"         => array("s","t","f"),
		"h5"         => array("s","t","f"),
		"h6"         => array("s","t","f"),
		"hr"         => array("s","t","f"),
		"ins"        => array("s","t","f"),
		"isindex"    => array(    "t"),
		"menu"       => array(    "t"),
		"noframes"   => array(    "t"),
		"noscript"   => array("s","t","f"),
		"ol"         => array("s","t","f"),
		"p"          => array("s","t","f"),
		"pre"        => array("s","t","f"),
		"table"      => array("s","t","f"),
		"ul"         => array("s","t","f"),
	);


	private $inlineElements=array(
		"a"        => array("s","t","f"),
		"abbr"     => array("s","t","f"),
		"acronym"  => array("s","t","f"),
		"applet"   => array(    "t"),
		"b"        => array("s","t","f"),
		"basefont" => array(    "t"),
		"bdo"      => array("s","t","f"),
		"big"      => array("s","t","f"),
		"br"       => array("s","t","f"),
		"button"   => array("s","t","f"),
		"cite"     => array("s","t","f"),
		"code"     => array("s","t","f"),
		"del"      => array("s","t","f"),
		"dfn"      => array("s","t","f"),
		"em"       => array("s","t","f"),
		"font"     => array(    "t"),
		"i"        => array("s","t","f"),
		"img"      => array("s","t","f"),
		"ins"      => array("s","t","f"),
		"input"    => array("s","t","f"),
		"iframe"   => array(    "t"),
		"kbd"      => array("s","t","f"),
		"label"    => array("s","t","f"),
		"map"      => array("s","t","f"),
		"object"   => array("s","t","f"),
		"q"        => array("s","t","f"),
		"s"        => array(    "t"),
		"samp"     => array("s","t","f"),
		"script"   => array("s","t","f"),
		"select"   => array("s","t","f"),
		"small"    => array("s","t","f"),
		"span"     => array("s","t","f"),
		"strike"   => array(    "t"),
		"strong"   => array("s","t","f"),
		"sub"      => array("s","t","f"),
		"sup"      => array("s","t","f"),
		"textarea" => array("s","t","f"),
		"tt"       => array("s","t","f"),
		"u"        => array(    "t"),
		"var"      => array("s","t","f"),
	);
}
?>