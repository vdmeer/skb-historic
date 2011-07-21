/* Copyright (c) 2007-2011 Sven van der Meer
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

package org.skb.util.misc;

import java.io.File;

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.skb.util.stringtemplate.STGManager;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * A report manager with extended functionality for parsers/compilers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class ReportManager extends STGManager{
	private int noOfErrors=0;
	private int noOfWarnings=0;

	private boolean noWarnings;
	private boolean noErrors;

	private String fileFN;
	private String progName;

	private ReportManager() {
		super();
		this.chunksMandatory=new TSMapLH();
		this.chunksOptional=new TSMapLH();

		this.chunksMandatory.put("report",    new TSArrayListString(new String[]{"name", "file", "line", "column", "message", "type"}));
		this.chunksMandatory.put("error100",  new TSArrayListString(new String[]{"name"}));

		this.setFileName("");
		this.progName="tribe";

		this.noErrors=false;
		this.noWarnings=false;

		this.useLexerAngelB=true;
	}

	private static class ReportManagerHolder{
		private final static ReportManager INSTANCE = new ReportManager();
	}

	public static ReportManager getInstance(){
		return ReportManagerHolder.INSTANCE;
	}

	public void setFileName(String fn){this.fileFN=(new File(fn)).getName();}
	public String getFileName(){return this.fileFN;}

	public void doErrors(boolean b){this.noErrors=b;}
	public void doWarnings(boolean b){this.noWarnings=b;}

	public void setProgrammeName(String p){this.progName=p;}

	public int noOfErrors(){return this.noOfErrors;}
	public void resetNoOfErrors(){this.noOfErrors=0;}
	public int noOfWarnings(){return this.noOfWarnings;}
	public void resetNoOfWarnings(){this.noOfWarnings=0;}

	public void report(String msgType, String message, String add, int line, int column){
		if(msgType=="warning")
			this.noOfWarnings++;
		if(msgType=="error")
			this.noOfErrors++;

		if(msgType=="warning"&&this.noWarnings==true)
			return;
		if(msgType=="error"&&this.noErrors==true)
			return;

		if(this.stg==null)
			return;

		StringTemplate template=this.stg.getInstanceOf("report");
		template.setAttribute("name", this.progName);

		if(add!=null)
			template.setAttribute("add", add);
		if(msgType!=null)
			template.setAttribute("type", msgType);
		if(this.fileFN!=null)
			template.setAttribute("file", this.fileFN);
		if(line!=-1)
			template.setAttribute("line", line);
		if(column!=-1)
			template.setAttribute("column", column);
		if(message!=null)
			template.setAttribute("message", message);

		if(msgType=="error"){
			System.err.print(template);
			System.err.flush();
		}
		else{
			System.out.print(template);
			System.out.flush();
		}

		if(msgType=="error"&&this.noOfErrors>100){
			StringTemplate error100 = this.stg.getInstanceOf("error100");
			error100.setAttribute("name", this.progName);
			System.err.print(error100);
			System.exit(1);
		}
	}

	public void reportError(String m, String add, int line, int column){this.report("error", m, add, line, column);}
	public void reportError(String m, Token t, String add){this.reportError(m, add, t.getLine(), t.getCharPositionInLine());}
	public void reportError(String m, Token t){this.reportError(m, t, null);}
	public void reportError(String m){this.reportError(m, null, -1, -1);}
	public void reportError(String m, String add){this.reportError(m, add, -1, -1);}
	public void reportErrorNoFile(String m){String t=this.fileFN; this.fileFN=null; this.reportError(m); this.fileFN=t;}
	public void reportError(String m, org.antlr.runtime.RecognitionException re){this.reportError(m, null, re.line, re.charPositionInLine);}

	public void reportMessage(String m, String add, int line, int column){this.report(null, m, add, line, column);}
	public void reportMessage(String m, Token t, String add){this.reportMessage(m, add, t.getLine(), t.getCharPositionInLine());}
	public void reportMessage(String m, Token t){this.reportMessage(m, t, null);}
	public void reportMessage(String m){this.reportMessage(m, null, -1, -1);}
	public void reportMessage(String m, String add){this.reportMessage(m, add, -1, -1);}
	public void reportMessageNoFile(String m){String t=this.fileFN; this.fileFN=null; this.reportMessage(m); this.fileFN=t;}

	public void reportWarning(String m, String add, int line, int column){this.report("warning", m, add, line, column);}
	public void reportWarning(String m, Token t, String add){this.reportWarning(m, add, t.getLine(), t.getCharPositionInLine());}
	public void reportWarning(String m, Token t){this.reportWarning(m, t, null);}
	public void reportWarning(String m){this.reportWarning(m, null, -1, -1);}
	public void reportWarning(String m, String add){this.reportWarning(m, add, -1, -1);}
	public void reportWarningNoFile(String m){String t=this.fileFN; this.fileFN=null; this.reportWarning(m); this.fileFN=t;}
}