package com.example.gatewayweb.model;

import java.util.UUID;

import lombok.Data;

/**
 * AccessTokenResponseDto
 */
@Data
public class AccessTokenResponse {
  private UUID userId;
  private String accessToken;
  private String refreshToken;
}