package com.example.serviceauth.domain.event;

import java.util.UUID;

import com.example.ddd.domain.DomainEvent;
import com.example.serviceauth.domain.aggregate.user.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * UserCreatedDomainEvent
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreatedDomainEvent extends DomainEvent {
  private UUID userId;
  private String userName;

  public UserCreatedDomainEvent(User user) {
    super();
    this.userId = user.getId();
    this.userName = user.getUserName();
  }

  @Override
  public String getEventName() {
    return UserCreatedDomainEvent.class.getTypeName();
  }
}