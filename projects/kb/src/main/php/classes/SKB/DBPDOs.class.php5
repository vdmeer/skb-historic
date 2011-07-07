<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2009-2011, Sven van der Meer <sven@vandermeer.de>
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
 * A simple class to manage PDO objects and provide an API for SQL operations
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.32 build 110405 (05-Apr-11) with PHP 5.3.0
 */
class SKB_DBPDOs{
  /**
   * The local array maintaining all PDO objects.
   * @var Util_ArType
   */
	private $db_pdos=array();


  /**
   * Class constructor (empty)
   */
	public function __construct(){}


  /**
   * Add a PDO object.
   * 
   * This function will add an entry named 'key' in the local PDO array and then add the given filename (fn),
   * tables, actual PDO object and origin to this entry. If the parameter 'tables' contains any table allready
   * linked to a PDO, then the existing link will be removed and the overwrite documented.
   *
   * @param string key key for the new PDO
   * @param string fn filename for the database linked to the PDO
   * @param mixed tables string or array with a single table or a list of tables associated with the PDO
   * @param PDO pdo the actual PDO object
   * @param string origin string indicating where this PDO information comes form, i.e. from which package
   */
  public function pdo_add($key, $fn, $tables, $pdo, $origin){
  	$_keys=array_keys($tables);
  	$_size=count($_keys);
  	for($i=0;$i<$_size;$i++){
  		$this->table_remove($tables[$_keys[$i]], $key);
  	}

    $this->db_pdos[$key]=array();
    $this->db_pdos[$key]['file']=$fn;
    $this->db_pdos[$key]['pdo']=$pdo;
    $this->db_pdos[$key]['origin']=$origin;
    if(is_array($tables))
      $this->db_pdos[$key]['tables']=$tables;
    elseif($tables!=null)
      $this->db_pdos[$key]['tables']=Util_Interpreter::interpret("array:explode", $tables);
  }


  /**
   * Test of a particular table exists in the given PDO object.
   * 
   * This function tries to read data from the table 'table' on the given PDO object. If the read is successfull,
   * it returns true, otherwise false.
   *
   * @param PDO pdo PDO object to use in the test
   * @param string table table to test for
   */
  public function pdo_table_exists($pdo, $table){
    $sth=$pdo->prepare("SELECT * FROM " . $table);
    if(!is_object($sth)){
    	return false;
    }
    if($sth->execute())
      return true;
    else
      return false;
  }


  /**
   * Private function to select a PDO.
   * 
   * This function is used internally to test if a PDO object exists and provides access to a particular table.
   * It returns the PDO object on success, otherwise it triggers a user error.
   * it returns true, otherwise false.
   *
   * @param string table to look for
   */
  private function pdo_select($table){
  	$_keys=array_keys($this->db_pdos);
  	$_size=count($_keys);
  	for($i=0;$i<$_size;$i++){
  		if(in_array($table, $this->db_pdos[$_keys[$i]]['tables']))
  		  return $this->db_pdos[$_keys[$i]]['pdo'];
  	}
    trigger_error("SKB_DBPDOs: no database with table {$table} connected", E_USER_ERROR);
  }


  /**
   * Private function to remove a table from a registered PDO.
   * 
   * This function is used internally to remove a table from the table list of a registered PDO.
   *
   * @param string table table to be removed
   * @param string who string to indicate who initiated the removal (overwrite effectively), i.e. package name
   */
  private function table_remove($table, $who){
  	$_keys=array_keys($this->db_pdos);
  	$_size=count($_keys);
  	for($i=0;$i<$_size;$i++){
  		if(in_array($table, $this->db_pdos[$_keys[$i]]['tables'])){
 		    $this->db_pdos[$_keys[$i]]['tables']=array_diff($this->db_pdos[$_keys[$i]]['tables'], array($table));
 		    $this->db_pdos[$_keys[$i]]['tables'][]="[$table overwritten by $who]";
 		  }
 		}
  }


//  public function table_registered($table){
//  	$_keys=array_keys($this->db_pdos);
//  	$_size=count($_keys);
//  	for($i=0;$i<$_size;$i++){
//  		if(in_array($table, $this->db_pdos[$_keys[$i]]['tables']))
//  		  return true;
//  	}
//    return false;
//  }


  /**
   * Initiate an SQL query on a PDO.
   * 
   * This function will do an SQL query on the given PDO using the provided select string and table(s). If 
   * where and order are provided, the respective SQL commands will be added to the query. If the PDO object does not 
   * exist or select and tables were empty, it will trigger a user notice.
   *
   * @param PDO pdo PDO object to be used in the query, set to null for automatic selection
   * @param string select parameters for the SQL command SELECT
   * @param mixed tables array or string with a single table or table list to be used in the query
   * @param string where parameters to the SQL command WHERE (empty on default
   * @param string order parameters to the SQL command ORDER (empty on default)
   */
  public function sql_query($pdo, $select, $tables, $where=null, $order=null){
    if(is_array($select)&&count($select)>0)
      $select=implode(',',$select);
    elseif(!strlen($select)>0)
      $select=null;

    if(is_array($tables)&&count($tables)>0)
      $tables=implode(',',$tables);
    elseif(!strlen($tables)>0)
      $tables=null;

    if($select==null&&$tables==null){
    	trigger_error('SKB_DBPDOs: select and tables are empty', E_USER_NOTICE);
      return -1;
    }

    if(!strlen($where)>0)
      $where=null;
    if(!strlen($order)>0)
      $order=null;

    $sql="SELECT " . $select . " FROM " . $tables;
    if($where!=null)
      $sql.=" WHERE " . $where;
    if($order!=null)
      $sql.=" ORDER BY " . $order;

    if($pdo==null)
      $pdo=$this->pdo_select($tables);
//echo $sql."<br />\n";
    $sth=$pdo->prepare($sql);
    if($sth->execute())
      return $sth;
    else
      return -1;
  }


  /**
   * Initiate an SQL query on a PDO and return a Util_ArBase.
   * 
   * This function is a wrapper for sql_query, returning -1 on error or a Util_ArBase with the results.
   *
   * @param PDO pdo PDO object to be used in the query, set to null for automatic selection
   * @param string select parameters for the SQL command SELECT
   * @param mixed tables array or string with a single table or table list to be used in the query
   * @param string where parameters to the SQL command WHERE (empty on default
   * @param string order parameters to the SQL command ORDER (empty on default)
   */
  public function sql_query_array($pdo, $select, $tables, $where=null, $order=null){
    $sth=$this->sql_query($pdo, $select, $tables, $where, $order);
    if(sth!=-1)
      return new Util_ArBase($sth->fetchAll(PDO::FETCH_ASSOC));
    else
      return -1;
  }


  /**
   * Return the array with the PDO registrations.
   * 
   * This function returns the complete array of registered PDOs.
   */
  public function get_registered_pdos(){return $this->db_pdos;}


  /**
   * Return the information on a particular registered PDO.
   * 
   * This function returns the array with all information about the registered PDO identifed by $group and $key, or -1.
   *
   * @param string group group identifier for the PDO (or the actual PDO key if no groups are used).
   * @param string group key identifier for the PDO (only if groups are used).
   */
//  public function get_registered_pdos_by_key($group, $key=null){
//  	if(array_key_exists($key, $this->db_pdos))
//  	  return $this->db_pdos[$key];
//  	return -1;
//  }


  /**
   * Call SQL operation INSERT.
   * 
   * This function will call the SQL operation INSERT on the specified table.
   * $insert must be an associated array with its keys identifying table rows and the values being the values to be inserted.
   *
   * @param string table table to insert information into.
   * @param array insert array to be used to insert information.
   */
  public function insert($table=null, $insert=array()){
    if($table==null)
      return -1;
    elseif(count($insert)<1)
      return -1;
    else{
      $sql="INSERT INTO " . $table . " (" . implode(',',array_keys($insert)) . ") VALUES (" . implode(',',array_values($insert)) . ")";
//print_r($insert);
//echo "<br /><br />\n\n".$sql;
      $pdo=$this->pdo_select($table);
      $sth=$pdo->prepare($sql);
//echo $pdo->errorCode();
//print_r($pdo->errorInfo());
      $sth->execute();
    }
  }


  /**
   * Call SQL operation UPDATE.
   * 
   * This function will call the SQL operation UPDATE on the specified table.
   * $insert must be an associated array with its keys identifying table rows and the values being the values to be updated.
   *
   * @param string table table to update information into.
   * @param array insert array to be used to update information.
   * @param array key specify the row for the update.
   */
  public function update($table=null, $update=array(), $key=null){
    if($table==null)
      return -1;
    elseif(count($update)<1)
      return -1;
    elseif($key==null)
      return -1;
    else{
      $_keys=array_keys($update);
      $_size=count($_keys);
      for($i=0;$i<$_size;$i++){
        $sql="UPDATE " . $table . " SET " . $_keys[$i] . " = '" . $update[$_keys[$i]] . "' WHERE key = '" . $key . "';";
        $pdo=$this->pdo_select($table);
        $sth=$pdo->prepare($sql);
        $sth->execute();
//        echo $sql;
//        echo "\n\n";
      }
    }
  }



//  private function keys($table){
//    $sql="SELECT key FROM {$table} ORDER BY key";
//    $r=array();
//    $pdo=$this->select_pdo($table);
//    foreach ($pdo->query($sql) as $row)
//      $r[]=$row['key'];
//    return new Util_ArBase($r);
//  }
//
//  public function has_key($key, $table){
//    $ret=true;
//    $sql="SELECT key FROM {$table} WHERE key = '{$key}'";
//    $pdo=$this->select_pdo($table);
//    $sth=$pdo->prepare($sql);
//    $sth->execute();
//    $res=$sth->fetchAll(PDO::FETCH_ASSOC);
//    if(count($res)==0)
//      $ret=false;
//    return $ret;
//  }
//
//  public function table_exists($table){
//  	$_keys=array_keys($this->db_pdos);
//  	$_size=count($_keys);
//  	for($i=0;$i<$_size;$i++){
//  		if(in_array($table, $this->db_pdos[$_keys[$i]]['tables']))
//  		  return true;
//  	}
//    return false;
//  }
//
//  private function test_pdo($table){
//  	$_keys=array_keys($this->db_pdos);
//  	$_size=count($_keys);
//  	for($i=0;$i<$_size;$i++){
//  		if(in_array($table, $this->db_pdos[$_keys[$i]]['tables']))
//  		  return true;
//  	}
//    return false;
//  }


}
?>