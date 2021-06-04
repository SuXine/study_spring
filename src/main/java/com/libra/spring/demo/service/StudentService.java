package com.libra.spring.demo.service;

import com.libra.spring.demo.dao.StudentMapper;
import com.libra.spring.demo.model.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author sx
 * @date 2021-02-26
 */
@Component
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void demo() {
        System.out.println("StudentService DEMO");
    }

    public List<Student> sel(Long id) {
        return studentMapper.selectByNameAndId(null, id);
    }

}
