package io.learnstuff.security.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.learnstuff.security.exception.dto.ExceptionResponse;
import io.learnstuff.security.exception.types.BusinessException;
import io.learnstuff.security.exception.types.TechnicalException;
import io.learnstuff.security.exception.types.ValidationException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(ValidationException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.CONFLICT)
  public ExceptionResponse handleValidationExceptions(ValidationException e) {
    logger.error(e.getLocalizedMessage(), e);
    String msg =
        messageSource.getMessage(e.getMessage(), e.getArgs(), LocaleContextHolder.getLocale());
    return new ExceptionResponse(msg);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.CONFLICT)
  public String handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    JsonMappingException jme = (JsonMappingException) ex.getCause();
    logger.error(jme.getOriginalMessage(), jme);
    String msg = messageSource.getMessage(jme.getOriginalMessage(),
        new Object[] {jme.getPath().get(0).getFieldName()}, LocaleContextHolder.getLocale());
    return msg;
  }

  @ExceptionHandler(TechnicalException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ExceptionResponse handleTechnicalException(TechnicalException e) {
    logger.error(e.getLocalizedMessage(), e);
    return new ExceptionResponse(e.getMessage());
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ExceptionResponse handleBusinessException(BusinessException e) {
    logger.error(e.getLocalizedMessage(), e);
    return new ExceptionResponse(e.getMessage());
  }

}
