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
 * Reader for the SKB Package Dist.Publications.
 *
 * @package    Packages.Dist.Publications
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__publications___publications___reader extends SKB_Reader{
	/**
	 * An empty constructor.
	 */
	public function __construct(){
	}
	
	/**
	 * The reader specific prepare function.
	 *
	 * Automatically called by {@link SKB_Reader#prepare() SKB_Reader->prepare}.
	 */
	public function prepare_loop(SKB_Request $request, $sematag, $sematag_collections){
//		$mySKB=SKB_Main::get_instance();
		
		$skb_year=$request->get_value("default:year");
		$skb_type=$request->get_value("publications:entry_type_key");
		$skb_tags=$request->get_value("publications:tags");
		$skb_authors=$request->get_value("publications:author_keys");
		$skb_editors=$request->get_value("publications:editor_keys");
		$skb_conference=$request->get_value("publications:conference_key");
		$skb_journal=$request->get_value("publications:journal_key");
		$entry_key=$request->get_value("publications:publications_key");
		
		if($skb_type==-1)
			$skb_type=array();
		if($skb_tags==-1)
			$skb_tags=array();
		if($skb_year==-1)
			$skb_year=array();
		if($skb_authors==-1)
			$skb_authors=array();
		if($skb_editors==-1)
			$skb_editors=array();
		if($skb_journal==-1)
			$skb_journal=array();
		if($skb_conference==-1)
			$skb_conference=array();
		if($entry_key==-1)
			$entry_key=array();
		
		if(count($skb_type)==0
			&&count($skb_tags)==0
			&&count($skb_year)==0
			&&count($skb_authors)==0
			&&count($skb_editors)==0
			&&count($skb_journal)==0
			&&count($skb_conference)==0
			&&count($entry_key)==0)
		  return;

		$myDM=SKB_DataManager::get_instance();
		$ar=$myDM->query_data_object($myDM->prepare_query("skb:publications:publications",null,null,null,null,null,false,false))->ar;
		foreach($ar as $row){
			if(count($skb_type)>0&&!in_array($row['publications:entry_type_key'],$skb_type))
				continue;

			if(count($skb_year)>0&&!in_array($row['default:year'], $skb_year))
				continue;
	
			if(is_array($skb_tags)){
				if(count(array_diff($skb_tags, Util_Interpreter::interpret("array:explode", $row['publications:tags'])))>0)
					continue;
			}

			$people_ar=array();
			if(count($skb_authors)>0)
				$people_ar=Util_Interpreter::interpret("array:explode", $row['publications:author_keys']);
			if(count($skb_editors)>0)
				$people_ar=array_merge($people_ar, Util_Interpreter::interpret("array:explode", $row['publications:editor_keys']));
			$skb_people=array_unique(array_merge($skb_authors, $skb_editors));
			if(count($skb_people)>0){
				if(count(array_intersect($skb_people, array_keys($people_ar)))==0)
					continue;
			}

			if(count($skb_conference)>0&&isset($row['publications:conference_key'])&&!in_array($row['publications:conference_key'], $skb_conference))
				continue;
			if(count($skb_conference)>0&&!isset($row['publications:conference_key']))
				continue;
	
			if(count($skb_journal)>0&&isset($row['publications:journal_key'])&&!in_array($row['publications:journal_key'], $skb_journal))
				continue;
			if(count($skb_journal)>0&&!isset($row['publications:journal_key']))
				continue;
	
			if(count($entry_key)>0&&!in_array($row['key'], $entry_key))
				continue;

			$ar=Util_Interpreter::interpret("array:clean", $row);
			$ar=$myDM->interpret_do(new Util_ArBase($ar), null, $sematag)->ar;

			$this->entries[$ar['key']]=$ar;
		}
	}
	
	/**
	 * The reader specific execute function.
	 *
	 * Automatically called by {@link SKB_Reader#execute() SKB_Reader->execute}.
	 */
	public function execute_loop(SKB_Request $request){
	}
}
?>