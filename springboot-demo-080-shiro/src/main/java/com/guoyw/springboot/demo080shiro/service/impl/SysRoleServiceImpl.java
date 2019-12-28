package com.guoyw.springboot.demo080shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guoyw.springboot.demo080shiro.entity.SysRole;
import com.guoyw.springboot.demo080shiro.mapper.SysRoleMapper;
import com.guoyw.springboot.demo080shiro.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 角色业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }
}