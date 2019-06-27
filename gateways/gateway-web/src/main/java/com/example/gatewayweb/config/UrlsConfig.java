package com.example.gatewayweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.Data;

/**
 * UrlsConfig
 */

@Data
@Configuration
public class UrlsConfig {
  @Value("${urls.auth}")
  private String authUrl;

  public static class AuthOperations {
    public static String loginUrl() {
      return "/auth/login";
    }

    public static String registerUrl() {
      return "/auth/register";
    }
  }

  @Bean("authClient")
  public WebClient getAuthClient() {
    return WebClient.create(authUrl);
  }
}