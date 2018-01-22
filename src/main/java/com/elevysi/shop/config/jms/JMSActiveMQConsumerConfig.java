package com.elevysi.shop.config.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.elevysi.shop.jms.consumer.JMSMessageConsumer;

public class JMSActiveMQConsumerConfig {
	
//	private String brokerUrl = "tcp://localhost:61616";
	
//	@Autowired
//	ActiveMQConnectionFactory activeMQConnectionFactory;
	
//	@Bean
//	public ActiveMQConnectionFactory activeMQConnectionFactory(){
//		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//		activeMQConnectionFactory.setBrokerURL(brokerUrl);
//		
//		return activeMQConnectionFactory;
//	}
	
	
	
}
