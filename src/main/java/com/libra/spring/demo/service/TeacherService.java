package com.libra.spring.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Description: 教师类
 *
 * @author sx
 * @date 2021-02-26
 */
@Component
public class TeacherService {

    public void demo() {
        System.out.println("TeacherService DEMO");
    }
}
