package de.markory.notibot.response.types;

public class User {
	
	private String id;

	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	public String getId() { return id; }

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }
	
	public String getUserName() { return userName; }
	
	public User setId(String id) {
		this.id = id;
		return this;
	}
	
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
}
