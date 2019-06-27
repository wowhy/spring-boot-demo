package com.example.gatewayweb.config;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * ExceptionHandler
 */
@ControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(value = WebClientResponseException.class)
  public void exception(HttpServletResponse response, WebClientResponseException ex) throws IOException {
    response.setStatus(ex.getRawStatusCode());
    response.setCharacterEncoding("utf-8");
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().write(ex.getResponseBodyAsString());
    response.flushBuffer();
  }
}