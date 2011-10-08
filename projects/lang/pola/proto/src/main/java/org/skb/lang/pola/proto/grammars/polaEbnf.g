/* Copyright (c) 2009-2011 Sven van der Meer
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
 * EBNF ANTLR grammar for Org.SKB.Lang.Pola.Proto
 *
 * @package    org.skb.lang.pola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

grammar polaEbnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.pola.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.base.classic.config.Configuration;
  import org.skb.lang.pola.proto.PolaPass1_Ebnf;
  import org.skb.tribe.TribeHelpers;
  import org.skb.lang.pola.proto.PolaParser;
  import org.skb.lang.pola.proto.constants.PolaConstants;
}

@lexer::header
{
  package org.skb.lang.pola.proto.grammars;

  import org.skb.base.classic.config.Configuration;
  import org.skb.lang.pola.proto.PolaParser;
  import org.skb.lang.pola.proto.constants.PolaConstants;
}

@members{
  public static Configuration config=Configuration.getConfiguration(PolaParser.class);

  private String[] myTokens;
  private PolaPass1_Ebnf pass;
  private Token base_type;
  private boolean isArray=false;

  public void init() {
    this.pass=new PolaPass1_Ebnf();
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
    config.getReportManager().error(super.getErrorMessage(re, this.myTokens), re);
  }
}

@lexer::members{
  public static Configuration config=Configuration.getConfiguration(PolaParser.class);

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

skbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
skbEnvironment          : 'production' | 'test' | 'demonstrator';
skbCLevel               : 'business' | 'system' | 'element';

polaSpecification         @init{this.init();}
                        : 
                          cpp_directive AT_STAGE skbStage ';' AT_ENVIRONMENT skbEnvironment ';' AT_CLEVEL skbCLevel ';' AT_LANGUAGE l=IDENT ';' AT_SPEC spec=IDENT ';' {this.pass.atoms.specificationName(spec);} polaDefinition* EOF
                          -> ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE $l) ^(AT_SPEC $spec) cpp_directive polaDefinition*);                          
polaDefinition          : cpp_directive | managementPolicy;

cpp_directive           : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};


//++Subject & Target
//policyConcept           : policyCategory | policyRuleComponentStructure;

//attr ++pcLevel
//policyCategory          : managementPolicy;


managementPolicy        : POLA_POLICY managementPolicyType s=IDENT
                          {this.pass.atoms.putAtom(s,null);}
                          '{' policyRuleStructure '}'
                          -> ^(POLA_POLICY IDENT managementPolicyType policyRuleStructure);
managementPolicyType    : deonticPolicy | managementMetaPolicy;
deonticPolicy           : POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH;
managementMetaPolicy    : POLA_MEPO_DELE | POLA_MEPO_REVO;


//++MD
policyRuleStructure      : (policyContinuumLevel)? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule;
policyContinuumLevel     : POLA_PC_LEVEL '=' ('business' | 'system' | 'administration' | 'device' 'instance') ';';

ecaPolicyRule            : POLA_RULE_STRUCT_ECA '::=' ecaPolicyRuleBody
                           -> ^(POLA_RULE_STRUCT_ECA ecaPolicyRuleBody);
ecaPolicyRuleBody        : policyEventStructure* policyConditionStructure* policyActionStructure*;
goalPolicyRule           : POLA_RULE_STRUCT_GOAL; //PH
utilityFunctionPolicyRule: POLA_RULE_STRUCT_UTIL; //PH


//++MD
policyRuleComponentStructure: policyEventStructure | policyConditionStructure | policyActionStructure;

policyEventStructure    : POLA_EVENT policyEventStructureBody*;
policyEventStructureBody: policyEventGroup | policyEvent;
policyEventGroup        : POLA_GROUP IDENT '{' policyEventGroupBody* '}' ';'
                          -> ^(POLA_GROUP IDENT policyEventGroupBody*);
policyEventGroupBody    : policyEventGroup | policyEvent;
policyEvent             : policyEventBody* ';' -> ^(BODY policyEventBody*);
policyEventBody         : policyEventComposite | policyEventAtomic | policyEventNonStd;
policyEventComposite    : POLA_COMPOSITE policyECAInherited '{' policyEvent* '}'
                          -> ^(POLA_COMPOSITE policyECAInherited policyEvent*);
policyEventAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyEventNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyConditionStructure    : POLA_CONDITION policyConditionStructureBody*;
policyConditionStructureBody: policyConditionGroup | policyCondition;
policyConditionGroup        : POLA_GROUP IDENT '{' policyConditionGroupBody* '}' ';'
                              -> ^(POLA_GROUP IDENT policyConditionGroupBody*);
policyConditionGroupBody    : policyConditionGroup | policyCondition;
policyCondition             : policyConditionBody* ';' -> ^(BODY policyConditionBody*);
policyConditionBody         : policyConditionComposite | policyConditionAtomic | policyConditionNonStd;
policyConditionComposite    : POLA_COMPOSITE policyECAInherited '{' policyCondition* '}'
                          -> ^(POLA_COMPOSITE policyECAInherited policyCondition*);
policyConditionAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyConditionNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyActionStructure    : POLA_ACTION policyActionStructureBody*;
policyActionStructureBody: policyActionGroup | policyAction;
policyActionGroup        : POLA_GROUP IDENT '{' policyActionGroupBody* '}' ';'
                              -> ^(POLA_GROUP IDENT policyActionGroupBody*);
policyActionGroupBody    : policyActionGroup | policyAction;
policyAction             : policyActionBody* ';' -> ^(BODY policyActionBody*);
policyActionBody         : policyActionComposite | policyActionAtomic | policyActionNonStd;
policyActionComposite    : POLA_COMPOSITE policyECAInherited '{' policyAction* '}'
                          -> ^(POLA_COMPOSITE policyECAInherited policyAction*);
policyActionAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyActionNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyECAInherited    : IDENT POLA_SEQ_NUMER ':' VAL_INTEGER POLA_HASBEEN_EVALED ':' boolean_value
                        -> ^(POLA_SEQ_NUMER VAL_INTEGER) ^(POLA_HASBEEN_EVALED boolean_value);


pola_string             : VAL_DSTRING;

scoped_name             : (s=IDENT ('::' s=IDENT)* '::')? s=IDENT -> ^(AT_SCOPE IDENT*);

void_type               : VOID;
simple_type             : (scoped_name | base_type) array?
                          ;
base_type               : (s=SHORT | s=INTEGER | s=LONG | s=OCTET | s=HEX | s=BINARY | s=FLOAT | s=DOUBLE | s=CHAR | s=STRING | s=BOOLEAN)
                          {this.base_type=s;}
                          ;
array                   : '[' ']' {this.isArray=true;} -> ARRAY;

const_value             : VAL_INTEGER   -> ^(AT_PROVIDES INTEGER VAL_INTEGER)|
                          VAL_OCT       -> ^(AT_PROVIDES OCTET VAL_OCT)|
                          VAL_HEX       -> ^(AT_PROVIDES HEX VAL_HEX)|
                          VAL_BINARY    -> ^(AT_PROVIDES BINARY VAL_BINARY)|
                          VAL_FLOAT     -> ^(AT_PROVIDES FLOAT VAL_FLOAT)|
                          VAL_CHAR      -> ^(AT_PROVIDES CHAR VAL_CHAR)|
                          string_value  -> ^(AT_PROVIDES STRING string_value)|
                          boolean_value -> ^(AT_PROVIDES BOOLEAN boolean_value);
string_value            : VAL_STRING | POLA_NULL;
boolean_value           : POLA_TRUE | POLA_FALSE;

//for parsing only
ARRAY         : '__array';
BODY          : '__body';

// pola Keywords
//ACTION        : 'action';
//ATTRIBUTE     : 'attribute';
//CONTRACT      : 'contract';
//ELEMENT       : 'element';
//FACILITY      : 'facility';
//FUNCTION      : 'function';
//INV           : 'inv';
//ITEM          : 'item';
//MANDATORY     : 'mandatory';
//NOT_DEF       : 'not_def';
//OPTIONAL      : 'optional';
//PACKAGE       : 'package';
//PARAMETER     : 'parameter';
//POST          : 'post';
//PRE           : 'pre';
//PROPERTY      : 'property';
//REQUIRED      : 'required';
STRUCT        : 'struct';
TYPEDEF       : 'typedef';

// pola Keywords -> pola
POLA_PC_LEVEL            : 'continuum-level';

POLA_COMPOSITE           : 'composite';
POLA_ATOMIC              : 'atomic';
POLA_GROUP               : 'group';
POLA_NONSTD              : 'nonstd';

POLA_RULE_STRUCT_ECA     : 'eca';
POLA_RULE_STRUCT_GOAL    : 'goal';
POLA_RULE_STRUCT_UTIL    : 'util';

POLA_ACTION              : 'action';
POLA_CONDITION           : 'condition';
POLA_EVENT               : 'event';
POLA_POLICY              : 'policy';

POLA_SEQ_NUMER           : 'seq-number';
POLA_HASBEEN_EVALED      : 'evaluated';

POLA_DEONT_AUTH          : 'authorization';
POLA_DEONT_EXEM          : 'exemption';
POLA_DEONT_OBLG          : 'obligation';
POLA_DEONT_PROH          : 'prohibition';

POLA_MEPO_DELE           : 'delegation';
POLA_MEPO_REVO           : 'revocation';


// pola Keywords -> @@@
//AT_ALTERABLE       : '@alterable';
//AT_APPLY           : '@apply';
AT_CLEVEL          : '@clevel';
//AT_CONTAINS        : '@contains';
//AT_DESCRIPTION     : '@description';
AT_ENVIRONMENT     : '@environment';
//AT_EXTENDS         : '@extends';
AT_LANGUAGE        : '@language';
//AT_NEGOTIABLE      : '@negotiable';
//AT_PRIORITY        : '@priority';
AT_PROVIDES        : '@provides';
//AT_RANK            : '@rank';
//AT_REQUIRES        : '@requires';
//AT_RETURN          : '@return';
//AT_RUNTIME         : '@runtime';
AT_SCOPE           : '@scope';
AT_SPEC            : '@spec';
AT_STAGE           : '@stage';
//AT_TYPE            : '@type';
//AT_VISIBILITY      : '@visibility';

// pola Keywords -> TYPES
BINARY        : 'binary';
BOOLEAN       : 'boolean';
CHAR          : 'char';
DOUBLE        : 'double';
FLOAT         : 'float';
HEX           : 'hex';
INTEGER       : 'integer';
LONG          : 'long';
OCTET         : 'octet';
SHORT         : 'short';
STRING        : 'string';
VOID          : 'void';

// pola Keywords -> VALUES
POLA_FALSE    : 'FALSE';
POLA_NULL     : 'NULL';
POLA_TRUE     : 'TRUE';

WS            : (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;};
SL_COMMENT    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
ML_COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
VAL_CHAR      : '\'' ( ESC | ~('\''|'\\') ) '\'';
VAL_STRING    : '"' ( ESC | ~('\\'|'"') )* '"';

fragment ESC  : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | UnicodeEscape | OctalEscape;
fragment
OctalEscape   : '\\' ('0'..'3') ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ('0'..'7') | '\\' ('0'..'7');
fragment
UnicodeEscape : '\\' 'u' HexDigit HexDigit HexDigit HexDigit;

fragment
HexDigit      : ('0'..'9'|'a'..'f'|'A'..'F');
VAL_HEX       : '0' ('x'|'X') HexDigit+;

VAL_INTEGER   : ('+' | '-')? ('0' | '1'..'9' '0'..'9'*);

fragment
OctDigit      : ('0'..'7');
VAL_OCT       : '0' OctDigit OctDigit OctDigit;

fragment
BinDigit      : ('0' | '1');
VAL_BINARY    : ('b' | 'B') (BinDigit)+;

fragment
Exponent      : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
fragment
FloatSuffix   : ('f'|'F'|'d'|'D') ;
VAL_FLOAT     :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatSuffix?
                | '.' ('0'..'9')+ Exponent? FloatSuffix?
                | ('0'..'9')+ Exponent FloatSuffix?
                | ('0'..'9')+ Exponent? FloatSuffix
                ;

IDENT         : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// originally = CPP_FILENAME !
CPP_DIRECTIVE : '#' 'file' ' ' CPP_FILENAME '\r'? '\n' {this.setCppFileandLine($CPP_FILENAME.getText());};
CPP_FILENAME  : '"' (~'"')* '"';

VAL_DSTRING   : '<' ( ESC | ~('\\'|'>') )* '>';