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

package org.skb.types;

import java.util.EnumSet;

import org.skb.types.base.OatBase;

/**
 * Type repository maintaining string and enumerate literals for SKB types.
 *
 * The base class for SKB types ({@link org.skb.types.base.OatBase}) uses two protected
 * fields to maintain type information. The first field is a string vector for the stringified 
 * version of the type (string literals in this class). The second field is an enumerate set for the
 * enumerate version of the type. Each class inheriting from {@link org.skb.types.base.OatBase} can
 * add their specific type information, which can then be used at runtime to determine the A4DS type of 
 * an object.
 * <br /><br />
 * The starting point for all types is OAT_BASE, which is automatically
 * set by the base class {@link org.skb.types.base.OatBase}. The next two categories determine whether the type
 * is atomic (OAT_BASE_ATOMIC) or a composite type
 * OAT_BASE_COMPOSITE. Atomic here means that the type only holds atomic fields
 * (i.e. a string array, or a structure of different atomic types but no composite filed). Composite here means that
 * the type maintains atomic and composite fields. 
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class TypeRepository {
	/**
	 * The SKB base type.
	 * 
	 * This is the starting point for all SKB type definitions used by the base class {@link org.skb.types.base.OatBase}.
	 */
	public final static String OAT_BASE							= "oat:base"; 
	/**
	 * The SKB base atomic type.
	 * 
	 * This is the base type for all atomic type definitions.
	 */
	public final static String OAT_BASE_ATOMIC					= "oat:base:atomic";


	/**
	 * The SKB base composite type.
	 * 
	 * This is the base type for all composite type definitions.
	 */
	public final static String OAT_BASE_COMPOSITE				= "oat:base:composite";
	/**
	 * The SKB type for composites that represent tables.
	 * 
	 * A table should consist of named columns and zero or more rows with data.
	 */
	public final static String OAT_BASE_COMPOSITE_TABLE			= "oat:base:composite:table";
	/**
	 * The SKB type for composites that represent maps similar to java.utils.
	 */
	public final static String OAT_BASE_COMPOSITE_MAP			= "oat:base:composite:map";

	/**
	 * The SKB type for an array list of SKB base types.
	 */
	public final static String OAT_ARRAYLIST					= "oat:arraylist";
	/**
	 * The SKB type for an array list of SKB atomic types.
	 */
	public final static String OAT_ARRAYLIST_ATOMIC				= "oat:arraylist:atomic";
	/**
	 * The SKB type for an array list of strings.
	 */
	public final static String OAT_ARRAYLIST_STRING				= "oat:arraylist:string";


	/**
	 * The SKB type for a tree list of SKB atomic types.
	 */
//	public final static String OAT_TREESET_ATOMIC				= "oat:treeset:atomic";
	/**
	 * The SKB type for a tree list of strings.
	 */
//	public final static String OAT_TREESET_STRING				= "oat:treeset:string";


	/**
	 * The SKB type for a (Java) string.
	 */
	public final static String OAT_ATOMIC_STRING				= "oat:atomic:java:string";
	/**
	 * The SKB type for a (Java) boolean.
	 */
	public final static String OAT_ATOMIC_BOOLEAN				= "oat:atomic:java:boolean";
	/**
	 * The SKB type for a (Java) integer.
	 */
	public final static String OAT_ATOMIC_INTEGER				= "oat:atomic:java:integer";
	/**
	 * The SKB type for a (Java) double.
	 */
	public final static String OAT_ATOMIC_DOUBLE				= "oat:atomic:java:double";
	/**
	 * The SKB type for a (Java) float.
	 */
	public final static String OAT_ATOMIC_FLOAT					= "oat:atomic:java:float";
	/**
	 * The SKB type for a (Java) long.
	 */
	public final static String OAT_ATOMIC_LONG					= "oat:atomic:java:long";
	/**
	 * The SKB type for a (Java) short.
	 */
	public final static String OAT_ATOMIC_SHORT					= "oat:atomic:java:short";
	/**
	 * The SKB type for a (Java) byte.
	 */
	public final static String OAT_ATOMIC_BYTE					= "oat:atomic:java:byte";
	/**
	 * The SKB type for a (Java) object.
	 */
	public final static String OAT_ATOMIC_OBJECT				= "oat:atomic:java:object";


	/**
	 * The SKB type for an ANTLR token.
	 */
	public final static String OAT_ATOMIC_ANTLR_TOKEN			= "oat:atomic:antlr:token";
	/**
	 * The SKB type for an ANTLR string template group.
	 */
	public final static String OAT_ATOMIC_ANTLR_STGROUP			= "oat:atomic:antlr:stg";
	/**
	 * The SKB type for an ANTLR string template.
	 */
	public final static String OAT_ATOMIC_ANTLR_ST				= "oat:atomic:antlr:st";
	/**
	 * The SKB type for a string template group manager.
	 */
	public final static String OAT_ATOMIC_STG_MANAGER			= "oat:atomic:stg-manager";


	/**
	 * The SKB type for a composite table.
	 */
	public final static String OAT_COMPOSITE_TABLE				= "oat:composite:table";
	/**
	 * The SKB type for a composite table row.
	 */
	public final static String OAT_COMPOSITE_TABLE_ROW			= "oat:composite:table:row";
	/**
	 * The SKB type for a composite property map.
	 */
	public final static String OAT_COMPOSITE_PROPERTY_MAP		= "oat:composite:property:map";
	/**
	 * The SKB type for a composite language rule map.
	 */
	public final static String OAT_COMPOSITE_LANGUAGE_RULE_MAP	= "oat:composite:rule:map";
	/**
	 * The SKB type for a composite linked hash map.
	 */
	public final static String OAT_COMPOSITE_MAP_LH				= "oat:composite:map:lh";


	/**
	 * The SKB type for a PDO (portable database object).
	 */
	public final static String OAT_PDO							= "oat:pdo";


	/**
	 * The SKB type for a Scope object.
	 */
	public final static String OAT_SCOPE						= "oat:scope";


	/**
	 * The SKB unknown type.
	 */
	public final static String OAT_UNKNOWN						= "oat_unknown";

	/**
	 * Enumerates for SKB types.
	 *
	 * @author     Sven van der Meer <sven@vandermeer.de>
	 * @version    v0.10 build 110128 (28-Jan-11) with Java 1.6
	 */
	public enum ATType{
		/**
		 * The SKB base type.
		 * 
		 * This is the starting point for all SKB type definitions used by the base class {@link org.skb.types.base.OatBase}.
		 */
		OAT_BASE						(TypeRepository.OAT_BASE),
		/**
		 * The SKB base atomic type.
		 * 
		 * This is the base type for all atomic type definitions.
		 */
		OAT_BASE_ATOMIC					(TypeRepository.OAT_BASE_ATOMIC),


		/**
		 * The SKB base composite type.
		 * 
		 * This is the base type for all composite type definitions.
		 */
		OAT_BASE_COMPOSITE				(TypeRepository.OAT_BASE_COMPOSITE),
		/**
		 * The SKB type for composites that represent tables.
		 * 
		 * A table should consist of named columns and zero or more rows with data.
		 */
		OAT_BASE_COMPOSITE_TABLE		(TypeRepository.OAT_BASE_COMPOSITE_TABLE),
		/**
		 * The SKB type for composites that represent maps similar to java.utils.
		 */
		OAT_BASE_COMPOSITE_MAP			(TypeRepository.OAT_BASE_COMPOSITE_MAP),


		/**
		 * The SKB type for an array list of SKB atomic types.
		 */
		OAT_ARRAYLIST					(TypeRepository.OAT_ARRAYLIST),
		/**
		 * The SKB type for an array list of SKB atomic types.
		 */
		OAT_ARRAYLIST_ATOMIC			(TypeRepository.OAT_ARRAYLIST_ATOMIC),
		/**
		 * The SKB type for an array list of strings.
		 */
		OAT_ARRAYLIST_STRING			(TypeRepository.OAT_ARRAYLIST_STRING),

		
		/**
		 * The SKB type for a tree list of SKB atomic types.
		 */
//		OAT_TREESET_ATOMIC				(TypeRepository.OAT_TREESET_ATOMIC),
		/**
		 * The SKB type for a tree list of strings.
		 */
//		OAT_TREESET_STRING				(TypeRepository.OAT_TREESET_STRING),


		/**
		 * The SKB type for a (Java) string.
		 */
		OAT_ATOMIC_STRING				(TypeRepository.OAT_ATOMIC_STRING),
		/**
		 * The SKB type for a (Java) boolean.
		 */
		OAT_ATOMIC_BOOLEAN				(TypeRepository.OAT_ATOMIC_BOOLEAN),
		/**
		 * The SKB type for a (Java) integer.
		 */
		OAT_ATOMIC_INTEGER				(TypeRepository.OAT_ATOMIC_INTEGER),
		/**
		 * The SKB type for a (Java) double.
		 */
		OAT_ATOMIC_DOUBLE				(TypeRepository.OAT_ATOMIC_DOUBLE),
		/**
		 * The SKB type for a (Java) float.
		 */
		OAT_ATOMIC_FLOAT				(TypeRepository.OAT_ATOMIC_FLOAT),
		/**
		 * The SKB type for a (Java) long.
		 */
		OAT_ATOMIC_LONG					(TypeRepository.OAT_ATOMIC_LONG),
		/**
		 * The SKB type for a (Java) short.
		 */
		OAT_ATOMIC_SHORT				(TypeRepository.OAT_ATOMIC_SHORT),
		/**
		 * The SKB type for a (Java) byte.
		 */
		OAT_ATOMIC_BYTE					(TypeRepository.OAT_ATOMIC_BYTE),
		/**
		 * The SKB type for a (Java) object.
		 */
		OAT_ATOMIC_OBJECT				(TypeRepository.OAT_ATOMIC_OBJECT),


		/**
		 * The SKB type for an ANTLR token.
		 */
		OAT_ATOMIC_ANTLR_TOKEN			(TypeRepository.OAT_ATOMIC_ANTLR_TOKEN),
		/**
		 * The SKB type for an ANTLR string template group.
		 */
		OAT_ATOMIC_ANTLR_STGROUP		(TypeRepository.OAT_ATOMIC_ANTLR_STGROUP),
		/**
		 * The SKB type for an ANTLR string template.
		 */
		OAT_ATOMIC_ANTLR_ST				(TypeRepository.OAT_ATOMIC_ANTLR_ST),
		/**
		 * The SKB type for a string template group manager.
		 */
		OAT_ATOMIC_STG_MANAGER			(TypeRepository.OAT_ATOMIC_STG_MANAGER),


		/**
		 * The SKB type for a composite table.
		 */
		OAT_COMPOSITE_TABLE				(TypeRepository.OAT_COMPOSITE_TABLE),
		/**
		 * The SKB type for a composite table row.
		 */
		OAT_COMPOSITE_TABLE_ROW			(TypeRepository.OAT_COMPOSITE_TABLE_ROW),
		/**
		 * The SKB type for a composite property map.
		 */
		OAT_COMPOSITE_PROPERTY_MAP		(TypeRepository.OAT_COMPOSITE_PROPERTY_MAP),
		/**
		 * The SKB type for a composite language rule map.
		 */
		OAT_COMPOSITE_LANGUAGE_RULE_MAP	(TypeRepository.OAT_COMPOSITE_LANGUAGE_RULE_MAP),
		/**
		 * The SKB type for a composite linked hash map.
		 */
		OAT_COMPOSITE_MAP_LH			(TypeRepository.OAT_COMPOSITE_MAP_LH),


		/**
		 * The SKB type for a PDO (portable database object).
		 */
		OAT_PDO							(TypeRepository.OAT_PDO),

		/**
		 * The SKB type for a Scope object.
		 */
		OAT_SCOPE						(TypeRepository.OAT_SCOPE),


		//unknown type and end of list (used for EnumSet loops!)
		/**
		 * The SKB unknown type
		 */
		OAT_UNKNOWN						(TypeRepository.OAT_UNKNOWN);

		/** @ignore */
		private final String type;

		ATType(String type){
	        this.type=type;
	    }

		/**
		 * Returns the current set type.
		 * @return the curret set type
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
	public final static String type(ATType e){
		return e.type();
	}

	/**
	 * Returns the enumerate version of a type given as string or OAT_UNKNOWN. 
	 * @param s the string version of the type
	 * @return the enumerate version of the type or OAT_UNKNOWN
	 */
	public final static ATType type(String s){
	    for (ATType t : EnumSet.range(ATType.OAT_BASE, ATType.OAT_UNKNOWN))
	    	if(t.type().equals(s))
	        	return t;
		return ATType.OAT_UNKNOWN;
	}

	/**
	 * Returns the string version of a type given as string or OAT_UNKNOWN. 
	 * @param s the string version of the type
	 * @return the string version of the type or OAT_UNKNOWN
	 */
	public final static String type(OatBase b){
		String s=b.toString();
	    for (ATType t : EnumSet.range(ATType.OAT_BASE, ATType.OAT_UNKNOWN))
	    	if(t.type().equals(s))
	        	return t.type;
		return TypeRepository.OAT_UNKNOWN;
	}

}
