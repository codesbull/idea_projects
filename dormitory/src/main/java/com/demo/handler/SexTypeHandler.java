package com.demo.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if ("男".equals(parameter)) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 2);
        }
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        Integer sex = rs.getInt(columnName);
        return sex == 1 ? "男" : "女";
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer sex = rs.getInt(columnIndex);
        return sex == 1 ? "男" : "女";
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer sex = cs.getInt(columnIndex);
        return sex == 1 ? "男" : "女";
    }
}
