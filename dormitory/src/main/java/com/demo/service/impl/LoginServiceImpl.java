package com.demo.service.impl;

import com.demo.bean.Admin;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.AdminMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.LoginService;
import com.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result adminLogin(String adminName, String adminPassword) {
        Admin admin = adminMapper.findAdmin(adminName);
        if (admin == null) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        String realPwd = admin.getAdminPassword();
        if (adminPassword.equals(realPwd)) {
            return ResultUtil.getResult(RspEnum.SUCCESSFUL);
        }
        return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
    }

    @Override
    public Result studentLogin(String studentNumber, String studentPassword) {
        Student student = studentMapper.findStudent(studentNumber);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        String realPwd = student.getStudentPassword();
        if (studentPassword.equals(realPwd)) {
            return ResultUtil.getResult(RspEnum.SUCCESSFUL, student.getStudentId());
        }
        return ResultUtil.getResult(RspEnum.LOGIN_ERROR, student.getStudentId());
    }
}
