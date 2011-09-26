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

package org.skb.util.classic.json;

import java.io.StringWriter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSByte;
import org.skb.util.composite.java.TSDouble;
import org.skb.util.composite.java.TSFloat;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSLong;
import org.skb.util.composite.java.TSObject;
import org.skb.util.composite.java.TSShort;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSLinkedHashTree;

/**
 * Class that provides initialised ObjectMappers for serialising TS object.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TS2Json {

	/**
	 * Returns an ObjectMapper ready to serialise all SKB Composite types, with specific serialisers for atomic types.
	 * @return ready to serialise ObjectMapper
	 */
	public static ObjectMapper getMapper(){
		SimpleModule module=TS2Json.getStandardSerialisers();

	    module.addSerializer(TSLinkedHashTree.class, new TSLinkedHashTree2Json());

		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(module);

	    mapper.canSerialize(TSBoolean.class);
	    mapper.canSerialize(TSByte.class);
	    mapper.canSerialize(TSDouble.class);
	    mapper.canSerialize(TSFloat.class);
	    mapper.canSerialize(TSInteger.class);
	    mapper.canSerialize(TSLong.class);
	    mapper.canSerialize(TSObject.class);
	    mapper.canSerialize(TSShort.class);
	    mapper.canSerialize(TSString.class);

	    return mapper;
	}

	/**
	 * Returns an ObjectMapper ready to serialise all SKB Composite types, with special serialisers for D3 visualisation library.
	 * @return ready to serialise ObjectMapper
	 */
	public static ObjectMapper getMapperD3(){
		SimpleModule module=TS2Json.getStandardSerialisers();

	    module.addSerializer(TSLinkedHashTree.class, new TSLinkedHashTree2Json());

		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(module);

	    mapper.canSerialize(TSBoolean.class);
	    mapper.canSerialize(TSByte.class);
	    mapper.canSerialize(TSDouble.class);
	    mapper.canSerialize(TSFloat.class);
	    mapper.canSerialize(TSInteger.class);
	    mapper.canSerialize(TSLong.class);
	    mapper.canSerialize(TSObject.class);
	    mapper.canSerialize(TSShort.class);
	    mapper.canSerialize(TSString.class);

	    mapper.canSerialize(TSLinkedHashTree.class);

	    return mapper;
	}

	/**
	 * Creates a new module and adds serialisers for atomic types.
	 * @return
	 */
	private static SimpleModule getStandardSerialisers(){
	    SimpleModule module=new SimpleModule("SKBSerialiseJson", new Version(0, 1, 0, "alpha"));
	    module.addSerializer(TSBoolean.class, new TSBoolean2Json());
	    module.addSerializer(TSByte.class, new TSByte2Json());
	    module.addSerializer(TSDouble.class, new TSDouble2Json());
	    module.addSerializer(TSFloat.class, new TSFloat2Json());
	    module.addSerializer(TSInteger.class, new TSInteger2Json());
	    module.addSerializer(TSLong.class, new TSLong2Json());
	    module.addSerializer(TSObject.class, new TSObject2Json());
	    module.addSerializer(TSShort.class, new TSShort2Json());
	    module.addSerializer(TSString.class, new TSString2Json());

	    return module;
	}

	/**
	 * Returns a JsonGenerator with pretty printer.
	 * @param sw the input writer as StringWriter
	 * @return JsonGenerator
	 */
	public static JsonGenerator getJsonGeneratorSW(StringWriter sw){
		MappingJsonFactory jsonFactory=new MappingJsonFactory();
		try{
			JsonGenerator jsonGenerator=jsonFactory.createJsonGenerator(sw);
			jsonGenerator.useDefaultPrettyPrinter();
			return jsonGenerator;
		} catch(Exception e){
			System.err.println(e);
		}
		return null;
	}
}
