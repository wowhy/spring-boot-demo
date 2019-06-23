package com.example.serviceauth.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.serviceauth.domain.entity.User;
import com.example.serviceauth.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

/**
 * UserDomainService
 */
@Service
@Transactional
public class UserDomainService {
  private final UserRepository userRepository;
  private final ApplicationEventPublisher eventPublisher;

  @Autowired
  public UserDomainService(UserRepository userRepository, ApplicationEventPublisher eventPublisher) {
    this.userRepository = userRepository;
    this.eventPublisher = eventPublisher;
  }

  public User register(String userName, String password) {
    Assert.hasText(userName, "userName不能为空");
    Assert.hasText(password, "password不能为空");

    Optional<User> exists = this.userRepository.findByUserName(userName);
    if (exists.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "用户已存在！");
    }

    User user = new User(userName, password);

    this.userRepository.save(user);

    List<Object> domainEvents = user.getDomainEvents();
    for (Object domainEvent : domainEvents) {
      this.eventPublisher.publishEvent(domainEvent);
    }

    return user;
  }
}