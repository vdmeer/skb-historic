package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.skb.util.composite.java.TSString;

public class TSString2Json extends JsonSerializer<TSString> {
	@Override
	public Class<TSString> handledType(){
		return TSString.class;
	}

	@Override
	public void serialize(TSString tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeString(((TSString)tsvalue).tsvalue);
	}

	@Override
	public void serializeWithType(TSString tsvalue, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
		jgen.writeString(((TSString)tsvalue).tsvalue);
	}
}
