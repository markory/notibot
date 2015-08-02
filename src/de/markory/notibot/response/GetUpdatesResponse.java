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

	private List<Update> update = new ArrayList<>();

	public List<Update> getUpdate() {	return Collections.unmodifiableList(update); }

	@Override
	protected GetUpdatesResponse parseToObject(JsonArray resultJsonArray) {
		
		for(JsonObject updateObj: resultJsonArray.getValuesAs(JsonObject.class)) {
			update.add(new Update(updateObj));
		}
		
		return this;
	}

	@Override
	public String toString() {
		return "GetUpdatesResponse [status=" + status + ", errorCode=" + errorCode
				+ ", errorDescription=" + errorDescription + ", update=" + update + "]";
	}
}