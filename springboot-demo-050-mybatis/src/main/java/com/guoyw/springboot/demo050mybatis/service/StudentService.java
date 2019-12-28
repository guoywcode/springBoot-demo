package com.guoyw.springboot.demo050mybatis.service;

import com.guoyw.springboot.demo050mybatis.entity.Student;
import com.guoyw.springboot.demo050mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-25 21:19
 **/
@Service
public class StudentService {


    @Autowired(required = false)
    StudentMapper studentMapper;

    public List<Student> getList(){
        return studentMapper.getList();
    }


    public Integer save(Student student){
        return studentMapper.save(student);
    }
}
