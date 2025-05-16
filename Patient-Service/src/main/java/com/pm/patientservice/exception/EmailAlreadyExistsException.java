package com.pm.patientservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


public class EmailAlreadyExistsException extends RuntimeException {
  private static final Logger log = LoggerFactory.getLogger(EmailAlreadyExistsException.class);

  public EmailAlreadyExistsException(String message) {
    super(message);
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
    log.warn("Email address already exists: {}", ex.getMessage());

    Map<String, String> errors = new HashMap<>();
    errors.put("message", "Email address already exists");

    return ResponseEntity.badRequest().body(errors);
  }
}

