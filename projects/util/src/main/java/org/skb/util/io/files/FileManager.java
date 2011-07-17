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
import org.skb.util.types.OatValueIsNullException;
import org.skb.util.types.atomic.java.OatBoolean;
import org.skb.util.types.atomic.java.OatString;

/**
 * A manager for file lists to prepare output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class FileManager {
	private StringTemplate codeHeader;
	private StringTemplate fileStart;
	private StringTemplate fileEnd;

	private OatString sourceLanguage=null;
	private OatString sourceFile=null;
	private OatString targetLanguage=null;
	private OatString targetFileExtension=null;
	private OatBoolean canPrint;

	public FileManager(StringTemplate codeHeader, StringTemplate fileStart, StringTemplate fileEnd){
		this.codeHeader=codeHeader;
		this.fileStart=fileStart;
		this.fileEnd=fileEnd;

		this.canPrint=new OatBoolean((false));
	}

	public void init(OatString srcLang, OatString srcFile, OatString tgtLang, OatString tgtFileExt, OatBoolean canPrint){
		if(srcLang!=null)
			this.sourceLanguage=(OatString)srcLang;
		if(srcFile!=null)
			this.sourceFile=(OatString)srcFile;
		if(tgtLang!=null)
			this.targetLanguage=(OatString)tgtLang;
		if(tgtFileExt!=null)
			this.targetFileExtension=(OatString)tgtFileExt;
		if(canPrint!=null)
			this.canPrint=(OatBoolean)canPrint;

		if(this.sourceLanguage==null||this.sourceFile==null||this.targetLanguage==null||this.targetFileExtension==null)
			this.canPrint=new OatBoolean((false));
	}

	public boolean writeList(FileTemplateList list){
		if(canPrint()==false)
			return false;
		for (Map.Entry<String, FileTemplateSingle> e : list.entrySet())
			this.writeSingleFileFromList(list.getDir(e.getKey()), list.getFile(e.getKey())+this.targetFileExtension, e.getValue());
		return true;
	}

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
//			ReportManager.getInstance().reportErrorNoFile("Exception in tribe::FileManager : " + io.toString());
			return false;
		}  catch (Exception e) {
//			ReportManager.getInstance().reportErrorNoFile("Exception in tribe::FileManager : " + e.toString());
		}
		return true;
	}

	public boolean canPrint(){
		try {
			return this.canPrint.getValue();
		} catch (OatValueIsNullException e) {
			return false;
		}
	}

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

	private String stdFileStart(){
		if(this.targetLanguage==null)
			return "";
		this.fileStart.reset();
		TreeMap<String,String> target=new TreeMap<String, String>();
		target.put(this.targetLanguage.toString(), this.targetLanguage.toString());
		this.fileStart.setAttribute("target", target);
		return this.fileStart.toString();
	}
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
