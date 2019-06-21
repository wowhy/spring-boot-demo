package com.example.gatewayweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * HelloController
 */
@RestController
public class HelloController {
  @GetMapping("/hello")
  public Mono<String> hello() {
    return Mono.just("Welcome to reactive world ~");
  }
}