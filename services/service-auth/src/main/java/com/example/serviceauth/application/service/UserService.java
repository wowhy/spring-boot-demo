package com.example.serviceauth.application.service;

import com.example.serviceauth.application.dtos.UserDto;
import com.example.serviceauth.application.dtos.UserRegisterDto;
import com.example.serviceauth.domain.entity.User;
import com.example.serviceauth.domain.service.UserDomainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

/**
 * UserService
 */
@Service
public class UserService {
  private final UserDomainService userDomainService;

  @Autowired
  public UserService(UserDomainService userDomainService) {
    this.userDomainService = userDomainService;
  }

  public Mono<UserDto> register(UserRegisterDto dto) {
    Mono<User> userMono = Mono.just(this.userDomainService.register(dto.getUserName(), dto.getPassword()));
    Mono<UserDto> response = userMono.then(Mono.create(ctx -> {
      userMono.subscribe(user -> {
        ctx.success(new UserDto(user.getId(), user.getUserName()));
      });
    }));

    return response;
  }
}