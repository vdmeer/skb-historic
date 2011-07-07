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
 * Reader for the SKB Package Dist.Collections.
 *
 * @package    Packages.Dist.Collections
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__collections___collections___reader extends SKB_Reader{
  /**
   * An empty constructor.
   */
  public function __construct(){}

  /**
   * The reader specific prepare function.
   *
   * Automatically called by {@link SKB_Reader#prepare() SKB_Reader->prepare}.
   */
  public function prepare_loop(SKB_Request $request, $table, $table_collections){
    $mySKB=SKB_Main::get_instance();
    $lang=$mySKB->configuration->get_group("system","lang");

    $skb_collection=$request->get_value('request:collection');
  	$pdos=$mySKB->sql_query(null, array('*'), array($table_collections), '', '"request:seq_no"');
  	while($row=$pdos->fetch(PDO::FETCH_ASSOC)){
  		if(Util_Interpreter::interpret("value:is_empty", $skb_collection)==true||$skb_collection==-1)
  		  continue;
  		if(is_array($skb_collection)&&!in_array($row['request:collection'], $skb_collection))
  		  continue;
      if($row['request:show']==0)
        continue;
      if(!isset($this->entries[$row['request:collection']]))
        $this->entries[$row['request:collection']]=array();
      $this->entries[$row['request:collection']][$row['request:part']]=$mySKB->interpret(new Util_ArBase($row), $table_collections)->ar;
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