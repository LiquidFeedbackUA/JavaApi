package com.github.kindrat.liquidfeedback.api;

import com.github.kindrat.liquidfeedback.api.util.LogUtils;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.net.URI;

@Configurable
public class Startup {

    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);
    @Autowired
    private static URI serverUri;

    public static void main(String... args) throws InterruptedException, IOException {
        LogUtils.initLoggers();
        LOGGER.info("Starting grizzly...");
        // Initialize Grizzly HttpServer
        final HttpServer server = new HttpServer();
        // Initialize and add Spring-aware Jersey resource
        WebappContext ctx = new WebappContext("ctx", "/");
        SpringServlet servlet = new SpringServlet();
        final ServletRegistration reg = ctx.addServlet("spring", servlet);
        reg.addMapping("/*");
        ctx.addContextInitParameter("contextClass", "com.github.kindrat.liquidfeedback.api.context.AnnotationBasedContext");
        ctx.addListener("org.springframework.web.context.ContextLoaderListener");
        ctx.addListener("org.springframework.web.context.request.RequestContextListener");
        ctx.deploy(server);

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servlet.getServletContext());
        URI serverUri = context.getBean(URI.class);

        NetworkListener listener = new NetworkListener("grizzly2", serverUri.getHost(), serverUri.getPort());
        server.addListener(listener);
        server.start();

        LOGGER.info("Jersey app started with WADL available at {}application.wadl\n", serverUri);

        // register shutdown hook
        Runtime.getRuntime().addShutdownHook(
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LOGGER.info("Stopping server..");
                        server.shutdownNow();
                    }
                }, "shutdownHook")
        );

        // prevent auto-exiting to OS
        Thread.currentThread().join();
    }
}
