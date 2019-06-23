package com.example.serviceauth.controller;

import javax.validation.Valid;

import com.example.serviceauth.application.dtos.UserDto;
import com.example.serviceauth.application.dtos.UserLoginDto;
import com.example.serviceauth.application.dtos.UserLoginResponseDto;
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
public class AuthController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
  public Mono<UserDto> register(@RequestBody @Valid UserRegisterDto dto) {
    return this.userService.register(dto);
  }

  @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
  public Mono<UserLoginResponseDto> login(@RequestBody @Valid UserLoginDto dto) {
    return this.userService.login(dto);
  }
}