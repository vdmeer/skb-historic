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
 * Template for the formselect builder in the SKB Package Dist.Gallery, creates select elements for cities, countries, year and fotographer.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
    function my_sort($a, $b){
  	  $mySKB=SKB_Main::get_instance();
      $lang=$mySKB->configuration->get_group("system","lang");
    	return Util_Interpreter::interpret("array:sort:nat", $a, $b, $lang);
    }

	  $mySKB=SKB_Main::get_instance();
    $lang=$mySKB->configuration->get_group("system","lang");

    $gettext=array(
      "default:city_key"        => dgettext('dist.gallery', "Cities"),         // St&auml;dte
      "default:country_key"     => dgettext('dist.gallery', "Countries"),      // L&auml;nder
      "default:year"            => dgettext('dist.gallery', "Year"),           // Jahr
      "gallery:fotographer_key" => dgettext('dist.gallery', "Photographer"),   // Fotograf
      "selected"        => dgettext('dist.gallery', "selected"),        // ausgew&auml;hlt
    );

    echo '<div class="form-select"><table><tr>';

    $entries=$entries->ar;
    $_keys=array_keys($entries);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
    	uasort($entries[$_keys[$i]], "my_sort");
      $hSelect=Html4_Element::factory("select",array("size"=>"{$size}","multiple"=>"multiple","name"=>$request->get_form_name($_keys[$i])."[]"));

      $selected=0;

      $_keysSelect=array_keys($entries[$_keys[$i]]);
      $_sizeSelect=count($_keysSelect);
      for($k=0;$k<$_sizeSelect;$k++){
        $opt=array();
        $opt['value']=$_keysSelect[$k];
        $ar=$request->get_value($_keys[$i]);
        if($ar!=-1&&Util_Interpreter::interpret("value:is_empty", $ar)==false){
        	if(!is_array($ar))
        	  $ar=array($ar);
          if(in_array($_keysSelect[$k],$ar)){
            $opt['selected']="selected";
            $selected++;
          }
        }
        $hSelect->add_child(Html4_Element::factory("option",$opt,"&#160;".$entries[$_keys[$i]][$_keysSelect[$k]]."&#160;"));
      }
      if($selected>0)
        $selected="<i>".$gettext["selected"].":&#160;".$selected."</i>";
      else
        $selected="";
      echo '<td><b>' . $gettext[$_keys[$i]] .'</b><br />' . $selected . "<br />" . $hSelect->to_string() . "</td>\n\n";
      //echo '<div class="form-select"><table><tr>' . $hSelect->to_string() . "</tr></table></div>\n\n";
    }
    echo '</tr></table></div>';
?>