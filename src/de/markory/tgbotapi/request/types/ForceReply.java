package de.markory.tgbotapi.request.types;

import javax.json.Json;
import javax.json.JsonObject;

public class ForceReply implements ReplyMarkup {
	
	private boolean forceReply = true;
	
	private boolean selective = false;
	
	public boolean isForceReply() { return forceReply; }
	
	public boolean isSelective() { return selective; }
	
	
	public ForceReply setForceReply(boolean forceReply) {
		this.forceReply = forceReply;
		return this;
	}
	
	
	public ForceReply setSelective(boolean selective) {
		this.selective = selective;
		return this;
	}

	
	@Override
	public String toString() {
		JsonObject model = Json.createObjectBuilder()
				.add("force_reply", forceReply)
				.add("selective", selective)
				.build();
		
		return model.toString();
	}
}