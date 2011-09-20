package org.skb.util.composite;

import org.apache.log4j.Logger;
import org.skb.util.composite.TSRepository.TEnum;

/**
 * Error Class, can be used to return an error message.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSError extends TSDefault {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(TSError.class);

	/**
	 * Class constructor
	 */
	public TSError(){
		this.typeString.add(TSRepository.TString.TS_ERROR);
		this.typeEnum.add(TEnum.TS_ERROR);
	}

}
