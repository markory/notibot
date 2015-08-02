package de.markory.notibot.request.builder;

import de.markory.notibot.request.raw.SendMessageRequest;
import de.markory.notibot.request.raw.SendMessageRequest.MessageParam;
import de.markory.notibot.request.types.SendMessage;

public class SendMessageRequestBuilder extends RequestBuilder<SendMessage,SendMessageRequest> {
	
	@Override
	public SendMessageRequest build(final SendMessage message) {
		
		final SendMessageRequest request = new SendMessageRequest();
		
		request.setParameter(MessageParam.chat_id, message.getChatId());
		request.setParameter(MessageParam.text, message.getText());
		
		request.setParameter(MessageParam.disable_web_page_preview,
				Boolean.toString(message.isDisableWebPagePreview()));
		
		if ( message.getReplyToMessageId() != null) {
			request.setParameter(MessageParam.reply_to_message_id,
					Integer.toString(message.getReplyToMessageId()));
		}
		
		if ( message.getReplyMarkupy() != null ) {
			request.setParameter(MessageParam.reply_markup,
					message.getReplyMarkupy().toString());
		}
		
		return request;
	}
}
