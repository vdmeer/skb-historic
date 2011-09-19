package org.skb.util.patterns.structural.composite.atomic.lang;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.skb.util.languages.AtomList;
import org.skb.util.patterns.structural.composite.TSAtomicAPI;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.atomic.db.TSPDO;

public class TSAtomList extends AtomList implements TSAtomicAPI {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSPDO.class);

	/** String Vector maintaining the type hierarchy of the class, must be identical to typeEnum */ 
	protected final Vector<String> typeString=new Vector<String>(Arrays.asList(TSRepository.TString.TS_BASE));

	/** TEnum Set maintaining the type hierarchy of the class, must be identical to typeString */
	protected final LinkedHashSet<TEnum> typeEnum=new LinkedHashSet<TEnum>(EnumSet.of(TEnum.TS_BASE));


	public TSAtomList(){
		super();
		this._initAL();
	}

	private void _initAL(){
		this.typeString.add(TSRepository.TString.TS_ATOMIC);
		this.typeEnum.add(TEnum.TS_ATOMIC);

		this.typeString.add(TSRepository.TString.TS_ATOMIC_LANG_ATOMLIST);
		this.typeEnum.add(TEnum.TS_ATOMIC_LANG_ATOMLIST);
	}

	@Override
	public void tsClean() {
		// TODO Auto-generated method stub
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
	public boolean tsIsType(String type) {
		return this.typeString.contains(type);
	}

	@Override
	public boolean tsIsType(TEnum type) {
		return this.typeEnum.contains(type);
	}

	@Override
	public void tsPlus(TSBaseAPI tb) {
		// TODO Auto-generated method stub
	}

	@Override
	public String tsToString(int indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tsTrim() {
		// TODO Auto-generated method stub
	}

	@Override
	public TSAtomicAPI tsCopyAtomic() {
		// TODO Auto-generated method stub
		return null;
	}

}
