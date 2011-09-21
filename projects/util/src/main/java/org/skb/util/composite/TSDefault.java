package org.skb.util.composite;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSRepository.TEnum;

/**
 * Default Class.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSDefault implements TSAtomicAPI, TSCompositeAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSDefault.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE, TSRepository.TString.TS_ATOMIC, TSRepository.TString.TS_COMPOSITE, TSRepository.TString.TS_DEFAULT));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE, TEnum.TS_ATOMIC, TEnum.TS_COMPOSITE, TEnum.TS_DEFAULT));

	/** Message for the class, can be used to express why it is used/returned */
	protected String message=null;

	/** Explanation for the class, i.e. explaining the message in more detail */
	protected String explanation=null;

	/**
	 * Class constructor.
	 */
	public TSDefault(){
	}

	/**
	 * Gets the message of the object.
	 * @return current message
	 */
	public String tsGetMessage(){
		if(this.message==null)
			return "";
		return this.message;
	}

	/**
	 * Sets a message for the object.
	 * @param msg new message
	 */
	public void tsSetMessage(String msg){
		this.message=msg;
	}

	/**
	 * Gets the explanation of the object.
	 * @return current explanation
	 */
	public String tsGetExplanation(){
		if(this.explanation==null)
			return "";
		return this.explanation;
	}

	/**
	 * Sets an explanation for the object.
	 * @param expl new explanation
	 */
	public void tsSetExplanation(String expl){
		this.explanation=expl;
	}

	@Override
	public TSCompositeAPI tsCopyComposite() {
		return new TSDefault();
	}

	@Override
	public TSAtomicAPI tsCopyAtomic() {
		return new TSDefault();
	}

	@Override
	public void tsClean() {
		logger.warn("tsClean has no effect on TSNull, yet someone called it");
	}

	@Override
	public TEnum tsGetTypeEnum() {
		return TSRepository.type(this.typeString.lastElement());
	}

	@Override
	public Set<TEnum> tsGetTypeEnumSet() {
		return this.typeEnum;
	}

	@Override
	public String tsGetTypeString() {
		return this.typeString.lastElement();
	}

	@Override
	public List<String> tsGetTypeStringList() {
		return this.typeString;
	}

	@Override
	public boolean tsIsAtomic() {
		return true;
	}

	@Override
	public boolean tsIsComposite() {
		return true;
	}

	@Override
	public boolean tsIsType(String type) {
		return this.typeString.contains(type);
	}

	@Override
	public boolean tsIsType(TEnum type) {
		return this.typeEnum.contains(type);
	}

	@Override
	public void tsPlus(TSBaseAPI tb) {
		logger.warn("tsPlus has no effect on TSNull, yet someone called it");
	}

	@Override
	public String toString(){
		return this.tsToString(0);
	}

	@Override
	public String tsToString(int indent) {
		String ret=new String();
		if(this.message!=null)
			ret+=this.message;
		if(this.explanation!=null)
			ret+="\n"+this.explanation;
		return ret;
	}

	@Override
	public void tsTrim() {
		logger.warn("tsTrim has no effect on TSNull, yet someone called it");
	}

}
