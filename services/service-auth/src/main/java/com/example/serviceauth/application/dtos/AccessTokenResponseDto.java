package com.example.serviceauth.application.dtos;

import java.util.UUID;

import lombok.Data;

/**
 * AccessTokenResponseDto
 */
@Data
public class AccessTokenResponseDto {
  private UUID userId;
  private String accessToken;
  private String refreshToken;

  public AccessTokenResponseDto() {

  }

  public AccessTokenResponseDto(UUID userId, String accessToken, String refreshToken) {
    this.userId = userId;
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}