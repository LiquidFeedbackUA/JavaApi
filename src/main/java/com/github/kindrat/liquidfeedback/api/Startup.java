package com.github.kindrat.liquidfeedback.api;

import com.github.kindrat.liquidfeedback.api.util.LogUtils;
import com.typesafe.config.ConfigRenderOptions;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Startup {
    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String... args) throws InterruptedException {
        LogUtils.initLoggers();
        LOGGER.info("Starting grizzly...");

        final AppContext context = new AppContext();

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(context.serverUri, context.resourceConfig);

        LOGGER.info(context.config.root().render(ConfigRenderOptions.concise().setFormatted(true).setJson(false)));

        LOGGER.info("Jersey app started with WADL available at {}application.wadl\n", context.serverUri);

        // register shutdown hook
        Runtime.getRuntime().addShutdownHook(
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        LOGGER.info("Stopping server..");
                        server.shutdownNow();
                    }
                }, "shutdownHook")
        );

        // prevent auto-exiting to OS
        Thread.currentThread().join();
    }
}
