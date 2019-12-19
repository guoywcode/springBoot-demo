package com.guoyw.springboot.demo030jdbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: guoyw
 * create: 2019-12-19 14:35
 **/
@Data
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceProperties{
  private String username;
  
  private String password;
  
  private String jdbcUrl;
  
  private String driverClassName;
  
  private Integer initialSize;
  
  private Integer maxActive;
  
  private Integer minIdle;
  
  public String filters;
  
  private long maxWait;
  
  private boolean poolPreparedStatements;
}
