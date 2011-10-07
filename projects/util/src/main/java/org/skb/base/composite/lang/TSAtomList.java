/* Copyright (c) 2000-2011 Sven van der Meer
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

package org.skb.util.composite.lang;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.util.classic.lang.NameScope;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.TSTableRowAPI;
import org.skb.util.composite.antlr.TSStringTemplate;
import org.skb.util.composite.antlr.TSToken;
import org.skb.util.composite.misc.TSReportManager;
import org.skb.util.composite.util.TSTable;
import org.skb.util.composite.util.TSTableRow;

/**
 * AtomList for language parsers (symbol table)
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSAtomList extends TSTable {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSAtomList.class);

	/** The local list of atoms as a TreeMap (because insertion sequence determines atom positions) */
	protected TreeMap<String, TSTableRow> oatValue=null;

	/** Column identifier for the category */
	public final static String alValCategory	= "category";

	/** Column identifier for the type */
	public final static String alValType		= "type";

	/** Column identifier for the array */
	public final static String alValTypeArray	= "array";

	/** Column identifier for the file */
	public final static String alValFile 		= "file";

	/** Column identifier for the line */
	public final static String alValLine		= "line";

	/** Column identifier for the column */
	public final static String alValColumn		= "column";

	/** Column identifier for the string template */
	public final static String alValST 		   	= "st";

	/** Column identifier for the scoped identifier */
	public final static String alValScopedID	= "id:scoped";

	/** Specification name */
	private String specificationName;

	/** Current scope */
	public NameScope scope;

	/** List of imports */
	private TreeMap<String, LinkedHashMap<String, String>> imports;

	/** Report Manager instance, used to set file name for atoms */
	private TSReportManager reportMgr=null;

	/**
	 * Class constructor
	 */
	public TSAtomList(){
		super();
		this._initAL();
	}

//	public AtomList(HashSet<String>rows){
//		super();
//		this._init();
//		this.addRows(rows);
//	}
//
//	public AtomList(String ref_class, String rowPrefix){
//		super();
//		this._init();
//		this.addRows(ref_class, rowPrefix);
//	}

	/**
	 * Initialises the atom list, create the table and set default values.
	 */
	protected void _initAL(){
		//super._init();

		this.typeString.add(TSRepository.TString.TS_COMPOSITE_LANG_ATOMLIST);
		this.typeEnum.add(TEnum.TS_COMPOSITE_LANG_ATOMLIST);

		this.oatValue=new TreeMap <String, TSTableRow>();
		this.setColumns(TSAtomList.class.getName(), "alVal");
		this.addRows(TSAtomList.class.getName(), "alKey");

		this.specificationName="default";

		this.scope=new NameScope();
		this.imports=new TreeMap<String, LinkedHashMap<String, String>>();
	}

	/**
	 * Set the report manager
	 * @param rm Report Manager instance
	 */
	public void setReportMgr(TSReportManager rm){
		this.reportMgr=rm;
	}

	/**
	 * Sets the specification name, which is the root of an atom list hierarchy
	 * @param s the new specification name as string
	 */
	public void specificationName(String s){
		this.specificationName=s;
	}

	/**
	 * Sets the specification name, which is the root of an atom list hierarchy
	 * @param tk the new specification name as ANTLR token, getText is used to get the string
	 */
	public void specificationName(Token tk){
		this.specificationName=tk.getText();
	}

	/**
	 * Returns the specification name, which is the root of an atom list hierarchy
	 * @return the specification name, default is "default"
	 */
	public String specificationName(){
		return this.specificationName;
	}

	/**
	 * Sets the scope separator.
	 * @param s the new scope separator
	 */
	public void setScopeSeparator(String s){
		this.scope.setSeparator(s);
	}

	/**
	 * Gets the scope separator.
	 * return the current scope separator
	 */
	public String getScopeSeparator(){
		return this.scope.getSeparator();
	}

	/**
	 * Adds a new atom to the list.
	 * @param tk the ANTLR token of the atom 
	 * @param category the category the atom should be filed at
	 * @return null if successful, row containing existing atom otherwise
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public TSTableRowAPI putAtom(Token tk, String category){
		return this.putAtom(tk, category, null);
	}

	/**
	 * Adds a new atom to the list.
	 * @param tk the ANTLR token of the atom
	 * @param category category the category the atom should be filed at
	 * @param type the type of the atom
	 * @return null if successful, row containing existing atom otherwise
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public TSTableRowAPI putAtom(Token tk, String category, Token type){
		return this.putAtom(tk, category, type, false);
	}

	/**
	 * Adds a new atom to the list.
	 * @param tk the ANTLR token of the atom
	 * @param category category the category the atom should be filed at
	 * @param type the type of the atom
	 * @param array true if atom is an array, false otherwise
	 * @return null if successful, row containing existing atom otherwise
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public TSTableRowAPI putAtom(Token tk, String category, Token type, Boolean array){
		this.scope.push(tk);
		String id=this.scope.toString();
		if(this.containsKey(id)==false){
			this.addRow(id);
			this.put(id, TSAtomList.alValCategory, category);
			if(type!=null)
				this.put(id, TSAtomList.alValType, new TSToken(type));
			else
				this.put(id, TSAtomList.alValType, new TSToken());
			if(array==false)
				this.put(id, TSAtomList.alValTypeArray, false);
			else
				this.put(id, TSAtomList.alValTypeArray, true);
			if(this.reportMgr!=null)
				this.put(id, TSAtomList.alValFile, this.reportMgr.getFileName());
			this.put(id, TSAtomList.alValLine, tk.getLine());
			this.put(id, TSAtomList.alValColumn, tk.getCharPositionInLine());
			this.put(id, TSAtomList.alValScopedID, id);

			this.imports.put(id, new LinkedHashMap<String, String>());
			return null;
		}
		return this.get(id);
	}

	/**
	 * Adds an import to the list of imports.
	 * @param sn the import as scoped name
	 */
	public void addImport(String sn){
		this.imports.get(this.scope.toString()).put(sn,this.get(sn,TSAtomList.alValCategory).toString());
	}

	/**
	 * Adds a list of imports to the list of imports
	 * @param row
	 * @param m
	 */
	public void addImportsAll(String row, Map <String, String> m){
		this.imports.get(row).putAll(m);
	}

	/**
	 * Adds a string template to a language atom
	 * @param row
	 * @param st
	 */
	public void addST(String row, StringTemplate st){
		if(st!=null)
			this.put(row, TSAtomList.alValST, new TSStringTemplate(st));
	}

	/**
	 * Adds a string template to a language atom
	 * @param st
	 */
	public void addST(StringTemplate st){
		this.addST(this.scope.toString(),st);
	}

	/**
	 * Returns import list 
	 * @param row name of an atom to look for
	 * @return the list of recorded imports for this atom
	 */
	public LinkedHashMap<String, String> getImports(String row){
		return this.imports.get(row);
	}

	/**
	 * Returns the string template of a language atom
	 * @param row atom the read the template for
	 * @return the current set string template
	 */
	public StringTemplate getST(String row){
		TSBaseAPI st=this.get(row, TSAtomList.alValST);
		StringTemplate ret=new StringTemplate("");
		if(st!=null&&st.tsIsType(TSRepository.TEnum.TS_ATOMIC_STRINGTEMPLATE_ST))
			ret=((TSStringTemplate)st);
		return ret;
	}

	/**
	 * Returns the ANTLR runtime token for the given atom (row) and column
	 * @param row name of the atom
	 * @param column column to read the token from
	 * @return an ANTLR runtime token
	 */
	public Token getToken(String row, String column){
		TSToken ret=null;
		TSBaseAPI ata=this.get(row, column);
		if(ata!=null&&ata.tsIsType(TSRepository.TEnum.TS_ATOMIC_ANTLR_TOKEN))
			ret=((TSToken)ata);
		return (Token)ret;
	}
}