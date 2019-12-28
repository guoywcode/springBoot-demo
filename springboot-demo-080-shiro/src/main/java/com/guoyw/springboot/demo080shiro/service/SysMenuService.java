package com.guoyw.springboot.demo080shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guoyw.springboot.demo080shiro.entity.SysMenu;


import java.util.List;

/**
 * @Description 权限业务接口
 */
public interface SysMenuService extends IService<SysMenu> {
    
    
    /**
     * 根据角色查询用户权限
     */
    List<SysMenu> selectSysMenuByRoleId(Long roleId);

}

