package de.markory.notibot.request.types;

public class ForceReply implements ReplyMarkup {
	
	private boolean forceReply;
	
	public boolean isForceReply() { return forceReply; }
	
	public ForceReply setForceReply(boolean forceReply) {
		this.forceReply = forceReply;
		return this;
	}

	@Override
	public String toString() {
		return null;
	}
}
