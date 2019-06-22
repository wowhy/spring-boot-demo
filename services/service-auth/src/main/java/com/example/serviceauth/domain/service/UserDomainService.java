package com.example.serviceauth.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.serviceauth.domain.entity.User;
import com.example.serviceauth.domain.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * UserDomainService
 */
@Service
@Transactional
public class UserDomainService {
  private final UserRepository userRepository;

  @Autowired
  public UserDomainService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User register(String userName, String password) {
    Optional<User> exists = this.userRepository.findByUserName(userName);
    if (exists.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "用户已存在！");
    }

    User user = new User(userName, password);

    user = this.userRepository.save(user);

    // List<Object> domainEvents = user.getDomainEvents();
    // TODO: 发布领域事件

    return user;
  }
}