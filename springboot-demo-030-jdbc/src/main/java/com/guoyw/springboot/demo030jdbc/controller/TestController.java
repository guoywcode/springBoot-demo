package com.guoyw.springboot.demo030jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-19 15:00
 **/
@RestController
public class TestController{
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @RequestMapping("/testJdbc")
  public List<Map<String,Object>> tulingHello() {
    List<Map<String,Object>> employeeList = jdbcTemplate.queryForList("select * from user");
    return employeeList;
  }
}
