package com.guoyw.springboot.demo050mybatis.controller;

import com.guoyw.springboot.demo050mybatis.entity.Student;
import com.guoyw.springboot.demo050mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springBoot-demo
 * @description:
 * @author: guoyw
 * @create: 2019-12-25 21:22
 **/
@RestController
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping({"", "/", "index"})
  public String index() {
    return studentService.getList().toString();
  }

  @GetMapping("/add/{name}/{age}")
  public String add(HttpServletRequest request, @PathVariable String name, @PathVariable Integer age) {
    Student model = new Student();
    model.setId("1")
        .setName(name)
        .setAge(age);

    int res = studentService.save(model);
    return String.valueOf(res);
  }
}
