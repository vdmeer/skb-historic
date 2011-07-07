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
 * Template for the formselect builder in the SKB Package Dist.Gallery, creates the form.
 *
 * For examples how to use this template, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Gallery
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
?>
<div class="form-frame">
  <form name="options" method="post" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
    <input type="hidden" name="<?php echo $request->get_form_name("active"); ?>" value="true" />
    <div class="center">
      <br />
<?php
    $ar=$entries->ar;
    $_keys=array_keys($ar);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      $tpl=new Util_Template($tplSingle);
      $tpl->set("entry", $ar[$_keys[$i]]);
      $tpl->set("request", $request);
      $tpl->printT();
    }
?>
    </div>

    <br /><br />
    <fieldset>
      <legend>[ <b>Options</b> ]</legend>
      <?php echo $form_data; ?>
      <br /><br />

      <div class="form-button"><input type="submit" value=" &rsaquo;&rsaquo; Submit Changes &rsaquo;&rsaquo; " /></div>
<!--      <div class="form-button"><button onclick="return toggleHelp('options_help')">&rsaquo;&rsaquo; Explain Select Boxes</button></div> -->
      <br /><br />

<!--
      <div class="help" id="help_options_help">
        <p>
          Use the select boxes to minimise your search space. All boxes allow multiple selections. Use &lt;shift&gt; and &lt;ctrl&gt; to select/unselect items. The boxes will be logically combined as follows:<br />
          <code style="margin-left:25px;">(Category  XOR EntryType) . ) AND Year AND ReferenceCategory AND (Journal XOR Conference)</code><br />
          The two XOR combinations are processed as follows<br />
          <code style="margin-left:25px;">- nothing selected in neither of the 2 boxes, show all references</code><br />
          <code style="margin-left:25px;">- selection in only one of the 2 boxes, is the selection</code><br />
          <code style="margin-left:25px;">- selections in both of the 2 boxes, show all references</code><br />
        </p>
      </div>
-->
    </fieldset>
  </form>
</div>