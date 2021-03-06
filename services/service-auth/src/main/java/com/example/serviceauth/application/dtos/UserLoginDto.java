package com.example.serviceauth.application.dtos;

import javax.validation.constraints.*;

import lombok.Data;

/**
 * UserLoginDto
 */
@Data
public class UserLoginDto {
  @NotNull
  @NotBlank
  private String userName;

  @NotNull
  @NotBlank
  @Size(min = 6, max = 16)
  private String password;
}