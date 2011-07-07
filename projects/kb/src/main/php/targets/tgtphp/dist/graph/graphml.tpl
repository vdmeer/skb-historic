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
 * Template for the GraphML builder in the SKB Package Dist.Graph.
 *
 * @package    Packages.Dist.Graph
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2010-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
?>
<?xml version="1.0" encoding="UTF-8"?>
<!--
<graphml xmlns="http://graphml.graphdrawing.org/xmlns"  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd">
-->
<graphml xmlns="http://graphml.graphdrawing.org/xmlns/graphml"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd"
         xmlns:y="http://www.yworks.com/xml/graphml"
>

<?php
  if(isset($entries->ar['graphml:data'])&&is_array($entries->ar['graphml:data']))
    print_data($entries->ar['graphml:data']);
?>

  <!-- for yFiles -->
<!--
  <key id="d0" for="node" attr.name="style" attr.type="complex"/>  
  <key id="d1" for="node" attr.name="labels" attr.type="complex"/>  
  <key id="d2" for="node" attr.name="geometry" attr.type="complex"/>  
  <key id="d3" for="port" attr.name="style" attr.type="complex"/>  
  <key id="d4" for="port" attr.name="geometry" attr.type="complex"/>  
  <key id="d5" for="edge" attr.name="style" attr.type="complex"/>  
  <key id="d6" for="edge" attr.name="labels" attr.type="complex"/>  
  <key id="d7" for="edge" attr.name="geometry" attr.type="complex"/>  
-->
  <key for="node" id="d15" yfiles.type="nodegraphics" attr.name="id15" attr.type="string"/>


  <graph id="top:" edgedefault="undirected">
<?php
//print_r($entries->ar);
  print_nodes($entries->ar, "top");
  if(isset($entries->ar['graphml:edges'])&&is_array($entries->ar['graphml:edges']))
    print_edges($entries->ar['graphml:edges']);
?>
  </graph>
</graphml>


<?php
function print_nodes($ar, $top_node){
  $_keys=array_keys($ar);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    if($_keys[$i]!="graphml:edges"&&$_keys[$i]!="graphml:data"&&is_array($ar[$_keys[$i]])){
      echo '      <node id="'.$_keys[$i].'">'."\n";
//      if(isset($ar[$_keys[$i]]['default_name']))
//        echo '        <data key="d15"><y:GenericNode><y:NodeLabel>'.$ar[$_keys[$i]]['default_name'].'</y:NodeLabel></y:GenericNode></data>'."\n";
      echo '        <graph id="'.$_keys[$i].':">'."\n";
      print_nodes_rec($_keys[$i], $ar[$_keys[$i]], $top_node);
      echo '        </graph>'."\n";
      echo '      </node>'."\n";
    }
  }
}

function print_nodes_rec($parrent, $ar, $top_node){
  $_keys=array_keys($ar);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
    echo '          <node id="'.$parrent."::".$_keys[$i].'">'."\n";
    print_attributes($ar[$_keys[$i]]);
    echo '          </node>'."\n";
  }
}

function print_attributes($ar){
	if(!is_array($ar))
	  return;
	$_keys=array_keys($ar);
  $_size=count($_keys);
  for($i=0;$i<$_size;$i++){
  	if(!is_array($ar[$_keys[$i]])){
  		echo '            <data key="'.$_keys[$i].'">'.htmlspecialchars($ar[$_keys[$i]]).'</data>'."\n";
      if($_keys[$i]=='default_name')
        echo '            <data key="d15"><y:GenericNode><y:NodeLabel>'.$ar[$_keys[$i]].'</y:NodeLabel></y:GenericNode></data>'."\n";
      elseif($_keys[$i]=='key')
        echo '            <data key="d15"><y:GenericNode><y:NodeLabel>'.$ar[$_keys[$i]].'</y:NodeLabel></y:GenericNode></data>'."\n";
  	}
  }
}

function print_edges($ar){
  $i=0;
  while(list($source, $val)=each($ar)){
  	$val=array_unique($val);
  	foreach($val as $target)
  		echo '          <edge id="'.$i++.'" source="'.$source.'" target="'.$target.'"/>'."\n";
  }
}

function print_data($ar){
  while(list($key, $data)=each($ar))
    echo '  <key id="'.$data.'" for="node" attr.name="'.$data.'" attr.type="string"/>'."\n";
}

?>
