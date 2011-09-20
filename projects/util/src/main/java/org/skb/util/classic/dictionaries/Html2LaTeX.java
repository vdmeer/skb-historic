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
	protected Hashtable<String, String> value=null;

	private static class Html2LaTeXHolder{
		private final static Html2LaTeX INSTANCE = new Html2LaTeX();
	}

	public static Html2LaTeX getInstance(){
		return Html2LaTeXHolder.INSTANCE;
	}

	public Html2LaTeX(){
		this.value=new Hashtable<String, String>();
		this.buildDictionary();
	}

	public Enumeration<String> elements(){
		return this.value.elements();
	}

	public String get(Object key){
		return this.value.get(key);
	}

	public boolean isEmpty(){
		return this.value.isEmpty();
	}

	public Enumeration<String> keys(){
		return this.value.keys();
	}

	public String put(String key, String value){
		//we don't want any additions to the local dictionary here
		return null;
	}

	public String remove(Object key){
		return this.value.remove(key);
	}

	public int size(){
		return this.value.size();
	}


	public String translate(String input){
		String ret=new String(input);
		Set<String> keys = this.value.keySet();
		Iterator<String> key_it = keys.iterator();
		String key;
		while(key_it.hasNext()){
			key=key_it.next();
			ret=ret.replace(key, this.value.get(key));
		}
		return ret;
	}

	private void buildDictionary(){
        //html entities
        this.value.put("<sup>",   "$^{");
        this.value.put("</sup>",  "}$");
        this.value.put("<sub>",   "$_{");
        this.value.put("</sub>",  "}$");
        this.value.put("<b>",     "\\textbf{");
        this.value.put("</b>",    "}");
        this.value.put("<i>",     "\\textit{");
        this.value.put("</i>",    "}");
        this.value.put("<ol>",    "\\begin{enumerate}");
        this.value.put("</ol>",   "\\end{enumerate}");
        this.value.put("<ul>",    "\\begin{itemize}");
        this.value.put("</ul>",   "\\end{itemize}");
        this.value.put("<li>",    "\\item");
        this.value.put("</li>",   " ");
        this.value.put("<br />",  "\\\\");

        //ascii characters
        this.value.put("&#32;",  " ");                        // SPC
        this.value.put("&#33;",  "!");                        // !
        this.value.put("&#34;",  "\"");                       // "
        this.value.put("#",      "\\#");                      // #
        this.value.put("&#35;",  "\\#");                      // #
        this.value.put("&#36;",  "\\$");                      // $
        this.value.put("&#37;",  "\\%");                      // %
        this.value.put("&#38;",  "\\&");                      // &
        this.value.put("&#40;",  "(");                        // (
        this.value.put("&#41;",  ")");                        // )
        this.value.put("&#42;",  "\\textasteriskcentered");   // *
        this.value.put("&#43;",  "+");                        // +
        this.value.put("&#44;",  ",");                        // ,
        this.value.put("&#45;",  "-");                        // -
        this.value.put("&#46;",  ".");                        // .
        this.value.put("&#47;",  "/");                        // /
        this.value.put("&#58;",  ":");                        // :
        this.value.put("&#59;",  ";");                        // ;
        this.value.put("&#60;",  "\\textless");               // <
        this.value.put("&#61;",  "=");                        // =
        this.value.put("&#62;",  "\\textgreater");            // >
        this.value.put("&#63;",  "?");                        // ?
        this.value.put("&#64;",  "@");                        // @
        this.value.put("&#91;",  "\\[");                      // [
        this.value.put("&#92;",  "\\textbackslash");          // \
        this.value.put("&#93;",  "\\]");                      // ]
        this.value.put("&#94;",  "\\textasciicircum");        // ^
        this.value.put("_",      "\\_");                      // _
        this.value.put("&#95;",  "\\_");                      // _
        this.value.put("&#123;", "\\{");                      // {
        this.value.put("&#124;", "\\textbar");                // |
        this.value.put("&#125;", "\\}");                      // }
        this.value.put("&#126;", "\\textasciitilde");         // ~

        //html-named ascii characters
        this.value.put("&amp;",   "\\&");                     // &
        this.value.put("&lt;",    "\\textless");              // <
        this.value.put("&gt;",    "\\textgreater");           // >
        this.value.put("&circ;",  "\\textasciicircum");       // ^
        this.value.put("&tilde;", "\\textasciitilde");        // ~

        //punctuation, qoutes
        this.value.put("&quot;",   "\""); // "
        this.value.put("&lsquo;",  "`");  // `
        this.value.put("&#96;",    "`");  // `
        this.value.put("&rsquo;",  "'");  // '
        this.value.put("&#39;",    "'");  // '
        this.value.put("&sbquo;",  ""); // single low-9
        this.value.put("&ldquo;",  "``");
        this.value.put("&rdquo;",  "''");
        this.value.put("&bdquo;",  ""); // double low-9
        this.value.put("&lsaquo;", ""); // angewinkeltes <
        this.value.put("&rsaquo;", ""); // angewinkeltes >

        //accents grave
        this.value.put("&Agrave;", "\\`{A}"); // À
        this.value.put("&agrave;", "\\`{a}"); // à
        this.value.put("&Egrave;", "\\`{E}"); // È
        this.value.put("&egrave;", "\\`{e}"); // è
        this.value.put("&Igrave;", "\\`{I}"); // Ì
        this.value.put("&igrave;", "\\`{i}"); // ì
        this.value.put("&Ograve;", "\\`{O}"); // Ò
        this.value.put("&ograve;", "\\`{o}"); // ò
        this.value.put("&Ugrave;", "\\`{U}"); // Ù
        this.value.put("&ugrave;", "\\`{u}"); // ù

        //accents acute
        this.value.put("&Aacute;", "\\'{A}"); // Á
        this.value.put("&aacute;", "\\'{a}"); // á
        this.value.put("&Eacute;", "\\'{E}"); // É
        this.value.put("&eacute;", "\\'{e}"); // é
        this.value.put("&Iacute;", "\\'{I}"); // Í
        this.value.put("&iacute;", "\\'{i}"); // í
        this.value.put("&Oacute;", "\\'{O}"); // Ó
        this.value.put("&oacute;", "\\'{o}"); // ó
        this.value.put("&Uacute;", "\\'{U}"); // Ú
        this.value.put("&uacute;", "\\'{u}"); // ú
        this.value.put("&Yacute;", "\\'{Y}"); // Ý
        this.value.put("&yacute;", "\\'{y}"); // ý

        //accents circumflex
        this.value.put("&Acirc;", "\\^{A}"); // Â
        this.value.put("&acirc;", "\\^{a}"); // â
        this.value.put("&Ecirc;", "\\^{E}"); // Ê
        this.value.put("&ecirc;", "\\^{e}"); // ê
        this.value.put("&Icirc;", "\\^{I}"); // Î
        this.value.put("&icirc;", "\\^{i}"); // î
        this.value.put("&Ocirc;", "\\^{O}"); // Ô
        this.value.put("&ocirc;", "\\^{o}"); // ô
        this.value.put("&Ucirc;", "\\^{U}"); // Û
        this.value.put("&ucirc;", "\\^{u}"); // û

        //accents tilde
        this.value.put("&Atilde;", "\\~{A}"); // Ã
        this.value.put("&atilde;", "\\~{a}"); // ã
        this.value.put("&Ntilde;", "\\~{E}"); // Ñ
        this.value.put("&ntilde;", "\\~{e}"); // ñ
        this.value.put("&Otilde;", "\\~{O}"); // Õ
        this.value.put("&otilde;", "\\~{o}"); // õ

        //accents umlaut
        this.value.put("&Auml;", "\\\"{A}"); // Ä
        this.value.put("&auml;", "\\\"{a}"); // ä
        this.value.put("&Euml;", "\\\"{E}"); // Ë
        this.value.put("&euml;", "\\\"{e}"); // ë
        this.value.put("&Iuml;", "\\\"{I}"); // Ï
        this.value.put("&iuml;", "\\\"{i}"); // ï
        this.value.put("&Ouml;", "\\\"{O}"); // Ö
        this.value.put("&ouml;", "\\\"{o}"); // ö
        this.value.put("&Uuml;", "\\\"{U}"); // Ü
        this.value.put("&uuml;", "\\\"{u}"); // ü
        this.value.put("&Yuml;", "\\\"{U}"); // Ÿ
        this.value.put("&yuml;", "\\\"{u}"); // ÿ

        //accents ring
        this.value.put("&Aring;", "\\AA"); // Å
        this.value.put("&aring;", "\\aa"); // å

        this.value.put("&AElig;", "\\AE"); // Æ
        this.value.put("&aelig;", "\\ae"); // æ
        this.value.put("&OElig;", "\\OE"); // Œ
        this.value.put("&oelig;", "\\oe"); // œ

        this.value.put("&Ccedil;", "\\c{C}"); // Ç
        this.value.put("&ccedil;", "\\c{c}"); // ç

        this.value.put("&ETH;", "\\DH"); // Ð
        this.value.put("&eth;", "\\dh"); // ð

        this.value.put("&Oslash;", "\\O"); // Ø
        this.value.put("&oslash;", "\\o"); // ø

        this.value.put("&THORN;", "\\TH");  // Þ
        this.value.put("&thorn;", "\\th");  // þ

        this.value.put("&szlig;", "\\ss"); // ß

//    '&LLL;' => '\\L', // L-
//    '&lll;' => '\\l', // l-

        this.value.put("&Scaron;", "\\v{S}"); // Š
        this.value.put("&scaron;", "\\v{s}"); // š

        this.value.put("&fnof;", "");       // ƒ

        this.value.put("&nbsp;",   "~");
        this.value.put("&#160;",   "~");
        this.value.put("&iexcl;",  "\\textexclamdown");   // ¡
        this.value.put("&cent;",   "\\cent");             // ¢
        this.value.put("&pound;",  "{\\pounds}");         // £
        this.value.put("&curren;", "\\currency");         // ¤
        this.value.put("&yen;",    "");                   // ¥
        this.value.put("&brvbar;", "");                   // ¦
        this.value.put("&sect;",   "{\\S}");              // §
        this.value.put("&uml;",    "");                   // ¨
        this.value.put("&copy;",   "{\\copyright}");      // © -- alternative: {\textcopyright}
        this.value.put("&ordf;",   "\\textordfeminine");  // ª
        this.value.put("&laquo;",  "");                   // «
        this.value.put("&not;",    "");                   // ¬
        this.value.put("&shy;",    "");                   // ­
        this.value.put("&reg;",    "{\\textregistered}"); // ®
        this.value.put("&macr;",   "");                   // ¯
        this.value.put("&deg;",    "");                   // °
        this.value.put("&plusmn;", "");                   // ±
        this.value.put("&sup2;",   "");                   // ²
        this.value.put("&sup3;",   "");                   // ³
        this.value.put("&acute;",  "");                   // ´
        this.value.put("&micro;",  "");                   // µ
        this.value.put("&para;",   "\\P");                // ¶
        this.value.put("&middot;", "");                   // ·
        this.value.put("&cedil;",  "");                   // ¸
        this.value.put("&sup1;",   "");                   // ¹
        this.value.put("&ordm;",   "\\textordmasculine"); // º
        this.value.put("&raquo;",  "");                   // »
        this.value.put("&frac14;", "");                   // ¼
        this.value.put("&frac12;", "");                   // ½
        this.value.put("&frac34;", "");                   // ¾
        this.value.put("&iquest;", "\\textquestiondown"); // ¿
        this.value.put("&times;",  "");                   // ×
        this.value.put("&divide;", "");                   // ÷

        //technical symbols
        this.value.put("&lceil;",  "");
        this.value.put("&rceil;",  "");
        this.value.put("&lfloor;", "");
        this.value.put("&rfloor;", "");
        this.value.put("&lang;",   "");
        this.value.put("&rang;",   "");

        //arrow symbols
        this.value.put("&larr;",   "\\(\\leftarrow{}\\)");
        this.value.put("&uarr;",   "\\(\\uparrow\\)");
        this.value.put("&rarr;",   "\\(\\rightarrow{}\\)");
        this.value.put("&darr;",   "\\(\\downarrow{}\\)");
        this.value.put("&harr;",   "\\(\\leftrightarrow{}\\)");
        this.value.put("&crarr;",  "");
        this.value.put("&lArr;",   "\\(\\Leftarrow{}\\)");
        this.value.put("&uArr;",   "\\(\\Uparrow\\)");
        this.value.put("&rArr;",   "\\(\\Rightarrow{}\\)");
        this.value.put("&dArr;",   "\\(\\Downarrow{}\\)");
        this.value.put("&hArr;",   "\\(\\Leftrightarrow{}\\)");

        //symbols misc
        this.value.put("&bull;",    ""); // •
        this.value.put("&prime;",   ""); // '
        this.value.put("&Prime;",   "");
        this.value.put("&oline;",   "");
        this.value.put("&frasl;",   "");
        this.value.put("&weierp;",  "");
        this.value.put("&image;",   "");
        this.value.put("&real;",    "");
        this.value.put("&trade;",   "{\\texttrademark}"); // ™
        this.value.put("&euro;",    "{\\euro}");          // €
        this.value.put("&alefsym;", "");
        this.value.put("&spades;",  "");
        this.value.put("&clubs;",   "");
        this.value.put("&hearts;",  "");
        this.value.put("&diams;",   "");

        //punctation
        this.value.put("&ensp;",    "");
        this.value.put("&emsp;",    "");
        this.value.put("&thinsp;",  "");
        this.value.put("&zwnj;",    "");
        this.value.put("&zwj;",     "");
        this.value.put("&lrm;",     "");
        this.value.put("&rlm;",     "");
        this.value.put("&ndash;",   "--");       // –
        this.value.put("&mdash;",   "---");      // —
        this.value.put("&dagger;",  "\\dag");    // †
        this.value.put("&Dagger;",  "\\ddag");   // ‡
        this.value.put("&hellip;",  "{\\dots}"); // …
        this.value.put("&permil;",  "");         // ‰

        //mathematical signs
        this.value.put("&forall;",  "$\\forall$");
        this.value.put("&part;",    "");
        this.value.put("&exist;",   "$\\exists$");
        this.value.put("&empty;",   "");
        this.value.put("&nabla;",   "");
        this.value.put("&isin;",    "$\\in$");
        this.value.put("&notin;",   "$\\notin$");
        this.value.put("&ni;",      "");
        this.value.put("&prod;",    "$\\prod$");
        this.value.put("&sum;",     "$\\sum$");
        this.value.put("&minus;",   "");
        this.value.put("&lowast;",  "");
        this.value.put("&radic;",   "");
        this.value.put("&prop;",    "");
        this.value.put("&infin;",   "$infty$");
        this.value.put("&ang;",     "");
        this.value.put("&and;",     "$\\wedge$");
        this.value.put("&or;",      "$\\vee$");
        this.value.put("&cap;",     "$\\cap$");
        this.value.put("&cup;",     "$\\cup$");
        this.value.put("&int;",     "");
        this.value.put("&there4;",  "");
        this.value.put("&sim;",     "");
        this.value.put("&cong;",    "");
        this.value.put("&asymp;",   "$\\approx{}$");
        this.value.put("&ne;",      "$\\neq$");
        this.value.put("&equiv;",   "");
        this.value.put("&le;",      "$\\leq$");
        this.value.put("&ge;",      "$\\geq$");
        this.value.put("&sub;",     "");
        this.value.put("&sup;",     "");
        this.value.put("&nsub;",    "");
        this.value.put("&sube;",    "");
        this.value.put("&supe;",    "");
        this.value.put("&oplus;",   "");
        this.value.put("&otimes;",  "");
        this.value.put("&perp;",    "");
        this.value.put("&sdot;",    "");
        this.value.put("&loz;",     "");

        //greek characters
        this.value.put("&Alpha;",   "A");
        this.value.put("&alpha;",   "\\alpha");
        this.value.put("&Beta;",    "B");
        this.value.put("&beta;",    "\\beta");
        this.value.put("&Gamma;",   "\\Gamma");
        this.value.put("&gamma;",   "\\gamma");
        this.value.put("&Delta;",   "\\Delta");
        this.value.put("&delta;",   "\\delta");
        this.value.put("&Epsilon;", "E");
        this.value.put("&epsilon;", "\\epsilon");
        this.value.put("&Zeta;",    "Z");
        this.value.put("&zeta;",    "\\zeta");
        this.value.put("&Eta;",     "H");
        this.value.put("&eta;",     "\\eta");
        this.value.put("&Theta;",   "\\Theta");
        this.value.put("&theta;",   "\\theta");
        this.value.put("&thetasym;","\\vartheta");
        this.value.put("&Iota;",    "I");
        this.value.put("&iota;",    "\\iota");
        this.value.put("&Kappa;",   "K");
        this.value.put("&kappa;",   "\\kappa");
        this.value.put("&Lambda;",  "\\Lambda");
        this.value.put("&lambda;",  "\\lambda");
        this.value.put("&Mu;",      "M");
        this.value.put("&mu;",      "\\mu");
        this.value.put("&Nu;",      "N");
        this.value.put("&nu;",      "\\nu");
        this.value.put("&Xi;",      "\\Xi");
        this.value.put("&xi;",      "\\xi");
        this.value.put("&Omicron;", "O");
        this.value.put("&omicron;", "o");
        this.value.put("&Pi;",      "\\Pi");
        this.value.put("&pi;",      "\\pi");
        this.value.put("&Rho;",     "P");
        this.value.put("&rho;",     "\\rho");
        this.value.put("&Sigma;",   "\\Sigma");
        this.value.put("&sigma;",   "\\sigma");
        this.value.put("&sigmaf;",  "\\varsigma");
        this.value.put("&Tau;",     "T");
        this.value.put("&tau;",     "\\tau");
        this.value.put("&Upsilon;", "\\Upsilon");
        this.value.put("&upsilon;", "\\upsilon");
        this.value.put("&Phi;",     "\\Phi");
        this.value.put("&phi;",     "\\phi");
        this.value.put("&piv;",	    "\\varpi");
        this.value.put("&Chi;",     "X");
        this.value.put("&chi;",     "\\chi");
        this.value.put("&Psi;",     "\\Psi");
        this.value.put("&psi;",     "\\psi");
        this.value.put("&Omega;",   "\\Omega");
        this.value.put("&omega;",   "\\omega");
        this.value.put("&upsih;",   "");
	}
}
