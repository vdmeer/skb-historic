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
 * Application for the SKB Package Dist.Gallery.
 *
 * This is an example for an SKB Application, which combines readers and builders
 * for complex tasks. This application can present pictures, photos and figures.
 * It automatically integrates collections (for grouping pictures) and the 
 * Dis.PrevNext package for navigation support. It also shows thumbnails and 
 * automatically creates the links to full size pictures.<br />
 * <br />
 * For instance, if you have a foto album with fotos of your garden from various 
 * years and months, you can organise them using the SKB with parts and collections.
 * A collection is a large grouping of fotos (i.e. garden, house, holidays) and a part
 * is a smaller group within a collection (i.e. garden in 2009 and garden in 2010).
 * Once you have filled the database with information, you can use this application 
 * to generate the whole navigation through all fotos automatically:<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$skb_main=SKB_Main::get_instance();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery=$skb_main->get_application("<span style="font-weight:bold;">Dist.Gallery.Application</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery->set_request_collection("<span style="font-weight:bold;">garden</span>");</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery->set_request_extras("<span style="font-weight:bold;">request:file_ext</span>",array("<span style="font-weight:bold;">jpg</span>"));</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery->prepare();</span><br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery->execute();</span><br />
 * <br />
 * The code above instantiates a new application for the gallery and sets the collection to "garden".
 * It also adds the extension "jpg", which will instruct the gallery application to load only jpg files.
 * Then simply call prepare and execute, using the default configuration of the gallery. If you wanted to go 
 * directly to a specific part, say Garden 2009 called "garden-2009", simply add the following line before the call 
 * to prepare:<br />
 *   <span style="font-family:monospace;color:DarkGreen">&#160;&#160;$gallery->set_request_part("<span style="font-weight:bold;">garden-2009</span>");</span><br />
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__gallery___gallery___application{
	/**
	 * Default request used for html page
	 * @var string $htmlpage_request_key
	 */
	private $htmlpage_request_key="Dist.HtmlPage";


	/**
	 * Change the key for the html page request, default is "Dist.HtmlPage".
	 * @param string $s new key
	 */
	public function set_htmlpage_request_key($s){
		$this->htmlpage_request_key=$s;
	}


	/**
	 * Default reader used for html page
	 * @var string $htmlpage_reader_key
	 */
	private $htmlpage_reader_key="Dist.HtmlPage.DB2Entries";


	/**
	 * Change the key for the html page reader, default is "Dist.HtmlPage.DB2Entries".
	 * @param string $s new key
	 */
	public function set_htmlpage_reader_key($s){
		$this->htmlpage_reader_key=$s;
	}


	/**
	 * Default builder used for html page
	 * @var string $set_htmlpage_builder_key
	 */
	private $htmlpage_builder_key=null;


	/**
	 * Change the key for the html page builder, default is null.
	 * @param string $s new key
	 */
	public function set_htmlpage_builder_key($s){
		$this->htmlpage_builder_key=$s;
	}


	/**
	 * The local request for the application.
	 * @var string $request_key
	 */
	private $request;


	/**
	 * Default request key for the application.
	 * @var string $request_key
	 */
	private $request_key="Dist.Gallery.Fotos";


	/**
	 * Change the key for the default request, default is "Dist.Gallery.Fotos".
	 * @param string $s new key
	 */
	public function set_request_key($s){
		$this->request_key=$s;
	}


	/**
	 * Extra values for the local request.
	 * @var array $request_extras
	 */
	private $request_extras=array();


	/**
	 * Change extra values for the default request.
	 * @param string $key the key for the extra value
	 * @param mixed $val the exta value
	 */
	public function set_request_extras($key, $val){
		$this->request_extras[$key]=$val;
	}


	/**
	 * The default request for collections
	 * @var string $request_collection
	 */
	private $request_collection=null;


	/**
	 * Change the key for the default request for collections, default is null.
	 * @param string $s new key
	 */
	public function set_request_collection($s){
		$this->request_collection=$s;
	}


	/**
	 * The default request for parts
	 * @var string $request_part
	 */
	private $request_part=null;


	/**
	 * Change the key for the default request for parts, default is null.
	 * @param string $s new key
	 */
	public function set_request_part($s){
		$this->request_part=$s;
	}


	/**
	 * The gallery reader.
	 * @var string $gallery_reader
	 */
	private $gallery_reader=null;


	/**
	 * The default gallery reader key.
	 * @var string $gallery_reader_key
	 */
	private $gallery_reader_key="Dist.Gallery.DB2Entries";


	/**
	 * Change the key for the default gallery reader, default is "Dist.Gallery.DB2Entries".
	 * @param string $s new key
	 */
	public function set_gallery_reader_key($s){
		$this->gallery_reader_key=$s;
	}


	/**
	 * The gallery builder.
	 * @var string $gallery_builder
	 */
	private $gallery_builder=null;


	/**
	 * The default gallery builder key.
	 * @var string $gallery_builder_key
	 */
	private $gallery_builder_key="Dist.Gallery.Entries2XHTML";


	/**
	 * Change the key for the default gallery builder, default is "Dist.Gallery.Entries2XHTML".
	 * @param string $s new key
	 */
	public function set_gallery_builder_key($s){
		$this->gallery_builder_key=$s;
	}


	/**
	 * The gallery part reader.
	 * @var string $gallery_part_reader
	 */
	private $gallery_part_reader=null;


	/**
	 * The default gallery part reader key.
	 * @var string $gallery_part_reader_key
	 */
	private $gallery_part_reader_key="Dist.Collections.DB2Entries";


	/**
	 * Change the key for the default gallery part reader, default is "Dist.Collections.DB2Entries".
	 * @param string $s new key
	 */
	public function set_gallery_part_reader_key($s){
		$this->gallery_part_reader_key=$s;
	}


	/**
	 * The gallery part builder.
	 * @var string $gallery_part_builder
	 */
	private $gallery_part_builder=null;


	/**
	 * The default gallery part builder key.
	 * @var string $gallery_part_builder_key
	 */
	private $gallery_part_builder_key="Dist.Collections.Entries2XHTML-Table";


	/**
	 * Change the key for the default gallery part builder, default is "Dist.Collections.Entries2XHTML-Table".
	 * @param string $s new key
	 */
	public function set_gallery_part_builder_key($s){
		$this->gallery_part_builder_key=$s;
	}


	/**
	 * Boolean for showing part links or not.
	 * @var boolean $show_part_links
	 */
	private $show_part_links=true;


	/**
	 * Tell the application to not show part links
	 * @param string $s new key
	 */
	public function dont_show_part_links(){
		$this->show_part_links=false;
	}


	/**
	 * Array for extra 'stuff' before the pictures (pre)
	 * @var array $show_part_links
	 */
	private $extra_pre=array();


	/**
	 * Add anything you want to put before the picutres are shown (pre)
	 * @param mixed $extra the extra information, i.e. some html code
	 */
	public function add_extra_pre($extra){
		$this->extra_pre[]=$extra;
	}


	/**
	 * Array for extra 'stuff' after the pictures (post)
	 * @var array $show_part_links
	 */
	private $extra_post=array();


	/**
	 * Add anything you want to put after the picutres are shown (post)
	 * @param mixed $extra the extra information, i.e. some html code
	 */
	public function add_extra_post($extra){
		$this->extra_post[]=$extra;
	}


	/**
	 * An empty constructor, since we use dependency injection for configuring the application.
	 */
	public function __construct(){
	}


	/**
	 * Prepare the application, i.e. collect and read all information, but do not print yet.
	 */
	public function prepare(){
		if($this->htmlpage_request_key==null)
			trigger_error('SKB_Applications_Gallery: no html page request set: "'.$this->htmlpage_request_key.'".', E_USER_ERROR);
		if($this->htmlpage_reader_key==null)
			trigger_error('SKB_Applications_Gallery: no html page reader set: "'.$this->htmlpage_reader_key.'".', E_USER_ERROR);
		if($this->htmlpage_builder_key==null)
			trigger_error('SKB_Applications_Gallery: no html page builder set: "'.$this->htmlpage_builder_key.'".', E_USER_ERROR);
	
		$mySKB=SKB_Main::get_instance();
	
		if($this->request_key==null)
		  trigger_error('SKB_Applications_Gallery: no request key set: "'.$this->request_key.'".', E_USER_ERROR);
		$this->request=$mySKB->get_request($this->request_key);
		$this->request->init_http();
		if(count($this->request_extras)>0){
			$_keys=array_keys($this->request_extras);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++)
				$this->request->set_value($_keys[$i],$this->request_extras[$_keys[$i]]);
		}
	
		if($this->gallery_reader_key==null)
			trigger_error('SKB_Applications_Gallery: no gallery reader key set: "'.$this->gallery_reader_key.'".', E_USER_ERROR);
		if($this->gallery_builder_key==null)
			trigger_error('SKB_Applications_Gallery: no gallery builder key set: "'.$this->gallery_builder_key.'".', E_USER_ERROR);
		$this->gallery_builder=$mySKB->get_builder($this->gallery_builder_key);
		$this->gallery_reader=$mySKB->get_reader($this->gallery_reader_key);
		$this->gallery_reader->set_builder($this->gallery_builder);
	
		if($this->gallery_part_reader_key==null)
			trigger_error('SKB_Applications_Gallery: no gallery-part reader key set: "'.$this->gallery_part_reader_key.'".', E_USER_ERROR);
		if($this->gallery_part_builder_key==null)
			trigger_error('SKB_Applications_Gallery: no gallery-part builder key set: "'.$this->gallery_part_builder_key.'".', E_USER_ERROR);
		$this->gallery_part_builder=$mySKB->get_builder($this->gallery_part_builder_key);
		$this->gallery_part_reader=$mySKB->get_reader($this->gallery_part_reader_key);
		$this->gallery_part_reader->set_builder($this->gallery_part_builder);
	
		$this->request->set_value("request:collection", $this->request_collection);
		if($this->request_part!=null){
			$this->request->set_value("request:part", $this->request_part);
			$this->request->activate();
		}
	
		$cpart=$this->request->get_value("request:part");
		if(Util_Interpreter::interpret("value:is_empty", $cpart)==true){
			$this->request->set_value("request:part", $this->request_collection);
			$this->request->activate();
		}
	
		$this->gallery_part_reader->prepare($this->request);
		$this->gallery_reader->prepare($this->request);
	}


	/**
	 * Execute the application, i.e. print everything using the builders.
	 */
	public function execute(){
		$mySKB=SKB_Main::get_instance();
	
		$bodyadd=array();
		if($this->show_part_links==true)
			$bodyadd[]=array('reader'=>$this->gallery_part_reader,'request'=>$this->request);

		$skb_collection=$this->request->get_value('request:collection');
		$skb_part=$this->request->get_value('request:part');
		$skb_key=$this->request->get_value('request:entry');
		if(count($skb_collection)==1&&count($skb_part)==1&&count($skb_key)==1){
			$skb_collection=$skb_collection[0];
			$skb_part=$skb_part[0];
			$fotos=$this->gallery_part_reader->get_entries()->ar;

			$fotos=$fotos[$skb_collection][$skb_part]['request:element_keys'];

			$prev_next_request=$mySKB->get_request("Dist.PrevNext");
			$prev_next_request->activate();
			$prev_next_request->set_value("request:request", clone $this->request);
			$prev_next_builder=$mySKB->get_builder("Dist.PrevNext.Entries2XHTML-Table");
			$prev_next_reader=$mySKB->get_reader("Dist.PrevNext.DB2Entries");
			$prev_next_reader->set_builder($prev_next_builder);
			$prev_next_reader->prepare($prev_next_request);

			$single_foto=$this->gallery_reader->get_entries()->ar;
			if(isset($single_foto[0]['default:description'])&&$single_foto[0]['default:description']!=-1)
				$prev_next_request->set_value("default:description", $single_foto[0]['default:description']);
			elseif(isset($single_foto[0]['default:name'])&&$single_foto[0]['default:name']!=-1)
				$prev_next_request->set_value("default:description", $single_foto[0]['default:name']);
			$prev_next_request->set_value("request:element_keys", $fotos);
			$prev_next_request->set_value("request:entry", $skb_key);
			$prev_next_request->set_value("request:part", $skb_part);
			$prev_next_request->set_value("request:collection", $skb_collection);

			$bodyadd[]=array('reader'=>$prev_next_reader,'request'=>$prev_next_request);
		}

		$request=$mySKB->get_request($this->htmlpage_request_key);
		$request->init_http();
		$request->activate();
		$request->set_value("htmlpage:extra_builder",$bodyadd);

		$page=$mySKB->get_reader($this->htmlpage_reader_key);
		$page->set_builder($mySKB->get_builder($this->htmlpage_builder_key));
		$page->prepare($request);

		$request->set_value("htmlpage:execute_todo", "head");
		$page->execute($request);

		$request->set_value("htmlpage:execute_todo", "bodystart");
		$page->execute($request);

		if(count($skb_key)!=1){
			if(count($this->extra_pre)>0){
				$_keys=array_keys($this->extra_pre);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if(is_object($this->extra_pre[$_keys[$i]]))
						echo $this->extra_pre[$_keys[$i]]->toString();
					else
						echo $this->extra_pre[$_keys[$i]];
					echo "\n";
				}
			}
		}

		$this->gallery_reader->execute($this->request);

		if(count($skb_key)!=1){
			if(count($this->extra_post)>0){
				$_keys=array_keys($this->extra_post);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if(is_object($this->extra_post[$_keys[$i]]))
						echo $this->extra_post[$_keys[$i]]->toString();
					else
						echo $this->extra_post[$_keys[$i]];
					echo "\n";
				}
			}
		}

		$request->set_value("htmlpage:execute_todo", "bodyend");
		$page->execute($request);
	}
}
?>