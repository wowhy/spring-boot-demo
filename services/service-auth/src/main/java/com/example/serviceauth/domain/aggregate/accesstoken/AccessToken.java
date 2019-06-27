package com.example.serviceauth.domain.aggregate.accesstoken;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;

import com.example.ddd.domain.AggreateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * AccessToken
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class AccessToken extends AggreateRoot {
  private UUID userId;
  private String accessToken;
  private Date accessTokenExpiresAt;

  private String refreshToken;
  private Date refreshTokenExpiresAt;

  public AccessToken() {
  }

  public AccessToken(UUID userId, String accessToken, Date accessTokenExpiresAt, String refreshToken,
      Date refreshTokenExpiresAt) {
    super(UUID.randomUUID());
    this.userId = userId;
    this.accessToken = accessToken;
    this.accessTokenExpiresAt = accessTokenExpiresAt;
    this.refreshToken = refreshToken;
    this.refreshTokenExpiresAt = refreshTokenExpiresAt;
  }
}