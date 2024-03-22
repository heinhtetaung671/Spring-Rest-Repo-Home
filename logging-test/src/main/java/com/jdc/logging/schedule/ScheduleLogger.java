package com.jdc.logging.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@Slf4j
@Component
public class ScheduleLogger {

	@Value("${log.file.path}")
	private String logPath;
	
	@Value("${log.file.name.date-time-format}")
	private String logFileNameDateTimeFormat;
	
	@Autowired
	private FileAppender<ILoggingEvent> appender;

	private DateTimeFormatter formatter;
	
	@PostConstruct
	public void init() {
		formatter = DateTimeFormatter.ofPattern(logFileNameDateTimeFormat);
	}
	
	@Scheduled(fixedDelay = 1000)
	public void log() {
		if (log instanceof Logger logger) {

			appender.setFile(logPath + formatter.format(LocalDateTime.now()) + ".log");
			appender.start();

			logger.addAppender(appender);
			logger.error("error log in every sec");
			logger.detachAppender(appender);
			appender.stop();
		}
	}

}
