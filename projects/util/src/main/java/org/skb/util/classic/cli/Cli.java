/* Copyright (c) 2007-2011 Sven van der Meer
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

package org.skb.util.cli;

import org.apache.commons.cli.ParseException;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.composite.util.TSPropertyMap;

/**
 * Interface for CLI processing.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface Cli {
	/**
	 * Sets the application name, used for reporting errors and warnings
	 * @param appName the application name
	 */
	public abstract boolean setApplicationName(TSBaseAPI appName);

	/**
	 * Set the application name, used for reporting errors and warnings
	 * @param appName the application name
	 */
	public abstract boolean setApplicationName(String appName);

	/**
	 * Returns the current application name
	 * @return current application name, "" if not set after initialisation
	 */
	public abstract String getApplicationName();

	/**
	 * Sets properties, i.e. the command line arguments
	 * @param prop property map with command line arguments
	 */
	public abstract void setPropOptions(TSPropertyMap prop);

	/**
	 * Parse the command line
	 * @param args arguments from the main method
	 * @throws ParseException
	 */
	public abstract void parse(String[] args, boolean stopAtNonOption) throws ParseException;

	/**
	 * Print usage information
	 */
	public abstract String usage(String header, String footer, int width, boolean autoUsage);

	/**
	 * Set options for parsing
	 * @param prop
	 */
	public abstract void setOptions(TSPropertyMap prop);

}