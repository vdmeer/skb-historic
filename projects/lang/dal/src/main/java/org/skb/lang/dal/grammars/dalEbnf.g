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

  public void init() {
    this.pass=new DalPass1_Ebnf();
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
dalDefinition                : dalRepository dalPackage*;


/*
 * dalRepository == All Meta-Meta data on fields for different tables
 */
dalRepository                 : DAL_REPOSITORY id=IDENT
                                {this.pass.putAtom(id,DalTokensConstants.DAL_REPOSITORY);}
                                {this.pass.repo.currentRepo(id);}
                                '{' dalRepositoryTable* '}'
                                {this.pass.atoms.scope.pop();}
                                -> ^(DAL_REPOSITORY IDENT dalRepositoryTable*);
dalRepositoryTable            : DAL_TABLE id=IDENT
                                {this.pass.putAtom(id,DalTokensConstants.DAL_TABLE);}
                                {this.pass.repo.currentRepoTable(id);}
                                '{' dalRepositoryElement* {this.pass.repo.currentRepoElement();}
                                    (dalRepositorySequence {this.pass.repo.checkSequence();})?
                                '}'
                                {this.pass.repo.currentRepoTable();}
                                {this.pass.atoms.scope.pop();}
                                -> ^(DAL_TABLE IDENT dalRepositoryElement* dalRepositorySequence);
dalRepositoryElement          : DAL_REPOSITORY_ELEMENT id=IDENT type=dalElemPropType
                                {this.pass.repo.addRepoElement(id, this.base_type);}
                                dalRepositoryElementValue?
                                -> ^(DAL_REPOSITORY_ELEMENT IDENT dalElemPropType dalRepositoryElementValue?);
dalRepositoryElementValue     : '(' (s=DAL_EXPR_AND | s=DAL_EXPR_OR | s=DAL_EXPR_XOR | s=DAL_EXPR_NOR | s=DAL_EXPR_NAND | s=DAL_EXPR_LIST)
                                    {this.pass.repo.addRepoElementValueExpr(s);}
                                    (val=VAL_STRING {this.pass.repo.addRepoElementValue(val);})*
                                ')'
                                ;

dalRepositorySequence         : DAL_SEQUENCE '{' (id=IDENT {this.pass.repo.addToSequence(id);}
                                (',' (id=IDENT {this.pass.repo.addToSequence(id);}))*)? '}'
                                 -> ^(DAL_SEQUENCE IDENT*);




dalPackage                   : DAL_PACKAGE s=IDENT
                               {this.pass.putAtom(s,DalTokensConstants.DAL_PACKAGE);}
                               '{' dalDeclaration* dalActions* dalData* '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_PACKAGE IDENT dalDeclaration* dalActions* dalData*);

cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

dalDeclaration               : DAL_DECLARATION id=IDENT
                               {this.pass.putAtom(id,DalTokensConstants.DAL_DECLARATION);}
                               '{' dalElement+ dalMetaElement* dalSequence '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_DECLARATION IDENT dalElement* dalMetaElement* dalSequence);

dalMetaElement               : DAL_REPOSITORY_ELEMENT id=IDENT
                               {this.pass.putAtom(id,DalTokensConstants.DAL_REPOSITORY_ELEMENT);}
                               '{' dalElemMetaData? '}'
                               {this.pass.atoms.scope.pop();}
                               ->  ^(DAL_REPOSITORY_ELEMENT IDENT dalElemMetaData?);

dalElement                   : DAL_ELEMENT id=IDENT dalElemPropType
                               {this.pass.putAtom(id,DalTokensConstants.DAL_ELEMENT, this.base_type);}
                               '{' dalElemProperties dalElemMetaData? '}'
                               {this.pass.atoms.scope.pop();}
                               ->  ^(DAL_ELEMENT IDENT dalElemPropType dalElemProperties dalElemMetaData?);

dalElemProperties            : DAL_ELEMENT_PROPERTIES '{'
                                 (dalElemPropSize dalElemPropPrecision?)? dalElemPropDefValue?
                                 dalElemPropCollate? dalElemPropConstraints*
                               '}'
                               -> ^(DAL_ELEMENT_PROPERTIES dalElemPropSize? dalElemPropPrecision? dalElemPropDefValue? dalElemPropCollate? dalElemPropConstraints*); 
dalElemPropType              : base_type;
dalElemPropSize              : DAL_ELEM_PROP_SIZE '='      VAL_INTEGER -> ^(DAL_ELEM_PROP_SIZE VAL_INTEGER);
dalElemPropPrecision         : DAL_ELEM_PROP_PRECISION '=' VAL_INTEGER -> ^(DAL_ELEM_PROP_PRECISION VAL_INTEGER);
dalElemPropDefValue          : DAL_ELEM_PROP_DEFVAL '='    VAL_STRING  -> ^(DAL_ELEM_PROP_DEFVAL VAL_STRING);
dalElemPropCollate           : DAL_ELEM_PROP_COLLATE '='   VAL_STRING  -> ^(DAL_ELEM_PROP_COLLATE VAL_STRING);

dalElemPropConstraints       : dalElemPropConstrReason '=' dalElemPropConstrAction
                               -> ^(AT_PROVIDES dalElemPropConstrReason dalElemPropConstrAction);
dalElemPropConstrReason      : DAL_CONSTRAINT_PKEY | DAL_CONSTRAINT_NNUL | DAL_CONSTRAINT_UNIQUE;
dalElemPropConstrAction      : DAL_CONSTRAINT_ABORT | DAL_CONSTRAINT_ROLLBACK;

dalElemMetaData              : DAL_ELEMENT_REPOSITORY id=IDENT '{'
                                 {this.pass.putAtom(id,DalTokensConstants.DAL_ELEMENT_REPOSITORY);}
                                 dalElementMetaDataKV*
                                 {this.pass.atoms.scope.pop();}
                               '}'
                               -> ^(DAL_ELEMENT_REPOSITORY IDENT dalElementMetaDataKV*);
dalElementMetaDataKV         : dalKey '=' dalValue* -> ^(AT_PROVIDES dalKey dalValue*);

dalSequence                   : DAL_SEQUENCE '{' (IDENT (',' IDENT)*)? '}'
                                -> ^(DAL_SEQUENCE IDENT*);

dalActions                   : s=DAL_ACTIONS
                               {this.pass.putAtom(s,DalTokensConstants.DAL_ACTIONS);}
                               '{' (dalActionsSet | dalActionsIns | dalActionsAdd | dalActionsRem | dalActionsEmp)* '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_ACTIONS dalActionsIns* dalActionsSet* dalActionsAdd* dalActionsRem* dalActionsEmp*);

dalActionsSet                : DAL_ACTION_SET dalListIdent dalKeyTypeValueList;
dalActionsIns                : DAL_ACTION_INS dalListIdent dalKeyTypeValueList;
dalActionsAdd                : DAL_ACTION_ADD dalListIdent dalElementIdent dalKeyTypeValue;
dalActionsRem                : DAL_ACTION_REM dalListIdent dalKeyIdent;
dalActionsEmp                : DAL_ACTION_EMP dalListIdent;

dalData                      : s=DAL_DATA
                               {this.pass.putAtom(s,DalTokensConstants.DAL_DATA);}
                               '{' dalDataElement* '}'
                               {this.pass.atoms.scope.pop();}
                               -> ^(DAL_DATA dalDataElement*);
dalDataElement               : dalListIdent dalKeyTypeValueList;

dalListIdent                 : IDENT;
dalElementIdent              : IDENT;
dalKeyIdent                  : IDENT;

dalKeyTypeValueList          : ('{' dalKeyTypeValue '}')* -> ^(AT_PROVIDES dalKeyTypeValue*);
dalKeyTypeValue              : dalKey dalType? dalValue;
dalKey                       : IDENT;
dalType                      : base_type;
dalValue                     : const_value;


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
DAL_TABLE              : 'dal:table';
DAL_REPOSITORY         : 'dal:repository';
DAL_REPOSITORY_ELEMENT : 'dal:repository:element';
DAL_SEQUENCE           : 'dal:sequence';

DAL_EXPR_AND           : 'and';
DAL_EXPR_OR            : 'or';
DAL_EXPR_XOR           : 'xor';
DAL_EXPR_NOR           : 'nor';
DAL_EXPR_NAND          : 'nand';
DAL_EXPR_LIST          : 'list';

DAL_ACTION_ADD         : 'dal:action:add';
DAL_ACTION_EMP         : 'dal:action:emp';
DAL_ACTION_INS         : 'dal:action:ins';
DAL_ACTION_REM         : 'dal:action:rem';
DAL_ACTION_SET         : 'dal:action:set';
DAL_ACTIONS            : 'dal:actions';
DAL_CONSTRAINT_ABORT   : 'dal:constraint:abort';
DAL_CONSTRAINT_NNUL    : 'dal:constraint:nnull';
DAL_CONSTRAINT_PKEY    : 'dal:constraint:pkey';
DAL_CONSTRAINT_ROLLBACK: 'dal:constraint:rollback';
DAL_CONSTRAINT_UNIQUE  : 'dal:constraint:unique';
DAL_DATA               : 'dal:data';
DAL_DECLARATION        : 'dal:declaration';
DAL_ELEM_PROP_COLLATE  : 'dal:elem:prop:collate';
DAL_ELEM_PROP_DEFVAL   : 'dal:elem:prop:def_val';
DAL_ELEM_PROP_PRECISION: 'dal:elem:prop:precision';
DAL_ELEM_PROP_SIZE     : 'dal:elem:prop:size';
DAL_ELEMENT            : 'dal:element';
DAL_ELEMENT_REPOSITORY : 'dal:element:repository';
DAL_ELEMENT_PROPERTIES : 'dal:element:properties';
DAL_PACKAGE            : 'dal:package';


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
