package com.github.kindrat.liquidfeedback.api.persistence;

import com.github.kindrat.liquidfeedback.api.persistence.functions.PostgreSQLFullTextSearchFunction;
import org.hibernate.dialect.PostgreSQL9Dialect;

public class CustomPostgresDialect extends PostgreSQL9Dialect {

    public CustomPostgresDialect() {
        registerFunction("fts", new PostgreSQLFullTextSearchFunction());
    }
}
