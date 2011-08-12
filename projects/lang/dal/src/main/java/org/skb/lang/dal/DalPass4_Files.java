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

import java.util.ArrayList;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.tribe.TribeProperties;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.languages.AtomList;
import org.skb.util.types.atomic.java.TSBoolean;

/**
 * Pass 4 of the DAL Parser, generating files for output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass4_Files {
	static Logger logger = Logger.getLogger(DalPass4_Files.class);

	private FileTemplateList ftl;
	private AtomList atoms;
	private TribeProperties prop;

	public DalPass4_Files(){
		this.ftl=new FileTemplateList();
		this.atoms=AtomList.getInstance();
		this.prop=TribeProperties.getInstance();
	}

	public FileTemplateList getFileTemplateList(){
		//remove everything but the dalRepository and the dalPackage
		ArrayList<String> del=new ArrayList<String>();
		del.add(DalConstants.Tokens.dalACTIONS);
		del.add(DalConstants.Tokens.dalSEQUENCE);
		del.add(DalConstants.Tokens.dalFIELD);
		del.add(DalConstants.Tokens.dalDATA);
		del.add(DalConstants.Tokens.dalTABLE);
		this.removeEntries(del);

		Boolean tgtSplitRepo=false;
		Boolean tgtIgnoreEmptyST=false;
		try {
			tgtSplitRepo=((TSBoolean)this.prop.getValue(DalConstants.Properties.keyTgSplitRepository)).tsvalue;
			tgtIgnoreEmptyST=((TSBoolean)this.prop.getValue(DalConstants.Properties.keyTgIgnoreEmptyST)).tsvalue;
		} catch (Exception e) {}

		//set the default file name, will be overwritten by package name later (set just in case)
		String fn=this.prop.getValue(TribeProperties.tpmKeyTgtFile).toString();
		//remember package name for fn construction later
		String pkg=new String();

		if(tgtSplitRepo==false)
			this.doPackageRepository();

		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		//we start at 1 to deal with repository (0) separately
		for(int i=1;i<size;i++){
			if(tgtSplitRepo==true){
				if(this.atoms.get(rows.get(i)).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalPACKAGE)){
					fn=rows.get(i);
					pkg=fn;
					//create the file with the core defs, if they are not empty
					if(this.atoms.get(rows.get(0)).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalREPOSITORY)){
						if(tgtIgnoreEmptyST==false||(tgtIgnoreEmptyST==true&&this.atoms.getST(rows.get(0)).toString().length()>0))
							this.ftl.addTemplate(fn+this.prop.getValue(DalConstants.Properties.keyTgRepoFileAdd).toString(),this.atoms.getST(rows.get(0)));
					}
				}
				else if(this.atoms.get(rows.get(i)).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalREPOSITORY)){
					if(tgtIgnoreEmptyST==false||(tgtIgnoreEmptyST==true&&this.atoms.getST(rows.get(0)).toString().length()>0))
						fn=pkg+this.prop.getValue(DalConstants.Properties.keyTgRepoFileAdd).toString();
				}
			}
			else{
				//if no split for repos, and just started, then add the repo to the current fn
				if(i==1&&this.atoms.get(rows.get(0)).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalREPOSITORY))
					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(0)));
			}
			if(tgtIgnoreEmptyST==true&&this.atoms.getST(rows.get(i)).toString().length()==0)
				continue;
			this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
		}

		return this.ftl;
	}

	private void removeEntries(ArrayList<String> categories){
		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		ArrayList<String>removeList=new ArrayList<String>();
		Integer size=rows.size();
		String current;
		String cat;
		for(int i=0;i<size;i++){
			current=rows.get(i);
			cat=this.atoms.get(current,AtomList.alValCategory).toString();
			if(categories.contains(cat))
				removeList.add(current);
		}
		//now remove the processed atoms
		size=removeList.size();
        for(int i=0;i<size;i++)
        	this.atoms.remove(removeList.get(i));
	}

	private void doPackageRepository(){
		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		for(int i=1;i<size;i++){
			if(this.atoms.getST(rows.get(i)).toString().length()==0)
				continue;
			if(this.atoms.get(rows.get(i)).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalREPOSITORY)){
				String[] path=StringUtils.split(rows.get(i), this.atoms.scope.separator());
				if(this.atoms.get(path[0]).get(AtomList.alValCategory).toString().equals(DalConstants.Tokens.dalPACKAGE)){
					StringTemplate st=this.atoms.getST(path[0]);
					st.setAttribute("repos", this.atoms.getST(rows.get(i)));
					this.atoms.remove(rows.get(i));
				}
			}
		}
	}
}