package de.markory.notibot.response;

import de.markory.notibot.api.TelegramBotApiResponse;
import de.markory.notibot.response.types.Message;


public class SendMessageResponse extends TelegramBotApiResponse {
	
	private Message message;
	
	public SendMessageResponse() {
		super(SendMessageResponse.class);
	}
	
	public String specificSendMessageMethode() {
		return super.getRawResponse();
	}

}
