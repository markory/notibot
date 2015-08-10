package de.markory.tgbotapi.response.types;

import java.util.Date;

import javax.json.JsonObject;

import de.markory.tgbotapi.util.DateConverter;

public class Message implements Type {

	public Message(JsonObject json) {
		parseJson(json);
	}

	private int messageId;

	private User from;

	private Date date;

	private Chat chat;

	private Message replyToMessage;

	private String text;

	public int getMessageId() { return messageId; }

	public User getFrom() { return from; }

	public Date getDate() { return date; }

	public Chat getChat() { return chat; }

	public Message getReplyToMessage() { return replyToMessage; }

	public String getText() { return text; }

	public Message setMessageId(int id) {
		this.messageId = id;
		return this;
	}

	Message setFrom(User from) {
		this.from = from;
		return this;
	}

	Message setDate(Date date) {
		this.date = date;
		return this;
	}

	Message setChat(Chat chat) {
		this.chat = chat;
		return this;
	}

	Message setText(String text) {
		this.text = text;
		return this;
	}

	@Override
	public void parseJson(JsonObject json) {

		messageId = json.getInt("message_id");

		from = new User(json.getJsonObject("from"));
		date = DateConverter.convertUnixTimeStamp(json.getInt("date"));

		//only title exist in group_chat
		JsonObject chatJsonObject =  json.getJsonObject("chat");
		if ( chatJsonObject.containsKey("title") ) {
			chat = new GroupeChat(chatJsonObject);
		}
		else {
			chat = new User(chatJsonObject);
		}

		JsonObject replyToMessageJsonObject = json.getJsonObject("reply_to_message");
		if( replyToMessageJsonObject !=  null) {
			replyToMessage = new Message(replyToMessageJsonObject);
		}

		text = json.getString("text","");
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", from=" + from + ", date=" + date + ", chat=" + chat
				+ ", replyToMessage=" + replyToMessage + ", text=" + text + "]";
	}
}