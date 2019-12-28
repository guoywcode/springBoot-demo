package com.guoyw.springboot.demo060exception.controller;

import com.guoyw.springboot.demo060exception.exception.GuoywException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-26 21:30
 **/
@RestController
public class TestController {

  @GetMapping("/")
  public void  test(){
    throw new GuoywException("ERROR-00001");
  }

  @GetMapping("/test")
  public void  test1(){
    throw new GuoywException("ERROR-00002",new String[]{"errorName"});
  }
}
