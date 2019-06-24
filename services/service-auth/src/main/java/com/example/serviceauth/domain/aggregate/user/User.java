package com.example.serviceauth.domain.aggregate.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.example.serviceauth.domain.event.UserCreatedDomainEvent;
import com.example.serviceauth.domain.event.UserLoginedDomainEvent;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;

/**
 * User
 */
@Data
@Entity
public class User {
  @Id
  private UUID id;

  @Column(unique = true)
  private String userName;
  private String password;

  @Transient
  private List<Object> domainEvents = new ArrayList<Object>();

  public User() {
  }

  public User(String userName, String password) {
    this.id = UUID.randomUUID();
    this.userName = userName;
    this.password = password;

    this.domainEvents.add(new UserCreatedDomainEvent(this));
  }

  public void login(String password) {
    if (this.password != null && this.password.equals(password)) {
      this.domainEvents.add(new UserLoginedDomainEvent(this));
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "密码错误！");
    }
  }
}