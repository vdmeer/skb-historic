package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSByte;

public class TSByte2Json extends JsonSerializer<TSByte> {
	@Override
	public void serialize(TSByte tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeBinary(new byte[]{((TSByte)tsvalue).tsvalue});
	}
}
