/* Copyright (c) 2000-2011 Sven van der Meer (sven@vandermeer.de)
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
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.lang.dal;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.antlr.runtime.Token;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.util.classic.config.Configuration;
import org.skb.util.composite.lang.TSAtomList;

/**
 * Pass 2 of the DAL parser, mostly looking into semantic analysis.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class DalPass2_Ast {
	/** Logger instance */
	static Logger logger = Logger.getLogger(DalPass2_Ast.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(DalParser.class);

	/** Atom List (Symbol Table) */
	public TSAtomList atoms;

	// temp Type and Value for testing
	private Token lastBaseType=null;
	private Token lastCommonValue=null;
	private Token lastCommonValueType=null;

	public DalPass2_Ast(){
		this.atoms=config.getAtomlist();
		this.atoms.scope.clear();
	}


	public void testAtom(Token tk){
		this.atoms.scope.push(tk);
		String atomScope=this.atoms.scope.toString();
		String scopeSep=this.atoms.scope.separator();
		LinkedHashMap<String,String> path=this.buildPathList(atomScope, scopeSep);
		ArrayList<String> keys=new ArrayList<String>(path.keySet());
		int pathSize=StringUtils.split(atomScope, scopeSep).length;

		if(path.size()==0){
			System.err.println("error: ID not known ["+tk.getText()+"]");
			return;
		}

		//first can be Repository or Package
		if(path.get(keys.get(0)).equals(DalConstants.Tokens.dalREPOSITORY)){
			//in Repository, we have only tables, in there lots of fields (nothing to test) and optionally a sequence
			if(path.get(keys.get(2)).equals(DalConstants.Tokens.dalSEQUENCE)){
				//in sequence we have many fields (level 4)
				if(path.get(keys.get(3)).equals(DalConstants.Tokens.dalFIELD)){
					//now remove "sequence@@" and test if Atom exists
					String t=atomScope.replace("sequence"+scopeSep, "");
					if(!this.atoms.containsKey(t))
						System.err.println("erorr in repository: field in sequence not defined for table");
				}
			}
		}
		else if(path.get(keys.get(0)).equals(DalConstants.Tokens.dalPACKAGE)){
			//first check for definitions for a repository table
			if(path.get(keys.get(1)).equals(DalConstants.Tokens.dalREPOSITORY)&&path.get(keys.get(2)).equals(DalConstants.Tokens.dalTABLE)){
				//remove the first path entry (current package) and test for the repository, print error only for the actual repo Atom
				if(pathSize==3&&!this.atoms.containsKey(keys.get(1).substring(keys.get(1).indexOf(scopeSep)+2))){
					System.err.println("unknown repository referenced in package");
				}
				//remove the first path entry (current package) and test for the repository table, print error only for the actual repo-table Atom
				if(pathSize==4&&!this.atoms.containsKey(keys.get(2).substring(keys.get(2).indexOf(scopeSep)+2))){
					System.err.println("unknown repository-table referenced in package");
				}
				//check for referenced field in table for repo, error if field is not defined in repo-table
				if(pathSize==5){
					String[] split=StringUtils.split(atomScope, scopeSep);
					String field=StringUtils.join(new String[]{split[1], split[2], split[4]},scopeSep);
					if(!this.atoms.containsKey(field))
						System.err.println("unknown field for repository-table referenced in package");
				}
			}
			//next check if we are defining a package table
			if(path.get(keys.get(1)).equals(DalConstants.Tokens.dalTABLE)){
				//in a table, we have lots of fields and optionally a sequence (s=3), but we can only check on the sequence at the end
				if(path.get(keys.get(2)).equals(DalConstants.Tokens.dalFIELD)){
					//System.err.println(pathSize+" = table field = "+atomScope);
				}
				if(path.get(keys.get(2)).equals(DalConstants.Tokens.dalSEQUENCE)){
					//in sequence we only care about size of 4
					if(pathSize==4){
						String t=atomScope.replace("sequence"+scopeSep, "");
						if(!this.atoms.containsKey(t))
							System.err.println("erorr in repository: field in sequence not defined for table");
					}
				}
			}
			//next check if we are adding actions to the package
			if(path.get(keys.get(1)).equals(DalConstants.Tokens.dalACTIONS)){
				//check for the referenced table, size=4
				if(pathSize==4){
					String[] split=StringUtils.split(atomScope, scopeSep);
					String field=StringUtils.join(new String[]{split[0], split[3]},scopeSep);
					if(!this.atoms.containsKey(field))
						System.err.println("unknown table referenced in action for package");
				}
				//check for the individual fields of the actions, if keys exist in the named table
				if(pathSize==5){
					String[] split=StringUtils.split(atomScope, scopeSep);
					String field=StringUtils.join(new String[]{split[0], split[3], split[4]},scopeSep);
					if(!this.atoms.containsKey(field))
						System.err.println("unknown key for table referenced in action for package");
				}
			}
			//last check if we are adding data to the package
			if(path.get(keys.get(1)).equals(DalConstants.Tokens.dalDATA)){
				//first check if referenced table exists in the package
				if(pathSize==4){
					String[] split=StringUtils.split(atomScope, scopeSep);
					String field=StringUtils.join(new String[]{split[0], split[3]},scopeSep);
					if(!this.atoms.containsKey(field))
						System.err.println("unknown table referenced in data for package");
				}
				if(pathSize==5){
					String[] split=StringUtils.split(atomScope, scopeSep);
					String field=StringUtils.join(new String[]{split[0], split[3], split[4]},scopeSep);
					if(!this.atoms.containsKey(field))
						System.err.println("unknown key for table referenced in data for package");
				}
			}
		}
	}

	/**
	 * Build all individual scopes from current scope, resulting in a list of paths that can be used to analyse the current atom
	 * 
	 * @param scope the scope of the Atom
	 * @param scopeSep the scope separator to be used
	 * @return an array list with the constructed paths
	 */
	private LinkedHashMap<String,String> buildPathList(String scope, String scopeSep){

		String[] path=StringUtils.split(scope, scopeSep);
		LinkedHashMap<String,String> ret=new LinkedHashMap<String,String>();
		if(path.length!=0){
			int i=-1;
			while(++i<path.length){
				String p=new String();
				for(int k=0;k<=i;k++){
					p+=path[k];
					if(k<i)
						p+=scopeSep;
				}
				try{
					ret.put(p,this.atoms.get(p).get(TSAtomList.alValCategory).toString());
				}
				catch(Exception e){
					ret.put(p,new String());
				}
			}
			//fill with empty strings, using 10 as the maximum possible length of the path
			for(int k=i;k<10;k++){
				ret.put(Integer.toString(k), new String());
			}
		}
		return ret;
	}

	// temp Type and Value for testing
	public void setLastBaseType(Token tk){
		this.lastBaseType=tk;
	}
	public void setLastCommonValue(Token tk){
		this.lastCommonValue=tk;
	}
	public void setLastCommonValueType(Token tk){
		this.lastCommonValueType=tk;
	}
	public void setLastCommonValuePlusType(Token value, Token type){
		this.setLastCommonValueType(type);
		this.setLastCommonValue(value);
	}
}
