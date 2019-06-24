package com.example.serviceauth.domain.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.example.serviceauth.domain.aggregate.accesstoken.*;
import com.example.serviceauth.domain.aggregate.user.*;

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
  private final AccessTokenRepository accessTokenRepository;
  private final ApplicationEventPublisher eventPublisher;

  @Autowired
  public UserDomainService(UserRepository userRepository, AccessTokenRepository accessTokenRepository,
      ApplicationEventPublisher eventPublisher) {
    this.userRepository = userRepository;
    this.accessTokenRepository = accessTokenRepository;
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

  public AccessToken login(String userName, String password, Integer expiresIn) {
    Assert.hasText(userName, "userName不能为空");
    Assert.hasText(password, "password不能为空");

    Optional<User> exists = this.userRepository.findByUserName(userName);
    if (!exists.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "用户不存在！");
    }

    User user = exists.get();

    user.login(password);

    AccessToken accessToken = this.accessTokenRepository
        .save(new AccessToken(user.getId(), UUID.randomUUID().toString(), this.addHour(new Date(), 2),
            UUID.randomUUID().toString(), this.addHour(new Date(), 24 * 30)));

    List<Object> domainEvents = user.getDomainEvents();
    for (Object domainEvent : domainEvents) {
      this.eventPublisher.publishEvent(domainEvent);
    }

    return accessToken;
  }

  private Date addHour(Date date, int hour) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR, hour);
    return calendar.getTime();
  }
}