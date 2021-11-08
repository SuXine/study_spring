package com.libra.spring.demo.service;

import com.libra.spring.demo.dao.DemoResultHandler;
import com.libra.spring.demo.dao.StudentMapper;
import com.libra.spring.demo.model.entity.Student;

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
//        studentMapper.selList();
//        studentMapper.selMap();
//        studentMapper.selVoid(new DemoResultHandler());
//        studentMapper.selCursor();
        studentMapper.selectByNameAndId("小绿238718973918", 2L);
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
