package com.jdc.home.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@EnableJpaAuditing
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class DatabaseConfig {

	@Bean
	DataSource dataSource() {
		var ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/angular_universty_db");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("angularUniversty");
		ds.setPassword("angularUniversty");
		return ds;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(ds);
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setPackagesToScan("com.jdc.home.model.entity");
		bean.setJpaPropertyMap(Map.of("hibernate.hbm2ddl.auto", "drop-and-create", "hibernate.show_sql", true, "hibernate.format_sql", true));
		return bean;
	}
	
	@Bean
	TransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}
