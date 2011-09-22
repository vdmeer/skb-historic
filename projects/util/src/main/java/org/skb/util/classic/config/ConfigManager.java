/* Copyright (c) 2005-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
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

package org.skb.util.classic.config;

import java.util.LinkedHashMap;

/**
 * Manages configuration objects.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class ConfigManager {
	/** Local list of active configurations */
	private LinkedHashMap<Class<?>, Configuration> configurations;

	/**
	 * Singleton instance holder
	 */
	private static class ConfigManagerHolder{
		private final static ConfigManager INSTANCE = new ConfigManager();
	}

	/**
	 * Singleton getInstance
	 * @return pointer to the TribeProperty instance
	 */
	public static ConfigManager getInstance(){
		return ConfigManagerHolder.INSTANCE;
	}

	/**
	 * Class constructor, private for singleton
	 */
	private ConfigManager(){
		this.configurations=new LinkedHashMap<Class<?>, Configuration>();
	}

	/**
	 * Returns a configuration identified by a class name.
	 * @param clazz class name for the configuration
	 * @return configuration object
	 */
	public Configuration getConfiguration(Class<?> clazz){
		if(!this.configurations.containsKey(clazz)){
			this.configurations.put(clazz, new Configuration(clazz));
		}
		return this.configurations.get(clazz);
	}
}
