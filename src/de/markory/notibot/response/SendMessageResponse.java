package de.markory.notibot.response;

import javax.json.JsonObject;
import de.markory.notibot.api.TelegramBotApiResponse;
import de.markory.notibot.response.types.Message;


public class SendMessageResponse extends TelegramBotApiResponse<JsonObject> {
	
	private Message message;
	
	public SendMessageResponse() {
		super(SendMessageResponse.class, JsonObject.class);
	}
	
	public Message getMessage() { return message; }

	@Override
	protected SendMessageResponse processResponse(JsonObject json) {

		message = new Message(json);
		
		return this;
	}

	@Override
	public String toString() {
		return "SendMessageResponse [status=" + status + ", errorCode=" + errorCode
				+ ", errorDescription=" + errorDescription + ", message=" + message + "]";
	}
}