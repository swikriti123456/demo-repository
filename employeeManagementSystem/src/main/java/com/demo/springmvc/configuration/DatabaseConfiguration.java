package com.demo.springmvc.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.demo.springmvc.dao.repository" })
public class DatabaseConfiguration {
	@Autowired
	Environment env;

	private Properties getHibernateProperties() {
		Properties property = new Properties();
		property.put(org.hibernate.cfg.Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");//env.getProperty("jpa.dialect"));
		property.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO,"create");// env.getProperty("jpa.hbm2ddl.auto"));
		property.put(org.hibernate.cfg.Environment.SHOW_SQL,"true");// env.getProperty("jpa.show_sql"));
		property.put(org.hibernate.cfg.Environment.FORMAT_SQL,"true");// env.getProperty("jpa.format_sql"));
		return property;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//env.getProperty("dataSource.driverClass"));
		dataSource.setUrl("jdbc:mysql://localhost:3306/advjava");//env.getProperty("dataSource.url"));
		dataSource.setUsername("root");//env.getProperty("dataSource.user"));
		dataSource.setPassword("root");//env.getProperty("dataSource.password"));
		return dataSource;
	}

	/*
	 * @Bean(name = "jdbcTemplate") public JdbcTemplate getJdbcTemplate(DataSource
	 * dataSource) { return new JdbcTemplate(dataSource); }
	 * 
	 * @Bean(name = "sessionFactory") public SessionFactory
	 * getSessionFactory(DataSource dataSource) { LocalSessionFactoryBuilder
	 * sessionFactory = new LocalSessionFactoryBuilder(dataSource);
	 * sessionFactory.scanPackages("com.demo.springmvc.beans");
	 * sessionFactory.setProperties(getHibernateProperties()); return
	 * sessionFactory.buildSessionFactory(); }
	 */

	/*
	 * @Bean(name="transactionManager") public HibernateTransactionManager
	 * forTransactionManager(SessionFactory sessionFactory) { return new
	 * HibernateTransactionManager(sessionFactory); }
	 */
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setPackagesToScan("com.demo.springmvc.beans");
		factoryBean.setJpaProperties(getHibernateProperties());
		return factoryBean;
	}

	@Bean(name = "transactionManager")
	public JpaTransactionManager forTranstactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
