package com.example.serviceauth.application.domain.event;

import com.example.serviceauth.domain.event.UserCreatedDomainEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * UserCreatedHandler
 */
@Component
public class UserCreatedHandler {
  private static Logger logger = LoggerFactory.getLogger(UserCreatedHandler.class);

  @EventListener
  private void handle(UserCreatedDomainEvent event) {
    logger.info(event.toString());
  }
}