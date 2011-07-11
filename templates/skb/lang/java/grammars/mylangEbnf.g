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
 * EBNF ANTLR grammar for Org.SKB.Lang.##MyLang##
 *
 * @package    org.skb.lang.##mylang##
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

grammar ##mylang##Ebnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.##mylang##.grammars;

  import java.util.LinkedHashMap;

  import org.skb.lang.##mylang##.##MyLang##Pass1_Ebnf;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.##mylang##.##MyLang##TokensConstants;
  import org.skb.util.ReportManager;
}

@lexer::header
{
  package org.skb.lang.##mylang##.grammars;

  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.##mylang##.##MyLang##TokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private ##MyLang##Pass1_Ebnf pass;
  private Token base_type;
  private boolean isArray=false;

  public void init() {
    this.pass=new ##MyLang##Pass1_Ebnf();
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

skbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
skbEnvironment          : 'production' | 'test' | 'demonstrator';
skbCLevel               : 'business' | 'system' | 'element';

##mylang##Specification         @init{this.init();}
                        : cpp_directive AT_STAGE skbStage ';' AT_ENVIRONMENT skbEnvironment ';' AT_CLEVEL skbCLevel ';' AT_LANGUAGE l=IDENT ';' AT_SPEC s=IDENT ';' {this.pass.atoms.specificationName(s);} ##mylang##Definition* EOF
                          -> ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE $l) ^(AT_SPEC $s) cpp_directive ##mylang##Definition*);
##mylang##Definition          : ##mylang##Package | cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

##mylang##Package             : ##mylang##PropertyDefList? PACKAGE s=IDENT {this.pass.putAtom(s,##MyLang##TokensConstants.##mylang##PACKAGE);}
                          '{' (##mylang##Definition | inline_code)* '}'
                          {this.pass.atoms.scope.pop();}
                          -> ^(PACKAGE IDENT ##mylang##PropertyDefList? ##mylang##Definition* inline_code*)
                          ;

scoped_name             : (s=IDENT ('::' s=IDENT)* '::')? s=IDENT -> ^(AT_SCOPE IDENT*);

simple_type             : (scoped_name | base_type) array?
                          ;
base_type               : (s=SHORT | s=INTEGER | s=STRING)
                          {this.base_type=s;}
                          ;

const_value             : VAL_INTEGER   -> ^(AT_PROVIDES INTEGER VAL_INTEGER)|
                          string_value  -> ^(AT_PROVIDES STRING string_value)|
                          boolean_value -> ^(AT_PROVIDES BOOLEAN boolean_value);
string_value            : VAL_STRING | ##MYLANG##_NULL;

//for parsing only
ARRAY         : '__array';
MEMBER        : '__member';

// ##MYLANG## Keywords
PACKAGE       : 'package';

// ##MYLANG## Keywords -> TYPES
INTEGER       : 'integer';
STRING        : 'string';

// ##MYLANG## Keywords -> VALUES
##MYLANG##_NULL     : 'NULL';


WS            : (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;};
SL_COMMENT    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
ML_COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
VAL_STRING    : '"' ( ESC | ~('\\'|'"') )* '"';

VAL_INTEGER   : ('+' | '-')? ('0' | '1'..'9' '0'..'9'*);

IDENT         : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// originally = CPP_FILENAME !
CPP_DIRECTIVE : '#' 'file' ' ' CPP_FILENAME '\r'? '\n' {this.setCppFileandLine($CPP_FILENAME.getText());};
CPP_FILENAME  : '"' (~'"')* '"';
