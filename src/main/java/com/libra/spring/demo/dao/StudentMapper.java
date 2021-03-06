package com.libra.spring.demo.dao;
 
import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface StudentMapper {
 
    void selVoid(ResultHandler demo);

    Cursor<Student> selCursor();

    @MapKey("id")
    Map<Long,Student> selMap();

    List<Student> selList();

    List<Student> selectByNameAndId(@Param("name")String name, @Param("id")Long id);

}
