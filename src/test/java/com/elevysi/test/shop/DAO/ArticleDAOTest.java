package com.elevysi.test.shop.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.elevysi.shop.ShopApplication;
import com.elevysi.shop.config.AppConfig;
import com.elevysi.shop.dao.ArticleDAO;
import com.elevysi.shop.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={AppConfig.class})
@SpringBootTest(classes={ShopApplication.class, AppConfig.class})
@Transactional
public class ArticleDAOTest {
	
	private Article article;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Before
	public void init(){
		this.article = new Article();
		this.article.setName("Test Article");
		this.article.setDescription("Test description");
		this.article.setPrice(new Double(1000));
	}
	
	@Test
	public void checksave(){
		Article savedArticle = articleDAO.save(article);
		assertEquals(savedArticle.getName(), "Test Article");
		assertEquals(savedArticle.getDescription(), "Test description");
		assertEquals(savedArticle.getPrice(), new Double(1000));
	}
}
