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
 * Template for the HTML page builder in the SKB Package Dist.HtmlPage.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.HtmlPage
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
    $entries=$entries->ar;

    $http_request=SKB_Http::get_instance();
    $ct=$http_request->response_set_html_content_type();
    switch($ct){
      case "application/xhtml+xml":
        echo '<?xml version="1.0" encoding="utf-8"?>';
        echo "\n";
        echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">';
        echo "\n";
        echo '<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">';
        echo "\n";
        echo "  <head>\n";
        echo '    <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />';
        echo "\n";
        break;
      case "text/html":
      default:
        echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">';
        echo "\n";
        echo '<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">';
//        echo "\n";
//        echo "<html>";
        echo "\n";
        echo "  <head>\n";
        echo '    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />';
        echo "\n";
        break;
    }
    echo "    <title>{$entries['title']}</title>\n";

    $_size=count($entries['meta']);
    for($i=0;$i<$_size;$i++)
      echo "    <meta {$entries['meta'][$i]} />\n";

    $_size=count($entries['style']);
    for($i=0;$i<$_size;$i++)
      echo "    <style type=\"{$entries['style'][$i]['type']}\" media=\"{$entries['style'][$i]['media']}\">{$entries['style'][$i]['__content']}</style>\n";

    $_size=count($entries['script']);
    for($i=0;$i<$_size;$i++)
      echo "    <script type=\"{$entries['script'][$i]['type']}\" src=\"{$entries['script'][$i]['src']}\"></script>\n";

    echo "  </head>\n\n";
?>