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
 * Extended HTML4 Table, offering some added functionality
 *
 * @package    Classes.HTML4.Extension
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2007-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class Html4_Ext_Table extends Html4_Base{
  /**
   * Constructor for the extended table element.
   *
   * The constructor works similar to the base class ({@link Html4_Base Html4_Base}), except that the paramter htype is automatically 
   * set to table (so it's not part of this constructor. Furthermore, three attributes are set in the constructor:
   * <ul>
   *   <li>altColors - for alternating colors (color1 and color2)</li>
   *   <li>altClasses - for alternating css classes (class1 and class2)</li>
   *   <li>optimise - is set to false since optimisation of the HTML4 package doesn't work well with the extra functionality</li>
   * </ul>
   *
   * @param array attributes HTML attributes as array("attribute" => "value")
   * @param mixed content content for the instance (mixed, object, array of mixed or array of objects)
   * @param array parameters configuration parameters array("parameter" => "value")
   * @param string obj_id identifier the instance
   */
  public function __construct($attributes=false, $content=false, $objID=false){
    $cfgAttr=array(
      "altColors"  => array("value" => false, "color1" => false, "color2" => false, "current" => 0),
      "altClasses" => array("value" => false, "class1" => false, "class2" => false, "current" => 0),
      "optimise" => false,
    );
    parent::__construct("table", $attributes, $content, $cfgAttr, $objID);
  }

  /**
   *  Set alternate colours for table rows.
   *
   *  @param string $color1 the color for all odd rows
   *  @param string $color2 the color for all even rows
   */
  public function set_alternate_colors($color1, $color2){
    $this->parameters["altColors"]["value"]=true;
    $this->parameters["altColors"]["color1"]=$color1;
    $this->parameters["altColors"]["color2"]=$color2;
    $this->parameters["altColors"]["current"]=0;
  }

  /** @ignore */
  private function do_alternate_colors(){
    if($this->parameters["altColors"]["value"]==true){
      $_keys=array_keys($this->content);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
        if(is_object($this->content[$_keys[$i]])&&$this->content[$_keys[$i]]->htype()=="tr"){
          $color=($this->parameters["altColors"]["current"]==0)?$this->parameters["altColors"]["color1"]:$this->parameters["altColors"]["color2"];
          $newCurrent=($this->parameters["altColors"]["current"])==0?1:0;
          if($color!="")
            $this->content[$_keys[$i]]->set("bgcolor",$color);
          $this->parameters["altColors"]["current"]=$newCurrent;
        }
        if(is_object($this->content[$_keys[$i]])&&$this->content[$_keys[$i]]->htype()=="tbody"){
          $newCurrent=($this->parameters["altColors"]["current"])==0?1:0;
          $this->content[$_keys[$i]]->do_alternate_colors($this->parameters["altColors"]["color1"],$this->parameters["altColors"]["color2"],$newCurrent);
          $this->parameters["altColors"]["current"]=$newCurrent;
        }
      }
    }
  }

  /**
   *  Set alternate classes for table rows.
   *
   *  @param string $class1 the class for all odd rows
   *  @param string $class2 the class for all even rows
   */
  public function set_alternate_classes($class1, $class2){
    $this->parameters["altClasses"]["value"]=true;
    $this->parameters["altClasses"]["class1"]=$class1;
    $this->parameters["altClasses"]["class2"]=$class2;
    $this->parameters["altClasses"]["current"]=0;
  }

  /** @ignore */
  private function do_alternate_classes(){
    if($this->parameters["altClasses"]["value"]==true){
      $_keys=array_keys($this->content);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
        if(is_object($this->content[$_keys[$i]])&&$this->content[$_keys[$i]]->htype()=="tr"){
          $class=($this->parameters["altClasses"]["current"]==0)?$this->parameters["altClasses"]["class1"]:$this->parameters["altClasses"]["class2"];
          $newCurrent=($this->parameters["altClasses"]["current"])==0?1:0;
          if($class!="")
            $this->content[$_keys[$i]]->set("class",$class);
          $this->parameters["altClasses"]["current"]=$newCurrent;
        }
        else if(is_object($this->content[$_keys[$i]])&&$this->content[$_keys[$i]]->htype()=="tbody"){
          $newCurrent=($this->parameters["altClasses"]["current"])==0?1:0;
          $this->content[$_keys[$i]]->do_alternate_classes($this->parameters["altClasses"]["class1"],$this->parameters["altClasses"]["class2"],$newCurrent);
          $this->parameters["altClasses"]["current"]=$newCurrent;
        }
      }
    }
  }

  /**
   *  Convert the HTML4 Table object into a string, using the set or default colours and classes
   *
   *  @param string $indent minimum indent for each line of the code, default is 0
   *  "param boolean $_echo not used here, inherited from base class
   */
  public function to_string($indent=0, $_echo=false){
  	$this->do_alternate_colors();
  	$this->do_alternate_classes();
  	return parent::to_string($indent);
  }

  /**
   *  Convert the HTML4 Table object into a string and print the result.
   *
   *  @param string $indent minimum indent for each line of the code, default is 0
   */
  public function print_html($indent=0){
  	$this->do_alternate_colors();
  	$this->do_alternate_classes();
  	parent::print_html($indent);
  }
}
?>