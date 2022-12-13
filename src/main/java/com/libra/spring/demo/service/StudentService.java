package com.libra.spring.demo.service;

import com.libra.spring.demo.dao.StudentMapper;
import com.libra.spring.demo.dao.req.StudentReq;
import com.libra.spring.demo.model.entity.Student;
import com.libra.spring.demo.thread.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public void select() {
        List<Student> students;

        StudentReq req = new StudentReq();
        req.setName("新");

        //        studentMapper.selMap();
        //        studentMapper.selVoid(new DemoResultHandler());
        //        studentMapper.selCursor();
        //        students = studentMapper.selList();

        PageHelper.start(1, 2);
        students = studentMapper.selectByNameAndId(req);

        //        students = studentMapper.selValidCollectionForeignColumn();
        students.stream().forEach(System.out::println);

    }

    public void update() {
        Student update = new Student();
        update.setId(1L);
        update.setName("小绿" + Math.random());
        studentMapper.updateById(update);
    }

    public void insert() {
        Student insert = new Student();
        insert.setName("小新" + Math.random());
        studentMapper.insertSelective(insert);
    }

}
