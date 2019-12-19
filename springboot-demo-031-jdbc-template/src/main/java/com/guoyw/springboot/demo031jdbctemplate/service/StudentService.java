package com.guoyw.springboot.demo031jdbctemplate.service;

import com.guoyw.springboot.demo031jdbctemplate.dao.StudentDao;
import com.guoyw.springboot.demo031jdbctemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-19 16:05
 **/
@Service
public class StudentService{
  @Autowired
  private StudentDao studentDao;
  
  public List<Student> index() {
    return studentDao.list();
  }
  
  public Integer save(Student student) {
    return studentDao.save(student);
  }
}
