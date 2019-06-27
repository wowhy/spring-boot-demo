package com.example.ddd.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * AggreateRoot
 */
@MappedSuperclass
public abstract class AggreateRoot extends Entity {
  @Transient
  protected Collection<DomainEvent> domainEvents = new ArrayList<DomainEvent>();

  public AggreateRoot() {
    super();
  }

  public AggreateRoot(UUID id) {
    super(id);
  }

  public void raiseEvent(DomainEvent e) {
    this.domainEvents.add(e);
  }

  public Collection<DomainEvent> getDomainEvents() {
    return Collections.unmodifiableCollection(this.domainEvents);
  }
}