package com.example.gatewayweb.model;

import javax.validation.constraints.*;

import lombok.Data;

/**
 * RegisterRequest
 */
@Data
public class RegisterRequest {
  @NotNull
  @NotBlank
  private String userName;

  @NotNull
  @NotBlank
  @Size(min = 6, max = 16)
  private String password;
}