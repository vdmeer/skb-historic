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

import org.skb.util.pattern.Builder;
import org.skb.util.pattern.Reader;
import org.skb.util.pattern.Request;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Abstract class to implement readers for the SKB.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public abstract class SKBReader implements Reader {
	protected Builder builder=null;
	protected boolean is_prepared=false;

	protected TSMapLH entries=null;


	@Override
	public final void setBuilder(Builder builder){
		this.builder=builder;
		//this.builder.set_header();
	}


	@Override
	public final void prepareAndExecute(Request request){
		this.prepare(request);
		this.execute(request);
	}


	@Override
	public final void prepare(Request request){
		if(request.isActivated()==true){
			TSString table=request.getTable();
			TSString table_collections=request.getTableCollections();
			this.entries=new TSMapLH();
			this.prepareLoop(request, table, table_collections);
			this.is_prepared=true;
		}
	}


	@Override
	public final TSMapLH getEntries(){
		if(this.is_prepared==true)
			return this.entries;
		return null;
	}


	@Override
	public final void execute(Request request){
		if(this.is_prepared==false)
			return;
		if(this.builder==null)
			return;
		this.executeLoop(request);
		this.builder.execute(request, this.entries);
	}
}
