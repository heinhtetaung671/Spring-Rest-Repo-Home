package com.jdc.home.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jdc.home.controller")
public class AppMvcConfig implements WebMvcConfigurer{

	private String dateTimeFormat;
	private String dateFormat;
	
	@Bean
	ObjectMapper  objectMapperBuilder() {
		var builder =  new Jackson2ObjectMapperBuilder();
		builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)), new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
				
		return builder.build();
	}
	
	@Bean
	MappingJackson2HttpMessageConverter httpMessageConverter(ObjectMapper objectMapper) {
		return new MappingJackson2HttpMessageConverter(objectMapper);
	}
}
