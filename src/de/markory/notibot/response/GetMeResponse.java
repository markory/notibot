package de.markory.notibot.response;

import javax.json.JsonObject;

import de.markory.notibot.api.TelegramBotApiResponse;
import de.markory.notibot.response.types.User;

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