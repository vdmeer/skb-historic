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
 * Code Generation ANTLR grammar for Org.SKB.Lang.Mess
 *
 * @package    org.skb.lang.mess.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for ANTLR v3.1.3
 */

tree grammar messGen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=messEbnf;
}

@header
{
  package org.skb.lang.mess.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.lang.mess.proto.MessPass3_Gen;
  import org.skb.lang.mess.proto.constants.MessConstants;
}

@members{
  private MessPass3_Gen pass;

  public void init() {
    this.pass=new MessPass3_Gen();
  }
}

/*
 * messSpecification/Definition == Start of every MESS spec
 */
messSpecification              @init{this.init();}
                             : ^(AT_SPEC
                                 {StringTemplate spec=templateLib.getInstanceOf("messSpecification");
                                  this.pass.atoms.addST(MessConstants.Tokens.messAT_SPEC,spec);
                                  this.pass.addRuntimeST(this.getTemplateLib());
                                 }
                                 messDefinition
                               );

cpp_directive                : CPP_DIRECTIVE;

messDefinition               : cpp_directive* messDomain {this.pass.addST($messDomain.st);} {this.pass.popAtom(1);}
                               ( cpp_directive |
                                 messContentType {this.pass.addST($messContentType.st);} {this.pass.popAtom(1);} |
                                 messField {this.pass.addST($messField.st);} {this.pass.popAtom(1);} |
                                 messMessage {this.pass.addST($messMessage.st);} {this.pass.popAtom(1);}
                               )*; 

messDomain                   : ^(MESS_DOMAIN id=IDENT
                                 {this.pass.pushSep(id.token, null);}
                               )
                               -> messDomain();

messContentType              : ^(sep=MESS_CONTENT_TYPE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 mime=MIME val=VAL_STRING
                               )
                               -> messContentType(ident={$id}, mime_ct={$mime}, value={$val});

messField                    : ^(sep=MESS_FIELD id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 mime=IDENT val=VAL_STRING
                               )
                               -> messField(ident={$id}, mime={$mime}, value={$val});

messMessage                  : ^(sep=MESS_MESSAGE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.clearDefTemplates();}
                                 {ArrayList<StringTemplate> decls=new ArrayList<StringTemplate>();}
                                 (ext=IDENT)?
                                 (messMessageChangeDecl {decls.add($messMessageChangeDecl.st);})*
                                 (messMessageRequiresDecl {decls.add($messMessageRequiresDecl.st);})*
                                 (messMessageOptionalDecl {decls.add($messMessageOptionalDecl.st);})*
                               )
                               -> messMessage(ident={$id}, extends={$ext}, fieldDeclarations={decls}, fieldDefinitions={this.pass.getDefTemplates()});

messMessageChangeDecl        : ^(sep=MESS_CHANGE id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.resetFieldList();}
                                 value=VAL_STRING {this.pass.setFieldValue(value.token);}
                                 {this.pass.addFieldListDef(sep.token, id.token, this.getTemplateLib());}
                                 {this.pass.popAtom(2);}
                               )
                               -> messMessageChangeDecl(ident={$id}, value={$value});

messMessageRequiresDecl      : ^(sep=MESS_REQUIRES id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.resetFieldList();}
                                 (value=VAL_STRING {this.pass.setFieldValue(value.token);})?
                                 (immutable=MESS_IMMUTABLE {this.pass.setFieldImmut(immutable.token);})?
                                 {this.pass.addFieldListDef(sep.token, id.token, this.getTemplateLib());}
                                 {this.pass.popAtom(2);}
                               )
                               -> messMessageRequiresDecl(ident={$id}, value={$value}, immutable={$immutable});

messMessageOptionalDecl      : ^(sep=MESS_OPTIONAL id=IDENT
                                 {this.pass.pushSep(id.token, sep.token);}
                                 {this.pass.resetFieldList();}
                                 (value=VAL_STRING {this.pass.setFieldValue(value.token);})?
                                 (immutable=MESS_IMMUTABLE {this.pass.setFieldImmut(immutable.token);})?
                                 {this.pass.addFieldListDef(sep.token, id.token, this.getTemplateLib());}
                                 {this.pass.popAtom(2);}
                               )
                               -> messMessageOptionalDecl(ident={$id}, value={$value}, immutable={$immutable});
