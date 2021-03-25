package com.libra.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author sx
 * @date 2021-02-26
 */
@Component
public class StudentService {
    @Autowired
    private TeacherService teacherService;

//    public StudentService() {
//        System.out.println("懒加载~");
//    }
//
//    public void demo() {
//        System.out.println("StudentService DEMO");
//    }
//
//    public void teacherDemo() {
//        System.out.println("------- teacherDemo: ------- ");
//        teacherService.demo();
//    }
}
