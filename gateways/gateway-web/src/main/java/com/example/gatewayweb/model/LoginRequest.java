package com.example.gatewayweb.model;

import javax.validation.constraints.*;

import lombok.Data;

/**
 * LoginRequest
 */
@Data
public class LoginRequest {
  @NotNull
  @NotBlank
  private String userName;

  @NotNull
  @NotBlank
  @Size(min = 6, max = 16)
  private String password;
}