package org.skb.util.classic.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.TSBaseAPI;
import org.skb.util.composite.util.TSLinkedHashTree;

public class TSLinkedHashTree2Json extends JsonSerializer<TSLinkedHashTree> {
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

					//jgen.writeNumber(90);
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
}
