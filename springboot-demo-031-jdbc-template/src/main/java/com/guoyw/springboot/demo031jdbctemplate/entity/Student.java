package com.guoyw.springboot.demo031jdbctemplate.entity;

import com.guoyw.springboot.demo031jdbctemplate.utils.SnowFlakeUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: guoyw
 * create: 2019-12-19 16:00
 **/
@Data
@Component
public class Student implements Serializable{
  
  private String id = String.valueOf(SnowFlakeUtil.getInstance().nextId());
  private String name;
  private Integer age;
}
