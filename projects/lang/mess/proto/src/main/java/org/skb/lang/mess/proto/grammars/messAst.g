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
 * AST ANTLR grammar for Org.SKB.Lang.Mess
 *
 * @package    org.skb.lang.mess.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

tree grammar messAst;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  tokenVocab=messEbnf;
}

@header
{
  package org.skb.lang.mess.proto.grammars;

  import org.skb.util.classic.config.Configuration;
  import org.skb.lang.mess.proto.MessPass2_Ast;
  import org.skb.tribe.TribeHelpers;
  import org.skb.lang.mess.proto.MessParser;
  import org.skb.lang.mess.proto.constants.MessConstants;
}

@members{
  public static Configuration config=Configuration.getConfiguration(MessParser.class);

  private String[] myTokens;
  private MessPass2_Ast pass;

  private Token currentExtend=null;

  public void init() {
    this.pass=new MessPass2_Ast();
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


/*
 * messSpecification/Definition == Start of every MESS spec
 */
messSpecification               @init{this.init();}
                             : ^(AT_SPEC messDefinition);

cpp_directive                : s=CPP_DIRECTIVE {this.setCppFile(s.getText());};

messDefinition               : cpp_directive* messDomain (cpp_directive | messContentType | messField | messMessage)*; 

messDomain                   : ^(MESS_DOMAIN
                                 id=IDENT
                                 {this.pass.pushSep(id.token, null);}
                                 {this.pass.popAtom(1);}
                               );

messContentType              : ^(sep=MESS_CONTENT_TYPE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.popAtom(2);}
                                 MIME VAL_STRING
                               );

messField                    : ^(sep=MESS_FIELD id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.popAtom(2);}
                                 mime=IDENT
                                 {this.pass.testIdent(mime.token, sep.token, null);}
                                 VAL_STRING
                               );

messMessage                  : ^(sep=MESS_MESSAGE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 (ext=IDENT
                                  {this.pass.testIdent(ext.token, sep.token, null);}
                                  {this.pass.setExtends(ext.token);}
                                 )?
                                 messMessageChangeDecl* messMessageRequiresDecl* messMessageOptionalDecl*
                                 {this.pass.setExtends(null);}
                                 {this.pass.popAtom(2);}
                               );

messMessageChangeDecl        : ^(sep=MESS_CHANGE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.testIdent(id.token, sep.token, null);}
                                 VAL_STRING
                                 {this.pass.popAtom(2);}
                               );

messMessageRequiresDecl      : ^(sep=MESS_REQUIRES id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.testIdent(id.token, sep.token, null);}
                                 VAL_STRING? MESS_IMMUTABLE?
                                 {this.pass.popAtom(2);}
                               );

messMessageOptionalDecl      : ^(sep=MESS_OPTIONAL id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.testIdent(id.token, sep.token, null);}
                                 VAL_STRING? MESS_IMMUTABLE?
                                 {this.pass.popAtom(2);}
                               );
