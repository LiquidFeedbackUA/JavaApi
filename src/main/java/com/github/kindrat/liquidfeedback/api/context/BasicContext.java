package com.github.kindrat.liquidfeedback.api.context;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static com.github.kindrat.liquidfeedback.api.util.ConfigUtil.API_PORT;
import static com.github.kindrat.liquidfeedback.api.util.ConfigUtil.API_URL;

@Configuration
public class BasicContext {

    @Bean(name = "config")
    public Config config() {
        return ConfigFactory.load();
    }

    @Bean(name = "serverUri")
    public URI serverUri(Config config) {
        String masterReUri = config.getString(API_URL.getPropertyName());
        Integer masterRePort = config.getInt(API_PORT.getPropertyName());
        return UriBuilder.fromUri(masterReUri).port(masterRePort).build();
    }
}
