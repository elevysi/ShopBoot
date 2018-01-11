package com.elevysi.shop.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.elevysi.shop.jms.pojo.ShopMessage;

@Component
public class ArticleCreatedReceiver {
	
	@JmsListener(destination="mailbox", containerFactory="defJmsFactory")
	public void receiveArticleCreatedMessage(ShopMessage shopMessage){
		System.out.println("Recieved "+shopMessage);
	}

}
