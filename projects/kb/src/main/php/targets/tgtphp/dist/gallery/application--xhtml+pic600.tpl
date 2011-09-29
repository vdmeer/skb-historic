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
 * Template for the HTML picture builder in the SKB Package Dist.Gallery, creating a large view of the picture.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
	if(!is_array($entry))
		return;

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

	if(isset($source['full'])){
?>
	<div class="center" style="padding-top:10px;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div class="img-shadow">
						<img src="<?php echo $source['full']['rel'];?>" width="<?php echo $source['full']['width'];?>" height="<?php echo $source['full']['height'];?>" alt="<?php echo $entry['default:description'] ;?>" />
					</div>
<?php
		$fn=File_Factory::get_file($source['full']['abs']);
		$ar=$fn->get_meta_data()->ar;
		if(count($ar)>0){
?>
					<div class="table-exif">
						<br style="clear: both;" /><br />
						<table>
<?php
			$_keys=array_keys($ar);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++){
?>
							<tr>
								<th><b><?php echo $_keys[$i];?></b></th>
								<td><?php echo $ar[$_keys[$i]];?></td>
							</tr>
<?php
			}
?>
						</table>
					</div>
<?php
		}
?>
				</td>
			</tr>
		</table>
	</div>
<?php
	}
?>