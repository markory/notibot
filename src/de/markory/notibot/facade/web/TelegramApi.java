package de.markory.notibot.facade.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


import de.markory.notibot.facade.config.PropertyLoader;

public class TelegramApi {

	private static boolean prop_use_proxy = false;
	private static String prop_proxy_host = "";
	private static int prop_proxy_port = 80;
	
	private static String prop_bot_token = "";
	private static String prop_chatIds = "";
	
	private final static String protocol = "https";
	private final static String domain_api = "api.telegram.org";
	
	private final List<String> chatIds = new ArrayList<String>();
	
	static {
		PropertyLoader.load(TelegramApi.class);
	}

	final String type = "application/x-www-form-urlencoded";
	
	private enum Method{
		
		sendMessage("/sendMessage");
		
		private final String tlName;
		
		Method(String tlName) {
			this.tlName = tlName;
		}
		
		public String get() { return "/"+prop_bot_token+tlName; }
	}
	
	public TelegramApi() {
		initChatIds();
	}
	
	private void initChatIds() {
		
		StringTokenizer st = new StringTokenizer(prop_chatIds,"|");
		
	     while (st.hasMoreTokens()) {
	        chatIds.add(st.nextToken());
	     }
	}

	
	public String sendBroadcastMessage(String msg) throws IOException {
		
		final URL url = new URL(protocol,domain_api, Method.sendMessage.get());
		
		String response = "";
		
		for ( String chatId: getChatIds() ) {
			
			String msgChatId = "chat_id="+chatId+"&text=";
			response += sendMessage(url, msgChatId, msg);
		}
		
		return response;
	}
	
	
	private String sendMessage(URL url,String metaData, String message) throws IOException {
		
		final String encodedData = URLEncoder.encode( message, "UTF-8");
		
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		
		String response = "";
		
		try {
			
			HttpURLConnection con;
			if ( prop_use_proxy ) {
				con = (HttpURLConnection) url.openConnection(getProxy());
			}
			else {
				con = (HttpURLConnection) url.openConnection();
			}
			
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty( "Content-Type", type );
			
			con.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()) );
			
			writer = new OutputStreamWriter( con.getOutputStream() );
			writer.write( metaData+encodedData );
			writer.flush();
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()) );
			
			for ( String line; (line = reader.readLine()) != null; )
			{
			  response += line;
			}
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
		finally{
			if (writer != null) { writer.close(); }
			if ( reader != null) { reader.close(); }
		}
		
		return response;
	}

	
	private Proxy getProxy() {
		
		return new Proxy(java.net.Proxy.Type.HTTP,
				new InetSocketAddress(prop_proxy_host, prop_proxy_port));
	}
	
	public String getBotToken() { return prop_bot_token; }
	
	public List<String> getChatIds() {
		return Collections.unmodifiableList(chatIds);
	}
	
}
