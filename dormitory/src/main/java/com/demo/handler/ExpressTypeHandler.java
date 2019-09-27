package com.demo.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpressTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if ("发件".equals(parameter)) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 2);
        }
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        Integer type = rs.getInt(columnName);
        return type == 1 ? "发件" : "收件";
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer type = rs.getInt(columnIndex);
        return type == 1 ? "发件" : "收件";
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer type = cs.getInt(columnIndex);
        return type == 1 ? "发件" : "收件";
    }
}
