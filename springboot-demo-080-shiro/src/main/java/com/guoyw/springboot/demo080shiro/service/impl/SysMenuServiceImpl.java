package com.guoyw.springboot.demo080shiro.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guoyw.springboot.demo080shiro.entity.SysMenu;
import com.guoyw.springboot.demo080shiro.mapper.SysMenuMapper;
import com.guoyw.springboot.demo080shiro.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 权限业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {


    /**
     * 根据角色查询用户权限
     */
    @Override
    public List<SysMenu> selectSysMenuByRoleId(Long roleId) {
        return this.baseMapper.selectSysMenuByRoleId(roleId);
    }
}