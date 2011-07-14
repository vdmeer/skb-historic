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
 * Code Generation ANTLR grammar for Org.SKB.Lang.Pola.Proto
 *
 * @package    org.skb.lang.pola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar polaGen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=polaEbnf;
}

@header
{
  package org.skb.lang.pola.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.pola.proto.PolaPass3_Gen;
  import org.skb.lang.pola.proto.constants.PolaConstants;
  import org.skb.util.ReportManager;
}

@members{
  private AtomList atoms;
  private PolaPass3_Gen pass;

  public void init() {
    this.atoms=AtomList.getInstance();
    this.pass=new PolaPass3_Gen();
  }
}

a3dsStage               : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
a3dsEnvironment         : 'production' | 'test' | 'demonstrator';
a3dsCLevel              : 'business' | 'system' | 'element';

polaSpecification @init{this.init();}
                        : ^(AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^(AT_LANGUAGE IDENT)
                          ^(AT_SPEC id=IDENT
                           {StringTemplate spec=templateLib.getInstanceOf("polaSpecification");
                            spec.setAttribute("id", $id);
                            this.atoms.addST(PolaConstants.Tokens.polaSPECIFICATION,spec);
                           })
                           cpp_directive (def+=polaDefinition)*
                          )
                          -> template(specification={spec}, token={$def}) "<specification>\n\n<token>";
polaDefinition          : managementPolicy {this.pass.addST($managementPolicy.st);} -> template(token={$managementPolicy.st}) "<token>" |
                          cpp_directive
                          ;

cpp_directive           : CPP_DIRECTIVE;

managementPolicy        : ^(POLA_POLICY id=IDENT {this.atoms.scope.push($id.token);} type=managementPolicyType prs=policyRuleStructure)
                          -> managementPolicy(id={$id}, type={$type.st}, prs={prs.st});
managementPolicyType    : d=deonticPolicy -> template(token={$d.text}) "<token>" |
                          m=managementMetaPolicy -> template(token={$m.text}) "<token>";
deonticPolicy           : (t=POLA_DEONT_AUTH | t=POLA_DEONT_EXEM | t=POLA_DEONT_OBLG | t=POLA_DEONT_PROH)
                          -> deonticPolicy(type={$t});
managementMetaPolicy    : (t=POLA_MEPO_DELE | t=POLA_MEPO_REVO)
                          -> managementMetaPolicy(type={$t});


//++MD
policyRuleStructure      : (policyContinuumLevel)? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule;
policyContinuumLevel     : POLA_PC_LEVEL '=' ('business' | 'system' | 'administration' | 'device' 'instance') ';';

ecaPolicyRule            : ^(POLA_RULE_STRUCT_ECA ecaPolicyRuleBody);
ecaPolicyRuleBody        : policyEventStructure* policyConditionStructure* policyActionStructure*;
goalPolicyRule           : POLA_RULE_STRUCT_GOAL;
utilityFunctionPolicyRule: POLA_RULE_STRUCT_UTIL;


//++MD
policyRuleComponentStructure: policyEventStructure | policyConditionStructure | policyActionStructure;

policyEventStructure    : POLA_EVENT policyEventStructureBody*;
policyEventStructureBody: policyEventGroup | policyEvent;
policyEventGroup        : ^(POLA_GROUP IDENT policyEventGroupBody*);
policyEventGroupBody    : policyEventGroup | policyEvent;
policyEvent             : ^(BODY policyEventBody*);
policyEventBody         : policyEventComposite | policyEventAtomic | policyEventNonStd;
policyEventComposite    : ^(POLA_COMPOSITE policyECAInherited policyEvent*);
policyEventAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyEventNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyConditionStructure    : POLA_CONDITION policyConditionStructureBody*;
policyConditionStructureBody: policyConditionGroup | policyCondition;
policyConditionGroup        : ^(POLA_GROUP IDENT policyConditionGroupBody*);
policyConditionGroupBody    : policyConditionGroup | policyCondition;
policyCondition             : ^(BODY policyConditionBody*);
policyConditionBody         : policyConditionComposite | policyConditionAtomic | policyConditionNonStd;
policyConditionComposite    : ^(POLA_COMPOSITE policyECAInherited policyCondition*);
policyConditionAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyConditionNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyActionStructure    : POLA_ACTION policyActionStructureBody*;
policyActionStructureBody: policyActionGroup | policyAction;
policyActionGroup        : ^(POLA_GROUP IDENT policyActionGroupBody*);
policyActionGroupBody    : policyActionGroup | policyAction;
policyAction             : ^(BODY policyActionBody*);
policyActionBody         : policyActionComposite | policyActionAtomic | policyActionNonStd;
policyActionComposite    : ^(POLA_COMPOSITE policyECAInherited policyAction*);
policyActionAtomic       : POLA_ATOMIC policyECAInherited pola_string;
policyActionNonStd       : POLA_NONSTD policyECAInherited pola_string;

policyECAInherited    : ^(POLA_SEQ_NUMER VAL_INTEGER) ^(POLA_HASBEEN_EVALED boolean_value);

pola_string             : VAL_DSTRING;

scoped_name             : {this.pass.sn.clear();}
                          ^(AT_SCOPE (id+=IDENT {this.pass.sn.push(id.token);})*) -> scoped_name(id={$id}, add={this.pass.scopeTgtLangAdd()});

void_type               : t=VOID -> template(token={$t}) "<token>";
simple_type             : {this.pass.simple_typeClear();}
                          (sc=scoped_name | bt=base_type) ARRAY?
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
string_value            : (VAL_STRING | POLA_NULL);
boolean_value           : (POLA_TRUE | POLA_FALSE);
