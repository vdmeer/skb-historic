package org.skb.base.classic.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.TSDefault;
import org.skb.base.composite.TSError;
import org.skb.base.composite.TSWarning;
import org.skb.base.composite.TSRepository.TEnum;
import org.skb.base.composite.lang.TSAtomList;

public class AtomListUtils {

	/**
	 * Returns the parent ID of the current scope in the given AtomList
	 * @param scope
	 * @return parent ID of the current scope in the given AtomList or "" of not existent
	 */
	public static String getParentID(TSAtomList al){
		return NameScopeUtils.getParentID(al.scope.toString(), al.scope.getSeparator());
	}

	/**
	 * Returns the parent category of the given ID from the given AtomList
	 * @param id
	 * @param al
	 * @return parent category of the given ID or "" of not existent or any other error occured
	 */
	public static String getParentCategory(String id, TSAtomList al){
		if(id==null)
			return "";
		if(al==null)
			return "";

		String parentID=NameScopeUtils.getParentID(id, al.scope.getSeparator());
		if(!al.containsKey(parentID))
			return "";

		TSBaseAPI parentCategory=al.get(parentID, TSAtomList.alValCategory);
		if(parentCategory.tsIsType(TEnum.TS_DEFAULT))
			return "";

		return parentCategory.toString();
	}

	/**
	 * Returns the parent category of the current scope of the given AtomList
	 * @param al
	 * @return parent category of the given ID or "" of not existent
	 */
	public static String getParentCategory(TSAtomList al){
		return AtomListUtils.getParentCategory(al.scope.toString(), al);
	}

	/**
	 * Removes all atoms of the given category from the given AtomList
	 * @param al AtomList to remove categories from
	 * @param category to process
	 * @return error object if any error occurred, warning object if any warning occurred, TSDefault if removal was successful
	 */
	public static TSDefault removeCategory(TSAtomList al, String category){
		return AtomListUtils.removeCategory(al, new String[]{category});
	}

	/**
	 * Removes all atoms of the given categories from the given AtomList
	 * @param al AtomList to remove categories from
	 * @param categories list of categories to process
	 * @return error object if any error occurred, warning object if any warning occurred, TSDefault if removal was successful
	 */
	public static TSDefault removeCategory(TSAtomList al, String[] categories){
		return AtomListUtils.removeCategory(al, new ArrayList<String>(Arrays.asList(categories)));
	}

	/**
	 * Removes all atoms of the given categories from the given AtomList
	 * @param al AtomList to remove categories from
	 * @param categories list of categories to process
	 * @return error object if any error occurred, warning object if any warning occurred, TSDefault if removal was successful
	 */
	public static TSDefault removeCategory(TSAtomList al, ArrayList<String> categories){
		TSError err=new TSError();
		TSWarning warn=new TSWarning();

		if(al==null){
			err.tsSetMessage("given AtomList was null");
			return err;
		}
		if(al.size()==0){
			warn.tsSetMessage("given AtomList was empty");
			return warn;
		}
		if(categories.size()==0){
			warn.tsSetMessage("no category given");
			return warn;
		}

		Set<String> rows=al.getRows();
		ArrayList<String> removeList=new ArrayList<String>();
		String currentAtom;
		String currentCategory;
        for (Iterator<String> i = rows.iterator(); i.hasNext(); i.hasNext()){
        	currentAtom=i.next();
        	currentCategory=al.get(currentAtom,TSAtomList.alValCategory).toString();
       		if(categories.equals(currentCategory))
       			removeList.add(currentAtom);
		}

        if(removeList.size()==0){
        	warn.tsSetMessage("nothing found to remove");
			return warn;
        }

        //now go through the remove list and remove the no longer needed atoms
        int size=removeList.size();
        for(int i=0;i<size;i++)
        	al.remove(removeList.get(i));

		return new TSDefault();
	}

	/**
	 * Returns a map of atom categories as keys and the number of atoms registered for the category as integer. 
	 * @param al atom list to process
	 * @return map of atom categories (string) and number of atoms in the category (integer), or empty map
	 */
	public static LinkedHashMap<String, Integer> atomsPerCategory(TSAtomList al){
		LinkedHashMap<String, Integer> ret=new LinkedHashMap<String, Integer>();
		Set<String> rows=al.getRows();

		for (Iterator<String> i = rows.iterator(); i.hasNext(); i.hasNext()){
			String current=i.next();
        	String category=al.get(current,TSAtomList.alValCategory).toString();
        	if(!ret.containsKey(category))
        		ret.put(category, 0);
        	ret.put(category, ret.get(category)+1);
		}
		return ret;
	}
}
