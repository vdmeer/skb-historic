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
 * Demo Template for the HTML table builder in the SKB Package Dist.People.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.People
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
?>
    <div class="center">
      <br />
      <div class="table-widegrey">
        <table style="width:auto;">
          <?php
            echo "              <thead><tr>";
            echo "                <th>First</th>\n";
            echo "                <th>Middle</th>\n";
            echo "                <th>Last</th>\n";
            echo "                <th>Affiliation(s)</th>\n";
            echo "              </tr></thead>";

            echo "              <tbody>";
            $_keys=array_keys($entries->ar);
            $_size=count($_keys);
            for($i=0;$i<$_size;$i++){
              echo "              <tr>";
              if(isset($entries->ar[$_keys[$i]]['people:first']))
                echo '                <td>'.$entries->ar[$_keys[$i]]['people:first'].'</td>'."\n";
              else
                echo '                <td>&#160;</td>'."\n";

              if(isset($entries->ar[$_keys[$i]]['people:middle']))
                echo '                <td>'.$entries->ar[$_keys[$i]]['people:middle'].'</td>'."\n";
              else
                echo '                <td>&#160;</td>'."\n";

              if(isset($entries->ar[$_keys[$i]]['people:last']))
                echo '                <td>'.$entries->ar[$_keys[$i]]['people:last'].'</td>'."\n";
              else
                echo '                <td>&#160;</td>'."\n";

              if(isset($entries->ar[$_keys[$i]]['people:affiliation'])){
                echo '                <td>';
                $ar=$entries->ar[$_keys[$i]]['people:affiliation'];
                $_keysAf=array_keys($ar);
                $_sizeAf=count($_keysAf);
                for($k=0;$k<$_sizeAf;$k++){
                  if(isset($ar[$_keysAf[$k]]['default:name']))
                    echo ($k+1).': '.$ar[$_keysAf[$k]]['default:name'];
                  elseif(isset($ar[$_keysAf[$k]]['default:acronym']))
                    echo ($k+1).': '.$ar[$_keysAf[$k]]['default:acronym']['acronyms:long'];
                  if(isset($ar[$_keysAf[$k]]['default:acronym']))
                    echo ' ('.$ar[$_keysAf[$k]]['default:acronym']['acronyms:short'].')';
                  if(isset($ar[$_keysAf[$k]]['default:address']))
                    echo ', '.$ar[$_keysAf[$k]]['default:address'];
                  if(isset($ar[$_keysAf[$k]]['default:city'])){
                    if(isset($ar[$_keysAf[$k]]['default:city']['default:name']))
                      echo ', '.$ar[$_keysAf[$k]]['default:city']['default:name'];
                    if(isset($ar[$_keysAf[$k]]['default:city']['default:country']['default:name']))
                      echo ', '.$ar[$_keysAf[$k]]['default:city']['default:country']['default:name'];
                  }
                  elseif(isset($ar[$_keysAf[$k]]['default:country']['default:name'])){
                    echo ', '.$ar[$_keysAf[$k]]['default:country']['default:name'];
                  }
                  if(isset($ar[$_keysAf[$k]]['default:url']))
                    echo ', '.$ar[$_keysAf[$k]]['default:url'];
                  echo "<br />\n";
                }
                echo '</td>'."\n";
              }
              else
                echo '                <td>&#160;</td>'."\n";

              echo "              </tr>";
            }
            echo "              </tbody>";
          ?>
        </table>
      </div>
      <br />
    </div>
