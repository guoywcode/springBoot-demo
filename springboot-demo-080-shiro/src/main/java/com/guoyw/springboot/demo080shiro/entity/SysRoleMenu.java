package com.guoyw.springboot.demo080shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springBoot-demo
 * @description: 角色与权限关系实体
 * @author: guoyw
 * @create: 2019-12-27 21:44
 **/
@Data
@TableName("sys_role_menu")
@ApiModel("角色与权限关系实体")
public class SysRoleMenu implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * ID
   */
  @TableId
  private Long id;
  /**
   * 角色ID
   */
  private Long roleId;
  /**
   * 权限ID
   */
  private Long menuId;
}
