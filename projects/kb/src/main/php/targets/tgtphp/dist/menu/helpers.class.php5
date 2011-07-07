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
 * A class with some helper functions for the SKB Ppackage Dist.Menu.
 *
 * @package    Packages.Dist.Menu
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class pkg_dist__menu___helpers{

  public static function alter_positions($pos, $size, $count=-1){
    if($pos!=""){
      $_change="";
      if($pos[strlen($pos)-1]=='l')
        $_change='n';
      else
        $_change='v';

      $pos=str_replace("l",$_change,$pos);
      $pos=str_replace("m","v",$pos);
    }
    return $pos;
  }
  
  public static function set_position($size, $count){
    $ret='';
    if($count<$size)
      $ret='m';
    if($count==($size-1))
      $ret='l';
    return $ret;
  }

  public static function check_print_levels($levels, $level){
    $ret=false;
    $levAr=explode("-",$levels);
    if(count($levAr)<2)
      return false;
    $min=0+$levAr[0];
    $max=0+$levAr[1];
    if($level>=$min&&$level<=$max)
        return true;
    return $ret;
  }

  public static function sitemap_li($pos, $level){
    ob_start();
    echo "<li>";
    for($i=0;$i<strlen($pos);$i++){
      if($level>1&&$pos[$i]=="n")
        echo '<span class="none">&#160;</span>';
      if($level>1&&$pos[$i]=="v")
        echo '<span class="vert">&#160;</span>';
      if($level>1&&$pos[$i]=="m")
        echo '<span class="midd">&#160;</span>';
      if($level>1&&$pos[$i]=="l")
        echo '<span class="last">&#160;</span>';
    }
    $ret=ob_get_contents();
    ob_end_clean();
    return $ret;
  }
}
?>