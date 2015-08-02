package de.markory.notibot.response.types;

import javax.json.JsonObject;

public class GroupeChat extends Chat implements Type {
	
	public GroupeChat(JsonObject json) {
		super(Chat.Type.group_chat);
		parseJson(json);
	}
	
	private int id;
	
	private String title;
	
	public int getId() { return id; }

	public String getTitle() { return title; }

	public GroupeChat setTitle(String title) {
		this.title = title;
		return this;
	}

	public GroupeChat setId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public void parseJson(JsonObject json) {
		id = json.getInt("id");
		title = json.getString("title","");
	}

	@Override
	public String toString() {
		return "GroupeChat [id=" + id + ", title=" + title + "]";
	}
}
