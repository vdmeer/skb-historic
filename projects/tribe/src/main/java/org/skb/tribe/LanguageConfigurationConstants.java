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
 * Constants for reading a json configuration file of a parser.
 *
 * @author     Sven van der Meer
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */

public final class LanguageConfigurationConstants {
	public LanguageConfigurationConstants(){}

    public static final class Fields {
    	public final static String A3DSLanguageTargetConfigurationCli="a3ds:language:target:config:cli";
//    	public final static String A3DSLanguageTargetConfigurationTribe="a3ds:language:target:config:tribe";

    	public final static String A3DSTLanguageTargetConfigurationConstID="a3ds:language:target:config:constid";

    	public final static String A3DSTribeStgChunkMandatory="a3ds:tribe:stgchunk:mandatory";
    	public final static String A3DSTribeStgChunkOptional="a3ds:tribe:stgchunk:optional";

    	public final static String A3DSTLanguageTokensConstID="a3ds:language:target:tokens:cid";
    	public final static String A3DSTLanguageTokensConstVal="a3ds:language:target:tokens:cval";
    	public final static String A3DSTLanguageTokensConstJavaDoc="a3ds:language:target:tokens:cjavadoc";

    	public final static String A3DSTLanguageTokensTokenID="a3ds:language:target:tokens:tid";
    	public final static String A3DSTLanguageTokensTokenVal="a3ds:language:target:tokens:tval";

    	public final static String A3DSLanguageTargetName="a3ds:language:target:name";

    	public final static String A3DSTLanguageRulesMessage="a3ds:language:parser:rules:message";
    	public final static String A3DSTLanguageRulesMessageAdd="a3ds:language:parser:rules:message:add";
    	public final static String A3DSTLanguageRulesMessageInsertPath="a3ds:language:parser:rules:message:insert:path";
    	public final static String A3DSTLanguageRulesMessageAddInsertPath="a3ds:language:parser:rules:message:add:insert:path";
    }

    public static final class Paths {
    	public final static String A3DSTribeConfiguration="a3ds/tribe/configuration";

    	public final static String A3DSLanguageConfiguration="a3ds/language/configuration";
    	public final static String A3DSLanguageTokens="a3ds/language/tokens";
    	public final static String A3DSLanguageTargets="a3ds/language/targets";

    	public final static String A3DSLanguageStgChunks="a3ds/language/stgchunks";
    	public final static String A3DSLanguageRules="a3ds/language/rules";
    }
}
