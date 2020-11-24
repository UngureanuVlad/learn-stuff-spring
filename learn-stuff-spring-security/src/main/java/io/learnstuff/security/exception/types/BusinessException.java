package io.learnstuff.security.exception.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException implements Serializable {

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

}
