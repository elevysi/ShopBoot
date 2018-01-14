package com.elevysi.shop.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.elevysi.shop.dao.ArticleDAO;
import com.elevysi.shop.entity.Article;
import com.elevysi.shop.service.ArticleService;


public class ArticleServiceTest {
	
	private ArticleDAO articleDAOMock = mock(ArticleDAO.class);
	private ArticleService articleService = new ArticleService(articleDAOMock);
	private Article article;
	
	@Before
	public void init(){
		this.article = new Article();
		this.article.setName("Test Article");
		this.article.setDescription("Test description");
		this.article.setPrice(new Double(1000));
	}
	
	@Test
	public void testAddArticle(){
		Article daoSavedArticle = new Article("Test Article", "Test description", new Double(1000));
		when(articleDAOMock.save(this.article)).thenReturn(daoSavedArticle);
		Article savedArticle = articleService.addArticle(article);
		
		assertEquals(savedArticle.getName(), daoSavedArticle.getName());
		assertEquals(savedArticle.getDescription(), daoSavedArticle.getDescription());
		assertEquals(savedArticle.getPrice(), daoSavedArticle.getPrice());
		
	}

}
