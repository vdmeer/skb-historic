<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2007-2011, Sven van der Meer <sven@vandermeer.de>
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
 * (abstract) Base class for the File package.
 *
 * @package    Classes.File
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
abstract class File_Base{
	protected $fn=null;
	protected $type=null;

  /**
   * Class constructor.
   *
   * The constructor only sets the internal values for filename ($fn) and type ($type). The available types 
   * will be managed by the factory.
   *
   * @param string fn the file name
   * @param string type the file type
   */
  public function __construct($fn, $type){
  	$this->fn=$fn;
  	$this->type=$type;
  }

  /**
   * Retrieve content from a file.
   *
   * This function returns a Util_ArBase array with the content of the file. Any child class needs to 
   * implement the protected function _get_content() to realise the type specific operations.
   * @return Util_ArBase array content
   */
  public function get_content(){
  	$ret=new Util_ArBase();
  	if($this->fn==null)
  	  return $ret;
  	else
  	  return $this->_get_content();
  }

  /**
   * File type specific content retrieval function.
   */
  protected abstract function _get_content();

  /**
   * Return meta data available for the file.
   *
   * This function returns a Util_ArBase array with the meta data for the file. Any child class needs to 
   * implement the protected function _get_meta_data() to realise the type specific operations.
   * @return Util_ArBase array content
   */
  public function get_meta_data(){
  	$ret=new Util_ArBase();
  	if($this->fn==null)
  	  return $ret;
  	else
  	  return $this->_get_meta_data();
  }

  protected abstract function _get_meta_data();
}
?>