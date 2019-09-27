package com.demo.dao;

import com.demo.bean.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    Admin findAdmin(@Param("adminName") String adminName);

    void changePassword(@Param("adminId") Integer adminId, @Param("password") String password);
}
