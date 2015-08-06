package de.markory.tgbotapi.request.raw;

import de.markory.tgbotapi.api.RequestParam;
import de.markory.tgbotapi.api.TelegramMethode;
import de.markory.tgbotapi.response.GetMeResponse;

public class GetMeRequest extends TelegramMethode<GetMeRequest.MessageParam, GetMeResponse> {
	
	private final static String name = "getMe";
	
	public enum MessageParam implements RequestParam{
		
		nothing("");
		
		private final String parameterName;
		
		MessageParam(String parameterName) {
			this.parameterName = parameterName;
		}
		
		@Override
		public String getParameterName() { return parameterName; }
	}

	public GetMeRequest() {
		super(MessageParam.class, GetMeRequest.name, new GetMeResponse());
	}
}