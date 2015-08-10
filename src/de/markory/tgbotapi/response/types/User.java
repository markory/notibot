package de.markory.tgbotapi.response.types;

import javax.json.JsonObject;

public class User extends Chat implements Type{

	public User(JsonObject json) {
		super(Chat.Type.user_chat);
		parseJson(json);
	}

	private int id;

	private String firstName;

	private String lastName;

	private String userName;

	@Override
	public int getId() { return id; }

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public String getUserName() { return userName; }

	User setId(int id) {
		this.id = id;
		return this;
	}

	User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	@Override
	public void parseJson(JsonObject json) {

		id = json.getInt("id");
		firstName = json.getString("first_name","");
		lastName = json.getString("last_name", "");
		userName = json.getString("username","");
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ "]";
	}
}
