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
 * Reader for the SKB Package Dist.Acronyms.
 *
 * Reads the acronym semantic tag and prepares an array with all found acronyms.
 * This reader does not check the request object for further parametrisation.
 * The following code sequence will simply print an HTML table with all acronyms:<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$mySKB=SKB_Main::get_instance();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$mySKB->require_package("dist.acronyms");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request=$mySKB->get_request();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$request->activate();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader=$mySKB->get_reader("<span style="font-weight:bold;">Dist.Acronyms.DB2Eentries</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$builder=$mySKB->get_builder("<span style="font-weight:bold;">Dist.Acronyms.Entries2XHTML-Table</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader->set_builder($builder);<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader->prepare($request);<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;...<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$reader->execute($request);<br />
 * <br />
 * To change the output from HTML table to other formats provided by this package, simply request a different builder.
 * Available are LaTeX acronym environment (line 1), LaTeX longtable (line 2) and plain text (line 3):
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$builder=$mySKB->get_builder("<span style="font-weight:bold;">Dist.Acronyms.Entries2LaTeX-Acronym</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$builder=$mySKB->get_builder("<span style="font-weight:bold;">Dist.Acronyms.Entries2LaTeX-Table</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$builder=$mySKB->get_builder("<span style="font-weight:bold;">Dist.Acronyms.Entries2Text-Plain</span>");</span><br />
 * <br />
 * Or simply print the array the reader collects. That means you do not instantiate a builder, but simply call the reader's function
 * prepare followed by this:<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;print_r($reader->get_entries()->ar);</span><br />
 *
 * @package    Packages.Dist.Acronyms
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__acronyms___acronyms___reader extends SKB_Reader{
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
		$myDM=SKB_DataManager::get_instance();
		$this->entries=$myDM->query_data_object($myDM->prepare_query("skb:acronyms",null,null,"acronyms:short",null,null,true,true))->ar;
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