package com.libra.spring.demo.controller;

import com.libra.spring.demo.service.StudentService;
import com.libra.spring.demo.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

/**
 * Description: demo
 *
 * @author sx
 * @date 2021-03-16
 */
@Controller
@Lazy
public class DemoController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @GetMapping("/demo")
    public String demo(){
        teacherService.demo();
        studentService.demo();
        return "hello word";
    }
}
