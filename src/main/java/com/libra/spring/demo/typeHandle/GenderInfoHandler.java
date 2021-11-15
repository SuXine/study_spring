package com.libra.spring.demo.typeHandle;

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
public class GenderInfoHandler extends BaseTypeHandler<GenderInfo> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GenderInfo parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getId().toString());
    }

    @Override
    public GenderInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String gender = rs.getString(columnName);
        GenderInfo genderInfo = new GenderInfo();
        genderInfo.setId(gender);
        return genderInfo;
    }

    @Override
    public GenderInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String gender = rs.getString(columnIndex);
        GenderInfo genderInfo = new GenderInfo();
        genderInfo.setId(gender);
        return genderInfo;
    }

    @Override
    public GenderInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String gender = cs.getString(columnIndex);
        GenderInfo genderInfo = new GenderInfo();
        genderInfo.setId(gender);
        return genderInfo;
    }
}
