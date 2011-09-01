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
 * Extended HTML4 TBody, offering some added functionality
 *
 * @package    Classes.HTML4.Extension
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
class Html4_Ext_TBody extends Html4_Base{
  /**
   * Constructor for the extended table body element.
   *
   * The constructor works similar to the base class ({@link Html4_Base Html4_Base}), except that the paramter htype is automatically 
   * set to tb (so it's not part of this constructor. Furthermore, the atribute optimise is set to fales,
   * since optimisation of the HTML4 package doesn't work well with the extra functionality
   *
   * @param array attributes HTML attributes as array("attribute" => "value")
   * @param mixed content content for the instance (mixed, object, array of mixed or array of objects)
   * @param array parameters configuration parameters array("parameter" => "value")
   * @param string obj_id identifier the instance
   */
  public function __construct($attributes=false, $content=false, $objID=false){
  	parent::__construct("tbody", $attributes, $content, array("optimise"=>false), $objID);
  }

  /**
   *  Set alternate colours for table rows.
   *
   *  @param string $color1 the color for all odd rows
   *  @param string $color2 the color for all even rows
   *  @param string $currentColor the current colour
   */
  public function do_alternate_colors($color1,$color2,$currentColor){
  	$curCol=$currentColor;

    $_keys=array_keys($this->content);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      $color=($curCol==1)?$color1:$color2;
      $curCol=($curCol==1)?2:1;
      if($color!="")
        $this->content[$_keys[$i]]->set("bgcolor",$color);
    }
  }

  /**
   *  Set alternate classes for table rows.
   *
   *  @param string $class1 the class for all odd rows
   *  @param string $class2 the class for all even rows
   *  @param string $currentClass the current class
   */
  public function do_alternate_classes($class1,$class2,$currentClass){
  	$curClass=$currentClass;
    $_keys=array_keys($this->content);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      $class=($curClass==1)?$class1:$class2;
      $curClass=($curClass==1)?2:1;
      if($class!="")
        $this->content[$_keys[$i]]->set("class",$class);
    }
  }

  /**
   *  Sort the rows of the table.
   *
   */
  public function ua_sort(){
  	uasort($this->content, array("Html4_Ext_TR", "compare"));
  }

  /**
   *  Normalise the rows of the table body.
   *
   *  @param ar $ar array to normalise
   */
  public function normalise($ar){
    $_keys=array_keys($this->content);
    $_size=count($_keys);
    for($i=0;$i<$_size;$i++){
      $val=$this->content[$_keys[$i]];
      if(is_object($val))
        $val->normalise($ar);
    }
  }
}

?>