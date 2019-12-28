package com.guoyw.springboot.demo080shiro.controller;

import com.guoyw.springboot.demo080shiro.entity.SysMenu;
import com.guoyw.springboot.demo080shiro.entity.SysRole;
import com.guoyw.springboot.demo080shiro.entity.SysRoleMenu;
import com.guoyw.springboot.demo080shiro.entity.SysUser;
import com.guoyw.springboot.demo080shiro.service.SysMenuService;
import com.guoyw.springboot.demo080shiro.service.SysRoleMenuService;
import com.guoyw.springboot.demo080shiro.service.SysRoleService;
import com.guoyw.springboot.demo080shiro.service.SysUserService;
import com.guoyw.springboot.demo080shiro.utils.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guoyw
 * create: 2019-12-28 11:18
 **/
@RestController
@RequestMapping("/menu")
@Api(tags = "权限管理接口")
public class UserMenuController{
  
  @Autowired
  private SysUserService sysUserService;
  @Autowired
  private SysRoleService sysRoleService;
  @Autowired
  private SysMenuService sysMenuService;
  @Autowired
  private SysRoleMenuService sysRoleMenuService;
  
  /**
   * 获取用户信息集合
   */
  @RequestMapping("/getUserInfoList")
  @RequiresPermissions("sys:user:info")
  @ApiOperation("获取用户信息")
  public Map<String,Object> getUserInfoList(){
    Map<String,Object> map = new HashMap<>();
    List<SysUser> sysUserEntityList = sysUserService.list();
    map.put("sysUserList",sysUserEntityList);
    return map;
  }
  
  /**
   * 获取角色信息集合
   */
  @RequestMapping("/getRoleInfoList")
  @RequiresPermissions("sys:role:info")
  @ApiOperation("获取角色信息")
  public Map<String,Object> getRoleInfoList(){
    Map<String,Object> map = new HashMap<>();
    List<SysRole> sysRoleEntityList = sysRoleService.list();
    map.put("sysRoleEntityList",sysRoleEntityList);
    return map;
  }
  
  /**
   * 获取权限信息集合
   */
  @RequestMapping("/getMenuInfoList")
  @RequiresPermissions("sys:menu:info")
  @ApiOperation("获取权限信息")
  public Map<String,Object> getMenuInfoList(){
    Map<String,Object> map = new HashMap<>();
    List<SysMenu> sysMenuEntityList = sysMenuService.list();
    map.put("sysMenuEntityList",sysMenuEntityList);
    return map;
  }
  
  /**
   * 获取所有数据
   * @Author Sans
   * @CreateTime 2019/6/19 10:38
   * @Return Map<String,Object>
   */
  @RequestMapping("/getInfoAll")
  @RequiresPermissions("sys:info:all")
  @ApiOperation("获取所有数据")
  public Map<String,Object> getInfoAll(){
    Map<String,Object> map = new HashMap<>();
    List<SysUser> sysUserEntityList = sysUserService.list();
    map.put("sysUserEntityList",sysUserEntityList);
    List<SysRole> sysRoleEntityList = sysRoleService.list();
    map.put("sysRoleEntityList",sysRoleEntityList);
    List<SysMenu> sysMenuEntityList = sysMenuService.list();
    map.put("sysMenuEntityList",sysMenuEntityList);
    return map;
  }
  
  /**
   * 添加管理员角色权限(测试动态权限更新)
   */
  @RequestMapping("/addMenu")
  @ApiOperation("添加管理员角色权限")
  public Map<String,Object> addMenu(){
    //添加管理员角色权限
    SysRoleMenu sysRoleMenuEntity = new SysRoleMenu();
    sysRoleMenuEntity.setMenuId(4L);
    sysRoleMenuEntity.setRoleId(1L);
    sysRoleMenuService.save(sysRoleMenuEntity);
    //清除缓存
    String username = "admin";
    ShiroUtil.deleteCache(username,false);
    Map<String,Object> map = new HashMap<>();
    map.put("code",200);
    map.put("msg","权限添加成功");
    return map;
  }
  
}
