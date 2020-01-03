package com.guoyw.springboot.demo081shirorealm.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: guoyw
 * create: 2019-12-31 09:44
 **/
@Entity
@Table(name = "user")
@Data
public class User {
  
  private int id;
  private String name;
  private String password;
 

}
