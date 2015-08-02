package de.markory.notibot.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;

import de.markory.notibot.api.TelegramBotApiResponse;
import de.markory.notibot.response.types.Update;

public class GetUpdatesResponse extends TelegramBotApiResponse<JsonArray> {
	
	public GetUpdatesResponse() {
		super(GetUpdatesResponse.class,JsonArray.class);
	}

	private Integer highesUpdateId;
	
	private List<Update> updates = new ArrayList<>();

	public List<Update> getUpdates() {	return Collections.unmodifiableList(updates); }

	@Override
	protected GetUpdatesResponse processResponse(JsonArray resultJsonArray) {
		
		for(JsonObject updateObj: resultJsonArray.getValuesAs(JsonObject.class)) {
			
			Update update = new Update(updateObj);
			updates.add(update);
			
			if ( highesUpdateId == null ) { highesUpdateId = update.getUpdateId(); }
			
			if ( update.getUpdateId() > highesUpdateId  ) { highesUpdateId = update.getUpdateId(); }
		}
		
		return this;
	}

	@Override
	public String toString() {
		return "GetUpdatesResponse [status=" + status + ", errorCode=" + errorCode
				+ ", errorDescription=" + errorDescription + ", highesUpdateId="+highesUpdateId+", updates=" + updates + "]";
	}
}