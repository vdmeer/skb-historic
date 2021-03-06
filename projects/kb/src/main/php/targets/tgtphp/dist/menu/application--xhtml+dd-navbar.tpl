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
  if(!isset($current_position))
    return;

  $delim=" &rsaquo;&rsaquo; ";
  $last=$request->get_value("menu:navbar_last");

  $name=(isset($entries['_children'][$current_position[0]]['menu:navbar']))?$entries['_children'][$current_position[0]]['menu:navbar']:"";
  if($name=="")
    $name=(isset($entries['_children'][$current_position[0]]['menu:title']))?$entries['_children'][$current_position[0]]['menu:title']:"";
  $name=strtolower($name);
  $link=(isset($entries['_children'][$current_position[0]]['menu:url']))?$entries['_children'][$current_position[0]]['menu:url']:-1;

  if(isset($first_key)){
    $f_name=(isset($entries['_children'][$first_key]['menu:navbar']))?$entries['_children'][$first_key]['menu:navbar']:"";
    if($f_name=="")
      $f_name=(isset($entries['_children'][$first_key]['menu:title']))?$entries['_children'][$first_key]['menu:title']:"";
    $f_link=(isset($entries['_children'][$first_key]['menu:url']))?$entries['_children'][$first_key]['menu:url']:-1;
    echo "<a href=\"{$f_link}\">{$f_name}</a> {$delim}";
  }

  if(isset($first_name)){
    echo "<span>{$first_name}</span>{$delim}";
  }

  if(count($current_position)==1){
    echo '<span>';
    if(count($last)==0)
      echo $name;
    else
      echo "<a href=\"{$link}\">{$name}</a> {$delim} {$last[0]}";
    echo '</span>';
  }
  elseif(count($current_position)>1){
  	echo '<span>';
    if($link!=-1)
      echo "<a href=\"{$link}\">{$name}</a>";
    else
      echo $name;
    echo '</span>';

    echo $delim;

    $next=new Util_Template($tpl);
    $next->set("request", $request);
    $next->set("entries", $entries['_children'][$current_position[0]]);
    array_shift($current_position);
    $next->set("current_position", $current_position);
    $next->set("tpl", $tpl);
    $next->printT();
  }
?>