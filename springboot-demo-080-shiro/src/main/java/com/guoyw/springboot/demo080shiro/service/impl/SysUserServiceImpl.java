package com.guoyw.springboot.demo080shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guoyw.springboot.demo080shiro.entity.SysUser;
import com.guoyw.springboot.demo080shiro.mapper.SysUserMapper;
import com.guoyw.springboot.demo080shiro.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Description 系统用户业务实现
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 根据用户名查询实体
     */
    @Override
    public SysUser selectUserByName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }
}