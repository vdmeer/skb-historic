/* Copyright (c) 2010-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.kb;

import org.apache.log4j.Logger;
import org.skb.base.PathKeys;
import org.skb.base.classic.config.Configuration;
import org.skb.base.classic.misc.LogManager;
import org.skb.base.composite.misc.TSI18NManager;

/**
 * Static class that provides an init method to realise all SKB initialisation.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public final class SKBInit {
	/** Logger instance */
	static Logger logger=Logger.getLogger(SKBInit.class);

	/** Logger instance */
	public static Configuration config=Configuration.getConfiguration(SKBInit.class);

	/**
	 * Initialise the SKB to be in operational state.
	 * 
	 * This method should be called before any other call to the SKB, including {@link SKB#getInstance()}.
	 * It will request an SKB instance (and being the first one to do so initialise the SKB) and call any other
	 * method required to complete the initialisation (such as {@link SKB#load_core_packages()}.
	 * @return true if all calls were successful, false otherwise (some exception catched, for details see log information)
	 */
	public static boolean init(){
		LogManager.init();
		config.config.put(PathKeys.pathInstancesI18nmanager, new TSI18NManager());
		config.config.put(PathKeys.pathInstancesKbDatamanager, new SKBDataManager());

		boolean ret=false;
		try{
			logger.trace("creating first SKB instance");
			@SuppressWarnings("unused")
			SKB mySKB=SKB.getInstance();
			ret=true;
		}
		catch(Exception e){
			logger.error("SKBInit exception initialising SKB and SKBDataManager\n"+e);
		}
		try{
			logger.trace("loading SKB core packages");
			SKB mySKB=SKB.getInstance();
			mySKB.load_core_packages();
		}
		catch(Exception e){
			logger.error("SKBInit exception loading core packages\n"+e);
		}

		logger.trace("return ("+ret+")");
		return ret;
	}
}
