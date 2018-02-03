package com.elevysi.shop.test.jms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.elevysi.shop.ShopApplication;
import com.elevysi.shop.config.AppConfig;
import com.elevysi.shop.config.jms.JMSActiveMQConsumerConfig;
import com.elevysi.shop.config.jms.JMSActiveMQSenderConfig;
import com.elevysi.shop.jms.consumer.JMSMessageConsumer;
import com.elevysi.shop.jms.sender.JMSMessageSender;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes={ShopApplication.class, AppConfig.class, JMSActiveMQConsumerConfig.class, JMSActiveMQSenderConfig.class})
public class JmsTest {
	
//	@Autowired
//	private JMSMessageSender sender;
//	
//	@Autowired
//	private JMSMessageConsumer consumer;
//	
//	
//	@Test
//	public void testJMSActiveQueue(){
//		sender.send("helloworld.q", "Hello JMS World!");
//		assertThat(consumer.getLatch().getCount()).isEqualTo(0);
//	}
}
