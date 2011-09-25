package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSFloat;

public class TSFloat2Json extends JsonSerializer<TSFloat> {
	@Override
	public void serialize(TSFloat tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeNumber(((TSFloat)tsvalue).tsvalue);
	}
}
