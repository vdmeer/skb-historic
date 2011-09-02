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
 * Builder for the SKB Package Dist.HtmlPage, creates head, body-start and body-end for the html page.
 *
 * For examples how to use this builder, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.HtmlPage
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

class pkg_dist__htmlpage___application__xhtml___builder extends SKB_Builder{
	/**
	 * The template for the head of the html page
	 *
	 * @var $tpl_head
	 */
	protected $tpl_head="Dist.HtmlPage.Entries2XHTML-Page:Template:Head";


	/**
	 * The template for the start of the body, left empty to be overwritten by children.
	 *
	 * @var $tpl_bodystart
	 */
	protected $tpl_bodystart="";


	/**
	 * The template for the end of the bodt, left empty to be overwriteen by children.
	 *
	 * @var $tpl_bodyend
	 */
	protected $tpl_bodyend="";


	/**
	 * Class Constructor.
	 *
	 * It calls the parent class to instantiate the template repository and then 
	 * adds the local template to it.
	 */
	function __construct(){
		parent::__construct();
		$this->templates->add_template("head", $this->tpl_head);
		$this->templates->add_template("bodystart", $this->tpl_bodystart);
		$this->templates->add_template("bodyend", $this->tpl_bodyend);
	}


	/**
	 * The builder specific execute function.
	 *
	 * Automatically called by {@link SKB_Builder#execute() SKB_Builder->execute}
	 */
	public function execute_loop(SKB_Request $request, Util_ArBase $entries){
		$tpl=null;
		$todo=$request->get_value("htmlpage:execute_todo");
		if(is_array($todo)&&count($todo)>0){
			$todo=$todo[0];
			switch($todo){
				case "head":      $tpl=$this->templates->get_template_object("head"); break;
				case "bodystart": $tpl=$this->templates->get_template_object("bodystart"); break;
				case "bodyend":   $tpl=$this->templates->get_template_object("bodyend"); break;
			}
			if($tpl!=null){
				$tpl->set("request", $request);
				$tpl->set("entries", $entries);
				$tpl->printT();
			}
		}
	}
}
?>