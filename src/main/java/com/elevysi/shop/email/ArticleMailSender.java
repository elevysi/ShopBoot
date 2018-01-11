package com.elevysi.shop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;

public class ArticleMailSender {
	
	@Autowired
	private MailSender mailSender;
	
	public void notifyNewArticle(){
		
	}

}
