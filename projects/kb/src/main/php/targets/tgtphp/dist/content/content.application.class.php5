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
 * Application for the SKB Package Dist.Collections.
 *
 * @package    Packages.Dist.Content
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__content___content___application{
  private $lang;

  /** @ignore */
  private $htmlpage_request_key="Dist.HtmlPage";
  /**
   * Set the key for the SKBRequest used to build the HTML page.
   *  @param string s request key
   */
  public function set_htmlpage_request_key($s){
  	$this->htmlpage_request_key=$s;
  }

  private $htmlpage_reader_key="Dist.HtmlPage.DB2Entries";
  /**
   * Set the key for the SKBReader used to build the HTML page.
   *  @param string s request key
   */
  public function set_htmlpage_reader_key($s){
  	$this->htmlpage_reader_key=$s;
  }

  private $htmlpage_builder_key=null;
  /**
   * Set the key for the SKBBuilder used to build the HTML page.
   *  @param string s request key
   */
  public function set_htmlpage_builder_key($s){
  	$this->htmlpage_builder_key=$s;
  }

  private $gallery_request;
  private $gallery_request_key="Dist.Gallery.Fotos";
  /**
   * Set the key for the SKBRequest used for gallery elements, default is "Dist.Gallery.Fotos".
   *  @param string s request key
   */
  public function set_gallery_request_key($s){
  	$this->gallery_request_key=$s;
  }

  private $request=null;
  private $request_key=null;
  /**
   * Set the key for the genral SKBRequest used in this application.
   *  @param string s request key
   */
  public function set_request_key($s){
  	$this->request_key=$s;
  }

  private $request_collection=null;
  /**
   * Set the key for the collection to be used.
   *  @param string s request key
   */
  public function set_request_collection($s){
  	$this->request_collection=$s;
  }

  private $request_part=null;
   /**
   * Set the key for the part to be used.
   *  @param string s request key
   */
  public function set_request_part($s){
  	$this->request_part=$s;
  }

  private $content_reader=null;
  private $content_reader_key="Dist.Content.DB2Entries";
  /**
   * Set the key for the SKBReader that processes content, default is "Dist.Content.DB2Entries".
   *  @param string s request key
   */
  public function set_content_reader_key($s){
  	$this->content_reader_key=$s;
  }

  private $content_builder=null;
  private $content_builder_key=null;
  /**
   * Set the key for the SKBBuilder that processes content.
   *  @param string s request key
   */
  public function set_content_builder_key($s){
  	$this->content_builder_key=$s;
  }

  private $content_part_reader=null;
  private $content_part_reader_key="Dist.Collections.DB2Entries";
  /**
   * Set the key for the SKBReader that processes content parts, default is "Dist.Collections.DB2Entries".
   *  @param string s request key
   */
  public function set_content_part_reader_key($s){
  	$this->content_part_reader_key=$s;
  }

  private $content_part_builder=null;
  private $content_part_builder_key=null;
  /**
   * Set the key for the SKBBuilder that processes content parts.
   *  @param string s request key
   */
  public function set_content_part_builder_key($s){
  	$this->content_part_builder_key=$s;
  }

  private $prevnext_request=null;
  private $prevnext_request_key="Dist.PrevNext";
  /**
   * Set the key for the SKBRequest for processing 'previuos'/'next' elements, default is "Dist.PrevNext".
   *  @param string s request key
   */
  public function set_prevnext_request_key($s){
  	$this->prevnext_request_key=$s;
  }

  private $prevnext_reader=null;
  private $prevnext_reader_key="Dist.PrevNext.DB2Entries";
  /**
   * Set the key for the SKBReader that processes 'previuos'/'next' elements, default is "Dist.PrevNext.DB2Entries".
   *  @param string s request key
   */
  public function set_prevnext_reader_key($s){
  	$this->prevnext_reader_key=$s;
  }

  private $prevnext_builder=null;
  private $prevnext_builder_key="Dist.PrevNext.Entries2XHTML-Table";
  /**
   * Set the key for the SKBBuilder that processes 'previuos'/'next' elements, default is "Dist.PrevNext.DB2Entries".
   *  @param string s request key
   */
  public function set_prevnext_builder_key($s){
  	$this->prevnext_builder_key=$s;
  }

  /** @ignore */
  private $mm_content=false;
  /** @ignore */
  private $mm_part=null;

  /**
   * The public constructor, does not do anything.
   */
  public function __construct(){}

  /** @ignore */
  private $gettext_title="";
  /** @ignore */
  private $gettext_subtitle="";
  
  public function set_lang_texts($title, $subtitle){
    $this->gettext_title=$title;
    $this->gettext_subtitle=$subtitle;
  }

/**
   * Prepare the application.
   * 
   * Prepare basically means to do everything needed prior invoking execute. For the content application,
   * this means to check for all request/reader/builder keys and if they are set, initialise all readers and
   * builders: HTML page generation, main request for content, Gallery, PrevNext, Content Part. All dependencies and
   * the necessary sequence of the reader/builder initialisation is taken care of here. In the case of problems with 
   * instantiating any object, the function will trigger E_USER_ERROR and try to continue for as long as possible.
   *
   * @param SKB_Request request the request object to paremeterise the function call
   */
  public function prepare(){
    if($this->htmlpage_request_key==null)
      trigger_error('SKB_Applications_Content: no html page request set: "'.$this->htmlpage_request_key.'".', E_USER_ERROR);
    if($this->htmlpage_reader_key==null)
      trigger_error('SKB_Applications_Content: no html page reader set: "'.$this->htmlpage_reader_key.'".', E_USER_ERROR);
    if($this->htmlpage_builder_key==null)
      trigger_error('SKB_Applications_Content: no html page builder set: "'.$this->htmlpage_builder_key.'".', E_USER_ERROR);

  	$mySKB=SKB_Main::get_instance();

    if($this->request_key==null)
      trigger_error('SKB_Applications_Content: no request key set: "'.$this->request_key.'".', E_USER_ERROR);
    $this->request=$mySKB->get_request($this->request_key);
    $this->request->init_http();

    if($this->gallery_request_key==null)
      trigger_error('SKB_Applications_Content: no gallery request key set: "'.$this->gallery_request_key.'".', E_USER_ERROR);
    $this->request->set_value("request:request", $this->gallery_request_key);
    $this->request->activate();
    $this->request->set_value("request:collection", $this->request_collection);
    if($this->request_part!=null)
      $this->request->set_value("request:part", $this->request_part);

    if($this->content_part_reader_key==null)
      trigger_error('SKB_Applications_Content: no content-part reader key set: "'.$this->content_part_reader_key.'".', E_USER_ERROR);
    if($this->content_part_builder_key==null)
      trigger_error('SKB_Applications_Content: no content-part builder key set: "'.$this->content_part_builder_key.'".', E_USER_ERROR);
    $this->content_part_builder=$mySKB->get_builder($this->content_part_builder_key);
    $this->content_part_reader=$mySKB->get_reader($this->content_part_reader_key);
    $this->content_part_reader->set_builder($this->content_part_builder);
    $this->content_part_reader->prepare($this->request);

    $this->gallery_request=$mySKB->get_request($this->gallery_request_key);
    $this->gallery_request->init_http();
    $this->gallery_request->activate();
    $this->mm_content=$this->gallery_request->get_value("request:entry");
    $this->mm_part=$this->gallery_request->get_value("request:part");
    if(Util_Interpreter::interpret("value:is_empty", $this->mm_content)!=true)
      $this->request->set_value("request:part", $this->mm_part);

    if($this->content_reader_key==null)
      trigger_error('SKB_Applications_Content: no content reader key set: "'.$this->content_reader_key.'".', E_USER_ERROR);
    if($this->content_builder_key==null)
      trigger_error('SKB_Applications_Content: no content builder key set: "'.$this->content_builder_key.'".', E_USER_ERROR);
    $this->content_builder=$mySKB->get_builder($this->content_builder_key);
    $this->content_reader=$mySKB->get_reader($this->content_reader_key);
    $this->content_reader->set_builder($this->content_builder);
    $this->content_reader->prepare($this->request);

    if($this->prevnext_request_key==null)
      trigger_error('SKB_Applications_Content: no prevnext request key set: "'.$this->prevnext_request_key.'".', E_USER_ERROR);
    if($this->prevnext_reader_key==null)
      trigger_error('SKB_Applications_Content: no prevnext reader key set: "'.$this->prevnext_reader_key.'".', E_USER_ERROR);
    if($this->prevnext_builder_key==null)
      trigger_error('SKB_Applications_Content: no prevnext builder key set: "'.$this->prevnext_builder_key.'".', E_USER_ERROR);

    $this->prevnext_request=$mySKB->get_request($this->prevnext_request_key);
    $this->prevnext_request->activate();
    $this->prevnext_request->set_value("request:request", clone $this->gallery_request);
    $this->prevnext_builder=$mySKB->get_builder($this->prevnext_builder_key);
    $this->prevnext_reader=$mySKB->get_reader($this->prevnext_reader_key);
    $this->prevnext_reader->set_builder($this->prevnext_builder);
    $this->prevnext_reader->prepare($this->prevnext_request);
  }

/**
   * Execute the application.
   * 
   * Check for any additional (new inserted or generated) values of the involved request objects and then execute the 
   * initiated readers and builders in the correct sequence. Reader/builder pairs that are not mandatory and have not been 
   * initialised will be ignored.
   *
   * @param SKB_Request request the request object to paremeterise the function call
   */
  public function execute(){
  	$mySKB=SKB_Main::get_instance();

    $ccollection=$this->request->get_value("request:collection");
    $cpart=$this->request->get_value("request:part");

    $page_request=$mySKB->get_request($this->htmlpage_request_key);
    $page_request->init_http();
    $page_request->activate();

   	if(Util_Interpreter::interpret("value:is_empty", $this->mm_content)!=true){
      $fotos=array();
  		$ar=$this->content_reader->get_entries()->ar;
  		$_keys=array_keys($ar);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
      	if(isset($ar[$_keys[$i]]['content:foto_keys']))
      	  $fotos=array_merge($fotos,Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['content:foto_keys']));
      	if(isset($ar[$_keys[$i]]['content:graphic_keys']))
      	  $fotos=array_merge($fotos,Util_Interpreter::interpret("array:explode", $ar[$_keys[$i]]['content:graphic_keys']));
      }
      $gallery_request=$mySKB->get_request($this->gallery_request_key);
      $gallery_request->init_http();
      $gallery_request->set_value("request:file_ext",array("jpg","png"));
      //$gallery_request->set_value("request:part",$page_request->get_value("request:part"));
      $gallery_request->set_value("request:entry",$this->mm_content);
      $gallery_request->activate();
      $gallery_reader=$mySKB->get_reader("Dist.Gallery.DB2Entries");
      $gallery_reader->set_builder($mySKB->get_builder("Dist.Gallery.Entries2XHTML"));
      $gallery_reader->prepare($gallery_request);
      $ar=$gallery_reader->get_entries()->ar;

      if(isset($ar[0]['default:description'])&&$ar[0]['default:description']!=-1)
        $this->prevnext_request->set_value("default:description", $ar[0]['default:description']);
      $this->prevnext_request->set_value("request:element_keys", $fotos);
      $this->prevnext_request->set_value("request:entry", $this->mm_content[0]);
      $this->prevnext_request->set_value("request:part", $cpart);

      $page_request->set_value("htmlpage:extra_builder",array('reader'=>$this->prevnext_reader,'request'=>$this->prevnext_request));
    }

    $page=$mySKB->get_reader($this->htmlpage_reader_key);
    $page->set_builder($mySKB->get_builder($this->htmlpage_builder_key));
    $page->prepare($page_request);

    $page_request->set_value("htmlpage:execute_todo", "head");
    $page->execute($page_request);

    $page_request->set_value("htmlpage:execute_todo", "bodystart");
    $page->execute($page_request);

    //getting title information
    if(Util_Interpreter::interpret("value:is_empty", $ccollection)!=true&&Util_Interpreter::interpret("value:is_empty", $cpart)!=true){
      $ar=$this->content_part_reader->get_entries()->ar;
      if(isset($ar[$ccollection[0]][$cpart[0]]['default:name']))
        $this->request->set_value("content:title",$ar[$ccollection[0]][$cpart[0]]['default:name']);
      if(isset($ar[$ccollection[0]][$cpart[0]]['default:name_sub']))
        $this->request->set_value("content:subtitle",$ar[$ccollection[0]][$cpart[0]]['default:name_sub']);
    }
    else{
      if($this->gettext_title!="")
        $this->request->set_value("content:title",_($this->gettext_title));
      if($this->gettext_subtitle!="")
        $this->request->set_value("conent:subtitle",_($this->gettext_subtitle));
    }

    if(Util_Interpreter::interpret("value:is_empty", $cpart)!=true)
      $this->content_reader->execute($this->request);
    else
      $this->content_part_reader->execute($this->request);

    $page_request->set_value("htmlpage:execute_todo", "bodyend");
    $page->execute($page_request);
  }
}
?>