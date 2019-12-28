package com.guoyw.springboot.demo060exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-26 21:24
 **/
@Slf4j
@RestControllerAdvice
public class GuoywExceptionHandler {

  @Autowired(required = false)
  protected MessageSource messageSource;

  private final String codeName;
  private final String msgName;

  public GuoywExceptionHandler() {
    this.codeName = "codeName";
    this.msgName = "msgName";
  }

  @ExceptionHandler(GuoywException.class)
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Object> handleGuoywException(GuoywException exception) {
    Map<String, Object> result = new HashMap<>();
    log.warn(exception.getClass().getName());
    log.warn(exception.getMessage());
    
    String code = exception.getCodeName();
    String msgKey = exception.getClass().getSimpleName() + "." + code;
    String msg;
    if (messageSource != null) {
      msg = messageSource.getMessage(msgKey, exception.getParams(), code, LocaleContextHolder.getLocale());
    } else {
      msg = code;
    }
    result.put(this.codeName, code);
    result.put(this.msgName, msg);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
