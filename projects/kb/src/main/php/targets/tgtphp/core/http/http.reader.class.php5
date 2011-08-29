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
 * Reader for the SKB Package Core.Http.
 *
 * This reader provides easy access to all HTTP and MIME related information of the SKB.
 * It calls the respective function of SKB_Main to collect all information. One can use 
 * the default request, since this reader does not require specific configuration.
 * To instantiate a default reader do the following:.<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader=$mySKB->get_reader("<span style="font-weight:bold;">Core.HTTP.DB2Entries</span>");</span><br />
 *
 * @package    Packages.Core.Http
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_core__http___http___reader extends SKB_Reader{
	/**
	 * The reader specific prepare function.
	 *
	 * Automatically called by {@link SKB_Reader#prepare()}
	 */
	public function prepare_loop(SKB_Request $request, $sematag, $sematag_collections){
		$this->_get("http_status_codes");
		$this->_get("http_headers_request");
	
		$this->_get("http_headers_response");
		$this->_get("core_http_headers_response", "http_headers_response_skb", "skb");
		$this->_get("site_http_headers_response", "http_headers_response_skb", "site");
	
		$this->_get("mime_content_types", null, "std");
		$this->_get("core_mime_content_types", "mime_content_types", "skb");
		$this->_get("site_mime_content_types", "mime_content_types", "site");
	
		$this->_get("http_request_methods");
	}


	/** @ignore */
	private function _get($sematag, $entry_key=null, $origin=null){
		$mySKB=SKB_Main::get_instance();
		if(!$mySKB->sematag_exists($sematag))
			return;

		$myDM=SKB_DataManager::get_instance();
		$this->entry_list=$myDM->query_data_object($myDM->prepare_query($sematag,null,null,"'key'",null,null,true,true))->ar;

		$pdos=$mySKB->sql_query(null, array('*'), array($sematag), null, "'key'");
		if(!is_object($pdos)&&$pdos==-1)
			return;

		if($entry_key==null)
			$entry_key=$sematag;

		if(!isset($this->entries[$entry_key]))
			$this->entries[$entry_key]=array();
		foreach($this->entry_list as $row){
			if(isset($row['key'])){
				$this->entries[$entry_key][$row['key']]=$row;
				if($origin!=null)
					$this->entries[$entry_key][$row['key']]['origin']=$origin;     	    
				unset($this->entries[$entry_key][$row['key']]['key']);
			}
		}
	}


	/**
	 * The reader specific execute function.
	 *
	 * Automatically called by {@link SKB_Reader#execute()}
	 */
	public function execute_loop(SKB_Request $request){
	}
}
?>