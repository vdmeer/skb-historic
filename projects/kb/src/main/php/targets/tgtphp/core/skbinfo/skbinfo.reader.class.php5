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
 * Reader for the SKB Package Core.SkbInfo.
 *
 * This reader collects all configuration information from SKB_Main, including registered
 * readers, applications, builders, interpreters and templates (RABIT) plus registered
 * MIME content types and HTTP response headers. It can be configured using the request
 * object by adding a the key "request:entry" with the value of the SKB information needed.
 * If "request:entry" in the request object is not set or null, all information will be 
 * collected. If "request:entry" is set to one of the following values, then this specific
 * information is collected:
 * <ul>
 *   <li>configuration</li>
 *   <li>dbpdos</li>
 *   <li>requests</li>
 *   <li>readers</li>
 *   <li>builders</li>
 *   <li>templates</li>
 *   <li>applications</li>
 *   <li>interpreters</li>
 *   <li>fields</li>
 *   <li>mime_content_types</li>
 *   <li>http_headers_response</li>
 * </ul>
 * One can also add a requested 'origin' string to "request:entry" simply by addind the string ":[origin]"
 * with [origin] being the package one wants to look at. All other packages will then be ignored. For instance,
 * if we only want to see readers of the core package, we can set the request object as follows:<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$mySKB=SKB_Main::get_instance();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request=$mySKB->get_request();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request->set_value("request:entry","readers:Core");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader=$mySKB->get_reader("<span style="font-weight:bold;">Core.SkbInfo.DB2Entries</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader->prepare($request);</span><br />
 * <br />
 * The following code will do everything for you (except calling a specific HTML page of course). First, we load the package Core.SkbInfo, then
 * we create a request object and activate it (this is important, otherwise the reader will do nothing!). Then we create the reader and select 
 * the provided builder from Core.SkbInfo for creating HTML tables. Finally, we associate reader and builder and call prepare and execute to 
 * read and print the information:
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$skb_main=SKB_Main::get_instance();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$skb_main->require_package("core.skbinfo");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request_info=$skb_main->get_request();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request_info->activate();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader_info=$skb_main->get_reader("<span style="font-weight:bold;">Core.SkbInfo.DB2Entries</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$builder_info=$skb_main->get_builder("<span style="font-weight:bold;">Core.SkbInfo.Entries2XHTML-Table</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader_info->set_builder($builder_info);<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader_info->prepare($request_info);<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader_info->execute($request_info);<br />
 *
 * @package    Packages.Core.SkbInfo
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_core__skbinfo___skbinfo___reader extends SKB_Reader{
  /**
   * An empty constructor.
   */
  public function __construct(){}

  /**
   * The reader specific prepare function.
   *
   * Automatically called by {@link SKB_Reader#prepare() SKB_Reader->prepare}.
   */
  public function prepare_loop(SKB_Request $request, $sematag, $sematag_collections){
    $todo=$request->get_value("request:entry");
    $select=null;
    if(count($todo)>0){
      $todo=$todo[0];
      if(strpos($todo,":")!==false){
      	$ar=explode(":",$todo);
      	if(strlen($ar[0])>0)
      	  $todo=$ar[0];
      	else
      	  $todo=null;
      	$select=$ar[1];
      }
    }
    else{
      $todo=null;
    }

  	$mySKB=SKB_Main::get_instance();
    if($todo==null||$todo=="configuration"){
      $this->entries['configuration']=$mySKB->get_configuration();
      ksort($this->entries['configuration']);
    }
    if($todo==null||$todo=="registered_dos"){
      $this->entries['registered_dos']=SKB_DataManager::get_instance()->get_data_objects();
      ksort($this->entries['registered_dos']);
    }
    if($todo==null||$todo=="requests"){
      $this->entries['registered_requests']=$mySKB->get_registered_requests();
      ksort($this->entries['registered_requests']);
    }
    if($todo==null||$todo=="readers"){
      $this->entries['registered_readers']=$mySKB->get_registered_readers();
      ksort($this->entries['registered_readers']);
    }
    if($todo==null||$todo=="builders"){
      $this->entries['registered_builders']=$mySKB->get_registered_builders();
      ksort($this->entries['registered_builders']);
    }
    if($todo==null||$todo=="templates"){
      $this->entries['registered_templates']=$mySKB->get_registered_templates();
      ksort($this->entries['registered_templates']);
    }
    if($todo==null||$todo=="applications"){
      $this->entries['registered_applications']=$mySKB->get_registered_applications();
      ksort($this->entries['registered_applications']);
    }
    if($todo==null||$todo=="interpreters"){
      $this->entries['registered_interpreters']=$mySKB->get_registered_interpreters();
      ksort($this->entries['registered_interpreters']);
    }
    if($todo==null||$todo=="fields"){
      $this->entries['registered_fields']=$mySKB->get_registered__fields();
      ksort($this->entries['registered_fields']);
    }
    if($todo==null||$todo=="enc_char"){
    	$req=$mySKB->get_request("Core.Encoding");
    	$req->init_plain();
    	$req->activate();
    	$red=$mySKB->get_reader("Core.Encoding.DB2Entries");
    	$bui=$mySKB->get_builder("Core.Encoding.Entries2Entries");
    	$red->set_builder($bui);
    	$red->prepare($req);
    	$this->entries['enc_char']=$red->get_entries()->ar;
      ksort($this->entries['enc_char']);
    }

    $myHTTP=SKB_Http::get_instance();
    if($todo==null||$todo=="mime_content_types"){
      $this->entries['mime_content_types']=$myHTTP->get_skb_mime_content_types();
      ksort($this->entries['mime_content_types']);
    }
    if($todo==null||$todo=="http_headers_response"){
      $this->entries['http_headers_response']=$myHTTP->get_skb_http_headers_response();
      ksort($this->entries['http_headers_response']);
    }

    $this->entries['todo']=$todo;
    $this->entries['select']=$select;

    //remove all non selected
    if($select!=null){
      $_keys=array_keys($this->entries);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
      	if(is_array($this->entries[$_keys[$i]])){
        	$ar=$this->entries[$_keys[$i]];
        	$_keysD=array_keys($ar);
        	$_sizeD=count($_keysD);
        	for($k=0;$k<$_sizeD;$k++){
        		if(isset($ar[$_keysD[$k]]['origin'])&&$ar[$_keysD[$k]]['origin']!=$select){
        		  unset($this->entries[$_keys[$i]][$_keysD[$k]]);
        		}
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