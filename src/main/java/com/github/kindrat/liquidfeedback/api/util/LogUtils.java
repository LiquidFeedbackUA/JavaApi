package com.github.kindrat.liquidfeedback.api.util;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Level;

public final class LogUtils {
    private LogUtils() {
    }

    public static void initLoggers() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        java.util.logging.Logger.getLogger("global").setLevel(Level.FINEST);
    }
}
