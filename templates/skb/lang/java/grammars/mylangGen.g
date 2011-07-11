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
 * Code Generation ANTLR grammar for Org.SKB.Lang.##MyLang##
 *
 * @package    org.skb.lang.##mylang##
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar ##mylang##Gen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=##mylang##Ebnf;
}

@header
{
  package org.skb.lang.##mylang##.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.lang.##mylang##.##MyLang##Pass3_Gen;
  import org.skb.lang.##mylang##.##MyLang##TokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private ##MyLang##Pass3_Gen pass;

  public void init() {
    this.pass=new ##MyLang##Pass3_Gen();
  }
}

akbStage                : 'architecture' | 'model' | 'design' | 'development' | 'deployment' | 'runtime';
akbEnvironment          : 'production' | 'test' | 'demonstrator';
akbCLevel               : 'business' | 'system' | 'element';

##mylang##Specification @init{this.init();}
                        : ^(AT_SPEC stage=skbStage env=skbEnvironment clevel=skbCLevel ^(AT_LANGUAGE lang=IDENT)
                          ^(AT_SPEC s=IDENT
                           {StringTemplate spec=templateLib.getInstanceOf("##mylang##Specification");
                            spec.setAttribute("stage", $stage.text);
                            spec.setAttribute("environment", $env.text);
                            spec.setAttribute("clevel", $clevel.text);
                            spec.setAttribute("language", $lang.text);
                            spec.setAttribute("spec", $s);
                            this.pass.atoms.addST(##MyLang##TokensConstants.##mylang##SPECIFICATION,spec);
                           })
                           cpp_directive (def+=##mylang##Definition)*
                          )
                          -> template(specification={spec}, token={$def}) "<specification>\n\n<token>";
##mylang##Definition    : ##mylang##Package {this.pass.addST($##mylang##Package.st);} -> template(token={$##mylang##Package.st}) "<token>" |
                          cpp_directive;

cpp_directive           : CPP_DIRECTIVE;

##mylang##Package             : ^(PACKAGE id=IDENT {this.pass.atoms.scope.push($id.token);} lpd=##mylang##PropertyDefList (def+=##mylang##Definition)* (ic+=inline_code)*)
                          -> ##mylang##Package(id={$id}, properties={$lpd.st}, inline_code={$ic}, misc={this.pass.misc()});
