package com.libra.spring.demo.dao;
 
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.libra.spring.demo.ann.ComponentMy;
import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author:bz
 */
@Mapper
public interface StudentMapper extends DefaultPrettyPrinter.Indenter {
 
    void selVoid(ResultHandler demo);

    List<Student> selValidCollectionForeignColumn();

    Cursor<Student> selCursor();

    @MapKey("id")
    Map<Long,Student> selMap();

    List<Student> selList();

    List<Student> selectByNameAndId(@Param("name")String name, @Param("id")Long id);

    int updateById(@Param("updated")Student updated);

    int insertSelective(Student student);

}
