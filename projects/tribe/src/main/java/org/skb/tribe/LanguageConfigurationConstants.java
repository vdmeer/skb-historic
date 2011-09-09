/* Copyright (c) 2005-2011 Sven van der Meer
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

package org.skb.tribe;

/**
 * Constants for reading a JSON configuration file of a parser.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */

public final class LanguageConfigurationConstants {
	/**
	 * Constants to access fields in JSON configuration files.
	 * @author     Sven van der Meer
 	 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
	 */
	public static final class Fields {
		/** Key to command line fields */
		public final static String SKBLangTargetConfigurationCli		= "skb:lang:target:config:cli";
		//public final static String SKBLangTargetConfigurationTribe="skb:lang:target:config:tribe";

		/** Identifier of a constant, used as main key in a map */
		public final static String SKBLangTargetConfigurationConstID	= "skb:lang:target:config:constid";
		/** Key that provides access to information for JavaDoc */
		public final static String SKBLangTargetConfigurationJavaDoc	= "skb:lang:target:config:javadoc";

		/** Key to access mandatory chunks (for testing StringTemplates )*/
		public final static String SKBTribeStgChunkMandatory			= "skb:tribe:stgchunk:mandatory";
		/** Key to access optional chunks (for testing StringTemplates )*/
		public final static String SKBTribeStgChunkOptional				= "skb:tribe:stgchunk:optional";

		/** Identifier of a token (ANTLR token) */
		public final static String SKBLangTokensConstID					= "skb:lang:target:tokens:cid";
		/** Value for a constant identifier*/
		public final static String SKBLangTokensConstVal				= "skb:lang:target:tokens:cval";
		/** Identifier of a constant for a token, used as main key in a map */
		public final static String SKBLangTokensConstJavaDoc			= "skb:lang:target:tokens:cjavadoc";

		/** Token ID, used to map ANTLR grammar IDs to translations for error messages */
		public final static String SKBLangTokensTokenID					= "skb:lang:target:tokens:tid";
		/** Error/warning message for the TID */
		public final static String SKBLangTokensTokenVal				= "skb:lang:target:tokens:tval";

		/** Name of a target language, used to access configuration information for that target */
    	public final static String SKBLangTargetName					= "skb:lang:target:name";

		/** Message of a language parser rule*/
    	public final static String SKBLangRulesMessage					= "skb:lang:parser:rules:message";
    	/** Additional information for a message of a language parser rule*/
    	public final static String SKBLangRulesMessageAdd				= "skb:lang:parser:rules:message:add";
		/** Identifier to class that is used to substitute "####" in the message */
    	public final static String SKBLangRulesMessageInsertPath		= "skb:lang:parser:rules:message:insert:path";
    	/** Identifier to class that is used to substitute "####" in the additional information for the message */
    	public final static String SKBLangRulesMessageAddInsertPath		= "skb:lang:parser:rules:message:add:insert:path";
    }


	/**
	 * Constants defining paths used later to access fields in JSON configuration files. 
	 * @author     Sven van der Meer
 	 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
	 */

	public static final class Paths {
		/** Path in a TSMap to configuration information for the Tribe library*/
    	public final static String SKBTribeConfiguration	= "skb/tribe/configuration";

    	/** Path in a TSMap to configuration information for an SKB language parser/compiler*/
    	public final static String SKBLangConfiguration		= "skb/lang/configuration";
		/** Path to ANTLR tokens */
    	public final static String SKBLangTokens			= "skb/lang/tokens";
		/** Path to target language specifications */
    	public final static String SKBLangTargets			= "skb/lang/targets";

		/** Path to STG chunk information */
    	public final static String SKBLangStgChunks			= "skb/lang/stgchunks";
		/** Path to language rule information */
    	public final static String SKBLangRules				= "skb/lang/rules";
    }
}
