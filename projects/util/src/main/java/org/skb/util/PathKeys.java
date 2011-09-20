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

package org.skb.util;

/**
 * Constants for field keys for skb.util
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PathKeys {
	/*
	 * Field keys paths to instances (i.e. TS* objects)
	 */
	/** Key for a path to property information (TSPropertyMap) in a configuration */
	public final static String pathInstancesProperties					= "skb/instances/properties";

	/** Key for a path to the report manager (TSReportMgt) in a configuration */
	public final static String pathInstancesReportmanager				= "skb/instances/reportmanager";

	/** Key for a path to the atom list (TSATomList) in a configuration */
	public final static String pathInstancesAtomlist					= "skb/instances/atomlist";

	/** Key for a path to the language rule map (TSLangRuleMap) in a configuration */
	public final static String pathInstancesLangrulemap					= "skb/instances/langrulemap";

	/** Key for a path to the internationalisation manager (TSI18NManager) in a configuration */
	public final static String pathInstancesI18nmanager					= "skb/instances/i18nmanager";

	/** Key for a path to the KB data manager (SKBDataManager) in a configuration */
	public final static String pathInstancesKbDatamanager				= "skb/instances/kb/datamanager";


	/*
	 * Field keys paths to information, i.e. any TSAtomic or (usually) TSComposite types
	 */
	/** Key for a path that holds configuration information for the Tribe library */
	public final static String pathConfigurationParserTribe				= "skb/tribe/configuration";

	/** Key for a path that holds information on StringTemplate chunks */
	public final static String pathConfigurationParserTribeStgChunks	= "skb/tribe/stgchunks";

	/** Key for a path that holds configuration information for a parser/compiler */
	public final static String patConfigurationParserLang				= "skb/lang";

	/** Key for a path that holds configuration information for a parser/compiler */
	public final static String patConfigurationParserLangConfiguration	= "skb/lang/configuration";

	/** Key for a path that holds information on ANTLR token */
	public final static String pathConfigurationParserLangTokens		= "skb/lang/tokens";

	/** Key for a path that holds information about target languages */
	public final static String pathConfigurationParserLangTargets		= "skb/lang/targets";

	/** Key for a path that holds information on StringTemplate chunks */
	public final static String pathConfigurationParserLangStgChunks		= "skb/lang/stgchunks";

	/** Key for a path that holds information language rules */
	public final static String pathConfigurationParserLangRules			= "skb/lang/rules";
}
