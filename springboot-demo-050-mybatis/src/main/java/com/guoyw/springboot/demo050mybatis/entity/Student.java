package com.guoyw.springboot.demo050mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-25 21:13
 **/
@Data
@Accessors(chain = true)
public class Student {

    private String id;
    private String name;
    private Integer age;
}
