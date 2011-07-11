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
 * AST ANTLR grammar for Org.SKB.Lang.##MyLang##
 *
 * @package    org.skb.lang.##mylang##
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar ##mylang##Ast;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  tokenVocab=##mylang##Ebnf;
}

@header
{
  package org.skb.lang.##mylang##.grammars;

  import org.skb.util.languages.AtomList;
  import org.skb.lang.##mylang##.##MyLang##Pass2_Ast;
  import org.skb.tribe.LanguageTokens;
  import org.skb.lang.##mylang##.##MyLang##TokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private LanguageTokens myTokens;
  private ##MyLang##Pass2_Ast pass;

  public void init() {
    this.pass=new ##MyLang##Pass2_Ast();
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

skbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
skbEnvironment          : 'production' | 'test' | 'demonstrator';
skbCLevel               : 'business' | 'system' | 'element';

##mylang##Specification @init{this.init();}
                        : ^(AT_SPEC skbStage skbEnvironment skbCLevel ^(AT_LANGUAGE IDENT) ^(AT_SPEC IDENT) cpp_directive ##mylang##Definition*);
##mylang##Definition    : ##mylang##Package cpp_directive;

cpp_directive           : s=CPP_DIRECTIVE {setCppFile(s.getText());};

##mylang##Package       : ^(PACKAGE s=IDENT {this.pass.atoms.scope.push(s.token);} {this.pass.propDefListStart();} ##mylang##PropertyDef* {this.pass.propDefListFinish();} ##mylang##Definition* inline_code*) {this.pass.atoms.scope.pop();};
