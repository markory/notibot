package de.markory.tgbotapi.response.types;

import javax.json.JsonObject;

public interface Type {

	public void parseJson(JsonObject json);
}