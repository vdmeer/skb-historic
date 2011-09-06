/* Copyright (c) 2008-2011 Sven van der Meer
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

package org.skb.util.io.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSBoolean;

/**
 * A manager for file lists to prepare output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class FileManager {
	static Logger logger;


	/**
	 * Header for code files, will prepend all other content
	 */
	private StringTemplate codeHeader;


	/**
	 * 
	 */
	private StringTemplate fileStart;


	/**
	 * 
	 */
	private StringTemplate fileEnd;


	/**
	 * Source language, i.e. cola, pola, dal, glue
	 */
	private String sourceLanguage=null;


	/**
	 * Source file
	 */
	private String sourceFile=null;


	/**
	 * Target language, i.e. xml, sql, java
	 */
	private String targetLanguage=null;


	/**
	 * Standard file extension for target files
	 */
	private String targetFileExtension=null;


	/**
	 * Boolean determining if files can be printed or not, default is false
	 */
	private TSBoolean canPrint;


	/**
	 * Class constructor, requires code header, file start and file end paramters
	 * @param codeHeader the header to be added to each code file
	 * @param fileStart a start text for files
	 * @param fileEnd a final text for files
	 */
	public FileManager(StringTemplate codeHeader, StringTemplate fileStart, StringTemplate fileEnd){
		logger=Logger.getLogger(FileManager.class);

		this.codeHeader=codeHeader;
		this.fileStart=fileStart;
		this.fileEnd=fileEnd;

		this.canPrint=new TSBoolean((false));
	}


	/**
	 * Initialisation of the File Manager
	 * @param srcLang source language
	 * @param srcFile source file name
	 * @param tgtLang target language
	 * @param tgtFileExt target file extension
	 * @param canPrint can print boolean
	 */
	public void init(TSBase srcLang, TSBase srcFile, TSBase tgtLang, TSBase tgtFileExt, TSBase canPrint){
		if(srcLang!=null)
			this.sourceLanguage=srcLang.toString();
		if(srcFile!=null)
			this.sourceFile=srcFile.toString();
		if(tgtLang!=null)
			this.targetLanguage=tgtLang.toString();
		if(tgtFileExt!=null)
			this.targetFileExtension=tgtFileExt.toString();
		if(canPrint!=null)
			this.canPrint=(TSBoolean)canPrint;

		if(this.sourceLanguage==null||this.sourceFile==null||this.targetLanguage==null||this.targetFileExtension==null)
			this.canPrint=new TSBoolean((false));
	}


	/**
	 * Write the given file list
	 * @param list list of file names and associated templates
	 * @return true if successful, false otherwise
	 */
	public boolean writeList(FileTemplateList list){
		if(canPrint()==false)
			return false;
		for (Map.Entry<String, FileTemplateSingle> e : list.entrySet())
			this.writeSingleFileFromList(list.getDir(e.getKey()), list.getFile(e.getKey())+this.targetFileExtension, e.getValue());
		return true;
	}


	/**
	 * Write a single file
	 * @param dir target directory
	 * @param file target file name
	 * @param fts template to be written
	 * @return true if successful, false otherwise
	 */
	private boolean writeSingleFileFromList(String dir, String file, FileTemplateSingle fts){
		if(canPrint()==false)
			return false;

		if(dir!=null){
			File outputDir = new File(dir);
			outputDir.mkdirs();
		}
		File outputFile=new File(dir+System.getProperty("file.separator")+file);
		FileWriter aout;
		LinkedHashSet<StringTemplate> set=fts.getTemplates();
		try{
			aout=new FileWriter(outputFile);
			aout.write(this.stdFileStart());
			aout.write(this.stdHeader(fts.getMisc()));
			for (Iterator<StringTemplate> it=set.iterator(); it.hasNext(); ){
				StringTemplate ao = it.next();
				aout.write(ao.toString());
				aout.write("\n");
			}
			aout.write(stdFileEnd());
			aout.write("\r\n");
			aout.flush();
			aout.close();
		}  catch (IOException io) {
			logger.error("IO exception writing files: " + io);
			return false;
		}  catch (Exception e) {
			logger.error("general exception writing files: " + e);
		}
		return true;
	}


	/**
	 * Return the current status of <canPrint>
	 * @return current print status
	 */
	public boolean canPrint(){
		return this.canPrint.tsvalue;
	}


	/**
	 * Return the standard header
	 * 
	 * The standard header includes the source file, the source language, the target language and time and date information.
	 * @param ms misc items to be added to the standard header
	 * @return standard header
	 */
	private String stdHeader(LinkedHashMap<String, String> ms){
		if(this.targetLanguage==null||this.sourceLanguage==null||this.sourceFile==null)
			return null;

		this.codeHeader.reset();

		this.codeHeader.setAttribute("source", this.sourceLanguage);
		this.codeHeader.setAttribute("file", this.sourceFile);

		TreeMap<String,String> target=new TreeMap<String, String>();
		target.put(this.targetLanguage.toString(), this.targetLanguage.toString());
		this.codeHeader.setAttribute("target", target);

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	    String dateFormat = "dd MMMMM yyyy";
	    java.text.SimpleDateFormat sdfDay = new java.text.SimpleDateFormat(dateFormat);
	    sdfDay.setTimeZone(TimeZone.getDefault());  
	    this.codeHeader.setAttribute("day", sdfDay.format(cal.getTime()));

	    dateFormat = "H:mm:ss";
	    java.text.SimpleDateFormat sdfTime = new java.text.SimpleDateFormat(dateFormat);
	    sdfTime.setTimeZone(TimeZone.getDefault());
	    this.codeHeader.setAttribute("time", sdfTime.format(cal.getTime()));

	    this.codeHeader.setAttribute("misc", ms);

	    return this.codeHeader.toString();
	}


	/**
	 * Compile and return the standard pre-text of a file
	 * @return text to be used as pre-text
	 */
	private String stdFileStart(){
		if(this.targetLanguage==null)
			return "";
		this.fileStart.reset();
		TreeMap<String,String> target=new TreeMap<String, String>();
		target.put(this.targetLanguage.toString(), this.targetLanguage.toString());
		this.fileStart.setAttribute("target", target);
		return this.fileStart.toString();
	}


	/**
	 * Compile and return the standard pre-text of a file
	 * @return text to be used as pre-text
	 */
	private String stdFileEnd(){
		if(this.targetLanguage==null)
			return "";
		this.fileEnd.reset();
		TreeMap<String,String> target=new TreeMap<String, String>();
		target.put(this.targetLanguage.toString(), this.targetLanguage.toString());
		this.fileEnd.setAttribute("target", target);
		return this.fileEnd.toString();
	}
}
