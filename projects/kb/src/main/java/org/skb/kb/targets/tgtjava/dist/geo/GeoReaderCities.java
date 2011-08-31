package org.skb.kb.targets.tgtjava.dist.geo;

import org.skb.kb.SKBDataManager;
import org.skb.kb.SKBReader;
import org.skb.util.pattern.Request;
import org.skb.util.types.atomic.java.TSString;

public class GeoReaderCities extends SKBReader {

	@Override
	protected void prepare_loop(Request request, TSString table, TSString table_collections) {
		SKBDataManager myDM=SKBDataManager.getInstance();
		this.entries=myDM.queryDataObject(myDM.prepareQuery("skb:geo:cities",null,null,"key",null,null,true,true));
	}

	@Override
	protected void execute_loop(Request request) {
	}
}
