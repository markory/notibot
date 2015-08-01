package de.markory.notibot.request.types;

public class ReplyKeyboardMarkup implements ReplyMarkup {
	
	private String[][] keyboard;
	
	private boolean resizeKeyboard;
	
	private boolean oneTimeKeyboard;

	public String[][] getKeyboard() { return keyboard; }
	
	public boolean isResizeKeyboard() { return resizeKeyboard; }
	
	public boolean isOneTimeKeyboard() { return oneTimeKeyboard; }
	
	public ReplyKeyboardMarkup setKeyboard(String[][] keyboard) {
		this.keyboard = keyboard;
		return this;
	}
	
	public ReplyKeyboardMarkup enableResizeKeyboard(boolean enable) {
		this.resizeKeyboard = enable;
		return this;
	}
	
	public ReplyKeyboardMarkup enableOneTimeKeyboard(boolean enable) {
		this.oneTimeKeyboard = enable;
		return this;
	}

	@Override
	public String toString() {
		
		return null;
	}
}
