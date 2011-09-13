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

package org.skb.lang.glue.proto;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.log4j.Logger;
import org.skb.lang.glue.proto.constants.GlueConstants;
import org.skb.tribe.TribeProperties;
import org.skb.util.languages.AtomList;
import org.skb.util.misc.ReportManager;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;
import org.skb.util.stringtemplate.STGManager;

/**
 * Class handling statistic information about a Glue specification.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class GlueStatistics {
	static Logger logger = Logger.getLogger(GlueStatistics.class);

	private STGManager stgl=null;
	private StringTemplateGroup stg;
	boolean loaded=false;

	private StringTemplate simpleStat=null;
	private StringTemplate completeStatStart=null;
//	private StringTemplate completeStatPrintArray=null;

	public GlueStatistics(){
		TSMapLH chMan=new TSMapLH();

		chMan.put("simpleStat", new TSArrayListString(new String[]{"file", "ids", "properties", "items", "contracts", "packages", "elements", "facilities", "actions"}));
		chMan.put("simpleStat", new TSArrayListString(new String[]{"attributes", "parameters", "structs", "members", "typedefs"}));

		chMan.put("completeStatStart",      new TSArrayListString(new String[]{"file"}));
		chMan.put("completeStatPrintArray", new TSArrayListString(new String[]{"text", "size", "array"}));

		this.stgl=new STGManager();
		this.stgl.setMandatoryChunks(chMan);

		TSBaseAPI statStg=TribeProperties.getInstance().getValueCli(GlueConstants.Properties.keyStatStg);
		if(statStg!=null)
			this.stgl.setSTGFileName(statStg.toString());
		this.stgl.setSTGUrlName(TribeProperties.getInstance().getValueDefault(GlueConstants.Properties.keyStatStg));

		this.stgl.loadSTG("templates for printing statistics", "");

		if(this.stgl.testChunks()){
			stg=this.stgl.getSTG();
			this.loaded=true;
		}
	}

	public void genSimpleStats(){
		if(this.loaded==true){
			AtomList atoms=AtomList.getInstance();

			this.simpleStat=stg.getInstanceOf("simpleStat");
			simpleStat.setAttribute("file", ReportManager.getInstance().getFileName());

//			LinkedHashMap<String, Integer> map=atoms.atomNumbers();
			simpleStat.setAttribute("ids", atoms.noOfAtoms());
//			simpleStat.setAttribute("properties.{decl,def}", map.get(GlueTokens.gluePROPERTY),  atoms.retDefinedProperties());
		}
	}

	public void printSimpleStatistic(){
		if(this.loaded==true)
			System.out.println(simpleStat.toString());
	}

	public void genCompleteStats(){
		if(this.loaded==true){
			this.completeStatStart=stg.getInstanceOf("completeStatStart");
			this.completeStatStart.setAttribute("file", ReportManager.getInstance().getFileName());
		}
	}

	public void printCompleteStatistic(){
	}
}
