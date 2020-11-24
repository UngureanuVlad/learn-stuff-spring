package io.learnstuff.security.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.learnstuff.security.controller.dto.AuthenticationDTO;
import io.learnstuff.security.main.config.jwt.service.JwtTokenProvider;
import io.learnstuff.security.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserRepository users;

  @SuppressWarnings("rawtypes")
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO) {
    System.out.println("auth!!!");
    try {
      String username = authenticationDTO.getUsername();
      System.out.println(username);
      System.out.println(authenticationDTO.getPassword());
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, authenticationDTO.getPassword()));
      String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username)
          .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"))
          .getAuthorities().stream().map(a -> a.getAuthority()).collect(toList()));

      Map<Object, Object> model = new HashMap<>();
      model.put("username", username);
      model.put("token", token);
      return ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/me")
  public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails) {
    Map<Object, Object> model = new HashMap<>();
    model.put("username", userDetails.getUsername());
    model.put("roles",
        userDetails.getAuthorities().stream().map(a -> a.getAuthority()).collect(toList()));
    return ok(model);
  }
}
