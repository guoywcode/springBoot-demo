package com.guoyw.springboot.demo020properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-19 11:55
 **/
@Data
@Configuration
@ConfigurationProperties("demo.book")
public class BookProperties{
  private String name;
  private Integer price;
  private List<String> authors;
}
