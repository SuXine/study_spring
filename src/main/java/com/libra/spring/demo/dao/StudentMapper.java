package com.libra.spring.demo.dao;

import com.libra.spring.demo.dao.req.StudentReq;
import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.MapKey;import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.cursor.Cursor;import org.apache.ibatis.session.ResultHandler;import java.util.List;import java.util.Map;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-3:53 下午-2021/11/16
 */
public interface StudentMapper {

    List<Student> selValidCollectionForeignColumn();

    List<Student> selectByNameAndId(StudentReq req);

    void selVoid(ResultHandler demo);

    Cursor<Student> selCursor();

    @MapKey("id")
    Map<Long, Student> selMap();

    List<Student> selList();

    int insertSelective(Student student);

    int updateById(@Param("updated") Student updated);
}