package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSShort;

public class TSShort2Json extends JsonSerializer<TSShort> {
	@Override
	public void serialize(TSShort tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeNumber(((TSShort)tsvalue).tsvalue);
	}
}
