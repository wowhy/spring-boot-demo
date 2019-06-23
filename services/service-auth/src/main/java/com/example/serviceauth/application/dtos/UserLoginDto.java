package com.example.serviceauth.application.dtos;

import lombok.Data;

/**
 * UserLoginDto
 */
@Data
public class UserLoginDto {
  private String userName;
  private String password;
}