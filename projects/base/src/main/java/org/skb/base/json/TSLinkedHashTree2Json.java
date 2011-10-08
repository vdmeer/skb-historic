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

package org.skb.base.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.skb.base.composite.TSBaseAPI;
import org.skb.base.composite.util.TSLinkedHashTree;

/**
 * Serialiser for Jackson library, serialising TSLinkhedHashTree.
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class TSLinkedHashTree2Json extends JsonSerializer<TSLinkedHashTree> {
	@Override
	public Class<TSLinkedHashTree> handledType(){
		return TSLinkedHashTree.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serialize(TSLinkedHashTree tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		Map<String, TSBaseAPI> map=((TSLinkedHashTree)tsvalue).tsGetTree();

		@SuppressWarnings("rawtypes")
		JsonSerializer js;
		String key;
		TSBaseAPI val;
		Set<String> o_set=(Set<String>)map.keySet();
		Iterator<String> key_it=o_set.iterator();
		while(key_it.hasNext()){
			key=key_it.next();
			val=map.get(key);
			String keyPrint=key.replace(":", "-");

			switch(val.tsGetTypeEnum()){
				case TS_ATOMIC_JAVA_BOOLEAN:
				case TS_ATOMIC_JAVA_BYTE:
				case TS_ATOMIC_JAVA_DOUBLE:
				case TS_ATOMIC_JAVA_FLOAT:
				case TS_ATOMIC_JAVA_INTEGER:
				case TS_ATOMIC_JAVA_OBJECT:
				case TS_ATOMIC_JAVA_SHORT:
				case TS_ATOMIC_JAVA_STRING:
					jgen.writeStartObject();
					jgen.writeFieldName("name");
					jgen.writeString(keyPrint);
					jgen.writeFieldName("size");

					jgen.writeNumber(90);
					//js=provider.findTypedValueSerializer(val.getClass(), true, null);
					//js.serialize(val, jgen, provider);

					jgen.writeEndObject();
					break;
				case TS_COMPOSITE_TREE:
				case TS_COMPOSITE_TREE_LH:
					jgen.writeStartObject();
					jgen.writeFieldName("name");
					jgen.writeString(keyPrint);
					jgen.writeFieldName("children");
					jgen.writeStartArray();

					js=provider.findTypedValueSerializer(val.getClass(), true, null);
					js.serialize(val, jgen, provider);

					jgen.writeEndArray();
					jgen.writeEndObject();
					break;
//				case TS_COMPOSITE_ARRAYLIST:
//				case TS_ATOMIC_ARRAYLIST_ATOMIC:
//				case TS_ATOMIC_ARRAYLIST_STRING:
//					jgen.writeFieldName(keyPrint);
//					provider.serializeValue(provider.getConfig(), jgen, val, new SKBSerializerFactoryRegistry());
				default:
					break;
			}
		}
	}

	@Override
	public void serializeWithType(TSLinkedHashTree tsvalue, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
		this.serialize(tsvalue, jgen, provider);
	}

}
