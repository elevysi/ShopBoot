package com.elevysi.shop.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.elevysi.shop.entity.Article;
import com.elevysi.shop.entity.dto.ArticleAddDTO;
import com.elevysi.shop.exception.ArticleNotFoundException;
import com.elevysi.shop.pojo.Error;
import com.elevysi.shop.service.ArticleService;

@Controller
@RequestMapping("/api")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	private static final Logger logger = Logger.getLogger(ArticleController.class);
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.GET)
	public @ResponseBody Article getArticle(@PathVariable("id")Long id){
		Article article = articleService.articleById(id);
		if(article == null) throw new ArticleNotFoundException(id);
		return article;
	}
	
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public ResponseEntity<Article> doAddArticle(@RequestBody ArticleAddDTO articleAddDTO){
		logger.info(articleAddDTO);
		
		Article article = articleService.saveRestArticleDTO(articleAddDTO);
		
		HttpStatus status;
		if(article != null)
			status = HttpStatus.CREATED;
		else	status = HttpStatus.NOT_FOUND;
		
		return new ResponseEntity<Article>(article, status);
	}
	
	@ExceptionHandler(ArticleNotFoundException.class)
	public ResponseEntity<com.elevysi.shop.pojo.Error> articleNotFound(ArticleNotFoundException articleNotFoundException){
		long articleId = articleNotFoundException.getArticleId();
		com.elevysi.shop.pojo.Error error = new Error(4,  "Article "+articleId+" was not found.");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
}
