package com.guoyw.springboot.demo080shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.guoyw.springboot.demo080shiro.mapper"}) //扫描Mapper
public class SpringbootDemo080ShiroApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDemo080ShiroApplication.class, args);
  }

}
