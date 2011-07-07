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
 * Template for the Sitemap builder in the SKB Package Dist.Menu.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Menu
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
  if(!isset($entries['options'])||strstr($entries['options'], "no-sitemap")===false)
    echo pkg_dist__menu___helpers::sitemap_li($position, $entries['level']);
  else
    return;

  $tpl=new Util_Template($tpl_entry);
  $tpl->set("entries", $entries);
  $tpl->set("tpl_list", $tpl_list);
  $tpl->set("tpl_entry", $tpl_entry);
  $tpl->printT();

  $next_level=$entries['level']+1;

  if(isset($entries['_children'])&&pkg_dist__menu___helpers::check_print_levels($levels,$next_level)==true){
    echo "\n<ul";
    if($entries['level']==1)
      echo " class=\"sub\"";
    echo ">";

    $_keys=array_keys($entries['_children']);
    $_size=count($_keys);

    $positionT=pkg_dist__menu___helpers::alter_positions($position, $_size);
    for($i=0;$i<$_size;$i++){
      $pos=pkg_dist__menu___helpers::set_position($_size, $i);

      $tpl=new Util_Template($tpl_list);

      $tpl->set("levels", $levels);
      $tpl->set("position", $positionT.$pos);
      $tpl->set("entries", $entries['_children'][$_keys[$i]]);
      $tpl->set("tpl_list", $tpl_list);
      $tpl->set("tpl_entry", $tpl_entry);
      $tpl->printT();
    }
    echo "</ul>\n\n";
  }
  echo "</li>\n";
?>