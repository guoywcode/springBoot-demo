package com.guoyw.springboot.demo050mybatis.mapper;

import com.guoyw.springboot.demo050mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-25 21:15
 **/
@Mapper
public interface StudentMapper {

    @Select("select * from studet")
    List<Student> getList();

    int save(@Param("student") Student student);
}
