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

package org.skb.lang.cpp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.skb.lang.cpp.grammars.CPPLexer;
import org.skb.lang.cpp.grammars.CPPParser;

/**
 * This class is the Tribe preprocessor. It is automatically called if preprocessing is requested.
 * The grammar, Preprosessor.g, supports all POSIX preprocessor rules, however the current class
 * only implements the "import" directive. 
 * 
 * The class reads the input stream, parses the input and if include directive is discovered creates
 * a new instance of itself with the filename as new inputstream.
 * 
 * Output is a stream, containing all lines from the original input stream and all included files
 * separated by the directive '#file "<filename>":<line>'. The location of the stream must be provided by
 * the calling class as PrintWriter.
 *  
 * @author     Sven van der Meer
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class CPP {
    public void parse(String fin, PrintWriter fout) {
    	try {
    		int curLine=1;
    		CPPLexer lexer = new CPPLexer();
    		CommonTokenStream tokens = new CommonTokenStream(lexer);
    		CPPParser parser = new CPPParser(tokens);

    		FileInputStream fstream = new FileInputStream(fin);
    	    DataInputStream in = new DataInputStream(fstream);
    	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    	    String line;

    	    fout.println("#file \""+fin+":"+curLine+"\"");
    	    while ((line = br.readLine()) != null){
    	    	curLine++;
    	    	if(line.startsWith("#")){
    	    		lexer.reset();
    	    		lexer.setCharStream(new ANTLRStringStream(line));
    	    		tokens = new CommonTokenStream(lexer);
    	    		parser = new CPPParser(tokens);
    	    		CPPParser.start_return result = parser.start();
    	    		Tree t = (Tree)result.getTree();
    	    		String _switch=t.getText();
    	    		if(_switch.equalsIgnoreCase("include")){
    	    			String fn=t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1);
    	    			fout.flush();
    	    			CPP _cpp=new CPP();
    	    			_cpp.parse(fn, fout);
    	    			fout.println("#file \""+fin+":"+curLine+"\"");
    	    		}
    	    		else if(_switch.equalsIgnoreCase("define")){
    	    			//System.out.println("define var "+t.getChild(0));
    	    		}
    	    		else if(_switch.equalsIgnoreCase("undef")){
    	    			//System.out.println("un-define var "+t.getChild(0));
    	    		}
    	    	}
    	    	else
    	    		fout.println(line);
    	    }
    	    in.close();
    	    fout.flush();
        } catch (FileNotFoundException fn) {
        	System.err.println("cpp: can't open include file <" + fin + ">");
        	System.err.println("cpp: " + fn.toString());
        	System.exit(-9);
        }
    	  catch(Exception e) {
        	System.err.println("cpp: "+e.toString());
        }
    }
}
