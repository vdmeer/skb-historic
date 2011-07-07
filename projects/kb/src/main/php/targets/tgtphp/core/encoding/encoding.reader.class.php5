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
 * Reader for the SKB Package Core.Encoding.
 *
 * @package    Packages.Core.Encoding
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_core__encoding___encoding___reader extends SKB_Reader{
  /**
   * An empty constructor.
   */
  public function __construct(){}

  /**
   * The reader specific prepare function.
   *
   * Automatically called by {@link SKB_Reader#prepare()}
   */
  public function prepare_loop(SKB_Request $request, $table, $table_collections){
    $mySKB=SKB_Main::get_instance();

    $table="encoding_characters";

  	$pdos=$mySKB->sql_query(null, array('*'), array($table));
  	while($row=$pdos->fetch(PDO::FETCH_ASSOC)){
      $ar=Util_Interpreter::interpret("array:clean", $row);
      $ar=$mySKB->interpret(new Util_ArBase($ar), $table)->ar;
      $this->entry_list[$ar['key']]=$ar;
  	}

    // source/target either of: a,h,l,n,s,t,u
    $source=$request->get_value("default:source");
    $target=$request->get_value("default:target");
    if($source!=-1&&isset($source[0])&&$target!=-1&&isset($target[0])){
    	$key;
    	$val;
    	switch($source[0]){
    		case "a": $key="core:encoding:asciidoc"; break;
    		default:
    		case "h": $key="core:encoding:html";
    		          break;
    		case "l": $key="core:encoding:latex";
     		          break;
    		case "n": $key="core:encoding:natsort";
    		          break;
    		case "s": $key="core:encoding:latex:skb";
    		          break;
    		case "t": $key="core:encoding:text";
    		          break;
    		case "u": $key="core:encoding:utf8";
    		          break;
    	}
    	switch($target[0]){
    		case "a": $val="core:encoding:asciidoc";
    		          break;
    		case "h": $val="core:encoding:html";
    		          break;
    		case "l": $val="core:encoding:latex";
    		          break;
    		case "n": $val="core:encoding:natsort";
    		          break;
    		case "s": $val="core:encoding:latex:skb";
    		          break;
    		default:
    		case "t": $val="core:encoding:text";
    		          break;
    		case "u": $val="core:encoding:utf8";
    		          break;
    	}
			$_keys=array_keys($this->entry_list);
      $_size=count($_keys);
      $this->entries=array();
      for($i=0;$i<$_size;$i++){
        if(isset($this->entry_list[$_keys[$i]][$key])&&isset($this->entry_list[$_keys[$i]][$val]))
      	  $this->entries[$this->entry_list[$_keys[$i]][$key]]=$this->entry_list[$_keys[$i]][$val];
      	elseif(isset($this->entry_list[$_keys[$i]][$key]))
      	  $this->entries[$this->entry_list[$_keys[$i]][$key]]="";
      }
    }
    else{
    	$this->entry_list=Util_Interpreter::interpret("array:clean", $this->entry_list);
    	$this->entries=$this->entry_list;
    }
  }

  /**
   * The reader specific execute function.
   *
   * Automatically called by {@link SKB_Reader#execute()}
   */
  public function execute_loop(SKB_Request $request){}
}
?>