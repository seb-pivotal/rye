package io.pivotal.rye.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import java.net.URI;
import java.net.URL;

@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConnectionConfig {
    public String host;

    public int port;
    public String auth;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
