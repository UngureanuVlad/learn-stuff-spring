package io.learnstuff.security.controller.dto;

import java.io.Serializable;

public class AuthenticationDTO implements Serializable {

  private static final long serialVersionUID = -6986746375915710855L;
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
