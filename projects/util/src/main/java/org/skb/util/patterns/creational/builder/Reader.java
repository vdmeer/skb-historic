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

package org.skb.util.patterns.creational.builder;

import org.skb.util.patterns.structural.composite.atomic.java.TSString;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * Interface for a reader.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public interface Reader {
	/**
	 * Associate an instantiated builder with the reader.
	 * @param builder the builder instance
	 */
	public void setBuilder(Builder builder);


	/**
	 * Prepare (reader only) and Execute (reader and builder).
	 * 
	 * This method will call prepare and execute on the reader. It is a shortcut to calling first prepare and
	 * execute next on the reader.
	 * @param request the request object to parameterise the method
	 */
	public void prepareAndExecute(Request request);


	/**
	 * Prepare the reader.
	 * 
	 * Prepare basically means to do everything needed prior invoking execute. Usually, this would
	 * mean initialise all data structures, possibly reading and processing data from external sources and
	 * other preparation tasks. This function will call prepare_loop before and set is_prepared to true before returning.
	 * @param request the request object to parameterise the method
	 */
	public void prepare(Request request);


	/**
	 * Local Prepare method.
	 * 
	 * If you want your reader to do anything in the preparation stage, simply put all that code in this function.
	 * It will be automatically called by the base object.
	 * @param request the request object to parameterise the method
	 * @param table semantic tag to be used to read from external data sources
	 * @param table_collections semantic tag to be used to read collections from external data sources
	 */
	public void prepareLoop(Request request, TSString table, TSString table_collections);


	/**
	 * Return the current array of entries.
	 * @return entries array
	 */
	public TSMapLH getEntries();


	/**
	 * Execute the reader and the builder.
	 * 
	 * Execute all remaining functionality on the reader first and then call the builder's execute function to 
	 * finish the job. This is only done if is_prepared is true and if a builder was provided (set_builder).
	 * @param request the request object to parameterise the method
	 */
	public void execute(Request request);


	/**
	 * Local Execute method.
	 * 
	 * If you want your reader to do anything in the execution stage, simply put all that code in this function.
	 * It will be automatically called by the base object.
	 * @param request the request object to parameterise the method
	 */
	public void executeLoop(Request request);
}