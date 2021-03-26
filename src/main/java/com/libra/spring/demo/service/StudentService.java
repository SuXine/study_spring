package com.libra.spring.demo.service;

import com.libra.spring.demo.ann.ComponentMy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author sx
 * @date 2021-02-26
 */
@ComponentMy
@Lazy
public class StudentService {

    public StudentService() {
        System.out.println("懒加载~");
    }

    public void demo() {
        System.out.println("StudentService DEMO");
    }

}
