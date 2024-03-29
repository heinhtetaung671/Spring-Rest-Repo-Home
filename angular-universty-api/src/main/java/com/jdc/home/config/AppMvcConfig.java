package com.jdc.home.config;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jdc.home.model.formatter.CategoryFormatter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jdc.home.api", "com.jdc.home.aop"})
@PropertySource(value = "classpath:/application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppMvcConfig implements WebMvcConfigurer{

	@Autowired
	private CategoryFormatter categoryFormatter;
	
	@Value("${spring.mvc.format.date-time}")
	private String dateTimeFormat;
	@Value("${spring.mvc.format.date}")
	private String dateFormat;
	
	@Bean
	ObjectMapper  objectMapperBuilder() {
		var builder =  new Jackson2ObjectMapperBuilder();
		builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)), new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
		builder.deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern(dateFormat)), new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
		return builder.build();
	}
	
	@Bean
	MappingJackson2HttpMessageConverter httpMessageConverter(ObjectMapper objectMapper) {
		return new MappingJackson2HttpMessageConverter(objectMapper);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(categoryFormatter);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
	}
	
}
