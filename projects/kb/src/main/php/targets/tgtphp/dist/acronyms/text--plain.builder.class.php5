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
 * Builder for the SKB Package Dist.Acronyms, creating plain text list of acronyms.
 *
 * For examples how to use this builder, please see the documentation for the reader of this package.
 *
 * @package    Packages.Dist.Acronyms
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class pkg_dist__acronyms___text__plain___builder extends SKB_Builder{
  /**
   * The template id for the builder.
   *
   * @var $tpl
   */
  protected $tpl="Dist.Acronyms.Entries2Text-Plain:Template";

  /**
   * Class Constructor.
   *
   * It calls the parent class to instantiate the template repository and then 
   * adds the local template to it.
   */
  function __construct(){
  	parent::__construct();
  	$this->templates->add_template("tpl", $this->tpl);
  }

  /**
   * The builder specific execute function.
   *
   * Automatically called by {@link SKB_Builder#execute() SKB_Builder->execute}
   */
  public function execute_loop(SKB_Request $request, Util_ArBase $entries){
    $tpl=$this->templates->get_template_object("tpl");
    $tpl->set("entries", $entries);
    $tpl->printT();
  }
}
?>