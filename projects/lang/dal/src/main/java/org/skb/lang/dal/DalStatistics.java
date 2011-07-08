/* Copyright (c) 2000-2011 Sven van der Meer (sven@vandermeer.de)
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

package org.skb.lang.dal;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.skb.tribe.TribeProperties;
import org.skb.types.TypeRepository;
import org.skb.types.atomic.java.OatBoolean;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.base.OatBaseAtomic;
import org.skb.types.composite.util.OatMapLH;
import org.skb.util.ReportManager;
import org.skb.util.languages.AtomList;
import org.skb.util.stringtemplate.STGManager;
import org.skb.util.stringtemplate.STGWriterXtoY;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

/**
 * Class implementing statistic methods for Cola parser.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalStatistics {
	private STGManager stgl=null;
	private StringTemplateGroup stg;
	boolean loaded=false;

	private StringTemplate simpleStat=null;
	private StringTemplate completeStatStart=null;
	private StringTemplate completeStatPrintArray=null;

	public DalStatistics(){
		OatMapLH chMan=new OatMapLH();

		chMan.put("simpleStat", new OatArrayListString(new String[]{"file", "ids", "properties", "items", "contracts", "packages", "elements", "facilities", "actions"}));
		chMan.put("simpleStat", new OatArrayListString(new String[]{"attributes", "parameters", "structs", "members", "typedefs"}));

		chMan.put("completeStatStart",      new OatArrayListString(new String[]{"file"}));
		chMan.put("completeStatPrintArray", new OatArrayListString(new String[]{"text", "size", "array"}));

		this.stgl=new STGManager();
		this.stgl.setMandatoryChunks(chMan);
		this.stgl.setApplicationName(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyNameLC).getValOatAtomicString());

		this.stgl.setSTGFileName(TribeProperties.getInstance().getValueCli(DalPropertiesConstants.keyStatStg));
		this.stgl.setSTGUrlName(TribeProperties.getInstance().getValueDefault(DalPropertiesConstants.keyStatStg));
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

			LinkedHashMap<String, Integer> map=atoms.atomNumbers();
			simpleStat.setAttribute("ids", atoms.noOfAtoms());
//			simpleStat.setAttribute("properties.{decl,def}", map.get(DalTokensConstants.colaPROPERTY),  atoms.retDefinedProperties());
//			simpleStat.setAttribute("items.{decl,def}",      map.get(DalTokensConstants.colaITEM),      0);
//			simpleStat.setAttribute("contracts.{decl,def}",  map.get(DalTokensConstants.colaCONTRACT),  0);
//			simpleStat.setAttribute("packages.{decl,def}",   map.get(DalTokensConstants.colaPACKAGE),   0);
//			simpleStat.setAttribute("elements.{decl,def}",   map.get(DalTokensConstants.colaELEMENT),   0);
//			simpleStat.setAttribute("facilities.{decl,def}", map.get(DalTokensConstants.colaFACILITY),  0);
//			simpleStat.setAttribute("actions.{decl,def}",    map.get(DalTokensConstants.colaACTION),    0);
//			simpleStat.setAttribute("attributes.{decl,def}", map.get(DalTokensConstants.colaATTRIBUTE), 0);
//			simpleStat.setAttribute("parameters.{decl,def}", map.get(DalTokensConstants.colaPARAMETER), 0);
//			simpleStat.setAttribute("typedefs.{decl,def}",   map.get(DalTokensConstants.colaTYPEDEF),   0);
//			simpleStat.setAttribute("structs.{decl,def}",    map.get(DalTokensConstants.colaSTRUCT),    0);
//			simpleStat.setAttribute("members.{decl,def}",    map.get(DalTokensConstants.parserMEMBER),  0);
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
		if(this.loaded==true){
			System.out.println(completeStatStart);

			this.completeStatPrintArray = stg.getInstanceOf("completeStatPrintArray");

			TribeProperties prop=TribeProperties.getInstance();
			boolean scope=false;

			try {
				OatBaseAtomic ata=prop.getValue(DalPropertiesConstants.keyPrStatsWScope);
				if(ata.isType(TypeRepository.OAT_ATOMIC_BOOLEAN))
						scope=((OatBoolean)ata).getValue();
			} catch (Exception e) {}
		}
	}
	private void _printCompleteStatisticArray(String s, ArrayList<String> ar, StringTemplate template, boolean scope) {
		template.setAttribute("text", s);
		if(scope==true){
			template.setAttribute("size", ar.size());
			template.setAttribute("array", ar);
		} else {
			ArrayList<String> tempA=new ArrayList<String>();
			int size=ar.size();
			for(int i=0; i<size; i++){
				String ta = ar.get(i);
				if(ta.lastIndexOf("::")!=-1)
					ta = ta.substring(ta.lastIndexOf("::")+2);
				tempA.add(ta);
			}
			template.setAttribute("size", tempA.size());
			template.setAttribute("array", tempA);
		}
		StringWriter out = new StringWriter();
		STGWriterXtoY psrmw = new STGWriterXtoY(out);
		psrmw.setStart(2);
		psrmw.setEnd(78);
		try{template.write(psrmw);} catch (IOException e) {}
		System.out.println(out.toString());
		template.reset();
	}
}