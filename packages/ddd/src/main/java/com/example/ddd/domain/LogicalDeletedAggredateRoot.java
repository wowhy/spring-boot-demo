package com.example.ddd.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * LogicalDeletedAggredateRoot
 */
public abstract class LogicalDeletedAggredateRoot extends AggreateRoot {
  @Getter
  @Setter
  protected Date deletedAt;

  public boolean isDeleted() {
    return this.deletedAt != null;
  }

  public void remove() {
    this.deletedAt = new Date();
    this.raiseDeletedEvent();
  }

  protected abstract void raiseDeletedEvent();
}