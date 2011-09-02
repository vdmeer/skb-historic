<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2007-2011, Sven van der Meer <sven@vandermeer.de>
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
 * Provides a collection of functions that interpet data, i.e. change their representation
 *
 * @package    Classes.Util
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Util_Interpreter{
	public static function interpret($field, $val=null, $val_add=null, $val_add2=null){
		switch($field){
			case "array:clean":
				return self::array_clean($val); break;
			case "array:trim":
				return self::array_trim($val); break;
			case "array:explode":
				return self::array_explode($val); break;
			case "array:sort:nat:collated":
				return self::array_sort_nat_collated($val, $val_add); break;
			case "array:sort:nat":
				return self::array_sort_nat($val, $val_add, $val_add2); break;

			case "value:is_empty":
				return self::value_is_empty($val); break;

			case "add:string":
				return self::add_string($val, $val_add); break;

			case "add:char:comma":
				return self::add_char($val, ","); break;
			case "add:char:comma-blank":
				return self::add_char_with_blank($val, ","); break;

			case "add:char:colon":
				return self::add_char($val, ":"); break;
			case "add:char:colon-blank":
				return self::add_char_with_blank($val, ":"); break;

			case "add:char:slash":
				return self::add_char($val, "/"); break;
			case "add:char:slash-blank":
				return self::add_char_with_blank($val, "/"); break;

			case "add:char:hyphen":
				return self::add_char($val, "-"); break;
			case "add:char:hyphen-blank":
				return self::add_char_with_blank($val, "-"); break;

			case "add:char:blank":
				return self::add_char($val, " "); break;

			case "add:char:first:lbr":
				return self::add_first_char($val, "("); break;

			case "html:img:get:spacer":
				return self::html_img_get_spacer($val, $val_add); break;

			case "html:img:get:spacer_br":
				return self::html_img_get_spacer($val, $val_add) . "<br />"; break;
	
	
			case "bibtex:field":
				return self::bibtex_field($val, $val_add); break;
	
			case "convert_text:h2l":
				return self::convert_text_h2l($val); break;
	
			case "convert_text:h2t":
				return self::convert_text_h2t($val); break;

			case "url:build":
				return self::url_build($val, $val_add); break;

			case "url:remove:add":
				return self::url_remove_add($val); break;

			case "integer:ordinal:text":
				return self::integer_ordinal_text($val); break;

			case "email:syntax:check":
				return self::email_syntax_check($val); break;
			case "email:get:as_link":
				return self::mail_get_as_link($val); break;
			case "email:get:as_link_js":
				return self::mail_get_as_link_js($val); break;

			case "php:code:highlight":
				return self::php_code_highlight($val); break;
	
			case "paging:prevnext":
				return self::paging_prevnext($val, $val_add); break;

			default:
				return -1;
				break;
		}
	}


	private static function add_char($str, $chr){
		if(strlen($str)>0)
			if(($str[strlen($str)-1]!=$chr)&&($str[strlen($str)-1]!=" "))
				return $chr;
		return "";
	}


	private static function add_char_with_blank($str, $chr){
		(self::add_char($str, $chr)!="")?$ret=self::add_char($str, $chr) . " ":$ret="";return $ret;
	}


	private static function add_first_char($str, $chr){
		(strlen($str)==0)?$ret=$chr:$ret="";return $ret;
	}


	private static function add_string($str, $add){
		if(strlen($str)>0)
			if($str[strlen($str)-1]!=" ")
				if(((strlen($str))-(strlen($add))-(strrpos($str,$add)))!=0)
					return $add;
		return "";
	}


	private static function array_clean($ar){
		if(is_array($ar)){
			foreach ($ar as $m_key=>$m_value){
				if(is_array($ar[$m_key]))
					$ar[$m_key]=self::array_clean($m_value);
				if(self::value_is_empty($ar[$m_key])==true)
					unset($ar[$m_key]);
			}
		}
		elseif(self::value_is_empty($ar)==true)
			return null;
		return $ar;
	}


	private static function array_trim($ar){
		if(is_array($ar))
			foreach ($ar as $m_key=>$m_value)
				$ar[$m_key]=trim($m_value);
		return $ar;
	}


	private static function array_explode($str){
		$ret=array();
		if(strstr($str, "%")!==false){
			$tmp=explode(",", $str);
			$_Akeys=array_keys($tmp);
			$_Asize=count($_Akeys);
			for($k=0;$k<$_Asize;$k++){
				$ts=trim($tmp[$_Akeys[$k]]);
				$tmp2=explode("%", $ts);
				if(isset($tmp2[0])&&isset($tmp2[1]))
				$ret[$tmp2[0]]=$tmp2[1];
			}
		}
		elseif(strlen($str)==0)
			return array();
		else
			$ret=explode(",", $str);
		return self::interpret("array:trim", $ret);
	}


	private static function array_sort_nat_collated($val, $val_add){
		$ct=Util_ConversationTable::get_instance();
		$ar=$ct->get_i18n_arrays($val_add)->ar;
		return preg_replace($ar["pattern"],$ar["replace"],$val);
	}


	private static function array_sort_nat($a, $b, $lang){
		$anew=strtolower(self::array_sort_nat_collated($a,$lang));
		$bnew=strtolower(self::array_sort_nat_collated($b,$lang));
		if ($anew < $bnew) return -1;
		if ($anew > $bnew) return 1;
		return 0;
	}


	private static function value_is_empty($var){
		if(is_object($var)){
			if(count($var)==0)
				return true;
			return false;
		}
		if(is_array($var)){
			if(empty($var))
			return true;
			if(count($var)==0)
				return true;
			return false;
		}
		elseif((is_null($var)||rtrim($var)=="")&&$var!==false)
			return true;

		return false;
	}


	private static function html_img_get_spacer($width, $height){
		$mySKB=SKB_Main::get_instance();
		return "<img src=\"" . $mySKB->configuration->get_group("path","images") . "bgrnd_q.gif" . "\" width=\"$width\" height=\"$height\" alt=\"spacer\" />";
	}


	private static function bibtex_field($field, $content){
		return '  ' . $field . ' = {'  . self::convert_text_h2l($content) . '},'  . "\n";
	}


	private static function url_build($href, $ar){
		$mySKB=SKB_Main::get_instance();
		$url=parse_url($href);

		$query_ar=array();
		if(isset($url['query'])){
			$tmp_ar=explode("&",$url['query']);
			$_keys=array_keys($tmp_ar);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++){
				list($key,$val)=explode("=",$tmp_ar[$_keys[$i]]);
				$query_ar[$key]=$val;
			}
		}
		if(is_array($ar))
			$query_ar=array_merge($query_ar, self::array_clean($mySKB->configuration->get_group("request")), self::array_clean($ar));
		else
			$query_ar=array_merge($query_ar, self::array_clean($mySKB->configuration->get_group("request")));
		$url['query']=http_build_query($query_ar);

		$ret=$url['path'];
		if(strlen($url['query'])>0)
			$ret.='?'.$url['query'];
		if(isset($url['fragment']))
			$ret.='#'.$url['fragment'];
		return htmlentities($ret);
	}


	private static function url_remove_add($href){
		$mySKB=SKB_Main::get_instance();
		$urlAr=parse_url($href);
		if(!isset($urlAr["query"]))
			return $urlAr["path"];

		$urlQuery=explode("&",$urlAr["query"]);

		$urlAdd=$mySKB->configuration->get_group("html", "url-add");
		$_keys=array_keys($urlQuery);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			$_keysAdd=array_keys($urlAdd);
			$_sizeAdd=count($_keysAdd);
			for($k=0;$k<$_sizeAdd;$k++){
				if(strstr($urlQuery[$_keys[$i]], $urlAdd[$_keysAdd[$k]])!==false){
					unset($urlQuery[$_keys[$i]]);
					continue;
				}
			}
		}

		$ret=$urlAr["path"];
		if(count($urlQuery)>0)
			$ret.="?" . implode("&",$urlQuery);
		return $ret;
	}


	private static function integer_ordinal($cardinal){
		$ret=self::integer_ordinal_text($cardinal);
		if($ret!=-1)
			$ret=$cardinal.$ret;
		return $ret;
	}


	private static function integer_ordinal_text($cardinal){
		$ret=-1;
		if(!is_numeric($cardinal))
			return $ret;

		$cardinal=(int)$cardinal;
		$digit=substr($cardinal, -1, 1);

		if($cardinal<100)
			$tens=round($cardinal/10);
		else
			$tens=substr($cardinal, -2, 1);

		if($tens == 1)
			return 'th';

		switch($digit) {
			case 1:  $ret='st'; break;
			case 2:  $ret='nd'; break;
			case 3:  $ret='rd'; break;
			default: $ret='th'; break;
		}
		return $ret;
	}


	private static function email_syntax_check($_email){
		return External_EmailSyntaxCheck::email_syntax_check($_email);
	}


	private static function mail_get_as_link($text){
		$ret = eregi_replace( "([[:alnum:]]+)://([^[:space:]]*)([[:alnum:]#?/&=])",  "<a href=\"\\1://\\2\\3\" target=\"_blank\" target=\"_new\">\\1://\\2\\3</a>", $text);
		$ret = eregi_replace( "(([a-z0-9_]|\\-|\\.)+@([^[:space:]]*)([[:alnum:]-]))",  "<a href=\"mailto:\\1\" target=\"_new\">\\1</a>", $ret);
		return $ret;
	}


	private static function mail_get_as_link_js($val){
		$ret="<a class=\"" . $val['class'] . "\" href=\"javascript:textclick(text2('" . $val['domain'] . "','','" . $val['name'] . "'))\"\n";
		$ret.="   onmouseout=\"return textclear();\"\n";
		$ret.="   onmouseover=\"return textview(text2('" . $val['domain'] . "','','" . $val['name'] . "'));\">" . $val['nprint'] . "</a>\n";
		return $ret;
	}


	private static function convert_text_h2l($s){
		$ct=Util_ConversationTable::get_instance();
		return strtr($s, $ct->get_h2l_arrays());
	}


	private static function convert_text_h2t($s){
		$ct=Util_ConversationTable::get_instance();
		return strtr($s, $ct->get_h2t_arrays());
	}


	private static function php_code_highlight($fn){
		return External_PhPCodeHighlight::php_code_highlight($fn);
	}


	private static function paging_prevnext($key, $ar){
		$ret=array();
		$_keys=array_keys($ar);
		$_size=count($_keys);
		for($i=0;$i<$_size;$i++){
			if($_keys[$i]==$key){
				if($i==0){
					if(isset($_keys[1]))
						$ret["next"]=$_keys[1];
				}
				elseif($i==($_size-1))
					$ret["prev"]=$_keys[($i-1)];
				else{
					$ret["next"]=$_keys[($i+1)];
					$ret["prev"]=$_keys[($i-1)];
				}
				if(isset($ar['description']))
					$ret["alt"]=$ar['description'];
				elseif(isset($ar['name']))
					$ret["alt"]=$ar['name'];
				else
					$ret["alt"]=null;
			}
		}
		return $ret;
	}
}


/*
  public static function mail_do_link($text){
    $ret = eregi_replace( "([[:alnum:]]+)://([^[:space:]]*)([[:alnum:]#?/&=])",  "<a href=\"\\1://\\2\\3\" target=\"_blank\" target=\"_new\">\\1://\\2\\3</a>", $text);
    $ret = eregi_replace( "(([a-z0-9_]|\\-|\\.)+@([^[:space:]]*)([[:alnum:]-]))",  "<a href=\"mailto:\\1\" target=\"_new\">\\1</a>", $ret);
    return $ret;
  }

  public static function mail_get_link_js($name, $domain, $class, $nprint){
    $ret="<a class=\"" . $class . "\" href=\"javascript:textclick(text2('" . $domain . "','','" . $name . "'))\"\n";
    $ret.="   onmouseout=\"return textclear();\"\n";
    $ret.="   onmouseover=\"return textview(text2('" . $domain . "','','" . $name . "'));\">" . $nprint . "</a>\n";
    return $ret;
  }
*/


?>