/* Copyright (c) 2010-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
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

package org.skb.util.classic.dictionaries;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * Rough test for an HTML to LaTeX translation dictionary.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Html2LaTeX extends Dictionary<String, String>{
	protected Hashtable<String, String> tsvalue=null;

	private static class Html2LaTeXHolder{
		private final static Html2LaTeX INSTANCE = new Html2LaTeX();
	}

	public static Html2LaTeX getInstance(){
		return Html2LaTeXHolder.INSTANCE;
	}

	public Html2LaTeX(){
		this.tsvalue=new Hashtable<String, String>();
		this.buildDictionary();
	}

	public Enumeration<String> elements(){
		return this.tsvalue.elements();
	}

	public String get(Object key){
		return this.tsvalue.get(key);
	}

	public boolean isEmpty(){
		return this.tsvalue.isEmpty();
	}

	public Enumeration<String> keys(){
		return this.tsvalue.keys();
	}

	public String put(String key, String value){
		//we don't want any additions to the local dictionary here
		return null;
	}

	public String remove(Object key){
		return this.tsvalue.remove(key);
	}

	public int size(){
		return this.tsvalue.size();
	}


	public String translate(String input){
		String ret=new String(input);
		Set<String> keys = this.tsvalue.keySet();
		Iterator<String> key_it = keys.iterator();
		String key;
		while(key_it.hasNext()){
			key=key_it.next();
			ret=ret.replace(key, this.tsvalue.get(key));
		}
		return ret;
	}

	private void buildDictionary(){
        //html entities
        this.tsvalue.put("<sup>",   "$^{");
        this.tsvalue.put("</sup>",  "}$");
        this.tsvalue.put("<sub>",   "$_{");
        this.tsvalue.put("</sub>",  "}$");
        this.tsvalue.put("<b>",     "\\textbf{");
        this.tsvalue.put("</b>",    "}");
        this.tsvalue.put("<i>",     "\\textit{");
        this.tsvalue.put("</i>",    "}");
        this.tsvalue.put("<ol>",    "\\begin{enumerate}");
        this.tsvalue.put("</ol>",   "\\end{enumerate}");
        this.tsvalue.put("<ul>",    "\\begin{itemize}");
        this.tsvalue.put("</ul>",   "\\end{itemize}");
        this.tsvalue.put("<li>",    "\\item");
        this.tsvalue.put("</li>",   " ");
        this.tsvalue.put("<br />",  "\\\\");

        //ascii characters
        this.tsvalue.put("&#32;",  " ");                        // SPC
        this.tsvalue.put("&#33;",  "!");                        // !
        this.tsvalue.put("&#34;",  "\"");                       // "
        this.tsvalue.put("#",      "\\#");                      // #
        this.tsvalue.put("&#35;",  "\\#");                      // #
        this.tsvalue.put("&#36;",  "\\$");                      // $
        this.tsvalue.put("&#37;",  "\\%");                      // %
        this.tsvalue.put("&#38;",  "\\&");                      // &
        this.tsvalue.put("&#40;",  "(");                        // (
        this.tsvalue.put("&#41;",  ")");                        // )
        this.tsvalue.put("&#42;",  "\\textasteriskcentered");   // *
        this.tsvalue.put("&#43;",  "+");                        // +
        this.tsvalue.put("&#44;",  ",");                        // ,
        this.tsvalue.put("&#45;",  "-");                        // -
        this.tsvalue.put("&#46;",  ".");                        // .
        this.tsvalue.put("&#47;",  "/");                        // /
        this.tsvalue.put("&#58;",  ":");                        // :
        this.tsvalue.put("&#59;",  ";");                        // ;
        this.tsvalue.put("&#60;",  "\\textless");               // <
        this.tsvalue.put("&#61;",  "=");                        // =
        this.tsvalue.put("&#62;",  "\\textgreater");            // >
        this.tsvalue.put("&#63;",  "?");                        // ?
        this.tsvalue.put("&#64;",  "@");                        // @
        this.tsvalue.put("&#91;",  "\\[");                      // [
        this.tsvalue.put("&#92;",  "\\textbackslash");          // \
        this.tsvalue.put("&#93;",  "\\]");                      // ]
        this.tsvalue.put("&#94;",  "\\textasciicircum");        // ^
        this.tsvalue.put("_",      "\\_");                      // _
        this.tsvalue.put("&#95;",  "\\_");                      // _
        this.tsvalue.put("&#123;", "\\{");                      // {
        this.tsvalue.put("&#124;", "\\textbar");                // |
        this.tsvalue.put("&#125;", "\\}");                      // }
        this.tsvalue.put("&#126;", "\\textasciitilde");         // ~

        //html-named ascii characters
        this.tsvalue.put("&amp;",   "\\&");                     // &
        this.tsvalue.put("&lt;",    "\\textless");              // <
        this.tsvalue.put("&gt;",    "\\textgreater");           // >
        this.tsvalue.put("&circ;",  "\\textasciicircum");       // ^
        this.tsvalue.put("&tilde;", "\\textasciitilde");        // ~

        //punctuation, qoutes
        this.tsvalue.put("&quot;",   "\""); // "
        this.tsvalue.put("&lsquo;",  "`");  // `
        this.tsvalue.put("&#96;",    "`");  // `
        this.tsvalue.put("&rsquo;",  "'");  // '
        this.tsvalue.put("&#39;",    "'");  // '
        this.tsvalue.put("&sbquo;",  ""); // single low-9
        this.tsvalue.put("&ldquo;",  "``");
        this.tsvalue.put("&rdquo;",  "''");
        this.tsvalue.put("&bdquo;",  ""); // double low-9
        this.tsvalue.put("&lsaquo;", ""); // angewinkeltes <
        this.tsvalue.put("&rsaquo;", ""); // angewinkeltes >

        //accents grave
        this.tsvalue.put("&Agrave;", "\\`{A}"); // À
        this.tsvalue.put("&agrave;", "\\`{a}"); // à
        this.tsvalue.put("&Egrave;", "\\`{E}"); // È
        this.tsvalue.put("&egrave;", "\\`{e}"); // è
        this.tsvalue.put("&Igrave;", "\\`{I}"); // Ì
        this.tsvalue.put("&igrave;", "\\`{i}"); // ì
        this.tsvalue.put("&Ograve;", "\\`{O}"); // Ò
        this.tsvalue.put("&ograve;", "\\`{o}"); // ò
        this.tsvalue.put("&Ugrave;", "\\`{U}"); // Ù
        this.tsvalue.put("&ugrave;", "\\`{u}"); // ù

        //accents acute
        this.tsvalue.put("&Aacute;", "\\'{A}"); // Á
        this.tsvalue.put("&aacute;", "\\'{a}"); // á
        this.tsvalue.put("&Eacute;", "\\'{E}"); // É
        this.tsvalue.put("&eacute;", "\\'{e}"); // é
        this.tsvalue.put("&Iacute;", "\\'{I}"); // Í
        this.tsvalue.put("&iacute;", "\\'{i}"); // í
        this.tsvalue.put("&Oacute;", "\\'{O}"); // Ó
        this.tsvalue.put("&oacute;", "\\'{o}"); // ó
        this.tsvalue.put("&Uacute;", "\\'{U}"); // Ú
        this.tsvalue.put("&uacute;", "\\'{u}"); // ú
        this.tsvalue.put("&Yacute;", "\\'{Y}"); // Ý
        this.tsvalue.put("&yacute;", "\\'{y}"); // ý

        //accents circumflex
        this.tsvalue.put("&Acirc;", "\\^{A}"); // Â
        this.tsvalue.put("&acirc;", "\\^{a}"); // â
        this.tsvalue.put("&Ecirc;", "\\^{E}"); // Ê
        this.tsvalue.put("&ecirc;", "\\^{e}"); // ê
        this.tsvalue.put("&Icirc;", "\\^{I}"); // Î
        this.tsvalue.put("&icirc;", "\\^{i}"); // î
        this.tsvalue.put("&Ocirc;", "\\^{O}"); // Ô
        this.tsvalue.put("&ocirc;", "\\^{o}"); // ô
        this.tsvalue.put("&Ucirc;", "\\^{U}"); // Û
        this.tsvalue.put("&ucirc;", "\\^{u}"); // û

        //accents tilde
        this.tsvalue.put("&Atilde;", "\\~{A}"); // Ã
        this.tsvalue.put("&atilde;", "\\~{a}"); // ã
        this.tsvalue.put("&Ntilde;", "\\~{E}"); // Ñ
        this.tsvalue.put("&ntilde;", "\\~{e}"); // ñ
        this.tsvalue.put("&Otilde;", "\\~{O}"); // Õ
        this.tsvalue.put("&otilde;", "\\~{o}"); // õ

        //accents umlaut
        this.tsvalue.put("&Auml;", "\\\"{A}"); // Ä
        this.tsvalue.put("&auml;", "\\\"{a}"); // ä
        this.tsvalue.put("&Euml;", "\\\"{E}"); // Ë
        this.tsvalue.put("&euml;", "\\\"{e}"); // ë
        this.tsvalue.put("&Iuml;", "\\\"{I}"); // Ï
        this.tsvalue.put("&iuml;", "\\\"{i}"); // ï
        this.tsvalue.put("&Ouml;", "\\\"{O}"); // Ö
        this.tsvalue.put("&ouml;", "\\\"{o}"); // ö
        this.tsvalue.put("&Uuml;", "\\\"{U}"); // Ü
        this.tsvalue.put("&uuml;", "\\\"{u}"); // ü
        this.tsvalue.put("&Yuml;", "\\\"{U}"); // Ÿ
        this.tsvalue.put("&yuml;", "\\\"{u}"); // ÿ

        //accents ring
        this.tsvalue.put("&Aring;", "\\AA"); // Å
        this.tsvalue.put("&aring;", "\\aa"); // å

        this.tsvalue.put("&AElig;", "\\AE"); // Æ
        this.tsvalue.put("&aelig;", "\\ae"); // æ
        this.tsvalue.put("&OElig;", "\\OE"); // Œ
        this.tsvalue.put("&oelig;", "\\oe"); // œ

        this.tsvalue.put("&Ccedil;", "\\c{C}"); // Ç
        this.tsvalue.put("&ccedil;", "\\c{c}"); // ç

        this.tsvalue.put("&ETH;", "\\DH"); // Ð
        this.tsvalue.put("&eth;", "\\dh"); // ð

        this.tsvalue.put("&Oslash;", "\\O"); // Ø
        this.tsvalue.put("&oslash;", "\\o"); // ø

        this.tsvalue.put("&THORN;", "\\TH");  // Þ
        this.tsvalue.put("&thorn;", "\\th");  // þ

        this.tsvalue.put("&szlig;", "\\ss"); // ß

//    '&LLL;' => '\\L', // L-
//    '&lll;' => '\\l', // l-

        this.tsvalue.put("&Scaron;", "\\v{S}"); // Š
        this.tsvalue.put("&scaron;", "\\v{s}"); // š

        this.tsvalue.put("&fnof;", "");       // ƒ

        this.tsvalue.put("&nbsp;",   "~");
        this.tsvalue.put("&#160;",   "~");
        this.tsvalue.put("&iexcl;",  "\\textexclamdown");   // ¡
        this.tsvalue.put("&cent;",   "\\cent");             // ¢
        this.tsvalue.put("&pound;",  "{\\pounds}");         // £
        this.tsvalue.put("&curren;", "\\currency");         // ¤
        this.tsvalue.put("&yen;",    "");                   // ¥
        this.tsvalue.put("&brvbar;", "");                   // ¦
        this.tsvalue.put("&sect;",   "{\\S}");              // §
        this.tsvalue.put("&uml;",    "");                   // ¨
        this.tsvalue.put("&copy;",   "{\\copyright}");      // © -- alternative: {\textcopyright}
        this.tsvalue.put("&ordf;",   "\\textordfeminine");  // ª
        this.tsvalue.put("&laquo;",  "");                   // «
        this.tsvalue.put("&not;",    "");                   // ¬
        this.tsvalue.put("&shy;",    "");                   // ­
        this.tsvalue.put("&reg;",    "{\\textregistered}"); // ®
        this.tsvalue.put("&macr;",   "");                   // ¯
        this.tsvalue.put("&deg;",    "");                   // °
        this.tsvalue.put("&plusmn;", "");                   // ±
        this.tsvalue.put("&sup2;",   "");                   // ²
        this.tsvalue.put("&sup3;",   "");                   // ³
        this.tsvalue.put("&acute;",  "");                   // ´
        this.tsvalue.put("&micro;",  "");                   // µ
        this.tsvalue.put("&para;",   "\\P");                // ¶
        this.tsvalue.put("&middot;", "");                   // ·
        this.tsvalue.put("&cedil;",  "");                   // ¸
        this.tsvalue.put("&sup1;",   "");                   // ¹
        this.tsvalue.put("&ordm;",   "\\textordmasculine"); // º
        this.tsvalue.put("&raquo;",  "");                   // »
        this.tsvalue.put("&frac14;", "");                   // ¼
        this.tsvalue.put("&frac12;", "");                   // ½
        this.tsvalue.put("&frac34;", "");                   // ¾
        this.tsvalue.put("&iquest;", "\\textquestiondown"); // ¿
        this.tsvalue.put("&times;",  "");                   // ×
        this.tsvalue.put("&divide;", "");                   // ÷

        //technical symbols
        this.tsvalue.put("&lceil;",  "");
        this.tsvalue.put("&rceil;",  "");
        this.tsvalue.put("&lfloor;", "");
        this.tsvalue.put("&rfloor;", "");
        this.tsvalue.put("&lang;",   "");
        this.tsvalue.put("&rang;",   "");

        //arrow symbols
        this.tsvalue.put("&larr;",   "\\(\\leftarrow{}\\)");
        this.tsvalue.put("&uarr;",   "\\(\\uparrow\\)");
        this.tsvalue.put("&rarr;",   "\\(\\rightarrow{}\\)");
        this.tsvalue.put("&darr;",   "\\(\\downarrow{}\\)");
        this.tsvalue.put("&harr;",   "\\(\\leftrightarrow{}\\)");
        this.tsvalue.put("&crarr;",  "");
        this.tsvalue.put("&lArr;",   "\\(\\Leftarrow{}\\)");
        this.tsvalue.put("&uArr;",   "\\(\\Uparrow\\)");
        this.tsvalue.put("&rArr;",   "\\(\\Rightarrow{}\\)");
        this.tsvalue.put("&dArr;",   "\\(\\Downarrow{}\\)");
        this.tsvalue.put("&hArr;",   "\\(\\Leftrightarrow{}\\)");

        //symbols misc
        this.tsvalue.put("&bull;",    ""); // •
        this.tsvalue.put("&prime;",   ""); // '
        this.tsvalue.put("&Prime;",   "");
        this.tsvalue.put("&oline;",   "");
        this.tsvalue.put("&frasl;",   "");
        this.tsvalue.put("&weierp;",  "");
        this.tsvalue.put("&image;",   "");
        this.tsvalue.put("&real;",    "");
        this.tsvalue.put("&trade;",   "{\\texttrademark}"); // ™
        this.tsvalue.put("&euro;",    "{\\euro}");          // €
        this.tsvalue.put("&alefsym;", "");
        this.tsvalue.put("&spades;",  "");
        this.tsvalue.put("&clubs;",   "");
        this.tsvalue.put("&hearts;",  "");
        this.tsvalue.put("&diams;",   "");

        //punctation
        this.tsvalue.put("&ensp;",    "");
        this.tsvalue.put("&emsp;",    "");
        this.tsvalue.put("&thinsp;",  "");
        this.tsvalue.put("&zwnj;",    "");
        this.tsvalue.put("&zwj;",     "");
        this.tsvalue.put("&lrm;",     "");
        this.tsvalue.put("&rlm;",     "");
        this.tsvalue.put("&ndash;",   "--");       // –
        this.tsvalue.put("&mdash;",   "---");      // —
        this.tsvalue.put("&dagger;",  "\\dag");    // †
        this.tsvalue.put("&Dagger;",  "\\ddag");   // ‡
        this.tsvalue.put("&hellip;",  "{\\dots}"); // …
        this.tsvalue.put("&permil;",  "");         // ‰

        //mathematical signs
        this.tsvalue.put("&forall;",  "$\\forall$");
        this.tsvalue.put("&part;",    "");
        this.tsvalue.put("&exist;",   "$\\exists$");
        this.tsvalue.put("&empty;",   "");
        this.tsvalue.put("&nabla;",   "");
        this.tsvalue.put("&isin;",    "$\\in$");
        this.tsvalue.put("&notin;",   "$\\notin$");
        this.tsvalue.put("&ni;",      "");
        this.tsvalue.put("&prod;",    "$\\prod$");
        this.tsvalue.put("&sum;",     "$\\sum$");
        this.tsvalue.put("&minus;",   "");
        this.tsvalue.put("&lowast;",  "");
        this.tsvalue.put("&radic;",   "");
        this.tsvalue.put("&prop;",    "");
        this.tsvalue.put("&infin;",   "$infty$");
        this.tsvalue.put("&ang;",     "");
        this.tsvalue.put("&and;",     "$\\wedge$");
        this.tsvalue.put("&or;",      "$\\vee$");
        this.tsvalue.put("&cap;",     "$\\cap$");
        this.tsvalue.put("&cup;",     "$\\cup$");
        this.tsvalue.put("&int;",     "");
        this.tsvalue.put("&there4;",  "");
        this.tsvalue.put("&sim;",     "");
        this.tsvalue.put("&cong;",    "");
        this.tsvalue.put("&asymp;",   "$\\approx{}$");
        this.tsvalue.put("&ne;",      "$\\neq$");
        this.tsvalue.put("&equiv;",   "");
        this.tsvalue.put("&le;",      "$\\leq$");
        this.tsvalue.put("&ge;",      "$\\geq$");
        this.tsvalue.put("&sub;",     "");
        this.tsvalue.put("&sup;",     "");
        this.tsvalue.put("&nsub;",    "");
        this.tsvalue.put("&sube;",    "");
        this.tsvalue.put("&supe;",    "");
        this.tsvalue.put("&oplus;",   "");
        this.tsvalue.put("&otimes;",  "");
        this.tsvalue.put("&perp;",    "");
        this.tsvalue.put("&sdot;",    "");
        this.tsvalue.put("&loz;",     "");

        //greek characters
        this.tsvalue.put("&Alpha;",   "A");
        this.tsvalue.put("&alpha;",   "\\alpha");
        this.tsvalue.put("&Beta;",    "B");
        this.tsvalue.put("&beta;",    "\\beta");
        this.tsvalue.put("&Gamma;",   "\\Gamma");
        this.tsvalue.put("&gamma;",   "\\gamma");
        this.tsvalue.put("&Delta;",   "\\Delta");
        this.tsvalue.put("&delta;",   "\\delta");
        this.tsvalue.put("&Epsilon;", "E");
        this.tsvalue.put("&epsilon;", "\\epsilon");
        this.tsvalue.put("&Zeta;",    "Z");
        this.tsvalue.put("&zeta;",    "\\zeta");
        this.tsvalue.put("&Eta;",     "H");
        this.tsvalue.put("&eta;",     "\\eta");
        this.tsvalue.put("&Theta;",   "\\Theta");
        this.tsvalue.put("&theta;",   "\\theta");
        this.tsvalue.put("&thetasym;","\\vartheta");
        this.tsvalue.put("&Iota;",    "I");
        this.tsvalue.put("&iota;",    "\\iota");
        this.tsvalue.put("&Kappa;",   "K");
        this.tsvalue.put("&kappa;",   "\\kappa");
        this.tsvalue.put("&Lambda;",  "\\Lambda");
        this.tsvalue.put("&lambda;",  "\\lambda");
        this.tsvalue.put("&Mu;",      "M");
        this.tsvalue.put("&mu;",      "\\mu");
        this.tsvalue.put("&Nu;",      "N");
        this.tsvalue.put("&nu;",      "\\nu");
        this.tsvalue.put("&Xi;",      "\\Xi");
        this.tsvalue.put("&xi;",      "\\xi");
        this.tsvalue.put("&Omicron;", "O");
        this.tsvalue.put("&omicron;", "o");
        this.tsvalue.put("&Pi;",      "\\Pi");
        this.tsvalue.put("&pi;",      "\\pi");
        this.tsvalue.put("&Rho;",     "P");
        this.tsvalue.put("&rho;",     "\\rho");
        this.tsvalue.put("&Sigma;",   "\\Sigma");
        this.tsvalue.put("&sigma;",   "\\sigma");
        this.tsvalue.put("&sigmaf;",  "\\varsigma");
        this.tsvalue.put("&Tau;",     "T");
        this.tsvalue.put("&tau;",     "\\tau");
        this.tsvalue.put("&Upsilon;", "\\Upsilon");
        this.tsvalue.put("&upsilon;", "\\upsilon");
        this.tsvalue.put("&Phi;",     "\\Phi");
        this.tsvalue.put("&phi;",     "\\phi");
        this.tsvalue.put("&piv;",	    "\\varpi");
        this.tsvalue.put("&Chi;",     "X");
        this.tsvalue.put("&chi;",     "\\chi");
        this.tsvalue.put("&Psi;",     "\\Psi");
        this.tsvalue.put("&psi;",     "\\psi");
        this.tsvalue.put("&Omega;",   "\\Omega");
        this.tsvalue.put("&omega;",   "\\omega");
        this.tsvalue.put("&upsih;",   "");
	}
}
