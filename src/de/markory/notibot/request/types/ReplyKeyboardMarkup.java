package de.markory.notibot.request.types;

import javax.json.Json;
import javax.json.JsonObject;
import de.markory.notibot.util.JsonHelper;

public class ReplyKeyboardMarkup implements ReplyMarkup {
	
	private String[][] keyboard;
	
	private boolean resizeKeyboard = true;
	
	private boolean oneTimeKeyboard = true;
	
	private boolean selective = false;

	public String[][] getKeyboard() { return keyboard; }
	
	public boolean isResizeKeyboard() { return resizeKeyboard; }
	
	public boolean isOneTimeKeyboard() { return oneTimeKeyboard; }
	
	public boolean isSelective() { return selective; }

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
	
	public ReplyKeyboardMarkup setSelective(boolean selective) {
		this.selective = selective;
		return this;
	}
	
	
	@Override
	public String toString() {
		
		JsonObject model = Json.createObjectBuilder()
				.add("keyboard",JsonHelper.buildJsonArray(this.keyboard))
				.add("resize_keyboard", resizeKeyboard)
				.add("one_time_keyboard",oneTimeKeyboard)
				.add("selective",selective)
				.build();
		
		return model.toString();
	}

}
