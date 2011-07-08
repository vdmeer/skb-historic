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
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */

    $mySKB=SKB_Main::get_instance();
    global $skb_menu_reader;
    $imgPath=$mySKB->configuration->get_group("path","images");

?>
          <div id="push"></div><br />
        </div>
      </div>
    </div>

    <div id="container-food-outer">
      <div id="container-food-inner">
        <div id="foot_top"></div>
        <div id="foot_top_content">
          <ul>
            <li>&copy; 2010-2011 Sven van der Meer</li>
            <li>Licenced under a <a href="http://creativecommons.org/licenses/by-nc-nd/3.0/" rel="license">Creative Commons Licence</a></li>
            <li><i>last changed:</i> <?php echo date("F j, Y, g:i a", filemtime($_SERVER["SCRIPT_FILENAME"]));?></li>
          </ul>
        </div>
        <div class="foot_middle"></div>
        <div class="foot_middle_content" style="text-align:left;">
          <ul>
            <li><i>page reference:</i> http://<?php echo $_SERVER["HTTP_HOST"].htmlspecialchars($_SERVER["REQUEST_URI"]);?></li>
          </ul>
        </div>
        <div class="foot_middle"></div>
        <div class="foot_middle_content">
          <ul>
            <li>&#160;</li>
            <li><a href="http://creativecommons.org/licenses/by-nc-nd/3.0/" rel="license"><img alt="reative Commons License" src="<?php echo $imgPath;?>dist/images/valid/cc-by-nc-nd.png" /></a></li>
            <li><a href="http://validator.w3.org/check?uri=referer"><img alt="w3c xhtml validation banner" src="<?php echo $imgPath;?>dist/images/valid/w3c-valid-xhtml11.png" /></a></li>
            <li><a href="http://jigsaw.w3.org/css-validator/check/referer"><img alt="w3c css validation banner" src="<?php echo $imgPath;?>dist/images/valid/w3c-valid-css.png" /></a></li>
            <li><a href="http://www.php.net"><img alt="php5 banner" src="<?php echo $imgPath;?>dist/images/valid/php5-power-micro.png" /></a></li>
            <li><a href="http://www.apache.org"><img alt="apache banner" src="<?php echo $imgPath;?>dist/images/valid/apache.gif" /></a></li>
            <li><img alt="no-table banner" src="<?php echo $imgPath;?>dist/images/valid/no-table.png" /></li>
            <li><a href="http://www.anybrowser.org/campaign/"><img alt="all browser banner" src="<?php echo $imgPath;?>dist/images/valid/ab_thin.png" /></a></li>
          </ul>
        </div>
        <div id="foot_bottom"></div>
      </div>
    </div>

  </body>
</html>