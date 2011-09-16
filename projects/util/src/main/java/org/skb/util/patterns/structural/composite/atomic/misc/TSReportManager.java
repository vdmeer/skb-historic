/**
 * 
 */
package org.skb.util.patterns.structural.composite.atomic.misc;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.misc.ReportManager;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.db.TSPDO;
import org.skb.util.stringtemplate.STGroupManager;

/**
 * @author vdmeer
 *
 */
public class TSReportManager extends ReportManager implements TSAtomicAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSPDO.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));


	public TSReportManager(){
		super();
		this._initRM();
	}


	private void _initRM(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_REPORTMANAGER);
		this.typeEnum.add(TEnum.TS_ATOMIC_REPORTMANAGER);
	}


	@Override
	public void tsClean() {
		// TODO Auto-generated method stub
		logger.warn("tsClean not implemented");
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
		return false;
	}


	@Override
	public boolean tsIsType(String t) {
		return this.typeString.contains(t);
	}


	@Override
	public boolean tsIsType(TEnum t) {
		return this.typeEnum.contains(t);
	}


	@Override
	public void tsPlus(TSBaseAPI tb) {
		logger.warn("tsPlus not implemented");
	}


	@Override
	public String tsToString(int indent) {
		logger.warn("tsToString not implemented");
		return "";
	}


	@Override
	public void tsTrim() {
		logger.warn("tsTrim not implemented");
	}


	@Override
	public TSReportManager tsCopyAtomic(){
		TSReportManager ret=new TSReportManager();
		ret.stgm=new STGroupManager(this.stgm);
		ret.noOfErrors=this.noOfErrors;
		ret.noOfWarnings=this.noOfWarnings;
		ret.noWarnings=this.noWarnings;
		ret.noErrors=this.noErrors;
		ret.fileFN=new String(this.fileFN);
		ret.applicationName=new String(this.applicationName);
		return ret;
	}
}
