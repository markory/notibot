package de.markory.tgbotapi.request.raw;

import de.markory.tgbotapi.api.RequestParam;
import de.markory.tgbotapi.api.TelegramMethode;
import de.markory.tgbotapi.response.GetUpdatesResponse;

public class GetUpdatesRequest extends TelegramMethode<GetUpdatesRequest.MessageParam,GetUpdatesResponse> {

	private final static String name = "getUpdates";
	
	public enum MessageParam implements RequestParam{
		
		offset("offset"),
		limit("limit"),
		timeout("timeout");
		
		private final String parameterName;
		
		MessageParam(String parameterName) {
			this.parameterName = parameterName;
		}
		
		@Override
		public String getParameterName() { return parameterName; }
	}

	public GetUpdatesRequest() { 
		super(MessageParam.class, GetUpdatesRequest.name, new GetUpdatesResponse());
	}
}