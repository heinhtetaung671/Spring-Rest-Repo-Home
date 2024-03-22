package com.jdc.logging.config;

import java.nio.charset.Charset;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

@Configuration
public class LoggingConfig {

	@Value("${log.file.path}")
	String logPath;
	public static final LoggerContext CONTEXT = (LoggerContext) LoggerFactory.getILoggerFactory();
	
	@Bean
	PatternLayoutEncoder encoder() {
		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
		encoder.setCharset(Charset.forName("utf-8"));
		encoder.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
		encoder.setContext(CONTEXT);
		encoder.start();
		return encoder;
	}
	
	@Bean
	FileAppender<ILoggingEvent> fileAppender(PatternLayoutEncoder encoder){
		FileAppender<ILoggingEvent> appender = new FileAppender<ILoggingEvent>();
		appender.setContext(CONTEXT);
		appender.setEncoder(encoder);
		return appender;
	}
	
	
}
