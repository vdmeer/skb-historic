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

package org.skb.util.misc;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.skb.util.types.api.TSBase;
import org.skb.util.types.atomic.java.TSBoolean;
import org.skb.util.types.atomic.java.TSDouble;
import org.skb.util.types.atomic.java.TSFloat;
import org.skb.util.types.atomic.java.TSInteger;
import org.skb.util.types.atomic.java.TSString;
import org.skb.util.types.composite.util.TSArrayList;
import org.skb.util.types.composite.util.TSMapLH;

/**
 * Class that reads a json file and transforms it into an TSMapLH.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
public class Json2Oat {

	public Json2Oat(){}

	public TSBase read(File file){
		if(file.canRead()){
			try{
				return this.read(new Scanner(file));
			}
			catch (Exception e){System.err.println(e);}
		}
		return null;
	}

	public TSBase read(String url){
		try{
			return this.read(new Scanner(getClass().getResourceAsStream(url)));
		}catch(Exception e){return null;}
	}

	public TSBase read(Scanner input){
		String content=new String();
		try{
			while(input.hasNextLine()){
				String line=input.nextLine();
				if(!StringUtils.startsWithAny(line.trim(), new String[]{"//","#"}))
					content+=line.trim();
			}
		}
		catch (Exception e){System.err.println(e);}
		return this.s2o(content);
	}

	public TSBase s2o(String content){
		try{
			ObjectMapper mapper=new ObjectMapper();
			JsonNode rootNode=mapper.readValue(content, JsonNode.class);
			return this.traverse(rootNode);
		}
		catch (Exception e){System.err.println(e);}
		return null;
	}

	private TSBase traverse(JsonNode node){
		if(node.isArray()){
			TSArrayList ret=new TSArrayList();
			Iterator<JsonNode> valFields = node.getElements();
			while(valFields.hasNext())
				ret.add(this.traverse(valFields.next()));
			return ret;
		}
		else if(node.isObject()){
			TSMapLH ret=new TSMapLH();
			Iterator<JsonNode> valFields = node.getElements();
			Iterator<String> keyFields = node.getFieldNames();
			while(keyFields.hasNext()&&valFields.hasNext())
				ret.put(keyFields.next(), this.traverse(valFields.next()));
			return ret;
		}
		else if(node.isTextual())
			return new TSString(node.getTextValue());
		else if(node.isBoolean())
			return new TSBoolean(node.getBooleanValue());
		else if(node.isIntegralNumber())
			return new TSInteger(node.getIntValue());
		else if(node.isDouble())
			return new TSDouble(node.getDoubleValue());
		else if(node.isFloatingPointNumber())
			return new TSFloat(node.getDoubleValue());
		else if(node.isNull())
			return new TSString("");
System.err.println("nothing for");
		return null;
	}
}
