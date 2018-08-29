package com.elevysi.shop.jms.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;


public class JMSMessageConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JMSMessageConsumer.class);
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch(){
		return latch;
	}
	
	@JmsListener(destination="helloworld.q")
	public void receive(String message){
		LOGGER.info("receive message='{}'", message);
		latch.countDown();
	}
}