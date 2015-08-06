package de.markory.tgbotapi.request.types;

public class SendMessage {
	
	private String chatId;
	
	private String text;
	
	private boolean disableWebPagePreview = false;
	
	private Integer replyToMessageId;
	
	private ReplyMarkup replyMarkup;

	public String getChatId() {	return chatId;	}
	
	public String getText() { return text; 	}

	public boolean isDisableWebPagePreview() { return disableWebPagePreview; }
	
	public Integer getReplyToMessageId() { return replyToMessageId; }
	
	public ReplyMarkup getReplyMarkupy(){ return replyMarkup; }
	
	public SendMessage setChatId(String id) {
		this.chatId = id;
		return this;
	}

	public SendMessage setText(String text) {
		this.text = text;
		return this;
	}

	public SendMessage disableWebPagePreview(boolean disable) {
		this.disableWebPagePreview = disable;
		return this;
	}

	public SendMessage setReplyToMessageId(int replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
		return this;
	}

	public SendMessage setReplyMarkup(ReplyMarkup markup) {
		this.replyMarkup = markup;
		return this;
	}

	@Override
	public String toString() {
		return "SendMessage [chatId=" + chatId + ", text=" + text + ", disableWebPagePreview=" + disableWebPagePreview
				+ ", replyToMessageId=" + replyToMessageId + ", replyMarkup=" + replyMarkup + "]";
	}
	
	
}
