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

package org.skb.util.classic.misc;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSDouble;
import org.skb.util.composite.java.TSFloat;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSArrayList;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Class that reads a JSON file and transforms it into an TSMapLH.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Json2Oat {
	/** Logger instance */
	public final static Logger logger=Logger.getLogger(Json2Oat.class);

	/**
	 * Class constructor, empty.
	 */
	public Json2Oat(){}

	/**
	 * Reads the given JSON file and logs errors.
	 * @param file JSON file
	 * @return a TSMapLH with information from the JSON file or null in case of errors 
	 */
	public TSBaseAPI read(File file){
		if(file.canRead()){
			try{
				return this.read(new Scanner(file));
			}
			catch (Exception e){
				logger.error("excpetion reading file <"+file.getName()+">\n--> "+e);
			}
		}
		return null;
	}

	/**
	 * Reads the JSON from the given file name (URL) and logs errors.
	 * @param url file name, will be used as URL
	 * @return a TSMapLH with information from the JSON file or null in case of errors
	 */
	public TSBaseAPI read(String url){
		try{
			return this.read(new Scanner(getClass().getResourceAsStream(url)));
		}
		catch(Exception e){
			logger.error("exception getting URL <"+url+"> as stream\n--> "+e);
			return null;
		}
	}

	/**
	 * Reads JSON from the input scanner and transform into an TSMapLH and logs errors.
	 * 
	 * This method parses the <code>input</code> and removes every line starting with either of the two possible single line comments: '//' and '#'.
	 * It then calls s2o with the altered input.
	 * @param input scanner wit JSON specification
	 * @return a TSMapLH with information from the JSON file or null in case of errors
	 */
	public TSBaseAPI read(Scanner input){
		String content=new String();
		try{
			while(input.hasNextLine()){
				String line=input.nextLine();
				if(!StringUtils.startsWithAny(line.trim(), new String[]{"//","#"}))
					content+=line.trim();
			}
		}
		catch (Exception e){
			logger.error("exception while reading from input\n--> "+e);
		}
		return this.s2o(content);
	}

	/**
	 * Transforms the given JSON string into a TSBase object
	 * @param content JSON string
	 * @return The return value depends on the JSON specification. It can be a TSArrayList or a TSMapLH for composite items or a
	 * TSString, TSBoolean, TSInteger, TSDouble or TSFloat for atomic items. The method is using recursion to parse each part of the JSON string and construct
	 * a single TSBase object.
	 */
	public TSBaseAPI s2o(String content){
		try{
			ObjectMapper mapper=new ObjectMapper();
			JsonNode rootNode=mapper.readValue(content, JsonNode.class);
			return this.traverse(rootNode);
		}
		catch (Exception e){
			logger.error("exception while transforming JSON into TSBase\n--> "+e);
		}
		return null;
	}

	/**
	 * Recurses through the given node and constructs a TSBase return.
	 * @param node starting node for recursion
	 * @return TSBase object that is either and TSArrayList, a TSMapLH or an atomic type from the package {@link org.skb.util.composite.java}
	 */
	private TSBaseAPI traverse(JsonNode node){
		if(node.isArray()){
			TSArrayList ret=new TSArrayList();
			Iterator<JsonNode> valFields = node.getElements();
			while(valFields.hasNext())
				ret.add(this.traverse(valFields.next()));
			return ret;
		}
		else if(node.isObject()){
			TSLinkedHashTree ret=new TSLinkedHashTree();
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

		logger.warn("nothing do to here");
		return null;
	}
}
