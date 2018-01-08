package com.elevysi.shop.exception;

public class ArticleNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long articleId;
	
	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public ArticleNotFoundException(long articleId){
		this.articleId = articleId;
	}
	
}
