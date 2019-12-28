package com.guoyw.springboot.demo080shiro.controller;

import com.guoyw.springboot.demo080shiro.utils.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-28 11:16
 **/
@RestController
@RequestMapping("/userLogin")
@Api(tags = "登陆管理")
public class UserLoginController{
  
  // 登录
  @GetMapping("/login")
  @ApiOperation("登陆")
  public Map<String,Object> login(String username,String password){
    Map<String,Object> map = new HashMap<>();
    //进行身份验证
    try{
      //验证身份和登陆
      Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      //验证成功进行登录操作
      subject.login(token);
    }catch (IncorrectCredentialsException e) {
      map.put("code",500);
      map.put("msg","用户不存在或者密码错误");
      return map;
    } catch (LockedAccountException e) {
      map.put("code",500);
      map.put("msg","登录失败，该用户已被冻结");
      return map;
    } catch (AuthenticationException e) {
      map.put("code",500);
      map.put("msg","该用户不存在");
      return map;
    } catch (Exception e) {
      map.put("code",500);
      map.put("msg","未知异常");
      return map;
    }
    map.put("code",0);
    map.put("msg","登录成功");
    map.put("token", ShiroUtil.getSession().getId().toString());
    return map;
  }
  /**
   * 未登录
   */
  @RequestMapping("/unauth")
  @ApiOperation("未登录")
  public Map<String,Object> unauth(){
    Map<String,Object> map = new HashMap<>();
    map.put("code",500);
    map.put("msg","未登录");
    return map;
  }
  
}
