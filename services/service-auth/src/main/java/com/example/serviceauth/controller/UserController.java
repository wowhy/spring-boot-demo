package com.example.serviceauth.controller;

import com.example.serviceauth.application.dtos.UserDto;
import com.example.serviceauth.application.dtos.UserRegisterDto;
import com.example.serviceauth.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * UserController
 */
@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public Mono<UserDto> create(@RequestBody UserRegisterDto dto) {
    Mono<UserDto> response = this.userService.register(dto);
    return response;
  }
}