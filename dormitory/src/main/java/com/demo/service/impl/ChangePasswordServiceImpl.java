package com.demo.service.impl;

import com.demo.bean.Admin;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.AdminMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.ChangePasswordService;
import com.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result adminChangePassword(String adminName, String oldPassword, String newPassword) {
        Admin admin = adminMapper.findAdmin(adminName);
        if (admin == null) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        String realPwd = admin.getAdminPassword();
        if (!oldPassword.equals(realPwd)) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        int id = admin.getId();
        try {
            adminMapper.changePassword(id, newPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CHANGE_PASSWORD_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }

    @Override
    public Result studentChangePassword(String studentNumber, String oldPassword, String newPassword) {
        Student student = studentMapper.findStudent(studentNumber);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        String realPwd = student.getStudentPassword();
        if (!oldPassword.equals(realPwd)) {
            return ResultUtil.getResult(RspEnum.LOGIN_ERROR);
        }
        int id = student.getStudentId();
        try {
            studentMapper.changePassword(id, newPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CHANGE_PASSWORD_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }
}
