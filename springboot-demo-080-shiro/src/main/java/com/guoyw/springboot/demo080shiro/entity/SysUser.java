package com.guoyw.springboot.demo080shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springBoot-demo
 * @description: 用户实体
 * @author: guoyw
 * @create: 2019-12-27 21:38
 **/
@Data
@TableName("sys_user")
@ApiModel("用户实体")
public class SysUser implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * 用户ID
   */
  @TableId
  private Long userId;
  /**
   * 用户名
   */
  private String username;
  /**
   * 密码
   */
  private String password;
  /**
   * 盐值
   */
  private String salt;
  /**
   * 状态:NORMAL正常  PROHIBIT禁用
   */
  private String state;


}
