package com.guoyw.springboot.demo080shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: springBoot-demo
 * @description: 权限实体
 * @author: guoyw
 * @create: 2019-12-27 21:39
 **/
@Data
@TableName("sys_menu")
@ApiModel("权限实体")
public class SysMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 权限ID
   */
  @TableId
  private Long menuId;
  /**
   * 权限名称
   */
  private String name;
  /**
   * 权限标识
   */
  private String perms;

}
