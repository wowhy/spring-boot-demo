package com.example.gatewayweb.controller;

import javax.validation.Valid;

import com.example.gatewayweb.model.*;
import com.example.gatewayweb.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * AuthController
 */
@RestController
public class AuthController {
  @Autowired
  private AuthService service;

  @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
  public Mono<LoginResponse> login(@RequestBody @Valid LoginRequest body) {
    return this.service.login(body);
  }

  @RequestMapping(value = "/api/auth/register", method = RequestMethod.POST)
  public Mono<RegisterResponse> register(@RequestBody @Valid RegisterRequest body) {
    return this.service.register(body);
  }
}