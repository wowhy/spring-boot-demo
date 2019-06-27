package com.example.ddd.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity
 */
@MappedSuperclass
public abstract class Entity {
  @Id
  @Getter
  @Setter
  protected UUID id;

  @Getter
  @Setter
  protected Date createdAt;

  @Getter
  @Setter
  protected Date updatedAt;

  public Entity() {
  }

  public Entity(UUID id) {
    this.id = id;
    this.createdAt = this.updatedAt = new Date();
  }

  public UUID newIdentity() {
    return UUID.randomUUID();
  }
}