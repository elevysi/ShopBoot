package com.elevysi.shop.config.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.elevysi.shop.jms.consumer.JMSMessageConsumer;
import com.elevysi.shop.jms.sender.JMSMessageSender;

@Configuration
public class JMSActiveMQSenderConfig {
	
	private String brokerUrl = "tcp://localhost:61616";
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		
		return activeMQConnectionFactory;
	}
	
	@Bean
	public CachingConnectionFactory cachingConnectionFactory(){
		return new CachingConnectionFactory(activeMQConnectionFactory());
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		return new JmsTemplate(cachingConnectionFactory());
	}
	
	@Bean
	public JMSMessageSender jMSMessageSender(){
		return new JMSMessageSender();
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMQConnectionFactory());
		factory.setConcurrency("3-10");
		
		return factory;
	}
	
	@Bean
	public JMSMessageConsumer consumer(){
		return new JMSMessageConsumer();
	}

}
