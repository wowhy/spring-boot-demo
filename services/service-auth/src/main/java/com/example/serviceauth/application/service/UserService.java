package com.example.serviceauth.application.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.example.serviceauth.application.dtos.*;
import com.example.serviceauth.domain.aggregate.user.*;
import com.example.serviceauth.domain.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

/**
 * UserService
 */
@Service
public class UserService {
  private final UserDomainService userDomainService;

  @Autowired
  private Validator validator;

  @Autowired
  public UserService(UserDomainService userDomainService) {
    this.userDomainService = userDomainService;
  }

  public Mono<UserDto> register(UserRegisterDto dto) {
    this.validate(dto);

    Mono<User> userMono = Mono.just(this.userDomainService.register(dto.getUserName(), dto.getPassword()));
    Mono<UserDto> response = userMono.then(Mono.create(ctx -> {
      userMono.subscribe(user -> {
        ctx.success(new UserDto(user.getId(), user.getUserName()));
      });
    }));

    return response;
  }

  public Mono<UserLoginResponseDto> login(UserLoginDto dto) {
    return Mono.just(new UserLoginResponseDto());
  }

  private <T> void validate(T param) {
    Set<ConstraintViolation<T>> violations = this.validator.validate(param);
    if (!violations.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      for (ConstraintViolation<T> constraintViolation : violations) {
        sb.append(constraintViolation.getMessage());
      }

      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
    }
  }
}