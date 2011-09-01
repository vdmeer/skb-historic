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
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
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
  import org.skb.lang.dal.constants.DalConstants;
  import org.skb.util.misc.ReportManager;
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
                             : ^(AT_SPEC cpp_directive* dalDefinition);
cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};
dalDefinition                : dalRepository cpp_directive* dalPackage*;


/*
 * dalRepository == All Meta-Meta data on fields for different tables
 */
dalRepository                 : ^(DAL_REPOSITORY
                                  id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  dalTable*
                                  {this.pass.atoms.scope.pop();}
                                )
                                ;
dalTable                      : ^(DAL_TABLE
                                  id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  dalField* dalSequence
                                  {this.pass.atoms.scope.pop();}
                                )
                                ;
dalField                      : ^(DAL_FIELD
                                  id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  base_type
                                  dalFieldValue? dalFieldPrimkey? dalFieldNotnull? dalFieldUnique?
                                  dalFieldSize? dalFieldPrecision? dalFieldDefval? dalFieldCollate?
                                  {this.pass.atoms.scope.pop();}
                                )
                                ;

dalFieldValue                 : ^(DAL_SETVALUE VAL_STRING*);
dalFieldSize                  : ^(DAL_SIZE val=VAL_INTEGER);
dalFieldPrecision             : ^(DAL_PRECISION val=VAL_INTEGER);
dalFieldCollate               : ^(DAL_COLLATE val=VAL_STRING);
dalFieldDefval                : ^(DAL_DEFVAL const_value);
dalFieldNotnull               : ^(DAL_NOTNUL DAL_ROLLBACK? DAL_ABORT?);
dalFieldPrimkey               : ^(DAL_PRIMKEY DAL_ROLLBACK? DAL_ABORT?);
dalFieldUnique                : ^(DAL_UNIQUE DAL_ROLLBACK? DAL_ABORT?);

dalSequence                   : ^(DAL_SEQUENCE id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  (id=IDENT
                                   {this.pass.testAtom(id.token);}
                                   {this.pass.atoms.scope.pop();}
                                  )*
                                  {this.pass.atoms.scope.pop();}
                                )
                                ;


dalPackage                    : ^(DAL_PACKAGE id=IDENT cpp_directive*
                                  {this.pass.testAtom(id.token);}
                                  dalActionsEmpty? dalActionsRemove? dalPackageRepository dalTable* dalActions* dalData*
                                  {this.pass.atoms.scope.pop();}
                                );

dalPackageRepository          : ^(DAL_REPOSITORY
                                  id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  dalPackageRepositoryTable*
                                  {this.pass.atoms.scope.pop();}
                                );
dalPackageRepositoryTable     : ^(DAL_TABLE
                                  id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  dalPackageRepositoryRow*
                                  {this.pass.atoms.scope.pop();}
                                );
dalPackageRepositoryRow       : ^(DAL_ROW id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  dalPackageRepositoryRowKV*
                                  {this.pass.atoms.scope.pop();}
                                );
dalPackageRepositoryRowKV     : ^(DAL_ROW id=IDENT
                                  {this.pass.testAtom(id.token);}
                                  const_value*
                                  {this.pass.atoms.scope.pop();}
                                );


dalActions                   : ^(DAL_ACTIONS id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 dalActionsInsert* dalActionsRemove* dalActionsEmpty*
                                 {this.pass.atoms.scope.pop();}
                               );
dalActionsInsert             : ^(DAL_ACTION_INSERT id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 tabid=dalTableIdent
                                 {this.pass.testAtom(tabid.tree.getToken());}
                                 dalKV*
                                 {this.pass.atoms.scope.pop();}
                                 {this.pass.atoms.scope.pop();}
                               );
dalActionsRemove             : ^(DAL_ACTION_REMOVE id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 tabid=dalTableIdent
                                 {this.pass.testAtom(tabid.tree.getToken());}
                                 dalKV?
                                 {this.pass.atoms.scope.pop();}
                                 {this.pass.atoms.scope.pop();}
                               );
dalActionsEmpty              : ^(DAL_ACTION_EMPTY id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 tabid=dalTableIdent
                                 {this.pass.testAtom(tabid.tree.getToken());}
                                 {this.pass.atoms.scope.pop();}
                                 {this.pass.atoms.scope.pop();}
                               );

dalData                      : ^(DAL_DATA id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 dalDataRow*
                                 {this.pass.atoms.scope.pop();}
                               );
dalDataRow                   : ^(DAL_ROW id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 tabid=dalTableIdent
                                 {this.pass.testAtom(tabid.tree.getToken());}
                                 dalKV*
                                 {this.pass.atoms.scope.pop();}
                                 {this.pass.atoms.scope.pop();}
                               );

dalTableIdent                : IDENT;

dalKV                        : ^(DAL_DATA
                                 id=IDENT
                                 {this.pass.testAtom(id.token);}
                                 const_value
                                 {this.pass.atoms.scope.pop();}
                               );


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