package com.guoyw.springboot.demo080shiro.controller;

import com.guoyw.springboot.demo080shiro.service.SysMenuService;
import com.guoyw.springboot.demo080shiro.service.SysRoleMenuService;
import com.guoyw.springboot.demo080shiro.service.SysRoleService;
import com.guoyw.springboot.demo080shiro.service.SysUserService;
import com.guoyw.springboot.demo080shiro.utils.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-28 11:22
 **/
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class UserRoleController{
  
  @Autowired
  private SysUserService sysUserService;
  @Autowired
  private SysRoleService sysRoleService;
  @Autowired
  private SysMenuService sysMenuService;
  @Autowired
  private SysRoleMenuService sysRoleMenuService;
  
  /**
   * 管理员角色测试接口
   */
  @RequestMapping("/getAdminInfo")
  @RequiresRoles("ADMIN")
  @ApiOperation("获取管理员角色")
  public Map<String,Object> getAdminInfo(){
    Map<String,Object> map = new HashMap<>();
    map.put("code",200);
    map.put("msg","这里是只有管理员角色能访问的接口");
    return map;
  }
  
  /**
   * 用户角色测试接口
   */
  @RequestMapping("/getUserInfo")
  @RequiresRoles("USER")
  @ApiOperation("获取用户角色")
  public Map<String,Object> getUserInfo(){
    Map<String,Object> map = new HashMap<>();
    map.put("code",200);
    map.put("msg","这里是只有用户角色能访问的接口");
    return map;
  }
  
  /**
   * 角色测试接口
   */
  @RequestMapping("/getRoleInfo")
  @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
  @RequiresUser
  @ApiOperation("角色")
  public Map<String,Object> getRoleInfo(){
    Map<String,Object> map = new HashMap<>();
    map.put("code",200);
    map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
    return map;
  }
  
  /**
   * 登出
   */
  @RequestMapping("/getLogout")
  @RequiresUser
  @ApiOperation("登出")
  public Map<String,Object> getLogout(){
    //登出Shiro会帮我们清理掉Session和Cache
    ShiroUtil.logout();
    Map<String,Object> map = new HashMap<>();
    map.put("code",200);
    map.put("msg","登出");
    return map;
  }
  
}
