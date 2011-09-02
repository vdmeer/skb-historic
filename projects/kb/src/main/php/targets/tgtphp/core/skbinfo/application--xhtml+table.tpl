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
 * Template for the SKB Package Core.SkbInfo HTML table builder.
 *
 * Creates tables from $entries. For details please see builder and reader of this package.
 *
 * @package    Packages.Core.SkbInfo
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
?>
<div class="center">
  <div class="skbinfo">

<?php
	$entries=$entries->ar;
	$select=$entries['select'];

	if(isset($entries['configuration'])){
?>
	<p><table class="configuration">
		<thead>
			<tr><td colspan="3"><?php echo dgettext('pkg.core.skbinfo', "Configuration"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "group"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "value"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "group"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "value"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['configuration'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					$ar=$cfg[$_keys[$i]];
					$_keysTD=array_keys($ar);
					$_sizeTD=count($_keysTD);
					$rowsp=$_sizeTD+1;
					echo "            <tr><th rowspan=\"{$rowsp}\">" . $_keys[$i] . "</th></tr>";
					for($k=0;$k<$_sizeTD;$k++){
						$val=$ar[$_keysTD[$k]];
						if(is_array($val))
							$val=implode(", ",$val);
						elseif($val===false)
							$val="[false]";
						elseif($val===true)
							$val="[true]";
						elseif($val==null||$val=="")
							$val="[empty]";
						echo "<tr><td>" . $_keysTD[$k] . "</td><td>" . $val . "</td></tr>";
					}
				}
			?>
		</tbody>
	</table></p>
<?php
  	}

	if(isset($entries['registered_dos'])){
?>
	<p><table class="dos">
		<thead>
			<tr><td colspan="6"><?php echo dgettext('pkg.core.skbinfo', "Registered Semantic Tags"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "semantic tag"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "handle"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "tables"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "filter"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "package"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "semantic tag"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "handle"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "tables"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "filter"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "package"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_dos'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					$rowspan=count($cfg[$_keys[$i]])+1;
					echo "            <tr>";
					echo '<th rowspan="'.$rowspan.'">' . $_keys[$i] . "</th>";
					echo "</tr>\n";
					foreach($cfg[$_keys[$i]] as $sema){
						echo "            <tr>";
						echo (isset($sema['type']))?"<td>{$sema['type']}</td>":"<td>&#160;</td>";
						echo (isset($sema['handle']))?"<td>{$sema['handle']}</td>":"<td>&#160;</td>";
						if(isset($sema['tables']))
							echo "<td>".implode(", ",$sema['tables'])."</td>";
						else
							echo "<td>&#160;</td>";
						echo (isset($sema['filter_id']))?"<td>{$sema['filter_id']}</td>":"<td>&#160;</td>";
						echo (isset($sema['package']))?"<td>{$sema['package']}</td>":"<td>&#160;</td>";
						echo "            </tr>";
						}
					}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['registered_requests'])){
?>
	<p><table class="requests">
		<thead>
			<tr><td colspan="8"><?php echo dgettext('pkg.core.skbinfo', "Registered Requests"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td>core:requests:fields</td><td>core:requests:prefix</td><td>core:requests:formselect_fields</td><td>core:requests:table</td><td>core:requests:table_collections</td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td>core:requests:fields</td><td>core:requests:prefix</td><td>core:requests:formselect_fields</td><td>core:requests:table</td><td>core:requests:table_collections</td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_requests'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;
				
					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
					if(isset($cfg[$_keys[$i]]['core:requests:fields'])){
						$val=$cfg[$_keys[$i]]['core:requests:fields'];
						$val=str_replace(",","]<br />",$val);
						$val=str_replace("%"," [",$val);
						echo "<td>{$val}]</td>";
					}
					else
						echo "<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:requests:prefix']))?"<td>{$cfg[$_keys[$i]]['core:requests:prefix']}</td>":"<td>&#160;</td>";
					if(isset($cfg[$_keys[$i]]['core:requests:formselect_fields'])){
						$val=$cfg[$_keys[$i]]['core:requests:formselect_fields'];
						$val=str_replace(",","]<br />",$val);
						$val=str_replace("%"," [",$val);
						echo "<td>{$val}]</td>";
					}
					else
						echo "<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:requests:table']))?"<td>{$cfg[$_keys[$i]]['core:requests:table']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:requests:table_collections']))?"<td>{$cfg[$_keys[$i]]['core:requests:table_collections']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['registered_readers'])){
?>
	<p><table class="readers">
		<thead>
			<tr><td colspan="9"><?php echo dgettext('pkg.core.skbinfo', "Registered Readers"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td>core:rabit:requests</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td>core:rabit:requests</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_readers'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;
				
					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
				
					if(isset($cfg[$_keys[$i]]['core:rabit:target:class']))
						echo return_classes($cfg[$_keys[$i]]['core:rabit:target:class']);
					else
						echo "<td>&#160;</td>";
				
					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_in']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_in']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_out']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_out']}</td>":"<td>&#160;</td>";
				
					if(isset($cfg[$_keys[$i]]['core:rabit:requests'])){
						$val=$cfg[$_keys[$i]]['core:rabit:requests'];
						$val=str_replace(",","<br />",$val);
						echo "<td>{$val}</td>";
					}
					else
					  echo "<td>&#160;</td>";
				
					echo (isset($cfg[$_keys[$i]]['description']))?"<td>{$cfg[$_keys[$i]]['description']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['registered_builders'])){
?>
	<p><table class="builders">
		<thead>
			<tr><td colspan="9"><?php echo dgettext('pkg.core.skbinfo', "Registered Builders"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td>core:rabit:requests</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td>core:rabit:requests</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_builders'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;

					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";

					if(isset($cfg[$_keys[$i]]['core:rabit:target:class']))
						echo return_classes($cfg[$_keys[$i]]['core:rabit:target:class']);
					else
					echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_in']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_in']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_out']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_out']}</td>":"<td>&#160;</td>";
				
					if(isset($cfg[$_keys[$i]]['core:rabit:requests'])){
						$val=$cfg[$_keys[$i]]['core:rabit:requests'];
						$val=str_replace(",","<br />",$val);
						echo "<td>{$val}</td>";
					}
					else
						echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['description']))?"<td>{$cfg[$_keys[$i]]['description']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['registered_templates'])){
?>
	<p><table class="templates">
		<thead>
			<tr><td colspan="9"><?php echo dgettext('pkg.core.skbinfo', "Registered Templates"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "file"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "css"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "file"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "css"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_templates'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;

					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
				
					if(isset($cfg[$_keys[$i]]['core:rabit:target:template'])){
						foreach($cfg[$_keys[$i]]['core:rabit:target:template'] as $key => $val){
							if($key=='php')
								$val="{$key}: [rabit]/".$val.".tpl"."<br />";
							elseif($key=='java')
								$val="{$key}: [rabit]/".$val.".stg"."<br />";
							else
								$val="{$key}: [rabit]/".$val."<br />";
						}
						echo "<td>{$val}</td>";
					}
					else
						echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_in']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_in']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:rabit:mime_out']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_out']}</td>":"<td>&#160;</td>";

					if(isset($cfg[$_keys[$i]]['core:rabit:css'])){
						$val=$cfg[$_keys[$i]]['core:rabit:css'];
						$val=str_replace(",","<br />",$val);
						echo "<td>{$val}</td>";
					}
					else
						echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['description']))?"<td>{$cfg[$_keys[$i]]['description']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['registered_applications'])){
?>
		<p><table class="applications">
			<thead>
				<tr><td colspan="9"><?php echo dgettext('pkg.core.skbinfo', "Registered Applications"); ?></td></tr>
				<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
			</thead>
			<tfoot>
				<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime in"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "mime out"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
			</tfoot>
			<tbody>
				<?php
					$cfg=$entries['registered_applications'];
					ksort($cfg);
					$_keys=array_keys($cfg);
					$_size=count($_keys);
					for($i=0;$i<$_size;$i++){
						if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
							continue;

						echo "            <tr>";
						echo "<th>" . $_keys[$i] . "</th>";
						echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";

						if(isset($cfg[$_keys[$i]]['core:rabit:target:class']))
							echo return_classes($cfg[$_keys[$i]]['core:rabit:target:class']);
						else
							echo "<td>&#160;</td>";

						echo (isset($cfg[$_keys[$i]]['core:rabit:mime_in']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_in']}</td>":"<td>&#160;</td>";
						echo (isset($cfg[$_keys[$i]]['core:rabit:mime_out']))?"<td>{$cfg[$_keys[$i]]['core:rabit:mime_out']}</td>":"<td>&#160;</td>";

						echo (isset($cfg[$_keys[$i]]['description']))?"<td>{$cfg[$_keys[$i]]['description']}</td>":"<td>&#160;</td>";
						echo "</tr>\n";
					}
				?>
			</tbody>
		</table></p>
<?php
	}

	if(isset($entries['registered_interpreters'])){
?>
	<p><table class="interpreters">
		<thead>
			<tr><td colspan="9"><?php echo dgettext('pkg.core.skbinfo', "Registered Interpreters"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "class"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['registered_interpreters'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;

					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
				
					if(isset($cfg[$_keys[$i]]['core:rabit:target:class']))
						echo return_classes($cfg[$_keys[$i]]['core:rabit:target:class']);
					else
						echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['description']))?"<td>{$cfg[$_keys[$i]]['description']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
  <?php
	}

	if(isset($entries['registered_fields'])){
?>
	<p><table class="fields">
	  <thead>
	  	<tr><td colspan="15"><?php echo dgettext('pkg.core.skbinfo', "Registered Fields"); ?></td></tr>
	  	<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td>localised</td><td>type</td><td>use</td><td>entries name</td><td>http req name</td><td>default table</td><td>explode</td><td>val_unset</td><td>isval</td><td>isval_if</td><td>isval_else</td><td>val_do_list</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
	  </thead>
	  <tfoot>
	  	<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td>localised</td><td>type</td><td>use</td><td>entries name</td><td>http req name</td><td>default table</td><td>explode</td><td>val_unset</td><td>isval</td><td>isval_if</td><td>isval_else</td><td>val_do_list</td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
	  </tfoot>
	  <tbody>
			<?php
				$cfg=$entries['registered_fields'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;
	
					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";

					if(substr_compare($_keys[$i], "_locale", -strlen("_locale"), strlen("_locale"))===0)
						echo "<td>yes</td>";
					else
						echo "<td>no</td>";

					echo (isset($cfg[$_keys[$i]]['core:type']))?"<td>{$cfg[$_keys[$i]]['core:type']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:use']))?"<td>{$cfg[$_keys[$i]]['core:use']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:entries_name']))?"<td>{$cfg[$_keys[$i]]['core:entries_name']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:http_req_name']))?"<td>{$cfg[$_keys[$i]]['core:http_req_name']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:default_db']))?"<td>{$cfg[$_keys[$i]]['core:default_db']}</td>":"<td>&#160;</td>";

					if(isset($cfg[$_keys[$i]]['core:explode'])){
						if($cfg[$_keys[$i]]['core:explode']==true)
							echo "<td>true</td>";
						else
							echo "<td>false</td>";
					}
					else
						echo "<td>&#160;</td>";

					echo (isset($cfg[$_keys[$i]]['core:val_unset']))?"<td>{$cfg[$_keys[$i]]['core:val_unset']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:isval']))?"<td>{$cfg[$_keys[$i]]['core:isval']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:isval_if']))?"<td>{$cfg[$_keys[$i]]['core:isval_if']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:isval_else']))?"<td>{$cfg[$_keys[$i]]['core:isval_else']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:val_do_list']))?"<td>{$cfg[$_keys[$i]]['core:val_do_list']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['core:description']))?"<td>{$cfg[$_keys[$i]]['core:description']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['http_headers_response'])){
?>
	<p><table class="http_headers_response">
		<thead>
			<tr><td colspan="10"><?php echo dgettext('pkg.core.skbinfo', "Registered SKB HTTP Response Headers"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "header"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "example"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "header"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "example"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['http_headers_response'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;
					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['http:header']))?"<td>{$cfg[$_keys[$i]]['http:header']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['default:example']))?"<td>{$cfg[$_keys[$i]]['default:example']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['default:description_locale']))?"<td>{$cfg[$_keys[$i]]['default:description_locale']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['mime_content_types'])){
?>
	<p><table class="mime_content_types">
		<thead>
			<tr><td colspan="10"><?php echo dgettext('pkg.core.skbinfo', "Registered SKB MIME Content Types"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "media-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "content-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "content-sub-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "file extensions"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "source (URL)"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "origin"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "media-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "content-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "content-sub-type"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "file extensions"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "source (URL)"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td></tr>
		</tfoot>
		<tbody>
			<?php
				$cfg=$entries['mime_content_types'];
				ksort($cfg);
				$_keys=array_keys($cfg);
				$_size=count($_keys);
				for($i=0;$i<$_size;$i++){
					if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
						continue;
					echo "            <tr>";
					echo "<th>" . $_keys[$i] . "</th>";
					echo (isset($cfg[$_keys[$i]]['origin']))?"<td>{$cfg[$_keys[$i]]['origin']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['mime:media:type']))?"<td>{$cfg[$_keys[$i]]['mime:media:type']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['mime:type']))?"<td>{$cfg[$_keys[$i]]['mime:type']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['mime:sub:type']))?"<td>{$cfg[$_keys[$i]]['mime:sub:type']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['mime:file:extensions']))?"<td>{$cfg[$_keys[$i]]['mime:file:extensions']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['mime:source:url']))?"<td>{$cfg[$_keys[$i]]['mime:source:url']}</td>":"<td>&#160;</td>";
					echo (isset($cfg[$_keys[$i]]['default:description_locale']))?"<td>{$cfg[$_keys[$i]]['default:description_locale']}</td>":"<td>&#160;</td>";
					echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}

	if(isset($entries['enc_char'])){

	//preg_replace_callback('/\\\\u([0-9a-f]{4})/i', 'replace_unicode_escape_sequence', $cfg[$_keys[$i]]['core:encoding:utf8'])
	function replace_unicode_escape_sequence($match) {
		return mb_convert_encoding(pack('H*', $match[1]), 'UTF-8', 'UTF-16BE');
	}
	$interenc = mb_internal_encoding();

?>
	<p><table class="enc_char">
		<thead>
			<tr><td colspan="12"><?php echo dgettext('pkg.core.encoding', "Character Encodings"); ?></td></tr>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "text"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "html"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "ascii7"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "natsort"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "utf-8"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "utf-16"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "LaTeX"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "SKB-LaTeX"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "AsciiDoc"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "unicode range"); ?></td></tr>
		</thead>
		<tfoot>
			<tr><td><?php echo dgettext('pkg.core.skbinfo', "key"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "text"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "html"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "ascii7"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "natsort"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "utf-8"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "utf-16"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "LaTeX"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "SKB-LaTeX"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "AsciiDoc"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "description"); ?></td><td><?php echo dgettext('pkg.core.skbinfo', "unicode range"); ?></td></tr>
		</tfoot>
		<tbody>
		<?php
			$cfg=$entries['enc_char'];
			ksort($cfg);
			$_keys=array_keys($cfg);
			$_size=count($_keys);
			for($i=0;$i<$_size;$i++){
				if($select!=null&&isset($cfg[$_keys[$i]]['origin'])&&$select!=$cfg[$_keys[$i]]['origin'])
					continue;
				echo "            <tr>";
				echo "<th>" . htmlentities($_keys[$i]) . "</th>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:text']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:text'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:html']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:html'])."</td>":"<td>&#160;</td>";
//				echo (isset($cfg[$_keys[$i]]['core:encoding:html']))?"<td>".$cfg[$_keys[$i]]['core:encoding:html']."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:ascii7']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:ascii7'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:natsort']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:natsort'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:utf8']))?"<td>".$cfg[$_keys[$i]]['core:encoding:utf8']."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:utf16']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:utf16'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:latex']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:latex'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:latex:skb']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:latex:skb'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:asciidoc']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:asciidoc'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['default:description']))?"<td>".htmlentities($cfg[$_keys[$i]]['default:description'])."</td>":"<td>&#160;</td>";
				echo (isset($cfg[$_keys[$i]]['core:encoding:unicode:range']))?"<td>".htmlentities($cfg[$_keys[$i]]['core:encoding:unicode:range'])."</td>":"<td>&#160;</td>";
				echo "</tr>\n";
				}
			?>
		</tbody>
	</table></p>
<?php
	}


	function return_classes($ar){
		$ret='<td>';
		$count=0;
		foreach($ar as $key => $val){
			if($count>0)
				$ret.='<hr />';
			if($key=='php'){
				$val=SKB_Autoloader::get_path_abbreviated($val);
				$ret.="php name: {$ar['php']}";
				$ret.="<br />php path: {$val}<br />";
				$count++;
			}
			else{
				$ret.="{$key} name: {$val}";
				$count++;
			}
		}
		$ret.="</td>";
		return $ret;
	}
?>

  </div>
</div>
