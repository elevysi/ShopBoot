package com.elevysi.shop.dao;

import com.elevysi.shop.entity.Article;

public interface ArticleDAO {
	public Article articleById(Long id);
	public Article save(Article article);
}
