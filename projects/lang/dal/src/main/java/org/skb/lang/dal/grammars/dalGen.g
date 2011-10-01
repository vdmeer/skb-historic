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
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
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
  import org.skb.lang.dal.constants.DalConstants;
}

@members{
  private DalPass3_Gen pass;

  private String curRepo;
  private String curTable;
  private LinkedHashMap<String, List<StringTemplate>> tmpKV;

  public void init() {
    this.pass=new DalPass3_Gen();
    this.tmpKV=new LinkedHashMap<String, List<StringTemplate>>();
  }
}

/*
 * dalSpecification/Definition == Start of every DAL spec
 */
dalSpecification               @init{this.init();}
                             : ^(AT_SPEC cpp_directive* dalDefinition);
cpp_directive                : CPP_DIRECTIVE;
dalDefinition                : dalRepository {this.pass.addST($dalRepository.st);}
                               cpp_directive*
                               (dalPackage {this.pass.addST($dalPackage.st);})*;


/*
 * dalRepository == All Meta-Meta data on fields for different tables
 */
dalRepository                : ^(DAL_REPOSITORY id=IDENT
                                 {this.pass.atoms.scope.push($id.token);}
                                 {this.curRepo=$id.text;}
                                 (tables+=dalTable {this.pass.atoms.scope.pop();})*)
                                 {this.curRepo=null;}
                               -> dalRepository(ident={$id.text}, tables={$tables});
dalTable                     : ^(DAL_TABLE id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 (fields+=dalField)* dalSequence
                               )
                               ->dalTable(ident={$id.text}, fields={this.pass.sequenceFields(this.curRepo, $id.text, $fields)}, sequence={$dalSequence.st});
dalField                     : ^(DAL_FIELD id=IDENT type=base_type
                                 {this.pass.addFieldName(id.token);}
                                 {ArrayList<StringTemplate> cons=new ArrayList<StringTemplate>();}
                                 {ArrayList<StringTemplate> others=new ArrayList<StringTemplate>();}
                                 dalFieldValue?
                                 (dalFieldPrimkey {cons.add($dalFieldPrimkey.st);})?
                                 (dalFieldNotnull {cons.add($dalFieldNotnull.st);})?
                                 (dalFieldUnique {cons.add($dalFieldUnique.st);})?
                                 dalFieldSize? dalFieldPrecision?
                                 (dalFieldDefval {others.add($dalFieldDefval.st);})?
                                 (dalFieldCollate {others.add($dalFieldCollate.st);})?
                               )
                               -> dalField(ident={$id.text}, type={$type.text}, constraints={cons}, size={$dalFieldSize.st}, precision={$dalFieldPrecision.st}, others={others});

dalFieldValue                : ^(DAL_SETVALUE VAL_STRING*);
dalFieldSize                 : ^(DAL_SIZE VAL_INTEGER)       -> template(token={$VAL_INTEGER}) "<token>";
dalFieldPrecision            : ^(DAL_PRECISION VAL_INTEGER)  -> template(token={$VAL_INTEGER}) "<token>";
dalFieldCollate              : ^(DAL_COLLATE VAL_STRING)     -> template(token={$VAL_STRING}) "<token>";
dalFieldDefval               : ^(DAL_DEFVAL const_value)     -> template(token={$const_value.st}) "<token>";
dalFieldNotnull              : ^(reason=DAL_NOTNUL (action=DAL_ROLLBACK)? (action=DAL_ABORT)?)
                               -> dalFieldConstraint(reason={$reason.text}, action={$action.text});
dalFieldPrimkey              : ^(reason=DAL_PRIMKEY (action=DAL_ROLLBACK)? (action=DAL_ABORT)?)
                               -> dalFieldConstraint(reason={$reason.text}, action={$action.text});
dalFieldUnique               : ^(reason=DAL_UNIQUE (action=DAL_ROLLBACK)? (action=DAL_ABORT)?)
                               -> dalFieldConstraint(reason={$reason.text}, action={$action.text});

dalSequence                  : ^(DAL_SEQUENCE IDENT
                                 (
                                   id+=IDENT
                                   {this.pass.addToSequence(id.token);}
                                 )*
                               )
                               -> dalSequence(keys={$id});


dalPackage                   : ^(DAL_PACKAGE id=IDENT cpp_directive*
                                   {this.curRepo=$id.text;}
                                   {this.pass.atoms.scope.push($id.token);}
                                   dalPackageRepository {this.pass.addST($dalPackageRepository.st);}
                                   (dalTable {this.pass.addST($dalTable.st);})*
                                   (dalActions {this.pass.addST($dalActions.st);})*
                                   (dalData {this.pass.addST($dalData.st);})*
                                 )
                                 {this.curRepo=null;}
                               ->dalPackage(ident={$id.text});


dalPackageRepository         : ^(DAL_REPOSITORY repo=IDENT
                                 {this.pass.atoms.scope.push($repo.token);}
                                 (tables+=dalPackageRepositoryTable)*
                               )
                               -> dalPackageRepository(ident={$repo.text}, tables={$tables});
dalPackageRepositoryTable    : ^(DAL_TABLE table=IDENT (kvs+=dalPackageRepositoryRow)*)
                               -> dalPackageRepositoryTable(ident={$table.text}, rows={$kvs});
dalPackageRepositoryRow      : ^(DAL_ROW id=IDENT
                                 {this.tmpKV.clear();}
                                 dalPackageRepositoryRowKV*
                               )
                               -> dalPackageRepositoryRow(ident={$id.text}, kv={this.pass.fixKV(this.tmpKV)});
dalPackageRepositoryRowKV    : ^(DAL_ROW id=IDENT (cv+=const_value)*)
                               {this.tmpKV.put($id.text, $cv);}
                               ;


dalActions                   : ^(s=DAL_ACTIONS id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 (dalActionsInsert {this.pass.addST($dalActionsInsert.st);})*
                                 (dalActionsAdd {this.pass.addST($dalActionsAdd.st);})*
                                 (dalActionsRemove {this.pass.addST($dalActionsRemove.st);})*
                                 (dalActionsEmpty {this.pass.addST($dalActionsEmpty.st);})*
                               )
                               -> dalActions();

dalActionsInsert             : ^(DAL_ACTION_INSERT id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 table=dalTableIdent {this.tmpKV.clear();} dalKV*
                               )
                               -> dalActionsInsert(table={$table.st}, kvl={this.pass.fixKV(this.tmpKV)});
dalActionsAdd                : ^(DAL_ACTION_ADD id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 table=dalTableIdent {this.tmpKV.clear();} dalKV key=string_value
                               )
                               -> dalActionsAdd(table={$table.st}, kv={this.pass.fixKV(this.tmpKV)}, key={$key.text});
dalActionsRemove             : ^(DAL_ACTION_REMOVE id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 table=dalTableIdent {this.tmpKV.clear();} dalKV?
                               )
                               -> dalActionsRemove(table={$table.st}, kv={this.pass.fixKV(this.tmpKV)});
dalActionsEmpty              : ^(DAL_ACTION_EMPTY id=IDENT {this.pass.atoms.scope.push($id.token);}
                                 table=dalTableIdent
                               )
                               ->dalActionsEmpty(table={$table.st});


dalData                      : ^(DAL_DATA id=IDENT {this.pass.atoms.scope.push($id.token);} (rows+=dalDataRow)*)
                               -> dalData(rows={$rows});
dalDataRow                   : ^(DAL_ROW
                                 id=IDENT
                                 table=dalTableIdent
                                 {this.tmpKV.clear();}
                                 dalKV*
                               )
                               -> dalDataRow(table={$table.st}, kvl={this.pass.fixKV(this.tmpKV)});

dalTableIdent                : id=IDENT -> template(token={$id}) "<token>";


dalKV                        : ^(DAL_DATA id=IDENT cv+=const_value)
                               {this.tmpKV.put($id.text, $cv);}
                               ;


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
