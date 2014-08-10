package com.github.kindrat.liquidfeedback.api.util;

public enum ConfigUtil {
    TIMEOUT_SECONDS("api.timeout"),
    FULL_DOWNLOAD_SECONDS("api.fullDownload"),
    API_PORT("api.port"),
    API_URL("api.uri"),
    DB_URL("db.datasource.url"),
    DB_USER("db.datasource.username"),
    DB_PASS("db.datasource.password"),
    DB_DRIVER("db.datasource.driver"),
    DB_DIALECT("db.hibernate.dialect"),
    PERSISTENCE_UNIT("db.persistence.name"),
    PERSISTENCE_POOL("db.persistence.poolSize"),
    TEST_QUERY("db.persistence.testQuery");

    private final String propertyName;

    ConfigUtil(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
