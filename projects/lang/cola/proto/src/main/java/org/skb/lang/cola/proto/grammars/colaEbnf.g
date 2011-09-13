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

/*
 * EBNF ANTLR grammar for Org.SKB.Lang.Cola.Proto
 *
 * @package    org.skb.lang.cola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

grammar colaEbnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.cola.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.lang.cola.proto.ColaPass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.constants.ColaConstants;
  import org.skb.util.misc.ReportManager;
}

@lexer::header
{
  package org.skb.lang.cola.proto.grammars;

  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.constants.ColaConstants;
  import org.skb.util.misc.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private ColaPass1_Ebnf pass;
  private Token base_type;
  private boolean isArray=false;

  public void init() {
    this.pass=new ColaPass1_Ebnf();
    this.myTokens = new LanguageTokens();
    this.myTokens.addTokens(tokenNames);
  }

  public void setFilename(String f){ReportManager.getInstance().setFileName(f);}
  public String getFilename(){return ReportManager.getInstance().getFileName();}

  private void setCppFile(String cpp){
    String fn=cpp.substring(1,cpp.lastIndexOf(':'));
    fn=fn.replace("file \"","");
    this.setFilename(fn);
  }

  public int  numberOfErrors() {return ReportManager.getInstance().noOfErrors();}
  public void resetErrors()    {ReportManager.getInstance().resetNoOfErrors();}
  public void displayRecognitionError(String[] tokenNames, RecognitionException re){ReportManager.getInstance().reportError(super.getErrorMessage(re, this.myTokens.getTokenNames()), re);}
}

@lexer::members{
  public void setFilename(String f){ReportManager.getInstance().setFileName(f);}
  public String getFilename(){return ReportManager.getInstance().getFileName();}

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

colaFunction            : FUNCTION s=IDENT ':' AT_LANGUAGE '=' string_value PARAMETER '(' colaFunctionParam* ')' AT_RETURN '(' base_type array? ')' ';'
                          {this.pass.putAtom(s,ColaConstants.Tokens.colaFUNCTION, this.base_type, this.isArray);}
                          {this.pass.atoms.scope.pop();}
                          -> ^(FUNCTION IDENT colaFunctionParam* base_type array? ^(AT_LANGUAGE string_value))
                          ;
colaFunctionParam       : '[' base_type array? IDENT ']'
                          -> ^(PARAMETER base_type array? IDENT);

colaPropertyDecl        : PROPERTY s=IDENT ':'
                          AT_TYPE '(' base_type array? '=' const_value ')'
                          {this.pass.putAtom(s,ColaConstants.Tokens.colaPROPERTY, this.base_type, this.isArray);}
                          {this.isArray=false;}
                          AT_SCOPE '(' propertyScope+ ')'
                          {this.pass.propertyDeclScopeFinish();}
                          propertyApply atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                          (AT_EXTENDS  '(' ext+=scoped_name+ ')')?
                          (AT_REQUIRES '(' req+=scoped_name+ ')')?
                          (AT_PRIORITY '(' base_type '=' const_value ')')?
                          ';'
                          {this.pass.atoms.scope.pop();}
                          -> ^(PROPERTY IDENT ^(AT_TYPE base_type const_value array?)
                               ^(AT_SCOPE propertyScope+)
                               propertyApply atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                               ^(AT_EXTENDS $ext+)? ^(AT_REQUIRES $req+)?
                               ^(AT_PRIORITY base_type const_value)?
                              )
                          ;
propertyScope           : '[' propertyScopeAtom ':' propertyScopeRank ']' -> ^(propertyScopeAtom propertyScopeRank);
propertyScopeAtom       : (s=PACKAGE | s=ELEMENT | s=FACILITY | s=ACTION | s=ATTRIBUTE | s=PARAMETER)
                          {this.pass.addPropertyDeclScopeAtom(s);};
propertyScopeRank       : (s=REQUIRED | s=MANDATORY | s=OPTIONAL | s=NOT_DEF)
                          {this.pass.addPropertyDeclScopeRank(s);};
propertyApply           : AT_APPLY '(' ((PRE ('=' idpre+=scoped_name (',' idpre+=scoped_name)*)?) |
                                        (POST ('=' idpost+=scoped_name (',' idpost+=scoped_name)*)?) |
                                        (INV ('=' idinvt+=scoped_name (',' idinvt+=scoped_name)*)?))? ')'
                          -> ^(AT_APPLY (^(PRE $idpre*))? (^(POST $idpost*))? (^(INV $idinvt*))? );

atVisibility            : AT_VISIBILITY '[' AT_SPEC atVisibilityData ',' AT_RUNTIME atVisibilityData ']'
                          -> ^(AT_VISIBILITY ^(AT_SPEC atVisibilityData) ^(AT_RUNTIME atVisibilityData));
atVisibilityData        : '('
                          (IDENT? '-' string_value (',' string_value)*)? ';'
                          COLA_TRUE? ';'
                          (IDENT? '+' string_value (',' string_value)*)?
                          ')'
                          ;

atDescription           : AT_DESCRIPTION '(' string_value ')' -> ^(AT_DESCRIPTION string_value);

colaPropertyDefList     : {this.pass.identsStart();} '[' colaPropertyDef (',' colaPropertyDef)* ']' -> colaPropertyDef*;
colaPropertyDef         : scoped_name s=IDENT {this.pass.identsAddPropDef(s);} ('(' const_value (',' const_value)* ')')?
                          //{this.pass.atoms.definedProperties();}
                          -> ^(PROPERTY IDENT scoped_name const_value*);

colaContractDecl        : CONTRACT s=IDENT ':' {this.pass.putAtom(s,ColaConstants.Tokens.colaCONTRACT);}
                          {this.pass.lastContract();}
                          AT_SCOPE '(' contractScope+ ')'
                          {this.pass.contractDeclScopeFinish();}
                          atVisibility? atDescription (contractItem)*
                          {this.pass.atoms.scope.pop();}
                          ';'
                          -> ^(CONTRACT IDENT ^(AT_SCOPE contractScope*) atVisibility? atDescription contractItem*);
contractScope           : '[' contractScopeAtom ':' contractScopeRank ']' -> contractScopeAtom contractScopeRank;
contractScopeAtom       : (s=ELEMENT | s=FACILITY)
                          {this.pass.addContractDeclScopeAtom(s);};
contractScopeRank       : (s=REQUIRED | s=MANDATORY | s=OPTIONAL | s=NOT_DEF)
                          {this.pass.addContractDeclScopeRank(s);};

contractItem            : ITEM s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaITEM);}
                          {this.pass.identsStart();}
                          {this.pass.lastItem();}
                          '{' contractItemProp (',' contractItemProp)* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(ITEM IDENT contractItemProp+);
contractItemProp        : '[' s=IDENT ':'
                              AT_TYPE '(' base_type array? '=' const_value ')'
                              {this.pass.putAtom(s,ColaConstants.Tokens.parserItemProp, this.base_type, this.isArray);}
                              {this.isArray=false;}
                              AT_RANK '(' contractItemPropRank ')'
                              propertyApply AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                              (AT_PRIORITY '(' base_type '=' const_value ')')?
                              {this.pass.contractItemDeclAdd(s.getText());}
                              {this.pass.atoms.scope.pop();}
                          ']'
                          -> ^(PROPERTY IDENT ^(AT_TYPE base_type const_value array?)
                             contractItemPropRank propertyApply AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                             ^(AT_PRIORITY base_type const_value)?);
contractItemPropRank    : (s=REQUIRED | s=MANDATORY | s=OPTIONAL)
                          {this.pass.lastItemPropRank(s);};

colaContractDefList     : {this.pass.contIdentsStart();} '[' '[' colaContractDef (',' colaContractDef)* ']' ']' -> colaContractDef*;
colaContractDef         : '{' scoped_name s=IDENT {this.pass.contIdentsAdd(s);} '=' colaContractItemDef (',' colaContractItemDef)* '}' -> ^(CONTRACT IDENT scoped_name colaContractItemDef*);
colaContractItemDef     : IDENT colaItemDefList;
colaItemDefList         : {this.pass.identsStart();} '[' (colaItemDef (',' colaItemDef)*)? ']' -> colaItemDef*;
colaItemDef             : IDENT s=IDENT {this.pass.identsAddItemDef(s);} ('(' const_value (',' const_value)* ')')?
                          -> ^(IDENT IDENT const_value*);

colaSpecification       @init{this.init();}
                        : cpp_directive AT_STAGE skbStage ';' AT_ENVIRONMENT skbEnvironment ';' AT_CLEVEL skbCLevel ';' AT_LANGUAGE l=IDENT ';' AT_SPEC s=IDENT ';' {this.pass.atoms.specificationName(s);} colaDefinition* EOF
                          -> ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE $l) ^(AT_SPEC $s) cpp_directive colaDefinition*);
colaDefinition          : colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

colaPackage             : colaPropertyDefList? PACKAGE s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaPACKAGE);}
                          '{' (colaDefinition | inline_code)* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(PACKAGE IDENT colaPropertyDefList? colaDefinition* inline_code*)
                          ;
colaElement             : colaPropertyDefList? colaContractDefList? atVisibility?
                          ELEMENT s=IDENT
                          {this.pass.putAtom(s,ColaConstants.Tokens.colaELEMENT);}
                          (AT_EXTENDS elemExt=scoped_name)?
                          (AT_PROVIDES elemPro+=scoped_name (',' elemPro+=scoped_name)*)?
                          (AT_REQUIRES elemReq+=scoped_name (',' elemReq+=scoped_name)*)?
                          '{' elementBody* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(ELEMENT IDENT colaPropertyDefList? colaContractDefList? atVisibility?
                                ^(AT_EXTENDS $elemExt)? ^(AT_PROVIDES $elemPro+)? ^(AT_REQUIRES $elemReq+)?
                                elementBody*
                             )
                          ;
elementBody             : elementContains | colaAttribute | colaAction | inline_code;
elementContains         : AT_CONTAINS s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaAT_CONTAINS);} elemCont+=scoped_name ';' {this.pass.atoms.scope.pop();}
                          -> ^(AT_CONTAINS IDENT $elemCont);
colaFacility            : colaPropertyDefList? colaContractDefList? atVisibility?
                          FACILITY s=IDENT
                          {this.pass.putAtom(s,ColaConstants.Tokens.colaFACILITY);}
                          (AT_EXTENDS ext+=scoped_name (',' ext+=scoped_name)*)?
                          (AT_REQUIRES req+=scoped_name (',' req+=scoped_name)*)?
                          '{' facilityBody* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(FACILITY IDENT colaPropertyDefList? colaContractDefList? atVisibility?
                                ^(AT_EXTENDS $ext+)? ^(AT_REQUIRES $req+)? facilityBody*
                             )
                          ;
facilityBody            : colaAttribute | colaAction;
colaAction              : colaPropertyDefList? ACTION (simple_type|void_type) s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaACTION);}
                          '(' (colaParameter(',' colaParameter)*)? ')'
                          ('{' inline_code* '}')? ';'
                          {this.pass.atoms.scope.pop();}
                          -> ^(ACTION IDENT simple_type? void_type? colaPropertyDefList? colaParameter* inline_code*)
                          ;
colaParameter           : colaPropertyDefList? simple_type s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaPARAMETER);} {this.pass.atoms.scope.pop();}
                          -> ^(PARAMETER IDENT simple_type colaPropertyDefList?);
colaTypeDef             : colaPropertyDefList?
                          TYPEDEF simple_type s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaTYPEDEF);}
                          ('{' inline_code* '}')? ';'
                          {this.pass.atoms.scope.pop();}
                          -> ^(TYPEDEF IDENT simple_type colaPropertyDefList? inline_code*)
                          ;
colaAttribute           : colaPropertyDefList? ATTRIBUTE simple_type s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaATTRIBUTE);}
                          ('{' inline_code* '}')? ';'
                          {this.pass.atoms.scope.pop();}
                          -> ^(ATTRIBUTE IDENT simple_type colaPropertyDefList? inline_code*)
                          ;
colaStruct              : colaPropertyDefList? STRUCT s=IDENT {this.pass.putAtom(s,ColaConstants.Tokens.colaSTRUCT);}
                          '{' (colaMember | inline_code)* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(STRUCT IDENT colaPropertyDefList? colaMember* inline_code*)
                          ;
colaMember              : colaPropertyDefList? simple_type s=IDENT ';' {this.pass.putAtom(s,ColaConstants.Tokens.parserMEMBER);} {this.pass.atoms.scope.pop();}
                          -> ^(MEMBER IDENT simple_type colaPropertyDefList?);

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
string_value            : VAL_STRING | COLA_NULL;
boolean_value           : COLA_TRUE | COLA_FALSE;

inline_code             : '{' AT_LANGUAGE '=' string_value INLINE_CODE '}'
                          -> ^(AT_LANGUAGE string_value INLINE_CODE)
                          ;

//for parsing only
ARRAY         : '__array';
MEMBER        : '__member';

// COLA Keywords
ACTION        : 'action';
ATTRIBUTE     : 'attribute';
CONTRACT      : 'contract';
ELEMENT       : 'element';
FACILITY      : 'facility';
FUNCTION      : 'function';
INV           : 'inv';
ITEM          : 'item';
MANDATORY     : 'mandatory';
NOT_DEF       : 'not_def';
OPTIONAL      : 'optional';
PACKAGE       : 'package';
PARAMETER     : 'parameter';
POST          : 'post';
PRE           : 'pre';
PROPERTY      : 'property';
REQUIRED      : 'required';
STRUCT        : 'struct';
TYPEDEF       : 'typedef';

// COLA Keywords -> @@@
AT_ALTERABLE       : '@alterable';
AT_APPLY           : '@apply';
AT_CLEVEL          : '@clevel';
AT_CONTAINS        : '@contains';
AT_DESCRIPTION     : '@description';
AT_ENVIRONMENT     : '@environment';
AT_EXTENDS         : '@extends';
AT_LANGUAGE        : '@language';
AT_NEGOTIABLE      : '@negotiable';
AT_PRIORITY        : '@priority';
AT_PROVIDES        : '@provides';
AT_RANK            : '@rank';
AT_REQUIRES        : '@requires';
AT_RETURN          : '@return';
AT_RUNTIME         : '@runtime';
AT_SCOPE           : '@scope';
AT_SPEC            : '@spec';
AT_STAGE           : '@stage';
AT_TYPE            : '@type';
AT_VISIBILITY      : '@visibility';

// COLA Keywords -> TYPES
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

// COLA Keywords -> VALUES
COLA_FALSE    : 'FALSE';
COLA_NULL     : 'NULL';
COLA_TRUE     : 'TRUE';

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

INLINE_CODE   : '<<?' ( options {greedy=false;} : . )* '?>>';

// originally = CPP_FILENAME !
CPP_DIRECTIVE : '#' 'file' ' ' CPP_FILENAME '\r'? '\n' {this.setCppFileandLine($CPP_FILENAME.getText());};
CPP_FILENAME  : '"' (~'"')* '"';
