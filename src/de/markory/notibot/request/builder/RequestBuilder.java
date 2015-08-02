package de.markory.notibot.request.builder;

public abstract class RequestBuilder<E,T> {
	
	public abstract T build(E request);
}
