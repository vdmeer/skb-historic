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
 * Reader for the SKB Package Dist.FormSelect.
 *
 * @package    Packages.Dist.FormSelect
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__formselect___formselect___reader extends SKB_Reader{
  /**
   * An empty constructor.
   */
  function __construct(){}

  /**
   * The reader specific prepare function.
   *
   * Automatically called by {@link SKB_Reader#prepare() SKB_Reader->prepare}.
   */
  public function prepare_loop(SKB_Request $request, $table, $table_collections){
  	$mySKB=SKB_Main::get_instance();
    $lang=$mySKB->configuration->get_group("system","lang");

    $todo=$request->get_form_select_keys();
    $table_fields=array();
//    $table_collections_fields=array();
    $_keys=array_keys($todo);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
    	$this->entries[$_keys[$i]]=array();
    	if($todo[$_keys[$i]]=="table")
    	  $table_fields[$_keys[$i]]=$mySKB->get_field_settings($_keys[$i]);
//    	elseif($todo[$_keys[$i]]=="table_collections")
//    	  $table_collections_fields[$_keys[$i]]=$mySKB->get_field_settings($_keys[$i]);
    }

    $test_key_ar=array();
    $coll=$request->get_value("request:collection");
    if(is_array($coll)&&isset($coll[0])){
    	$part=$request->get_value("request:part");
    	if(is_array($part)&&isset($part[0])){
    		$coll=$coll[0];
    		$part=$part[0];

    		$pdos=$mySKB->sql_query(null, array('key','"request:collection"','"request:part"','"request:element_keys"'), array($table_collections), '"request:collection"="'.$coll.'" AND "request:part"="'.$part.'"');
        $row=$pdos->fetch(PDO::FETCH_ASSOC);
        $test_key_ar=Util_Interpreter::interpret("array:explode", $row['request:element_keys']);
        $test_key_ar=array_keys($test_key_ar);
    	}
    }

    $pdos=$mySKB->sql_query(null, '*', array($table));
    while($row=$pdos->fetch(PDO::FETCH_ASSOC)){
    	//first, if we have a selection array, check if the key is in there
    	if(count($test_key_ar)>0&&!in_array($row['key'],$test_key_ar))
    		continue;

      $_keys=array_keys($table_fields);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
      	//first case, field does not explode
      	if($table_fields[$_keys[$i]]['core:explode']==0){
          if(isset($this->entries[$_keys[$i]])&&isset($row[$_keys[$i]])&&Util_Interpreter::interpret("value:is_empty", $row[$_keys[$i]])==false)
            $this->entries[$_keys[$i]][$row[$_keys[$i]]]=$row[$_keys[$i]];
          //special case for journals and conferences
          elseif(isset($row['publications:entry_type_key'])){
          	switch($row['publications:entry_type_key']){
              case "conference":
              case "inproceedings":
              case "proceedings":
                if($_keys[$i]=="publications:conference"){
          	      $pdos_conf=$mySKB->sql_query(null, array('key', '"default:acronym_key"', '"default:year"'), array('conferences'), 'key="'.$row['publications:key'].'"');
          	      $row_conf=$pdos_conf->fetch(PDO::FETCH_ASSOC);
          	      $row_conf=Util_Interpreter::interpret("array:clean",$row_conf);
          	      $row_conf=$mySKB->interpret(new Util_ArBase($row_conf), $table)->ar;
          	      $this->entries[$_keys[$i]][$row_conf['key']]=$row_conf['default:acronym']['acronyms:short'] . " " . $row_conf['default:year'];
                }
                break;
              case "article":
                if($_keys[$i]=="publications:journal"){
          	      $pdos_conf=$mySKB->sql_query(null, array('key', '"default:acronym_key"'), array('journals'), 'key="'.$row['publications:key'].'"');
          	      $row_conf=$pdos_conf->fetch(PDO::FETCH_ASSOC);
          	      $row_conf=Util_Interpreter::interpret("array:clean",$row_conf);
          	      $row_conf=$mySKB->interpret(new Util_ArBase($row_conf), $table)->ar;
          	      $this->entries[$_keys[$i]][$row_conf['key']]=$row_conf['default:acronym']['acronyms:short'];
                }
          		  break;
          		default: break;
          	}
          }
        }
        else{
          if(isset($this->entries[$_keys[$i]])&&isset($row[$_keys[$i]])&&Util_Interpreter::interpret("value:is_empty", $row[$_keys[$i]])==false){
       	    $tmp_ar=Util_Interpreter::interpret("array:explode", $row[$_keys[$i]]);
       	    //if($table_fields[$_keys[$i]]['core:explode_keys']==true)
       	    if(isset($table_fields[$_keys[$i]]['core:interpreter']))
       	      $this->entries[$_keys[$i]]=array_merge($this->entries[$_keys[$i]], array_combine(array_keys($tmp_ar),array_keys($tmp_ar)));
       	    else
      	      $this->entries[$_keys[$i]]=array_merge($this->entries[$_keys[$i]], array_combine(array_values($tmp_ar),array_values($tmp_ar)));
    	    }
        }
      }
    }

    //special case for museums, this impacts country and city as well, need further build
    if(isset($this->entries['gallery:museum_key'])){
      $this->entries['gallery:museum_key']=array_unique($this->entries['gallery:museum_key']);
      $pdos=$mySKB->sql_query(null, array('key','"default:name_locale"','"default:city_key"', '"default:country_key"'), array('affiliations'));
      while($row=$pdos->fetch(PDO::FETCH_ASSOC)){
      	if(in_array($row['key'],$this->entries['gallery:museum_key'])){
      		$row=Util_Interpreter::interpret("array:clean",$row);
      		$row=$mySKB->interpret(new Util_ArBase($row), 'affiliations')->ar;
      		if(isset($this->entries['default:city_key'])&&isset($row['default:city']['key']))
      		  $this->entries['default:city_key'][$row['default:city']['key']]=$row['default:city']['key'];
      		if(isset($this->entries['default:country_key'])&&isset($row['default:country']['key']))
      		  $this->entries['default:country_key'][$row['default:country']['key']]=$row['default:country']['key'];
      	}
      }
    }

    $_keys=array_keys($this->entries);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      if(isset($table_fields[$_keys[$i]]['core:default_db'])){
      	$ar=$this->entries[$_keys[$i]];
        $_keys_ex=array_keys($ar);
        $_size_ex=count($_keys_ex);
        for($k=0;$k<$_size_ex;$k++){
        	//$pdos_locale=$mySKB->sql_query(null, array('*'), array($table_fields[$_keys[$i]]['core:default_db']), "key='\"".$ar[$_keys_ex[$k]]."\"'");
        	$pdos_locale=$mySKB->sql_query(null, array('*'), array($table_fields[$_keys[$i]]['core:default_db']), 'key="'.$ar[$_keys_ex[$k]].'"');
        	$row_locale=$pdos_locale->fetch(PDO::FETCH_ASSOC);
        	$row_locale=Util_Interpreter::interpret("array:clean",$row_locale);
        	$row_locale=$mySKB->interpret(new Util_ArBase($row_locale), $table_fields[$_keys[$i]]['core:default_db'])->ar;
        	//special case for people, here we want last name and then first name
        	if($_keys[$i]=="publications:author_keys"||$_keys[$i]=="publications:editor_keys"||$_keys[$i]=="gallery:fotographer_key")
        	  $this->entries[$_keys[$i]][$ar[$_keys_ex[$k]]]=$row_locale['people:last'] . ", ". $row_locale['people:first'];
        	else{
        		if(isset($row_locale['default:acronym']['acronyms:short'])){
        		  $this->entries[$_keys[$i]][$ar[$_keys_ex[$k]]]=$row_locale['default:acronym']['acronyms:short'];
        		  if(isset($row_locale['default:year']))
        		    $this->entries[$_keys[$i]][$ar[$_keys_ex[$k]]].=" ".$row_locale['default:year'];
        		}
        		elseif(isset($row_locale['default:name']))
        		  $this->entries[$_keys[$i]][$ar[$_keys_ex[$k]]]=$row_locale['default:name'];
          }
        }
      }
    }
  }

  /**
   * The reader specific execute function.
   *
   * Automatically called by {@link SKB_Reader#execute() SKB_Reader->execute}.
   */
  public function execute_loop(SKB_Request $request){}
}
?>