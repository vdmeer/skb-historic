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
 * AST ANTLR grammar for Org.SKB.Lang.Cola.Proto
 *
 * @package    org.skb.lang.cola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

tree grammar colaAst;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  tokenVocab=colaEbnf;
}

@header
{
  package org.skb.lang.cola.proto.grammars;

  import org.skb.base.config.Configuration;
  import org.skb.lang.cola.proto.ColaPass2_Ast;
  import org.skb.tribe.TribeHelpers;
  import org.skb.lang.cola.proto.ColaParser;
  import org.skb.lang.cola.proto.constants.ColaConstants;
}

@members{
  public static Configuration config=Configuration.getConfiguration(ColaParser.class);

  private String[] myTokens;
  private ColaPass2_Ast pass;

  public void init() {
    this.pass=new ColaPass2_Ast();
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

colaSpecification        @init{this.init();}
                        : ^(AT_SPEC skbSpecificationHeader cpp_directive colaDefinition*);

skbSpecificationHeader  : ^(AT_STAGE VAL_STRING AT_ENVIRONMENT VAL_STRING AT_CLEVEL VAL_STRING AT_LANGUAGE VAL_STRING AT_SPEC VAL_STRING);

colaDefinition          : colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {setCppFile(s.getText());};

colaFunction            : ^(FUNCTION IDENT colaFunctionParam* base_type PARSER_ARRAY? ^(AT_LANGUAGE string_value));

colaFunctionParam       : ^(PARAMETER base_type PARSER_ARRAY? IDENT);

colaPropertyDecl        : ^(PROPERTY id=IDENT ^(AT_TYPE bt=base_type cv=const_value PARSER_ARRAY?)
                            {this.pass.atoms.scope.push(id.token);}
                            {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}
                            ^(AT_SCOPE propertyScope*)
                            ^(AT_APPLY (^(PRE (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                                       (^(POST (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                                       (^(INV (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                            )
                            atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription aExtends? aRequires?
                            (^(AT_PRIORITY bt=base_type cv=const_value))?
                          )
                          {this.pass.atoms.scope.pop();};
propertyScope           : ^(propertyScopeAtom propertyScopeRank);

propertyScopeAtom       : PACKAGE | ELEMENT | FACILITY | ACTION | ATTRIBUTE | PARAMETER;

propertyScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;

aExtends                : ^(AT_EXTENDS (scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaAT_EXTENDS);})*);

aProvides               : ^(AT_PROVIDES (scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaAT_PROVIDES);})*);

aRequires               : ^(AT_REQUIRES (scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaAT_REQUIRES);})*);

atVisibility            : ^(AT_VISIBILITY ^(AT_SPEC atVisibilityData) ^(AT_RUNTIME atVisibilityData));

atVisibilityData        : '(' 
                          (IDENT? '-' string_value (',' string_value)*)? ';'
                          COLA_TRUE? ';'
                          (IDENT? '+' string_value (',' string_value)*)?
                          ')'
                          ;

atDescription           : ^(AT_DESCRIPTION string_value {this.pass.testPropDeclDescription($string_value.tree);});

colaPropertyDefList     : ^(PARSER_PROPERTY_DEF colaPropertyDef*)
                          {this.pass.testPropertyDefList();}
                          ;

colaPropertyDef         : ^(PROPERTY 
                            id=IDENT
                            {this.pass.putAtom(id.token, ColaConstants.Tokens.parserPropertyDefIdent);}
                            {this.pass.popAtom();}
                            scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaPROPERTY);}
                            {int cv=0;}
                            (const_value {this.pass.testPropertyDefConstValue($scoped_name.tree, $const_value.tree); cv++;})*
                            {this.pass.testPropertyDefConstValue($scoped_name.tree, cv);}
                          );

colaContractDecl        : ^(CONTRACT id=IDENT {this.pass.atoms.scope.push(id.token);} ^(AT_SCOPE contractScope*) atVisibility? atDescription
                          contractItem*) {this.pass.atoms.scope.pop();};
contractScope           : contractScopeAtom contractScopeRank;

contractScopeAtom       : ELEMENT | FACILITY;

contractScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;

contractItem            : ^(ITEM id=IDENT {this.pass.atoms.scope.push(id.token);} contractItemProp+) {this.pass.atoms.scope.pop();};

contractItemProp        : ^(PROPERTY id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            ^(AT_TYPE bt=base_type cv=const_value PARSER_ARRAY?)
                            {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}
                            contractItemPropRank
                            ^(AT_APPLY
                              (^(PRE  (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                              (^(POST (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                              (^(INV  (sc=scoped_name {this.pass.testScopedName(sc.tree, ColaConstants.Tokens.colaAT_APPLY);})*))?
                            )
                            AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            (^(AT_PRIORITY bt=base_type cv=const_value))?)
                          {this.pass.atoms.scope.pop();};
contractItemPropRank    : (rank=REQUIRED | rank=MANDATORY | rank=OPTIONAL)
                          {this.pass.addItemDeclaration(rank.token);};

colaContractDefList     : ^(PARSER_CONTRACT_DEF colaContractDef*)
                          {this.pass.testContractDefList();}
                          ;

colaContractDef         : ^(CONTRACT
                            id=IDENT
                            scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaCONTRACT);}
                            {this.pass.putAtom(id.token, ColaConstants.Tokens.parserContractDefIdent);}
                            colaContractItemDef*
                            {this.pass.popAtom();}
                          );

colaContractItemDef     : id=IDENT
                          {this.pass.putAtom(id.token, ColaConstants.Tokens.parserContractDefItemIdent);}
                          colaItemDef*
                          {this.pass.popAtom();}
                          ;

colaItemDef             : ^(prop=IDENT id=IDENT
                            {this.pass.putAtom(prop.token, ColaConstants.Tokens.parserContractDefItemProperty);}
                            {this.pass.putAtom(id.token, ColaConstants.Tokens.parserContractDefItemPropertyIdent);}
                            {this.pass.popAtom();}
                            {int cv=0;}
                            (const_value {this.pass.testItemDefConstValue(prop.token, $const_value.tree); cv++;})*
                            {this.pass.testItemDefConstValue(prop.token, cv);}
                            {this.pass.popAtom();}
                          );

colaPackage             : ^(PACKAGE id=IDENT {this.pass.atoms.scope.push(id.token);}
                            colaPropertyDefList? colaDefinition* inline_code*
                          )
                          {this.pass.atoms.scope.pop();};

colaElement             : ^(ELEMENT id=IDENT {this.pass.atoms.scope.push(id.token);}
                             colaPropertyDefList? colaContractDefList?
                             atVisibility? aExtends? aProvides? aRequires? elementBody*
                          )
                          {this.pass.atoms.scope.pop();};

elementBody             : elementContains | colaAttribute | colaAction | inline_code;

elementContains         : ^(AT_CONTAINS id=IDENT {this.pass.atoms.scope.push(id.token);}
                            scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaAT_CONTAINS);}
                          )
                          {this.pass.atoms.scope.pop();};

colaFacility            : ^(FACILITY id=IDENT {this.pass.atoms.scope.push(id.token);}
                            colaPropertyDefList? colaContractDefList? atVisibility? aExtends? aRequires? facilityBody*
                          )
                          {this.pass.atoms.scope.pop();};

facilityBody            : colaAttribute | colaAction;

colaAction              : ^(ACTION id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            simple_type? void_type? colaPropertyDefList? colaParameter* inline_code*
                          )
                          {this.pass.atoms.scope.pop();};

colaParameter           : ^(PARAMETER id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            simple_type colaPropertyDefList?
                          )
                          {this.pass.atoms.scope.pop();};

colaTypeDef             : ^(TYPEDEF id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            simple_type colaPropertyDefList? inline_code*
                          )
                          {this.pass.atoms.scope.pop();};

colaAttribute           : ^(ATTRIBUTE id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            simple_type colaPropertyDefList? inline_code*
                          )
                          {this.pass.atoms.scope.pop();};

colaStruct              : ^(STRUCT id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            colaPropertyDefList? colaMember* inline_code*
                          )
                          {this.pass.atoms.scope.pop();};

colaMember              : ^(PARSER_MEMBER id=IDENT
                            {this.pass.atoms.scope.push(id.token);}
                            simple_type colaPropertyDefList?
                          )
                          {this.pass.atoms.scope.pop();};

scoped_name             : ^(AT_SCOPE IDENT*);

void_type               : VOID;

simple_type             : (scoped_name {this.pass.testScopedName($scoped_name.tree, ColaConstants.Tokens.colaAT_TYPE);}| base_type) PARSER_ARRAY?;

base_type               : (SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN);

const_value             : ^(AT_PROVIDES INTEGER VAL_INTEGER) |
                          ^(AT_PROVIDES OCTET VAL_OCT)       |
                          ^(AT_PROVIDES HEX VAL_HEX)         |
                          ^(AT_PROVIDES BINARY VAL_BINARY)   |
                          ^(AT_PROVIDES FLOATVAL_FLOAT)      |
                          ^(AT_PROVIDES CHAR VAL_CHAR)       |
                          ^(AT_PROVIDES STRING string_value) |
                          ^(AT_PROVIDES BOOLEAN boolean_value);

string_value            : (VAL_STRING | COLA_NULL);

boolean_value           : (COLA_TRUE  | COLA_FALSE);

inline_code             : ^(AT_LANGUAGE string_value INLINE_CODE);