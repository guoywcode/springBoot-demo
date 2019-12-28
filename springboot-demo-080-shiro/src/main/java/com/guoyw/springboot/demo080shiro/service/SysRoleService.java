package com.guoyw.springboot.demo080shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guoyw.springboot.demo080shiro.entity.SysRole;

import java.util.List;

/**
 * @Description 角色业务接口
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过用户ID查询角色集合
     */
    List<SysRole> selectSysRoleByUserId(Long userId);
}

