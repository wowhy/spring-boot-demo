package com.example.serviceauth.domain.aggregate.user;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.ddd.domain.AggreateRoot;
import com.example.serviceauth.domain.event.UserCreatedDomainEvent;
import com.example.serviceauth.domain.event.UserLoginedDomainEvent;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AggreateRoot {
  @Column(unique = true)
  private String userName;
  private String password;

  public User() {
  }

  public User(String userName, String password) {
    super(UUID.randomUUID());
    this.userName = userName;
    this.password = password;
    this.raiseEvent(new UserCreatedDomainEvent(this));
  }

  public void login(String password) {
    if (this.password != null && this.password.equals(password)) {
      this.raiseEvent(new UserLoginedDomainEvent(this));
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "密码错误！");
    }
  }
}