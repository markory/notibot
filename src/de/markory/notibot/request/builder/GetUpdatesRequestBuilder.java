package de.markory.notibot.request.builder;

import de.markory.notibot.request.raw.GetUpdatesRequest;
import de.markory.notibot.request.types.GetUpdates;

public class GetUpdatesRequestBuilder extends RequestBuilder<GetUpdates,GetUpdatesRequest>  {
	
	@Override
	public GetUpdatesRequest build(GetUpdates updates) {
		
		final GetUpdatesRequest request = new GetUpdatesRequest();

		if ( updates.getOffset() != null ) {
			request.setParameter(GetUpdatesRequest.MessageParam.offset, Integer.toString(updates.getOffset()));
		}
		if ( updates.getLimit() != null ) {
			request.setParameter(GetUpdatesRequest.MessageParam.limit, Integer.toString(updates.getLimit()));
		}
		
		if ( updates.getTimeout() != null ) {
			request.setParameter(GetUpdatesRequest.MessageParam.timeout, Integer.toString(updates.getTimeout()));
		}
		
		return request;
	}
}