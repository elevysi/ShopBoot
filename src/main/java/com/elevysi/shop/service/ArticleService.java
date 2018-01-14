package com.elevysi.shop.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.elevysi.shop.dao.ArticleDAO;
import com.elevysi.shop.entity.Article;
import com.elevysi.shop.entity.dto.ArticleAddDTO;

@Service
public class ArticleService {
	
	
	private ArticleDAO articleDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	public ArticleService(ArticleDAO articleDAO){
		this.articleDAO = articleDAO;
	}
	
	public Article articleById(Long id){
		return articleDAO.articleById(id);
	}
	
	
	public Article addArticle(Article article){
		//After an article is saved, send a Mail to people and add the message to the queue
		Article savedArticle =  articleDAO.save(article);
		
		//Disseminate article creation JSM
//		JmsTemplate jmsTemplate = new jmsTemplate();
		
		return savedArticle;
	}
	
	public Article saveRestArticleDTO(ArticleAddDTO articleAddDTO){
		Article article = modelMapper.map(articleAddDTO, Article.class);
		
		return this.addArticle(article);
	}

}