package com.example.demo.NHSLogin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "nhs.login")
@Configuration
public class NHSLoginProperties {
    private String environmentUri = "https://auth.sandpit.signin.nhs.uk";
    private String tokenPath = "/token";
    private String userInfoPath = "/userinfo";
    private String clientId;

    public String getClientId() {
        return clientId;
    }

    public String getTokenEndpoint() {
        return environmentUri + tokenPath;
    }

    public String getUserInfoEndpoint() {
        return environmentUri + userInfoPath;
    }

    public void setEnvironmentUri(String environmentUri) {
        this.environmentUri = environmentUri;
    }

    public void setTokenPath(String tokenPath) {
        this.tokenPath = tokenPath;
    }

    public void setUserInfoPath(String userInfoPath) {
        this.userInfoPath = userInfoPath;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
