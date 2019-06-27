package com.example.gatewayweb.service;

import com.example.gatewayweb.config.UrlsConfig;
import com.example.gatewayweb.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * AuthService
 */
@Service
public class AuthService {
  @Autowired
  @Qualifier("authClient")
  private WebClient client;

  public Mono<LoginResponse> login(LoginRequest body) {
    Mono<LoginResponse> response = this.client.post().uri(UrlsConfig.AuthOperations.loginUrl())
        .contentType(MediaType.APPLICATION_JSON).syncBody(body).retrieve().bodyToMono(LoginResponse.class);

    return response;
  }

  public Mono<RegisterResponse> register(RegisterRequest body) {
    Mono<RegisterResponse> response = this.client.post().uri(UrlsConfig.AuthOperations.registerUrl())
        .contentType(MediaType.APPLICATION_JSON).syncBody(body).retrieve().bodyToMono(RegisterResponse.class);

    return response;
  }
}