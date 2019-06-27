package com.example.ddd.domain;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * DomainEvent
 */
public abstract class DomainEvent {
  @Getter
  @Setter
  protected UUID id;

  @Getter
  @Setter
  protected Date timestamp;

  public DomainEvent() {
    this.id = UUID.randomUUID();
    this.timestamp = new Date();
  }

  public abstract String getEventName();
}