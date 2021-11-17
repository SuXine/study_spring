package com.libra.spring.demo.dao;
import org.apache.ibatis.annotations.Param;

import com.libra.spring.demo.model.entity.ClassInfo;

/**
 * @description: ${desc}
 * 
 * @author: sx
 * @date: 2021-3:54 下午-2021/11/16
 */
public interface ClassInfoMapper {
    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectById(@Param("id")Long id);


}