package com.guoyw.springboot.demo080shiro.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-28 09:42
 **/
@ControllerAdvice
public class MyShiroException{
  
  /**
   * 处理Shiro权限拦截异常
   * 如果返回JSON数据格式请加上 @ResponseBody注解
   */
  @ResponseBody
  @ExceptionHandler(value = AuthorizationException.class)
  public Map<String,Object> defaultErrorHandler(){
    Map<String,Object> map = new HashMap<>();
    map.put("403","权限不足");
    return map;
  }
  
}
