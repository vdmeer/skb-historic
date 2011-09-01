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
 * SVG File functions.
 *
 * @package    Classes.File
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class File_SVG extends File_Base{

  public function __construct($fn, $type){
  	parent::__construct($fn, $type);
  }

  protected function _get_content(){return $this->get_content_scale();}

  /*
   * SVG specific get_content() function.
   *
   * This function gets a scale factor (default=5) and returns altered SVG content adding the scale factor to 
   * the width and height of the SVG graphic.
   *
   * @param int scale_factor the scale factor to be used, default is 5
   * @return Util_ArBase content array
   */
  public function get_content_scale($scale_factor=5){
    $ret=new Util_ArBase();

    if($this->type=="svg")
      $lines=file($this->fn);
    else
    	$lines=gzfile($this->fn);

    $width=0;
    $height=0;
    $change=false;
    foreach ($lines as $line_num => $line){
      if(strpos($line, "<?xml")===false&&strpos($line, "<!--")===false){
        if(strpos($line, "<svg")!==false)
          $change=true;
        if(strpos($line, ">")!==false)
          $change=false;

        if($change==true){
          if(strpos($line, "width=")!==false){
            $width=intval(str_replace("width=","",str_replace('"',"",$line))/$scale_factor);
            $ret->ar[]="   width=\"{$width}\"\n";
          }
          elseif(strpos($line, "height=")!==false){
            $height=intval(str_replace("height=","",str_replace('"',"",$line))/$scale_factor);
            $ret->ar[]="   height=\"{$height}\"\n";
          }
          else
            $ret->ar[]=$line;
          if($width!=0&&$height!=0){
          	$ret->ar[]='   viewBox="0 0 '.intval($width*$scale_factor) . ' ' . intval($height*$scale_factor) . '"'."\n";
          	$width=0;
          	$height=0;
          }
        }
        else
          $ret->ar[]=$line;
      }
    }
    return $ret;
  }

  protected function _get_meta_data(){
  	$ret=new Util_ArBase();
  	return $ret;
  }
}
?>