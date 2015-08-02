package de.markory.notibot.response.types;

import javax.json.JsonObject;

public class Update implements Type {
	
	public Update(JsonObject jsonObject) {
		parseJson(jsonObject);
	}
	
	private int updateId;
	
	private Message message;

	public int getUpdateId() {	return updateId; }

	public Message getMessage() { return message; }
	
	public Update setUpdateId(int updateId) {
		this.updateId = updateId;
		return this;
	}

	public Update setMessage(Message message) {
		this.message = message;
		return this;
	}

	@Override
	public void parseJson(JsonObject json) {
		
		updateId = json.getInt("update_id");
		
		message = new Message(json.getJsonObject("message"));
	}

	@Override
	public String toString() {
		return "Update [updateId=" + updateId + ", message=" + message + "]";
	}
}