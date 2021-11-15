package com.libra.spring.demo.dao;

import com.libra.spring.demo.model.entity.GenderInfo;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @description: ${desc}
 * @author: sx
 * @date: 2021-5:52 下午-2021/11/15
 */
public interface GenderInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(GenderInfo record);

    int insertSelective(GenderInfo record);

    GenderInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GenderInfo record);

    int updateByPrimaryKey(GenderInfo record);

    List<GenderInfo> selectAllByName(@Param("name") String name);

    List<GenderInfo> selectAll();
}