package de.markory.tgbotapi.util;

import java.util.Date;

public class DateConverter {
	
	private DateConverter() {}
	
	public static Date convertUnixTimeStamp(int timestamp) {
		return new Date(timestamp*1000L);
	}
}