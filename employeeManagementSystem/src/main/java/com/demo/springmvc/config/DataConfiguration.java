package com.demo.springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.demo.springmvc.dao.repo")
public class DataConfiguration {
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/advjava");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSession() {
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.scanPackages("com.demo.springmvc.beans");
		factoryBuilder.setProperties(getProperty());
		return factoryBuilder.buildSessionFactory();
	}
	
	private Properties getProperty() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.show-sql","true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getManager() {
		return new HibernateTransactionManager(getSession());
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManager() {
		LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(getProperty());
		factoryBean.setPackagesToScan("com.demo.springmvc.dao.beans");
		return factoryBean;
	}
	
	@Bean(name = "transactionManager")
	public JpaTransactionManager getJpaTransaction(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager manager=new JpaTransactionManager(entityManagerFactory);
		return manager;
	}
}
