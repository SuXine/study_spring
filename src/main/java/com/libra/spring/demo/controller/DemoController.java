package com.libra.spring.demo.controller;

import com.libra.spring.demo.service.StudentService;
import com.libra.spring.demo.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: demo
 *
 * @author sx
 * @date 2021-03-16
 */
@RestController
@Lazy
public class DemoController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @GetMapping("/select")
    public String select(){
        studentService.select();
        return "hello word  - select()";
    }

    @GetMapping("/update")
    public String update(){
        studentService.update();
        return "hello word - update()";
    }

    @GetMapping("/insert")
    public String insert(){
        studentService.insert();
        return "hello word - insert()";
    }

    @GetMapping("/demo")
    public String insert(@RequestParam List<Long> ids){
        studentService.insert();
        return "hello word - insert()";
    }

}
