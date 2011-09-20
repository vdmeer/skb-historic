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
import org.skb.util.FieldKeys;
import org.skb.util.PathKeys;
import org.skb.util.config.Configuration;
import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.composite.util.TSArrayList;
import org.skb.util.patterns.structural.composite.composite.util.TSLinkedHashTree;
import org.skb.util.stringtemplate.STGroupManager;

/**
 * Class that handles target string template groups for the parser.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class STGroupTarget {
	private boolean initialised;
	private TSLinkedHashTree targetCunksMan;
	private TSLinkedHashTree targetChunksOpt;

	private STGroupManager stdHeader;

	public STGroupTarget(TSBaseAPI applicationName, TSBaseAPI genericSTG, Configuration config){
		this.initialised=false;

		TSLinkedHashTree stdHeaderChunks=new TSLinkedHashTree();
		stdHeaderChunks.put("std",	     new TSArrayList(new String[]{"source", "target", "file", "day", "time", "misc"}));
		stdHeaderChunks.put("fImport",   new TSArrayList(new String[]{"target", "import"}));
		stdHeaderChunks.put("fileStart", new TSArrayList(new String[]{"target"}));
		stdHeaderChunks.put("fileEnd",   new TSArrayList(new String[]{"target"}));

		this.stdHeader=new STGroupManager();
		this.stdHeader.setMandatoryChunks(stdHeaderChunks);

		this.stdHeader.useLexerDefault();
		this.stdHeader.setApplicationName(applicationName.toString().toLowerCase());

		this.stdHeader.setSTGFile(genericSTG.toString());
		this.stdHeader.loadSTG("string template for generic header", "");
		//this.stdHeader.testChunks();

		this.targetCunksMan=new TSLinkedHashTree();
		this.targetChunksOpt=new TSLinkedHashTree();
		this.getChunks(config);

		this.initialised=true;
	}

	protected boolean getChunks(Configuration config){
		//LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		//TSMapLH map=cfg.getLanguageStgChunks();
		TSLinkedHashTree map=(TSLinkedHashTree)config.config.get(PathKeys.pathConfigurationParserLangStgChunks);
		if(map!=null){
			TSBaseAPI ala;
			for (String s:map.keySet()){
				ala=map.get(s+"/"+FieldKeys.fieldStringtemplateChunksMandatory);
				if(ala!=null&&!ala.tsIsType(TEnum.TS_NULL))
					this.targetCunksMan.put(s, ala);
				ala=map.get(s+"/"+FieldKeys.fieldStringtemplateChunksOptional);
				if(ala!=null&&!ala.tsIsType(TEnum.TS_NULL))
					this.targetChunksOpt.put(s, ala);
			}
		}
		return true;
	}

	public boolean isInitialised(){
		return this.initialised;
	}

	public TSLinkedHashTree getMandatory(){
		return this.targetCunksMan;
	}

	public TSLinkedHashTree getOptional(){
		return this.targetChunksOpt;
	}

	public StringTemplate getStdHeaderST(){
		return this.stdHeader.getSTG().getInstanceOf("std");
	}

	public StringTemplate getFileStartST(){
		return this.stdHeader.getSTG().getInstanceOf("fileStart");
	}

	public StringTemplate getFileEndST(){
		return this.stdHeader.getSTG().getInstanceOf("fileEnd");
	}
}
