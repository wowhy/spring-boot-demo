package com.example.serviceauth.application.dtos;

import java.util.UUID;

import lombok.Data;

/**
 * UserDto
 */
@Data
public class UserDto {
  private UUID id;
  private String userName;

  public UserDto() {

  }

  public UserDto(UUID id, String userName) {
    this.id = id;
    this.userName = userName;
  }
}