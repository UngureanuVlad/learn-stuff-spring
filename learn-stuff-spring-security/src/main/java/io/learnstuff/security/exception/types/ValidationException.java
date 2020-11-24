package io.learnstuff.security.exception.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException implements Serializable {

  private transient Object[] args;

  public ValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ValidationException(String message, Throwable cause, Object[] args) {
    super(message, cause);
    this.args = args;
  }

  public ValidationException(String message) {
    super(message);
  }

  public void setArgs(Object[] args) {
    this.args = args;
  }

  public Object[] getArgs() {
    return args;
  }

}
