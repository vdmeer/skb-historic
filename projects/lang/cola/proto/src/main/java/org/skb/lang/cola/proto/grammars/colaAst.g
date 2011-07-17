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
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
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

  import org.skb.util.languages.AtomList;
  import org.skb.lang.cola.proto.ColaPass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.cola.proto.constants.ColaConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private ColaPass2_Ast pass;

  public void init() {
    this.pass=new ColaPass2_Ast();
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

skbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
skbEnvironment          : 'production' | 'test' | 'demonstrator';
skbCLevel               : 'business' | 'system' | 'element';

colaFunction            : ^(FUNCTION IDENT colaFunctionParam* base_type ARRAY? ^(AT_LANGUAGE string_value));
colaFunctionParam       : ^(PARAMETER base_type ARRAY? IDENT);

colaPropertyDecl        : ^(PROPERTY s=IDENT ^(AT_TYPE base_type const_value ARRAY?)
                            {this.pass.atoms.scope.push(s.token);}
                            {this.pass.testBaseTypeWithConstValue(ColaConstants.Tokens.colaPROPERTY);}
                            ^(AT_SCOPE propertyScope*)
                            ^(AT_APPLY (^(PRE (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? (^(POST (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? (^(INV (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? )
                            atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            {this.pass.eprStart(ColaConstants.Tokens.colaPROPERTY);} aExtends? aRequires?
                            (^(AT_PRIORITY base_type const_value {this.pass.testBaseTypeWithConstValue(ColaConstants.Tokens.colaAT_PRIORITY);}))?
                          )
                          {this.pass.atoms.scope.pop();};
propertyScope           : ^(propertyScopeAtom propertyScopeRank);
propertyScopeAtom       : PACKAGE | ELEMENT | FACILITY | ACTION | ATTRIBUTE | PARAMETER;
propertyScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;
aExtends                : ^(AT_EXTENDS  {this.pass.eprCategory(ColaConstants.Tokens.colaAT_EXTENDS);}  (scoped_name {this.pass.eprAdd($scoped_name.text);})*);
aProvides               : ^(AT_PROVIDES {this.pass.eprCategory(ColaConstants.Tokens.colaAT_PROVIDES);} (scoped_name {this.pass.eprAdd($scoped_name.text);})*);
aRequires               : ^(AT_REQUIRES {this.pass.eprCategory(ColaConstants.Tokens.colaAT_REQUIRES);} (scoped_name {this.pass.eprAdd($scoped_name.text);})*);

atVisibility            : ^(AT_VISIBILITY ^(AT_SPEC atVisibilityData) ^(AT_RUNTIME atVisibilityData));
atVisibilityData        : '(' 
                          (IDENT? '-' string_value (',' string_value)*)? ';'
                          COLA_TRUE? ';'
                          (IDENT? '+' string_value (',' string_value)*)?
                          ')'
                          ;

atDescription           : ^(AT_DESCRIPTION string_value {this.pass.testPropDeclDescription();});

colaPropertyDef         : ^(PROPERTY IDENT scoped_name {this.pass.propDef(); this.pass.propDefValueStart();}
                          (const_value {this.pass.propDefValueTest();})*) {this.pass.propDefFinish();};

colaContractDecl        : ^(CONTRACT s=IDENT {this.pass.atoms.scope.push(s.token);} ^(AT_SCOPE contractScope*) atVisibility? atDescription
                          contractItem*) {this.pass.atoms.scope.pop();};
contractScope           : contractScopeAtom contractScopeRank;
contractScopeAtom       : ELEMENT | FACILITY;
contractScopeRank       : REQUIRED | MANDATORY | OPTIONAL | NOT_DEF;

contractItem            : ^(ITEM s=IDENT {this.pass.atoms.scope.push(s.token);} contractItemProp+) {this.pass.atoms.scope.pop();};
contractItemProp        : ^(PROPERTY s=IDENT ^(AT_TYPE base_type const_value ARRAY?)
                            {this.pass.atoms.scope.push(s.token);}
                            {this.pass.testBaseTypeWithConstValue(ColaConstants.Tokens.parserItemProp);}
                             contractItemPropRank
                             ^(AT_APPLY (^(PRE (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? (^(POST (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? (^(INV (scoped_name {this.pass.testSN(ColaConstants.Tokens.colaFUNCTION, null);})*))? )
                             AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            (^(AT_PRIORITY base_type const_value {this.pass.testBaseTypeWithConstValue(ColaConstants.Tokens.parserItemProp);}))?)
                          {this.pass.atoms.scope.pop();};
contractItemPropRank    : (s=REQUIRED | s=MANDATORY | s=OPTIONAL);

colaContractDef         : ^(CONTRACT id=IDENT scoped_name {this.pass.contDef();} colaContractItemDef*);
colaContractItemDef     : s=IDENT {this.pass.itemDefListStart(s.token);}colaItemDef* {this.pass.itemDefListFinish();};
colaItemDef             : ^(prop=IDENT s=IDENT {this.pass.itemDef(prop.token); this.pass.itemDefValueStart();}
                          (const_value {this.pass.itemDefValueTest(prop.token);})*) {this.pass.itemDefFinish(prop.token);};

colaSpecification @init{this.init();}
                        : ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE IDENT) ^(AT_SPEC IDENT) cpp_directive colaDefinition*);
colaDefinition          : colaFunction | colaPropertyDecl | colaContractDecl | colaPackage | colaElement | colaFacility | colaTypeDef | colaStruct | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {setCppFile(s.getText());};

colaPackage             : ^(PACKAGE s=IDENT {this.pass.atoms.scope.push(s.token);} {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();} colaDefinition* inline_code*) {this.pass.atoms.scope.pop();};
colaElement             : ^(ELEMENT s=IDENT {this.pass.atoms.scope.push(s.token);}
                             {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();}
                             {this.pass.contDefListStart();} colaContractDef* {this.pass.contDefListFinish();}
                             atVisibility?
                             {this.pass.eprStart(ColaConstants.Tokens.colaELEMENT);} aExtends? aProvides? aRequires?
                             elementBody*
                          ) {this.pass.atoms.scope.pop();};
elementBody             : elementContains | colaAttribute | colaAction | inline_code;
elementContains         : ^(AT_CONTAINS s=IDENT {this.pass.atoms.scope.push(s.token);} scoped_name {this.pass.testSN(ColaConstants.Tokens.colaELEMENT, ColaConstants.Tokens.colaAT_CONTAINS);} {this.pass.atoms.scope.pop();});

colaFacility            : ^(FACILITY s=IDENT {this.pass.atoms.scope.push(s.token);}
                             {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();}
                             {this.pass.contDefListStart();} colaContractDef* {this.pass.contDefListFinish();}
                             atVisibility?
                             {this.pass.eprStart(ColaConstants.Tokens.colaFACILITY);} aExtends? aRequires?
                             facilityBody*
                          ) {this.pass.atoms.scope.pop();};
facilityBody            : colaAttribute | colaAction;

colaAction              : ^(ACTION    s=IDENT {this.pass.atoms.scope.push(s.token);this.pass.sn.clear();} (simple_type {this.pass.testSN(ColaConstants.Tokens.colaACTION, null);})? void_type? {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();} colaParameter* inline_code*) {this.pass.atoms.scope.pop();};
colaParameter           : ^(PARAMETER s=IDENT {this.pass.atoms.scope.push(s.token);this.pass.sn.clear();}  simple_type {this.pass.testSN(ColaConstants.Tokens.colaPARAMETER, null);}           {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();})                             {this.pass.atoms.scope.pop();};
colaTypeDef             : ^(TYPEDEF   s=IDENT {this.pass.atoms.scope.push(s.token);this.pass.sn.clear();}  simple_type {this.pass.testSN(ColaConstants.Tokens.colaTYPEDEF, null);}             {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();}                inline_code*) {this.pass.atoms.scope.pop();};
colaAttribute           : ^(ATTRIBUTE s=IDENT {this.pass.atoms.scope.push(s.token);this.pass.sn.clear();}  simple_type {this.pass.testSN(ColaConstants.Tokens.colaATTRIBUTE, null);}           {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();}                inline_code*) {this.pass.atoms.scope.pop();};
colaStruct              : ^(STRUCT    s=IDENT {this.pass.atoms.scope.push(s.token);}                                                                                        {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();} colaMember*    inline_code*) {this.pass.atoms.scope.pop();};
colaMember              : ^(MEMBER    s=IDENT {this.pass.atoms.scope.push(s.token);this.pass.sn.clear();}  simple_type {this.pass.testSN(ColaConstants.Tokens.parserMEMBER, null);}            {this.pass.propDefListStart();} colaPropertyDef* {this.pass.propDefListFinish();})                             {this.pass.atoms.scope.pop();};

scoped_name             : ^(AT_SCOPE {this.pass.sn.clear();} (s=IDENT {this.pass.sn.push(s.token);})*);

void_type               : VOID;
simple_type             : (scoped_name | base_type) ARRAY?;
base_type               : (s=SHORT | s=INTEGER | s=LONG | s=OCTET | s=HEX | s=BINARY | s=FLOAT | s=DOUBLE | s=CHAR | s=STRING | s=BOOLEAN)
                          {this.pass.setLastBaseType(s.token);};

const_value             : ^(AT_PROVIDES type=INTEGER value=VAL_INTEGER {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=OCTET   value=VAL_OCT     {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=HEX     value=VAL_HEX     {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=BINARY  value=VAL_BINARY  {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=FLOAT   value=VAL_FLOAT   {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=CHAR    value=VAL_CHAR    {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                          ^(AT_PROVIDES type=STRING  string_value      {this.pass.setLastCommonValueType(type.token);})|
                          ^(AT_PROVIDES type=BOOLEAN boolean_value     {this.pass.setLastCommonValueType(type.token);});
string_value            : (value=VAL_STRING | value=COLA_NULL)  {this.pass.setLastCommonValue(value.token);};
boolean_value           : (value=COLA_TRUE  | value=COLA_FALSE) {this.pass.setLastCommonValue(value.token);};

inline_code             : ^(AT_LANGUAGE string_value INLINE_CODE);