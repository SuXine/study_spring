package com.libra.spring.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description: 教师类
 *
 * @author sx
 * @date 2021-02-26
 */
@Component
public class TeacherService {
    @Autowired
    private StudentService studentService;

//    public void demo() {
//        System.out.println("TeacherService DEMO");
//    }
}
