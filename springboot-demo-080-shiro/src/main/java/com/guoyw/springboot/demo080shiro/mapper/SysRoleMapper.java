package com.guoyw.springboot.demo080shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guoyw.springboot.demo080shiro.entity.SysRole;

import java.util.List;

/**
 * @program: springBoot-demo
 * @description: 角色Mapper
 * @author: guoyw
 * @create: 2019-12-27 22:19
 **/
public interface SysRoleMapper extends BaseMapper<SysRole> {
  //通过用户ID查询角色集合
  List<SysRole> selectSysRoleByUserId(Long userId);
}
