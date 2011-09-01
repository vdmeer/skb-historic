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
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.skb.util.types.TSRepository;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.composite.util.TSArrayList;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Implementation of a PDO object.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PDO {
	private Connection core=null;
	public Connection get_core(){return this.core;}

	private Statement statement=null;
	private ResultSet result_set=null;

	public PDO(){
	}

	public PDO(Connection c){
		this.core=c;
	}

	public void set(java.sql.Connection c){
		this.core=c;
	}

	public void clearWarnings() throws SQLException{
		try{
			this.core.clearWarnings();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void close() throws SQLException{
		try{
			this.core.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void commint() throws SQLException{
		try{
			this.core.commit();
		} catch (SQLException e) {
			throw e;
		}
	}

	public Statement createStatement() throws SQLException{
		Statement s=null;
		try{
			this.core.createStatement();
		} catch (SQLException e){
			throw e;
		}
		return s;
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException{
		Statement s=null;
		try{
			this.core.createStatement(resultSetType, resultSetConcurrency);
		} catch (SQLException e){
			throw e;
		} return s;
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException{
		Statement s=null;
		try{
			this.core.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
		} catch (SQLException e){
			throw e;
		}
		return s;
	}

	public DatabaseMetaData getMetaData() throws SQLException{
		DatabaseMetaData dmd=null;
		try{
			this.core.getMetaData();
		} catch (SQLException e){
			throw e;
		}
		return dmd;
	}

	public ResultSet query(ArrayList<String> sel, String table, String whe, String ord){
		String select=null;
		if(sel!=null){
			select=new String();
			for(int i=0;i<sel.size();i++){
				if(i>0)
					select+=",";
				select+=sel.get(i);
			}
			return this.query(select, table, whe, ord);
		}
		return null;
	}

	public ResultSet query(String sel, String table, String whe, String ord){
		this.result_set=null;
		String select=null;
		if(sel.length()>0)
			select=sel;
		else
			System.err.println("Empty Select string!"+"\n--> USER ERROR");

		if(select==null&&table==null)
			return null;

		String sql=new String("SELECT "+select+" FROM "+table);
		if(whe!=null&&whe.length()>0)
			sql+=" WHERE "+whe;
		if(ord!=null&&ord.length()>0)
			sql+=" ORDER BY \""+ord+"\"";
		try {
			this.statement=this.core.createStatement();
			this.result_set=statement.executeQuery(sql);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return this.result_set;
	}

	public TSMapLH semanticQuery(TSMapLH query, String from){
		TSMapLH ret=new TSMapLH();

		//select string
		if(query.get("find").tsIsType(TSRepository.TEnum.TS_COMPOSITE_ARRAYLIST)&&((TSArrayList)query.get("find")).size()>0)
			query.put("find", new TSString(StringUtils.join(((TSArrayList)query.get("find")).toArray(),",")));
		if(!(query.get("find").toString().length()>0))
			query.put("find", new TSString("*"));

		//where string
		String where="";
		if(query.get("equals").tsIsType(TSRepository.TEnum.TS_COMPOSITE_MAP_LH)&&((TSMapLH)query.get("equals")).size()>0){
			TSMapLH _a=(TSMapLH)query.get("equals");
			Set<String> o_set = _a.keySet();
			Iterator<String> key_it = o_set.iterator();
			while(key_it.hasNext()){
				String key=key_it.next();
				String val=_a.get(key).toString();
				where+=" \""+key+"\" = \""+val+"\"";
			}
		}

		//order string
		String order=query.get("sort").toString();

		ResultSet rs=this.query(query.get("find").toString(), from, where, order);
		ArrayList<String> cols=this.get_columns();
		try{
			while(rs.next()){
				for(int i=0;i<cols.size();i++){
					//if we don't look for anything, create a list, otherwise, only the columns of the searched row(s)
					if(where=="")
						ret.put(new ArrayList<String>(Arrays.asList(rs.getString("key"), cols.get(i))), rs.getString(cols.get(i)));
					else
						ret.put(new ArrayList<String>(Arrays.asList(cols.get(i))), rs.getString(cols.get(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<String> get_columns(){
		if(this.result_set!=null){
			try {
				ResultSetMetaData rsmd = this.result_set.getMetaData();
				int colC = rsmd.getColumnCount()+1;
				ArrayList<String> columns = new ArrayList<String>();
				for(int i=1;i<colC;i++)
					columns.add(rsmd.getColumnName(i));
				return columns;
			} catch (Exception e) {
				System.err.println("Could not extract ResultSet MetaData\n --> USER WARNING");
				e.printStackTrace();
				return null;
			}
		}
		System.err.println("Something wrong with result set" + "\n --> USER WARNING");
		return null;
	}


	public void clean() {
		try {
			if(this.statement!=null)
				this.statement.close();
			if(this.result_set!=null)
				this.result_set.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
