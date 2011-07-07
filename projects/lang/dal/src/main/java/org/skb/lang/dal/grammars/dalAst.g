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
 * AST ANTLR grammar for Org.SKB.Lang.Dal
 *
 * @package    org.skb.lang.dal
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar dalAst;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  tokenVocab=dalEbnf;
}

@header
{
  package org.skb.lang.dal.grammars;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.dal.DalPass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.dal.DalTokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private DalPass2_Ast pass;

  public void init() {
    this.pass=new DalPass2_Ast();
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


/*
 * dalSpecification/Definition == Start of every DAL spec
 */
dalSpecification               @init{this.init();}
                             : ^(AT_SPEC cpp_directive dalDefinition);
dalDefinition                : dalRepository dalPackage*;


/*
 * dalRepository == All Meta-Meta data on fields for different tables
 */
dalRepository                 : ^(DAL_REPOSITORY id=IDENT {this.pass.atoms.scope.push(id.token);} dalRepositoryTable*)
                                {this.pass.atoms.scope.pop();}
                                ;
dalRepositoryTable            : ^(DAL_TABLE id=IDENT {this.pass.atoms.scope.push(id.token);}
                                  dalRepositoryElement* dalRepositorySequence
                                )
                                //{System.err.println(this.pass.repo.getTableST());}
                                {this.pass.atoms.scope.pop();}
                                ;
dalRepositoryElement          : ^(DAL_REPOSITORY_ELEMENT IDENT dalElemPropType dalRepositoryElementValue?)
                                ;
dalRepositoryElementValue     : '(' (s=DAL_EXPR_AND | s=DAL_EXPR_OR | s=DAL_EXPR_XOR | s=DAL_EXPR_NOR | s=DAL_EXPR_NAND | s=DAL_EXPR_LIST)
                                    VAL_STRING*
                                ')';

dalRepositorySequence        : ^(DAL_SEQUENCE IDENT*);



dalPackage                   : ^(DAL_PACKAGE id=IDENT {this.pass.atoms.scope.push(id.token);} dalDeclaration* dalActions* dalData*)
                               {this.pass.atoms.scope.pop();}
                               ;

cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

dalDeclaration               : ^(DAL_DECLARATION id=IDENT
                                   {this.pass.atoms.scope.push(id.token);}
                                   dalElement* dalMetaElement* dalSequence
                                )
                               {this.pass.atoms.scope.pop();}
                               ;


dalMetaElement               : ^(DAL_REPOSITORY_ELEMENT id=IDENT
                                   {this.pass.atoms.scope.push(id.token);}
                                   dalElemMetaData?
                               )
                               {this.pass.atoms.scope.pop();}
                               ;

dalElement                   : ^(DAL_ELEMENT id=IDENT
                                   {this.pass.atoms.scope.push(id.token);}
                                   dalElemPropType dalElemProperties dalElemMetaData?
                               )
                               {this.pass.atoms.scope.pop();}
                               ;

dalElemProperties            : ^(DAL_ELEMENT_PROPERTIES dalElemPropSize? dalElemPropPrecision? dalElemPropDefValue? dalElemPropCollate? dalElemPropConstraints*); 
dalElemPropType              : base_type;
dalElemPropSize              : ^(DAL_ELEM_PROP_SIZE VAL_INTEGER);
dalElemPropPrecision         : ^(DAL_ELEM_PROP_PRECISION VAL_INTEGER);
dalElemPropDefValue          : ^(DAL_ELEM_PROP_DEFVAL VAL_STRING);
dalElemPropCollate           : ^(DAL_ELEM_PROP_COLLATE VAL_STRING);

dalElemPropConstraints       : ^(AT_PROVIDES dalElemPropConstrReason dalElemPropConstrAction);
dalElemPropConstrReason      : DAL_CONSTRAINT_PKEY | DAL_CONSTRAINT_NNUL | DAL_CONSTRAINT_UNIQUE;
dalElemPropConstrAction      : DAL_CONSTRAINT_ABORT | DAL_CONSTRAINT_ROLLBACK;


dalElemMetaData              : ^(DAL_ELEMENT_REPOSITORY id=IDENT
                                 {this.pass.atoms.scope.push(id.token);}
                                 dalElementMetaDataKV*
                                 {this.pass.atoms.scope.pop();}
                               );
dalElementMetaDataKV         : ^(AT_PROVIDES dalKey dalValue*);

dalSequence                  : ^(DAL_SEQUENCE (id=IDENT {this.pass.addElemSequence(id.token);})*)
                               {this.pass.testElemSequence();}
                               ;

dalActions                   : ^(DAL_ACTIONS dalActionsIns* dalActionsSet* dalActionsAdd* dalActionsRem* dalActionsEmp*);

dalActionsSet                : DAL_ACTION_SET dalListIdent dalKeyTypeValueList
                               {this.pass.atoms.scope.pop();}
                               ;
dalActionsIns                : DAL_ACTION_INS dalListIdent dalKeyTypeValueList
                               {this.pass.atoms.scope.pop();}
                               ;
dalActionsAdd                : DAL_ACTION_ADD dalListIdent dalElementIdent dalKeyTypeValue
                               {this.pass.atoms.scope.pop();}
                               ;
dalActionsRem                : DAL_ACTION_REM dalListIdent dalKeyIdent
                               {this.pass.atoms.scope.pop();}
                               ;
dalActionsEmp                : DAL_ACTION_EMP dalListIdent
                               {this.pass.atoms.scope.pop();}
                               ;

dalData                      : ^(DAL_DATA dalDataElement*);
dalDataElement               : dalListIdent dalKeyTypeValueList
                               {this.pass.atoms.scope.pop();}
                               ;

dalListIdent                 : id=IDENT
                               {this.pass.atoms.scope.push(id.token);}
                               {this.pass.testList(id.token);}
                               ;
dalElementIdent              : IDENT;
dalKeyIdent                  : IDENT;

dalKeyTypeValueList          : ^(AT_PROVIDES dalKeyTypeValue*);
dalKeyTypeValue              : dalKey dalType? dalValue;
dalKey                       : s=IDENT
                               {this.pass.testKey(s.token);}
                               ;
dalType                      : base_type;
dalValue                     : const_value;

void_type                    : VOID;
base_type                    : (s=SHORT | s=INTEGER | s=LONG | s=HEX | s=BINARY | s=FLOAT | s=DOUBLE | s=CHAR | s=STRING | s=BOOLEAN)
                               {this.pass.setLastBaseType(s.token);};

const_value                  : ^(AT_PROVIDES type=INTEGER value=VAL_INTEGER {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                               ^(AT_PROVIDES type=HEX     value=VAL_HEX     {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                               ^(AT_PROVIDES type=BINARY  value=VAL_BINARY  {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                               ^(AT_PROVIDES type=FLOAT   value=VAL_FLOAT   {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                               ^(AT_PROVIDES type=CHAR    value=VAL_CHAR    {this.pass.setLastCommonValuePlusType(value.token,type.token);}) |
                               ^(AT_PROVIDES type=STRING  string_value      {this.pass.setLastCommonValueType(type.token);})|
                               ^(AT_PROVIDES type=BOOLEAN boolean_value     {this.pass.setLastCommonValueType(type.token);});
string_value                 : (value=VAL_STRING | value=DAL_NULL)  {this.pass.setLastCommonValue(value.token);};
boolean_value                : (value=DAL_TRUE  | value=DAL_FALSE) {this.pass.setLastCommonValue(value.token);};