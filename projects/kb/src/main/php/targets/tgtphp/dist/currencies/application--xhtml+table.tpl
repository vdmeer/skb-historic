<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2010-2010, Sven van der Meer <sven@vandermeer.de>
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
 * Template for the HTML table builder in the SKB Package Dist.Currencies.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Currencies
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
            echo "                <th>Code</th>\n";
            echo "                <th>Number</th>\n";
            echo "                <th>Exponent</th>\n";
            echo "                <th>Name</th>\n";
            echo "                <th>Country</th>\n";
            echo "                <th>Organisation</th>\n";
            echo "                <th>Replaced by</th>\n";
            echo "                <th>Description</th>\n";
            echo "                <th>Active?</th>\n";
            echo "              </tr></thead>";
            echo "              <tbody>";

            $_keys=array_keys($entries->ar);
            $_size=count($_keys);
            for($i=0;$i<$_size;$i++){
          ?>
              <tr>
                <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['currencies:code'] ?></td>
                <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['currencies:number'] ?></td>
                <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['currencies:e'] ?></td>
                <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['default:name'] ?></td>

                <?php if(isset($entries->ar[$_keys[$i]]['default:country'])): ?>
                  <td style="vertical-align:top;text-align:left;">
                    <?php
                      $_keysC=array_keys($entries->ar[$_keys[$i]]['default:country']);
                      $_sizeC=count($_keysC);
                      for($c=0;$c<$_sizeC;$c++){
                        if($c>0)
                          echo ", ";
                        echo $entries->ar[$_keys[$i]]['default:country'][$_keysC[$c]]['default:name'];
                      }
                    ?>
                  </td>
                <?php else: ?>
                  <td style="vertical-align:top;text-align:left;">&#160;</td>
                <?php endif; ?>

                <?php if(isset($entries->ar[$_keys[$i]]['default:organization'])): ?>
                  <td style="vertical-align:top;text-align:left;">
                    <?php
                      $_keysO=array_keys($entries->ar[$_keys[$i]]['default:organization']);
                      $_sizeO=count($_keysO);
                      for($o=0;$o<$_sizeO;$o++){
                        if($o>0)
                          echo ", ";
                        if(isset($entries->ar[$_keys[$i]]['default:organization'][$_keysO[$o]]['default:acronym']['acronyms:long']))
                          echo $entries->ar[$_keys[$i]]['default:organization'][$_keysO[$o]]['default:acronym']['acronyms:long'];
                        else
                          echo $entries->ar[$_keys[$i]]['default:organization'][$_keysO[$o]]['default:name'];
                      }
                    ?>
                  </td>
                <?php else: ?>
                  <td style="vertical-align:top;text-align:left;">&#160;</td>
                <?php endif; ?>

                <?php if(isset($entries->ar[$_keys[$i]]['currencies:replacedby'])): ?>
                  <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['currencies:replacedby']['default:name']."(".$entries->ar[$_keys[$i]]['currencies:replacedby']['currencies:code'].")"; ?></td>
                <?php else: ?>
                  <td style="vertical-align:top;text-align:left;">&#160;</td>
                <?php endif; ?>

                <?php if(isset($entries->ar[$_keys[$i]]['default:description'])): ?>
                  <td style="vertical-align:top;text-align:left;"><?php echo $entries->ar[$_keys[$i]]['default:description'] ?></td>
                <?php else: ?>
                  <td style="vertical-align:top;text-align:left;">&#160;</td>
                <?php endif; ?>

                <?php if(isset($entries->ar[$_keys[$i]]['currencies:active'])&&$entries->ar[$_keys[$i]]['currencies:active']==true): ?>
                  <td style="vertical-align:top;text-align:left;">active</td>
                <?php else: ?>
                  <td style="vertical-align:top;text-align:left;">historic
                  <?php if(isset($entries->ar[$_keys[$i]]['default:year_start'])||isset($entries->ar[$_keys[$i]]['default:month_start'])||isset($entries->ar[$_keys[$i]]['default:day_start'])||isset($entries->ar[$_keys[$i]]['default:year_end'])||isset($entries->ar[$_keys[$i]]['default:month_end'])||isset($entries->ar[$_keys[$i]]['default:day_end'])): ?>
                    <?php
                      $mySKB=SKB_Main::get_instance();
                      echo "(".$mySKB->interpret_data("Dist.Date.Interpreter.PeriodString", $entries->ar[$_keys[$i]]).")";
                    ?>
                  <?php endif; ?>
                  </td>
                <?php endif; ?>

              </tr>
          <?php
            }
            echo "              </tbody>";
          ?>
        </table>
      </div>
      <br />
    </div>
