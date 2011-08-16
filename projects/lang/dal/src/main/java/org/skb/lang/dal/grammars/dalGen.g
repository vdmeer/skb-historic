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
  import org.skb.lang.dal.constants.DalConstants;
  import org.skb.util.misc.ReportManager;
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
                                 (tables+=dalTable)*)
                                 {this.curRepo=null;}
                               -> dalRepository(ident={$id.text}, tables={$tables});
dalTable                     : ^(DAL_TABLE id=IDENT (fields+=dalField)* dalSequence)
                               ->dalTable(ident={$id.text}, fields={this.pass.sequenceFields(this.curRepo, $id.text, $fields)});
dalField                     : ^(DAL_FIELD id=IDENT type=base_type
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
                               -> dalSequence(ids={$id});


dalPackage                   : ^(DAL_PACKAGE id=IDENT cpp_directive*
                                 {this.curRepo=$id.text;}
                                 {this.pass.atoms.scope.push($id.token);}
                                 dalActionsEmpty? dalActionsRemove?
                                 dalPackageRepository
                                 {this.pass.addST($dalPackageRepository.st);}
                                 (tables+=dalTable)* (actions+=dalActions)* (data+=dalData)*)
                                 {this.curRepo=null;}
                               ->dalPackage(ident={$id.text}, empty={$dalActionsEmpty.st}, tables={$tables}, actions={$actions}, data={$data});


dalPackageRepository         : ^(DAL_REPOSITORY repo=IDENT
                                 {this.pass.atoms.scope.push($repo.token);}
                                 (tables+=dalPackageRepositoryTable)*
                               )
                               -> dalPackageRepository(repo={$repo.text}, tables={$tables});
dalPackageRepositoryTable    : ^(DAL_TABLE table=IDENT (kvs+=dalPackageRepositoryRow)*)
                               -> dalPackageRepositoryTable(table={$table.text}, kv={$kvs});
dalPackageRepositoryRow      : ^(DAL_ROW IDENT
                                 {this.tmpKV.clear();}
                                 dalPackageRepositoryRowKV*
                               )
                               -> dalPackageRepositoryRow(kv={this.pass.fixKV(this.tmpKV)});
dalPackageRepositoryRowKV    : ^(DAL_ROW id=IDENT (cv+=const_value)*)
                               {this.tmpKV.put($id.text, $cv);}
                               ;


dalActions                   : ^(s=DAL_ACTIONS IDENT (insert+=dalActionsInsert)* (remove+=dalActionsRemove)* (empty+=dalActionsEmpty)*)
                               -> dalActions(insert={$insert}, remove={$remove}, empty={$empty});

dalActionsInsert             : ^(DAL_ACTION_INSERT IDENT table=dalTableIdent {this.tmpKV.clear();} dalKV*)
                               -> dalActionsInsert(table={$table.st}, kvl={this.pass.fixKV(this.tmpKV)});
dalActionsRemove             : ^(DAL_ACTION_REMOVE IDENT table=dalTableIdent {this.tmpKV.clear();} dalKV?)
                               -> dalActionsRemove(table={$table.st}, kv={this.pass.fixKV(this.tmpKV)});
dalActionsEmpty              : ^(DAL_ACTION_EMPTY IDENT table=dalTableIdent)
                               ->dalActionsEmpty(table={$table.st});


dalData                      : ^(DAL_DATA IDENT (rows+=dalDataRow)*)
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
