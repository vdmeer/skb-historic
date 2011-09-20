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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class CPP {
	public static void main (String[] args) throws IOException {
		String fin=null;
		String fout=null;
		PrintWriter cppOut;

		if(args.length>2){
			System.err.println("cpp: to many arguments");
			CPP.usage();
			return;
		}
//		else if(args.length==0){
//			System.err.println("cpp: to few arguments");
//			CPP.usage();
//			return;
//		}
		else if(args.length==1){
			fin=args[0];
		}
		else if(args.length==2){
			fin=args[0];
			fout=args[1];
		}

		if(fin==null){
    		File temp=File.createTempFile("_cpp_fin", "cpp");
    		temp.deleteOnExit();
    		PrintWriter pwOut=new PrintWriter(new FileWriter(temp));

			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s=in.readLine())!=null)
				pwOut.println(s);
			pwOut.flush();
			pwOut.close();
			fin=temp.getAbsolutePath();
		}

		if(fout!=null){
    		File temp=new File(fout);
			cppOut=new PrintWriter(new FileWriter(temp));
		}
		else{
			cppOut=new PrintWriter(System.out);
		}

		new CPP().parse_initial(fin, cppOut);
	}

	public static void usage(){
		
	}

	public void parse_initial(String fin, PrintWriter fout) {
		CPPDefinedTerms definitions=CPPDefinedTerms.getInstance();
		definitions.defs.clear();
		this.parse(fin, fout);
	}

	public void parse(String fin, PrintWriter fout) {
    	try {
    		int curLine=1;
    		CPPLexer lexer=new CPPLexer();
    		CommonTokenStream tokens=new CommonTokenStream(lexer);
    		CPPParser parser=new CPPParser(tokens);

    		FileInputStream fstream=new FileInputStream(fin);
    	    DataInputStream in=new DataInputStream(fstream);
    	    BufferedReader br=new BufferedReader(new InputStreamReader(in));
    	    String line;

    	    CPPDefinedTerms definitions=CPPDefinedTerms.getInstance();
    	    boolean ignoreUntilEndif=false;

    	    fout.println("#file \""+fin+":"+curLine+"\"");
    	    while((line=br.readLine())!=null){
    	    	curLine++;
    	    	if(line.startsWith("#")){
    	    		lexer.reset();
    	    		lexer.setCharStream(new ANTLRStringStream(line));
    	    		tokens=new CommonTokenStream(lexer);
    	    		parser=new CPPParser(tokens);
    	    		CPPParser.start_return result=parser.start();
    	    		Tree t=(Tree)result.getTree();
    	    		if(t.getText()=="CPP_RULE"&&t.getChildCount()>0){
    	    			t=t.getChild(0);
    	    			String _switch=t.getText();

    	    			if(_switch.equalsIgnoreCase("include")){
        	    			if(ignoreUntilEndif==true)
        	    				continue;
        	    			if(t.getChildCount()==0){
        	    				System.err.println("cpp: include without an include file");
        	    			}
        	    			else{
        	    				String fn=fin.substring(0,fin.lastIndexOf("/")+1)+t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1);
        	    				fout.flush();
        	    				CPP _cpp=new CPP();
        	    				_cpp.parse(fn, fout);
        	    				fout.println("#file \""+fin+":"+curLine+"\"");
        	    			}
        	    		}
        	    		else if(_switch.equalsIgnoreCase("define")){
        	    			if(ignoreUntilEndif==true)
        	    				continue;
        	    			if(t.getChildCount()==0)
        	    				System.err.println("cpp: #define without definition");
        	    			else
        	    				definitions.defs.add(t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1));
        	    		}
        	    		else if(_switch.equalsIgnoreCase("undef")){
        	    			if(ignoreUntilEndif==true)
        	    				continue;
        	    			if(t.getChildCount()==0)
        	    				System.err.println("cpp: #undef without definition");
        	    			else
        	    				definitions.defs.remove(t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1));
        	    		}
        	    		else if(_switch.equalsIgnoreCase("ifdef")){
        	    			if(ignoreUntilEndif==true)
        	    				continue;
        	    			if(t.getChildCount()==0)
        	    				System.err.println("cpp: #ifdef without a term");
        	    			else{
        	    				if(!definitions.defs.contains(t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1)))
        	    					ignoreUntilEndif=true;
        	    			}
        	    		}
        	    		else if(_switch.equalsIgnoreCase("ifndef")){
        	    			if(ignoreUntilEndif==true)
        	    				continue;
        	    			if(t.getChildCount()==0)
        	    				System.err.println("cpp: #ifndef without a term");
        	    			else{
        	    				if(definitions.defs.contains(t.getChild(0).toString().substring(1,t.getChild(0).toString().length()-1)))
    	    						ignoreUntilEndif=true;
        	    			}
        	    		}
        	    		else if(_switch.equalsIgnoreCase("endif")){
        	    			ignoreUntilEndif=false;
        	    			continue;
        	    		}
    	    		}
    	    	}
    	    	else{
    	    		if(ignoreUntilEndif==false)
    	    			fout.println(line);
    	    	}
    	    }
    	    in.close();
    	    fout.flush();
        } catch (FileNotFoundException fn) {
        	System.err.println("cpp: can't open include file <" + fin + ">");
        	//System.err.println("cpp: " + fn.toString());
        	System.exit(-9);
        } catch(Exception e) {
        	System.err.println("cpp: "+e.toString());
        }
    }
}
