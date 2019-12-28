package com.guoyw.springboot.demo080shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guoyw.springboot.demo080shiro.entity.SysRoleMenu;
import com.guoyw.springboot.demo080shiro.mapper.SysRoleMenuMapper;
import com.guoyw.springboot.demo080shiro.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色与权限业务实现
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

}