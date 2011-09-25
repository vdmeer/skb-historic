package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.skb.util.composite.java.TSInteger;

public class TSInteger2Json extends JsonSerializer<TSInteger> {
	@Override
	public Class<TSInteger> handledType(){
		return TSInteger.class;
	}

	@Override
	public void serialize(TSInteger tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeNumber(((TSInteger)tsvalue).tsvalue);
	}

	@Override
	public void serializeWithType(TSInteger tsvalue, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
		jgen.writeNumber(((TSInteger)tsvalue).tsvalue);
	}
}
