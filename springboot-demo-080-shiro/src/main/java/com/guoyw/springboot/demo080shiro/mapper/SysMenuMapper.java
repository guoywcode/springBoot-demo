package com.guoyw.springboot.demo080shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guoyw.springboot.demo080shiro.entity.SysMenu;

import java.util.List;

/**
 * @program: springBoot-demo
 * @description: 权限Mapper
 * @author: guoyw
 * @create: 2019-12-27 22:19
 **/

public interface SysMenuMapper extends BaseMapper<SysMenu> {

  //根据角色查询用户权限
  List<SysMenu> selectSysMenuByRoleId(Long roleId);

}
