package com.example.serviceauth.application.dtos;

import lombok.Data;

/**
 * UserLoginResponseDto
 */
@Data
public class UserLoginResponseDto {
  private Integer expiresIn;
  private AccessTokenResponseDto token;

  public UserLoginResponseDto() {

  }

  public UserLoginResponseDto(Integer expiresIn, AccessTokenResponseDto token) {
    this.expiresIn = expiresIn;
    this.token = token;
  }
}