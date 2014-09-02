package com.github.kindrat.liquidfeedback.api.context;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.net.URI;

public class ServerWrapper {

    private static final String CONTEXT_CLASS_NAME = "com.github.kindrat.liquidfeedback.api.context.AnnotationBasedContext";

    private HttpServer server;
    private URI serverUri;

    public ServerWrapper() {
        this(CONTEXT_CLASS_NAME);
    }

    public ServerWrapper(String contextClassName) {
        init(contextClassName);
    }

    private ServerWrapper init(String contextClassName) {
        // Initialize Grizzly HttpServer
        server = new HttpServer();
        // Initialize and add Spring-aware Jersey resource
        WebappContext ctx = new WebappContext("ctx", "/");
        SpringServlet servlet = new SpringServlet();
        final ServletRegistration reg = ctx.addServlet("spring", servlet);
        reg.addMapping("/*");
        ctx.addContextInitParameter("contextClass", contextClassName);
        ctx.addListener("org.springframework.web.context.ContextLoaderListener");
        ctx.addListener("org.springframework.web.context.request.RequestContextListener");
        ctx.deploy(server);

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
        serverUri = context.getBean(URI.class);

        NetworkListener listener = new NetworkListener("grizzly2", serverUri.getHost(), serverUri.getPort());
        server.addListener(listener);

        return this;
    }

    public HttpServer getServer() {
        return server;
    }

    public URI getServerUri() {
        return serverUri;
    }
}
