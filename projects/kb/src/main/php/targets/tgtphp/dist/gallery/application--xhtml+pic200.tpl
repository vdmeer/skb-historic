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
 * Template for the HTML picture builder in the SKB Package Dist.Gallery, creating a thumbnail of the picture.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
	$req=clone $request;
	$req->set_value("request:entry", $entry['key']);
	$href=$req->build_url($_SERVER["PHP_SELF"]);

	$source=null;
	if(isset($entry['file']['jpg']))
		$source=$entry['file']['jpg'];
	elseif(isset($entry['file']['jpeg']))
		$source=$entry['file']['jpeg'];
	elseif(isset($entry['file']['gif']))
		$source=$entry['file']['gif'];
	elseif(isset($entry['file']['png']))
		$source=$entry['file']['png'];

	if($source==null)
		return;

	if(!isset($entry['default:description']))
		$entry['default:description']="";

	if(isset($source['small'])){
?>
	<div class="img-frame-link"><?php if(isset($source['full'])): ?><a href="<?php echo $href ;?>"><?php endif; ?><img src="<?php echo $source['small']['rel'];?>" width="<?php echo $source['small']['width'];?>" height="<?php echo $source['small']['height'];?>" alt="<?php echo $entry['default:description'] ;?>" /><?php if(isset($source['full'])): ?></a><?php endif; ?><?php if(isset($entry['request:hbr'])): echo "<br />\n"; endif; ?></div>
<?php
	}
	elseif(isset($source['full'])){
?>
	<div class="center" style="padding-top:10px;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="img-shadow">
						<img src="<?php echo $source['full']['rel'];?>" width="<?php echo $source['full']['width'];?>" height="<?php echo $source['full']['height'];?>" alt="<?php echo $entry['default:description'] ;?>" />
					</div>
				</td>
			</tr>
		</table>
	</div>
<?php
	}
?>