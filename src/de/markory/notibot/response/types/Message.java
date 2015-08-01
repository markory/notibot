package de.markory.notibot.response.types;

import java.util.Date;

public class Message {
	
	private int messageId;
	
	private User from;
	
	private Date date;
	
	private User userChat;
	
	private GroupeChat groupChat;
	
	private Message replyToMessage;
	
	private String text;

	public Message() {
	}

}
