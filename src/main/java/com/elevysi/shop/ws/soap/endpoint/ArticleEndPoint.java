package com.elevysi.shop.ws.soap.endpoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.elevysi.shop.dao.ArticleDAO;
import com.elevysi.shop.ws.soap.ArticleDetailsRequest;
import com.elevysi.shop.ws.soap.ArticleDetailsResponse;


@Endpoint
public class ArticleEndPoint {
	
	private static final String NAMESPACE_URI = "http://shop.elevysi.com/ws/soap/";
	private ArticleDAO articleDAO;
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public ArticleEndPoint(ArticleDAO articleDAO){
		this.articleDAO = articleDAO;
	}
	

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ArticleDetailsRequest")
	@ResponsePayload
	public ArticleDetailsResponse getArticle(@RequestPayload ArticleDetailsRequest request){
		
		ArticleDetailsResponse response = new ArticleDetailsResponse();
		com.elevysi.shop.entity.Article domainArticle = articleDAO.articleById(request.getId());
		com.elevysi.shop.ws.soap.Article wsArticle = modelMapper.map(domainArticle, com.elevysi.shop.ws.soap.Article.class);
		
		response.setArticle(wsArticle);
		
		return response;
		
	}
}
