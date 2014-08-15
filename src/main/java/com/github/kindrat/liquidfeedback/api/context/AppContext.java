package com.github.kindrat.liquidfeedback.api.context;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.github.kindrat.liquidfeedback.api.util.ConfigUtil.*;

@Configuration
@ComponentScan("com.github.kindrat.liquidfeedback.api")
public class AppContext {

    private static final String PERSISTENCE_URL = "javax.persistence.jdbc.url";
    private static final String PERSISTENCE_USER = "javax.persistence.jdbc.user";
    private static final String PERSISTENCE_PASSWORD = "javax.persistence.jdbc.password";
    private static final String PERSISTENCE_DRIVER = "javax.persistence.jdbc.driver";
    private static final String PERSISTENCE_DIALECT = "hibernate.dialect";
    private static final String PERSISTENCE_POOL_SIZE = "hibernate.c3p0.max_size";
    private static final String PERSISTENCE_TEST_QUERY = "hibernate.c3p0.preferredTestQuery";

    @Autowired
    public Config config;

    @Bean(name = "config")
    public Config config()
    {
        return ConfigFactory.load();
    }

    @Bean(name = "serverUri")
    public URI serverUri() {
        String masterReUri = getProperty(API_URL.getPropertyName());
        Integer masterRePort = getInt(API_PORT.getPropertyName());
        return UriBuilder.fromUri(masterReUri).port(masterRePort).build();
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager() {
        Map<String, String> properties = new HashMap<>();
        properties.put(PERSISTENCE_URL, getProperty(DB_URL.getPropertyName()));
        properties.put(PERSISTENCE_USER, getProperty(DB_USER.getPropertyName()));
        properties.put(PERSISTENCE_PASSWORD, getProperty(DB_PASS.getPropertyName()));
        properties.put(PERSISTENCE_DRIVER, getProperty(DB_DRIVER.getPropertyName()));
        properties.put(PERSISTENCE_DIALECT, getProperty(DB_DIALECT.getPropertyName()));
        properties.put(PERSISTENCE_POOL_SIZE, getProperty(PERSISTENCE_POOL.getPropertyName()));
        properties.put(PERSISTENCE_TEST_QUERY, getProperty(TEST_QUERY.getPropertyName()));
        properties.put("hibernate.c3p0.testConnectionOnCheckout", "true");
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory(getProperty(PERSISTENCE_UNIT.getPropertyName()), properties);
        return factory.createEntityManager();
    }

    public String getProperty(String property) {
        return config.getString(property);
    }

    public long getLong(String property) {
        return config.getLong(property);
    }

    public int getInt(String property) {
        return config.getInt(property);
    }
}
