package com.guoyw.springboot.demo031jdbctemplate.controller;

import com.guoyw.springboot.demo031jdbctemplate.entity.Student;
import com.guoyw.springboot.demo031jdbctemplate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: guoyw
 * create: 2019-12-19 16:03
 **/
@RestController
@RequestMapping("/api/student")
public class StudentController{
  
  @Autowired
  private StudentService studentService;
  
  @GetMapping({"", "/", "index"})
  public String index() {
    return studentService.index().toString();
  }
  
  @GetMapping("/add/{name}/{age}")
  public String add(HttpServletRequest request, @PathVariable String name, @PathVariable Integer age) {
    Student model = new Student();
    model.setName(name);
    model.setAge(age);
    
    int res = studentService.save(model);
    return String.valueOf(res);
  }
  
}
