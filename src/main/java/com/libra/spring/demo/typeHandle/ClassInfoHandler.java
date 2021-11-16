package com.libra.spring.demo.typeHandle;

import com.libra.spring.demo.model.entity.ClassInfo;
import com.libra.spring.demo.model.entity.GenderInfo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: genderInfo的处理类
 * @author: sx
 * @date: 2021-11:39 上午-2021/11/15
 */
public class ClassInfoHandler extends BaseTypeHandler<ClassInfo> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ClassInfo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getId().toString());
    }

    @Override
    public ClassInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Long id = rs.getLong(columnName);
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(id);
        return classInfo;
    }

    @Override
    public ClassInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Long id = rs.getLong(columnIndex);
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(id);
        return classInfo;
    }

    @Override
    public ClassInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Long id = cs.getLong(columnIndex);
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(id);
        return classInfo;
    }
}
