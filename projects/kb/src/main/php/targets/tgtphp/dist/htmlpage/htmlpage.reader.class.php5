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
 * Reader for the SKB Package Dist.HtmlPage.
 *
 * @package    Packages.Dist.HtmlPage
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__htmlpage___htmlpage___reader extends SKB_Reader{
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
  	global $skb_menu_reader;
    $mySKB=SKB_Main::get_instance();

    if($mySKB->configuration->get_group("header","pre-title")!=-1)
      $this->entries['title']=$mySKB->configuration->get_group("header","pre-title").$skb_menu_reader->get_title_string(" -> ");
    else
      $this->entries['title']==$skb_menu_reader->get_title_string(" -> ");

    $description=$request->get_value("htmlpage:description");
    if($description==-1)
      $description=$mySKB->configuration->get_group("header","description");
    if($description!=-1)
      $this->entries['meta'][]='name="description" content="'.implode(",",$description).'"';

    $keywords=$request->get_value("htmlpage:keywords");
    if($keywords==-1)
      $keywords=$mySKB->configuration->get_group("header","keywords");
    if($keywords!=-1)
      $this->entries['meta'][]='name="keywords" content="'.implode(",",$keywords).'"';

    //if($mySKB->configuration->get_group("header","base-target")!=-1)
    //  $head->addChild(new Html4_Base(array("target"=>$mySKB->configuration->get_group("header","base-target"))));

    $this->entries['style']=array();
    if($mySKB->configuration->get_group("request","layout")!=-1)
      $this->entries['style'][]=array("type"=>"text/css","media"=>"all","__content"=>" @import \"" . $mySKB->configuration->get_group("path","prefix") . $mySKB->configuration->get_group("request","layout") . ".css\";");
    else if($mySKB->configuration->get_group("header","std-css")!=-1){
    	$list=explode(",", $mySKB->configuration->get_group("header","std-css"));
    	$list=array_unique($list);
	    $_keys=array_keys($list);
  	  $_size=count($_keys);
    	for($i=0;$i<$_size;$i++)
    	  $this->entries['style'][]=array("type"=>"text/css","media"=>"all","__content"=>" @import \"" . $mySKB->configuration->get_group("path","css") . $list[$_keys[$i]] . ".css\";");
    }

    $this->entries['additional']=array();
    $additional=$request->get_value("htmlpage:additional");
    if($additional!=""&&is_object($additional))
      $this->entries['additional'][]=$additional->toString();
    else if($additional!=""&&is_array($additional)){
  	  $_size=count($additional);
      for($i=0;$i<$_size;$i++)
        $this->entries['additional'][]=$additional[$i];
    }
    else if($additional!="")
      $this->entries['additional'][]=$additional;

    $this->entries['script']=array();
    $_js=$mySKB->configuration->get_group("header","std-js");
    if($_js!=-1&&$_js!=null){
    	$list=explode(",", $_js);
    	$list=array_unique($list);
	    $_keys=array_keys($list);
  	  $_size=count($_keys);
    	for($i=0;$i<$_size;$i++){
    	  if(strpos($list[$_keys[$i]],"http://")===false)
    	    $this->entries['script'][]=array("type"=>"text/javascript","src"=>$mySKB->configuration->get_group("path","javascript") . $list[$_keys[$i]] . ".js");
    	  else
    	    $this->entries['script'][]=array("type"=>"text/javascript","src"=>$list[$_keys[$i]]);
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