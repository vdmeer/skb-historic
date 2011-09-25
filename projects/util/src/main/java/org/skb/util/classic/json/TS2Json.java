package org.skb.util.classic.json;

import java.io.StringWriter;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.skb.util.composite.java.TSBoolean;
import org.skb.util.composite.java.TSByte;
import org.skb.util.composite.java.TSDouble;
import org.skb.util.composite.java.TSFloat;
import org.skb.util.composite.java.TSInteger;
import org.skb.util.composite.java.TSLong;
import org.skb.util.composite.java.TSObject;
import org.skb.util.composite.java.TSShort;
import org.skb.util.composite.java.TSString;
import org.skb.util.composite.util.TSLinkedHashTree;

public class TS2Json {

	public static ObjectMapper getMapper(){
	    SimpleModule module = new SimpleModule("SKBSerialiseJson", new Version(0, 1, 0, "alpha"));
	    module.addSerializer(TSBoolean.class, new TSBoolean2Json());
	    module.addSerializer(TSByte.class, new TSByte2Json());
	    module.addSerializer(TSDouble.class, new TSDouble2Json());
	    module.addSerializer(TSFloat.class, new TSFloat2Json());
	    module.addSerializer(TSInteger.class, new TSInteger2Json());
	    module.addSerializer(TSLong.class, new TSLong2Json());
	    module.addSerializer(TSObject.class, new TSObject2Json());
	    module.addSerializer(TSShort.class, new TSShort2Json());
	    module.addSerializer(TSString.class, new TSString2Json());

	    module.addSerializer(TSLinkedHashTree.class, new TSLinkedHashTree2Json());

		ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(module);

	    mapper.canSerialize(TSBoolean.class);
	    mapper.canSerialize(TSByte.class);
	    mapper.canSerialize(TSDouble.class);
	    mapper.canSerialize(TSFloat.class);
	    mapper.canSerialize(TSInteger.class);
	    mapper.canSerialize(TSLong.class);
	    mapper.canSerialize(TSObject.class);
	    mapper.canSerialize(TSShort.class);
	    mapper.canSerialize(TSString.class);

	    mapper.canSerialize(TSLinkedHashTree.class);

	    return mapper;
	}

	public static JsonGenerator getJsonGeneratorSW(StringWriter sw){
		MappingJsonFactory jsonFactory = new MappingJsonFactory();
		try{
			JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(sw);
			jsonGenerator.useDefaultPrettyPrinter();
			return jsonGenerator;
		} catch(Exception e){
			System.err.println(e);
		}
		return null;
	}
}
