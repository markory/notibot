package de.markory.notibot.request;

import de.markory.notibot.api.RequestParam;
import de.markory.notibot.api.TelegramMethode;
import de.markory.notibot.response.SendMessageResponse;

public class SendMessageRequest extends TelegramMethode<SendMessageRequest.MessageParam,SendMessageResponse> {
	
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
		super(MessageParam.class,"sendMessage", new SendMessageResponse());
	}
	
}
