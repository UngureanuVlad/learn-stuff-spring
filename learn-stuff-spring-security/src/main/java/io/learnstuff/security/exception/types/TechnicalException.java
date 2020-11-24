package io.learnstuff.security.exception.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TechnicalException extends RuntimeException implements Serializable {

  public TechnicalException(String message, Throwable cause) {
    super(message, cause);
  }

}
