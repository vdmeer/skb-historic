package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSLong;

public class TSLong2Json extends JsonSerializer<TSLong> {
	@Override
	public void serialize(TSLong tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeNumber(((TSLong)tsvalue).tsvalue);
	}
}
