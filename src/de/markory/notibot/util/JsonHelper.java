package de.markory.notibot.util;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

public class JsonHelper {
	
	private JsonHelper() { }
	
	/** Builds two dimensional JsonArray form String[][] */
	public static JsonArray buildJsonArray(String[][] twoDimensionArray)  {
		
		JsonArrayBuilder keyboardBuilder = Json.createArrayBuilder();
		
		for(String[] boardElement: twoDimensionArray ){
			
			JsonArrayBuilder key = Json.createArrayBuilder();
			
			for( String keyElement: boardElement ) {
				key.add(keyElement);
			}
			
			keyboardBuilder.add(key.build());
		}
		
		return keyboardBuilder.build();
	}
}
