package com.libra.spring.demo.dao;

import com.libra.spring.demo.model.entity.Student;import org.apache.ibatis.annotations.MapKey;import org.apache.ibatis.annotations.Param;import org.apache.ibatis.cursor.Cursor;import org.apache.ibatis.session.ResultHandler;import java.util.List;import java.util.Map;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-3:53 下午-2021/11/16
 */
public interface StudentMapper {



    int insertSelective(Student student);

    void selVoid(ResultHandler demo);

    List<Student> selValidCollectionForeignColumn();

    Cursor<Student> selCursor();

    @MapKey("id")
    Map<Long, Student> selMap();

    List<Student> selList();

    List<Student> selectByNameAndId(@Param("name") String name, @Param("id") Long id);

    int updateById(@Param("updated") Student updated);
}