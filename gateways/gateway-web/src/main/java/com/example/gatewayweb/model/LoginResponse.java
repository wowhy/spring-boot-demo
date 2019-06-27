package com.example.gatewayweb.model;

import lombok.Data;

/**
 * LoginResponse
 */
@Data
public class LoginResponse {
  private Integer expiresIn;
  private AccessTokenResponse token;
}