package com.example.serviceauth.domain.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * AccessToken
 */
@Data
@Entity
public class AccessToken {
  @Id
  private UUID id;

  private UUID userId;
  private String accessToken;
  private Date accessTokenExpiresAt;

  private String refreshToken;
  private Date refreshTokenExpiresAt;

  public AccessToken() {
  }

  public AccessToken(UUID userId, String accessToken, Date accessTokenExpiresAt, String refreshToken,
      Date refreshTokenExpiresAt) {
    this.id = UUID.randomUUID();
    this.userId = userId;
    this.accessToken = accessToken;
    this.accessTokenExpiresAt = accessTokenExpiresAt;
    this.refreshToken = refreshToken;
    this.refreshTokenExpiresAt = refreshTokenExpiresAt;
  }
}