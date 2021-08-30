package com.libra.spring.demo.service;

import com.libra.spring.demo.dao.DemoResultHandler;
import com.libra.spring.demo.dao.StudentMapper;
import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    @Transactional
    public List<Student> select(Long id) {
//        studentMapper.selList();
//        studentMapper.selMap();
//        studentMapper.selVoid(new DemoResultHandler());
        studentMapper.selCursor();
        return new ArrayList<>();
    }

    public List<Student> update(Long id) {
        //        studentMapper.selList();
        //        studentMapper.selMap();
        //        studentMapper.selVoid(new DemoResultHandler());
        studentMapper.selCursor();
        return new ArrayList<>();
    }

}
