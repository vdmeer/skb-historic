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

skbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
skbEnvironment          : 'production' | 'test' | 'demonstrator';
skbCLevel               : 'business' | 'system' | 'element';

colaSpecification        @init{this.init();}
                        : ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE IDENT) ^(AT_SPEC IDENT) cpp_directive colaDefinition*);

colaDefinition          : colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {setCppFile(s.getText());};

colaFunction            : ^(FUNCTION IDENT colaFunctionParam* base_type ARRAY? ^(AT_LANGUAGE string_value));

colaFunctionParam       : ^(PARAMETER base_type ARRAY? IDENT);

colaPropertyDecl        : ^(PROPERTY s=IDENT ^(AT_TYPE bt=base_type cv=const_value ARRAY?)
                            {this.pass.atoms.scope.push(s.token);}
                            {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}
                            ^(AT_SCOPE propertyScope*)
                            ^(apply=AT_APPLY (^(PRE (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                                       (^(POST (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                                       (^(INV (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                            )
                            atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription aExtends? aRequires?
                            (^(AT_PRIORITY bt=base_type cv=const_value {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}))?
                          )
                          {this.pass.atoms.scope.pop();};
propertyScope           : ^(propertyScopeAtom propertyScopeRank);

propertyScopeAtom       : PACKAGE | ELEMENT | FACILITY | ACTION | ATTRIBUTE | PARAMETER;

propertyScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;

aExtends                : ^(atextends=AT_EXTENDS (scoped_name {this.pass.testScopedName($scoped_name.tree, atextends.token);})*);

aProvides               : ^(atprovides=AT_PROVIDES (scoped_name {this.pass.testScopedName($scoped_name.tree, atprovides.token);})*);

aRequires               : ^(atrequires=AT_REQUIRES (scoped_name {this.pass.testScopedName($scoped_name.tree, atrequires.token);})*);

atVisibility            : ^(AT_VISIBILITY ^(AT_SPEC atVisibilityData) ^(AT_RUNTIME atVisibilityData));

atVisibilityData        : '(' 
                          (IDENT? '-' string_value (',' string_value)*)? ';'
                          COLA_TRUE? ';'
                          (IDENT? '+' string_value (',' string_value)*)?
                          ')'
                          ;

atDescription           : ^(AT_DESCRIPTION string_value {this.pass.testPropDeclDescription($string_value.tree);});

colaPropertyDefList     : ^(PROPERTY_DEF colaPropertyDef*)
                          {this.pass.testPropertyDefList();}
                          ;

colaPropertyDef         : ^(prop=PROPERTY 
                            id=IDENT
                            {this.pass.testPropDefIdent(id.token);}
                            scoped_name {this.pass.testScopedName($scoped_name.tree, prop.token);}
                            {int cv=0;}
                            (const_value {this.pass.testPropertyDefConstValue($scoped_name.tree, $const_value.tree); cv++;})*
                            {this.pass.testPropertyDefConstValue($scoped_name.tree, cv);}
                          );

colaContractDecl        : ^(CONTRACT s=IDENT {this.pass.atoms.scope.push(s.token);} ^(AT_SCOPE contractScope*) atVisibility? atDescription
                          contractItem*) {this.pass.atoms.scope.pop();};
contractScope           : contractScopeAtom contractScopeRank;

contractScopeAtom       : ELEMENT | FACILITY;

contractScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;

contractItem            : ^(ITEM s=IDENT {this.pass.atoms.scope.push(s.token);} contractItemProp+) {this.pass.atoms.scope.pop();};

contractItemProp        : ^(PROPERTY s=IDENT ^(AT_TYPE bt=base_type cv=const_value ARRAY?)
                            {this.pass.atoms.scope.push(s.token);}
                            {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}
                            contractItemPropRank
                            ^(apply=AT_APPLY
                              (^(PRE  (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                              (^(POST (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                              (^(INV  (sc=scoped_name {this.pass.testScopedName(sc.tree, apply.token);})*))?
                            )
                            AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            (^(AT_PRIORITY bt=base_type cv=const_value {this.pass.testBaseTypeAndConstValue(bt.tree.getToken(), cv.tree);}))?)
                          {this.pass.atoms.scope.pop();};
contractItemPropRank    : (s=REQUIRED | s=MANDATORY | s=OPTIONAL);

colaContractDefList     : ^(CONTRACT_DEF colaContractDef*)
                          {this.pass.testContractDefList();}
                          ;

colaContractDef         : ^(cont=CONTRACT
                          id=IDENT
                          {this.pass.testContDefIdent(id.token);}
                          scoped_name {this.pass.testScopedName($scoped_name.tree, cont.token);}
                          colaContractItemDef*);

colaContractItemDef     : s=IDENT {this.pass.itemDefListStart(s.token);} colaItemDef* {this.pass.itemDefListFinish();};

colaItemDef             : ^(prop=IDENT s=IDENT {this.pass.itemDef(prop.token); this.pass.itemDefValueStart();}
                          (const_value {this.pass.itemDefValueTest(prop.token);})*) {this.pass.itemDefFinish(prop.token);};

colaPackage             : ^(PACKAGE s=IDENT {this.pass.atoms.scope.push(s.token);} colaPropertyDefList? colaDefinition* inline_code*) {this.pass.atoms.scope.pop();};

colaElement             : ^(ELEMENT s=IDENT {this.pass.atoms.scope.push(s.token);}
                             colaPropertyDefList? colaContractDefList?
                             atVisibility? aExtends? aProvides? aRequires? elementBody*
                          )
                          {this.pass.atoms.scope.pop();};

elementBody             : elementContains | colaAttribute | colaAction | inline_code;

elementContains         : ^(contains=AT_CONTAINS s=IDENT {this.pass.atoms.scope.push(s.token);} scoped_name {this.pass.testScopedName($scoped_name.tree, contains.token);} {this.pass.atoms.scope.pop();});

colaFacility            : ^(FACILITY s=IDENT {this.pass.atoms.scope.push(s.token);}
                             colaPropertyDefList? colaContractDefList? atVisibility? aExtends? aRequires? facilityBody*
                          ) {this.pass.atoms.scope.pop();};

facilityBody            : colaAttribute | colaAction;

colaAction              : ^(ACTION    s=IDENT {this.pass.atoms.scope.push(s.token);} (simple_type {this.pass.testSimpleType($simple_type.tree);})? void_type? colaPropertyDefList? colaParameter* inline_code*) {this.pass.atoms.scope.pop();};

colaParameter           : ^(PARAMETER s=IDENT {this.pass.atoms.scope.push(s.token);}  simple_type {this.pass.testSimpleType($simple_type.tree);}              colaPropertyDefList?)                             {this.pass.atoms.scope.pop();};

colaTypeDef             : ^(TYPEDEF   s=IDENT {this.pass.atoms.scope.push(s.token);}  simple_type {this.pass.testSimpleType($simple_type.tree);}              colaPropertyDefList?                inline_code*) {this.pass.atoms.scope.pop();};

colaAttribute           : ^(ATTRIBUTE s=IDENT {this.pass.atoms.scope.push(s.token);}  simple_type {this.pass.testSimpleType($simple_type.tree);}              colaPropertyDefList?                inline_code*) {this.pass.atoms.scope.pop();};

colaStruct              : ^(STRUCT    s=IDENT {this.pass.atoms.scope.push(s.token);}                                                                          colaPropertyDefList? colaMember*    inline_code*) {this.pass.atoms.scope.pop();};

colaMember              : ^(MEMBER    s=IDENT {this.pass.atoms.scope.push(s.token);}  simple_type {this.pass.testSimpleType($simple_type.tree);}              colaPropertyDefList?)                             {this.pass.atoms.scope.pop();};

scoped_name             : ^(AT_SCOPE IDENT*);

void_type               : VOID;

simple_type             : (scoped_name | base_type) ARRAY?;

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