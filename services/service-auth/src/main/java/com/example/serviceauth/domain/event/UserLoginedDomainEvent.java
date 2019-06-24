package com.example.serviceauth.domain.event;

import java.util.Date;
import java.util.UUID;

import com.example.serviceauth.domain.aggregate.user.User;

import lombok.Data;

/**
 * UserLoginedDomainEvent
 */
@Data
public class UserLoginedDomainEvent {
  private UUID id;
  private Date timestamp;

  private UUID userId;
  private String userName;

  public UserLoginedDomainEvent(User user) {
    this.id = UUID.randomUUID();
    this.timestamp = new Date();
    this.userId = user.getId();
    this.userName = user.getUserName();
  }
}