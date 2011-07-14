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
 * Code Generation ANTLR grammar for Org.SKB.Lang.Cola.Proto
 *
 * @package    org.skb.lang.cola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar colaGen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=colaEbnf;
}

@header
{
  package org.skb.lang.cola.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.lang.cola.proto.ColaPass3_Gen;
  import org.skb.lang.cola.proto.constants.ColaConstants;
  import org.skb.util.ReportManager;
}

@members{
  private ColaPass3_Gen pass;

  public void init() {
    this.pass=new ColaPass3_Gen();
  }
}

a3dsStage               : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
a3dsEnvironment         : 'production' | 'test' | 'demonstrator';
a3dsCLevel              : 'business' | 'system' | 'element';

colaFunction            : ^(FUNCTION id=IDENT par+=colaFunctionParam* bt=base_type ARRAY? ^(AT_LANGUAGE string_value)) {this.pass.atoms.scope.push($id.token);}
                          -> colaFunction(id={$id}, parameter={$par}, ret_type={$bt.text}, ret_array={$ARRAY.text});
colaFunctionParam       : ^(PARAMETER bt=base_type ARRAY? id=IDENT)
                          -> colaFunctionParam(type={$bt.text}, array={$ARRAY.text}, id={$id});

colaPropertyDecl        : ^(PROPERTY id=IDENT ^(AT_TYPE bt=base_type cv=const_value ARRAY?)
                            {this.pass.atoms.scope.push($id.token);}
                            {this.pass.clearPropertyScope();}
                            ^(AT_SCOPE propertyScope*)
                            {LinkedHashMap<String, ArrayList<String>> apply=new LinkedHashMap<String, ArrayList<String>>();}
                            ^(AT_APPLY (^(PRE {apply.put("pre",new ArrayList<String>());apply.get("pre").add("pre");} {apply.put("preList",new ArrayList<String>());} (pre=scoped_name {apply.get("preList").add(this.pass.atoms.getST($pre.text).toString());})*))?
                                       (^(POST {apply.put("post",new ArrayList<String>());apply.get("post").add("post");} {apply.put("postList",new ArrayList<String>());} (post=scoped_name {apply.get("postList").add(this.pass.atoms.getST($post.text).toString());})*))?
                                       (^(INV {apply.put("inv",new ArrayList<String>());apply.get("inv").add("inv");} {apply.put("invList",new ArrayList<String>());} (inv=scoped_name {apply.get("invList").add(this.pass.atoms.getST($inv.text).toString());})*))? )
                            atVisibility? AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            (^(AT_EXTENDS (ext+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))? (^(AT_REQUIRES (req+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                            (^(AT_PRIORITY pbt=base_type pcv=const_value))?
                          )
                          -> colaPropertyDecl(id={$id}, type={$bt.text}, val={$cv.st}, array={$ARRAY.text},
                                              propertyScope={this.pass.propertyScope()},
                                              apply={apply},
                                              aExtends={$ext}, aRequires={$req},
                                              alterable={$AT_ALTERABLE.text}, negotiable={$AT_NEGOTIABLE.text},
                                              priorityBT={$pbt.text}, priorityCV={$pcv.st},
                                              description={$atDescription.st},
                                              misc={this.pass.misc()});
propertyScope           : ^(a=propertyScopeAtom r=propertyScopeRank)
                          {this.pass.addPropertyScope($a.st,$r.st);};

propertyScopeAtom       : (t=PACKAGE | t=ELEMENT | t=FACILITY | t=ACTION | t=ATTRIBUTE | t=PARAMETER) -> template(token={$t}) "<token>";
propertyScopeRank       : (t=REQUIRED | t=MANDATORY | t=OPTIONAL | t=NOT_DEF) -> template(token={$t}) "<token>";

atVisibility            : ^(AT_VISIBILITY ^(AT_SPEC atVisibilityData) ^(AT_RUNTIME atVisibilityData));
atVisibilityData        : '(' 
                          (IDENT? '-' string_value (',' string_value)*)? ';'
                          COLA_TRUE? ';'
                          (IDENT? '+' string_value (',' string_value)*)?
                          ')';

atDescription           : ^(AT_DESCRIPTION string_value)-> template(token={$string_value.text}) "<token>";

colaPropertyDefList     : {this.pass.clearPropDefList();} (lpd+=colaPropertyDef)*
                          -> colaPropertyDefList(property={$lpd});
colaPropertyDef         : ^(PROPERTY id=IDENT sn=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());} (cv+=const_value)*)
                          {this.pass.addPropDefList($id.text);}
                          -> colaPropertyDef(sn={$sn.text}, array={this.pass.propertyDefIsArray($cv)}, id={$id.text}, type={this.pass.getPropDefBaseType(this.pass.sn.toString())}, val={$cv}, misc={this.pass.misc()});

colaContractDecl        : ^(CONTRACT id=IDENT
                            {this.pass.atoms.scope.push($id.token);}
                            {this.pass.clearPropertyScope();}
                            ^(AT_SCOPE contractScope*) atVisibility? atDescription
                            (items+=contractItem {this.pass.atoms.scope.pop();})+
                          )
                          -> colaContractDecl(id={$id}, contractScope={this.pass.propertyScope()}, description={$atDescription.st}, items={$items}, misc={this.pass.misc()});
contractScope           : a=contractScopeAtom r=contractScopeRank
                          {this.pass.addPropertyScope($a.st,$r.st);};
contractScopeAtom       : (t=ELEMENT | t=FACILITY) -> template(token={$t}) "<token>";
contractScopeRank       : (t=REQUIRED | t=MANDATORY | t=OPTIONAL | t=NOT_DEF) -> template(token={$t}) "<token>";

contractItem            : ^(ITEM id=IDENT
                           {this.pass.atoms.scope.push($id.token);}
                           (single+=contractItemProp {this.pass.atoms.scope.pop();})+)
                          -> contractItem(id={$id}, property={$single}, misc={this.pass.misc()});
contractItemProp        : ^(PROPERTY id=IDENT
                            {this.pass.atoms.scope.push($id.token);}
                            ^(AT_TYPE bt=base_type cv=const_value ARRAY?)
                             ipr=contractItemPropRank
                            {LinkedHashMap<String, ArrayList<String>> apply=new LinkedHashMap<String, ArrayList<String>>();}
                            ^(AT_APPLY (^(PRE {apply.put("pre",new ArrayList<String>());apply.get("pre").add("pre");} {apply.put("preList",new ArrayList<String>());} (pre=scoped_name {apply.get("preList").add(this.pass.atoms.getST($pre.text).toString());})*))?
                                       (^(POST {apply.put("post",new ArrayList<String>());apply.get("post").add("post");} {apply.put("postList",new ArrayList<String>());} (post=scoped_name {apply.get("postList").add(this.pass.atoms.getST($post.text).toString());})*))?
                                       (^(INV {apply.put("inv",new ArrayList<String>());apply.get("inv").add("inv");} {apply.put("invList",new ArrayList<String>());} (inv=scoped_name {apply.get("invList").add(this.pass.atoms.getST($inv.text).toString());})*))? )
                             AT_ALTERABLE? AT_NEGOTIABLE? atDescription
                            (^(AT_PRIORITY pbt=base_type pcv=const_value))?)
                          -> contractItemProp(id={$id}, type={$bt.text}, val={$cv.st}, array={$ARRAY.text}, rank={$ipr.text}, apply={apply},
                                              alterable={$AT_ALTERABLE.text}, negotiable={$AT_NEGOTIABLE.text}, description={$atDescription.st},
                                              priorityBT={$pbt.text}, priorityCV={$pcv.st}, misc={this.pass.misc()}
                             );

contractItemPropRank    : (s=REQUIRED | s=MANDATORY | s=OPTIONAL);

colaContractDefList     : (lcd+=colaContractDef)*
                          -> colaContractDefList(contract={$lcd}, misc={this.pass.misc()});
colaContractDef         : ^(CONTRACT id=IDENT scoped_name items+=colaContractItemDef*)
                          -> colaContractDef(id={$id.text}, scoped_name={$scoped_name.st}, items={$items}, misc={this.pass.misc()});
colaContractItemDef     : id=IDENT def+=colaItemDef*
                          -> colaContractItemDef(id={$id.text}, properties={$def}, misc={this.pass.misc()});
colaItemDef             : ^(IDENT id=IDENT val+=const_value*)
                          -> colaItemDef(id={$id.text}, val={$val}, misc={this.pass.misc()});

colaSpecification @init{this.init();}
                        : ^(AT_SPEC stage=a3dsStage env=a3dsEnvironment clevel=a3dsCLevel ^(AT_LANGUAGE lang=IDENT)
                          ^(AT_SPEC s=IDENT
                           {StringTemplate spec=templateLib.getInstanceOf("colaSpecification");
                            spec.setAttribute("stage", $stage.text);
                            spec.setAttribute("environment", $env.text);
                            spec.setAttribute("clevel", $clevel.text);
                            spec.setAttribute("language", $lang.text);
                            spec.setAttribute("spec", $s);
                            this.pass.atoms.addST(ColaConstants.Tokens.colaSPECIFICATION,spec);
                           })
                           cpp_directive (def+=colaDefinition)*
                          )
                          -> template(specification={spec}, token={$def}) "<specification>\n\n<token>";
colaDefinition          : colaFunction {this.pass.addST($colaFunction.st);} -> template(token={$colaFunction.st}) "<token>" |
                          colaPropertyDecl {this.pass.addST($colaPropertyDecl.st);} -> template(token={$colaPropertyDecl.st}) "<token>" |
                          colaContractDecl {this.pass.addST($colaContractDecl.st);} -> template(token={$colaContractDecl.st}) "<token>" |
                          colaPackage {this.pass.addST($colaPackage.st);} -> template(token={$colaPackage.st}) "<token>" |
                          colaElement {this.pass.addST($colaElement.st);} -> template(token={$colaElement.st}) "<token>" |
                          colaFacility {this.pass.addST($colaFacility.st);} -> template(token={$colaFacility.st}) "<token>" |
                          colaTypeDef {this.pass.addST($colaTypeDef.st);} -> template(token={$colaTypeDef.st}) "<token>" |
                          colaStruct {this.pass.addST($colaStruct.st);} -> template(token={$colaStruct.st}) "<token>" |
                          cpp_directive;

cpp_directive           : CPP_DIRECTIVE;

colaPackage             : ^(PACKAGE id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=colaPropertyDefList (def+=colaDefinition)* (ic+=inline_code)*)
                          -> colaPackage(id={$id}, properties={$lpd.st}, inline_code={$ic}, misc={this.pass.misc()});

colaElement             : ^(ELEMENT id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=colaPropertyDefList lcd=colaContractDefList atVisibility?
                             (^(AT_EXTENDS  (ext+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                             (^(AT_PROVIDES (pro+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                             (^(AT_REQUIRES (req+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                             elementBody*
                          )
                          -> colaElement(id={$id}, properties={$lpd.st}, contracts={$lcd.st}, aExtends={$ext}, aProvides={$pro}, aRequires={$req}, misc={this.pass.misc()});
elementBody             : elementContains | colaAttribute {this.pass.addST($colaAttribute.st);} | colaAction  {this.pass.addST($colaAction.st);} | inline_code {this.pass.addST($inline_code.st);};
elementContains         : ^(AT_CONTAINS IDENT scoped_name);

colaFacility            : ^(FACILITY id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=colaPropertyDefList lcd=colaContractDefList atVisibility?
                             (^(AT_EXTENDS  (ext+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                             (^(AT_REQUIRES (req+=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());})*))?
                             facilityBody*
                          )
                          -> colaFacility(id={$id}, properties={$lpd.st}, contracts={$lcd.st}, aExtends={$ext}, aRequires={$req}, misc={this.pass.misc()});
facilityBody            : colaAttribute {this.pass.addST($colaAttribute.st);} | colaAction {this.pass.addST($colaAction.st);};

colaAction              : ^(ACTION id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type? (void_type {this.pass.simple_typeVoid();})? lpd=colaPropertyDefList (colaParameter {this.pass.addST($colaParameter.st);})* (ic+=inline_code)*)
                          -> colaAction(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, misc={this.pass.misc()}, inline_code={$ic});
colaParameter           : ^(PARAMETER id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type lpd=colaPropertyDefList)
                          -> colaParameter(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, misc={this.pass.misc()});

//colaAction              : ^(ACTION id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type? (void_type {this.pass.simple_typeVoid();})? lpd=colaPropertyDefList (params+=colaParameter)* (ic+=inline_code)*)
//                          -> colaAction(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, parameter={$params},  misc={this.pass.misc()}, inline_code={$ic});
//colaParameter           : ^(PARAMETER id=IDENT simple_type lpd=colaPropertyDefList)
//                          -> colaParameter(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, misc={this.pass.misc()});
colaTypeDef             : ^(TYPEDEF id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type lpd=colaPropertyDefList (ic+=inline_code)*)
                          -> colaTypeDef(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, inline_code={$ic}, propertiesInstances={this.pass.getPropDefList()}, misc={this.pass.misc()});
colaAttribute           : ^(ATTRIBUTE id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type lpd=colaPropertyDefList (ic+=inline_code)*)
                          -> colaAttribute(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, inline_code={$ic}, misc={this.pass.misc()});

colaStruct              : ^(STRUCT id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=colaPropertyDefList (colaMember {this.pass.addST($colaMember.st);})* (ic+=inline_code)*)
                          -> colaStruct(id={$id}, properties={$lpd.st}, inline_code={$ic}, misc={this.pass.misc()});
colaMember              : ^(MEMBER id=IDENT {this.pass.atoms.scope.push($id.token);} simple_type lpd=colaPropertyDefList)
                          -> colaMember(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, misc={this.pass.misc()});

//colaStruct              : ^(STRUCT id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=colaPropertyDefList (mem+=colaMember)* (ic+=inline_code)*)
//                          -> colaStruct(id={$id}, properties={$lpd.st}, member={$mem}, inline_code={$ic}, misc={this.pass.misc()});
//colaMember              : ^(MEMBER id=IDENT simple_type lpd=colaPropertyDefList)
//                          -> colaMember(id={$id}, type={this.pass.simple_type()}, properties={$lpd.st}, misc={this.pass.misc()});

scoped_name             : {this.pass.sn.clear();}
                          ^(AT_SCOPE (id+=IDENT {this.pass.sn.push(id.token);})*) -> scoped_name(id={$id}, add={this.pass.scopeTgtLangAdd()});

void_type               : t=VOID -> template(token={$t}) "<token>";
simple_type             : {this.pass.simple_typeClear();}
                          ((sc=scoped_name {this.pass.atoms.addImport(this.pass.sn.toString());}) | bt=base_type) ARRAY?
                          {this.pass.simple_type($sc.st,$bt.text,$ARRAY.text);};
base_type               : SHORT | INTEGER | LONG | OCTET | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN;

const_value             : ^(AT_PROVIDES type=INTEGER cv=VAL_INTEGER) -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=OCTET   cv=VAL_OCT)     -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=HEX     cv=VAL_HEX)     -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=BINARY  cv=VAL_BINARY)  -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=FLOAT   cv=VAL_FLOAT)   -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=CHAR    cv=VAL_CHAR)    -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=STRING  string_value)   -> const_value(type={$type.text}, val={$string_value.text}) |
                          ^(AT_PROVIDES type=BOOLEAN boolean_value)  -> const_value(type={$type.text}, val={$boolean_value.text});
string_value            : (VAL_STRING | COLA_NULL);
boolean_value           : (COLA_TRUE | COLA_FALSE);

inline_code             : ^(AT_LANGUAGE string_value ic=INLINE_CODE)
                          -> inline_code(language={this.pass.inline_codeLanguage($string_value.text)}, code={this.pass.inline_code($ic.text)})
                          ;