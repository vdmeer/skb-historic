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
 * AST ANTLR grammar for Org.SKB.Lang.Pola.Proto
 *
 * @package    org.skb.lang.pola.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar polaAst;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  tokenVocab=polaEbnf;
}

@header
{
  package org.skb.lang.pola.proto.grammars;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.pola.proto.PolaPass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.pola.proto.constants.PolaConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private AtomList atoms;
  private PolaPass2_Ast pass;

  public void init() {
    this.atoms=AtomList.getInstance();
    this.pass=new PolaPass2_Ast();
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

a3dsStage               : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
a3dsEnvironment         : 'production' | 'test' | 'demonstrator';
a3dsCLevel              : 'business' | 'system' | 'element';

polaSpecification @init{this.init();}
                        : ^(AT_SPEC a3dsStage a3dsEnvironment a3dsCLevel ^(AT_LANGUAGE IDENT) ^(AT_SPEC IDENT) cpp_directive polaDefinition*);
polaDefinition          : managementPolicy | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {setCppFile(s.getText());};

managementPolicy        : ^(POLA_POLICY IDENT managementPolicyType policyRuleStructure);
managementPolicyType    : deonticPolicy | managementMetaPolicy;
deonticPolicy           : POLA_DEONT_AUTH | POLA_DEONT_EXEM | POLA_DEONT_OBLG | POLA_DEONT_PROH;
managementMetaPolicy    : POLA_MEPO_DELE | POLA_MEPO_REVO;


//++MD
policyRuleStructure      : (policyContinuumLevel)? ecaPolicyRule | goalPolicyRule | utilityFunctionPolicyRule;
policyContinuumLevel     : POLA_PC_LEVEL '=' ('business' | 'system' | 'administration' | 'device' 'instance') ';';

ecaPolicyRule            : ^(POLA_RULE_STRUCT_ECA ecaPolicyRuleBody);
ecaPolicyRuleBody        : policyEventStructure* policyConditionStructure* policyActionStructure*;
goalPolicyRule           : POLA_RULE_STRUCT_GOAL; //PH
utilityFunctionPolicyRule: POLA_RULE_STRUCT_UTIL; //PH


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
string_value            : (value=VAL_STRING | value=POLA_NULL)  {this.pass.setLastCommonValue(value.token);};
boolean_value           : (value=POLA_TRUE  | value=POLA_FALSE) {this.pass.setLastCommonValue(value.token);};
