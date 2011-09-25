package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSBoolean;

public class TSBoolean2Json extends JsonSerializer<TSBoolean> {
	@Override
	public void serialize(TSBoolean tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeBoolean(((TSBoolean)tsvalue).tsvalue);
	}
}
