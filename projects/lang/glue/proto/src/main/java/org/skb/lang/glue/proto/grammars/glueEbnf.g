/* Copyright (c) 2010-2011 Sven van der Meer (sven@vandermeer.de)
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

/*
 * EBNF ANTLR grammar for Org.SKB.Lang.Glue.Proto
 *
 * @package    org.skb.lang.glue.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

grammar glueEbnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.glue.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.util.config.Configuration;
  import org.skb.lang.glue.proto.GlueParser;
  import org.skb.lang.glue.proto.GluePass1_Ebnf;
  import org.skb.tribe.TribeHelpers;
  import org.skb.lang.glue.proto.constants.GlueConstants;
  import org.skb.util.patterns.structural.composite.atomic.misc.TSReportManager;
}

@lexer::header
{
  package org.skb.lang.glue.proto.grammars;

  import org.skb.lang.glue.proto.GlueParser;
  import org.skb.util.config.Configuration;
  import org.skb.lang.glue.proto.constants.GlueConstants;
  import org.skb.util.patterns.structural.composite.atomic.misc.TSReportManager;
}

@members{
  public static Configuration config=Configuration.getConfiguration(GlueParser.class);

  private String[] myTokens;
  private GluePass1_Ebnf pass;
  private Token base_type;
  private boolean isArray=false;

  public void init() {
    this.pass=new GluePass1_Ebnf();
    this.myTokens=TribeHelpers.translateTokens(tokenNames, config);
  }

  public void setFilename(String f){
    config.getReportManager().setFileName(f);
  }

  public String getFilename(){
    return config.getReportManager().getFileName();
  }

  private void setCppFile(String cpp){
    String fn=cpp.substring(1,cpp.lastIndexOf(':'));
    fn=fn.replace("file \"","");
    this.setFilename(fn);
  }

  public int  numberOfErrors(){
    return config.getReportManager().noOfErrors();
  }

  public void resetErrors(){
    config.getReportManager().resetNoOfErrors();
  }

  public void displayRecognitionError(String[] tokenNames, RecognitionException re){
    config.getReportManager().reportError(super.getErrorMessage(re, this.myTokens), re);
  }
}

@lexer::members{
  public static Configuration config=Configuration.getConfiguration(GlueParser.class);

  public void setFilename(String f){
    config.getReportManager().setFileName(f);
  }

  public String getFilename(){
    return config.getReportManager().getFileName();
  }

  private void setCppFile(String cpp){
    String fn=cpp.substring(1,cpp.lastIndexOf(':'));
    this.setFilename(fn);
  }

  private void setCppLine(String cpp){
    Integer i=new Integer(cpp.substring(cpp.lastIndexOf(':')+1, cpp.length()-1));
    this.input.setLine(i.intValue());
  }

  private void setCppFileandLine(String cpp){
    setCppFile(cpp);
    setCppLine(cpp);
  }
}

glueSpecification @init{this.init();}
                   : AT_SPEC s=IDENT ';' glueTopology* EOF
                     -> ^(AT_SPEC IDENT glueTopology*);

glueTopology       : TOPOLOGY (IDENT | scoped_name_lang) '[' (glueDomain | glueNode | glueConnection)* ']'
                     -> ^(TOPOLOGY IDENT? scoped_name_lang? glueDomain* glueNode* glueConnection*);

glueDomain         : DOMAIN (IDENT | scoped_name_lang) '[' (glueDomain | glueNode | glueConnection | gluePort)* glueContracts? gluePolicies? ('{' key_value_list '}')? ']'
                     -> ^(DOMAIN IDENT? scoped_name_lang? glueDomain* glueNode* glueConnection* gluePort* glueContracts? gluePolicies? key_value_list?);

glueNode           : NODE (IDENT | scoped_name_lang) '[' (glueComponent | glueConnection | gluePort)* glueContracts? gluePolicies? ('{' key_value_list '}')? ']'
                     -> ^(NODE IDENT? scoped_name_lang? glueComponent* glueConnection* gluePort* glueContracts? gluePolicies? key_value_list?);

glueConnection     : CONNECTION IDENT '[' DIRECTED? glueSource glueTarget ']'
                     -> ^(CONNECTION IDENT DIRECTED? glueSource glueTarget);

glueSource         : SOURCE '=' scoped_name glueSourcePort?
                     -> ^(SOURCE scoped_name glueSourcePort?);
glueTarget         : TARGET '=' scoped_name glueTargetPort?
                     -> ^(TARGET scoped_name glueTargetPort?);

gluePort           : PORT '=' IDENT
                     -> ^(PORT IDENT);

glueSourcePort     : SOURCEPORT '=' scoped_name
                     -> ^(SOURCEPORT scoped_name);
glueTargetPort     : TARGETPORT '=' scoped_name
                     -> ^(TARGETPORT scoped_name);

glueComponent      : COMPONENT (IDENT | scoped_name_lang) '[' (gluePort)* glueContracts? gluePolicies? ('{' key_value_list '}')? ']'
                     -> ^(COMPONENT IDENT? scoped_name_lang? gluePort* glueContracts? gluePolicies? key_value_list?);

glueContracts      : CONTRACTS ('=')? '{' (scoped_name | scoped_name_lang)* '}'
                     -> ^(CONTRACTS scoped_name* scoped_name_lang*);

gluePolicies       : POLICIES ('=')? '{' (scoped_name | scoped_name_lang)* '}'
                     -> ^(POLICIES scoped_name* scoped_name_lang*);

scoped_name        : (IDENT ('::' IDENT)* '::')? IDENT -> ^(AT_SCOPE IDENT*);
scoped_name_lang   : IDENT '@' scoped_name -> ^(AT_LANG IDENT scoped_name);

key_value_list     : key_value key_value* -> ^(AT_KVL key_value*);
key_value          : (IDENT | VAL_STRING) '=' (VAL_XSTRING | VAL_STRING) -> ^(AT_KVL ^(AT_KVL IDENT? VAL_STRING?) ^(AT_KVL VAL_XSTRING? VAL_STRING?));

// Glue Keywords
TOPOLOGY      : 'topology';
NODE          : 'node';
CONNECTION    : 'connection';
INTERFACE     : 'interface';
COMPONENT     : 'component';
DIRECTED      : 'directed';
SOURCE        : 'source';
TARGET        : 'target';
PORT          : 'port';
SOURCEPORT    : 'sourceport';
TARGETPORT    : 'targetport';
DOMAIN        : 'domain';
CONTRACTS     : 'contracts';
POLICIES      : 'policies';

AT_SPEC       : '@spec';
AT_SCOPE      : '@scope';
AT_LANG       : '@lang';
AT_KVL        : '@kvl';

IDENT         : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

WS            : (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;};
SL_COMMENT    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
ML_COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
VAL_CHAR      : '\'' ( ESC | ~('\''|'\\') ) '\'';
VAL_STRING    : '"' ( ESC | ~('\\'|'"') )* '"';

//VAL_XSTRING   : '$$' ( ESC | ~('\\'|'$$') )* '$$';
VAL_XSTRING   : '<![' 'CDATA'? '[' ( options {greedy=false;} : . )* ']]>';

fragment ESC  : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | UnicodeEscape | OctalEscape;

fragment
OctalEscape   : '\\' ('0'..'3') ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ('0'..'7') | '\\' ('0'..'7');
fragment
UnicodeEscape : '\\' 'u' HexDigit HexDigit HexDigit HexDigit;

fragment
HexDigit      : ('0'..'9'|'a'..'f'|'A'..'F');
VAL_HEX       : '0' ('x'|'X') HexDigit+;