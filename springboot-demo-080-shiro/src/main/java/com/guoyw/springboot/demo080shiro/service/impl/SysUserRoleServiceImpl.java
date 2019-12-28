package com.guoyw.springboot.demo080shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guoyw.springboot.demo080shiro.entity.SysUserRole;
import com.guoyw.springboot.demo080shiro.mapper.SysUserRoleMapper;
import com.guoyw.springboot.demo080shiro.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}