/* Copyright (c) 2007-2011 Sven van der Meer
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
public class FieldKeys {
	/*
	 * Field keys for application specific items
	 */
	/** Key for a field holding the application name */
	public final static String	fieldApplicationName				= "skb:application:name";

	/** Key for a field holding copyright information for the application */
	public final static String fieldApplicationCopyright			= "skb:application:copyright";

	/** Key for a field holding information about software used to build the application */
	public final static String fieldApplicationBuildwith			= "skb:application:buildwith";

	/** Key for a field holding additional information about application, used for usage/help screens */
	public final static String fieldApplicationAdditional			= "skb:application:additional";

	/** Key for a field holding the version of an application */
	public final static String fieldApplicationVersion				= "skb:application:version";

	/** Key for a field holding the build of an application */
	public final static String fieldApplicationBuild				= "skb:application:build";

	/** Key for a field holding the build date of an application */
	public final static String fieldApplicationBuilddate			= "skb:application:builddate";

	/** Key for a field with the name of the application directory, for instance user-dir */
	public final static String fieldApplicationDirectory			= "skb:application:directory";


	/*
	 * Field keys for value specifications and processing
	 */

	/** Key for a field that specifies the (expected) type of a value */
	public final static String fieldValueType						= "skb:value:type";

	/** Key for a field that holds a default value */
	public final static String fieldValueDefault					= "skb:value:default";

	/** Key for a field that holds a value read from a file, for instance a property file */
	public final static String fieldValueFile						= "skb:value:file";

	/** Key for a field that holds a value read from command line arguments */
	public final static String fieldValueCli						= "skb:value:cli";


	/*
	 * Field keys for command line specifications and processing, Skb.Util.Cli
	 */
	/** Key for a field that specifies a short command line option, should be only 1 character */
	public final static String fieldCliOptionShort					= "skb:util:cli:option:short";

	/** Key for a field that specifies a long command line option, should start with "--" */
	public final static String fieldCliOptionLong					= "skb:util:cli:option:long";

	/** Key for a field that specifies the type of a command line option, for instance String, Integer */
	public final static String fieldCliOptionType					= "skb:util:cli:option:type";

	/** Key for a field that specifies that a command line option can have arguments, should be an integer stating the number of expected arguments */
	public final static String fieldCliOptionArguments				= "skb:util:cli:option:arguments";

	/** Key for a field that specifies the separator for arguments of a command line option */
	public final static String fieldCliOptionArgumentsSeparator		= "skb:util:cli:option:arguments:separator";

	/** Key for a field that specifies the description for a command line option, can be used in usage output */
	public final static String fieldCliOptionDescriptionShort		= "skb:util:cli:descr:short";

	/** Key for a field that specifies the description for a command line option, can be used in usage output */
	public final static String fieldCliOptionDescriptionLong		= "skb:util:cli:descr:long";

	/** Key for a field that specifies the description for arguments (if any allowed) */
	public final static String fieldCliOptionDescriptionArguments	= "skb:util:cli:descr:arguments";


	/*
	 * Field keys for general command line arguments 
	 */
	/** General key for common command line arguments */
	public final static String fieldCliArgument						= "skb:util:cli:argument";

	/** Key for a field that holds information on whether to show version information or not */
	public final static String fieldCliArgumentShowversion			= "skb:util:cli:argument:show-version";

	/** Key for a field that holds information on whether to show help information or not */
	public final static String fieldCliArgumentShowhelp				= "skb:util:cli:argument:show-help";

	/** Key for a field that holds information on whether to show supported languages, i.e. of a parser/compiler */
	public final static String fieldCliArgumentShowlang				= "skb:util:cli:argument:show-languages";

	/** Key for a field that indicates to load configuration from a <file> */
	public final static String fieldCliArgumentConfigLoad			= "cfg-load";

	/** Key for a field that indicates to save configuration to a <file> */
	public final static String fieldCliArgumentConfigSave			= "cfg-save";

	/** Key for a field that indicates whether default options are to be shown */
	public final static String fieldCliArgumentDefaultOptions		= "default-options";

	/** Key to a field that holds information on supported languages */
	public final static String fieldCliArgumentLanguages			= "languages";

	/** Key to a field that indicates whether the Report Manager StringTempltate should be printed */
	public final static String fieldCliArgumentReportManagerStg		= "repmgr-stg";

	/** Key to a field that indicates whether the Tribe StringTempltate should be printed */
	public final static String fieldCliArgumentPrStgFileTribe		= "pr-stg-tribe";

	/** Key to a field that indicates whether to print the target language StringTempltate */
	public final static String fieldCliArgumentPrStgFileTarget		= "pr-stg-target";

	/** Key to a field that indicates if warnings should be printed */
	public final static String fieldCliArgumentNoWarnings			= "no-warnings";

	/** Key to a field that indicates if errors should be printed*/
	public final static String fieldCliArgumentNoErrors				= "no-errors";

	/** Key to a field that indicates whether the preprocessor (CPP) should be used */
	public final static String fieldCliArgumentNoCPP				= "no-cpp";

	/** Key to a field that indicates if quiet mode is on */
	public final static String fieldCliArgumentQuietMode			= "be-quiet";

	/** Key to a field that indicates if code generation is switched on*/
	public final static String fieldCliArgumentGC					= "gc";

	/** Key to a field that holds the scope separator for code generation */
	public final static String fieldCliArgumentGCScopeSep			= "gc-scope-sep";

	/** Key to a field that determines the source language*/
	public final static String fieldCliArgumentSrcLanguage			= "src-lang";

	/** Key to a field that determines the source file */
	public final static String fieldCliArgumentSrcFile				= "src-file";

	/** Key to a field that determines the target language*/
	public final static String fieldCliArgumentTgtLanguage			= "tgt-lang";

	/** Key to a field that determines the target language directory*/
	public final static String fieldCliArgumentTgtDir				= "tgt-dir";

	/** Key to a field that determines the target language file extension */
	public final static String fieldCliArgumentTgtFileExt			= "tgt-fileext";

	/** Key to a field that determines the target language file */
	public final static String fieldCliArgumentTgtFile				= "tgt-file";

	/** Key to a field that determines the target language StringTemplate*/
	public final static String fieldCliArgumentTgtStg				= "tgt-stg";

	/** Key to a field that determines the lexer to be used for StringTemplate initialisation */
	public final static String fieldCliArgumentTgtStgAngleBr		= "tgt-stg-angle-br";

	/** Key to a field that determines which StringTemplate to be used for header information */
	public final static String tpmKeyGenericSTG         = "tribe-generic-stg";

	/** Key to a field that determines whether generated target code should be split, i.e. into several files or directories */
	public final static String fieldCliArgumentTgSplitCode			= "tgt-split-code";


	/*
	 * Field keys for Skb.Util.Lang
	 */
	/** Key for a field that provides a language rule message */
	public final static String fieldLangRuleMessage					= "skb:lang:parser:rules:message";

	/** Key for a field that provides additional information for a language rule message */
	public final static String fieldLangRuleMessageAdd				= "skb:lang:parser:rules:message:add";

	/** Key to a field that defines a replacement in a message, usually replacing a string "####" in the message */
	public final static String fieldLangRuleMessageReplace			= "skb:lang:rule:message:replace";

	/** Key to a field that defines a replacement in the additional information of a message, usually replacing a string "####" */
	public final static String fieldLangRuleMessageAddReplace		= "skb:lang:rule:message:add:replace";

	/** Key for a field that provides information about command line parameters for a language target */
	public final static String fieldLangTargetConfigCli				= "skb:lang:target:config:cli";

	/** Key to a field that defines an identifier */
	public final static String fieldLangTargetConstantIdent			= "skb:util:constant:ident";

	/** Key to a field that defines an identifier */
	public final static String fieldLangTargetConstantValue			= "skb:util:constant:value";

	/** Key to a field that has descriptions for JavaDoc */
	public final static String fieldLangTargetConstantJavadoc		= "skb:util:constant:javadoc";

	//TODO check this
	/** Key to a field that defines an identifier for tokens */
	public final static String fieldLangTargetTokenIdent			= "skb:lang:target:token:ident";

	/** Key to a field that defines a value for a token */
	public final static String fieldLangTargetTokenTranslate		= "skb:lang:target:token:translate";

//	/** Key to a field that defines a target name */
//	public final static String fieldLangTargetName					= "skb:lang:target:name";

	/** Key to a field that holds the category of a language atom */
	public final static String fieldLangAtomCategory				= "skb:lang:atom:category";

	/** Key to a field that holds the type of a language atom */
	public final static String fieldLangAtomType					= "skb:lang:atom:type";

	/** Key to a field that determines of the language atom is an array */
	public final static String fieldLangAtomArray					= "skb:lang:atom:array";

	/** Key to a field that holds the file name the atom has been defined in */
	public final static String fieldLangAtomFile					= "skb:lang:atom:file";

	/** Key to a field that holds the line number the atom has been defined in */
	public final static String fieldLangAtomLine					= "skb:lang:atom:line";

	/** Key to a field that holds the column number the atom has been defined in */
	public final static String fieldLangAtomColumn					= "skb:lang:atom:column";

	/** Key to a field that holds the StringTemplate for atom */
	public final static String fieldLangAtomSt						= "skb:lang:atom:st";

	/** Key to a field that holds the atom's scoped identifier */
	public final static String fieldLangAtomIdentScoped				= "skb:lang:atom:scoped:ident";

	/** Key to a field that maintains a single source language identifier */
	public final static String fieldLangSupportedSource				= "skb:lang:supported:source";

	/** Key to a field that maintains a list of target language identifiers */
	public final static String fieldLangSupportedTargets			= "skb:lang:supported:targets";

	/** Key to a field that holds a parser class for a source language */
	public final static String fieldLangSupportedParser				= "skb:lang:supported:parser";


	/*
	 * Field keys for Skb.Util.Stringtemplate
	 */
	/** Key to a field that defines mandatory chunks for a string template group */
	public final static String fieldStringtemplateChunksMandatory	= "skb:stringtemplate:chunks:mandatory";

	/** Key to a field that defines optional chunks for a string template group */
	public final static String fieldStringtemplateChunksOptional	= "skb:stringtemplate:chunks:optional";

}

