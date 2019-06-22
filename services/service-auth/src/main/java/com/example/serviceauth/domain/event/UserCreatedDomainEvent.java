package com.example.serviceauth.domain.event;

import java.util.UUID;

import com.example.serviceauth.domain.entity.User;

import lombok.Data;

/**
 * UserCreatedDomainEvent
 */
@Data
public class UserCreatedDomainEvent {
  private UUID id;

  private UUID userId;
  private String userName;

  public UserCreatedDomainEvent(User user) {
    this.id = UUID.randomUUID();
    this.userId = user.getId();
    this.userName = user.getUserName();
  }
}