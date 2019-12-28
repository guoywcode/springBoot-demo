package com.guoyw.springboot.demo080shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guoyw.springboot.demo080shiro.entity.SysUser;

/**
 * @program: springBoot-demo
 * @description: 用户service
 * @author: guoyw
 * @create: 2019-12-27 22:32
 **/

public interface SysUserService  extends IService<SysUser> {

  //根据用户名查询实体
  SysUser selectUserByName(String username);
}
