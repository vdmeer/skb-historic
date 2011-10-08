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
 * EBNF ANTLR grammar for Org.SKB.Lang.Mess
 *
 * @package    org.skb.lang.mess.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

grammar messEbnf;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header
{
  package org.skb.lang.mess.proto.grammars;

  import java.util.LinkedHashMap;

  import org.skb.base.config.Configuration;
  import org.skb.lang.mess.proto.MessParser;
  import org.skb.lang.mess.proto.MessPass1_Ebnf;
  import org.skb.lang.mess.proto.constants.MessConstants;
  import org.skb.tribe.TribeHelpers;
}

@lexer::header
{
  package org.skb.lang.mess.proto.grammars;

  import org.skb.base.config.Configuration;
  import org.skb.lang.mess.proto.MessParser;
  import org.skb.lang.mess.proto.constants.MessConstants;
}

@members{
  public static Configuration config=Configuration.getConfiguration(MessParser.class);

  private String[] myTokens;
  private MessPass1_Ebnf pass;

  public void init() {
    this.pass=new MessPass1_Ebnf();
    this.myTokens=TribeHelpers.translateTokens(tokenNames, config);
  }

  public void setFilename(String f){
    config.getReportManager().setFileName(f);
  }

  public String getFilename(){
    return config.getReportManager().getFileName();
  }

  private void setCppFile(String cpp){
    String fn=cpp.substring(1,cpp.lastIndexOf(':'));
    fn=fn.replace("file \"","");
    this.setFilename(fn);
  }

  public int  numberOfErrors(){
    return config.getReportManager().noOfErrors();
  }

  public void resetErrors(){
    config.getReportManager().resetNoOfErrors();
  }

  public void displayRecognitionError(String[] tokenNames, RecognitionException re){
    config.getReportManager().error(super.getErrorMessage(re, this.myTokens), re);
  }
}

@lexer::members{
  public static Configuration config=Configuration.getConfiguration(MessParser.class);

  public void setFilename(String f){
    config.getReportManager().setFileName(f);
  }

  public String getFilename(){
    return config.getReportManager().getFileName();
  }

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
 * messSpecification/Definition == Start of every MESS spec
 */
messSpecification              @init{this.init();}
                             : messDefinition EOF
                               -> ^(AT_SPEC messDefinition);

cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

messDefinition               : cpp_directive* messDomain (cpp_directive | messContentType | messField | messMessage)*; 

messDomain                   : MESS_DOMAIN MESS_IS id=IDENT
                               {this.pass.putAtom(id, MessConstants.Tokens.messDOMAIN);}
                               {this.pass.popAtom(1);}
                               -> ^(MESS_DOMAIN IDENT);

messContentType              : sep=MESS_CONTENT_TYPE id=IDENT MIME VAL_STRING
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messCONTENT_TYPE, sep);}
                               {this.pass.popAtom(2);}
                               -> ^(MESS_CONTENT_TYPE IDENT MIME VAL_STRING);

messField                    : sep=MESS_FIELD id=IDENT MESS_AS IDENT MESS_WITH VAL_STRING
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messFIELD, sep);}
                               {this.pass.popAtom(2);}
                               -> ^(MESS_FIELD IDENT IDENT VAL_STRING);

messMessage                  : sep=MESS_MESSAGE id=IDENT
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messMESSAGE, sep);}
                               (MESS_EXTENDS IDENT)?
                               messMessageChangeDecl* messMessageRequiresDecl* messMessageOptionalDecl*
                               {this.pass.popAtom(2);}
                               -> ^(MESS_MESSAGE IDENT IDENT? messMessageChangeDecl* messMessageRequiresDecl* messMessageOptionalDecl*);

messMessageChangeDecl        : sep=MESS_CHANGE id=IDENT
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messFIELD, sep);}
                               MESS_TO VAL_STRING
                               {this.pass.popAtom(2);}
                               -> ^(MESS_CHANGE IDENT VAL_STRING);

messMessageRequiresDecl      : sep=MESS_REQUIRES id=IDENT
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messFIELD, sep);}
                               (MESS_WITH VAL_STRING)? (MESS_IS MESS_IMMUTABLE)?
                               {this.pass.popAtom(2);}
                               -> ^(MESS_REQUIRES IDENT VAL_STRING? MESS_IMMUTABLE?);

messMessageOptionalDecl      : sep=MESS_OPTIONAL id=IDENT
                               {this.pass.putAtomSep(id, MessConstants.Tokens.messFIELD, sep);}
                               (MESS_WITH VAL_STRING)? (MESS_IS MESS_IMMUTABLE)?
                               {this.pass.popAtom(2);}
                               -> ^(MESS_OPTIONAL IDENT VAL_STRING? MESS_IMMUTABLE?);


// MESS Keywords -> @@@
AT_SPEC            : '@spec';

//MESS Keywords -> DAL specific
MESS_CONTENT_TYPE  : 'content-type';
MESS_FIELD         : 'field';
MESS_MESSAGE       : 'message';
MESS_EXTENDS       : 'extends';
MESS_DOMAIN        : 'domain';

MESS_REQUIRES      : 'requires';
MESS_OPTIONAL      : 'optional';
MESS_CHANGE        : 'change';

MESS_IMMUTABLE     : 'immutable';

MESS_AS            : 'as';
MESS_IS            : 'is';
MESS_TO            : 'to';
MESS_WITH          : 'with';

MESS_RUNTIME_API   : 'runtime-api';
MESS_RUNTIME_IMPL  : 'runtime-impl';

WS            : (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;};
SL_COMMENT    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
ML_COMMENT    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};
VAL_STRING    : '"' ( ESC | ~('\\'|'"') )* '"';

fragment ESC  : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | UnicodeEscape | OctalEscape;
fragment
OctalEscape   : '\\' ('0'..'3') ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ('0'..'7') | '\\' ('0'..'7');
fragment
UnicodeEscape : '\\' 'u' HexDigit HexDigit HexDigit HexDigit;

fragment
HexDigit      : ('0'..'9'|'a'..'f'|'A'..'F');
VAL_HEX       : '0' ('x'|'X') HexDigit+;

IDENT         : ('A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*;
MIME          : ('a'..'z') ('a'..'z'|'-'|'+'|'0'..'9')* '/' ('a'..'z') ('a'..'z'|'-'|'+'|'0'..'9')*;

// originally = CPP_FILENAME !
CPP_DIRECTIVE : '#' 'file' ' ' CPP_FILENAME '\r'? '\n' {this.setCppFileandLine($CPP_FILENAME.getText());};
CPP_FILENAME  : '"' (~'"')* '"';
