package com.guoyw.springboot.demo020properties.controller;

import com.guoyw.springboot.demo020properties.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guoyw
 * create: 2019-12-19 11:54
 **/
@RestController
@RequestMapping("/api/book")
public class BookController{
 
 @Autowired
 private BookProperties bookProperties;
  
  @GetMapping({"/", "index"})
  public String index() {
    return "book name: " + bookProperties.getName()
      + " and price: " + bookProperties.getPrice()
      + " and authors: " + bookProperties.getAuthors().toString();
  }
}
