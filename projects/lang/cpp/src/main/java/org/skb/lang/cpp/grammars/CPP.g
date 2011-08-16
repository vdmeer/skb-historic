/* Copyright (c) 2001-2011 Sven van der Meer (sven@vandermeer.de)
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
 * EBNF ANTLR grammar for the SKB Preprocessor
 *
 * @package    org.skb.lang.cpp
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2011-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v0.31 build 110208 (08-Feb-11)
 */

grammar CPP;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header{
  package org.skb.lang.cpp.grammars;
}

@lexer::header{
  package org.skb.lang.cpp.grammars;
}

@members{
  Boolean error=false;
  public void displayRecognitionError(String[] tokenNames, RecognitionException re){this.error=true;}
}

start      : '#' WS WS* (rule | empty_rule) (('\r'? '\n') | EOF)! -> ^(CPP_RULE rule? empty_rule?); 
rule       : (c=CPP_INCLUDE | c=CPP_DEFINE | c=CPP_UNDEF | c=CPP_IFDEF | c=CPP_IFNDEF | c=CPP_ELSIF) WS STRING -> ^($c STRING);
empty_rule : CPP_ELSE | CPP_ENDIF;
CPP_INCLUDE: 'include';
CPP_DEFINE : 'define';
CPP_UNDEF  : 'undef';
CPP_IFDEF  : 'ifdef';
CPP_IFNDEF : 'ifndef';
CPP_ELSE   : 'else';
CPP_ELSIF  : 'elsif';
CPP_ENDIF  : 'endif';

CPP_RULE   : 'rule';

WS         : (' '|'\t') {$channel=HIDDEN;};
STRING     : '"' ( options {greedy=false;}: ~('"') )* '"';