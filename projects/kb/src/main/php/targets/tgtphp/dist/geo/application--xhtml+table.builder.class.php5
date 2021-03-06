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
 * Demo Builder for the SKB Package Dist.Geo, creating an HTML table of the given entries.
 *
 * For examples how to use this builder, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Geo
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__geo___application__xhtml__table___builder extends SKB_Builder{
  /**
   * The template id for the builder.
   *
   * @var $tpl_list
   */
  protected $tpl_list="Dist.Geo.Entries2XHTML-Table:Template";

  /**
   * Class Constructor.
   *
   * It calls the parent class to instantiate the template repository and then 
   * adds the local template to it.
   */
  function __construct(){
  	parent::__construct();
  	$this->templates->add_template("list", $this->tpl_list);
  }

  /**
   * The builder specific execute function.
   *
   * Automatically called by {@link SKB_Builder#execute() SKB_Builder->execute}
   */
  public function execute_loop(SKB_Request $request, Util_ArBase $entries){
  	$ar=array();
    $_keys=array_keys($entries->ar);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      if(isset($entries->ar[$_keys[$i]]['default:name'])){
      	$_t=$entries->ar[$_keys[$i]]['default:name'];
        if(isset($entries->ar[$_keys[$i]]['geo:region']))
          $_t.=', '.$entries->ar[$_keys[$i]]['geo:region'];
        if(isset($entries->ar[$_keys[$i]]['geo:state']))
          $_t.=', '.$entries->ar[$_keys[$i]]['geo:state'];
        if(isset($entries->ar[$_keys[$i]]['geo:county']))
          $_t.=', Co. '.$entries->ar[$_keys[$i]]['geo:county'];
        if(isset($entries->ar[$_keys[$i]]['default:country']))
          $_t.=', '.$entries->ar[$_keys[$i]]['default:country']['default:name'];
        if(isset($entries->ar[$_keys[$i]]['default:continent']))
          $_t.=' ('.$entries->ar[$_keys[$i]]['default:continent']['default:name'].')';
        if(isset($entries->ar[$_keys[$i]]['geo:ccTLD']))
          $_t.=', TDL = '.$entries->ar[$_keys[$i]]['geo:ccTLD'];
        $ar[]=$_t;
      }
    }
  	uasort($ar, "pkg_dist__geo___application__xhtml__table___builder::my_sort");

    $heading="";
    if(isset($entries->ar[0]['default:country']))
      $heading="Cities";
    elseif(isset($entries->ar[0]['default:continent']))
      $heading="Countries";
    else
      $heading="Continents";

    $tpl=$this->templates->get_template_object("list");
    $tpl->set("entries", $ar);
    $tpl->set("heading", $heading);
    $tpl->printT();
  }

  private static function my_sort($a, $b){
  	  $mySKB=SKB_Main::get_instance();
      $lang=$mySKB->configuration->get_group("system","lang");
    	return Util_Interpreter::interpret("array:sort:nat", $a, $b, $lang);
  }
}
?>