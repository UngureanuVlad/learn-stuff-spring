package io.learnstuff.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StatusController {


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/alive", produces = "application/json;charset=UTF-8")
    public String alive() {
        log.info("Called alive() service!");
        return "OK";
    }
}
