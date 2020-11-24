package io.learnstuff.security.exception.dto;

public class ExceptionResponse {
  private String response;

  public ExceptionResponse() {
    // default constructor
  }

  public ExceptionResponse(String response) {
    this.response = response;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
}
