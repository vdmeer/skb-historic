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
 * Template for the Brick builder in the SKB Package Dist.Menu.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Menu
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
?>
<div id="menu">
	<ul>
		<?php
			$entries=$entries->ar;
			if(isset($entries['/']['_children'])){
				$ar=$entries['/']['_children'];
				$_keys=array_keys($ar);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++)
					_do_entry($ar[$_keys[$i]]);
			}
		?>
	</ul>
</div>

<?php
	echo '<div id="menu-sub" class="' . $entries['/']['current-parameters']['menu:class_b'] . '">'."\n";
	echo '  <ul>'."\n";
	if(!isset($entries['/']['_children'][$entries['/']['current-position'][0]]['_children']))
		echo "&#160;";
	else{
		$ar=$entries['/']['_children'][$entries['/']['current-position'][0]]['_children'];
		$_keys=array_keys($ar);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++)
			_do_entry($ar[$_keys[$i]],false);
	}
	echo '  </ul>'."\n";
	echo '</div>'."\n";
//	Util_Debug::print_r($entries);
?>
<div id="menu-bottom">
	&#160;
</div>

<?php
	function _do_entry($ar, $top=true){
		$name=(isset($ar['menu:linkname']))?$ar['menu:linkname']:"";
		if($name=="")
			$name=(isset($ar['menu:title']))?$ar['menu:title']:"";
		if($name=="")
			trigger_error("[Menu] - no name or linkname found, item '{$ar['key']}' might not be shown", E_USER_NOTICE);
		$link="";
		if(isset($ar["menu:url"])){
			$link=$ar["menu:url"];
			if(strstr($ar["menu:url"],"://")==false)
				$link=Util_Interpreter::interpret("url:build", $ar["menu:url"]);
		}

		echo "<li";
		if($top==true&&isset($ar['active']))
			echo ' id="current" class="' . $ar['menu:class_b'] . '"';
		if($top==false&&isset($ar['active']))
			echo ' class="current"';
		echo "><a href=\"{$link}\">{$name}</a></li>\n";  
	}
?>