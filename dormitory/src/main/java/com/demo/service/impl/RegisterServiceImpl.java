package com.demo.service.impl;

import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.StudentMapper;
import com.demo.service.RegisterService;
import com.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result studentRegister(String studentNumber, String studentPassword) {
        Student student = new Student();
        student.setStudentNumber(studentNumber);
        student.setStudentPassword(studentPassword);
        try {
            studentMapper.createStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.REGISTER_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }
}
