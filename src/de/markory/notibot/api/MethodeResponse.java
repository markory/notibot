package de.markory.notibot.api;

public abstract class MethodeResponse {
	
	private String rawResponse = null;

	protected <T extends MethodeResponse> MethodeResponse(Class<T> responseMethode) {
		
	}
	
	void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}
	
	public String getRawResponse() {
		return this.rawResponse;
	}
}
