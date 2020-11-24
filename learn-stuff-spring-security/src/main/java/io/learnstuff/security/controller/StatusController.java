package io.learnstuff.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

  private final Logger logger = LoggerFactory.getLogger(StatusController.class);

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/alive", produces = "application/json;charset=UTF-8")
  public String alive() {
    logger.info("Called alive() service!");
    return "OK";
  }
}
