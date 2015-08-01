package de.markory.notibot.api;

public abstract class TelegramBotApiResponse {
	
	private String rawResponse = null;
	
	private String responseCode = null;

	protected <T extends TelegramBotApiResponse> TelegramBotApiResponse(Class<T> responseMethode) {
		
	}
	
	void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}
	
	public String getRawResponse() {
		return this.rawResponse;
	}
}
