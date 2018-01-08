package com.elevysi.shop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elevysi.shop.dao.ArticleDAO;
import com.elevysi.shop.entity.Article;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	public Article articleById(Long id){
		return articleDAO.articleById(id);
	}
	
	public Article addArticle(Article article){
		return articleDAO.save(article);
	}

}
