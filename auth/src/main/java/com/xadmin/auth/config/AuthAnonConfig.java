package com.xadmin.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "auth")
@PropertySource(value = { "classpath:auth.yml" })
public class AuthAnonConfig {
    @Value("#{'${anonurl}'.replaceAll(' ', '').split(',')}")
    private List<String> anonurl;

    public List<String> getAnonurl() {
        return anonurl;
    }

    public void setAnonurl(List<String> anonurl) {
        this.anonurl = anonurl;
    }
}
