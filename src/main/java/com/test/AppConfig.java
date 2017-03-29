package com.test;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.controller.TestController;
import com.test.service.TestService;
import com.test.service.impl.TestServiceImpl;

@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

	 @Bean
	 public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
	  MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	  ObjectMapper objectMapper = new ObjectMapper();
	  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	  jsonConverter.setObjectMapper(objectMapper);
	  return jsonConverter;
	 }
	 
	 @Override
	 public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	  converters.add(customJackson2HttpMessageConverter());
	  super.addDefaultHttpMessageConverters(converters);
	 }
	 
	@Bean
	public TestService testService() {
		return new TestServiceImpl();
	}

	@Bean
	public TestController testController() {
		return new TestController();
	}
	
/*	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	 MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	 ObjectMapper objectMapper = new ObjectMapper();
	 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	 jsonConverter.setObjectMapper(objectMapper);
	 return jsonConverter;
	}
*/}
