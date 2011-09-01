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
 * Template for the HTML table builder in the SKB Package Dist.ModelRailway.Inventory.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.ModelRailway.Inventory
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

  $buildings=array();
  $locomotives=array();
  $coaches=array();
  $freightcars=array();
  $rs_sets=array();

  $_keys=array_keys($entries->ar);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
  	if(isset($entries->ar[$_keys[$i]]['dist:modelrailway:category'])&&$entries->ar[$_keys[$i]]['dist:modelrailway:category']['key']=='building')
  	  $buildings[]=$entries->ar[$_keys[$i]];
  	else if(isset($entries->ar[$_keys[$i]]['dist:modelrailway:type1'])&&$entries->ar[$_keys[$i]]['dist:modelrailway:type1']['key']=='locomotive')
  	  $locomotives[]=$entries->ar[$_keys[$i]];
  	else if(isset($entries->ar[$_keys[$i]]['dist:modelrailway:type1'])&&$entries->ar[$_keys[$i]]['dist:modelrailway:type1']['key']=='passenger_coach')
  	  $coaches[]=$entries->ar[$_keys[$i]];
  	else if(isset($entries->ar[$_keys[$i]]['dist:modelrailway:type1'])&&$entries->ar[$_keys[$i]]['dist:modelrailway:type1']['key']=='freight_car')
  	  $freightcars[]=$entries->ar[$_keys[$i]];
  	else if(isset($entries->ar[$_keys[$i]]['dist:modelrailway:type1'])&&$entries->ar[$_keys[$i]]['dist:modelrailway:type1']['key']=='set')
  	  $rs_sets[]=$entries->ar[$_keys[$i]];
  	else
  	  echo "<b>WARNING: NO CAT SET</b>";
  }


  $request->set_value("request:file_ext", array("jpg", "gif"));
?>

    <div class="center">
      <br />
      <div class="table-widegrey">
        <table style="width:auto;">
          <thead><tr>
            <th colspan="2">Locomotives</th>
          </tr></thead>
          <tbody>
            <?php
              $_keys=array_keys($locomotives);
              $_size=count($_keys);
              for($i=0;$i<$_size;$i++){
            ?>
            <tr>
              <td><?php echo rolling_stock($locomotives[$_keys[$i]]); ?></td>
              <td><?php echo (isset($locomotives[$_keys[$i]]['core:urn']))?image($locomotives[$_keys[$i]]['key'], $request):"&#160;"; ?></td>
            </tr>
            <?php
              }
            ?>
          </tbody>
        </table>
      </div>
      <br />
    </div>

    <div class="center">
      <br />
      <div class="table-widegrey">
        <table style="width:auto;">
          <thead><tr>
            <th colspan="2">Passenger Coaches</th>
          </tr></thead>
          <tbody>
            <?php
              $_keys=array_keys($coaches);
              $_size=count($_keys);
              for($i=0;$i<$_size;$i++){
            ?>
            <tr>
              <td><?php echo rolling_stock($coaches[$_keys[$i]]); ?></td>
              <td><?php echo (isset($coaches[$_keys[$i]]['core:urn']))?image($coaches[$_keys[$i]]['key'], $request):"&#160;"; ?></td>
            </tr>
            <?php
              }
            ?>
          </tbody>
        </table>
      </div>
      <br />
    </div>

    <div class="center">
      <br />
      <div class="table-widegrey">
        <table style="width:auto;">
          <thead><tr>
            <th colspan="2">Freight Cars</th>
          </tr></thead>
          <tbody>
            <?php
              $_keys=array_keys($freightcars);
              $_size=count($_keys);
              for($i=0;$i<$_size;$i++){
            ?>
            <tr>
              <td><?php echo rolling_stock($freightcars[$_keys[$i]]); ?></td>
              <td><?php echo (isset($freightcars[$_keys[$i]]['core:urn']))?image($freightcars[$_keys[$i]]['key'], $request):"&#160;"; ?></td>
            </tr>
            <?php
              }
            ?>
          </tbody>
        </table>
      </div>
      <br />
    </div>

<?php
  function rolling_stock($entry){
  	$ret="";
  
    echo "<b>".$entry['default:name']."</b>";
    echo "<br />";
    
    $s="";
    $s.=(isset($entry['dist:modelrailway:type2']))?$entry['dist:modelrailway:type2']['default:name']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:operator']))?Util_Interpreter::interpret("add:char:comma-blank",$s).$entry['dist:modelrailway:operator']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:period']))?Util_Interpreter::interpret("add:char:comma-blank",$s)." Period ".$entry['dist:modelrailway:period']:"&#160;";
    echo $s;
    echo "<br />";
    
    $s="";
    $s.=(isset($entry['dist:modelrailway:gauge']))?$entry['dist:modelrailway:gauge']['default:name']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:manufacturer']))?Util_Interpreter::interpret("add:char:comma-blank",$s).$entry['dist:modelrailway:manufacturer']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:articel_no']))?Util_Interpreter::interpret("add:char:blank",$s).$entry['dist:modelrailway:articel_no']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:catalogue']))?Util_Interpreter::interpret("add:char:comma-blank",$s)." Catalogue ".$entry['dist:modelrailway:catalogue']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:catalogue:page']))?Util_Interpreter::interpret("add:char:comma-blank",$s)." Page ".$entry['dist:modelrailway:catalogue:page']:"&#160;";
    echo $s."&#160;"."&#160;"."&#160;"."&#160;"."&#160;"."&#160;";
    echo "<br />";
    
    echo (isset($entry['dist:modelrailway:equivalent']))?"Equivalent zu ".$entry['dist:modelrailway:partof']['dist:modelrailway:manufacturer']." ".$entry['dist:modelrailway:partof']['dist:modelrailway:articel_no']:"";
    echo (isset($entry['dist:modelrailway:partof']))?"Part of ".$entry['dist:modelrailway:partof']['dist:modelrailway:manufacturer']." ".$entry['dist:modelrailway:partof']['dist:modelrailway:articel_no']:"";
    echo "<br />";

    $s="";
    $s.=(isset($entry['default:length']))?"L&uuml;P: ".$entry['default:length']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:coupling']))?Util_Interpreter::interpret("add:char:comma-blank",$s)."Kupplung: ".$entry['dist:modelrailway:coupling']:"&#160;";
    echo $s;
    
    echo "<br />";
    echo "<br />";
    $s="";
    $s.=(isset($entry['dist:modelrailway:inventory']))?"Bestand: ".$entry['dist:modelrailway:inventory']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:condition_locale']))?Util_Interpreter::interpret("add:char:comma-blank",$s)."Zustand: ".$entry['dist:modelrailway:condition_locale']:"&#160;";
    echo $s;
    
    echo "<br />";
    echo "<br />";
    $s="";
    $s.=(isset($entry['dist:modelrailway:price:retail']))?"Liste: ".$entry['dist:modelrailway:price:retail:currency']." ".$entry['dist:modelrailway:price:retail']:"&#160;";
    $s.=(isset($entry['dist:modelrailway:price:paid']))?" (".$entry['dist:modelrailway:price:paid:currency']." ".$entry['dist:modelrailway:price:paid'].")":"&#160;";
    echo $s;
  
  	return $ret;
  }

  function image($key, $request){
    $mySKB=SKB_Main::get_instance();
    $file=$mySKB->interpret_data('Core.Interpreter.URN', $key, null, $request)->ar;
    if(isset($file['jpg']))
      $source=$file['jpg'];
    elseif(isset($file['gif']))
      $source=$file['gif'];

    $ret="";
    $ret='<img src="' . $source['full']['rel'];
    if(isset($source['full']['width']))
      $ret.='" width="' . $source['full']['width'];
    if(isset($source['full']['height']))
      $ret.='" width="' . $source['full']['height'];
    $ret.='" alt="' .  $key . '" />';
    return $ret;
  }
?>