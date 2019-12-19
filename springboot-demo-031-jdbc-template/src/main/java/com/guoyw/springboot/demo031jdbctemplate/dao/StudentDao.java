package com.guoyw.springboot.demo031jdbctemplate.dao;

import com.guoyw.springboot.demo031jdbctemplate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: guoyw
 * create: 2019-12-19 16:06
 **/
@Repository
public class StudentDao{
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public List<Student> list() {
    List<Student> list = jdbcTemplate.query("select * from student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
    if (list != null && list.size() > 0) {
      return list;
    } else {
      return null;
    }
  }
  
  public int save(Student student) {
    return jdbcTemplate.update("insert into student(id, name, age) values(?, ?, ?)", student.getId(), student.getName(), student.getAge());
  }
}
