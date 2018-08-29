package com.elevysi.shop.jms.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JMSMessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(JMSMessageSender.class);
	
	public void send(String destination, String message){
		LOGGER.info("sending message='{}' to destination='{}'", message);
		jmsTemplate.convertAndSend(destination, message);
	}

}
