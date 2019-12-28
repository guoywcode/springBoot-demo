package com.guoyw.springboot.demo080shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springBoot-demo
 * @description: 角色实体
 * @author: guoyw
 * @create: 2019-12-27 21:42
 **/
@Data
@TableName("sys_role")
@ApiModel("角色实体")
public class SysRole implements Serializable {
  private static final long serialVersionUID = 1L;
   /**
   * 角色ID
   */
  @TableId
  private Long roleId;
  /**
   * 角色名称
   */
  private String roleName;
}
