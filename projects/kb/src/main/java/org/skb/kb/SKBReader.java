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

import org.skb.types.atomic.java.OatString;
import org.skb.types.composite.util.OatMapLH;
import org.skb.util.pattern.Builder;
import org.skb.util.pattern.Reader;
import org.skb.util.pattern.Request;

public abstract class SKBReader implements Reader {
	protected Builder builder=null;
	protected boolean is_prepared=false;

	protected OatMapLH entries=null;

	public SKBReader(){}

	public final void set_builder(Builder builder){
		this.builder=builder;
//		this.builder.set_header();
	}

	public final void prepare_and_execute(Request request){
		this.prepare(request);
		this.execute(request);
	}

	public final void prepare(Request request){
		if(request.isActivated()==true){
			OatString table=request.getTable();
			OatString table_collections=request.getTableCollections();
			this.entries=new OatMapLH();
			this.prepare_loop(request, table, table_collections);
			this.is_prepared=true;
		}
	}

	public final OatMapLH get_entries(){
		if(this.is_prepared==true)
			return this.entries;
		return null;
	}

	protected abstract void prepare_loop(Request request, OatString table, OatString table_collections);

	public final void execute(Request request){
		if(this.is_prepared==false)
			return;
		if(this.builder==null)
			return;
		this.execute_loop(request);
		this.builder.execute(request, this.entries);
	}

	protected abstract void execute_loop(Request request);
}
