package com.jdc.payroll.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jdc.payroll.model.BaseRepositoryImpl;

@Configuration
@ComponentScan(basePackages = "com.jdc.payroll.model")
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class, basePackages = "com.jdc.payroll.model.repo")
public class DatabaseConfig {
	
}
