package com.libra.spring.demo.dao;
 
import com.libra.spring.demo.model.entity.Student;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface StudentMapper {
 
    Student sel(Long id);

    Student sql(@RequestParam("name") Long id);

    List<Student> selectByNameAndId(@Param("name")String name, @Param("id")Long id);

}
