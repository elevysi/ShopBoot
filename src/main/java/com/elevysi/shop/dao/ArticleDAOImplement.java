package com.elevysi.shop.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elevysi.shop.entity.Article;

@Repository
@Transactional
public class ArticleDAOImplement implements ArticleDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public Article articleById(Long id){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Article> criteria = cb.createQuery(Article.class);
		Root<Article> queryRoot = criteria.from(Article.class);
		Predicate condition = cb.equal(queryRoot.get("id"), id);
		criteria.where(condition);
		TypedQuery<Article> query = em.createQuery(criteria);
		Article article;
		
		try{
			article = query.getSingleResult();
		}catch(NoResultException e){
			article = null;
		}
		
		return article;
		
	}
	
	public Article save(Article article){
		em.persist(article);
		em.flush();
		return article;
	}
}
