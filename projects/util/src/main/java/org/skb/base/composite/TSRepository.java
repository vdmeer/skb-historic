/* Copyright (c) 2011-2011 Sven van der Meer
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

package org.skb.util.composite;

import java.util.EnumSet;

import org.apache.log4j.Logger;

/**
 * Type repository maintaining string and enumerate literals for SKB types.
 *
 * The base interface for SKB types ({@link org.skb.util.composite.TSBaseAPI}) defines four methods for processing type information.
 * The first two ({@link org.skb.util.composite.TSBaseAPI#tsGetTypeEnum} and {@link org.skb.util.composite.TSBaseAPI#tsGetTypeString})
 * must return the type of a TSBase object as either enumerate or string. The other two methods
 * ({@link org.skb.util.composite.TSBaseAPI#tsGetTypeEnumSet} and {@link org.skb.util.composite.TSBaseAPI#tsGetTypeStringList})
 * must return all type information of a TSBase object as either a set of enumerates or a set of strings. This class maintains all enumerates and
 * all strings that for type information that the SKB supports, and provides some basic function to convert between them.
 * <br /><br /> 
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSRepository {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSRepository.class);

	/**
	 * String values identifying SKB types.
	 *
	 * @author     Sven van der Meer <sven@vandermeer.de>
	 * @version    v0.10 build 110128 (28-Jan-11) with Java 1.6
	 */
	public class TString{
		/** The SKB base type */
		public final static String TS_BASE						= "ts:base";

		/** The SKB for a TSAtomic */
		public final static String TS_ATOMIC					= "ts:atomic";

		/** The SKB for a TSComposite */
		public final static String TS_COMPOSITE					= "ts:composite";

		/** The generic SKB Default type */
		public final static String TS_DEFAULT					= "ts:default";

		/** The generic SKB NULL type */
		public final static String TS_NULL						= "ts:null";

		/** The generic SKB Warning type */
		public final static String TS_WARNING					= "ts:warning";

		/** The generic SKB Error type */
		public final static String TS_ERROR						= "ts:error";


		/** The SKB type for a (Java) Object */
		public final static String TS_ATOMIC_JAVA_OBJECT		= "ts:atomic:java:object";

		/** The SKB type for a (Java) String */
		public final static String TS_ATOMIC_JAVA_STRING		= "ts:atomic:java:string";

		/** The SKB type for a (Java) Long */
		public final static String TS_ATOMIC_JAVA_LONG			= "ts:atomic:java:long";

		/** The SKB type for a (Java) Short */
		public final static String TS_ATOMIC_JAVA_SHORT			= "ts:atomic:java:short";

		/** The SKB type for a (Java) Integer */
		public final static String TS_ATOMIC_JAVA_INTEGER		= "ts:atomic:java:integer";

		/** The SKB type for a (Java) Float */
		public final static String TS_ATOMIC_JAVA_FLOAT			= "ts:atomic:java:float";

		/** The SKB type for a (Java) Double */
		public final static String TS_ATOMIC_JAVA_DOUBLE		= "ts:atomic:java:double";

		/** The SKB type for a (Java) Byte */
		public final static String TS_ATOMIC_JAVA_BYTE			= "ts:atomic:java:byte";

		/** The SKB type for a (Java) Boolean */
		public final static String TS_ATOMIC_JAVA_BOOLEAN		= "ts:atomic:java:boolean";


		/** The SKB type for an ANTLR Token (org.antlr) */
		public final static String TS_ATOMIC_ANTLR_TOKEN		= "ts:atomic:antlr:token";

		/** The SKB type for a string template (org.stringtemplate) */
		public final static String TS_ATOMIC_STRINGTEMPLATE_ST	= "ts:atomic:stringtemplate:st";

		/** The SKB type for a string template group (org.stringtemplate) */
		public final static String TS_ATOMIC_STRINGTEMPLATE_STG	= "ts:atomic:stringtemplate:stg";

		/** The SKB type for a string template group manager (SKB.Util) */
		public final static String TS_ATOMIC_STGROUPMANAGER		= "ts:atomic:stgroupmanager";


		/** The SKB type for a Portable Data Object (SKB.Util) */
		public final static String TS_ATOMIC_DB_PDO				= "ts:atomic:db:pdo";


		/** The SKB type for a Portable Data Object (SKB.Util) */
		public final static String TS_ATOMIC_SCOPE				= "ts:atomic:scope";


		/** The SKB type for the Tribe Language Parser */
		public final static String TS_TRIBE_LP					= "ts:atomic:tribe:lp";

		/** The SKB type for the COLA PROTO Parser */
		public final static String TS_TRIBE_LP_COLA_PROTO		= "ts:atomic:tribe:lp:cola:proto";

		/** The SKB type for the POLA PROTO Parser */
		public final static String TS_TRIBE_LP_POLA_PROTO		= "ts:atomic:tribe:lp:pola:proto";

		/** The SKB type for the GLUE PROTO Parser */
		public final static String TS_TRIBE_LP_GLUE_PROTO		= "ts:atomic:tribe:lp:glue:proto";

		/** The SKB type for the DAL Parser */
		public final static String TS_TRIBE_LP_DAL				= "ts:atomic:tribe:lp:dal";


		/** The SKB Report Manager */
		public final static String TS_ATOMIC_REPORTMANAGER		= "ts:atomic:reportmanager";


		/** The SKB Internationalisation Manager */
		public final static String TS_ATOMIC_I18NMANAGER		= "ts:atomic:i18nmanager";


		/** The SKB KB Data Manager */
		public final static String TS_ATOMIC_KB_DATAMANAGER		= "ts:atomic:kb:datamanager";


		/** SKB Type for an Array List (java.utils.list<java.lang.String>) */
		public final static String TS_ATOMIC_ARRAYLIST_STRING	= "ts:atomic:util:arraylist_string";

		/** SKB Type for an Array List (java.utils.list<TSAtomic>) */
		public final static String TS_ATOMIC_ARRAYLIST_ATOMIC	= "ts:atomic:util:arraylist_atomic";


		/** SKB Type for a Table (using TSTableRow) */
		public final static String TS_COMPOSITE_TABLE			= "ts:composite:util:table";

		/** SKB Type for a Table Row (used in TSTable) */
		public final static String TS_COMPOSITE_TABLEROW		= "ts:composite:util:tablerow";

		/** SKB Type for a Map, used to identify the Map interface */
		public final static String TS_COMPOSITE_TREE			= "ts:composite:util:tree";

		/** SKB Type for a Linked Hash Map (java.util.LinkedHashMap<String, TSBase> */
		public final static String TS_COMPOSITE_TREE_LH			= "ts:composite:util:tree:lh";

		/** SKB Type for an Array List (java.utils.list<TSBase>) */
		public final static String TS_COMPOSITE_ARRAYLIST		= "ts:composite:util:arraylist";

		/** SKB Type for a map of rules, as used in SKB.Tribe */
		public final static String TS_COMPOSITE_LANG_RULEMAP	= "ts:composite:util:lang_rulemap";

		/** SKB Type for a Property Map, which provides different value types and initialisations */
		public final static String TS_COMPOSITE_PROPERTY_MAP	= "ts:composite:util:property_map";


		/** The SKB Lang AtomList */
		public final static String TS_COMPOSITE_LANG_ATOMLIST	= "ts:composite:lang:atomlist";


		/** The SKB unknown type */
		public final static String TS_UNKNOWN					= "ts:unknown";
	}


	/**
	 * Enumerates for SKB types.
	 *
	 * @author     Sven van der Meer <sven@vandermeer.de>
	 * @version    v0.10 build 110128 (28-Jan-11) with Java 1.6
	 */
	public enum TEnum{
		/** The SKB base type */
		TS_BASE							(TSRepository.TString.TS_BASE),

		/** The SKB for a TSAtomic */
		TS_ATOMIC						(TSRepository.TString.TS_ATOMIC),

		/** The SKB for a TSComposite */
		TS_COMPOSITE					(TSRepository.TString.TS_COMPOSITE),

		/** The generic SKB Default type */
		TS_DEFAULT						(TSRepository.TString.TS_DEFAULT),

		/** The generic SKB NULL type */
		TS_NULL							(TSRepository.TString.TS_NULL),

		/** The generic SKB Warning type */
		TS_WARNING						(TSRepository.TString.TS_WARNING),

		/** The generic SKB Error type */
		TS_ERROR						(TSRepository.TString.TS_ERROR),


		/** The SKB type for a (Java) Object */
		TS_ATOMIC_JAVA_OBJECT			(TSRepository.TString.TS_ATOMIC_JAVA_OBJECT),

		/** The SKB type for a (Java) String */
		TS_ATOMIC_JAVA_STRING			(TSRepository.TString.TS_ATOMIC_JAVA_STRING),

		/** The SKB type for a (Java) Long */
		TS_ATOMIC_JAVA_LONG				(TSRepository.TString.TS_ATOMIC_JAVA_LONG),

		/** The SKB type for a (Java) Short */
		TS_ATOMIC_JAVA_SHORT			(TSRepository.TString.TS_ATOMIC_JAVA_SHORT),

		/** The SKB type for a (Java) Integer */
		TS_ATOMIC_JAVA_INTEGER			(TSRepository.TString.TS_ATOMIC_JAVA_INTEGER),

		/** The SKB type for a (Java) Float */
		TS_ATOMIC_JAVA_FLOAT			(TSRepository.TString.TS_ATOMIC_JAVA_FLOAT),

		/** The SKB type for a (Java) Double */
		TS_ATOMIC_JAVA_DOUBLE			(TSRepository.TString.TS_ATOMIC_JAVA_DOUBLE),

		/** The SKB type for a (Java) Byte */
		TS_ATOMIC_JAVA_BYTE				(TSRepository.TString.TS_ATOMIC_JAVA_BYTE),

		/** The SKB type for a (Java) Boolean */
		TS_ATOMIC_JAVA_BOOLEAN			(TSRepository.TString.TS_ATOMIC_JAVA_BOOLEAN),


		/** The SKB type for an ANTLR Token (org.antlr) */
		TS_ATOMIC_ANTLR_TOKEN			(TSRepository.TString.TS_ATOMIC_ANTLR_TOKEN),

		/** The SKB type for a string template (org.stringtemplate) */
		TS_ATOMIC_STRINGTEMPLATE_ST		(TSRepository.TString.TS_ATOMIC_STRINGTEMPLATE_ST),

		/** The SKB type for a string template group (org.stringtemplate) */
		TS_ATOMIC_STRINGTEMPLATE_STG	(TSRepository.TString.TS_ATOMIC_STRINGTEMPLATE_STG),

		/** The SKB type for a string template group manager (SKB.Util) */
		TS_ATOMIC_STGROUPMANAGER		(TSRepository.TString.TS_ATOMIC_STGROUPMANAGER),


		/** The SKB type for a Portable Data Object (SKB.Util) */
		TS_ATOMIC_DB_PDO				(TSRepository.TString.TS_ATOMIC_DB_PDO),


		/** The SKB type for a Portable Data Object (SKB.Util) */
		TS_ATOMIC_SCOPE					(TSRepository.TString.TS_ATOMIC_SCOPE),


		/** The SKB type for the Tribe Language Parser */
		TS_TRIBE_LP						(TSRepository.TString.TS_TRIBE_LP),

		/** The SKB type for the COLA PROTO Parser */
		TS_TRIBE_LP_COLA_PROTO			(TSRepository.TString.TS_TRIBE_LP_COLA_PROTO),

		/** The SKB type for the POLA PROTO Parser */
		TS_TRIBE_LP_POLA_PROTO			(TSRepository.TString.TS_TRIBE_LP_POLA_PROTO),

		/** The SKB type for the GLUE PROTO Parser */
		TS_TRIBE_LP_GLUE_PROTO			(TSRepository.TString.TS_TRIBE_LP_GLUE_PROTO),

		/** The SKB type for the DAL Parser */
		TS_TRIBE_LP_DAL					(TSRepository.TString.TS_TRIBE_LP_DAL),


		/** The SKB Report Manager */
		TS_ATOMIC_REPORTMANAGER			(TSRepository.TString.TS_ATOMIC_REPORTMANAGER),


		/** The SKB Internationalisation Manager */
		TS_ATOMIC_I18NMANAGER			(TSRepository.TString.TS_ATOMIC_I18NMANAGER),


		/** The SKB KB Data Manager */
		TS_ATOMIC_KB_DATAMANAGER			(TSRepository.TString.TS_ATOMIC_KB_DATAMANAGER),


		/** SKB Type for an Array List (java.utils.list<java.lang.String>) */
		TS_ATOMIC_ARRAYLIST_STRING		(TSRepository.TString.TS_ATOMIC_ARRAYLIST_STRING),

		/** SKB Type for an Array List (java.utils.list<TSAtomic>) */
		TS_ATOMIC_ARRAYLIST_ATOMIC		(TSRepository.TString.TS_ATOMIC_ARRAYLIST_ATOMIC),


		/** SKB Type for a Table (using TSTableRow) */
		TS_COMPOSITE_TABLE				(TSRepository.TString.TS_COMPOSITE_TABLE),

		/** SKB Type for a Table Row (used in TSTable) */
		TS_COMPOSITE_TABLEROW			(TSRepository.TString.TS_COMPOSITE_TABLEROW),

		/** SKB Type for a Map, used to identify the Map interface */
		TS_COMPOSITE_TREE				(TSRepository.TString.TS_COMPOSITE_TREE),

		/** SKB Type for a Linked Hash Map (java.util.LinkedHashMap<String, TSBase> */
		TS_COMPOSITE_TREE_LH			(TSRepository.TString.TS_COMPOSITE_TREE_LH),

		/** SKB Type for an Array List (java.utils.list<TSBase>) */
		TS_COMPOSITE_ARRAYLIST			(TSRepository.TString.TS_COMPOSITE_ARRAYLIST),

		/** SKB Type for a map of rules, as used in SKB.Tribe */
		TS_COMPOSITE_LANG_RULEMAP		(TSRepository.TString.TS_COMPOSITE_LANG_RULEMAP),

		/** SKB Type for a Property Map, which provides different value types and initialisations */
		TS_COMPOSITE_PROPERTY_MAP		(TSRepository.TString.TS_COMPOSITE_PROPERTY_MAP),


		/** The SKB Lang AtomList */
		TS_COMPOSITE_LANG_ATOMLIST		(TSRepository.TString.TS_COMPOSITE_LANG_ATOMLIST),


		/** The SKB unknown type */
		TS_UNKNOWN						(TSRepository.TString.TS_UNKNOWN);


		/** local type */
		private final String type;

		TEnum(String type){
	        this.type=type;
	    }

		/**
		 * Returns the current set type.
		 * @return the current set type
		 */
		public String type(){
	    	return this.type;
	    }
	}


	/**
	 * Returns the stringified version of the enumerate type given.
	 * @param e enumerate type
	 * @return stringified version of the enumerate type
	 */
	public final static String type(TEnum e){
		return e.type();
	}


	/**
	 * Returns the enumerate version of a type given as string or TS_UNKNOWN. 
	 * @param s the string version of the type
	 * @return the enumerate version of the type or TS_UNKNOWN
	 */
	public final static TEnum type(String s){
	    for (TEnum t : EnumSet.range(TEnum.TS_BASE, TEnum.TS_UNKNOWN))
	    	if(t.type().equals(s))
	        	return t;
		return TEnum.TS_UNKNOWN;
	}


	/**
	 * Returns the string version of a type given as TSBase or TS_UNKNOWN. 
	 * @param b the TSBase version of the type
	 * @return the string version of the type or TS_UNKNOWN
	 */
	public final static String type(TSBaseAPI b){
		String s=b.toString();
	    for (TEnum t : EnumSet.range(TEnum.TS_BASE, TEnum.TS_UNKNOWN))
	    	if(t.type().equals(s))
	        	return t.type;
		return TSRepository.TString.TS_UNKNOWN;
	}
}