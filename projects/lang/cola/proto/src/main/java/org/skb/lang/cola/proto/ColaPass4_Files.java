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

package org.skb.lang.cola.proto;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;
import org.skb.lang.cola.proto.constants.ColaConstants;
import org.skb.tribe.TribeProperties;
import org.skb.util.io.files.FileTemplateList;
import org.skb.util.languages.AtomList;
import org.skb.util.types.atomic.java.OatBoolean;
import org.skb.util.types.base.OatBaseAtomic;

/**
 * Pass 4 of the Cola Parser, generating files for output.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.30 build 110309 (09-Mar-11) with Java 1.6
 */
public class ColaPass4_Files {
	static Logger logger = Logger.getLogger(ColaPass4_Files.class);

	private FileTemplateList ftl;
	private AtomList atoms;
	private TribeProperties prop;

	public ColaPass4_Files(){
		this.ftl=new FileTemplateList();
		this.atoms=AtomList.getInstance();
		this.prop=TribeProperties.getInstance();
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

		this._processAtomChildren(ColaConstants.Tokens.colaSTRUCT, null, null);
		this._processAtomChildren(ColaConstants.Tokens.colaACTION, null, null);

		this._processAtomChildren(ColaConstants.Tokens.colaFACILITY, null, null);
		this._processAtomChildren(ColaConstants.Tokens.colaELEMENT, null, null);

		//the list now has only packages, elements, facilities, typedefs and structures left
		//the rest is dependent on the code-split options

		//split code is either not set at all (like for XML) or set to false
		Boolean tgtSplitCode=false;
		Boolean tgtByPkg=false;
		Boolean tgtByAtomCat=false;
		try {
			tgtSplitCode=((OatBoolean)this.prop.getValue(ColaConstants.Properties.keyTgSplitCode)).getValue();
			tgtByPkg=((OatBoolean)this.prop.getValue(ColaConstants.Properties.keyTgSCbyPackage)).getValue();
			tgtByAtomCat=((OatBoolean)this.prop.getValue(ColaConstants.Properties.keyTgSCbyAtomCategory)).getValue();
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
				this._processPackages(ColaConstants.Tokens.colaPACKAGE);

				//final cleanup, like remove all functions if we're not in cola target mode
				this.removeFunctions();

				//now we have only atoms in the default package (root/void) and packages in the list
				//default filename is this
				ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
				Integer size=rows.size();
				for(int i=1;i<size;i++){
					if(this.atoms.get(rows.get(i), AtomList.alValCategory).equals(ColaConstants.Tokens.colaPACKAGE))
						fn=rows.get(i).replace(this.prop.getValue(TribeProperties.tpmKeyGCScopeSep).toString(), "_"); 
					else{
						File f=new File(this.prop.getValue(TribeProperties.tpmKeySrcFile).toString());
						fn=f.getName();
						fn=fn.substring(0, fn.lastIndexOf(this.prop.getValue(TribeProperties.tpmKeyTgtFileExt).toString()));
					}
					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
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
					if(category.lastIndexOf(ColaConstants.Tokens.parserScopeSep)!=-1)
						category=category.substring(0,category.lastIndexOf(ColaConstants.Tokens.parserScopeSep));
					else
						category="";
					category=category.replace(ColaConstants.Tokens.parserScopeSep, System.getProperty("file.separator"));
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

				OatBaseAtomic defP=this.prop.getValue(ColaConstants.Properties.keyXtJavaPackage);
				String defPkg;
				if(defP==null)
					defPkg="";
				else defPkg=defP.toString();

				String calcPkg;

				ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
				Integer size=rows.size();
				for(int i=0;i<size;i++){
					fn=rows.get(i).replace(ColaConstants.Tokens.parserScopeSep, System.getProperty("file.separator"));
					this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
					if(this.prop.getValue(TribeProperties.tpmKeyTgtLanguage).equals(ColaConstants.Properties.internalColaTgtJava)){
						if(defPkg.length()>0)
							calcPkg=new String(defPkg)+this.prop.getValue(ColaConstants.Properties.keyScopeSep);
						else
							calcPkg=new String();

						if(rows.get(i).contains(ColaConstants.Tokens.parserScopeSep)){
							calcPkg+=rows.get(i).substring(0, rows.get(i).lastIndexOf(ColaConstants.Tokens.parserScopeSep));
							calcPkg=calcPkg.replace(ColaConstants.Tokens.parserScopeSep,this.prop.getValue(TribeProperties.tpmKeyGCScopeSep).toString());
						}

						if(calcPkg.length()>0)
							this.ftl.addMisc(fn,"package",calcPkg);
						else if(defPkg.length()>0)
							this.ftl.addMisc(fn,"package",defPkg);
					}
				}
			}
		}
		return this.ftl;
	}

	private void _keyXtDoElementCode(){
		String currentElem;
		LinkedHashMap<String, String>map;
		ArrayList<String> inFac=new ArrayList<String>();
		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		if(size>0){
			for(int i=0;i<size;i++){
				currentElem=rows.get(i);
				//not contained in any other Atom? go to the next one
				if(currentElem.lastIndexOf(ColaConstants.Tokens.parserScopeSep)==-1)
					continue;
				//not an element, then continue
				if(!this.atoms.get(currentElem,AtomList.alValCategory).equals(ColaConstants.Tokens.colaELEMENT))
					continue;
				else{
					map=this.atoms.getImports(currentElem);
					Collection<String> values = map.keySet();
					for (Iterator<String> it = values.iterator(); it.hasNext(); ){
						String currentFac=it.next();
						String cat=map.get(currentFac);
						//no facility, then continue
						if(!cat.equals(ColaConstants.Tokens.colaFACILITY))
							continue;
						//we are in an element that has a dependency (requires) a facility
						//this can only be by @provides, so we can generate the attribute/action code
						//for that element
						//first go through the list and get all definitions of that facility
						inFac.clear();
						Integer fSize=rows.size();
						String entry;
						String entryParID;
						for(int k=0;k<fSize;k++){
							entry=rows.get(k);
							if(entry.lastIndexOf(ColaConstants.Tokens.parserScopeSep)==-1)
								continue;
							entryParID=entry.substring(0,entry.lastIndexOf(ColaConstants.Tokens.parserScopeSep));
							if(currentFac.equals(entryParID))
								inFac.add(entry);
						}
						//first add the import of the Facility to the Element
						//now we have a list of names of all children of the facility currentFac which is needed in
						//the element currentElem, let's add them to the element
						fSize=inFac.size();
						StringTemplate elem=this.atoms.getST(currentElem);
						StringTemplate body;
						for(int k=0;k<fSize;k++){
							//if we should do Element code, do it
							Boolean xtDoElemCode=false;
							try {
								xtDoElemCode=((OatBoolean)this.prop.getValue(ColaConstants.Properties.keyXtDoElementCode)).getValue();
							} catch (Exception e) {}

							if(xtDoElemCode==true){
								body=this.atoms.getST(inFac.get(k));
								//first set misc/inElement
								body.removeAttribute("misc");
								body.setAttribute("misc", this.genMiscAttribute(inFac.get(k),ColaConstants.Tokens.colaELEMENT));
								elem.setAttribute("body", this.atoms.getST(inFac.get(k)).toString());
								//and now retour
								body.removeAttribute("misc");
								body.setAttribute("misc", this.genMiscAttribute(inFac.get(k),ColaConstants.Tokens.colaFACILITY));								
							}
							//in any case, we have to do set imports for the elements
//this.atoms.addImportsAll(currentElem, this.atoms.getImports(inFac.get(k)));
						}
					}
				}
			}
		}
	}

	private void _processAtomChildren(String processParrentCat, String processParrent, String excludeCategory){
		String current;
		String parrent;
		String parrentCat;

		ArrayList<String>removeList=new ArrayList<String>();

		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		//we start at 1 because the first entry is VOID (root), and we don't want that
		//check for everything that can be contained in element/facility and if so, put it into it
		if(size>0){
			for(int i=0;i<size;i++){
				current=rows.get(i);
				//not contained in any other Atom? go to the next one
				if(current.lastIndexOf(ColaConstants.Tokens.parserScopeSep)==-1)
					continue;
				parrent=current.substring(0,current.lastIndexOf(ColaConstants.Tokens.parserScopeSep));
				parrentCat=this.atoms.get(parrent,AtomList.alValCategory).toString();
				if(processParrentCat!=null&&processParrentCat.equals(parrentCat)){
					//now, if we should process a generic parent category, let's do that
					if(processParrentCat!=null&&processParrentCat.equals(ColaConstants.Tokens.colaSTRUCT))
						this.atoms.getST(parrent).setAttribute("member", this.atoms.getST(current).toString());
					else if(processParrentCat!=null&&processParrentCat.equals(ColaConstants.Tokens.colaACTION))
						this.atoms.getST(parrent).setAttribute("parameter", this.atoms.getST(current).toString());
					else
						this.atoms.getST(parrent).setAttribute("body", this.atoms.getST(current).toString());
					this.atoms.addImportsAll(parrent, this.atoms.getImports(current));
					removeList.add(current);
				}
				else if(processParrent!=null&&processParrent.equals(parrent)){
					//otherwise, we should process a specific Atom with ID, so let's do that then
					//now check if we have to exclude the found child's category
					if(excludeCategory!=null&&excludeCategory.equals(this.atoms.get(current,AtomList.alValCategory)))
						continue;
					if(processParrentCat!=null&&processParrentCat.equals(ColaConstants.Tokens.colaSTRUCT))
						this.atoms.getST(parrent).setAttribute("member", this.atoms.getST(current).toString());
					else if(processParrentCat!=null&&processParrentCat.equals(ColaConstants.Tokens.colaACTION))
						this.atoms.getST(parrent).setAttribute("parameter", this.atoms.getST(current).toString());
					else
						this.atoms.getST(parrent).setAttribute("body", this.atoms.getST(current).toString());
					this.atoms.addImportsAll(parrent, this.atoms.getImports(current));
					removeList.add(current);
				}
			}
		}
		//now remove the processed atoms
		size=removeList.size();
        for(int i=0;i<size;i++)
        	this.atoms.remove(removeList.get(i));
	}

	private void _processPackages(String excludeCategory){
		String current;
		TreeMap<Integer, ArrayList<String>>pkgMap=new TreeMap<Integer, ArrayList<String>>();

		ArrayList<String>_r=new ArrayList<String>(this.atoms.getRows());
		Integer size=_r.size();
		for(int i=0;i<size;i++){
			current=_r.get(i);
			if(this.atoms.get(current,AtomList.alValCategory).equals(ColaConstants.Tokens.colaPACKAGE)){
				Integer count=ColaPass4_Files.countIndexOf(current, ColaConstants.Tokens.parserScopeSep);
				if(!pkgMap.containsKey(count))
					pkgMap.put(count, new ArrayList<String>());
				pkgMap.get(count).add(current);
			}
		}
		//ok, we have all pkg's in the map, lets go through the map
		TreeSet<Integer>idx=new TreeSet<Integer>(pkgMap.descendingKeySet());
		Integer curK;
		ArrayList<String>pkg=new ArrayList<String>();
		for (Iterator<Integer> i = idx.iterator(); i.hasNext(); i.hasNext()){
			curK=i.next();
			pkg.clear();
			pkg=pkgMap.get(curK);
			size=pkg.size();
        	for(int k=0;k<size;k++){
        		this._processAtomChildren(null, pkg.get(k), excludeCategory);
        	}
        }
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
		if(this.prop.getValue(TribeProperties.tpmKeyTgtLanguage).equals(ColaConstants.Properties.internalColaTgtCola))
			return;
		ArrayList<String>removeList=new ArrayList<String>();
		String current;
		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		//we start at 1 because the first entry is VOID (root), and we don't want that
		//check for everything that can be contained in element/facility and if so, put it into it
		if(size>0){
			for(int i=0;i<size;i++){
				current=rows.get(i);
				if(this.atoms.get(current,AtomList.alValCategory).equals(ColaConstants.Tokens.colaFUNCTION))
					removeList.add(current);
			}
		}
		size=removeList.size();
        for(int i=0;i<size;i++)
        	this.atoms.remove(removeList.get(i));
	}

	public TreeMap<String,String> genMiscAttribute(){return this. genMiscAttribute(null, null);}

  	//keep key and cat null if you want to use current values or use overload function below
	  public TreeMap<String,String> genMiscAttribute(String key, String cat){
		TreeMap<String,String>ret=new TreeMap<String,String>();
		ret.put(ColaConstants.Tokens.gcMiscParrentID, this.atoms.getParrentId(key));
		ret.put(ColaConstants.Tokens.gcMiscParrentCat, this.atoms.getParrentCategory(key));
		ret.put(ColaConstants.Tokens.gcMiscSpecName, this.atoms.specificationName());
		ret.put(ColaConstants.Tokens.gcMiscCurrentScope, this.atoms.scope.toString());
		ret.put(ColaConstants.Tokens.gcMiscCurrentCat, this.atoms.get(this.atoms.scope.toString(), AtomList.alValCategory).toString());

		String cmpCat=cat;
		if(cmpCat==null)
			cmpCat=this.atoms.getParrentCategory(key);
		if(cmpCat.equals(ColaConstants.Tokens.colaCONTRACT))
			ret.put(ColaConstants.Tokens.gcMiscInContract, "true");
		if(cmpCat.equals(ColaConstants.Tokens.colaITEM))
			ret.put(ColaConstants.Tokens.gcMiscInItem, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaPACKAGE))
			ret.put(ColaConstants.Tokens.gcMiscInPackage, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaELEMENT))
			ret.put(ColaConstants.Tokens.gcMiscInElement, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaFACILITY))
			ret.put(ColaConstants.Tokens.gcMiscInFacility, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaACTION))
			ret.put(ColaConstants.Tokens.gcMiscInAction, "true");
		else if(cmpCat.equals(ColaConstants.Tokens.colaSTRUCT))
			ret.put(ColaConstants.Tokens.gcMiscInStruct, "true");
		else
			ret.put(ColaConstants.Tokens.gcMiscInDefinition, "true");
		return ret;
	}
}