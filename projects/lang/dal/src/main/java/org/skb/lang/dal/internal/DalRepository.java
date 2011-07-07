package org.skb.lang.dal.internal;

import java.util.Iterator;
import java.util.Set;

import org.skb.types.atomic.antlr.OatAntlrToken;
import org.skb.types.atomic.util.OatArrayListString;
import org.skb.types.composite.util.OatMapLH;
import org.antlr.runtime.Token;
import org.antlr.stringtemplate.StringTemplate;

public class DalRepository extends OatMapLH{
	public static final String token="token";
	public static final String type="type";
	public static final String elements="elements";
	public static final String sequence="sequence";
	public static final String val_exp="val_exp";
	public static final String val="val";

	private String repo;
	private String currentRepoTable;
	private String currentRepoElement;

	private static class DalRepositoryHolder{
		private final static DalRepository INSTANCE = new DalRepository();
	}

	/**
	 * Return a pointer to the instance of the repository (singleton)
	 * @return the pointer to the instance
	 */
	public static DalRepository getInstance(){
		return DalRepositoryHolder.INSTANCE;
	}

	public DalRepository(){
		super();
		this.init();

		this.repo=new String();
		this.currentRepoTable=new String();
		this.currentRepoElement=new String();
	}

	public void currentRepo(Token repo){
		this.repo=repo.getText();
		this.put(this.repo+"/token", new OatAntlrToken(repo));
	}

	public void currentRepo(){
		this.repo=new String();
		this.clean();
	}

	public String getCurrentRepo(){
		return this.repo;
	}

	public void currentRepoTable(Token table){
		this.currentRepoTable=table.getText();
		this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.token, new OatAntlrToken(table));
	}

	public void currentRepoTable(){
		this.currentRepoTable=new String();
	}

	public void addRepoElement(Token element, Token type){
		this.currentRepoElement=element.getText();
		this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.token, new OatAntlrToken(element));
		this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.type, new OatAntlrToken(type));
	}

	public void addRepoElementValueExpr(Token expr){
		this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.val_exp, new OatAntlrToken(expr));
	}

	public void addRepoElementValue(Token val){
		if(!this.containsKey(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.val))
			this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.val, new OatArrayListString());
		((OatArrayListString)this.get(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+this.currentRepoElement+"/"+DalRepository.val)).add(val.getText());
	}	

	public void currentRepoElement(){
		this.currentRepoElement=new String();
	}

	public void addToSequence(Token seq){
		if(!this.containsKey(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements+"/"+seq.getText()))
			System.err.println(repo+"."+currentRepoTable+" = does NOT contain element == "+seq.getText());

		if(!this.containsKey(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.sequence))
			this.put(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.sequence, new OatArrayListString());
		((OatArrayListString)this.get(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.sequence)).add(seq.getText());
	}

	public void checkSequence(){
		OatArrayListString als=((OatArrayListString)this.get(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.sequence));
		Set<String> keys=((OatMapLH)this.get(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.elements)).keySet();

		Iterator<String>it=keys.iterator();
		while(it.hasNext()){
			String elem=it.next();
		    if(!als.contains(elem))
		    	System.err.println(repo+"."+currentRepoTable+" sequence does not include == "+elem);
		}
	}

	public boolean checkElement(String table, String elem){
		boolean ret=false;
		if(this.get(this.repo+"/"+table+"/"+DalRepository.elements)==null)
			return false;
		Set<String> keys=((OatMapLH)this.get(this.repo+"/"+table+"/"+DalRepository.elements)).keySet();
		if(keys.contains(elem))
			ret=true;
		return ret;
	}

	public StringTemplate getTableST(){
		if(!this.containsKey(this.repo+"/"+this.currentRepoTable)){
			System.err.println("getTableST = table not found in repo = "+this.currentRepoTable);
			return new StringTemplate();
		}

		String start="CREATE TABLE ["+this.currentRepoTable+"] ($\\n$";
		String end=");$\\n$";
		String tpl=new String();

		OatArrayListString seq=((OatArrayListString)this.get(this.repo+"/"+this.currentRepoTable+"/"+DalRepository.sequence));
		for(int i=0;i<seq.size();i++){
			tpl+="    ["+seq.get(i)+"] TEXT";
			if(i<(seq.size()-1))
				tpl+=",$\\n$";
			else
				tpl+="$\\n$";
		}
		return new StringTemplate(start+tpl+end);
	}
}
