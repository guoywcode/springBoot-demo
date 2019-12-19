package com.guoyw.springboot.demo040jpa.repository;

import com.guoyw.springboot.demo040jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: guoyw
 * create: 2019-12-18 11:51
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long>, CrudRepository<User,Long>{
  
  User findOneByUuid(String uuid);
  
  // 根据 真实姓名查询用户信息
  User findByIdName(String idName);
  
  // 根据身份证查询用户信息
  User findByIpAddressLike(String ipAddress);
}
