package de.markory.notibot.facade.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.markory.notibot.facade.config.PropertyLoader;

public class TelegramApi {

	static {
		PropertyLoader.load(TelegramApi.class);
	}

	private static String proxy = "";
	
	private static boolean use_proxy = false;
	
	private static String bot_url = "";
	private static String chatIds = "";
	
	private enum Method{
		
		sendMessage("/sendMessage");
		
		private final String tlName;
		
		Method(String tlName) {
			this.tlName = tlName;
		}
		
		public String get() { return bot_url+tlName; }
		
	}
	
	public TelegramApi() {	}
	
	public String getBotUrl() {
		return bot_url;
	}

	public String sendBroadcastMessage() {
		
		return "";
	}
	
	private String sendReqeust() {
		
		URL url;
		try {
			
			url = new URL(Method.sendMessage.get() );
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	
}
