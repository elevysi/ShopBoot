package com.elevysi.shop.ws.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
//	@Bean(name = "articleDetailsWsdl")
//	public Wsdl11Definition defaultWsdl11Definition() {
//		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
//	    wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/helloworld.wsdl"));
//
//	    return wsdl11Definition;
//	}
	
	@Bean(name="articleDetailsWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema articlesSchema){
		
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ArticleDetailsPort");
        wsdl11Definition.setLocationUri("/ws/article-details");
        wsdl11Definition.setTargetNamespace("http://shop.elevysi.com/ws/soap/");
        wsdl11Definition.setSchema(articlesSchema);
        return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema articlesSchema(){
		return new SimpleXsdSchema(new ClassPathResource("ws/soap/article.xsd"));
	}
}
