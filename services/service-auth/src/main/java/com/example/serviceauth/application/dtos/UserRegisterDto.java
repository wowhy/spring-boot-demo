package com.example.serviceauth.application.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * UserRegisterDto
 */
@Data
public class UserRegisterDto {
  @NotNull
  @NotBlank
  private String userName;

  @NotNull
  @NotBlank
  @Size(min = 6, max = 16)
  private String password;

  public UserRegisterDto() {
  }
}