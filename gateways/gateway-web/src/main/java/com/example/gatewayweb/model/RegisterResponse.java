package com.example.gatewayweb.model;

import java.util.UUID;

import lombok.Data;

/**
 * RegisterResponse
 */
@Data
public class RegisterResponse {
  private UUID id;
  private String userName;
}