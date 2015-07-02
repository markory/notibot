package de.markory.notibot.response;

import de.markory.notibot.api.MethodeResponse;

public class SendMessageResponse extends MethodeResponse {

	public SendMessageResponse() {
		super(SendMessageResponse.class);
	}
	
	public String specificSendMessageMethode() {
		return super.getRawResponse();
	}

}
