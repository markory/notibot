package de.markory.notibot.request.types;

public class GetUpdates {

	private Integer offset;
	
	private Integer limit = 100;
	
	private Integer timeout = 60;
	
	public Integer getOffset() { return offset;	}

	public Integer getTimeout() { return timeout; }
	
	public Integer getLimit() {	return limit; }
	
	
	public GetUpdates setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

	
	public GetUpdates setLimit(Integer limit) {
		
		if ( limit > 100 ) {
			throw new IllegalArgumentException("setLimit(Integer) - limit of 100 not accepted.");
		}
		
		this.limit = limit;
		return this;
	}

	
	public GetUpdates setTimeout(Integer timeout) {
		this.timeout = timeout;
		return this;
	}
}