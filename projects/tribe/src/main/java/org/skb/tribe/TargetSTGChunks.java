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

import org.skb.util.patterns.structural.composite.TSBaseAPI;
import org.skb.util.patterns.structural.composite.TSRepository.TEnum;
import org.skb.util.patterns.structural.composite.composite.util.TSMapLH;

/**
 * Class that checks the chunks of a given string template with a required list.
 *
 * @author     Sven van der Meer
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TargetSTGChunks {
	private TSMapLH chMan;
	private TSMapLH chOpt;

	public TargetSTGChunks(){
		this.chMan=new TSMapLH();
		this.chOpt=new TSMapLH();

		LanguageConfiguration cfg=LanguageConfiguration.getInstance();
		TSMapLH map=cfg.getLanguageStgChunks();
		if(map!=null){
			TSBaseAPI ala;
			for (String s:map.keySet()){
				ala=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBTribeStgChunkMandatory);
				if(ala!=null&&!ala.tsIsType(TEnum.TS_NULL))
					this.chMan.put(s, ala);
				ala=map.get(s+"/"+LanguageConfigurationConstants.Fields.SKBTribeStgChunkOptional);
				if(ala!=null&&!ala.tsIsType(TEnum.TS_NULL))
					this.chOpt.put(s, ala);
			}
		}
	}

	public TSMapLH getMandatory(){return this.chMan;}
	public TSMapLH getOptional(){return this.chOpt;}
}
