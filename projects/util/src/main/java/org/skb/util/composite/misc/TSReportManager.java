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

package org.skb.util.composite.misc;

import java.io.File;

import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.util.ConfigKeys;
import org.skb.util.composite.TSAtomic;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.TSDefault;
import org.skb.util.composite.TSRepository;
import org.skb.util.composite.TSRepository.TEnum;
import org.skb.util.composite.antlr.TSSTGroupManager;
import org.skb.util.composite.util.TSArrayList;

/**
 * The SKB Report Manager.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSReportManager extends TSAtomic {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSReportManager.class);

	/** Report Manager Logger instance for normal information */
	public final static Logger reportInfo=Logger.getLogger(ConfigKeys.configLoggerReportmanagerInfo);

	/** Report Manager Logger instance for error messages */
	public final static Logger reportError=Logger.getLogger(ConfigKeys.configLoggerReportmanagerErrors);

	/** Report Manager Logger instance for warnings */
	public final static Logger reportWarn=Logger.getLogger(ConfigKeys.configLoggerReportmanagerWarnings);

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
	protected TSSTGroupManager stgm;

	/**
	 * Class constructor.
	 * 
	 * Adds the required chunks for testing the StringTemplate and initialises local members. The default lexer is AngelB,
	 * noErrors and noWarnings are set to false, the file name is set to an empty string and the programme name is set to "tribe". 
	 */
	public TSReportManager(){
		this._init();
	}

	public TSReportManager(TSReportManager rm){
		this._init();

		this.stgm=new TSSTGroupManager(rm.stgm);
		this.noOfErrors=rm.noOfErrors;
		this.noOfWarnings=rm.noOfWarnings;
		this.noWarnings=rm.noWarnings;
		this.noErrors=rm.noErrors;
		this.fileFN=new String(rm.fileFN);
		this.applicationName=new String(rm.applicationName);
	}

	private void _init(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC_REPORTMANAGER);
		this.typeEnum.add(TEnum.TS_ATOMIC_REPORTMANAGER);

		this.stgm=new TSSTGroupManager();
		this.stgm.putMandatoryChunks("report", new TSArrayList(new String[]{"name", "file", "line", "column", "message", "type"}));
		this.stgm.putMandatoryChunks("error100", new TSArrayList(new String[]{"name"}));
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

		if(msgType=="error")
			reportError.error(template.toString());
		else if(msgType=="warning")
			reportWarn.warn(template.toString());
		else
			reportInfo.info(template.toString());

		if(msgType=="error"&&this.noOfErrors>100){
			StringTemplate error100 = group.getInstanceOf("error100");
			error100.setAttribute("name", this.applicationName);
			reportWarn.warn(error100.toString());
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
	public void error(String m, String add, int line, int column){
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
	public void error(String m, Token t, String add){
		this.error(m, add, t.getLine(), t.getCharPositionInLine());
	}

	/**
	 * Report an error from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param t token at which the error occurred
	 */
	public void error(String m, Token t){
		this.error(m, t, null);
	}

	/**
	 * Report a simple error message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 */
	public void error(String m){
		this.error(m, null, -1, -1);
	}

	/**
	 * Report a simple error message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param add additional message to be reported
	 */
	public void error(String m, String add){
		this.error(m, add, -1, -1);
	}

	/**
	 * Report a simple error message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 */
	public void errorNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.error(m);
		this.fileFN=t;
	}

	/**
	 * Report an error message with an ANTLR exception without additional information
	 * 
	 * Line number and column will extracted from the exception. File name and programme name will be used as set (either default or last change).
	 * @param m error message to be reported
	 * @param re associated ANTLR exception
	 */
	public void error(String m, org.antlr.runtime.RecognitionException re){
		this.error(m, null, re.line, re.charPositionInLine);
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
	public void message(String m, String add, int line, int column){
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
	public void message(String m, Token t, String add){
		this.message(m, add, t.getLine(), t.getCharPositionInLine());
	}

	/**
	 * Report a message from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param t token to which the message corresponds
	 */
	public void message(String m, Token t){
		this.message(m, t, null);
	}

	/**
	 * Report a simple message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 */
	public void message(String m){
		this.message(m, null, -1, -1);
	}

	/**
	 * Report a simple message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 * @param add additional message to be reported
	 */
	public void message(String m, String add){
		this.message(m, add, -1, -1);
	}

	/**
	 * Report a simple message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m message to be reported
	 */
	public void messageNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.message(m);
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
	public void warning(String m, String add, int line, int column){
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
	public void warning(String m, Token t, String add){
		this.warning(m, add, t.getLine(), t.getCharPositionInLine());
	}

	/**
	 * Report a warning from Token without additional information
	 * 
	 * The line and column are extracted from the token. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 * @param t token at which the warning occurred
	 */
	public void warning(String m, Token t){
		 this.warning(m, t, null);
	}

	/**
	 * Report a simple warning message
	 * 
	 * No additional information will be reported, and line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 */
	public void warning(String m){
		this.warning(m, null, -1, -1);
	}

	/**
	 * Report a simple warning message with additional information
	 * 
	 * Line number and column will not be used in the report. File name and programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 * @param add additional message to be reported
	 */
	public void warning(String m, String add){
		this.warning(m, add, -1, -1);
	}

	/**
	 * Report a simple warning message without a file name
	 * 
	 * Programme name will be used as set (either default or last change).
	 * @param m warning message to be reported
	 */
	public void warningNoFile(String m){
		String t=this.fileFN;
		this.fileFN=null;
		this.warning(m);
		this.fileFN=t;
	}

	/**
	 * @see TSSTGroupManager#setSTGFile(TSBaseAPI)
	 */
	public boolean setSTGFileName(TSBaseAPI fn){
		return this.stgm.setSTGFile(fn);
	}

	/**
	 * @see TSSTGroupManager#loadSTG(String, String)
	 */
	public TSDefault loadSTG(String purpose, String targetLang){
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

	@Override
	public TSReportManager tsCopyAtomic(){
		TSReportManager ret=new TSReportManager(this);
		return ret;
	}

}
