package org.skb.lang.dal.internal;

import java.util.Set;

import org.antlr.runtime.Token;
import org.skb.lang.dal.DalTokensConstants;
import org.skb.types.atomic.antlr.OatAntlrToken;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.composite.util.OatMapLH;

public class DalTables extends OatMapLH{
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
		this.init();

		this.curRepo=new String();
		this.curTable=new String();
		this.curField=new String();
	}


	public void curRepoSet(Token repo){
		this.curRepo=repo.getText();
		this.put(this.curRepo+"/token", new OatAntlrToken(repo));
	}
	
	public void curRepoClear(){
		this.curRepo=new String();
		this.clean();
	}
	
	public String curRepoGet(){
		return this.curRepo;
	}

	public void curTableSet(Token table){
		this.curTable=table.getText();
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTables.token, new OatAntlrToken(table));
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
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTables.token, new OatAntlrToken(element));
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTables.type, new OatAntlrToken(type));
	}

	public void curFieldValueExprSet(Token expr){
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTables.val_exp, new OatAntlrToken(expr));
	}

	public void curFieldValueSet(Token val){
		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTokensConstants.dalVALUE))
			this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTokensConstants.dalVALUE, new OatArrayListString());
		((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+DalTokensConstants.dalVALUE)).add(val.getText());
	}	

	public void curFieldPropertySet(String prop, Token tk){
		this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+this.curField+"/"+prop, new OatAntlrToken(tk));
	}

	public void curTableSequenceAdd(Token seq){
		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD+"/"+seq.getText()))
			System.err.println(curRepo+"."+curTable+" = does NOT contain element == "+seq.getText());

		if(!this.containsKey(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalSEQUENCE))
			this.put(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalSEQUENCE, new OatArrayListString());
		((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalSEQUENCE)).add(seq.getText());
	}

/*
	public void curTableSequenceCheck(){
		OatArrayListString als=((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalSEQUENCE));
		Set<String> keys=((OatMapLH)this.get(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalFIELD)).keySet();

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
		if(this.get(this.curRepo+"/"+table+"/"+DalTokensConstants.dalFIELD)==null)
			return false;
		Set<String> keys=((OatMapLH)this.get(this.curRepo+"/"+table+"/"+DalTokensConstants.dalFIELD)).keySet();
		if(keys.contains(elem))
			ret=true;
		return ret;
	}
/*
	public OatArrayListString curTableSequenceGet(){
		return ((OatArrayListString)this.get(this.curRepo+"/"+this.curTable+"/"+DalTokensConstants.dalSEQUENCE));
	}
*/
	public OatArrayListString tableSequenceGet(String repo, String table){
		return ((OatArrayListString)this.get(repo+"/"+table+"/"+DalTokensConstants.dalSEQUENCE));
	}
}
