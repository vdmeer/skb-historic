/* Copyright (c) 2010-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
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
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.util.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.skb.util.sql.PDO;
import org.skb.types.atomic.java.OatString;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.atomic.util.OatPDO;
import org.skb.types.composite.util.OatMapLH;

/**
 * Implementation of a PDO object for the SKB.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class DBPDOs {
	/**
	 * The local array maintaining all PDO objects.
	 */
	private OatMapLH db_pdos=new OatMapLH();
	
	public DBPDOs(){}

	/**
	 * Add a PDO object.
	 * 
	 * This function will add an entry named 'key' in the local PDO array and then add the given filename (fn),
	 * tables, actual PDO object and origin to this entry. If the parameter 'tables' contains any table already
	 * linked to a PDO, then the existing link will be removed and the overwrite documented.
	 * @param key key for the new PDO
	 * @param fn filename for the database linked to the PDO
	 * @param tables array with a single table or a list of tables associated with the PDO
	 * @param pdo the actual PDO object
	 * @param origin string indicating where this PDO information comes form, i.e. from which package
	 */
	public void pdo_add(String key, String fn, OatArrayListString tables, OatPDO pdo, String origin){
		int _size=tables.size();
		for(int i=0;i<_size;i++)
			this.table_remove(tables.get(i),key);

		this.db_pdos.put(key, new OatMapLH());
		this.db_pdos.put(new ArrayList<String>(Arrays.asList(key, "file")), fn);
		this.db_pdos.put(new ArrayList<String>(Arrays.asList(key, "pdo")), pdo);
		this.db_pdos.put(new ArrayList<String>(Arrays.asList(key, "origin")), origin);
		this.db_pdos.put(new ArrayList<String>(Arrays.asList(key, "tables")), tables);
	}

	/**
	 * Test of a particular table exists in the given PDO object.
	 * 
	 * This function tries to read data from the table 'table' on the given PDO object. If the read is successful,
	 * it returns true, otherwise false.
	 * @param pdo object to use in the test
	 * @param table to test for
	 * @return true if table exists, false otherwise
	 */
	public boolean pdo_table_exists(OatPDO pdo, String table){
		return this.pdo_table_exists(pdo.oatValue, table);
	}

	/**
	 * Test of a particular table exists in the given PDO object.
	 * 
	 * This function tries to read data from the table 'table' on the given PDO object. If the read is successful,
	 * it returns true, otherwise false.
	 * @param pdo object to use in the test
	 * @param table to test for
	 * @return true if table exists, false otherwise
	 */
	public boolean pdo_table_exists(PDO pdo, String table){
		return this.pdo_table_exists(pdo.get_core(), table);
	}

	/**
	 * Test of a particular table exists in the given PDO object.
	 * 
	 * This function tries to read data from the table 'table' on the given PDO object. If the read is successful,
	 * it returns true, otherwise false.
	 * @param c connection object to use in the test
	 * @param table to test for
	 * @return true if table exists, false otherwise
	 */
	public boolean pdo_table_exists(Connection c, String table){
		try{
			ResultSet rs=c.createStatement().executeQuery("SELECT * FROM "+table);
			rs.next();

		} catch (Exception e) {
			return false;
			//e.printStackTrace();
		}
		return true;
	}

	/**
	 * Private function to select a PDO.
	 * 
	 * This function is used internally to test if a PDO object exists and provides access to a particular table.
	 * It returns the PDO object on success, otherwise it triggers a user error.
	 * it returns true, otherwise false.
	 * @param table table to look for
	 * @return PDO object
	 */
	public OatPDO pdo_select(String table){
		String key;
		Set<String> o_set = this.db_pdos.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			OatArrayListString val=this.db_pdos.get(new ArrayList<String>(Arrays.asList(key, "tables"))).getValOatArrayListString();
			if(val!=null&&val.contains(table))
				return this.db_pdos.get(key+"/"+"pdo").getValOatPdo();
		}
		return null;
	}


	/**
	 * Private function to remove a table from a registered PDO.
	 * 
	 * This function is used internally to remove a table from the table list of a registered PDO.
	 * @param table table to be removed
	 * @param who string to indicate who initiated the removal (overwrite effectively), i.e. package name
	 */
	private void table_remove(OatString table, String who){
		String key;
		Set<String> o_set = this.db_pdos.keySet();
		Iterator<String> key_it = o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			OatArrayListString val=this.db_pdos.get(new ArrayList<String>(Arrays.asList(key, "tables"))).getValOatArrayListString();
			if(val!=null&&val.contains(table)){
				this.db_pdos.get(key+"/"+"tables").getValOatArrayListString().remove(table);
				this.db_pdos.get(key+"/"+"tables").getValOatArrayListString().add("["+table+" overwritten by "+who+"]");
			}
		}
	}

	/**
	 * Initiate an SQL query on a PDO.
	 * 
	 * This function will do an SQL query on the given PDO using the provided select string and table(s). If
	 * where and order are provided, the respective SQL commands will be added to the query. If the PDO object does not
	 * exist or select and tables were empty, it will trigger a user notice.
	 * @param pdo PDO object to be used in the query, set to null for automatic selection
	 * @param select parameters for the SQL command SELECT
	 * @param table table to be used in the select
	 * @param where parameters to the SQL command WHERE (empty on default
	 * @param order parameters to the SQL command ORDER (empty on default)
	 * @return ResultSet object or null if not successful
	 */
	public ResultSet sql_query(OatPDO pdo, String select, String table, String where, String order){
		if(pdo==null)
			pdo=this.pdo_select(table);
		return pdo.oatValue.query(select, table, where, order);
	}

	/**
	 * Return the complete array of registered PDOs.
	 * @return a map with all currently registered PDO objects
	 */
	public OatMapLH get_registered_pdos(){
		return this.db_pdos;
	}

	public OatMapLH get_registered_pdos(String group, String key){
		if(key==null)
			return this.db_pdos.get("group").getValOatMapLH();
		else
			return this.db_pdos.get(group+"/"+key).getValOatMapLH();
	}


	  /*
	   * Call SQL operation INSERT.
	   * 
	   * This function will call the SQL operation INSERT on the specified table.
	   * $insert must be an associated array with its keys identifying table rows and the values being the values to be inserted.
	   *
	   * @param string table table to insert information into.
	   * @param array insert array to be used to insert information.
	   */
//	  public function insert($table=null, $insert=array()){
//	    if($table==null)
//	      return -1;
//	    elseif(count($insert)<1)
//	      return -1;
//	    else{
//	      $sql="INSERT INTO " . $table . " (" . implode(',',array_keys($insert)) . ") VALUES (" . implode(',',array_values($insert)) . ")";
//	      $pdo=$this->pdo_select($table);
//	      $sth=$pdo->prepare($sql);
//	      $sth->execute();
//	    }
//	  }


	  /*
	   * Call SQL operation UPDATE.
	   * 
	   * This function will call the SQL operation UPDATE on the specified table.
	   * $insert must be an associated array with its keys identifying table rows and the values being the values to be updated.
	   *
	   * @param string table table to update information into.
	   * @param array insert array to be used to update information.
	   * @param array key specify the row for the update.
	   */
//	  public function update($table=null, $update=array(), $key=null){
//	    if($table==null)
//	      return -1;
//	    elseif(count($update)<1)
//	      return -1;
//	    elseif($key==null)
//	      return -1;
//	    else{
//	      $_keys=array_keys($update);
//	      $_size=count($_keys);
//	      for($i=0;$i<$_size;$i++){
//	        $sql="UPDATE " . $table . " SET " . $_keys[$i] . " = '" . $update[$_keys[$i]] . "' WHERE key = '" . $key . "';";
//	        $pdo=$this->pdo_select($table);
//	        $sth=$pdo->prepare($sql);
//	        $sth->execute();
//	      }
//	    }
//	  }

	public String toString(){
		return this.db_pdos.toString();
	}
}
