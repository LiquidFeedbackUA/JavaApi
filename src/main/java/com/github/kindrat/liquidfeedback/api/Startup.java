package com.github.kindrat.liquidfeedback.api;

import com.github.kindrat.liquidfeedback.api.context.ServerWrapper;
import com.github.kindrat.liquidfeedback.api.util.LogUtils;
import org.glassfish.grizzly.http.server.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Startup {
    private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

    public static void main(String... args) throws InterruptedException, IOException {
        LogUtils.initLoggers();
        LOGGER.info("Starting grizzly...");
        ServerWrapper wrapper = new ServerWrapper();
        final HttpServer server = wrapper.getServer();
        server.start();

        LOGGER.info("Jersey app started with WADL available at {}application.wadl\n", wrapper.getServerUri());

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
