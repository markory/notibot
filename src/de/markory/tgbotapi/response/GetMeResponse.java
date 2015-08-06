package de.markory.tgbotapi.response;

import javax.json.JsonObject;

import de.markory.tgbotapi.api.TelegramBotApiResponse;
import de.markory.tgbotapi.response.types.User;

public class GetMeResponse extends TelegramBotApiResponse<JsonObject> {
	
	private User user;
	
	public User getUser() { return user; }	

	public GetMeResponse() {
		super(GetMeResponse.class,JsonObject.class);
	}

	@Override
	protected GetMeResponse processResponse(JsonObject json) {
		
		user = new User(json);
		
		return this;
	}

	@Override
	public String toString() {
		return "GetMeResponse [user=" + user + "]";
	}
}