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
 * Base class for HTML Element classes
 *
 * @package    Classes.HTML4
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Html4_Base{
	/**
	 *  The type of the HTML Element, i.e. the HTML element <table> = "table"
	 *  @var string
	 */
	protected $htype;


	/**
	 *  HTML attributes of the HTML Element. Attributes are stored as array("attribute"=>"value")
	 *  @var array
	 */
	protected $attributes;


	/**
	 *  Array with configuration parameter for the Element. Configuration parameters are stored as array("parameter"=>"value")
	 *  @var array
	 */
	protected $parameters;


	/**
	 *  Content of the HTML Element. Content can be either a string or an object. Content can be added with an index (objectID) or without index.
	 *  @var array
	 */
	protected $content;


	/**
	 *  Object ID of the Element instance.
	 *  @var string
	 */
	protected $obj_id;


	/**
	 *  boolean value indicating that the HTML element is empty (i.e. no explicit closing tag)
	 *  @var boolean
	 */
	protected $hempty;


	/**
	 * Constructor for an HTML4 Element.
	 *
	 * Valid HTML4 elements are:
	 * <table>
	 *   <tr><td><b>htype</b></td><td width="30%"><b>HTML Element</b></td><td width="40%"><b>Description</b></td><td><b>HTML Variants</b></td></tr>
	 *   <tr><td>a</td><td>&lt;a&gt; Anchor &lt;/a&gt;</td><td>Defines an anchor (link, hyper link) referenced by the attribute href.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>abbr</td><td>&lt;abbr&gt; Abbreviation &lt;/abbr&gt;</td><td></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>acronym</td><td>&lt;acronym&gt; Acronym &lt;/acronym&gt;</td><td>An acronym is a special type of abbreviation, usually composed of the first characters of a number words.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>address</td><td>&lt;address&gt; Address &lt;/address&gt;</td><td></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>applet</td><td>&lt;applet&gt; Applet &lt;/applet&gt;</td><td></td><td>transitional, frameset</td></tr>
	 *   <tr><td>area</td><td>&lt;area /&gt; - Area within an image</td><td>Defines a fragment (<i>area</i>) for a link-sensitive image.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>bold</td><td>&lt;b&gt; Bold Text &lt;/b&gt;</td><td>Marks text to be displayed <i>bold</i>.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>base</td><td>&lt;base /&gt; - Base Link</td><td>Defines target window and base URIs of links for a complete document.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>basefont</td><td>&lt;basefont /&gt; - Base font</td><td>Defines basic font characteristics for the following text.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>bdo</td><td>&lt;bdo&gt; BDO &lt;/bdo&gt; - Text direction</td><td>Marks changes in the direction (ltr or rtl) of text for languages with different directions. It is intended for use when &lt;dir&gt; is problematic.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>big</td><td>&lt;big&gt; Big Text &lt;/big&gt;</td><td>Marks text to be displayed <i>bigger</i> then normal.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>blockquote</td><td>&lt;blockquote&gt; Blockqoute &lt;/blockquote&gt;</td><td>Marks text as <i>quote</i>.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>body</td><td>&lt;body&gt; HTML Dcoument Body &lt;/body&gt;</td><td>Defines the <i>body</i> part of an HTML document.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>br</td><td>&lt;br /&gt; single line BReak</td><td>Generates a line <i>br</i>eak.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>button</td><td>&lt;button&gt; Form Click-Button &lt;/button&gt;</td><td>Generates a click <i>button</i>.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>caption</td><td>&lt;caption&gt; Table Caption &lt;/caption&gt;</td><td>Sets a caption for a table.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>center</td><td>&lt;center&gt; Centered elements &lt;/center&gt;</td><td>Marks text to be displayed <i>center</i>d.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>cite</td><td>&lt;cite&gt; Cite &lt;/cite&gt;</td><td>Marks a citation. For qoutes (citation with refrence) use "q".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>code</td><td>&lt;code&gt; Source-Code &lt;/code&gt;</td><td>Marks source <i>code</i>.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>col</td><td>&lt;col /&gt;</td><td>Defines characteristics of a table column.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>colgroup</td><td>&lt;colgroup&gt; Colgroup (of a table) &lt;/colgroup&gt;</td><td>Defines groups of table columns.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>dd</td><td>&lt;dd&gt; Definition List Definition &lt;/dd&gt;</td><td>Marks a definition within a definition list ("dl"). Terms are marked by "dt".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>del</td><td>&lt;del&gt; Deleted Text &lt;/del&gt;</td><td>Marks text as being removed, similar to change bars in text processing systems.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>dfn</td><td>&lt;dfn&gt; Definition &lt;/dfn&gt;</td><td>Marks a definition.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>dir</td><td>&lt;dir&gt; Directory List &lt;/dir&gt;</td><td>A directory list. </td><td>transitional, frameset</td></tr>
	 *   <tr><td>div</td><td>&lt;div&gt; Division &lt;/div&gt;</td><td>Defines a container or <i>division</i>, which is intended to be used with CSS formats.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>dl</td><td>&lt;dl&gt; Definition List &lt;/dl&gt;</td><td>A <i>d</i>efinition <i>l</i>ist. Definitions are defined by "dd" and definition terms are defined by "dt".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>dt</td><td>&lt;dt&gt; Definition Term &lt;/dt&gt;</td><td>A <i>d</i>efinition <i>t</i>erm in a definition list ("dl").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>em</td><td>&lt;em&gt; Emphasised Text &lt;/em&gt;</td><td><i>emphasised</i> text. For text stronger than em use "strong".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>fieldset</td><td>&lt;fieldset&gt; Fieldset &lt;/fieldset&gt;</td><td>Marks a group of elements (block-elements and inline-elements). Requires "legend".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>font</td><td>&lt;font&gt; Font &lt;/font&gt;</td><td>Defines font characteristics (size, color, type, etc.).</td><td>transitional, frameset</td></tr>
	 *   <tr><td>form</td><td>&lt;form&gt; Form &lt;/form&gt;</td><td>Defines a <i>form</i></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>frame</td><td>&lt;frame /&gt; - Frame</td><td>Defines a <i>frame</i> window</td><td>frameset</td></tr>
	 *   <tr><td>frameset</td><td>&lt;frameset&gt; Set of Frames &lt;/frameset&gt;</td><td>Defines a set of frames and defines characteristics for displaying them.</td><td>frameset</td></tr>
	 *   <tr><td>h1</td><td>&lt;h1&gt; Heading Level 1 &lt;/h1&gt;</td><td>Level 1 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>h2</td><td>&lt;h2&gt; Heading Level 2 &lt;/h2&gt;</td><td>Level 2 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>h3</td><td>&lt;h3&gt; Heading Level 3 &lt;/h3&gt;</td><td>Level 3 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>h4</td><td>&lt;h4&gt; Heading Level 4 &lt;/h4&gt;</td><td>Level 4 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>h5</td><td>&lt;h5&gt; Heading Level 5 &lt;/h5&gt;</td><td>Level 5 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>h6</td><td>&lt;h6&gt; Heading Level 6 &lt;/h6&gt;</td><td>Level 6 heading</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>head</td><td>&lt;head&gt; HTML Document Head &lt;/head&gt;</td><td>Defines the head of an HTML document.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>hr</td><td>&lt;hr /&gt; - Horizontal Rule</td><td>Generates a horizontal rule.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>html</td><td>&lt;html&gt; Html &lt;/html&gt;</td><td>Root element of every HTML page.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>i</td><td>&lt;i&gt; Italic Text &lt;/i&gt;</td><td>Marks text to be displayed italic.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>frame</td><td>&lt;iframe&gt; Inline Frame &lt;/iframe&gt;</td><td>Defines in inline frame.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>img</td><td>&lt;img /&gt; - Image</td><td>Reference to an image.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>input</td><td>&lt;input /&gt; - Form Input</td><td>Defines an element of a form ("form"). The actual type (radio button, checkbox, click button, file upload, hidden, submit/reset button) is defined by its attributes.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>ins</td><td>&lt;ins&gt; Inserted Text &lt;/ins&gt;</td><td>Marks text as inserted, similar to change bars in text processing systems.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>isindex</td><td>&lt;isindex /&gt; - Index for search operation within HTML documents</td><td>Deprecated, do not use it anymore!</td><td>transitional, frameset</td></tr>
	 *   <tr><td>kbd</td><td>&lt;kbd&gt; Keyboard (user input) &lt;/kbd&gt;</td><td>Marks text as being input from the user (from the keyboard).</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>label</td><td>&lt;label&gt; Form-Label &lt;/label&gt;</td><td>Associates text with a specific form field.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>legend</td><td>&lt;legend&gt; Field Legend &lt;/legend&gt;</td><td>Defines a heading for a group of form elements ("fieldset").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>li</td><td>&lt;li&gt; List Item &lt;/li&gt;</td><td>A list item. The actual list can be unordered ("ul"), ordered ("ol"), menu ("menu") or directory ("dir").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>link</td><td>&lt;link /&gt; - Link to external data</td><td>Defines a logical link to external data (within the head of an HTML document - "head").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>map</td><td>&lt;map&gt; (image) Map &lt;/map&gt; </td><td>Groups the definitions ("area") of a link-sensitive image.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>menu</td><td>&lt;menu&gt; Menu List &lt;/menu&gt;</td><td>Marks a menu list. List items are realised by "li".</td><td>transitional, frameset</td></tr>
	 *   <tr><td>meta</td><td>&lt;meta /&gt; - HTML Meta data</td><td>Defines meta-data for an HTML document.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>noframes</td><td>&lt;noframes&gt; Noframes Part &lt;/noframes&gt;</td><td>Provides markups if browser can not display frames.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>noscript</td><td>&lt;noscript&gt; Noscript Part &lt;/noscript&gt;</td><td>Provides markups if browser can not execut a script.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>object</td><td>&lt;object&gt; Multi-media Object &lt;/object&gt;</td><td>Defines a multi media object.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>ol</td><td>&lt;ol&gt; Ordered (numbered) List &lt;/ol&gt;</td><td>Defiens an ordered (numbered) list.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>optgroup</td><td>&lt;optgroup&gt; Menu Option Group &lt;/optgroup&gt;</td><td>Defines entries of a structured menu.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>option</td><td>&lt;option&gt; Select Option &lt;/option&gt;</td><td>Defines a single entry of a selection list (for selection lists ("select") in forms - ("form")).</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>p</td><td>&lt;p&gt; Paragraph &lt;/p&gt;</td><td>Defines a <i>paragraph</i>.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>param</td><td>&lt;param /&gt; - Parameter for multi-media object</td><td>Defines one parameter for a multi media object ("object") or JAVA applet ("applet").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>pre</td><td>&lt;pre&gt; Pre-formatted Text &lt;/pre&gt;</td><td>Defines text to be displayed pre-formatted.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>q</td><td>&lt;q&gt; Qoute (citation with reference) &lt;/q&gt;</td><td>A qoute with reference (source).</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>s</td><td>&lt;s&gt; Strikethrough Text &lt;/s&gt;</td><td>Text to be displayed strikethrough.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>samp</td><td>&lt;samp&gt; Example &lt;/samp&gt;</td><td>Marks text being an example.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>script</td><td>&lt;script&gt; Script (i.e. JavaSript) &lt;/script&gt;</td><td>Defines an area for scrips (i.e. JavaScript).</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>select</td><td>&lt;select&gt; Selection List &lt;/select&gt;</td><td>Defines a selection list. The elements of that list are defined by "option".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>small</td><td>&lt;small&gt; Small Text &lt;/small&gt;</td><td>Marks text that should be displayed smaller than normal.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>span</td><td>&lt;span&gt; Span &lt;/span&gt;</td><td>Defines an inline area for special formatting, i.e. using CSS.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>strike</td><td>&lt;strike&gt; Strikethrough Text &lt;/strike&gt;</td><td>Text to be displayed strikethrough.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>strong</td><td>&lt;strong&gt; Strong Text &lt;/strong&gt;</td><td>Marks text that should be displayed <i>strong</i>, which is stronger than "em".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>style</td><td>&lt;style&gt; Stylesheet Information &lt;/style&gt;</td><td>Area for stylesheet definitions, i.e. CSS.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>sub</td><td>&lt;sub&gt; Subscript Text &lt;/sub&gt;</td><td></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>sup</td><td>&lt;sup&gt; Superscript Text &lt;/sup&gt;</td><td></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>table</td><td>&lt;table&gt; Table &lt;/table&gt;</td><td></td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>tbody</td><td>&lt;tbody&gt; Table Body &lt;/tbody&gt;</td><td>The body part of a table ("table").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>td</td><td>&lt;td&gt; Table Data (~cell) &lt;/td&gt;</td><td>The cell of a table ("table"), also called <i>t</i>able <i>d</i>ata.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>textarea</td><td>&lt;textarea&gt; Textarea (form) &lt;/textarea&gt;</td><td>Defines a multi-line input field.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>tfoot</td><td>&lt;tfoot&gt; Table Footer &lt;/tfoot&gt;</td><td>The footer of a table ("table").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>th</td><td>&lt;th&gt; Table Header Row &lt;/th&gt;</td><td>The header (head row) of a table ("table").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>thead</td><td>&lt;thead&gt; Table Header &lt;/thead&gt;</td><td>The header of a table ("table").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>title</td><td>&lt;title&gt; Document Title &lt;/title&gt;</td><td><i>title</i> of an HTML document.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>tr</td><td>&lt;tr&gt; Table Row &lt;/tr&gt;</td><td>The row of a table ("table").</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>tt</td><td>&lt;tt&gt; Typewriter Text &lt;/tt&gt;</td><td>Text to be displayed in type writer style.</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>u</td><td>&lt;u&gt; Underlined Text &lt;/u&gt;</td><td>Text to be displayed underlined.</td><td>transitional, frameset</td></tr>
	 *   <tr><td>ul</td><td>&lt;ul&gt; Unordered List &lt;/ul&gt;</td><td>An <i>u</i>nordered <i>l</i>ist. Elements of that list are defined by "li".</td><td>strict, transitional, frameset</td></tr>
	 *   <tr><td>var</td><td>&lt;var&gt; Variable Text &lt;/var&gt;</td><td>Marks text as a variable.</td><td>strict, transitional, frameset</td></tr>
	 * </table>
	 *
	 * @param string htype type for the HTML element, see list above for valid elements
	 * @param array attributes HTML attributes as array("attribute" => "value")
	 * @param mixed content content for the instance (mixed, object, array of mixed or array of objects)
	 * @param array parameters configuration parameters array("parameter" => "value")
	 * @param string obj_id identifier the instance
	 */
	public function __construct($htype, $attributes=false, $content=false, $parameters=false, $obj_id=false){
		$html4_cfg=SKB_Main::get_instance();

		$this->htype=$htype;
		$this->hempty=false;
		$_emptyAr=array("area","base","basefont","br","col","frame","hr","img","input","isindex","link","meta","param");
		if(in_array($htype,$_emptyAr))
		$this->hempty=true;

		$this->content=array();
		$this->attributes=array();
		$this->parameters=array(
			"this"       => "Html4_Base",
			"html4-std"  => $html4_cfg->configuration->get_group("html4","server-active"),
			"optimise"   => $html4_cfg->configuration->get_group("html4","optimise-output"),
			"obj_id"     => false,
			"indent"     => 2,
			"use-indent" => true,
			"inline-br"  => true,
		);
		if(is_array($parameters))
			$this->parameters=array_merge($this->parameters,$parameters);
		$this->set("obj_id",$obj_id);
		if($content!="")
			$this->add_child($content);
		$this->set($attributes);

		if(in_array("Html4_Standard",get_declared_classes())){
			$glob=$this->parameters["html4-std"];
			global $$glob;
			if(is_object($$glob))
				$$glob->element_exists($this->htype);
    	}
	}


	/**
	 *  Set attribute value(s).
	 *
	 *  The key is searched in the local configuration array first ($this->parameters)
	 *  and in the local html attribute array next ($this->attributes).
	 *
	 *  @param mixed $key the attribute key. If $key is an array, we assume that this array represents (key,value) pairs
	 *  @param mixed $val the new value of the attribute $key.
	 */
	public function set($key, $val=""){
		if(is_array($key)){
			while(list($k, $v) = each($key))
				$this->_set($k,$v);
		}
		else if(is_string($key)&&$key!=""){
			$this->_set($key, $val);
		}
		else if(is_int($key))
			$this->_set($key, $val);
		else
			return -1;
	}


	private function _set($key, $val){
		$ret=true;
		if(isset($this->parameters[$key]))
			$this->parameters[$key]=$val;
		else
			$this->attributes[$key]["value"]=$val;
		return $ret;
	}


	/**
	 *  Add configuration parameter(s).
	 *
	 *  @param mixed $key the attribute key. If $key is an array, we assume that this array represents (key,value) pairs
	 *  @param mixed $val the new value of the attribute $key.
	 */
	public function add_param($key, $val=""){
		if(is_array($key))
			while(list($k, $v) = each($key))
				$this->_add_param($k,$v);
		else
			$this->_add_param($key, $val);
	}


	private function _add_param($key, $val){
		if(!isset($this->parameters[$key]))
			$this->parameters[$key]=$val;
	}


	/**
	 *  Get HTML attribute value(s) and/or Configuration parameter value(s).
	 *
	 *  Returns the value of the key $key searching in the HTML attribute array first and the configuration array next.
	 *  If $key is empty, both arrays are returned.
	 *
	 *  @param mixed $key the attribute/parameter key
	 *  @return mixed value of the attribute/parameter $key or array with all HTML attributes and all configuration parameters
	 */
	public function get($key=false){
		$ret=false;
		if($key===false)
			$ret=array("attributes" => $this->attributes, "parameters" => $this->parameters);
		else{
			if(isset($this->attributes[$key])&&isset($this->attributes[$key]["value"]))
				$ret=$this->attributes[$key]["value"];
			else if(isset($this->attributes[$key])&&!isset($this->attributes[$key]["value"]))
				$ret="";
			else if(isset($this->parameters[$key]))
				$ret=$this->parameters[$key];
		}
		return $ret;
	}


	/**
	 *  Return the keys of the content array.
	 *
	 *  @return array array_keys($this->content)
	 */
	public function keys(){
		return array_keys($this->content);
	}


	/**
	 *  return the keys of the content array
	 *
	 *  @return array array_keys($this->content)
	 */
	public function child_h_types(){
		$ret=new Util_ArType();
		$_keys=array_keys($this->content);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if(is_object($this->content[$_keys[$i]]))
				$ret->add($this->content[$_keys[$i]]->htype());
		}
		return $ret;
	}


	/**
	 *  Return the keys of the attribute array.
	 *
	 *  @return array array_keys($this->attributes)
	 */
	public function attributes(){
		return array_keys($this->attributes);
	}


	/**
	 *  Return the keys and values of the attribute array.
	 *
	 *  @return array array_keys($this->attributes)
	 */
	public function attributes_w_values(){
		return new Util_ArType($this->attributes);
	}


	/**
	 *  Return the keys of the parameter array.
	 *
	 *  @return array array_keys($this->parameters)
	 */
	public function parameters(){
		return array_keys($this->parameters);
	}


	/**
	 *  Return object ID of this instance.
	 *
	 *  @return string object ID or -1
	 */
	public function obj_id(){
		return $this->get("obj_id");
	}


	/**
	 *  return html type of this instance
	 *
	 *  @return string html type
	 */
	public function htype(){
		return $this->htype;
	}


	/**
	 *  Convert object to HTML string.
	 *
	 *  @param int $indent starting level indentation (default=0)
	 *  @return string object as HTML string
	 */
	public function to_string($indent=0, $_echo=false){
		if(in_array("Html4_Standard",get_declared_classes())){
			$glob=$this->parameters["html4-std"];
			global $$glob;
			if(is_object($$glob))
				$$glob->check_element($this->htype, $this->attributes_w_values(), $this->child_h_types());
		}

	  ob_start();

		$_inlineBR=$this->parameters["inline-br"];
		$_useIndent=$this->parameters["use-indent"];
		$_indent=$this->parameters["indent"];
		if($_inlineBR==false){
			$_useIndent=false;
			$_indent==false;
		}

		$_sIndent="";
		if($_useIndent==true){
			if($_indent!==false)
				$_sIndent=str_repeat(' ', $_indent);
			if($indent!==false)
				$_sIndent.=str_repeat(' ', $indent);
		}
	
		echo $_sIndent . "<" . $this->htype;
		foreach($this->attributes as $name => $value){
			echo " " . $name;
			if($value["value"]!="")
				echo "=\"" . $value["value"] . "\"";
		}
	
		if($this->hempty==true){
		  echo " />";
		  if($_inlineBR==true)
		    echo "\n";
		}
		else{
			echo ">";
			if($_inlineBR==true)
			  echo "\n";
			foreach($this->content as $child){
				if(is_object($child))
					echo $child->to_string(strlen($_sIndent));
				else{
					if($_inlineBR==true){
						$lines=explode("\n",$child);
						foreach($lines as $line)
							echo $_sIndent, str_repeat(' ',$_indent), $line, "\n";
					}
					else
						echo $child;
				}
			}
			if($_inlineBR==true)
				echo $_sIndent;
			echo "</" . $this->htype . ">";
			if($_inlineBR==true)
				echo "\n";
		}
		$ret="";
		if($_echo==true)
			ob_end_flush();
		else{
			$ret=ob_get_contents();
			ob_end_clean();
			return $ret;
		}
	}


	/**
	 *  Prints object as HTML.
	 *
	 *  @param int $indent starting level indentation (default=0)
	 */
	public function print_html($indent=0){
		$this->to_string($indent,true);
	}


	/**
	 *  Add new child element to content array.
	 *
	 *  @param mixed $child can be an object (HTML element) or a string (#PCDATA) or an array of both types mixed
	 */
	public function add_child($child){
		if($this->hempty==true)
			return;
		if(is_array($child)){
			$_keys=array_keys($child);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++)
				$this->_add_child($child[$_keys[$i]]);
		}
		else
			$this->_add_child($child);
	}


	/** @ignore */
	private function _add_child($child){
		if(is_object($child)){
			if($child->obj_id()!==false){
				//if($this->parameters["optimise"]==true)
				//  $this->content[$child->obj_id()]=$child->to_string();
				//else
				$this->content[$child->obj_id()]=$child;
			}
			else{
				//if($this->parameters["optimise"]==true)
				//  $this->content[]=$child->to_string();
				//else
				$this->content[]=$child;
			}
		}
		else if(is_scalar($child))
			$this->content[]=$child;
	}
}
?>