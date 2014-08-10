package com.github.kindrat.liquidfeedback.api;

import com.github.kindrat.liquidfeedback.api.endpoint.UncaughtExceptionMapper;
import com.github.kindrat.liquidfeedback.api.persistence.dao.MemberDao;
import com.github.kindrat.liquidfeedback.api.persistence.dao.PolicyDao;
import com.github.kindrat.liquidfeedback.api.util.JsonProvider;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.github.kindrat.liquidfeedback.api.util.ConfigUtil.*;

public class AppContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppContext.class);

    private static final String PERSISTENCE_URL = "javax.persistence.jdbc.url";
    private static final String PERSISTENCE_USER = "javax.persistence.jdbc.user";
    private static final String PERSISTENCE_PASSWORD = "javax.persistence.jdbc.password";
    private static final String PERSISTENCE_DRIVER = "javax.persistence.jdbc.driver";
    private static final String PERSISTENCE_DIALECT = "hibernate.dialect";
    private static final String PERSISTENCE_POOL_SIZE = "hibernate.c3p0.max_size";
    private static final String PERSISTENCE_TEST_QUERY = "hibernate.c3p0.preferredTestQuery";

    public final Config config;
    public final EntityManager entityManager;
    public final ResourceConfig resourceConfig;
    public final URI serverUri;

    public final MemberDao memberDao;
    public final PolicyDao policyDao;

    public AppContext() {
        try {
            config = ConfigFactory.load();
            entityManager = withEntityManager();
            resourceConfig = withJerseyResourcesConfig();
            serverUri = withServerUri();
            memberDao = withMemberDao();
            policyDao = withPolicyDao();
        }catch (Exception e)
        {
            LOGGER.error("Error during initialization", e);
            throw new RuntimeException(e);
        }
    }

    private MemberDao withMemberDao() {
        checkNotNull(entityManager);
        return new MemberDao(entityManager);
    }

    private PolicyDao withPolicyDao() {
        checkNotNull(entityManager);
        return new PolicyDao(entityManager);
    }

    protected URI withServerUri() {
        String masterReUri = getProperty(API_URL.getPropertyName());
        Integer masterRePort = getInt(API_PORT.getPropertyName());
        return UriBuilder.fromUri(masterReUri).port(masterRePort).build();
    }

    protected ResourceConfig withJerseyResourcesConfig()
    {
        final AppContext context = this;
        return new ResourceConfig()
                .packages(true, "com.github.kindrat.liquidfeedback.api.endpoint")
                .register(MultiPartFeature.class)
                .register(JsonProvider.class)
                .register(UncaughtExceptionMapper.class)
                .register(new AbstractBinder()
                {
                    @Override
                    protected void configure()
                    {
                        bind(context).to(AppContext.class);
                    }
                });
    }

    protected EntityManager withEntityManager() {
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

    public void checkNotNull(Object obj) {
        if (obj == null)
            throw new NullPointerException("Null verification failed");
    }
}
