package com.elevysi.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elevysi.shop.entity.Article;
import com.elevysi.shop.exception.ArticleNotFoundException;
import com.elevysi.shop.pojo.Error;
import com.elevysi.shop.service.ArticleService;

@Controller
@RequestMapping("/api/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public ResponseEntity<Article> articleById(@PathVariable("id")Long id){
//		Article article = new Article();
//		article.setDescription("This is the article for sale");
//		article.setName("Shop Site");
//		article.setPrice(new Double(2000));
//		HttpStatus status = HttpStatus.OK;
//		
//		return new ResponseEntity<Article>(article, status);
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Article articleById(@PathVariable("id")Long id){
		Article article = articleService.articleById(id);
		if(article == null) throw new ArticleNotFoundException(id);
		return article;
	}
	
	public ResponseEntity<Article> addArticle(@RequestBody Article article){
		Article savedArticle = articleService.addArticle(article);
		HttpStatus status;
		if(article != null)
			status = HttpStatus.CREATED;
		else	status = HttpStatus.NOT_FOUND;
		
		return new ResponseEntity<Article>(savedArticle, status);
	}
	
	@ExceptionHandler(ArticleNotFoundException.class)
	public ResponseEntity<com.elevysi.shop.pojo.Error> articleNotFound(ArticleNotFoundException articleNotFoundException){
		long articleId = articleNotFoundException.getArticleId();
		com.elevysi.shop.pojo.Error error = new Error(4,  "Article "+articleId+" was not found.");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
}
