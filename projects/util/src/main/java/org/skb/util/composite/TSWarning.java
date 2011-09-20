package org.skb.util.composite;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSRepository.TEnum;

/**
 * Warning Class, can be used to return a warning message.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSWarning extends TSDefault {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSWarning.class);

	/**
	 * Class constructor
	 */
	public TSWarning(){
		this.typeString.add(TSRepository.TString.TS_WARNING);
		this.typeEnum.add(TEnum.TS_WARNING);
	}
}
