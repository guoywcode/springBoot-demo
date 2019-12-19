package com.guoyw.springboot.demo040jpa.controller;

import com.guoyw.springboot.demo040jpa.entity.User;
import com.guoyw.springboot.demo040jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-19 17:11
 **/
@RestController
@RequestMapping("/api/user")
public class UserController{
  
  @Autowired
  private UserService userService;
  
  @RequestMapping(path = "/getUserInfo/{uuid}", method = RequestMethod.GET)
  public User getUserInfo(@PathVariable("uuid") String uuid ){
    return userService.getByUuid(uuid);
  }
  
  @RequestMapping(path = "/addUser",method = RequestMethod.POST)
  public void addUser(@RequestBody Map<String,String> idNameMap){
    User user = new User();
    user.setIdName(idNameMap.get("idName"));
    userService.create(user);
  }
}
