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
import java.util.TreeMap;

import org.skb.tribe.TribeProperties;
import org.skb.types.atomic.java.OatBoolean;
import org.skb.util.languages.AtomList;
import org.skb.util.stringtemplate.FileTemplateList;

/**
 * Pass 4 of the DAL Parser, generating files for output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class DalPass4_Files {
	private FileTemplateList ftl;
	private AtomList atoms;
	private TribeProperties prop;

	public DalPass4_Files(){
		this.ftl=new FileTemplateList();
		this.atoms=AtomList.getInstance();
		this.prop=TribeProperties.getInstance();
//System.err.println(this.atoms.getValue());
	}

	public FileTemplateList getFileTemplateList(){
		String fn;
		//now we do have a list (not tree) of all declared COLA atoms
		//parameters and members are already in action/structure -> pass3 is taking care of that
		//now we need to check the code generation options

		// start looking at keyXtDoElementCode["xt-do-element-code"], means we need to add Facility code to elements
		//we do this operation in any case, it will transfer the imports and generate code only if the option is set
		this._keyXtDoElementCode();

		//now we can add Attributes/Actions to Elements/Facilities
		//this should remove all Actions and Attributes, plus all propertyDecl, itemDecl, contractDecl contained in Elements/Facilities

//private void _processAtomChildren(String processParrentCat, String processParrent, String excludeCategory){
//		this._processAtomChildren(DalTokensConstants.colaSTRUCT, null, null);
//		this._processAtomChildren(DalTokensConstants.colaACTION, null, null);

//		this._processAtomChildren(DalTokensConstants.colaFACILITY, null, null);
//		this._processAtomChildren(DalTokensConstants.colaELEMENT, null, null);

		//the list now has only packages, elements, facilities, typedefs and structures left
		//the rest is dependent on the code-split options

		//split code is either not set at all (like for XML) or set to false
		Boolean tgtSplitCode=false;
		Boolean tgtByPkg=false;
		Boolean tgtByAtomCat=false;
		try {
			tgtSplitCode=((OatBoolean)this.prop.getValue(DalPropertiesConstants.keyTgSplitCode)).getValue();
//			tgtByPkg=((OatBoolean)this.prop.getValue(DalPropertiesConstants.keyTgSCbyPackage)).getValue();
//			tgtByAtomCat=((OatBoolean)this.prop.getValue(DalPropertiesConstants.keyTgSCbyAtomCategory)).getValue();
		} catch (Exception e) {}

		if(tgtSplitCode==false){
			//no split, so go through the atoms, put all children into the body of their parent
			//add the final template to the ftl and give back
			fn=this.prop.getValue(TribeProperties.tpmKeyTgtFile).toString();

			//now we only have root elements and packages (including their children)
			//let's do the packages, if their are not root, from the inner to the outer
			//i.e. longest scoped_name first
			this._processPackages(null);

			//final cleanup, like remove all functions if we're not in cola target mode
			this.removeFunctions();

			ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
			Integer size=rows.size();
			for(int i=0;i<size;i++)
				this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
		}
		else{
			//now check the split code options. default is by AtomInstance (else part)
			//if byPackage is set, it overwrites byAtomCategory
			if(tgtByPkg==true){
				//split packages only = 1 file per package (in directory with same name as package
//				this._processPackages(DalTokensConstants.colaPACKAGE);

				//final cleanup, like remove all functions if we're not in cola target mode
				this.removeFunctions();

				//now we have only atoms in the default package (root/void) and packages in the list
				//default filename is this
				ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
				Integer size=rows.size();
				for(int i=1;i<size;i++){
//					if(this.atoms.get(rows.get(i), AtomList.alValCategory).equals(DalTokensConstants.colaPACKAGE))
//						fn=rows.get(i).replace(this.prop.getValue(TribeProperties.tpmKeyGCScopeSep).toString(), "_"); 
//					else{
//						File f=new File(this.prop.getValue(TribeProperties.tpmKeySrcFile).toString());
//						fn=f.getName();
//						fn=fn.substring(0, fn.lastIndexOf(this.prop.getValue(TribeProperties.tpmKeyTgtFileExt).toString()));
//					}
//					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
				}
			}
			else if(tgtByAtomCat==true){
				//split category = split package + 1 file per atom category, name of file is atom category (it's a keyword!)
				//final cleanup, like remove all functions if we're not in cola target mode
				this.removeFunctions();

				ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
				Integer size=rows.size();
				String category;
				for(int i=0;i<size;i++){
					category=rows.get(i);
					if(category.lastIndexOf(DalTokensConstants.parserScopeSep)!=-1)
						category=category.substring(0,category.lastIndexOf(DalTokensConstants.parserScopeSep));
					else
						category="";
					category=category.replace(DalTokensConstants.parserScopeSep, System.getProperty("file.separator"));
					if(category.length()>0)
						category+=System.getProperty("file.separator");
					fn=category+this.atoms.get(rows.get(i), AtomList.alValCategory);
					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
				}
			}
			else{
				//split atoms = split package + 1 file per atom instance
				//final cleanup, like remove all functions if we're not in cola target mode
				this.removeFunctions();

//				OatBaseAtomic defP=this.prop.getValue(DalPropertiesConstants.keyXtJavaPackage);
//				String defPkg;
//				if(defP==null)
//					defPkg="";
//				else defPkg=defP.toString();

				String calcPkg;

				ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
				Integer size=rows.size();
				for(int i=0;i<size;i++){
					fn=rows.get(i).replace(DalTokensConstants.parserScopeSep, System.getProperty("file.separator"));
					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
				}
			}
		}
		return this.ftl;
	}

	private void _keyXtDoElementCode(){
	}

	private void _processAtomChildren(String processParrentCat, String processParrent, String excludeCategory){
	}

	private void _processPackages(String excludeCategory){
	}

	private static int countIndexOf(String content, String search) {
		int ctr = -1;
		int total = 0;
		while (true) {
			if (ctr == -1) ctr = content.indexOf(search);
			else ctr = content.indexOf(search, ctr);

		    if (ctr == -1) {
		    	break;
		    }
		    else {
		    	total++;
		    	ctr += search.length();
		    }
		}
		return total;
	}

	private void removeFunctions(){
	}

	public TreeMap<String,String> genMiscAttribute(){return this. genMiscAttribute(null, null);}

  	//keep key and cat null if you want to use current values or use overload function below
	  public TreeMap<String,String> genMiscAttribute(String key, String cat){
		TreeMap<String,String>ret=new TreeMap<String,String>();
		return ret;
	}
}