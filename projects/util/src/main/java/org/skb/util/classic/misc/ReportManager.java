/* Copyright (c) 2005-2011 Sven van der Meer
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
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.composite.util.TSArrayList;
import org.skb.util.stringtemplate.STGroupManager;

/**
 * A report manager with extended functionality for parsers/compilers.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ReportManager{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(ReportManager.class);

	/** Number of reported errors */
	protected int noOfErrors=0;

	/** Number of reported warnings */
	protected int noOfWarnings=0;

	/** Report warnings? */
	protected boolean noWarnings;

	/** Report errors? */
	protected boolean noErrors;

	/** File name used for reporting */
	protected String fileFN;

	/** Programme name used for reporting */
	protected String applicationName;

	/** The manager for the StringTemplate */
	protected STGroupManager stgm;


	/**
	 * Class constructor, initialises members
	 */
	public ReportManager() {
		super();
		this._init();
	}


	/**
	 * Initialise the report manager
	 * 
	 * This method adds the required chunks for testing the StringTemplate and initialises local members. The default lexer is AngelB,
	 * noErrors and noWarnings are set to false, the file name is set to an empty string and the programme name is set to "tribe". 
	 */
	private void _init(){
		this.stgm=new STGroupManager();
		this.stgm.putMandatoryChunks("report", new TSArrayList(new String[]{"name", "file", "line", "column", "message", "type"}));
		this.stgm.putOptionalChunks("error100", new TSArrayList(new String[]{"name"}));
		this.stgm.useLexerAngelB();

		this.setFileName("");
		this.applicationName="tribe";

		this.noErrors=false;
		this.noWarnings=false;
	}


	/**
	 * Set the file name for reporting
	 * @param fn
	 */
	public void setFileName(String fn){
		this.fileFN=(new File(fn)).getName();
	}


	/**
	 * Return the currently set file name
	 * @return currently set file name
	 */
	public String getFileName(){
		return this.fileFN;
	}


	/**
	 * Set the boolean for error handling.
	 * 
	 * True means errors will be reported, false means they will not be reported
	 * @param b
	 */
	public void doErrors(boolean b){
		this.noErrors=b;
	}


	/**
	 * Set the boolean for warning handling.
	 * 
	 * True means warnings will be reported, false means they will not be reported
	 * @param b
	 */
	public void doWarnings(boolean b){
		this.noWarnings=b;
	}


	/**
	 * Set the programme name to be used for reporting
	 * @param p
	 */
	public boolean setApplicationName(String p){
		boolean ret=true;
		if(p!=null){
			this.applicationName=new String(p);
			this.stgm.setApplicationName(p);
		}
		else{
			ret=false;
		}
		return ret;
	}


	/**
	 * Set the programme name to be used for reporting
	 * @param p
	 */
	public boolean setApplicationName(TSBaseAPI p){
		boolean ret=true;
		if(p!=null&&p.tsIsType(TEnum.TS_ATOMIC_JAVA_STRING)){
			this.applicationName=p.toString();
			this.stgm.setApplicationName(p);
		}
		else{
			ret=false;
		}
		return ret;
	}


	/**
	 * Return the number of errors reported since the last initialisation
	 * @return number of errors reported since the last initialisation
	 */
	public int noOfErrors(){
		return this.noOfErrors;
	}


	/**
	 * Set the number of errors to zero
	 */
	public void resetNoOfErrors(){
		this.noOfErrors=0;
	}


	/**
	 * Return the number of warnings reported since the last initialisation
	 * @return number of warnings reported since the last initialisation
	 */
	public int noOfWarnings(){
		return this.noOfWarnings;
	}


	/**
	 * Set the number of warnings to zero
	 */
	public void resetNoOfWarnings(){
		this.noOfWarnings=0;
	}


	/**
	 * Report an error or a warning
	 * 
	 * This is the method that does all reporting, all other error, warning or message methods redirect to here.
	 * @param msgType type of message, either "warning" or "error"
	 * @param message message to be reported
	 * @param add additional message to be reported
	 * @param line line in which the error/warning occurred
	 * @param column column in which the error/warning occurred
	 */
	public void report(String msgType, String message, String add, int line, int column){
		if(msgType=="warning")
			this.noOfWarnings++;
		if(msgType=="error")
			this.noOfErrors++;

		if(msgType=="warning"&&this.noWarnings==true)
			return;
		if(msgType=="error"&&this.noErrors==true)
			return;

		StringTemplateGroup group=this.stgm.getSTG();
		if(group==null)
			return;

		StringTemplate template=group.getInstanceOf("report");
		template.setAttribute("name", this.applicationName);

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
			StringTemplate error100 = group.getInstanceOf("error100");
			error100.setAttribute("name", this.applicationName);
			System.err.print(error100);
			System.exit(1);
		}
	}


	/**
	 * Report an error from string with additional information
	 * 
	 * File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param add additional message to be reported
	 * @param line line in which the error occurred
	 * @param column column in which the error occurred
	 */
	public void reportError(String m, String add, int line, int column){
		this.report("error", m, add, line, column);
	}


	/**
	 * Report an error from Token with additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param t token at which the error occurred
	 * @param add additional message to be reported
	 */
	public void reportError(String m, Token t, String add){
		this.reportError(m, add, t.getLine(), t.getCharPositionInLine());
	}


	/**
	 * Report an error from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param t token at which the error occurred
	 */
	public void reportError(String m, Token t){
		this.reportError(m, t, null);
	}


	/**
	 * Report a simple error message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 */
	public void reportError(String m){
		this.reportError(m, null, -1, -1);
	}


	/**
	 * Report a simple error message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param add additional message to be reported
	 */
	public void reportError(String m, String add){
		this.reportError(m, add, -1, -1);
	}


	/**
	 * Report a simple error message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 */
	public void reportErrorNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.reportError(m);
		this.fileFN=t;
	}


	/**
	 * Report an error message with an ANTLR exception without additional information
	 * 
	 * Line number and column will extracted from the exception. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param re associated ANTLR exception
	 */
	public void reportError(String m, org.antlr.runtime.RecognitionException re){
		this.reportError(m, null, re.line, re.charPositionInLine);
	}


	/**
	 * Report a message from string with additional information
	 * 
	 * File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param add additional message to be reported
	 * @param line line to which the message corresponds
	 * @param column column to which the message corresponds
	 */
	public void reportMessage(String m, String add, int line, int column){
		this.report(null, m, add, line, column);
	}


	/**
	 * Report a message from Token with additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param t token to which the message corresponds
	 * @param add additional message to be reported
	 */
	public void reportMessage(String m, Token t, String add){
		this.reportMessage(m, add, t.getLine(), t.getCharPositionInLine());
	}


	/**
	 * Report a message from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param t token to which the message corresponds
	 */
	public void reportMessage(String m, Token t){
		this.reportMessage(m, t, null);
	}


	/**
	 * Report a simple message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 */
	public void reportMessage(String m){
		this.reportMessage(m, null, -1, -1);
	}


	/**
	 * Report a simple message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param add additional message to be reported
	 */
	public void reportMessage(String m, String add){
		this.reportMessage(m, add, -1, -1);
	}


	/**
	 * Report a simple message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 */
	public void reportMessageNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.reportMessage(m);
		this.fileFN=t;
	}


	/**
	 * Report a warning from string with additional information
	 * 
	 * File name and programme name will be used as set (either default or last change).
	 * @param m warning to be reported
	 * @param add additional message to be reported
	 * @param line line in which the warning occurred
	 * @param column column in which the warning occurred
	 */
	public void reportWarning(String m, String add, int line, int column){
		this.report("warning", m, add, line, column);
	}


	/**
	 * Report a warning from Token with additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 * @param t token at which the warning occurred
	 * @param add additional message to be reported
	 */
	public void reportWarning(String m, Token t, String add){
		this.reportWarning(m, add, t.getLine(), t.getCharPositionInLine());
	}


	/**
	 * Report a warning from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 * @param t token at which the warning occurred
	 */
	public void reportWarning(String m, Token t){
		this.reportWarning(m, t, null);
	}


	/**
	 * Report a simple warning message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 */
	public void reportWarning(String m){
		this.reportWarning(m, null, -1, -1);
	}


	/**
	 * Report a simple warning message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 * @param add additional message to be reported
	 */
	public void reportWarning(String m, String add){
		this.reportWarning(m, add, -1, -1);
	}
	

	/**
	 * Report a simple warning message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 */
	public void reportWarningNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.reportWarning(m);
		this.fileFN=t;
	}


	/**
	 * @see STGroupManager#setSTGFile(TSBaseAPI)
	 */
	public boolean setSTGFileName(TSBaseAPI fn){
		return this.stgm.setSTGFile(fn);
	}


	/**
	 * @see STGroupManager#loadSTG(String, String)
	 */
	public boolean loadSTG(String purpose, String targetLang){
		return this.stgm.loadSTG(purpose, targetLang);
	}


	/**
	 * Returns the manager's STGroup
	 * @return null if not set or not initialised, STGroup otherwise
	 */
	public StringTemplateGroup getSTG(){
		return this.stgm.getSTG();
	}


	public String stgmToString(){
		return this.stgm.toString();
	}

}