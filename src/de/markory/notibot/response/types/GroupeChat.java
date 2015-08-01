package de.markory.notibot.response.types;

public class GroupeChat {
	
	private String id;
	
	private String title;
	
	public String getId() { return id; }

	public String getTitle() { return title; }

	public GroupeChat setTitle(String title) {
		this.title = title;
		return this;
	}

	public GroupeChat setId(String id) {
		this.id = id;
		return this;
	}
}
