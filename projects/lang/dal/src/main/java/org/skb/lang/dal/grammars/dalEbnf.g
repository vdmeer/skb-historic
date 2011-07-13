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
 * EBNF ANTLR grammar for Org.SKB.Lang.Dal
 *
 * @package    org.skb.lang.dal
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.01 build 110309 (09-Mar-11) for ANTLR v3.3
 */

grammar dalEbnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.dal.grammars;

  import java.util.LinkedHashMap;

  import org.skb.lang.dal.DalPass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.dal.DalTokensConstants;
  import org.skb.util.ReportManager;
}

@lexer::header
{
  package org.skb.lang.dal.grammars;

  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.dal.DalTokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private DalPass1_Ebnf pass;
  private Token base_type;
  private Token value;

  private int internalID;

  public void init() {
    this.pass=new DalPass1_Ebnf();
    this.myTokens = new LanguageTokens();
    this.myTokens.addTokens(tokenNames);

    this.internalID=0;
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

@lexer::members{
  public void setFilename(String f){ReportManager.getInstance().setFileName(f);}
  public String getFilename(){return ReportManager.getInstance().getFileName();}

  private void setCppFile(String cpp){
    String fn=cpp.substring(1,cpp.lastIndexOf(':'));
    this.setFilename(fn);
  }
  private void setCppLine(String cpp){
    Integer i=new Integer(cpp.substring(cpp.lastIndexOf(':')+1, cpp.length()-1));
    this.input.setLine(i.intValue());
  }
  private void setCppFileandLine(String cpp){
    setCppFile(cpp);
    setCppLine(cpp);
  }
}

/*
 * dalSpecification/Definition == Start of every DAL spec
 */
dalSpecification               @init{this.init();}
                             : cpp_directive dalDefinition EOF
                               -> ^(AT_SPEC cpp_directive dalDefinition);
cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};
dalDefinition                : dalRepository dalPackage*;


/*
 * dalRepository == All Meta-Meta data on fields for different tables
 */
dalRepository                 : DAL_REPOSITORY id=IDENT 
                                {this.pass.putAtom(id,DalTokensConstants.dalREPOSITORY);}
                                {this.pass.tables.curRepoSet(id);}
                                '{' dalTable* '}'
                                {this.pass.atoms.scope.pop();}
                                {this.pass.tables.curRepoClear();}
                                -> ^(DAL_REPOSITORY IDENT dalTable*);
dalTable                      : DAL_TABLE id=IDENT
                                {this.pass.putAtom(id,DalTokensConstants.dalTABLE);}
                                {this.pass.tables.curTableSet(id);}
                                '{' dalField* dalSequence '}'
                                {this.pass.atoms.scope.pop();}
                                {this.pass.tables.curTableClear();}
                                -> ^(DAL_TABLE IDENT dalField* dalSequence);
//field IDENT TYPE value(VALUE) primkey(abort) notnull(abort) unique(abort) size(2) precision(1) defval("") collate("");
dalField                      : DAL_FIELD id=IDENT base_type
                                {this.pass.putAtom(id,DalTokensConstants.dalFIELD, this.base_type);}
                                {this.pass.tables.curTableAddField(id, this.base_type);}
                                dalFieldValue?
                                dalFieldPrimkey? dalFieldNotnull? dalFieldUnique? 
                                (dalFieldSize dalFieldPrecision?)? dalFieldDefval? dalFieldCollate?
                                ';'
                                {this.pass.atoms.scope.pop();}
                                {this.pass.tables.curFieldClear();}
                                -> ^(DAL_FIELD IDENT base_type dalFieldValue? dalFieldPrimkey? dalFieldNotnull? dalFieldUnique? dalFieldSize? dalFieldPrecision? dalFieldDefval? dalFieldCollate?);

dalFieldValue                 : DAL_VALUE '(' (DAL_EXPR_AND | DAL_EXPR_OR | DAL_EXPR_XOR | DAL_EXPR_NOR | DAL_EXPR_NAND | DAL_EXPR_LIST) VAL_STRING* ')'
                                -> ^(DAL_VALUE VAL_STRING*);
dalFieldSize                  : DAL_SIZE  '(' VAL_INTEGER ')'
                                -> ^(DAL_SIZE VAL_INTEGER);
dalFieldPrecision             : DAL_PRECISION '(' VAL_INTEGER ')'
                                -> ^(DAL_PRECISION VAL_INTEGER);
dalFieldCollate               : DAL_COLLATE '(' VAL_STRING ')'
                                -> ^(DAL_COLLATE VAL_STRING);
dalFieldDefval                : DAL_DEFVAL '(' const_value ')'
                                -> ^(DAL_DEFVAL const_value);
dalFieldNotnull               : DAL_NOTNUL '(' (DAL_ROLLBACK | DAL_ABORT) ')'
                                -> ^(DAL_NOTNUL DAL_ROLLBACK? DAL_ABORT?);
dalFieldPrimkey               : DAL_PRIMKEY '(' (DAL_ROLLBACK | DAL_ABORT) ')'
                                -> ^(DAL_PRIMKEY DAL_ROLLBACK? DAL_ABORT?);
dalFieldUnique                : DAL_UNIQUE '(' (DAL_ROLLBACK | DAL_ABORT) ')'
                                -> ^(DAL_UNIQUE DAL_ROLLBACK? DAL_ABORT?);

dalSequence                   : s=DAL_SEQUENCE 
                                {this.pass.putAtom(s,DalTokensConstants.dalSEQUENCE);}
                                '{' ( (id=IDENT {this.pass.tables.curTableSequenceAdd(id);}) (',' (id=IDENT {this.pass.tables.curTableSequenceAdd(id);}))*)? '}'
                                {this.pass.atoms.scope.pop();}
                                 -> ^(DAL_SEQUENCE IDENT*);


dalPackage                    : DAL_PACKAGE id=IDENT
                                {this.pass.putAtom(id,DalTokensConstants.dalPACKAGE);}
                                {this.pass.tables.curRepoSet(id);}
                                '{' dalActionsEmpty? dalActionsRemove? dalPackageRepository* dalTable* dalActions* dalData* '}'
                                {this.pass.atoms.scope.pop();}
                                {this.pass.tables.curRepoClear();}
                                -> ^(DAL_PACKAGE IDENT dalActionsEmpty? dalActionsRemove? dalPackageRepository* dalTable* dalActions* dalData*);

dalPackageRepository          : DAL_REPOSITORY IDENT DAL_TABLE IDENT '{' dalPackageRepositoryRow* '}'
                                -> ^(DAL_REPOSITORY IDENT IDENT dalPackageRepositoryRow*);
dalPackageRepositoryRow       : DAL_ROW IDENT dalPackageRepositoryRowKV* ';'
                                -> ^(DAL_ROW IDENT dalPackageRepositoryRowKV*);
dalPackageRepositoryRowKV     : IDENT '=' const_value* -> ^(DAL_ROW IDENT const_value*);

dalActions                   : DAL_ACTIONS
                               id=dalActionsID
                               {this.pass.putAtom(id.tree.getToken(),DalTokensConstants.dalACTIONS);}
                               (dalActionsInsert | dalActionsRemove | dalActionsEmpty)* '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ACTIONS dalActionsID dalActionsInsert* dalActionsRemove* dalActionsEmpty*);

dalActionsID                 : '{' -> ^({new CommonTree(new CommonToken(IDENT,"internal"+Integer.toString(this.internalID++)))});

dalActionsInsert             : DAL_ACTION_INSERT
                               id=internalID
                               {this.pass.putAtom(id.tree.getToken(),DalTokensConstants.dalACTIONS);}
                               dalTableIdent dalKV*
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ACTION_INSERT internalID dalTableIdent dalKV*);
dalActionsRemove             : DAL_ACTION_REMOVE
                               id=internalID
                               {this.pass.putAtom(id.tree.getToken(),DalTokensConstants.dalACTIONS);}
                               dalTableIdent dalKV?
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ACTION_REMOVE internalID dalTableIdent dalKV?);
dalActionsEmpty              : DAL_ACTION_EMPTY
                               id=internalID
                               {this.pass.putAtom(id.tree.getToken(),DalTokensConstants.dalACTIONS);}
                               dalTableIdent
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ACTION_EMPTY internalID dalTableIdent);

dalData                      : s=DAL_DATA
                               {this.pass.putAtom(s,DalTokensConstants.dalDATA);}
                               '{' dalDataRow* '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_DATA dalDataRow*);
dalDataRow                   : id=internalID
                               {this.pass.putAtom(id.tree.getToken(),DalTokensConstants.dalROW);}
                               dalTableIdent dalKV*
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ROW internalID dalTableIdent dalKV*);

dalTableIdent                : IDENT;

internalID                   : DAL_TABLE -> ^({new CommonTree(new CommonToken(IDENT,"internal"+Integer.toString(this.internalID++)))});

dalKV                        : '{' IDENT const_value '}' -> ^(DAL_DATA IDENT const_value);

base_type               : (s=SHORT | s=INTEGER | s=LONG | s=HEX | s=BINARY | s=FLOAT | s=DOUBLE | s=CHAR | s=STRING | s=BOOLEAN)
                          {this.base_type=s;}
                          ;

const_value             : VAL_INTEGER   -> ^(AT_PROVIDES INTEGER VAL_INTEGER)|
                          VAL_HEX       -> ^(AT_PROVIDES HEX VAL_HEX)|
                          VAL_BINARY    -> ^(AT_PROVIDES BINARY VAL_BINARY)|
                          VAL_FLOAT     -> ^(AT_PROVIDES FLOAT VAL_FLOAT)|
                          VAL_CHAR      -> ^(AT_PROVIDES CHAR VAL_CHAR)|
                          string_value  -> ^(AT_PROVIDES STRING string_value)|
                          boolean_value -> ^(AT_PROVIDES BOOLEAN boolean_value);
string_value            : VAL_STRING | DAL_NULL;
boolean_value           : DAL_TRUE | DAL_FALSE;

// DAL Keywords


// DAL Keywords -> @@@
AT_PROVIDES        : '@provides';
AT_SPEC            : '@spec';

//DAL Keywords -> DAL specific
DAL_TABLE              : 'table';
DAL_REPOSITORY         : 'repository';
DAL_SEQUENCE           : 'sequence';

DAL_FIELD              : 'field';
DAL_VALUE              : 'value';
DAL_PRECISION          : 'precision';
DAL_SIZE               : 'size';
DAL_COLLATE            : 'collate';
DAL_DEFVAL             : 'defval';
DAL_ABORT              : 'abort';
DAL_NOTNUL             : 'notnull';
DAL_PRIMKEY            : 'primkey';
DAL_ROLLBACK           : 'rollback';
DAL_UNIQUE             : 'unique';
DAL_ROW                : 'row';
DAL_ACTIONS            : 'actions';
DAL_DATA               : 'data';
DAL_PACKAGE            : 'package';

DAL_EXPR_AND           : 'and';
DAL_EXPR_OR            : 'or';
DAL_EXPR_XOR           : 'xor';
DAL_EXPR_NOR           : 'nor';
DAL_EXPR_NAND          : 'nand';
DAL_EXPR_LIST          : 'list';

DAL_ACTION_EMPTY       : 'empty';
DAL_ACTION_REMOVE      : 'remove';
DAL_ACTION_INSERT      : 'insert';


// DAL Keywords -> TYPES
BINARY        : 'binary';
BOOLEAN       : 'boolean';
CHAR          : 'char';
DOUBLE        : 'double';
FLOAT         : 'float';
HEX           : 'hex';
INTEGER       : 'integer';
LONG          : 'long';
SHORT         : 'short';
STRING        : 'string';
VOID          : 'void';

// DAL Keywords -> VALUES
DAL_FALSE    : 'false';
DAL_NULL     : 'null';
DAL_TRUE     : 'true';

WS            : (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;};
SL_COMMENT    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
ML_COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
VAL_CHAR      : '\'' ( ESC | ~('\''|'\\') ) '\'';
VAL_STRING    : '"' ( ESC | ~('\\'|'"') )* '"';

fragment ESC  : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | UnicodeEscape | OctalEscape;
fragment
OctalEscape   : '\\' ('0'..'3') ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ('0'..'7') | '\\' ('0'..'7');
fragment
UnicodeEscape : '\\' 'u' HexDigit HexDigit HexDigit HexDigit;

fragment
HexDigit      : ('0'..'9'|'a'..'f'|'A'..'F');
VAL_HEX       : '0' ('x'|'X') HexDigit+;

VAL_INTEGER   : ('+' | '-')? ('0' | '1'..'9' '0'..'9'*);

fragment
BinDigit      : ('0' | '1');
VAL_BINARY    : ('b' | 'B') (BinDigit)+;

fragment
Exponent      : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;
fragment
FloatSuffix   : ('f'|'F'|'d'|'D') ;
VAL_FLOAT     :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatSuffix?
                | '.' ('0'..'9')+ Exponent? FloatSuffix?
                | ('0'..'9')+ Exponent FloatSuffix?
                | ('0'..'9')+ Exponent? FloatSuffix
                ;

IDENT         : ('a'..'z') ('a'..'z'|':'|'_'|'.'|'0'..'9')*;

// originally = CPP_FILENAME !
CPP_DIRECTIVE : '#' 'file' ' ' CPP_FILENAME '\r'? '\n' {this.setCppFileandLine($CPP_FILENAME.getText());};
CPP_FILENAME  : '"' (~'"')* '"';
