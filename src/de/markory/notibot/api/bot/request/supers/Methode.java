package de.markory.notibot.api.bot.request.supers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.EnumMap;


public abstract class Methode<E extends Enum<E> & BaseParameter> {
	
	String endpoint;

	EnumMap<E, String> parameters;

	public Methode(Class<E> parameterType,String endpoint) {
		this.endpoint = endpoint;
		parameters = new EnumMap<E, String>(parameterType);
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
	
}
