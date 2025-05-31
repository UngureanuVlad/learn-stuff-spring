package io.learnstuff.security.controller;

import io.learnstuff.security.domain.DomainResponse;
import io.learnstuff.security.domain.DomainToken;
import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.DomainUserRegistration;
import io.learnstuff.security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<DomainResponse> register(@RequestBody DomainUserRegistration user) {
        log.info("Called register()!");
        authenticationService.register(user);
        return ResponseEntity.ok(DomainResponse.builder().message("").build());
    }

    @PostMapping("/login")
    public ResponseEntity<DomainToken> login(@RequestBody DomainUser user) {
        log.info("Called login()!");
        return ResponseEntity.ok(authenticationService.login(user));
    }
}
