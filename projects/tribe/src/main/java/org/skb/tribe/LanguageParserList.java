package org.skb.tribe;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.skb.util.FieldKeys;
import org.skb.util.misc.ReportManager;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.TSTableRowAPI;
import org.skb.util.patterns.structural.composite.atomic.java.TSBoolean;
import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.atomic.util.TSArrayListString;
import org.skb.util.patterns.structural.composite.composite.util.TSTable;

public class LanguageParserList extends TSTable{
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSTable.class);

	/** Set source language */
	private String setSrcLang=null;

	/** Set target language */
	private String setTgtLang=null;

	//TODO should be replaced
	private TribeProperties prop=TribeProperties.getInstance();
	//TODO should be replaced
	private ReportManager repMgr=ReportManager.getInstance();

	public LanguageParserList(){
		this._initLL();
	}


	private void _initLL(){
		super._init();

		HashSet<String>columns=new HashSet<String>();
		columns.add(FieldKeys.fieldLangSupportedSource);
		columns.add(FieldKeys.fieldLangSupportedTargets);
		columns.add(FieldKeys.fieldLangSupportedParser);
		this.setColumns(columns);
	}


	/**
	 * Add languages to the local table
	 * @param lp array of language parsers
	 */
	public void addLanguages(LanguageParserAPI[] lp){
		for(int i=0;i<lp.length;i++){
			this.addRow(lp[i].getSupportedSourceLang());
			this.put(lp[i].getSupportedSourceLang(), FieldKeys.fieldLangSupportedParser, lp[i]);
			this.put(lp[i].getSupportedSourceLang(), FieldKeys.fieldLangSupportedSource, lp[i].getSupportedSourceLang());
			this.put(lp[i].getSupportedSourceLang(), FieldKeys.fieldLangSupportedTargets, lp[i].getSupportedTargetLang());
		}
	}


	/**
	 * Get mappings supported by registered language parsers
	 * @return TreeMap map of source languages with associated target languages
	 */
	public TreeMap<TSString, TSArrayListString> getMappings(){
		TreeMap<TSString, TSArrayListString> ret=new TreeMap<TSString, TSArrayListString>();
		Collection<String> keys = this.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext(); ){
			TSTableRowAPI row=this.get(i.next());
			ret.put((TSString)row.get(FieldKeys.fieldLangSupportedSource), (TSArrayListString)row.get(FieldKeys.fieldLangSupportedTargets));
		}
		return ret;
	}


	public Boolean setMapping(TSBaseAPI srcLang, TSBaseAPI tgtLang, Boolean gc){
		if(srcLang!=null&&!srcLang.tsIsType(TEnum.TS_NULL))
			this.setSrcLang=srcLang.toString();
		if(tgtLang!=null&&!tgtLang.tsIsType(TEnum.TS_NULL))
			this.setTgtLang=tgtLang.toString();
		if(gc==true&&this.setTgtLang==null)
			return false;
		if(!this.containsKey(this.setSrcLang))
			return false;

		if(this.setTgtLang!=null){
			TSBaseAPI ols=this.get(this.setSrcLang, FieldKeys.fieldLangSupportedTargets);
			if(ols.tsIsType(TEnum.TS_ATOMIC_ARRAYLIST_STRING)&&!((TSArrayListString)ols).contains(this.setTgtLang))
				return false;
		}

		((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).setOptions();
		this.prop.addProperties(((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).getMap());
		((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).loadTarget();
		return true;
	}


	public Boolean checkSetMapping(){
		if(this.setSrcLang==null){
			this.repMgr.reportError("-  no source language specified");
			return false;
		}

        Boolean gc=false;
		try {
			gc=((TSBoolean)prop.getValue(TribeProperties.tpmKeyGC)).tsvalue;
		} catch (Exception e) {}

		if(gc==true&&this.setTgtLang==null){
			this.repMgr.reportError("-  no target language specified");
			return false;
		}
		if(!this.containsKey(this.setSrcLang)){
			this.repMgr.reportError("source language <" + this.setSrcLang + "> not supported");
			return false;
		}
		if(this.setTgtLang!=null){
			TSArrayListString ols=(TSArrayListString)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedTargets);
			if(!ols.contains(this.setTgtLang)){
				this.repMgr.reportError("target language <" + this.setTgtLang + "> not supported for source language <" + this.setSrcLang + ">");
				return false;
			}
		}
		return true;
	}


	public void loadStg(){
		if(this.setSrcLang!=null)
			((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).loadStg();
	}


	public void printStg(){
		if(this.setSrcLang!=null)
			((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).printStg();
	}


	public void parse(InputStream is){
		if(this.setSrcLang!=null)
			((LanguageParserAPI)this.get(this.setSrcLang, FieldKeys.fieldLangSupportedParser)).parse(is);
	}


	public String toString(){
		String ret="";
		Collection<String> keys = this.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext(); ){
			String key=i.next();
			ret+="\n          source:" + this.get(key, FieldKeys.fieldLangSupportedSource).toString() + " -> targets:" + this.get(key, FieldKeys.fieldLangSupportedTargets).toString();
		}
    	return ret;
	}
}
