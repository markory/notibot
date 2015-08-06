package de.markory.tgbotapi.request.raw;

import de.markory.tgbotapi.api.RequestParam;
import de.markory.tgbotapi.api.TelegramMethode;
import de.markory.tgbotapi.response.SendMessageResponse;

public class SendMessageRequest extends TelegramMethode<SendMessageRequest.MessageParam,SendMessageResponse> {
	
	private final static String name = "sendMessage";
	
	public enum MessageParam implements RequestParam{
		
		chat_id("chat_id"),
		text("text"),
		disable_web_page_preview("disable_web_page_preview"),
		reply_to_message_id("reply_to_message_id"),
		reply_markup("reply_markup");
		
		private final String parameterName;
		
		MessageParam(String parameterName) {
			this.parameterName = parameterName;
		}
		
		@Override
		public String getParameterName() { return parameterName; }
	}

	public SendMessageRequest() { 
		super(MessageParam.class, SendMessageRequest.name, new SendMessageResponse());
	}
}