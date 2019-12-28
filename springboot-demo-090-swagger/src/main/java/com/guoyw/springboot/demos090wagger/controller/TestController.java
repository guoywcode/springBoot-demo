package com.guoyw.springboot.demos090wagger.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-26 21:30
 **/
@RestController
@Api(tags = "测试文档")
public class TestController{

  @GetMapping("/")
  @ApiOperation("测试一")
  public void  test(){
    return;
  }

  @GetMapping("/test")
  @ApiOperation("测试二")
  public void  test1(){
    return;
  }
}
