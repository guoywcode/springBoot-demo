package com.guoyw.springboot.demo010maven.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guoyw
 * create: 2019-12-19 16:44
 **/
@RestController
public class TestController{
  
  @RequestMapping("/hello")
  public String testHello() {
    return "hello";
  }
  
}
