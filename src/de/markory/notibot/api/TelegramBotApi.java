package de.markory.notibot.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

import de.markory.notibot.util.PropertyLoader;

/**
 * 
 * @author Philipp Mueller-Leven
 */
public class TelegramBotApi {

	private static boolean prop_use_proxy = false;
	private static String prop_proxy_host = "";
	private static int prop_proxy_port = 80;
	
	private static String prop_bot_token = "";
	
	private final static String protocol = "https";
	private final static String domain_api = "api.telegram.org";
	
	private static TelegramBotApi instance = null;
	
	static {
		PropertyLoader.load(TelegramBotApi.class);
	}

	final String type = "application/x-www-form-urlencoded";
	
	private TelegramBotApi() {	}
	
	public static synchronized TelegramBotApi getInstance() {
		
		if ( instance == null ) return (instance = new TelegramBotApi());
		
		return instance;
	}
	
	InputStream sendRequest( TelegramMethode<?,?> methode) throws IOException {
		
		final URL url = new URL(protocol,domain_api, "/"+prop_bot_token+methode.getEndpoint());
		
		OutputStreamWriter writer = null;
		
		String parameters = methode.getParameters();
		
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
			
			con.setRequestProperty( "Content-Length", String.valueOf(parameters.length()) );
			
			writer = new OutputStreamWriter( con.getOutputStream() );
			writer.write( parameters );
			writer.flush();
			
			try {
				return con.getInputStream();
			} catch ( IOException e ) {
				return con.getErrorStream();
			}
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
		finally{
			if ( writer != null ) { writer.close(); }
		}
			
		return null;
	}
	
	
	private Proxy getProxy() {
		
		return new Proxy(java.net.Proxy.Type.HTTP,
				new InetSocketAddress(prop_proxy_host, prop_proxy_port));
	}
	
	
	public String getBotToken() { return prop_bot_token; }
	
}
