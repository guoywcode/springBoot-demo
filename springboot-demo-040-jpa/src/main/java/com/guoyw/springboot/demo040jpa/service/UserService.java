package com.guoyw.springboot.demo040jpa.service;


import com.guoyw.springboot.demo040jpa.entity.User;
import com.guoyw.springboot.demo040jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: guoyw
 * create: 2019-12-18 11:19
 **/
@Service
public class UserService{
  
  @Autowired
  private UserRepository userRepository;
  
  public User getByUuid(String uuid){
    return userRepository.findOneByUuid(uuid);
  }
  
  public User create(User user){
    if(StringUtils.isEmpty(user.getUuid())){
      user.setUuid(UUID.randomUUID().toString().replace("-",""));
    }
    if(StringUtils.isEmpty(user.getCreatedAt())){
      user.setCreatedAt(new Date().getTime());
    }
    if(StringUtils.isEmpty(user.getUpdatedAt())){
      user.setUpdatedAt(new Date().getTime());
    }
    
    return userRepository.save(user);
  }
  
  public User update(User user){
    user.setUpdatedAt(new Date().getTime());
    return userRepository.save(user);
  }
  
  public List<User> getAll(){
    return userRepository.findAll();
  }
  
  // 根据身份证查询用户信息
  public User getByIdName(String idName){
    return userRepository.findByIdName(idName);
  }
  
  // 根据身份证查询用户信息
  public User getByIp(String ipAddress){
    return userRepository.findByIpAddressLike("%" + ipAddress + "%");
  }
  
  
}
