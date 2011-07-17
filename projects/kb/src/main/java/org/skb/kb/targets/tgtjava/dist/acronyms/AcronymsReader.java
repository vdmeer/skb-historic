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

package org.skb.kb.targets.tgtjava.dist.acronyms;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import org.skb.kb.SKB;
import org.skb.kb.SKBReader;
import org.skb.util.pattern.Request;
import org.skb.util.types.atomic.java.OatString;
import org.skb.util.types.atomic.util.OatPDO;

public class AcronymsReader extends SKBReader {

	@Override
	protected void prepare_loop(Request request, OatString table, OatString tableCollections) {
		// TODO Auto-generated method stub
		SKB mySKB=SKB.getInstance();

		ResultSet rs;
		ArrayList<String> cols;
		OatPDO pdo;

		pdo=mySKB.pdoSelect("acronyms");

		rs=pdo.oatValue.query("*", "acronyms", null, "acronyms:short");
		cols=pdo.oatValue.get_columns();
		try{
			while(rs.next()){
				for(int i=0;i<cols.size();i++){
					this.entries.put(new ArrayList<String>(Arrays.asList(rs.getString("key"), cols.get(i))), rs.getString(cols.get(i)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mySKB.interpretMap(this.entries, "acronyms");
	}

	@Override
	protected void execute_loop(Request request) {
		// TODO Auto-generated method stub

	}
}
