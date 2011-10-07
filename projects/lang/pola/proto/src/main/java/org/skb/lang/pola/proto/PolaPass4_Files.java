/* Copyright (c) 2009-2011 Sven van der Meer
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

package org.skb.lang.pola.proto;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.skb.base.FieldKeys;
import org.skb.base.classic.config.Configuration;
import org.skb.base.classic.config.ConfigurationProperties;
import org.skb.base.classic.io.files.FileTemplateList;
import org.skb.base.composite.lang.TSAtomList;

/**
 * Pass 4 of the Pola parser generating output files.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class PolaPass4_Files {
	/** Logger instance */
	static Logger logger = Logger.getLogger(PolaPass4_Files.class);

	/** Configuration instance */
	public static Configuration config=Configuration.getConfiguration(PolaParser.class);

	private FileTemplateList ftl;
	private TSAtomList atoms;
	private ConfigurationProperties prop;

	public PolaPass4_Files(){
		this.ftl=new FileTemplateList();
		this.atoms=config.getAtomlist();
		this.prop=config.getProperties();
	}

	public FileTemplateList getFileTemplateList(){
		String fn;

		//no split, so go through the atoms, put all children into the body of their parent
		//add the final template to the ftl and give back
		fn=this.prop.getValue(FieldKeys.fieldCliOptionTgtFile).toString();

		ArrayList<String> rows=new ArrayList<String>(this.atoms.getRows());
		Integer size=rows.size();
		for(int i=1;i<size;i++)
			this.ftl.addTemplate(fn,this.atoms.getST(rows.get(i)));
		return this.ftl;
	}
}