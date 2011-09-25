package org.skb.util.classic.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.skb.util.composite.java.TSObject;

public class TSObject2Json extends JsonSerializer<TSObject> {
	@Override
	public void serialize(TSObject tsvalue, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeObject(((TSObject)tsvalue).tsvalue);
	}
}
