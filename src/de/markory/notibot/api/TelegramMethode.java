package de.markory.notibot.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.EnumMap;


public abstract class TelegramMethode<E extends Enum<E> & RequestParam, T extends TelegramBotApiResponse> {
	
	private final TelegramBotApi telegramBotApi = TelegramBotApi.getInstance();
	
	protected EnumMap<E, String> parameters;

	protected String endpoint;
	
	private T methodeResponse;
	
	protected TelegramMethode(Class<E> parameterType,String endpoint,T methodeResponse) {
		this.parameters = new EnumMap<E, String>(parameterType);
		this.endpoint = endpoint;
		this.methodeResponse = methodeResponse;
	}
	
	
	public String getEndpoint() {
		return "/"+endpoint;
	}
	
	
	/** Get parameters application/x-www-form-urlencoded */
	public String getParameters() {
			
		StringBuilder urlEncoded = new StringBuilder();
		
		for (E key:parameters.keySet()) {
			
			String parameterValue = parameters.get(key);
			
			if ( parameterValue != null ) {
				
				try {
					
					if( urlEncoded.length() != 0 ) {
						urlEncoded.append("&");
					}
					urlEncoded.append(key.getParameterName()+"="+URLEncoder.encode(parameterValue, "UTF-8"));
					
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException("getParameters() -"
							+ "can't encode value: '"+parameterValue+"' of parameter: '"+key.getParameterName()+"'.");
				}
			}
		}
		
		return urlEncoded.toString();
	}
	
	
	public void setParameter(E key, String value) {
		parameters.put(key, value);
	}
	

	public T sendRequest() throws IOException {
		InputStream response = telegramBotApi.sendRequest(this);
		methodeResponse.parseToJsonObject(response);
		return methodeResponse;
	}
	
	public T getResponse() {
		return methodeResponse;
	}
}