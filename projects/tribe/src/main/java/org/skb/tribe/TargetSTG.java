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

package org.skb.tribe;

import org.antlr.stringtemplate.StringTemplate;
import org.skb.util.stringtemplate.STGManager;
import org.skb.util.types.atomic.util.TSArrayListString;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Class that handles target string template groups for the parser.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TargetSTG {
	private boolean initialised;
	private TSMapLH chMan;
	private TSMapLH chOpt;

	private STGManager stdHeader;

	public TargetSTG(){
		this.initialised=false;
		this.chMan=new TSMapLH();
		this.chOpt=new TSMapLH();

		TSMapLH stdHeaderChunks=new TSMapLH();
		stdHeaderChunks.put("std",	     new TSArrayListString(new String[]{"source", "target", "file", "day", "time", "misc"}));
		stdHeaderChunks.put("fImport",   new TSArrayListString(new String[]{"target", "import"}));
		stdHeaderChunks.put("fileStart", new TSArrayListString(new String[]{"target"}));
		stdHeaderChunks.put("fileEnd",   new TSArrayListString(new String[]{"target"}));

		this.stdHeader=new STGManager();
		this.stdHeader.setMandatoryChunks(stdHeaderChunks);

		TargetSTGChunks chunks=new TargetSTGChunks();
		this.chMan.putAll(chunks.getMandatory());
		this.chOpt.putAll(chunks.getOptional());

		this.stdHeader.useLexerDefault();
		this.stdHeader.setApplicationName(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyNameLC));
		this.stdHeader.setSTGUrlName(TribeProperties.getInstance().getValue(TribeProperties.tpmKeyGenericSTG).toString());
		this.stdHeader.loadSTG("string template for generic header", "");

		this.initialised=true;
	}

	public boolean isInitialised(){return this.initialised;}
	public TSMapLH getMandatory(){return this.chMan;}
	public TSMapLH getOptional(){return this.chOpt;}

	public StringTemplate getStdHeaderST(){return this.stdHeader.getSTG().getInstanceOf("std");}
	public StringTemplate getFileStartST(){return this.stdHeader.getSTG().getInstanceOf("fileStart");}
	public StringTemplate getFileEndST(){return this.stdHeader.getSTG().getInstanceOf("fileEnd");}

}
