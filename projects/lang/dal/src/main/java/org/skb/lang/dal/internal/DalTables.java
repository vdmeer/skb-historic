package org.skb.lang.dal.internal;

import java.util.Set;

import org.antlr.runtime.Token;
import org.skb.lang.dal.constants.DalConstants;
import org.skb.util.types.atomic.antlr.TSToken;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;

public class DalTables extends TSMapLH{
	public static final String token="token";
	public static final String type="type";
	public static final String val_exp="val_exp";

	private String curRepo;
	private String curTable;
	private String curField;

	private static class DalRepositoryHolder{
		private final static DalTables INSTANCE = new DalTables();
	}

	/**
	 * Return a pointer to the instance of the repository (singleton)
	 * @return the pointer to the instance
	 */
	public static DalTables getInstance(){
		return DalRepositoryHolder.INSTANCE;
	}

	public DalTables(){
		super();
		this._init();

		this.curRepo=new String();
		this.curTable=new String();
		this.curField=new String();
	}


	public void curRepoSet(Token repo){
		this.curRepo=repo.getText();
		this.put(this.curRepo+"/token", new TSToken(repo));
	}
	
	public void curRepoClear(){
		this.curRepo=new String();
		this.tsClean();
	}
	
	public String curRepoGet(){
		return this.curRepo;
	}

	public void curTableSet(Token table){
		this.curTable=table.getText();
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTables.token, new TSToken(table));
	}

	public void curTableClear(){
		this.curTable=new String();
	}

	public String curTableGet(){
		return this.curTable;
	}

	public void curFieldClear(){
		this.curField=new String();
	}

	public String curFieldGet(){
		return this.curField;
	}

	public void curTableAddField(Token element, Token type){
		this.curField=element.getText();
		this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalTables.token, new TSToken(element));
		this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalTables.type, new TSToken(type));
	}

	public void curFieldValueExprSet(Token expr){
		this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalTables.val_exp, new TSToken(expr));
	}

	public void curFieldValueSet(Token val){
		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalConstants.Tokens.dalVALUE))
			this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalConstants.Tokens.dalVALUE, new TSArrayListString());
		((TSArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+DalConstants.Tokens.dalVALUE)).add(val.getText());
	}	

	public void curFieldPropertySet(String prop, Token tk){
		this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+this.curField+"/"+prop, new TSToken(tk));
	}

	public void curTableSequenceAdd(Token seq){
		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD+"/"+seq.getText()))
			System.err.println(curRepo+"."+curTable+" = does NOT contain element == "+seq.getText());

		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalSEQUENCE))
			this.put(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalSEQUENCE, new TSArrayListString());
		((TSArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalSEQUENCE)).add(seq.getText());
	}

/*
	public void curTableSequenceCheck(){
		OatArrayListString als=((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalSEQUENCE));
		Set<String> keys=((OatMapLH)this.get(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalFIELD)).keySet();

		Iterator<String>it=keys.iterator();
		while(it.hasNext()){
			String elem=it.next();
		    if(!als.contains(elem))
		    	System.err.println(curRepo+"."+curTable+" sequence does not include == "+elem);
		}
	}
*/

	public boolean curFieldCheck(String table, String elem){
		boolean ret=false;
		if(this.get(this.curRepo+"/"+table+"/"+DalConstants.Tokens.dalFIELD)==null)
			return false;
		Set<String> keys=((TSMapLH)this.get(this.curRepo+"/"+table+"/"+DalConstants.Tokens.dalFIELD)).keySet();
		if(keys.contains(elem))
			ret=true;
		return ret;
	}
/*
	public OatArrayListString curTableSequenceGet(){
		return ((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalConstants.Tokens.dalSEQUENCE));
	}
*/
	public TSArrayListString tableSequenceGet(String repo, String table){
		return ((TSArrayListString)this.get(repo+"/"+table+"/"+DalConstants.Tokens.dalSEQUENCE));
	}
}
