package de.markory.notibot.api.bot.request;

import de.markory.notibot.api.bot.request.supers.BaseParameter;
import de.markory.notibot.api.bot.request.supers.Methode;

public class SendMessage extends Methode<SendMessage.Parameter> {
	
	public static final String endpoint= "sendMessage";
	
	public enum Parameter implements BaseParameter{
		
		chat_id("chat_id"),
		text("text"),
		disable_web_page_preview("disable_web_page_preview"),
		reply_to_message_id("reply_to_message_id"),
		reply_markup("reply_markup");
		
		private final String parameterName;
		
		Parameter(String parameterName) {
			this.parameterName = parameterName;
		}
		
		@Override
		public String getParameterName() { return parameterName; }
	}

	public SendMessage() { super(Parameter.class,endpoint); }
}
