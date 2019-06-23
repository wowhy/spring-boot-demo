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
}