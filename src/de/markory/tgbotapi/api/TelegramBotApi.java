package de.markory.tgbotapi.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

import de.markory.tgbotapi.util.PropertyLoader;

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

	private final static String type = "application/x-www-form-urlencoded";

	private static TelegramBotApi instance = null;

	private TelegramBotApi() {	}

	/** Init settings for telegram bot api.
	 * <br>
	 * <br>
	 * The following settings must be made:
	 * <ul>
	 *		<li>prop_bot_token = [token from telegram api bot.]</li>
	 * </ul>
	 * <br>
	 *
	 **/
	public static void init(String propertiesFileName) {
		PropertyLoader.load(TelegramBotApi.class, propertiesFileName);
		getInstance();
	}

	static TelegramBotApi getInstance() {

		if ( prop_bot_token.isEmpty() ) {
			throw new RuntimeException("Not inital Token for Telegram Bot Api has been set. Call"
					+ " for TelegramBotApi.init(String) initalization!\n"
					+ " For further Information got to: \n"
					+ " https://core.telegram.org/bots/api");
		}

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
