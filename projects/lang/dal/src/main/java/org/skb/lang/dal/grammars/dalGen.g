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
 * Code Generation ANTLR grammar for Org.SKB.Lang.Dal
 *
 * @package    org.skb.lang.dal
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar dalGen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=dalEbnf;
}

@header
{
  package org.skb.lang.dal.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.lang.dal.DalPass3_Gen;
  import org.skb.lang.dal.DalTokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private DalPass3_Gen pass;

  public void init() {
    this.pass=new DalPass3_Gen();
  }
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
dalRepository                 : ^(DAL_REPOSITORY id=IDENT dalRepositoryTable*)
                                ;
dalRepositoryTable            : ^(DAL_TABLE id=IDENT
                                  dalRepositoryElement* dalRepositorySequence
                                )
                                //{System.err.println(this.pass.repo.getTableST());}
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

cpp_directive                : CPP_DIRECTIVE;

dalDeclaration               : ^(DAL_DECLARATION id=IDENT
                                   {this.pass.atoms.scope.push(id.token);}
                                   (dalElement     {this.pass.addST($dalElement.st);}     -> template(token={$dalElement.st}) "<token>")*
                                   (dalMetaElement {this.pass.addST($dalMetaElement.st);} -> template(token={$dalMetaElement.st}) "<token>")*
                                   dalSequence
                                )
                               {this.pass.atoms.scope.pop();}
                               ;


dalMetaElement               : ^(DAL_REPOSITORY_ELEMENT id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 (metadata=dalElemMetaData)?
                                 {this.pass.atoms.scope.pop();}
                               )
                               -> dalMetaElement(ident={$id.text}, metadata={$metadata.st})
                               ;

dalElemMetaData              : ^(DAL_ELEMENT_REPOSITORY IDENT dalElementMetaDataKV*);
dalElementMetaDataKV         : ^(AT_PROVIDES dalKey dalValue*);


dalElement                   : ^(DAL_ELEMENT id=IDENT {this.pass.atoms.scope.push($id.token);} type=dalElemPropType prop=dalElemProperties meta=dalElemMetaData?)
                               {this.pass.addMetaElement($id.text, $meta.st);}
                               -> dalElement(ident={$id.text}, type={$type.text}, properties={$prop.st})
                               ;

dalElemProperties            : ^(DAL_ELEMENT_PROPERTIES
                                 (size=dalElemPropSize)?
                                 (prec=dalElemPropPrecision)?
                                 (defv=dalElemPropDefValue)?
                                 (coll=dalElemPropCollate)?
                                 (con+=dalElemPropConstraints)*
                               )
                               -> dalElemProperties(size={$size.text}, precision={$prec.text}, defvalue={$defv.text}, collate={$coll.text}, constraints={$con}); 

dalElemPropType              : base_type;
dalElemPropSize              : ^(DAL_ELEM_PROP_SIZE VAL_INTEGER);
dalElemPropPrecision         : ^(DAL_ELEM_PROP_PRECISION VAL_INTEGER);
dalElemPropDefValue          : ^(DAL_ELEM_PROP_DEFVAL VAL_STRING);
dalElemPropCollate           : ^(DAL_ELEM_PROP_COLLATE VAL_STRING);

dalElemPropConstraints       : ^(AT_PROVIDES res=dalElemPropConstrReason act=dalElemPropConstrAction)
                               -> dalElemPropConstraints(reason={$res.text}, action={$act.text});
dalElemPropConstrReason      : DAL_CONSTRAINT_PKEY | DAL_CONSTRAINT_NNUL | DAL_CONSTRAINT_UNIQUE;
dalElemPropConstrAction      : DAL_CONSTRAINT_ABORT | DAL_CONSTRAINT_ROLLBACK;

dalSequence                  : ^(DAL_SEQUENCE IDENT*);


dalActions                   : ^(s=DAL_ACTIONS {this.pass.atoms.scope.push(s.token);} dalActionsIns* dalActionsSet* dalActionsAdd* dalActionsRem* dalActionsEmp*)
                               {this.pass.atoms.scope.pop();};

dalActionsSet                : DAL_ACTION_SET dalListIdent dalKeyTypeValueList;
dalActionsIns                : DAL_ACTION_INS dalListIdent dalKeyTypeValueList;
dalActionsAdd                : DAL_ACTION_ADD dalListIdent dalElementIdent dalKeyTypeValue;
dalActionsRem                : DAL_ACTION_REM dalListIdent dalKeyIdent;
dalActionsEmp                : DAL_ACTION_EMP dalListIdent;

dalData                      : ^(s=DAL_DATA {this.pass.atoms.scope.push(s.token);} dalDataElement*)
                               {this.pass.atoms.scope.pop();};
dalDataElement               : dalListIdent dalKeyTypeValueList;

dalListIdent                 : IDENT;
dalElementIdent              : IDENT;
dalKeyIdent                  : IDENT;

dalKeyTypeValueList          : ^(AT_PROVIDES dalKeyTypeValue*);
dalKeyTypeValue              : dalKey dalType? dalValue;
dalKey                       : IDENT;
dalType                      : base_type;
dalValue                     : const_value;

void_type               : t=VOID -> template(token={$t}) "<token>";
base_type               : SHORT | INTEGER | LONG | HEX | BINARY | FLOAT | DOUBLE | CHAR | STRING | BOOLEAN;

const_value             : ^(AT_PROVIDES type=INTEGER cv=VAL_INTEGER) -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=HEX     cv=VAL_HEX)     -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=BINARY  cv=VAL_BINARY)  -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=FLOAT   cv=VAL_FLOAT)   -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=CHAR    cv=VAL_CHAR)    -> const_value(type={$type.text}, val={$cv.text}) |
                          ^(AT_PROVIDES type=STRING  string_value)   -> const_value(type={$type.text}, val={$string_value.text}) |
                          ^(AT_PROVIDES type=BOOLEAN boolean_value)  -> const_value(type={$type.text}, val={$boolean_value.text});
string_value            : (VAL_STRING | DAL_NULL);
boolean_value           : (DAL_TRUE | DAL_FALSE);
