package com.elevysi.test.shop.entity.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.elevysi.shop.entity.Article;
import com.elevysi.shop.entity.dto.ArticleAddDTO;

public class ArticleDTOTest {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	
	@Test
	public void checkArticleMapping(){
		ArticleAddDTO articleAddDTO = new ArticleAddDTO();
		articleAddDTO.setName("Test name");
		articleAddDTO.setDescription("Test description");
		articleAddDTO.setPrice(new Double(100));
		
		Article article = modelMapper.map(articleAddDTO, Article.class);
		assertEquals(articleAddDTO.getName(), article.getName());
		assertEquals(articleAddDTO.getDescription(), article.getDescription());
		assertEquals(articleAddDTO.getPrice(), article.getPrice());
		assertEquals(articleAddDTO.getCreated(), article.getCreated());
		assertEquals(articleAddDTO.getModified(), article.getModified());
	}

}
