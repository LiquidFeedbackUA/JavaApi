package com.github.kindrat.liquidfeedback.api.context;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class AnnotationBasedContext extends AnnotationConfigWebApplicationContext {

    public AnnotationBasedContext() {
        register(AppContext.class);
        refresh();
    }
}
