package de.markory.tgbotapi.request.builder;

public abstract class RequestBuilder<E,T> {
	
	public abstract T build(E request);
}
