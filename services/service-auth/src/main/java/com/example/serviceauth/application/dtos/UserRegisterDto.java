package com.example.serviceauth.application.dtos;

import lombok.Data;

/**
 * UserRegisterDto
 */
@Data
public class UserRegisterDto {
  private String userName;
  private String password;

  public UserRegisterDto() {
  }
}