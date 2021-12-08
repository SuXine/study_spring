package com.libra.spring.demo.service;

import com.libra.spring.demo.dao.DemoResultHandler;
import com.libra.spring.demo.dao.StudentMapper;
import com.libra.spring.demo.dao.req.StudentReq;
import com.libra.spring.demo.model.bo.PageInfo;
import com.libra.spring.demo.model.entity.Student;
import com.libra.spring.demo.thread.PageHelper;

import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        PageHelper.start(1,2);
        students = studentMapper.selectByNameAndId(req);

        //        List<Student> students = studentMapper.selValidCollectionForeignColumn();
        System.out.println("使用前");
        students.forEach(item -> {
            System.out.println(item.toString());
        });
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
