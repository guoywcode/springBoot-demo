package com.guoyw.springboot.demo080shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springBoot-demo
 * @description: 用户与角色关系实体
 * @author: guoyw
 * @create: 2019-12-27 21:45
 **/
@Data
@TableName("sys_user_role")
@ApiModel("用户与角色关系实体")
public class SysUserRole implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * ID
   */
  @TableId
  private Long id;
  /**
   * 用户ID
   */
  private Long userId;
  /**
   * 角色ID
   */
  private Long roleId;
}
