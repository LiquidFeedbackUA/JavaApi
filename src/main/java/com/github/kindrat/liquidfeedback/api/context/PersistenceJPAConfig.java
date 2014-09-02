package com.github.kindrat.liquidfeedback.api.context;

import com.typesafe.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static com.github.kindrat.liquidfeedback.api.util.ConfigUtil.*;

@Configurable
@Configuration
@EnableJpaRepositories(basePackages={"com.github.kindrat.liquidfeedback.api.persistence.dao"})
@EnableTransactionManagement
public class PersistenceJPAConfig {

    @Autowired
    public Config config;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.github.kindrat.liquidfeedback.api.persistence");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(config.getString(DB_DRIVER.getPropertyName()));
        dataSource.setUrl(config.getString(DB_URL.getPropertyName()));
        dataSource.setUsername(config.getString((DB_USER.getPropertyName())));
        dataSource.setPassword(config.getString(DB_PASS.getPropertyName()));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "com.github.kindrat.liquidfeedback.api.persistence.CustomPostgresDialect");
        properties.setProperty("hibernate.c3p0.max_size", config.getString(PERSISTENCE_POOL.getPropertyName()));
        properties.setProperty("hibernate.c3p0.preferredTestQuery", config.getString(TEST_QUERY.getPropertyName()));
        properties.setProperty("hibernate.c3p0.testConnectionOnCheckout", "true");
        return properties;
    }
}
