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
 * Demo Template for the HTML page builder in the SKB Package Demo.HtmlPage.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Demo.HtmlPage
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */

    $mySKB=SKB_Main::get_instance();
    global $skb_menu_reader;

    $menu_request=$mySKB->get_request("Dist.Menu");
    $menu_request->activate();
    $skb_menu_reader->set_builder($mySKB->get_builder("Dist.Menu.Entries2XHTML-Menu-Brick"));

?>
  <body>
    <div id="container-page">
      <span><a id="top"></a></span>
      <div id="container-head-outer">
        <div id="container-head-inner">
          <div id="menu-top">&#160;</div>
          <div id="menu-top2">&#160;</div>
          <?php $skb_menu_reader->execute($menu_request); ?>
<?php
    $add=$request->get_value("htmlpage:extra_builder");
    if(count($add)>0){
    	if(isset($add['reader'])&&isset($add['request'])){
      	if(is_object($add['reader'])&&is_object($add['request'])){
      	  echo '          <div id="gall-nav">';
      	  $add['reader']->execute($add['request']);
    	    echo '</div>'."\n";
    	  }
    	}
    	else{
        $_keys=array_keys($add);
        $_size=count($_keys);
        for($i=0;$i<$_size;$i++){
          if(isset($add[$_keys[$i]]['reader'])&&isset($add[$_keys[$i]]['request'])){
    	      if(is_object($add[$_keys[$i]]['reader'])&&is_object($add[$_keys[$i]]['request'])){
    	        echo '          <div id="gall-nav">';
    	        $add[$_keys[$i]]['reader']->execute($add[$_keys[$i]]['request']);
    	        echo '</div>'."\n";
    	      }
    	    }
        }
      }
    }
?>
        </div>
      </div>

      <div id="container-content">
        <div id="content">
