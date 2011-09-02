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
 * Template for the DD builder in the SKB Package Dist.Menu.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Menu
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
	$name=(isset($entries['menu:linkname']))?$entries['menu:linkname']:"";
	if($name=="")
		$name=(isset($entries['menu:title']))?$entries['menu:title']:"";
	if($name=="")
		trigger_error("[Menu] - no name or linkname found, item '{$this->id}' might not be shown", E_USER_NOTICE);

	$link="";
	if(isset($entries["menu:url"])){
		$link=$entries["menu:url"];
		if(strstr($entries["menu:url"],"://")==false)
			$link=Util_Interpreter::interpret("url:build", $entries["menu:url"]);
	}

	$child="";
	$ret="";
	$close="";

	if(isset($entries["menu:class_b"]))
		$child.="<b class=\"{$entries["menu:class_b"]}\"></b>";
	if($entries['level']==1&&isset($entries['_children']))
		$child.="<span class=\"span_top drop\">$name</span>";
	else if($entries['level']==1)
		$child.="<span class=\"span_top\">$name</span>";
	else
		$child.="<span>$name</span>";

	if($link!=""){
			$ret="<a href=\"$link\"";
			$close="</a>";
	}
	else{
			$ret="<span";
			$close="</span>";
	}

	if($entries['level']==1)
		$ret.=" class=\"top_link\"";
	else if(isset($entries['_children']))
		$ret.=" class=\"fly\"";

	if(isset($entries["menu:id_a"]))
		$ret.=" id=\"{$entries["menu:id_a"]}\"";

	echo $ret.">".$child.$close;
?>
