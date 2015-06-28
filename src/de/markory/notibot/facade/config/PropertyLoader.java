package de.markory.notibot.facade.config;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.Set;

public class PropertyLoader {
	
	
	private static final String suffix = ".properties";
	
	
	/**
	 * 
	 */
	public static void load(Class<?> targetClass) {
		
		String propFile = targetClass.getSimpleName()+suffix;
		
		InputStream propFileInputStream = targetClass.getClassLoader().getResourceAsStream(propFile);
		
		Properties properties = new Properties();
		
		try {
			properties.load(propFileInputStream);
			
			initProps(properties, targetClass);
			
		} catch (IOException e) {
			System.err.println("de.markory.notibot.facade.config.PropertyLoader.load(Class) - "
					+ "Error loading file: "+propFile+". Exception: "+e.getStackTrace());
		}
		
	}
	
	
	/**
	 * 
	 */
	private static void initProps(Properties properties, Class<?> targetClass) {
		
		Set<Object> propertiesSet = properties.keySet();
		
		for (Object propObj: propertiesSet) {

			setField(targetClass, (String)propObj, properties.getProperty((String)propObj));
		}
		
	}
	
	
	/**
	 * 
	 */
	private static void setField(Class<?> targetClass, String name, String value) {
		
		boolean changedAccessible = false;
		
		Field targetField = null;
		Field modifiersField = null;
		
		try {
			targetField = targetClass.getDeclaredField(name);
			
			if ( !targetField.isAccessible() ) {
				targetField.setAccessible(true);
				changedAccessible = true;
			}
			
			//make final field accessible
			/*
			modifiersField = Field.class.getDeclaredField( "modifiers" );
			modifiersField.setAccessible( true );
			modifiersField.set(targetField, targetField.getModifiers() & ~Modifier.FINAL );
			*/
			
			//change value of final field
			targetField.set(targetField.getType(), value);
			
		} catch (NoSuchFieldException | SecurityException e) {
			throw new RuntimeException("de.markory.notibot.facade.config.PropertyLoader.setField(Class<?>, String, Class<?>) -"
					+ "Can't set Field: "+name+".", e);
		}
		catch(IllegalArgumentException | IllegalAccessException e){
			throw new RuntimeException("de.markory.notibot.facade.config.PropertyLoader.setField(Class<?>, String, Class<?>) -"
					+ "Can't set Field: "+name+".", e);
		}
		finally{
			
			if(changedAccessible && targetField != null) {
				targetField.setAccessible(false);
			}
			
			if(modifiersField != null ) {
				modifiersField.setAccessible( false );
			}
		}
	}
}
