package de.markory.tgbotapi.api;

import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;

public abstract class TelegramBotApiResponse<J extends JsonStructure> {
	
	protected final Class<J> resultType;
	
	private static final String jsonObjKey= "result";
	
	protected boolean status;
	
	protected Integer errorCode;
	protected String errorDescription;
	
	protected <T extends TelegramBotApiResponse> TelegramBotApiResponse(Class<T> responseMethode, Class<J> resultType) {
		this.resultType = resultType;
	}
	
	public boolean getStatus() { return status; }
	public Integer getErrorCode() { return errorCode; }
	public String getErrorDescription() { return errorDescription; }
	
	void setStatus(boolean status) {
		this.status = status;
	}
	
	void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	void setErrorDescription(String description) {
		this.errorDescription=description;
	}
	
	
	<T extends TelegramBotApiResponse> T parseToJsonObject(InputStream responseStream) throws IOException {
		
		JsonReader responseJsonReader = Json.createReader(responseStream);
		
		JsonObject responseJsonObject = responseJsonReader.readObject();
		
		status = responseJsonObject.getBoolean("ok");
		
		if (!status) {
			errorCode = responseJsonObject.getInt("error_code");
			errorDescription = responseJsonObject.getString("description");
		}
		else {
			
			if ( resultType == JsonArray.class ) {
				return processResponse((J) responseJsonObject.getJsonArray(jsonObjKey));
			}
			
			if ( resultType == JsonObject.class ) {
				return processResponse((J)responseJsonObject.getJsonObject(jsonObjKey));
			}
		}
		
		if ( responseStream != null ) {	responseStream.close();	}
		
		return null;
	}

	protected abstract <T extends TelegramBotApiResponse> T processResponse(J json);
	
}