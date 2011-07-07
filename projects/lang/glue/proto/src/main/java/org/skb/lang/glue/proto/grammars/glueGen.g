/* Copyright (c) 2010-2011 Sven van der Meer (sven@vandermeer.de)
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
 * Code Generation ANTLR grammar for Org.SKB.Lang.Glue.Proto
 *
 * @package    org.skb.lang.glue.proto
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.30 build 110309 (09-Mar-11) for ANTLR v3.3
 */

tree grammar glueGen;

options
{
  language=Java;
  output=template;
  ASTLabelType=CommonTree;
  tokenVocab=glueEbnf;
}

@header
{
  package org.skb.lang.glue.proto.grammars;

  import java.util.ArrayList;
  import java.util.LinkedHashMap;

  import org.skb.util.languages.AtomList;
  import org.skb.util.languages.ScopeToken;
  import org.skb.lang.glue.proto.GluePass3_Gen;
  import org.skb.lang.glue.proto.GlueTokensConstants;
  import org.skb.util.ReportManager;
}

@members{
  private GluePass3_Gen pass;

  public void init() {
    this.pass=new GluePass3_Gen();
  }
}

glueSpecification @init{this.init();}
//                   : ^(AT_SPEC s=IDENT (top+=glueTopology)*)
//                     -> template(token={$top}) "<specification>\n\n<token>";

                        : ^(AT_SPEC s=IDENT
                           {StringTemplate spec=templateLib.getInstanceOf("glueSpecification");
                            spec.setAttribute("id", $s);
//                            this.pass.atoms.addST(ColaTokens.colaSPECIFICATION,spec);
                           }
                           (def+=glueTopology)*
                          )
{
spec.setAttribute("body", $def);
System.out.println(spec);
}
                          -> template(specification={spec}, token={$def}) "<specification>\n\n<token>";



glueTopology       : ^(TOPOLOGY (id=IDENT)? (snl=scoped_name_lang)? (d+=glueDomain)* (n+=glueNode)* (c+=glueConnection)*)
                     -> glueTopology(id={$id.text}, idlang={$snl.st}, domains={$d}, nodes={$n}, connections={$c});

glueDomain         : ^(DOMAIN (id=IDENT)? (snl=scoped_name_lang)? (dom+=glueDomain)* (node+=glueNode)* (conn+=glueConnection)* (port+=gluePort)* (con+=glueContracts)? (pol+=gluePolicies)? (kvl+=key_value_list)?)
                     -> glueDomain(id={$id.text}, idlang={$snl.st}, domains={$dom}, nodes={$node}, connections={$conn}, ports={$port}, contracts={$con}, policies={$pol}, kvl={$kvl});

glueNode           : ^(NODE (id=IDENT)? (snl=scoped_name_lang)? (com+=glueComponent)* (con+=glueConnection)* (p+=gluePort)* (con+=glueContracts)? (pol+=gluePolicies)? (kvl+=key_value_list)?)
                     -> glueNode(id={$id.text}, idlang={$snl.st}, components={$com}, connections={$con}, ports={$p}, contracts={$con}, policies={$pol}, kvl={$kvl});

glueConnection     : ^(CONNECTION id=IDENT DIRECTED? src+=glueSource tgt+=glueTarget)
                     -> glueConnection(id={$id.text}, directed={$DIRECTED.text}, source={$src}, target={$tgt});

glueSource         : ^(SOURCE sn=scoped_name (src+=glueSourcePort)?)
                     -> glueSource(id={$sn.st}, sourceport={$src});
glueTarget         : ^(TARGET sn=scoped_name (tgt+=glueTargetPort)?)
                     -> glueTarget(id={$sn.st}, targetport={$tgt});

gluePort           : ^(PORT id=IDENT)
                     -> gluePort(id={$id});

glueSourcePort     : ^(SOURCEPORT sn=scoped_name)
                     -> glueSourcePort(id={$sn.st});

glueTargetPort     : ^(TARGETPORT sn=scoped_name)
                     -> glueTargetPort(id={$sn.st});

glueComponent      : ^(COMPONENT (id=IDENT)? (snl=scoped_name_lang)? (p+=gluePort)* (con+=glueContracts)? (pol+=gluePolicies)? (kvl+=key_value_list)?)
                     -> glueComponent(id={$id.text}, idlang={$snl.st}, ports={$p}, contracts={$con}, policies={$pol}, kvl={$kvl});

glueContracts      : ^(CONTRACTS scoped_name* scoped_name_lang*) -> template() "<!-- Contracts TO DE DONE### -->";

gluePolicies       : ^(POLICIES scoped_name* scoped_name_lang*) -> template() "<!-- Policies TO DE DONE### -->";

scoped_name        : ^(AT_SCOPE (id+=IDENT)*) -> scoped_name(id={$id});
scoped_name_lang   : ^(AT_LANG IDENT sn=scoped_name) -> scoped_name_lang(sn={$sn.st});

key_value_list     : ^(AT_KVL key_value*);

key_value          : ^(AT_KVL ^(AT_KVL IDENT? VAL_STRING?) ^(AT_KVL VAL_XSTRING? VAL_STRING?));
