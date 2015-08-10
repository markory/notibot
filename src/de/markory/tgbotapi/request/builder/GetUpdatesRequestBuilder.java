package de.markory.tgbotapi.request.builder;

import de.markory.tgbotapi.request.raw.GetUpdatesRequest;
import de.markory.tgbotapi.request.types.GetUpdates;

public class GetUpdatesRequestBuilder extends RequestBuilder<GetUpdates,GetUpdatesRequest>  {

	public GetUpdates updates = new GetUpdates();

	@Override
	public GetUpdatesRequest build() {

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

	@Override
	public GetUpdatesRequestBuilder setEntity(GetUpdates entity) {
		this.updates = entity;
		return this;
	}
}