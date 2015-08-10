package de.markory.tgbotapi.request.builder;

public abstract class RequestBuilder<E,T> {

	public abstract RequestBuilder<E, T> setEntity(E entity);

	public abstract T build();
}
