package com.github.kindrat.liquidfeedback.api.persistence.functions;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

public class PostgreSQLFullTextSearchFunction implements SQLFunction {
    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) throws QueryException {
        return new BooleanType();
    }

    @Override
    public String render(Type firstArgumentType, List arguments, SessionFactoryImplementor factory) throws QueryException {
        if (arguments == null || arguments.size() < 2) {
            throw new IllegalArgumentException(
                    "The function must be passed 2 arguments");
        }

        String fragment;
        String ftsConfig;
        String field;
        String value;
        if (arguments.size() == 3) {
            ftsConfig = (String) arguments.get(0);
            field = (String) arguments.get(1);
            value = (String) arguments.get(2);
            fragment = field + " @@ to_tsquery(" + ftsConfig + ", " + value + ")";
        } else {
            field = (String) arguments.get(0);
            value = (String) arguments.get(1);
            fragment = field + " @@ to_tsquery(" + value + ")";
        }
        return fragment;
    }
}
